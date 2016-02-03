package com.pocket.c;

import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.activity.a.d;
import com.ideashower.readitlater.activity.a.n;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.service.WakefulAppService;
import com.ideashower.readitlater.util.u;
import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;
import com.pocket.user.UserMeta;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
{
  private static final AtomicInteger a = new AtomicInteger(0);
  private static final al b = new al();
  private static com.ideashower.readitlater.g.f c;
  private static i d;
  private static boolean e;
  private static boolean f;
  private static t g;
  private static com.ideashower.readitlater.g.g h;
  private static com.ideashower.readitlater.g.g i;
  private static final Object j = new Object();
  private static final Object k = new Object();
  private static com.ideashower.readitlater.g.i l;
  private static boolean m = false;
  private static t n;
  private static CountDownLatch o;
  private static boolean p;
  private static d q;
  
  public static ab a(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, ac paramac)
  {
    return new ab(paramReadOnlyItemQuery, paramac);
  }
  
  public static void a()
  {
    b(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ai));
    c = new com.ideashower.readitlater.g.f(1, "sync");
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = j;
    if (paramBoolean1)
    {
      paramInt1 += 1;
      paramInt2 += 1;
    }
    for (;;)
    {
      int i1 = paramInt2;
      if (!paramBoolean2) {
        i1 = paramInt2 + 1;
      }
      paramInt1 = (int)(paramInt1 / i1 * 100.0F);
      try
      {
        com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aQ, paramInt1).a();
        b.a(paramInt1 / 100.0F);
        return;
      }
      finally {}
    }
  }
  
  public static void a(int paramInt1, ErrorReport paramErrorReport, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ca) != null) {
      d(paramInt2);
    }
    while ((m) || (paramInt2 == 2) || ((paramInt2 == 3) && (!paramBoolean1))) {
      return;
    }
    String str;
    switch (paramInt1)
    {
    case -6: 
    case -3: 
    case -2: 
    default: 
      return;
    case -5: 
      if ((paramErrorReport != null) && (!org.apache.a.c.k.c(paramErrorReport.b())))
      {
        str = paramErrorReport.b();
        label93:
        if (paramErrorReport == null) {
          break label139;
        }
      }
      break;
    }
    for (;;)
    {
      d.a(1, 2131493167, str, paramBoolean2, paramErrorReport).N();
      return;
      com.ideashower.readitlater.activity.a.b.b(2131493167, 2131493168).N();
      return;
      paramBoolean2 = true;
      break;
      str = com.ideashower.readitlater.a.g.a(2131493178);
      break label93;
      label139:
      paramErrorReport = new ErrorReport(-1, str);
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, com.ideashower.readitlater.db.operation.action.c paramc, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i1 = 0;
    if (paramBoolean) {
      c(2);
    }
    for (;;)
    {
      paramArrayOfObject[0] = paramc.f();
      if (paramBoolean) {
        i1 = 1;
      }
      paramArrayOfObject[1] = Integer.valueOf(i1);
      paramSQLiteDatabase.execSQL("INSERT INTO sync_queue (action, send_asap) VALUES (?,?)", paramArrayOfObject);
      return;
      c(1);
    }
  }
  
  public static void a(com.ideashower.readitlater.activity.a parama)
  {
    com.ideashower.readitlater.activity.a.f.M().a(parama);
  }
  
  public static void a(final com.ideashower.readitlater.d.f paramf, boolean paramBoolean)
  {
    com.ideashower.readitlater.g.l local4 = new com.ideashower.readitlater.g.l()
    {
      public void a()
      {
        synchronized ()
        {
          e.a(null);
          return;
        }
      }
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean) {}
    };
    synchronized (j)
    {
      h = new p(new q()
      {
        public void a(UserMeta paramAnonymousUserMeta, ErrorReport paramAnonymousErrorReport, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          if (paramAnonymousBoolean1) {
            as.a(UserMeta.a(as.e(), paramAnonymousUserMeta));
          }
          while ((!this.a) || (paramAnonymousBoolean2))
          {
            if (paramf != null) {
              paramf.a(paramAnonymousBoolean1);
            }
            return;
          }
          if (paramAnonymousErrorReport != null) {}
          for (paramAnonymousUserMeta = paramAnonymousErrorReport.b();; paramAnonymousUserMeta = com.ideashower.readitlater.a.g.a(2131493043))
          {
            com.ideashower.readitlater.activity.a.b.a(2131493090, paramAnonymousUserMeta).N();
            break;
          }
        }
      });
      h.a(local4, false);
      h.h();
      return;
    }
  }
  
  public static void a(am paramam)
  {
    synchronized (j)
    {
      b.a(paramam);
      return;
    }
  }
  
  public static void a(an paraman)
  {
    c.a(paraman);
  }
  
  public static void a(File paramFile, com.ideashower.readitlater.d.f paramf)
  {
    paramFile = new ai(paramFile);
    paramFile.a(new com.ideashower.readitlater.g.l()
    {
      public void a() {}
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        com.ideashower.readitlater.d.f localf;
        if (e.this != null)
        {
          localf = e.this;
          if ((!paramAnonymousBoolean) || (!((ai)paramAnonymousk).u())) {
            break label36;
          }
        }
        label36:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          localf.a(paramAnonymousBoolean);
          return;
        }
      }
    }, true);
    paramFile.h();
  }
  
  public static void a(String paramString, com.ideashower.readitlater.d.f paramf)
  {
    a(paramString, "https://getpocket.com/v3/resendEmailConfirmation", paramf);
  }
  
  public static void a(String paramString, z paramz)
  {
    new y(paramString, paramz).h();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, false, null);
  }
  
  private static void a(String paramString1, String paramString2, com.ideashower.readitlater.d.f paramf)
  {
    paramString1 = new v(paramString1, paramString2);
    paramString1.a(new com.ideashower.readitlater.g.l()
    {
      public void a() {}
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        com.ideashower.readitlater.d.f localf;
        if (e.this != null)
        {
          localf = e.this;
          if ((!paramAnonymousBoolean) || (!((f)paramAnonymousk).u())) {
            break label36;
          }
        }
        label36:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          localf.a(paramAnonymousBoolean);
          return;
        }
      }
    }, true);
    paramString1.h();
  }
  
  public static void a(final String paramString1, String paramString2, ak paramak)
  {
    paramString1 = new aj(paramString1, paramString2);
    paramString1.a(new com.ideashower.readitlater.g.l()
    {
      public void a() {}
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        ak localak = e.this;
        if (paramAnonymousBoolean) {}
        for (paramAnonymousk = paramString1.n();; paramAnonymousk = null)
        {
          localak.a(paramAnonymousk);
          return;
        }
      }
    }, true);
    paramString1.h();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, g paramg)
  {
    com.ideashower.readitlater.g.l local6 = new com.ideashower.readitlater.g.l()
    {
      public void a()
      {
        synchronized ()
        {
          e.b(null);
          return;
        }
      }
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean) {}
    };
    synchronized (j)
    {
      i = new c(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramg);
      i.a(local6, false);
      i.h();
      return;
    }
  }
  
  public static void a(String paramString1, final String paramString2, final boolean paramBoolean, final com.ideashower.readitlater.d.f paramf)
  {
    if (!paramBoolean) {
      WakefulAppService.a(2131493748, 1);
    }
    if (as.j() == null)
    {
      if (paramBoolean)
      {
        if (paramf != null) {
          paramf.a(false);
        }
        return;
      }
      a(new com.ideashower.readitlater.d.f()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            if (as.j() == null) {
              n.a(e.this, paramString2, paramf).N();
            }
          }
          while (paramf == null)
          {
            return;
            e.b(e.this, paramString2, paramBoolean, paramf);
            return;
          }
          paramf.a(false);
        }
      }, true);
      return;
    }
    c(paramString1, paramString2, paramBoolean, paramf);
  }
  
  public static void a(boolean paramBoolean)
  {
    synchronized (j)
    {
      Object localObject2 = b.d();
      if (localObject2 != null) {
        ((ah)localObject2).D();
      }
      localObject2 = b.c();
      if (localObject2 != null) {
        ((o)localObject2).D();
      }
      b.a(false);
      if (!paramBoolean) {
        return;
      }
      if (g != null) {
        g.D();
      }
      if (i != null) {
        i.D();
      }
      return;
    }
  }
  
  static void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = j;
    if (!paramBoolean) {}
    try
    {
      j();
      return;
    }
    finally {}
    if (paramInt == 0)
    {
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aI, true).a();
      i();
      com.ideashower.readitlater.i.c.a();
      return;
    }
    int i1 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aK) + 1;
    com.ideashower.readitlater.h.i.b().a((com.ideashower.readitlater.h.b)com.ideashower.readitlater.h.a.aP.b(paramInt), true).a(com.ideashower.readitlater.h.a.aK, i1).a();
    paramInt = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aM);
    if (i1 >= paramInt) {
      y();
    }
    for (;;)
    {
      a(i1, paramInt, true, false);
      break;
      int i2 = (int)(i1 / paramInt * 100.0F);
    }
  }
  
  public static void a(boolean paramBoolean1, String paramString1, String paramString2, x paramx, boolean paramBoolean2)
  {
    new w(paramBoolean1, paramString1, paramString2, paramx, paramBoolean2).h();
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (j)
    {
      b.a(null);
      if (!paramBoolean1) {
        b.a(false);
      }
      if ((!paramBoolean1) && (m)) {
        j();
      }
      if (f) {
        m();
      }
      if (paramBoolean2) {
        com.pocket.e.a.a();
      }
      return;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    do
    {
      do
      {
        synchronized (j)
        {
          b.a(null);
          b.a(false);
          if (paramBoolean2)
          {
            a(paramInt, paramBoolean3);
            return;
          }
        }
        if (!paramBoolean1) {
          break;
        }
      } while (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aR));
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aR, true).a();
      y();
      return;
    } while (!m);
    j();
  }
  
  public static boolean a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    synchronized (j)
    {
      if ((!m) && ((x()) || (b(false)))) {
        return false;
      }
      if (d()) {
        return true;
      }
      if (!com.ideashower.readitlater.a.g.k())
      {
        a(-1, null, paramInt, false, false);
        return false;
      }
    }
    b.a(true);
    com.pocket.billing.google.h.a(null);
    return a(true, paramInt, paramBoolean);
  }
  
  public static boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    synchronized (j)
    {
      if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ca) != null)
      {
        d(paramInt);
        b.a(false);
        return false;
      }
      if (b.d() != null)
      {
        f = true;
        if (paramBoolean1) {
          b.d().a(true);
        }
        return true;
      }
      f = false;
      ah localah = new ah(paramBoolean1, paramInt, paramBoolean2);
      b.a(localah);
      localah.q();
      return true;
    }
  }
  
  public static void b() {}
  
  public static void b(int paramInt)
  {
    if (a.getAndSet(paramInt) != paramInt) {
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.ai, paramInt).a();
    }
  }
  
  public static void b(am paramam)
  {
    synchronized (j)
    {
      b.b(paramam);
      return;
    }
  }
  
  public static void b(String paramString, com.ideashower.readitlater.d.f paramf)
  {
    a(paramString, "https://getpocket.com/v3/deleteAlias", paramf);
  }
  
  public static void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    synchronized (j)
    {
      if ((b.c() == null) || (b.c().a_()))
      {
        if (paramBoolean1) {
          b.a(true);
        }
        o localo = new o(paramInt, paramBoolean2);
        b.a(localo);
        localo.q();
      }
      return;
    }
  }
  
  private static void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (j)
    {
      e = paramBoolean1;
      WakefulAppService.a("SyncDelegate fetching state update");
      return;
    }
  }
  
  public static boolean b(boolean paramBoolean)
  {
    boolean bool = true;
    for (;;)
    {
      synchronized (j)
      {
        if (e) {
          return true;
        }
        if (paramBoolean) {
          return false;
        }
        if (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aG))
        {
          paramBoolean = bool;
          return paramBoolean;
        }
      }
      paramBoolean = false;
    }
  }
  
  public static void c()
  {
    if (as.l())
    {
      if (!p) {
        break label22;
      }
      p = false;
      a(2);
    }
    label22:
    while (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.E)) {
      return;
    }
    a(2);
  }
  
  public static void c(int paramInt)
  {
    if (paramInt == 2) {
      b(2);
    }
    while ((paramInt != 1) || (!a.compareAndSet(0, 1))) {
      return;
    }
    com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.ai, 1).a();
  }
  
  public static void c(String paramString, com.ideashower.readitlater.d.f paramf)
  {
    a(paramString, "https://getpocket.com/v3/addAlias", paramf);
  }
  
  private static void c(String paramString1, String paramString2, boolean paramBoolean, final com.ideashower.readitlater.d.f paramf)
  {
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 1)
    {
      paramString1 = new ad(i1, paramString1, paramString2);
      paramString1.a(new com.ideashower.readitlater.g.l()
      {
        public void a() {}
        
        public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousBoolean) && (((f)paramAnonymousk).u())) {}
          for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
          {
            if ((paramAnonymousBoolean) && (!this.a)) {
              WakefulAppService.a(2131493749, 1);
            }
            if (paramf != null) {
              paramf.a(paramAnonymousBoolean);
            }
            return;
          }
        }
      }, true);
      paramString1.h();
      return;
    }
  }
  
  public static boolean c(boolean paramBoolean)
  {
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2;
      synchronized (j)
      {
        bool2 = b(false);
        if ((bool2) && (paramBoolean) && (!e))
        {
          x();
          break label45;
          return paramBoolean;
        }
      }
      label45:
      paramBoolean = bool1;
      if (!bool2) {
        paramBoolean = true;
      }
    }
  }
  
  private static void d(int paramInt)
  {
    if ((com.ideashower.readitlater.a.g.u()) || (paramInt == 1))
    {
      String str = com.ideashower.readitlater.a.g.a(2131493155);
      ErrorReport localErrorReport = new ErrorReport(-1, str);
      StringBuilder localStringBuilder = u.a().append(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ca)).append("\n\n").append(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.cc)).append("\n\n").append(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.cb)).append("\n\n_______\n");
      localErrorReport.c(localStringBuilder.toString());
      u.a(localStringBuilder);
      if ((q == null) || (q.M()))
      {
        q = d.a(8, 2131493167, str, true, localErrorReport);
        q.N();
      }
    }
  }
  
  public static boolean d()
  {
    synchronized (j)
    {
      boolean bool = b.a();
      return bool;
    }
  }
  
  public static boolean d(boolean paramBoolean)
  {
    if (as.d()) {
      return true;
    }
    Object localObject2 = (com.pocket.user.b)as.k();
    CountDownLatch localCountDownLatch;
    synchronized (k)
    {
      if (n == null)
      {
        o = new CountDownLatch(1);
        n = t.a(((com.pocket.user.b)localObject2).a(), ((com.pocket.user.b)localObject2).k(), 2, new g()
        {
          public void a(f arg1, boolean paramAnonymousBoolean)
          {
            ??? = (t)???;
            if (paramAnonymousBoolean) {
              as.a(???.p(), ???.o());
            }
            e.t().countDown();
            synchronized (e.u())
            {
              e.a(null);
              e.a(null);
              return;
            }
          }
        });
        n.h();
      }
      localObject2 = n;
      localCountDownLatch = o;
      if (!paramBoolean) {
        break label117;
      }
    }
    if (as.p()) {
      com.ideashower.readitlater.a.g.g();
    }
    return false;
    label117:
    return false;
  }
  
  public static boolean e()
  {
    synchronized (j)
    {
      boolean bool = b.b();
      return bool;
    }
  }
  
  public static boolean f()
  {
    for (;;)
    {
      synchronized (j)
      {
        if (((d()) || (e) || (b.c() != null) || (b.d() != null) || (g != null) || (h != null) || (i != null)) && (!e()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static String g()
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (j)
      {
        Object localObject2 = new StringBuilder().append(" {SY:").append(d()).append(" ").append("F:").append(e).append(" ").append("SD:");
        if (b.d() != null)
        {
          bool1 = true;
          localObject2 = ((StringBuilder)localObject2).append(bool1).append(" ").append("G:");
          if (b.c() == null) {
            break label205;
          }
          bool1 = true;
          localObject2 = ((StringBuilder)localObject2).append(bool1).append(" ").append("L:");
          if (g == null) {
            break label210;
          }
          bool1 = true;
          localObject2 = ((StringBuilder)localObject2).append(bool1).append(" ").append("GU:");
          if (h == null) {
            break label215;
          }
          bool1 = true;
          localObject2 = ((StringBuilder)localObject2).append(bool1).append(" ").append("CA:");
          if (i == null) {
            break label220;
          }
          bool1 = bool2;
          localObject2 = bool1 + "} ";
          return (String)localObject2;
        }
      }
      boolean bool1 = false;
      continue;
      label205:
      bool1 = false;
      continue;
      label210:
      bool1 = false;
      continue;
      label215:
      bool1 = false;
      continue;
      label220:
      bool1 = false;
    }
  }
  
  public static int h()
  {
    return com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aQ);
  }
  
  public static boolean i()
  {
    int i1;
    int i3;
    int i2;
    int i4;
    synchronized (j)
    {
      b(true, true);
      int i5 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aH);
      i1 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aL) - i5;
      int i6 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aJ);
      long l1 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aN);
      if (i6 == 0) {
        break label221;
      }
      if (i1 < i6)
      {
        if (i1 > 0) {
          break label216;
        }
        i1 = 0;
        break label200;
        if (i3 > i1) {
          break label148;
        }
        if (com.ideashower.readitlater.h.i.a((com.ideashower.readitlater.h.b)com.ideashower.readitlater.h.a.aP.b(i3)))
        {
          i2 += 1;
          break label209;
        }
      }
      else
      {
        i1 = (int)Math.ceil(i1 / i6);
        break label200;
      }
      new h(i4, l1, (i3 - 1) * i6 + i5, i6, i3).a(l);
      if (i4 == 1)
      {
        i4 = 2;
        break label209;
        label148:
        com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aM, i1).a(com.ideashower.readitlater.h.a.aK, i2).a();
        a(i2, i1, true, false);
        if (i2 == i1) {
          y();
        }
        return true;
      }
    }
    for (;;)
    {
      label200:
      i3 = 1;
      i4 = 1;
      i2 = 0;
      break;
      label209:
      i3 += 1;
      break;
      label216:
      i1 = 1;
      continue;
      label221:
      i1 = 0;
    }
  }
  
  protected static void j()
  {
    synchronized (j)
    {
      if (b(true)) {
        l.a(false);
      }
      b(false, false);
      com.ideashower.readitlater.activity.a locala = com.ideashower.readitlater.a.g.n();
      if ((locala == null) || (locala.isFinishing()))
      {
        b.f();
        return;
      }
      a(locala);
    }
  }
  
  public static void k()
  {
    com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.aP);
  }
  
  public static boolean l()
  {
    return a(1, false);
  }
  
  public static boolean m()
  {
    return a(false, 2, false);
  }
  
  public static boolean n()
  {
    return f();
  }
  
  public static int o()
  {
    return a.get();
  }
  
  public static ag p()
  {
    new ag()
    {
      public void a()
      {
        e.a(true);
        e.w().a(20, TimeUnit.SECONDS);
      }
      
      public void b() {}
      
      public void c()
      {
        e.a(new com.ideashower.readitlater.g.f(1, "sync"));
      }
    };
  }
  
  public static boolean q()
  {
    return m;
  }
  
  public static void r()
  {
    com.ideashower.readitlater.g.l local8 = new com.ideashower.readitlater.g.l()
    {
      public void a()
      {
        synchronized ()
        {
          e.a(null);
          return;
        }
      }
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean) {}
    };
    synchronized (j)
    {
      d = new i();
      d.a(local8, false);
      d.h();
      return;
    }
  }
  
  public static void s()
  {
    p = true;
  }
  
  private static boolean x()
  {
    if (!as.l()) {}
    while (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aG)) {
      return false;
    }
    if (!com.ideashower.readitlater.a.g.k())
    {
      d.a(1, new ErrorReport(1, com.ideashower.readitlater.a.g.a(2131493096))).N();
      return false;
    }
    synchronized (j)
    {
      if (b(true)) {
        return false;
      }
    }
    b(true, true);
    l = new com.ideashower.readitlater.g.i(1, "sync-fetch");
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aI))
    {
      boolean bool = i();
      return bool;
    }
    new h(1).a(l);
    a(0, 1, false, false);
    return true;
  }
  
  private static void y()
  {
    synchronized (j)
    {
      if (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aR))
      {
        m = true;
        l();
        return;
      }
      a(1, 1, true, true);
      m = false;
      com.ideashower.readitlater.h.l locall = com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aG, true).a(com.ideashower.readitlater.h.a.aI).a(com.ideashower.readitlater.h.a.aH).a(com.ideashower.readitlater.h.a.aJ).a(com.ideashower.readitlater.h.a.aM).a(com.ideashower.readitlater.h.a.aL).a(com.ideashower.readitlater.h.a.aK).a(com.ideashower.readitlater.h.a.aQ).a(com.ideashower.readitlater.h.a.aN);
      k();
      locall.a();
      b(false, true);
      b.e();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */