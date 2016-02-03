package com.pocket.i.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.m;
import com.pocket.p.a;
import com.pocket.p.b;
import java.util.Arrays;

public class i
  extends Drawable
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static int e = 178;
  private static final Paint f;
  private static final Paint g;
  private static final Paint h;
  private static final Paint i;
  private static final Paint j;
  private static final Paint k;
  private static final float l = com.ideashower.readitlater.util.j.a(2.0F);
  private static final Interpolator m = new AccelerateInterpolator(1.6F);
  private static final Paint[] n = { g, h, i, f };
  private final float[] o;
  private boolean p = true;
  private boolean q;
  private j r = j.a;
  private long s;
  private long t;
  private final b u = new b();
  private int v;
  
  static
  {
    Resources localResources = g.c().getResources();
    a = localResources.getColor(2131165539);
    b = localResources.getColor(2131165533);
    c = localResources.getColor(2131165540);
    d = localResources.getColor(2131165538);
    f = a(a);
    g = a(b);
    h = a(c);
    i = a(d);
    j = a(-1);
    k = a(-16777216);
    j.setStrokeWidth(0.0F);
  }
  
  public i(Drawable.Callback paramCallback)
  {
    setCallback(paramCallback);
    this.o = new float[4];
  }
  
  private static Paint a(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(paramInt);
    return localPaint;
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 /= 4.0F;
    a(paramCanvas, paramFloat1 + 0.0F, paramFloat2, paramFloat3, paramFloat4, f);
    a(paramCanvas, paramFloat1 + paramFloat3, paramFloat2, paramFloat3, paramFloat4, g);
    a(paramCanvas, paramFloat1 + 2.0F * paramFloat3, paramFloat2, paramFloat3, paramFloat4, h);
    a(paramCanvas, paramFloat1 + 3.0F * paramFloat3, paramFloat2, paramFloat3, paramFloat4, i);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramFloat3 /= 4.0F;
    a(paramCanvas, paramFloat1 + 0.0F, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, f);
    a(paramCanvas, paramFloat1 + paramFloat3, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, g);
    a(paramCanvas, paramFloat1 + 2.0F * paramFloat3, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, h);
    a(paramCanvas, paramFloat1 + 3.0F * paramFloat3, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, i);
  }
  
  private static void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Paint paramPaint)
  {
    if (paramFloat1 < paramFloat5) {
      paramFloat1 = paramFloat5;
    }
    for (;;)
    {
      paramFloat5 = paramFloat1 + paramFloat3;
      paramFloat3 = paramFloat5;
      if (paramFloat5 > paramFloat6) {
        paramFloat3 = paramFloat6;
      }
      if (paramFloat1 < paramFloat3) {
        paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramPaint);
      }
      return;
    }
  }
  
  private static void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint)
  {
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat4, paramPaint);
  }
  
  public void a()
  {
    this.r = j.c;
    this.s = SystemClock.uptimeMillis();
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void b()
  {
    if ((this.r == j.a) || (this.r == j.e)) {
      return;
    }
    if (this.r == j.b) {}
    for (this.r = j.d;; this.r = j.e)
    {
      a.a(this.u, this.s, this.t);
      this.v = (this.u.b + 1);
      invalidateSelf();
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject3 = getBounds();
    float f4 = ((Rect)localObject3).width();
    float f5 = ((Rect)localObject3).height();
    if (this.q) {
      paramCanvas.drawRect(0.0F, 0.0F, f4, f5, k);
    }
    Object localObject2 = null;
    Object localObject1;
    float f6;
    float f2;
    if (this.r != j.a)
    {
      localObject1 = this.u;
      a.a((b)localObject1, this.s, this.t);
      if ((this.r == j.b) && (((b)localObject1).b >= 1))
      {
        this.r = j.c;
        localObject2 = localObject1;
      }
    }
    else
    {
      f6 = ((Rect)localObject3).top;
      f2 = ((Rect)localObject3).left;
      if (this.r != j.a) {
        break label268;
      }
      a(paramCanvas, f2, f6, f4, f5);
    }
    label268:
    label402:
    label445:
    label530:
    label604:
    label615:
    label653:
    label681:
    label740:
    label747:
    label752:
    for (;;)
    {
      if ((this.p) && (!this.q)) {
        paramCanvas.drawLine(0.0F, f5 + 1.0F, f4, f5 + 1.0F, j);
      }
      if (this.r != j.a) {
        invalidateSelf();
      }
      return;
      if ((this.r == j.d) && (((b)localObject1).b == this.v))
      {
        this.r = j.e;
        localObject2 = localObject1;
        break;
      }
      localObject2 = localObject1;
      if (this.r != j.e) {
        break;
      }
      localObject2 = localObject1;
      if (((b)localObject1).b <= this.v) {
        break;
      }
      this.r = j.a;
      localObject2 = localObject1;
      break;
      float[] arrayOfFloat = this.o;
      int i2 = arrayOfFloat.length;
      float f7 = 1.0F / i2;
      int i1 = 0;
      float f3;
      float f1;
      while (i1 < i2)
      {
        f3 = ((b)localObject2).d + i1 * f7;
        f1 = f3;
        if (f3 > 1.0F) {
          f1 = f3 - 1.0F;
        }
        arrayOfFloat[i1] = (m.getInterpolation(f1) * f4);
        arrayOfFloat[i1] -= l;
        i1 += 1;
      }
      f7 = arrayOfFloat[0];
      Arrays.sort(arrayOfFloat);
      if (((b)localObject2).b > n.length - 1)
      {
        i1 = ((b)localObject2).b % n.length;
        if ((this.r != j.b) && (this.r != j.d)) {
          break label604;
        }
        localObject1 = null;
        a(paramCanvas, f2, f6, f4, f5, f2 + f7, f2 + f4);
        if ((this.r != j.e) || (((b)localObject2).b < this.v)) {
          break label615;
        }
        f1 = m.getInterpolation(((b)localObject2).d) * (1.75F * f4);
        a(paramCanvas, f2, f6, f4, f5, f2, f2 + f7 + f1);
        localObject2 = null;
        f2 += f1;
        i1 = 0;
        if (i1 < i2)
        {
          if (i1 != 0) {
            break label653;
          }
          f1 = 0.0F;
          if ((localObject1 != null) || (f1 < f7)) {
            break label681;
          }
        }
        f1 = arrayOfFloat[(i2 - 1)] + l;
        if (f1 >= f4) {
          continue;
        }
        if (f1 < f7) {
          break label747;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label752;
        }
        paramCanvas.drawRect(f2 + f1, f6, f4, f6 + f5, (Paint)localObject1);
        break;
        i1 = ((b)localObject2).b;
        break label402;
        localObject1 = n[i1];
        break label445;
        localObject2 = n;
        if (i1 < n.length - 1) {
          i1 += 1;
        }
        for (;;)
        {
          localObject2 = localObject2[i1];
          break;
          i1 = 0;
        }
        f3 = arrayOfFloat[(i1 - 1)] + l;
        f1 = f3;
        if (f3 >= 0.0F) {
          break label530;
        }
        f1 = 0.0F;
        break label530;
        f3 = arrayOfFloat[i1];
        if (f3 > f1) {
          if (f1 < f7) {
            break label740;
          }
        }
        for (localObject3 = localObject1;; localObject3 = localObject2)
        {
          if (localObject3 != null) {
            paramCanvas.drawRect(f2 + f1, f6, f2 + f3, f6 + f5, (Paint)localObject3);
          }
          i1 += 1;
          break;
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.t = ((paramRect.width() / com.ideashower.readitlater.util.j.a(320.0F) * 1800.0F));
    invalidateSelf();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i2 = 255;
    super.onStateChange(paramArrayOfInt);
    this.q = m.a(paramArrayOfInt);
    paramArrayOfInt = f;
    if (this.q)
    {
      i1 = e;
      paramArrayOfInt.setAlpha(i1);
      paramArrayOfInt = g;
      if (!this.q) {
        break label109;
      }
      i1 = e;
      label53:
      paramArrayOfInt.setAlpha(i1);
      paramArrayOfInt = i;
      if (!this.q) {
        break label116;
      }
    }
    label109:
    label116:
    for (int i1 = e;; i1 = 255)
    {
      paramArrayOfInt.setAlpha(i1);
      paramArrayOfInt = h;
      i1 = i2;
      if (this.q) {
        i1 = e;
      }
      paramArrayOfInt.setAlpha(i1);
      return true;
      i1 = 255;
      break;
      i1 = 255;
      break label53;
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */