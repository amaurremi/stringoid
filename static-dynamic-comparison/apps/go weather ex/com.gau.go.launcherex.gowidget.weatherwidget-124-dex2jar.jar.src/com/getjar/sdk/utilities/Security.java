package com.getjar.sdk.utilities;

import android.content.Context;
import com.getjar.sdk.data.GooglePurchaseResponse;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.security.SecureRandom;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Security
{
  private static final SecureRandom RANDOM = new SecureRandom();
  private static long knownNonce;
  
  public static long generateNonce()
  {
    knownNonce = RANDOM.nextLong();
    return knownNonce;
  }
  
  public static ArrayList<GooglePurchaseResponse> getPurchaseDetails(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null)
    {
      Logger.e(Area.BUY_GOLD.value(), "data is null", new Object[0]);
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      if (paramContext == null) {
        throw new IllegalArgumentException("context cannot be null");
      }
      int i = 0;
      try
      {
        paramContext = new JSONObject(paramString1);
        Logger.w(Area.BUY_GOLD.value(), "JSONData: %1$s", new Object[] { paramContext.toString() });
        JSONArray localJSONArray = paramContext.optJSONArray("orders");
        if (localJSONArray != null) {
          i = localJSONArray.length();
        }
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        for (;;)
        {
          paramContext = localArrayList;
          if (j >= i) {
            break;
          }
          try
          {
            Object localObject = localJSONArray.getJSONObject(j);
            Constants.PurchaseState localPurchaseState = Constants.PurchaseState.valueOf(((JSONObject)localObject).getInt("purchaseState"));
            String str1 = ((JSONObject)localObject).getString("productId");
            String str2 = ((JSONObject)localObject).optString("orderId", "");
            paramContext = null;
            if (((JSONObject)localObject).has("notificationId")) {
              paramContext = ((JSONObject)localObject).getString("notificationId");
            }
            localObject = ((JSONObject)localObject).optString("developerPayload", null);
            if (localPurchaseState == Constants.PurchaseState.PURCHASED) {
              localArrayList.add(new GooglePurchaseResponse(paramContext, str2, str1, (short)localPurchaseState.ordinal(), (String)localObject, paramString1, paramString2));
            }
          }
          catch (JSONException paramString1)
          {
            Logger.e(Area.BUY_GOLD.value(), paramString1, "JSON exception: ", new Object[0]);
            return null;
          }
          j += 1;
        }
        return null;
      }
      catch (JSONException paramString1) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/Security.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */