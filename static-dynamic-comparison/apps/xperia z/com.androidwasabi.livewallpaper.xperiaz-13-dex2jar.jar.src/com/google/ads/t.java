package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class t
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    if ((paramWebView instanceof AdWebView))
    {
      ((AdWebView)paramWebView).setCustomClose("1".equals(paramHashMap.get("custom_close")));
      return;
    }
    b.b("Trying to set a custom close icon on a WebView that isn't an AdWebView");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */