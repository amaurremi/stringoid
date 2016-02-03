package com.mapbar.android.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MultiTouchHelper
{
  private static int B = 1;
  private static int C = 1;
  private static int D = 1;
  private Method A = null;
  private final MapView a;
  private Context b;
  private final MapController c;
  private final Paint d = new Paint();
  private final Transformation e = new Transformation();
  private final AnimationSet f = new AnimationSet(false);
  private OnZoomChangeListener g;
  private int h = 0;
  private float i = 1.0F;
  private boolean j = false;
  private Bitmap k;
  private Matrix l = new Matrix();
  private Matrix m = new Matrix();
  private float n;
  private PointF o = new PointF();
  private int p = 300;
  private int q = 300;
  private int r;
  private int s;
  private int t;
  private ArrayList<Bitmap> u = new ArrayList();
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private Method z = null;
  
  MultiTouchHelper(MapView paramMapView, MapController paramMapController)
  {
    this.a = paramMapView;
    this.c = paramMapController;
    this.d.setFilterBitmap(true);
    this.b = paramMapView.getContext();
  }
  
  private int SWN4x(int paramInt1, int paramInt2)
  {
    paramInt2 = this.p / 2;
    int i1 = this.r;
    return (paramInt1 - paramInt2) * D.a(this.t) / this.a.d + i1;
  }
  
  private int TFiU(int paramInt1, int paramInt2)
  {
    paramInt1 = this.q / 2;
    return this.s - (paramInt2 - paramInt1) * D.b(this.t) / this.a.e;
  }
  
  private void addFade()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.initialize(0, 0, 0, 0);
    localAlphaAnimation.startNow();
    this.f.addAnimation(localAlphaAnimation);
  }
  
  private void addScale(float paramFloat1, float paramFloat2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, this.o.x, this.o.y);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.initialize(0, 0, 0, 0);
    localScaleAnimation.startNow();
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    this.w = false;
    this.f.getAnimations().clear();
    this.f.addAnimation(localScaleAnimation);
  }
  
  private void checkSDKForMulti(MotionEvent paramMotionEvent)
  {
    if (this.y) {}
    for (;;)
    {
      return;
      this.y = true;
      try
      {
        this.z = paramMotionEvent.getClass().getMethod("getX", new Class[] { Integer.TYPE });
        this.A = paramMotionEvent.getClass().getMethod("getY", new Class[] { Integer.TYPE });
        if ((this.z != null) && (this.A != null)) {
          this.x = true;
        }
        int i1 = getFieldInt(paramMotionEvent, "ACTION_MASK");
        if (i1 != 64536) {
          B = i1;
        }
        i1 = getFieldInt(paramMotionEvent, "ACTION_POINTER_UP");
        if (i1 != 64536) {
          C = i1;
        }
        i1 = getFieldInt(paramMotionEvent, "ACTION_POINTER_DOWN");
        if (i1 == 64536) {
          continue;
        }
        D = i1;
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private void continueZoom(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    this.e.getMatrix().invert(localMatrix);
    localMatrix.mapPoints(new float[] { this.o.x, this.o.y });
    addScale(paramFloat1, paramFloat2);
    stepAnimation(AnimationUtils.currentAnimationTimeMillis(), (PixelConverter)this.a.getProjection());
  }
  
  private void createMultiBitmap()
  {
    try
    {
      removeAllBitmap();
      if ((this.k == null) || (this.k.isRecycled()))
      {
        this.k = Bitmap.createBitmap(this.a.getMapWidth(), this.a.getMapHeight(), Bitmap.Config.RGB_565);
        this.u.add(this.k);
      }
      Canvas localCanvas = new Canvas(this.k);
      localCanvas.drawColor((int)AnimationUtils.currentAnimationTimeMillis());
      this.a.drawForMultiTouch(localCanvas, false);
      return;
    }
    catch (Exception localException) {}catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private float distance(MotionEvent paramMotionEvent)
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    if (this.x) {}
    for (;;)
    {
      try
      {
        if (paramMotionEvent.getPointerCount() <= 1) {
          break label265;
        }
        f1 = ((Float)this.z.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
        f3 = ((Float)this.z.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
        f1 -= f3;
        float f4;
        paramMotionEvent.printStackTrace();
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        try
        {
          f3 = ((Float)this.A.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
          f4 = ((Float)this.A.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
          f3 -= f4;
          f2 = f1;
          f1 = f3;
          f3 = f2;
          f2 = f1;
          f1 = f3;
          return FloatMath.sqrt(f1 * f1 + f2 * f2);
        }
        catch (InvocationTargetException paramMotionEvent)
        {
          int i1;
          for (;;) {}
        }
        catch (IllegalAccessException paramMotionEvent)
        {
          continue;
        }
        catch (IllegalArgumentException paramMotionEvent)
        {
          continue;
        }
        paramMotionEvent = paramMotionEvent;
        f1 = 0.0F;
        paramMotionEvent.printStackTrace();
        continue;
      }
      catch (IllegalAccessException paramMotionEvent)
      {
        f1 = 0.0F;
        paramMotionEvent.printStackTrace();
        continue;
      }
      catch (InvocationTargetException paramMotionEvent)
      {
        f1 = 0.0F;
      }
      continue;
      i1 = (int)paramMotionEvent.getSize();
      paramMotionEvent = this.b.getResources().getDisplayMetrics();
      float f1 = (i1 >> 12) * paramMotionEvent.widthPixels / 4095.0F;
      f2 = (i1 & 0xFFF) * paramMotionEvent.heightPixels / 4095.0F;
      f1 = -f1;
      f2 = -f2;
      continue;
      label265:
      f1 = 0.0F;
      f2 = f3;
    }
  }
  
  private void finishMultiTouch(MotionEvent paramMotionEvent)
  {
    int i4;
    int i5;
    float f1;
    int i1;
    int i2;
    if ((this.h == 2) && (!this.v))
    {
      i4 = this.a.getZoomLevel();
      i5 = getSegByZoom(i4);
      f1 = i5 / this.i;
      i1 = getZoomBySeg(f1);
      if (this.i >= 1.0F) {
        break label215;
      }
      i2 = -1;
      i1 -= 1;
    }
    for (;;)
    {
      float f2 = (getSegByZoom(i1) + i5) / 15.0F;
      int i3 = i1;
      if (Math.abs(i5 - f1) < f2) {
        i3 = i1 - i2;
      }
      i1 = getSegByZoom(i3);
      f1 = i5 / i1;
      this.v = true;
      continueZoom(this.i, f1);
      if (i3 != i4)
      {
        this.t = i3;
        paramMotionEvent = getNewCenter(this.a.getMapWidth() / 2, this.a.getMapHeight() / 2);
        this.a.setCenterPoint(paramMotionEvent);
      }
      this.c.setZoom(i3);
      if ((i3 != i4) && (this.g != null)) {
        this.g.onZoomChanged(i3);
      }
      return;
      label215:
      i2 = 1;
    }
  }
  
  private void getCenterPoint(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    if (this.x) {}
    for (;;)
    {
      try
      {
        if (paramMotionEvent.getPointerCount() <= 1) {
          break label288;
        }
        f1 = ((Float)this.z.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
        f3 = ((Float)this.z.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
        f1 += f3;
        float f4;
        paramMotionEvent.printStackTrace();
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        try
        {
          f3 = ((Float)this.A.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
          f4 = ((Float)this.A.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
          f3 = f4 + f3;
          f2 = f1;
          f1 = f3;
          f3 = f2;
          f2 = f1;
          f1 = f3;
          paramPointF.set(f1 / 2.0F, f2 / 2.0F);
          return;
        }
        catch (InvocationTargetException paramMotionEvent)
        {
          int i1;
          DisplayMetrics localDisplayMetrics;
          for (;;) {}
        }
        catch (IllegalAccessException paramMotionEvent)
        {
          continue;
        }
        catch (IllegalArgumentException paramMotionEvent)
        {
          continue;
        }
        paramMotionEvent = paramMotionEvent;
        f1 = 0.0F;
        paramMotionEvent.printStackTrace();
        continue;
      }
      catch (IllegalAccessException paramMotionEvent)
      {
        f1 = 0.0F;
        paramMotionEvent.printStackTrace();
        continue;
      }
      catch (InvocationTargetException paramMotionEvent)
      {
        f1 = 0.0F;
      }
      continue;
      i1 = (int)paramMotionEvent.getSize();
      localDisplayMetrics = this.b.getResources().getDisplayMetrics();
      float f1 = (i1 >> 12) * localDisplayMetrics.widthPixels / 4095.0F;
      f2 = (i1 & 0xFFF) * localDisplayMetrics.heightPixels / 4095.0F;
      f1 = paramMotionEvent.getX() * 2.0F + f1;
      f2 = paramMotionEvent.getY() * 2.0F + f2;
      continue;
      label288:
      f1 = 0.0F;
      f2 = f3;
    }
  }
  
  private int getFieldInt(MotionEvent paramMotionEvent, String paramString)
  {
    try
    {
      paramString = paramMotionEvent.getClass().getField(paramString);
      if (paramString != null)
      {
        int i1 = paramString.getInt(paramMotionEvent);
        return i1;
      }
    }
    catch (Exception paramMotionEvent) {}
    return 64536;
  }
  
  private Point getNewCenter(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point();
    localPoint.x = (SWN4x(paramInt1, paramInt2) * 10);
    localPoint.y = (TFiU(paramInt1, paramInt2) * 10);
    return localPoint;
  }
  
  private int getSegByZoom(int paramInt)
  {
    return D.b(paramInt);
  }
  
  private int getZoomBySeg(float paramFloat)
  {
    int i3 = D.a();
    int i2;
    if (paramFloat <= 80.0F)
    {
      i2 = 13;
      return i2;
    }
    int i1 = 1;
    for (;;)
    {
      if (i1 >= i3) {
        break label45;
      }
      i2 = i1;
      if (paramFloat > D.b(i1)) {
        break;
      }
      i1 += 1;
    }
    label45:
    return 0;
  }
  
  private void moveMultiTouch(MotionEvent paramMotionEvent)
  {
    if (this.h == 2)
    {
      float f1 = distance(paramMotionEvent);
      if (f1 > 10.0F)
      {
        this.l.set(this.m);
        this.i = (f1 / this.n);
        int i1 = this.a.getZoomLevel();
        if (((i1 != this.a.getMaxZoomLevel()) || (this.i <= 1.0F)) && ((i1 != 0) || (this.i >= 1.0F))) {
          break label90;
        }
        this.i = 1.0F;
      }
    }
    return;
    label90:
    this.l.postScale(this.i, this.i, this.o.x, this.o.y);
  }
  
  private void onMultiTouchForHigh(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & B;
    if (i1 == C) {
      finishMultiTouch(paramMotionEvent);
    }
    do
    {
      return;
      if (i1 == D)
      {
        startMultiTouch(paramMotionEvent);
        return;
      }
    } while (i1 != 2);
    moveMultiTouch(paramMotionEvent);
  }
  
  private void onMultiTouchForLow(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getSize();
    DisplayMetrics localDisplayMetrics = this.b.getResources().getDisplayMetrics();
    float f1 = (i1 >> 12) * localDisplayMetrics.widthPixels / 4095.0F;
    float f2 = (i1 & 0xFFF) * localDisplayMetrics.heightPixels / 4095.0F;
    if (!this.j)
    {
      if ((f1 != 0.0F) || (f2 != 0.0F)) {
        startMultiTouch(paramMotionEvent);
      }
      return;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 1: 
      finishMultiTouch(paramMotionEvent);
      return;
    }
    moveMultiTouch(paramMotionEvent);
  }
  
  private void removeAllBitmap()
  {
    int i1 = this.u.size() - 1;
    while (i1 >= 0)
    {
      try
      {
        Bitmap localBitmap = (Bitmap)this.u.get(i1);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        this.u.remove(i1);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      i1 -= 1;
    }
    this.u.clear();
  }
  
  private void startMultiTouch(MotionEvent paramMotionEvent)
  {
    if (this.h == 0)
    {
      this.n = distance(paramMotionEvent);
      if (this.n > 10.0F)
      {
        createMultiBitmap();
        this.l.reset();
        this.m.reset();
        this.m.set(this.l);
        getCenterPoint(this.o, paramMotionEvent);
        paramMotionEvent = this.a.getProjection().fromPixels((int)this.o.x, (int)this.o.y);
        this.s = (paramMotionEvent.getLatitudeE6() / 10);
        this.r = (paramMotionEvent.getLongitudeE6() / 10);
        this.p = ((int)(this.o.x * 2.0F));
        this.q = ((int)(this.o.y * 2.0F));
        this.h = 2;
        this.v = false;
        this.j = true;
        this.a.invalidate();
      }
    }
  }
  
  private void stepAnimation(long paramLong, PixelConverter paramPixelConverter)
  {
    this.f.getTransformation(paramLong, this.e);
  }
  
  void destory()
  {
    removeAllBitmap();
    this.k = null;
  }
  
  public boolean isFacing()
  {
    return this.w;
  }
  
  public boolean isMultiTouch()
  {
    return this.j;
  }
  
  boolean onDraw(Canvas paramCanvas, MapView paramMapView, long paramLong)
  {
    if (this.k == null) {
      return false;
    }
    if (!shouldDrawMap(paramLong)) {
      paramCanvas.drawARGB(255, 229, 221, 220);
    }
    if (this.v)
    {
      this.d.setAlpha((int)(255.0F * this.e.getAlpha()));
      stepAnimation(paramLong, (PixelConverter)this.a.getProjection());
      paramCanvas.save();
      paramCanvas.concat(this.e.getMatrix());
      if ((this.k == null) || (this.k.isRecycled())) {}
    }
    try
    {
      paramCanvas.drawBitmap(this.k, 0.0F, 0.0F, this.d);
      paramCanvas.restore();
      for (;;)
      {
        if ((this.v) && (this.f.hasEnded()))
        {
          this.h = 0;
          if (this.w)
          {
            this.f.getAnimations().clear();
            this.w = false;
            this.v = false;
            this.j = false;
            this.k.recycle();
            this.k = null;
            return true;
            this.d.setAlpha(255);
            paramCanvas.save();
            paramCanvas.concat(this.l);
            if ((this.k == null) || (this.k.isRecycled())) {}
          }
        }
        try
        {
          paramCanvas.drawBitmap(this.k, 0.0F, 0.0F, this.d);
          paramCanvas.restore();
          continue;
          if (this.k != null)
          {
            this.w = true;
            this.h = 0;
            addFade();
          }
          return true;
          return true;
        }
        catch (Exception paramMapView)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception paramMapView)
    {
      for (;;) {}
    }
  }
  
  public void onMultiTouch(MotionEvent paramMotionEvent)
  {
    checkSDKForMulti(paramMotionEvent);
    if (!this.x)
    {
      onMultiTouchForLow(paramMotionEvent);
      return;
    }
    onMultiTouchForHigh(paramMotionEvent);
  }
  
  public void setOnZoomChangeListener(OnZoomChangeListener paramOnZoomChangeListener)
  {
    this.g = paramOnZoomChangeListener;
  }
  
  boolean shouldDrawMap(long paramLong)
  {
    return (this.h != 2) || (this.w);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/MultiTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */