package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;

public class WatermarkPreview
  extends ViewGroup
{
  private final SparseArray a = new SparseArray();
  private WeatherBean b = null;
  private com.gau.go.launcherex.gowidget.weather.model.q c;
  private boolean d = false;
  private final PointF e = new PointF();
  
  public WatermarkPreview(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public WatermarkPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public WatermarkPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(an paraman)
  {
    removeAllViews();
    addView(paraman.d());
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      an localan = (an)localView.getTag();
      int i = localView.getLeft();
      int j = getScrollX();
      int k = localView.getTop();
      int m = getScrollY();
      int n = localView.getLeft();
      int i1 = localan.i();
      int i2 = getScrollX();
      int i3 = localView.getTop();
      int i4 = localan.j();
      int i5 = getScrollY();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      return (f1 > i - j) && (f1 < n + i1 - i2) && (f2 > k - m) && (f2 < i4 + i3 - i5);
    }
    return false;
  }
  
  private an b(int paramInt)
  {
    an localan2 = (an)this.a.get(paramInt);
    an localan1 = localan2;
    if (localan2 == null)
    {
      localan1 = an.a(getContext(), paramInt);
      localan1.a(this.b, this.c);
      this.a.append(paramInt, localan1);
    }
    return localan1;
  }
  
  private void b()
  {
    e locale = c.a(getContext().getApplicationContext()).f();
    this.b = m.b().b();
    this.c = locale.a();
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    an localan;
    float f1;
    float f2;
    float f4;
    float f5;
    float f3;
    if (getChildCount() > 0)
    {
      localan = (an)getChildAt(0).getTag();
      localan.a(true);
      f1 = paramMotionEvent.getX();
      f2 = this.e.x;
      f4 = paramMotionEvent.getY();
      f5 = this.e.y;
      f3 = localan.f() + (f1 - f2) / getWidth();
      f2 = (getWidth() - localan.i()) * 1.0F / getWidth();
      f1 = f3;
      if (f3 < 0.0F) {
        f1 = 0.0F;
      }
      if (f1 <= f2) {
        break label192;
      }
      f1 = f2;
    }
    label192:
    for (;;)
    {
      localan.a(f1);
      f1 = localan.g();
      f3 = (f4 - f5) / getHeight() + f1;
      f2 = (getHeight() - localan.j()) * 1.0F / getHeight();
      f1 = f3;
      if (f3 < 0.0F) {
        f1 = 0.0F;
      }
      if (f1 > f2) {
        f1 = f2;
      }
      for (;;)
      {
        localan.b(f1);
        c();
        return;
      }
    }
  }
  
  private void c()
  {
    if (getChildCount() > 0)
    {
      an localan = (an)getChildAt(0).getTag();
      int i = (int)(getWidth() * localan.f());
      float f = getHeight();
      int j = (int)(localan.g() * f);
      scrollTo(-i, -j);
    }
  }
  
  public ao a()
  {
    if (getChildCount() > 0) {
      return ((an)getChildAt(0).getTag()).a();
    }
    return new ac(getContext()).a();
  }
  
  public void a(int paramInt)
  {
    a(b(paramInt));
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    an localan = (an)paramView.getTag();
    paramCanvas.save();
    paramCanvas.scale(localan.f, localan.f);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restore();
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
      ((an)localView.getTag()).a(getWidth(), getHeight());
      paramInt1 += 1;
    }
    c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChildren(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 0));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool2 = this.d;
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = super.onTouchEvent(paramMotionEvent);
      }
      return bool1;
      this.d = a(paramMotionEvent);
      this.e.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      if (this.d) {
        b(paramMotionEvent);
      }
      this.e.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.d = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/WatermarkPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */