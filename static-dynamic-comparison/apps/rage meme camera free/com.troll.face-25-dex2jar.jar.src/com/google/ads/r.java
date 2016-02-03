package com.google.ads;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import java.util.HashMap;
import java.util.Locale;

public class r
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    str = (String)paramHashMap.get("u");
    if (str == null)
    {
      b.e("Could not get URL from click gmsg.");
      return;
    }
    g localg = paramd.n();
    if (localg != null)
    {
      paramHashMap = Uri.parse(str);
      paramWebView = paramHashMap.getHost();
      if ((paramWebView != null) && (paramWebView.toLowerCase(Locale.US).endsWith(".admob.com")))
      {
        paramWebView = null;
        Object localObject = paramHashMap.getPath();
        paramHashMap = paramWebView;
        if (localObject != null)
        {
          localObject = ((String)localObject).split("/");
          paramHashMap = paramWebView;
          if (localObject.length >= 4) {
            paramHashMap = localObject[2] + "/" + localObject[3];
          }
        }
        localg.a(paramHashMap);
      }
    }
    paramHashMap = paramd.i();
    paramWebView = (Context)paramHashMap.f.a();
    paramd = Uri.parse(str);
    try
    {
      paramHashMap = (al)paramHashMap.s.a();
      if ((paramHashMap == null) || (!paramHashMap.a(paramd))) {
        break label233;
      }
      paramHashMap = paramHashMap.a(paramd, paramWebView);
      paramd = paramHashMap;
    }
    catch (am paramHashMap)
    {
      for (;;)
      {
        b.e("Unable to append parameter to URL: " + str);
      }
    }
    new Thread(new ae(paramd.toString(), paramWebView)).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */