package com.appbrain.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.appbrain.AppBrainActivity.a;

public final class cm
  extends AppBrainActivity.a
{
  private final Activity a;
  
  public cm(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public final void a(Bundle paramBundle)
  {
    this.a.requestWindowFeature(1);
    paramBundle = new ProgressBar(this.a);
    WebView localWebView = new WebView(this.a);
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.setWebViewClient(new cn(this, paramBundle));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.a.setContentView(localWebView);
    this.a.addContentView(paramBundle, localLayoutParams);
    localWebView.loadUrl(this.a.getIntent().getDataString());
  }
  
  public final boolean d()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */