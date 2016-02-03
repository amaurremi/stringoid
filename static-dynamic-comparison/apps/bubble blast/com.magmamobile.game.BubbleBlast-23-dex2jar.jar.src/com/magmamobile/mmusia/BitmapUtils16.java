package com.magmamobile.mmusia;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;

public final class BitmapUtils16
{
  public static BitmapDrawable loadDrawable(Activity paramActivity, String paramString)
    throws IOException
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localDisplay.getMetrics(localDisplayMetrics);
    localOptions.inScaled = true;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = localDisplayMetrics.densityDpi;
    return new BitmapDrawable(BitmapFactory.decodeStream(paramActivity.getAssets().open(paramString), null, localOptions));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/BitmapUtils16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */