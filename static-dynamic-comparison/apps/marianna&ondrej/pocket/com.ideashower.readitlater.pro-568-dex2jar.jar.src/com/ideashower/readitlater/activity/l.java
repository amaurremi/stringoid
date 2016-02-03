package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ideashower.readitlater.a.g;
import com.pocket.p.o;
import org.apache.a.c.k;

class l
  extends WebViewClient
{
  private l(BasicWebViewActivity paramBasicWebViewActivity) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    if (paramString.startsWith("browser::"))
    {
      this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(k.a(paramString, "browser::", ""))));
      bool = true;
    }
    do
    {
      return bool;
      if (paramString.startsWith("webview::"))
      {
        paramWebView = new Intent(this.a, BasicWebViewActivity.class);
        paramWebView.putExtra("pathToLoad", k.a(paramString, "webview::", ""));
        this.a.startActivity(paramWebView);
        return true;
      }
      if (paramString.startsWith("mailto:"))
      {
        paramWebView = new Intent("android.intent.action.SEND");
        paramWebView.setType("plain/text");
        paramWebView.putExtra("android.intent.extra.EMAIL", new String[] { k.a(paramString, "mailto:", "") });
        if (o.a(this.a, paramWebView)) {
          this.a.startActivity(paramWebView);
        }
        return true;
      }
      if (paramString.startsWith("intent::NewUser")) {
        return true;
      }
    } while (!paramString.startsWith("intent::openPendingSupport"));
    paramString = this.a.getIntent();
    paramWebView = null;
    if (paramString != null) {
      paramWebView = paramString.getStringExtra("com.ideashower.readitlater.extra.pendingSupportUrl");
    }
    paramString = paramWebView;
    if (paramWebView == null) {
      paramString = "http://support.readitlaterlist.com/discussion/new?discussion[title]=Android App Issue";
    }
    g.a(this.a, paramString);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */