package com.bubble.tapjoy;

import android.content.Intent;
import com.bluebird.mobile.tools.activities.ActivityAction;

public class TapjoyAction
  implements ActivityAction
{
  private TapjoySupport tapjoySupport;
  
  public TapjoyAction(TapjoySupport paramTapjoySupport)
  {
    this.tapjoySupport = paramTapjoySupport;
  }
  
  public void onActivityResultAction(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressedAction()
  {
    return false;
  }
  
  public void onCreateAction()
  {
    this.tapjoySupport.connect();
  }
  
  public void onDestroyAction() {}
  
  public void onPauseAction()
  {
    this.tapjoySupport.onPause();
  }
  
  public void onResumeAction()
  {
    this.tapjoySupport.onResume();
  }
  
  public void onStartAction() {}
  
  public void onStopAction() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/tapjoy/TapjoyAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */