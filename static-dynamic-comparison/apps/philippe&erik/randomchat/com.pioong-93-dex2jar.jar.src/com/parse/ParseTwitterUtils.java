package com.parse;

import android.content.Context;
import com.parse.auth.TwitterAuthenticationProvider;
import com.parse.twitter.Twitter;
import java.util.Set;
import org.json.JSONException;

public final class ParseTwitterUtils
{
  private static boolean isInitialized;
  private static TwitterAuthenticationProvider provider;
  private static Twitter twitter;
  
  private static void checkInitialization()
  {
    if (!isInitialized) {
      throw new IllegalStateException("You must call ParseTwitterUtils.initialize() before using ParseTwitterUtils");
    }
  }
  
  private static TwitterAuthenticationProvider getAuthenticationProvider()
  {
    if (provider == null) {
      provider = new TwitterAuthenticationProvider(getTwitter());
    }
    return provider;
  }
  
  public static Twitter getTwitter()
  {
    if (twitter == null) {
      twitter = new Twitter("", "");
    }
    return twitter;
  }
  
  public static void initialize(String paramString1, String paramString2)
  {
    getTwitter().setConsumerKey(paramString1);
    getTwitter().setConsumerSecret(paramString2);
    ParseUser.registerAuthenticationProvider(getAuthenticationProvider());
    isInitialized = true;
  }
  
  public static boolean isLinked(ParseUser paramParseUser)
  {
    return paramParseUser.getLinkedServiceNames().contains(getAuthenticationProvider().getAuthType());
  }
  
  public static void link(ParseUser paramParseUser, Context paramContext)
  {
    link(paramParseUser, paramContext, null);
  }
  
  public static void link(ParseUser paramParseUser, Context paramContext, SaveCallback paramSaveCallback)
  {
    checkInitialization();
    getAuthenticationProvider().setContext(paramContext);
    Parse.callbackOnMainThreadAsync(paramParseUser.linkWithAsync(getAuthenticationProvider().getAuthType()), paramSaveCallback, true);
  }
  
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    link(paramParseUser, paramString1, paramString2, paramString3, paramString4, null);
  }
  
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, String paramString3, String paramString4, SaveCallback paramSaveCallback)
  {
    
    try
    {
      Parse.callbackOnMainThreadAsync(paramParseUser.linkWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(paramString1, paramString2, paramString3, paramString4)), paramSaveCallback);
      return;
    }
    catch (JSONException paramParseUser)
    {
      while (paramSaveCallback == null) {}
      paramSaveCallback.internalDone(null, new ParseException(paramParseUser));
    }
  }
  
  public static void logIn(Context paramContext, LogInCallback paramLogInCallback)
  {
    checkInitialization();
    getAuthenticationProvider().setContext(paramContext);
    Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType()), paramLogInCallback, true);
  }
  
  public static void logIn(String paramString1, String paramString2, String paramString3, String paramString4, LogInCallback paramLogInCallback)
  {
    
    try
    {
      Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(paramString1, paramString2, paramString3, paramString4)), paramLogInCallback);
      return;
    }
    catch (JSONException paramString1)
    {
      while (paramLogInCallback == null) {}
      paramLogInCallback.internalDone(null, new ParseException(paramString1));
    }
  }
  
  public static void unlink(ParseUser paramParseUser)
    throws ParseException
  {
    checkInitialization();
    Parse.waitForTask(paramParseUser.unlinkFromAsync(getAuthenticationProvider().getAuthType()));
  }
  
  public static void unlinkInBackground(ParseUser paramParseUser)
  {
    unlinkInBackground(paramParseUser, null);
  }
  
  public static void unlinkInBackground(ParseUser paramParseUser, SaveCallback paramSaveCallback)
  {
    checkInitialization();
    Parse.callbackOnMainThreadAsync(paramParseUser.unlinkFromAsync(getAuthenticationProvider().getAuthType()), paramSaveCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseTwitterUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */