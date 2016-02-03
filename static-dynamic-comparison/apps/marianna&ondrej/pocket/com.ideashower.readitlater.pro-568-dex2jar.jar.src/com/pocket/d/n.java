package com.pocket.d;

import android.content.Context;
import com.pocket.oauth.k;
import com.pocket.oauth.q;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class n
  extends d
{
  public n(Context paramContext, b paramb)
  {
    super(paramContext, paramb, new q(paramContext));
  }
  
  public int c()
  {
    return 2131493267;
  }
  
  protected int d()
  {
    return 2130837525;
  }
  
  public String o()
  {
    return "twitter";
  }
  
  protected String r()
  {
    AccessToken localAccessToken = new AccessToken(this.i.d(), this.i.e());
    Twitter localTwitter = new TwitterFactory().getInstance();
    localTwitter.setOAuthConsumer(this.i.f(), this.i.g());
    localTwitter.setOAuthAccessToken(localAccessToken);
    return localTwitter.verifyCredentials().getOriginalProfileImageURL();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */