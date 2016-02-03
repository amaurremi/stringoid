package com.b.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class e
  extends k
{
  private float g;
  private float h;
  private float i;
  private boolean j = true;
  
  public e(i... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public e a()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    i[] arrayOfi = new i[m];
    int k = 0;
    while (k < m)
    {
      arrayOfi[k] = ((i)((h)localArrayList.get(k)).d());
      k += 1;
    }
    return new e(arrayOfi);
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
        this.g = ((i)this.e.get(0)).e();
        this.h = ((i)this.e.get(1)).e();
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
    i locali;
    float f2;
    float f3;
    float f4;
    float f5;
    if (paramFloat <= 0.0F)
    {
      localObject = (i)this.e.get(0);
      locali = (i)this.e.get(1);
      f2 = ((i)localObject).e();
      f3 = locali.e();
      f4 = ((i)localObject).b();
      f5 = locali.b();
      localObject = locali.c();
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
      localObject = (i)this.e.get(this.a - 2);
      locali = (i)this.e.get(this.a - 1);
      f2 = ((i)localObject).e();
      f3 = locali.e();
      f4 = ((i)localObject).b();
      f5 = locali.b();
      localObject = locali.c();
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
    for (Object localObject = (i)this.e.get(0); k < this.a; localObject = locali)
    {
      locali = (i)this.e.get(k);
      if (paramFloat < locali.b())
      {
        Interpolator localInterpolator = locali.c();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((i)localObject).b()) / (locali.b() - ((i)localObject).b());
        f1 = ((i)localObject).e();
        f2 = locali.e();
        if (this.f == null) {
          return (f2 - f1) * paramFloat + f1;
        }
        return ((Number)this.f.a(paramFloat, Float.valueOf(f1), Float.valueOf(f2))).floatValue();
      }
      k += 1;
    }
    return ((Number)((h)this.e.get(this.a - 1)).a()).floatValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */