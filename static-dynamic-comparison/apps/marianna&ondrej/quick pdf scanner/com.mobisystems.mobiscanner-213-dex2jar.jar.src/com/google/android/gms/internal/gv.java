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
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import java.util.HashSet;

public final class gv
  extends g.a
  implements ac, as, at, aw.a, gu, q
{
  private final a Tt;
  private final gw Tu;
  private final ai xU;
  
  public gv(Context paramContext, ab paramab, String paramString, ai paramai, db paramdb)
  {
    this.Tt = new a(paramContext, paramab, paramString, paramdb);
    this.xU = paramai;
    this.Tu = new gw(this);
    ce.aa("Use AdRequest.Builder.addTestDevice(\"" + cb.H(paramContext) + "\") to get test ads on this device.");
    bw.E(paramContext);
  }
  
  private void L(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.Tt.Tv.addView(paramView, localLayoutParams);
  }
  
  private void N(boolean paramBoolean)
  {
    if (this.Tt.TA == null) {
      ce.D("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      ce.aG("Pinging Impression URLs.");
      this.Tt.TB.pD();
      if (this.Tt.TA.yj != null) {
        bw.a(this.Tt.Tw, this.Tt.CY.FK, this.Tt.TA.yj);
      }
      if ((this.Tt.TA.EI != null) && (this.Tt.TA.EI.yj != null)) {
        ag.a(this.Tt.Tw, this.Tt.CY.FK, this.Tt.TA, this.Tt.DD, paramBoolean, this.Tt.TA.EI.yj);
      }
    } while ((this.Tt.TA.Ck == null) || (this.Tt.TA.Ck.ye == null));
    ag.a(this.Tt.Tw, this.Tt.CY.FK, this.Tt.TA, this.Tt.DD, paramBoolean, this.Tt.TA.Ck.ye);
  }
  
  /* Error */
  private boolean b(bi parambi)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 177	com/google/android/gms/internal/bi:DN	Z
    //   4: ifeq +182 -> 186
    //   7: aload_1
    //   8: getfield 181	com/google/android/gms/internal/bi:Cl	Lcom/google/android/gms/internal/aj;
    //   11: invokeinterface 187 1 0
    //   16: invokestatic 192	com/google/android/gms/dynamic/d:a	(Lcom/google/android/gms/dynamic/c;)Ljava/lang/Object;
    //   19: checkcast 194	android/view/View
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   27: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   30: invokevirtual 198	android/widget/ViewSwitcher:getNextView	()Landroid/view/View;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +14 -> 49
    //   38: aload_0
    //   39: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   42: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   45: aload_2
    //   46: invokevirtual 201	android/widget/ViewSwitcher:removeView	(Landroid/view/View;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 203	com/google/android/gms/internal/gv:L	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   58: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   61: invokevirtual 207	android/widget/ViewSwitcher:getChildCount	()I
    //   64: iconst_1
    //   65: if_icmple +13 -> 78
    //   68: aload_0
    //   69: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   72: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   75: invokevirtual 210	android/widget/ViewSwitcher:showNext	()V
    //   78: aload_0
    //   79: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   82: getfield 101	com/google/android/gms/internal/gv$a:TA	Lcom/google/android/gms/internal/bi;
    //   85: ifnull +70 -> 155
    //   88: aload_0
    //   89: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   92: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   95: invokevirtual 198	android/widget/ViewSwitcher:getNextView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_1
    //   100: instanceof 212
    //   103: ifeq +156 -> 259
    //   106: aload_1
    //   107: checkcast 212	com/google/android/gms/internal/dd
    //   110: aload_0
    //   111: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   114: getfield 130	com/google/android/gms/internal/gv$a:Tw	Landroid/content/Context;
    //   117: aload_0
    //   118: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   121: getfield 216	com/google/android/gms/internal/gv$a:DC	Lcom/google/android/gms/internal/ab;
    //   124: invokevirtual 219	com/google/android/gms/internal/dd:a	(Landroid/content/Context;Lcom/google/android/gms/internal/ab;)V
    //   127: aload_0
    //   128: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   131: getfield 101	com/google/android/gms/internal/gv$a:TA	Lcom/google/android/gms/internal/bi;
    //   134: getfield 181	com/google/android/gms/internal/bi:Cl	Lcom/google/android/gms/internal/aj;
    //   137: ifnull +18 -> 155
    //   140: aload_0
    //   141: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   144: getfield 101	com/google/android/gms/internal/gv$a:TA	Lcom/google/android/gms/internal/bi;
    //   147: getfield 181	com/google/android/gms/internal/bi:Cl	Lcom/google/android/gms/internal/aj;
    //   150: invokeinterface 222 1 0
    //   155: aload_0
    //   156: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   159: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   162: iconst_0
    //   163: invokevirtual 226	android/widget/ViewSwitcher:setVisibility	(I)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: ldc -28
    //   171: aload_1
    //   172: invokestatic 232	com/google/android/gms/internal/ce:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_1
    //   178: ldc -22
    //   180: aload_1
    //   181: invokestatic 232	com/google/android/gms/internal/ce:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_1
    //   187: getfield 237	com/google/android/gms/internal/bi:EJ	Lcom/google/android/gms/internal/ab;
    //   190: ifnull -136 -> 54
    //   193: aload_1
    //   194: getfield 241	com/google/android/gms/internal/bi:CQ	Lcom/google/android/gms/internal/dd;
    //   197: aload_1
    //   198: getfield 237	com/google/android/gms/internal/bi:EJ	Lcom/google/android/gms/internal/ab;
    //   201: invokevirtual 244	com/google/android/gms/internal/dd:a	(Lcom/google/android/gms/internal/ab;)V
    //   204: aload_0
    //   205: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   208: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   211: invokevirtual 247	android/widget/ViewSwitcher:removeAllViews	()V
    //   214: aload_0
    //   215: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   218: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   221: aload_1
    //   222: getfield 237	com/google/android/gms/internal/bi:EJ	Lcom/google/android/gms/internal/ab;
    //   225: getfield 253	com/google/android/gms/internal/ab:widthPixels	I
    //   228: invokevirtual 256	android/widget/ViewSwitcher:setMinimumWidth	(I)V
    //   231: aload_0
    //   232: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   235: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   238: aload_1
    //   239: getfield 237	com/google/android/gms/internal/bi:EJ	Lcom/google/android/gms/internal/ab;
    //   242: getfield 259	com/google/android/gms/internal/ab:heightPixels	I
    //   245: invokevirtual 262	android/widget/ViewSwitcher:setMinimumHeight	(I)V
    //   248: aload_0
    //   249: aload_1
    //   250: getfield 241	com/google/android/gms/internal/bi:CQ	Lcom/google/android/gms/internal/dd;
    //   253: invokespecial 203	com/google/android/gms/internal/gv:L	(Landroid/view/View;)V
    //   256: goto -202 -> 54
    //   259: aload_1
    //   260: ifnull -133 -> 127
    //   263: aload_0
    //   264: getfield 35	com/google/android/gms/internal/gv:Tt	Lcom/google/android/gms/internal/gv$a;
    //   267: getfield 89	com/google/android/gms/internal/gv$a:Tv	Landroid/widget/ViewSwitcher;
    //   270: aload_1
    //   271: invokevirtual 201	android/widget/ViewSwitcher:removeView	(Landroid/view/View;)V
    //   274: goto -147 -> 127
    //   277: astore_1
    //   278: ldc_w 264
    //   281: invokestatic 106	com/google/android/gms/internal/ce:D	(Ljava/lang/String;)V
    //   284: goto -129 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	gv
    //   0	287	1	parambi	bi
    //   33	13	2	localView	View
    // Exception table:
    //   from	to	target	type
    //   7	23	168	android/os/RemoteException
    //   49	54	177	java/lang/Throwable
    //   140	155	277	android/os/RemoteException
  }
  
  private void dF(int paramInt)
  {
    ce.D("Failed to load ad: " + paramInt);
    if (this.Tt.Ty != null) {}
    try
    {
      this.Tt.Ty.ba(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }
  
  private cd.a e(z paramz)
  {
    ApplicationInfo localApplicationInfo = this.Tt.Tw.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo = this.Tt.Tw.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      if ((!this.Tt.DC.xa) && (this.Tt.Tv.getParent() != null))
      {
        localObject2 = new int[2];
        this.Tt.Tv.getLocationOnScreen((int[])localObject2);
        int j = localObject2[0];
        int k = localObject2[1];
        localObject2 = this.Tt.Tw.getResources().getDisplayMetrics();
        int m = this.Tt.Tv.getWidth();
        int n = this.Tt.Tv.getHeight();
        if ((this.Tt.Tv.isShown()) && (j + m > 0) && (k + n > 0) && (j <= ((DisplayMetrics)localObject2).widthPixels) && (k <= ((DisplayMetrics)localObject2).heightPixels))
        {
          i = 1;
          localObject2 = new Bundle(5);
          ((Bundle)localObject2).putInt("x", j);
          ((Bundle)localObject2).putInt("y", k);
          ((Bundle)localObject2).putInt("width", m);
          ((Bundle)localObject2).putInt("height", n);
          ((Bundle)localObject2).putInt("visible", i);
          String str = bk.pJ();
          this.Tt.TB = new bj(str, this.Tt.DD);
          this.Tt.TB.c(paramz);
          Bundle localBundle = bk.a(this.Tt, str, this.Tt.Tw);
          return new cd.a((Bundle)localObject2, paramz, this.Tt.DC, this.Tt.DD, localApplicationInfo, localPackageInfo, str, bk.EX, this.Tt.CY, localBundle);
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
  
  private void tP()
  {
    ce.aa("Ad closing.");
    if (this.Tt.Ty != null) {}
    try
    {
      this.Tt.Ty.ko();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }
  
  private void tQ()
  {
    ce.aa("Ad leaving application.");
    if (this.Tt.Ty != null) {}
    try
    {
      this.Tt.Ty.kp();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  private void tR()
  {
    ce.aa("Ad opening.");
    if (this.Tt.Ty != null) {}
    try
    {
      this.Tt.Ty.kq();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }
  
  private void tS()
  {
    ce.aa("Ad finished loading.");
    if (this.Tt.Ty != null) {}
    try
    {
      this.Tt.Ty.kr();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }
  
  private boolean tT()
  {
    boolean bool = true;
    if (!bw.a(this.Tt.Tw.getPackageManager(), this.Tt.Tw.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.Tt.DC.xa) {
        cb.a(this.Tt.Tv, this.Tt.DC, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
      bool = false;
    }
    if (!bw.D(this.Tt.Tw))
    {
      if (!this.Tt.DC.xa) {
        cb.a(this.Tt.Tv, this.Tt.DC, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      }
      bool = false;
    }
    if ((!bool) && (!this.Tt.DC.xa)) {
      this.Tt.Tv.setVisibility(0);
    }
    return bool;
  }
  
  private void tU()
  {
    if (this.Tt.TA == null) {
      ce.D("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      ce.aG("Pinging click URLs.");
      this.Tt.TB.pE();
      if (this.Tt.TA.yi != null) {
        bw.a(this.Tt.Tw, this.Tt.CY.FK, this.Tt.TA.yi);
      }
    } while ((this.Tt.TA.EI == null) || (this.Tt.TA.EI.yi == null));
    ag.a(this.Tt.Tw, this.Tt.CY.FK, this.Tt.TA, this.Tt.DD, false, this.Tt.TA.EI.yi);
  }
  
  private void tV()
  {
    if (this.Tt.TA != null)
    {
      this.Tt.TA.CQ.destroy();
      this.Tt.TA = null;
    }
  }
  
  public void a(ab paramab)
  {
    dc.aH("setAdSize must be called on the main UI thread.");
    this.Tt.DC = paramab;
    if (this.Tt.TA != null) {
      this.Tt.TA.CQ.a(paramab);
    }
    if (this.Tt.Tv.getChildCount() > 1) {
      this.Tt.Tv.removeView(this.Tt.Tv.getNextView());
    }
    this.Tt.Tv.setMinimumWidth(paramab.widthPixels);
    this.Tt.Tv.setMinimumHeight(paramab.heightPixels);
    this.Tt.Tv.requestLayout();
  }
  
  public void a(bi parambi)
  {
    int j = 0;
    this.Tt.Tz = null;
    if ((parambi.errorCode != -2) && (parambi.errorCode != 3)) {
      bk.a(this.Tt);
    }
    if (parambi.errorCode == -1) {
      return;
    }
    boolean bool;
    if (parambi.DB.extras != null)
    {
      bool = parambi.DB.extras.getBoolean("_noRefresh", false);
      if (!this.Tt.DC.xa) {
        break label180;
      }
      bw.a(parambi.CQ);
    }
    for (;;)
    {
      if ((parambi.errorCode == 3) && (parambi.EI != null) && (parambi.EI.yk != null))
      {
        ce.aG("Pinging no fill URLs.");
        ag.a(this.Tt.Tw, this.Tt.CY.FK, parambi, this.Tt.DD, false, parambi.EI.yk);
      }
      if (parambi.errorCode == -2) {
        break label281;
      }
      dF(parambi.errorCode);
      return;
      bool = false;
      break;
      label180:
      if (!bool) {
        if (parambi.ym > 0L) {
          this.Tu.b(parambi.DB, parambi.ym);
        } else if ((parambi.EI != null) && (parambi.EI.ym > 0L)) {
          this.Tu.b(parambi.DB, parambi.EI.ym);
        } else if ((!parambi.DN) && (parambi.errorCode == 2)) {
          this.Tu.f(parambi.DB);
        }
      }
    }
    label281:
    if ((!this.Tt.DC.xa) && (!b(parambi)))
    {
      dF(0);
      return;
    }
    if ((this.Tt.TA != null) && (this.Tt.TA.Cn != null)) {
      this.Tt.TA.Cn.a(null);
    }
    if (parambi.Cn != null) {
      parambi.Cn.a(this);
    }
    this.Tt.TA = parambi;
    if (parambi.EJ != null) {
      this.Tt.DC = parambi.EJ;
    }
    this.Tt.TB.k(parambi.EK);
    this.Tt.TB.l(parambi.EL);
    this.Tt.TB.B(this.Tt.DC.xa);
    this.Tt.TB.C(parambi.DN);
    if (!this.Tt.DC.xa) {
      N(false);
    }
    if (this.Tt.TD == null) {
      this.Tt.TD = new bm(this.Tt.DD);
    }
    int i;
    if (parambi.EI != null)
    {
      i = parambi.EI.yn;
      j = parambi.EI.yo;
    }
    for (;;)
    {
      this.Tt.TD.q(i, j);
      tS();
      return;
      i = 0;
    }
  }
  
  public void a(f paramf)
  {
    dc.aH("setAdListener must be called on the main UI thread.");
    this.Tt.Ty = paramf;
  }
  
  public void a(i parami)
  {
    dc.aH("setAppEventListener must be called on the main UI thread.");
    this.Tt.TC = parami;
  }
  
  public boolean a(z paramz)
  {
    dc.aH("loadAd must be called on the main UI thread.");
    if (this.Tt.Tz != null) {
      ce.D("An ad request is already in progress. Aborting.");
    }
    do
    {
      return false;
      if ((this.Tt.DC.xa) && (this.Tt.TA != null))
      {
        ce.D("An interstitial is already loading. Aborting.");
        return false;
      }
    } while (!tT());
    ce.aa("Starting ad request.");
    this.Tu.cancel();
    cd.a locala = e(paramz);
    if (this.Tt.DC.xa)
    {
      paramz = dd.a(this.Tt.Tw, this.Tt.DC, false, false, this.Tt.Tx, this.Tt.CY);
      paramz.pX().a(this, null, this, this, true);
      this.Tt.Tz = aw.a(this.Tt.Tw, locala, this.Tt.Tx, paramz, this.xU, this);
      return true;
    }
    paramz = this.Tt.Tv.getNextView();
    if ((paramz instanceof dd))
    {
      paramz = (dd)paramz;
      paramz.a(this.Tt.Tw, this.Tt.DC);
    }
    for (;;)
    {
      paramz.pX().a(this, this, this, this, false);
      break;
      if (paramz != null) {
        this.Tt.Tv.removeView(paramz);
      }
      dd localdd = dd.a(this.Tt.Tw, this.Tt.DC, false, false, this.Tt.Tx, this.Tt.CY);
      paramz = localdd;
      if (this.Tt.DC.xb == null)
      {
        L(localdd);
        paramz = localdd;
      }
    }
  }
  
  public void d(z paramz)
  {
    ViewParent localViewParent = this.Tt.Tv.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (bw.pM()))
    {
      a(paramz);
      return;
    }
    ce.aa("Ad is not visible. Not refreshing ad.");
    this.Tu.f(paramz);
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (this.Tt.TC != null) {}
    try
    {
      this.Tt.TC.d(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      ce.c("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void destroy()
  {
    dc.aH("destroy must be called on the main UI thread.");
    this.Tt.Ty = null;
    this.Tt.TC = null;
    this.Tu.cancel();
    stopLoading();
    if (this.Tt.Tv != null) {
      this.Tt.Tv.removeAllViews();
    }
    if ((this.Tt.TA != null) && (this.Tt.TA.CQ != null)) {
      this.Tt.TA.CQ.destroy();
    }
  }
  
  public void fv()
  {
    dc.aH("showInterstitial must be called on the main UI thread.");
    if (!this.Tt.DC.xa)
    {
      ce.D("Cannot call showInterstitial on a banner ad.");
      return;
    }
    if (this.Tt.TA == null)
    {
      ce.D("The interstitial has not loaded.");
      return;
    }
    if (this.Tt.TA.CQ.qa())
    {
      ce.D("The interstitial is already showing.");
      return;
    }
    this.Tt.TA.CQ.E(true);
    if (this.Tt.TA.DN) {
      try
      {
        this.Tt.TA.Cl.fv();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ce.c("Could not show interstitial.", localRemoteException);
        tV();
        return;
      }
    }
    bq localbq = new bq(this, this, this, this.Tt.TA.CQ, this.Tt.TA.orientation, this.Tt.CY);
    bo.a(this.Tt.Tw, localbq);
  }
  
  public boolean mw()
  {
    dc.aH("isLoaded must be called on the main UI thread.");
    return (this.Tt.Tz == null) && (this.Tt.TA != null);
  }
  
  public c oM()
  {
    dc.aH("getAdFrame must be called on the main UI thread.");
    return d.J(this.Tt.Tv);
  }
  
  public void oN()
  {
    dc.aH("recordManualImpression must be called on the main UI thread.");
    if (this.Tt.TA == null) {
      ce.D("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      ce.aG("Pinging manual tracking URLs.");
    } while (this.Tt.TA.DP == null);
    bw.a(this.Tt.Tw, this.Tt.CY.FK, this.Tt.TA.DP);
  }
  
  public ab oO()
  {
    dc.aH("getAdSize must be called on the main UI thread.");
    return this.Tt.DC;
  }
  
  public void pause()
  {
    dc.aH("pause must be called on the main UI thread.");
    if (this.Tt.TA != null) {
      bw.a(this.Tt.TA.CQ);
    }
  }
  
  public void pb()
  {
    pg();
  }
  
  public void pc()
  {
    ps();
  }
  
  public void pd()
  {
    px();
  }
  
  public void pe()
  {
    pt();
  }
  
  public void pf()
  {
    if (this.Tt.TA != null) {
      ce.D("Mediation adapter " + this.Tt.TA.Cm + " refreshed, but mediation adapters should never refresh.");
    }
    N(true);
    tS();
  }
  
  public void pg()
  {
    tU();
  }
  
  public void ps()
  {
    if (this.Tt.DC.xa) {
      tV();
    }
    tP();
    this.Tt.TB.pF();
  }
  
  public void pt()
  {
    if (this.Tt.DC.xa) {
      N(false);
    }
    tR();
  }
  
  public void px()
  {
    tQ();
  }
  
  public void resume()
  {
    dc.aH("resume must be called on the main UI thread.");
    if (this.Tt.TA != null) {
      bw.b(this.Tt.TA.CQ);
    }
  }
  
  public void stopLoading()
  {
    dc.aH("stopLoading must be called on the main UI thread.");
    if (this.Tt.TA != null)
    {
      this.Tt.TA.CQ.stopLoading();
      this.Tt.TA = null;
    }
    if (this.Tt.Tz != null) {
      this.Tt.Tz.cancel();
    }
  }
  
  public static final class a
  {
    public final db CY;
    public ab DC;
    public final String DD;
    public bi TA;
    public bj TB;
    public i TC;
    public bm TD = null;
    private HashSet<bj> TE = null;
    public final ViewSwitcher Tv;
    public final Context Tw;
    public final gn Tx;
    public f Ty;
    public br Tz;
    
    public a(Context paramContext, ab paramab, String paramString, db paramdb)
    {
      if (paramab.xa) {
        this.Tv = null;
      }
      for (;;)
      {
        this.DC = paramab;
        this.DD = paramString;
        this.Tw = paramContext;
        this.Tx = new gn(gg.b(paramdb.FK, paramContext));
        this.CY = paramdb;
        return;
        this.Tv = new ViewSwitcher(paramContext);
        this.Tv.setMinimumWidth(paramab.widthPixels);
        this.Tv.setMinimumHeight(paramab.heightPixels);
        this.Tv.setVisibility(4);
      }
    }
    
    public void a(HashSet<bj> paramHashSet)
    {
      this.TE = paramHashSet;
    }
    
    public HashSet<bj> tW()
    {
      return this.TE;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */