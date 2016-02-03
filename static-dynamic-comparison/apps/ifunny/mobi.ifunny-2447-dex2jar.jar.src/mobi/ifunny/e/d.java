package mobi.ifunny.e;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import mobi.ifunny.util.a.a;

public class d {
    private static <T extends mobi.ifunny.l.e, R> void a(T paramT, String paramString, Uri paramUri, a parama, g<R> paramg, h<T, R> paramh) {
        new j(paramT, paramString, parama, paramh, paramg).execute(new Uri[]{paramUri});
    }

    public static <T extends mobi.ifunny.l.e> void a(T paramT, String paramString, Uri paramUri, a parama, h<T, Bitmap> paramh) {
        String str = paramUri.getScheme();
        if ((TextUtils.equals(str, "http")) || (TextUtils.equals(str, "https"))) {
            a(paramT, paramString, paramUri, mobi.ifunny.util.cache.f.b(parama), paramh);
        }
        while (!TextUtils.equals(str, "file")) {
            return;
        }
        a(paramT, paramString, paramUri, parama, new e(), paramh);
    }

    private static <T extends mobi.ifunny.l.e, R> void a(T paramT, String paramString, Uri paramUri, mobi.ifunny.util.cache.f<R> paramf, h<T, R> paramh) {
        paramUri = paramUri.toString();
        new i(paramT, paramString, paramf, paramh).execute(new String[]{paramUri});
    }

    public static <T extends mobi.ifunny.l.e> void b(T paramT, String paramString, Uri paramUri, a parama, h<T, mobi.ifunny.util.a.d> paramh) {
        String str = paramUri.getScheme();
        if ((TextUtils.equals(str, "http")) || (TextUtils.equals(str, "https"))) {
            a(paramT, paramString, paramUri, mobi.ifunny.util.cache.f.a(parama, true), paramh);
        }
        while (!TextUtils.equals(str, "file")) {
            return;
        }
        a(paramT, paramString, paramUri, parama, new f(), paramh);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */