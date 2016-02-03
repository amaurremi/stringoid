package com.vungle.publisher;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

public final class i
  extends m
{
  private static final Map<String, p> k;
  public Object b;
  private String l;
  private p m;
  
  static
  {
    HashMap localHashMap = new HashMap();
    k = localHashMap;
    localHashMap.put("alpha", j.a);
    k.put("pivotX", j.b);
    k.put("pivotY", j.c);
    k.put("translationX", j.d);
    k.put("translationY", j.e);
    k.put("rotation", j.f);
    k.put("rotationX", j.g);
    k.put("rotationY", j.h);
    k.put("scaleX", j.i);
    k.put("scaleY", j.j);
    k.put("scrollX", j.k);
    k.put("scrollY", j.l);
    k.put("x", j.m);
    k.put("y", j.n);
  }
  
  public i() {}
  
  private i(Object paramObject, String paramString)
  {
    this.b = paramObject;
    a(paramString);
  }
  
  public static i a(Object paramObject, String paramString, float... paramVarArgs)
  {
    paramObject = new i(paramObject, paramString);
    ((i)paramObject).a(paramVarArgs);
    return (i)paramObject;
  }
  
  public final i a(long paramLong)
  {
    super.b(paramLong);
    return this;
  }
  
  public final void a()
  {
    super.a();
  }
  
  final void a(float paramFloat)
  {
    super.a(paramFloat);
    int j = this.i.length;
    int i = 0;
    while (i < j)
    {
      this.i[i].b(this.b);
      i += 1;
    }
  }
  
  public final void a(String paramString)
  {
    if (this.i != null)
    {
      k localk = this.i[0];
      String str = localk.a;
      localk.a = paramString;
      this.j.remove(str);
      this.j.put(paramString, localk);
    }
    this.l = paramString;
    this.g = false;
  }
  
  public final void a(float... paramVarArgs)
  {
    if ((this.i == null) || (this.i.length == 0))
    {
      if (this.m != null)
      {
        a(new k[] { k.a(this.m, paramVarArgs) });
        return;
      }
      a(new k[] { k.a(this.l, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public final void a(int... paramVarArgs)
  {
    if ((this.i == null) || (this.i.length == 0))
    {
      if (this.m != null)
      {
        a(new k[] { k.a(this.m, paramVarArgs) });
        return;
      }
      a(new k[] { k.a(this.l, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  final void d()
  {
    if (!this.g)
    {
      if ((this.m == null) && (r.a) && ((this.b instanceof View)) && (k.containsKey(this.l)))
      {
        p localp = (p)k.get(this.l);
        if (this.i != null)
        {
          k localk = this.i[0];
          String str = localk.a;
          localk.a(localp);
          this.j.remove(str);
          this.j.put(this.l, localk);
        }
        if (this.m != null) {
          this.l = localp.a;
        }
        this.m = localp;
        this.g = false;
      }
      int j = this.i.length;
      int i = 0;
      while (i < j)
      {
        this.i[i].a(this.b);
        i += 1;
      }
      super.d();
    }
  }
  
  public final String toString()
  {
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.b;
    String str2 = str1;
    if (this.i != null)
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.i.length) {
          break;
        }
        str1 = str1 + "\n    " + this.i[i].toString();
        i += 1;
      }
    }
    return str2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */