package com.google.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import com.google.ads.util.i.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class e
{
  private final d a;
  private h b = null;
  private final Object c = new Object();
  private Thread d = null;
  private final Object e = new Object();
  private boolean f = false;
  private final Object g = new Object();
  
  protected e()
  {
    this.a = null;
  }
  
  public e(d paramd)
  {
    com.google.ads.util.a.b(paramd);
    this.a = paramd;
  }
  
  public static boolean a(c paramc, d paramd)
  {
    if (paramc.j() == null) {
      return true;
    }
    if (paramd.i().b())
    {
      if (!paramc.j().a())
      {
        b.e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
        return false;
      }
      return true;
    }
    paramd = ((com.google.ads.internal.h)paramd.i().g.a()).c();
    if (paramc.j().a())
    {
      b.e("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (" + paramd + ") in the ad-type field in the mediation UI.");
      return false;
    }
    paramc = paramc.j().c();
    if (paramc != paramd)
    {
      b.e("Mediation server returned ad size: '" + paramc + "', while the AdView was created with ad size: '" + paramd + "'. Using the ad-size passed to the AdView on creation.");
      return false;
    }
    return true;
  }
  
  private boolean a(h paramh, String paramString)
  {
    if (e() != paramh)
    {
      b.c("GWController: ignoring callback to " + paramString + " from non showing ambassador with adapter class: '" + paramh.h() + "'.");
      return false;
    }
    return true;
  }
  
  private boolean a(final String paramString, Activity paramActivity, AdRequest arg3, final f paramf, HashMap<String, String> paramHashMap, long paramLong)
  {
    synchronized (new h(this, (com.google.ads.internal.h)this.a.i().g.a(), paramf, paramString, ???, paramHashMap))
    {
      ???.a(paramActivity);
      try
      {
        while ((!???.c()) && (paramLong > 0L))
        {
          long l1 = SystemClock.elapsedRealtime();
          ???.wait(paramLong);
          long l2 = SystemClock.elapsedRealtime();
          paramLong -= l2 - l1;
        }
        paramString = finally;
      }
      catch (InterruptedException paramActivity)
      {
        b.a("Interrupted while waiting for ad network to load ad using adapter class: " + paramString);
        this.a.n().a(???.e());
        if ((???.c()) && (???.d()))
        {
          if (this.a.i().b()) {}
          for (paramString = null;; paramString = ???.f())
          {
            ((Handler)m.a().c.a()).post(new Runnable()
            {
              public void run()
              {
                if (e.a(e.this, paramAdRequest))
                {
                  b.a("Trying to switch GWAdNetworkAmbassadors, but GWController().destroy() has been called. Destroying the new ambassador and terminating mediation.");
                  return;
                }
                e.b(e.this).a(paramString, paramAdRequest, paramf, false);
              }
            });
            return true;
          }
        }
        if (!???.c()) {
          b.a("Timeout occurred in adapter class: " + ???.h());
        }
        ???.b();
        return false;
      }
    }
  }
  
  private void b(final c paramc, AdRequest paramAdRequest)
  {
    label243:
    do
    {
      long l;
      Object localObject3;
      HashMap localHashMap;
      String str1;
      do
      {
        for (;;)
        {
          synchronized (this.e)
          {
            com.google.ads.util.a.a(Thread.currentThread(), this.d);
            ??? = paramc.f();
            if (paramc.a())
            {
              l = paramc.b();
              Iterator localIterator = ((List)???).iterator();
              if (!localIterator.hasNext()) {
                break label293;
              }
              localObject3 = (a)localIterator.next();
              b.a("Looking to fetch ads from network: " + ((a)localObject3).b());
              Object localObject2 = ((a)localObject3).c();
              localHashMap = ((a)localObject3).e();
              ??? = ((a)localObject3).d();
              str1 = ((a)localObject3).a();
              localObject3 = ((a)localObject3).b();
              String str2 = paramc.c();
              if (??? == null) {
                break label243;
              }
              ??? = new f(str1, (String)localObject3, str2, (List)???, paramc.h(), paramc.i());
              localObject2 = ((List)localObject2).iterator();
              if (!((Iterator)localObject2).hasNext()) {
                continue;
              }
              str1 = (String)((Iterator)localObject2).next();
              localObject3 = (Activity)this.a.i().c.a();
              if (localObject3 != null) {
                break;
              }
              b.a("Activity is null while mediating.  Terminating mediation thread.");
              return;
            }
          }
          l = 10000L;
          continue;
          ??? = paramc.g();
        }
        this.a.n().c();
      } while (a(str1, (Activity)localObject3, paramAdRequest, (f)???, localHashMap, l));
    } while (!d());
    b.a("GWController.destroy() called. Terminating mediation thread.");
    return;
    label293:
    ((Handler)m.a().c.a()).post(new Runnable()
    {
      public void run()
      {
        e.b(e.this).b(paramc);
      }
    });
  }
  
  private boolean d()
  {
    synchronized (this.g)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  private h e()
  {
    synchronized (this.c)
    {
      h localh = this.b;
      return localh;
    }
  }
  
  private boolean e(h paramh)
  {
    synchronized (this.g)
    {
      if (d())
      {
        paramh.b();
        return true;
      }
      return false;
    }
  }
  
  public void a(final c paramc, final AdRequest paramAdRequest)
  {
    for (;;)
    {
      synchronized (this.e)
      {
        if (a())
        {
          b.c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
          return;
        }
        if (paramc.d())
        {
          this.a.a(paramc.e());
          if (!this.a.t()) {
            this.a.g();
          }
          a(paramc, this.a);
          this.d = new Thread(new Runnable()
          {
            public void run()
            {
              e.a(e.this, paramc, paramAdRequest);
              synchronized (e.a(e.this))
              {
                e.a(e.this, null);
                return;
              }
            }
          });
          this.d.start();
          return;
        }
      }
      if (this.a.t()) {
        this.a.f();
      }
    }
  }
  
  public void a(h paramh)
  {
    if (!a(paramh, "onPresentScreen")) {
      return;
    }
    ((Handler)m.a().c.a()).post(new Runnable()
    {
      public void run()
      {
        e.b(e.this).v();
      }
    });
  }
  
  public void a(final h paramh, final View paramView)
  {
    if (e() != paramh)
    {
      b.c("GWController: ignoring onAdRefreshed() callback from non-showing ambassador (adapter class name is '" + paramh.h() + "').");
      return;
    }
    this.a.n().a(g.a.a);
    paramh = this.b.a();
    ((Handler)m.a().c.a()).post(new Runnable()
    {
      public void run()
      {
        e.b(e.this).a(paramView, e.c(e.this), paramh, true);
      }
    });
  }
  
  public void a(final h paramh, final boolean paramBoolean)
  {
    if (!a(paramh, "onAdClicked()")) {
      return;
    }
    paramh = paramh.a();
    ((Handler)m.a().c.a()).post(new Runnable()
    {
      public void run()
      {
        e.b(e.this).a(paramh, paramBoolean);
      }
    });
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (this.e)
      {
        if (this.d != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b()
  {
    synchronized (this.g)
    {
      this.f = true;
      d(null);
      synchronized (this.e)
      {
        if (this.d != null) {
          this.d.interrupt();
        }
        return;
      }
    }
  }
  
  public void b(h paramh)
  {
    if (!a(paramh, "onDismissScreen")) {
      return;
    }
    ((Handler)m.a().c.a()).post(new Runnable()
    {
      public void run()
      {
        e.b(e.this).u();
      }
    });
  }
  
  public void c(h paramh)
  {
    if (!a(paramh, "onLeaveApplication")) {
      return;
    }
    ((Handler)m.a().c.a()).post(new Runnable()
    {
      public void run()
      {
        e.b(e.this).w();
      }
    });
  }
  
  public boolean c()
  {
    com.google.ads.util.a.a(this.a.i().b());
    h localh = e();
    if (localh != null)
    {
      localh.g();
      return true;
    }
    b.b("There is no ad ready to show.");
    return false;
  }
  
  public void d(h paramh)
  {
    synchronized (this.c)
    {
      if (this.b != paramh)
      {
        if (this.b != null) {
          this.b.b();
        }
        this.b = paramh;
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */