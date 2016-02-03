package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;

public abstract interface SocialProviderControllerObserver
{
  @PublishedFor__1_0_0
  public abstract void didEnterInvalidCredentials(SocialProviderController paramSocialProviderController);
  
  @PublishedFor__1_0_0
  public abstract void didFail(SocialProviderController paramSocialProviderController, Throwable paramThrowable);
  
  @PublishedFor__1_0_0
  public abstract void didSucceed(SocialProviderController paramSocialProviderController);
  
  @PublishedFor__1_0_0
  public abstract void userDidCancel(SocialProviderController paramSocialProviderController);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/SocialProviderControllerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */