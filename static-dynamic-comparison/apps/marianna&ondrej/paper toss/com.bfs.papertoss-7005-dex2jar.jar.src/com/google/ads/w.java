package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.c.d;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class w
  implements n
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramWebView = (String)paramHashMap.get("url");
    String str1 = (String)paramHashMap.get("type");
    String str2 = (String)paramHashMap.get("afma_notify_dt");
    boolean bool1 = "1".equals(paramHashMap.get("drt_include"));
    String str3 = (String)paramHashMap.get("request_scenario");
    boolean bool2 = "1".equals(paramHashMap.get("use_webview_loadurl"));
    if (c.d.d.e.equals(str3)) {
      paramHashMap = c.d.d;
    }
    for (;;)
    {
      b.c("Received ad url: <url: \"" + paramWebView + "\" type: \"" + str1 + "\" afmaNotifyDt: \"" + str2 + "\" useWebViewLoadUrl: \"" + bool2 + "\">");
      paramd = paramd.j();
      if (paramd != null)
      {
        paramd.c(bool1);
        paramd.a(paramHashMap);
        paramd.d(bool2);
        paramd.d(paramWebView);
      }
      return;
      if (c.d.c.e.equals(str3)) {
        paramHashMap = c.d.c;
      } else if (c.d.a.e.equals(str3)) {
        paramHashMap = c.d.a;
      } else {
        paramHashMap = c.d.b;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */