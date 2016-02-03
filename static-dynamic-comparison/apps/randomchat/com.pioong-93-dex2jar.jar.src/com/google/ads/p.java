package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class p
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramWebView = (String)paramHashMap.get("name");
    if (paramWebView == null)
    {
      b.b("Error: App event with no name parameter.");
      return;
    }
    paramd.a(paramWebView, (String)paramHashMap.get("info"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */