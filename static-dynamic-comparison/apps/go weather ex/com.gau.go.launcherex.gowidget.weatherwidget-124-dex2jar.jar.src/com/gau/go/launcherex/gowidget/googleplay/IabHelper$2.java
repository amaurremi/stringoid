package com.gau.go.launcherex.gowidget.googleplay;

import android.os.Handler;
import java.util.List;

class IabHelper$2
  implements Runnable
{
  IabHelper$2(IabHelper paramIabHelper, boolean paramBoolean, List paramList, IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener, Handler paramHandler) {}
  
  public void run()
  {
    IabResult localIabResult1 = new IabResult(0, "Inventory refresh successful.");
    Object localObject = null;
    try
    {
      Inventory localInventory = this.this$0.queryInventory(this.val$querySkuDetails, this.val$moreSkus);
      localObject = localInventory;
    }
    catch (IabException localIabException)
    {
      for (;;)
      {
        IabResult localIabResult2 = localIabException.getResult();
      }
    }
    this.this$0.flagEndAsync();
    if ((!this.this$0.mDisposed) && (this.val$listener != null)) {
      this.val$handler.post(new IabHelper.2.1(this, localIabResult1, (Inventory)localObject));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/IabHelper$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */