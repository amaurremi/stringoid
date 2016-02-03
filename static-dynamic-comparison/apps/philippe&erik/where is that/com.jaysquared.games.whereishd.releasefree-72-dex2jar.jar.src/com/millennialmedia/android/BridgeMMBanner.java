package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class BridgeMMBanner
  extends MMJSObject
{
  int getScreenHeight(Context paramContext)
  {
    return Integer.parseInt(MMSDK.getDpiHeight(paramContext));
  }
  
  int getScreenWidth(Context paramContext)
  {
    return Integer.parseInt(MMSDK.getDpiWidth(paramContext));
  }
  
  public MMJSResponse resize(HashMap<String, String> paramHashMap)
  {
    MMWebView localMMWebView = (MMWebView)this.mmWebViewRef.get();
    if (localMMWebView != null)
    {
      if (localMMWebView.isMraidResized()) {
        return MMJSResponse.responseWithError("State is currently resized");
      }
      String str1 = (String)paramHashMap.get("width");
      Object localObject = (String)paramHashMap.get("height");
      int i = 0;
      int j = 0;
      if (!TextUtils.isEmpty(str1)) {
        i = (int)Float.parseFloat(str1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        j = (int)Float.parseFloat((String)localObject);
      }
      str1 = (String)paramHashMap.get("customClosePosition");
      localObject = (String)paramHashMap.get("offsetX");
      String str2 = (String)paramHashMap.get("offsetY");
      int k = 0;
      int m = 0;
      if (!TextUtils.isEmpty(str2)) {
        k = (int)Float.parseFloat(str2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        m = (int)Float.parseFloat((String)localObject);
      }
      boolean bool = Boolean.parseBoolean((String)paramHashMap.get("allowOffscreen"));
      paramHashMap = localMMWebView.getContext();
      localObject = MMSDK.getMetrics(paramHashMap);
      int n = getScreenWidth(paramHashMap);
      int i1 = getScreenHeight(paramHashMap);
      localMMWebView.setMraidResize(new DTOResizeParameters(((DisplayMetrics)localObject).density, i, j, str1, m, k, bool, n, i1));
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/BridgeMMBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */