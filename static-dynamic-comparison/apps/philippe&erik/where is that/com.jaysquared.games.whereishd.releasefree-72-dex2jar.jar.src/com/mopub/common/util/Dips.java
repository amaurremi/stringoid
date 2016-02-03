package com.mopub.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class Dips
{
  public static float asFloatPixels(float paramFloat, Context paramContext)
  {
    return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int asIntPixels(float paramFloat, Context paramContext)
  {
    return (int)(asFloatPixels(paramFloat, paramContext) + 0.5F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/Dips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */