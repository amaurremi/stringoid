package com.venticake.retrica.a;

import android.os.AsyncTask;
import android.util.Log;
import com.amazon.inapp.purchasing.Receipt;
import java.util.Iterator;
import java.util.Set;

class f
  extends AsyncTask<g, Void, Boolean>
{
  private f(a parama) {}
  
  protected Boolean a(g... paramVarArgs)
  {
    Object localObject1 = paramVarArgs[0];
    paramVarArgs = ((g)localObject1).c();
    Object localObject2 = ((g)localObject1).a().iterator();
    if (!((Iterator)localObject2).hasNext()) {
      localObject1 = ((g)localObject1).b().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        return Boolean.valueOf(true);
        Receipt localReceipt = (Receipt)((Iterator)localObject2).next();
        Log.i("amazon_iap", "PurchaseUpdatesAsyncTask.doInBackground: receipt itemType (" + localReceipt.getItemType() + ") SKU (" + localReceipt.getSku() + ") purchaseToken (" + localReceipt.getPurchaseToken() + ")");
        String str = localReceipt.getSku();
        Log.i("amazon_iap", "PurchaseUpdatesAsyncTask.doInBackground: call onPurchaseUpdatesResponseSuccessSku for sku (" + str + ")");
        a.a(this.a).b(paramVarArgs, str, localReceipt.getPurchaseToken());
        Log.i("amazon_iap", "PurchaseUpdatesAsyncTask.doInBackground: completed for receipt with purchaseToken (" + localReceipt.getPurchaseToken() + ")");
        break;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      Log.i("amazon_iap", "PurchaseUpdatesAsyncTask.doInBackground: call onPurchaseUpdatesResponseSuccessRevokedSku for revoked sku (" + (String)localObject2 + ")");
      a.a(this.a).d(paramVarArgs, (String)localObject2);
      a.b(this.a).d((String)localObject2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */