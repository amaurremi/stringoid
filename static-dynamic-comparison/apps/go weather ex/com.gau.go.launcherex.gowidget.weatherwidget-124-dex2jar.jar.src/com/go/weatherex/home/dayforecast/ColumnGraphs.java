package com.go.weatherex.home.dayforecast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;

public class ColumnGraphs
  extends View
{
  private Context a;
  private SparseArray b;
  private f c;
  private e d;
  private g e;
  private NinePatch f;
  private NinePatch g;
  private float h;
  private RectF i;
  private boolean j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private Paint r;
  private float s;
  private float t;
  private c u;
  private float v = 1.0F;
  
  public ColumnGraphs(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ColumnGraphs(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ColumnGraphs(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new SparseArray();
    Object localObject = BitmapFactory.decodeResource(this.a.getResources(), 2130837901);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130837902);
    this.h = (Math.max(((Bitmap)localObject).getHeight(), localBitmap.getHeight()) / 2.0F + 1.0F);
    this.f = new NinePatch((Bitmap)localObject, ((Bitmap)localObject).getNinePatchChunk(), null);
    this.g = new NinePatch(localBitmap, localBitmap.getNinePatchChunk(), null);
    this.i = new RectF();
    localObject = com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext);
    this.c = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).h();
    this.d = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).f();
    this.e = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).g();
    this.r = new Paint(33);
    this.r.setTextAlign(Paint.Align.CENTER);
    this.r.setTextSize(paramContext.getResources().getDimension(2131427654));
    this.r.setColor(-1);
  }
  
  public void a()
  {
    if (this.f != null) {
      this.f = null;
    }
    if (this.g != null) {
      this.g = null;
    }
    this.b.clear();
  }
  
  public void a(String paramString, ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.j = true;
      int i4 = paramArrayList.size();
      if (this.b.size() > i4) {
        this.b.clear();
      }
      float f2 = -10000.0F;
      float f1 = 10000.0F;
      int i3 = 0;
      paramString = this.c.a(paramString);
      int i1;
      Time localTime;
      float f3;
      int i2;
      label95:
      ForecastBean localForecastBean;
      float f4;
      if (paramString != null)
      {
        i1 = paramString.k.n();
        localTime = this.e.c(i1);
        f3 = 0.0F;
        i2 = 0;
        i1 = i3;
        if (i2 >= i4) {
          break label364;
        }
        localForecastBean = (ForecastBean)paramArrayList.get(i2);
        if (localForecastBean != null) {
          break label165;
        }
        f4 = f3;
        f3 = f2;
        f2 = f1;
        f1 = f4;
      }
      for (;;)
      {
        i2 += 1;
        f4 = f2;
        f2 = f3;
        f3 = f1;
        f1 = f4;
        break label95;
        i1 = 0;
        break;
        label165:
        b localb = (b)this.b.get(i2);
        paramString = localb;
        if (localb == null)
        {
          paramString = new b(this, null);
          this.b.put(i2, paramString);
        }
        i3 = this.d.a().g;
        paramString.a(Math.round(localForecastBean.b(i3)), Math.round(localForecastBean.a(i3)));
        paramString.e(0.0F);
        paramString.a(1.0F);
        paramString.c(false);
        f4 = f3 + paramString.c();
        f3 = f2;
        if (f2 < paramString.b()) {
          f3 = paramString.b();
        }
        f2 = f1;
        if (f1 > paramString.a()) {
          f2 = paramString.a();
        }
        if ((i1 == 0) && (r.a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), localTime)))
        {
          paramString.a(true);
          i1 = 1;
          f1 = f4;
        }
        else
        {
          paramString.a(false);
          f1 = f4;
        }
      }
      label364:
      this.s = f2;
      this.t = f1;
      if ((paramBoolean) && (f3 > 0.0F))
      {
        f1 = 0.0F;
        i1 = 0;
        while (i1 < this.b.size())
        {
          paramString = (b)this.b.get(i1);
          f2 = Math.max(paramString.c(), 0.5F) / f3;
          paramString.c(f1);
          paramString.d(f2);
          paramString.a(0.0F);
          f1 += f2;
          i1 += 1;
        }
      }
      if (paramBoolean)
      {
        if (this.u == null)
        {
          this.u = new c(this, null);
          this.u.setStartOffset(360L);
          this.u.setDuration(1450L);
          this.u.setInterpolator(new LinearInterpolator());
        }
        clearAnimation();
        startAnimation(this.u);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.j = false;
      this.b.clear();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.j) {
      return;
    }
    int i2 = this.b.size();
    float f1 = this.m;
    int i1;
    label31:
    float f2;
    float f3;
    label79:
    label96:
    b localb;
    if (i2 != 0)
    {
      i1 = i2;
      this.o = (f1 / i1);
      f2 = this.n;
      f3 = this.r.getTextSize();
      if (this.s == this.t) {
        break label147;
      }
      f1 = Math.abs(this.s - this.t);
      this.p = ((f2 - f3 * 3.2F) / f1);
      i1 = 0;
      if (i1 < i2)
      {
        localb = (b)this.b.get(i1);
        if ((localb != null) && (localb.f() != 0.0F)) {
          break label152;
        }
      }
    }
    label147:
    label152:
    label549:
    for (;;)
    {
      i1 += 1;
      break label96;
      break;
      i1 = 1;
      break label31;
      f1 = 1.0F;
      break label79;
      f2 = Math.max(localb.g() * this.p, this.h);
      f3 = this.l;
      float f4 = this.o;
      float f5 = i1;
      float f6 = (this.o - this.q) / 2.0F;
      f1 = this.k + this.r.getTextSize() * 1.6F + Math.abs(this.s - localb.e()) * this.p - f2 - localb.j() * this.p;
      float f7 = this.l;
      float f8 = this.o;
      float f9 = i1 + 1;
      float f10 = (this.o - this.q) / 2.0F;
      f2 = f2 + (this.k + this.r.getTextSize() * 1.6F + Math.abs(this.s - localb.e()) * this.p) + localb.j() * this.p;
      this.i.set(f3 + f4 * f5 + f6, f1, f7 + f8 * f9 - f10, f2);
      if (localb.d()) {
        if (this.g != null) {
          this.g.draw(paramCanvas, this.i);
        }
      }
      for (;;)
      {
        if (localb.f() != 1.0F) {
          break label549;
        }
        f3 = this.l + this.o * i1 + this.o / 2.0F;
        f4 = this.r.getTextSize();
        paramCanvas.drawText((int)localb.b() + "°", f3, f1 - f4 * 0.7F, this.r);
        f1 = Math.round(this.r.getTextSize() * 1.4F);
        paramCanvas.drawText((int)localb.a() + "°", f3, f2 + f1, this.r);
        break;
        if (this.f != null) {
          this.f.draw(paramCanvas, this.i);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = getPaddingTop();
    this.l = getPaddingLeft();
    this.m = (getWidth() - getPaddingLeft() - getPaddingRight());
    this.n = (getHeight() - getPaddingTop() - getPaddingBottom());
    this.q = (this.m / 10.0F * 0.4F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/dayforecast/ColumnGraphs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */