package com.quoord.xmlrpc;

public class XmlRpcException
        extends Exception {
    static final int FATAL = 2;
    static final int NONE = 0;
    static final int RECOVERABLE = 1;
    public final int code;

    public XmlRpcException(int paramInt, String paramString) {
        super(paramString);
        this.code = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/XmlRpcException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */