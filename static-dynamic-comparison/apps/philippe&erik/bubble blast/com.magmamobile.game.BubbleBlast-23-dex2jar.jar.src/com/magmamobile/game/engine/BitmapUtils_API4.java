package com.magmamobile.game.engine;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build;

public final class BitmapUtils_API4
{
  public static final BitmapFactory.Options createOption()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPurgeable = false;
    localOptions.inDither = false;
    localOptions.inScaled = false;
    localOptions.inInputShareable = true;
    localOptions.inScreenDensity = 0;
    localOptions.inTargetDensity = 0;
    localOptions.inDensity = 0;
    int i = Game.getColorMode();
    if (i == 2)
    {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return localOptions;
    }
    if (i == 1)
    {
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      return localOptions;
    }
    if (("GT-I9000".equals(Build.MODEL)) || ("SGH-T959".equals(Build.MODEL)) || ("SCH-I500".equals(Build.MODEL)) || ("SAMSUNG-SGH-I897".equals(Build.MODEL)) || ("Droid".equals(Build.MODEL)) || ("Milestone".equals(Build.MODEL)) || ("Archos5".equals(Build.MODEL)))
    {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return localOptions;
    }
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    return localOptions;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/BitmapUtils_API4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */