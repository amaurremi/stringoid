package com.android.volley;

public abstract interface Network {
    public abstract NetworkResponse performRequest(Request<?> paramRequest)
            throws VolleyError;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/android/volley/Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */