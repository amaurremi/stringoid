package com.pocket.m.a;

import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.g.k;
import com.pocket.m.a;
import java.io.File;
import org.apache.a.b.b;

public abstract class g
{
  private static final boolean a = com.ideashower.readitlater.util.e.a(true);
  private static final Object b = new Object();
  private static boolean c;
  private static boolean d;
  private static boolean e;
  private static com.pocket.m.e f;
  
  public static void a()
  {
    if (!as.l()) {
      return;
    }
    if (!com.pocket.m.a.a.c.f())
    {
      com.pocket.m.a.a.c.c();
      return;
    }
    synchronized (b)
    {
      if (a.a(true))
      {
        f();
        return;
      }
    }
    if (!c)
    {
      c = true;
      d = false;
      h localh = new h(null);
      localh.a(new com.ideashower.readitlater.g.l()
      {
        public void a() {}
        
        public void a(k paramAnonymousk, boolean paramAnonymousBoolean)
        {
          synchronized ()
          {
            g.a(false);
            if ((g.c()) && (((h)paramAnonymousk).g())) {
              g.a();
            }
            com.ideashower.readitlater.util.e.a();
            return;
          }
        }
      }, false);
      localh.f();
    }
    for (;;)
    {
      return;
      d = true;
    }
  }
  
  public static void a(File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      do
      {
        return;
        localObject = paramFile.getAbsolutePath();
      } while ((((String)localObject).equals(l.c().c())) || (((String)localObject).equals(l.c().a())) || (!paramFile.exists()));
      if (paramFile.list() == null)
      {
        com.ideashower.readitlater.util.e.a(paramFile + " is not a directory");
        b.c(paramFile);
        return;
      }
    } while (paramFile.list().length != 0);
    Object localObject = paramFile.getParentFile();
    b.c(paramFile);
    a((File)localObject);
  }
  
  private static void b(String paramString)
  {
    a(new File(paramString));
  }
  
  private static void f()
  {
    if (e) {}
    do
    {
      return;
      e = true;
    } while (f != null);
    f = new com.pocket.m.e()
    {
      public void a()
      {
        if ((g.d()) && (!a.a(true)))
        {
          g.b(false);
          g.a();
        }
      }
    };
    a.a(f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */