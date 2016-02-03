package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public final class bk
  extends bs.a
{
  private boolean gA = false;
  private boolean gB = false;
  private RelativeLayout gC;
  private final Activity gs;
  private bm gt;
  private bo gu;
  private cw gv;
  private b gw;
  private bp gx;
  private FrameLayout gy;
  private WebChromeClient.CustomViewCallback gz;
  
  public bk(Activity paramActivity)
  {
    this.gs = paramActivity;
  }
  
  private void Z()
  {
    if ((!this.gs.isFinishing()) || (this.gB)) {}
    do
    {
      do
      {
        return;
        this.gB = true;
      } while (!this.gs.isFinishing());
      if (this.gv != null)
      {
        this.gv.az();
        this.gC.removeView(this.gv);
        if (this.gw != null)
        {
          this.gv.l(false);
          this.gw.gF.addView(this.gv, this.gw.index, this.gw.gE);
        }
      }
    } while ((this.gt == null) || (this.gt.gI == null));
    this.gt.gI.A();
  }
  
  private static RelativeLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }
  
  public static void a(Context paramContext, bm parambm)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", parambm.ej.iM);
    bm.a(localIntent, parambm);
    localIntent.addFlags(524288);
    paramContext.startActivity(localIntent);
  }
  
  private void h(boolean paramBoolean)
    throws bk.a
  {
    this.gs.requestWindowFeature(1);
    Window localWindow = this.gs.getWindow();
    localWindow.setFlags(1024, 1024);
    setRequestedOrientation(this.gt.orientation);
    if (Build.VERSION.SDK_INT >= 11)
    {
      ct.r("Enabling hardware acceleration on the AdActivity window.");
      cp.a(localWindow);
    }
    this.gC = new RelativeLayout(this.gs);
    this.gC.setBackgroundColor(-16777216);
    this.gs.setContentView(this.gC);
    boolean bool = this.gt.gJ.aC().aJ();
    if (paramBoolean)
    {
      this.gv = cw.a(this.gs, this.gt.gJ.y(), true, bool, null, this.gt.ej);
      this.gv.aC().a(null, null, this.gt.gK, this.gt.gO, true);
      this.gv.aC().a(new cx.a()
      {
        public void a(cw paramAnonymouscw)
        {
          paramAnonymouscw.aA();
        }
      });
      if (this.gt.go != null) {
        this.gv.loadUrl(this.gt.go);
      }
    }
    for (;;)
    {
      this.gv.a(this);
      this.gC.addView(this.gv, -1, -1);
      if (!paramBoolean) {
        this.gv.aA();
      }
      f(bool);
      return;
      if (this.gt.gN != null)
      {
        this.gv.loadDataWithBaseURL(this.gt.gL, this.gt.gN, "text/html", "UTF-8", null);
      }
      else
      {
        throw new a("No URL or HTML to display in ad overlay.");
        this.gv = this.gt.gJ;
        this.gv.setContext(this.gs);
      }
    }
  }
  
  public bo W()
  {
    return this.gu;
  }
  
  public void X()
  {
    if (this.gt != null) {
      setRequestedOrientation(this.gt.orientation);
    }
    if (this.gy != null)
    {
      this.gs.setContentView(this.gC);
      this.gy.removeAllViews();
      this.gy = null;
    }
    if (this.gz != null)
    {
      this.gz.onCustomViewHidden();
      this.gz = null;
    }
  }
  
  public void Y()
  {
    this.gC.removeView(this.gx);
    f(true);
  }
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.gy = new FrameLayout(this.gs);
    this.gy.setBackgroundColor(-16777216);
    this.gy.addView(paramView, -1, -1);
    this.gs.setContentView(this.gy);
    this.gz = paramCustomViewCallback;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.gu != null) {
      this.gu.setLayoutParams(a(paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.gu == null)
    {
      this.gu = new bo(this.gs, this.gv);
      this.gC.addView(this.gu, 0, a(paramInt1, paramInt2, paramInt3, paramInt4));
      this.gv.aC().m(false);
    }
  }
  
  public void close()
  {
    this.gs.finish();
  }
  
  public void f(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      this.gx = new bp(this.gs, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 11;; i = 9)
    {
      localLayoutParams.addRule(i);
      this.gx.g(this.gt.gM);
      this.gC.addView(this.gx, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.gx != null) {
      this.gx.g(paramBoolean);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.gA = bool;
    try
    {
      this.gt = bm.a(this.gs.getIntent());
      if (this.gt != null) {
        break label68;
      }
      throw new a("Could not get info for ad overlay.");
    }
    catch (a paramBundle)
    {
      ct.v(paramBundle.getMessage());
      this.gs.finish();
    }
    return;
    label68:
    if (paramBundle == null)
    {
      if (this.gt.gI != null) {
        this.gt.gI.B();
      }
      if ((this.gt.gP != 1) && (this.gt.gH != null)) {
        this.gt.gH.w();
      }
    }
    switch (this.gt.gP)
    {
    }
    for (;;)
    {
      throw new a("Could not determine ad overlay type.");
      h(false);
      return;
      this.gw = new b(this.gt.gJ);
      h(false);
      return;
      h(true);
      return;
      if (this.gA)
      {
        this.gs.finish();
        return;
      }
      if (bh.a(this.gs, this.gt.gG, this.gt.gO)) {
        break;
      }
      this.gs.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.gu != null) {
      this.gu.destroy();
    }
    if (this.gv != null) {
      this.gC.removeView(this.gv);
    }
    Z();
  }
  
  public void onPause()
  {
    if (this.gu != null) {
      this.gu.pause();
    }
    X();
    if ((this.gv != null) && ((!this.gs.isFinishing()) || (this.gw == null))) {
      co.a(this.gv);
    }
    Z();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((this.gt != null) && (this.gt.gP == 4))
    {
      if (!this.gA) {
        break label47;
      }
      this.gs.finish();
    }
    for (;;)
    {
      if (this.gv != null) {
        co.b(this.gv);
      }
      return;
      label47:
      this.gA = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.gA);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    Z();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.gs.setRequestedOrientation(paramInt);
  }
  
  private static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  private static final class b
  {
    public final ViewGroup.LayoutParams gE;
    public final ViewGroup gF;
    public final int index;
    
    public b(cw paramcw)
      throws bk.a
    {
      this.gE = paramcw.getLayoutParams();
      ViewParent localViewParent = paramcw.getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        this.gF = ((ViewGroup)localViewParent);
        this.index = this.gF.indexOfChild(paramcw);
        this.gF.removeView(paramcw);
        paramcw.l(true);
        return;
      }
      throw new bk.a("Could not get the parent of the WebView for an overlay.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */