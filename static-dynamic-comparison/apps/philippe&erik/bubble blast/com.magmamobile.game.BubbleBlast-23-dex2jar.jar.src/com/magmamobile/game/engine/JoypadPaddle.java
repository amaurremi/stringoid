package com.magmamobile.game.engine;

import android.graphics.Paint;
import android.view.MotionEvent;

public class JoypadPaddle
  extends Joypad
{
  protected int dx;
  protected int dy;
  private Paint paint1 = new Paint();
  private Paint paint2;
  private int pr;
  
  public JoypadPaddle()
  {
    this(Game.scalei(74), Game.getBufferHeight() - Game.scalei(74), Game.scalei(64));
  }
  
  public JoypadPaddle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.paint1.setColor(Integer.MIN_VALUE);
    this.paint2 = new Paint();
    this.paint2.setColor(-2130706433);
    this.pr = ((int)(paramInt3 * 0.1D));
    this.r = paramInt3;
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  protected void JoyDown(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    if (hit(paramInt1, paramInt2))
    {
      this.p += 1;
      this.dx = (paramInt1 - this.x);
      this.dy = (paramInt2 - this.y);
    }
  }
  
  protected void JoyMove(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    if (hit(paramInt1, paramInt2))
    {
      this.dx = (paramInt1 - this.x);
      this.dy = (paramInt2 - this.y);
      if (this.p == 0) {
        this.p = 1;
      }
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
  
  public float getDirLength()
  {
    return (float)Math.sqrt(this.dx * this.dx + this.dy * this.dy);
  }
  
  public int getDirX()
  {
    return this.dx;
  }
  
  public int getDirY()
  {
    return this.dy;
  }
  
  public void onRender()
  {
    if (isPressed())
    {
      this.paint1.setAlpha(128);
      this.paint2.setAlpha(128);
      Game.drawCircle(this.x, this.y, this.r, this.paint1);
      Game.drawCircle(this.x + this.dx, this.y + this.dy, this.pr, this.paint2);
      return;
    }
    this.paint1.setAlpha(48);
    this.paint2.setAlpha(48);
    Game.drawCircle(this.x, this.y, this.r, this.paint1);
    Game.drawCircle(this.x + this.dx, this.y + this.dy, this.pr, this.paint2);
  }
  
  public void release()
  {
    this.p = 0;
    this.dx = 0;
    this.dy = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/JoypadPaddle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */