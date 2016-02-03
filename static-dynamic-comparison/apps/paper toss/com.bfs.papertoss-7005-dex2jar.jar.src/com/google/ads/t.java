package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;

public class t
  implements n
{
  private static final a a = (a)a.a.b();
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramd = (String)paramHashMap.get("js");
    if (paramd == null)
    {
      b.b("Could not get the JS to evaluate.");
      return;
    }
    if ((paramWebView instanceof AdWebView))
    {
      paramHashMap = ((AdWebView)paramWebView).d();
      if (paramHashMap == null) {
        b.b("Could not get the AdActivity from the AdWebView.");
      }
    }
    else
    {
      b.b("Trying to evaluate JS in a WebView that isn't an AdWebView");
      return;
    }
    paramHashMap = paramHashMap.getOpeningAdWebView();
    if (paramHashMap == null)
    {
      b.b("Could not get the opening WebView.");
      return;
    }
    a.a(paramHashMap, paramd);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */