package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.LinearLayout.LayoutParams;
import com.go.gl.view.GLLayoutInflater;
import com.go.gl.view.GLRelativeLayout;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gowidget.core.IGoWidget3D;
import com.go.gowidget.core.WidgetCallback;

public class Base
  extends GLRelativeLayout
  implements GLView.OnLongClickListener, IGoWidget3D, y
{
  private HourlyTypeView a;
  private WeatherTrendView b;
  private e c;
  private int d = -1;
  private Context e;
  private float f;
  private VelocityTracker g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  private final long k = 10000L;
  private boolean l = false;
  private boolean m = false;
  private Handler n = new a(this);
  
  public Base(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public Base(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.a != null) {
      return;
    }
    b();
    this.a.rebuildAnimation(this.mHeight);
    e();
  }
  
  private void a(Context paramContext)
  {
    this.e = paramContext;
    b();
  }
  
  private void b()
  {
    this.a = ((HourlyTypeView)GLLayoutInflater.from(this.e).inflate(2130903242, null));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.a, localLayoutParams);
    this.a.setOnLongClickListener(this);
    if (this.b != null)
    {
      this.b.setHourlyView(this.a);
      this.a.setTrendView(this.b);
    }
  }
  
  private void c()
  {
    if (this.b != null) {
      return;
    }
    d();
    this.b.rebuildAnimation(this.mHeight);
    this.b.refreshScreenMode();
    f();
  }
  
  private void d()
  {
    this.b = ((WeatherTrendView)GLLayoutInflater.from(this.e).inflate(2130903245, null));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.b, 0, localLayoutParams);
    this.b.setOnLongClickListener(this);
    if (this.a != null)
    {
      this.b.setHourlyView(this.a);
      this.a.setTrendView(this.b);
    }
    requestLayout();
  }
  
  private void e()
  {
    this.a.setDataHandler(this.c, this);
    this.a.onStart();
  }
  
  private void f()
  {
    this.b.setDataHandler(this.c, this);
    this.b.setWidgetId(this.d);
    this.b.onStart();
  }
  
  private void g()
  {
    if ((this.h) || (this.i)) {}
    while ((this.a == null) || (this.b == null)) {
      return;
    }
    this.a.cleanup();
    removeView(this.a);
    this.b.setHourlyView(null);
    this.a = null;
  }
  
  private void h()
  {
    if ((this.h) || (this.i)) {}
    while ((this.b == null) || (this.a == null)) {
      return;
    }
    this.b.cleanup();
    this.a.setTrendView(null);
    removeView(this.b);
    this.b = null;
  }
  
  public GLView getContentView()
  {
    return this;
  }
  
  public HourlyTypeView getHourlyTypeView()
  {
    try
    {
      a();
      HourlyTypeView localHourlyTypeView = this.a;
      return localHourlyTypeView;
    }
    finally {}
  }
  
  public boolean getIfHourSwitchReady()
  {
    return !this.h;
  }
  
  public boolean getIfTrendSwitchReady()
  {
    return !this.i;
  }
  
  public WeatherTrendView getTrendView()
  {
    try
    {
      c();
      WeatherTrendView localWeatherTrendView = this.b;
      return localWeatherTrendView;
    }
    finally {}
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public boolean onActivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    return false;
  }
  
  public void onClearMemory() {}
  
  public boolean onDeactivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onDelete()
  {
    this.c.a(this.d);
  }
  
  public void onEnter()
  {
    this.a.onEnter();
  }
  
  public void onHourlyViewHide()
  {
    this.j = false;
    this.h = false;
    this.n.removeMessages(0);
    this.n.sendEmptyMessageDelayed(0, 10000L);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    switch (i1)
    {
    case 1: 
    default: 
    case 2: 
      do
      {
        return false;
        i1 = getTouchSlop();
      } while ((int)Math.abs(this.f - f1) <= i1);
      return true;
    }
    this.f = f1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b != null) {
      this.b.refreshScreenMode();
    }
  }
  
  public void onLeave() {}
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return false;
  }
  
  public void onRemove()
  {
    if (this.c != null) {
      this.c.e();
    }
    if (this.b != null) {
      this.b.cleanup();
    }
    if (this.a != null) {
      this.a.cleanup();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.rebuildAnimation(paramInt2);
    }
    if (this.b != null)
    {
      this.b.rebuildAnimation(paramInt2);
      this.b.refreshScreenMode();
    }
  }
  
  public void onStart(Bundle paramBundle)
  {
    this.d = paramBundle.getInt("gowidget_Id");
    if (this.c == null) {
      this.c = new e(this.e, this.d, this, false);
    }
    if (this.a != null) {
      e();
    }
    if (this.b != null) {
      f();
    }
    this.m = true;
  }
  
  public void onStop() {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.m) {}
    int i1;
    float f1;
    do
    {
      do
      {
        return true;
        if (this.g == null) {
          this.g = VelocityTracker.obtain();
        }
        this.g.addMovement(paramMotionEvent);
        switch (paramMotionEvent.getAction())
        {
        case 2: 
        default: 
          return true;
        case 0: 
          this.f = paramMotionEvent.getY();
          return true;
        }
      } while ((this.l) || (this.h) || (this.i) || (this.h));
      VelocityTracker localVelocityTracker = this.g;
      localVelocityTracker.computeCurrentVelocity(1000);
      i1 = (int)localVelocityTracker.getYVelocity();
      f1 = paramMotionEvent.getY() - this.f;
      if (((i1 > 600) || (f1 > getHeight() / 4)) && (this.b != null) && (this.b.isVisible()) && (!this.h) && (!this.i))
      {
        this.n.removeMessages(0);
        try
        {
          a();
          this.j = true;
          this.i = true;
          this.a.startAppearAnimation();
          this.b.startDisppearAnimation();
          return true;
        }
        finally {}
      }
    } while (((i1 >= 64936) && (f1 >= -getHeight() / 4)) || (this.a == null) || (!this.a.isVisible()) || (this.i));
    this.n.removeMessages(0);
    try
    {
      c();
      this.h = true;
      this.b.startAppearAnimation();
      this.a.startDisppearAnimation();
      return true;
    }
    finally {}
  }
  
  public void onTrendViewHide()
  {
    this.j = true;
    this.i = false;
    this.n.removeMessages(0);
    this.n.sendEmptyMessageDelayed(0, 10000L);
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setDrawingCacheEnabled(paramBoolean);
    }
    if (this.b != null) {
      this.b.setDrawingCacheEnabled(paramBoolean);
    }
    super.setDrawingCacheEnabled(paramBoolean);
  }
  
  public void setHourDisappearStart()
  {
    this.h = true;
  }
  
  public void setTrendDisappearStart()
  {
    this.i = true;
  }
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */