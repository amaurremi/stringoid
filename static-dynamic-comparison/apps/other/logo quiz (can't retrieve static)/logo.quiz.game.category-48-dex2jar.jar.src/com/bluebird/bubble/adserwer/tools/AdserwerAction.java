package com.bluebird.bubble.adserwer.tools;

import android.content.Intent;
import com.bluebird.mobile.tools.activities.ActivityAction;

public class AdserwerAction
  implements ActivityAction
{
  private Adserwer adserwer;
  
  public AdserwerAction(Adserwer paramAdserwer)
  {
    this.adserwer = paramAdserwer;
  }
  
  public void onActivityResultAction(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressedAction()
  {
    return false;
  }
  
  public void onCreateAction() {}
  
  public void onDestroyAction() {}
  
  public void onPauseAction() {}
  
  public void onResumeAction()
  {
    this.adserwer.collectPrizes();
  }
  
  public void onStartAction() {}
  
  public void onStopAction() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/bubble/adserwer/tools/AdserwerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */