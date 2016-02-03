package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class do
  extends en
  implements dq.a, ez.a
{
  private final bu kz;
  private final ey lL;
  private final Object lq = new Object();
  private final Context mContext;
  private bn nd;
  private dv pA;
  private boolean pB = false;
  private bl pC;
  private br pD;
  private final dn.a pv;
  private final Object pw = new Object();
  private final dt.a px;
  private final l py;
  private en pz;
  
  public do(Context paramContext, dt.a parama, l paraml, ey paramey, bu parambu, dn.a parama1)
  {
    this.kz = parambu;
    this.pv = parama1;
    this.lL = paramey;
    this.mContext = paramContext;
    this.px = parama;
    this.py = paraml;
  }
  
  private am a(dt paramdt)
    throws do.a
  {
    if (this.pA.qg == null) {
      throw new a("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = this.pA.qg.split("x");
    if (localObject.length != 2) {
      throw new a("Could not parse the ad size from the ad response: " + this.pA.qg, 0);
    }
    for (;;)
    {
      int i;
      am localam;
      try
      {
        int m = Integer.parseInt(localObject[0]);
        int n = Integer.parseInt(localObject[1]);
        localObject = paramdt.kR.me;
        int i1 = localObject.length;
        i = 0;
        if (i >= i1) {
          break;
        }
        localam = localObject[i];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localam.width == -1)
        {
          j = (int)(localam.widthPixels / f);
          if (localam.height != -2) {
            break label253;
          }
          k = (int)(localam.heightPixels / f);
          if ((m != j) || (n != k)) {
            break label263;
          }
          return new am(localam, paramdt.kR.me);
        }
      }
      catch (NumberFormatException paramdt)
      {
        throw new a("Could not parse the ad size from the ad response: " + this.pA.qg, 0);
      }
      int j = localam.width;
      continue;
      label253:
      int k = localam.height;
      continue;
      label263:
      i += 1;
    }
    throw new a("The ad size from the ad response was not one of the requested sizes: " + this.pA.qg, 0);
  }
  
  private void a(dt paramdt, long paramLong)
    throws do.a
  {
    synchronized (this.pw)
    {
      this.pC = new bl(this.mContext, paramdt, this.kz, this.nd);
      this.pD = this.pC.a(paramLong, 60000L);
      switch (this.pD.nJ)
      {
      default: 
        throw new a("Unexpected mediation result: " + this.pD.nJ, 0);
      }
    }
    throw new a("No fill from any mediation ad networks.", 3);
  }
  
  private void bi()
    throws do.a
  {
    if (this.pA.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.pA.qb)) {
        throw new a("No fill from ad server.", 3);
      }
    } while (!this.pA.qd);
    try
    {
      this.nd = new bn(this.pA.qb);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new a("Could not parse mediation config: " + this.pA.qb, 0);
    }
  }
  
  private boolean c(long paramLong)
    throws do.a
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.lq.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new a("Ad request cancelled.", -1);
    }
  }
  
  private void e(long paramLong)
    throws do.a
  {
    eu.ss.post(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          synchronized (do.a(do.this))
          {
            if (do.c(do.this).errorCode != -2) {
              return;
            }
            do.d(do.this).bW().a(do.this);
            if (do.c(do.this).errorCode == -3)
            {
              ev.C("Loading URL in WebView: " + do.c(do.this).oy);
              do.d(do.this).loadUrl(do.c(do.this).oy);
              return;
            }
          }
          ev.C("Loading HTML in WebView.");
          do.d(do.this).loadDataWithBaseURL(ep.v(do.c(do.this).oy), do.c(do.this).qb, "text/html", "UTF-8", null);
        }
      }
    });
    h(paramLong);
  }
  
  private void g(long paramLong)
    throws do.a
  {
    do
    {
      if (!c(paramLong)) {
        throw new a("Timed out waiting for ad response.", 2);
      }
    } while (this.pA == null);
    synchronized (this.pw)
    {
      this.pz = null;
      if ((this.pA.errorCode != -2) && (this.pA.errorCode != -3)) {
        throw new a("There was a problem getting an ad response. ErrorCode: " + this.pA.errorCode, this.pA.errorCode);
      }
    }
  }
  
  private void h(long paramLong)
    throws do.a
  {
    do
    {
      if (!c(paramLong)) {
        throw new a("Timed out waiting for WebView to finish loading.", 2);
      }
    } while (!this.pB);
  }
  
  public void a(dv paramdv)
  {
    synchronized (this.lq)
    {
      ev.z("Received ad response.");
      this.pA = paramdv;
      this.lq.notify();
      return;
    }
  }
  
  public void a(ey arg1)
  {
    synchronized (this.lq)
    {
      ev.z("WebView finished loading.");
      this.pB = true;
      this.lq.notify();
      return;
    }
  }
  
  public void bc()
  {
    for (;;)
    {
      int i;
      long l2;
      long l3;
      synchronized (this.lq)
      {
        ev.z("AdLoaderBackgroundTask started.");
        String str1 = this.py.y().a(this.mContext);
        localObject6 = new dt(this.px, str1);
        str1 = null;
        localbm = null;
        i = -2;
        l2 = -1L;
        l1 = l2;
        localObject4 = localbm;
        try
        {
          l3 = SystemClock.elapsedRealtime();
          l1 = l2;
          localObject4 = localbm;
          localObject8 = dq.a(this.mContext, (dt)localObject6, this);
          l1 = l2;
          localObject4 = localbm;
          localObject7 = this.pw;
          l1 = l2;
          localObject4 = localbm;
          try
          {
            this.pz = ((en)localObject8);
            if (this.pz != null) {
              continue;
            }
            throw new a("Could not start the ad request service.", 0);
          }
          finally
          {
            l1 = l2;
            localObject4 = localbm;
          }
          if (i != -1) {
            break label651;
          }
        }
        catch (a locala)
        {
          i = locala.getErrorCode();
          if (i == 3) {}
        }
        ev.B(locala.getMessage());
        if (this.pA != null) {
          break label662;
        }
        this.pA = new dv(i);
        eu.ss.post(new Runnable()
        {
          public void run()
          {
            do.this.onStop();
          }
        });
        final Object localObject2 = localObject4;
        boolean bool = TextUtils.isEmpty(this.pA.ql);
        if (bool) {
          break label694;
        }
        try
        {
          localObject4 = new JSONObject(this.pA.ql);
          aj localaj = ((dt)localObject6).pV;
          ey localey = this.lL;
          List localList1 = this.pA.nr;
          List localList2 = this.pA.ns;
          List localList3 = this.pA.qf;
          int j = this.pA.orientation;
          l2 = this.pA.nv;
          String str2 = ((dt)localObject6).pY;
          bool = this.pA.qd;
          if (this.pD == null) {
            break label700;
          }
          localbm = this.pD.nK;
          if (this.pD == null) {
            break label706;
          }
          localObject6 = this.pD.nL;
          if (this.pD == null) {
            break label712;
          }
          localObject7 = this.pD.nM;
          bn localbn = this.nd;
          if (this.pD == null) {
            break label718;
          }
          localObject8 = this.pD.nN;
          localObject2 = new eg(localaj, localey, localList1, i, localList2, localList3, j, l2, str2, bool, localbm, (bv)localObject6, (String)localObject7, localbn, (bp)localObject8, this.pA.qe, (am)localObject2, this.pA.qc, l1, this.pA.qh, this.pA.qi, (JSONObject)localObject4);
          eu.ss.post(new Runnable()
          {
            public void run()
            {
              synchronized (do.a(do.this))
              {
                do.b(do.this).a(localObject2);
                return;
              }
            }
          });
          return;
        }
        catch (Exception localException)
        {
          ev.b("Error parsing the JSON for Active View.", localException);
        }
        l1 = l2;
        localObject4 = localbm;
        g(l3);
        l1 = l2;
        localObject4 = localbm;
        l2 = SystemClock.elapsedRealtime();
        l1 = l2;
        localObject4 = localbm;
        bi();
        l1 = l2;
        localObject4 = localbm;
        if (((dt)localObject6).kR.me != null)
        {
          l1 = l2;
          localObject4 = localbm;
          localObject2 = a((dt)localObject6);
        }
        l1 = l2;
        localObject4 = localObject2;
        if (this.pA.qd)
        {
          l1 = l2;
          localObject4 = localObject2;
          a((dt)localObject6, l3);
        }
        else
        {
          l1 = l2;
          localObject4 = localObject2;
          if (this.pA.qj)
          {
            l1 = l2;
            localObject4 = localObject2;
            f(l3);
          }
        }
      }
      long l1 = l2;
      Object localObject4 = localObject3;
      e(l3);
      break label724;
      label651:
      ev.D(((a)localObject3).getMessage());
      continue;
      label662:
      this.pA = new dv(i, this.pA.nv);
      continue;
      label694:
      Object localObject5 = null;
      continue;
      label700:
      bm localbm = null;
      continue;
      label706:
      Object localObject6 = null;
      continue;
      label712:
      Object localObject7 = null;
      continue;
      label718:
      Object localObject8 = null;
      continue;
      label724:
      l1 = l2;
    }
  }
  
  protected void f(long paramLong)
    throws do.a
  {
    final Object localObject = this.lL.Q();
    int j;
    if (((am)localObject).md) {
      j = this.mContext.getResources().getDisplayMetrics().widthPixels;
    }
    for (int i = this.mContext.getResources().getDisplayMetrics().heightPixels;; i = ((am)localObject).heightPixels)
    {
      localObject = new dp(this, this.lL, j, i);
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          synchronized (do.a(do.this))
          {
            if (do.c(do.this).errorCode != -2) {
              return;
            }
            do.d(do.this).bW().a(do.this);
            localObject.b(do.c(do.this));
            return;
          }
        }
      });
      h(paramLong);
      if (!((dp)localObject).bl()) {
        break;
      }
      ev.z("Ad-Network indicated no fill with passback URL.");
      throw new a("AdNetwork sent passback url", 3);
      j = ((am)localObject).widthPixels;
    }
    if (!((dp)localObject).bm()) {
      throw new a("AdNetwork timed out", 2);
    }
  }
  
  public void onStop()
  {
    synchronized (this.pw)
    {
      if (this.pz != null) {
        this.pz.cancel();
      }
      this.lL.stopLoading();
      ep.a(this.lL);
      if (this.pC != null) {
        this.pC.cancel();
      }
      return;
    }
  }
  
  private static final class a
    extends Exception
  {
    private final int pH;
    
    public a(String paramString, int paramInt)
    {
      super();
      this.pH = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.pH;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */