package com.gtp.go.weather.sharephoto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.language.d;

public class TermsAndPrivacyActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private WebView a;
  private View b;
  private TextView c;
  private ProgressBar d;
  
  private void a()
  {
    new DisplayMetrics();
    float f = e().getDisplayMetrics().density;
    if (f >= 1.5F)
    {
      this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
      return;
    }
    if (f >= 2.0F)
    {
      this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
      return;
    }
    this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, TermsAndPrivacyActivity.class));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903298);
    this.a = ((WebView)findViewById(2131231941));
    this.a.setWebChromeClient(new y(this));
    a();
    paramBundle = this.a.getSettings();
    paramBundle.setDomStorageEnabled(true);
    paramBundle.setDefaultTextEncodingName("utf-8");
    this.b = findViewById(2131231688);
    this.b.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131231942));
    this.d = ((ProgressBar)findViewById(2131231709));
    paramBundle = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).c().d();
    com.gtp.a.a.b.c.a("TermsAndPrivacyActivity", "curUserLangLocale: " + paramBundle);
    StringBuffer localStringBuffer = new StringBuffer("file:///android_asset/share_photo_terms_and_privacy");
    if ("zh_CN".equals(paramBundle)) {
      localStringBuffer.append("_zh_CN");
    }
    localStringBuffer.append(".html");
    this.a.loadUrl(localStringBuffer.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/TermsAndPrivacyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */