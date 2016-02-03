package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class aa
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    int m = -1;
    if ((paramWebView instanceof ActivationOverlay)) {}
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)paramHashMap.get("w"))) {
          break label247;
        }
        i = Integer.parseInt((String)paramHashMap.get("w"));
        if (TextUtils.isEmpty((CharSequence)paramHashMap.get("h"))) {
          break label241;
        }
        j = Integer.parseInt((String)paramHashMap.get("h"));
        if (TextUtils.isEmpty((CharSequence)paramHashMap.get("x"))) {
          break label235;
        }
        k = Integer.parseInt((String)paramHashMap.get("x"));
        if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("y"))) {
          m = Integer.parseInt((String)paramHashMap.get("y"));
        }
        if ((paramHashMap.get("a") != null) && (((String)paramHashMap.get("a")).equals("1")))
        {
          paramd.a(null, true, k, m, i, j);
          return;
        }
      }
      catch (NumberFormatException paramd)
      {
        b.d("Invalid number format in activation overlay response.", paramd);
        return;
      }
      if ((paramHashMap.get("a") != null) && (((String)paramHashMap.get("a")).equals("0")))
      {
        paramd.a(null, false, k, m, i, j);
        return;
      }
      paramd.a(k, m, i, j);
      return;
      b.b("Trying to activate an overlay when this is not an overlay.");
      return;
      label235:
      int k = -1;
      continue;
      label241:
      int j = -1;
      continue;
      label247:
      int i = -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */