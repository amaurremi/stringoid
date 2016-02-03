package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import org.osmdroid.ResourceProxy;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.safecanvas.ISafeCanvas;
import org.osmdroid.views.safecanvas.SafeTranslatedCanvas;

public abstract class SafeDrawOverlay
  extends Overlay
{
  private static final Matrix sMatrix = new Matrix();
  private static final SafeTranslatedCanvas sSafeCanvas = new SafeTranslatedCanvas();
  private boolean mUseSafeCanvas = true;
  
  public SafeDrawOverlay(Context paramContext)
  {
    super(paramContext);
  }
  
  public SafeDrawOverlay(ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    sSafeCanvas.setCanvas(paramCanvas);
    Rect localRect;
    int i;
    int j;
    if (isUsingSafeCanvas())
    {
      localRect = paramMapView.getProjection().getScreenRect();
      sSafeCanvas.xOffset = (-localRect.left);
      sSafeCanvas.yOffset = (-localRect.top);
      paramCanvas.save();
      if (paramMapView.getMapOrientation() != 0.0F) {
        paramCanvas.rotate(-paramMapView.getMapOrientation(), localRect.exactCenterX(), localRect.exactCenterY());
      }
      i = localRect.left - localRect.left;
      j = localRect.top - localRect.top;
      if (Build.VERSION.SDK_INT >= 11)
      {
        float f1 = paramMapView.getScaleX();
        float f2 = paramMapView.getScaleY();
        paramCanvas.translate(localRect.left * f1, localRect.top * f2);
        paramCanvas.translate(i, j);
        if (paramMapView.getMapOrientation() != 0.0F) {
          sSafeCanvas.rotate(paramMapView.getMapOrientation(), localRect.exactCenterX(), localRect.exactCenterY());
        }
      }
    }
    for (;;)
    {
      drawSafe(sSafeCanvas, paramMapView, paramBoolean);
      if (isUsingSafeCanvas()) {
        paramCanvas.restore();
      }
      return;
      paramCanvas.getMatrix(sMatrix);
      sMatrix.preTranslate(localRect.left, localRect.top);
      sMatrix.preTranslate(i, j);
      paramCanvas.setMatrix(sMatrix);
      break;
      sSafeCanvas.xOffset = 0;
      sSafeCanvas.yOffset = 0;
    }
  }
  
  protected abstract void drawSafe(ISafeCanvas paramISafeCanvas, MapView paramMapView, boolean paramBoolean);
  
  public boolean isUsingSafeCanvas()
  {
    return this.mUseSafeCanvas;
  }
  
  public void setUseSafeCanvas(boolean paramBoolean)
  {
    this.mUseSafeCanvas = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/SafeDrawOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */