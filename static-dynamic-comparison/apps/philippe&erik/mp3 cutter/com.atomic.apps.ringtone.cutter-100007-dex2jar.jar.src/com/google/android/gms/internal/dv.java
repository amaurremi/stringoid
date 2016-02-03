package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.a.d;
import java.util.ArrayList;
import java.util.HashSet;

public final class dv
  extends s
  implements H, S, aC, aH, aX, aa, bF, du
{
  private final ai a;
  private final dz b;
  private final dA c;
  private final f d;
  private boolean e;
  private final ComponentCallbacks f = new dw(this);
  
  public dv(Context paramContext, ak paramak, String paramString, ai paramai, dx paramdx)
  {
    this.b = new dz(paramContext, paramak, paramString, paramdx);
    this.a = paramai;
    this.c = new dA(this);
    this.d = new f();
    com.atomic.apps.ringtone.cutter.aa.c("Use AdRequest.Builder.addTestDevice(\"" + bU.a(paramContext) + "\") to get test ads on this device.");
    bN.b(paramContext);
    if ((Build.VERSION.SDK_INT >= 14) && (this.b != null) && (this.b.c != null)) {
      this.b.c.registerComponentCallbacks(this.f);
    }
  }
  
  private void a(int paramInt)
  {
    com.atomic.apps.ringtone.cutter.aa.e("Failed to load ad: " + paramInt);
    if (this.b.f != null) {}
    try
    {
      this.b.f.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.atomic.apps.ringtone.cutter.aa.b("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.b.a.addView(paramView, localLayoutParams);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.b.i == null) {
      com.atomic.apps.ringtone.cutter.aa.e("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      com.atomic.apps.ringtone.cutter.aa.a("Pinging Impression URLs.");
      this.b.j.a();
      if (this.b.i.e != null) {
        bN.a(this.b.c, this.b.e.b, this.b.i.e);
      }
      if ((this.b.i.o != null) && (this.b.i.o.d != null)) {
        com.atomic.apps.ringtone.cutter.aa.a(this.b.c, this.b.e.b, this.b.i, this.b.b, paramBoolean, this.b.i.o.d);
      }
    } while ((this.b.i.l == null) || (this.b.i.l.e == null));
    com.atomic.apps.ringtone.cutter.aa.a(this.b.c, this.b.e.b, this.b.i, this.b.b, paramBoolean, this.b.i.l.e);
  }
  
  /* Error */
  private boolean b(bA parambA)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 208	com/google/android/gms/internal/bA:k	Z
    //   4: ifeq +184 -> 188
    //   7: aload_1
    //   8: getfield 212	com/google/android/gms/internal/bA:m	Lcom/google/android/gms/internal/am;
    //   11: invokeinterface 217 1 0
    //   16: invokestatic 222	com/google/android/gms/a/d:a	(Lcom/google/android/gms/a/a;)Ljava/lang/Object;
    //   19: checkcast 224	android/view/View
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   27: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   30: invokevirtual 228	com/google/android/gms/internal/dy:getNextView	()Landroid/view/View;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +14 -> 49
    //   38: aload_0
    //   39: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   42: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   45: aload_2
    //   46: invokevirtual 231	com/google/android/gms/internal/dy:removeView	(Landroid/view/View;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 233	com/google/android/gms/internal/dv:a	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   58: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   61: invokevirtual 237	com/google/android/gms/internal/dy:getChildCount	()I
    //   64: iconst_1
    //   65: if_icmple +13 -> 78
    //   68: aload_0
    //   69: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   72: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   75: invokevirtual 240	com/google/android/gms/internal/dy:showNext	()V
    //   78: aload_0
    //   79: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   82: getfield 153	com/google/android/gms/internal/dz:i	Lcom/google/android/gms/internal/bA;
    //   85: ifnull +70 -> 155
    //   88: aload_0
    //   89: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   92: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   95: invokevirtual 228	com/google/android/gms/internal/dy:getNextView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_1
    //   100: instanceof 242
    //   103: ifeq +158 -> 261
    //   106: aload_1
    //   107: checkcast 242	com/google/android/gms/internal/bW
    //   110: aload_0
    //   111: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   114: getfield 103	com/google/android/gms/internal/dz:c	Landroid/content/Context;
    //   117: aload_0
    //   118: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   121: getfield 246	com/google/android/gms/internal/dz:h	Lcom/google/android/gms/internal/ak;
    //   124: invokevirtual 249	com/google/android/gms/internal/bW:a	(Landroid/content/Context;Lcom/google/android/gms/internal/ak;)V
    //   127: aload_0
    //   128: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   131: getfield 153	com/google/android/gms/internal/dz:i	Lcom/google/android/gms/internal/bA;
    //   134: getfield 212	com/google/android/gms/internal/bA:m	Lcom/google/android/gms/internal/am;
    //   137: ifnull +18 -> 155
    //   140: aload_0
    //   141: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   144: getfield 153	com/google/android/gms/internal/dz:i	Lcom/google/android/gms/internal/bA;
    //   147: getfield 212	com/google/android/gms/internal/bA:m	Lcom/google/android/gms/internal/am;
    //   150: invokeinterface 251 1 0
    //   155: aload_0
    //   156: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   159: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   162: iconst_0
    //   163: invokevirtual 254	com/google/android/gms/internal/dy:setVisibility	(I)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: ldc_w 256
    //   172: aload_1
    //   173: invokestatic 133	com/atomic/apps/ringtone/cutter/aa:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: ldc_w 258
    //   182: aload_1
    //   183: invokestatic 133	com/atomic/apps/ringtone/cutter/aa:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: iconst_0
    //   187: ireturn
    //   188: aload_1
    //   189: getfield 261	com/google/android/gms/internal/bA:q	Lcom/google/android/gms/internal/ak;
    //   192: ifnull -138 -> 54
    //   195: aload_1
    //   196: getfield 264	com/google/android/gms/internal/bA:b	Lcom/google/android/gms/internal/bW;
    //   199: aload_1
    //   200: getfield 261	com/google/android/gms/internal/bA:q	Lcom/google/android/gms/internal/ak;
    //   203: invokevirtual 267	com/google/android/gms/internal/bW:a	(Lcom/google/android/gms/internal/ak;)V
    //   206: aload_0
    //   207: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   210: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   213: invokevirtual 270	com/google/android/gms/internal/dy:removeAllViews	()V
    //   216: aload_0
    //   217: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   220: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   223: aload_1
    //   224: getfield 261	com/google/android/gms/internal/bA:q	Lcom/google/android/gms/internal/ak;
    //   227: getfield 275	com/google/android/gms/internal/ak:g	I
    //   230: invokevirtual 278	com/google/android/gms/internal/dy:setMinimumWidth	(I)V
    //   233: aload_0
    //   234: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   237: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   240: aload_1
    //   241: getfield 261	com/google/android/gms/internal/bA:q	Lcom/google/android/gms/internal/ak;
    //   244: getfield 280	com/google/android/gms/internal/ak:d	I
    //   247: invokevirtual 283	com/google/android/gms/internal/dy:setMinimumHeight	(I)V
    //   250: aload_0
    //   251: aload_1
    //   252: getfield 264	com/google/android/gms/internal/bA:b	Lcom/google/android/gms/internal/bW;
    //   255: invokespecial 233	com/google/android/gms/internal/dv:a	(Landroid/view/View;)V
    //   258: goto -204 -> 54
    //   261: aload_1
    //   262: ifnull -135 -> 127
    //   265: aload_0
    //   266: getfield 51	com/google/android/gms/internal/dv:b	Lcom/google/android/gms/internal/dz;
    //   269: getfield 142	com/google/android/gms/internal/dz:a	Lcom/google/android/gms/internal/dy;
    //   272: aload_1
    //   273: invokevirtual 231	com/google/android/gms/internal/dy:removeView	(Landroid/view/View;)V
    //   276: goto -149 -> 127
    //   279: astore_1
    //   280: ldc_w 285
    //   283: invokestatic 121	com/atomic/apps/ringtone/cutter/aa:e	(Ljava/lang/String;)V
    //   286: goto -131 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	dv
    //   0	289	1	parambA	bA
    //   33	13	2	localView	View
    // Exception table:
    //   from	to	target	type
    //   7	23	168	android/os/RemoteException
    //   49	54	178	java/lang/Throwable
    //   140	155	279	android/os/RemoteException
  }
  
  private bl c(ah paramah)
  {
    ApplicationInfo localApplicationInfo = this.b.c.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo = this.b.c.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      if ((!this.b.h.e) && (this.b.a.getParent() != null))
      {
        localObject2 = new int[2];
        this.b.a.getLocationOnScreen((int[])localObject2);
        int j = localObject2[0];
        int k = localObject2[1];
        localObject2 = this.b.c.getResources().getDisplayMetrics();
        int m = this.b.a.getWidth();
        int n = this.b.a.getHeight();
        if ((this.b.a.isShown()) && (j + m > 0) && (k + n > 0) && (j <= ((DisplayMetrics)localObject2).widthPixels) && (k <= ((DisplayMetrics)localObject2).heightPixels))
        {
          i = 1;
          localObject2 = new Bundle(5);
          ((Bundle)localObject2).putInt("x", j);
          ((Bundle)localObject2).putInt("y", k);
          ((Bundle)localObject2).putInt("width", m);
          ((Bundle)localObject2).putInt("height", n);
          ((Bundle)localObject2).putInt("visible", i);
          String str = bD.b();
          this.b.j = new bB(str, this.b.b);
          this.b.j.a(paramah);
          Bundle localBundle = bD.a(this, str);
          return new bl((Bundle)localObject2, paramah, this.b.h, this.b.b, localApplicationInfo, localPackageInfo, str, bD.a, this.b.e, localBundle);
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
  
  private void s()
  {
    com.atomic.apps.ringtone.cutter.aa.c("Ad finished loading.");
    if (this.b.f != null) {}
    try
    {
      this.b.f.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.atomic.apps.ringtone.cutter.aa.b("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }
  
  private void t()
  {
    if (this.b.i != null)
    {
      this.b.i.b.destroy();
      this.b.i = null;
    }
  }
  
  public final com.google.android.gms.a.a a()
  {
    com.atomic.apps.ringtone.cutter.aa.f("getAdFrame must be called on the main UI thread.");
    return d.a(this.b.a);
  }
  
  public final void a(aU paramaU)
  {
    com.atomic.apps.ringtone.cutter.aa.f("setInAppPurchaseListener must be called on the main UI thread.");
    this.b.l = paramaU;
  }
  
  public final void a(ak paramak)
  {
    com.atomic.apps.ringtone.cutter.aa.f("setAdSize must be called on the main UI thread.");
    this.b.h = paramak;
    if (this.b.i != null) {
      this.b.i.b.a(paramak);
    }
    if (this.b.a.getChildCount() > 1) {
      this.b.a.removeView(this.b.a.getNextView());
    }
    this.b.a.setMinimumWidth(paramak.g);
    this.b.a.setMinimumHeight(paramak.d);
    this.b.a.requestLayout();
  }
  
  public final void a(bA parambA)
  {
    int j = 0;
    this.b.g = null;
    if ((parambA.d != -2) && (parambA.d != 3)) {
      bD.a(this.b.a());
    }
    if (parambA.d == -1) {
      return;
    }
    boolean bool;
    if (parambA.a.c != null)
    {
      bool = parambA.a.c.getBoolean("_noRefresh", false);
      if (!this.b.h.e) {
        break label183;
      }
      bN.a(parambA.b);
    }
    for (;;)
    {
      if ((parambA.d == 3) && (parambA.o != null) && (parambA.o.e != null))
      {
        com.atomic.apps.ringtone.cutter.aa.a("Pinging no fill URLs.");
        com.atomic.apps.ringtone.cutter.aa.a(this.b.c, this.b.e.b, parambA, this.b.b, false, parambA.o.e);
      }
      if (parambA.d == -2) {
        break label284;
      }
      a(parambA.d);
      return;
      bool = false;
      break;
      label183:
      if (!bool) {
        if (parambA.h > 0L) {
          this.c.a(parambA.a, parambA.h);
        } else if ((parambA.o != null) && (parambA.o.g > 0L)) {
          this.c.a(parambA.a, parambA.o.g);
        } else if ((!parambA.k) && (parambA.d == 2)) {
          this.c.a(parambA.a);
        }
      }
    }
    label284:
    if (!this.b.h.e)
    {
      if (!b(parambA))
      {
        a(0);
        return;
      }
      if (this.b.a != null) {
        dy.a(this.b.a).a(parambA.t);
      }
    }
    if ((this.b.i != null) && (this.b.i.p != null)) {
      this.b.i.p.a(null);
    }
    if (parambA.p != null) {
      parambA.p.a(this);
    }
    this.d.b(this.b.i);
    this.b.i = parambA;
    if (parambA.q != null) {
      this.b.h = parambA.q;
    }
    this.b.j.a(parambA.r);
    this.b.j.b(parambA.s);
    this.b.j.a(this.b.h.e);
    this.b.j.b(parambA.k);
    if (!this.b.h.e) {
      a(false);
    }
    if (this.b.m == null) {
      this.b.m = new bG(this.b.b);
    }
    int i;
    if (parambA.o != null)
    {
      i = parambA.o.h;
      j = parambA.o.i;
    }
    for (;;)
    {
      this.b.m.a(i, j);
      if ((!this.b.h.e) && (parambA.b != null) && ((parambA.b.f().a()) || (parambA.j != null)))
      {
        a locala = this.d.a(this.b.h, this.b.i);
        if ((parambA.b.f().a()) && (locala != null)) {
          locala.a(new dD(parambA.b));
        }
      }
      this.b.i.b.a();
      s();
      return;
      i = 0;
    }
  }
  
  public final void a(o paramo)
  {
    com.atomic.apps.ringtone.cutter.aa.f("setAdListener must be called on the main UI thread.");
    this.b.f = paramo;
  }
  
  public final void a(x paramx)
  {
    com.atomic.apps.ringtone.cutter.aa.f("setAppEventListener must be called on the main UI thread.");
    this.b.k = paramx;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.b.k != null) {}
    try
    {
      this.b.k.a(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      com.atomic.apps.ringtone.cutter.aa.b("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public final void a(String paramString, ArrayList paramArrayList)
  {
    if (this.b.l == null)
    {
      com.atomic.apps.ringtone.cutter.aa.e("InAppPurchaseListener is not set");
      return;
    }
    try
    {
      this.b.l.a(new aQ(paramString, paramArrayList, this.b.c, this.b.e.b));
      return;
    }
    catch (RemoteException paramString)
    {
      com.atomic.apps.ringtone.cutter.aa.e("Could not start In-App purchase.");
    }
  }
  
  public final void a(HashSet paramHashSet)
  {
    this.b.a(paramHashSet);
  }
  
  public final boolean a(ah paramah)
  {
    com.atomic.apps.ringtone.cutter.aa.f("loadAd must be called on the main UI thread.");
    if (this.b.g != null)
    {
      com.atomic.apps.ringtone.cutter.aa.e("An ad request is already in progress. Aborting.");
      return false;
    }
    if ((this.b.h.e) && (this.b.i != null))
    {
      com.atomic.apps.ringtone.cutter.aa.e("An interstitial is already loading. Aborting.");
      return false;
    }
    if (!bN.a(this.b.c.getPackageManager(), this.b.c.getPackageName(), "android.permission.INTERNET")) {
      if (!this.b.h.e) {
        bU.a(this.b.a, this.b.h, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
    }
    for (int i = 0;; i = 1)
    {
      if (!bN.a(this.b.c))
      {
        if (!this.b.h.e) {
          bU.a(this.b.a, this.b.h, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
        }
        i = 0;
      }
      if ((i == 0) && (!this.b.h.e)) {
        this.b.a.setVisibility(0);
      }
      if (i == 0) {
        break;
      }
      com.atomic.apps.ringtone.cutter.aa.c("Starting ad request.");
      this.c.a();
      bl localbl = c(paramah);
      Object localObject;
      if (this.b.h.e)
      {
        paramah = bW.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
        paramah.f().a(this, null, this, this, true, this);
        localObject = this.b;
        paramah = new aY(this.b.c, localbl, this.b.d, paramah, this.a, this);
        paramah.e();
        ((dz)localObject).g = paramah;
        return true;
      }
      paramah = this.b.a.getNextView();
      if ((paramah instanceof bW))
      {
        paramah = (bW)paramah;
        paramah.a(this.b.c, this.b.h);
      }
      for (;;)
      {
        paramah.f().a(this, this, this, this, false, this);
        break;
        if (paramah != null) {
          this.b.a.removeView(paramah);
        }
        localObject = bW.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
        paramah = (ah)localObject;
        if (this.b.h.h == null)
        {
          a((View)localObject);
          paramah = (ah)localObject;
        }
      }
    }
  }
  
  public final void b()
  {
    com.atomic.apps.ringtone.cutter.aa.f("destroy must be called on the main UI thread.");
    if ((Build.VERSION.SDK_INT >= 14) && (this.b != null) && (this.b.c != null)) {
      this.b.c.unregisterComponentCallbacks(this.f);
    }
    this.b.f = null;
    this.b.k = null;
    this.c.a();
    g();
    if (this.b.a != null) {
      this.b.a.removeAllViews();
    }
    if ((this.b.i != null) && (this.b.i.b != null)) {
      this.b.i.b.destroy();
    }
    if ((this.b.i != null) && (this.b.i.m != null)) {}
    try
    {
      this.b.i.m.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.atomic.apps.ringtone.cutter.aa.e("Could not destroy mediation adapter.");
    }
  }
  
  public final void b(ah paramah)
  {
    ViewParent localViewParent = this.b.a.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (bN.a()) && (!this.e))
    {
      a(paramah);
      return;
    }
    com.atomic.apps.ringtone.cutter.aa.c("Ad is not visible. Not refreshing ad.");
    this.c.a(paramah);
  }
  
  public final boolean c()
  {
    com.atomic.apps.ringtone.cutter.aa.f("isLoaded must be called on the main UI thread.");
    return (this.b.g == null) && (this.b.i != null);
  }
  
  public final void d()
  {
    com.atomic.apps.ringtone.cutter.aa.f("pause must be called on the main UI thread.");
    if (this.b.i != null) {
      bN.a(this.b.i.b);
    }
    if ((this.b.i != null) && (this.b.i.m != null)) {}
    try
    {
      this.b.i.m.d();
      this.c.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.atomic.apps.ringtone.cutter.aa.e("Could not pause mediation adapter.");
      }
    }
  }
  
  public final void e()
  {
    com.atomic.apps.ringtone.cutter.aa.f("resume must be called on the main UI thread.");
    if (this.b.i != null) {
      bN.b(this.b.i.b);
    }
    if ((this.b.i != null) && (this.b.i.m != null)) {}
    try
    {
      this.b.i.m.e();
      this.c.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.atomic.apps.ringtone.cutter.aa.e("Could not resume mediation adapter.");
      }
    }
  }
  
  public final void f()
  {
    com.atomic.apps.ringtone.cutter.aa.f("showInterstitial must be called on the main UI thread.");
    if (!this.b.h.e)
    {
      com.atomic.apps.ringtone.cutter.aa.e("Cannot call showInterstitial on a banner ad.");
      return;
    }
    if (this.b.i == null)
    {
      com.atomic.apps.ringtone.cutter.aa.e("The interstitial has not loaded.");
      return;
    }
    if (this.b.i.b.i())
    {
      com.atomic.apps.ringtone.cutter.aa.e("The interstitial is already showing.");
      return;
    }
    this.b.i.b.a(true);
    if ((this.b.i.b.f().a()) || (this.b.i.j != null))
    {
      a locala = this.d.a(this.b.h, this.b.i);
      if ((this.b.i.b.f().a()) && (locala != null)) {
        locala.a(new dD(this.b.i.b));
      }
    }
    if (this.b.i.k) {
      try
      {
        this.b.i.m.b();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        com.atomic.apps.ringtone.cutter.aa.b("Could not show interstitial.", localRemoteException);
        t();
        return;
      }
    }
    ce localce = new ce(this, this, this, this.b.i.b, this.b.i.g, this.b.e, this.b.i.t);
    aw.a(this.b.c, localce);
  }
  
  public final void g()
  {
    com.atomic.apps.ringtone.cutter.aa.f("stopLoading must be called on the main UI thread.");
    if (this.b.i != null)
    {
      this.b.i.b.stopLoading();
      this.b.i = null;
    }
    if (this.b.g != null) {
      this.b.g.f();
    }
  }
  
  public final void h()
  {
    com.atomic.apps.ringtone.cutter.aa.f("recordManualImpression must be called on the main UI thread.");
    if (this.b.i == null) {
      com.atomic.apps.ringtone.cutter.aa.e("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      com.atomic.apps.ringtone.cutter.aa.a("Pinging manual tracking URLs.");
    } while (this.b.i.f == null);
    bN.a(this.b.c, this.b.e.b, this.b.i.f);
  }
  
  public final ak i()
  {
    com.atomic.apps.ringtone.cutter.aa.f("getAdSize must be called on the main UI thread.");
    return this.b.h;
  }
  
  public final void j()
  {
    r();
  }
  
  public final void k()
  {
    o();
  }
  
  public final void l()
  {
    q();
  }
  
  public final void m()
  {
    p();
  }
  
  public final void n()
  {
    if (this.b.i != null) {
      com.atomic.apps.ringtone.cutter.aa.e("Mediation adapter " + this.b.i.n + " refreshed, but mediation adapters should never refresh.");
    }
    a(true);
    s();
  }
  
  public final void o()
  {
    this.d.b(this.b.i);
    if (this.b.h.e) {
      t();
    }
    this.e = false;
    com.atomic.apps.ringtone.cutter.aa.c("Ad closing.");
    if (this.b.f != null) {}
    try
    {
      this.b.f.a();
      this.b.j.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.atomic.apps.ringtone.cutter.aa.b("Could not call AdListener.onAdClosed().", localRemoteException);
      }
    }
  }
  
  public final void p()
  {
    if (this.b.h.e) {
      a(false);
    }
    this.e = true;
    com.atomic.apps.ringtone.cutter.aa.c("Ad opening.");
    if (this.b.f != null) {}
    try
    {
      this.b.f.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.atomic.apps.ringtone.cutter.aa.b("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }
  
  public final void q()
  {
    com.atomic.apps.ringtone.cutter.aa.c("Ad leaving application.");
    if (this.b.f != null) {}
    try
    {
      this.b.f.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.atomic.apps.ringtone.cutter.aa.b("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  public final void r()
  {
    if (this.b.i == null) {
      com.atomic.apps.ringtone.cutter.aa.e("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      com.atomic.apps.ringtone.cutter.aa.a("Pinging click URLs.");
      this.b.j.b();
      if (this.b.i.c != null) {
        bN.a(this.b.c, this.b.e.b, this.b.i.c);
      }
    } while ((this.b.i.o == null) || (this.b.i.o.c == null));
    com.atomic.apps.ringtone.cutter.aa.a(this.b.c, this.b.e.b, this.b.i, this.b.b, false, this.b.i.o.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */