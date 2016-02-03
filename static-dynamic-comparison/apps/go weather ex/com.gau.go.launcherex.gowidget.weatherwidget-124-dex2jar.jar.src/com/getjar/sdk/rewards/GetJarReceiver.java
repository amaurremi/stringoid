package com.getjar.sdk.rewards;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Constants.ResponseCode;

public class GetJarReceiver
  extends BroadcastReceiver
{
  private void checkResponseCode(Context paramContext, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("com.android.vending.billing.RESPONSE_CODE");
    localIntent.setClass(paramContext, GetJarService.class);
    localIntent.putExtra("request_id", paramLong);
    localIntent.putExtra("response_code", paramInt);
    paramContext.startService(localIntent);
  }
  
  private void notify(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("com.getjar.sdk.GET_PURCHASE_INFORMATION");
    localIntent.setClass(paramContext, GetJarService.class);
    localIntent.putExtra("notification_id", paramString);
    paramContext.startService(localIntent);
  }
  
  private void purchaseStateChanged(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.android.vending.billing.PURCHASE_STATE_CHANGED");
    localIntent.setClass(paramContext, GetJarService.class);
    localIntent.putExtra("inapp_signed_data", paramString1);
    localIntent.putExtra("inapp_signature", paramString2);
    paramContext.startService(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    try
    {
      str = paramIntent.getAction();
      Logger.d(Area.TRANSACTION.value() | Area.OS_ENTRY_POINT.value(), "GooglePlayBillingReceiver onReceive -- action " + str, new Object[0]);
      if ("com.android.vending.billing.PURCHASE_STATE_CHANGED".equals(str))
      {
        purchaseStateChanged(paramContext, paramIntent.getStringExtra("inapp_signed_data"), paramIntent.getStringExtra("inapp_signature"));
        return;
      }
      if ("com.android.vending.billing.IN_APP_NOTIFY".equals(str))
      {
        notify(paramContext, paramIntent.getStringExtra("notification_id"));
        return;
      }
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.TRANSACTION.value() | Area.OS_ENTRY_POINT.value(), paramContext, "GetJarReceiver: onReceive() failed", new Object[0]);
      return;
    }
    if ("com.android.vending.billing.RESPONSE_CODE".equals(str))
    {
      checkResponseCode(paramContext, paramIntent.getLongExtra("request_id", -1L), paramIntent.getIntExtra("response_code", Constants.ResponseCode.RESULT_ERROR.ordinal()));
      return;
    }
    Logger.w(Area.TRANSACTION.value() | Area.OS_ENTRY_POINT.value(), "unexpected action: " + str, new Object[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */