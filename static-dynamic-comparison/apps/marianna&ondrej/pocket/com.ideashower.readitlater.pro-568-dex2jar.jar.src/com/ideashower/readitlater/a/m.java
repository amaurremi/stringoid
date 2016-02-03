package com.ideashower.readitlater.a;

import a.a.a.d;
import android.database.sqlite.SQLiteDiskIOException;
import com.ideashower.readitlater.activity.a.q;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.service.WakefulAppService;
import com.pocket.m.a;
import com.pocket.m.a.l;
import java.util.concurrent.atomic.AtomicBoolean;

public class m
{
  private static AtomicBoolean a;
  private final g b;
  
  public m(g paramg)
  {
    this.b = paramg;
  }
  
  private void c()
  {
    if (a == null) {
      a = new AtomicBoolean(false);
    }
    if (a.get()) {
      return;
    }
    a.d();
    g.a(new Runnable()
    {
      public void run()
      {
        if (g.u())
        {
          m.b().set(true);
          com.ideashower.readitlater.activity.a.k.M().N();
        }
      }
    });
  }
  
  public void a()
  {
    if (a != null) {
      a.set(false);
    }
  }
  
  public void a(final Throwable paramThrowable)
  {
    if (ac.b()) {
      return;
    }
    if (paramThrowable != null)
    {
      com.ideashower.readitlater.util.e.a(paramThrowable, true);
      if ((paramThrowable instanceof SQLiteDiskIOException))
      {
        a(paramThrowable, 4);
        return;
      }
    }
    g.a(new Runnable()
    {
      public void run()
      {
        if (g.u())
        {
          com.ideashower.readitlater.activity.a.c.a(this.a).N();
          m.this.b(paramThrowable);
        }
        com.pocket.c.e.a(false);
        a.d();
        WakefulAppService.b();
      }
    });
  }
  
  public void a(Throwable paramThrowable, int paramInt)
  {
    a(paramThrowable, paramInt, true);
  }
  
  public void a(Throwable paramThrowable, int paramInt, boolean paramBoolean)
  {
    if (paramThrowable != null) {
      com.ideashower.readitlater.util.e.a(paramThrowable);
    }
    if (!this.b.t()) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt != 5) && ((!l.c().g()) || (l.c().i() == 1))) {
            break;
          }
        } while (((a != null) && (a.get())) || (paramInt == 4) || (paramInt == 1));
        com.pocket.c.e.a(false);
        a.d();
      } while (!g.u());
      g.a(new Runnable()
      {
        public void run()
        {
          if (l.c().i() == 3)
          {
            q.b(2).N();
            return;
          }
          q.b(1).N();
        }
      });
      return;
    } while (!l.c().h());
    c();
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable == null) {
      return;
    }
    com.ideashower.readitlater.util.e.a(paramThrowable);
    try
    {
      throw new n(this, org.apache.a.c.k.c(paramString), paramThrowable);
    }
    catch (Throwable paramThrowable)
    {
      d.a(paramThrowable, null);
    }
  }
  
  public void b(Throwable paramThrowable)
  {
    a(paramThrowable, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */