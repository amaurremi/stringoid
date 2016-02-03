package com.gau.go.launcherex.goweather.ad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;

@SuppressLint({"SetJavaScriptEnabled"})
public class AdWebviewActivity
  extends Activity
  implements View.OnClickListener, DownloadListener
{
  private WebView a;
  private View b;
  private View c;
  private FrameLayout d;
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((FrameLayout)LayoutInflater.from(this).inflate(2130903221, null));
    setContentView(this.d);
    this.a = ((WebView)findViewById(2131231687));
    this.a.getSettings().setJavaScriptEnabled(true);
    this.c = findViewById(2131231252);
    this.a.setWebViewClient(new g(this));
    this.a.setDownloadListener(this);
    this.b = findViewById(2131231688);
    this.b.setOnClickListener(this);
    paramBundle = "";
    Intent localIntent = getIntent();
    if (localIntent != null) {
      paramBundle = localIntent.getStringExtra("intent_extre_url");
    }
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.a.loadUrl(paramBundle);
      return;
    }
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.d.removeAllViews();
    this.a.destroy();
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString1)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/AdWebviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */