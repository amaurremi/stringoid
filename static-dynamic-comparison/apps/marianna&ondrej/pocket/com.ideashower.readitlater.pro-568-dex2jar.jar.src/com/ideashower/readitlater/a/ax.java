package com.ideashower.readitlater.a;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.views.BaseWebView;

public class ax
{
  private static String a;
  private static String b;
  
  private static String a()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 13) {
      return "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24";
    }
    if (i > 10) {
      return "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24";
    }
    return "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Safari/530.17";
  }
  
  public static String a(boolean paramBoolean)
  {
    if ((paramBoolean) || (!i.a(a.I))) {
      return a();
    }
    if (a != null) {
      return a;
    }
    if (b == null) {
      b = i.a(a.af);
    }
    if (b != null) {
      return b;
    }
    return b();
  }
  
  public static void a(BaseWebView paramBaseWebView)
  {
    if (a != null) {
      return;
    }
    paramBaseWebView.getSettings().setUserAgentString(null);
    a = paramBaseWebView.getSettings().getUserAgentString();
    i.b().a(a.af, a).a();
  }
  
  private static String b()
  {
    return "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */