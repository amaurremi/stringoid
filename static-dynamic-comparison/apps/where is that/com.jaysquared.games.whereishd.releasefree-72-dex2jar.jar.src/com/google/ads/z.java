package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.util.b;
import java.util.HashMap;

public class z
  implements o
{
  private AdActivity.StaticMethodWrapper a;
  
  public z()
  {
    this(new AdActivity.StaticMethodWrapper());
  }
  
  public z(AdActivity.StaticMethodWrapper paramStaticMethodWrapper)
  {
    this.a = paramStaticMethodWrapper;
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    paramWebView = (String)paramHashMap.get("a");
    if (paramWebView == null)
    {
      b.a("Could not get the action parameter for open GMSG.");
      return;
    }
    if (paramWebView.equals("webapp"))
    {
      this.a.launchAdActivity(paramd, new e("webapp", paramHashMap));
      return;
    }
    if (paramWebView.equals("expand"))
    {
      this.a.launchAdActivity(paramd, new e("expand", paramHashMap));
      return;
    }
    this.a.launchAdActivity(paramd, new e("intent", paramHashMap));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */