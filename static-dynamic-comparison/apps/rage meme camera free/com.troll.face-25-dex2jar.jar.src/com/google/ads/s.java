package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class s
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    if ((paramWebView instanceof AdWebView))
    {
      ((AdWebView)paramWebView).f();
      return;
    }
    b.b("Trying to close WebView that isn't an AdWebView");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */