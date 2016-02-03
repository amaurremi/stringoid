package com.pocket.list.adapter.a;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.ideashower.readitlater.e.u;
import com.pocket.list.widget.b;
import com.pocket.list.widget.b.b.c;
import com.pocket.list.widget.b.b.d;
import com.pocket.list.widget.b.b.e;
import com.pocket.list.widget.b.b.f;
import com.pocket.list.widget.b.b.g;
import com.pocket.list.widget.b.b.h;
import com.pocket.list.widget.b.b.i;
import com.pocket.list.widget.b.b.l;
import com.pocket.list.widget.b.b.m;
import com.pocket.list.widget.b.b.n;
import com.pocket.list.widget.b.b.p;
import com.pocket.list.widget.b.b.q;
import com.pocket.list.widget.b.b.r;
import com.pocket.list.widget.b.b.s;
import com.pocket.list.widget.b.b.t;
import java.util.ArrayList;

public class a
{
  private final b a;
  private final ArrayList b = new ArrayList();
  private final SparseIntArray c = new SparseIntArray();
  private final com.ideashower.readitlater.objects.k d = new com.ideashower.readitlater.objects.k();
  private c e;
  private h f;
  private i g;
  private r h;
  private s i;
  private com.pocket.list.widget.b.b.j j;
  private com.pocket.list.widget.b.b.k k;
  private t l;
  private p m;
  private q n;
  private c o;
  private f p;
  private d q;
  private e r;
  private l s;
  private m t;
  private n u;
  private com.pocket.list.widget.b.b.o v;
  
  public a(b paramb)
  {
    this.a = paramb;
  }
  
  private void a(com.pocket.list.widget.b.b.a parama)
  {
    parama.a(this.a);
    this.b.add(parama);
  }
  
  private boolean a(com.ideashower.readitlater.e.o paramo)
  {
    paramo = paramo.q();
    if (org.apache.a.c.k.e(paramo) < 15) {}
    while ((org.apache.a.c.k.c(paramo, ".jpg")) || (org.apache.a.c.k.c(paramo, ".png")) || (org.apache.a.c.k.c(paramo, ".gif")) || (org.apache.a.c.k.c(paramo, ".jpeg"))) {
      return false;
    }
    return true;
  }
  
  private com.pocket.list.widget.b.b.a b(int paramInt)
  {
    Resources localResources = this.a.getResources();
    switch (paramInt)
    {
    case 4: 
    case 10: 
    default: 
      return null;
    case 1: 
      if (this.f == null)
      {
        this.f = new h(localResources, this.a);
        a(this.f);
      }
      return this.f;
    case 15: 
      if (this.g == null)
      {
        this.g = new i(localResources, this.a);
        a(this.g);
      }
      return this.g;
    case 2: 
      if (this.h == null)
      {
        this.h = new r(localResources, this.a);
        a(this.h);
      }
      return this.h;
    case 16: 
      if (this.i == null)
      {
        this.i = new s(localResources, this.a);
        a(this.i);
      }
      return this.i;
    case 3: 
      if (this.j == null)
      {
        this.j = new com.pocket.list.widget.b.b.j(localResources, this.a);
        a(this.j);
      }
      return this.j;
    case 17: 
      if (this.k == null)
      {
        this.k = new com.pocket.list.widget.b.b.k(localResources, this.a);
        a(this.k);
      }
      return this.k;
    case 5: 
      if (this.l == null)
      {
        this.l = new t(localResources, this.a);
        a(this.l);
      }
      return this.l;
    case 6: 
      if (this.m == null)
      {
        this.m = new p(localResources, this.a);
        a(this.m);
      }
      return this.m;
    case 18: 
      if (this.n == null)
      {
        this.n = new q(localResources, this.a);
        a(this.n);
      }
      return this.n;
    case 7: 
      if (this.s == null)
      {
        this.s = new l(localResources, this.a);
        a(this.s);
      }
      return this.s;
    case 19: 
      if (this.t == null)
      {
        this.t = new m(localResources, this.a);
        a(this.t);
      }
      return this.t;
    case 8: 
      if (this.u == null)
      {
        this.u = new n(localResources, this.a);
        a(this.u);
      }
      return this.u;
    case 20: 
      if (this.v == null)
      {
        this.v = new com.pocket.list.widget.b.b.o(localResources, this.a);
        a(this.v);
      }
      return this.v;
    case 9: 
      if (this.e == null)
      {
        this.e = new g(localResources, this.a);
        a(this.e);
      }
      return this.e;
    case 11: 
      if (this.o == null)
      {
        this.o = new c(localResources, this.a);
        a(this.o);
      }
      return this.o;
    case 12: 
      if (this.p == null)
      {
        this.p = new f(localResources, this.a);
        a(this.p);
      }
      return this.p;
    case 13: 
      if (this.q == null)
      {
        this.q = new d(localResources, this.a);
        a(this.q);
      }
      return this.q;
    }
    if (this.r == null)
    {
      this.r = new e(localResources, this.a);
      a(this.r);
    }
    return this.r;
  }
  
  public com.pocket.list.widget.b.b.a a(com.ideashower.readitlater.e.o paramo, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4, u paramu)
  {
    this.d.a = 0;
    this.d.b = 0;
    com.ideashower.readitlater.e.a locala = paramo.X();
    boolean bool = paramo.e(true);
    if (com.ideashower.readitlater.util.j.f())
    {
      if ((paramu != null) && (paramu.h()))
      {
        if (bool) {}
        for (paramInt1 = 14;; paramInt1 = 13) {
          return b(paramInt1);
        }
      }
      if (paramBoolean1)
      {
        if ((paramo.J()) && (!a(paramo)))
        {
          if (paramo.h(true)) {}
          for (paramInt1 = 19;; paramInt1 = 7) {
            return b(paramInt1);
          }
        }
        if (paramo.h(true)) {}
        for (paramInt1 = 20;; paramInt1 = 8) {
          return b(paramInt1);
        }
      }
      switch (paramInt2)
      {
      default: 
        if (!paramo.h(true)) {
          break;
        }
      }
    }
    for (paramInt1 = 15;; paramInt1 = 1)
    {
      return b(paramInt1);
      if ((paramo.J()) || (bool)) {}
      for (paramInt1 = 12;; paramInt1 = 11) {
        return b(paramInt1);
      }
      if (bool) {}
      for (paramInt1 = 14;; paramInt1 = 13) {
        return b(paramInt1);
      }
      if (a(paramo))
      {
        if (paramo.h(true)) {}
        for (paramInt1 = 20;; paramInt1 = 8) {
          return b(paramInt1);
        }
      }
      if (paramo.h(true)) {}
      for (paramInt1 = 19;; paramInt1 = 7) {
        return b(paramInt1);
      }
      if (paramo.h(true)) {}
      for (paramInt1 = 20;; paramInt1 = 8) {
        return b(paramInt1);
      }
      if (paramInt1 == 1) {
        return b(9);
      }
      if ((paramu != null) && (paramu.h()))
      {
        if (paramo.h(true)) {}
        for (paramInt1 = 15;; paramInt1 = 1) {
          return b(paramInt1);
        }
      }
      if (paramo.J())
      {
        if (paramo.h(true)) {}
        for (paramInt1 = 17;; paramInt1 = 3) {
          return b(paramInt1);
        }
      }
      if ((!bool) || ((paramo.I() == 0) && ((!com.ideashower.readitlater.util.j.f()) || (!paramo.L())))) {
        break;
      }
      if ((paramBoolean2) && (paramInt3 >= 2))
      {
        paramInt1 = this.c.get(6);
        paramInt2 = this.c.get(5);
        if (((b(6).a(locala, this.d, false)) && (paramInt1 == 0)) || ((paramInt4 - paramInt1 >= 4) && (paramo.b(30))))
        {
          this.c.put(6, paramInt4);
          if (paramo.h(true)) {}
          for (paramInt1 = 18;; paramInt1 = 6) {
            return b(paramInt1);
          }
        }
        if (((!paramo.h(true)) && (b(5).a(locala, this.d, false)) && (paramInt2 == 0)) || (paramInt4 - paramInt2 >= 4))
        {
          this.c.put(5, paramInt4);
          return b(5);
        }
      }
      paramu = b(2);
      com.ideashower.readitlater.objects.k localk = this.d;
      if ((paramo.d(false)) || (paramo.L()))
      {
        paramBoolean1 = true;
        label595:
        if (!paramu.a(locala, localk, paramBoolean1)) {
          break label630;
        }
        if (!paramo.h(true)) {
          break label632;
        }
      }
      label630:
      label632:
      for (paramInt1 = 16;; paramInt1 = 2)
      {
        return b(paramInt1);
        paramBoolean1 = false;
        break label595;
        break;
      }
    }
  }
  
  public void a()
  {
    int i2 = this.b.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((com.pocket.list.widget.b.b.a)this.b.get(i1)).a(this.a);
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      this.c.clear();
    }
    for (;;)
    {
      return;
      int i1 = this.c.size() - 1;
      while (i1 >= paramInt)
      {
        this.c.delete(this.c.keyAt(i1));
        i1 -= 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */