package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.List;
import org.json.JSONException;

public final class bz
  extends br
  implements ax.a, ch.a
{
  private final dd CB;
  private final aw.a Dl;
  private final Object Dm = new Object();
  private final cd.a Dn;
  private final gn Do;
  private br Dp;
  private cf Dq;
  private boolean Dr = false;
  private x Ds;
  private af Dt;
  private final Context mContext;
  private final ai xU;
  private final Object xV = new Object();
  private aa xW;
  
  public bz(Context paramContext, cd.a parama, gn paramgn, dd paramdd, ai paramai, aw.a parama1)
  {
    this.xU = paramai;
    this.Dl = parama1;
    this.CB = paramdd;
    this.mContext = paramContext;
    this.Dn = parama;
    this.Do = paramgn;
  }
  
  private ab a(cd paramcd)
  {
    if (this.Dq.DQ == null) {
      throw new a("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = this.Dq.DQ.split("x");
    if (localObject.length != 2) {
      throw new a("Could not parse the ad size from the ad response: " + this.Dq.DQ, 0);
    }
    for (;;)
    {
      int i;
      ab localab;
      try
      {
        int m = Integer.parseInt(localObject[0]);
        int n = Integer.parseInt(localObject[1]);
        localObject = paramcd.DC.xb;
        int i1 = localObject.length;
        i = 0;
        if (i >= i1) {
          break;
        }
        localab = localObject[i];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localab.width == -1)
        {
          j = (int)(localab.widthPixels / f);
          if (localab.height != -2) {
            break label253;
          }
          k = (int)(localab.heightPixels / f);
          if ((m != j) || (n != k)) {
            break label263;
          }
          return new ab(localab, paramcd.DC.xb);
        }
      }
      catch (NumberFormatException paramcd)
      {
        throw new a("Could not parse the ad size from the ad response: " + this.Dq.DQ, 0);
      }
      int j = localab.width;
      continue;
      label253:
      int k = localab.height;
      continue;
      label263:
      i += 1;
    }
    throw new a("The ad size from the ad response was not one of the requested sizes: " + this.Dq.DQ, 0);
  }
  
  private void a(cd paramcd, long paramLong)
  {
    synchronized (this.Dm)
    {
      this.Ds = new x(this.mContext, paramcd, this.xU, this.xW);
      this.Dt = this.Ds.b(paramLong, 60000L);
      switch (this.Dt.Cj)
      {
      default: 
        throw new a("Unexpected mediation result: " + this.Dt.Cj, 0);
      }
    }
    throw new a("No fill from any mediation ad networks.", 3);
  }
  
  private void f(long paramLong)
  {
    cb.Fw.post(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          synchronized (bz.a(bz.this))
          {
            if (bz.c(bz.this).errorCode != -2) {
              return;
            }
            bz.d(bz.this).pX().a(bz.this);
            if (bz.c(bz.this).errorCode == -3)
            {
              ce.C("Loading URL in WebView: " + bz.c(bz.this).CT);
              bz.d(bz.this).loadUrl(bz.c(bz.this).CT);
              return;
            }
          }
          ce.C("Loading HTML in WebView.");
          bz.d(bz.this).loadDataWithBaseURL(bw.aD(bz.c(bz.this).CT), bz.c(bz.this).DL, "text/html", "UTF-8", null);
        }
      }
    });
    h(paramLong);
  }
  
  private void g(long paramLong)
  {
    do
    {
      if (!i(paramLong)) {
        throw new a("Timed out waiting for ad response.", 2);
      }
    } while (this.Dq == null);
    synchronized (this.Dm)
    {
      this.Dp = null;
      if ((this.Dq.errorCode != -2) && (this.Dq.errorCode != -3)) {
        throw new a("There was a problem getting an ad response. ErrorCode: " + this.Dq.errorCode, this.Dq.errorCode);
      }
    }
  }
  
  private void h(long paramLong)
  {
    do
    {
      if (!i(paramLong)) {
        throw new a("Timed out waiting for WebView to finish loading.", 2);
      }
    } while (!this.Dr);
  }
  
  private boolean i(long paramLong)
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.xV.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new a("Ad request cancelled.", -1);
    }
  }
  
  private void pz()
  {
    if (this.Dq.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.Dq.DL)) {
        throw new a("No fill from ad server.", 3);
      }
    } while (!this.Dq.DN);
    try
    {
      this.xW = new aa(this.Dq.DL);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new a("Could not parse mediation config: " + this.Dq.DL, 0);
    }
  }
  
  public void a(cf paramcf)
  {
    synchronized (this.xV)
    {
      ce.aG("Received ad response.");
      this.Dq = paramcf;
      this.xV.notify();
      return;
    }
  }
  
  public void a(dd arg1)
  {
    synchronized (this.xV)
    {
      ce.aG("WebView finished loading.");
      this.Dr = true;
      this.xV.notify();
      return;
    }
  }
  
  public void onStop()
  {
    synchronized (this.Dm)
    {
      if (this.Dp != null) {
        this.Dp.cancel();
      }
      this.CB.stopLoading();
      bw.a(this.CB);
      if (this.Ds != null) {
        this.Ds.cancel();
      }
      return;
    }
  }
  
  public void py()
  {
    for (;;)
    {
      long l2;
      synchronized (this.xV)
      {
        ce.aG("AdLoaderBackgroundTask started.");
        String str1 = this.Do.tA().J(this.mContext);
        localObject5 = new cd(this.Dn, str1);
        str1 = null;
        localaj = null;
        int i = -2;
        l2 = -1L;
        l1 = l2;
        localObject4 = localaj;
        long l3;
        try
        {
          l3 = SystemClock.elapsedRealtime();
          l1 = l2;
          localObject4 = localaj;
          localObject8 = ax.a(this.mContext, (cd)localObject5, this);
          l1 = l2;
          localObject4 = localaj;
          localObject6 = this.Dm;
          l1 = l2;
          localObject4 = localaj;
          try
          {
            this.Dp = ((br)localObject8);
            if (this.Dp != null) {
              continue;
            }
            throw new a("Could not start the ad request service.", 0);
          }
          finally
          {
            l1 = l2;
            localObject4 = localaj;
          }
          if (i != -1) {
            break label569;
          }
        }
        catch (a locala)
        {
          i = locala.getErrorCode();
          if (i == 3) {}
        }
        ce.aa(locala.getMessage());
        this.Dq = new cf(i);
        cb.Fw.post(new Runnable()
        {
          public void run()
          {
            bz.this.onStop();
          }
        });
        final Object localObject2 = localObject4;
        Object localObject8 = ((cd)localObject5).DB;
        dd localdd = this.CB;
        List localList1 = this.Dq.yi;
        List localList2 = this.Dq.yj;
        List localList3 = this.Dq.DP;
        int j = this.Dq.orientation;
        l2 = this.Dq.ym;
        String str2 = ((cd)localObject5).DG;
        boolean bool = this.Dq.DN;
        if (this.Dt == null) {
          break label580;
        }
        localObject4 = this.Dt.Ck;
        if (this.Dt == null) {
          break label586;
        }
        localaj = this.Dt.Cl;
        if (this.Dt == null) {
          break label592;
        }
        localObject5 = this.Dt.Cm;
        aa localaa = this.xW;
        if (this.Dt == null) {
          break label598;
        }
        localObject6 = this.Dt.Cn;
        localObject2 = new bi((z)localObject8, localdd, localList1, i, localList2, localList3, j, l2, str2, bool, (y)localObject4, localaj, (String)localObject5, localaa, (ad)localObject6, this.Dq.DO, (ab)localObject2, this.Dq.DM, l1, this.Dq.DR);
        cb.Fw.post(new Runnable()
        {
          public void run()
          {
            synchronized (bz.a(bz.this))
            {
              bz.b(bz.this).a(localObject2);
              return;
            }
          }
        });
        return;
        l1 = l2;
        localObject4 = localaj;
        g(l3);
        l1 = l2;
        localObject4 = localaj;
        l2 = SystemClock.elapsedRealtime();
        l1 = l2;
        localObject4 = localaj;
        pz();
        l1 = l2;
        localObject4 = localaj;
        if (((cd)localObject5).DC.xb != null)
        {
          l1 = l2;
          localObject4 = localaj;
          localObject2 = a((cd)localObject5);
        }
        l1 = l2;
        localObject4 = localObject2;
        if (this.Dq.DN)
        {
          l1 = l2;
          localObject4 = localObject2;
          a((cd)localObject5, l3);
        }
        else
        {
          l1 = l2;
          localObject4 = localObject2;
          f(l3);
        }
      }
      label569:
      ce.D(((a)localObject3).getMessage());
      continue;
      label580:
      Object localObject4 = null;
      continue;
      label586:
      aj localaj = null;
      continue;
      label592:
      Object localObject5 = null;
      continue;
      label598:
      Object localObject6 = null;
      continue;
      long l1 = l2;
    }
  }
  
  private static final class a
    extends Exception
  {
    private final int nX;
    
    public a(String paramString, int paramInt)
    {
      super();
      this.nX = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.nX;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */