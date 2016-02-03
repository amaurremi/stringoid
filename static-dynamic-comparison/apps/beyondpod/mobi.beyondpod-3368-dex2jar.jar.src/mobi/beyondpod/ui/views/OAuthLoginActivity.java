package mobi.beyondpod.ui.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SeekBar;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.OAuthAccountInfo;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.OAuthAccountInfo.RedirectResult;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class OAuthLoginActivity
  extends ActionBarActivityBase
{
  public static final int OAuthActivityResult = 33445566;
  AggregatorLoginHelper.OAuthAccountInfo _Account = AggregatorLoginHelper.CurrentOAuthAccount();
  WebView _WebView;
  private SeekBar _loadProgress;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903142);
    getActionBarHelper().setDisplayOptions(4, 4);
    this._loadProgress = ((SeekBar)findViewById(2131230992));
    this._WebView = ((WebView)findViewById(2131230981));
    this._WebView.setWebViewClient(new OAuthWebViewClient(null));
    this._WebView.setWebChromeClient(new OAuthWebChromeClient());
    this._WebView.setScrollBarStyle(0);
    this._WebView.getSettings().setJavaScriptEnabled(true);
    this._WebView.loadUrl(this._Account.OAuthEndPoint());
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  class OAuthWebChromeClient
    extends WebChromeClient
  {
    OAuthWebChromeClient() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      paramWebView = OAuthLoginActivity.this._loadProgress;
      if (paramInt < 100) {}
      for (int i = 0;; i = 8)
      {
        paramWebView.setVisibility(i);
        OAuthLoginActivity.this._loadProgress.setProgress(paramInt);
        return;
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      OAuthLoginActivity.this.setTitle(paramString);
    }
  }
  
  private class OAuthWebViewClient
    extends WebViewClient
  {
    private OAuthWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      OAuthLoginActivity.this.runOnUiThread(new Runnable()
      {
        public void run() {}
      });
      super.onPageFinished(paramWebView, paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      OAuthLoginActivity.this.runOnUiThread(new Runnable()
      {
        public void run() {}
      });
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      paramWebView = OAuthLoginActivity.this._Account.CheckRedirectUrl(paramString2);
      if (paramWebView.Result == 1)
      {
        paramWebView = new Intent(paramWebView.AuthCode);
        OAuthLoginActivity.this.setResult(-1, paramWebView);
      }
      for (;;)
      {
        OAuthLoginActivity.this.finish();
        return;
        OAuthLoginActivity.this.setResult(0);
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView = OAuthLoginActivity.this._Account.CheckRedirectUrl(paramString);
      if (paramWebView.Result == 0) {
        return false;
      }
      if (paramWebView.Result == 1)
      {
        paramWebView = new Intent(paramWebView.AuthCode);
        OAuthLoginActivity.this.setResult(-1, paramWebView);
      }
      for (;;)
      {
        OAuthLoginActivity.this.finish();
        return true;
        OAuthLoginActivity.this.setResult(0);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/OAuthLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */