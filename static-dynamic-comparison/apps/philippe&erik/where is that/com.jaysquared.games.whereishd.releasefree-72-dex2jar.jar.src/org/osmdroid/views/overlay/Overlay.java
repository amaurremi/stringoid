package org.osmdroid.views.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicInteger;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapView;
import org.osmdroid.views.MapView;
import org.osmdroid.views.util.constants.OverlayConstants;

public abstract class Overlay
  implements OverlayConstants
{
  protected static final float SHADOW_X_SKEW = -0.9F;
  protected static final float SHADOW_Y_SCALE = 0.5F;
  private static final Rect mRect = new Rect();
  private static AtomicInteger sOrdinal = new AtomicInteger();
  private boolean mEnabled = true;
  protected final ResourceProxy mResourceProxy;
  protected final float mScale;
  
  public Overlay(Context paramContext)
  {
    this.mResourceProxy = new DefaultResourceProxyImpl(paramContext);
    this.mScale = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public Overlay(ResourceProxy paramResourceProxy)
  {
    this.mResourceProxy = paramResourceProxy;
    this.mScale = this.mResourceProxy.getDisplayMetricsDensity();
  }
  
  protected static void drawAt(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat)
  {
    try
    {
      paramCanvas.save();
      paramCanvas.rotate(-paramFloat, paramInt1, paramInt2);
      paramDrawable.copyBounds(mRect);
      paramDrawable.setBounds(mRect.left + paramInt1, mRect.top + paramInt2, mRect.right + paramInt1, mRect.bottom + paramInt2);
      paramDrawable.draw(paramCanvas);
      paramDrawable.setBounds(mRect);
      paramCanvas.restore();
      return;
    }
    finally
    {
      paramCanvas = finally;
      throw paramCanvas;
    }
  }
  
  protected static final int getSafeMenuId()
  {
    return sOrdinal.getAndIncrement();
  }
  
  protected static final int getSafeMenuIdSequence(int paramInt)
  {
    return sOrdinal.getAndAdd(paramInt);
  }
  
  protected abstract void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean);
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public void onDetach(MapView paramMapView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2, MapView paramMapView)
  {
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
  
  public boolean onLongPress(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2, MapView paramMapView)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent, MapView paramMapView) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent, MapView paramMapView)
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
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public static abstract interface Snappable
  {
    public abstract boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, IMapView paramIMapView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/Overlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */