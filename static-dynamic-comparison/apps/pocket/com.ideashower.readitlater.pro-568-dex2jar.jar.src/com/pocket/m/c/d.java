package com.pocket.m.c;

import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.a.aa;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.w;
import com.ideashower.readitlater.e.o;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.m.a.k;
import com.pocket.m.b.f;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d
  extends w
{
  protected final ConcurrentHashMap p;
  protected final ConcurrentHashMap q;
  protected k r;
  protected boolean s = false;
  protected boolean t = false;
  protected boolean u = false;
  protected int v;
  
  public d(k paramk)
  {
    this.r = paramk;
    this.p = com.pocket.m.a.b();
    this.q = com.pocket.m.a.c();
  }
  
  private int a(o paramo, int paramInt1, ConcurrentHashMap paramConcurrentHashMap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    f localf = (f)paramConcurrentHashMap.get(Integer.valueOf(paramo.f()));
    if (localf != null)
    {
      if (localf.f()) {
        return 3;
      }
      if ((paramInt2 == 2) && (localf.h() != 2))
      {
        localf.D();
        localf = null;
      }
    }
    label188:
    label190:
    for (;;)
    {
      Object localObject;
      switch (paramInt1)
      {
      default: 
        localObject = null;
        if (paramInt2 == 2) {
          com.pocket.m.a.a((com.pocket.m.b.e)localObject);
        }
        break;
      }
      for (;;)
      {
        if (localf != null) {
          break label188;
        }
        paramConcurrentHashMap.put(Integer.valueOf(paramo.f()), localObject);
        return 2;
        if (localf.c() == paramInt3) {
          break label190;
        }
        localf.h(paramInt3);
        return 3;
        localObject = new com.pocket.m.b.i(paramInt2, paramInt3, h(), paramo, paramBoolean1, paramBoolean2);
        break;
        localObject = new com.pocket.m.b.l(paramInt2, paramInt3, h(), paramo, paramBoolean1);
        break;
        com.pocket.m.a.b((com.pocket.m.b.e)localObject);
      }
      return 3;
    }
  }
  
  protected void B()
  {
    super.B();
    if (!g.k())
    {
      this.g = true;
      return;
    }
    com.pocket.m.a.a(1, true);
    e();
  }
  
  public void a(int paramInt)
  {
    this.v = paramInt;
  }
  
  protected void a(o paramo)
  {
    a(paramo, 1, 2, false, false);
  }
  
  protected void a(o paramo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.k.get()) {
      throw new RuntimeException("Loading was cancelled");
    }
    if (paramBoolean1)
    {
      if ((this.v == 1) || (this.v == 0)) {
        paramo.i(0);
      }
      if ((this.v == 2) || (this.v == 0)) {
        paramo.h(0);
      }
      Object[] arrayOfObject = f(3);
      arrayOfObject[0] = Integer.valueOf(paramo.P());
      arrayOfObject[1] = Integer.valueOf(paramo.O());
      arrayOfObject[2] = Integer.valueOf(paramo.f());
      this.h.execSQL("UPDATE items SET offline_text = ?, offline_web = ? WHERE unique_id = ?", arrayOfObject);
      aa.b(paramo.f());
    }
    boolean bool1 = this.p.containsKey(Integer.valueOf(paramo.f()));
    boolean bool2 = this.q.containsKey(Integer.valueOf(paramo.f()));
    if (((paramBoolean1) || (!bool1)) && (a(1, paramo))) {}
    for (int i = a(paramo, 1, this.p, paramInt1, paramInt2, paramBoolean1, paramBoolean2);; i = 1)
    {
      if (((paramBoolean1) || (!bool2)) && (a(2, paramo))) {}
      for (paramInt1 = a(paramo, 2, this.q, paramInt1, paramInt2, paramBoolean1, paramBoolean2);; paramInt1 = 1)
      {
        if (((i == 2) || (paramInt1 == 2)) && (!bool1) && (!bool2)) {
          com.pocket.m.a.k();
        }
        return;
      }
    }
  }
  
  protected boolean a(int paramInt, o paramo)
  {
    if (this.v != 0) {
      if (paramInt != this.v) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != 1) {
        break;
      }
    } while (((paramo.P() == 0) || ((com.pocket.m.a.h()) && (paramo.P() <= 0))) && ((this.u) || ((this.s) && (paramo.d(true)))));
    do
    {
      do
      {
        return false;
      } while ((paramInt != 2) || ((paramo.O() != 0) && ((!com.pocket.m.a.h()) || (paramo.O() > 0))));
      if (this.t) {
        break;
      }
    } while ((!this.s) || (paramo.d(true)));
    return true;
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    com.ideashower.readitlater.i.a.g();
    com.pocket.m.a.g();
    com.pocket.m.a.e();
    com.pocket.m.a.a(1);
    super.b(paramBoolean, paramThrowable);
  }
  
  protected void e()
  {
    boolean bool2 = false;
    this.s = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.B);
    if (this.s)
    {
      bool1 = false;
      this.t = bool1;
      if (!this.s) {
        break label51;
      }
    }
    label51:
    for (boolean bool1 = bool2;; bool1 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.C))
    {
      this.u = bool1;
      return;
      bool1 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.D);
      break;
    }
  }
  
  protected ItemQuery g()
  {
    ItemQuery localItemQuery = new ItemQuery();
    com.pocket.list.adapter.data.l locall = localItemQuery.a().a(Integer.valueOf(0));
    label78:
    int i;
    label96:
    String str2;
    if (com.pocket.m.a.h())
    {
      str1 = "<=";
      if (!this.s) {
        break label263;
      }
      locall.e("(offline_text " + str1 + " 0 AND is_article != 0) OR (offline_web " + str1 + " 0 AND is_article = 0)");
      if (com.pocket.m.a.e.i())
      {
        if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.P) != 1) {
          break label408;
        }
        i = 1;
        locall.a(i);
        if (com.pocket.m.a.e.e())
        {
          if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.P) != 1) {
            break label413;
          }
          str2 = "<=";
        }
      }
    }
    for (String str1 = "ASC";; str1 = "DESC")
    {
      locall.e("time_added " + str2 + " (SELECT " + "time_added" + " FROM " + "items" + " " + " WHERE " + "offline_web" + " != 0 AND " + "offline_text" + " != 0" + " ORDER BY " + "time_added" + " " + str1 + " LIMIT 1)");
      this.r = k.a;
      locall.a();
      return localItemQuery;
      str1 = "=";
      break;
      label263:
      if ((this.t) && (this.u))
      {
        locall.e("offline_web " + str1 + " 0 OR offline_text " + str1 + " 0");
        break label78;
      }
      if (this.t)
      {
        locall.e("offline_web " + str1 + " 0");
        break label78;
      }
      if (this.u)
      {
        locall.e("offline_text" + str1 + " 0");
        break label78;
      }
      return null;
      label408:
      i = 0;
      break label96;
      label413:
      str2 = ">=";
    }
  }
  
  protected k h()
  {
    return this.r;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */