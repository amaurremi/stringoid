package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import org.json.JSONObject;

public class h
  extends b
  implements g.b
{
  private WebView b;
  
  public h(Context paramContext)
  {
    super(paramContext);
    this.b = new WebView(paramContext);
    addView(this.b, new LinearLayout.LayoutParams(-1, -1));
    this.b.setBackgroundColor(0);
    this.b.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString == null) {
          return false;
        }
        if ((paramAnonymousString.contains("chartboost")) && (paramAnonymousString.contains("click")) && (h.this.a != null)) {
          h.this.a.onClick(h.this);
        }
        return true;
      }
    });
  }
  
  public int a()
  {
    return CBUtility.a(100, getContext());
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("html");
    if (paramJSONObject != null) {}
    try
    {
      this.b.loadDataWithBaseURL("file:///android_res/", paramJSONObject, "text/html", "UTF-8", null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      CBLogging.b("CBNativeMoreAppsWebViewCell", "Exception raised loading data into webview", paramJSONObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */