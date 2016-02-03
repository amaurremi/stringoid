package com.pocket.list.adapter.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import android.util.SparseArray;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.u;
import com.ideashower.readitlater.objects.ErrorReport;

public class a
{
  private final ItemQuery a = k.a();
  private final com.ideashower.readitlater.objects.h b = new com.ideashower.readitlater.objects.h();
  private final SparseArray c = new SparseArray();
  private final com.ideashower.readitlater.objects.i d;
  private final h e;
  private final j f;
  private final b g;
  private final c h;
  private final d i;
  private final int j;
  private final e k;
  private f l;
  private boolean m;
  private boolean n;
  private Boolean o;
  private boolean p;
  private SharedPreferences.OnSharedPreferenceChangeListener q;
  private boolean r;
  private ErrorReport s;
  private Runnable t;
  private com.ideashower.readitlater.h.d u;
  
  public a(e parame)
  {
    this(parame, 30);
  }
  
  public a(e parame, int paramInt)
  {
    this.k = parame;
    this.o = null;
    this.j = paramInt;
    this.d = new com.ideashower.readitlater.objects.i(0, paramInt);
    this.g = new b(this, null);
    this.e = new h(this.g);
    this.f = new j(this.g);
    this.l = this.e;
    this.h = new c(this, null);
    com.ideashower.readitlater.i.c.a(this.h);
    this.i = new d(this, null);
    this.a.a(this.i);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.d.a(paramInt1, paramInt2);
    a(this.a.a().c(Integer.valueOf(paramInt1)).d(Integer.valueOf(paramInt2 - paramInt1)));
  }
  
  private void a(ItemQuery paramItemQuery)
  {
    if ((this.u != null) && (paramItemQuery.j() != this.u.a())) {
      a(j().a().a(this.u.a()));
    }
  }
  
  private void a(l paraml)
  {
    this.n = true;
    paraml.a();
    this.n = false;
  }
  
  private void a(boolean paramBoolean, ErrorReport paramErrorReport)
  {
    this.p = false;
    this.l = this.e;
    this.s = paramErrorReport;
    this.r = paramBoolean;
    n();
  }
  
  private void n()
  {
    if ((this.o == null) || (!this.o.booleanValue())) {
      return;
    }
    if (this.b.isEmpty()) {
      this.k.b(this);
    }
    for (;;)
    {
      this.l.a(this.a.c());
      return;
      if (this.d.b > this.b.size()) {
        this.k.d(this);
      }
    }
  }
  
  public int a(o paramo)
  {
    if (this.l == this.e) {
      return paramo.f();
    }
    return paramo.c();
  }
  
  public void a()
  {
    a(this.j);
  }
  
  public void a(int paramInt)
  {
    this.s = null;
    this.r = false;
    this.b.clear();
    this.c.clear();
    this.k.a(this);
    this.k.b(this, h());
    a(0, paramInt);
    this.e.b();
    this.f.b();
    if (this.a.l()) {}
    for (Object localObject = this.f;; localObject = this.e)
    {
      this.l = ((f)localObject);
      n();
      return;
    }
  }
  
  public void a(final com.ideashower.readitlater.h.d paramd)
  {
    this.u = paramd;
    if (this.q != null) {
      com.ideashower.readitlater.h.i.b(this.q);
    }
    if (paramd != null)
    {
      this.q = new SharedPreferences.OnSharedPreferenceChangeListener()
      {
        public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
        {
          if (paramAnonymousString.equals(paramd.b())) {
            a.this.j().a().a(paramd.a()).a();
          }
        }
      };
      com.ideashower.readitlater.h.i.a(this.q);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.o != null) && (this.o.booleanValue() == paramBoolean)) {
      return;
    }
    this.o = Boolean.valueOf(paramBoolean);
    if (!paramBoolean)
    {
      this.p = false;
      a();
      this.k.b();
      return;
    }
    this.p = true;
    g.o().post(new Runnable()
    {
      public void run()
      {
        if (!a.a(a.this)) {
          return;
        }
        a.a(a.this, a.this.j());
        a.this.a();
      }
    });
  }
  
  public int b(o paramo)
  {
    return this.b.b(paramo);
  }
  
  public o b(int paramInt)
  {
    return (o)this.b.get(paramInt);
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    this.m = false;
    a(0, Math.max(Math.max(this.b.size(), this.j), this.d.b));
    n();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.t == null) {
        this.t = new Runnable()
        {
          public void run()
          {
            a.b(a.this).c();
          }
        };
      }
      g.o().post(this.t);
    }
    this.l.c();
  }
  
  public int c(o paramo)
  {
    int i1 = this.b.c(paramo.f());
    if (i1 != -1)
    {
      this.b.e(i1);
      this.c.remove(i1);
      this.k.b(this, h());
      return i1;
    }
    return -1;
  }
  
  public u c(int paramInt)
  {
    return (u)this.c.get(paramInt);
  }
  
  public void c()
  {
    if (this.a == null) {
      throw new RuntimeException("You must first set an initial query with one of the load methods");
    }
    if (this.d.b > 0) {}
    for (int i1 = Math.min(this.b.size(), this.d.a);; i1 = this.b.size())
    {
      a(i1, Math.max(this.d.b, this.j + this.b.size()));
      n();
      return;
    }
  }
  
  public o d(int paramInt)
  {
    if (this.l == this.e) {
      return this.b.a(paramInt);
    }
    return this.b.b(paramInt);
  }
  
  public boolean d()
  {
    return this.l == this.e;
  }
  
  public boolean e()
  {
    return this.l == this.f;
  }
  
  public boolean f()
  {
    return (j().l()) && (this.l == this.e);
  }
  
  public ErrorReport g()
  {
    if (f()) {
      return this.s;
    }
    return null;
  }
  
  public int h()
  {
    return this.b.size();
  }
  
  public boolean i()
  {
    return h() == 0;
  }
  
  public ItemQuery j()
  {
    return this.a;
  }
  
  public int k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return !this.m;
  }
  
  public void m()
  {
    this.e.b();
    this.f.b();
    com.ideashower.readitlater.i.c.b(this.h);
    if (this.q != null) {
      com.ideashower.readitlater.h.i.b(this.q);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */