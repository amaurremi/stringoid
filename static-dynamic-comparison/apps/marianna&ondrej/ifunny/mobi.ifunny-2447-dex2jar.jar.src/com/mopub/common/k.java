package com.mopub.common;

import com.mopub.common.logging.MoPubLog;

final class k
        implements DownloadTask.DownloadTaskListener {
    public void onComplete(String paramString, DownloadResponse paramDownloadResponse) {
        if ((paramDownloadResponse == null) || (paramDownloadResponse.getStatusCode() != 200)) {
            MoPubLog.d("Failed to hit tracking endpoint: " + paramString);
            return;
        }
        if (HttpResponses.asResponseString(paramDownloadResponse) != null) {
            MoPubLog.d("Successfully hit tracking endpoint: " + paramString);
            return;
        }
        MoPubLog.d("Failed to hit tracking endpoint: " + paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */