package com.appflood.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.appflood.e.j;
import java.io.UnsupportedEncodingException;

public class MraidBrowserActivity
  extends Activity
{
  private WebView a;
  private String b;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getIntent().getStringExtra("url");
    try
    {
      this.b = new String(this.b.getBytes("utf-8"), "utf-8");
      this.a = new WebView(this);
      paramBundle = this.a.getSettings();
      paramBundle.setJavaScriptEnabled(true);
      paramBundle.setSupportZoom(true);
      paramBundle.setBuiltInZoomControls(false);
      paramBundle.setUseWideViewPort(true);
      setContentView(this.a);
      this.a.setWebViewClient(new WebViewClient()
      {
        public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        }
        
        public final void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        }
        
        public final void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          Toast.makeText((Activity)paramAnonymousWebView.getContext(), "MRAID error: " + paramAnonymousString1, 0).show();
        }
        
        public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (paramAnonymousString == null) {}
          String str;
          do
          {
            return false;
            paramAnonymousWebView = Uri.parse(paramAnonymousString);
            str = paramAnonymousWebView.getHost();
            new StringBuilder(" uri = ").append(paramAnonymousWebView).append(" host ").append(str).toString();
            j.a();
          } while (((paramAnonymousString.startsWith("http:")) || (paramAnonymousString.startsWith("https:"))) && (!"play.google.com".equals(str)) && (!"market.android.com".equals(str)));
          try
          {
            MraidBrowserActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString)));
            MraidBrowserActivity.this.finish();
            return true;
          }
          catch (ActivityNotFoundException paramAnonymousWebView)
          {
            for (;;)
            {
              j.b(paramAnonymousWebView, "Not support ");
            }
          }
        }
      });
      this.a.setWebChromeClient(new WebChromeClient()
      {
        public final boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
        {
          new StringBuilder("jsAlert url ").append(paramAnonymousString1).append(" message ").append(paramAnonymousString2).append(" finishing ").append(MraidBrowserActivity.this.isFinishing()).toString();
          j.a();
          return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        }
        
        public final void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          new StringBuilder(" onProgressChanged ").append(paramAnonymousInt).toString();
          j.a();
          Activity localActivity = (Activity)paramAnonymousWebView.getContext();
          localActivity.setTitle("Loading...");
          localActivity.setProgress(paramAnonymousInt * 100);
          if (paramAnonymousInt == 100) {
            localActivity.setTitle(paramAnonymousWebView.getUrl());
          }
        }
      });
      this.a.loadUrl(this.b);
      return;
    }
    catch (UnsupportedEncodingException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void onDestroy()
  {
    j.a();
    super.onDestroy();
    if (this.a != null)
    {
      this.a.removeAllViews();
      this.a.destroy();
      this.a = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/MraidBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */