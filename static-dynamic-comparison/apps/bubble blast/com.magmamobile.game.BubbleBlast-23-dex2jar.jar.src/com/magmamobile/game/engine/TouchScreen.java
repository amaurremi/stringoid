package com.magmamobile.game.engine;

import android.view.MotionEvent;
import com.magmamobile.game.engine.ex.BaseEntity;
import com.magmamobile.game.engine.ex.Vector2D;

public final class TouchScreen
{
  public static boolean eventDown;
  public static boolean eventMoving;
  public static boolean eventUp;
  public static boolean pressed;
  public static long pt;
  public static int px;
  public static int py;
  public static int x;
  public static int y;
  
  public static int BufferToScreenX(int paramInt)
  {
    return (int)(paramInt * Game.mDivRatioX);
  }
  
  public static int BufferToScreenY(int paramInt)
  {
    return (int)(paramInt * Game.mDivRatioY);
  }
  
  public static int ScreenToBufferX(float paramFloat)
  {
    return (int)(Game.mMulRatioX * paramFloat);
  }
  
  public static int ScreenToBufferY(float paramFloat)
  {
    return (int)(Game.mMulRatioY * paramFloat);
  }
  
  protected static void clear()
  {
    eventMoving = false;
    eventDown = false;
    eventUp = false;
  }
  
  protected static boolean ev(MotionEvent paramMotionEvent)
  {
    Game.onJoypadEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      try
      {
        Thread.sleep(8L);
        return true;
      }
      catch (InterruptedException paramMotionEvent) {}
      x = (int)(paramMotionEvent.getX() * Game.mMulRatioX);
      y = (int)(paramMotionEvent.getY() * Game.mMulRatioY);
      px = x;
      py = y;
      pt = Game.tick;
      pressed = true;
      eventDown = true;
      if (Game._touchmode == 1)
      {
        Game.getCurrentStage().onTouchEvent(1, x, y);
        continue;
        x = (int)(paramMotionEvent.getX() * Game.mMulRatioX);
        y = (int)(paramMotionEvent.getY() * Game.mMulRatioY);
        pressed = true;
        eventMoving = true;
        if (Game._touchmode == 1)
        {
          Game.getCurrentStage().onTouchEvent(2, x, y);
          continue;
          pressed = false;
          eventDown = false;
          eventMoving = false;
          eventUp = true;
          if (Game._touchmode == 1) {
            Game.getCurrentStage().onTouchEvent(3, x, y);
          }
        }
      }
    }
    return true;
  }
  
  public static boolean isIn(int paramInt1, int paramInt2, int paramInt3)
  {
    return MathUtils.PtInRect(paramInt1 - paramInt3, paramInt2 - paramInt3, paramInt1 + paramInt3, paramInt2 + paramInt3, x, y);
  }
  
  public static boolean isIn(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return MathUtils.PtInRect(paramInt1 - paramInt3, paramInt2 - paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4, x, y);
  }
  
  public static boolean isInRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return MathUtils.PtInRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, x, y);
  }
  
  protected static void reset()
  {
    x = 0;
    y = 0;
    px = 0;
    py = 0;
    pt = 0L;
    pressed = false;
    eventMoving = false;
    eventDown = false;
    eventUp = false;
  }
  
  public static boolean touch(int paramInt1, int paramInt2, int paramInt3)
  {
    if (eventDown) {
      return MathUtils.PtInRect(paramInt1 - paramInt3, paramInt2 - paramInt3, paramInt1 + paramInt3, paramInt2 + paramInt3, x, y);
    }
    return false;
  }
  
  public static boolean touch(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (eventDown) {
      return MathUtils.PtInRect(paramInt1, paramInt2, paramInt3, paramInt4, x, y);
    }
    return false;
  }
  
  public static final boolean touch(BaseEntity paramBaseEntity)
  {
    if (!eventDown) {}
    while ((px < paramBaseEntity.pos.x) || (py < paramBaseEntity.pos.y) || (py >= paramBaseEntity.pos.x + paramBaseEntity.size.x) || (py >= paramBaseEntity.pos.y + paramBaseEntity.size.y)) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/TouchScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */