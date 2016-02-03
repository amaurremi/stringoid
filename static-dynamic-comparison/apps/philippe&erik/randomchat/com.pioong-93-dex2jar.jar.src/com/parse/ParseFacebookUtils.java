package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.Session;
import com.facebook.android.Facebook;
import com.parse.auth.FacebookAuthenticationProvider;
import com.parse.auth.ParseAuthenticationProvider.ParseAuthenticationCallback;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class ParseFacebookUtils
{
  private static boolean isInitialized;
  private static FacebookAuthenticationProvider provider;
  
  private static void checkInitialization()
  {
    if (!isInitialized) {
      throw new IllegalStateException("You must call ParseFacebookUtils.initialize() before using ParseFacebookUtils");
    }
  }
  
  @Deprecated
  public static void extendAccessToken(ParseUser paramParseUser, Context paramContext, final SaveCallback paramSaveCallback)
  {
    checkInitialization();
    provider.extendAccessToken(paramContext, new ParseAuthenticationProvider.ParseAuthenticationCallback()
    {
      public void onCancel()
      {
        if (paramSaveCallback != null) {
          paramSaveCallback.internalDone(null, null);
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (paramSaveCallback != null) {
          paramSaveCallback.internalDone(null, new ParseException(paramAnonymousThrowable));
        }
      }
      
      public void onSuccess(JSONObject paramAnonymousJSONObject)
      {
        Parse.callbackOnMainThreadAsync(ParseFacebookUtils.this.linkWithAsync(ParseFacebookUtils.provider.getAuthType(), paramAnonymousJSONObject), paramSaveCallback, true);
      }
    });
  }
  
  @Deprecated
  public static boolean extendAccessTokenIfNeeded(ParseUser paramParseUser, Context paramContext, SaveCallback paramSaveCallback)
  {
    if (shouldExtendAccessToken(paramParseUser))
    {
      extendAccessToken(paramParseUser, paramContext, paramSaveCallback);
      return true;
    }
    return false;
  }
  
  public static void finishAuthentication(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (provider != null) {
      provider.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  @Deprecated
  public static Facebook getFacebook()
  {
    if (provider == null) {
      throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getFacebook()");
    }
    return provider.getFacebook();
  }
  
  public static Session getSession()
  {
    if (provider == null) {
      throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getSession()");
    }
    return provider.getSession();
  }
  
  public static void initialize(String paramString)
  {
    if (Parse.applicationContext == null) {
      throw new IllegalStateException("You must call Parse.initialize() before calling ParseFacebookUtils.initialize()");
    }
    provider = new FacebookAuthenticationProvider(Parse.applicationContext, paramString);
    ParseUser.registerAuthenticationProvider(provider);
    isInitialized = true;
  }
  
  public static boolean isLinked(ParseUser paramParseUser)
  {
    return paramParseUser.getLinkedServiceNames().contains("facebook");
  }
  
  public static void link(ParseUser paramParseUser, Activity paramActivity)
  {
    link(paramParseUser, Collections.emptyList(), paramActivity, 32665, null);
  }
  
  public static void link(ParseUser paramParseUser, Activity paramActivity, int paramInt)
  {
    link(paramParseUser, Collections.emptyList(), paramActivity, paramInt, null);
  }
  
  public static void link(ParseUser paramParseUser, Activity paramActivity, int paramInt, SaveCallback paramSaveCallback)
  {
    link(paramParseUser, Collections.emptyList(), paramActivity, paramInt, paramSaveCallback);
  }
  
  public static void link(ParseUser paramParseUser, Activity paramActivity, SaveCallback paramSaveCallback)
  {
    link(paramParseUser, Collections.emptyList(), paramActivity, 32665, paramSaveCallback);
  }
  
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, Date paramDate)
  {
    link(paramParseUser, paramString1, paramString2, paramDate, null);
  }
  
  public static void link(ParseUser paramParseUser, String paramString1, String paramString2, Date paramDate, SaveCallback paramSaveCallback)
  {
    
    try
    {
      Parse.callbackOnMainThreadAsync(paramParseUser.linkWithAsync(provider.getAuthType(), provider.getAuthData(paramString1, paramString2, paramDate)), paramSaveCallback);
      return;
    }
    catch (JSONException paramParseUser)
    {
      while (paramSaveCallback == null) {}
      paramSaveCallback.internalDone(null, new ParseException(paramParseUser));
    }
  }
  
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity)
  {
    link(paramParseUser, paramCollection, paramActivity, 32665, null);
  }
  
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity, int paramInt)
  {
    link(paramParseUser, paramCollection, paramActivity, paramInt, null);
  }
  
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity, int paramInt, SaveCallback paramSaveCallback)
  {
    checkInitialization();
    provider.setActivity(paramActivity);
    provider.setActivityCode(paramInt);
    paramActivity = paramCollection;
    if (paramCollection == null) {
      paramActivity = Collections.emptyList();
    }
    provider.setPermissions(paramActivity);
    Parse.callbackOnMainThreadAsync(paramParseUser.linkWithAsync(provider.getAuthType()), paramSaveCallback, true);
  }
  
  public static void link(ParseUser paramParseUser, Collection<String> paramCollection, Activity paramActivity, SaveCallback paramSaveCallback)
  {
    link(paramParseUser, paramCollection, paramActivity, 32665, paramSaveCallback);
  }
  
  public static void logIn(Activity paramActivity, int paramInt, LogInCallback paramLogInCallback)
  {
    logIn(Collections.emptyList(), paramActivity, paramInt, paramLogInCallback);
  }
  
  public static void logIn(Activity paramActivity, LogInCallback paramLogInCallback)
  {
    logIn(Collections.emptyList(), paramActivity, 32665, paramLogInCallback);
  }
  
  public static void logIn(String paramString1, String paramString2, Date paramDate, LogInCallback paramLogInCallback)
  {
    
    try
    {
      Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(provider.getAuthType(), provider.getAuthData(paramString1, paramString2, paramDate)), paramLogInCallback);
      return;
    }
    catch (JSONException paramString1)
    {
      while (paramLogInCallback == null) {}
      paramLogInCallback.internalDone(null, new ParseException(paramString1));
    }
  }
  
  public static void logIn(Collection<String> paramCollection, Activity paramActivity, int paramInt, LogInCallback paramLogInCallback)
  {
    checkInitialization();
    provider.setActivity(paramActivity);
    provider.setActivityCode(paramInt);
    paramActivity = paramCollection;
    if (paramCollection == null) {
      paramActivity = Collections.emptyList();
    }
    provider.setPermissions(paramActivity);
    Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(provider.getAuthType()), paramLogInCallback, true);
  }
  
  public static void logIn(Collection<String> paramCollection, Activity paramActivity, LogInCallback paramLogInCallback)
  {
    logIn(paramCollection, paramActivity, 32665, paramLogInCallback);
  }
  
  public static void saveLatestSessionData(ParseUser paramParseUser)
  {
    saveLatestSessionData(paramParseUser, null);
  }
  
  public static void saveLatestSessionData(ParseUser paramParseUser, SaveCallback paramSaveCallback)
  {
    
    if (!isLinked(paramParseUser)) {
      throw new IllegalStateException("The user must already be linked to Facebook.");
    }
    link(paramParseUser, provider.getUserId(), getSession().getAccessToken(), getSession().getExpirationDate(), paramSaveCallback);
  }
  
  @Deprecated
  public static boolean shouldExtendAccessToken(ParseUser paramParseUser)
  {
    return (paramParseUser != null) && (isLinked(paramParseUser)) && (getFacebook().shouldExtendAccessToken());
  }
  
  public static void unlink(ParseUser paramParseUser)
    throws ParseException
  {
    checkInitialization();
    Parse.waitForTask(paramParseUser.unlinkFromAsync("facebook"));
  }
  
  public static void unlinkInBackground(ParseUser paramParseUser)
  {
    unlinkInBackground(null);
  }
  
  public static void unlinkInBackground(ParseUser paramParseUser, SaveCallback paramSaveCallback)
  {
    checkInitialization();
    Parse.callbackOnMainThreadAsync(paramParseUser.unlinkFromAsync("facebook"), paramSaveCallback);
  }
  
  public static final class Permissions
  {
    public static final class Extended
    {
      public static final String ADS_MANAGEMENT = "ads_management";
      public static final String CREATE_EVENT = "create_event";
      public static final String MANAGE_FRIEND_LISTS = "manage_friendlists";
      public static final String MANAGE_NOTIFICATIONS = "manage_notifications";
      public static final String OFFLINE_ACCESS = "offline_access";
      public static final String PUBLISH_ACTIONS = "publish_actions";
      public static final String PUBLISH_CHECKINS = "publish_checkins";
      public static final String PUBLISH_STREAM = "publish_stream";
      public static final String READ_FRIEND_LISTS = "read_friendlists";
      public static final String READ_INSIGHTS = "read_insights";
      public static final String READ_MAILBOX = "read_mailbox";
      public static final String READ_REQUESTS = "read_requests";
      public static final String READ_STREAM = "read_stream";
      public static final String RSVP_EVENT = "rsvp_event";
      public static final String XMPP_LOGIN = "xmpp_login";
    }
    
    public static final class Friends
    {
      public static final String ABOUT_ME = "friends_about_me";
      public static final String ACTIVITIES = "friends_activities";
      public static final String BIRTHDAY = "friends_birthday";
      public static final String CHECKINS = "friends_checkins";
      public static final String EDUCATION_HISTORY = "friends_education_history";
      public static final String EVENTS = "friends_events";
      public static final String GROUPS = "friends_groups";
      public static final String HOMETOWN = "friends_hometown";
      public static final String INTERESTS = "friends_interests";
      public static final String LIKES = "friends_likes";
      public static final String LOCATION = "friends_location";
      public static final String NOTES = "friends_notes";
      public static final String ONLINE_PRESENCE = "friends_online_presence";
      public static final String PHOTOS = "friends_photos";
      public static final String QUESTIONS = "friends_questions";
      public static final String RELATIONSHIPS = "friends_relationships";
      public static final String RELATIONSHIP_DETAILS = "friends_relationship_details";
      public static final String RELIGION_POLITICS = "friends_religion_politics";
      public static final String STATUS = "friends_status";
      public static final String VIDEOS = "friends_videos";
      public static final String WEBSITE = "friends_website";
      public static final String WORK_HISTORY = "friends_work_history";
    }
    
    public static final class Page
    {
      public static final String MANAGE_PAGES = "manage_pages";
    }
    
    public static final class User
    {
      public static final String ABOUT_ME = "user_about_me";
      public static final String ACTIVITIES = "user_activities";
      public static final String BIRTHDAY = "user_birthday";
      public static final String CHECKINS = "user_checkins";
      public static final String EDUCATION_HISTORY = "user_education_history";
      public static final String EMAIL = "email";
      public static final String EVENTS = "user_events";
      public static final String GROUPS = "user_groups";
      public static final String HOMETOWN = "user_hometown";
      public static final String INTERESTS = "user_interests";
      public static final String LIKES = "user_likes";
      public static final String LOCATION = "user_location";
      public static final String NOTES = "user_notes";
      public static final String ONLINE_PRESENCE = "user_online_presence";
      public static final String PHOTOS = "user_photos";
      public static final String QUESTIONS = "user_questions";
      public static final String RELATIONSHIPS = "user_relationships";
      public static final String RELATIONSHIP_DETAILS = "user_relationship_details";
      public static final String RELIGION_POLITICS = "user_religion_politics";
      public static final String STATUS = "user_status";
      public static final String VIDEOS = "user_videos";
      public static final String WEBSITE = "user_website";
      public static final String WORK_HISTORY = "user_work_history";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseFacebookUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */