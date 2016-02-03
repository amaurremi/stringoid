package com.android.volley;

import android.content.Intent;

public class AuthFailureError
        extends VolleyError {
    private Intent mResolutionIntent;

    public AuthFailureError() {
    }

    public AuthFailureError(Intent paramIntent) {
        this.mResolutionIntent = paramIntent;
    }

    public AuthFailureError(NetworkResponse paramNetworkResponse) {
        super(paramNetworkResponse);
    }

    public AuthFailureError(String paramString) {
        super(paramString);
    }

    public AuthFailureError(String paramString, Exception paramException) {
        super(paramString, paramException);
    }

    public String getMessage() {
        if (this.mResolutionIntent != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }

    public Intent getResolutionIntent() {
        return this.mResolutionIntent;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/android/volley/AuthFailureError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */