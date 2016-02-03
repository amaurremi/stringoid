package com.b.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class k
{
  int a;
  h b;
  h c;
  Interpolator d;
  ArrayList e;
  o f;
  
  public k(h... paramVarArgs)
  {
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((h)this.e.get(0));
    this.c = ((h)this.e.get(this.a - 1));
    this.d = this.c.c();
  }
  
  public static k a(float... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    i[] arrayOfi = new i[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfi[0] = ((i)h.b(0.0F));
      arrayOfi[1] = ((i)h.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new e(arrayOfi);
      arrayOfi[0] = ((i)h.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfi[i] = ((i)h.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static k a(int... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    j[] arrayOfj = new j[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfj[0] = ((j)h.a(0.0F));
      arrayOfj[1] = ((j)h.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new g(arrayOfj);
      arrayOfj[0] = ((j)h.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfj[i] = ((j)h.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public Object a(float paramFloat)
  {
    float f1;
    if (this.a == 2)
    {
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      return this.f.a(f1, this.b.a(), this.c.a());
    }
    Object localObject2;
    if (paramFloat <= 0.0F)
    {
      localObject1 = (h)this.e.get(1);
      localObject2 = ((h)localObject1).c();
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = this.b.b();
      paramFloat = (f1 - paramFloat) / (((h)localObject1).b() - paramFloat);
      return this.f.a(paramFloat, this.b.a(), ((h)localObject1).a());
    }
    if (paramFloat >= 1.0F)
    {
      localObject1 = (h)this.e.get(this.a - 2);
      localObject2 = this.c.c();
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = ((h)localObject1).b();
      paramFloat = (f1 - paramFloat) / (this.c.b() - paramFloat);
      return this.f.a(paramFloat, ((h)localObject1).a(), this.c.a());
    }
    Object localObject1 = this.b;
    int i = 1;
    while (i < this.a)
    {
      localObject2 = (h)this.e.get(i);
      if (paramFloat < ((h)localObject2).b())
      {
        Interpolator localInterpolator = ((h)localObject2).c();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = ((h)localObject1).b();
        paramFloat = (f1 - paramFloat) / (((h)localObject2).b() - paramFloat);
        return this.f.a(paramFloat, ((h)localObject1).a(), ((h)localObject2).a());
      }
      i += 1;
      localObject1 = localObject2;
    }
    return this.c.a();
  }
  
  public void a(o paramo)
  {
    this.f = paramo;
  }
  
  public k b()
  {
    ArrayList localArrayList = this.e;
    int j = this.e.size();
    h[] arrayOfh = new h[j];
    int i = 0;
    while (i < j)
    {
      arrayOfh[i] = ((h)localArrayList.get(i)).d();
      i += 1;
    }
    return new k(arrayOfh);
  }
  
  public String toString()
  {
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      str = str + ((h)this.e.get(i)).a() + "  ";
      i += 1;
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */