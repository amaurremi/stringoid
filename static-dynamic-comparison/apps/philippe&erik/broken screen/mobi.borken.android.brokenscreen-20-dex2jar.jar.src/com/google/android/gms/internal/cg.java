package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class cg
  extends co.a
{
  private static final int od = Color.argb(0, 0, 0, 0);
  private ey lL;
  private final Activity oe;
  private ci of;
  private ck og;
  private c oh;
  private cl oi;
  private boolean oj;
  private FrameLayout ok;
  private WebChromeClient.CustomViewCallback ol;
  private boolean om = false;
  private boolean on = false;
  private boolean oo = false;
  private RelativeLayout op;
  
  public cg(Activity paramActivity)
  {
    this.oe = paramActivity;
  }
  
  private static RelativeLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }
  
  public static void a(Context paramContext, ci paramci)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramci.kO.sw);
    ci.a(localIntent, paramci);
    localIntent.addFlags(524288);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void aO()
  {
    if ((!this.oe.isFinishing()) || (this.on)) {}
    do
    {
      do
      {
        return;
        this.on = true;
      } while (!this.oe.isFinishing());
      if (this.lL != null)
      {
        this.lL.bT();
        this.op.removeView(this.lL);
        if (this.oh != null)
        {
          this.lL.q(false);
          this.oh.os.addView(this.lL, this.oh.index, this.oh.or);
        }
      }
    } while ((this.of == null) || (this.of.ov == null));
    this.of.ov.U();
  }
  
  private void k(boolean paramBoolean)
    throws cg.a
  {
    if (!this.oj) {
      this.oe.requestWindowFeature(1);
    }
    Object localObject = this.oe.getWindow();
    if ((!this.oo) || (this.of.oF.lb)) {
      ((Window)localObject).setFlags(1024, 1024);
    }
    setRequestedOrientation(this.of.orientation);
    if (Build.VERSION.SDK_INT >= 11)
    {
      ev.z("Enabling hardware acceleration on the AdActivity window.");
      er.a((Window)localObject);
    }
    this.op = new b(this.oe, this.of.oE);
    boolean bool;
    if (!this.oo)
    {
      this.op.setBackgroundColor(-16777216);
      this.oe.setContentView(this.op);
      N();
      bool = this.of.ow.bW().ce();
      if (!paramBoolean) {
        break label410;
      }
      this.lL = ey.a(this.oe, this.of.ow.Q(), true, bool, null, this.of.kO);
      this.lL.bW().a(null, null, this.of.ox, this.of.oB, true, this.of.oD);
      this.lL.bW().a(new ez.a()
      {
        public void a(ey paramAnonymousey)
        {
          paramAnonymousey.bU();
        }
      });
      if (this.of.nZ == null) {
        break label358;
      }
      this.lL.loadUrl(this.of.nZ);
    }
    for (;;)
    {
      this.lL.a(this);
      localObject = this.lL.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(this.lL);
      }
      if (this.oo) {
        this.lL.setBackgroundColor(od);
      }
      this.op.addView(this.lL, -1, -1);
      if (!paramBoolean) {
        this.lL.bU();
      }
      i(bool);
      return;
      this.op.setBackgroundColor(od);
      break;
      label358:
      if (this.of.oA != null)
      {
        this.lL.loadDataWithBaseURL(this.of.oy, this.of.oA, "text/html", "UTF-8", null);
      }
      else
      {
        throw new a("No URL or HTML to display in ad overlay.");
        label410:
        this.lL = this.of.ow;
        this.lL.setContext(this.oe);
      }
    }
  }
  
  public void N()
  {
    this.oj = true;
  }
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.ok = new FrameLayout(this.oe);
    this.ok.setBackgroundColor(-16777216);
    this.ok.addView(paramView, -1, -1);
    this.oe.setContentView(this.ok);
    N();
    this.ol = paramCustomViewCallback;
  }
  
  public ck aL()
  {
    return this.og;
  }
  
  public void aM()
  {
    if (this.of != null) {
      setRequestedOrientation(this.of.orientation);
    }
    if (this.ok != null)
    {
      this.oe.setContentView(this.op);
      N();
      this.ok.removeAllViews();
      this.ok = null;
    }
    if (this.ol != null)
    {
      this.ol.onCustomViewHidden();
      this.ol = null;
    }
  }
  
  public void aN()
  {
    this.op.removeView(this.oi);
    i(true);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.og != null) {
      this.og.setLayoutParams(a(paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.og == null)
    {
      this.og = new ck(this.oe, this.lL);
      this.op.addView(this.og, 0, a(paramInt1, paramInt2, paramInt3, paramInt4));
      this.lL.bW().r(false);
    }
  }
  
  public void close()
  {
    this.oe.finish();
  }
  
  public void i(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      this.oi = new cl(this.oe, i);
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
      this.oi.j(this.of.oz);
      this.op.addView(this.oi, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.oi != null) {
      this.oi.j(paramBoolean);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.om = bool;
    for (;;)
    {
      try
      {
        this.of = ci.a(this.oe.getIntent());
        if (this.of.oF == null) {
          break label92;
        }
        this.oo = this.of.oF.kZ;
        if (this.of != null) {
          break;
        }
        throw new a("Could not get info for ad overlay.");
      }
      catch (a paramBundle)
      {
        ev.D(paramBundle.getMessage());
        this.oe.finish();
      }
      return;
      label92:
      this.oo = false;
    }
    if (paramBundle == null)
    {
      if (this.of.ov != null) {
        this.of.ov.V();
      }
      if ((this.of.oC != 1) && (this.of.ou != null)) {
        this.of.ou.onAdClicked();
      }
    }
    switch (this.of.oC)
    {
    }
    for (;;)
    {
      throw new a("Could not determine ad overlay type.");
      k(false);
      return;
      this.oh = new c(this.of.ow);
      k(false);
      return;
      k(true);
      return;
      if (this.om)
      {
        this.oe.finish();
        return;
      }
      if (cd.a(this.oe, this.of.ot, this.of.oB)) {
        break;
      }
      this.oe.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.og != null) {
      this.og.destroy();
    }
    if (this.lL != null) {
      this.op.removeView(this.lL);
    }
    aO();
  }
  
  public void onPause()
  {
    if (this.og != null) {
      this.og.pause();
    }
    aM();
    if ((this.lL != null) && ((!this.oe.isFinishing()) || (this.oh == null))) {
      ep.a(this.lL);
    }
    aO();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((this.of != null) && (this.of.oC == 4))
    {
      if (!this.om) {
        break label47;
      }
      this.oe.finish();
    }
    for (;;)
    {
      if (this.lL != null) {
        ep.b(this.lL);
      }
      return;
      label47:
      this.om = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.om);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    aO();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.oe.setRequestedOrientation(paramInt);
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
    extends RelativeLayout
  {
    private final eq kG;
    
    public b(Context paramContext, String paramString)
    {
      super();
      this.kG = new eq(paramContext, paramString);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.kG.c(paramMotionEvent);
      return false;
    }
  }
  
  private static final class c
  {
    public final int index;
    public final ViewGroup.LayoutParams or;
    public final ViewGroup os;
    
    public c(ey paramey)
      throws cg.a
    {
      this.or = paramey.getLayoutParams();
      ViewParent localViewParent = paramey.getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        this.os = ((ViewGroup)localViewParent);
        this.index = this.os.indexOfChild(paramey);
        this.os.removeView(paramey);
        paramey.q(true);
        return;
      }
      throw new cg.a("Could not get the parent of the WebView for an overlay.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */