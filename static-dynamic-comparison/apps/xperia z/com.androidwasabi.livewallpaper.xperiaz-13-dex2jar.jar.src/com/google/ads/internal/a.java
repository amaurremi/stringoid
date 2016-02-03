package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.o;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
{
  public static final f<a> a = new a.2();
  public static final Map<String, o> b = Collections.unmodifiableMap(new a.3());
  public static final Map<String, o> c = Collections.unmodifiableMap(new a.4());
  public static final Map<String, o> d = Collections.unmodifiableMap(new a.1());
  private static final a e = new a();
  
  public String a(Uri paramUri, HashMap<String, String> paramHashMap)
  {
    if (c(paramUri))
    {
      String str = paramUri.getHost();
      if (str == null)
      {
        b.e("An error occurred while parsing the AMSG parameters.");
        return null;
      }
      if (str.equals("launch"))
      {
        paramHashMap.put("a", "intent");
        paramHashMap.put("u", paramHashMap.get("url"));
        paramHashMap.remove("url");
        return "/open";
      }
      if (str.equals("closecanvas")) {
        return "/close";
      }
      if (str.equals("log")) {
        return "/log";
      }
      b.e("An error occurred while parsing the AMSG: " + paramUri.toString());
      return null;
    }
    if (b(paramUri)) {
      return paramUri.getPath();
    }
    b.e("Message was neither a GMSG nor an AMSG.");
    return null;
  }
  
  public void a(WebView paramWebView)
  {
    a(paramWebView, "onshow", "{'version': 'afma-sdk-a-v6.4.1'}");
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    b.a("Sending JS to a WebView: " + paramString);
    paramWebView.loadUrl("javascript:" + paramString);
  }
  
  public void a(WebView paramWebView, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      a(paramWebView, "AFMA_ReceiveMessage" + "('" + paramString1 + "', " + paramString2 + ");");
      return;
    }
    a(paramWebView, "AFMA_ReceiveMessage" + "('" + paramString1 + "');");
  }
  
  public void a(WebView paramWebView, Map<String, Boolean> paramMap)
  {
    a(paramWebView, "openableURLs", new JSONObject(paramMap).toString());
  }
  
  public void a(d paramd, Map<String, o> paramMap, Uri paramUri, WebView paramWebView)
  {
    HashMap localHashMap = AdUtil.b(paramUri);
    if (localHashMap == null)
    {
      b.e("An error occurred while parsing the message parameters.");
      return;
    }
    paramUri = a(paramUri, localHashMap);
    if (paramUri == null)
    {
      b.e("An error occurred while parsing the message.");
      return;
    }
    paramMap = (o)paramMap.get(paramUri);
    if (paramMap == null)
    {
      b.e("No AdResponse found, <message: " + paramUri + ">");
      return;
    }
    paramMap.a(paramd, localHashMap, paramWebView);
  }
  
  public boolean a(Uri paramUri)
  {
    if ((paramUri == null) || (!paramUri.isHierarchical())) {}
    while ((!b(paramUri)) && (!c(paramUri))) {
      return false;
    }
    return true;
  }
  
  public void b(WebView paramWebView)
  {
    a(paramWebView, "onhide", null);
  }
  
  public boolean b(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (!str.equals("gmsg"))) {}
    do
    {
      return false;
      paramUri = paramUri.getAuthority();
    } while ((paramUri == null) || (!paramUri.equals("mobileads.google.com")));
    return true;
  }
  
  public boolean c(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return (paramUri != null) && (paramUri.equals("admob"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */