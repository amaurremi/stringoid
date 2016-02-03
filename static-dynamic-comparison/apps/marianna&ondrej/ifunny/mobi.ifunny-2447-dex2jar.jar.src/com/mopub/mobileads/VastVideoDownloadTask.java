package com.mopub.mobileads;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.HttpClient;
import com.mopub.common.logging.MoPubLog;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public class VastVideoDownloadTask
        extends AsyncTask<String, Void, Boolean> {
    private static final int MAX_VIDEO_SIZE = 26214400;
    private final VastVideoDownloadTask.VastVideoDownloadTaskListener mVastVideoDownloadTaskListener;

    public VastVideoDownloadTask(VastVideoDownloadTask.VastVideoDownloadTaskListener paramVastVideoDownloadTaskListener) {
        this.mVastVideoDownloadTaskListener = paramVastVideoDownloadTaskListener;
    }

    protected Boolean doInBackground(String... paramVarArgs) {
        Object localObject1;
        if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
            localObject1 = Boolean.valueOf(false);
        }
        Boolean localBoolean;
        do {
            String str;
            for (; ; ) {
                return (Boolean) localObject1;
                str = paramVarArgs[0];
                localObject1 = null;
                paramVarArgs = null;
                try {
                    AndroidHttpClient localAndroidHttpClient = HttpClient.getHttpClient();
                    paramVarArgs = localAndroidHttpClient;
                    localObject1 = localAndroidHttpClient;
                    localObject2 = localAndroidHttpClient.execute(new HttpGet(str));
                    if (localObject2 != null) {
                        paramVarArgs = localAndroidHttpClient;
                        localObject1 = localAndroidHttpClient;
                        if (((HttpResponse) localObject2).getEntity() != null) {
                        }
                    } else {
                        paramVarArgs = localAndroidHttpClient;
                        localObject1 = localAndroidHttpClient;
                        throw new IOException("Obtained null response from video url: " + str);
                    }
                } catch (Exception localException) {
                    localObject1 = paramVarArgs;
                    MoPubLog.d("Failed to download video: " + localException.getMessage());
                    localBoolean = Boolean.valueOf(false);
                    localObject1 = localBoolean;
                    if (paramVarArgs != null) {
                        paramVarArgs.close();
                        return localBoolean;
                        paramVarArgs = localBoolean;
                        localObject1 = localBoolean;
                        if (((HttpResponse) localObject2).getEntity().getContentLength() > 26214400L) {
                            paramVarArgs = localBoolean;
                            localObject1 = localBoolean;
                            throw new IOException("Video exceeded max download size");
                        }
                    }
                } finally {
                    if (localObject1 != null) {
                        ((AndroidHttpClient) localObject1).close();
                    }
                }
            }
            paramVarArgs = localBoolean;
            localObject1 = localBoolean;
            Object localObject2 = new BufferedInputStream(((HttpResponse) localObject2).getEntity().getContent());
            paramVarArgs = localBoolean;
            localObject1 = localBoolean;
            boolean bool = CacheService.putToDiskCache(str, (InputStream) localObject2);
            paramVarArgs = localBoolean;
            localObject1 = localBoolean;
            ((InputStream) localObject2).close();
            paramVarArgs = Boolean.valueOf(bool);
            localObject1 = paramVarArgs;
        } while (localBoolean == null);
        localBoolean.close();
        return paramVarArgs;
    }

    protected void onCancelled() {
        onPostExecute(Boolean.valueOf(false));
    }

    protected void onPostExecute(Boolean paramBoolean) {
        if (this.mVastVideoDownloadTaskListener != null) {
            this.mVastVideoDownloadTaskListener.onComplete(paramBoolean.booleanValue());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoDownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */