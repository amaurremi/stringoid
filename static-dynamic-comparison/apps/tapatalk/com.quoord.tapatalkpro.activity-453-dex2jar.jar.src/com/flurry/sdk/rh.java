package com.flurry.sdk;

public class rh {
    protected rc<qj, im> a;

    public im a(sh paramsh, jn<?> paramjn) {
        return a(paramsh.p(), paramjn);
    }

    public im a(Class<?> paramClass, jn<?> paramjn) {
        for (; ; ) {
            try {
                qj localqj = new qj(paramClass);
                Object localObject;
                if (this.a == null) {
                    this.a = new rc(20, 200);
                    localObject = (mw) paramjn.c(paramClass);
                    paramjn = paramjn.a().b(((mw) localObject).c());
                    if (paramjn == null) {
                        paramClass = paramClass.getSimpleName();
                        paramClass = new im(paramClass);
                        this.a.put(localqj, paramClass);
                        return paramClass;
                    }
                } else {
                    localObject = (im) this.a.get(localqj);
                    if (localObject == null) {
                        continue;
                    }
                    paramClass = (Class<?>) localObject;
                    continue;
                }
                paramClass = paramjn;
            } finally {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */