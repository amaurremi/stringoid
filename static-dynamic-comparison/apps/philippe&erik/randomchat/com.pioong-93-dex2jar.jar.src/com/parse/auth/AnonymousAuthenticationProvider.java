package com.parse.auth;

import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class AnonymousAuthenticationProvider
  implements ParseAuthenticationProvider
{
  public void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback)
  {
    try
    {
      paramParseAuthenticationCallback.onSuccess(getAuthData());
      return;
    }
    catch (JSONException paramParseAuthenticationCallback)
    {
      throw new RuntimeException(paramParseAuthenticationCallback);
    }
  }
  
  public void cancel() {}
  
  public void deauthenticate() {}
  
  public JSONObject getAuthData()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", UUID.randomUUID());
    return localJSONObject;
  }
  
  public String getAuthType()
  {
    return "anonymous";
  }
  
  public boolean restoreAuthentication(JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/auth/AnonymousAuthenticationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */