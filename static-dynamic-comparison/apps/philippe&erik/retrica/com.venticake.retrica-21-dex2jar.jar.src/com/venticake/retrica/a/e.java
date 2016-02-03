package com.venticake.retrica.a;

import android.os.AsyncTask;
import android.util.Log;

class e
  extends AsyncTask<b, Void, Boolean>
{
  private e(a parama) {}
  
  protected Boolean a(b... paramVarArgs)
  {
    Object localObject = paramVarArgs[0];
    paramVarArgs = ((b)localObject).a();
    String str1 = ((b)localObject).b();
    String str2 = ((b)localObject).f();
    localObject = ((b)localObject).e();
    Log.i("amazon_iap", "PurchaseResponseSuccessAsyncTask.doInBackground: call listener's onPurchaseResponseSucccess for sku (" + str2 + ")");
    a.a(this.a).a(str1, str2, (String)localObject);
    Log.d("amazon_iap", "PurchaseResponseSuccessAsyncTask.doInBackground: fulfilled SKU (" + str2 + ") purchaseToken (" + (String)localObject + ")");
    a.b(this.a).h((String)localObject);
    a.b(this.a).f(paramVarArgs);
    Log.d("amazon_iap", "PurchaseResponseSuccessAsyncTask.doInBackground: completed for requestId (" + paramVarArgs + ")");
    return Boolean.valueOf(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */