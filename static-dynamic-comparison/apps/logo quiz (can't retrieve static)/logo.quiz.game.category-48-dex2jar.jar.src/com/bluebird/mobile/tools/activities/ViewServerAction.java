package com.bluebird.mobile.tools.activities;

import android.app.Activity;

public class ViewServerAction
  extends BaseActivityAction
{
  public ViewServerAction(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void onDestroyAction()
  {
    ViewServer.get(getActivity()).removeWindow(getActivity());
  }
  
  public void onResumeAction()
  {
    ViewServer.get(getActivity()).setFocusedWindow(getActivity());
  }
  
  public void onStartAction()
  {
    ViewServer.get(getActivity()).addWindow(getActivity());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/activities/ViewServerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */