package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;

public abstract interface RequestControllerObserver
{
  @PublishedFor__1_0_0
  public abstract void requestControllerDidFail(RequestController paramRequestController, Exception paramException);
  
  @PublishedFor__1_0_0
  public abstract void requestControllerDidReceiveResponse(RequestController paramRequestController);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/RequestControllerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */