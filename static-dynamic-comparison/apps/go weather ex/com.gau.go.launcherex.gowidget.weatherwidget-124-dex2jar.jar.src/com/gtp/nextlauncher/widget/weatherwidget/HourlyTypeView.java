package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import com.gau.go.launcherex.gowidget.weather.model.HourlyBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.util.a;
import com.go.gl.animation.AlphaAnimation;
import com.go.gl.animation.Animation;
import com.go.gl.animation.Animation.AnimationListener;
import com.go.gl.animation.AnimationSet;
import com.go.gl.animation.Rotate3DAnimation;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLLayoutInflater;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLImageView;
import com.go.gowidget.core.WidgetCallback;

public class HourlyTypeView
  extends GLLinearLayout
  implements Animation.AnimationListener, GLView.OnClickListener, GLView.OnLongClickListener, h
{
  private long A = 500L;
  private long B = 0L;
  private boolean C = false;
  private boolean D = false;
  private Context a;
  private int b = 0;
  private int c = -1;
  private GLLinearLayout d;
  private GLLayoutInflater e = null;
  private WeatherIcon f;
  private CityNameView g;
  private HourBottom[] h = new HourBottom[5];
  private GLDigitalClock i;
  private ProgressBar j;
  private GLImageView k;
  private GLDrawable[] l = new GLDrawable[3];
  private HourBottom m;
  String mAm = "am";
  String mPm = "pm";
  private e n;
  private WeatherTrendView o;
  private y p;
  private Animation q;
  private AnimationSet r;
  private int s = 0;
  private String t = new String();
  private a u = null;
  private Interpolator v = new w(this);
  private int w = 0;
  private final int x = 5;
  private boolean y = true;
  private float z = 1.0F;
  
  public HourlyTypeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    setBackgroundColor(-14527079);
    this.e = GLLayoutInflater.from(paramContext);
    this.d = ((GLLinearLayout)this.e.inflate(2130903242, null));
    this.d.setBackgroundColor(-11206656);
    addView(this.d);
    this.a = paramContext;
  }
  
  public HourlyTypeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.a = paramContext;
    setOnClickListener(this);
    this.u = new a();
    setHasPixelOverlayed(false);
  }
  
  private String a(int paramInt)
  {
    String str = new String();
    if (this.n.b())
    {
      if (paramInt < 10) {
        str = "0";
      }
      str = str + paramInt;
      return str + ":00";
    }
    str = this.mAm;
    if (paramInt >= 12) {
      str = this.mPm;
    }
    int i1 = paramInt;
    if (paramInt > 12) {
      i1 = paramInt % 12;
    }
    return i1 + str;
  }
  
  private void a()
  {
    Object localObject = "";
    if (this.n.i() > 0) {
      localObject = this.n.k();
    }
    for (int i1 = this.n.l();; i1 = -1)
    {
      localObject = com.gau.go.launcherex.gowidget.weather.util.p.a(getContext(), (String)localObject, true, 17, "", -1);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("gowidget_Id", this.c);
      ((Intent)localObject).putExtra("isMyLocation", i1);
      getContext().startActivity((Intent)localObject);
      return;
    }
  }
  
  private void a(float paramFloat)
  {
    this.z = paramFloat;
    if (paramFloat == 1.0F) {
      c();
    }
    invalidate();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.f.changeWeather(paramInt - 1, paramBoolean);
  }
  
  private void a(Context paramContext)
  {
    int i1 = 0;
    while (i1 < 3)
    {
      this.l[i1] = p.a(paramContext, new int[] { 2130838307, 2130838307, 2130838307 }[i1]);
      i1 += 1;
    }
  }
  
  private void a(String paramString)
  {
    this.g.changeCity(paramString);
  }
  
  private void b()
  {
    if (this.b != 5) {
      return;
    }
    Object localObject1 = this.n.p();
    float f1 = 0.0F;
    if (localObject1 != null) {
      f1 = ((NowBean)localObject1).a(e.a);
    }
    String str1 = new String();
    if (e.a == 1) {
      str1 = "°C";
    }
    label218:
    label317:
    for (;;)
    {
      if ((localObject1 == null) || (f1 == -10000.0F))
      {
        this.h[0].clearData();
        i1 = 1;
        while (i1 < 5)
        {
          localObject1 = this.n.e(i1);
          if (localObject1 != null) {
            break label218;
          }
          this.h[i1].clearData();
          i1 += 1;
        }
        break;
        if (e.a != 2) {
          break label317;
        }
        str1 = "°F";
        continue;
      }
      String str2 = (int)f1 + str1;
      boolean bool = this.n.d(this.n.t().hour);
      Object localObject2 = this.h[0];
      int i1 = ((NowBean)localObject1).d();
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        ((HourBottom)localObject2).setWeather(i1 - 1, bool, str2, this.t);
        break;
      }
      str2 = (int)((HourlyBean)localObject1).b(e.a) + str1;
      localObject2 = a(((HourlyBean)localObject1).d());
      bool = this.n.d(((HourlyBean)localObject1).d());
      HourBottom localHourBottom = this.h[i1];
      int i2 = ((HourlyBean)localObject1).e();
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        localHourBottom.setWeather(i2 - 1, bool, str2, (String)localObject2);
        break;
      }
    }
  }
  
  private void b(float paramFloat)
  {
    this.z = (1.0F - paramFloat);
    if (paramFloat == 1.0F) {
      d();
    }
    invalidate();
  }
  
  private void c()
  {
    this.C = false;
    invalidate();
  }
  
  private void d()
  {
    this.D = false;
    invalidate();
  }
  
  public void cleanup()
  {
    int i1 = 0;
    this.b = 0;
    if (this.n != null) {
      this.n.b(this);
    }
    int i2 = this.l.length;
    while (i1 < i2)
    {
      this.l[i1].clear();
      i1 += 1;
    }
    super.cleanup();
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (this.B == -1L) {
      this.B = getDrawingTime();
    }
    float f1;
    if ((this.C) || (this.D))
    {
      f1 = Math.max(0.0F, Math.min((float)(getDrawingTime() - this.B) / (float)this.A, 1.0F));
      if (!this.C) {
        break label98;
      }
      a(f1);
    }
    for (;;)
    {
      int i1 = paramGLCanvas.getAlpha();
      paramGLCanvas.setAlpha((int)(i1 * this.z));
      super.dispatchDraw(paramGLCanvas);
      paramGLCanvas.setAlpha(i1);
      return;
      label98:
      b(f1);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i1)
    {
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void endRefresh()
  {
    this.j.end();
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public boolean onActivate(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.r))
    {
      setVisibility(8);
      this.o = null;
      this.p.onHourlyViewHide();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public boolean onApplyTheme(Bundle paramBundle)
  {
    return false;
  }
  
  public void onAutoLocateFail(String paramString)
  {
    this.g.setCityName(paramString);
  }
  
  public void onClick(GLView paramGLView)
  {
    if (this.b != 5) {}
    int i2;
    label11:
    label82:
    do
    {
      do
      {
        return;
        i2 = 0;
        if ((i2 < 5) && (!paramGLView.equals(this.h[i2]))) {
          break;
        }
      } while ((i2 >= 5) || (this.h[i2].equals(this.m)));
      this.h[i2].setFoucse();
      this.m.clearFouse();
      this.s = i2;
      i1 = 2130838308;
      if (i2 != 0) {
        break label181;
      }
      i1 = 2130838307;
      this.h[i2].setBackgroundResource(i1);
      this.m.setBackgroundDrawable(null);
      this.m = this.h[i2];
      if (i2 != 0) {
        break label193;
      }
      paramGLView = this.n.p();
    } while (paramGLView == null);
    int i1 = paramGLView.d() - 1;
    boolean bool = this.n.d(this.n.t().hour);
    label152:
    paramGLView = this.f;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      paramGLView.startRotate(i2, i1, bool);
      return;
      i2 += 1;
      break label11;
      label181:
      if (i2 != 4) {
        break label82;
      }
      i1 = 2130838309;
      break label82;
      label193:
      paramGLView = this.n.e(i2);
      if (paramGLView == null) {
        break;
      }
      i1 = paramGLView.e() - 1;
      bool = this.n.d(paramGLView.d());
      break label152;
    }
  }
  
  public void onDateStyleChange(int paramInt) {}
  
  public boolean onDeactivate(boolean paramBoolean, Bundle paramBundle)
  {
    return true;
  }
  
  public void onDelete() {}
  
  public void onEnter()
  {
    this.f.startZoom();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((WeatherIcon)findViewById(2131231254));
    this.f.setOnClickListener(new q(this));
    this.f.setOnLongClickListener(this);
    this.g = ((CityNameView)findViewById(2131231208));
    this.g.setOnClickListener(new r(this));
    this.g.setOnLongClickListener(this);
    int i1 = 0;
    while (i1 < 5)
    {
      this.h[i1] = ((HourBottom)findViewById(new int[] { 2131231743, 2131231744, 2131231745, 2131231746, 2131231747 }[i1]));
      this.h[i1].setOnClickListener(this);
      this.h[i1].setOnLongClickListener(this);
      i1 += 1;
    }
    this.m = this.h[0];
    this.h[0].setFoucse();
    this.h[0].setBackgroundDrawable(this.l[0]);
    this.i = ((GLDigitalClock)findViewById(2131231742));
    this.i.setOnClickListener(new s(this));
    this.i.startTimeChangeAnimation(0, 0);
    this.i.setOnLongClickListener(this);
    this.j = ((ProgressBar)findViewById(2131231740));
    this.j.setOnClickListener(new t(this));
    this.k = ((GLImageView)findViewById(2131231741));
    this.k.setOnClickListener(new v(this));
    this.t = this.a.getResources().getString(2131165829);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLeave() {}
  
  public void onLoadFinish()
  {
    post(new x(this));
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return false;
  }
  
  public void onMyLoadFinish()
  {
    boolean bool = true;
    if (this.b != 5)
    {
      this.y = true;
      this.w += 1;
      return;
    }
    a(this.n.m());
    Object localObject;
    int i2;
    int i1;
    if (this.s == 0)
    {
      localObject = this.n.p();
      if (localObject != null)
      {
        i2 = ((NowBean)localObject).d();
        i1 = this.n.t().hour;
        if (this.n.d(i1)) {
          break label205;
        }
      }
    }
    for (;;)
    {
      a(i2, bool);
      b();
      this.n.q();
      this.i.startTimeChangeAnimation(this.n.r(), this.n.s());
      this.g.setCityNum(this.n.i());
      this.g.setCityName(this.n.m());
      this.y = false;
      return;
      i1 = 0;
      i2 = 1;
      break;
      localObject = this.n.e(this.s);
      if (localObject != null)
      {
        i2 = ((HourlyBean)localObject).e();
        i1 = ((HourlyBean)localObject).d();
        break;
      }
      i1 = 0;
      i2 = 1;
      break;
      label205:
      bool = false;
    }
  }
  
  public void onRemove() {}
  
  public void onScreenChange(String paramString) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b |= 0x1;
    this.f.setCenter(paramInt1 / 2 - 12);
    if (this.y) {
      onMyLoadFinish();
    }
  }
  
  public void onStart()
  {
    this.n.a(this);
    this.n.q();
    this.i.startTimeChangeAnimation(this.n.r(), this.n.s());
  }
  
  public void onStop() {}
  
  public void onTemperatureUnitChange(int paramInt)
  {
    if (this.b != 5) {
      return;
    }
    b();
  }
  
  public void onTimeChange(int paramInt1, int paramInt2)
  {
    if (this.b != 5) {
      return;
    }
    this.i.startTimeChangeAnimation(paramInt1, paramInt2);
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void rebuildAnimation(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(2130838334);
    int i1 = localDrawable.getIntrinsicHeight() / 2;
    i1 = -localDrawable.getIntrinsicHeight() / 2;
    this.r = new AnimationSet(false);
    Rotate3DAnimation localRotate3DAnimation = new Rotate3DAnimation(0.0F, -90.0F, 0.0F, -paramInt + localDrawable.getIntrinsicHeight(), i1, 1.0F, 0.0F, 0.0F);
    localRotate3DAnimation.setDuration(320L);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(320L);
    this.r.addAnimation(localRotate3DAnimation);
    this.r.addAnimation(localAlphaAnimation);
    this.r.setAnimationListener(this);
    this.q = new Rotate3DAnimation(-90.0F, 0.0F, 0.0F, -paramInt + localDrawable.getIntrinsicHeight(), i1, 1.0F, 0.0F, 0.0F);
    this.q.setDuration(800L);
    this.q.setInterpolator(this.v);
  }
  
  public void setDataHandler(e parame, y paramy)
  {
    if (parame != null)
    {
      this.n = parame;
      this.b |= 0x4;
      this.g.setCityName(this.n.m());
    }
    this.p = paramy;
    if (this.y) {
      onMyLoadFinish();
    }
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    this.f.setDrawingCacheEnabled(paramBoolean);
  }
  
  public void setTrendView(WeatherTrendView paramWeatherTrendView)
  {
    this.o = paramWeatherTrendView;
  }
  
  public void setWidgetCallback(WidgetCallback paramWidgetCallback) {}
  
  public void startAppearAnimation()
  {
    setVisibility(0);
    startAnimation(this.q);
  }
  
  public void startDisppearAnimation()
  {
    startAnimation(this.r);
  }
  
  public void startEntering()
  {
    this.C = true;
    this.B = -1L;
    invalidate();
  }
  
  public void startLeaving()
  {
    this.D = true;
    this.B = -1L;
    invalidate();
  }
  
  public void startRefresh()
  {
    this.j.start();
  }
  
  void updateRadius() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/HourlyTypeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */