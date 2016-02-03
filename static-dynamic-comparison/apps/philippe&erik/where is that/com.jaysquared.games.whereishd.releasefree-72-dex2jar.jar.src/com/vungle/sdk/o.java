package com.vungle.sdk;

import android.content.Context;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

final class o
{
  FrameLayout a;
  WebView b;
  
  public o(Context paramContext)
  {
    this.a = new FrameLayout(paramContext);
    this.b = new WebView(paramContext);
    this.a.addView(this.b);
    paramContext = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    paramContext.gravity = 17;
    paramContext.width = -1;
    paramContext.height = -1;
    this.b.setLayoutParams(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */