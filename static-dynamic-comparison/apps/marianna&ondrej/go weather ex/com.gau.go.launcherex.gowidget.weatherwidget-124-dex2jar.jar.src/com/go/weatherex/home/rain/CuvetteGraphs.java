package com.go.weatherex.home.rain;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.h.a;
import java.util.ArrayList;

public class CuvetteGraphs
  extends View
{
  private Context a;
  private f b;
  private g c;
  private e d;
  private String[] e;
  private String f;
  private Time g;
  private float h;
  private float i;
  private float j;
  private float k;
  private NinePatch l;
  private NinePatch m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private Paint u;
  private Paint v;
  private RectF w;
  private SparseArray x;
  private boolean y;
  
  public CuvetteGraphs(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CuvetteGraphs(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CuvetteGraphs(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.setToNow();
    this.g.set(paramInt3, paramInt2 - 1, paramInt1);
    this.g.normalize(false);
    return this.e[this.g.weekDay];
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.x = new SparseArray();
    this.w = new RectF();
    Object localObject = com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext);
    this.b = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).h();
    this.c = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).g();
    this.d = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).f();
    this.g = new Time();
    this.u = new Paint(33);
    this.u.setTextAlign(Paint.Align.CENTER);
    this.u.setTextSize(paramContext.getResources().getDimension(2131427654));
    this.u.setColor(-1);
    this.v = new Paint(this.u);
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2130837928);
    Bitmap localBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130837929);
    this.s = (((Bitmap)localObject).getHeight() * 0.48F);
    this.t = (((Bitmap)localObject).getHeight() * 0.13F);
    this.n = (Math.max(((Bitmap)localObject).getWidth(), 1.0F) * 1.05F);
    this.o = Math.max(localBitmap.getWidth(), 1.0F);
    this.p = Math.max(localBitmap.getHeight(), 1.0F);
    this.l = new NinePatch((Bitmap)localObject, ((Bitmap)localObject).getNinePatchChunk(), null);
    this.m = new NinePatch(localBitmap, localBitmap.getNinePatchChunk(), null);
    this.f = r.e(paramContext.getResources().getString(2131165919));
    this.e = com.gau.go.launcherex.gowidget.weather.util.c.h(paramContext);
    int i1 = this.e.length - 1;
    while (i1 > -1)
    {
      this.e[i1] = r.e(this.e[i1]);
      i1 -= 1;
    }
    localObject = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Regular.ttf");
    this.u.setTypeface((Typeface)localObject);
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Light.ttf");
    this.v.setTypeface(paramContext);
  }
  
  public void a()
  {
    if (this.l != null) {
      this.l = null;
    }
    if (this.m != null) {
      this.m = null;
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null) {}
    for (int i1 = paramArrayList.size(); i1 <= 0; i1 = 0)
    {
      this.y = false;
      this.x.clear();
      return;
    }
    paramString = this.b.a(paramString);
    Time localTime;
    if (paramString != null)
    {
      i2 = paramString.k.n();
      localTime = this.c.c(i2);
      if (i1 > 3) {
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        paramString = (ForecastBean)paramArrayList.get(0);
        if ((i2 + 3 == i1) || (r.a(paramString.e(), paramString.f(), paramString.g(), localTime)) || (a.a(paramString.e(), paramString.f(), paramString.g(), localTime)))
        {
          while (paramArrayList.size() > 3) {
            paramArrayList.remove(3);
          }
          i2 = 0;
          break;
        }
        paramArrayList.remove(0);
        i2 += 1;
      }
    }
    if (this.x.size() > paramArrayList.size()) {
      this.x.clear();
    }
    this.f = r.e(this.a.getResources().getString(2131165919));
    this.e = com.gau.go.launcherex.gowidget.weather.util.c.h(this.a);
    i1 = this.e.length - 1;
    while (i1 > -1)
    {
      this.e[i1] = r.e(this.e[i1]);
      i1 -= 1;
    }
    int i2 = 0;
    i1 = 0;
    while (i2 < paramArrayList.size())
    {
      ForecastBean localForecastBean = (ForecastBean)paramArrayList.get(i2);
      b localb = (b)this.x.get(i2);
      paramString = localb;
      if (localb == null)
      {
        paramString = new b(this, null);
        this.x.put(i2, paramString);
      }
      if (localForecastBean == null)
      {
        i2 += 1;
      }
      else
      {
        int i3 = this.d.a().k;
        paramString.b(r.a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), false, i3));
        if ((i1 == 0) && (r.a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), localTime)))
        {
          paramString.a(this.f);
          i1 = 1;
        }
        for (;;)
        {
          paramString.a(localForecastBean.m());
          break;
          paramString.a(a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g()));
        }
      }
    }
    this.y = true;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((!this.y) || (this.x.size() == 0)) {
      return;
    }
    int i2 = this.x.size();
    if (this.q <= 0.0F)
    {
      this.q = Math.max((this.k - this.u.getTextSize() * 5.8F - this.s - this.t - this.p) / 100.0F, 0.01F);
      Log.d("liuhui", "mCellHeight = " + this.q);
    }
    float f1;
    int i1;
    label134:
    label146:
    b localb;
    if (this.r <= 0.0F)
    {
      f1 = this.j;
      if (i2 != 0)
      {
        i1 = i2;
        this.r = (f1 / i1);
      }
    }
    else
    {
      i1 = 0;
      if (i1 < i2)
      {
        localb = (b)this.x.get(i1);
        if (localb != null) {
          break label187;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label146;
      break;
      i1 = 1;
      break label134;
      label187:
      this.w.left = ((this.r - this.n) / 2.0F + this.r * i1 + this.i);
      this.w.top = (this.h + this.u.getTextSize() * 2.2F);
      this.w.right = (this.w.left + this.n);
      this.w.bottom = (this.k + this.h - this.u.getTextSize() * 3.6000001F);
      this.l.draw(paramCanvas, this.w);
      if (localb.a() > 0)
      {
        this.w.bottom = (this.k + this.h - this.t - this.u.getTextSize() * 3.6000001F);
        this.w.left = ((this.r - this.o) / 2.0F + this.r * i1 + this.i);
        this.w.top = (this.w.bottom - this.q * localb.a() - this.p);
        this.w.right = (this.w.left + this.o);
        this.m.draw(paramCanvas, this.w);
      }
      f1 = this.r / 2.0F + this.r * i1 + this.i;
      float f2 = this.h;
      float f3 = this.u.getTextSize();
      paramCanvas.drawText(localb.a() + "%", f1, f2 + f3 * 1.2F, this.v);
      f2 = this.k;
      f3 = this.h;
      float f4 = this.u.getTextSize();
      paramCanvas.drawText(localb.b(), f1, f2 + f3 - f4 * 1.8000002F, this.u);
      f2 = this.k;
      f3 = this.h;
      f4 = this.u.getTextSize();
      paramCanvas.drawText(localb.c(), f1, f2 + f3 - f4 * 0.50000024F, this.u);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = getPaddingTop();
    this.i = getPaddingLeft();
    this.j = (getWidth() - getPaddingLeft() - getPaddingRight());
    this.k = (getHeight() - getPaddingTop() - getPaddingBottom());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/rain/CuvetteGraphs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */