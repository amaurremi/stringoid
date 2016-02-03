package com.magmamobile.game.engine;

import android.hardware.SensorEvent;
import android.view.MotionEvent;
import android.view.View;

public abstract interface IGameStage
{
  public abstract boolean enterOnResume();
  
  public abstract View getContentView();
  
  public abstract boolean isActive();
  
  public abstract void onAction();
  
  public abstract void onBackButton();
  
  public abstract void onCall(int paramInt);
  
  public abstract View onCreateView();
  
  public abstract void onEnter();
  
  public abstract void onInitialize();
  
  public abstract void onLateResume();
  
  public abstract void onLeave();
  
  public abstract void onRender();
  
  public abstract void onSensorEvent(SensorEvent paramSensorEvent);
  
  public abstract void onShowView();
  
  public abstract void onTerminate();
  
  public abstract void onTouchEvent(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setActive(boolean paramBoolean);
  
  public abstract void setContentView(View paramView);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/IGameStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */