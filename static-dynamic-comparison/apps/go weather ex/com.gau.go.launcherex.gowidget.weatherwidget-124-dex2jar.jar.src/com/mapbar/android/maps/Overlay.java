package com.mapbar.android.maps;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract class Overlay
{
  protected static final float SHADOW_X_SKEW = -0.9F;
  protected static final float SHADOW_Y_SCALE = 0.5F;
  
  protected static void drawAt(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 > 16000) || (paramInt2 > 16000) || (paramInt1 < 49536) || (paramInt2 < 49536)) {
      return;
    }
    if (paramBoolean) {
      paramDrawable.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    if (paramBoolean)
    {
      paramCanvas.skew(-0.9F, 0.0F);
      paramCanvas.scale(1.0F, 0.5F);
    }
    paramDrawable.draw(paramCanvas);
    if (paramBoolean) {
      paramDrawable.clearColorFilter();
    }
    paramCanvas.restore();
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean) {}
  
  public boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong)
  {
    draw(paramCanvas, paramMapView, paramBoolean);
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public static abstract interface Snappable
  {
    public abstract boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, MapView paramMapView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/Overlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */