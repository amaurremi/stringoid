package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;

class d
{
  c a = new c(this);
  b b = new b(this);
  o c = new o(this);
  u d = new u(this);
  v e = new v(this);
  ADCStorage f = new ADCStorage(this);
  ah g = new ah(this);
  t h = new t(this);
  ArrayList<j> i = new ArrayList();
  ArrayList<j> j = new ArrayList();
  volatile boolean k;
  boolean l;
  boolean m;
  ab.a n = new ab.a();
  
  double a(String paramString)
  {
    try
    {
      d1 = this.a.i.f(paramString);
      return d1;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        double d1 = 0.0D;
      }
    }
    finally {}
  }
  
  void a()
  {
    if (this.l) {}
    while (!a.d()) {
      return;
    }
    for (;;)
    {
      int i1;
      try
      {
        if ((!this.l) || ((!this.k) && (this.i.size() > 0)))
        {
          this.l = true;
          this.j.addAll(this.i);
          this.i.clear();
          i1 = 0;
          if (i1 < this.j.size())
          {
            if (this.j.get(i1) == null) {
              break label144;
            }
            ((j)this.j.get(i1)).a();
            break label144;
          }
          this.j.clear();
          continue;
        }
        this.l = false;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.l = false;
        this.j.clear();
        this.i.clear();
        a.a(localRuntimeException);
        return;
      }
      return;
      label144:
      i1 += 1;
    }
  }
  
  void a(final double paramDouble, AdColonyAd paramAdColonyAd)
  {
    new j(this)
    {
      void a()
      {
        this.n.d.a(paramDouble, this.b);
      }
    };
  }
  
  void a(int paramInt)
  {
    a.a(paramInt);
  }
  
  void a(final AdColonyAd paramAdColonyAd)
  {
    try
    {
      this.a.n = 0.0D;
      l.a.b("Tracking ad event - start");
      ag localag = paramAdColonyAd.h.k;
      localag.d += 1;
      if (!paramAdColonyAd.b())
      {
        paramAdColonyAd.h.k();
        this.h.a(paramAdColonyAd.g, paramAdColonyAd.i.d);
      }
      new j(this)
      {
        void a()
        {
          if ((!AdColony.isZoneV4VC(paramAdColonyAd.g)) && (paramAdColonyAd.k.equals("native")))
          {
            d.this.a("native_start", "{\"ad_slot\":" + paramAdColonyAd.h.k.d + ", \"replay\":false}", paramAdColonyAd);
            return;
          }
          d.this.a("start", "{\"ad_slot\":" + paramAdColonyAd.h.k.d + ", \"replay\":" + paramAdColonyAd.r + "}", paramAdColonyAd);
        }
      };
      return;
    }
    finally {}
  }
  
  void a(AdColonyInterstitialAd paramAdColonyInterstitialAd)
  {
    try
    {
      this.a.b(paramAdColonyInterstitialAd.g);
      return;
    }
    finally
    {
      paramAdColonyInterstitialAd = finally;
      throw paramAdColonyInterstitialAd;
    }
  }
  
  void a(AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    try
    {
      this.a.c(paramAdColonyV4VCAd.g);
      return;
    }
    finally
    {
      paramAdColonyV4VCAd = finally;
      throw paramAdColonyV4VCAd;
    }
  }
  
  void a(AdColonyVideoAd paramAdColonyVideoAd)
  {
    try
    {
      this.a.b(paramAdColonyVideoAd.g);
      return;
    }
    finally
    {
      paramAdColonyVideoAd = finally;
      throw paramAdColonyVideoAd;
    }
  }
  
  void a(j paramj)
  {
    synchronized (this.i)
    {
      if (!a.d()) {
        return;
      }
      this.i.add(paramj);
      if (!this.k) {
        g();
      }
      return;
    }
  }
  
  void a(String paramString, int paramInt)
  {
    try
    {
      this.h.b(paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  void a(final String paramString1, final String paramString2)
  {
    new j(this)
    {
      void a()
      {
        this.n.d.a(paramString1, k.b(paramString2));
      }
    };
  }
  
  void a(final String paramString1, final String paramString2, final AdColonyAd paramAdColonyAd)
  {
    new j(this)
    {
      void a()
      {
        this.n.d.a(paramString1, k.b(paramString2), paramAdColonyAd);
      }
    };
  }
  
  void a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      a(a.n);
      l.c.a("==== Configuring AdColony ").a(this.a.b).b(" ====");
      l.a.a("package name: ").b(ab.d());
      this.a.j = paramString2;
      this.a.k = paramArrayOfString;
      this.a.a(paramString1);
      this.n.a();
      return;
    }
    catch (RuntimeException paramString1)
    {
      for (;;)
      {
        a.a(paramString1);
      }
    }
    finally {}
  }
  
  void a(boolean paramBoolean, final AdColonyAd paramAdColonyAd)
  {
    int i2 = 0;
    int i1 = 1;
    int i3 = 1;
    if (paramAdColonyAd == null) {
      return;
    }
    for (;;)
    {
      try
      {
        a(1.0D, paramAdColonyAd);
        if ((paramBoolean) || (!paramAdColonyAd.b())) {
          break;
        }
        paramAdColonyAd.h.k();
        this.h.a(paramAdColonyAd.g, paramAdColonyAd.i.d);
        AdColonyV4VCAd localAdColonyV4VCAd = (AdColonyV4VCAd)a.H;
        final String str = localAdColonyV4VCAd.getRewardName();
        final int i4 = localAdColonyV4VCAd.getRewardAmount();
        int i5 = localAdColonyV4VCAd.getViewsPerReward();
        if (i5 > 1)
        {
          i1 = this.h.c(localAdColonyV4VCAd.getRewardName()) + 1;
          if (i1 >= i5)
          {
            i1 = i3;
            this.h.b(localAdColonyV4VCAd.getRewardName(), i2);
          }
        }
        else
        {
          if (i1 == 0) {
            break;
          }
          if (localAdColonyV4VCAd.h.j.e) {
            a(true, str, i4);
          }
          new j(this)
          {
            void a()
            {
              ADCData.g localg = new ADCData.g();
              localg.b("v4vc_name", str);
              localg.b("v4vc_amount", i4);
              this.n.d.a("reward_v4vc", localg, paramAdColonyAd);
            }
          };
          break;
        }
      }
      finally {}
      i3 = 0;
      i2 = i1;
      i1 = i3;
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    try
    {
      a.L.a(paramBoolean, paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = a.d();
        if (bool1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (RuntimeException paramString)
      {
        a.a(paramString);
        boolean bool1 = bool2;
        continue;
      }
      finally {}
      return bool1;
      bool1 = bool2;
      if (this.b.b(paramString, paramBoolean1)) {
        bool1 = this.b.j.n.a(paramString).b(paramBoolean2);
      }
    }
  }
  
  int b(String paramString)
  {
    try
    {
      i1 = this.a.i.g(paramString);
      return i1;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        int i1 = 0;
      }
    }
    finally {}
  }
  
  void b()
  {
    this.k = true;
    new j(this)
    {
      void a()
      {
        this.n.e.c();
      }
    };
  }
  
  boolean b(AdColonyAd paramAdColonyAd)
  {
    for (;;)
    {
      try
      {
        if (this.a.l.b())
        {
          a.H.f = 3;
          bool = false;
          return bool;
        }
        a(paramAdColonyAd);
        ADCVideo.a();
        if (a.m)
        {
          l.a.b("Launching AdColonyOverlay");
          paramAdColonyAd = new Intent(a.b(), AdColonyOverlay.class);
          a.b().startActivity(paramAdColonyAd);
        }
        else
        {
          l.a.b("Launching AdColonyFullscreen");
          paramAdColonyAd = new Intent(a.b(), AdColonyFullscreen.class);
          a.b().startActivity(paramAdColonyAd);
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  boolean b(AdColonyInterstitialAd paramAdColonyInterstitialAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        a.H = paramAdColonyInterstitialAd;
        str = paramAdColonyInterstitialAd.g;
        bool2 = f(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyInterstitialAd)
      {
        String str;
        boolean bool2;
        a.a(paramAdColonyInterstitialAd);
        continue;
      }
      finally {}
      return bool1;
      l.a.a("Showing ad for zone ").b(str);
      a(paramAdColonyInterstitialAd);
      bool2 = b(paramAdColonyInterstitialAd);
      bool1 = bool2;
    }
  }
  
  boolean b(AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        a.H = paramAdColonyV4VCAd;
        str = paramAdColonyV4VCAd.g;
        bool2 = g(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyV4VCAd)
      {
        String str;
        boolean bool2;
        a.a(paramAdColonyV4VCAd);
        continue;
      }
      finally {}
      return bool1;
      l.a.a("Showing v4vc for zone ").b(str);
      a(paramAdColonyV4VCAd);
      bool2 = b(paramAdColonyV4VCAd);
      bool1 = bool2;
    }
  }
  
  boolean b(AdColonyVideoAd paramAdColonyVideoAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        a.H = paramAdColonyVideoAd;
        str = paramAdColonyVideoAd.g;
        bool2 = f(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyVideoAd)
      {
        String str;
        boolean bool2;
        a.a(paramAdColonyVideoAd);
        continue;
      }
      finally {}
      return bool1;
      l.a.a("Showing ad for zone ").b(str);
      a(paramAdColonyVideoAd);
      bool2 = b(paramAdColonyVideoAd);
      bool1 = bool2;
    }
  }
  
  boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = a.d();
        if (bool1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (RuntimeException paramString)
      {
        a.a(paramString);
        boolean bool1 = bool2;
        continue;
      }
      finally {}
      return bool1;
      bool1 = bool2;
      if (this.b.b(paramString, paramBoolean1)) {
        bool1 = this.b.j.n.a(paramString).c(paramBoolean2);
      }
    }
  }
  
  void c()
  {
    this.k = false;
    new j(this)
    {
      void a()
      {
        this.n.e.d();
      }
    };
  }
  
  boolean c(String paramString)
  {
    try
    {
      bool = this.a.i.h(paramString);
      return bool;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        boolean bool = false;
      }
    }
    finally {}
  }
  
  String d(String paramString)
  {
    try
    {
      paramString = this.a.i.e(paramString);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        paramString = null;
      }
    }
    finally {}
  }
  
  void d()
  {
    new j(this)
    {
      void a()
      {
        this.n.e.e();
      }
    };
  }
  
  int e(String paramString)
  {
    try
    {
      int i1 = this.h.c(paramString);
      return i1;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String e()
  {
    try
    {
      String str = this.b.c();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  String f()
  {
    try
    {
      String str = this.b.d();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean f(String paramString)
  {
    try
    {
      boolean bool = a(paramString, false, true);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 401	com/jirbo/adcolony/a:c	()Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 402	com/jirbo/adcolony/d:a	()V
    //   17: getstatic 405	com/jirbo/adcolony/a:p	Z
    //   20: ifne +38 -> 58
    //   23: invokestatic 409	com/jirbo/adcolony/g:n	()Ljava/lang/String;
    //   26: ifnonnull +17 -> 43
    //   29: aload_0
    //   30: getfield 104	com/jirbo/adcolony/d:n	Lcom/jirbo/adcolony/ab$a;
    //   33: invokevirtual 412	com/jirbo/adcolony/ab$a:b	()D
    //   36: ldc2_w 413
    //   39: dcmpl
    //   40: ifle +14 -> 54
    //   43: aload_0
    //   44: getfield 57	com/jirbo/adcolony/d:a	Lcom/jirbo/adcolony/c;
    //   47: invokevirtual 415	com/jirbo/adcolony/c:a	()V
    //   50: iconst_1
    //   51: putstatic 405	com/jirbo/adcolony/a:p	Z
    //   54: iconst_1
    //   55: putstatic 418	com/jirbo/adcolony/a:r	Z
    //   58: aload_0
    //   59: getfield 62	com/jirbo/adcolony/d:b	Lcom/jirbo/adcolony/b;
    //   62: invokevirtual 420	com/jirbo/adcolony/b:f	()V
    //   65: aload_0
    //   66: getfield 67	com/jirbo/adcolony/d:c	Lcom/jirbo/adcolony/o;
    //   69: invokevirtual 422	com/jirbo/adcolony/o:e	()V
    //   72: aload_0
    //   73: getfield 77	com/jirbo/adcolony/d:e	Lcom/jirbo/adcolony/v;
    //   76: invokevirtual 424	com/jirbo/adcolony/v:b	()V
    //   79: aload_0
    //   80: getfield 72	com/jirbo/adcolony/d:d	Lcom/jirbo/adcolony/u;
    //   83: invokevirtual 426	com/jirbo/adcolony/u:d	()V
    //   86: aload_0
    //   87: getfield 92	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   90: invokevirtual 427	com/jirbo/adcolony/t:d	()V
    //   93: aload_0
    //   94: getfield 87	com/jirbo/adcolony/d:g	Lcom/jirbo/adcolony/ah;
    //   97: invokevirtual 428	com/jirbo/adcolony/ah:d	()V
    //   100: goto -90 -> 10
    //   103: astore_2
    //   104: aload_2
    //   105: invokestatic 120	com/jirbo/adcolony/a:a	(Ljava/lang/RuntimeException;)V
    //   108: goto -98 -> 10
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	d
    //   5	2	1	bool	boolean
    //   103	2	2	localRuntimeException	RuntimeException
    //   111	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	43	103	java/lang/RuntimeException
    //   43	54	103	java/lang/RuntimeException
    //   54	58	103	java/lang/RuntimeException
    //   58	100	103	java/lang/RuntimeException
    //   2	6	111	finally
    //   13	43	111	finally
    //   43	54	111	finally
    //   54	58	111	finally
    //   58	100	111	finally
    //   104	108	111	finally
  }
  
  boolean g(String paramString)
  {
    try
    {
      boolean bool = b(paramString, false, true);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  n.y h(String paramString)
  {
    try
    {
      paramString = this.b.j.n.a(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */