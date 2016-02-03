package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.go.gl.animation.AlphaAnimation;
import com.go.gl.animation.Animation;
import com.go.gl.animation.Animation.AnimationListener;
import com.go.gl.animation.AnimationSet;
import com.go.gl.animation.InterpolatorFactory;
import com.go.gl.animation.Rotate3DAnimation;
import com.go.gl.animation.RotateAnimation;
import com.go.gl.animation.ScaleAnimation;
import com.go.gl.view.GLFrameLayout;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.view.GLRelativeLayout;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextViewWrapper;
import java.util.Calendar;
import java.util.List;

public class WeatherTrendView
  extends GLRelativeLayout
  implements Animation.AnimationListener, GLView.OnClickListener, GLView.OnLongClickListener, h
{
  private static final String[] a = { "%m/%d", "%m/%d", "%d/%m" };
  private Animation A;
  private AnimationSet B;
  private Animation C;
  private AnimationSet D;
  private SensorManager E;
  private Sensor F;
  private boolean G = false;
  private int H;
  private int I;
  private boolean J = true;
  private y K;
  private HourlyTypeView L;
  private Interpolator M = new af(this);
  private SensorEventListener N = new ag(this);
  private float O = 2.14748365E9F;
  private float P = -2.14748365E9F;
  private Handler Q = new ai(this);
  private String b = a[0];
  private CustomTextViewWrapper c;
  private GLImageView d;
  private GLImageView e;
  private GLImageView f;
  private TemperatureCubeView g;
  private TemperatureCubeView h;
  private TemperatureCubeView i;
  private TemperatureCubeView j;
  private TemperatureCubeView k;
  private TemperatureCubeView l;
  private TemperatureCubeView[] m = new TemperatureCubeView[6];
  boolean mCubeViewDrawingCacheEnabled = false;
  private GLTextViewWrapper n;
  private GLTextViewWrapper o;
  private GLTextViewWrapper p;
  private GLTextViewWrapper q;
  private GLTextViewWrapper r;
  private GLTextViewWrapper s;
  private GLTextViewWrapper[] t = new GLTextViewWrapper[6];
  private GLLinearLayout u;
  private GLLinearLayout v;
  private GLFrameLayout w;
  private e x;
  private Animation y;
  private Animation z;
  
  public WeatherTrendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setChildrenDrawingOrderEnabled(true);
    a();
    registSensorEventListener();
  }
  
  private String a(ForecastBean paramForecastBean)
  {
    int i1 = paramForecastBean.f();
    int i2 = paramForecastBean.g();
    if (i1 < 10)
    {
      paramForecastBean = "0" + i1;
      if (i2 >= 10) {
        break label134;
      }
    }
    String str2;
    label134:
    for (String str1 = "0" + i2;; str1 = String.valueOf(i2))
    {
      str2 = str1 + "/" + paramForecastBean;
      if (!this.b.equals("%m/%d")) {
        break label143;
      }
      return paramForecastBean + "/" + str1;
      paramForecastBean = String.valueOf(i1);
      break;
    }
    label143:
    if (this.b.equals("%d/%m")) {
      return str1 + "/" + paramForecastBean;
    }
    return str2;
  }
  
  private void a()
  {
    this.C = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 1.0F);
    this.C.setDuration(1800L);
    this.C.setInterpolator(InterpolatorFactory.getInterpolator(8, 0, new float[] { 0.5F, 0.3F }));
    this.D = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation.setDuration(400L);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(400L);
    this.D.addAnimation(localScaleAnimation);
    this.D.addAnimation(localAlphaAnimation);
    this.D.setAnimationListener(this);
    this.y = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.y.setRepeatCount(-1);
    this.y.setInterpolator(InterpolatorFactory.getInterpolator(0));
    this.y.setDuration(1000L);
  }
  
  private void a(int paramInt)
  {
    Object localObject = "";
    if (this.x.i() > 0) {
      localObject = this.x.k();
    }
    for (int i1 = this.x.l();; i1 = -1)
    {
      localObject = p.a(getContext(), (String)localObject, true, 17, "", paramInt);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("gowidget_Id", this.I);
      ((Intent)localObject).putExtra("isMyLocation", i1);
      getContext().startActivity((Intent)localObject);
      return;
    }
  }
  
  private void a(GLTextViewWrapper paramGLTextViewWrapper, ForecastBean paramForecastBean)
  {
    paramGLTextViewWrapper.setText(a(paramForecastBean));
  }
  
  private void a(TemperatureCubeView paramTemperatureCubeView, ForecastBean paramForecastBean)
  {
    paramTemperatureCubeView.setWeatherType(paramForecastBean.i(), this.x.o());
  }
  
  private void a(TemperatureCubeView paramTemperatureCubeView, GLTextViewWrapper paramGLTextViewWrapper, ForecastBean paramForecastBean, boolean paramBoolean)
  {
    int i1 = e.b - 1;
    if ((i1 >= 0) && (i1 < a.length)) {
      this.b = a[i1];
    }
    if (!paramBoolean) {
      a(paramGLTextViewWrapper, paramForecastBean);
    }
    for (;;)
    {
      float f1 = paramForecastBean.b(e.a);
      float f2 = paramForecastBean.a(e.a);
      this.O = Math.min(this.O, f2);
      this.P = Math.max(this.P, f1);
      paramTemperatureCubeView.setHighTemperature(f1);
      paramTemperatureCubeView.setLowTemperature(f2);
      paramTemperatureCubeView.setTemperatureUnit(e.a);
      a(paramTemperatureCubeView, paramForecastBean);
      return;
      paramGLTextViewWrapper.setText(2131165919);
    }
  }
  
  private void b(int paramInt)
  {
    while (paramInt < this.m.length)
    {
      this.t[paramInt].setText("N/A");
      this.m[paramInt].setHighTemperature(0.0F);
      this.m[paramInt].setLowTemperature(0.0F);
      this.m[paramInt].setWeatherType(1, true);
      this.m[paramInt].resetCubes();
      this.m[paramInt].setNoData(true);
      paramInt += 1;
    }
  }
  
  private void c(int paramInt)
  {
    while (paramInt < this.m.length)
    {
      this.t[paramInt].setText("N/A");
      this.m[paramInt].setHighTemperature(0.0F);
      this.m[paramInt].setLowTemperature(0.0F);
      this.m[paramInt].setWeatherType(1, true);
      paramInt += 1;
    }
  }
  
  public void cleanup()
  {
    this.J = false;
    this.x.b(this);
    unRegistSensorEventListener();
    this.E = null;
    this.F = null;
    super.cleanup();
  }
  
  public void endRefresh()
  {
    if ((getVisibility() != 0) || (!this.J)) {
      return;
    }
    this.e.clearAnimation();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2) {
      paramInt1 = 3;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (paramInt2 != 3);
    return 2;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramAnimation.equals(this.z)) {
      postDelayed(new aj(this), 150L);
    }
    do
    {
      for (;;)
      {
        return;
        if (paramAnimation.equals(this.D))
        {
          this.u.setVisibility(8);
          return;
        }
        if (!paramAnimation.equals(this.B)) {
          break;
        }
        this.v.setVisibility(8);
        paramAnimation = this.m;
        i2 = paramAnimation.length;
        while (i1 < i2)
        {
          paramAnimation[i1].setVisibility(8);
          i1 += 1;
        }
      }
    } while (!paramAnimation.equals(this.A));
    paramAnimation = this.m;
    int i3 = paramAnimation.length;
    i1 = i2;
    while (i1 < i3)
    {
      Object localObject = paramAnimation[i1];
      ((TemperatureCubeView)localObject).setHighTemperature(0.0F);
      ((TemperatureCubeView)localObject).setLowTemperature(0.0F);
      ((TemperatureCubeView)localObject).resetCubes();
      i1 += 1;
    }
    this.w.setVisibility(8);
    setVisibility(8);
    this.L = null;
    this.K.onTrendViewHide();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onAutoLocateFail(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void onClick(GLView paramGLView)
  {
    switch (paramGLView.getId())
    {
    default: 
    case 2131231759: 
    case 2131231760: 
      do
      {
        return;
        this.x.c();
        postDelayed(new ah(this), 1000L);
        return;
      } while ((!this.K.getIfTrendSwitchReady()) || (!this.K.getIfHourSwitchReady()));
      startDisppearAnimation();
      if (this.L == null) {
        this.L = this.K.getHourlyTypeView();
      }
      this.L.startAppearAnimation();
      this.K.setTrendDisappearStart();
      return;
    case 2131231761: 
      if (this.x.i() > 1)
      {
        this.x.f();
        return;
      }
      a(-1);
      return;
    }
    a(2);
  }
  
  public void onDateStyleChange(int paramInt)
  {
    paramInt -= 1;
    if ((paramInt >= 0) && (paramInt < a.length)) {
      this.b = a[paramInt];
    }
    List localList = this.x.n();
    if ((localList != null) && (localList.size() >= 6))
    {
      a(this.o, (ForecastBean)localList.get(1));
      a(this.p, (ForecastBean)localList.get(2));
      a(this.q, (ForecastBean)localList.get(3));
      a(this.r, (ForecastBean)localList.get(4));
      a(this.s, (ForecastBean)localList.get(5));
    }
  }
  
  protected void onFinishInflate()
  {
    this.c = ((CustomTextViewWrapper)findViewById(2131231761));
    this.c.setOnClickListener(this);
    this.e = ((GLImageView)findViewById(2131231759));
    this.e.setOnClickListener(this);
    this.f = ((GLImageView)findViewById(2131231760));
    this.f.setOnClickListener(this);
    this.d = ((GLImageView)findViewById(2131231762));
    this.g = ((TemperatureCubeView)findViewById(2131231773));
    this.h = ((TemperatureCubeView)findViewById(2131231774));
    this.i = ((TemperatureCubeView)findViewById(2131231775));
    this.j = ((TemperatureCubeView)findViewById(2131231776));
    this.k = ((TemperatureCubeView)findViewById(2131231777));
    this.l = ((TemperatureCubeView)findViewById(2131231778));
    this.m[0] = this.g;
    this.m[1] = this.h;
    this.m[2] = this.i;
    this.m[3] = this.j;
    this.m[4] = this.k;
    this.m[5] = this.l;
    this.n = ((GLTextViewWrapper)findViewById(2131231766));
    this.o = ((GLTextViewWrapper)findViewById(2131231767));
    this.p = ((GLTextViewWrapper)findViewById(2131231768));
    this.q = ((GLTextViewWrapper)findViewById(2131231769));
    this.r = ((GLTextViewWrapper)findViewById(2131231770));
    this.s = ((GLTextViewWrapper)findViewById(2131231771));
    this.t[0] = this.n;
    this.t[1] = this.o;
    this.t[2] = this.p;
    this.t[3] = this.q;
    this.t[4] = this.r;
    this.t[5] = this.s;
    this.u = ((GLLinearLayout)findViewById(2131231756));
    this.u.setHasPixelOverlayed(false);
    this.v = ((GLLinearLayout)findViewById(2131231772));
    this.v.setOnClickListener(this);
    this.v.setOnLongClickListener(this);
    this.v.setHasPixelOverlayed(false);
    this.w = ((GLFrameLayout)findViewById(2131231765));
    super.onFinishInflate();
  }
  
  public void onLoadFinish()
  {
    if ((getVisibility() != 0) || (!this.J)) {
      return;
    }
    updateUI();
    startChangeCityAnimation();
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return false;
  }
  
  public void onScreenChange(String paramString)
  {
    if (paramString.equals("android.intent.action.SCREEN_ON")) {
      registSensorEventListener();
    }
    while (!paramString.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    unRegistSensorEventListener();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onStart()
  {
    if ((this.x.i() == 0) && (this.J)) {
      this.c.setText(2131165761);
    }
    if (this.x.i() <= 1)
    {
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public void onTemperatureUnitChange(int paramInt)
  {
    if (!this.J) {
      return;
    }
    updateTemperatureUnit(e.a);
    updateUI();
  }
  
  public void onTimeChange(int paramInt1, int paramInt2)
  {
    if ((getVisibility() != 0) || (!this.J)) {}
    Object localObject;
    int i2;
    int i3;
    int i1;
    do
    {
      return;
      updateUI();
      localObject = Calendar.getInstance();
      i2 = ((Calendar)localObject).get(2);
      i3 = ((Calendar)localObject).get(5);
      localObject = this.x.n();
      i1 = -1;
    } while (localObject == null);
    paramInt2 = 0;
    for (;;)
    {
      paramInt1 = i1;
      if (paramInt2 < ((List)localObject).size())
      {
        ForecastBean localForecastBean = (ForecastBean)((List)localObject).get(paramInt2);
        if ((localForecastBean.f() == i2 + 1) && (localForecastBean.g() == i3)) {
          paramInt1 = paramInt2;
        }
      }
      else
      {
        if ((paramInt1 < 0) || (paramInt1 >= ((List)localObject).size())) {
          break;
        }
        paramInt2 = paramInt1;
        while ((paramInt2 < paramInt1 + 6) && (paramInt2 < ((List)localObject).size()))
        {
          a(this.m[(paramInt2 - paramInt1)], (ForecastBean)((List)localObject).get(paramInt2));
          paramInt2 += 1;
        }
        break;
      }
      paramInt2 += 1;
    }
  }
  
  public void rebuildAnimation(int paramInt)
  {
    this.B = new AnimationSet(false);
    Object localObject = new Rotate3DAnimation(0.0F, 90.0F, 0.0F, -paramInt, 0.0F, 1.0F, 0.0F, 0.0F);
    ((Rotate3DAnimation)localObject).setDuration(400L);
    this.B.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(400L);
    this.B.addAnimation((Animation)localObject);
    this.B.setAnimationListener(this);
    paramInt = -getResources().getDrawable(2130838334).getIntrinsicHeight() / 2;
    this.z = new Rotate3DAnimation(90.0F, 0.0F, 0.0F, 0.0F, paramInt, 1.0F, 0.0F, 0.0F);
    this.z.setDuration(400L);
    this.z.setAnimationListener(this);
    this.A = new Rotate3DAnimation(0.0F, 90.0F, 0.0F, 0.0F, paramInt, 1.0F, 0.0F, 0.0F);
    this.A.setDuration(400L);
    this.A.setInterpolator(this.M);
    this.A.setAnimationListener(this);
  }
  
  public void refreshScreenMode()
  {
    this.H = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
  }
  
  public void registSensorEventListener()
  {
    if (this.G) {
      return;
    }
    this.G = true;
    if (this.E == null) {
      this.E = ((SensorManager)this.mContext.getSystemService("sensor"));
    }
    if (this.F == null) {
      this.F = this.E.getDefaultSensor(1);
    }
    this.E.registerListener(this.N, this.F, 1);
  }
  
  public void setDataHandler(e parame, y paramy)
  {
    this.x = parame;
    this.x.a(this);
    this.K = paramy;
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    this.mCubeViewDrawingCacheEnabled = paramBoolean;
  }
  
  public void setHourlyView(HourlyTypeView paramHourlyTypeView)
  {
    this.L = paramHourlyTypeView;
  }
  
  public void setWidgetId(int paramInt)
  {
    this.I = paramInt;
  }
  
  public void startAppearAnimation()
  {
    setVisibility(0);
    this.u.setVisibility(8);
    this.v.setVisibility(8);
    this.w.setVisibility(0);
    this.w.startAnimation(this.z);
  }
  
  public void startChangeCityAnimation()
  {
    TemperatureCubeView[] arrayOfTemperatureCubeView = this.m;
    int i2 = arrayOfTemperatureCubeView.length;
    int i1 = 0;
    if (i1 < i2)
    {
      TemperatureCubeView localTemperatureCubeView = arrayOfTemperatureCubeView[i1];
      if (!localTemperatureCubeView.isNoData()) {
        localTemperatureCubeView.startAnimating(this.P, this.O, false);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localTemperatureCubeView.updateLastWeatherMark();
      }
    }
  }
  
  public void startDisppearAnimation()
  {
    this.v.startAnimation(this.B);
    this.w.startAnimation(this.A);
    this.u.startAnimation(this.D);
  }
  
  public void startRefresh()
  {
    if ((getVisibility() != 0) || (!this.J)) {
      return;
    }
    this.e.startAnimation(this.y);
  }
  
  public void startShowUpAnimation()
  {
    updateUI();
    this.u.setVisibility(0);
    this.v.setVisibility(0);
    this.u.startAnimation(this.C);
    this.Q.sendEmptyMessage(0);
  }
  
  public void unRegistSensorEventListener()
  {
    if (this.G)
    {
      this.G = false;
      this.E.unregisterListener(this.N);
    }
  }
  
  public void updateTemperatureUnit(int paramInt)
  {
    TemperatureCubeView[] arrayOfTemperatureCubeView = this.m;
    int i2 = arrayOfTemperatureCubeView.length;
    int i1 = 0;
    while (i1 < i2)
    {
      TemperatureCubeView localTemperatureCubeView = arrayOfTemperatureCubeView[i1];
      if (localTemperatureCubeView != null) {
        localTemperatureCubeView.setTemperatureUnit(paramInt);
      }
      i1 += 1;
    }
  }
  
  public void updateUI()
  {
    this.O = 2.14748365E9F;
    this.P = -2.14748365E9F;
    if (this.c != null) {
      this.c.setText(this.x.m());
    }
    Object localObject1;
    int i3;
    int i2;
    label101:
    int i1;
    Object localObject2;
    label173:
    GLTextViewWrapper localGLTextViewWrapper;
    ForecastBean localForecastBean;
    if (this.x.i() <= 1)
    {
      this.d.setVisibility(4);
      localObject1 = Calendar.getInstance();
      int i4 = ((Calendar)localObject1).get(2);
      int i5 = ((Calendar)localObject1).get(5);
      localObject1 = this.x.n();
      i3 = -1;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label308;
      }
      i2 = 0;
      i1 = i3;
      if (i2 < ((List)localObject1).size())
      {
        localObject2 = (ForecastBean)((List)localObject1).get(i2);
        if ((((ForecastBean)localObject2).f() != i4 + 1) || (((ForecastBean)localObject2).g() != i5)) {
          break label262;
        }
        i1 = i2;
      }
      if ((i1 < 0) || (i1 >= ((List)localObject1).size())) {
        break label307;
      }
      i3 = i1 + 6;
      i2 = i1;
      if ((i2 >= i3) || (i2 >= ((List)localObject1).size())) {
        break label283;
      }
      localObject2 = this.m[(i2 - i1)];
      localGLTextViewWrapper = this.t[(i2 - i1)];
      localForecastBean = (ForecastBean)((List)localObject1).get(i2);
      if (i2 != i1) {
        break label269;
      }
      a((TemperatureCubeView)localObject2, localGLTextViewWrapper, localForecastBean, true);
    }
    for (;;)
    {
      ((TemperatureCubeView)localObject2).setNoData(false);
      i2 += 1;
      break label173;
      this.d.setVisibility(0);
      break;
      label262:
      i2 += 1;
      break label101;
      label269:
      a((TemperatureCubeView)localObject2, localGLTextViewWrapper, localForecastBean, false);
    }
    label283:
    if (i3 > ((List)localObject1).size()) {
      b(((List)localObject1).size() - i1);
    }
    label307:
    return;
    label308:
    c(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/WeatherTrendView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */