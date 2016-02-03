package com.a.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class r
{
  int a;
  o b;
  o c;
  Interpolator d;
  ArrayList e;
  am f;
  
  public r(o... paramVarArgs)
  {
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((o)this.e.get(0));
    this.c = ((o)this.e.get(this.a - 1));
    this.d = this.c.d();
  }
  
  public static r a(float... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    p[] arrayOfp = new p[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfp[0] = ((p)o.b(0.0F));
      arrayOfp[1] = ((p)o.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new l(arrayOfp);
      arrayOfp[0] = ((p)o.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfp[i] = ((p)o.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static r a(int... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    q[] arrayOfq = new q[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfq[0] = ((q)o.a(0.0F));
      arrayOfq[1] = ((q)o.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new n(arrayOfq);
      arrayOfq[0] = ((q)o.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfq[i] = ((q)o.a(i / (j - 1), paramVarArgs[i]));
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
      return this.f.a(f1, this.b.b(), this.c.b());
    }
    Object localObject2;
    if (paramFloat <= 0.0F)
    {
      localObject1 = (o)this.e.get(1);
      localObject2 = ((o)localObject1).d();
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = this.b.c();
      paramFloat = (f1 - paramFloat) / (((o)localObject1).c() - paramFloat);
      return this.f.a(paramFloat, this.b.b(), ((o)localObject1).b());
    }
    if (paramFloat >= 1.0F)
    {
      localObject1 = (o)this.e.get(this.a - 2);
      localObject2 = this.c.d();
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = ((o)localObject1).c();
      paramFloat = (f1 - paramFloat) / (this.c.c() - paramFloat);
      return this.f.a(paramFloat, ((o)localObject1).b(), this.c.b());
    }
    Object localObject1 = this.b;
    int i = 1;
    while (i < this.a)
    {
      localObject2 = (o)this.e.get(i);
      if (paramFloat < ((o)localObject2).c())
      {
        Interpolator localInterpolator = ((o)localObject2).d();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = ((o)localObject1).c();
        paramFloat = (f1 - paramFloat) / (((o)localObject2).c() - paramFloat);
        return this.f.a(paramFloat, ((o)localObject1).b(), ((o)localObject2).b());
      }
      i += 1;
      localObject1 = localObject2;
    }
    return this.c.b();
  }
  
  public void a(am paramam)
  {
    this.f = paramam;
  }
  
  public r b()
  {
    ArrayList localArrayList = this.e;
    int j = this.e.size();
    o[] arrayOfo = new o[j];
    int i = 0;
    while (i < j)
    {
      arrayOfo[i] = ((o)localArrayList.get(i)).e();
      i += 1;
    }
    return new r(arrayOfo);
  }
  
  public String toString()
  {
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      str = str + ((o)this.e.get(i)).b() + "  ";
      i += 1;
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */