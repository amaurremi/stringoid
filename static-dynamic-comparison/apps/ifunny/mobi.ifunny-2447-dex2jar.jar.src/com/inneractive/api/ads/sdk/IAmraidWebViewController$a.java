package com.inneractive.api.ads.sdk;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

final class IAmraidWebViewController$a
        implements MediaScannerConnection.MediaScannerConnectionClient {
    private final String mFilename;
    private MediaScannerConnection mMediaScannerConnection;
    private final String mMimeType;

    private IAmraidWebViewController$a(IAmraidWebViewController paramIAmraidWebViewController, String paramString1, String paramString2) {
        this.mFilename = paramString1;
        this.mMimeType = paramString2;
    }

    private void setMediaScannerConnection(MediaScannerConnection paramMediaScannerConnection) {
        this.mMediaScannerConnection = paramMediaScannerConnection;
    }

    public final void onMediaScannerConnected() {
        if (this.mMediaScannerConnection != null) {
            this.mMediaScannerConnection.scanFile(this.mFilename, this.mMimeType);
        }
    }

    public final void onScanCompleted(String paramString, Uri paramUri) {
        if (this.mMediaScannerConnection != null) {
            this.mMediaScannerConnection.disconnect();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebViewController$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */