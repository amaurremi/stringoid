package com.ideashower.readitlater.db.operation;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;
import com.ideashower.readitlater.g.f;
import com.ideashower.readitlater.service.WakefulAppService;
import java.util.concurrent.TimeUnit;

public class d
{
  private static e a;
  private static SQLiteDatabase b;
  private static Context c;
  private static f d;
  
  public static void a()
  {
    c = g.c();
    c();
    d = new f(1, "db");
  }
  
  public static void a(c paramc)
  {
    d.a(paramc);
    WakefulAppService.a("dbdelegate start operation");
  }
  
  public static void b() {}
  
  public static boolean c()
  {
    if ((b == null) || (!b.isOpen())) {
      try
      {
        a = new e(c);
        b = a.getWritableDatabase();
        return true;
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          g.s().a(localSQLException);
        }
      }
    }
    return false;
  }
  
  public static void d() {}
  
  public static void e()
  {
    a.close();
    c.deleteDatabase("ril");
  }
  
  public static SQLiteDatabase f()
  {
    return b;
  }
  
  public static boolean g()
  {
    return d.g();
  }
  
  public static ag h()
  {
    new ag()
    {
      public void a()
      {
        d.j().a(20, TimeUnit.SECONDS);
        d.d();
      }
      
      public void b()
      {
        d.e();
        w.C();
      }
      
      public void c() {}
    };
  }
  
  public static int i()
  {
    return d.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */