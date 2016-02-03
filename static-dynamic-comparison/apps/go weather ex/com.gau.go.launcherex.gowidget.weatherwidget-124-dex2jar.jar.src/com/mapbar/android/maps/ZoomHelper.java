package com.mapbar.android.maps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.mapbar.map.c;
import java.util.ArrayList;
import java.util.List;

class ZoomHelper
{
  private final MapView a;
  private final MapController b;
  private final Transformation c = new Transformation();
  private final AnimationSet d = new AnimationSet(false);
  private final Paint e = new Paint();
  private OnZoomChangeListener f;
  private Snapshot g = null;
  private boolean h = false;
  private long i = Long.MAX_VALUE;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private ArrayList<Bitmap> p;
  
  ZoomHelper(MapView paramMapView, MapController paramMapController)
  {
    new Point();
    this.j = 300;
    this.k = 300;
    this.o = false;
    this.p = new ArrayList();
    this.a = paramMapView;
    this.b = paramMapController;
    paramMapView = this.b;
    this.e.setFilterBitmap(true);
  }
  
  private int SWN4x(int paramInt1, int paramInt2)
  {
    paramInt2 = this.j / 2;
    int i1 = this.l;
    return (paramInt1 - paramInt2) * D.a(this.n) / this.a.d + i1;
  }
  
  private int TFiU(int paramInt1, int paramInt2)
  {
    paramInt1 = this.k / 2;
    return this.m - (paramInt2 - paramInt1) * D.b(this.n) / this.a.e;
  }
  
  private void addFade()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.initialize(0, 0, 0, 0);
    localAlphaAnimation.startNow();
    this.d.addAnimation(localAlphaAnimation);
  }
  
  private void addScale()
  {
    float f1 = this.c.getMatrix().mapRadius(1.0F);
    float f2 = getScale(this.g.c, this.a.getZoom());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(f1, f2, f1, f2, this.g.d[0], this.g.d[1]);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.initialize(0, 0, 0, 0);
    localScaleAnimation.startNow();
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    this.h = false;
    this.d.getAnimations().clear();
    this.d.addAnimation(localScaleAnimation);
  }
  
  private void createSnapshot()
  {
    removeAllBitmap();
    Snapshot localSnapshot = new Snapshot(null);
    try
    {
      localSnapshot.a = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.RGB_565);
      this.p.add(localSnapshot.a);
      Canvas localCanvas = new Canvas(localSnapshot.a);
      localCanvas.drawColor((int)AnimationUtils.currentAnimationTimeMillis());
      this.a.drawMap(localCanvas, false);
      localSnapshot.c = this.a.getZoom();
      this.c.clear();
      this.g = localSnapshot;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Log.e("ZoomHelper", "OutOfMemoryError createSnapshot....");
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private Point getNewCenter(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point();
    localPoint.x = (SWN4x(paramInt1, paramInt2) * 10);
    localPoint.y = (TFiU(paramInt1, paramInt2) * 10);
    return localPoint;
  }
  
  private float getScale(c paramc1, c paramc2)
  {
    if (paramc2.b(paramc1)) {
      return paramc1.a(paramc2);
    }
    return 1.0F / paramc2.a(paramc1);
  }
  
  private void removeAllBitmap()
  {
    int i1 = this.p.size() - 1;
    while (i1 >= 0)
    {
      try
      {
        Bitmap localBitmap = (Bitmap)this.p.get(i1);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        this.p.remove(i1);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      i1 -= 1;
    }
    this.p.clear();
  }
  
  private void stepAnimation(long paramLong, PixelConverter paramPixelConverter)
  {
    this.d.getTransformation(paramLong, this.c);
    paramPixelConverter.setMatrix(this.c.getMatrix(), getScale(this.a.getZoom(), this.g.c), this.g.b, this.g.d[0], this.g.d[1]);
  }
  
  void destory()
  {
    removeAllBitmap();
    this.g = null;
  }
  
  boolean doZoom(c paramc, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.g == null) {
      createSnapshot();
    }
    PixelConverter localPixelConverter = (PixelConverter)this.a.getProjection();
    this.g.b = localPixelConverter.fromPixels(paramInt1, paramInt2);
    this.g.d[0] = paramInt1;
    this.g.d[1] = paramInt2;
    Object localObject = new Matrix();
    if (!this.c.getMatrix().invert((Matrix)localObject)) {
      Log.e("ZoomHelper", "Singular matrix " + this.c.getMatrix());
    }
    ((Matrix)localObject).mapPoints(this.g.d);
    if (this.o)
    {
      this.l = (this.g.b.getLongitudeE6() / 10);
      this.m = (this.g.b.getLatitudeE6() / 10);
      this.n = paramc.a();
      this.o = false;
      localObject = getNewCenter(this.a.getMapWidth() / 2, this.a.getMapHeight() / 2);
      this.a.setCenterPoint((Point)localObject);
    }
    this.a.zoomTo(paramc);
    if (this.f != null) {
      this.f.onZoomChanged(paramc.a());
    }
    if ((paramInt1 != this.a.getWidth() / 2) || (paramInt2 != this.a.getHeight() / 2))
    {
      paramc = localPixelConverter.toPixels(this.g.b, null, false);
      this.a.scrollBy(paramc.x - paramInt1, paramc.y - paramInt2);
    }
    addScale();
    stepAnimation(AnimationUtils.currentAnimationTimeMillis(), localPixelConverter);
    if (paramBoolean)
    {
      this.i = (AnimationUtils.currentAnimationTimeMillis() + 600L);
      return true;
    }
    this.a.preLoad();
    return true;
  }
  
  boolean doZoom(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    c localc = this.a.getZoom();
    if (paramBoolean1) {}
    for (localc = localc.b(); (localc == null) || (localc.a() > this.a.getMaxZoomLevel()); localc = localc.c())
    {
      this.o = false;
      return false;
    }
    return doZoom(localc, paramBoolean2, paramInt1, paramInt2);
  }
  
  boolean doZoomForDoubleTap(int paramInt1, int paramInt2)
  {
    this.j = (paramInt1 << 1);
    this.k = (paramInt2 << 1);
    this.o = true;
    return doZoom(true, true, paramInt1, paramInt2);
  }
  
  boolean onDraw(Canvas paramCanvas, MapView paramMapView, long paramLong)
  {
    if (this.g == null) {
      return false;
    }
    paramMapView = (PixelConverter)this.a.getProjection();
    if (!shouldDrawMap(paramLong)) {
      paramCanvas.drawARGB(255, 229, 221, 220);
    }
    if (paramLong > this.i)
    {
      this.a.preLoad();
      this.i = Long.MAX_VALUE;
    }
    stepAnimation(paramLong, paramMapView);
    this.e.setAlpha((int)(255.0F * this.c.getAlpha()));
    paramCanvas.save();
    paramCanvas.concat(this.c.getMatrix());
    Bitmap localBitmap = this.g.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {}
    try
    {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.e);
      paramCanvas.restore();
      if (this.d.hasEnded()) {
        if (this.h)
        {
          this.d.getAnimations().clear();
          paramCanvas = this.g.a;
          if ((paramCanvas == null) || (paramCanvas.isRecycled())) {}
        }
      }
      try
      {
        paramCanvas.recycle();
        this.g = null;
        this.h = false;
        paramMapView.resetMatrix();
        return true;
        if (this.g != null)
        {
          this.h = true;
          addFade();
          return true;
        }
        this.a.a.repaint();
        return true;
        return true;
      }
      catch (Exception paramCanvas)
      {
        for (;;) {}
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void setOnZoomChangeListener(OnZoomChangeListener paramOnZoomChangeListener)
  {
    this.f = paramOnZoomChangeListener;
  }
  
  boolean shouldDrawMap(long paramLong)
  {
    return (this.g == null) || (this.h) || (this.d.hasEnded());
  }
  
  private static class Snapshot
  {
    public Bitmap a;
    public GeoPoint b;
    public c c;
    public final float[] d = new float[2];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/ZoomHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */