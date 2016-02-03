package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class bw
{
  private static final String a = bw.class.getSimpleName();
  private aq b;
  private ad c;
  private FlurryAdModule d;
  
  public bw(FlurryAdModule paramFlurryAdModule)
  {
    this.d = paramFlurryAdModule;
    this.b = new aq();
    this.c = new ad();
  }
  
  ad a()
  {
    return this.c;
  }
  
  public an a(FlurryAdModule paramFlurryAdModule, Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    return this.b.a(paramFlurryAdModule, paramContext, paramViewGroup, paramString);
  }
  
  public an a(String paramString)
  {
    return this.b.a(paramString);
  }
  
  br a(String paramString, ViewGroup paramViewGroup, boolean paramBoolean, FlurryAdSize paramFlurryAdSize, jf paramjf)
  {
    FlurryAdModule localFlurryAdModule = this.d;
    localFlurryAdModule.getClass();
    paramString = new br(localFlurryAdModule, paramString, paramViewGroup, paramBoolean, paramFlurryAdSize, paramjf);
    paramString.a();
    return paramString;
  }
  
  public List<AdUnit> a(String paramString, int paramInt1, int paramInt2)
  {
    return this.c.a(paramString, paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, String paramString)
  {
    ja.a(3, a, "_removeAd(context = " + paramContext + ", adSpaceName = " + paramString + ")");
    paramContext = this.b.a(paramString);
    if (paramContext == null)
    {
      d(paramString);
      return;
    }
    paramContext.b();
    ViewGroup localViewGroup = paramContext.getViewGroup();
    if (localViewGroup != null)
    {
      paramContext.removeAllViews();
      localViewGroup.removeView(paramContext);
    }
    d(paramString);
    this.b.a(paramContext);
  }
  
  public void a(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize)
  {
    if (!b())
    {
      ja.a(5, a, "There is no network connectivity (ad will not Fetch)");
      paramContext = this.d.K();
      if (paramContext != null) {
        paramContext.spaceDidFailToReceiveAd(paramString.toString());
      }
      return;
    }
    if ((e(paramString)) && (!c()))
    {
      b(paramContext, paramString);
      return;
    }
    a(paramString, paramViewGroup, false, paramFlurryAdSize, new by(this, paramContext, paramString));
  }
  
  void a(String paramString, int paramInt)
  {
    this.c.a(paramString, paramInt);
  }
  
  void a(String paramString, cl paramcl)
  {
    this.b.a(paramString, paramcl);
  }
  
  void a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  void a(List<AdUnit> paramList)
  {
    this.c.a(paramList);
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool = false;
    paramContext = this.b.a(paramContext).iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      an localan = (an)paramContext.next();
      localan.b();
      localan.removeAllViews();
      ViewGroup localViewGroup = localan.getViewGroup();
      if (localViewGroup != null) {
        localViewGroup.removeView(localan);
      }
      this.b.a(localan);
      i += 1;
    }
    if (i > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    if (!b())
    {
      ja.a(5, a, "There is no network connectivity (ad will not Display)");
      paramContext = this.d.K();
      if (paramContext != null) {
        paramContext.spaceDidFailToReceiveAd(paramString.toString());
      }
    }
    cl localcl;
    do
    {
      return false;
      localcl = c(paramString);
    } while (localcl == null);
    AdUnit localAdUnit = localcl.b();
    FlurryAdListener localFlurryAdListener = this.d.K();
    if ((localcl instanceof af)) {}
    for (FlurryAdType localFlurryAdType = FlurryAdType.WEB_BANNER; (localFlurryAdListener != null) && (!localFlurryAdListener.shouldDisplayAd(paramString, localFlurryAdType)); localFlurryAdType = FlurryAdType.WEB_TAKEOVER)
    {
      a(paramString, localcl);
      return false;
    }
    this.d.a(paramContext, localAdUnit, localcl);
    localcl.a(paramContext, paramViewGroup);
    return true;
  }
  
  public boolean a(Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize, ViewGroup paramViewGroup, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!e(paramString)) {
      if ((b()) && (!c()))
      {
        ja.a(3, a, "getAd:no ads in cache, starting AsyncTask");
        bx localbx = null;
        if (0L == paramLong) {
          localbx = new bx(this, paramContext, paramString, paramViewGroup);
        }
        paramFlurryAdSize = a(paramString, paramViewGroup, false, paramFlurryAdSize, localbx);
        bool1 = bool2;
        if (paramLong <= 0L) {}
      }
    }
    do
    {
      do
      {
        do
        {
          try
          {
            paramFlurryAdSize.a(paramLong, TimeUnit.MILLISECONDS);
            bool1 = bool2;
            if (e(paramString))
            {
              ja.a(3, a, "getAd:cache has ads now, rendering");
              bool1 = b(paramContext, paramString, paramViewGroup);
            }
            return bool1;
          }
          catch (InterruptedException paramContext)
          {
            ja.a(3, a, "AsyncTask timeout InterruptedException");
            paramContext.printStackTrace();
            return false;
          }
          catch (ExecutionException paramContext)
          {
            ja.a(3, a, "AsyncTask timeout ExecutionException");
            paramContext.printStackTrace();
            return false;
          }
          catch (TimeoutException paramContext)
          {
            ja.a(3, a, "getAd:AsyncAdTask timeout TimeoutException. No ads retrieved within the timeout");
            return false;
          }
          bool1 = bool2;
        } while (b());
        paramContext = this.d.K();
        bool1 = bool2;
      } while (paramContext == null);
      paramContext.spaceDidFailToReceiveAd(paramString.toString());
      return false;
      bool1 = bool2;
    } while (c());
    return b(paramContext, paramString, paramViewGroup);
  }
  
  public boolean a(String paramString, FlurryAdSize paramFlurryAdSize, long paramLong)
  {
    boolean bool = false;
    if (e(paramString)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      ja.a(3, a, "isAdAvailable: no ads in cache, starting AsyncTask");
      paramFlurryAdSize = a(paramString, null, false, paramFlurryAdSize, null);
      try
      {
        paramFlurryAdSize.a(paramLong, TimeUnit.MILLISECONDS);
        if (e(paramString))
        {
          ja.a(3, a, "getAd:cache has ads now, rendering");
          return true;
        }
      }
      catch (InterruptedException paramString)
      {
        ja.a(3, a, "AsyncTask timeout InterruptedException");
        paramString.printStackTrace();
        return false;
      }
      catch (ExecutionException paramString)
      {
        ja.a(3, a, "AsyncTask timeout ExecutionException");
        paramString.printStackTrace();
        return false;
      }
      catch (TimeoutException paramString)
      {
        ja.a(3, a, "isAdAvailable:AsyncAdTask timeout TimeoutException. No ads retrieved within the timeout");
      }
    }
    return false;
  }
  
  boolean b()
  {
    return jc.a().c();
  }
  
  boolean b(Context paramContext, String paramString)
  {
    AdUnit localAdUnit = g(paramString);
    if (localAdUnit == null)
    {
      this.d.F();
      paramContext = this.d.K();
      if (paramContext != null) {
        paramContext.spaceDidFailToReceiveAd(paramString.toString());
      }
      return false;
    }
    this.d.J();
    a(paramString, this.d.a(paramContext, localAdUnit));
    paramContext = this.d.K();
    if (paramContext != null) {
      paramContext.spaceDidReceiveAd(paramString.toString());
    }
    return true;
  }
  
  boolean b(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    if (!b(paramContext, paramString)) {
      return false;
    }
    a(paramContext, paramString, paramViewGroup);
    return true;
  }
  
  public boolean b(String paramString)
  {
    return this.b.d(paramString);
  }
  
  cl c(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public boolean c()
  {
    return FlurryAdModule.e();
  }
  
  void d(String paramString)
  {
    this.b.c(paramString);
  }
  
  boolean e(String paramString)
  {
    return this.c.d(paramString);
  }
  
  public void f(String paramString)
  {
    this.c.a(paramString, this.c.e(paramString));
  }
  
  AdUnit g(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public void h(String paramString)
  {
    this.c.a(paramString);
    ja.a(3, a, "fetchAdTaskExecute :setting cache request limit count");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */