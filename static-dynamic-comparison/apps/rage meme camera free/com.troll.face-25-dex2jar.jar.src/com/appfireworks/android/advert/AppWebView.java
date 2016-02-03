package com.appfireworks.android.advert;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appfireworks.android.listener.AppModuleListener;
import com.appfireworks.android.module.AppModuleController;
import com.appfireworks.android.util.AppLog;

public class AppWebView
  extends WebView
{
  private Context activity;
  private AppModuleController controller;
  private AlertDialog dl;
  private AppModuleListener listener;
  private String loadUrl;
  private boolean loading = false;
  private WebSettings settings;
  
  public AppWebView(Activity paramActivity, AppModuleController paramAppModuleController)
  {
    super(paramActivity);
    this.activity = paramActivity;
    this.controller = paramAppModuleController;
    initialize();
  }
  
  private void initialize()
  {
    AppLog.d("AppFireworks", "initializing AppWebView");
    this.loadUrl = null;
    this.settings = getSettings();
    this.settings.setJavaScriptEnabled(true);
    this.settings.setJavaScriptCanOpenWindowsAutomatically(true);
    this.settings.setDomStorageEnabled(true);
    addJavascriptInterface(new AppJSInterface(this.activity, this.controller), "APPFIRE");
    if (Build.VERSION.SDK_INT >= 8) {
      this.settings.setPluginState(WebSettings.PluginState.ON);
    }
    setWebViewClient(new AppWebClient(this.activity, this.controller));
  }
  
  public void setListener(AppModuleListener paramAppModuleListener)
  {
    this.listener = paramAppModuleListener;
  }
  
  public void setLoadingURL(String paramString)
  {
    this.loadUrl = paramString;
  }
  
  public void showInternetDialog()
  {
    if (this.activity != null)
    {
      if (this.dl == null)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.activity);
        localBuilder.setMessage("Internet not available").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppWebView.this.dl.dismiss();
          }
        });
        this.dl = localBuilder.create();
      }
      this.dl.show();
    }
  }
  
  private class AppWebClient
    extends WebViewClient
  {
    private Context activity;
    private AppModuleController controller;
    private boolean error = false;
    private boolean loaded = true;
    private boolean redirect = false;
    
    public AppWebClient(Context paramContext, AppModuleController paramAppModuleController)
    {
      this.activity = paramContext;
      this.controller = paramAppModuleController;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      AppLog.d("AppFireworks", "onPageFinished");
      AppWebView.this.loading = false;
      this.controller.setLoading(AppWebView.this.loading);
      if (!this.redirect) {
        this.loaded = true;
      }
      AppLog.d("AppFireworks", "onPageFinished called");
      if (AppWebView.this.loadUrl == null)
      {
        paramWebView.setBackgroundColor(0);
        if ((!this.loaded) || (this.redirect)) {
          break label144;
        }
        AppWebView.this.setVisibility(0);
        this.controller.showElements();
        if (AppWebView.this.listener != null) {
          AppWebView.this.listener.onModuleLoaded();
        }
      }
      for (;;)
      {
        AppWebView.this.loadUrl = paramString;
        if (this.error)
        {
          this.controller.destroyAd();
          AppWebView.this.showInternetDialog();
        }
        return;
        label144:
        this.redirect = false;
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppLog.d("AppFireworks", "onPageStarted");
      this.loaded = false;
      AppLog.d("AppFireworks", "shouldOverrideUrlLoading");
      paramWebView.setPadding(0, 0, 0, 0);
      paramWebView.setInitialScale(100);
      paramWebView.setVerticalScrollBarEnabled(false);
      paramWebView.setHorizontalScrollBarEnabled(false);
      AppWebView.this.setVisibility(8);
      this.controller.hideElements();
      AppLog.d("AppFireworks", "Url to be loaded in the webview - " + paramString);
      if (this.error) {}
      do
      {
        return;
        if (AppWebView.this.loadUrl != null) {
          break;
        }
      } while (AppWebView.this.loading);
      AppWebView.this.loading = true;
      this.controller.setLoading(AppWebView.this.loading);
      return;
      AppLog.d("AppFireworks", "Link clicked!!");
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      if (paramInt != -10)
      {
        AppWebView.this.setVisibility(8);
        AppLog.d("AppFireworks", "Error received - Code=" + paramInt + ", Description = " + paramString1 + ", failURL - " + paramString2);
        this.error = true;
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      AppLog.d("AppFireworks", "shouldOverrideUrlLoading with URL: " + paramString);
      this.error = false;
      if (!this.loaded) {
        this.redirect = true;
      }
      this.loaded = false;
      if (AppWebView.this.loadUrl != null)
      {
        AppWebView.this.loading = false;
        this.controller.setLoading(AppWebView.this.loading);
        if (paramString.contains("afclose"))
        {
          AppLog.d("AppFireworks", "onCloseClick");
          this.controller.onCloseClick();
        }
      }
      else
      {
        return true;
      }
      this.controller.onLinkClick(paramString);
      this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      AppLog.d("AppFireworks", "finished tracking the link");
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/advert/AppWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */