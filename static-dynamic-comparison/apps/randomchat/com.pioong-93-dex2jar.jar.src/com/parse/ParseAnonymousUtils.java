package com.parse;

import com.parse.auth.AnonymousAuthenticationProvider;
import java.util.Set;
import org.json.JSONException;

public final class ParseAnonymousUtils
{
  static final String ANONYMOUS_AUTH_TYPE = "anonymous";
  private static AnonymousAuthenticationProvider provider;
  
  static {}
  
  private static void initialize()
  {
    if (provider == null)
    {
      provider = new AnonymousAuthenticationProvider();
      ParseUser.registerAuthenticationProvider(provider);
    }
  }
  
  public static boolean isLinked(ParseUser paramParseUser)
  {
    return paramParseUser.getLinkedServiceNames().contains("anonymous");
  }
  
  static void lazyLogIn()
  {
    try
    {
      ParseUser.logInLazyUser(provider.getAuthType(), provider.getAuthData());
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public static void logIn(LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(provider.getAuthType()), paramLogInCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseAnonymousUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */