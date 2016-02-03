package com.magmamobile.game.engine;

import android.view.MotionEvent;
import java.util.ArrayList;

public final class JoypadUtils_API5
{
  private static ArrayList<Joypad> joypads;
  
  static final boolean hasPointerOnIt(Joypad paramJoypad, MotionEvent paramMotionEvent)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramMotionEvent.getPointerCount()) {
        return false;
      }
      if (paramJoypad.hit((int)(paramMotionEvent.getX(i) * Game.mMulRatioX), (int)(paramMotionEvent.getY(i) * Game.mMulRatioY))) {
        return true;
      }
      i += 1;
    }
  }
  
  static final void onJoypadClear()
  {
    if (joypads == null) {
      return;
    }
    joypads.clear();
  }
  
  static final void onJoypadDown(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    if (joypads == null) {}
    for (;;)
    {
      return;
      int j = joypads.size();
      int i = 0;
      while (i < j)
      {
        ((Joypad)joypads.get(i)).JoyDown(paramInt1, paramInt2, paramMotionEvent);
        i += 1;
      }
    }
  }
  
  static final boolean onJoypadEvent(MotionEvent paramMotionEvent)
  {
    if (joypads == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (joypads.size() <= 0);
      int j = paramMotionEvent.getAction();
      i = j & 0xFF;
      j = (0xFF00 & j) >> 8;
      if (i == 0)
      {
        onJoypadDown(TouchScreen.ScreenToBufferX(paramMotionEvent.getX()), TouchScreen.ScreenToBufferY(paramMotionEvent.getY()), paramMotionEvent);
        return true;
      }
      if (i == 5)
      {
        onJoypadDown(TouchScreen.ScreenToBufferX(paramMotionEvent.getX(j)), TouchScreen.ScreenToBufferY(paramMotionEvent.getY(j)), paramMotionEvent);
        return true;
      }
      if (i == 2)
      {
        i = 0;
        for (;;)
        {
          if (i >= paramMotionEvent.getPointerCount()) {
            return true;
          }
          onJoypadMove(TouchScreen.ScreenToBufferX(paramMotionEvent.getX(i)), TouchScreen.ScreenToBufferY(paramMotionEvent.getY(i)), paramMotionEvent);
          i += 1;
        }
      }
      if (i == 6)
      {
        onJoypadUp(TouchScreen.ScreenToBufferX(paramMotionEvent.getX(j)), TouchScreen.ScreenToBufferY(paramMotionEvent.getY(j)), paramMotionEvent);
        return true;
      }
    } while ((i != 1) && (i != 3) && (i != 4));
    onJoypadUp(TouchScreen.ScreenToBufferX(paramMotionEvent.getX()), TouchScreen.ScreenToBufferY(paramMotionEvent.getY()), paramMotionEvent);
    return true;
  }
  
  static final void onJoypadInitialize()
  {
    joypads = new ArrayList();
  }
  
  static final void onJoypadMove(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    if (joypads == null) {}
    for (;;)
    {
      return;
      int j = joypads.size();
      int i = 0;
      while (i < j)
      {
        ((Joypad)joypads.get(i)).JoyMove(paramInt1, paramInt2, paramMotionEvent);
        i += 1;
      }
    }
  }
  
  static final void onJoypadSleep()
  {
    try
    {
      Thread.sleep(16L);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  static final void onJoypadUp(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    if (joypads == null) {}
    for (;;)
    {
      return;
      int j = joypads.size();
      int i = 0;
      while (i < j)
      {
        ((Joypad)joypads.get(i)).JoyUp(paramInt1, paramInt2, paramMotionEvent);
        i += 1;
      }
    }
  }
  
  static final void registerJoypad(Joypad paramJoypad)
  {
    if (joypads == null) {
      return;
    }
    joypads.add(paramJoypad);
  }
  
  static final void unregisterJoypad(Joypad paramJoypad)
  {
    if (joypads == null) {
      return;
    }
    joypads.remove(paramJoypad);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/JoypadUtils_API5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */