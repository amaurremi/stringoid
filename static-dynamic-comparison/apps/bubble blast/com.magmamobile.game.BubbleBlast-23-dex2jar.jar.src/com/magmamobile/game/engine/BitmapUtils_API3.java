package com.magmamobile.game.engine;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;

public final class BitmapUtils_API3
{
  public static final BitmapFactory.Options createOption()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    return localOptions;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/BitmapUtils_API3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */