package com.google.ads;

import android.content.Context;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class u
  implements n
{
  protected Runnable a(String paramString, WebView paramWebView)
  {
    return new ac(paramString, paramWebView.getContext().getApplicationContext());
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramd = (String)paramHashMap.get("u");
    if (paramd == null)
    {
      b.e("Could not get URL from click gmsg.");
      return;
    }
    new Thread(a(paramd, paramWebView)).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */