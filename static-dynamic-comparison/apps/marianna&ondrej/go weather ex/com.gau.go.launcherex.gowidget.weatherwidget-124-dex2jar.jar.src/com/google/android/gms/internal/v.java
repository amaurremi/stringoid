package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.HashSet;

public class v
  extends ap.a
  implements az, bc, bk, cf, ci, cr.a, dl, u
{
  private final x kA;
  private final aa kB;
  private boolean kC;
  private final ComponentCallbacks kD = new ComponentCallbacks()
  {
    public void onConfigurationChanged(Configuration paramAnonymousConfiguration)
    {
      if ((v.a(v.this) != null) && (v.a(v.this).kO != null) && (v.a(v.this).kO.oj != null)) {
        v.a(v.this).kO.oj.bE();
      }
    }
    
    public void onLowMemory() {}
  };
  private final bq ky;
  private final b kz;
  
  public v(Context paramContext, ak paramak, String paramString, bq parambq, dx paramdx)
  {
    this.kz = new b(paramContext, paramak, paramString, paramdx);
    this.ky = parambq;
    this.kA = new x(this);
    this.kB = new aa();
    dw.x("Use AdRequest.Builder.addTestDevice(\"" + dv.l(paramContext) + "\") to get test ads on this device.");
    dq.i(paramContext);
    S();
  }
  
  private void S()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kz != null) && (this.kz.kI != null)) {
      this.kz.kI.registerComponentCallbacks(this.kD);
    }
  }
  
  private void T()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kz != null) && (this.kz.kI != null)) {
      this.kz.kI.unregisterComponentCallbacks(this.kD);
    }
  }
  
  private void a(int paramInt)
  {
    dw.z("Failed to load ad: " + paramInt);
    if (this.kz.kL != null) {}
    try
    {
      this.kz.kL.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dw.c("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }
  
  private void ad()
  {
    dw.x("Ad closing.");
    if (this.kz.kL != null) {}
    try
    {
      this.kz.kL.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dw.c("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }
  
  private void ae()
  {
    dw.x("Ad leaving application.");
    if (this.kz.kL != null) {}
    try
    {
      this.kz.kL.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dw.c("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  private void af()
  {
    dw.x("Ad opening.");
    if (this.kz.kL != null) {}
    try
    {
      this.kz.kL.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dw.c("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }
  
  private void ag()
  {
    dw.x("Ad finished loading.");
    if (this.kz.kL != null) {}
    try
    {
      this.kz.kL.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dw.c("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }
  
  private boolean ah()
  {
    boolean bool = true;
    if (!dq.a(this.kz.kI.getPackageManager(), this.kz.kI.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.kz.kN.lT) {
        dv.a(this.kz.kG, this.kz.kN, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
      bool = false;
    }
    if (!dq.h(this.kz.kI))
    {
      if (!this.kz.kN.lT) {
        dv.a(this.kz.kG, this.kz.kN, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      }
      bool = false;
    }
    if ((!bool) && (!this.kz.kN.lT)) {
      this.kz.kG.setVisibility(0);
    }
    return bool;
  }
  
  private void ai()
  {
    if (this.kz.kO == null) {
      dw.z("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      dw.v("Pinging click URLs.");
      this.kz.kP.bl();
      if (this.kz.kO.ne != null) {
        dq.a(this.kz.kI, this.kz.kK.rq, this.kz.kO.ne);
      }
    } while ((this.kz.kO.qt == null) || (this.kz.kO.qt.ne == null));
    bo.a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, false, this.kz.kO.qt.ne);
  }
  
  private void aj()
  {
    if (this.kz.kO != null)
    {
      this.kz.kO.oj.destroy();
      this.kz.kO = null;
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.kz.kG.addView(paramView, localLayoutParams);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.kz.kO == null) {
      dw.z("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      dw.v("Pinging Impression URLs.");
      this.kz.kP.bk();
      if (this.kz.kO.nf != null) {
        dq.a(this.kz.kI, this.kz.kK.rq, this.kz.kO.nf);
      }
      if ((this.kz.kO.qt != null) && (this.kz.kO.qt.nf != null)) {
        bo.a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, paramBoolean, this.kz.kO.qt.nf);
      }
    } while ((this.kz.kO.nx == null) || (this.kz.kO.nx.na == null));
    bo.a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, paramBoolean, this.kz.kO.nx.na);
  }
  
  /* Error */
  private boolean b(dh paramdh)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 330	com/google/android/gms/internal/dh:po	Z
    //   4: ifeq +184 -> 188
    //   7: aload_1
    //   8: getfield 334	com/google/android/gms/internal/dh:ny	Lcom/google/android/gms/internal/br;
    //   11: invokeinterface 340 1 0
    //   16: invokestatic 346	com/google/android/gms/dynamic/e:d	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   19: checkcast 348	android/view/View
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   27: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   30: invokevirtual 352	com/google/android/gms/internal/v$a:getNextView	()Landroid/view/View;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +14 -> 49
    //   38: aload_0
    //   39: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   42: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   45: aload_2
    //   46: invokevirtual 355	com/google/android/gms/internal/v$a:removeView	(Landroid/view/View;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 357	com/google/android/gms/internal/v:b	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   58: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   61: invokevirtual 361	com/google/android/gms/internal/v$a:getChildCount	()I
    //   64: iconst_1
    //   65: if_icmple +13 -> 78
    //   68: aload_0
    //   69: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   72: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   75: invokevirtual 364	com/google/android/gms/internal/v$a:showNext	()V
    //   78: aload_0
    //   79: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   82: getfield 233	com/google/android/gms/internal/v$b:kO	Lcom/google/android/gms/internal/dh;
    //   85: ifnull +70 -> 155
    //   88: aload_0
    //   89: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   92: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   95: invokevirtual 352	com/google/android/gms/internal/v$a:getNextView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_1
    //   100: instanceof 290
    //   103: ifeq +158 -> 261
    //   106: aload_1
    //   107: checkcast 290	com/google/android/gms/internal/dz
    //   110: aload_0
    //   111: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   114: getfield 114	com/google/android/gms/internal/v$b:kI	Landroid/content/Context;
    //   117: aload_0
    //   118: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   121: getfield 201	com/google/android/gms/internal/v$b:kN	Lcom/google/android/gms/internal/ak;
    //   124: invokevirtual 367	com/google/android/gms/internal/dz:a	(Landroid/content/Context;Lcom/google/android/gms/internal/ak;)V
    //   127: aload_0
    //   128: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   131: getfield 233	com/google/android/gms/internal/v$b:kO	Lcom/google/android/gms/internal/dh;
    //   134: getfield 334	com/google/android/gms/internal/dh:ny	Lcom/google/android/gms/internal/br;
    //   137: ifnull +18 -> 155
    //   140: aload_0
    //   141: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   144: getfield 233	com/google/android/gms/internal/v$b:kO	Lcom/google/android/gms/internal/dh;
    //   147: getfield 334	com/google/android/gms/internal/dh:ny	Lcom/google/android/gms/internal/br;
    //   150: invokeinterface 368 1 0
    //   155: aload_0
    //   156: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   159: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   162: iconst_0
    //   163: invokevirtual 228	com/google/android/gms/internal/v$a:setVisibility	(I)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: ldc_w 370
    //   172: aload_1
    //   173: invokestatic 151	com/google/android/gms/internal/dw:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: ldc_w 372
    //   182: aload_1
    //   183: invokestatic 151	com/google/android/gms/internal/dw:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: iconst_0
    //   187: ireturn
    //   188: aload_1
    //   189: getfield 375	com/google/android/gms/internal/dh:qu	Lcom/google/android/gms/internal/ak;
    //   192: ifnull -138 -> 54
    //   195: aload_1
    //   196: getfield 288	com/google/android/gms/internal/dh:oj	Lcom/google/android/gms/internal/dz;
    //   199: aload_1
    //   200: getfield 375	com/google/android/gms/internal/dh:qu	Lcom/google/android/gms/internal/ak;
    //   203: invokevirtual 378	com/google/android/gms/internal/dz:a	(Lcom/google/android/gms/internal/ak;)V
    //   206: aload_0
    //   207: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   210: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   213: invokevirtual 381	com/google/android/gms/internal/v$a:removeAllViews	()V
    //   216: aload_0
    //   217: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   220: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   223: aload_1
    //   224: getfield 375	com/google/android/gms/internal/dh:qu	Lcom/google/android/gms/internal/ak;
    //   227: getfield 384	com/google/android/gms/internal/ak:widthPixels	I
    //   230: invokevirtual 387	com/google/android/gms/internal/v$a:setMinimumWidth	(I)V
    //   233: aload_0
    //   234: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   237: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   240: aload_1
    //   241: getfield 375	com/google/android/gms/internal/dh:qu	Lcom/google/android/gms/internal/ak;
    //   244: getfield 390	com/google/android/gms/internal/ak:heightPixels	I
    //   247: invokevirtual 393	com/google/android/gms/internal/v$a:setMinimumHeight	(I)V
    //   250: aload_0
    //   251: aload_1
    //   252: getfield 288	com/google/android/gms/internal/dh:oj	Lcom/google/android/gms/internal/dz;
    //   255: invokespecial 357	com/google/android/gms/internal/v:b	(Landroid/view/View;)V
    //   258: goto -204 -> 54
    //   261: aload_1
    //   262: ifnull -135 -> 127
    //   265: aload_0
    //   266: getfield 55	com/google/android/gms/internal/v:kz	Lcom/google/android/gms/internal/v$b;
    //   269: getfield 210	com/google/android/gms/internal/v$b:kG	Lcom/google/android/gms/internal/v$a;
    //   272: aload_1
    //   273: invokevirtual 355	com/google/android/gms/internal/v$a:removeView	(Landroid/view/View;)V
    //   276: goto -149 -> 127
    //   279: astore_1
    //   280: ldc_w 395
    //   283: invokestatic 136	com/google/android/gms/internal/dw:z	(Ljava/lang/String;)V
    //   286: goto -131 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	v
    //   0	289	1	paramdh	dh
    //   33	13	2	localView	View
    // Exception table:
    //   from	to	target	type
    //   7	23	168	android/os/RemoteException
    //   49	54	178	java/lang/Throwable
    //   140	155	279	android/os/RemoteException
  }
  
  private cx.a c(ah paramah)
  {
    ApplicationInfo localApplicationInfo = this.kz.kI.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo = this.kz.kI.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      if ((!this.kz.kN.lT) && (this.kz.kG.getParent() != null))
      {
        localObject2 = new int[2];
        this.kz.kG.getLocationOnScreen((int[])localObject2);
        int j = localObject2[0];
        int k = localObject2[1];
        localObject2 = this.kz.kI.getResources().getDisplayMetrics();
        int m = this.kz.kG.getWidth();
        int n = this.kz.kG.getHeight();
        if ((this.kz.kG.isShown()) && (j + m > 0) && (k + n > 0) && (j <= ((DisplayMetrics)localObject2).widthPixels) && (k <= ((DisplayMetrics)localObject2).heightPixels))
        {
          i = 1;
          localObject2 = new Bundle(5);
          ((Bundle)localObject2).putInt("x", j);
          ((Bundle)localObject2).putInt("y", k);
          ((Bundle)localObject2).putInt("width", m);
          ((Bundle)localObject2).putInt("height", n);
          ((Bundle)localObject2).putInt("visible", i);
          String str = dj.bs();
          this.kz.kP = new di(str, this.kz.kH);
          this.kz.kP.f(paramah);
          Bundle localBundle = dj.a(this, str);
          return new cx.a((Bundle)localObject2, paramah, this.kz.kN, this.kz.kH, localApplicationInfo, localPackageInfo, str, dj.qK, this.kz.kK, localBundle);
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
  
  public void P()
  {
    ai();
  }
  
  public d Q()
  {
    fq.aj("getAdFrame must be called on the main UI thread.");
    return e.h(this.kz.kG);
  }
  
  public ak R()
  {
    fq.aj("getAdSize must be called on the main UI thread.");
    return this.kz.kN;
  }
  
  public void U()
  {
    ae();
  }
  
  public void V()
  {
    this.kB.d(this.kz.kO);
    if (this.kz.kN.lT) {
      aj();
    }
    this.kC = false;
    ad();
    this.kz.kP.bm();
  }
  
  public void W()
  {
    if (this.kz.kN.lT) {
      b(false);
    }
    this.kC = true;
    af();
  }
  
  public void X()
  {
    P();
  }
  
  public void Y()
  {
    V();
  }
  
  public void Z()
  {
    U();
  }
  
  public void a(ak paramak)
  {
    fq.aj("setAdSize must be called on the main UI thread.");
    this.kz.kN = paramak;
    if (this.kz.kO != null) {
      this.kz.kO.oj.a(paramak);
    }
    if (this.kz.kG.getChildCount() > 1) {
      this.kz.kG.removeView(this.kz.kG.getNextView());
    }
    this.kz.kG.setMinimumWidth(paramak.widthPixels);
    this.kz.kG.setMinimumHeight(paramak.heightPixels);
    this.kz.kG.requestLayout();
  }
  
  public void a(ao paramao)
  {
    fq.aj("setAdListener must be called on the main UI thread.");
    this.kz.kL = paramao;
  }
  
  public void a(ar paramar)
  {
    fq.aj("setAppEventListener must be called on the main UI thread.");
    this.kz.kQ = paramar;
  }
  
  public void a(co paramco)
  {
    fq.aj("setInAppPurchaseListener must be called on the main UI thread.");
    this.kz.kR = paramco;
  }
  
  public void a(dh paramdh)
  {
    int j = 0;
    this.kz.kM = null;
    if ((paramdh.errorCode != -2) && (paramdh.errorCode != 3)) {
      dj.b(this.kz.ak());
    }
    if (paramdh.errorCode == -1) {
      return;
    }
    boolean bool;
    if (paramdh.pg.extras != null)
    {
      bool = paramdh.pg.extras.getBoolean("_noRefresh", false);
      if (!this.kz.kN.lT) {
        break label183;
      }
      dq.a(paramdh.oj);
    }
    for (;;)
    {
      if ((paramdh.errorCode == 3) && (paramdh.qt != null) && (paramdh.qt.ng != null))
      {
        dw.v("Pinging no fill URLs.");
        bo.a(this.kz.kI, this.kz.kK.rq, paramdh, this.kz.kH, false, paramdh.qt.ng);
      }
      if (paramdh.errorCode == -2) {
        break label284;
      }
      a(paramdh.errorCode);
      return;
      bool = false;
      break;
      label183:
      if (!bool) {
        if (paramdh.ni > 0L) {
          this.kA.a(paramdh.pg, paramdh.ni);
        } else if ((paramdh.qt != null) && (paramdh.qt.ni > 0L)) {
          this.kA.a(paramdh.pg, paramdh.qt.ni);
        } else if ((!paramdh.po) && (paramdh.errorCode == 2)) {
          this.kA.d(paramdh.pg);
        }
      }
    }
    label284:
    if (!this.kz.kN.lT)
    {
      if (!b(paramdh))
      {
        a(0);
        return;
      }
      if (this.kz.kG != null) {
        a.a(this.kz.kG).t(paramdh.pt);
      }
    }
    if ((this.kz.kO != null) && (this.kz.kO.nA != null)) {
      this.kz.kO.nA.a(null);
    }
    if (paramdh.nA != null) {
      paramdh.nA.a(this);
    }
    this.kB.d(this.kz.kO);
    this.kz.kO = paramdh;
    if (paramdh.qu != null) {
      this.kz.kN = paramdh.qu;
    }
    this.kz.kP.h(paramdh.qv);
    this.kz.kP.i(paramdh.qw);
    this.kz.kP.m(this.kz.kN.lT);
    this.kz.kP.n(paramdh.po);
    if (!this.kz.kN.lT) {
      b(false);
    }
    if (this.kz.kS == null) {
      this.kz.kS = new dm(this.kz.kH);
    }
    int i;
    if (paramdh.qt != null)
    {
      i = paramdh.qt.nj;
      j = paramdh.qt.nk;
    }
    for (;;)
    {
      this.kz.kS.a(i, j);
      if ((!this.kz.kN.lT) && (paramdh.oj != null) && ((paramdh.oj.bI().bP()) || (paramdh.qs != null)))
      {
        ab localab = this.kB.a(this.kz.kN, this.kz.kO);
        if ((paramdh.oj.bI().bP()) && (localab != null)) {
          localab.a(new w(paramdh.oj));
        }
      }
      this.kz.kO.oj.bE();
      ag();
      return;
      i = 0;
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    if (this.kz.kR == null)
    {
      dw.z("InAppPurchaseListener is not set");
      return;
    }
    try
    {
      this.kz.kR.a(new cm(paramString, paramArrayList, this.kz.kI, this.kz.kK.rq));
      return;
    }
    catch (RemoteException paramString)
    {
      dw.z("Could not start In-App purchase.");
    }
  }
  
  public void a(HashSet<di> paramHashSet)
  {
    this.kz.a(paramHashSet);
  }
  
  public boolean a(ah paramah)
  {
    fq.aj("loadAd must be called on the main UI thread.");
    if (this.kz.kM != null) {
      dw.z("An ad request is already in progress. Aborting.");
    }
    do
    {
      return false;
      if ((this.kz.kN.lT) && (this.kz.kO != null))
      {
        dw.z("An interstitial is already loading. Aborting.");
        return false;
      }
    } while (!ah());
    dw.x("Starting ad request.");
    this.kA.cancel();
    cx.a locala = c(paramah);
    if (this.kz.kN.lT)
    {
      paramah = dz.a(this.kz.kI, this.kz.kN, false, false, this.kz.kJ, this.kz.kK);
      paramah.bI().a(this, null, this, this, true, this);
      this.kz.kM = cr.a(this.kz.kI, locala, this.kz.kJ, paramah, this.ky, this);
      return true;
    }
    paramah = this.kz.kG.getNextView();
    if ((paramah instanceof dz))
    {
      paramah = (dz)paramah;
      paramah.a(this.kz.kI, this.kz.kN);
    }
    for (;;)
    {
      paramah.bI().a(this, this, this, this, false, this);
      break;
      if (paramah != null) {
        this.kz.kG.removeView(paramah);
      }
      dz localdz = dz.a(this.kz.kI, this.kz.kN, false, false, this.kz.kJ, this.kz.kK);
      paramah = localdz;
      if (this.kz.kN.lU == null)
      {
        b(localdz);
        paramah = localdz;
      }
    }
  }
  
  public void aa()
  {
    W();
  }
  
  public void ab()
  {
    if (this.kz.kO != null) {
      dw.z("Mediation adapter " + this.kz.kO.nz + " refreshed, but mediation adapters should never refresh.");
    }
    b(true);
    ag();
  }
  
  public void ac()
  {
    fq.aj("recordManualImpression must be called on the main UI thread.");
    if (this.kz.kO == null) {
      dw.z("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      dw.v("Pinging manual tracking URLs.");
    } while (this.kz.kO.pq == null);
    dq.a(this.kz.kI, this.kz.kK.rq, this.kz.kO.pq);
  }
  
  public void b(ah paramah)
  {
    ViewParent localViewParent = this.kz.kG.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (dq.by()) && (!this.kC))
    {
      a(paramah);
      return;
    }
    dw.x("Ad is not visible. Not refreshing ad.");
    this.kA.d(paramah);
  }
  
  public void destroy()
  {
    fq.aj("destroy must be called on the main UI thread.");
    T();
    this.kz.kL = null;
    this.kz.kQ = null;
    this.kA.cancel();
    stopLoading();
    if (this.kz.kG != null) {
      this.kz.kG.removeAllViews();
    }
    if ((this.kz.kO != null) && (this.kz.kO.oj != null)) {
      this.kz.kO.oj.destroy();
    }
    if ((this.kz.kO != null) && (this.kz.kO.ny != null)) {}
    try
    {
      this.kz.kO.ny.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dw.z("Could not destroy mediation adapter.");
    }
  }
  
  public boolean isReady()
  {
    fq.aj("isLoaded must be called on the main UI thread.");
    return (this.kz.kM == null) && (this.kz.kO != null);
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.kz.kQ != null) {}
    try
    {
      this.kz.kQ.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      dw.c("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    fq.aj("pause must be called on the main UI thread.");
    if (this.kz.kO != null) {
      dq.a(this.kz.kO.oj);
    }
    if ((this.kz.kO != null) && (this.kz.kO.ny != null)) {}
    try
    {
      this.kz.kO.ny.pause();
      this.kA.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        dw.z("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    fq.aj("resume must be called on the main UI thread.");
    if (this.kz.kO != null) {
      dq.b(this.kz.kO.oj);
    }
    if ((this.kz.kO != null) && (this.kz.kO.ny != null)) {}
    try
    {
      this.kz.kO.ny.resume();
      this.kA.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        dw.z("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    fq.aj("showInterstitial must be called on the main UI thread.");
    if (!this.kz.kN.lT)
    {
      dw.z("Cannot call showInterstitial on a banner ad.");
      return;
    }
    if (this.kz.kO == null)
    {
      dw.z("The interstitial has not loaded.");
      return;
    }
    if (this.kz.kO.oj.bL())
    {
      dw.z("The interstitial is already showing.");
      return;
    }
    this.kz.kO.oj.p(true);
    if ((this.kz.kO.oj.bI().bP()) || (this.kz.kO.qs != null))
    {
      ab localab = this.kB.a(this.kz.kN, this.kz.kO);
      if ((this.kz.kO.oj.bI().bP()) && (localab != null)) {
        localab.a(new w(this.kz.kO.oj));
      }
    }
    if (this.kz.kO.po) {
      try
      {
        this.kz.kO.ny.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        dw.c("Could not show interstitial.", localRemoteException);
        aj();
        return;
      }
    }
    ce localce = new ce(this, this, this, this.kz.kO.oj, this.kz.kO.orientation, this.kz.kK, this.kz.kO.pt);
    cc.a(this.kz.kI, localce);
  }
  
  public void stopLoading()
  {
    fq.aj("stopLoading must be called on the main UI thread.");
    if (this.kz.kO != null)
    {
      this.kz.kO.oj.stopLoading();
      this.kz.kO = null;
    }
    if (this.kz.kM != null) {
      this.kz.kM.cancel();
    }
  }
  
  private static final class a
    extends ViewSwitcher
  {
    private final dr kF;
    
    public a(Context paramContext)
    {
      super();
      this.kF = new dr(paramContext);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.kF.c(paramMotionEvent);
      return false;
    }
  }
  
  private static final class b
  {
    public final v.a kG;
    public final String kH;
    public final Context kI;
    public final l kJ;
    public final dx kK;
    public ao kL;
    public do kM;
    public ak kN;
    public dh kO;
    public di kP;
    public ar kQ;
    public co kR;
    public dm kS = null;
    private HashSet<di> kT = null;
    
    public b(Context paramContext, ak paramak, String paramString, dx paramdx)
    {
      if (paramak.lT) {
        this.kG = null;
      }
      for (;;)
      {
        this.kN = paramak;
        this.kH = paramString;
        this.kI = paramContext;
        this.kJ = new l(k.a(paramdx.rq, paramContext));
        this.kK = paramdx;
        return;
        this.kG = new v.a(paramContext);
        this.kG.setMinimumWidth(paramak.widthPixels);
        this.kG.setMinimumHeight(paramak.heightPixels);
        this.kG.setVisibility(4);
      }
    }
    
    public void a(HashSet<di> paramHashSet)
    {
      this.kT = paramHashSet;
    }
    
    public HashSet<di> ak()
    {
      return this.kT;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */