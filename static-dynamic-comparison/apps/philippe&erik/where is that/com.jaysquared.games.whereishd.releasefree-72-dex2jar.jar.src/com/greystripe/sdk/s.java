package com.greystripe.sdk;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;

final class s
{
  private View b;
  private ViewGroup.LayoutParams c;
  private z d;
  private FrameLayout e;
  private int f;
  
  private s(c paramc) {}
  
  @JavascriptInterface
  public final void collapse()
  {
    bm.a(new u(this));
  }
  
  @JavascriptInterface
  public final void expand()
  {
    bm.a(new t(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */