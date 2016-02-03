package com.quoord.tapatalkpro.callbackhandle;

public abstract interface AbsCallBackFactory {
    public static final String method_FORGETPASSWORD = "forget_password";
    public static final String method_UPDATEPASSWORD = "update_password";

    public abstract AbsCallBackHandler createCallBackHandler(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/callbackhandle/AbsCallBackFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */