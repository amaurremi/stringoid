package com.google.ads;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.util.a;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import java.util.HashMap;

public class h
{
  final com.google.ads.internal.h a;
  private final f b;
  private boolean c;
  private boolean d;
  private g.a e;
  private final e f;
  private MediationAdapter<?, ?> g;
  private boolean h;
  private boolean i;
  private View j;
  private final String k;
  private final AdRequest l;
  private final HashMap<String, String> m;
  
  public h(e parame, com.google.ads.internal.h paramh, f paramf, String paramString, AdRequest paramAdRequest, HashMap<String, String> paramHashMap)
  {
    a.b(TextUtils.isEmpty(paramString));
    this.f = parame;
    this.a = paramh;
    this.b = paramf;
    this.k = paramString;
    this.l = paramAdRequest;
    this.m = paramHashMap;
    this.c = false;
    this.d = false;
    this.e = null;
    this.g = null;
    this.h = false;
    this.i = false;
    this.j = null;
  }
  
  public f a()
  {
    return this.b;
  }
  
  public void a(Activity paramActivity)
  {
    try
    {
      a.b(this.h, "startLoadAdTask has already been called.");
      this.h = true;
      ((Handler)m.a().c.a()).post(new i(this, paramActivity, this.k, this.l, this.m));
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  void a(View paramView)
  {
    try
    {
      this.j = paramView;
      return;
    }
    finally
    {
      paramView = finally;
      throw paramView;
    }
  }
  
  void a(MediationAdapter<?, ?> paramMediationAdapter)
  {
    try
    {
      this.g = paramMediationAdapter;
      return;
    }
    finally
    {
      paramMediationAdapter = finally;
      throw paramMediationAdapter;
    }
  }
  
  void a(boolean paramBoolean, g.a parama)
  {
    try
    {
      this.d = paramBoolean;
      this.c = true;
      this.e = parama;
      notify();
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void b()
  {
    try
    {
      a.a(this.h, "destroy() called but startLoadAdTask has not been called.");
      ((Handler)m.a().c.a()).post(new Runnable()
      {
        public void run()
        {
          if (h.this.l()) {
            a.b(h.a(h.this));
          }
          try
          {
            h.a(h.this).destroy();
            b.a("Called destroy() for adapter with class: " + h.a(h.this).getClass().getName());
            return;
          }
          catch (Throwable localThrowable)
          {
            b.b("Error while destroying adapter (" + h.this.h() + "):", localThrowable);
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean d()
  {
    try
    {
      a.a(this.c, "isLoadAdTaskSuccessful() called when isLoadAdTaskDone() is false.");
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public g.a e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/google/ads/h:e	Lcom/google/ads/g$a;
    //   6: ifnonnull +11 -> 17
    //   9: getstatic 132	com/google/ads/g$a:d	Lcom/google/ads/g$a;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 67	com/google/ads/h:e	Lcom/google/ads/g$a;
    //   21: astore_1
    //   22: goto -9 -> 13
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	h
    //   12	10	1	locala	g.a
    //   25	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	25	finally
    //   17	22	25	finally
  }
  
  public View f()
  {
    try
    {
      a.a(this.c, "getAdView() called when isLoadAdTaskDone() is false.");
      View localView = this.j;
      return localView;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/google/ads/h:a	Lcom/google/ads/internal/h;
    //   6: invokevirtual 141	com/google/ads/internal/h:a	()Z
    //   9: invokestatic 143	com/google/ads/util/a:a	(Z)V
    //   12: aload_0
    //   13: getfield 69	com/google/ads/h:g	Lcom/google/ads/mediation/MediationAdapter;
    //   16: checkcast 145	com/google/ads/mediation/MediationInterstitialAdapter
    //   19: astore_1
    //   20: invokestatic 91	com/google/ads/m:a	()Lcom/google/ads/m;
    //   23: getfield 94	com/google/ads/m:c	Lcom/google/ads/util/i$b;
    //   26: invokevirtual 99	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   29: checkcast 101	android/os/Handler
    //   32: new 8	com/google/ads/h$2
    //   35: dup
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 148	com/google/ads/h$2:<init>	(Lcom/google/ads/h;Lcom/google/ads/mediation/MediationInterstitialAdapter;)V
    //   41: invokevirtual 110	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   44: pop
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: ldc -106
    //   51: aload_1
    //   52: invokestatic 155	com/google/ads/util/b:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: goto -10 -> 45
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	h
    //   19	19	1	localMediationInterstitialAdapter	MediationInterstitialAdapter
    //   48	4	1	localClassCastException	ClassCastException
    //   58	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	45	48	java/lang/ClassCastException
    //   2	12	58	finally
    //   12	45	58	finally
    //   49	55	58	finally
  }
  
  /* Error */
  public String h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/google/ads/h:g	Lcom/google/ads/mediation/MediationAdapter;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 69	com/google/ads/h:g	Lcom/google/ads/mediation/MediationAdapter;
    //   13: invokevirtual 160	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 165	java/lang/Class:getName	()Ljava/lang/String;
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: ldc -89
    //   26: astore_1
    //   27: goto -7 -> 20
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	h
    //   19	8	1	str	String
    //   30	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	30	finally
  }
  
  MediationAdapter<?, ?> i()
  {
    try
    {
      MediationAdapter localMediationAdapter = this.g;
      return localMediationAdapter;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  e j()
  {
    return this.f;
  }
  
  void k()
  {
    try
    {
      this.i = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean l()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */