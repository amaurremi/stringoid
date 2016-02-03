package com.b.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class g
  extends k
{
  private int g;
  private int h;
  private int i;
  private boolean j = true;
  
  public g(j... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public g a()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    j[] arrayOfj = new j[m];
    int k = 0;
    while (k < m)
    {
      arrayOfj[k] = ((j)((h)localArrayList.get(k)).d());
      k += 1;
    }
    return new g(arrayOfj);
  }
  
  public Object a(float paramFloat)
  {
    return Integer.valueOf(b(paramFloat));
  }
  
  public int b(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((j)this.e.get(0)).e();
        this.h = ((j)this.e.get(1)).e();
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
    j localj;
    int m;
    float f2;
    float f3;
    if (paramFloat <= 0.0F)
    {
      localObject = (j)this.e.get(0);
      localj = (j)this.e.get(1);
      k = ((j)localObject).e();
      m = localj.e();
      f2 = ((j)localObject).b();
      f3 = localj.b();
      localObject = localj.c();
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
      localObject = (j)this.e.get(this.a - 2);
      localj = (j)this.e.get(this.a - 1);
      k = ((j)localObject).e();
      m = localj.e();
      f2 = ((j)localObject).b();
      f3 = localj.b();
      localObject = localj.c();
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
    for (Object localObject = (j)this.e.get(0); k < this.a; localObject = localj)
    {
      localj = (j)this.e.get(k);
      if (paramFloat < localj.b())
      {
        Interpolator localInterpolator = localj.c();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((j)localObject).b()) / (localj.b() - ((j)localObject).b());
        k = ((j)localObject).e();
        m = localj.e();
        if (this.f == null) {
          return (int)((m - k) * paramFloat) + k;
        }
        return ((Number)this.f.a(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
      }
      k += 1;
    }
    return ((Number)((h)this.e.get(this.a - 1)).a()).intValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */