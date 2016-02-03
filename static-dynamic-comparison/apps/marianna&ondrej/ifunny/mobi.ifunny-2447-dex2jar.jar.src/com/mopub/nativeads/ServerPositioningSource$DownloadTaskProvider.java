package com.mopub.nativeads;

import com.mopub.common.DownloadTask;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
class ServerPositioningSource$DownloadTaskProvider {
    DownloadTask get(DownloadTask.DownloadTaskListener paramDownloadTaskListener) {
        return new DownloadTask(paramDownloadTaskListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ServerPositioningSource$DownloadTaskProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */