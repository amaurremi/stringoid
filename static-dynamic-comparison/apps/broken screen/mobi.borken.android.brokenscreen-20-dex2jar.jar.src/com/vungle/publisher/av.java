package com.vungle.publisher;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.vungle.publisher.log.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public final class av
  extends WebChromeClient
{
  private a a;
  
  public av(a parama)
  {
    this.a = parama;
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    Logger.v("VungleAd", "js prompt: " + paramString2);
    boolean bool = paramString2.startsWith("vungle:");
    if (bool) {
      paramWebView = null;
    }
    for (;;)
    {
      try
      {
        paramString1 = paramString2.substring(7);
        paramWebView = paramString1;
        paramString2 = new JSONObject(paramString1);
        paramWebView = paramString1;
        paramString3 = paramString2.getString("method");
        paramWebView = paramString1;
        paramString2.getString("params");
        paramWebView = paramString1;
        if (!"close".equalsIgnoreCase(paramString3)) {
          continue;
        }
        paramWebView = paramString1;
        this.a.a();
      }
      catch (IndexOutOfBoundsException paramWebView)
      {
        Logger.w("VungleAd", "no javascript method call");
        continue;
        paramWebView = paramString1;
        if (!"replay".equalsIgnoreCase(paramString3)) {
          continue;
        }
        paramWebView = paramString1;
        this.a.c();
        continue;
      }
      catch (JSONException paramString1)
      {
        Logger.w("VungleAd", "invalid json " + paramWebView, paramString1);
        continue;
        paramWebView = paramString1;
        Logger.w("VungleAd", "unknown javascript method: " + paramString3);
        continue;
      }
      catch (Exception paramWebView)
      {
        Logger.e("VungleAd", paramWebView);
        continue;
      }
      paramJsPromptResult.cancel();
      return bool;
      paramWebView = paramString1;
      if (!"download".equalsIgnoreCase(paramString3)) {
        continue;
      }
      paramWebView = paramString1;
      this.a.b();
    }
  }
  
  public static class a
  {
    public void a() {}
    
    public void b() {}
    
    public void c() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */