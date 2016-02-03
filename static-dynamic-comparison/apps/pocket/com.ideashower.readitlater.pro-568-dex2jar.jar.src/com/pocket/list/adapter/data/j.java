package com.pocket.list.adapter.data;

import android.os.Handler;
import com.ideashower.readitlater.d.a;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;
import com.ideashower.readitlater.objects.h;
import com.pocket.c.ab;
import com.pocket.c.ac;

public class j
  extends f
  implements l
{
  private static final String a = j.class.getName();
  private static final boolean b = com.ideashower.readitlater.util.e.a(false);
  private final Handler c = com.ideashower.readitlater.a.g.o();
  private final Runnable d = new Runnable()
  {
    public void run()
    {
      if ((j.a(j.this) != null) && (!j.a(j.this).a_()))
      {
        if (j.d()) {
          com.ideashower.readitlater.util.e.b(j.e(), "pending task executed");
        }
        j.a(j.this, j.a(j.this));
        j.b(j.this, null);
        j.b(j.this).q();
      }
    }
  };
  private ab e;
  private ab f;
  private g g;
  
  public j(g paramg)
  {
    super(paramg);
  }
  
  protected a a(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, g paramg)
  {
    this.e = null;
    this.f = null;
    if (com.ideashower.readitlater.a.g.k())
    {
      this.g = paramg;
      paramg = com.pocket.c.e.a(paramReadOnlyItemQuery, new ac()
      {
        public void a(h paramAnonymoush)
        {
          f.a(paramAnonymoush);
        }
      });
      paramg.a(this, true);
      if ((paramReadOnlyItemQuery.y()) && (paramReadOnlyItemQuery.q() == 0))
      {
        if (b) {
          com.ideashower.readitlater.util.e.b(a, "new task will execute after delay");
        }
        this.e = paramg;
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, 750L);
        return paramg;
      }
      if (b) {
        com.ideashower.readitlater.util.e.b(a, "new task executed immediately");
      }
      this.f = paramg;
      paramg.q();
      return paramg;
    }
    paramg.a(this, paramReadOnlyItemQuery);
    return null;
  }
  
  public void a() {}
  
  public void a(k paramk, boolean paramBoolean)
  {
    if ((paramk != this.f) || (paramk.a_()))
    {
      if (b) {
        com.ideashower.readitlater.util.e.b(a, "disregarding outdated results onComplete()");
      }
      return;
    }
    if (b) {
      com.ideashower.readitlater.util.e.b(a, "publishing results onComplete()");
    }
    paramk = (ab)paramk;
    g localg = this.g;
    h localh = paramk.n();
    this.e = null;
    this.g = null;
    if (!paramBoolean)
    {
      localg.a(this, paramk.p(), paramk.t());
      return;
    }
    if (localh == null)
    {
      localg.a(this, paramk.p(), null);
      return;
    }
    localg.a(this, paramk.p(), localh, paramk.o());
  }
  
  public void c()
  {
    if (b) {
      com.ideashower.readitlater.util.e.b(a, "commitPendingQuery()");
    }
    this.c.removeCallbacks(this.d);
    this.d.run();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */