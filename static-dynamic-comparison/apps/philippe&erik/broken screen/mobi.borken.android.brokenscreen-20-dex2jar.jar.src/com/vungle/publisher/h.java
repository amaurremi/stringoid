package com.vungle.publisher;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

public class h
{
  int a;
  g b;
  g c;
  Interpolator d;
  ArrayList<g> e;
  public l f;
  
  public h(g... paramVarArgs)
  {
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((g)this.e.get(0));
    this.c = ((g)this.e.get(this.a - 1));
    this.d = this.c.c;
  }
  
  public h a()
  {
    ArrayList localArrayList = this.e;
    int j = this.e.size();
    g[] arrayOfg = new g[j];
    int i = 0;
    while (i < j)
    {
      arrayOfg[i] = ((g)localArrayList.get(i)).b();
      i += 1;
    }
    return new h(arrayOfg);
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
      localObject1 = (g)this.e.get(1);
      localObject2 = ((g)localObject1).c;
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = this.b.a;
      paramFloat = (f1 - paramFloat) / (((g)localObject1).a - paramFloat);
      return this.f.a(paramFloat, this.b.a(), ((g)localObject1).a());
    }
    if (paramFloat >= 1.0F)
    {
      localObject1 = (g)this.e.get(this.a - 2);
      localObject2 = this.c.c;
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = ((g)localObject1).a;
      paramFloat = (f1 - paramFloat) / (this.c.a - paramFloat);
      return this.f.a(paramFloat, ((g)localObject1).a(), this.c.a());
    }
    Object localObject1 = this.b;
    int i = 1;
    while (i < this.a)
    {
      localObject2 = (g)this.e.get(i);
      if (paramFloat < ((g)localObject2).a)
      {
        Interpolator localInterpolator = ((g)localObject2).c;
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = ((g)localObject1).a;
        paramFloat = (f1 - paramFloat) / (((g)localObject2).a - paramFloat);
        return this.f.a(paramFloat, ((g)localObject1).a(), ((g)localObject2).a());
      }
      i += 1;
      localObject1 = localObject2;
    }
    return this.c.a();
  }
  
  public String toString()
  {
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      str = str + ((g)this.e.get(i)).a() + "  ";
      i += 1;
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */