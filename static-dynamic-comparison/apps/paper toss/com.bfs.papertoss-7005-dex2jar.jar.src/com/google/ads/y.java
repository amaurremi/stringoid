package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class y
  implements n
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramd = (String)paramHashMap.get("string");
    paramHashMap = (String)paramHashMap.get("afma_notify_dt");
    b.c("Received log message: <\"string\": \"" + paramd + "\", \"afmaNotifyDt\": \"" + paramHashMap + "\">");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */