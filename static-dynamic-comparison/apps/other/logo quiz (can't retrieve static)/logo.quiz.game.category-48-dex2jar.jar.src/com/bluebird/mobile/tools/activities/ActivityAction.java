package com.bluebird.mobile.tools.activities;

import android.content.Intent;

public abstract interface ActivityAction
{
  public abstract void onActivityResultAction(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean onBackPressedAction();
  
  public abstract void onCreateAction();
  
  public abstract void onDestroyAction();
  
  public abstract void onPauseAction();
  
  public abstract void onResumeAction();
  
  public abstract void onStartAction();
  
  public abstract void onStopAction();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/activities/ActivityAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */