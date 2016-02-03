package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Time;
import android.view.MotionEvent;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.go.gl.animation.Transformation3D;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.math3d.Plane;
import com.go.gl.math3d.Point;
import com.go.gl.math3d.Ray;
import com.go.gl.math3d.Vector;
import com.go.gl.view.GLContentView;
import com.go.gl.view.GLLayoutInflater;
import com.go.gl.view.GLRelativeLayout;
import com.go.gl.view.GLView;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextView;
import java.util.ArrayList;
import java.util.List;

public class ForecastView
  extends GLRelativeLayout
{
  private com.gtp.nextlauncher.widget.weatherwidget.e A;
  private float B = 0.0F;
  private boolean C = true;
  private Transformation3D D = new Transformation3D();
  private int E = 0;
  private g F = null;
  private Time G = new Time();
  private float[] H = { 0.4F, 0.3F, 0.2F, 0.1F, 0.0F };
  private float[] I = { 0.0F, 0.1F, 0.2F, 0.3F, 0.4F };
  private boolean J = false;
  private final int a = 5;
  private final float b = 0.8F;
  float[] bottomY = new float[5];
  private boolean c = false;
  private long d;
  float[] deeps = new float[5];
  private int e = 1000;
  private boolean f = true;
  private boolean g = false;
  private float[] h = new float[3];
  private Point i = new Point();
  private Point j = new Point();
  private final float k = 0.5F;
  private GLView[] l = new GLView[5];
  private int m = 80;
  boolean mHasGetCanvasT = false;
  private GLImageView[] n = new GLImageView[5];
  private GLTextView[] o = new GLTextView[5];
  private GLImageView[] p = new GLImageView[5];
  private GLTextView[] q = new GLTextView[5];
  private float r = 0.0F;
  private float[] s = new float[5];
  private float[] t = new float[5];
  private float u = 0.0F;
  private String[] v = new String[7];
  private Context w;
  private GLDrawable[] x;
  private GLDrawable[] y;
  private int z = 0;
  
  public ForecastView(Context paramContext)
  {
    super(paramContext);
    this.w = paramContext;
    a();
  }
  
  private void a()
  {
    int i1 = 0;
    while (i1 < 5)
    {
      GLLayoutInflater localGLLayoutInflater = GLLayoutInflater.from(this.w);
      this.l[i1] = localGLLayoutInflater.inflate(2130903107, null);
      this.n[i1] = ((GLImageView)this.l[i1].findViewById(2131230744));
      this.o[i1] = ((GLTextView)this.l[i1].findViewById(2131231253));
      this.p[i1] = ((GLImageView)this.l[i1].findViewById(2131231254));
      this.q[i1] = ((GLTextView)this.l[i1].findViewById(2131231255));
      addView(this.l[i1]);
      i1 += 1;
    }
    b();
    a(this.w);
    this.J = true;
  }
  
  private void a(float paramFloat)
  {
    int i1 = 0;
    int i2 = 0;
    float f1;
    if (this.f)
    {
      i1 = i2;
      while (i1 < 5)
      {
        f1 = Math.min(1.0F, Math.max(0.0F, getInterpor((paramFloat - this.H[i1]) / 0.6F)));
        this.s[i1] = ((this.deeps[i1] - this.r) * f1 + this.r);
        this.t[i1] = (f1 * (this.bottomY[i1] - this.u) + this.u);
        i1 += 1;
      }
    }
    while (i1 < 5)
    {
      f1 = Math.min(1.0F, Math.max(0.0F, c((paramFloat - this.I[i1]) / 0.6F)));
      this.s[i1] = ((this.r - this.deeps[i1]) * f1 + this.deeps[i1]);
      this.t[i1] = (f1 * (this.u - this.bottomY[i1]) + this.bottomY[i1]);
      i1 += 1;
    }
    if (paramFloat == 1.0F) {
      c();
    }
    invalidate();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    Ray localRay = new Ray();
    Plane localPlane = new Plane();
    this.m = this.l[0].getMeasuredHeight();
    int i1 = this.l[0].getMeasuredWidth();
    Object localObject2;
    if (paramInt1 < paramInt2)
    {
      this.z = ((this.mWidth - i1) / 2);
      localObject2 = getGLRootView();
      if (localObject2 != null) {
        break label92;
      }
    }
    label92:
    do
    {
      return;
      this.z = (this.mWidth - i1 - 50);
      break;
      this.B = ((GLContentView)localObject2).getDepthForProjectScale(0.8F);
      float f1 = ((GLContentView)localObject2).getDepthForProjectScale(0.5F) / 4.0F;
      i1 = 0;
      while (i1 < 5)
      {
        this.deeps[i1] = (i1 * f1);
        i1 += 1;
      }
      this.bottomY[0] = (-paramInt2 + this.m);
      Object localObject1 = this.h;
      ((GLContentView)localObject2).getCameraWorldPosition((float[])localObject1);
      localObject2 = this.i;
      ((Point)localObject2).set(localObject1[0], localObject1[1], localObject1[2]);
      localObject1 = this.j;
      i1 = 1;
      while (i1 < 5)
      {
        float[] arrayOfFloat = this.h;
        arrayOfFloat[0] = (paramInt1 / 2);
        arrayOfFloat[1] = this.bottomY[(i1 - 1)];
        arrayOfFloat[2] = this.deeps[(i1 - 1)];
        ((Point)localObject1).set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
        localRay.set((Point)localObject2, (Point)localObject1);
        localRay.startCast();
        localPlane.set(new Point(0.0F, 0.0F, this.deeps[i1]), new Vector(0.0F, 0.0F, 1.0F));
        localPlane.intersect(localRay);
        localObject1 = localRay.getHitPoint();
        this.bottomY[i1] = (((Point)localObject1).y + this.m);
        i1 += 1;
      }
      this.r = (-this.deeps[1] * 5.0F - this.B);
      this.u = (-paramInt2 - this.m);
      paramInt1 = i2;
      while (paramInt1 < 5)
      {
        this.s[paramInt1] = this.r;
        this.t[paramInt1] = this.u;
        paramInt1 += 1;
      }
    } while (this.f);
    a(1.0F);
    invalidate();
  }
  
  private void a(Context paramContext)
  {
    this.x = e.a().e(this.w);
    this.y = e.a().f(this.w);
    setIsClearForUpdateFalse();
  }
  
  private float b(float paramFloat)
  {
    return -(float)Math.pow(2.0D, -paramFloat);
  }
  
  private void b()
  {
    int[] arrayOfInt = new int[7];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131165326;
    int[] tmp12_6 = tmp6_5;
    tmp12_6[1] = 2131165327;
    int[] tmp18_12 = tmp12_6;
    tmp18_12[2] = 2131165328;
    int[] tmp24_18 = tmp18_12;
    tmp24_18[3] = 2131165329;
    int[] tmp30_24 = tmp24_18;
    tmp30_24[4] = 2131165330;
    int[] tmp36_30 = tmp30_24;
    tmp36_30[5] = 2131165331;
    int[] tmp42_36 = tmp36_30;
    tmp42_36[6] = 2131165332;
    tmp42_36;
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      this.v[i1] = this.w.getResources().getString(arrayOfInt[i1]);
      i1 += 1;
    }
  }
  
  private float c(float paramFloat)
  {
    paramFloat = d(10 * paramFloat + -2);
    float f1 = d(8);
    float f2 = d(-2);
    return (paramFloat - f2) / (f1 - f2);
  }
  
  private void c()
  {
    this.c = false;
  }
  
  private float d(float paramFloat)
  {
    return (float)Math.pow(2.0D, paramFloat);
  }
  
  public void cleanup()
  {
    this.J = false;
    super.cleanup();
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (!this.J) {
      return;
    }
    if (this.d == -1L) {
      this.d = getDrawingTime();
    }
    long l1 = getDrawingTime();
    long l2 = this.d;
    if (this.e != 0) {}
    for (float f1 = (float)(l1 - l2) / this.e;; f1 = 1.0F)
    {
      f1 = Math.max(0.0F, Math.min(f1, 1.0F));
      if (this.c) {
        a(f1);
      }
      int i1 = 4;
      while (i1 >= 0)
      {
        int i2 = paramGLCanvas.save();
        paramGLCanvas.translate(0.0F, 0.0F, this.B);
        paramGLCanvas.translate(this.z, this.t[i1], this.s[i1]);
        if (this.s[i1] + this.B < this.m) {
          this.l[i1].draw(paramGLCanvas);
        }
        paramGLCanvas.restoreToCount(i2);
        i1 -= 1;
      }
      break;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public float getInterpor(float paramFloat)
  {
    paramFloat = b(10 * paramFloat + -2);
    float f1 = b(8);
    float f2 = b(-2);
    return (paramFloat - f2) / (f1 - f2);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(this.mWidth, this.mHeight);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mHasGetCanvasT = false;
    this.C = true;
  }
  
  public void setDataHandler(com.gtp.nextlauncher.widget.weatherwidget.e parame, int paramInt)
  {
    this.A = parame;
    this.E = paramInt;
  }
  
  public void setIsClearForUpdateFalse()
  {
    int i1 = 0;
    while (i1 < 5)
    {
      this.n[i1].setIsClearForUpdate(false);
      this.p[i1].setIsClearForUpdate(false);
      i1 += 1;
    }
  }
  
  public void setNight(boolean paramBoolean)
  {
    int i2 = 0;
    if (!this.J) {}
    for (;;)
    {
      return;
      int i1;
      if (paramBoolean)
      {
        int i3 = -2629660;
        this.g = true;
        i1 = 0;
        while (i1 < 5)
        {
          this.o[i1].showTextShadow();
          this.q[i1].showTextShadow();
          i1 += 1;
        }
        a();
        i1 = i3;
      }
      while (i2 < 5)
      {
        this.o[i2].setTextColor(i1);
        this.q[i2].setTextColor(i1);
        i2 += 1;
        continue;
        this.g = false;
        i1 = 0;
        while (i1 < 5)
        {
          this.o[i1].hideTextShadow();
          this.q[i1].hideTextShadow();
          i1 += 1;
        }
        i1 = -13552052;
        a();
      }
    }
  }
  
  public void setTempreture(int paramInt, String paramString)
  {
    if (!this.J) {
      return;
    }
    this.q[paramInt].setText(paramString);
  }
  
  public void setWeatherIcon(int paramInt, GLDrawable paramGLDrawable)
  {
    if (!this.J) {
      return;
    }
    this.p[paramInt].setImageDrawable(paramGLDrawable);
  }
  
  public void setWeekday(int paramInt, String paramString)
  {
    if (!this.J) {
      return;
    }
    this.o[paramInt].setText(paramString);
  }
  
  public boolean startForeAnimation(boolean paramBoolean)
  {
    updateUI();
    if (this.c) {
      return false;
    }
    this.f = paramBoolean;
    this.d = -1L;
    invalidate();
    this.c = true;
    return true;
  }
  
  public void updateUI()
  {
    if (!this.J) {
      return;
    }
    if (this.F == null) {
      this.F = new g(this.w);
    }
    GLDrawable[] arrayOfGLDrawable;
    label43:
    int i1;
    int i4;
    int i3;
    int i2;
    label142:
    ForecastBean localForecastBean;
    if (!this.g)
    {
      arrayOfGLDrawable = this.x;
      if (this.A.b(this.E) == null) {
        break label434;
      }
      i1 = this.A.b(this.E).k.n();
      this.G = this.F.b(i1);
      i4 = this.G.month + 1;
      int i5 = this.G.monthDay;
      ArrayList localArrayList = this.A.b(this.E).g;
      i3 = -1;
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break label488;
      }
      i2 = 0;
      i1 = i3;
      if (i2 < localArrayList.size())
      {
        localForecastBean = (ForecastBean)localArrayList.get(i2);
        if (((localForecastBean.f() != i4) || (localForecastBean.g() != i5)) && ((localForecastBean.f() != i4) || (localForecastBean.g() <= i5)) && (localForecastBean.f() <= i4)) {
          break label436;
        }
        i1 = i2;
      }
      if ((i1 < 0) || (i1 >= localArrayList.size())) {
        break label488;
      }
      i2 = i1;
      label237:
      if ((i2 >= i1 + 5) || (i2 >= localArrayList.size()) || (i2 - i1 >= 5)) {
        break label488;
      }
      localForecastBean = (ForecastBean)localArrayList.get(i2);
      if (i2 != i1) {
        break label443;
      }
      this.n[(i2 - i1)].setBackgroundColor(1431655935);
      this.l[(i2 - i1)].setBackgroundResource(2130838888);
      label308:
      i3 = localForecastBean.i() - 1;
      if ((i3 < 0) || (i3 >= 8)) {
        break label474;
      }
      setWeatherIcon(i2 - i1, arrayOfGLDrawable[(localForecastBean.i() - 1)]);
    }
    for (;;)
    {
      setWeekday(i2 - i1, localForecastBean.h());
      i3 = (int)localForecastBean.b(com.gtp.nextlauncher.widget.weatherwidget.e.a);
      i4 = (int)localForecastBean.a(com.gtp.nextlauncher.widget.weatherwidget.e.a);
      setTempreture(i2 - i1, i3 + "°" + "/" + i4 + "°");
      i2 += 1;
      break label237;
      arrayOfGLDrawable = this.y;
      break label43;
      label434:
      break;
      label436:
      i2 += 1;
      break label142;
      label443:
      this.n[(i2 - i1)].setBackgroundColor(16777215);
      this.l[(i2 - i1)].setBackgroundColor(16777215);
      break label308;
      label474:
      setWeatherIcon(i2 - i1, arrayOfGLDrawable[0]);
    }
    label488:
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/ForecastView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */