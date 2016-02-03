package com.ideashower.readitlater.f;

import android.os.Bundle;
import com.ideashower.readitlater.a.x;
import com.pocket.m.a.d;
import com.pocket.m.a.k;
import java.util.ArrayList;

public class f
{
  private com.pocket.m.a.a a;
  private com.pocket.k.a b;
  private int c;
  private d d;
  private String e;
  private boolean f;
  private k g;
  private g h;
  private boolean i;
  private boolean j;
  private Bundle k;
  
  public static f a(com.pocket.m.a.a parama, com.pocket.k.a parama1, d paramd)
  {
    if (!e.n().isEmpty()) {}
    for (f localf = (f)e.n().remove(0);; localf = new f()) {
      return localf.a(parama).a(parama1).a(paramd);
    }
  }
  
  public static f a(String paramString, com.pocket.k.a parama, d paramd)
  {
    return a(com.pocket.m.a.a.a(paramString), parama, paramd);
  }
  
  private Bundle c()
  {
    if (this.k == null) {
      this.k = new Bundle();
    }
    return this.k;
  }
  
  private void d()
  {
    this.a = null;
    this.b = null;
    this.c = 0;
    this.d = null;
    this.e = null;
    this.f = false;
    this.g = k.a;
    this.h = null;
    this.i = false;
    this.j = true;
    if (this.k != null) {
      this.k.clear();
    }
    e.n().add(this);
  }
  
  public e a()
  {
    if (this.a == null) {
      throw new RuntimeException("Invalid request");
    }
    e locale = e.o();
    e.a(locale, this);
    d();
    return locale;
  }
  
  public f a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public f a(g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.h = paramg;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    return this;
  }
  
  public f a(com.pocket.k.a parama)
  {
    this.b = parama;
    return this;
  }
  
  public f a(com.pocket.m.a.a parama)
  {
    this.a = parama;
    return this;
  }
  
  public f a(d paramd)
  {
    this.d = paramd;
    return this;
  }
  
  public f a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public f a(String paramString, int paramInt)
  {
    c().putInt(paramString, paramInt);
    return this;
  }
  
  public f a(boolean paramBoolean, k paramk)
  {
    this.f = paramBoolean;
    this.g = paramk;
    return this;
  }
  
  public void b()
  {
    x.a(a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */