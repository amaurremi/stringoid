package com.google.ads;

import android.app.Activity;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;
import java.util.HashMap;

public class ab
  implements o
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    if ((Activity)paramd.i().c.a() == null) {
      b.e("Activity was null while responding to touch gmsg.");
    }
    for (;;)
    {
      return;
      paramWebView = (String)paramHashMap.get("tx");
      String str = (String)paramHashMap.get("ty");
      paramHashMap = (String)paramHashMap.get("td");
      try
      {
        int i = Integer.parseInt(paramWebView);
        int j = Integer.parseInt(str);
        int k = Integer.parseInt(paramHashMap);
        paramd = (ak)paramd.i().r.a();
        if (paramd != null)
        {
          paramd.a(i, j, k);
          return;
        }
      }
      catch (NumberFormatException paramd)
      {
        b.e("Could not parse touch parameters from gmsg.");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */