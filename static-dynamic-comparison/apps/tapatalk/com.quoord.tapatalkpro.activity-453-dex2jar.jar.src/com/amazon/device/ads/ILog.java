package com.amazon.device.ads;

abstract interface ILog {
    public abstract void d(String paramString1, String paramString2);

    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);

    public abstract void e(String paramString1, String paramString2);

    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);

    public abstract void i(String paramString1, String paramString2);

    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);

    public abstract void v(String paramString1, String paramString2);

    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);

    public abstract void w(String paramString1, String paramString2);

    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/ILog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */