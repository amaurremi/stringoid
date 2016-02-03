package com.google.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.c.d;
import com.google.ads.internal.d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;

public class w
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str1 = (String)paramHashMap.get("url");
    paramWebView = (String)paramHashMap.get("type");
    Object localObject2 = (String)paramHashMap.get("afma_notify_dt");
    String str2 = (String)paramHashMap.get("activation_overlay_url");
    Object localObject1 = (String)paramHashMap.get("check_packages");
    boolean bool1 = "1".equals(paramHashMap.get("drt_include"));
    String str3 = (String)paramHashMap.get("request_scenario");
    boolean bool2 = "1".equals(paramHashMap.get("use_webview_loadurl"));
    if (c.d.d.e.equals(str3)) {
      paramHashMap = c.d.d;
    }
    for (;;)
    {
      b.c("Received ad url: <url: \"" + str1 + "\" type: \"" + paramWebView + "\" afmaNotifyDt: \"" + (String)localObject2 + "\" activationOverlayUrl: \"" + str2 + "\" useWebViewLoadUrl: \"" + bool2 + "\">");
      paramWebView = str1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label386;
      }
      paramWebView = str1;
      if (TextUtils.isEmpty(str1)) {
        break label386;
      }
      paramWebView = new BigInteger(new byte[1]);
      localObject2 = ((String)localObject1).split(",");
      int i = 0;
      while (i < localObject2.length)
      {
        localObject1 = paramWebView;
        if (AdUtil.a((Context)paramd.i().c.a(), localObject2[i])) {
          localObject1 = paramWebView.setBit(i);
        }
        i += 1;
        paramWebView = (WebView)localObject1;
      }
      if (c.d.c.e.equals(str3)) {
        paramHashMap = c.d.c;
      } else if (c.d.a.e.equals(str3)) {
        paramHashMap = c.d.a;
      } else {
        paramHashMap = c.d.b;
      }
    }
    localObject1 = String.format(Locale.US, "%X", new Object[] { paramWebView });
    paramWebView = str1.replaceAll("%40installed_markets%40", (String)localObject1);
    m.a().a.a(localObject1);
    b.c("Ad url modified to " + paramWebView);
    label386:
    paramd = paramd.k();
    if (paramd != null)
    {
      paramd.d(bool1);
      paramd.a(paramHashMap);
      paramd.e(bool2);
      paramd.e(str2);
      paramd.d(paramWebView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */