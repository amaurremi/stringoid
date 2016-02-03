package com.scoreloop.client.android.core.ui;

import android.app.Activity;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.SocialProvider;
import com.scoreloop.client.android.core.utils.HTTPUtils;
import com.scoreloop.client.android.core.utils.JSONUtils;
import com.scoreloop.client.android.core.utils.Logger;
import com.scoreloop.client.android.core.utils.OAuthBuilder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class MySpaceAuthViewController
  extends AuthViewController
{
  private Activity a;
  private String b;
  private String c;
  private String d;
  private MyspaceCredentialsDialog e;
  
  public MySpaceAuthViewController(Session paramSession, AuthViewController.Observer paramObserver)
  {
    super(paramSession, paramObserver);
  }
  
  private Activity a()
  {
    return this.a;
  }
  
  private void a(Exception paramException)
  {
    this.e.dismiss();
    e().a(paramException);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    return (JSONUtils.a(paramJSONObject, "token")) && (JSONUtils.a(paramJSONObject, "tokenSecret")) && (JSONUtils.a(paramJSONObject, "userId"));
  }
  
  private HttpPut b(String paramString)
    throws MalformedURLException
  {
    OAuthBuilder localOAuthBuilder = new OAuthBuilder();
    localOAuthBuilder.a(new URL(paramString));
    localOAuthBuilder.a("73c6e22c33e14b56a329e7a19b40914c");
    return localOAuthBuilder.b("814d340412384e27b0d480add625fb4391d5cefac08e431f9797c3c9fa94caaf", null);
  }
  
  private HttpPut b(String paramString1, String paramString2, HttpPut paramHttpPut)
    throws URISyntaxException, JSONException, UnsupportedEncodingException
  {
    paramHttpPut.setHeader("Content-Type", "application/json");
    paramHttpPut.setEntity(new StringEntity(a(paramString1, paramString2).toString()));
    return paramHttpPut;
  }
  
  private void b()
  {
    this.e.dismiss();
    e().a();
  }
  
  private boolean b(JSONObject paramJSONObject)
    throws JSONException
  {
    if (!JSONUtils.a(paramJSONObject, "captcha")) {}
    do
    {
      return false;
      paramJSONObject = paramJSONObject.getJSONObject("captcha");
    } while ((!JSONUtils.a(paramJSONObject, "captchaImageUri")) || (!JSONUtils.a(paramJSONObject, "captchaGuid")));
    return true;
  }
  
  private void c(JSONObject paramJSONObject)
    throws JSONException
  {
    Logger.a("myspace response parser", "MYSPACE: valid user credentials acquired");
    Object localObject = paramJSONObject.getString("token");
    String str1 = paramJSONObject.getString("tokenSecret");
    String str2 = paramJSONObject.getString("userId");
    paramJSONObject = new JSONObject();
    paramJSONObject.put("uid", str2);
    paramJSONObject.put("token", localObject);
    paramJSONObject.put("token_secret", str1);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("myspace", paramJSONObject);
      SocialProvider.b(d().getUser(), (JSONObject)localObject);
      this.e.dismiss();
      e().c();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      throw new IllegalStateException(paramJSONObject);
    }
  }
  
  private void d(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("captcha");
    Logger.a("myspace response parser", "MYSPACE: captcha request aquired");
    String str = paramJSONObject.getString("captchaImageUri");
    this.b = paramJSONObject.getString("captchaGuid");
    paramJSONObject = new MyspaceCaptchaDialog(a(), new MyspaceCaptchaDialog.CaptchaCompletionListener()
    {
      public void a(String paramAnonymousString)
      {
        MySpaceAuthViewController.this.a(paramAnonymousString);
      }
    }, str);
    this.e.dismiss();
    paramJSONObject.show();
  }
  
  JSONObject a(String paramString1, String paramString2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("username", paramString1);
    localJSONObject.put("password", paramString2);
    return localJSONObject;
  }
  
  public void a(Activity paramActivity)
  {
    this.a = paramActivity;
    this.e = new MyspaceCredentialsDialog(a(), new MyspaceCredentialsDialog.MyspaceCredentialsListener()
    {
      public void a()
      {
        MySpaceAuthViewController.a(MySpaceAuthViewController.this).dismiss();
        MySpaceAuthViewController.this.e().d();
      }
      
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        try
        {
          MySpaceAuthViewController.this.a(paramAnonymousString1, paramAnonymousString2, MySpaceAuthViewController.a(MySpaceAuthViewController.this, "https://roa.myspace.com/roa/09/messaging/login"));
          return;
        }
        catch (MalformedURLException paramAnonymousString1)
        {
          throw new IllegalStateException(paramAnonymousString1);
        }
      }
    });
    this.e.show();
  }
  
  protected void a(String paramString)
  {
    paramString = "https://roa.myspace.com/roa/09/messaging/login/" + this.b + "/" + paramString;
    try
    {
      a(this.c, this.d, b(paramString));
      return;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  void a(String paramString1, String paramString2, HttpPut paramHttpPut)
  {
    try
    {
      this.c = paramString1;
      this.d = paramString2;
      paramString1 = new JSONObject(HTTPUtils.a(new DefaultHttpClient().execute(b(paramString1, paramString2, paramHttpPut))));
      Logger.a("myspace response parsed json:", paramString1.toString(4));
      if (a(paramString1))
      {
        c(paramString1);
        return;
      }
      if (b(paramString1))
      {
        d(paramString1);
        return;
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      a(paramString1);
      return;
      b();
      return;
    }
    catch (URISyntaxException paramString1)
    {
      a(paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      a(paramString1);
      return;
    }
    catch (ClientProtocolException paramString1)
    {
      a(paramString1);
      return;
    }
    catch (IOException paramString1)
    {
      a(paramString1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/MySpaceAuthViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */