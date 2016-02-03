package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;

public abstract interface UserControllerObserver
  extends RequestControllerObserver
{
  @PublishedFor__1_0_0
  public abstract void onEmailAlreadyTaken(UserController paramUserController);
  
  @PublishedFor__1_0_0
  public abstract void onEmailInvalidFormat(UserController paramUserController);
  
  @PublishedFor__1_0_0
  public abstract void onUsernameAlreadyTaken(UserController paramUserController);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/UserControllerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */