package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.HashSet;

public class u
  extends aq.a
  implements ba, bd, bf, bn, ci, cl, dm.a, ej, t
{
  private final bt kB;
  private final qm kC;
  private final y kD;
  private final ab kE;
  private boolean kF;
  private final ComponentCallbacks kG = new ComponentCallbacks()
  {
    public void onConfigurationChanged(Configuration paramAnonymousConfiguration)
    {
      if ((u.a(u.this) != null) && (u.a(u.this).i != null) && (u.a(u.this).i.oy != null)) {
        u.a(u.this).i.oy.bX();
      }
    }
    
    public void onLowMemory() {}
  };
  
  public u(Context paramContext, al paramal, String paramString, bt parambt, ev paramev)
  {
    this.kC = new qm(paramContext, paramal, paramString, paramev);
    this.kB = parambt;
    this.kD = new y(this);
    this.kE = new ab();
    eo.n(paramContext);
    W();
  }
  
  private void W()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kC != null) && (this.kC.c != null)) {
      this.kC.c.registerComponentCallbacks(this.kG);
    }
  }
  
  private void X()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kC != null) && (this.kC.c != null)) {
      this.kC.c.unregisterComponentCallbacks(this.kG);
    }
  }
  
  private void a(int paramInt)
  {
    eu.D("Failed to load ad: " + paramInt);
    if (this.kC.f != null) {}
    try
    {
      this.kC.f.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }
  
  private void ah()
  {
    eu.B("Ad closing.");
    if (this.kC.f != null) {}
    try
    {
      this.kC.f.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }
  
  private void ai()
  {
    eu.B("Ad leaving application.");
    if (this.kC.f != null) {}
    try
    {
      this.kC.f.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  private void aj()
  {
    eu.B("Ad opening.");
    if (this.kC.f != null) {}
    try
    {
      this.kC.f.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }
  
  private void ak()
  {
    eu.B("Ad finished loading.");
    if (this.kC.f != null) {}
    try
    {
      this.kC.f.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }
  
  private boolean al()
  {
    boolean bool = true;
    if (!eo.a(this.kC.c.getPackageManager(), this.kC.c.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.kC.h.mf) {
        et.a(this.kC.a, this.kC.h, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
      bool = false;
    }
    if (!eo.m(this.kC.c))
    {
      if (!this.kC.h.mf) {
        et.a(this.kC.a, this.kC.h, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      }
      bool = false;
    }
    if ((!bool) && (!this.kC.h.mf)) {
      this.kC.a.setVisibility(0);
    }
    return bool;
  }
  
  private void am()
  {
    if (this.kC.i == null) {
      eu.D("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      eu.z("Pinging click URLs.");
      this.kC.j.bC();
      if (this.kC.i.nt != null) {
        eo.a(this.kC.c, this.kC.e.sw, this.kC.i.nt);
      }
    } while ((this.kC.i.rz == null) || (this.kC.i.rz.nt == null));
    br.a(this.kC.c, this.kC.e.sw, this.kC.i, this.kC.b, false, this.kC.i.rz.nt);
  }
  
  private void an()
  {
    if (this.kC.i != null)
    {
      this.kC.i.oy.destroy();
      this.kC.i = null;
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.kC.a.addView(paramView, localLayoutParams);
  }
  
  /* Error */
  private boolean b(ef paramef)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 300	com/google/android/gms/internal/ef:qg	Z
    //   4: ifeq +184 -> 188
    //   7: aload_1
    //   8: getfield 304	com/google/android/gms/internal/ef:nN	Lcom/google/android/gms/internal/bu;
    //   11: invokeinterface 310 1 0
    //   16: invokestatic 315	com/google/android/gms/dynamic/e:e	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   19: checkcast 317	android/view/View
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   27: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   30: invokevirtual 321	com/google/android/gms/internal/qk:getNextView	()Landroid/view/View;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +14 -> 49
    //   38: aload_0
    //   39: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   42: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   45: aload_2
    //   46: invokevirtual 324	com/google/android/gms/internal/qk:removeView	(Landroid/view/View;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 326	com/google/android/gms/internal/u:b	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   58: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   61: invokevirtual 330	com/google/android/gms/internal/qk:getChildCount	()I
    //   64: iconst_1
    //   65: if_icmple +13 -> 78
    //   68: aload_0
    //   69: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   72: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   75: invokevirtual 333	com/google/android/gms/internal/qk:showNext	()V
    //   78: aload_0
    //   79: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   82: getfield 224	com/google/android/gms/internal/qm:i	Lcom/google/android/gms/internal/ef;
    //   85: ifnull +70 -> 155
    //   88: aload_0
    //   89: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   92: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   95: invokevirtual 321	com/google/android/gms/internal/qk:getNextView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_1
    //   100: instanceof 281
    //   103: ifeq +158 -> 261
    //   106: aload_1
    //   107: checkcast 281	com/google/android/gms/internal/ex
    //   110: aload_0
    //   111: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   114: getfield 85	com/google/android/gms/internal/qm:c	Landroid/content/Context;
    //   117: aload_0
    //   118: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   121: getfield 189	com/google/android/gms/internal/qm:h	Lcom/google/android/gms/internal/al;
    //   124: invokevirtual 336	com/google/android/gms/internal/ex:a	(Landroid/content/Context;Lcom/google/android/gms/internal/al;)V
    //   127: aload_0
    //   128: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   131: getfield 224	com/google/android/gms/internal/qm:i	Lcom/google/android/gms/internal/ef;
    //   134: getfield 304	com/google/android/gms/internal/ef:nN	Lcom/google/android/gms/internal/bu;
    //   137: ifnull +18 -> 155
    //   140: aload_0
    //   141: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   144: getfield 224	com/google/android/gms/internal/qm:i	Lcom/google/android/gms/internal/ef;
    //   147: getfield 304	com/google/android/gms/internal/ef:nN	Lcom/google/android/gms/internal/bu;
    //   150: invokeinterface 337 1 0
    //   155: aload_0
    //   156: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   159: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   162: iconst_0
    //   163: invokevirtual 219	com/google/android/gms/internal/qk:setVisibility	(I)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: ldc_w 339
    //   172: aload_1
    //   173: invokestatic 136	com/google/android/gms/internal/eu:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: ldc_w 341
    //   182: aload_1
    //   183: invokestatic 136	com/google/android/gms/internal/eu:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: iconst_0
    //   187: ireturn
    //   188: aload_1
    //   189: getfield 344	com/google/android/gms/internal/ef:rA	Lcom/google/android/gms/internal/al;
    //   192: ifnull -138 -> 54
    //   195: aload_1
    //   196: getfield 279	com/google/android/gms/internal/ef:oy	Lcom/google/android/gms/internal/ex;
    //   199: aload_1
    //   200: getfield 344	com/google/android/gms/internal/ef:rA	Lcom/google/android/gms/internal/al;
    //   203: invokevirtual 347	com/google/android/gms/internal/ex:a	(Lcom/google/android/gms/internal/al;)V
    //   206: aload_0
    //   207: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   210: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   213: invokevirtual 350	com/google/android/gms/internal/qk:removeAllViews	()V
    //   216: aload_0
    //   217: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   220: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   223: aload_1
    //   224: getfield 344	com/google/android/gms/internal/ef:rA	Lcom/google/android/gms/internal/al;
    //   227: getfield 353	com/google/android/gms/internal/al:widthPixels	I
    //   230: invokevirtual 356	com/google/android/gms/internal/qk:setMinimumWidth	(I)V
    //   233: aload_0
    //   234: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   237: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   240: aload_1
    //   241: getfield 344	com/google/android/gms/internal/ef:rA	Lcom/google/android/gms/internal/al;
    //   244: getfield 359	com/google/android/gms/internal/al:heightPixels	I
    //   247: invokevirtual 362	com/google/android/gms/internal/qk:setMinimumHeight	(I)V
    //   250: aload_0
    //   251: aload_1
    //   252: getfield 279	com/google/android/gms/internal/ef:oy	Lcom/google/android/gms/internal/ex;
    //   255: invokespecial 326	com/google/android/gms/internal/u:b	(Landroid/view/View;)V
    //   258: goto -204 -> 54
    //   261: aload_1
    //   262: ifnull -135 -> 127
    //   265: aload_0
    //   266: getfield 53	com/google/android/gms/internal/u:kC	Lcom/google/android/gms/internal/qm;
    //   269: getfield 197	com/google/android/gms/internal/qm:a	Lcom/google/android/gms/internal/qk;
    //   272: aload_1
    //   273: invokevirtual 324	com/google/android/gms/internal/qk:removeView	(Landroid/view/View;)V
    //   276: goto -149 -> 127
    //   279: astore_1
    //   280: ldc_w 364
    //   283: invokestatic 122	com/google/android/gms/internal/eu:D	(Ljava/lang/String;)V
    //   286: goto -131 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	u
    //   0	289	1	paramef	ef
    //   33	13	2	localView	View
    // Exception table:
    //   from	to	target	type
    //   7	23	168	android/os/RemoteException
    //   49	54	178	java/lang/Throwable
    //   140	155	279	android/os/RemoteException
  }
  
  private ds.a c(ai paramai)
  {
    ApplicationInfo localApplicationInfo = this.kC.c.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo = this.kC.c.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      if ((!this.kC.h.mf) && (this.kC.a.getParent() != null))
      {
        localObject2 = new int[2];
        this.kC.a.getLocationOnScreen((int[])localObject2);
        int j = localObject2[0];
        int k = localObject2[1];
        localObject2 = this.kC.c.getResources().getDisplayMetrics();
        int m = this.kC.a.getWidth();
        int n = this.kC.a.getHeight();
        if ((this.kC.a.isShown()) && (j + m > 0) && (k + n > 0) && (j <= ((DisplayMetrics)localObject2).widthPixels) && (k <= ((DisplayMetrics)localObject2).heightPixels))
        {
          i = 1;
          localObject2 = new Bundle(5);
          ((Bundle)localObject2).putInt("x", j);
          ((Bundle)localObject2).putInt("y", k);
          ((Bundle)localObject2).putInt("width", m);
          ((Bundle)localObject2).putInt("height", n);
          ((Bundle)localObject2).putInt("visible", i);
          String str = eh.bI();
          this.kC.j = new eg(str, this.kC.b);
          this.kC.j.f(paramai);
          Bundle localBundle = eh.a(this.kC.c, this, str);
          return new ds.a((Bundle)localObject2, paramai, this.kC.h, this.kC.b, localApplicationInfo, localPackageInfo, str, eh.rQ, this.kC.e, localBundle);
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
  
  private void c(boolean paramBoolean)
  {
    if (this.kC.i == null) {
      eu.D("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      eu.z("Pinging Impression URLs.");
      this.kC.j.bB();
      if (this.kC.i.nu != null) {
        eo.a(this.kC.c, this.kC.e.sw, this.kC.i.nu);
      }
      if ((this.kC.i.rz != null) && (this.kC.i.rz.nu != null)) {
        br.a(this.kC.c, this.kC.e.sw, this.kC.i, this.kC.b, paramBoolean, this.kC.i.rz.nu);
      }
    } while ((this.kC.i.nM == null) || (this.kC.i.nM.np == null));
    br.a(this.kC.c, this.kC.e.sw, this.kC.i, this.kC.b, paramBoolean, this.kC.i.nM.np);
  }
  
  public d U()
  {
    hm.ay("getAdFrame must be called on the main UI thread.");
    return e.h(this.kC.a);
  }
  
  public al V()
  {
    hm.ay("getAdSize must be called on the main UI thread.");
    return this.kC.h;
  }
  
  public void Y()
  {
    ai();
  }
  
  public void Z()
  {
    this.kE.d(this.kC.i);
    if (this.kC.h.mf) {
      an();
    }
    this.kF = false;
    ah();
    this.kC.j.bD();
  }
  
  public void a(al paramal)
  {
    hm.ay("setAdSize must be called on the main UI thread.");
    this.kC.h = paramal;
    if (this.kC.i != null) {
      this.kC.i.oy.a(paramal);
    }
    if (this.kC.a.getChildCount() > 1) {
      this.kC.a.removeView(this.kC.a.getNextView());
    }
    this.kC.a.setMinimumWidth(paramal.widthPixels);
    this.kC.a.setMinimumHeight(paramal.heightPixels);
    this.kC.a.requestLayout();
  }
  
  public void a(ap paramap)
  {
    hm.ay("setAdListener must be called on the main UI thread.");
    this.kC.f = paramap;
  }
  
  public void a(as paramas)
  {
    hm.ay("setAppEventListener must be called on the main UI thread.");
    this.kC.k = paramas;
  }
  
  public void a(dc paramdc)
  {
    hm.ay("setInAppPurchaseListener must be called on the main UI thread.");
    this.kC.m = paramdc;
  }
  
  public void a(dg paramdg, String paramString)
  {
    hm.ay("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.kC.n = new cz(paramString);
    this.kC.l = paramdg;
    if ((!eh.bM()) && (paramdg != null)) {
      new cs(this.kC.c, this.kC.l, this.kC.n).start();
    }
  }
  
  public void a(ef paramef)
  {
    int j = 0;
    this.kC.g = null;
    if ((paramef.errorCode != -2) && (paramef.errorCode != 3)) {
      eh.b(this.kC.a());
    }
    if (paramef.errorCode == -1) {
      return;
    }
    boolean bool;
    if (paramef.pX.extras != null)
    {
      bool = paramef.pX.extras.getBoolean("_noRefresh", false);
      if (!this.kC.h.mf) {
        break label183;
      }
      eo.a(paramef.oy);
    }
    for (;;)
    {
      if ((paramef.errorCode == 3) && (paramef.rz != null) && (paramef.rz.nv != null))
      {
        eu.z("Pinging no fill URLs.");
        br.a(this.kC.c, this.kC.e.sw, paramef, this.kC.b, false, paramef.rz.nv);
      }
      if (paramef.errorCode == -2) {
        break label284;
      }
      a(paramef.errorCode);
      return;
      bool = false;
      break;
      label183:
      if (!bool) {
        if (paramef.nx > 0L) {
          this.kD.a(paramef.pX, paramef.nx);
        } else if ((paramef.rz != null) && (paramef.rz.nx > 0L)) {
          this.kD.a(paramef.pX, paramef.rz.nx);
        } else if ((!paramef.qg) && (paramef.errorCode == 2)) {
          this.kD.d(paramef.pX);
        }
      }
    }
    label284:
    if (!this.kC.h.mf)
    {
      if (!b(paramef))
      {
        a(0);
        return;
      }
      if (this.kC.a != null) {
        qk.a(this.kC.a).x(paramef.ql);
      }
    }
    if ((this.kC.i != null) && (this.kC.i.nP != null)) {
      this.kC.i.nP.a(null);
    }
    if (paramef.nP != null) {
      paramef.nP.a(this);
    }
    this.kE.d(this.kC.i);
    this.kC.i = paramef;
    if (paramef.rA != null) {
      this.kC.h = paramef.rA;
    }
    this.kC.j.j(paramef.rB);
    this.kC.j.k(paramef.rC);
    this.kC.j.n(this.kC.h.mf);
    this.kC.j.o(paramef.qg);
    if (!this.kC.h.mf) {
      c(false);
    }
    if (this.kC.o == null) {
      this.kC.o = new ek(this.kC.b);
    }
    int i;
    if (paramef.rz != null)
    {
      i = paramef.rz.ny;
      j = paramef.rz.nz;
    }
    for (;;)
    {
      this.kC.o.a(i, j);
      if ((!this.kC.h.mf) && (paramef.oy != null) && ((paramef.oy.cb().cj()) || (paramef.ry != null)))
      {
        ac localac = this.kE.a(this.kC.h, this.kC.i);
        if ((paramef.oy.cb().cj()) && (localac != null)) {
          localac.a(new qn(paramef.oy));
        }
      }
      this.kC.i.oy.bX();
      ak();
      return;
      i = 0;
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = new ct(paramString, paramArrayList, this.kC.c, this.kC.e.sw);
    if (this.kC.m == null)
    {
      eu.D("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.kC.c) != 0) {
        eu.D("Google Play Service unavailable, cannot launch default purchase flow.");
      }
      for (;;)
      {
        return;
        if (this.kC.l == null)
        {
          eu.D("PlayStorePurchaseListener is not set.");
          return;
        }
        if (this.kC.n == null)
        {
          eu.D("PlayStorePurchaseVerifier is not initialized.");
          return;
        }
        try
        {
          boolean bool = this.kC.l.isValidPurchase(paramString);
          if (!bool) {}
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            eu.D("Could not start In-App purchase.");
          }
        }
      }
      cu.a(this.kC.c, this.kC.e.sz, new cq(paramArrayList, this.kC.l, this.kC.n, this.kC.c));
      return;
    }
    try
    {
      this.kC.m.a(paramArrayList);
      return;
    }
    catch (RemoteException paramString)
    {
      eu.D("Could not start In-App purchase.");
    }
  }
  
  public void a(HashSet<eg> paramHashSet)
  {
    this.kC.a(paramHashSet);
  }
  
  public boolean a(ai paramai)
  {
    hm.ay("loadAd must be called on the main UI thread.");
    if (this.kC.g != null) {
      eu.D("An ad request is already in progress. Aborting.");
    }
    do
    {
      return false;
      if ((this.kC.h.mf) && (this.kC.i != null))
      {
        eu.D("An interstitial is already loading. Aborting.");
        return false;
      }
    } while (!al());
    eu.B("Starting ad request.");
    if (!paramai.lV) {
      eu.B("Use AdRequest.Builder.addTestDevice(\"" + et.r(this.kC.c) + "\") to get test ads on this device.");
    }
    this.kD.cancel();
    this.kC.p = false;
    ds.a locala = c(paramai);
    if (this.kC.h.mf)
    {
      paramai = ex.a(this.kC.c, this.kC.h, false, false, this.kC.d, this.kC.e);
      paramai.cb().a(this, null, this, this, true, this, this);
      this.kC.g = dm.a(this.kC.c, locala, this.kC.d, paramai, this.kB, this);
      return true;
    }
    paramai = this.kC.a.getNextView();
    if ((paramai instanceof ex))
    {
      paramai = (ex)paramai;
      paramai.a(this.kC.c, this.kC.h);
    }
    for (;;)
    {
      paramai.cb().a(this, this, this, this, false, this);
      break;
      if (paramai != null) {
        this.kC.a.removeView(paramai);
      }
      ex localex = ex.a(this.kC.c, this.kC.h, false, false, this.kC.d, this.kC.e);
      paramai = localex;
      if (this.kC.h.mg == null)
      {
        b(localex);
        paramai = localex;
      }
    }
  }
  
  public void aa()
  {
    if (this.kC.h.mf) {
      c(false);
    }
    this.kF = true;
    aj();
  }
  
  public void ab()
  {
    onAdClicked();
  }
  
  public void ac()
  {
    Z();
  }
  
  public void ad()
  {
    Y();
  }
  
  public void ae()
  {
    aa();
  }
  
  public void af()
  {
    if (this.kC.i != null) {
      eu.D("Mediation adapter " + this.kC.i.nO + " refreshed, but mediation adapters should never refresh.");
    }
    c(true);
    ak();
  }
  
  public void ag()
  {
    hm.ay("recordManualImpression must be called on the main UI thread.");
    if (this.kC.i == null) {
      eu.D("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      eu.z("Pinging manual tracking URLs.");
    } while (this.kC.i.qi == null);
    eo.a(this.kC.c, this.kC.e.sw, this.kC.i.qi);
  }
  
  public void b(ai paramai)
  {
    ViewParent localViewParent = this.kC.a.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (eo.bQ()) && (!this.kF))
    {
      a(paramai);
      return;
    }
    eu.B("Ad is not visible. Not refreshing ad.");
    this.kD.d(paramai);
  }
  
  public void b(boolean paramBoolean)
  {
    this.kC.p = paramBoolean;
  }
  
  public void destroy()
  {
    hm.ay("destroy must be called on the main UI thread.");
    X();
    this.kC.f = null;
    this.kC.k = null;
    this.kD.cancel();
    this.kE.stop();
    stopLoading();
    if (this.kC.a != null) {
      this.kC.a.removeAllViews();
    }
    if ((this.kC.i != null) && (this.kC.i.oy != null)) {
      this.kC.i.oy.destroy();
    }
    if ((this.kC.i != null) && (this.kC.i.nN != null)) {}
    try
    {
      this.kC.i.nN.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.D("Could not destroy mediation adapter.");
    }
  }
  
  public boolean isReady()
  {
    hm.ay("isLoaded must be called on the main UI thread.");
    return (this.kC.g == null) && (this.kC.i != null);
  }
  
  public void onAdClicked()
  {
    am();
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.kC.k != null) {}
    try
    {
      this.kC.k.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      eu.c("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    hm.ay("pause must be called on the main UI thread.");
    if (this.kC.i != null) {
      eo.a(this.kC.i.oy);
    }
    if ((this.kC.i != null) && (this.kC.i.nN != null)) {}
    try
    {
      this.kC.i.nN.pause();
      this.kE.pause();
      this.kD.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        eu.D("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    hm.ay("resume must be called on the main UI thread.");
    if (this.kC.i != null) {
      eo.b(this.kC.i.oy);
    }
    if ((this.kC.i != null) && (this.kC.i.nN != null)) {}
    try
    {
      this.kC.i.nN.resume();
      this.kD.resume();
      this.kE.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        eu.D("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    hm.ay("showInterstitial must be called on the main UI thread.");
    if (!this.kC.h.mf)
    {
      eu.D("Cannot call showInterstitial on a banner ad.");
      return;
    }
    if (this.kC.i == null)
    {
      eu.D("The interstitial has not loaded.");
      return;
    }
    if (this.kC.i.oy.ce())
    {
      eu.D("The interstitial is already showing.");
      return;
    }
    this.kC.i.oy.q(true);
    if ((this.kC.i.oy.cb().cj()) || (this.kC.i.ry != null))
    {
      ac localac = this.kE.a(this.kC.h, this.kC.i);
      if ((this.kC.i.oy.cb().cj()) && (localac != null)) {
        localac.a(new qn(this.kC.i.oy));
      }
    }
    if (this.kC.i.qg) {
      try
      {
        this.kC.i.nN.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        eu.c("Could not show interstitial.", localRemoteException);
        an();
        return;
      }
    }
    v localv = new v(this.kC.p, false);
    Object localObject = localv;
    boolean bool2;
    if ((this.kC.c instanceof Activity))
    {
      localObject = ((Activity)this.kC.c).getWindow();
      Rect localRect1 = new Rect();
      Rect localRect2 = new Rect();
      ((Window)localObject).getDecorView().getGlobalVisibleRect(localRect1);
      ((Window)localObject).getDecorView().getWindowVisibleDisplayFrame(localRect2);
      localObject = localv;
      if (localRect1.bottom != 0)
      {
        localObject = localv;
        if (localRect2.bottom != 0)
        {
          bool2 = this.kC.p;
          if (localRect1.top != localRect2.top) {
            break label420;
          }
        }
      }
    }
    label420:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = new v(bool2, bool1);
      localObject = new ch(this, this, this, this.kC.i.oy, this.kC.i.orientation, this.kC.e, this.kC.i.ql, (v)localObject);
      cf.a(this.kC.c, (ch)localObject);
      return;
    }
  }
  
  public void stopLoading()
  {
    hm.ay("stopLoading must be called on the main UI thread.");
    if (this.kC.i != null)
    {
      this.kC.i.oy.stopLoading();
      this.kC.i = null;
    }
    if (this.kC.g != null) {
      this.kC.g.cancel();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */