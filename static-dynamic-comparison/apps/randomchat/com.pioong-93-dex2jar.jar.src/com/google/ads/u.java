package com.google.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import java.util.HashMap;

public class u
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramHashMap = (String)paramHashMap.get("u");
    if (TextUtils.isEmpty(paramHashMap))
    {
      b.e("Could not get URL from track gmsg.");
      return;
    }
    new Thread(new ae(paramHashMap, (Context)paramd.i().f.a())).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */