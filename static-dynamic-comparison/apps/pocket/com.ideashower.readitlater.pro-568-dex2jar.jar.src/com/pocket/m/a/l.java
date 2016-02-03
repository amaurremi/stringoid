package com.pocket.m.a;

import android.os.Environment;
import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a.q;
import com.ideashower.readitlater.util.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.a.b.b;

public final class l
{
  private static c a = new c();
  private static final Pattern b = Pattern.compile("[\\#\\=\\?\\&\\%\\;\\:\\*\\\"\\<\\>\\|]");
  private static final ArrayList c = new ArrayList();
  
  public static void a() {}
  
  public static void a(int paramInt)
  {
    Iterator localIterator = c.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if ((((n)localIterator.next()).aC()) || (i != 0)) {}
      for (i = 1;; i = 0) {
        break;
      }
    }
    if (i == 0) {
      g.a(new Runnable()
      {
        public void run()
        {
          if ((l.c().i() != 1) && (g.n() != null)) {
            q.b(this.a).a(g.n());
          }
        }
      });
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean1, Runnable paramRunnable, boolean paramBoolean2)
  {
    final com.ideashower.readitlater.activity.a.l locall = com.ideashower.readitlater.activity.a.l.b(paramInt);
    locall.N();
    new m(paramBoolean1, new Runnable()
    {
      public void run()
      {
        if (l.this != null) {
          l.this.run();
        }
        locall.b();
      }
    }, paramBoolean2).h();
  }
  
  public static void a(n paramn)
  {
    e.b();
    c.add(paramn);
  }
  
  public static void a(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    try
    {
      b.b(paramFile);
      return;
    }
    catch (FileNotFoundException paramFile)
    {
      e.a(paramFile);
      return;
    }
    catch (IOException paramFile)
    {
      e.a(paramFile);
      return;
    }
    catch (Throwable paramFile)
    {
      e.a(paramFile);
    }
  }
  
  public static boolean a(a parama)
  {
    try
    {
      b.g(new File(parama.d()));
      new File(parama.c() + ".nf").createNewFile();
      return true;
    }
    catch (IOException parama)
    {
      e.a(parama);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static String b(String paramString)
  {
    return b.matcher(paramString).replaceAll("");
  }
  
  public static void b() {}
  
  public static void b(n paramn)
  {
    e.b();
    c.remove(paramn);
  }
  
  public static boolean b(a parama)
  {
    return new File(parama.c() + ".nf").exists();
  }
  
  public static c c()
  {
    return a;
  }
  
  public static ag d()
  {
    new ag()
    {
      public void a() {}
      
      public void b()
      {
        l.g().d();
      }
      
      public void c()
      {
        l.a(new c());
      }
    };
  }
  
  public static boolean e()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static void f()
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).aB();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */