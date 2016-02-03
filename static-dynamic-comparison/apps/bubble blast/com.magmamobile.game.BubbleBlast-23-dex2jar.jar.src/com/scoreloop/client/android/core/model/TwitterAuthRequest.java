package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.utils.HTTPUtils;
import com.scoreloop.client.android.core.utils.OAuthBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public class TwitterAuthRequest
  extends AuthRequest
{
  private JSONObject a;
  
  public TwitterAuthRequest(AuthRequestDelegate paramAuthRequestDelegate)
  {
    super(paramAuthRequestDelegate);
  }
  
  private void a(int paramInt, String paramString)
  {
    a(new IllegalStateException(new Integer(paramInt).toString() + " ; " + paramString));
  }
  
  private void a(Throwable paramThrowable)
  {
    a().a(this, paramThrowable);
  }
  
  public void a(String paramString1, String paramString2)
  {
    OAuthBuilder localOAuthBuilder = new OAuthBuilder();
    localOAuthBuilder.a("1fKnfLmiZ2hDnn3mxr1Gg");
    localOAuthBuilder.b(paramString1);
    try
    {
      localOAuthBuilder.a(new URL("http://twitter.com/oauth/access_token"));
      a(localOAuthBuilder.a("gPm0dGnuOkwLtZ8mr3y8AjUSdVjF1d0yXJFeQm0xExY", paramString2));
      return;
    }
    catch (MalformedURLException paramString1)
    {
      throw new IllegalStateException(paramString1);
    }
  }
  
  void a(HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if (i != 200)
    {
      a(i, null);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramHttpResponse = HTTPUtils.a(paramHttpResponse).split("&");
      j = paramHttpResponse.length;
      i = 0;
    }
    catch (IOException paramHttpResponse)
    {
      for (;;)
      {
        int j;
        String[] arrayOfString;
        a(0, "invalid result to token request");
        if (localJSONObject == null) {
          a(0, "invalid result to token request");
        }
        if (this.a == null) {
          break;
        }
        throw new IllegalStateException("responseParameters must be nil");
        localJSONObject.put(arrayOfString[0], arrayOfString[1]);
        i += 1;
      }
    }
    catch (JSONException paramHttpResponse)
    {
      for (;;)
      {
        a(0, "invalid result to token request");
      }
      this.a = localJSONObject;
      a().a(this);
    }
    if (i < j)
    {
      arrayOfString = paramHttpResponse[i].split("=");
      if (arrayOfString.length == 2) {
        break label119;
      }
      throw new IllegalStateException("serious error parsin twitter response, this should not happen");
    }
    label119:
  }
  
  void a(HttpResponse paramHttpResponse, Throwable paramThrowable)
  {
    a(paramThrowable);
  }
  
  public void b()
  {
    OAuthBuilder localOAuthBuilder = new OAuthBuilder();
    localOAuthBuilder.a("1fKnfLmiZ2hDnn3mxr1Gg");
    try
    {
      localOAuthBuilder.a(new URL("http://twitter.com/oauth/request_token"));
      a(localOAuthBuilder.a("gPm0dGnuOkwLtZ8mr3y8AjUSdVjF1d0yXJFeQm0xExY", null));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalStateException(localMalformedURLException);
    }
  }
  
  public String c()
  {
    try
    {
      String str = this.a.getString("oauth_token");
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException(localJSONException);
    }
  }
  
  public String d()
  {
    try
    {
      String str = this.a.getString("oauth_token_secret");
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException(localJSONException);
    }
  }
  
  public String e()
  {
    try
    {
      String str = this.a.getString("user_id");
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException(localJSONException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/TwitterAuthRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */