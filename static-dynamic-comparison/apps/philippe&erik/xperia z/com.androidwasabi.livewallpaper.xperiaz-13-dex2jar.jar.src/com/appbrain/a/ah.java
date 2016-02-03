package com.appbrain.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.appbrain.f;

public final class ah
  implements f
{
  private Activity a;
  
  public ah(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public final void a() {}
  
  public final void a(Bundle paramBundle)
  {
    this.a.requestWindowFeature(1);
    paramBundle = new ProgressBar(this.a);
    WebView localWebView = new WebView(this.a);
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.setWebViewClient(new ai(this, paramBundle));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.a.setContentView(localWebView);
    this.a.addContentView(paramBundle, localLayoutParams);
    localWebView.loadUrl(this.a.getIntent().getDataString());
  }
  
  public final boolean a(int paramInt)
  {
    return false;
  }
  
  public final void b() {}
  
  public final void b(Bundle paramBundle) {}
  
  public final boolean c()
  {
    return true;
  }
  
  public final void d() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */