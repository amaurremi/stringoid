package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.messagecenter.util.MessageElementClickInterface;

public class MessageCenterWebView
  extends FrameLayout
{
  private WebView a = null;
  private LinearLayout b = null;
  private TextView c = null;
  private Handler d = new Handler();
  private g e = null;
  private MessageElementClickInterface f = null;
  private Activity g = null;
  private String h = null;
  private String i = null;
  
  public MessageCenterWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MessageCenterWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    new DisplayMetrics();
    float f1 = getResources().getDisplayMetrics().density;
    if (f1 == 1.5F)
    {
      this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
      return;
    }
    if (f1 == 2.0F)
    {
      this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
      return;
    }
    this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
  }
  
  private void c()
  {
    if ((this.b != null) && (this.b.getVisibility() == 4)) {
      this.b.setVisibility(0);
    }
  }
  
  private void d()
  {
    if ((this.b != null) && (this.b.getVisibility() == 0)) {
      this.b.setVisibility(4);
    }
  }
  
  public void a()
  {
    if (this.f != null)
    {
      this.f.onDestory();
      this.f = null;
    }
    if (this.a != null)
    {
      this.a.stopLoading();
      this.a = null;
    }
    this.e = null;
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt)
  {
    this.a = ((WebView)findViewById(2131231687));
    this.c = ((TextView)findViewById(2131231719));
    this.b = ((LinearLayout)findViewById(2131231717));
    this.g = paramActivity;
    paramActivity = this.a.getSettings();
    paramActivity.setJavaScriptEnabled(true);
    paramActivity.setDomStorageEnabled(true);
    paramActivity.setDefaultTextEncodingName("utf-8");
    this.a.setVerticalScrollbarOverlay(true);
    this.e = new g(this);
    this.a.setWebViewClient(this.e);
    this.a.setWebChromeClient(new e(this));
    b();
    this.b.setVisibility(0);
    this.f = new MessageElementClickInterface(this.a, this.g, paramString, paramInt);
    this.a.addJavascriptInterface(this.f, "buttonClick");
  }
  
  public void a(String paramString)
  {
    this.e.a(paramString);
    this.a.loadUrl(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.h = paramString1;
    this.i = paramString2;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.a != null) && (this.a.canGoBack()))
    {
      this.a.goBack();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/MessageCenterWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */