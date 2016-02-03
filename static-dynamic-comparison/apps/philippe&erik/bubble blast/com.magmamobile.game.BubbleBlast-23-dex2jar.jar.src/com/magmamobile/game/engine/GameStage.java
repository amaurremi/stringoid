package com.magmamobile.game.engine;

import android.hardware.SensorEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public abstract class GameStage
  implements IGameStage
{
  public static final int STATUS_CANCELED = 2;
  public static final int STATUS_DONE = 1;
  public static final int STATUS_RUNNING = 0;
  private boolean _active;
  private int _choice;
  private boolean _enabled;
  public FocusBag _foucs = new FocusBag();
  private int _id;
  private boolean _initialized;
  private int _status;
  private Object _tag;
  private View _view;
  
  public void call(int paramInt)
  {
    Game.mHandler.sendMessage(Game.mHandler.obtainMessage(3, paramInt, 0, this));
  }
  
  public void cancel()
  {
    this._status = 2;
  }
  
  public void done()
  {
    this._status = 1;
  }
  
  public boolean enterOnResume()
  {
    return true;
  }
  
  public int getChoice()
  {
    return this._choice;
  }
  
  public View getContentView()
  {
    return this._view;
  }
  
  public int getId()
  {
    return this._id;
  }
  
  public int getStatus()
  {
    return this._status;
  }
  
  public Object getTag()
  {
    return this._tag;
  }
  
  public boolean isActive()
  {
    return this._active;
  }
  
  public boolean isEnabled()
  {
    return this._enabled;
  }
  
  public boolean isInitialized()
  {
    return this._initialized;
  }
  
  public void onBackButton() {}
  
  public void onCall(int paramInt) {}
  
  public View onCreateView()
  {
    return null;
  }
  
  public void onEnter()
  {
    Game.invalidate();
    this._status = 0;
    this._enabled = true;
    this._choice = 0;
    if (useView()) {
      Game.mHandler.sendMessage(Game.mHandler.obtainMessage(5, 0, 0, this));
    }
  }
  
  public void onInitialize()
  {
    this._initialized = true;
  }
  
  public void onLateResume() {}
  
  public void onLeave()
  {
    this._enabled = false;
    if (useView()) {
      Game.mHandler.sendMessage(Game.mHandler.obtainMessage(6, 0, 0, this));
    }
  }
  
  public void onSensorEvent(SensorEvent paramSensorEvent) {}
  
  public void onShowView() {}
  
  public void onTerminate()
  {
    this._initialized = false;
  }
  
  public void onTouchEvent(int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setActive(boolean paramBoolean)
  {
    this._active = paramBoolean;
  }
  
  public void setChoice(int paramInt)
  {
    this._choice = paramInt;
  }
  
  public void setContentView(View paramView)
  {
    this._view = paramView;
  }
  
  public void setId(int paramInt)
  {
    this._id = paramInt;
  }
  
  public void setRate(GameRate paramGameRate)
  {
    Game.setRate(paramGameRate);
  }
  
  public void setStatus(int paramInt)
  {
    this._status = paramInt;
  }
  
  public void setTag(Object paramObject)
  {
    this._tag = paramObject;
  }
  
  public void startAnimation(Animation paramAnimation, Animation.AnimationListener paramAnimationListener)
  {
    if (this._view == null) {
      return;
    }
    if (paramAnimationListener != null) {
      paramAnimation.setAnimationListener(paramAnimationListener);
    }
    this._view.setAnimation(paramAnimation);
    paramAnimation.startNow();
    Game.layout.invalidate();
  }
  
  public boolean useView()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */