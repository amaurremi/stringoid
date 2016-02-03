package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.controller.MySpaceSocialProviderController;
import com.scoreloop.client.android.core.controller.SocialProviderController;

public class MySpaceSocialProvider
  extends SocialProvider
{
  public Class<? extends SocialProviderController> a()
  {
    return MySpaceSocialProviderController.class;
  }
  
  public String getIdentifier()
  {
    return "com.myspace.v1";
  }
  
  public boolean isUserConnected(User paramUser)
  {
    return paramUser.g() != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/MySpaceSocialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */