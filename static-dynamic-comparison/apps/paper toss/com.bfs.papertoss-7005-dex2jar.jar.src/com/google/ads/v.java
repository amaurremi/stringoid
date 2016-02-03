package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class v
  implements n
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramWebView = (String)paramHashMap.get("type");
    paramHashMap = (String)paramHashMap.get("errors");
    b.e("Invalid " + paramWebView + " request error: " + paramHashMap);
    paramd = paramd.j();
    if (paramd != null) {
      paramd.a(AdRequest.ErrorCode.INVALID_REQUEST);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */