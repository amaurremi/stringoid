package com.millennialmedia.android;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

class BridgeMMMedia$1
        implements MediaScannerConnection.MediaScannerConnectionClient {
    BridgeMMMedia$1(BridgeMMMedia paramBridgeMMMedia, String paramString) {
    }

    public void onMediaScannerConnected() {
        if (this.b.a != null) {
            this.b.a.scanFile(this.a, null);
        }
    }

    public void onScanCompleted(String paramString, Uri paramUri) {
        if (paramUri == null) {
            MMLog.b("BridgeMMMedia", "Failed to scan " + paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */