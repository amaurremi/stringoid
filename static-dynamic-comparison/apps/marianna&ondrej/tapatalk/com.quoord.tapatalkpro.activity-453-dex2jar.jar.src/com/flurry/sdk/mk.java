package com.flurry.sdk;

public class mk
        extends jh {
    protected final Class<?> c;
    protected final String d;

    public mk(String paramString1, hg paramhg, Class<?> paramClass, String paramString2) {
        super(paramString1, paramhg);
        this.c = paramClass;
        this.d = paramString2;
    }

    public static mk a(hj paramhj, Object paramObject, String paramString) {
        if (paramObject == null) {
            throw new IllegalArgumentException();
        }
        if ((paramObject instanceof Class)) {
        }
        for (Class localClass = (Class) paramObject; ; localClass = paramObject.getClass()) {
            paramhj = new mk("Unrecognized field \"" + paramString + "\" (Class " + localClass.getName() + "), not marked as ignorable", paramhj.i(), localClass, paramString);
            paramhj.a(paramObject, paramString);
            return paramhj;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */