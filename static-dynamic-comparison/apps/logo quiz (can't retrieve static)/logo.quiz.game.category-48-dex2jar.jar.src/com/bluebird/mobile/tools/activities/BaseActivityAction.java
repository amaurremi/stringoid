package com.bluebird.mobile.tools.activities;

import android.app.Activity;
import android.content.Intent;
import java.lang.ref.WeakReference;

public class BaseActivityAction
  implements ActivityAction
{
  private WeakReference<Activity> activity;
  
  public BaseActivityAction(Activity paramActivity)
  {
    this.activity = new WeakReference(paramActivity);
  }
  
  protected Activity getActivity()
  {
    return (Activity)this.activity.get();
  }
  
  public void onActivityResultAction(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressedAction()
  {
    return false;
  }
  
  public void onCreateAction() {}
  
  public void onDestroyAction() {}
  
  public void onPauseAction() {}
  
  public void onResumeAction() {}
  
  public void onStartAction() {}
  
  public void onStopAction() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/activities/BaseActivityAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */