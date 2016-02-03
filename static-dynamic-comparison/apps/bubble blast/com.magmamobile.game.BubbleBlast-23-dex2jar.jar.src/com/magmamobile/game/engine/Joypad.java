package com.magmamobile.game.engine;

import android.view.MotionEvent;

public abstract class Joypad
{
  protected int p;
  protected int r;
  protected boolean v = true;
  protected int x;
  protected int y;
  
  public Joypad() {}
  
  public Joypad(int paramInt1, int paramInt2, int paramInt3)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.r = paramInt3;
  }
  
  protected void JoyDown(int paramInt1, int paramInt2, MotionEvent paramMotionEvent) {}
  
  protected void JoyMove(int paramInt1, int paramInt2, MotionEvent paramMotionEvent) {}
  
  protected void JoyUp(int paramInt1, int paramInt2, MotionEvent paramMotionEvent) {}
  
  public int getRadius()
  {
    return this.r;
  }
  
  protected boolean hasPointerOnIt(MotionEvent paramMotionEvent)
  {
    if (Game.androidSDKVersion >= 5) {
      return JoypadUtils_API5.hasPointerOnIt(this, paramMotionEvent);
    }
    return JoypadUtils_API4.hasPointerOnIt(this, paramMotionEvent);
  }
  
  protected boolean hit(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= this.x - this.r) && (paramInt2 >= this.y - this.r) && (paramInt1 <= this.x + this.r) && (paramInt2 <= this.y + this.r);
  }
  
  public boolean isPressed()
  {
    return this.p > 0;
  }
  
  public void onRender() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Joypad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */