package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBOrientation;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.c;
import com.chartboost.sdk.impl.i;
import com.chartboost.sdk.impl.i.b;
import com.chartboost.sdk.impl.j;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.m;
import com.chartboost.sdk.impl.m.a;
import com.chartboost.sdk.impl.t;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

final class a
{
  private static a j;
  private Handler a;
  private Chartboost b;
  private CBPreferences c;
  private i d;
  private m e;
  private ArrayList<com.chartboost.sdk.Model.a> f = new ArrayList();
  private com.chartboost.sdk.Model.a g = null;
  private Map<String, com.chartboost.sdk.Model.a> h;
  private com.chartboost.sdk.Model.a i;
  private a.a k = new a.a()
  {
    public void a(com.chartboost.sdk.Model.a paramAnonymousa)
    {
      for (;;)
      {
        synchronized (a.this)
        {
          boolean bool = paramAnonymousa.f;
          if (paramAnonymousa.c == a.b.a)
          {
            paramAnonymousa.c = a.b.b;
            if (bool)
            {
              if ((paramAnonymousa.d != a.c.a) || (paramAnonymousa.e == null)) {
                break label145;
              }
              a.b(a.this).put(paramAnonymousa.e, paramAnonymousa);
              if (a.f(a.this).getDelegate() != null) {
                a.f(a.this).getDelegate().didCacheInterstitial(paramAnonymousa.e);
              }
              paramAnonymousa.c = a.b.d;
            }
          }
          if (!bool)
          {
            if (paramAnonymousa.d != a.c.a) {
              break label195;
            }
            a.a(a.this, paramAnonymousa);
          }
          a.this.b(paramAnonymousa);
          return;
        }
        label145:
        if (paramAnonymousa.d == a.c.b)
        {
          a.d(a.this, paramAnonymousa);
          if (a.f(a.this).getDelegate() != null)
          {
            a.f(a.this).getDelegate().didCacheMoreApps();
            continue;
            label195:
            if (paramAnonymousa.d == a.c.b) {
              a.c(a.this, paramAnonymousa);
            }
          }
        }
      }
    }
    
    public void a(com.chartboost.sdk.Model.a paramAnonymousa, CBError.CBImpressionError paramAnonymousCBImpressionError)
    {
      a.a(a.this, paramAnonymousa, paramAnonymousCBImpressionError);
    }
    
    public void a(com.chartboost.sdk.Model.a paramAnonymousa, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      int i;
      Object localObject;
      if ((paramAnonymousString != null) && (!paramAnonymousString.equals("")) && (!paramAnonymousString.equals("null")))
      {
        i = 1;
        if (paramAnonymousa.d != a.c.a) {
          break label323;
        }
        if (a.f(a.this).getDelegate() != null) {
          a.f(a.this).getDelegate().didDismissInterstitial(paramAnonymousa.e);
        }
        if (a.f(a.this).getDelegate() != null) {
          a.f(a.this).getDelegate().didClickInterstitial(paramAnonymousa.e);
        }
        if (paramAnonymousa.c == a.b.c)
        {
          localObject = a.a(a.this).a();
          if (localObject != null)
          {
            if (i != 0) {
              break label317;
            }
            label137:
            ((b)localObject).a(paramAnonymousa, bool1);
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          j localj = new j("api/click");
          Activity localActivity = a.a(a.this).c();
          localObject = localActivity;
          if (localActivity == null) {
            localObject = a.a(a.this).e();
          }
          localj.a((Context)localObject);
          localj.a(paramAnonymousa.a, "to");
          localj.a(paramAnonymousa.a, "cgn");
          localj.a(paramAnonymousa.a, "creative");
          localj.a(paramAnonymousa.a, "ad_id");
          localj.a(paramAnonymousJSONObject, "cgn");
          localj.a(paramAnonymousJSONObject, "creative");
          localj.a(paramAnonymousJSONObject, "type");
          localj.a(paramAnonymousJSONObject, "more_type");
          paramAnonymousa.l = localj;
          paramAnonymousa.c = a.b.f;
          a.a(a.this).a(paramAnonymousa);
          a.b(a.this, paramAnonymousa, paramAnonymousString);
          return;
          i = 0;
          break;
          label317:
          bool1 = false;
          break label137;
          label323:
          if (paramAnonymousa.d == a.c.b)
          {
            if (a.f(a.this).getDelegate() != null) {
              a.f(a.this).getDelegate().didDismissMoreApps();
            }
            if (a.f(a.this).getDelegate() != null) {
              a.f(a.this).getDelegate().didClickMoreApps();
            }
            if (paramAnonymousa.c == a.b.c)
            {
              localObject = a.a(a.this).a();
              if (localObject != null)
              {
                if (i == 0) {}
                for (bool1 = bool2;; bool1 = false)
                {
                  ((b)localObject).a(paramAnonymousa, bool1);
                  break;
                }
              }
            }
          }
        }
      }
      a.e(a.this).a(paramAnonymousa, false, paramAnonymousString, CBError.CBClickError.URI_INVALID);
    }
    
    public void b(com.chartboost.sdk.Model.a paramAnonymousa)
    {
      b localb;
      if (paramAnonymousa.d == a.c.a)
      {
        if (a.f(a.this).getDelegate() != null) {
          a.f(a.this).getDelegate().didDismissInterstitial(paramAnonymousa.e);
        }
        if (a.f(a.this).getDelegate() != null) {
          a.f(a.this).getDelegate().didCloseInterstitial(paramAnonymousa.e);
        }
        if (paramAnonymousa.c == a.b.c)
        {
          localb = a.a(a.this).a();
          if (localb != null) {
            localb.a(paramAnonymousa, true);
          }
        }
      }
      do
      {
        do
        {
          do
          {
            return;
          } while (paramAnonymousa.d != a.c.b);
          if (a.f(a.this).getDelegate() != null) {
            a.f(a.this).getDelegate().didDismissMoreApps();
          }
          if (a.f(a.this).getDelegate() != null) {
            a.f(a.this).getDelegate().didCloseMoreApps();
          }
        } while (paramAnonymousa.c != a.b.c);
        localb = a.a(a.this).a();
      } while (localb == null);
      localb.a(paramAnonymousa, true);
    }
  };
  private m.a l = new m.a()
  {
    public void a(final com.chartboost.sdk.Model.a paramAnonymousa, boolean paramAnonymousBoolean, final String paramAnonymousString, CBError.CBClickError paramAnonymousCBClickError)
    {
      paramAnonymousa.c = a.b.e;
      b localb = a.a(a.this).a();
      if ((localb != null) && (localb.a())) {
        localb.a(true);
      }
      if (!paramAnonymousBoolean) {
        if (a.f(a.this).getDelegate() != null) {
          a.f(a.this).getDelegate().didFailToRecordClick(paramAnonymousString, paramAnonymousCBClickError);
        }
      }
      while (paramAnonymousa.l == null) {
        return;
      }
      paramAnonymousa.l.a(true);
      a.g(a.this).a(paramAnonymousa.l, new i.b()
      {
        public void a(j paramAnonymous2j, CBError paramAnonymous2CBError)
        {
          a.e(a.this).a(paramAnonymousa, false, paramAnonymousString, CBError.CBClickError.INTERNAL);
        }
        
        public void a(JSONObject paramAnonymous2JSONObject, j paramAnonymous2j) {}
      });
    }
  };
  
  private a(Chartboost paramChartboost)
  {
    this.b = paramChartboost;
    this.c = CBPreferences.getInstance();
    this.d = this.b.b;
    this.e = m.a(this.l);
    this.h = new HashMap();
    this.i = null;
    this.a = new Handler();
  }
  
  protected static a a(Chartboost paramChartboost)
  {
    if (j == null) {
      j = new a(paramChartboost);
    }
    return j;
  }
  
  private void a(com.chartboost.sdk.Model.a parama, CBError.CBImpressionError paramCBImpressionError)
  {
    b(parama);
    b localb = this.b.a();
    if ((parama.d == a.c.b) && (localb != null) && (localb.a())) {
      localb.a(true);
    }
    if ((parama.d == a.c.a) && (this.c.getDelegate() != null)) {
      this.c.getDelegate().didFailToLoadInterstitial(parama.e, paramCBImpressionError);
    }
    if ((parama.d == a.c.b) && (this.c.getDelegate() != null)) {
      this.c.getDelegate().didFailToLoadMoreApps(paramCBImpressionError);
    }
  }
  
  private void a(final com.chartboost.sdk.Model.a parama, final String paramString)
  {
    paramString = new Runnable()
    {
      public void run()
      {
        a.d(a.this).a(parama, paramString, a.a(a.this).getHostActivity());
      }
    };
    b localb = this.b.a();
    if ((localb != null) && (localb.a))
    {
      parama.a(paramString);
      return;
    }
    paramString.run();
  }
  
  private void a(JSONObject paramJSONObject, com.chartboost.sdk.Model.a parama)
  {
    if (paramJSONObject.optString("status", "").equals("404"))
    {
      a(parama, CBError.CBImpressionError.NO_AD_FOUND);
      return;
    }
    if (!paramJSONObject.optString("status", "").equals("200"))
    {
      a(parama, CBError.CBImpressionError.INTERNAL);
      return;
    }
    if ((parama.d == a.c.b) && (!parama.f))
    {
      int n = 0;
      int m = n;
      if (this.b.a() != null)
      {
        m = n;
        if (this.b.a().a()) {
          m = 1;
        }
      }
      if ((parama.i) && (m == 0))
      {
        b(parama);
        return;
      }
    }
    parama.a(paramJSONObject, this.k);
  }
  
  private void b(final com.chartboost.sdk.Model.a parama, final String paramString)
  {
    Chartboost.CBAgeGateConfirmation local4 = new Chartboost.CBAgeGateConfirmation()
    {
      public void execute(final boolean paramAnonymousBoolean)
      {
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            if (paramAnonymousBoolean)
            {
              a.a(a.this, a.4.this.a, a.4.this.b);
              return;
            }
            a.e(a.this).a(a.4.this.a, false, a.4.this.b, CBError.CBClickError.AGE_GATE_FAILURE);
          }
        };
        a.a(a.this).a(local1);
      }
    };
    if ((this.c.getDelegate() == null) || (!this.c.getDelegate().shouldPauseClickForConfirmation(local4))) {
      a(parama, paramString);
    }
    do
    {
      return;
      parama = this.b.a();
    } while ((parama == null) || (!parama.a()));
    parama.a(true);
  }
  
  private void d(com.chartboost.sdk.Model.a parama)
  {
    if ((parama.c != a.b.c) && (this.c.getDelegate() != null) && (!this.c.getDelegate().shouldDisplayInterstitial(parama.e)))
    {
      b(parama);
      return;
    }
    Object localObject = null;
    JSONObject localJSONObject = parama.a.optJSONObject("assets");
    if (localJSONObject == null) {
      localObject = CBError.CBImpressionError.INTERNAL;
    }
    if (this.c.getOrientation().isPortrait()) {}
    for (String str = "portrait";; str = "landscape")
    {
      if (localJSONObject.optJSONObject(String.format(Locale.US, "ad-%s", new Object[] { str })) != null)
      {
        if (localJSONObject.optJSONObject(String.format(Locale.US, "frame-%s", new Object[] { str })) != null) {}
      }
      else {
        localObject = CBError.CBImpressionError.WRONG_ORIENTATION;
      }
      if (localObject == null) {
        break;
      }
      a(parama, (CBError.CBImpressionError)localObject);
      return;
    }
    if (((parama.c == a.b.d) || (parama.g)) && (this.h.get(parama.e) == parama))
    {
      this.h.remove(parama.e);
      parama.f = false;
      localObject = new j("api/show");
      ((j)localObject).a(this.b.e());
      str = parama.a.optString("ad_id");
      if (str != null) {
        ((j)localObject).a("ad_id", str);
      }
      this.d.a((j)localObject);
    }
    this.b.a(parama);
  }
  
  private void e(com.chartboost.sdk.Model.a parama)
  {
    if ((parama.c != a.b.c) && (this.c.getDelegate() != null) && (!this.c.getDelegate().shouldDisplayMoreApps()))
    {
      b(parama);
      return;
    }
    if (parama == this.i)
    {
      this.i = null;
      parama.f = false;
    }
    int m;
    if (parama.c == a.b.d)
    {
      m = 1;
      b localb = this.b.a();
      if (localb != null)
      {
        if (!localb.a()) {
          break label109;
        }
        localb.a(false);
      }
    }
    label109:
    while ((!parama.i) || (m != 0) || (parama.c == a.b.c))
    {
      this.b.a(parama);
      return;
      m = 0;
      break;
    }
  }
  
  private void f(final com.chartboost.sdk.Model.a parama)
  {
    if (!this.b.d) {
      a(parama, CBError.CBImpressionError.SESSION_NOT_STARTED);
    }
    do
    {
      return;
      localObject = this.b.a();
      if ((!parama.f) && (localObject != null) && (((b)localObject).b()))
      {
        a(parama, CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        return;
      }
    } while ((this.c.getDelegate() != null) && (!this.c.getDelegate().shouldRequestInterstitial(parama.e)));
    if (!l.a())
    {
      a(parama, CBError.CBImpressionError.INTERNET_UNAVAILABLE);
      return;
    }
    try
    {
      localObject = a(parama);
      if (localObject == null) {
        break label153;
      }
      if ((!parama.f) && (((com.chartboost.sdk.Model.a)localObject).f))
      {
        ((com.chartboost.sdk.Model.a)localObject).f = false;
        ((com.chartboost.sdk.Model.a)localObject).g = true;
        return;
      }
    }
    finally {}
    a(parama, CBError.CBImpressionError.TOO_MANY_CONNECTIONS);
    return;
    label153:
    c(parama);
    Object localObject = new j("api/get");
    ((j)localObject).a(this.b.e());
    ((j)localObject).a("location", parama.e);
    if (parama.f) {
      ((j)localObject).a("cache", "1");
    }
    this.d.a((j)localObject, new i.b()
    {
      public void a(j paramAnonymousj, CBError paramAnonymousCBError)
      {
        a.a(a.this, parama, paramAnonymousCBError.b());
        paramAnonymousj = a.a(a.this).a();
        if ((paramAnonymousj != null) && (paramAnonymousj.a())) {
          paramAnonymousj.a(true);
        }
      }
      
      public void a(JSONObject paramAnonymousJSONObject, j paramAnonymousj)
      {
        a.a(a.this, paramAnonymousJSONObject, parama);
      }
    });
  }
  
  protected com.chartboost.sdk.Model.a a()
  {
    Object localObject = this.b.a();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((b)localObject).c()) {
      return null;
    }
    return ((t)localObject).h();
  }
  
  public com.chartboost.sdk.Model.a a(com.chartboost.sdk.Model.a parama)
  {
    label146:
    for (;;)
    {
      try
      {
        if (parama.d == a.c.b)
        {
          parama = this.g;
          return parama;
        }
        if (parama.d == a.c.a)
        {
          if (parama.e == null)
          {
            parama = "";
            break label146;
            if (m >= this.f.size()) {
              continue;
            }
            if (((com.chartboost.sdk.Model.a)this.f.get(m)).e == null)
            {
              str = "";
              if (!parama.equals(str)) {
                continue;
              }
              parama = (com.chartboost.sdk.Model.a)this.f.get(m);
            }
          }
          else
          {
            parama = parama.e;
            break label146;
          }
          String str = ((com.chartboost.sdk.Model.a)this.f.get(m)).e;
          continue;
          m += 1;
          continue;
          parama = null;
        }
        else
        {
          parama = null;
          continue;
        }
        int m = 0;
      }
      finally {}
    }
  }
  
  public void a(Activity paramActivity, com.chartboost.sdk.Model.a parama)
  {
    if (parama != null) {
      switch (9.a[parama.c.ordinal()])
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((parama.c == a.b.a) && (!parama.i));
        this.b.a(parama);
        return;
      } while (parama.a());
      paramActivity = this.b.a();
    } while (paramActivity == null);
    CBLogging.b("CBImpressionManager", "Error onActivityStart " + parama.c.name());
    paramActivity.c(parama);
  }
  
  public void a(String paramString)
  {
    paramString = new com.chartboost.sdk.Model.a(a.c.a, true, paramString, false);
    if ((this.c.getDelegate() != null) && (!this.c.getDelegate().shouldRequestInterstitialsInFirstSession()) && (CBUtility.a().getInt("cbPrefSessionCount", 0) <= 1))
    {
      a(paramString, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED);
      return;
    }
    f(paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    com.chartboost.sdk.Model.a locala1 = new com.chartboost.sdk.Model.a(a.c.b, paramBoolean, null, false);
    if (!this.b.d) {
      a(locala1, CBError.CBImpressionError.SESSION_NOT_STARTED);
    }
    do
    {
      return;
      localObject = this.b.a();
      if ((!paramBoolean) && (localObject != null) && (((b)localObject).b()))
      {
        a(locala1, CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        return;
      }
    } while ((this.c.getDelegate() != null) && (!this.c.getDelegate().shouldRequestMoreApps()));
    if (!l.a())
    {
      a(locala1, CBError.CBImpressionError.INTERNET_UNAVAILABLE);
      return;
    }
    try
    {
      localObject = a(locala1);
      if (localObject == null) {
        break label157;
      }
      if ((!paramBoolean) && (((com.chartboost.sdk.Model.a)localObject).f))
      {
        ((com.chartboost.sdk.Model.a)localObject).f = false;
        ((com.chartboost.sdk.Model.a)localObject).g = true;
        return;
      }
    }
    finally {}
    a(locala2, CBError.CBImpressionError.TOO_MANY_CONNECTIONS);
    return;
    label157:
    c(locala2);
    if ((!paramBoolean) && ((this.c.getDelegate() == null) || (this.c.getDelegate().shouldDisplayLoadingViewForMoreApps())))
    {
      locala2.i = true;
      this.b.a(locala2);
    }
    Object localObject = new j("api/more");
    ((j)localObject).a(this.b.e());
    if (paramBoolean) {
      ((j)localObject).a("cache", "1");
    }
    this.d.a((j)localObject, new i.b()
    {
      public void a(j paramAnonymousj, CBError paramAnonymousCBError)
      {
        a.a(a.this, locala2, paramAnonymousCBError.b());
        paramAnonymousj = a.a(a.this).a();
        if ((paramAnonymousj != null) && (paramAnonymousj.a())) {
          paramAnonymousj.a(true);
        }
      }
      
      public void a(JSONObject paramAnonymousJSONObject, j paramAnonymousj)
      {
        a.a(a.this, paramAnonymousJSONObject, locala2);
      }
    });
  }
  
  protected void b()
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        if (a.c(a.this) != null)
        {
          a.c(a.this, a.c(a.this));
          return;
        }
        a.this.a(false);
      }
    });
  }
  
  /* Error */
  public void b(com.chartboost.sdk.Model.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 125	com/chartboost/sdk/Model/a:d	Lcom/chartboost/sdk/Model/a$c;
    //   6: getstatic 129	com/chartboost/sdk/Model/a$c:b	Lcom/chartboost/sdk/Model/a$c;
    //   9: if_acmpne +11 -> 20
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 63	com/chartboost/sdk/a:g	Lcom/chartboost/sdk/Model/a;
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_1
    //   21: getfield 125	com/chartboost/sdk/Model/a:d	Lcom/chartboost/sdk/Model/a$c;
    //   24: getstatic 139	com/chartboost/sdk/Model/a$c:a	Lcom/chartboost/sdk/Model/a$c;
    //   27: if_acmpne -10 -> 17
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 351	com/chartboost/sdk/a:a	(Lcom/chartboost/sdk/Model/a;)Lcom/chartboost/sdk/Model/a;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull -20 -> 17
    //   40: aload_0
    //   41: getfield 61	com/chartboost/sdk/a:f	Ljava/util/ArrayList;
    //   44: aload_1
    //   45: invokevirtual 457	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: goto -32 -> 17
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	a
    //   0	57	1	parama	com.chartboost.sdk.Model.a
    // Exception table:
    //   from	to	target	type
    //   2	17	52	finally
    //   20	36	52	finally
    //   40	49	52	finally
  }
  
  protected void b(final String paramString)
  {
    final com.chartboost.sdk.Model.a locala = new com.chartboost.sdk.Model.a(a.c.a, false, paramString, false);
    if ((this.c.getDelegate() != null) && (!this.c.getDelegate().shouldRequestInterstitialsInFirstSession()) && (CBUtility.a().getInt("cbPrefSessionCount", 0) == 1))
    {
      a(locala, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED);
      return;
    }
    this.a.post(new Runnable()
    {
      public void run()
      {
        if (a.a(a.this).hasCachedInterstitial(paramString))
        {
          a.a(a.this, (com.chartboost.sdk.Model.a)a.b(a.this).get(paramString));
          return;
        }
        a.b(a.this, locala);
      }
    });
  }
  
  /* Error */
  public void c(com.chartboost.sdk.Model.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 125	com/chartboost/sdk/Model/a:d	Lcom/chartboost/sdk/Model/a$c;
    //   6: getstatic 129	com/chartboost/sdk/Model/a$c:b	Lcom/chartboost/sdk/Model/a$c;
    //   9: if_acmpne +11 -> 20
    //   12: aload_0
    //   13: aload_1
    //   14: putfield 63	com/chartboost/sdk/a:g	Lcom/chartboost/sdk/Model/a;
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_1
    //   21: getfield 125	com/chartboost/sdk/Model/a:d	Lcom/chartboost/sdk/Model/a$c;
    //   24: getstatic 139	com/chartboost/sdk/Model/a$c:a	Lcom/chartboost/sdk/Model/a$c;
    //   27: if_acmpne -10 -> 17
    //   30: aload_0
    //   31: getfield 61	com/chartboost/sdk/a:f	Ljava/util/ArrayList;
    //   34: aload_1
    //   35: invokevirtual 463	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   38: pop
    //   39: goto -22 -> 17
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	a
    //   0	47	1	parama	com.chartboost.sdk.Model.a
    // Exception table:
    //   from	to	target	type
    //   2	17	42	finally
    //   20	39	42	finally
  }
  
  protected boolean c()
  {
    return this.i != null;
  }
  
  protected boolean c(String paramString)
  {
    paramString = (com.chartboost.sdk.Model.a)this.h.get(paramString);
    if (paramString == null) {
      return false;
    }
    if (TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - paramString.b.getTime()) < 86400L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected boolean d()
  {
    if (a() == null) {
      return false;
    }
    this.k.b(a());
    return true;
  }
  
  protected void e()
  {
    this.h.clear();
    this.i = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */