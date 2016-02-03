package com.vungle.publisher;

import android.view.animation.Interpolator;
import java.util.ArrayList;

final class f
  extends h
{
  private int g;
  private int h;
  private int i;
  private boolean j = true;
  
  public f(g.b... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  private f b()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    g.b[] arrayOfb = new g.b[m];
    int k = 0;
    while (k < m)
    {
      arrayOfb[k] = ((g.b)((g)localArrayList.get(k)).b());
      k += 1;
    }
    return new f(arrayOfb);
  }
  
  public final Object a(float paramFloat)
  {
    return Integer.valueOf(b(paramFloat));
  }
  
  public final int b(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((g.b)this.e.get(0)).e;
        this.h = ((g.b)this.e.get(1)).e;
        this.i = (this.h - this.g);
      }
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null) {
        return this.g + (int)(this.i * f1);
      }
      return ((Number)this.f.a(f1, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
    }
    g.b localb;
    int m;
    float f2;
    float f3;
    if (paramFloat <= 0.0F)
    {
      localObject = (g.b)this.e.get(0);
      localb = (g.b)this.e.get(1);
      k = ((g.b)localObject).e;
      m = localb.e;
      f2 = ((g)localObject).a;
      f3 = localb.a;
      localObject = localb.c;
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null) {
        return (int)(paramFloat * (m - k)) + k;
      }
      return ((Number)this.f.a(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (g.b)this.e.get(this.a - 2);
      localb = (g.b)this.e.get(this.a - 1);
      k = ((g.b)localObject).e;
      m = localb.e;
      f2 = ((g)localObject).a;
      f3 = localb.a;
      localObject = localb.c;
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null) {
        return (int)(paramFloat * (m - k)) + k;
      }
      return ((Number)this.f.a(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
    }
    for (Object localObject = (g.b)this.e.get(0); k < this.a; localObject = localb)
    {
      localb = (g.b)this.e.get(k);
      if (paramFloat < localb.a)
      {
        Interpolator localInterpolator = localb.c;
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((g)localObject).a) / (localb.a - ((g)localObject).a);
        k = ((g.b)localObject).e;
        m = localb.e;
        if (this.f == null) {
          return (int)((m - k) * paramFloat) + k;
        }
        return ((Number)this.f.a(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
      }
      k += 1;
    }
    return ((Number)((g)this.e.get(this.a - 1)).a()).intValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */