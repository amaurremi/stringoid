package com.magmamobile.game.engine;

import android.graphics.Paint;
import android.view.MotionEvent;

public class JoypadButton
  extends Joypad
{
  private Paint paint = new Paint();
  
  public JoypadButton()
  {
    this(Game.getBufferWidth() - Game.scalei(42), Game.getBufferHeight() - Game.scalei(74), Game.scalei(32));
  }
  
  public JoypadButton(int paramInt1, int paramInt2, int paramInt3)
  {
    this.paint.setColor(Integer.MIN_VALUE);
    this.r = paramInt3;
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  protected void JoyDown(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    if (hit(paramInt1, paramInt2)) {
      this.p += 1;
    }
  }
  
  protected void JoyUp(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    if (this.p > 0)
    {
      if (!hit(paramInt1, paramInt2)) {
        break label39;
      }
      this.p -= 1;
      if (this.p < 0) {
        this.p = 0;
      }
    }
    label39:
    while (hasPointerOnIt(paramMotionEvent)) {
      return;
    }
    this.p = 0;
  }
  
  public void onRender()
  {
    if (isPressed())
    {
      this.paint.setAlpha(128);
      Game.drawCircle(this.x, this.y, this.r, this.paint);
      return;
    }
    this.paint.setAlpha(48);
    Game.drawCircle(this.x, this.y, this.r, this.paint);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/JoypadButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */