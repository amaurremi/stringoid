package com.facebook;

public class FacebookOperationCanceledException
        extends FacebookException {
    static final long serialVersionUID = 1L;

    public FacebookOperationCanceledException() {
    }

    public FacebookOperationCanceledException(String paramString) {
        super(paramString);
    }

    public FacebookOperationCanceledException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public FacebookOperationCanceledException(Throwable paramThrowable) {
        super(paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/FacebookOperationCanceledException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */