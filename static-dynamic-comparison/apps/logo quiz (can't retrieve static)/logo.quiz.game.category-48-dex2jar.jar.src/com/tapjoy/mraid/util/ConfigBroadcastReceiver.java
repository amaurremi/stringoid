package com.tapjoy.mraid.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.mraid.controller.Display;

public class ConfigBroadcastReceiver
  extends BroadcastReceiver
{
  private int mLastOrientation;
  private Display mMraidDisplay;
  
  public ConfigBroadcastReceiver(Display paramDisplay)
  {
    this.mMraidDisplay = paramDisplay;
    this.mLastOrientation = this.mMraidDisplay.getOrientation();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
    {
      int i = this.mMraidDisplay.getOrientation();
      if (i != this.mLastOrientation)
      {
        this.mLastOrientation = i;
        this.mMraidDisplay.onOrientationChanged(this.mLastOrientation);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/util/ConfigBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */