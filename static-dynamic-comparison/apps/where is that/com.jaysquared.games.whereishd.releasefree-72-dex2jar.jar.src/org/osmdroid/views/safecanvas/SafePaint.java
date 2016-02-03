package org.osmdroid.views.safecanvas;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;

public class SafePaint
  extends Paint
{
  public PathEffect setPathEffect(PathEffect paramPathEffect)
  {
    if ((paramPathEffect instanceof DashPathEffect)) {
      throw new RuntimeException("Do not use DashPathEffect. Use SafeDashPathEffect instead.");
    }
    return super.setPathEffect(paramPathEffect);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/safecanvas/SafePaint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */