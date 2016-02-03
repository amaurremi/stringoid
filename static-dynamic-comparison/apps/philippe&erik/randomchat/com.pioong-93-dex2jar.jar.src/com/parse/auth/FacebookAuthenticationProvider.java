package com.parse.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Request.Callback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionState;
import com.facebook.SharedPreferencesTokenCachingStrategy;
import com.facebook.TokenCachingStrategy;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.ServiceListener;
import com.facebook.android.FacebookError;
import com.facebook.model.GraphObject;
import com.parse.ParseException;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAuthenticationProvider
  implements ParseAuthenticationProvider
{
  private static final String AUTH_TYPE_NAME = "facebook";
  public static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
  private int activityCode;
  private Context applicationContext;
  private String applicationId;
  private WeakReference<Activity> baseActivity;
  private ParseAuthenticationProvider.ParseAuthenticationCallback currentOperationCallback;
  private SessionDefaultAudience defaultAudience;
  private Facebook facebook;
  private Collection<String> permissions;
  private final DateFormat preciseDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
  private Session session;
  private String userId;
  
  public FacebookAuthenticationProvider(Context paramContext, String paramString)
  {
    this.preciseDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    this.activityCode = 32665;
    this.applicationId = paramString;
    if (paramContext != null) {
      this.applicationContext = paramContext.getApplicationContext();
    }
    if (paramString != null) {
      this.facebook = new Facebook(paramString);
    }
  }
  
  private void handleCancel()
  {
    if (this.currentOperationCallback == null) {
      return;
    }
    try
    {
      this.currentOperationCallback.onCancel();
      return;
    }
    finally
    {
      this.currentOperationCallback = null;
    }
  }
  
  private void handleError(Throwable paramThrowable)
  {
    if (this.currentOperationCallback == null) {
      return;
    }
    try
    {
      this.currentOperationCallback.onError(paramThrowable);
      return;
    }
    finally
    {
      this.currentOperationCallback = null;
    }
  }
  
  /* Error */
  private void handleSuccess(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/parse/auth/FacebookAuthenticationProvider:currentOperationCallback	Lcom/parse/auth/ParseAuthenticationProvider$ParseAuthenticationCallback;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 96	com/parse/auth/FacebookAuthenticationProvider:userId	Ljava/lang/String;
    //   13: aload_0
    //   14: aload_1
    //   15: aload_0
    //   16: getfield 128	com/parse/auth/FacebookAuthenticationProvider:session	Lcom/facebook/Session;
    //   19: invokevirtual 134	com/facebook/Session:getAccessToken	()Ljava/lang/String;
    //   22: aload_0
    //   23: getfield 128	com/parse/auth/FacebookAuthenticationProvider:session	Lcom/facebook/Session;
    //   26: invokevirtual 138	com/facebook/Session:getExpirationDate	()Ljava/util/Date;
    //   29: invokevirtual 142	com/parse/auth/FacebookAuthenticationProvider:getAuthData	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lorg/json/JSONObject;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 111	com/parse/auth/FacebookAuthenticationProvider:currentOperationCallback	Lcom/parse/auth/ParseAuthenticationProvider$ParseAuthenticationCallback;
    //   37: aload_1
    //   38: invokeinterface 146 2 0
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 111	com/parse/auth/FacebookAuthenticationProvider:currentOperationCallback	Lcom/parse/auth/ParseAuthenticationProvider$ParseAuthenticationCallback;
    //   48: return
    //   49: astore_1
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 107	com/parse/auth/FacebookAuthenticationProvider:handleError	(Ljava/lang/Throwable;)V
    //   55: return
    //   56: astore_1
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 111	com/parse/auth/FacebookAuthenticationProvider:currentOperationCallback	Lcom/parse/auth/ParseAuthenticationProvider$ParseAuthenticationCallback;
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	FacebookAuthenticationProvider
    //   0	64	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   13	33	49	org/json/JSONException
    //   33	43	56	finally
  }
  
  public void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback)
  {
    for (;;)
    {
      try
      {
        if (this.currentOperationCallback != null) {
          cancel();
        }
        this.currentOperationCallback = paramParseAuthenticationCallback;
        if (this.baseActivity == null)
        {
          paramParseAuthenticationCallback = null;
          if (paramParseAuthenticationCallback != null) {
            break;
          }
          throw new IllegalStateException("Activity must be non-null for Facebook authentication to proceed.");
        }
      }
      finally {}
      paramParseAuthenticationCallback = (Activity)this.baseActivity.get();
    }
    int i = this.activityCode;
    this.session = new Session.Builder(paramParseAuthenticationCallback).setApplicationId(this.applicationId).setTokenCachingStrategy(new SharedPreferencesTokenCachingStrategy(paramParseAuthenticationCallback)).build();
    paramParseAuthenticationCallback = new Session.OpenRequest(paramParseAuthenticationCallback);
    paramParseAuthenticationCallback.setRequestCode(i);
    if (this.defaultAudience != null) {
      paramParseAuthenticationCallback.setDefaultAudience(this.defaultAudience);
    }
    if (this.permissions != null) {
      paramParseAuthenticationCallback.setPermissions(new ArrayList(this.permissions));
    }
    paramParseAuthenticationCallback.setCallback(new Session.StatusCallback()
    {
      public void call(Session paramAnonymousSession, SessionState paramAnonymousSessionState, Exception paramAnonymousException)
      {
        if (paramAnonymousSessionState == SessionState.OPENING) {}
        do
        {
          return;
          if (!paramAnonymousSessionState.isOpened()) {
            break;
          }
        } while (FacebookAuthenticationProvider.this.currentOperationCallback == null);
        paramAnonymousSession = Request.newGraphPathRequest(paramAnonymousSession, "me", new Request.Callback()
        {
          public void onCompleted(Response paramAnonymous2Response)
          {
            if (paramAnonymous2Response.getError() != null)
            {
              if (paramAnonymous2Response.getError().getException() != null)
              {
                FacebookAuthenticationProvider.this.handleError(paramAnonymous2Response.getError().getException());
                return;
              }
              FacebookAuthenticationProvider.this.handleError(new ParseException(-1, "An error occurred while fetching the Facebook user's identity."));
              return;
            }
            FacebookAuthenticationProvider.this.handleSuccess((String)paramAnonymous2Response.getGraphObject().getProperty("id"));
          }
        });
        paramAnonymousSession.getParameters().putString("fields", "id");
        paramAnonymousSession.executeAsync();
        return;
        if (paramAnonymousException != null)
        {
          FacebookAuthenticationProvider.this.handleError(paramAnonymousException);
          return;
        }
        FacebookAuthenticationProvider.this.handleCancel();
      }
    });
    this.session.openForRead(paramParseAuthenticationCallback);
  }
  
  public void cancel()
  {
    try
    {
      handleCancel();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void deauthenticate()
  {
    restoreAuthentication(null);
  }
  
  @Deprecated
  public void extendAccessToken(Context paramContext, ParseAuthenticationProvider.ParseAuthenticationCallback paramParseAuthenticationCallback)
  {
    try
    {
      if (this.currentOperationCallback != null) {
        cancel();
      }
      this.currentOperationCallback = paramParseAuthenticationCallback;
      if (!this.facebook.extendAccessToken(paramContext, new Facebook.ServiceListener()
      {
        public void onComplete(Bundle paramAnonymousBundle)
        {
          FacebookAuthenticationProvider.this.handleSuccess(FacebookAuthenticationProvider.this.userId);
        }
        
        public void onError(Error paramAnonymousError)
        {
          FacebookAuthenticationProvider.this.handleError(paramAnonymousError);
        }
        
        public void onFacebookError(FacebookError paramAnonymousFacebookError)
        {
          FacebookAuthenticationProvider.this.handleError(paramAnonymousFacebookError);
        }
      })) {
        handleCancel();
      }
      return;
    }
    finally {}
  }
  
  public int getActivityCode()
  {
    return this.activityCode;
  }
  
  public JSONObject getAuthData(String paramString1, String paramString2, Date paramDate)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", paramString1);
    localJSONObject.put("access_token", paramString2);
    localJSONObject.put("expiration_date", this.preciseDateFormat.format(paramDate));
    return localJSONObject;
  }
  
  public String getAuthType()
  {
    return "facebook";
  }
  
  public Facebook getFacebook()
  {
    return this.facebook;
  }
  
  public Session getSession()
  {
    return this.session;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Activity localActivity = (Activity)this.baseActivity.get();
    if (localActivity != null) {
      this.session.onActivityResult(localActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean restoreAuthentication(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (this.facebook != null)
      {
        this.facebook.setAccessExpires(0L);
        this.facebook.setAccessToken(null);
      }
      this.session = null;
      return true;
    }
    try
    {
      Object localObject = paramJSONObject.getString("access_token");
      Date localDate = this.preciseDateFormat.parse(paramJSONObject.getString("expiration_date"));
      if (this.facebook != null)
      {
        this.facebook.setAccessToken((String)localObject);
        this.facebook.setAccessExpires(localDate.getTime());
      }
      localObject = new SharedPreferencesTokenCachingStrategy(this.applicationContext);
      Bundle localBundle = ((TokenCachingStrategy)localObject).load();
      TokenCachingStrategy.putToken(localBundle, paramJSONObject.getString("access_token"));
      TokenCachingStrategy.putExpirationDate(localBundle, localDate);
      ((TokenCachingStrategy)localObject).save(localBundle);
      paramJSONObject = new Session.Builder(this.applicationContext).setApplicationId(this.applicationId).setTokenCachingStrategy((TokenCachingStrategy)localObject).build();
      if (paramJSONObject.getState() == SessionState.CREATED_TOKEN_LOADED)
      {
        paramJSONObject.openForRead(null);
        this.session = paramJSONObject;
        Session.setActiveSession(this.session);
        return true;
      }
      this.session = null;
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  public void setActivity(Activity paramActivity)
  {
    try
    {
      this.baseActivity = new WeakReference(paramActivity);
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  public void setActivityCode(int paramInt)
  {
    try
    {
      this.activityCode = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setPermissions(Collection<String> paramCollection)
  {
    try
    {
      this.permissions = paramCollection;
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/auth/FacebookAuthenticationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */