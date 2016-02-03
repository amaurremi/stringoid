package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.List;
import org.json.JSONException;

public final class bv
  extends cm
  implements bw.a, cx.a
{
  private final bb ed;
  private final Object fx = new Object();
  private au fy;
  private final cw gv;
  private final bu.a hb;
  private final Object hc = new Object();
  private final bz.a hd;
  private final h he;
  private cm hf;
  private cb hg;
  private boolean hh = false;
  private as hi;
  private ay hj;
  private final Context mContext;
  
  public bv(Context paramContext, bz.a parama, h paramh, cw paramcw, bb parambb, bu.a parama1)
  {
    this.ed = parambb;
    this.hb = parama1;
    this.gv = paramcw;
    this.mContext = paramContext;
    this.hd = parama;
    this.he = paramh;
  }
  
  private x a(bz parambz)
    throws bv.a
  {
    if (this.hg.hB == null) {
      throw new a("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = this.hg.hB.split("x");
    if (localObject.length != 2) {
      throw new a("Could not parse the ad size from the ad response: " + this.hg.hB, 0);
    }
    for (;;)
    {
      int i;
      x localx;
      try
      {
        int m = Integer.parseInt(localObject[0]);
        int n = Integer.parseInt(localObject[1]);
        localObject = parambz.em.eH;
        int i1 = localObject.length;
        i = 0;
        if (i >= i1) {
          break;
        }
        localx = localObject[i];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localx.width == -1)
        {
          j = (int)(localx.widthPixels / f);
          if (localx.height != -2) {
            break label253;
          }
          k = (int)(localx.heightPixels / f);
          if ((m != j) || (n != k)) {
            break label263;
          }
          return new x(localx, parambz.em.eH);
        }
      }
      catch (NumberFormatException parambz)
      {
        throw new a("Could not parse the ad size from the ad response: " + this.hg.hB, 0);
      }
      int j = localx.width;
      continue;
      label253:
      int k = localx.height;
      continue;
      label263:
      i += 1;
    }
    throw new a("The ad size from the ad response was not one of the requested sizes: " + this.hg.hB, 0);
  }
  
  private void a(bz parambz, long paramLong)
    throws bv.a
  {
    synchronized (this.hc)
    {
      this.hi = new as(this.mContext, parambz, this.ed, this.fy);
      this.hj = this.hi.a(paramLong, 60000L);
      switch (this.hj.ga)
      {
      default: 
        throw new a("Unexpected mediation result: " + this.hj.ga, 0);
      }
    }
    throw new a("No fill from any mediation ad networks.", 3);
  }
  
  private void aj()
    throws bv.a
  {
    if (this.hg.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.hg.hw)) {
        throw new a("No fill from ad server.", 3);
      }
    } while (!this.hg.hy);
    try
    {
      this.fy = new au(this.hg.hw);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new a("Could not parse mediation config: " + this.hg.hw, 0);
    }
  }
  
  private void b(long paramLong)
    throws bv.a
  {
    cs.iI.post(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          synchronized (bv.a(bv.this))
          {
            if (bv.c(bv.this).errorCode != -2) {
              return;
            }
            bv.d(bv.this).aC().a(bv.this);
            if (bv.c(bv.this).errorCode == -3)
            {
              ct.u("Loading URL in WebView: " + bv.c(bv.this).gL);
              bv.d(bv.this).loadUrl(bv.c(bv.this).gL);
              return;
            }
          }
          ct.u("Loading HTML in WebView.");
          bv.d(bv.this).loadDataWithBaseURL(co.o(bv.c(bv.this).gL), bv.c(bv.this).hw, "text/html", "UTF-8", null);
        }
      }
    });
    d(paramLong);
  }
  
  private void c(long paramLong)
    throws bv.a
  {
    do
    {
      if (!e(paramLong)) {
        throw new a("Timed out waiting for ad response.", 2);
      }
    } while (this.hg == null);
    synchronized (this.hc)
    {
      this.hf = null;
      if ((this.hg.errorCode != -2) && (this.hg.errorCode != -3)) {
        throw new a("There was a problem getting an ad response. ErrorCode: " + this.hg.errorCode, this.hg.errorCode);
      }
    }
  }
  
  private void d(long paramLong)
    throws bv.a
  {
    do
    {
      if (!e(paramLong)) {
        throw new a("Timed out waiting for WebView to finish loading.", 2);
      }
    } while (!this.hh);
  }
  
  private boolean e(long paramLong)
    throws bv.a
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.fx.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new a("Ad request cancelled.", -1);
    }
  }
  
  public void a(cb paramcb)
  {
    synchronized (this.fx)
    {
      ct.r("Received ad response.");
      this.hg = paramcb;
      this.fx.notify();
      return;
    }
  }
  
  public void a(cw arg1)
  {
    synchronized (this.fx)
    {
      ct.r("WebView finished loading.");
      this.hh = true;
      this.fx.notify();
      return;
    }
  }
  
  public void ai()
  {
    for (;;)
    {
      synchronized (this.fx)
      {
        ct.r("AdLoaderBackgroundTask started.");
        String str1 = this.he.g().a(this.mContext);
        localObject5 = new bz(this.hd, str1);
        str1 = null;
        localbc = null;
        int i = -2;
        localObject4 = localbc;
        try
        {
          l = SystemClock.elapsedRealtime();
          localObject4 = localbc;
          localObject8 = bw.a(this.mContext, (bz)localObject5, this);
          localObject4 = localbc;
          localObject6 = this.hc;
          localObject4 = localbc;
          try
          {
            this.hf = ((cm)localObject8);
            if (this.hf != null) {
              continue;
            }
            throw new a("Could not start the ad request service.", 0);
          }
          finally
          {
            localObject4 = localbc;
          }
          if (i != -1) {
            break label502;
          }
        }
        catch (a locala)
        {
          i = locala.getErrorCode();
          if (i == 3) {}
        }
        ct.t(locala.getMessage());
        this.hg = new cb(i);
        cs.iI.post(new Runnable()
        {
          public void run()
          {
            bv.this.onStop();
          }
        });
        final Object localObject2 = localObject4;
        Object localObject8 = ((bz)localObject5).hr;
        cw localcw = this.gv;
        List localList1 = this.hg.fK;
        List localList2 = this.hg.fL;
        List localList3 = this.hg.hA;
        int j = this.hg.orientation;
        long l = this.hg.fO;
        String str2 = ((bz)localObject5).hu;
        boolean bool = this.hg.hy;
        if (this.hj == null) {
          break label513;
        }
        localObject4 = this.hj.gb;
        if (this.hj == null) {
          break label519;
        }
        localbc = this.hj.gc;
        if (this.hj == null) {
          break label525;
        }
        localObject5 = this.hj.gd;
        au localau = this.fy;
        if (this.hj == null) {
          break label531;
        }
        localObject6 = this.hj.ge;
        localObject2 = new cj((v)localObject8, localcw, localList1, i, localList2, localList3, j, l, str2, bool, (at)localObject4, localbc, (String)localObject5, localau, (aw)localObject6, this.hg.hz, (x)localObject2, this.hg.hx);
        cs.iI.post(new Runnable()
        {
          public void run()
          {
            synchronized (bv.a(bv.this))
            {
              bv.b(bv.this).a(localObject2);
              return;
            }
          }
        });
        return;
        localObject4 = localbc;
        c(l);
        localObject4 = localbc;
        aj();
        localObject4 = localbc;
        if (((bz)localObject5).em.eH != null)
        {
          localObject4 = localbc;
          localObject2 = a((bz)localObject5);
        }
        localObject4 = localObject2;
        if (this.hg.hy)
        {
          localObject4 = localObject2;
          a((bz)localObject5, l);
        }
        else
        {
          localObject4 = localObject2;
          b(l);
        }
      }
      label502:
      ct.v(((a)localObject3).getMessage());
      continue;
      label513:
      Object localObject4 = null;
      continue;
      label519:
      bc localbc = null;
      continue;
      label525:
      Object localObject5 = null;
      continue;
      label531:
      Object localObject6 = null;
    }
  }
  
  public void onStop()
  {
    synchronized (this.hc)
    {
      if (this.hf != null) {
        this.hf.cancel();
      }
      this.gv.stopLoading();
      co.a(this.gv);
      if (this.hi != null) {
        this.hi.cancel();
      }
      return;
    }
  }
  
  private static final class a
    extends Exception
  {
    private final int hm;
    
    public a(String paramString, int paramInt)
    {
      super();
      this.hm = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.hm;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */