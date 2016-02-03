package com.magmamobile.game.BubbleBlast.engine;

import com.magmamobile.game.engine.Sprite;

public class BubbleUtils
{
  public static int setBitmapAnim(Sprite paramSprite, Enums.enumBubbleState paramenumBubbleState, int paramInt)
  {
    switch (paramenumBubbleState)
    {
    default: 
      return paramInt;
    case big: 
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        paramSprite.setBitmap(5);
        return paramInt + 1;
      case 1: 
        paramSprite.setBitmap(6);
        return paramInt + 1;
      case 2: 
        paramSprite.setBitmap(7);
        return paramInt + 1;
      case 3: 
        paramSprite.setBitmap(6);
        return paramInt + 1;
      case 4: 
        paramSprite.setBitmap(5);
        return paramInt + 1;
      case 5: 
        paramSprite.setBitmap(8);
        return paramInt + 1;
      case 6: 
        paramSprite.setBitmap(9);
        return paramInt + 1;
      case 7: 
        paramSprite.setBitmap(8);
        return paramInt + 1;
      }
      paramSprite.setBitmap(5);
      return 0;
    case medium: 
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        paramSprite.setBitmap(27);
        return paramInt + 1;
      case 1: 
        paramSprite.setBitmap(28);
        return paramInt + 1;
      case 2: 
        paramSprite.setBitmap(29);
        return paramInt + 1;
      case 3: 
        paramSprite.setBitmap(30);
        return paramInt + 1;
      case 4: 
        paramSprite.setBitmap(31);
        return paramInt + 1;
      case 5: 
        paramSprite.setBitmap(32);
        return paramInt + 1;
      case 6: 
        paramSprite.setBitmap(31);
        return paramInt + 1;
      case 7: 
        paramSprite.setBitmap(30);
        return paramInt + 1;
      case 8: 
        paramSprite.setBitmap(29);
        return paramInt + 1;
      }
      paramSprite.setBitmap(28);
      return 0;
    case micro: 
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        paramSprite.setBitmap(11);
        return paramInt + 1;
      case 1: 
        paramSprite.setBitmap(12);
        return paramInt + 1;
      case 2: 
        paramSprite.setBitmap(13);
        return paramInt + 1;
      case 3: 
        paramSprite.setBitmap(14);
        return paramInt + 1;
      case 4: 
        paramSprite.setBitmap(15);
        return paramInt + 1;
      case 5: 
        paramSprite.setBitmap(16);
        return paramInt + 1;
      case 6: 
        paramSprite.setBitmap(15);
        return paramInt + 1;
      case 7: 
        paramSprite.setBitmap(14);
        return paramInt + 1;
      case 8: 
        paramSprite.setBitmap(13);
        return paramInt + 1;
      }
      paramSprite.setBitmap(12);
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      paramSprite.setBitmap(17);
      return paramInt + 1;
    case 1: 
      paramSprite.setBitmap(18);
      return paramInt + 1;
    case 2: 
      paramSprite.setBitmap(19);
      return paramInt + 1;
    case 3: 
      paramSprite.setBitmap(18);
      return paramInt + 1;
    case 4: 
      paramSprite.setBitmap(17);
      return paramInt + 1;
    case 5: 
      paramSprite.setBitmap(20);
      return paramInt + 1;
    case 6: 
      paramSprite.setBitmap(21);
      return paramInt + 1;
    case 7: 
      paramSprite.setBitmap(20);
      return paramInt + 1;
    }
    paramSprite.setBitmap(17);
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/BubbleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */