package com.google.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;

public class q
  implements o
{
  private static final a a = (a)a.a.b();
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramd = (String)paramHashMap.get("urls");
    if (paramd == null)
    {
      b.e("Could not get the urls param from canOpenURLs gmsg.");
      return;
    }
    paramHashMap = paramd.split(",");
    HashMap localHashMap = new HashMap();
    PackageManager localPackageManager = paramWebView.getContext().getPackageManager();
    int j = paramHashMap.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramHashMap[i];
      paramd = ((String)localObject).split(";", 2);
      String str = paramd[0];
      if (paramd.length >= 2)
      {
        paramd = paramd[1];
        label89:
        if (localPackageManager.resolveActivity(new Intent(paramd, Uri.parse(str)), 65536) == null) {
          break label143;
        }
      }
      label143:
      for (boolean bool = true;; bool = false)
      {
        localHashMap.put(localObject, Boolean.valueOf(bool));
        i += 1;
        break;
        paramd = "android.intent.action.VIEW";
        break label89;
      }
    }
    a.a(paramWebView, localHashMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */