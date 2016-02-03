package org.osmdroid.views.safecanvas;

import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathDashPathEffect.Style;

public class SafeDashPathEffect
  extends PathDashPathEffect
{
  public SafeDashPathEffect(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    super(createSafeDashedPath(paramArrayOfFloat, paramFloat1, paramFloat2, null), floatSum(paramArrayOfFloat), paramFloat1, PathDashPathEffect.Style.MORPH);
  }
  
  public static Path createSafeDashedPath(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, Path paramPath)
  {
    Path localPath = paramPath;
    if (paramPath == null) {
      localPath = new Path();
    }
    localPath.reset();
    localPath.moveTo(0.0F, 0.0F);
    int i = 0;
    if (i < paramArrayOfFloat.length)
    {
      if (i % 2 == 0)
      {
        localPath.rMoveTo(0.0F, paramFloat2 / 2.0F);
        localPath.rLineTo(paramArrayOfFloat[i], 0.0F);
        localPath.rLineTo(0.0F, -paramFloat2);
        localPath.rLineTo(-paramArrayOfFloat[i], 0.0F);
        localPath.rLineTo(0.0F, paramFloat2 / 2.0F);
        localPath.rMoveTo(paramArrayOfFloat[i], 0.0F);
      }
      for (;;)
      {
        i += 1;
        break;
        localPath.rMoveTo(paramArrayOfFloat[i], 0.0F);
      }
    }
    return localPath;
  }
  
  private static float floatSum(float[] paramArrayOfFloat)
  {
    float f = 0.0F;
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      f += paramArrayOfFloat[i];
      i += 1;
    }
    return f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/safecanvas/SafeDashPathEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */