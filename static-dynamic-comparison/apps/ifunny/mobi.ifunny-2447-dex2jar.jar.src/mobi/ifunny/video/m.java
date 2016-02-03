package mobi.ifunny.video;

import android.graphics.Rect;

import java.io.File;

public class m
        extends c {
    private static final String m = m.class.getSimpleName();
    private static boolean n = false;

    public m(File paramFile) {
        super(paramFile, null);
        try {
            this.b.readFrame();
            this.a = this.b.getCurrentFrameTimeStamp();
            this.b.decodeCurrentFrame(100000L);
            this.b.getBuffer(this.c);
            return;
        } catch (Exception paramFile) {
            d();
            throw new IllegalStateException(paramFile);
        }
    }

    public b a(String paramString, Rect paramRect) {
        paramString = new WebmVideo(paramString);
        if (!paramString.openFile()) {
            throw new IllegalStateException();
        }
        return paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */