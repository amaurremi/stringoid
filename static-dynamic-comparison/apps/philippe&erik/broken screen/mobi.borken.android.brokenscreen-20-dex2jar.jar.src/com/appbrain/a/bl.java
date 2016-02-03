package com.appbrain.a;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import cmn.af;
import cmn.j;
import cmn.q;
import com.appbrain.AppBrainBanner;
import com.appbrain.BannerListener;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public final class bl
{
  public static final int[] g = { 6, 4, 9, 8 };
  public static final int[] h = { 3, 2, 7 };
  public final AtomicBoolean a = new AtomicBoolean(false);
  public final AtomicBoolean b = new AtomicBoolean(false);
  public int c;
  public int d;
  public int e;
  public int f;
  private final AtomicBoolean i = new AtomicBoolean(false);
  private final AtomicBoolean j = new AtomicBoolean(false);
  private final AppBrainBanner k;
  private at.j l;
  private BannerListener m;
  private String n;
  private boolean o;
  private String p;
  private int q;
  
  public bl(AppBrainBanner paramAppBrainBanner)
  {
    this.k = paramAppBrainBanner;
    if (!paramAppBrainBanner.isInEditMode()) {
      cz.a().a(paramAppBrainBanner.getContext(), true);
    }
  }
  
  public final void a()
  {
    double d1 = aa.a().a("nbp", 0.05D);
    if ((this.l != null) || (Math.random() < d1)) {}
    boolean bool;
    String str2;
    Object localObject1;
    for (int i1 = 1;; i1 = 0)
    {
      if (this.i.compareAndSet(false, true))
      {
        bool = this.a.getAndSet(true);
        str2 = this.k.getResources().getConfiguration().locale.getLanguage();
        if (this.p != null) {
          this.p = this.p.substring(0, Math.min(10, this.p.length()));
        }
        if ((i1 == 0) || (this.k.isInEditMode())) {
          break;
        }
        localObject1 = this.p;
        bool = this.o;
        af.a(new bm(this, new bq(this)));
      }
      return;
    }
    Object localObject2;
    String str1;
    int i2;
    Object localObject3;
    if (!bool)
    {
      localObject1 = at.b[this.c];
      localObject2 = at.a[this.d];
      str1 = bs.a(g[this.e], str2);
      str2 = bs.a(h[this.f], str2);
      i1 = this.c;
      i2 = this.d;
      int i3 = this.e;
      i2 = this.f * 1024 + (i1 * 16 + i2 + i3 * 128);
      localObject3 = this.p;
      bool = this.o;
      this.n = new bt.a().b(i2).toString();
      i1 = 1;
      if (!this.k.isInEditMode())
      {
        j localj = j.a(this.k.getContext());
        cz localcz = cz.a();
        if ((localj.b == -1) || (localj.c < 5000) || (Build.VERSION.SDK_INT < 7)) {
          break label452;
        }
        i1 = 1;
        if ((i1 == 0) || (Math.random() > localcz.a(bool))) {
          break label457;
        }
        i1 = 1;
      }
      label358:
      if ((i1 == 0) && (!j.g)) {
        break label462;
      }
      bool = true;
      label371:
      this.k.removeAllViews();
      if (bool) {
        break label468;
      }
      this.k.setVisibility(8);
    }
    for (;;)
    {
      this.b.set(bool);
      if ((bool) && (this.k.hasWindowFocus())) {
        b();
      }
      if (this.m != null) {
        this.m.onAdRequestDone(this.b.get());
      }
      this.i.set(false);
      return;
      label452:
      i1 = 0;
      break;
      label457:
      i1 = 0;
      break label358;
      label462:
      bool = false;
      break label371;
      label468:
      localObject3 = new bp(this, i2, (String)localObject3);
      i1 = q.b(50.0F);
      localObject2 = new at.d(str1, str2, (at.g)localObject2, i1, (View.OnClickListener)localObject3);
      this.k.addView(((at.e)localObject1).a(this.k.getContext(), (at.d)localObject2), new FrameLayout.LayoutParams(-1, i1));
      this.k.setVisibility(0);
    }
  }
  
  public final void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public final void a(AttributeSet paramAttributeSet)
  {
    this.q = -1;
    this.c = -1;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    if (paramAttributeSet != null)
    {
      this.q = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.appbrain", "appDesign", -1);
      this.c = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.appbrain", "design", -1);
      if ((this.c < -1) || (this.c >= at.b.length)) {
        this.c = 0;
      }
      this.d = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.appbrain", "colors", -1);
      if ((this.d < -1) || (this.d >= at.a.length)) {
        this.d = 0;
      }
      this.e = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.appbrain", "title", -1);
      if ((this.e < -1) || (this.e >= g.length)) {
        this.e = 0;
      }
      this.f = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.appbrain", "button", -1);
      if ((this.f < -1) || (this.f >= h.length)) {
        this.f = 0;
      }
    }
    paramAttributeSet = new Random();
    if (this.c == -1) {
      this.c = paramAttributeSet.nextInt(at.b.length);
    }
    if (this.d == -1) {
      this.d = paramAttributeSet.nextInt(at.a.length);
    }
    if (this.e == -1) {
      this.e = paramAttributeSet.nextInt(g.length);
    }
    if (this.f == -1) {
      this.f = paramAttributeSet.nextInt(h.length);
    }
  }
  
  public final void a(BannerListener paramBannerListener)
  {
    this.m = paramBannerListener;
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    this.o = paramBoolean;
    this.p = paramString;
  }
  
  public final void b()
  {
    if ((this.j.compareAndSet(false, true)) && (!this.k.isInEditMode())) {
      bt.a(this.k.getContext(), this.n);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */