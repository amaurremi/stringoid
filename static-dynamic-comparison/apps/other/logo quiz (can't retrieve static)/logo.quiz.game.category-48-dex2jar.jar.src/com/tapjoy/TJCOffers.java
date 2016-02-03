package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.HashMap;

public class TJCOffers
{
  private static final String TAG = "TapjoyOffers";
  Context context;
  
  public TJCOffers(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void showOffers()
  {
    showOffersWithCurrencyID(null, false);
  }
  
  public void showOffersWithCurrencyID(String paramString, boolean paramBoolean)
  {
    showOffersWithCurrencyID(paramString, paramBoolean, null, null);
  }
  
  public void showOffersWithCurrencyID(String paramString1, boolean paramBoolean, TJEventData paramTJEventData, String paramString2)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      HashMap localHashMap = new HashMap(TapjoyConnectCore.getURLParams());
      TapjoyUtil.safePut(localHashMap, "currency_id", paramString1, true);
      TapjoyUtil.safePut(localHashMap, "currency_selector", str, true);
      localHashMap.putAll(TapjoyConnectCore.getVideoParams());
      paramString1 = new Intent(this.context, TJCOffersWebView.class);
      if (paramTJEventData != null) {
        TapjoyLog.i("TapjoyOffers", "showOffers for eventName: " + paramTJEventData.name);
      }
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        paramString1.putExtra("callback_id", paramString2);
      }
      paramString1.putExtra("view_type", 2);
      paramString1.putExtra("tjevent", paramTJEventData);
      paramString1.putExtra("legacy_view", true);
      paramString1.putExtra("URL_PARAMS", localHashMap);
      if (!(this.context instanceof Activity)) {
        break;
      }
      ((Activity)this.context).startActivityForResult(paramString1, 0);
      return;
    }
    paramString1.setFlags(268435456);
    this.context.startActivity(paramString1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJCOffers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */