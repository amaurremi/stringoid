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

public class dn
  extends em
  implements dp.a, ey.a
{
  private final bt kB;
  private final ex lN;
  private final Object ls = new Object();
  private final Context mContext;
  private bm nf;
  private final k pA;
  private em pB;
  private du pC;
  private boolean pD = false;
  private bk pE;
  private bq pF;
  private final dm.a px;
  private final Object py = new Object();
  private final ds.a pz;
  
  public dn(Context paramContext, ds.a parama, k paramk, ex paramex, bt parambt, dm.a parama1)
  {
    this.kB = parambt;
    this.px = parama1;
    this.lN = paramex;
    this.mContext = paramContext;
    this.pz = parama;
    this.pA = paramk;
  }
  
  private al a(ds paramds)
  {
    if (this.pC.qj == null) {
      throw new mx("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = this.pC.qj.split("x");
    if (localObject.length != 2) {
      throw new mx("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
    }
    for (;;)
    {
      int i;
      al localal;
      try
      {
        int m = Integer.parseInt(localObject[0]);
        int n = Integer.parseInt(localObject[1]);
        localObject = paramds.kT.mg;
        int i1 = localObject.length;
        i = 0;
        if (i >= i1) {
          break;
        }
        localal = localObject[i];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localal.width == -1)
        {
          j = (int)(localal.widthPixels / f);
          if (localal.height != -2) {
            break label253;
          }
          k = (int)(localal.heightPixels / f);
          if ((m != j) || (n != k)) {
            break label263;
          }
          return new al(localal, paramds.kT.mg);
        }
      }
      catch (NumberFormatException paramds)
      {
        throw new mx("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
      }
      int j = localal.width;
      continue;
      label253:
      int k = localal.height;
      continue;
      label263:
      i += 1;
    }
    throw new mx("The ad size from the ad response was not one of the requested sizes: " + this.pC.qj, 0);
  }
  
  private void a(ds paramds, long paramLong)
  {
    synchronized (this.py)
    {
      this.pE = new bk(this.mContext, paramds, this.kB, this.nf);
      this.pF = this.pE.a(paramLong, 60000L);
      switch (this.pF.nL)
      {
      default: 
        throw new mx("Unexpected mediation result: " + this.pF.nL, 0);
      }
    }
    throw new mx("No fill from any mediation ad networks.", 3);
  }
  
  private void bn()
  {
    if (this.pC.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.pC.qe)) {
        throw new mx("No fill from ad server.", 3);
      }
    } while (!this.pC.qg);
    try
    {
      this.nf = new bm(this.pC.qe);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new mx("Could not parse mediation config: " + this.pC.qe, 0);
    }
  }
  
  private boolean c(long paramLong)
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.ls.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new mx("Ad request cancelled.", -1);
    }
  }
  
  private void e(long paramLong)
  {
    et.sv.post(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          synchronized (dn.a(dn.this))
          {
            if (dn.c(dn.this).errorCode != -2) {
              return;
            }
            dn.d(dn.this).cb().a(dn.this);
            if (dn.c(dn.this).errorCode == -3)
            {
              eu.C("Loading URL in WebView: " + dn.c(dn.this).oA);
              dn.d(dn.this).loadUrl(dn.c(dn.this).oA);
              return;
            }
          }
          eu.C("Loading HTML in WebView.");
          dn.d(dn.this).loadDataWithBaseURL(eo.v(dn.c(dn.this).oA), dn.c(dn.this).qe, "text/html", "UTF-8", null);
        }
      }
    });
    h(paramLong);
  }
  
  private void g(long paramLong)
  {
    do
    {
      if (!c(paramLong)) {
        throw new mx("Timed out waiting for ad response.", 2);
      }
    } while (this.pC == null);
    synchronized (this.py)
    {
      this.pB = null;
      if ((this.pC.errorCode != -2) && (this.pC.errorCode != -3)) {
        throw new mx("There was a problem getting an ad response. ErrorCode: " + this.pC.errorCode, this.pC.errorCode);
      }
    }
  }
  
  private void h(long paramLong)
  {
    do
    {
      if (!c(paramLong)) {
        throw new mx("Timed out waiting for WebView to finish loading.", 2);
      }
    } while (!this.pD);
  }
  
  public void a(du paramdu)
  {
    synchronized (this.ls)
    {
      eu.z("Received ad response.");
      this.pC = paramdu;
      this.ls.notify();
      return;
    }
  }
  
  public void a(ex arg1)
  {
    synchronized (this.ls)
    {
      eu.z("WebView finished loading.");
      this.pD = true;
      this.ls.notify();
      return;
    }
  }
  
  public void bh()
  {
    for (;;)
    {
      int i;
      long l2;
      long l3;
      synchronized (this.ls)
      {
        eu.z("AdLoaderBackgroundTask started.");
        localObject4 = this.pA.z();
        String str1 = ((g)localObject4).b(this.mContext);
        localObject4 = ((g)localObject4).a(this.mContext);
        localObject6 = new ds(this.pz, str1, (String)localObject4);
        str1 = null;
        localbl = null;
        i = -2;
        l2 = -1L;
        l1 = l2;
        localObject4 = localbl;
        try
        {
          l3 = SystemClock.elapsedRealtime();
          l1 = l2;
          localObject4 = localbl;
          localObject8 = dp.a(this.mContext, (ds)localObject6, this);
          l1 = l2;
          localObject4 = localbl;
          localObject7 = this.py;
          l1 = l2;
          localObject4 = localbl;
          try
          {
            this.pB = ((em)localObject8);
            if (this.pB != null) {
              continue;
            }
            throw new mx("Could not start the ad request service.", 0);
          }
          finally
          {
            l1 = l2;
            localObject4 = localbl;
          }
          if (i != -1) {
            break label670;
          }
        }
        catch (mx localmx)
        {
          i = localmx.a();
          if (i == 3) {}
        }
        eu.B(localmx.getMessage());
        if (this.pC != null) {
          break label681;
        }
        this.pC = new du(i);
        et.sv.post(new Runnable()
        {
          public void run()
          {
            dn.this.onStop();
          }
        });
        final Object localObject2 = localObject4;
        boolean bool = TextUtils.isEmpty(this.pC.qo);
        if (bool) {
          break label713;
        }
        try
        {
          localObject4 = new JSONObject(this.pC.qo);
          ai localai = ((ds)localObject6).pX;
          ex localex = this.lN;
          List localList1 = this.pC.nt;
          List localList2 = this.pC.nu;
          List localList3 = this.pC.qi;
          int j = this.pC.orientation;
          l2 = this.pC.nx;
          String str2 = ((ds)localObject6).qa;
          bool = this.pC.qg;
          if (this.pF == null) {
            break label719;
          }
          localbl = this.pF.nM;
          if (this.pF == null) {
            break label725;
          }
          localObject6 = this.pF.nN;
          if (this.pF == null) {
            break label731;
          }
          localObject7 = this.pF.nO;
          bm localbm = this.nf;
          if (this.pF == null) {
            break label737;
          }
          localObject8 = this.pF.nP;
          localObject2 = new ef(localai, localex, localList1, i, localList2, localList3, j, l2, str2, bool, localbl, (bu)localObject6, (String)localObject7, localbm, (bo)localObject8, this.pC.qh, (al)localObject2, this.pC.qf, l1, this.pC.qk, this.pC.ql, (JSONObject)localObject4);
          et.sv.post(new Runnable()
          {
            public void run()
            {
              synchronized (dn.a(dn.this))
              {
                dn.b(dn.this).a(localObject2);
                return;
              }
            }
          });
          return;
        }
        catch (Exception localException)
        {
          eu.b("Error parsing the JSON for Active View.", localException);
        }
        l1 = l2;
        localObject4 = localbl;
        g(l3);
        l1 = l2;
        localObject4 = localbl;
        l2 = SystemClock.elapsedRealtime();
        l1 = l2;
        localObject4 = localbl;
        bn();
        l1 = l2;
        localObject4 = localbl;
        if (((ds)localObject6).kT.mg != null)
        {
          l1 = l2;
          localObject4 = localbl;
          localObject2 = a((ds)localObject6);
        }
        l1 = l2;
        localObject4 = localObject2;
        if (this.pC.qg)
        {
          l1 = l2;
          localObject4 = localObject2;
          a((ds)localObject6, l3);
        }
        else
        {
          l1 = l2;
          localObject4 = localObject2;
          if (this.pC.qm)
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
      break label743;
      label670:
      eu.D(((mx)localObject3).getMessage());
      continue;
      label681:
      this.pC = new du(i, this.pC.nx);
      continue;
      label713:
      Object localObject5 = null;
      continue;
      label719:
      bl localbl = null;
      continue;
      label725:
      Object localObject6 = null;
      continue;
      label731:
      Object localObject7 = null;
      continue;
      label737:
      Object localObject8 = null;
      continue;
      label743:
      l1 = l2;
    }
  }
  
  protected void f(long paramLong)
  {
    final Object localObject = this.lN.V();
    int j;
    if (((al)localObject).mf) {
      j = this.mContext.getResources().getDisplayMetrics().widthPixels;
    }
    for (int i = this.mContext.getResources().getDisplayMetrics().heightPixels;; i = ((al)localObject).heightPixels)
    {
      localObject = new do(this, this.lN, j, i);
      et.sv.post(new Runnable()
      {
        public void run()
        {
          synchronized (dn.a(dn.this))
          {
            if (dn.c(dn.this).errorCode != -2) {
              return;
            }
            dn.d(dn.this).cb().a(dn.this);
            localObject.b(dn.c(dn.this));
            return;
          }
        }
      });
      h(paramLong);
      if (!((do)localObject).bq()) {
        break;
      }
      eu.z("Ad-Network indicated no fill with passback URL.");
      throw new mx("AdNetwork sent passback url", 3);
      j = ((al)localObject).widthPixels;
    }
    if (!((do)localObject).br()) {
      throw new mx("AdNetwork timed out", 2);
    }
  }
  
  public void onStop()
  {
    synchronized (this.py)
    {
      if (this.pB != null) {
        this.pB.cancel();
      }
      this.lN.stopLoading();
      eo.a(this.lN);
      if (this.pE != null) {
        this.pE.cancel();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */