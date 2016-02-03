package com.quoord.tapatalkpro.callbackhandle;

public class CallBackFactory
        implements AbsCallBackFactory {
    private AbsCallBackHandler callbackHandler;

    public AbsCallBackHandler createCallBackHandler(String paramString) {
        if ("forget_password".equals(paramString)) {
            this.callbackHandler = new ForgetPasswordCallbackHandler();
        }
        for (; ; ) {
            return this.callbackHandler;
            if ("update_password".equals(paramString)) {
                this.callbackHandler = new UpdatePasswordCallbackHandler();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/callbackhandle/CallBackFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */