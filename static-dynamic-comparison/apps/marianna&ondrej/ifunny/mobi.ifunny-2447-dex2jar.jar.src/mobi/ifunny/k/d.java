package mobi.ifunny.k;

import android.graphics.Bitmap;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;

public class d
        implements t<Bitmap> {
    public static Bitmap c(mobi.ifunny.util.a.a parama, r paramr) {
        try {
            parama = (Bitmap) mobi.ifunny.util.cache.a.a(parama.c(), f.b(parama), new e(paramr)).a;
            return parama;
        } catch (Exception parama) {
        }
        return null;
    }

    public Bitmap a(mobi.ifunny.util.a.a parama, r<Bitmap> paramr) {
        return c(parama, paramr);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */