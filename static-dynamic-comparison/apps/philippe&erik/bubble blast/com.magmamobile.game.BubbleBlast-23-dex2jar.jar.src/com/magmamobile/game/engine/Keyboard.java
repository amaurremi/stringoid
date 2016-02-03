package com.magmamobile.game.engine;

import java.util.Arrays;

public final class Keyboard
{
  public static final byte KEY_BACK = 0;
  public static final byte KEY_DOWN = -1;
  public static final byte KEY_NONE = -1;
  public static final byte KEY_UP = 0;
  public static final byte KEY_VOLUMEDW = 2;
  public static final byte KEY_VOLUMEUP = 1;
  public static final byte STATE_DOWN = -1;
  public static final byte STATE_NONE = 0;
  public static final byte STATE_UP = 1;
  public static byte[] keys = new byte[3];
  public static byte[] state = new byte[3];
  
  static
  {
    reset();
  }
  
  public static void clear()
  {
    Arrays.fill(state, (byte)0);
  }
  
  public static boolean isDown(int paramInt)
  {
    return state[paramInt] == 1;
  }
  
  public static boolean isKeyBack()
  {
    boolean bool = false;
    if (state[0] == -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isUp(int paramInt)
  {
    return state[paramInt] == -1;
  }
  
  public static void reset()
  {
    Arrays.fill(keys, (byte)0);
    Arrays.fill(state, (byte)0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Keyboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */