package mobi.ifunny.util.cache;

import android.graphics.Bitmap;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.d;
import mobi.ifunny.video.c;

public final class f<Result> {
    public static final f<Void> c = new f(null, true);
    public final i<Result> a;
    public final boolean b;

    public f(i<Result> parami) {
        this(parami, false);
    }

    public f(i<Result> parami, boolean paramBoolean) {
        this.a = parami;
        this.b = paramBoolean;
    }

    public static f<Boolean> a(String paramString) {
        return new f(new j(paramString));
    }

    public static f<d> a(a parama) {
        return a(parama, false);
    }

    public static f<d> a(a parama, boolean paramBoolean) {
        return new f(new k(parama), paramBoolean);
    }

    public static f<c> a(boolean paramBoolean) {
        return new f(new l(paramBoolean, null));
    }

    public static f<Bitmap> b(a parama) {
        return new f(new h(parama));
    }

    public String toString() {
        return "CacheOptions{processor=" + this.a + ", needFile=" + this.b + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */