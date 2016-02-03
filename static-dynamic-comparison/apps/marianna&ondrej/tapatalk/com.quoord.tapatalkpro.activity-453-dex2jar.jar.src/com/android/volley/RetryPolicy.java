package com.android.volley;

public abstract interface RetryPolicy {
    public abstract int getCurrentRetryCount();

    public abstract int getCurrentTimeout();

    public abstract void retry(VolleyError paramVolleyError)
            throws VolleyError;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/android/volley/RetryPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */