package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;

public abstract interface HttpStack {
    public abstract HttpResponse performRequest(Request<?> paramRequest, Map<String, String> paramMap)
            throws IOException, AuthFailureError;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/android/volley/toolbox/HttpStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */