package com.greystripe.sdk;

import android.webkit.JavascriptInterface;

final class as
{
  private GSFullscreenActivity a;
  private int b = -1;
  private boolean c = false;
  private boolean d = false;
  
  final void a()
  {
    this.a = null;
    this.b = -1;
    this.c = false;
    this.d = false;
  }
  
  final void a(GSFullscreenActivity paramGSFullscreenActivity)
  {
    bd.b("setActivity()", new Object[0]);
    this.a = paramGSFullscreenActivity;
    if (this.c) {
      lockOrientation();
    }
    for (;;)
    {
      GSFullscreenAd.c.j().b("EventHandler.broadcastEvent('orientationchange', " + getOrientation() + ");");
      return;
      this.a.setRequestedOrientation(2);
    }
  }
  
  @JavascriptInterface
  public final void close()
  {
    bd.b("FullscreenAdController#close", new Object[0]);
    if (this.a != null)
    {
      bd.b("Finishing the Activity", new Object[0]);
      this.a.finish();
    }
  }
  
  @JavascriptInterface
  public final int getOrientation()
  {
    int j = 2;
    if (this.a != null)
    {
      int i;
      if (this.b != -1) {
        switch (this.b)
        {
        default: 
          i = 0;
          switch (i)
          {
          default: 
            bd.c("Java: Unknown orientation: " + i, new Object[0]);
            j = 0;
          }
          break;
        }
      }
      for (;;)
      {
        bd.b("Java: getOrientation(" + i + ") returned: " + j, new Object[0]);
        return j;
        i = 2;
        break;
        i = 1;
        break;
        i = this.a.a();
        break;
        j = 0;
        continue;
        j = 1;
      }
    }
    return 0;
  }
  
  @JavascriptInterface
  public final void lockOrientation()
  {
    this.c = true;
    if ((this.a != null) && (!this.d))
    {
      this.d = true;
      if (this.b != -1) {
        this.a.a(this.b);
      }
    }
    else
    {
      return;
    }
    this.a.b();
  }
  
  @JavascriptInterface
  public final void setOrientation(int paramInt)
  {
    int i = 0;
    bd.b("fscontroller#setOrientation(" + paramInt + ")", new Object[0]);
    if (paramInt == 1) {}
    for (paramInt = i; this.a == null; paramInt = 1)
    {
      this.b = paramInt;
      this.c = true;
      return;
    }
    this.a.a(paramInt);
  }
  
  @JavascriptInterface
  public final void takeScreenshot()
  {
    if (this.a != null) {
      this.a.takeScreenshot();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */