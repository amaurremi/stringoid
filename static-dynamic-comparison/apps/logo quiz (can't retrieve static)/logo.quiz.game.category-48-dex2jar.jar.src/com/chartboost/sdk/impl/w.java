package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.c;
import com.chartboost.sdk.c.a;
import com.chartboost.sdk.c.b;
import com.chartboost.sdk.c.c;
import java.net.URI;
import java.net.URLDecoder;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class w
  extends c
{
  private String h = null;
  
  public w(a parama)
  {
    super(parama);
  }
  
  protected c.b a(Context paramContext)
  {
    return new a(paramContext, this.h);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("html");
    if (paramJSONObject == null)
    {
      this.g.a(CBError.CBImpressionError.INTERNAL);
      return;
    }
    this.h = paramJSONObject;
    b();
  }
  
  public class a
    extends c.b
  {
    public WebView c;
    
    public a(Context paramContext, String paramString)
    {
      super(paramContext);
      setFocusable(false);
      this.c = new w.b(w.this, paramContext);
      this.c.setWebViewClient(new w.c(w.this, w.this));
      addView(this.c);
      this.c.loadDataWithBaseURL("file:///android_asset/", paramString, "text/html", "utf-8", null);
    }
    
    protected void a(int paramInt1, int paramInt2) {}
  }
  
  private class b
    extends WebView
  {
    public b(Context paramContext)
    {
      super();
      setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      setBackgroundColor(0);
      getSettings().setJavaScriptEnabled(true);
    }
    
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      if (((paramInt == 4) || (paramInt == 3)) && (w.this.a != null)) {
        w.this.a.a();
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
  }
  
  private class c
    extends WebViewClient
  {
    private w b;
    
    public c(w paramw)
    {
      this.b = paramw;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if ((this.b != null) && (this.b.c != null)) {
        this.b.c.a();
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      w.a(w.this).a(CBError.CBImpressionError.INTERNAL);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      WebView localWebView = null;
      CBLogging.d("CBWebViewProtocol", "loading url: " + paramString);
      Integer localInteger;
      try
      {
        paramWebView = new URI(paramString).getScheme();
        if (!paramWebView.equals("chartboost")) {
          break label154;
        }
        paramWebView = paramString.split("/");
        localInteger = Integer.valueOf(paramWebView.length);
        if (localInteger.intValue() >= 3) {
          break label119;
        }
        if (this.b.a != null) {
          this.b.a.a();
        }
      }
      catch (Exception paramWebView)
      {
        while (this.b.a == null) {}
        this.b.a.a();
        return false;
      }
      return false;
      label119:
      paramString = paramWebView[2];
      if (paramString.equals("close")) {
        if (this.b.a != null) {
          this.b.a.a();
        }
      }
      for (;;)
      {
        label154:
        return true;
        if (!paramString.equals("link")) {
          continue;
        }
        if (localInteger.intValue() < 4)
        {
          if (this.b.a == null) {
            break;
          }
          this.b.a.a();
          return false;
        }
        try
        {
          paramString = URLDecoder.decode(paramWebView[3], "UTF-8");
        }
        catch (Exception paramString)
        {
          try
          {
            if (localInteger.intValue() > 4)
            {
              paramWebView = new JSONObject(new JSONTokener(URLDecoder.decode(paramWebView[4], "UTF-8")));
              localWebView = paramWebView;
              paramWebView = paramString;
              while (this.b.b != null)
              {
                this.b.b.a(w.b(w.this), paramWebView, localWebView);
                break;
                paramString = paramString;
                paramWebView = null;
                CBLogging.b("CBWebViewProtocol", "Error decoding URL or JSON", paramString);
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramWebView = paramString;
              paramString = localException;
              continue;
              paramWebView = null;
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */