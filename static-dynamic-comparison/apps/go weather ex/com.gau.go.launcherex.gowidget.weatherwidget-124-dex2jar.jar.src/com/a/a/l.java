package com.a.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class l
  extends r
{
  private float g;
  private float h;
  private float i;
  private boolean j = true;
  
  public l(p... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public l a()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    p[] arrayOfp = new p[m];
    int k = 0;
    while (k < m)
    {
      arrayOfp[k] = ((p)((o)localArrayList.get(k)).e());
      k += 1;
    }
    return new l(arrayOfp);
  }
  
  public Object a(float paramFloat)
  {
    return Float.valueOf(b(paramFloat));
  }
  
  public float b(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((p)this.e.get(0)).f();
        this.h = ((p)this.e.get(1)).f();
        this.i = (this.h - this.g);
      }
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null) {
        return this.g + this.i * f1;
      }
      return ((Number)this.f.a(f1, Float.valueOf(this.g), Float.valueOf(this.h))).floatValue();
    }
    p localp;
    float f2;
    float f3;
    float f4;
    float f5;
    if (paramFloat <= 0.0F)
    {
      localObject = (p)this.e.get(0);
      localp = (p)this.e.get(1);
      f2 = ((p)localObject).f();
      f3 = localp.f();
      f4 = ((p)localObject).c();
      f5 = localp.c();
      localObject = localp.d();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.f == null) {
        return paramFloat * (f3 - f2) + f2;
      }
      return ((Number)this.f.a(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (p)this.e.get(this.a - 2);
      localp = (p)this.e.get(this.a - 1);
      f2 = ((p)localObject).f();
      f3 = localp.f();
      f4 = ((p)localObject).c();
      f5 = localp.c();
      localObject = localp.d();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.f == null) {
        return paramFloat * (f3 - f2) + f2;
      }
      return ((Number)this.f.a(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    for (Object localObject = (p)this.e.get(0); k < this.a; localObject = localp)
    {
      localp = (p)this.e.get(k);
      if (paramFloat < localp.c())
      {
        Interpolator localInterpolator = localp.d();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((p)localObject).c()) / (localp.c() - ((p)localObject).c());
        f1 = ((p)localObject).f();
        f2 = localp.f();
        if (this.f == null) {
          return (f2 - f1) * paramFloat + f1;
        }
        return ((Number)this.f.a(paramFloat, Float.valueOf(f1), Float.valueOf(f2))).floatValue();
      }
      k += 1;
    }
    return ((Number)((o)this.e.get(this.a - 1)).b()).floatValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */