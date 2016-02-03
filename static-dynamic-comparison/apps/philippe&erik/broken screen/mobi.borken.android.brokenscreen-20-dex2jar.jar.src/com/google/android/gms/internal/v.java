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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class v
  extends ar.a
  implements bb, be, bg, bo, cj, cm, dn.a, ek, u
{
  private final c kA;
  private final z kB;
  private final ac kC;
  private boolean kD;
  private final ComponentCallbacks kE = new ComponentCallbacks()
  {
    public void onConfigurationChanged(Configuration paramAnonymousConfiguration)
    {
      if ((v.a(v.this) != null) && (v.a(v.this).kS != null) && (v.a(v.this).kS.ow != null)) {
        v.a(v.this).kS.ow.bS();
      }
    }
    
    public void onLowMemory() {}
  };
  private final bu kz;
  
  public v(Context paramContext, am paramam, String paramString, bu parambu, ew paramew)
  {
    this.kA = new c(paramContext, paramam, paramString, paramew);
    this.kz = parambu;
    this.kB = new z(this);
    this.kC = new ac();
    ep.k(paramContext);
    R();
  }
  
  private void R()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kA != null) && (this.kA.kM != null)) {
      this.kA.kM.registerComponentCallbacks(this.kE);
    }
  }
  
  private void S()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kA != null) && (this.kA.kM != null)) {
      this.kA.kM.unregisterComponentCallbacks(this.kE);
    }
  }
  
  private void a(int paramInt)
  {
    ev.D("Failed to load ad: " + paramInt);
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }
  
  private void ac()
  {
    ev.B("Ad closing.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }
  
  private void ad()
  {
    ev.B("Ad leaving application.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  private void ae()
  {
    ev.B("Ad opening.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }
  
  private void af()
  {
    ev.B("Ad finished loading.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }
  
  private boolean ag()
  {
    boolean bool = true;
    if (!ep.a(this.kA.kM.getPackageManager(), this.kA.kM.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.kA.kR.md) {
        eu.a(this.kA.kK, this.kA.kR, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
      bool = false;
    }
    if (!ep.j(this.kA.kM))
    {
      if (!this.kA.kR.md) {
        eu.a(this.kA.kK, this.kA.kR, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      }
      bool = false;
    }
    if ((!bool) && (!this.kA.kR.md)) {
      this.kA.kK.setVisibility(0);
    }
    return bool;
  }
  
  private void ah()
  {
    if (this.kA.kS == null) {
      ev.D("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      ev.z("Pinging click URLs.");
      this.kA.kT.bx();
      if (this.kA.kS.nr != null) {
        ep.a(this.kA.kM, this.kA.kO.st, this.kA.kS.nr);
      }
    } while ((this.kA.kS.rw == null) || (this.kA.kS.rw.nr == null));
    bs.a(this.kA.kM, this.kA.kO.st, this.kA.kS, this.kA.kL, false, this.kA.kS.rw.nr);
  }
  
  private void ai()
  {
    if (this.kA.kS != null)
    {
      this.kA.kS.ow.destroy();
      this.kA.kS = null;
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.kA.kK.addView(paramView, localLayoutParams);
  }
  
  /* Error */
  private boolean b(eg parameg)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 305	com/google/android/gms/internal/eg:qd	Z
    //   4: ifeq +184 -> 188
    //   7: aload_1
    //   8: getfield 309	com/google/android/gms/internal/eg:nL	Lcom/google/android/gms/internal/bv;
    //   11: invokeinterface 315 1 0
    //   16: invokestatic 321	com/google/android/gms/dynamic/e:e	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   19: checkcast 323	android/view/View
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   27: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   30: invokevirtual 327	com/google/android/gms/internal/v$a:getNextView	()Landroid/view/View;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +14 -> 49
    //   38: aload_0
    //   39: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   42: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   45: aload_2
    //   46: invokevirtual 330	com/google/android/gms/internal/v$a:removeView	(Landroid/view/View;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 332	com/google/android/gms/internal/v:b	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   58: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   61: invokevirtual 336	com/google/android/gms/internal/v$a:getChildCount	()I
    //   64: iconst_1
    //   65: if_icmple +13 -> 78
    //   68: aload_0
    //   69: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   72: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   75: invokevirtual 339	com/google/android/gms/internal/v$a:showNext	()V
    //   78: aload_0
    //   79: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   82: getfield 229	com/google/android/gms/internal/v$c:kS	Lcom/google/android/gms/internal/eg;
    //   85: ifnull +70 -> 155
    //   88: aload_0
    //   89: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   92: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   95: invokevirtual 327	com/google/android/gms/internal/v$a:getNextView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_1
    //   100: instanceof 286
    //   103: ifeq +158 -> 261
    //   106: aload_1
    //   107: checkcast 286	com/google/android/gms/internal/ey
    //   110: aload_0
    //   111: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   114: getfield 92	com/google/android/gms/internal/v$c:kM	Landroid/content/Context;
    //   117: aload_0
    //   118: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   121: getfield 195	com/google/android/gms/internal/v$c:kR	Lcom/google/android/gms/internal/am;
    //   124: invokevirtual 342	com/google/android/gms/internal/ey:a	(Landroid/content/Context;Lcom/google/android/gms/internal/am;)V
    //   127: aload_0
    //   128: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   131: getfield 229	com/google/android/gms/internal/v$c:kS	Lcom/google/android/gms/internal/eg;
    //   134: getfield 309	com/google/android/gms/internal/eg:nL	Lcom/google/android/gms/internal/bv;
    //   137: ifnull +18 -> 155
    //   140: aload_0
    //   141: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   144: getfield 229	com/google/android/gms/internal/v$c:kS	Lcom/google/android/gms/internal/eg;
    //   147: getfield 309	com/google/android/gms/internal/eg:nL	Lcom/google/android/gms/internal/bv;
    //   150: invokeinterface 343 1 0
    //   155: aload_0
    //   156: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   159: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   162: iconst_0
    //   163: invokevirtual 224	com/google/android/gms/internal/v$a:setVisibility	(I)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: ldc_w 345
    //   172: aload_1
    //   173: invokestatic 142	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: ldc_w 347
    //   182: aload_1
    //   183: invokestatic 142	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: iconst_0
    //   187: ireturn
    //   188: aload_1
    //   189: getfield 350	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   192: ifnull -138 -> 54
    //   195: aload_1
    //   196: getfield 284	com/google/android/gms/internal/eg:ow	Lcom/google/android/gms/internal/ey;
    //   199: aload_1
    //   200: getfield 350	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   203: invokevirtual 353	com/google/android/gms/internal/ey:a	(Lcom/google/android/gms/internal/am;)V
    //   206: aload_0
    //   207: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   210: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   213: invokevirtual 356	com/google/android/gms/internal/v$a:removeAllViews	()V
    //   216: aload_0
    //   217: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   220: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   223: aload_1
    //   224: getfield 350	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   227: getfield 359	com/google/android/gms/internal/am:widthPixels	I
    //   230: invokevirtual 362	com/google/android/gms/internal/v$a:setMinimumWidth	(I)V
    //   233: aload_0
    //   234: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   237: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   240: aload_1
    //   241: getfield 350	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   244: getfield 365	com/google/android/gms/internal/am:heightPixels	I
    //   247: invokevirtual 368	com/google/android/gms/internal/v$a:setMinimumHeight	(I)V
    //   250: aload_0
    //   251: aload_1
    //   252: getfield 284	com/google/android/gms/internal/eg:ow	Lcom/google/android/gms/internal/ey;
    //   255: invokespecial 332	com/google/android/gms/internal/v:b	(Landroid/view/View;)V
    //   258: goto -204 -> 54
    //   261: aload_1
    //   262: ifnull -135 -> 127
    //   265: aload_0
    //   266: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   269: getfield 204	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   272: aload_1
    //   273: invokevirtual 330	com/google/android/gms/internal/v$a:removeView	(Landroid/view/View;)V
    //   276: goto -149 -> 127
    //   279: astore_1
    //   280: ldc_w 370
    //   283: invokestatic 128	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   286: goto -131 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	v
    //   0	289	1	parameg	eg
    //   33	13	2	localView	View
    // Exception table:
    //   from	to	target	type
    //   7	23	168	android/os/RemoteException
    //   49	54	178	java/lang/Throwable
    //   140	155	279	android/os/RemoteException
  }
  
  private dt.a c(aj paramaj)
  {
    ApplicationInfo localApplicationInfo = this.kA.kM.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo = this.kA.kM.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      if ((!this.kA.kR.md) && (this.kA.kK.getParent() != null))
      {
        localObject2 = new int[2];
        this.kA.kK.getLocationOnScreen((int[])localObject2);
        int j = localObject2[0];
        int k = localObject2[1];
        localObject2 = this.kA.kM.getResources().getDisplayMetrics();
        int m = this.kA.kK.getWidth();
        int n = this.kA.kK.getHeight();
        if ((this.kA.kK.isShown()) && (j + m > 0) && (k + n > 0) && (j <= ((DisplayMetrics)localObject2).widthPixels) && (k <= ((DisplayMetrics)localObject2).heightPixels))
        {
          i = 1;
          localObject2 = new Bundle(5);
          ((Bundle)localObject2).putInt("x", j);
          ((Bundle)localObject2).putInt("y", k);
          ((Bundle)localObject2).putInt("width", m);
          ((Bundle)localObject2).putInt("height", n);
          ((Bundle)localObject2).putInt("visible", i);
          String str = ei.bD();
          this.kA.kT = new eh(str, this.kA.kL);
          this.kA.kT.f(paramaj);
          Bundle localBundle = ei.a(this.kA.kM, this, str);
          return new dt.a((Bundle)localObject2, paramaj, this.kA.kR, this.kA.kL, localApplicationInfo, localPackageInfo, str, ei.rN, this.kA.kO, localBundle);
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
    if (this.kA.kS == null) {
      ev.D("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      ev.z("Pinging Impression URLs.");
      this.kA.kT.bw();
      if (this.kA.kS.ns != null) {
        ep.a(this.kA.kM, this.kA.kO.st, this.kA.kS.ns);
      }
      if ((this.kA.kS.rw != null) && (this.kA.kS.rw.ns != null)) {
        bs.a(this.kA.kM, this.kA.kO.st, this.kA.kS, this.kA.kL, paramBoolean, this.kA.kS.rw.ns);
      }
    } while ((this.kA.kS.nK == null) || (this.kA.kS.nK.nn == null));
    bs.a(this.kA.kM, this.kA.kO.st, this.kA.kS, this.kA.kL, paramBoolean, this.kA.kS.nK.nn);
  }
  
  public d P()
  {
    hn.ay("getAdFrame must be called on the main UI thread.");
    return e.h(this.kA.kK);
  }
  
  public am Q()
  {
    hn.ay("getAdSize must be called on the main UI thread.");
    return this.kA.kR;
  }
  
  public void T()
  {
    ad();
  }
  
  public void U()
  {
    this.kC.d(this.kA.kS);
    if (this.kA.kR.md) {
      ai();
    }
    this.kD = false;
    ac();
    this.kA.kT.by();
  }
  
  public void V()
  {
    if (this.kA.kR.md) {
      c(false);
    }
    this.kD = true;
    ae();
  }
  
  public void W()
  {
    onAdClicked();
  }
  
  public void X()
  {
    U();
  }
  
  public void Y()
  {
    T();
  }
  
  public void Z()
  {
    V();
  }
  
  public void a(am paramam)
  {
    hn.ay("setAdSize must be called on the main UI thread.");
    this.kA.kR = paramam;
    if (this.kA.kS != null) {
      this.kA.kS.ow.a(paramam);
    }
    if (this.kA.kK.getChildCount() > 1) {
      this.kA.kK.removeView(this.kA.kK.getNextView());
    }
    this.kA.kK.setMinimumWidth(paramam.widthPixels);
    this.kA.kK.setMinimumHeight(paramam.heightPixels);
    this.kA.kK.requestLayout();
  }
  
  public void a(aq paramaq)
  {
    hn.ay("setAdListener must be called on the main UI thread.");
    this.kA.kP = paramaq;
  }
  
  public void a(at paramat)
  {
    hn.ay("setAppEventListener must be called on the main UI thread.");
    this.kA.kU = paramat;
  }
  
  public void a(dd paramdd)
  {
    hn.ay("setInAppPurchaseListener must be called on the main UI thread.");
    this.kA.kW = paramdd;
  }
  
  public void a(dh paramdh, String paramString)
  {
    hn.ay("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.kA.kX = new da(paramString);
    this.kA.kV = paramdh;
    if ((!ei.bH()) && (paramdh != null)) {
      new ct(this.kA.kM, this.kA.kV, this.kA.kX).start();
    }
  }
  
  public void a(eg parameg)
  {
    int j = 0;
    this.kA.kQ = null;
    if ((parameg.errorCode != -2) && (parameg.errorCode != 3)) {
      ei.b(this.kA.al());
    }
    if (parameg.errorCode == -1) {
      return;
    }
    boolean bool;
    if (parameg.pV.extras != null)
    {
      bool = parameg.pV.extras.getBoolean("_noRefresh", false);
      if (!this.kA.kR.md) {
        break label183;
      }
      ep.a(parameg.ow);
    }
    for (;;)
    {
      if ((parameg.errorCode == 3) && (parameg.rw != null) && (parameg.rw.nt != null))
      {
        ev.z("Pinging no fill URLs.");
        bs.a(this.kA.kM, this.kA.kO.st, parameg, this.kA.kL, false, parameg.rw.nt);
      }
      if (parameg.errorCode == -2) {
        break label284;
      }
      a(parameg.errorCode);
      return;
      bool = false;
      break;
      label183:
      if (!bool) {
        if (parameg.nv > 0L) {
          this.kB.a(parameg.pV, parameg.nv);
        } else if ((parameg.rw != null) && (parameg.rw.nv > 0L)) {
          this.kB.a(parameg.pV, parameg.rw.nv);
        } else if ((!parameg.qd) && (parameg.errorCode == 2)) {
          this.kB.d(parameg.pV);
        }
      }
    }
    label284:
    if (!this.kA.kR.md)
    {
      if (!b(parameg))
      {
        a(0);
        return;
      }
      if (this.kA.kK != null) {
        a.a(this.kA.kK).x(parameg.qi);
      }
    }
    if ((this.kA.kS != null) && (this.kA.kS.nN != null)) {
      this.kA.kS.nN.a(null);
    }
    if (parameg.nN != null) {
      parameg.nN.a(this);
    }
    this.kC.d(this.kA.kS);
    this.kA.kS = parameg;
    if (parameg.rx != null) {
      this.kA.kR = parameg.rx;
    }
    this.kA.kT.j(parameg.ry);
    this.kA.kT.k(parameg.rz);
    this.kA.kT.n(this.kA.kR.md);
    this.kA.kT.o(parameg.qd);
    if (!this.kA.kR.md) {
      c(false);
    }
    if (this.kA.kY == null) {
      this.kA.kY = new el(this.kA.kL);
    }
    int i;
    if (parameg.rw != null)
    {
      i = parameg.rw.nw;
      j = parameg.rw.nx;
    }
    for (;;)
    {
      this.kA.kY.a(i, j);
      if ((!this.kA.kR.md) && (parameg.ow != null) && ((parameg.ow.bW().ce()) || (parameg.rv != null)))
      {
        ad localad = this.kC.a(this.kA.kR, this.kA.kS);
        if ((parameg.ow.bW().ce()) && (localad != null)) {
          localad.a(new y(parameg.ow));
        }
      }
      this.kA.kS.ow.bS();
      af();
      return;
      i = 0;
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = new cu(paramString, paramArrayList, this.kA.kM, this.kA.kO.st);
    if (this.kA.kW == null)
    {
      ev.D("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.kA.kM) != 0) {
        ev.D("Google Play Service unavailable, cannot launch default purchase flow.");
      }
      for (;;)
      {
        return;
        if (this.kA.kV == null)
        {
          ev.D("PlayStorePurchaseListener is not set.");
          return;
        }
        if (this.kA.kX == null)
        {
          ev.D("PlayStorePurchaseVerifier is not initialized.");
          return;
        }
        try
        {
          boolean bool = this.kA.kV.isValidPurchase(paramString);
          if (!bool) {}
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            ev.D("Could not start In-App purchase.");
          }
        }
      }
      cv.a(this.kA.kM, this.kA.kO.sw, new cr(paramArrayList, this.kA.kV, this.kA.kX, this.kA.kM));
      return;
    }
    try
    {
      this.kA.kW.a(paramArrayList);
      return;
    }
    catch (RemoteException paramString)
    {
      ev.D("Could not start In-App purchase.");
    }
  }
  
  public void a(HashSet<eh> paramHashSet)
  {
    this.kA.a(paramHashSet);
  }
  
  public boolean a(aj paramaj)
  {
    hn.ay("loadAd must be called on the main UI thread.");
    if (this.kA.kQ != null) {
      ev.D("An ad request is already in progress. Aborting.");
    }
    do
    {
      return false;
      if ((this.kA.kR.md) && (this.kA.kS != null))
      {
        ev.D("An interstitial is already loading. Aborting.");
        return false;
      }
    } while (!ag());
    ev.B("Starting ad request.");
    if (!paramaj.lT) {
      ev.B("Use AdRequest.Builder.addTestDevice(\"" + eu.o(this.kA.kM) + "\") to get test ads on this device.");
    }
    this.kB.cancel();
    this.kA.kZ = false;
    dt.a locala = c(paramaj);
    if (this.kA.kR.md)
    {
      paramaj = ey.a(this.kA.kM, this.kA.kR, false, false, this.kA.kN, this.kA.kO);
      paramaj.bW().a(this, null, this, this, true, this, this);
      this.kA.kQ = dn.a(this.kA.kM, locala, this.kA.kN, paramaj, this.kz, this);
      return true;
    }
    paramaj = this.kA.kK.getNextView();
    if ((paramaj instanceof ey))
    {
      paramaj = (ey)paramaj;
      paramaj.a(this.kA.kM, this.kA.kR);
    }
    for (;;)
    {
      paramaj.bW().a(this, this, this, this, false, this);
      break;
      if (paramaj != null) {
        this.kA.kK.removeView(paramaj);
      }
      ey localey = ey.a(this.kA.kM, this.kA.kR, false, false, this.kA.kN, this.kA.kO);
      paramaj = localey;
      if (this.kA.kR.me == null)
      {
        b(localey);
        paramaj = localey;
      }
    }
  }
  
  public void aa()
  {
    if (this.kA.kS != null) {
      ev.D("Mediation adapter " + this.kA.kS.nM + " refreshed, but mediation adapters should never refresh.");
    }
    c(true);
    af();
  }
  
  public void ab()
  {
    hn.ay("recordManualImpression must be called on the main UI thread.");
    if (this.kA.kS == null) {
      ev.D("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      ev.z("Pinging manual tracking URLs.");
    } while (this.kA.kS.qf == null);
    ep.a(this.kA.kM, this.kA.kO.st, this.kA.kS.qf);
  }
  
  public void b(aj paramaj)
  {
    ViewParent localViewParent = this.kA.kK.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (ep.bL()) && (!this.kD))
    {
      a(paramaj);
      return;
    }
    ev.B("Ad is not visible. Not refreshing ad.");
    this.kB.d(paramaj);
  }
  
  public void b(boolean paramBoolean)
  {
    this.kA.kZ = paramBoolean;
  }
  
  public void destroy()
  {
    hn.ay("destroy must be called on the main UI thread.");
    S();
    this.kA.kP = null;
    this.kA.kU = null;
    this.kB.cancel();
    this.kC.stop();
    stopLoading();
    if (this.kA.kK != null) {
      this.kA.kK.removeAllViews();
    }
    if ((this.kA.kS != null) && (this.kA.kS.ow != null)) {
      this.kA.kS.ow.destroy();
    }
    if ((this.kA.kS != null) && (this.kA.kS.nL != null)) {}
    try
    {
      this.kA.kS.nL.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.D("Could not destroy mediation adapter.");
    }
  }
  
  public boolean isReady()
  {
    hn.ay("isLoaded must be called on the main UI thread.");
    return (this.kA.kQ == null) && (this.kA.kS != null);
  }
  
  public void onAdClicked()
  {
    ah();
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.kA.kU != null) {}
    try
    {
      this.kA.kU.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      ev.c("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    hn.ay("pause must be called on the main UI thread.");
    if (this.kA.kS != null) {
      ep.a(this.kA.kS.ow);
    }
    if ((this.kA.kS != null) && (this.kA.kS.nL != null)) {}
    try
    {
      this.kA.kS.nL.pause();
      this.kC.pause();
      this.kB.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.D("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    hn.ay("resume must be called on the main UI thread.");
    if (this.kA.kS != null) {
      ep.b(this.kA.kS.ow);
    }
    if ((this.kA.kS != null) && (this.kA.kS.nL != null)) {}
    try
    {
      this.kA.kS.nL.resume();
      this.kB.resume();
      this.kC.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.D("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    hn.ay("showInterstitial must be called on the main UI thread.");
    if (!this.kA.kR.md)
    {
      ev.D("Cannot call showInterstitial on a banner ad.");
      return;
    }
    if (this.kA.kS == null)
    {
      ev.D("The interstitial has not loaded.");
      return;
    }
    if (this.kA.kS.ow.bZ())
    {
      ev.D("The interstitial is already showing.");
      return;
    }
    this.kA.kS.ow.q(true);
    if ((this.kA.kS.ow.bW().ce()) || (this.kA.kS.rv != null))
    {
      ad localad = this.kC.a(this.kA.kR, this.kA.kS);
      if ((this.kA.kS.ow.bW().ce()) && (localad != null)) {
        localad.a(new y(this.kA.kS.ow));
      }
    }
    if (this.kA.kS.qd) {
      try
      {
        this.kA.kS.nL.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not show interstitial.", localRemoteException);
        ai();
        return;
      }
    }
    w localw = new w(this.kA.kZ, false);
    Object localObject = localw;
    boolean bool2;
    if ((this.kA.kM instanceof Activity))
    {
      localObject = ((Activity)this.kA.kM).getWindow();
      Rect localRect1 = new Rect();
      Rect localRect2 = new Rect();
      ((Window)localObject).getDecorView().getGlobalVisibleRect(localRect1);
      ((Window)localObject).getDecorView().getWindowVisibleDisplayFrame(localRect2);
      localObject = localw;
      if (localRect1.bottom != 0)
      {
        localObject = localw;
        if (localRect2.bottom != 0)
        {
          bool2 = this.kA.kZ;
          if (localRect1.top != localRect2.top) {
            break label420;
          }
        }
      }
    }
    label420:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = new w(bool2, bool1);
      localObject = new ci(this, this, this, this.kA.kS.ow, this.kA.kS.orientation, this.kA.kO, this.kA.kS.qi, (w)localObject);
      cg.a(this.kA.kM, (ci)localObject);
      return;
    }
  }
  
  public void stopLoading()
  {
    hn.ay("stopLoading must be called on the main UI thread.");
    if (this.kA.kS != null)
    {
      this.kA.kS.ow.stopLoading();
      this.kA.kS = null;
    }
    if (this.kA.kQ != null) {
      this.kA.kQ.cancel();
    }
  }
  
  private static final class a
    extends ViewSwitcher
  {
    private final eq kG;
    
    public a(Context paramContext)
    {
      super();
      this.kG = new eq(paramContext);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.kG.c(paramMotionEvent);
      return false;
    }
  }
  
  private static final class b
    implements h, Runnable
  {
    private v.c kA;
    private final List<Object[]> kH = new Vector();
    private final CountDownLatch kI = new CountDownLatch(1);
    private final AtomicReference<h> kJ = new AtomicReference();
    
    public b(v.c paramc)
    {
      this.kA = paramc;
      if (eu.bR())
      {
        eo.execute(this);
        return;
      }
      run();
    }
    
    private void aj()
    {
      try
      {
        this.kI.await();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        ev.c("Interrupted during GADSignals creation.", localInterruptedException);
      }
    }
    
    private void ak()
    {
      if (this.kH.isEmpty()) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.kH.iterator();
        while (localIterator.hasNext())
        {
          Object[] arrayOfObject = (Object[])localIterator.next();
          if (arrayOfObject.length == 1) {
            ((h)this.kJ.get()).a((MotionEvent)arrayOfObject[0]);
          } else if (arrayOfObject.length == 3) {
            ((h)this.kJ.get()).a(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
          }
        }
      }
    }
    
    public String a(Context paramContext)
    {
      aj();
      ak();
      return ((h)this.kJ.get()).a(paramContext);
    }
    
    public String a(Context paramContext, String paramString)
    {
      aj();
      ak();
      return ((h)this.kJ.get()).a(paramContext, paramString);
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      h localh = (h)this.kJ.get();
      if (localh != null)
      {
        ak();
        localh.a(paramInt1, paramInt2, paramInt3);
        return;
      }
      this.kH.add(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    
    public void a(MotionEvent paramMotionEvent)
    {
      h localh = (h)this.kJ.get();
      if (localh != null)
      {
        ak();
        localh.a(paramMotionEvent);
        return;
      }
      this.kH.add(new Object[] { paramMotionEvent });
    }
    
    public void run()
    {
      try
      {
        this.kJ.set(k.a(this.kA.kO.st, this.kA.kM));
        return;
      }
      finally
      {
        this.kI.countDown();
        this.kA = null;
      }
    }
  }
  
  private static final class c
  {
    public final v.a kK;
    public final String kL;
    public final Context kM;
    public final l kN;
    public final ew kO;
    public aq kP;
    public en kQ;
    public am kR;
    public eg kS;
    public eh kT;
    public at kU;
    public dh kV;
    public dd kW;
    public da kX;
    public el kY = null;
    public boolean kZ = false;
    private HashSet<eh> la = null;
    
    public c(Context paramContext, am paramam, String paramString, ew paramew)
    {
      if (paramam.md) {
        this.kK = null;
      }
      for (;;)
      {
        this.kR = paramam;
        this.kL = paramString;
        this.kM = paramContext;
        this.kO = paramew;
        this.kN = new l(new v.b(this));
        return;
        this.kK = new v.a(paramContext);
        this.kK.setMinimumWidth(paramam.widthPixels);
        this.kK.setMinimumHeight(paramam.heightPixels);
        this.kK.setVisibility(4);
      }
    }
    
    public void a(HashSet<eh> paramHashSet)
    {
      this.la = paramHashSet;
    }
    
    public HashSet<eh> al()
    {
      return this.la;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */