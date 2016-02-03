package com.google.ads;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.util.b;
import java.util.HashMap;
import java.util.Locale;

public class q
  extends u
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    Object localObject1 = (String)paramHashMap.get("u");
    if (localObject1 == null)
    {
      b.e("Could not get URL from click gmsg.");
      return;
    }
    g localg = paramd.m();
    if (localg != null)
    {
      localObject1 = Uri.parse((String)localObject1);
      String str = ((Uri)localObject1).getHost();
      if ((str != null) && (str.toLowerCase(Locale.US).endsWith(".admob.com")))
      {
        str = null;
        Object localObject2 = ((Uri)localObject1).getPath();
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).split("/");
          localObject1 = str;
          if (localObject2.length >= 4) {
            localObject1 = localObject2[2] + "/" + localObject2[3];
          }
        }
        localg.a((String)localObject1);
      }
    }
    super.a(paramd, paramHashMap, paramWebView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */