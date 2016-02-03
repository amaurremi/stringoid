package com.greystripe.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

abstract class am
  extends z
  implements GSAd
{
  private ai a;
  private Animation b;
  private an c;
  private boolean d;
  
  public am(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null) {
      this.d = paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.greystripe.sdk", "autoload", true);
    }
  }
  
  private void c()
  {
    if (this.a == null) {
      return;
    }
    this.a.c.setBannerView(this);
  }
  
  protected final void a(ai paramai)
  {
    this.a = paramai;
    super.a(this.a);
    this.a.a(this);
    c();
  }
  
  public void addListener(GSAdListener paramGSAdListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.addListener(paramGSAdListener);
  }
  
  protected final boolean b()
  {
    return this.d;
  }
  
  public int getId()
  {
    return this.a.getId();
  }
  
  public boolean isAdReady()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.isAdReady();
  }
  
  public void refresh()
  {
    refresh(false, null, null);
  }
  
  public void refresh(Animation paramAnimation1, Animation paramAnimation2)
  {
    refresh(true, paramAnimation1, paramAnimation2);
  }
  
  public void refresh(boolean paramBoolean)
  {
    refresh(paramBoolean, null, null);
  }
  
  public void refresh(boolean paramBoolean, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (this.a == null) {
      return;
    }
    this.a.d();
    c();
    this.a.a = paramBoolean;
    if (paramBoolean)
    {
      if (paramAnimation1 != null) {
        this.b = paramAnimation1;
      }
      for (;;)
      {
        if (this.c == null)
        {
          this.c = new an(this, (byte)0);
          addListener(this.c);
        }
        if (paramAnimation2 == null) {
          break;
        }
        paramAnimation2.setAnimationListener(new ap(this, (byte)0));
        startAnimation(paramAnimation2);
        return;
        this.b = new AlphaAnimation(0.0F, 1.0F);
        this.b.setDuration(500L);
        this.b.setFillAfter(true);
      }
      paramAnimation1 = new AlphaAnimation(1.0F, 0.0F);
      paramAnimation1.setDuration(500L);
      paramAnimation1.setFillAfter(true);
      paramAnimation1.setAnimationListener(new ap(this, (byte)0));
      startAnimation(paramAnimation1);
      return;
    }
    if (this.c != null)
    {
      clearAnimation();
      removeListener(this.c);
      this.c = null;
    }
    this.a.h();
  }
  
  public void removeListener(GSAdListener paramGSAdListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.removeListener(paramGSAdListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */