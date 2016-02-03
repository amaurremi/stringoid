package com.gau.go.launcherex.gowidget.googleplay;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class IabHelper$3
  implements Runnable
{
  IabHelper$3(IabHelper paramIabHelper, List paramList, IabHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener, Handler paramHandler, IabHelper.OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.val$purchases.iterator();
    while (localIterator.hasNext())
    {
      Purchase localPurchase = (Purchase)localIterator.next();
      try
      {
        this.this$0.consume(localPurchase);
        localArrayList.add(new IabResult(0, "Successful consume of sku " + localPurchase.getSku()));
      }
      catch (IabException localIabException)
      {
        localArrayList.add(localIabException.getResult());
      }
    }
    this.this$0.flagEndAsync();
    if ((!this.this$0.mDisposed) && (this.val$singleListener != null)) {
      this.val$handler.post(new IabHelper.3.1(this, localArrayList));
    }
    if ((!this.this$0.mDisposed) && (this.val$multiListener != null)) {
      this.val$handler.post(new IabHelper.3.2(this, localArrayList));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/IabHelper$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */