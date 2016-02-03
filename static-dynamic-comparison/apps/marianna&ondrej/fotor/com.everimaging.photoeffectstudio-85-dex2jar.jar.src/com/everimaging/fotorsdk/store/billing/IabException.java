package com.everimaging.fotorsdk.store.billing;

public class IabException
        extends Exception {
    c mResult;

    public IabException(int paramInt, String paramString) {
        this(new c(paramInt, paramString));
    }

    public IabException(int paramInt, String paramString, Exception paramException) {
        this(new c(paramInt, paramString), paramException);
    }

    public IabException(c paramc) {
        this(paramc, null);
    }

    public IabException(c paramc, Exception paramException) {
        super(paramc.a(), paramException);
        this.mResult = paramc;
    }

    public c getResult() {
        return this.mResult;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/billing/IabException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */