package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;

public abstract interface ChallengeControllerObserver
  extends RequestControllerObserver
{
  @PublishedFor__1_0_0
  public abstract void onCannotAcceptChallenge(ChallengeController paramChallengeController);
  
  @PublishedFor__1_0_0
  public abstract void onCannotRejectChallenge(ChallengeController paramChallengeController);
  
  @PublishedFor__1_0_0
  public abstract void onInsufficientBalance(ChallengeController paramChallengeController);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/ChallengeControllerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */