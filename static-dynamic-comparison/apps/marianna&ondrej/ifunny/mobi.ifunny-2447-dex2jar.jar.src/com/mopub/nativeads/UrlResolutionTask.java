package com.mopub.nativeads;

import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.IntentUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class UrlResolutionTask
        extends AsyncTask<String, Void, String> {
    private static final int REDIRECT_LIMIT = 10;
    private final UrlResolutionTask.UrlResolutionListener mListener;

    UrlResolutionTask(UrlResolutionTask.UrlResolutionListener paramUrlResolutionListener) {
        this.mListener = paramUrlResolutionListener;
    }

    private String getRedirectLocation(String paramString) {
        Object localObject1 = null;
        paramString = new URL(paramString);
        try {
            paramString = (HttpURLConnection) paramString.openConnection();
            int i;
            if (paramString == null) {
                break label85;
            }
        } finally {
            try {
                paramString.setInstanceFollowRedirects(false);
                i = paramString.getResponseCode();
                if ((i >= 300) && (i < 400)) {
                    localObject1 = paramString.getHeaderField("Location");
                    if (paramString != null) {
                        paramString.disconnect();
                    }
                    return (String) localObject1;
                }
                if (paramString != null) {
                    paramString.disconnect();
                }
                return null;
            } finally {
                for (; ; ) {
                }
            }
            localObject3 =finally;
            paramString = (String) localObject1;
            localObject1 = localObject3;
        }
        paramString.disconnect();
        label85:
        throw ((Throwable) localObject1);
    }

    public static void getResolvedUrl(String paramString, UrlResolutionTask.UrlResolutionListener paramUrlResolutionListener) {
        UrlResolutionTask localUrlResolutionTask = new UrlResolutionTask(paramUrlResolutionListener);
        try {
            AsyncTasks.safeExecuteOnExecutor(localUrlResolutionTask, new String[]{paramString});
            return;
        } catch (Exception paramString) {
            MoPubLog.d("Failed to resolve url", paramString);
            paramUrlResolutionListener.onFailure();
        }
    }

    protected String doInBackground(String... paramVarArgs) {
        Object localObject;
        if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
            localObject = null;
        }
        for (; ; ) {
            return (String) localObject;
            paramVarArgs = paramVarArgs[0];
            int i = 0;
            localObject = null;
            if ((paramVarArgs != null) && (i < 10)) {
                localObject = paramVarArgs;
                try {
                    if (IntentUtils.isHttpUrl(paramVarArgs)) {
                        String str = getRedirectLocation(paramVarArgs);
                        i += 1;
                        localObject = paramVarArgs;
                        paramVarArgs = str;
                    }
                } catch (IOException paramVarArgs) {
                    return null;
                }
            }
        }
        return (String) localObject;
    }

    protected void onCancelled() {
        super.onCancelled();
        this.mListener.onFailure();
    }

    protected void onPostExecute(String paramString) {
        super.onPostExecute(paramString);
        if ((isCancelled()) || (paramString == null)) {
            onCancelled();
            return;
        }
        this.mListener.onSuccess(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/UrlResolutionTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */