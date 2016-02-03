package com.vungle.publisher.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;

public abstract class BaseBitmapFactory
  implements BitmapFactory
{
  protected BitmapFactory.Options getOptions(Context paramContext)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 330;
    localOptions.inTargetDensity = ((int)(paramContext.getResources().getDisplayMetrics().density * localOptions.inDensity));
    return localOptions;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/image/BaseBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */