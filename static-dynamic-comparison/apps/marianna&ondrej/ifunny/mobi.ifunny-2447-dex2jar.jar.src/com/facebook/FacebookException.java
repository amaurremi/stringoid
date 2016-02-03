package com.facebook;

public class FacebookException
        extends RuntimeException {
    static final long serialVersionUID = 1L;

    public FacebookException() {
    }

    public FacebookException(String paramString) {
        super(paramString);
    }

    public FacebookException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public FacebookException(Throwable paramThrowable) {
        super(paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */