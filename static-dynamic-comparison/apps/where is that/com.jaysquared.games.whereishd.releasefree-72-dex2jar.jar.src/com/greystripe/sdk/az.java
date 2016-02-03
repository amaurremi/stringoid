package com.greystripe.sdk;

import java.util.TimerTask;

final class az
  extends TimerTask
{
  az(GSFullscreenActivity paramGSFullscreenActivity) {}
  
  public final void run()
  {
    if (GSFullscreenActivity.a(this.a) != null)
    {
      bd.b("autofocusing", new Object[0]);
      GSFullscreenActivity.a(this.a).a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */