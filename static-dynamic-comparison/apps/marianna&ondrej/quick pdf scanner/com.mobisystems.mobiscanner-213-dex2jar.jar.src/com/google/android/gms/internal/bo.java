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

public final class bo
  extends au.a
{
  private bs CA;
  private dd CB;
  private b CC;
  private bt CD;
  private FrameLayout CE;
  private WebChromeClient.CustomViewCallback CF;
  private boolean CG = false;
  private boolean CH = false;
  private RelativeLayout CI;
  private final Activity Cy;
  private bq Cz;
  
  public bo(Activity paramActivity)
  {
    this.Cy = paramActivity;
  }
  
  public static void a(Context paramContext, bq parambq)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", parambq.CY.FN);
    bq.a(localIntent, parambq);
    localIntent.addFlags(524288);
    paramContext.startActivity(localIntent);
  }
  
  private static RelativeLayout.LayoutParams e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }
  
  private void pm()
  {
    if ((!this.Cy.isFinishing()) || (this.CH)) {}
    do
    {
      do
      {
        return;
        this.CH = true;
      } while (!this.Cy.isFinishing());
      if (this.CB != null)
      {
        this.CB.pU();
        this.CI.removeView(this.CB);
        if (this.CC != null)
        {
          this.CB.E(false);
          this.CC.CL.addView(this.CB, this.CC.index, this.CC.CK);
        }
      }
    } while ((this.Cz == null) || (this.Cz.CP == null));
    this.Cz.CP.ps();
  }
  
  private void y(boolean paramBoolean)
  {
    this.Cy.requestWindowFeature(1);
    Window localWindow = this.Cy.getWindow();
    localWindow.setFlags(1024, 1024);
    setRequestedOrientation(this.Cz.orientation);
    if (Build.VERSION.SDK_INT >= 11)
    {
      ce.aG("Enabling hardware acceleration on the AdActivity window.");
      bx.a(localWindow);
    }
    this.CI = new RelativeLayout(this.Cy);
    this.CI.setBackgroundColor(-16777216);
    this.Cy.setContentView(this.CI);
    boolean bool = this.Cz.CQ.pX().qe();
    if (paramBoolean)
    {
      this.CB = dd.a(this.Cy, this.Cz.CQ.oO(), true, bool, null, this.Cz.CY);
      this.CB.pX().a(null, null, this.Cz.CS, this.Cz.CW, true);
      this.CB.pX().a(new ch.a()
      {
        public void a(dd paramAnonymousdd)
        {
          paramAnonymousdd.pV();
        }
      });
      if (this.Cz.Cu != null) {
        this.CB.loadUrl(this.Cz.Cu);
      }
    }
    for (;;)
    {
      this.CB.a(this);
      this.CI.addView(this.CB, -1, -1);
      if (!paramBoolean) {
        this.CB.pV();
      }
      w(bool);
      return;
      if (this.Cz.CV != null)
      {
        this.CB.loadDataWithBaseURL(this.Cz.CT, this.Cz.CV, "text/html", "UTF-8", null);
      }
      else
      {
        throw new a("No URL or HTML to display in ad overlay.");
        this.CB = this.Cz.CQ;
        this.CB.setContext(this.Cy);
      }
    }
  }
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.CE = new FrameLayout(this.Cy);
    this.CE.setBackgroundColor(-16777216);
    this.CE.addView(paramView, -1, -1);
    this.Cy.setContentView(this.CE);
    this.CF = paramCustomViewCallback;
  }
  
  public void close()
  {
    this.Cy.finish();
  }
  
  public void f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.CA != null) {
      this.CA.setLayoutParams(e(paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public void g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.CA == null)
    {
      this.CA = new bs(this.Cy, this.CB);
      this.CI.addView(this.CA, 0, e(paramInt1, paramInt2, paramInt3, paramInt4));
      this.CB.pX().F(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.CG = bool;
    try
    {
      this.Cz = bq.a(this.Cy.getIntent());
      if (this.Cz != null) {
        break label68;
      }
      throw new a("Could not get info for ad overlay.");
    }
    catch (a paramBundle)
    {
      ce.D(paramBundle.getMessage());
      this.Cy.finish();
    }
    return;
    label68:
    if (paramBundle == null)
    {
      if (this.Cz.CP != null) {
        this.Cz.CP.pt();
      }
      if ((this.Cz.CX != 1) && (this.Cz.CO != null)) {
        this.Cz.CO.pg();
      }
    }
    switch (this.Cz.CX)
    {
    }
    for (;;)
    {
      throw new a("Could not determine ad overlay type.");
      y(false);
      return;
      this.CC = new b(this.Cz.CQ);
      y(false);
      return;
      y(true);
      return;
      if (this.CG)
      {
        this.Cy.finish();
        return;
      }
      if (ap.a(this.Cy, this.Cz.CN, this.Cz.CW)) {
        break;
      }
      this.Cy.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.CA != null) {
      this.CA.destroy();
    }
    if (this.CB != null) {
      this.CI.removeView(this.CB);
    }
    pm();
  }
  
  public void onPause()
  {
    if (this.CA != null) {
      this.CA.pause();
    }
    pk();
    if ((this.CB != null) && ((!this.Cy.isFinishing()) || (this.CC == null))) {
      bw.a(this.CB);
    }
    pm();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((this.Cz != null) && (this.Cz.CX == 4))
    {
      if (!this.CG) {
        break label47;
      }
      this.Cy.finish();
    }
    for (;;)
    {
      if (this.CB != null) {
        bw.b(this.CB);
      }
      return;
      label47:
      this.CG = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.CG);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    pm();
  }
  
  public bs pj()
  {
    return this.CA;
  }
  
  public void pk()
  {
    if (this.Cz != null) {
      setRequestedOrientation(this.Cz.orientation);
    }
    if (this.CE != null)
    {
      this.Cy.setContentView(this.CI);
      this.CE.removeAllViews();
      this.CE = null;
    }
    if (this.CF != null)
    {
      this.CF.onCustomViewHidden();
      this.CF = null;
    }
  }
  
  public void pl()
  {
    this.CI.removeView(this.CD);
    w(true);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.Cy.setRequestedOrientation(paramInt);
  }
  
  public void w(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      this.CD = new bt(this.Cy, i);
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
      this.CD.x(this.Cz.CU);
      this.CI.addView(this.CD, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  public void x(boolean paramBoolean)
  {
    if (this.CD != null) {
      this.CD.x(paramBoolean);
    }
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
    public final ViewGroup.LayoutParams CK;
    public final ViewGroup CL;
    public final int index;
    
    public b(dd paramdd)
    {
      this.CK = paramdd.getLayoutParams();
      ViewParent localViewParent = paramdd.getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        this.CL = ((ViewGroup)localViewParent);
        this.index = this.CL.indexOfChild(paramdd);
        this.CL.removeView(paramdd);
        paramdd.E(true);
        return;
      }
      throw new bo.a("Could not get the parent of the WebView for an overlay.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */