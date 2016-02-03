package mobi.ifunny.util.cache;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.util.ab;
import mobi.ifunny.util.ad;
import mobi.ifunny.util.ag;
import mobi.ifunny.util.l;
import mobi.ifunny.util.t;

public final class a {
    private static final String a = a.class.getSimpleName();
    private static final e b = new b();
    private static final Map<String, Integer> c = new HashMap();

    public static <Result> m<Result> a(String paramString, f<Result> paramf) {
        return a(paramString, paramf, b);
    }

    public static <Result> m<Result> a(String paramString, f<Result> paramf, e parame) {
        m localm = new m();
        if ((paramString == null) || (paramf == null) || (parame == null)) {
        }
        for (; ; ) {
            return localm;
            mobi.ifunny.d.c(a, String.format("process %s\n%s", new Object[]{paramString, paramf.toString()}));
            try {
                Object localObject = new ag();
                ab.a(paramString, (OutputStream) localObject, new c(parame));
                if (!parame.a()) {
                    localObject = ((ag) localObject).toByteArray();
                    if (paramf.a != null) {
                        localm.a = paramf.a.b((byte[]) localObject);
                    }
                    if ((!parame.a()) && (paramf.b)) {
                        localm.b = l.a(IFunnyApplication.a, (byte[]) localObject);
                        return localm;
                    }
                }
            } catch (ad paramf) {
                if ((!paramf.c) && (!paramf.d)) {
                    throw new IllegalStateException("Download failed", paramf);
                }
            } catch (Exception paramf) {
                a(paramString, paramf);
            }
        }
        return localm;
    }

    private static void a(String paramString, Throwable paramThrowable) {
        if (((paramThrowable instanceof t)) && (((t) paramThrowable).a)) {
            return;
        }
        mobi.ifunny.d.a(a, paramString, paramThrowable);
        if (paramString != null) {
        }
        for (; ; ) {
            synchronized (c) {
                Integer localInteger = (Integer) c.get(paramString);
                if (localInteger == null) {
                    i = 1;
                    c.put(paramString, Integer.valueOf(i));
                    if ((paramString != null) && (i <= 1)) {
                        break;
                    }
                    mobi.ifunny.hockeyapp.b.a(new d(String.format("%s\nFailed %d times", new Object[]{paramString, Integer.valueOf(i)}), paramThrowable, null));
                    return;
                }
                i = localInteger.intValue() + 1;
            }
            int i = 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */