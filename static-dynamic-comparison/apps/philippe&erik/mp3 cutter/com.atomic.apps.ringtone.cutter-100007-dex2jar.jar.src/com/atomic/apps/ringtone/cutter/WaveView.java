package com.atomic.apps.ringtone.cutter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.atomic.apps.ringtone.a.h;

public class WaveView
  extends View
{
  private Paint a;
  private Paint b;
  private Paint c;
  private Paint d;
  private Paint e;
  private Paint f;
  private Paint g;
  private h h;
  private int[] i;
  private double[][] j;
  private double[] k;
  private int[] l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private float u;
  private ai v;
  private GestureDetector w;
  private boolean x;
  
  public WaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(false);
    this.a = new Paint();
    this.a.setAntiAlias(false);
    this.a.setColor(getResources().getColor(2130837575));
    this.b = new Paint();
    this.b.setAntiAlias(false);
    this.b.setColor(getResources().getColor(2130837570));
    this.c = new Paint();
    this.c.setAntiAlias(false);
    this.c.setColor(getResources().getColor(2130837571));
    this.d = new Paint();
    this.d.setAntiAlias(false);
    this.d.setColor(getResources().getColor(2130837572));
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setStrokeWidth(1.5F);
    this.e.setPathEffect(new DashPathEffect(new float[] { 3.0F, 2.0F }, 0.0F));
    this.e.setColor(getResources().getColor(2130837573));
    this.f = new Paint();
    this.f.setAntiAlias(false);
    this.f.setColor(getResources().getColor(2130837574));
    this.g = new Paint();
    this.g.setTextSize(12.0F);
    this.g.setAntiAlias(true);
    this.g.setColor(getResources().getColor(2130837576));
    this.g.setShadowLayer(2.0F, 1.0F, 1.0F, getResources().getColor(2130837577));
    this.w = new GestureDetector(paramContext, new ah(this));
    this.h = null;
    this.i = null;
    this.j = null;
    this.l = null;
    this.q = 0;
    this.t = -1;
    this.r = 0;
    this.s = 0;
    this.u = 1.0F;
    this.x = false;
  }
  
  private static void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    paramCanvas.drawLine(paramInt1, paramInt2, paramInt1, paramInt3, paramPaint);
  }
  
  public final int a(double paramDouble)
  {
    return (int)(1.0D * paramDouble * this.o / this.p + 0.5D);
  }
  
  public final void a(float paramFloat)
  {
    this.l = null;
    this.u = paramFloat;
    this.g.setTextSize((int)(12.0F * paramFloat));
    invalidate();
  }
  
  public final void a(int paramInt)
  {
    if (this.m <= paramInt) {}
    for (;;)
    {
      if (this.m >= paramInt)
      {
        return;
        d();
        break;
      }
      f();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.r = paramInt1;
    this.s = paramInt2;
    this.q = paramInt3;
  }
  
  public final void a(h paramh)
  {
    this.h = paramh;
    this.o = this.h.f();
    this.p = this.h.c();
    int i4 = this.h.b();
    Object localObject = this.h.d();
    paramh = new double[i4];
    double d1;
    int i1;
    if (i4 == 1)
    {
      paramh[0] = localObject[0];
      d1 = 1.0D;
      i1 = 0;
      label69:
      if (i1 < i4) {
        break label495;
      }
      if (d1 <= 255.0D) {
        break label919;
      }
    }
    label103:
    label116:
    label141:
    label169:
    label272:
    label495:
    label604:
    label628:
    label648:
    label709:
    label787:
    label919:
    for (double d2 = 255.0D / d1;; d2 = 1.0D)
    {
      localObject = new int['Ā'];
      int i2 = 0;
      d1 = 0.0D;
      double d3;
      double d4;
      if (i2 >= i4)
      {
        i1 = 0;
        d3 = 0.0D;
        if ((d3 < 255.0D) && (i1 < i4 / 20)) {
          break label604;
        }
        i1 = 0;
        d4 = d1;
        if ((d4 > 2.0D) && (i1 < i4 / 100)) {
          break label628;
        }
        localObject = new double[i4];
        i1 = 0;
        if (i1 < i4) {
          break label648;
        }
        this.n = 5;
        this.i = new int[5];
        this.k = new double[5];
        this.j = new double[5][];
        this.i[0] = (i4 << 1);
        this.k[0] = 2.0D;
        this.j[0] = new double[this.i[0]];
        if (i4 > 0)
        {
          this.j[0][0] = (0.5D * localObject[0]);
          this.j[0][1] = localObject[0];
        }
        i1 = 1;
        if (i1 < i4) {
          break label709;
        }
        this.i[1] = i4;
        this.j[1] = new double[this.i[1]];
        this.k[1] = 1.0D;
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= this.i[1])
        {
          i1 = 2;
          if (i1 < 5) {
            break label787;
          }
          this.m = 4;
          this.x = true;
          this.l = null;
          return;
          if (i4 == 2)
          {
            paramh[0] = localObject[0];
            paramh[1] = localObject[1];
            break;
          }
          if (i4 <= 2) {
            break;
          }
          paramh[0] = (localObject[0] / 2.0D + localObject[1] / 2.0D);
          i1 = 1;
          for (;;)
          {
            if (i1 >= i4 - 1)
            {
              paramh[(i4 - 1)] = (localObject[(i4 - 2)] / 2.0D + localObject[(i4 - 1)] / 2.0D);
              break;
            }
            paramh[i1] = (localObject[(i1 - 1)] / 3.0D + localObject[i1] / 3.0D + localObject[(i1 + 1)] / 3.0D);
            i1 += 1;
          }
          d2 = d1;
          if (paramh[i1] > d1) {
            d2 = paramh[i1];
          }
          i1 += 1;
          d1 = d2;
          break label69;
          int i3 = (int)(paramh[i2] * d2);
          i1 = i3;
          if (i3 < 0) {
            i1 = 0;
          }
          i3 = i1;
          if (i1 > 255) {
            i3 = 255;
          }
          d3 = d1;
          if (i3 > d1) {
            d3 = i3;
          }
          localObject[i3] += 1;
          i2 += 1;
          d1 = d3;
          break label103;
          i2 = localObject[((int)d3)];
          d3 += 1.0D;
          i1 = i2 + i1;
          break label116;
          i1 += localObject[((int)d4)];
          d4 -= 1.0D;
          break label141;
          double d5 = (paramh[i1] * d2 - d3) / (d4 - d3);
          d1 = d5;
          if (d5 < 0.0D) {
            d1 = 0.0D;
          }
          d5 = d1;
          if (d1 > 1.0D) {
            d5 = 1.0D;
          }
          localObject[i1] = (d5 * d5);
          i1 += 1;
          break label169;
          this.j[0][(i1 * 2)] = (0.5D * (localObject[(i1 - 1)] + localObject[i1]));
          this.j[0][(i1 * 2 + 1)] = localObject[i1];
          i1 += 1;
          break label272;
        }
        this.j[1][i1] = localObject[i1];
        i1 += 1;
      }
      this.i[i1] = (this.i[(i1 - 1)] / 2);
      this.j[i1] = new double[this.i[i1]];
      this.k[i1] = (this.k[(i1 - 1)] / 2.0D);
      i2 = 0;
      for (;;)
      {
        if (i2 >= this.i[i1])
        {
          i1 += 1;
          break;
        }
        this.j[i1][i2] = (0.5D * (this.j[(i1 - 1)][(i2 * 2)] + this.j[(i1 - 1)][(i2 * 2 + 1)]));
        i2 += 1;
      }
    }
  }
  
  public final void a(ai paramai)
  {
    this.v = paramai;
  }
  
  public final boolean a()
  {
    return this.x;
  }
  
  public final double b(int paramInt)
  {
    double d1 = this.k[this.m];
    return paramInt * this.p / (d1 * this.o);
  }
  
  public final int b()
  {
    return this.m;
  }
  
  public final int b(double paramDouble)
  {
    return (int)(this.k[this.m] * paramDouble * this.o / this.p + 0.5D);
  }
  
  public final int c(int paramInt)
  {
    return (int)(this.k[this.m] * (paramInt * this.o) / (1000.0D * this.p) + 0.5D);
  }
  
  public final boolean c()
  {
    return this.m > 0;
  }
  
  public final int d(int paramInt)
  {
    double d1 = this.k[this.m];
    return (int)(paramInt * (1000.0D * this.p) / (d1 * this.o) + 0.5D);
  }
  
  public final void d()
  {
    if (c())
    {
      this.m -= 1;
      this.r <<= 1;
      this.s <<= 1;
      this.l = null;
      this.q = ((this.q + getMeasuredWidth() / 2 << 1) - getMeasuredWidth() / 2);
      if (this.q < 0) {
        this.q = 0;
      }
      invalidate();
    }
  }
  
  public final void e(int paramInt)
  {
    this.t = paramInt;
  }
  
  public final boolean e()
  {
    return this.m < this.n - 1;
  }
  
  public final void f()
  {
    if (e())
    {
      this.m += 1;
      this.r /= 2;
      this.s /= 2;
      this.q = ((this.q + getMeasuredWidth() / 2) / 2 - getMeasuredWidth() / 2);
      if (this.q < 0) {
        this.q = 0;
      }
      this.l = null;
      invalidate();
    }
  }
  
  public final int g()
  {
    return this.i[this.m];
  }
  
  public final int h()
  {
    return this.r;
  }
  
  public final int i()
  {
    return this.s;
  }
  
  public final int j()
  {
    return this.q;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.h == null) {
      return;
    }
    int i2;
    int i1;
    label46:
    int i5;
    int i7;
    int i8;
    int i9;
    if (this.l == null)
    {
      i2 = getMeasuredHeight() / 2;
      this.l = new int[this.i[this.m]];
      i1 = 0;
      if (i1 < this.i[this.m]) {}
    }
    else
    {
      i5 = getMeasuredWidth();
      i7 = getMeasuredHeight();
      i8 = this.q;
      i1 = this.l.length - i8;
      i9 = i7 / 2;
      if (i1 <= i5) {
        break label761;
      }
      i1 = i5;
    }
    label124:
    label140:
    label161:
    label427:
    label554:
    label758:
    label761:
    for (;;)
    {
      double d3 = b(1);
      int i3;
      double d1;
      int i4;
      if (d3 > 0.02D)
      {
        i3 = 1;
        d1 = this.q * d3;
        i4 = (int)d1;
        i2 = 0;
      }
      for (;;)
      {
        double d2;
        if (i2 >= i1)
        {
          i2 = 0;
          if (i2 < i1) {
            break label427;
          }
          i2 = i1;
          if (i2 < i5) {
            break label554;
          }
          paramCanvas.drawLine(0.5F + (this.r - this.q), 30.0F, 0.5F + (this.r - this.q), i7, this.e);
          paramCanvas.drawLine(0.5F + (this.s - this.q), 0.0F, 0.5F + (this.s - this.q), i7 - 30, this.e);
          d1 = 1.0D;
          if (1.0D / d3 < 50.0D) {
            d1 = 5.0D;
          }
          d2 = d1;
          if (d1 / d3 < 50.0D) {
            d2 = 15.0D;
          }
          d1 = this.q * d3;
          i3 = (int)(d1 / d2);
          i2 = 0;
        }
        for (;;)
        {
          Object localObject;
          if (i2 >= i1)
          {
            if (this.v == null) {
              break;
            }
            this.v.b();
            return;
            this.l[i1] = ((int)(this.j[this.m][i1] * (i2 - 1)));
            i1 += 1;
            break label46;
            i3 = 0;
            break label124;
            i2 += 1;
            d1 += d3;
            int i6 = (int)d1;
            if (i6 == i4) {
              break label758;
            }
            if ((i3 == 0) || (i6 % 5 == 0)) {
              paramCanvas.drawLine(i2, 0.0F, i2, i7, this.a);
            }
            i4 = i6;
            break label140;
            if ((i2 + i8 >= this.r) && (i2 + i8 < this.s)) {}
            for (localObject = this.b;; localObject = this.c)
            {
              a(paramCanvas, i2, i9 - this.l[(i8 + i2)], i9 + 1 + this.l[(i8 + i2)], (Paint)localObject);
              if (i2 + i8 == this.t) {
                paramCanvas.drawLine(i2, 0.0F, i2, i7, this.f);
              }
              i2 += 1;
              break;
              a(paramCanvas, i2, 0, i7, this.d);
            }
            a(paramCanvas, i2, 0, i7, this.d);
            i2 += 1;
            break label161;
          }
          i2 += 1;
          d1 += d3;
          i5 = (int)d1;
          i4 = (int)(d1 / d2);
          if (i4 != i3)
          {
            String str2 = i5 / 60;
            String str1 = i5 % 60;
            localObject = str1;
            if (i5 % 60 < 10) {
              localObject = "0" + str1;
            }
            localObject = str2 + ":" + (String)localObject;
            float f1 = (float)(0.5D * this.g.measureText((String)localObject));
            paramCanvas.drawText((String)localObject, i2 - f1, (int)(12.0F * this.u), this.g);
            i3 = i4;
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.w.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      this.v.b(paramMotionEvent.getX());
      return true;
    case 2: 
      this.v.c(paramMotionEvent.getX());
      return true;
    }
    this.v.c();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/WaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */