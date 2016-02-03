package com.a.a;

import android.view.View;
import com.a.b.c;
import com.a.c.a.a;
import java.util.HashMap;
import java.util.Map;

public final class s
  extends an
{
  private static final Map h = new HashMap();
  private Object i;
  private String j;
  private c k;
  
  static
  {
    h.put("alpha", t.a);
    h.put("pivotX", t.b);
    h.put("pivotY", t.c);
    h.put("translationX", t.d);
    h.put("translationY", t.e);
    h.put("rotation", t.f);
    h.put("rotationX", t.g);
    h.put("rotationY", t.h);
    h.put("scaleX", t.i);
    h.put("scaleY", t.j);
    h.put("scrollX", t.k);
    h.put("scrollY", t.l);
    h.put("x", t.m);
    h.put("y", t.n);
  }
  
  public s() {}
  
  private s(Object paramObject, String paramString)
  {
    this.i = paramObject;
    a(paramString);
  }
  
  public static s a(Object paramObject, String paramString, float... paramVarArgs)
  {
    paramObject = new s(paramObject, paramString);
    ((s)paramObject).a(paramVarArgs);
    return (s)paramObject;
  }
  
  public static s a(Object paramObject, String paramString, int... paramVarArgs)
  {
    paramObject = new s(paramObject, paramString);
    ((s)paramObject).a(paramVarArgs);
    return (s)paramObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  void a(float paramFloat)
  {
    super.a(paramFloat);
    int n = this.f.length;
    int m = 0;
    while (m < n)
    {
      this.f[m].b(this.i);
      m += 1;
    }
  }
  
  public void a(c paramc)
  {
    if (this.f != null)
    {
      ai localai = this.f[0];
      String str = localai.c();
      localai.a(paramc);
      this.g.remove(str);
      this.g.put(this.j, localai);
    }
    if (this.k != null) {
      this.j = paramc.a();
    }
    this.k = paramc;
    this.e = false;
  }
  
  public void a(Object paramObject)
  {
    if (this.i != paramObject)
    {
      Object localObject = this.i;
      this.i = paramObject;
      if ((localObject == null) || (paramObject == null) || (localObject.getClass() != paramObject.getClass())) {}
    }
    else
    {
      return;
    }
    this.e = false;
  }
  
  public void a(String paramString)
  {
    if (this.f != null)
    {
      ai localai = this.f[0];
      String str = localai.c();
      localai.a(paramString);
      this.g.remove(str);
      this.g.put(paramString, localai);
    }
    this.j = paramString;
    this.e = false;
  }
  
  public void a(float... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        a(new ai[] { ai.a(this.k, paramVarArgs) });
        return;
      }
      a(new ai[] { ai.a(this.j, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public void a(int... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        a(new ai[] { ai.a(this.k, paramVarArgs) });
        return;
      }
      a(new ai[] { ai.a(this.j, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public s b(long paramLong)
  {
    super.c(paramLong);
    return this;
  }
  
  void h()
  {
    if (!this.e)
    {
      if ((this.k == null) && (a.a) && ((this.i instanceof View)) && (h.containsKey(this.j))) {
        a((c)h.get(this.j));
      }
      int n = this.f.length;
      int m = 0;
      while (m < n)
      {
        this.f[m].a(this.i);
        m += 1;
      }
      super.h();
    }
  }
  
  public s i()
  {
    return (s)super.j();
  }
  
  public String toString()
  {
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.i;
    String str2 = str1;
    if (this.f != null)
    {
      int m = 0;
      for (;;)
      {
        str2 = str1;
        if (m >= this.f.length) {
          break;
        }
        str1 = str1 + "\n    " + this.f[m].toString();
        m += 1;
      }
    }
    return str2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */