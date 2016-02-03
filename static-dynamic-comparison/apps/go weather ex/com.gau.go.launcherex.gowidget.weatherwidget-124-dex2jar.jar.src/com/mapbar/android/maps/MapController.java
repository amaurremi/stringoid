package com.mapbar.android.maps;

import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.mapbar.map.c;

public final class MapController
  implements View.OnKeyListener
{
  private static final Transformation l = new Transformation();
  private final float[] a = { 0.0F, 0.0F };
  private final int[] b = { 0, 0 };
  private HorizPanState c = HorizPanState.c;
  private VertPanState d = VertPanState.c;
  private float e = 0.0F;
  private float f = 0.0F;
  private Animation g = null;
  private Point h = null;
  private MapView i = null;
  private Message j = null;
  private Runnable k = null;
  private boolean m = false;
  private int n = -1;
  private int o = -1;
  private volatile boolean p;
  
  MapController(MapView paramMapView)
  {
    this.i = paramMapView;
  }
  
  private void animateTo(GeoPoint paramGeoPoint, Runnable paramRunnable, Message paramMessage)
  {
    this.k = paramRunnable;
    this.j = paramMessage;
    paramGeoPoint = paramGeoPoint.getPoint();
    stopAnimation(false);
    this.i.preLoad(paramGeoPoint);
    this.h = paramGeoPoint;
    paramRunnable = this.i.getMapCenter().getPoint();
    int i1 = paramRunnable.x - paramGeoPoint.x;
    int i2 = paramRunnable.y - paramGeoPoint.y;
    i1 = (int)Math.min(Math.sqrt(i1 * i1 + i2 * i2) + 200.0D, 300.0D);
    this.g = new TranslateAnimation(paramRunnable.y / 100000.0F, paramGeoPoint.y / 100000.0F, paramRunnable.x / 100000.0F, paramGeoPoint.x / 100000.0F);
    this.g.setDuration(i1);
    this.g.startNow();
    this.g.setInterpolator(new AccelerateDecelerateInterpolator());
    this.g.initialize(0, 0, 0, 0);
    repaint();
  }
  
  private void centerMapToInternal(Point paramPoint)
  {
    this.i.setCenterPoint(paramPoint);
    repaint();
  }
  
  private float curve(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 - paramFloat1) / 8.0F + paramFloat1;
  }
  
  private boolean onKeyDown(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 19: 
      this.d = VertPanState.a;
      return true;
    case 20: 
      this.d = VertPanState.b;
      return true;
    case 21: 
      this.c = HorizPanState.a;
      return true;
    }
    this.c = HorizPanState.b;
    return true;
  }
  
  private boolean onKeyUp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 19: 
      if (this.d == VertPanState.a)
      {
        this.d = VertPanState.c;
        return true;
      }
      return false;
    case 20: 
      if (this.d == VertPanState.b)
      {
        this.d = VertPanState.c;
        return true;
      }
      return false;
    case 21: 
      if (this.c == HorizPanState.a)
      {
        this.c = HorizPanState.c;
        return true;
      }
      return false;
    }
    if (this.c == HorizPanState.b)
    {
      this.c = HorizPanState.c;
      return true;
    }
    return false;
  }
  
  public final void animateTo(GeoPoint paramGeoPoint)
  {
    animateTo(paramGeoPoint, null, null);
  }
  
  public final void animateTo(GeoPoint paramGeoPoint, Message paramMessage)
  {
    animateTo(paramGeoPoint, null, paramMessage);
  }
  
  public final void animateTo(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    animateTo(paramGeoPoint, paramRunnable, null);
  }
  
  final void clean()
  {
    this.p = false;
  }
  
  final int[] getDeltas()
  {
    this.e = 0.0F;
    this.f = 0.0F;
    this.b[0] = 0;
    this.b[1] = 0;
    return this.b;
  }
  
  final boolean isDirty()
  {
    return this.p;
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getAction())
    {
    default: 
      throw new IllegalArgumentException("Unknown key action: " + paramKeyEvent.getAction());
    case 0: 
      if (onKeyDown(paramInt))
      {
        repaint();
        return true;
      }
      return false;
    }
    if (onKeyUp(paramInt))
    {
      repaint();
      return true;
    }
    return false;
  }
  
  final void onMeasure()
  {
    if (!this.m)
    {
      this.m = true;
      if (this.n >= 0) {
        zoomToSpan(this.n, this.o);
      }
    }
  }
  
  final void repaint()
  {
    this.p = true;
    this.i.postInvalidate();
  }
  
  public final void scrollBy(int paramInt1, int paramInt2)
  {
    stopAnimation(false);
    centerMapToInternal(this.i.toCenterPoint(paramInt1, paramInt2));
  }
  
  final void scrollByTrackball(int paramInt1, int paramInt2)
  {
    if ((this.g != null) && (AnimationUtils.currentAnimationTimeMillis() - this.g.getStartTime() < 250L)) {
      return;
    }
    scrollBy(paramInt1, paramInt2);
  }
  
  public final void setCenter(GeoPoint paramGeoPoint)
  {
    centerMapToInternal(paramGeoPoint.getPoint());
  }
  
  public final int setZoom(int paramInt)
  {
    paramInt = Math.min(22, Math.max(0, paramInt));
    zoomTo(c.a(paramInt));
    return paramInt;
  }
  
  final boolean stepAnimation(long paramLong)
  {
    Object localObject = getDeltas();
    if ((localObject[0] != 0) || (localObject[1] != 0))
    {
      scrollBy(localObject[0], localObject[1]);
      return true;
    }
    if (this.g != null)
    {
      localObject = l;
      ((Transformation)localObject).clear();
      if (this.g.getTransformation(paramLong, (Transformation)localObject))
      {
        this.a[0] = 0.0F;
        this.a[1] = 0.0F;
        ((Transformation)localObject).getMatrix().mapPoints(this.a);
        centerMapToInternal(new Point((int)(this.a[1] * 100000.0D), (int)(this.a[0] * 100000.0D)));
        return true;
      }
      centerMapToInternal(this.h);
      this.h = null;
      this.g = null;
      if (this.j != null)
      {
        this.j.sendToTarget();
        this.j = null;
      }
      if (this.k != null)
      {
        this.i.post(this.k);
        this.k = null;
      }
      return false;
    }
    return false;
  }
  
  public final void stopAnimation(boolean paramBoolean)
  {
    if ((this.g == null) || (paramBoolean)) {}
    synchronized (this.i)
    {
      centerMapToInternal(this.h);
      this.g = null;
      this.h = null;
      this.j = null;
      return;
    }
  }
  
  public final void stopPanning()
  {
    this.c = HorizPanState.c;
    this.d = VertPanState.c;
  }
  
  public final boolean zoomIn()
  {
    return this.i.doZoom(true);
  }
  
  public final boolean zoomInFixing(int paramInt1, int paramInt2)
  {
    return this.i.doZoom(true, paramInt1, paramInt2);
  }
  
  public final boolean zoomOut()
  {
    return this.i.doZoom(false);
  }
  
  public final boolean zoomOutFixing(int paramInt1, int paramInt2)
  {
    return this.i.doZoom(false, paramInt1, paramInt2);
  }
  
  final void zoomTo(c paramc)
  {
    this.i.setZoom(paramc);
    repaint();
  }
  
  public final void zoomToSpan(int paramInt1, int paramInt2)
  {
    if (this.m)
    {
      this.i.zoomToSpan(paramInt1, paramInt2);
      repaint();
      return;
    }
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  static enum HorizPanState
  {
    private HorizPanState() {}
    
    public static final HorizPanState[] Values()
    {
      return (HorizPanState[])values().clone();
    }
  }
  
  static enum VertPanState
  {
    private VertPanState() {}
    
    public static final VertPanState[] Values()
    {
      return (VertPanState[])values().clone();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/MapController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */