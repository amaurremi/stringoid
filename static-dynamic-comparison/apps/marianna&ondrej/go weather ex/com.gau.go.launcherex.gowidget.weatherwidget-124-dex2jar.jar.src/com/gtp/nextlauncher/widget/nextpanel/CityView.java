package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.view.GLContentView;
import com.go.gl.view.GLLayoutInflater;
import com.go.gl.view.GLRelativeLayout;
import com.go.gl.view.GLRelativeLayout.LayoutParams;
import com.go.gowidget.core.FullScreenNextWidgetCallback;
import com.gtp.nextlauncher.widget.weatherwidget.e;

public class CityView
  extends GLRelativeLayout
  implements l
{
  private float A = 0.0F;
  private float B = 0.0F;
  private FullScreenNextWidgetCallback C;
  private boolean D = false;
  private ForecastView a;
  private int b = 0;
  private e c;
  private WeatherDespView d;
  private boolean e = false;
  private boolean f = true;
  private Wall g;
  private boolean h = false;
  private int i = -1;
  private boolean j = false;
  private long k = 0L;
  private float l = 1.0F;
  private float m = 0.0F;
  boolean mIsInRiseAnimation = false;
  protected float mOffSet = 0.0F;
  private float n = 0.0F;
  private float o;
  private int p = 0;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private boolean t = false;
  private long u = 0L;
  private int v;
  private int w = 0;
  private float x = 0.0F;
  private float y = 0.0F;
  private float[] z;
  
  public CityView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CityView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a()
  {
    Object localObject = "";
    if (this.c.i() > 0) {
      localObject = this.c.k();
    }
    for (int i1 = this.c.l();; i1 = -1)
    {
      localObject = p.a(getContext(), (String)localObject, true, 18, "", -1);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("gowidget_Id", this.v);
      ((Intent)localObject).putExtra("isMyLocation", i1);
      getContext().startActivity((Intent)localObject);
      return;
    }
  }
  
  private void a(float paramFloat)
  {
    this.l = (1.0F - paramFloat);
    this.m = paramFloat;
    this.y = (this.x * paramFloat);
    this.B = (this.A * paramFloat);
    this.n = (-this.o * paramFloat);
    if (paramFloat == 1.0F) {
      b();
    }
    invalidate();
  }
  
  private void a(Context paramContext)
  {
    this.mContext = paramContext;
    this.d = ((WeatherDespView)GLLayoutInflater.from(paramContext).inflate(2130903244, null));
    this.a = new ForecastView(this.mContext);
    this.D = true;
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    if (this.u == -1L) {
      this.u = getDrawingTime();
    }
    if (this.mIsInRiseAnimation) {
      a(Math.max(0.0F, Math.min((float)(getDrawingTime() - this.u) / 500.0F, 1.0F)));
    }
    if (this.k == -1L) {
      this.k = getDrawingTime();
    }
    if (this.j) {
      b(Math.max(0.0F, Math.min((float)(getDrawingTime() - this.k) / 300.0F, 1.0F)));
    }
    int i1 = paramGLCanvas.save();
    int i2 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i2 * this.l));
    paramGLCanvas.translate(-this.mOffSet, 0.0F);
    paramGLCanvas.clipRect(PanelMain.sClickRect);
    paramGLCanvas.translate(this.mOffSet, 0.0F);
    this.g.draw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i1);
    paramGLCanvas.setAlpha(i2);
  }
  
  private void b()
  {
    this.mIsInRiseAnimation = false;
    this.e = true;
    this.g.startWeatherAnimaiton();
  }
  
  private void b(float paramFloat)
  {
    this.l = paramFloat;
    this.m = (1.0F - paramFloat);
    this.y = (this.x * (1.0F - paramFloat));
    this.n = (-this.o * (1.0F - paramFloat));
    this.B = (this.A * (1.0F - paramFloat));
    if (paramFloat == 1.0F) {
      d();
    }
    invalidate();
  }
  
  private void c()
  {
    this.j = true;
    this.k = -1L;
    invalidate();
  }
  
  private void d()
  {
    this.j = false;
    if (this.C != null) {
      this.C.onFullAnimationEnd();
    }
  }
  
  private void e()
  {
    if ((this.g == null) || (this.a == null) || (this.mWidth <= 0) || (this.t)) {
      return;
    }
    int i1 = this.p;
    int i2 = this.q;
    int i4 = this.r;
    int i3 = this.s;
    if (this.mWidth > this.mHeight)
    {
      this.g.layout((i1 + i2) / 2, i4, i2, i3);
      i4 = this.a.getMeasuredHeight();
      this.a.layout((i1 + i2) / 2, i3 - i4, i2, i3);
    }
    this.t = true;
  }
  
  public void cleanup()
  {
    this.D = false;
    super.cleanup();
  }
  
  public void clearWall()
  {
    this.g.clearDrawable();
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    int i1 = paramGLCanvas.save();
    a(paramGLCanvas);
    paramGLCanvas.restoreToCount(i1);
    i1 = paramGLCanvas.save();
    paramGLCanvas.translate(-this.mOffSet, 0.0F);
    paramGLCanvas.clipRect(PanelMain.sClickRect);
    paramGLCanvas.translate(this.mOffSet, 0.0F);
    this.a.draw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i1);
    i1 = paramGLCanvas.save();
    paramGLCanvas.translate(-this.mOffSet, 0.0F);
    paramGLCanvas.clipRect(PanelMain.sClickRect);
    paramGLCanvas.translate(this.mOffSet, 0.0F);
    this.d.draw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i1);
  }
  
  public void drawFlyingFrame(GLCanvas paramGLCanvas)
  {
    int i1 = paramGLCanvas.save();
    int i2 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i2 * this.m));
    paramGLCanvas.translate(0.0F, -this.B, this.n);
    if (this.z != null) {
      paramGLCanvas.translate(0.0F, this.z[1], 0.0F);
    }
    paramGLCanvas.rotateAxisAngle(this.y, -1.0F, 0.0F, 0.0F);
    if (this.z != null) {
      paramGLCanvas.translate(0.0F, -this.z[1], 0.0F);
    }
    this.g.draw(paramGLCanvas);
    paramGLCanvas.setAlpha(i2);
    paramGLCanvas.restoreToCount(i1);
  }
  
  public void forceClosePreviewAnimation()
  {
    if ((this.j) || (this.mIsInRiseAnimation) || (this.e))
    {
      b(1.0F);
      this.mIsInRiseAnimation = false;
      this.e = false;
    }
    this.g.forceAnimationStop();
  }
  
  public boolean getIsFore()
  {
    return this.f;
  }
  
  public int getWeatherType()
  {
    return this.i;
  }
  
  public void initWall()
  {
    onTimeChange();
    this.g.initDrawable();
  }
  
  public void onEnterPreview()
  {
    if (!this.f) {
      startForecast();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.p = paramInt1;
    this.q = paramInt3;
    this.r = paramInt2;
    this.s = paramInt4;
  }
  
  public void onPreviewAnimationEnd()
  {
    if (this.e) {
      c();
    }
    this.e = false;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    GLContentView localGLContentView = getGLRootView();
    this.t = false;
    if (localGLContentView != null) {
      this.o = localGLContentView.getDepthForProjectScale(0.6F);
    }
    forceClosePreviewAnimation();
    onEnterPreview();
    e();
  }
  
  public void onTimeChange()
  {
    if ((this.c == null) || (!this.h) || (!this.D)) {}
    while ((this.c.b(this.w) == null) || (this.c.b(this.w).k == null)) {
      return;
    }
    int i1 = this.c.b(this.w).k.d();
    boolean bool = this.c.c(this.w);
    i1 = m.a(i1, bool);
    if (i1 != this.i)
    {
      this.i = i1;
      removeView(this.g);
      this.g = new m(i1, bool).a(this.mContext);
      this.g.setWallHodler(this);
      addView(this.g, new GLRelativeLayout.LayoutParams(-1, -1));
      this.g.initDrawable();
      if ((this.i != 3) && (this.i != 2) && (this.i != 4)) {
        break label210;
      }
      this.d.setNight(false);
      this.a.setNight(false);
    }
    for (;;)
    {
      this.a.updateUI();
      return;
      label210:
      this.d.setNight(true);
      this.a.setNight(true);
    }
  }
  
  public void setDateHandler(e parame, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = parame;
    this.w = paramInt1;
    this.v = this.c.u();
    boolean bool = parame.c(paramInt1);
    paramInt1 = m.a(paramInt2, bool);
    if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4))
    {
      this.d.setNight(false);
      this.a.setNight(false);
    }
    for (;;)
    {
      this.d.setOnClickListener(new b(this));
      this.a.setDataHandler(parame, this.w);
      if ((this.i != paramInt1) && (this.h))
      {
        removeView(this.g);
        this.g = new m(paramInt1, bool).a(this.mContext);
        this.g.setWallHodler(this);
        e();
        addView(this.g, new GLRelativeLayout.LayoutParams(-1, -1));
      }
      if (!this.h)
      {
        this.g = new m(paramInt1, bool).a(this.mContext);
        this.g.setWallHodler(this);
        e();
        addView(this.g, new GLRelativeLayout.LayoutParams(-1, -1));
        addView(this.a, new GLRelativeLayout.LayoutParams(-1, -1));
        addView(this.d);
        this.h = true;
      }
      showWeatherDesp();
      this.i = paramInt1;
      this.a.updateUI();
      return;
      this.d.setNight(true);
      this.a.setNight(true);
    }
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    super.setDrawingCacheEnabled(paramBoolean);
  }
  
  public void setOffSet(float paramFloat)
  {
    this.mOffSet = paramFloat;
  }
  
  public void showWeatherDesp()
  {
    if (this.c == null) {
      return;
    }
    WeatherBean localWeatherBean = this.c.b(this.b);
    if (localWeatherBean == null)
    {
      this.d.setCityName(this.c.m());
      return;
    }
    this.d.setWindDesp(this.c.g(localWeatherBean));
    this.d.setCityName(localWeatherBean.d());
    this.d.setNowTemp(this.c.b(localWeatherBean));
    this.d.setNowTempUnit(this.c.c(localWeatherBean));
    this.d.setLTempDesp(this.c.f(localWeatherBean));
    this.d.setHTempDesp(this.c.e(localWeatherBean));
    this.d.setHumidity(this.c.d(localWeatherBean));
    this.d.setWeatherDesp(this.c.a(localWeatherBean));
  }
  
  public void startForecast()
  {
    if (this.g.startForeAnimation(this.f))
    {
      this.a.startForeAnimation(this.f);
      if (this.f) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      invalidate();
      return;
    }
  }
  
  public void startRiseAnimation(float paramFloat, float[] paramArrayOfFloat, FullScreenNextWidgetCallback paramFullScreenNextWidgetCallback)
  {
    if (this.mIsInRiseAnimation) {
      return;
    }
    this.C = paramFullScreenNextWidgetCallback;
    this.mIsInRiseAnimation = true;
    this.u = -1L;
    this.l = 1.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    this.x = paramFloat;
    this.z = paramArrayOfFloat;
    this.y = 0.0F;
    this.e = true;
    this.A = ((float)(Math.tan(Math.toRadians(this.x)) * this.o));
    invalidate();
  }
  
  public void startWeatherAnimation()
  {
    this.g.startWeatherAnimaiton();
  }
  
  public void updateTemp()
  {
    if (this.c == null) {}
    WeatherBean localWeatherBean;
    do
    {
      return;
      localWeatherBean = this.c.b(this.b);
    } while (localWeatherBean == null);
    this.d.setNowTemp(this.c.b(localWeatherBean));
    this.d.setNowTempUnit(this.c.c(localWeatherBean));
    this.d.setLTempDesp(this.c.f(localWeatherBean));
    this.d.setHTempDesp(this.c.e(localWeatherBean));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/CityView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */