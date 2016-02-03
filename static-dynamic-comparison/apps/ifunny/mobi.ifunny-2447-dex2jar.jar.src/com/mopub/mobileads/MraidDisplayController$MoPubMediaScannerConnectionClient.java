package com.mopub.mobileads;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

class MraidDisplayController$MoPubMediaScannerConnectionClient
        implements MediaScannerConnection.MediaScannerConnectionClient {
    private final String mFilename;
    private MediaScannerConnection mMediaScannerConnection;
    private final String mMimeType;

    private MraidDisplayController$MoPubMediaScannerConnectionClient(MraidDisplayController paramMraidDisplayController, String paramString1, String paramString2) {
        this.mFilename = paramString1;
        this.mMimeType = paramString2;
    }

    private void setMediaScannerConnection(MediaScannerConnection paramMediaScannerConnection) {
        this.mMediaScannerConnection = paramMediaScannerConnection;
    }

    public void onMediaScannerConnected() {
        if (this.mMediaScannerConnection != null) {
            this.mMediaScannerConnection.scanFile(this.mFilename, this.mMimeType);
        }
    }

    public void onScanCompleted(String paramString, Uri paramUri) {
        if (this.mMediaScannerConnection != null) {
            this.mMediaScannerConnection.disconnect();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidDisplayController$MoPubMediaScannerConnectionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */