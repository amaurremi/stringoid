package com.go.weatherex.home.hourforecast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.HourlyBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.a.a.d.a;
import java.util.ArrayList;

public class TrendGraphs
  extends View
{
  private float A;
  private float B;
  private float C;
  private float D;
  private int E;
  private int F;
  private float G;
  private float H = 0.0F;
  private boolean I = false;
  private float J = 4.0F;
  private i K;
  private NinePatch L;
  private NinePatch M;
  private float N = 20.0F;
  private Paint O;
  private float P;
  private boolean Q = false;
  private Context a;
  private SparseArray b;
  private e c;
  private com.gau.go.launcherex.gowidget.weather.d.f d;
  private com.gau.go.launcherex.gowidget.weather.util.f e;
  private NinePatch f;
  private NinePatch g;
  private Bitmap[] h;
  private float i;
  private Bitmap j;
  private float k;
  private g[] l = { new g(this), new g(this) };
  private RectF m;
  private Path n;
  private Paint o;
  private Paint p;
  private Paint q;
  private Paint r;
  private Paint s;
  private Path t;
  private boolean u;
  private float v;
  private float w;
  private float x;
  private float y;
  private float z;
  
  public TrendGraphs(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TrendGraphs(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TrendGraphs(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new SparseArray();
    Object localObject = c.a(paramContext);
    this.c = ((c)localObject).f();
    this.d = ((c)localObject).e();
    this.e = ((c)localObject).h();
    this.G = paramContext.getResources().getDisplayMetrics().density;
    this.j = BitmapFactory.decodeResource(this.a.getResources(), 2130837909);
    if (this.j != null) {
      this.k = (this.j.getWidth() / 2.2F);
    }
    localObject = BitmapFactory.decodeResource(this.a.getResources(), 2130837924);
    Bitmap localBitmap1 = BitmapFactory.decodeResource(this.a.getResources(), 2130837923);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(this.a.getResources(), 2130837911);
    Bitmap localBitmap3 = BitmapFactory.decodeResource(this.a.getResources(), 2130837912);
    Paint localPaint = new Paint(3);
    localPaint.setTextAlign(Paint.Align.CENTER);
    this.P = (Math.max(localBitmap2.getHeight(), localBitmap3.getHeight()) / 2.0F);
    this.f = new NinePatch((Bitmap)localObject, ((Bitmap)localObject).getNinePatchChunk(), null);
    this.f.setPaint(localPaint);
    this.g = new NinePatch(localBitmap1, localBitmap1.getNinePatchChunk(), null);
    this.g.setPaint(localPaint);
    this.L = new NinePatch(localBitmap2, localBitmap2.getNinePatchChunk(), null);
    this.L.setPaint(localPaint);
    this.M = new NinePatch(localBitmap3, localBitmap3.getNinePatchChunk(), null);
    this.M.setPaint(localPaint);
    this.m = new RectF();
    this.n = new Path();
    this.N *= this.a.getResources().getDisplayMetrics().density;
    this.h = new Bitmap[com.gau.go.launcherex.gowidget.scriptengine.parser.i.h.length];
    int i1 = 0;
    while (i1 < this.h.length)
    {
      this.h[i1] = r.a(BitmapFactory.decodeResource(this.a.getResources(), com.gau.go.launcherex.gowidget.scriptengine.parser.i.h[i1]), 0.8F);
      i1 += 1;
    }
    this.i = (Math.max(this.h[0].getWidth(), this.h[0].getHeight()) / 2.0F);
    this.p = new Paint(3);
    this.p.setStrokeWidth(a.a(paramContext, 1.7F));
    this.p.setTextAlign(Paint.Align.CENTER);
    this.p.setColor(-922746881);
    this.s = new Paint(3);
    this.s.setStrokeWidth(a.a(paramContext, 1.7F) / 2.5F);
    this.s.setTextAlign(Paint.Align.CENTER);
    this.s.setColor(-1325400065);
    this.s.setStyle(Paint.Style.STROKE);
    float f1 = this.G;
    float f2 = this.G;
    float f3 = this.G;
    float f4 = this.G;
    float f5 = this.G;
    localObject = new DashPathEffect(new float[] { f1 * 2.0F, 1.5F * f2, f3 * 2.0F, 1.5F * f4 }, f5);
    this.s.setPathEffect((PathEffect)localObject);
    this.t = new Path();
    this.q = new Paint(3);
    this.q.setStrokeWidth(a.a(paramContext, 1.7F));
    this.q.setTextAlign(Paint.Align.CENTER);
    this.q.setColor(620756991);
    this.o = new Paint(33);
    this.o.setTextAlign(Paint.Align.CENTER);
    this.o.setColor(-1);
    this.o.setTextSize(paramContext.getResources().getDimension(2131427654));
    this.O = new Paint(33);
    this.O.setTextAlign(Paint.Align.CENTER);
    this.O.setColor(-1);
    this.O.setTextSize(paramContext.getResources().getDimension(2131427657));
    this.P = (Math.max(this.P, this.O.getTextSize() * 1.8F) / 2.0F);
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Light.ttf");
    if (paramContext != null) {
      this.O.setTypeface(paramContext);
    }
    this.r = new Paint(3);
    this.r.setTextAlign(Paint.Align.CENTER);
    this.K = new i(this, null);
    this.K.setStartOffset(300L);
    this.K.setDuration(1050L);
    this.K.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  private void a(h paramh)
  {
    if (paramh.c())
    {
      if (paramh.b() < this.J)
      {
        paramh.a(paramh.b() + 1.0F);
        return;
      }
      paramh.a(false);
      return;
    }
    if (paramh.b() > 0.0F)
    {
      paramh.a(paramh.b() - 1.0F);
      return;
    }
    paramh.b(true);
  }
  
  private void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.k > 0.0F)
    {
      float f1 = Math.abs(paramFloat3 - paramFloat1) * this.k / (float)Math.sqrt(Math.pow(paramFloat2 - paramFloat4, 2.0D) + Math.pow(paramFloat1 - paramFloat3, 2.0D));
      if (paramBoolean)
      {
        this.l[0].a = (f1 + paramFloat1);
        this.l[0].b = ((paramFloat2 - paramFloat4) * this.l[0].a / (paramFloat1 - paramFloat3) + (paramFloat1 * paramFloat4 - paramFloat3 * paramFloat2) / (paramFloat1 - paramFloat3));
        return;
      }
      this.l[1].a = (paramFloat3 - f1);
      this.l[1].b = ((paramFloat2 - paramFloat4) * this.l[1].a / (paramFloat1 - paramFloat3) + (paramFloat1 * paramFloat4 - paramFloat3 * paramFloat2) / (paramFloat1 - paramFloat3));
      return;
    }
    this.l[0].a = paramFloat1;
    this.l[0].b = paramFloat2;
    this.l[1].a = paramFloat3;
    this.l[1].b = paramFloat4;
  }
  
  private boolean a(WeatherBean paramWeatherBean, int paramInt)
  {
    boolean bool = true;
    if (paramWeatherBean != null)
    {
      String str = paramWeatherBean.k.j();
      paramWeatherBean = paramWeatherBean.k.k();
      bool = r.a(paramInt, r.a(true, str), r.a(false, paramWeatherBean));
    }
    return bool;
  }
  
  public void a()
  {
    if (this.j != null)
    {
      if (!this.j.isRecycled()) {
        this.j.recycle();
      }
      this.j = null;
    }
    if (this.f != null) {
      this.f = null;
    }
    if (this.g != null) {
      this.g = null;
    }
    if (this.L != null) {
      this.L = null;
    }
    if (this.M != null) {
      this.M = null;
    }
    this.b.clear();
    if (this.h != null)
    {
      int i1 = 0;
      while (i1 < this.h.length)
      {
        if ((this.h[i1] != null) && (!this.h[i1].isRecycled()))
        {
          this.h[i1].recycle();
          this.h[i1] = null;
        }
        i1 += 1;
      }
      this.h = null;
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList, boolean paramBoolean)
  {
    int i7;
    int i1;
    int i4;
    int i5;
    WeatherBean localWeatherBean;
    int i2;
    int i8;
    int i6;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.I = paramBoolean;
      this.u = true;
      i7 = paramArrayList.size();
      if (this.b.size() > i7) {
        this.b.clear();
      }
      i1 = 0;
      i4 = 55536;
      i5 = 10000;
      this.Q = this.d.b();
      localWeatherBean = this.e.a(paramString);
      i2 = 0;
      i8 = ((HourlyBean)paramArrayList.get(0)).d();
      i6 = 0;
      if (i6 < i7)
      {
        paramString = (h)this.b.get(i6);
        if (paramString != null) {
          break label554;
        }
        paramString = new h(this, null);
        this.b.put(i6, paramString);
      }
    }
    label358:
    label554:
    for (;;)
    {
      Object localObject = (HourlyBean)paramArrayList.get(i6);
      if (localObject == null)
      {
        i3 = i4;
        i6 += 1;
        i4 = i3;
        break;
      }
      paramString.b(((HourlyBean)localObject).d());
      paramString.c(r.a(((HourlyBean)localObject).e(), a(localWeatherBean, ((HourlyBean)localObject).d())));
      paramString.a(Math.round(((HourlyBean)localObject).b(this.c.a().g)));
      paramString.e(0);
      paramString.d(-1);
      int i3 = i4;
      if (i4 < paramString.a()) {
        i3 = paramString.a();
      }
      i4 = i5;
      if (i5 > paramString.a()) {
        i4 = paramString.a();
      }
      if ((this.Q) && (i6 % 2 == i8 % 2) && (i6 > 1))
      {
        localObject = (h)this.b.get(i6 - 2);
        if (paramString.g() != ((h)localObject).g())
        {
          ((h)localObject).d(((h)localObject).g());
          ((h)localObject).e(i6 - 1 - i2);
          i5 = i6 - 1;
          if (i6 != i7 - 1)
          {
            i2 = i5;
            if (i6 != i7 - 2) {}
          }
          else
          {
            paramString.d(paramString.g());
            paramString.e(i6 - 1 - i5);
            i2 = i5;
          }
        }
      }
      for (;;)
      {
        if (this.Q)
        {
          if ((i1 == 0) && (paramString.e() == 0))
          {
            paramString.c(true);
            i1 = 1;
            i5 = i4;
            break;
          }
          paramString.c(false);
          i5 = i4;
          break;
        }
        if ((i1 == 0) && (paramString.e() >= 0) && (paramString.e() <= 3))
        {
          paramString.c(true);
          i1 = 1;
          i5 = i4;
          break;
        }
        paramString.c(false);
        i5 = i4;
        break;
        this.E = i4;
        this.F = i5;
        if (paramBoolean)
        {
          clearAnimation();
          startAnimation(this.K);
        }
        for (;;)
        {
          invalidate();
          return;
          this.u = false;
          this.b.clear();
        }
        i5 = i2;
        break label358;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.u) {
      return;
    }
    if (!this.I) {
      this.H = getWidth();
    }
    int i11 = this.b.size();
    float f1 = this.y;
    int i1;
    label91:
    int i4;
    int i2;
    int i5;
    float f6;
    float f2;
    float f3;
    if (i11 - 1 != 0)
    {
      i1 = i11 - 1;
      this.C = (f1 / i1);
      f1 = this.z;
      if (this.E - this.F == 0) {
        break label904;
      }
      i1 = Math.abs(this.E - this.F);
      this.D = (f1 / i1);
      i4 = 0;
      i2 = 0;
      i5 = 0;
      this.n.reset();
      f6 = -this.p.getStrokeWidth();
      f1 = this.v;
      f1 = this.w;
      f2 = Math.abs(this.E - ((h)this.b.get(0)).a()) * this.D + this.v;
      if (((h)this.b.get(0)).a() >= ((h)this.b.get(1)).a()) {
        break label910;
      }
      f3 = -f1 / 4.0F + f2 + f6 / 4.0F;
      label216:
      if (((h)this.b.get(0)).a() != this.E) {
        break label927;
      }
      i2 = 1;
      a(false, f6, f3, f1, f2);
      f1 = this.l[1].a;
      f2 = this.l[1].b;
      i1 = 0;
    }
    for (;;)
    {
      label274:
      float f5 = f1;
      float f4 = f2;
      if (f1 > this.H)
      {
        f4 = (this.H * (f3 - f2) + f2 * f6 - f3 * f1) / (f6 - f1);
        f5 = this.H;
      }
      paramCanvas.drawLine(f6, f3, f5, f4, this.p);
      this.n.moveTo(f6, this.B);
      this.n.lineTo(f6, f3);
      this.n.lineTo(f5, f4);
      if (this.H < this.w) {
        this.n.lineTo(f5, this.B);
      }
      int i7 = 0;
      int i6 = 0;
      int i8 = i2;
      label407:
      int i3;
      if (i6 < i11 - 1)
      {
        f5 = this.w + this.C * i6;
        f6 = Math.abs(this.E - ((h)this.b.get(i6)).a()) * this.D + this.v;
        f1 = this.w + this.C * (i6 + 1);
        f2 = Math.abs(this.E - ((h)this.b.get(i6 + 1)).a()) * this.D + this.v;
        if ((i4 == 0) && (((h)this.b.get(i6)).a() == this.E))
        {
          i2 = 1;
          a(true, f5, f6, f1, f2);
          f3 = this.l[0].a;
          f4 = this.l[0].b;
          i3 = i5;
          label587:
          if ((i8 != 0) || (((h)this.b.get(i6 + 1)).a() != this.E)) {
            break label1087;
          }
          i8 = 1;
          a(false, f3, f4, f1, f2);
          f1 = this.l[1].a;
          f2 = this.l[1].b;
          label650:
          f6 = f1;
          f5 = f2;
          i4 = i7;
          if (f1 > this.H)
          {
            f6 = f1;
            f5 = f2;
            i4 = i7;
            if (this.H > this.w)
            {
              f5 = (this.H * (f4 - f2) + f2 * f3 - f4 * f1) / (f3 - f1);
              f6 = this.H;
              i4 = 1;
            }
          }
          if (this.H > this.w) {
            paramCanvas.drawLine(f3, f4, f6, f5, this.p);
          }
          if (i4 == 0) {
            break label1153;
          }
          i8 = i2;
          i7 = i3;
        }
      }
      for (;;)
      {
        i5 = 0;
        i2 = 0;
        i3 = 0;
        i6 = 0;
        f2 = this.B - this.N - this.O.getTextSize() * 0.32F;
        f3 = f2 - this.P - this.i * 2.5F;
        i1 = 0;
        int i12 = ((h)this.b.get(0)).e();
        int i9 = 0;
        h localh2;
        label877:
        label904:
        label910:
        label927:
        label1087:
        label1153:
        label1224:
        String str;
        for (;;)
        {
          if (i9 < i11)
          {
            localh2 = (h)this.b.get(i9);
            if (localh2 == null)
            {
              i4 = i1;
              i1 = i3;
              i3 = i5;
              i9 += 1;
              i5 = i3;
              i3 = i1;
              i1 = i4;
              continue;
              i1 = 1;
              break;
              i1 = 1;
              break label91;
              f3 = f1 / 4.0F + f2 - f6 / 4.0F;
              break label216;
              if (((h)this.b.get(0)).a() != this.F) {
                break label3303;
              }
              a(false, f6, f3, f1, f2);
              f1 = this.l[1].a;
              f2 = this.l[1].b;
              i1 = 1;
              break label274;
              f3 = f5;
              f4 = f6;
              i3 = i5;
              i2 = i4;
              if (i5 != 0) {
                break label587;
              }
              f3 = f5;
              f4 = f6;
              i3 = i5;
              i2 = i4;
              if (((h)this.b.get(i6)).a() != this.F) {
                break label587;
              }
              i3 = 1;
              a(true, f5, f6, f1, f2);
              f3 = this.l[0].a;
              f4 = this.l[0].b;
              i2 = i4;
              break label587;
              if ((i1 != 0) || (((h)this.b.get(i6 + 1)).a() != this.F)) {
                break label3289;
              }
              a(false, f3, f4, f1, f2);
              f1 = this.l[1].a;
              f2 = this.l[1].b;
              i1 = 1;
              break label650;
              i6 += 1;
              i7 = i4;
              i5 = i3;
              i4 = i2;
              break label407;
            }
            i4 = i5;
            if (i5 == 0)
            {
              i4 = i5;
              if (localh2.f())
              {
                i5 = 1;
                if (i9 == 0) {
                  break label2358;
                }
                f1 = this.w + i9 * this.C - this.C / 2.0F;
                this.m.set(0.0F, f2 - this.P, f1, this.P + f2);
                this.L.draw(paramCanvas, this.m);
                i4 = i5;
                if (i9 != 0)
                {
                  this.m.set(f1, f2 - this.P, this.A, this.P + f2);
                  this.M.draw(paramCanvas, this.m);
                  i4 = i5;
                }
              }
            }
            if (i6 != 0) {
              break label3244;
            }
            str = localh2.a() + "°";
            f1 = this.w;
            f1 = this.C * i9 + f1;
            f4 = Math.abs(this.E - localh2.a());
            f5 = this.D;
            f4 = this.v + f4 * f5;
            if ((f1 < this.H) && (this.H > this.w))
            {
              this.n.lineTo(f1, f4);
              if ((this.Q) && ((!this.Q) || (i9 % 2 != i12 % 2))) {
                break label3286;
              }
              if (this.H >= f1) {
                paramCanvas.drawText(String.valueOf(localh2.e()), f1, this.O.getTextSize() * 0.32F + f2, this.O);
              }
              if ((this.h == null) || (this.h.length <= 0)) {
                break label3286;
              }
              if ((this.Q) || (this.H < f1)) {
                break label2508;
              }
              paramCanvas.drawBitmap(r.a(this.h, localh2.g()), f1 - this.i, f3, this.r);
            }
          }
        }
        label2358:
        label2508:
        label2548:
        label2752:
        label2978:
        label3039:
        label3147:
        label3164:
        label3241:
        label3244:
        label3286:
        for (;;)
        {
          i5 = i2;
          if (i2 == 0)
          {
            i5 = i2;
            if (this.E == localh2.a())
            {
              i5 = i2;
              if (this.H >= this.w + this.C * i9)
              {
                i2 = 1;
                if ((this.j != null) && (!this.j.isRecycled()))
                {
                  f1 = this.j.getWidth() / 2.0F;
                  f4 = this.j.getHeight() / 2.0F;
                  paramCanvas.drawBitmap(this.j, this.w + this.C * i9 - f1, Math.abs(this.E - localh2.a()) * this.D + this.v - f4, this.r);
                }
                i5 = i2;
                if (this.H >= this.A)
                {
                  this.o.setTextSize(this.a.getResources().getDimension(2131427654) + localh2.b() * this.G);
                  f1 = Math.abs(this.E - localh2.a()) * this.D - this.o.getTextSize() * 1.3F;
                  paramCanvas.drawText(str, this.w + this.C * i9, this.v + f1 + 2.0F * this.G, this.o);
                  i5 = i2;
                  if (this.f != null)
                  {
                    f4 = this.o.measureText(str) / 2.0F + this.a.getResources().getDimension(2131427655);
                    f5 = (this.o.descent() - this.o.ascent()) / 2.0F + this.a.getResources().getDimension(2131427656);
                    this.m.set(this.w + this.C * i9 - f4, this.v + f1 - f5, f4 + (this.w + this.C * i9), f1 + this.v + f5);
                    this.f.draw(paramCanvas, this.m);
                    i5 = i2;
                  }
                }
              }
            }
          }
          if ((i3 == 0) && (this.F == localh2.a()) && (this.H >= this.w + this.C * i9))
          {
            if ((this.j != null) && (!this.j.isRecycled()))
            {
              f1 = this.j.getWidth() / 2.0F;
              f4 = this.j.getHeight() / 2.0F;
              paramCanvas.drawBitmap(this.j, this.w + this.C * i9 - f1, Math.abs(this.E - localh2.a()) * this.D + this.v - f4, this.r);
            }
            if (this.H >= this.A)
            {
              this.o.setTextSize(this.a.getResources().getDimension(2131427654) + localh2.b() * this.G);
              f1 = Math.abs(this.E - localh2.a()) * this.D + this.o.getTextSize() * 1.3F;
              paramCanvas.drawText(str, this.w + this.C * i9, f1 - this.o.ascent() + this.v - 5.0F * this.G, this.o);
              if (this.g != null)
              {
                f4 = this.o.measureText(str) / 2.0F + this.a.getResources().getDimension(2131427655);
                f5 = (this.o.descent() - this.o.ascent()) / 2.0F + this.a.getResources().getDimension(2131427656);
                this.m.set(this.w + this.C * i9 - f4, this.v + f1 - f5, f4 + (this.w + this.C * i9), f1 + this.v + f5);
                this.g.draw(paramCanvas, this.m);
              }
            }
            i10 = 1;
            i3 = i4;
            i2 = i5;
            i4 = i1;
            i1 = i10;
            break label877;
            f1 = this.A;
            break label1224;
            if (i9 > 0)
            {
              f5 = this.w;
              f5 = this.C * (i9 - 1) + f5;
              f6 = Math.abs(this.E - ((h)this.b.get(i9 - 1)).a()) * this.D + this.v;
              f4 = (f6 * f1 + this.H * (f4 - f6) - f4 * f5) / (f1 - f5);
              this.n.lineTo(this.H, f4);
            }
            for (;;)
            {
              this.n.lineTo(this.H, this.B);
              i6 = 1;
              break;
              this.n.lineTo(this.H, f4);
            }
            if ((!this.Q) || (localh2.h() < 0)) {
              break label3286;
            }
            h localh1;
            if (i9 < i11 - 2)
            {
              localh1 = (h)this.b.get(i9 + 1);
              if (localh1 != null)
              {
                f1 = this.C * (i9 + 1) + this.w;
                if (this.H >= f1)
                {
                  f4 = Math.abs(this.E - localh1.a());
                  f5 = this.D;
                  f6 = this.v;
                  float f7 = this.k / 2.0F;
                  this.t.reset();
                  this.t.moveTo(f1, f4 * f5 + f6 + f7);
                  this.t.lineTo(f1, f2 - this.P - this.k / 2.0F);
                  paramCanvas.drawPath(this.t, this.s);
                }
              }
              if (i1 != 0) {
                break label2752;
              }
              f1 = (this.w + this.C * (i9 + 1)) / 2.0F - this.i;
            }
            for (;;)
            {
              if (this.H >= f1) {
                paramCanvas.drawBitmap(r.a(this.h, localh2.g()), f1, f3, this.r);
              }
              i1 += localh2.i();
              break;
              localh1 = null;
              break label2548;
              if ((i9 != i11 - 1) && (i9 != i11 - 2)) {
                f1 = this.w + i1 * this.C + localh2.i() * this.C / 2.0F - this.i;
              } else {
                f1 = this.A - ((localh2.i() + i11 - i9) * this.C + this.x) / 2.0F - this.i;
              }
            }
            f2 = this.w + this.C * (i11 - 1);
            f3 = Math.abs(this.E - ((h)this.b.get(i11 - 1)).a()) * this.D + this.v;
            f4 = this.A;
            f1 = this.v;
            if (this.H > this.y + this.w)
            {
              if (((h)this.b.get(i11 - 2)).a() >= ((h)this.b.get(i11 - 1)).a()) {
                break label3147;
              }
              f1 = -f2 / 4.0F + f3 + f4 / 4.0F;
              if ((i8 != 0) || (((h)this.b.get(i11 - 1)).a() != this.E)) {
                break label3164;
              }
              a(true, f2, f3, f4, f1);
              f2 = this.l[0].a;
              f3 = this.l[0].b;
            }
            for (;;)
            {
              if (this.H < this.A)
              {
                f4 = (this.H * (f3 - f1) + f2 * f1 - f3 * f4) / (f2 - f4);
                f1 = this.H;
              }
              for (;;)
              {
                paramCanvas.drawLine(f2, f3, f1, f4, this.p);
                this.n.lineTo(f1, f4);
                this.n.lineTo(f1, this.B);
                this.n.close();
                if (this.H <= 0.0F) {
                  break;
                }
                paramCanvas.drawPath(this.n, this.q);
                return;
                f1 = f2 / 4.0F + f3 - f4 / 4.0F;
                break label2978;
                if ((i7 != 0) || (((h)this.b.get(i11 - 1)).a() != this.F)) {
                  break label3241;
                }
                a(true, f2, f3, f4, f1);
                f2 = this.l[0].a;
                f3 = this.l[0].b;
                break label3039;
                f5 = f1;
                f1 = f4;
                f4 = f5;
              }
            }
            i5 = i3;
            i3 = i4;
            i4 = i1;
            i1 = i5;
            break label877;
          }
          int i10 = i3;
          i2 = i5;
          i3 = i4;
          i4 = i1;
          i1 = i10;
          break label877;
        }
        label3289:
        break label650;
        i7 = i5;
        i8 = i4;
      }
      label3303:
      i1 = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.v = getPaddingTop();
    this.w = getPaddingLeft();
    this.x = getPaddingRight();
    this.y = (getWidth() - getPaddingLeft() - getPaddingRight());
    this.z = (getHeight() - getPaddingTop() - getPaddingBottom());
    this.A = getWidth();
    this.B = getHeight();
    if (!this.I) {
      this.H = getWidth();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/hourforecast/TrendGraphs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */