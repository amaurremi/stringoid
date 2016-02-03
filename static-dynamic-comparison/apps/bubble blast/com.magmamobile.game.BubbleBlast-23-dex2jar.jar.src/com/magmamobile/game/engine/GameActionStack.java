package com.magmamobile.game.engine;

public final class GameActionStack
{
  private static final int MAX_ACTION = 16;
  private static int pointer = 0;
  private static int[] stack = new int[16];
  
  public static boolean hasData()
  {
    return pointer > 0;
  }
  
  public static int pop()
  {
    if (pointer <= 0) {
      return 0;
    }
    pointer -= 1;
    return stack[pointer];
  }
  
  public static void push(int paramInt)
  {
    if (pointer >= 16) {
      return;
    }
    stack[pointer] = paramInt;
    pointer += 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameActionStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */