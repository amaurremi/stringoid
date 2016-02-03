package mobi.ifunny.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

import java.io.File;

public class k
        implements MediaScannerConnection.MediaScannerConnectionClient {
    private File a;
    private MediaScannerConnection b = new MediaScannerConnection(paramContext, this);

    public k(Context paramContext) {
    }

    public void a(File paramFile) {
        this.a = paramFile;
        this.b.connect();
    }

    public void onMediaScannerConnected() {
        this.b.scanFile(this.a.getAbsolutePath(), null);
    }

    public void onScanCompleted(String paramString, Uri paramUri) {
        this.b.disconnect();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */