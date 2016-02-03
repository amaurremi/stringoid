package mobi.ifunny.util.cache;

import android.graphics.Bitmap;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.b;

class h
        implements i<Bitmap> {
    private final a a;

    public h(a parama) {
        this.a = parama;
    }

    public Bitmap a(byte[] paramArrayOfByte) {
        return b.a(paramArrayOfByte, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */