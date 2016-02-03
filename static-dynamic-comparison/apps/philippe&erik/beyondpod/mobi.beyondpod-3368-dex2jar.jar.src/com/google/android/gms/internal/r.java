package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;

public final class r
  extends ac.a
  implements al, av, bn, bq, bu.a, q
{
  private final bb ed;
  private final a ee;
  private final s ef;
  
  public r(Context paramContext, x paramx, String paramString, bb parambb, cu paramcu)
  {
    this.ee = new a(paramContext, paramx, paramString, paramcu);
    this.ed = parambb;
    this.ef = new s(this);
    ct.t("Use AdRequest.Builder.addTestDevice(\"" + cs.l(paramContext) + "\") to get test ads on this device.");
    co.i(paramContext);
  }
  
  private void I()
  {
    ct.t("Ad closing.");
    if (this.ee.ek != null) {}
    try
    {
      this.ee.ek.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }
  
  private void J()
  {
    ct.t("Ad leaving application.");
    if (this.ee.ek != null) {}
    try
    {
      this.ee.ek.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  private void K()
  {
    ct.t("Ad opening.");
    if (this.ee.ek != null) {}
    try
    {
      this.ee.ek.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }
  
  private void L()
  {
    ct.t("Ad finished loading.");
    if (this.ee.ek != null) {}
    try
    {
      this.ee.ek.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }
  
  private boolean M()
  {
    boolean bool = true;
    if (!co.a(this.ee.eh.getPackageManager(), this.ee.eh.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.ee.em.eG) {
        cs.a(this.ee.eg, this.ee.em, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
      bool = false;
    }
    if (!co.h(this.ee.eh))
    {
      if (!this.ee.em.eG) {
        cs.a(this.ee.eg, this.ee.em, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      }
      bool = false;
    }
    if ((!bool) && (!this.ee.em.eG)) {
      this.ee.eg.setVisibility(0);
    }
    return bool;
  }
  
  private void N()
  {
    if (this.ee.en == null) {
      ct.v("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      ct.r("Pinging click URLs.");
      if (this.ee.en.fK != null) {
        co.a(this.ee.eh, this.ee.ej.iJ, this.ee.en.fK);
      }
    } while ((this.ee.en.is == null) || (this.ee.en.is.fK == null));
    az.a(this.ee.eh, this.ee.ej.iJ, this.ee.en, this.ee.adUnitId, false, this.ee.en.is.fK);
  }
  
  private void O()
  {
    if (this.ee.en != null)
    {
      this.ee.en.gJ.destroy();
      this.ee.en = null;
    }
  }
  
  private void a(int paramInt)
  {
    ct.v("Failed to load ad: " + paramInt);
    if (this.ee.ek != null) {}
    try
    {
      this.ee.ek.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.ee.eg.addView(paramView, localLayoutParams);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.ee.en == null) {
      ct.v("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      ct.r("Pinging Impression URLs.");
      if (this.ee.en.fL != null) {
        co.a(this.ee.eh, this.ee.ej.iJ, this.ee.en.fL);
      }
      if ((this.ee.en.is != null) && (this.ee.en.is.fL != null)) {
        az.a(this.ee.eh, this.ee.ej.iJ, this.ee.en, this.ee.adUnitId, paramBoolean, this.ee.en.is.fL);
      }
    } while ((this.ee.en.gb == null) || (this.ee.en.gb.fG == null));
    az.a(this.ee.eh, this.ee.ej.iJ, this.ee.en, this.ee.adUnitId, paramBoolean, this.ee.en.gb.fG);
  }
  
  /* Error */
  private boolean b(cj paramcj)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 280	com/google/android/gms/internal/cj:hy	Z
    //   4: ifeq +184 -> 188
    //   7: aload_1
    //   8: getfield 284	com/google/android/gms/internal/cj:gc	Lcom/google/android/gms/internal/bc;
    //   11: invokeinterface 290 1 0
    //   16: invokestatic 295	com/google/android/gms/dynamic/c:b	(Lcom/google/android/gms/dynamic/b;)Ljava/lang/Object;
    //   19: checkcast 297	android/view/View
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   27: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   30: invokevirtual 301	android/widget/ViewSwitcher:getNextView	()Landroid/view/View;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +14 -> 49
    //   38: aload_0
    //   39: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   42: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   45: aload_2
    //   46: invokevirtual 304	android/widget/ViewSwitcher:removeView	(Landroid/view/View;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 306	com/google/android/gms/internal/r:b	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   58: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   61: invokevirtual 310	android/widget/ViewSwitcher:getChildCount	()I
    //   64: iconst_1
    //   65: if_icmple +13 -> 78
    //   68: aload_0
    //   69: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   72: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   75: invokevirtual 313	android/widget/ViewSwitcher:showNext	()V
    //   78: aload_0
    //   79: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   82: getfield 182	com/google/android/gms/internal/r$a:en	Lcom/google/android/gms/internal/cj;
    //   85: ifnull +70 -> 155
    //   88: aload_0
    //   89: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   92: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   95: invokevirtual 301	android/widget/ViewSwitcher:getNextView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_1
    //   100: instanceof 233
    //   103: ifeq +158 -> 261
    //   106: aload_1
    //   107: checkcast 233	com/google/android/gms/internal/cw
    //   110: aload_0
    //   111: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   114: getfield 128	com/google/android/gms/internal/r$a:eh	Landroid/content/Context;
    //   117: aload_0
    //   118: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   121: getfield 146	com/google/android/gms/internal/r$a:em	Lcom/google/android/gms/internal/x;
    //   124: invokevirtual 316	com/google/android/gms/internal/cw:a	(Landroid/content/Context;Lcom/google/android/gms/internal/x;)V
    //   127: aload_0
    //   128: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   131: getfield 182	com/google/android/gms/internal/r$a:en	Lcom/google/android/gms/internal/cj;
    //   134: getfield 284	com/google/android/gms/internal/cj:gc	Lcom/google/android/gms/internal/bc;
    //   137: ifnull +18 -> 155
    //   140: aload_0
    //   141: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   144: getfield 182	com/google/android/gms/internal/r$a:en	Lcom/google/android/gms/internal/cj;
    //   147: getfield 284	com/google/android/gms/internal/cj:gc	Lcom/google/android/gms/internal/bc;
    //   150: invokeinterface 317 1 0
    //   155: aload_0
    //   156: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   159: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   162: iconst_0
    //   163: invokevirtual 177	android/widget/ViewSwitcher:setVisibility	(I)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: ldc_w 319
    //   172: aload_1
    //   173: invokestatic 98	com/google/android/gms/internal/ct:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: ldc_w 321
    //   182: aload_1
    //   183: invokestatic 98	com/google/android/gms/internal/ct:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: iconst_0
    //   187: ireturn
    //   188: aload_1
    //   189: getfield 324	com/google/android/gms/internal/cj:it	Lcom/google/android/gms/internal/x;
    //   192: ifnull -138 -> 54
    //   195: aload_1
    //   196: getfield 231	com/google/android/gms/internal/cj:gJ	Lcom/google/android/gms/internal/cw;
    //   199: aload_1
    //   200: getfield 324	com/google/android/gms/internal/cj:it	Lcom/google/android/gms/internal/x;
    //   203: invokevirtual 327	com/google/android/gms/internal/cw:a	(Lcom/google/android/gms/internal/x;)V
    //   206: aload_0
    //   207: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   210: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   213: invokevirtual 330	android/widget/ViewSwitcher:removeAllViews	()V
    //   216: aload_0
    //   217: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   220: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   223: aload_1
    //   224: getfield 324	com/google/android/gms/internal/cj:it	Lcom/google/android/gms/internal/x;
    //   227: getfield 333	com/google/android/gms/internal/x:widthPixels	I
    //   230: invokevirtual 336	android/widget/ViewSwitcher:setMinimumWidth	(I)V
    //   233: aload_0
    //   234: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   237: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   240: aload_1
    //   241: getfield 324	com/google/android/gms/internal/cj:it	Lcom/google/android/gms/internal/x;
    //   244: getfield 339	com/google/android/gms/internal/x:heightPixels	I
    //   247: invokevirtual 342	android/widget/ViewSwitcher:setMinimumHeight	(I)V
    //   250: aload_0
    //   251: aload_1
    //   252: getfield 231	com/google/android/gms/internal/cj:gJ	Lcom/google/android/gms/internal/cw;
    //   255: invokespecial 306	com/google/android/gms/internal/r:b	(Landroid/view/View;)V
    //   258: goto -204 -> 54
    //   261: aload_1
    //   262: ifnull -135 -> 127
    //   265: aload_0
    //   266: getfield 35	com/google/android/gms/internal/r:ee	Lcom/google/android/gms/internal/r$a;
    //   269: getfield 156	com/google/android/gms/internal/r$a:eg	Landroid/widget/ViewSwitcher;
    //   272: aload_1
    //   273: invokevirtual 304	android/widget/ViewSwitcher:removeView	(Landroid/view/View;)V
    //   276: goto -149 -> 127
    //   279: astore_1
    //   280: ldc_w 344
    //   283: invokestatic 187	com/google/android/gms/internal/ct:v	(Ljava/lang/String;)V
    //   286: goto -131 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	r
    //   0	289	1	paramcj	cj
    //   33	13	2	localView	View
    // Exception table:
    //   from	to	target	type
    //   7	23	168	android/os/RemoteException
    //   49	54	178	java/lang/Throwable
    //   140	155	279	android/os/RemoteException
  }
  
  private bz.a c(v paramv)
  {
    ApplicationInfo localApplicationInfo = this.ee.eh.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo = this.ee.eh.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      if ((!this.ee.em.eG) && (this.ee.eg.getParent() != null))
      {
        localObject2 = new int[2];
        this.ee.eg.getLocationOnScreen((int[])localObject2);
        int j = localObject2[0];
        int k = localObject2[1];
        localObject2 = this.ee.eh.getResources().getDisplayMetrics();
        int m = this.ee.eg.getWidth();
        int n = this.ee.eg.getHeight();
        if ((this.ee.eg.isShown()) && (j + m > 0) && (k + n > 0) && (j <= ((DisplayMetrics)localObject2).widthPixels) && (k <= ((DisplayMetrics)localObject2).heightPixels))
        {
          i = 1;
          localObject2 = new Bundle(5);
          ((Bundle)localObject2).putInt("x", j);
          ((Bundle)localObject2).putInt("y", k);
          ((Bundle)localObject2).putInt("width", m);
          ((Bundle)localObject2).putInt("height", n);
          ((Bundle)localObject2).putInt("visible", i);
          return new bz.a((Bundle)localObject2, paramv, this.ee.em, this.ee.adUnitId, localApplicationInfo, localPackageInfo, ck.ar(), ck.iu, this.ee.ej);
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject1 = null;
        continue;
        int i = 0;
        continue;
        Object localObject2 = null;
      }
    }
  }
  
  public void A()
  {
    if (this.ee.em.eG) {
      O();
    }
    I();
  }
  
  public void B()
  {
    if (this.ee.em.eG) {
      b(false);
    }
    K();
  }
  
  public void C()
  {
    w();
  }
  
  public void D()
  {
    A();
  }
  
  public void E()
  {
    z();
  }
  
  public void F()
  {
    B();
  }
  
  public void G()
  {
    if (this.ee.en != null) {
      ct.v("Mediation adapter " + this.ee.en.gd + " refreshed, but mediation adapters should never refresh.");
    }
    b(true);
    L();
  }
  
  public void H()
  {
    eg.N("recordManualImpression must be called on the main UI thread.");
    if (this.ee.en == null) {
      ct.v("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      ct.r("Pinging manual tracking URLs.");
    } while (this.ee.en.hA == null);
    co.a(this.ee.eh, this.ee.ej.iJ, this.ee.en.hA);
  }
  
  public void a(ab paramab)
  {
    eg.N("setAdListener must be called on the main UI thread.");
    this.ee.ek = paramab;
  }
  
  public void a(ae paramae)
  {
    eg.N("setAppEventListener must be called on the main UI thread.");
    this.ee.eo = paramae;
  }
  
  public void a(cj paramcj)
  {
    this.ee.el = null;
    if (paramcj.errorCode == -1) {
      return;
    }
    boolean bool;
    if (paramcj.hr.extras != null)
    {
      bool = paramcj.hr.extras.getBoolean("_noRefresh", false);
      if (!this.ee.em.eG) {
        break label152;
      }
      co.a(paramcj.gJ);
    }
    for (;;)
    {
      if ((paramcj.errorCode == 3) && (paramcj.is != null) && (paramcj.is.fM != null))
      {
        ct.r("Pinging no fill URLs.");
        az.a(this.ee.eh, this.ee.ej.iJ, paramcj, this.ee.adUnitId, false, paramcj.is.fM);
      }
      if (paramcj.errorCode == -2) {
        break label252;
      }
      a(paramcj.errorCode);
      return;
      bool = false;
      break;
      label152:
      if (!bool) {
        if (paramcj.fO > 0L) {
          this.ef.a(paramcj.hr, paramcj.fO);
        } else if ((paramcj.is != null) && (paramcj.is.fO > 0L)) {
          this.ef.a(paramcj.hr, paramcj.is.fO);
        } else if ((!paramcj.hy) && (paramcj.errorCode == 2)) {
          this.ef.d(paramcj.hr);
        }
      }
    }
    label252:
    if ((!this.ee.em.eG) && (!b(paramcj)))
    {
      a(0);
      return;
    }
    if ((this.ee.en != null) && (this.ee.en.ge != null)) {
      this.ee.en.ge.a(null);
    }
    if (paramcj.ge != null) {
      paramcj.ge.a(this);
    }
    this.ee.en = paramcj;
    if (paramcj.it != null) {
      this.ee.em = paramcj.it;
    }
    if (!this.ee.em.eG) {
      b(false);
    }
    L();
  }
  
  public void a(x paramx)
  {
    eg.N("setAdSize must be called on the main UI thread.");
    this.ee.em = paramx;
    if (this.ee.en != null) {
      this.ee.en.gJ.a(paramx);
    }
    if (this.ee.eg.getChildCount() > 1) {
      this.ee.eg.removeView(this.ee.eg.getNextView());
    }
    this.ee.eg.setMinimumWidth(paramx.widthPixels);
    this.ee.eg.setMinimumHeight(paramx.heightPixels);
    this.ee.eg.requestLayout();
  }
  
  public boolean a(v paramv)
  {
    eg.N("loadAd must be called on the main UI thread.");
    if (this.ee.el != null) {
      ct.v("An ad request is already in progress. Aborting.");
    }
    do
    {
      return false;
      if ((this.ee.em.eG) && (this.ee.en != null))
      {
        ct.v("An interstitial is already loading. Aborting.");
        return false;
      }
    } while (!M());
    ct.t("Starting ad request.");
    this.ef.cancel();
    bz.a locala = c(paramv);
    if (this.ee.em.eG)
    {
      paramv = cw.a(this.ee.eh, this.ee.em, false, false, this.ee.ei, this.ee.ej);
      paramv.aC().a(this, null, this, this, true);
      this.ee.el = bu.a(this.ee.eh, locala, this.ee.ei, paramv, this.ed, this);
      return true;
    }
    paramv = this.ee.eg.getNextView();
    if ((paramv instanceof cw))
    {
      paramv = (cw)paramv;
      paramv.a(this.ee.eh, this.ee.em);
    }
    for (;;)
    {
      paramv.aC().a(this, this, this, this, false);
      break;
      if (paramv != null) {
        this.ee.eg.removeView(paramv);
      }
      cw localcw = cw.a(this.ee.eh, this.ee.em, false, false, this.ee.ei, this.ee.ej);
      paramv = localcw;
      if (this.ee.em.eH == null)
      {
        b(localcw);
        paramv = localcw;
      }
    }
  }
  
  public void b(v paramv)
  {
    ViewParent localViewParent = this.ee.eg.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (co.at()))
    {
      a(paramv);
      return;
    }
    ct.t("Ad is not visible. Not refreshing ad.");
    this.ef.d(paramv);
  }
  
  public void destroy()
  {
    eg.N("destroy must be called on the main UI thread.");
    this.ee.ek = null;
    this.ee.eo = null;
    this.ef.cancel();
    stopLoading();
    if (this.ee.eg != null) {
      this.ee.eg.removeAllViews();
    }
    if ((this.ee.en != null) && (this.ee.en.gJ != null)) {
      this.ee.en.gJ.destroy();
    }
  }
  
  public boolean isReady()
  {
    eg.N("isLoaded must be called on the main UI thread.");
    return (this.ee.el == null) && (this.ee.en != null);
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.ee.eo != null) {}
    try
    {
      this.ee.eo.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      ct.b("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    eg.N("pause must be called on the main UI thread.");
    if (this.ee.en != null) {
      co.a(this.ee.en.gJ);
    }
  }
  
  public void resume()
  {
    eg.N("resume must be called on the main UI thread.");
    if (this.ee.en != null) {
      co.b(this.ee.en.gJ);
    }
  }
  
  public void showInterstitial()
  {
    eg.N("showInterstitial must be called on the main UI thread.");
    if (!this.ee.em.eG)
    {
      ct.v("Cannot call showInterstitial on a banner ad.");
      return;
    }
    if (this.ee.en == null)
    {
      ct.v("The interstitial has not loaded.");
      return;
    }
    if (this.ee.en.gJ.aF())
    {
      ct.v("The interstitial is already showing.");
      return;
    }
    this.ee.en.gJ.l(true);
    if (this.ee.en.hy) {
      try
      {
        this.ee.en.gc.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ct.b("Could not show interstitial.", localRemoteException);
        O();
        return;
      }
    }
    bm localbm = new bm(this, this, this, this.ee.en.gJ, this.ee.en.orientation, this.ee.ej);
    bk.a(this.ee.eh, localbm);
  }
  
  public void stopLoading()
  {
    eg.N("stopLoading must be called on the main UI thread.");
    if (this.ee.en != null)
    {
      this.ee.en.gJ.stopLoading();
      this.ee.en = null;
    }
    if (this.ee.el != null) {
      this.ee.el.cancel();
    }
  }
  
  public void w()
  {
    N();
  }
  
  public b x()
  {
    eg.N("getAdFrame must be called on the main UI thread.");
    return c.h(this.ee.eg);
  }
  
  public x y()
  {
    eg.N("getAdSize must be called on the main UI thread.");
    return this.ee.em;
  }
  
  public void z()
  {
    J();
  }
  
  private static final class a
  {
    public final String adUnitId;
    public final ViewSwitcher eg;
    public final Context eh;
    public final h ei;
    public final cu ej;
    public ab ek;
    public cm el;
    public x em;
    public cj en;
    public ae eo;
    
    public a(Context paramContext, x paramx, String paramString, cu paramcu)
    {
      if (paramx.eG) {
        this.eg = null;
      }
      for (;;)
      {
        this.em = paramx;
        this.adUnitId = paramString;
        this.eh = paramContext;
        this.ei = new h(g.a(paramcu.iJ, paramContext));
        this.ej = paramcu;
        return;
        this.eg = new ViewSwitcher(paramContext);
        this.eg.setMinimumWidth(paramx.widthPixels);
        this.eg.setMinimumHeight(paramx.heightPixels);
        this.eg.setVisibility(4);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */