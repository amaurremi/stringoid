package com.inmobi.commons.network;

import java.util.List;
import java.util.Map;

public class Response {
    String a = null;
    int b = 0;
    Map<String, List<String>> c = null;
    ErrorCode d;

    public Response(ErrorCode paramErrorCode) {
        this.d = paramErrorCode;
    }

    public Response(String paramString, int paramInt, Map<String, List<String>> paramMap) {
        this.a = paramString;
        this.b = paramInt;
        this.c = paramMap;
    }

    public ErrorCode getError() {
        return this.d;
    }

    public Map<String, List<String>> getHeaders() {
        return this.c;
    }

    public String getResponseBody() {
        return this.a;
    }

    public int getStatusCode() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */