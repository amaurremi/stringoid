package com.mopub.nativeads;

import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.HttpResponses;
import com.mopub.common.logging.MoPubLog;
import org.json.JSONException;

class ServerPositioningSource$2
        implements DownloadTask.DownloadTaskListener {
    ServerPositioningSource$2(ServerPositioningSource paramServerPositioningSource) {
    }

    public void onComplete(String paramString, DownloadResponse paramDownloadResponse) {
        if (paramDownloadResponse == null) {
            return;
        }
        ServerPositioningSource.access$102(this.this$0, null);
        if (paramDownloadResponse.getStatusCode() != 200) {
            MoPubLog.e("Invalid positioning download response ");
            ServerPositioningSource.access$200(this.this$0);
            return;
        }
        paramString = HttpResponses.asResponseString(paramDownloadResponse);
        try {
            paramString = this.this$0.parseJsonResponse(paramString);
            ServerPositioningSource.access$300(this.this$0, paramString);
            return;
        } catch (JSONException paramString) {
            MoPubLog.e("Error parsing JSON: ", paramString);
            ServerPositioningSource.access$200(this.this$0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ServerPositioningSource$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */