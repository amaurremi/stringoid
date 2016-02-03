package com.bluebird.mobile.tools.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AbstractFragmentActivity
  extends FragmentActivity
{
  private List<ActivityAction> activityActions = new ArrayList();
  
  protected void addActivityAction(ActivityAction paramActivityAction)
  {
    this.activityActions.add(paramActivityAction);
  }
  
  protected void addActivityActions(List<? extends ActivityAction> paramList)
  {
    this.activityActions.addAll(paramList);
  }
  
  protected void addActivityActions(ActivityAction... paramVarArgs)
  {
    addActivityActions(Arrays.asList(paramVarArgs));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.activityActions.iterator();
    while (localIterator.hasNext()) {
      ((ActivityAction)localIterator.next()).onActivityResultAction(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    Iterator localIterator = this.activityActions.iterator();
    for (;;)
    {
      if ((!localIterator.hasNext()) || (((ActivityAction)localIterator.next()).onBackPressedAction())) {
        return;
      }
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.activityActions.iterator();
    while (localIterator.hasNext()) {
      ((ActivityAction)localIterator.next()).onDestroyAction();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    Iterator localIterator = this.activityActions.iterator();
    while (localIterator.hasNext()) {
      ((ActivityAction)localIterator.next()).onPauseAction();
    }
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    Iterator localIterator = this.activityActions.iterator();
    while (localIterator.hasNext()) {
      ((ActivityAction)localIterator.next()).onResumeAction();
    }
  }
  
  protected void onStart()
  {
    Iterator localIterator = this.activityActions.iterator();
    while (localIterator.hasNext()) {
      ((ActivityAction)localIterator.next()).onCreateAction();
    }
    super.onStart();
    localIterator = this.activityActions.iterator();
    while (localIterator.hasNext()) {
      ((ActivityAction)localIterator.next()).onStartAction();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Iterator localIterator = this.activityActions.iterator();
    while (localIterator.hasNext()) {
      ((ActivityAction)localIterator.next()).onStopAction();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/activities/AbstractFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */