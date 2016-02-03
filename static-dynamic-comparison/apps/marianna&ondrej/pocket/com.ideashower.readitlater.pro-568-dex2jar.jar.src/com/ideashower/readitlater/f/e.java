package com.ideashower.readitlater.f;

import android.os.Bundle;
import com.ideashower.readitlater.util.u;
import com.pocket.m.a.d;
import java.io.File;
import java.util.ArrayList;

public class e
{
  private static final ArrayList a = new ArrayList();
  private static final ArrayList b = new ArrayList();
  private com.pocket.k.a c;
  private com.pocket.m.a.a d;
  private String e;
  private int f;
  private String g;
  private d h;
  private boolean i;
  private com.pocket.m.a.k j;
  private boolean k;
  private boolean l = true;
  private g m;
  private boolean n = false;
  private Bundle o;
  
  private void a(f paramf)
  {
    this.n = false;
    this.d = f.a(paramf);
    this.f = f.b(paramf);
    this.h = f.c(paramf);
    this.g = f.d(paramf);
    this.c = f.e(paramf);
    this.i = f.f(paramf);
    this.j = f.g(paramf);
    this.k = f.h(paramf);
    this.l = f.i(paramf);
    this.m = f.j(paramf);
    this.o = f.k(paramf);
    if (this.c != null)
    {
      paramf = u.a().append(f.a(paramf).d()).append(File.separator).append(f.a(paramf).h()).append("_").append(f.e(paramf).c()).append("-").append(f.e(paramf).d()).append(".jpg");
      this.e = paramf.toString();
      u.a(paramf);
      return;
    }
    this.e = this.d.c();
  }
  
  private static e p()
  {
    if (!a.isEmpty()) {
      return (e)a.remove(0);
    }
    return new e();
  }
  
  private void q()
  {
    if (this.n) {
      throw new RuntimeException("image request is recycled");
    }
  }
  
  public g a()
  {
    q();
    return this.m;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public String c()
  {
    q();
    return this.e;
  }
  
  public int d()
  {
    q();
    return this.f;
  }
  
  public d e()
  {
    q();
    return this.h;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (e)paramObject;
        if (this.e == null)
        {
          if (((e)paramObject).e != null) {
            return false;
          }
        }
        else if (!this.e.equals(((e)paramObject).e)) {
          return false;
        }
        if (this.f != ((e)paramObject).f) {
          return false;
        }
        if (this.g != null) {
          break;
        }
      } while (((e)paramObject).g == null);
      return false;
    } while (this.g.equals(((e)paramObject).g));
    return false;
  }
  
  public com.pocket.m.a.a f()
  {
    q();
    return this.d;
  }
  
  public boolean g()
  {
    q();
    return this.i;
  }
  
  public com.pocket.m.a.k h()
  {
    q();
    return this.j;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    int i1;
    int i3;
    if (this.e == null)
    {
      i1 = 0;
      i3 = this.f;
      if (this.g != null) {
        break label49;
      }
    }
    for (;;)
    {
      return ((i1 + 31) * 31 + i3) * 31 + i2;
      i1 = this.e.hashCode();
      break;
      label49:
      i2 = this.g.hashCode();
    }
  }
  
  public com.pocket.k.a i()
  {
    q();
    return this.c;
  }
  
  public Bundle j()
  {
    q();
    return this.o;
  }
  
  public boolean k()
  {
    q();
    return this.k;
  }
  
  public boolean l()
  {
    q();
    return this.l;
  }
  
  public void m()
  {
    this.d = null;
    this.f = 0;
    this.h = null;
    this.i = false;
    this.j = com.pocket.m.a.k.a;
    this.g = null;
    this.e = null;
    this.k = false;
    this.l = true;
    this.c = null;
    this.o = null;
    this.n = true;
    a.add(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(hashCode())).append(" ");
    if (this.d != null)
    {
      str = this.d.h() + " " + this.d.f();
      localStringBuilder = localStringBuilder.append(str).append(" ").append((String)org.apache.a.c.k.e(this.g, "")).append(" ");
      if (this.c == null) {
        break label153;
      }
      str = this.c.toString();
      label112:
      localStringBuilder = localStringBuilder.append(str).append(" ");
      if (this.o == null) {
        break label159;
      }
    }
    label153:
    label159:
    for (String str = this.o.toString();; str = "")
    {
      return str;
      str = "";
      break;
      str = "";
      break label112;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */