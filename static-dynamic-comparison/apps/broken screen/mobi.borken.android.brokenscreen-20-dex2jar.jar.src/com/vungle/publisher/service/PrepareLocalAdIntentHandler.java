package com.vungle.publisher.service;

import android.content.Context;
import android.content.Intent;
import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.ag;
import com.vungle.publisher.ak;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.as;
import com.vungle.publisher.at.a;
import com.vungle.publisher.at.b;
import com.vungle.publisher.bj;
import com.vungle.publisher.ca;
import com.vungle.publisher.db.model.Ad.a;
import com.vungle.publisher.db.model.LocalAd;
import com.vungle.publisher.db.model.LocalAdReport;
import com.vungle.publisher.db.model.LocalAdReport.Factory;
import com.vungle.publisher.di;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.DownloadHttpGateway;
import com.vungle.publisher.reporting.ReportManager;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class PrepareLocalAdIntentHandler
  extends ca
{
  public AdManager f;
  public Context g;
  public DownloadHttpGateway h;
  public di i;
  public ReportManager j;
  
  public PrepareLocalAdIntentHandler(String paramString)
  {
    super(paramString, 1, 10);
  }
  
  protected final Runnable a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("adId");
    at.b localb = (at.b)paramIntent.getParcelableExtra("viewableType");
    if (paramIntent.hasExtra("viewableSize")) {}
    for (paramIntent = Integer.valueOf(paramIntent.getIntExtra("viewableSize", -1)); str == null; paramIntent = null) {
      throw new IllegalArgumentException("no adId in intent");
    }
    Logger.d("VungleService", this.a + " creating runnable: adId " + str + ", viewableType " + localb + ", viewableSize " + paramIntent);
    return new c(str, localb, paramIntent);
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    public AdManager a;
    @Inject
    public Context b;
    @Inject
    public DownloadHttpGateway c;
    @Inject
    public di d;
    @Inject
    public ReportManager e;
  }
  
  static final class a
    extends RuntimeException
  {
    a(String paramString)
    {
      super();
    }
    
    a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static final class b
    extends RuntimeException
  {
    b(String paramString)
    {
      super();
    }
  }
  
  final class c
    implements Runnable
  {
    private final String b;
    private final at.b c;
    private final Integer d;
    
    c(String paramString, at.b paramb, Integer paramInteger)
    {
      this.b = paramString;
      this.c = paramb;
      this.d = paramInteger;
    }
    
    private LocalAd a(String paramString, at.b paramb, Integer paramInteger)
    {
      LocalAd localLocalAd = (LocalAd)PrepareLocalAdIntentHandler.this.f.e.a(paramString, false);
      if (localLocalAd == null) {
        throw new IllegalArgumentException("no ad " + paramString);
      }
      Object localObject = localLocalAd.h();
      switch (PrepareLocalAdIntentHandler.1.a[localObject.ordinal()])
      {
      default: 
        if (paramb == null) {
          break;
        }
      }
      label800:
      for (;;)
      {
        try
        {
          localObject = localLocalAd.b(paramb);
          Ad.a locala;
          long l1;
          long l2;
          int i;
          switch (PrepareLocalAdIntentHandler.1.b[paramb.ordinal()])
          {
          case 1: 
            Logger.i("VunglePrepare", paramb + " downloaded for ad " + this.b);
            ((as)localObject).a(at.a.c);
            paramInteger = localLocalAd.d();
            localObject = localLocalAd.h();
            if (localObject == Ad.a.b)
            {
              locala = Ad.a.d;
              l1 = System.currentTimeMillis() / 1000L;
              l2 = localLocalAd.i();
              if (l1 < l2)
              {
                Logger.d("VunglePrepare", "clock change detected; updating ad.id " + paramInteger + " status from " + localObject + " to " + locala);
                localLocalAd.a(locala);
              }
            }
            else
            {
              paramInteger = Ad.a.b;
              i = localLocalAd.s;
              if (i >= 3) {
                break label800;
              }
              try
              {
                paramInteger = PrepareLocalAdIntentHandler.1.a;
                localObject = localLocalAd.h();
                switch (paramInteger[localObject.ordinal()])
                {
                case 1: 
                  throw new IllegalStateException("unexpected ad.status: " + localObject);
                }
              }
              catch (PrepareLocalAdIntentHandler.b paramInteger)
              {
                Logger.w("VunglePrepare", paramInteger.getMessage() + " for ad.id: " + paramString);
                localLocalAd.s += 1;
              }
            }
            break;
          case 2: 
            try
            {
              localLocalAd.l();
              throw paramString;
              throw new PrepareLocalAdIntentHandler.a("ad status: " + Ad.a.c);
              Logger.d("VunglePrepare", "ad already " + Ad.a.e + ": " + paramString);
              return localLocalAd;
              ((as)localObject).a(paramInteger);
              continue;
              l1 = (l1 - l2) / 60L;
              if (l1 >= 1440L)
              {
                Logger.d("VunglePrepare", "retrying " + Ad.a.b + " ad.id " + paramInteger + " after " + l1 + "/1440 minutes; updating status from " + localObject + " to " + locala);
                localLocalAd.a(locala);
                continue;
              }
              throw new PrepareLocalAdIntentHandler.a("ad marked failed " + l1 + " minutes ago");
              PrepareLocalAdIntentHandler.this.j.a(localLocalAd);
              localLocalAd.a(Ad.a.d);
              localObject = new StringBuilder();
              if (paramb == null) {}
              for (paramInteger = "download ";; paramInteger = "prepare " + paramb + " ")
              {
                Logger.d("VunglePrepare", paramInteger + "prepare_retry_count " + i + " for ad " + paramString);
                a(localLocalAd);
                try
                {
                  localLocalAd.l();
                  return localLocalAd;
                }
                catch (Exception paramString)
                {
                  Logger.e("VunglePrepare", "error saving ad " + localLocalAd.d() + " to database");
                  return localLocalAd;
                }
              }
              b(localLocalAd);
              try
              {
                localLocalAd.l();
                return localLocalAd;
              }
              catch (Exception paramString)
              {
                Logger.e("VunglePrepare", "error saving ad " + localLocalAd.d() + " to database");
                return localLocalAd;
              }
              localLocalAd.a(Ad.a.b);
              throw new PrepareLocalAdIntentHandler.a("failed to prepare ad after " + i + " attempts");
            }
            catch (Exception paramb)
            {
              for (;;)
              {
                Logger.e("VunglePrepare", "error saving ad " + localLocalAd.d() + " to database");
              }
            }
          }
        }
        finally {}
      }
    }
    
    private void a(LocalAd paramLocalAd)
    {
      int j = 1;
      c(paramLocalAd);
      as[] arrayOfas = paramLocalAd.x();
      int k = arrayOfas.length;
      int i = 0;
      while (i < k)
      {
        if (!a(arrayOfas[i])) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0)
      {
        Logger.i("VunglePrepare", "ad ready " + paramLocalAd.d());
        paramLocalAd.a(Ad.a.e);
        ((LocalAdReport)PrepareLocalAdIntentHandler.this.j.a.b(paramLocalAd)).c(Long.valueOf(System.currentTimeMillis()));
        return;
      }
      Logger.d("VunglePrepare", "ad not ready " + paramLocalAd.d());
    }
    
    private boolean a(as paramas)
    {
      at.b localb = paramas.i();
      at.a locala = paramas.h();
      switch (PrepareLocalAdIntentHandler.1.c[locala.ordinal()])
      {
      default: 
        throw new IllegalStateException("unexpected " + localb + " status: " + locala);
      case 1: 
        try
        {
          paramas.y();
          return false;
        }
        catch (bj paramas)
        {
          throw new PrepareLocalAdIntentHandler.a("external storage not available, could not download ad", paramas);
        }
      case 2: 
        Logger.d("VunglePrepare", localb + " still downloading for ad_id " + this.b);
        return false;
      case 3: 
        try
        {
          if (!paramas.z()) {
            throw new PrepareLocalAdIntentHandler.b(paramas.i() + " post processing failed for ad_id " + paramas.f());
          }
        }
        catch (bj paramas)
        {
          throw new PrepareLocalAdIntentHandler.a("external storage not available, could not post process ad", paramas);
        }
        return true;
      }
      Logger.v("VunglePrepare", localb + " already " + locala + " for ad_id " + this.b);
      return true;
    }
    
    private void b(LocalAd paramLocalAd)
    {
      String str = paramLocalAd.d();
      Logger.d("VunglePrepare", "re-verify prepare_retry_count " + paramLocalAd.s + " for ad " + str);
      c(paramLocalAd);
      Object localObject1 = paramLocalAd.x();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!((as)localObject2).B()) {
          throw new PrepareLocalAdIntentHandler.b(((as)localObject2).i() + " re-verification failed for ad_id " + ((as)localObject2).f());
        }
        i += 1;
      }
      localObject1 = Ad.a.e;
      Logger.i("VunglePrepare", "re-verified ad and set to " + localObject1 + ": " + str);
      PrepareLocalAdIntentHandler.this.j.a(paramLocalAd).c(Long.valueOf(-1L));
      paramLocalAd.a((Ad.a)localObject1);
    }
    
    private static void c(LocalAd paramLocalAd)
      throws PrepareLocalAdIntentHandler.a
    {
      if (!paramLocalAd.y()) {
        throw new PrepareLocalAdIntentHandler.a("invalid ad - no viewables");
      }
    }
    
    public final void run()
    {
      try
      {
        if (a(this.b, this.c, this.d).h() == Ad.a.e) {
          PrepareLocalAdIntentHandler.this.i.c(new ak());
        }
        return;
      }
      catch (PrepareLocalAdIntentHandler.a locala)
      {
        Logger.w("VunglePrepare", locala.getMessage() + " for ad.id " + this.b);
        PrepareLocalAdIntentHandler.this.i.b(new ag());
        return;
      }
      catch (Exception localException)
      {
        Logger.e("VunglePrepare", "error processing ad.id: " + this.b, localException);
        PrepareLocalAdIntentHandler.this.i.b(new ag());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/PrepareLocalAdIntentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */