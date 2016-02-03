package com.ideashower.readitlater.a;

import com.ideashower.readitlater.db.operation.d;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.k;
import com.pocket.tts.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class ac
{
  private static final AtomicBoolean d = new AtomicBoolean();
  private CountDownLatch a;
  private final ae b;
  private final ArrayList c = new ArrayList();
  
  public ac(ae paramae)
  {
    this.b = paramae;
  }
  
  private void a(ag paramag)
  {
    if (paramag == null) {
      return;
    }
    this.c.add(paramag);
  }
  
  public static void a(boolean paramBoolean)
  {
    d.set(paramBoolean);
  }
  
  public static boolean b()
  {
    return d.get();
  }
  
  public void a()
  {
    a(com.pocket.m.a.l.d());
    a(com.pocket.m.a.e.d());
    a(am.d());
    a(l.b());
    a(q.f());
    a(w.e());
    a(x.c());
    a(com.ideashower.readitlater.a.a.a.e());
    a(as.o());
    a(d.h());
    a(com.pocket.m.a.m());
    a(com.pocket.c.e.p());
    a(j.r());
    a(o.f());
    a(h.r());
    a(k.d());
    a(com.pocket.n.a.a());
    this.a = new CountDownLatch(this.c.size());
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      new af(this, (ag)localIterator.next(), null).execute(new Void[0]);
    }
    new ad(this, null).execute(new Void[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */