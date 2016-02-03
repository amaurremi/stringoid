package mobi.ifunny.main.a;

public enum b {
    public final int g;
    public final int h;
    public final int i;

    private b(int paramInt1, int paramInt2, int paramInt3) {
        this.g = paramInt1;
        this.h = paramInt2;
        this.i = paramInt3;
    }

    public static b a(b paramb) {
        b localb = paramb;
        if (paramb == b) {
            localb = a;
        }
        return localb;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */