package com.gau.go.launcherex.gowidget.googleplay;

import java.util.List;

class IabHelper$3$1
  implements Runnable
{
  IabHelper$3$1(IabHelper.3 param3, List paramList) {}
  
  public void run()
  {
    this.this$1.val$singleListener.onConsumeFinished((Purchase)this.this$1.val$purchases.get(0), (IabResult)this.val$results.get(0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/IabHelper$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */