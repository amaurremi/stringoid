package com.pocket.oauth;

import android.content.Context;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.e;
import org.apache.a.c.k;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

public class q
  extends o
{
  public static boolean c = false;
  private static Twitter d;
  
  public q(Context paramContext)
  {
    super(paramContext, "Q3EvVAsxIj6cXymHJeTZNw", "6JvXlx92AI07kcgqQzrWN7hOhubHrvWEYUuhcs7DE", "https://api.twitter.com/oauth/request_token", "https://api.twitter.com/oauth/authorize", "https://api.twitter.com/oauth/access_token", 2131493541, a.bu, a.bv);
  }
  
  public static Twitter a(Context paramContext)
  {
    if (d == null) {
      b(paramContext);
    }
    return d;
  }
  
  public static void b(Context paramContext)
  {
    Object localObject = new q(paramContext);
    if ((localObject != null) && (((q)localObject).d() != null))
    {
      paramContext = new ConfigurationBuilder();
      paramContext.setUseSSL(true);
      AccessToken localAccessToken = new AccessToken(((q)localObject).d(), ((q)localObject).e());
      d = new TwitterFactory(paramContext.build()).getInstance();
      d.setOAuthConsumer(((q)localObject).f(), ((q)localObject).g());
      d.setOAuthAccessToken(localAccessToken);
      c = false;
      return;
    }
    localObject = new ConfigurationBuilder();
    ((ConfigurationBuilder)localObject).setUseSSL(true);
    ((ConfigurationBuilder)localObject).setApplicationOnlyAuthEnabled(true);
    d = new TwitterFactory(((ConfigurationBuilder)localObject).build()).getInstance();
    d.setOAuthConsumer("Q3EvVAsxIj6cXymHJeTZNw", "6JvXlx92AI07kcgqQzrWN7hOhubHrvWEYUuhcs7DE");
    localObject = h();
    if (!k.c((CharSequence)localObject)) {
      d.setOAuth2Token(new OAuth2Token("bearer", (String)localObject));
    }
    for (;;)
    {
      c = true;
      return;
      try
      {
        c(d.getOAuth2Token().getAccessToken());
      }
      catch (TwitterException localTwitterException)
      {
        e.a(localTwitterException);
      }
      if ((localTwitterException.getStatusCode() == 401) && (localTwitterException.getErrorCode() == 89)) {
        c(paramContext);
      }
    }
  }
  
  public static void c(Context paramContext)
  {
    c("");
    c = false;
    b(paramContext);
  }
  
  private static void c(String paramString)
  {
    i.b().a(a.bw, paramString).a();
  }
  
  public static void d(Context paramContext)
  {
    i.b().a(a.bu, null).a(a.bv, null).a();
    d = null;
    b(paramContext);
  }
  
  private static String h()
  {
    return i.a(a.bw);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */