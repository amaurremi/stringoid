package com.flurry.sdk;

public class gt<T>
        extends fu<T> {
    public gt() {
        this(null, null, gs.b());
    }

    public gt(fn paramfn) {
        this(paramfn, paramfn, gs.b());
    }

    public gt(fn paramfn1, fn paramfn2, gs paramgs) {
        super(paramfn1, paramfn2, paramgs);
    }

    public gt(Class<T> paramClass) {
        this(gs.b().a(paramClass));
    }

    protected Object a(String paramString, fn paramfn) {
        Class localClass = b().b(paramfn);
        if (localClass == null) {
            return super.a(paramString, paramfn);
        }
        return Enum.valueOf(localClass, paramString);
    }

    public gs b() {
        return (gs) a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */