package com.magmamobile.mmusia;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import java.io.IOException;

public final class BitmapUtils
{
  public static BitmapDrawable loadDrawable(Activity paramActivity, String paramString)
    throws IOException
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() <= 3) {
      return new BitmapDrawable(paramActivity.getAssets().open(paramString));
    }
    return BitmapUtils16.loadDrawable(paramActivity, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */