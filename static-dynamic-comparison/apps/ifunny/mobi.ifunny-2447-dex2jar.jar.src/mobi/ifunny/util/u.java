package mobi.ifunny.util;

public class u {
    private static u a = new u();
    private final int b;

    public u() {
        this(8192);
    }

    public u(int paramInt) {
        this.b = paramInt;
    }

    public static u a() {
        return a;
    }

    protected boolean a(int paramInt) {
        return false;
    }

    public final int b() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */