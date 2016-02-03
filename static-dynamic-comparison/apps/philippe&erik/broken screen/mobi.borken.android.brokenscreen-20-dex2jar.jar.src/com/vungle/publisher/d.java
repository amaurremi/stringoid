package com.vungle.publisher;

import android.view.animation.Interpolator;
import java.util.ArrayList;

final class d
  extends h
{
  private float g;
  private float h;
  private float i;
  private boolean j = true;
  
  public d(g.a... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  private d b()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    g.a[] arrayOfa = new g.a[m];
    int k = 0;
    while (k < m)
    {
      arrayOfa[k] = ((g.a)((g)localArrayList.get(k)).b());
      k += 1;
    }
    return new d(arrayOfa);
  }
  
  public final Object a(float paramFloat)
  {
    return Float.valueOf(b(paramFloat));
  }
  
  public final float b(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((g.a)this.e.get(0)).e;
        this.h = ((g.a)this.e.get(1)).e;
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
    g.a locala;
    float f2;
    float f3;
    float f4;
    float f5;
    if (paramFloat <= 0.0F)
    {
      localObject = (g.a)this.e.get(0);
      locala = (g.a)this.e.get(1);
      f2 = ((g.a)localObject).e;
      f3 = locala.e;
      f4 = ((g)localObject).a;
      f5 = locala.a;
      localObject = locala.c;
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
      localObject = (g.a)this.e.get(this.a - 2);
      locala = (g.a)this.e.get(this.a - 1);
      f2 = ((g.a)localObject).e;
      f3 = locala.e;
      f4 = ((g)localObject).a;
      f5 = locala.a;
      localObject = locala.c;
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
    for (Object localObject = (g.a)this.e.get(0); k < this.a; localObject = locala)
    {
      locala = (g.a)this.e.get(k);
      if (paramFloat < locala.a)
      {
        Interpolator localInterpolator = locala.c;
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((g)localObject).a) / (locala.a - ((g)localObject).a);
        f1 = ((g.a)localObject).e;
        f2 = locala.e;
        if (this.f == null) {
          return (f2 - f1) * paramFloat + f1;
        }
        return ((Number)this.f.a(paramFloat, Float.valueOf(f1), Float.valueOf(f2))).floatValue();
      }
      k += 1;
    }
    return ((Number)((g)this.e.get(this.a - 1)).a()).floatValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */