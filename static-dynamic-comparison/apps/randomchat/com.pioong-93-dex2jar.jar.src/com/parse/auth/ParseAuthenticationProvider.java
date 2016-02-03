package com.parse.auth;

import org.json.JSONObject;

public abstract interface ParseAuthenticationProvider
{
  public abstract void authenticate(ParseAuthenticationCallback paramParseAuthenticationCallback);
  
  public abstract void cancel();
  
  public abstract void deauthenticate();
  
  public abstract String getAuthType();
  
  public abstract boolean restoreAuthentication(JSONObject paramJSONObject);
  
  public static abstract interface ParseAuthenticationCallback
  {
    public abstract void onCancel();
    
    public abstract void onError(Throwable paramThrowable);
    
    public abstract void onSuccess(JSONObject paramJSONObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/auth/ParseAuthenticationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */