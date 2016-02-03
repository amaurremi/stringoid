package mobi.ifunny.util.cache;

import mobi.ifunny.util.ae;

final class c
        implements ae {
    private final e a;

    public c(e parame) {
        this.a = parame;
    }

    private static int b(int paramInt1, int paramInt2) {
        int i = paramInt2;
        if (paramInt2 <= 0) {
            i = 1048576;
        }
        return Math.min(100, Math.max(0, paramInt1 * 100 / i));
    }

    public boolean a(int paramInt1, int paramInt2) {
        if (this.a.a()) {
            return true;
        }
        this.a.a(b(paramInt1, paramInt2));
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */