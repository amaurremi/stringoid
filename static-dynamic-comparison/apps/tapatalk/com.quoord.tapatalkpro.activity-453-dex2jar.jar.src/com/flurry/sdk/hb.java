package com.flurry.sdk;

public final class hb {
    public static final ha a = new ha("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    public static final ha b = new ha(a, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
    public static final ha c = new ha(a, "PEM", true, '=', 64);
    public static final ha d;

    static {
        StringBuffer localStringBuffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        localStringBuffer.setCharAt(localStringBuffer.indexOf("+"), '-');
        localStringBuffer.setCharAt(localStringBuffer.indexOf("/"), '_');
        d = new ha("MODIFIED-FOR-URL", localStringBuffer.toString(), false, '\000', Integer.MAX_VALUE);
    }

    public static ha a() {
        return b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */