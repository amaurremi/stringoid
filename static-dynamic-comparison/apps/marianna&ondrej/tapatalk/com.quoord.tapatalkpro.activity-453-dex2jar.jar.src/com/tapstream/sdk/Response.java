package com.tapstream.sdk;

public class Response {
    public String data;
    public String message;
    public int status;

    public Response(int paramInt, String paramString1, String paramString2) {
        this.status = paramInt;
        this.message = paramString1;
        this.data = paramString2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */