package com.parse.twitter;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.CookieSyncManager;
import com.parse.internal.AsyncCallback;
import com.parse.oauth.OAuth1FlowDialog;
import com.parse.oauth.OAuth1FlowDialog.FlowResultHandler;
import com.parse.oauth.OAuth1FlowException;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.OAuthProvider;
import com.parse.signpost.commonshttp.CommonsHttpOAuthConsumer;
import com.parse.signpost.commonshttp.CommonsHttpOAuthProvider;
import com.parse.signpost.http.HttpParameters;
import org.apache.http.client.methods.HttpUriRequest;

public class Twitter
{
  static final String ACCESS_TOKEN_URL = "https://api.twitter.com/oauth/access_token";
  static final String AUTHORIZE_URL = "https://api.twitter.com/oauth/authorize";
  private static final String CALLBACK_URL = "twitter-oauth://complete";
  private static final OAuthProvider PROVIDER = new CommonsHttpOAuthProvider("https://api.twitter.com/oauth/request_token", "https://api.twitter.com/oauth/access_token", "https://api.twitter.com/oauth/authorize");
  static final String REQUEST_TOKEN_URL = "https://api.twitter.com/oauth/request_token";
  private static final String SCREEN_NAME_PARAM = "screen_name";
  private static final String USER_ID_PARAM = "user_id";
  private static final String VERIFIER_PARAM = "oauth_verifier";
  private String authToken;
  private String authTokenSecret;
  private String consumerKey;
  private String consumerSecret;
  private String screenName;
  private String userId;
  
  public Twitter(String paramString1, String paramString2)
  {
    this.consumerKey = paramString1;
    this.consumerSecret = paramString2;
  }
  
  public void authorize(final Context paramContext, final AsyncCallback paramAsyncCallback)
  {
    if ((getConsumerKey() == null) || (getConsumerKey().length() == 0) || (getConsumerSecret() == null) || (getConsumerSecret().length() == 0)) {
      throw new IllegalStateException("Twitter must be initialized with a consumer key and secret before authorization.");
    }
    final CommonsHttpOAuthConsumer localCommonsHttpOAuthConsumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
    final ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
    localProgressDialog.setMessage("Loading...");
    new AsyncTask()
    {
      private Throwable error;
      
      protected String doInBackground(Void... paramAnonymousVarArgs)
      {
        try
        {
          paramAnonymousVarArgs = Twitter.PROVIDER.retrieveRequestToken(localCommonsHttpOAuthConsumer, "twitter-oauth://complete");
          return paramAnonymousVarArgs;
        }
        catch (Throwable paramAnonymousVarArgs)
        {
          this.error = paramAnonymousVarArgs;
        }
        return null;
      }
      
      protected void onPostExecute(String paramAnonymousString)
      {
        super.onPostExecute(paramAnonymousString);
        try
        {
          if (this.error != null)
          {
            paramAsyncCallback.onFailure(this.error);
            return;
          }
          CookieSyncManager.createInstance(paramContext);
          new OAuth1FlowDialog(paramContext, paramAnonymousString, "twitter-oauth://complete", "api.twitter", new OAuth1FlowDialog.FlowResultHandler()
          {
            public void onCancel()
            {
              this.val$callback.onCancel();
            }
            
            public void onComplete(final String paramAnonymous2String)
            {
              CookieSyncManager.getInstance().sync();
              paramAnonymous2String = Uri.parse(paramAnonymous2String).getQueryParameter("oauth_verifier");
              if (paramAnonymous2String == null)
              {
                this.val$callback.onCancel();
                return;
              }
              new AsyncTask()
              {
                private Throwable error;
                
                protected HttpParameters doInBackground(Void... paramAnonymous3VarArgs)
                {
                  try
                  {
                    Twitter.PROVIDER.retrieveAccessToken(this.val$consumer, paramAnonymous2String);
                    return Twitter.PROVIDER.getResponseParameters();
                  }
                  catch (Throwable paramAnonymous3VarArgs)
                  {
                    for (;;)
                    {
                      this.error = paramAnonymous3VarArgs;
                    }
                  }
                }
                
                /* Error */
                protected void onPostExecute(HttpParameters paramAnonymous3HttpParameters)
                {
                  // Byte code:
                  //   0: aload_0
                  //   1: aload_1
                  //   2: invokespecial 72	android/os/AsyncTask:onPostExecute	(Ljava/lang/Object;)V
                  //   5: aload_0
                  //   6: getfield 62	com/parse/twitter/Twitter$1$1$1:error	Ljava/lang/Throwable;
                  //   9: ifnull +24 -> 33
                  //   12: aload_0
                  //   13: getfield 36	com/parse/twitter/Twitter$1$1$1:val$callback	Lcom/parse/internal/AsyncCallback;
                  //   16: aload_0
                  //   17: getfield 62	com/parse/twitter/Twitter$1$1$1:error	Ljava/lang/Throwable;
                  //   20: invokeinterface 78 2 0
                  //   25: aload_0
                  //   26: getfield 34	com/parse/twitter/Twitter$1$1$1:val$progress	Landroid/app/ProgressDialog;
                  //   29: invokevirtual 83	android/app/ProgressDialog:dismiss	()V
                  //   32: return
                  //   33: aload_0
                  //   34: getfield 28	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
                  //   37: invokestatic 86	com/parse/twitter/Twitter$1$1:access$0	(Lcom/parse/twitter/Twitter$1$1;)Lcom/parse/twitter/Twitter$1;
                  //   40: invokestatic 90	com/parse/twitter/Twitter$1:access$2	(Lcom/parse/twitter/Twitter$1;)Lcom/parse/twitter/Twitter;
                  //   43: aload_0
                  //   44: getfield 30	com/parse/twitter/Twitter$1$1$1:val$consumer	Lcom/parse/signpost/OAuthConsumer;
                  //   47: invokeinterface 96 1 0
                  //   52: invokevirtual 99	com/parse/twitter/Twitter:setAuthToken	(Ljava/lang/String;)V
                  //   55: aload_0
                  //   56: getfield 28	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
                  //   59: invokestatic 86	com/parse/twitter/Twitter$1$1:access$0	(Lcom/parse/twitter/Twitter$1$1;)Lcom/parse/twitter/Twitter$1;
                  //   62: invokestatic 90	com/parse/twitter/Twitter$1:access$2	(Lcom/parse/twitter/Twitter$1;)Lcom/parse/twitter/Twitter;
                  //   65: aload_0
                  //   66: getfield 30	com/parse/twitter/Twitter$1$1$1:val$consumer	Lcom/parse/signpost/OAuthConsumer;
                  //   69: invokeinterface 102 1 0
                  //   74: invokevirtual 105	com/parse/twitter/Twitter:setAuthTokenSecret	(Ljava/lang/String;)V
                  //   77: aload_0
                  //   78: getfield 28	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
                  //   81: invokestatic 86	com/parse/twitter/Twitter$1$1:access$0	(Lcom/parse/twitter/Twitter$1$1;)Lcom/parse/twitter/Twitter$1;
                  //   84: invokestatic 90	com/parse/twitter/Twitter$1:access$2	(Lcom/parse/twitter/Twitter$1;)Lcom/parse/twitter/Twitter;
                  //   87: aload_1
                  //   88: ldc 107
                  //   90: invokevirtual 113	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
                  //   93: invokevirtual 116	com/parse/twitter/Twitter:setScreenName	(Ljava/lang/String;)V
                  //   96: aload_0
                  //   97: getfield 28	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
                  //   100: invokestatic 86	com/parse/twitter/Twitter$1$1:access$0	(Lcom/parse/twitter/Twitter$1$1;)Lcom/parse/twitter/Twitter$1;
                  //   103: invokestatic 90	com/parse/twitter/Twitter$1:access$2	(Lcom/parse/twitter/Twitter$1;)Lcom/parse/twitter/Twitter;
                  //   106: aload_1
                  //   107: ldc 118
                  //   109: invokevirtual 113	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
                  //   112: invokevirtual 121	com/parse/twitter/Twitter:setUserId	(Ljava/lang/String;)V
                  //   115: aload_0
                  //   116: getfield 36	com/parse/twitter/Twitter$1$1$1:val$callback	Lcom/parse/internal/AsyncCallback;
                  //   119: aload_0
                  //   120: getfield 28	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
                  //   123: invokestatic 86	com/parse/twitter/Twitter$1$1:access$0	(Lcom/parse/twitter/Twitter$1$1;)Lcom/parse/twitter/Twitter$1;
                  //   126: invokestatic 90	com/parse/twitter/Twitter$1:access$2	(Lcom/parse/twitter/Twitter$1;)Lcom/parse/twitter/Twitter;
                  //   129: invokeinterface 124 2 0
                  //   134: aload_0
                  //   135: getfield 34	com/parse/twitter/Twitter$1$1$1:val$progress	Landroid/app/ProgressDialog;
                  //   138: invokevirtual 83	android/app/ProgressDialog:dismiss	()V
                  //   141: return
                  //   142: astore_1
                  //   143: aload_0
                  //   144: getfield 36	com/parse/twitter/Twitter$1$1$1:val$callback	Lcom/parse/internal/AsyncCallback;
                  //   147: aload_1
                  //   148: invokeinterface 78 2 0
                  //   153: aload_0
                  //   154: getfield 34	com/parse/twitter/Twitter$1$1$1:val$progress	Landroid/app/ProgressDialog;
                  //   157: invokevirtual 83	android/app/ProgressDialog:dismiss	()V
                  //   160: return
                  //   161: astore_1
                  //   162: aload_0
                  //   163: getfield 34	com/parse/twitter/Twitter$1$1$1:val$progress	Landroid/app/ProgressDialog;
                  //   166: invokevirtual 83	android/app/ProgressDialog:dismiss	()V
                  //   169: aload_1
                  //   170: athrow
                  // Local variable table:
                  //   start	length	slot	name	signature
                  //   0	171	0	this	1
                  //   0	171	1	paramAnonymous3HttpParameters	HttpParameters
                  // Exception table:
                  //   from	to	target	type
                  //   33	115	142	java/lang/Throwable
                  //   5	25	161	finally
                  //   33	115	161	finally
                  //   115	134	161	finally
                  //   143	153	161	finally
                }
                
                protected void onPreExecute()
                {
                  super.onPreExecute();
                  this.val$progress.show();
                }
              }.execute(new Void[0]);
            }
            
            public void onError(int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              this.val$callback.onFailure(new OAuth1FlowException(paramAnonymous2Int, paramAnonymous2String1, paramAnonymous2String2));
            }
          }).show();
          return;
        }
        finally
        {
          localProgressDialog.dismiss();
        }
      }
      
      protected void onPreExecute()
      {
        super.onPreExecute();
        localProgressDialog.show();
      }
    }.execute(new Void[0]);
  }
  
  public String getAuthToken()
  {
    return this.authToken;
  }
  
  public String getAuthTokenSecret()
  {
    return this.authTokenSecret;
  }
  
  public String getConsumerKey()
  {
    return this.consumerKey;
  }
  
  public String getConsumerSecret()
  {
    return this.consumerSecret;
  }
  
  public String getScreenName()
  {
    return this.screenName;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setAuthToken(String paramString)
  {
    this.authToken = paramString;
  }
  
  public void setAuthTokenSecret(String paramString)
  {
    this.authTokenSecret = paramString;
  }
  
  public void setConsumerKey(String paramString)
  {
    this.consumerKey = paramString;
  }
  
  public void setConsumerSecret(String paramString)
  {
    this.consumerSecret = paramString;
  }
  
  public void setScreenName(String paramString)
  {
    this.screenName = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public void signRequest(HttpUriRequest paramHttpUriRequest)
  {
    CommonsHttpOAuthConsumer localCommonsHttpOAuthConsumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
    localCommonsHttpOAuthConsumer.setTokenWithSecret(getAuthToken(), getAuthTokenSecret());
    try
    {
      localCommonsHttpOAuthConsumer.sign(paramHttpUriRequest);
      return;
    }
    catch (Exception paramHttpUriRequest)
    {
      throw new RuntimeException(paramHttpUriRequest);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/twitter/Twitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */