package com.pocket.p;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Environment;
import android.view.Window;
import android.widget.Toast;
import com.e.c.b;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.k;
import com.ideashower.readitlater.util.z;
import com.pocket.m.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class r
{
  private static com.e.c.a a;
  private static b b;
  private static boolean c;
  
  private static String a(Activity paramActivity)
  {
    String str = h();
    if (str == null) {}
    do
    {
      return null;
      paramActivity = z.b(paramActivity.getWindow().getDecorView());
    } while ((paramActivity == null) || (!com.ideashower.readitlater.f.i.a(str, paramActivity, d.a())));
    return str;
  }
  
  public static void a()
  {
    if (!g.y()) {
      return;
    }
    g.a(new com.ideashower.readitlater.a.i()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          r.a(false);
          r.b();
          return;
        }
        r.c();
      }
    });
  }
  
  private static void e()
  {
    if (a == null)
    {
      b = new b()
      {
        private final long a = 3000L;
        private long b;
        
        public void a()
        {
          long l = System.currentTimeMillis();
          if (l < this.b + 3000L) {
            this.b = l;
          }
          for (;;)
          {
            return;
            this.b = l;
            switch (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.cs))
            {
            case 2: 
            default: 
              return;
            case 0: 
              r.d();
              return;
            case 3: 
              if (m.a(m.a())) {
                m.b(0);
              }
              while (g.n() != null)
              {
                g.n().a(m.a(g.n()));
                return;
                m.b(1);
              }
            }
            if (as.m()) {
              com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.cr, 2);
            }
            for (String str = "Switched to Fake Free";; str = "Switched to Fake Premium")
            {
              as.y();
              if (g.n() == null) {
                break;
              }
              Toast.makeText(g.n(), str, 0).show();
              return;
              com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.cr, 1);
            }
          }
        }
      };
      a = new com.e.c.a(b);
    }
    a.a((SensorManager)g.c().getSystemService("sensor"));
  }
  
  private static void f()
  {
    if (a != null) {
      a.a();
    }
  }
  
  private static void g()
  {
    if (c) {}
    com.ideashower.readitlater.activity.a locala;
    String str1;
    do
    {
      do
      {
        return;
        locala = g.n();
      } while (locala == null);
      str1 = g.b().n();
    } while (str1 == null);
    Object localObject2 = a(locala);
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = "file://" + (String)localObject2;
    }
    localObject2 = new s(null);
    locala.a((s)localObject2);
    Iterator localIterator = s.a((s)localObject2).iterator();
    String str2;
    while (localIterator.hasNext())
    {
      str2 = (String)localIterator.next();
      str1 = str1 + "," + str2;
    }
    localIterator = s.b((s)localObject2).iterator();
    for (localObject2 = "Please include as much info as possible"; localIterator.hasNext(); localObject2 = (String)localObject2 + "\n\n" + str2) {
      str2 = (String)localIterator.next();
    }
    k.a(locala, str1, "Android Feedback Report", (String)localObject2 + "\n\n", true, null, (String)localObject1);
    c = true;
  }
  
  private static String h()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      return Environment.getExternalStorageDirectory().toString() + "/Android/data/" + g.c().getPackageName() + "/files/capture.jpg";
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */