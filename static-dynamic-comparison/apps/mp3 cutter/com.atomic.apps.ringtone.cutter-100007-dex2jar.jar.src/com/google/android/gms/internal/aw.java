package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.atomic.apps.ringtone.cutter.aa;

public final class aw
  extends aL
{
  private final Activity a;
  private ce b;
  private aD c;
  private bW d;
  private aA e;
  private aG f;
  private boolean g;
  private FrameLayout h;
  private WebChromeClient.CustomViewCallback i;
  private boolean j = false;
  private boolean k = false;
  private RelativeLayout l;
  
  public aw(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public static void a(Context paramContext, ce paramce)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramce.n.e);
    ce.a(localIntent, paramce);
    localIntent.addFlags(524288);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void b(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      m = 50;
      this.f = new aG(this.a, m);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int m = 11;; m = 9)
    {
      localLayoutParams.addRule(m);
      this.f.a(this.b.h);
      this.l.addView(this.f, localLayoutParams);
      return;
      m = 32;
      break;
    }
  }
  
  private static RelativeLayout.LayoutParams c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }
  
  private void c(boolean paramBoolean)
  {
    if (!this.g) {
      this.a.requestWindowFeature(1);
    }
    Object localObject = this.a.getWindow();
    ((Window)localObject).setFlags(1024, 1024);
    a(this.b.k);
    if (Build.VERSION.SDK_INT >= 11)
    {
      aa.a("Enabling hardware acceleration on the AdActivity window.");
      ((Window)localObject).setFlags(16777216, 16777216);
    }
    this.l = new az(this.a, this.b.p);
    this.l.setBackgroundColor(-16777216);
    this.a.setContentView(this.l);
    this.g = true;
    boolean bool = this.b.e.f().a();
    if (paramBoolean)
    {
      this.d = bW.a(this.a, this.b.e.e(), true, bool, null, this.b.n);
      this.d.f().a(null, null, this.b.f, this.b.j, true, this.b.o);
      this.d.f().a(new ax(this));
      if (this.b.m != null) {
        this.d.loadUrl(this.b.m);
      }
    }
    for (;;)
    {
      this.d.a(this);
      localObject = this.d.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(this.d);
      }
      this.l.addView(this.d, -1, -1);
      if (!paramBoolean) {
        this.d.c();
      }
      b(bool);
      return;
      if (this.b.i != null)
      {
        this.d.loadDataWithBaseURL(this.b.g, this.b.i, "text/html", "UTF-8", null);
      }
      else
      {
        throw new ay("No URL or HTML to display in ad overlay.");
        this.d = this.b.e;
        this.d.a(this.a);
      }
    }
  }
  
  private void l()
  {
    if ((!this.a.isFinishing()) || (this.k)) {}
    do
    {
      do
      {
        return;
        this.k = true;
      } while (!this.a.isFinishing());
      if (this.d != null)
      {
        this.d.b();
        this.l.removeView(this.d);
        if (this.e != null)
        {
          this.d.a(false);
          this.e.c.addView(this.d, this.e.a, this.e.b);
        }
      }
    } while ((this.b == null) || (this.b.d == null));
    this.b.d.o();
  }
  
  public final void a()
  {
    this.a.finish();
  }
  
  public final void a(int paramInt)
  {
    this.a.setRequestedOrientation(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c != null) {
      this.c.setLayoutParams(c(paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.j = bool;
    try
    {
      this.b = ce.a(this.a.getIntent());
      if (this.b != null) {
        break label68;
      }
      throw new ay("Could not get info for ad overlay.");
    }
    catch (ay paramBundle)
    {
      aa.e(paramBundle.getMessage());
      this.a.finish();
    }
    return;
    label68:
    if (paramBundle == null)
    {
      if (this.b.d != null) {
        this.b.d.p();
      }
      if ((this.b.l != 1) && (this.b.c != null)) {
        this.b.c.r();
      }
    }
    switch (this.b.l)
    {
    }
    for (;;)
    {
      throw new ay("Could not determine ad overlay type.");
      c(false);
      return;
      this.e = new aA(this.b.e);
      c(false);
      return;
      c(true);
      return;
      if (this.j)
      {
        this.a.finish();
        return;
      }
      if (aa.a(this.a, this.b.b, this.b.j)) {
        break;
      }
      this.a.finish();
      return;
    }
  }
  
  public final void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.h = new FrameLayout(this.a);
    this.h.setBackgroundColor(-16777216);
    this.h.addView(paramView, -1, -1);
    this.a.setContentView(this.h);
    this.g = true;
    this.i = paramCustomViewCallback;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.f != null) {
      this.f.a(paramBoolean);
    }
  }
  
  public final aD b()
  {
    return this.c;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c == null)
    {
      this.c = new aD(this.a, this.d);
      this.l.addView(this.c, 0, c(paramInt1, paramInt2, paramInt3, paramInt4));
      this.d.f().a(false);
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.j);
  }
  
  public final void c()
  {
    if (this.b != null) {
      a(this.b.k);
    }
    if (this.h != null)
    {
      this.a.setContentView(this.l);
      this.g = true;
      this.h.removeAllViews();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.onCustomViewHidden();
      this.i = null;
    }
  }
  
  public final void d() {}
  
  public final void e() {}
  
  public final void f()
  {
    if ((this.b != null) && (this.b.l == 4))
    {
      if (!this.j) {
        break label47;
      }
      this.a.finish();
    }
    for (;;)
    {
      if (this.d != null) {
        bN.b(this.d);
      }
      return;
      label47:
      this.j = true;
    }
  }
  
  public final void g()
  {
    if (this.c != null) {
      this.c.c();
    }
    c();
    if ((this.d != null) && ((!this.a.isFinishing()) || (this.e == null))) {
      bN.a(this.d);
    }
    l();
  }
  
  public final void h()
  {
    l();
  }
  
  public final void i()
  {
    if (this.c != null) {
      this.c.a();
    }
    if (this.d != null) {
      this.l.removeView(this.d);
    }
    l();
  }
  
  public final void j()
  {
    this.g = true;
  }
  
  public final void k()
  {
    this.l.removeView(this.f);
    b(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */