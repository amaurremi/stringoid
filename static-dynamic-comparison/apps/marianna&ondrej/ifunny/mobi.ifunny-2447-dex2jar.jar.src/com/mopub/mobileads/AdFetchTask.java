package com.mopub.mobileads;

import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.HttpResponses;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;

public class AdFetchTask
        extends AsyncTask<String, Void, AdLoadTask> {
    private static final double EXPONENTIAL_BACKOFF_FACTOR = 1.5D;
    private static final int MAXIMUM_REFRESH_TIME_MILLISECONDS = 600000;
    private AdViewController mAdViewController;
    private Exception mException;
    private AdFetcher.FetchStatus mFetchStatus = AdFetcher.FetchStatus.NOT_SET;
    private HttpClient mHttpClient;
    private long mTaskId;
    private TaskTracker mTaskTracker;
    private String mUserAgent;

    public AdFetchTask(TaskTracker paramTaskTracker, AdViewController paramAdViewController, String paramString, int paramInt) {
        this.mTaskTracker = paramTaskTracker;
        this.mAdViewController = paramAdViewController;
        this.mHttpClient = HttpClientFactory.create(paramInt);
        this.mTaskId = this.mTaskTracker.getCurrentTaskId();
        this.mUserAgent = paramString;
    }

    private void cleanup() {
        this.mTaskTracker = null;
        this.mException = null;
        this.mFetchStatus = AdFetcher.FetchStatus.NOT_SET;
    }

    private void exponentialBackoff() {
        int i = 600000;
        if (this.mAdViewController == null) {
            return;
        }
        int j = (int) (this.mAdViewController.getRefreshTimeMilliseconds() * 1.5D);
        if (j > 600000) {
        }
        for (; ; ) {
            this.mAdViewController.setRefreshTimeMilliseconds(i);
            return;
            i = j;
        }
    }

    private AdLoadTask fetch(String paramString) {
        paramString = new HttpGet(paramString);
        paramString.addHeader(ResponseHeader.USER_AGENT.getKey(), this.mUserAgent);
        if (!isStateValid()) {
        }
        do {
            do {
                return null;
                paramString = this.mHttpClient.execute(paramString);
            } while (!isResponseValid(paramString));
            this.mAdViewController.configureUsingHttpResponse(paramString);
        } while (!responseContainsContent(paramString));
        return AdLoadTask.fromHttpResponse(paramString, this.mAdViewController);
    }

    private boolean isMostCurrentTask() {
        if (this.mTaskTracker == null) {
            return false;
        }
        return this.mTaskTracker.isMostCurrentTask(this.mTaskId);
    }

    private boolean isResponseValid(HttpResponse paramHttpResponse) {
        if ((paramHttpResponse == null) || (paramHttpResponse.getEntity() == null)) {
            MoPubLog.d("MoPub server returned null response.");
            this.mFetchStatus = AdFetcher.FetchStatus.INVALID_SERVER_RESPONSE_NOBACKOFF;
            return false;
        }
        int i = paramHttpResponse.getStatusLine().getStatusCode();
        if (i >= 400) {
            MoPubLog.d("Server error: returned HTTP status code " + Integer.toString(i) + ". Please try again.");
            this.mFetchStatus = AdFetcher.FetchStatus.INVALID_SERVER_RESPONSE_BACKOFF;
            return false;
        }
        if (i != 200) {
            MoPubLog.d("MoPub server returned invalid response: HTTP status code " + Integer.toString(i) + ".");
            this.mFetchStatus = AdFetcher.FetchStatus.INVALID_SERVER_RESPONSE_NOBACKOFF;
            return false;
        }
        return true;
    }

    private boolean isStateValid() {
        if (isCancelled()) {
            this.mFetchStatus = AdFetcher.FetchStatus.FETCH_CANCELLED;
            return false;
        }
        if ((this.mAdViewController == null) || (this.mAdViewController.isDestroyed())) {
            MoPubLog.d("Error loading ad: AdViewController has already been GCed or destroyed.");
            return false;
        }
        return true;
    }

    private boolean responseContainsContent(HttpResponse paramHttpResponse) {
        if ("1".equals(HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.WARMUP))) {
            MoPubLog.d("Ad Unit (" + this.mAdViewController.getAdUnitId() + ") is still warming up. " + "Please try again in a few minutes.");
            this.mFetchStatus = AdFetcher.FetchStatus.AD_WARMING_UP;
            return false;
        }
        if ("clear".equals(HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.AD_TYPE))) {
            MoPubLog.d("No ads found for adunit (" + this.mAdViewController.getAdUnitId() + ").");
            this.mFetchStatus = AdFetcher.FetchStatus.CLEAR_AD_TYPE;
            return false;
        }
        return true;
    }

    private void shutdownHttpClient() {
        if (this.mHttpClient != null) {
            ClientConnectionManager localClientConnectionManager = this.mHttpClient.getConnectionManager();
            if (localClientConnectionManager != null) {
                localClientConnectionManager.shutdown();
            }
            this.mHttpClient = null;
        }
    }

    protected AdLoadTask doInBackground(String... paramVarArgs) {
        try {
            paramVarArgs = fetch(paramVarArgs[0]);
            return paramVarArgs;
        } catch (Exception paramVarArgs) {
            this.mException = paramVarArgs;
            return null;
        } finally {
            shutdownHttpClient();
        }
    }

    protected void onCancelled() {
        if (!isMostCurrentTask()) {
            MoPubLog.d("Ad response is stale.");
            cleanup();
            return;
        }
        MoPubLog.d("Ad loading was cancelled.");
        if (this.mException != null) {
            MoPubLog.d("Exception caught while loading ad: " + this.mException);
        }
        this.mTaskTracker.markTaskCompleted(this.mTaskId);
        cleanup();
    }

    protected void onPostExecute(AdLoadTask paramAdLoadTask) {
        if (!isMostCurrentTask()) {
            MoPubLog.d("Ad response is stale.");
            cleanup();
            return;
        }
        if ((this.mAdViewController == null) || (this.mAdViewController.isDestroyed())) {
            if (paramAdLoadTask != null) {
                paramAdLoadTask.cleanup();
            }
            this.mTaskTracker.markTaskCompleted(this.mTaskId);
            cleanup();
            return;
        }
        if (paramAdLoadTask == null) {
            if (this.mException != null) {
                MoPubLog.d("Exception caught while loading ad: " + this.mException);
            }
            switch (AdFetchTask .1.$SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[this.mFetchStatus.ordinal()])
            {
                default:
                    paramAdLoadTask = MoPubErrorCode.UNSPECIFIED;
                    this.mAdViewController.adDidFail(paramAdLoadTask);
                    if (this.mFetchStatus == AdFetcher.FetchStatus.INVALID_SERVER_RESPONSE_BACKOFF) {
                        exponentialBackoff();
                        this.mFetchStatus = AdFetcher.FetchStatus.NOT_SET;
                    }
                    break;
            }
        }
        for (; ; ) {
            this.mTaskTracker.markTaskCompleted(this.mTaskId);
            cleanup();
            return;
            paramAdLoadTask = MoPubErrorCode.UNSPECIFIED;
            break;
            paramAdLoadTask = MoPubErrorCode.CANCELLED;
            break;
            paramAdLoadTask = MoPubErrorCode.SERVER_ERROR;
            break;
            paramAdLoadTask = MoPubErrorCode.NO_FILL;
            break;
            paramAdLoadTask.execute();
            paramAdLoadTask.cleanup();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdFetchTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */