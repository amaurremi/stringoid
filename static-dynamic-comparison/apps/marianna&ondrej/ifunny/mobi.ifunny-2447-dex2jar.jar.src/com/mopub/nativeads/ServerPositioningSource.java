package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.DownloadTask;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.HttpClient;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ServerPositioningSource
        implements PositioningSource {
    private static final double DEFAULT_RETRY_TIME_MILLISECONDS = 1000.0D;
    private static final double EXPONENTIAL_BACKOFF_FACTOR = 2.0D;
    private static final String FIXED_KEY = "fixed";
    private static final String INTERVAL_KEY = "interval";
    @VisibleForTesting
    static int MAXIMUM_RETRY_TIME_MILLISECONDS = 300000;
    private static final int MAX_VALUE = 65536;
    private static final String POSITION_KEY = "position";
    private static final String REPEATING_KEY = "repeating";
    private static final String SECTION_KEY = "section";
    private final Context mContext;
    private DownloadTask mDownloadTask;
    private final ServerPositioningSource.DownloadTaskProvider mDownloadTaskProvider;
    private PositioningSource.PositioningListener mListener;
    private int mRetryCount;
    private final Handler mRetryHandler;
    private final Runnable mRetryRunnable;
    private String mRetryUrl;
    private DownloadTask.DownloadTaskListener mTaskListener = new ServerPositioningSource
    .2(this);

    ServerPositioningSource(Context paramContext) {
        this(paramContext, new ServerPositioningSource.DownloadTaskProvider());
    }

    @VisibleForTesting
    ServerPositioningSource(Context paramContext, ServerPositioningSource.DownloadTaskProvider paramDownloadTaskProvider) {
        this.mContext = paramContext.getApplicationContext();
        this.mDownloadTaskProvider = paramDownloadTaskProvider;
        this.mRetryHandler = new Handler();
        this.mRetryRunnable = new ServerPositioningSource .1 (this);
    }

    private void handleFailure() {
        int i = (int) (Math.pow(2.0D, this.mRetryCount + 1) * 1000.0D);
        if (i >= MAXIMUM_RETRY_TIME_MILLISECONDS) {
            MoPubLog.d("Error downloading positioning information");
            this.mListener.onFailed();
            this.mListener = null;
            return;
        }
        this.mRetryCount += 1;
        this.mRetryHandler.postDelayed(this.mRetryRunnable, i);
    }

    private void handleSuccess(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        this.mListener.onLoad(paramMoPubClientPositioning);
        this.mListener = null;
        this.mRetryCount = 0;
    }

    private void parseFixedJson(JSONArray paramJSONArray, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        int i = 0;
        if (i < paramJSONArray.length()) {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            int j = localJSONObject.optInt("section", 0);
            if (j < 0) {
                throw new JSONException("Invalid section " + j + " in JSON response");
            }
            if (j > 0) {
            }
            for (; ; ) {
                i += 1;
                break;
                j = localJSONObject.getInt("position");
                if ((j < 0) || (j > 65536)) {
                    throw new JSONException("Invalid position " + j + " in JSON response");
                }
                paramMoPubClientPositioning.addFixedPosition(j);
            }
        }
    }

    private void parseRepeatingJson(JSONObject paramJSONObject, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        int i = paramJSONObject.getInt("interval");
        if ((i < 2) || (i > 65536)) {
            throw new JSONException("Invalid interval " + i + " in JSON response");
        }
        paramMoPubClientPositioning.enableRepeatingPositions(i);
    }

    private void requestPositioningInternal() {
        MoPubLog.d("Loading positioning from: " + this.mRetryUrl);
        this.mDownloadTask = this.mDownloadTaskProvider.get(this.mTaskListener);
        HttpGet localHttpGet = HttpClient.initializeHttpGet(this.mRetryUrl, this.mContext);
        AsyncTasks.safeExecuteOnExecutor(this.mDownloadTask, new HttpUriRequest[]{localHttpGet});
    }

    public void loadPositions(String paramString, PositioningSource.PositioningListener paramPositioningListener) {
        if (this.mDownloadTask != null) {
            this.mDownloadTask.cancel(true);
            this.mDownloadTask = null;
        }
        if (this.mRetryCount > 0) {
            this.mRetryHandler.removeCallbacks(this.mRetryRunnable);
            this.mRetryCount = 0;
        }
        this.mListener = paramPositioningListener;
        this.mRetryUrl = new PositioningUrlGenerator(this.mContext).withAdUnitId(paramString).generateUrlString("ads.mopub.com");
        requestPositioningInternal();
    }

    @VisibleForTesting
    MoPubNativeAdPositioning.MoPubClientPositioning parseJsonResponse(String paramString) {
        if ((paramString == null) || (paramString.equals(""))) {
            throw new JSONException("Empty response");
        }
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("error", null);
        if (paramString != null) {
            throw new JSONException(paramString);
        }
        paramString = localJSONObject.optJSONArray("fixed");
        localJSONObject = localJSONObject.optJSONObject("repeating");
        MoPubNativeAdPositioning.MoPubClientPositioning localMoPubClientPositioning = new MoPubNativeAdPositioning.MoPubClientPositioning();
        if ((paramString == null) && (localJSONObject == null)) {
            throw new JSONException("Must contain fixed or repeating positions");
        }
        if (paramString != null) {
            parseFixedJson(paramString, localMoPubClientPositioning);
        }
        if (localJSONObject != null) {
            parseRepeatingJson(localJSONObject, localMoPubClientPositioning);
        }
        return localMoPubClientPositioning;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ServerPositioningSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */