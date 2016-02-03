package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.controller.SocialProviderController;
import com.scoreloop.client.android.core.controller.TwitterSocialProviderController;

public class TwitterSocialProvider
  extends SocialProvider
{
  static String a = "com.twitter.v1";
  
  public Class<? extends SocialProviderController> a()
  {
    return TwitterSocialProviderController.class;
  }
  
  public String getIdentifier()
  {
    return a;
  }
  
  public boolean isUserConnected(User paramUser)
  {
    return paramUser.f() != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/TwitterSocialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */