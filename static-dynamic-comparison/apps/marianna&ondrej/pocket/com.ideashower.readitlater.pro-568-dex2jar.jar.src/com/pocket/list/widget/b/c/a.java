package com.pocket.list.widget.b.c;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.e.g;
import com.ideashower.readitlater.e.u;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.pocket.p.m;
import com.pocket.p.p;
import java.util.ArrayList;
import java.util.Iterator;

public class a
  extends Drawable
{
  private static final int a = j.a(5.5F);
  private static final int b = j.a(3.0F);
  private static final int c = j.a(11.0F);
  private static final int d = j.a(6.0F);
  private static final int e = d;
  private static final int f = j.a(18.0F);
  private g A;
  private int B = 0;
  private int C;
  private final Context D;
  private String E;
  private int[] F;
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private final RectF i = new RectF();
  private final m j = new m();
  private final m k = new m();
  private final b l;
  private final ArrayList m = new ArrayList();
  private final ArrayList n = new ArrayList();
  private final ColorStateList o;
  private final ColorStateList p;
  private final ColorStateList q;
  private final ColorStateList r;
  private final ColorStateList s;
  private final int t;
  private final float u;
  private final int v;
  private int w = 0;
  private boolean x = false;
  private int y;
  private int z;
  
  public a(Context paramContext)
  {
    this.D = paramContext;
    paramContext = paramContext.getResources();
    this.o = paramContext.getColorStateList(2131165242);
    this.p = paramContext.getColorStateList(2131165741);
    this.q = paramContext.getColorStateList(2131165740);
    this.r = paramContext.getColorStateList(2131165743);
    this.s = paramContext.getColorStateList(2131165742);
    this.g.setTextSize(c);
    this.g.setTypeface(i.a(i.d));
    this.g.setFlags(this.g.getFlags() | 0x80);
    this.g.setAntiAlias(true);
    this.g.setTextAlign(Paint.Align.CENTER);
    this.u = ((f - (this.g.descent() + this.g.ascent())) / 2.0F);
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.FILL);
    this.t = ((int)this.g.measureText("0"));
    this.l = new b(this, paramContext, null);
    this.v = (this.t * 3);
  }
  
  private int a(int paramInt)
  {
    return f * paramInt + (paramInt - 1) * e;
  }
  
  private int a(String paramString)
  {
    return (int)(a * 2 + this.g.measureText(paramString));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == this.k.c()) {
      this.k.a(paramInt2);
    }
    for (;;)
    {
      this.y = Math.max(paramInt3, this.y);
      return;
      this.k.c(paramInt1, paramInt2);
    }
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF, String paramString)
  {
    paramCanvas.drawRoundRect(paramRectF, b, b, this.h);
    paramCanvas.drawText(paramString, paramRectF.centerX(), paramRectF.top + this.u, this.g);
  }
  
  private void a(boolean paramBoolean)
  {
    int i8 = 0;
    int[] arrayOfInt = this.j.e();
    int i10 = p.b(this.m);
    int i6 = getBounds().width();
    int i11 = getBounds().height();
    this.k.a();
    this.l.a();
    this.y = 0;
    this.z = 0;
    this.C = 0;
    if ((this.A != null) && (!paramBoolean))
    {
      this.y = this.w;
      this.z = f;
    }
    for (int i1 = i6 - this.w;; i1 = i6)
    {
      int i4 = 0;
      int i3 = 0;
      int i5 = 0;
      int i2 = 0;
      if (i4 < i10)
      {
        int i9 = arrayOfInt[i4];
        int i7 = i9;
        if (i5 > 0) {
          i7 = i9 + d;
        }
        if (i7 < i1) {
          if (i4 == i10 - 1)
          {
            a(i2, i5 + 1, i6 - i1);
            i7 = i1;
            i1 = i3;
            i3 = i2;
            i2 = i7;
          }
        }
        for (;;)
        {
          i4 += 1;
          i7 = i3;
          i3 = i1;
          i1 = i2;
          i2 = i7;
          break;
          i5 += 1;
          i7 = i1 - i7;
          i1 = i3;
          i3 = i2;
          i2 = i7;
          continue;
          if ((a(i2 + 2) >= i11) || ((i2 >= this.B - 1) && (this.B != 0))) {
            break label289;
          }
          a(i2, i5, i6 - i1);
          i4 -= 1;
          i5 = 0;
          i3 = i2 + 1;
          i2 = i6;
        }
        label289:
        this.l.a(i10, i4, i5, arrayOfInt, i1);
        if (b.a(this.l)) {
          break label476;
        }
        i1 = i5 - b.b(this.l);
        if ((i1 == 0) && (b.c(this.l) < i3)) {
          a(i2 - 1, this.k.b(i2 - 1), i3 - b.d(this.l));
        }
      }
      else
      {
        i1 = this.k.c();
        i2 = f;
        i3 = e;
        this.z = Math.max(this.z, (i1 - 1) * i3 + i2 * i1);
        if (this.A == null) {
          break label496;
        }
      }
      label476:
      label496:
      for (i1 = 1;; i1 = 0)
      {
        arrayOfInt = this.k.e();
        i3 = this.k.c();
        i2 = i8;
        while (i2 < i3)
        {
          i1 += arrayOfInt[i2];
          i2 += 1;
        }
        a(i2, i1, i6 - b.d(this.l));
        break;
        if (!paramBoolean)
        {
          a(true);
          return;
        }
        a(i2, 0, 0);
        break;
      }
      this.C = i1;
      invalidateSelf();
      return;
    }
  }
  
  private void a(int[] paramArrayOfInt)
  {
    if (!this.n.isEmpty())
    {
      this.F = new int[paramArrayOfInt.length + 1];
      this.F[0] = 2130772094;
      System.arraycopy(paramArrayOfInt, 0, this.F, 1, paramArrayOfInt.length);
      return;
    }
    this.F = null;
  }
  
  private void f()
  {
    this.x = true;
    a(getState());
  }
  
  private void g()
  {
    if (this.x)
    {
      a(false);
      this.x = false;
    }
  }
  
  public int a()
  {
    g();
    return this.y;
  }
  
  public void a(g paramg)
  {
    this.A = paramg;
    if (paramg != null) {
      this.E = paramg.b(this.D);
    }
    for (this.w = a(this.E);; this.w = 0)
    {
      f();
      return;
      this.E = null;
    }
  }
  
  public void a(ArrayList paramArrayList, u paramu)
  {
    this.m.clear();
    this.n.clear();
    this.j.a();
    int i1;
    label43:
    String str;
    if ((paramu != null) && (paramu.g()))
    {
      i1 = 1;
      if (paramArrayList == null) {
        break label154;
      }
      paramArrayList = paramArrayList.iterator();
      if (!paramArrayList.hasNext()) {
        break label154;
      }
      str = (String)paramArrayList.next();
      if ((i1 == 0) || (!paramu.e(str))) {
        break label142;
      }
      this.n.add(str);
    }
    label142:
    for (int i2 = this.n.size() - 1;; i2 = this.m.size())
    {
      this.m.add(i2, str);
      int i3 = Math.max(a(str), this.v);
      this.j.a(i2, i3);
      break label43;
      i1 = 0;
      break;
    }
    label154:
    f();
  }
  
  public int b()
  {
    g();
    return this.z;
  }
  
  public int c()
  {
    Rect localRect = getBounds();
    return Math.min(localRect.top + b(), localRect.bottom);
  }
  
  public int d()
  {
    g();
    return this.C;
  }
  
  public void draw(Canvas paramCanvas)
  {
    g();
    boolean bool = b.a(this.l);
    if ((this.C == 0) && (!bool)) {
      return;
    }
    RectF localRectF = this.i;
    localRectF.set(getBounds());
    float f1 = localRectF.left;
    float f2 = localRectF.top;
    int[] arrayOfInt2 = getState();
    if ((this.A != null) && (!bool))
    {
      this.h.setColor(this.A.b().getColorForState(arrayOfInt2, 0));
      this.g.setColor(this.o.getColorForState(arrayOfInt2, 0));
      localRectF.set(f1, f2, this.w + f1, f + f2);
      a(paramCanvas, localRectF, this.E);
    }
    for (float f3 = this.w + d + f1;; f3 = f1)
    {
      if ((!this.k.d()) && (!bool))
      {
        int[] arrayOfInt3 = this.k.e();
        int i4 = this.k.c();
        int[] arrayOfInt4 = this.j.e();
        int i2 = 0;
        float f4 = f2;
        int i1 = 0;
        float f5 = f3;
        f3 = f2;
        float f6 = f1;
        f2 = f4;
        f4 = f6;
        while (i2 < i4)
        {
          int i5 = arrayOfInt3[i2];
          f3 = f5;
          int i3 = 0;
          if (i3 < i5)
          {
            f4 = arrayOfInt4[i1];
            String str = (String)this.m.get(i1);
            if ((this.n != null) && (this.n.contains(str))) {}
            for (int[] arrayOfInt1 = this.F;; arrayOfInt1 = arrayOfInt2)
            {
              this.g.setColor(this.p.getColorForState(arrayOfInt1, 0));
              this.h.setColor(this.q.getColorForState(arrayOfInt1, 0));
              localRectF.set(f3, f2, f3 + f4, f + f2);
              a(paramCanvas, localRectF, str);
              f3 += d + f4;
              i3 += 1;
              i1 += 1;
              break;
            }
          }
          f6 = f + e;
          i2 += 1;
          f4 = f2;
          f5 = f1;
          f6 = f2 + f6;
          f2 = f3;
          f3 = f4;
          f4 = f2;
          f2 = f6;
        }
        f1 = f4;
      }
      while (b.e(this.l) != null)
      {
        this.g.setColor(this.r.getColorForState(arrayOfInt2, 0));
        this.h.setColor(this.s.getColorForState(arrayOfInt2, 0));
        localRectF.set(f1, f3, b.c(this.l) + f1, f + f3);
        a(paramCanvas, localRectF, b.e(this.l));
        return;
        f3 = f2;
      }
      break;
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
    f();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    a(paramArrayOfInt);
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.g.setAlpha(paramInt);
    this.h.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.g.setColorFilter(paramColorFilter);
    this.h.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */