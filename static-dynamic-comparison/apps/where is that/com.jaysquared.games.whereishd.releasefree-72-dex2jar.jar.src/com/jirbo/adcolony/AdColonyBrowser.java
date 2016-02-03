package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class AdColonyBrowser
  extends Activity
{
  static boolean enable_back_button = false;
  static boolean enable_forward_button = false;
  static boolean finishing = false;
  static boolean first_draw;
  static boolean is_open;
  static boolean loading = false;
  static boolean page_loaded = false;
  static boolean should_recycle;
  public static String url;
  ADCImage back_button;
  boolean back_button_down = false;
  ADCImage back_button_enabled;
  RelativeLayout bar_layout;
  ADCImage browser_icon;
  ADCImage close_button;
  boolean close_button_down = false;
  DisplayMetrics dm;
  ADCImage forward_button;
  boolean forward_button_down = false;
  ADCImage forward_button_enabled;
  ADCImage glow_button;
  ButtonOverlay overlay;
  ProgressBar pb;
  ADCImage reload_button;
  boolean reload_button_down = false;
  ShadowOverlay shadow_overlay;
  ADCImage stop_button;
  WebView web_view;
  RelativeLayout web_view_layout;
  
  static
  {
    first_draw = true;
    should_recycle = false;
    is_open = false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new RelativeLayout.LayoutParams(-2, this.dm.heightPixels - (int)(this.close_button.height * 1.5D));
    paramConfiguration.addRule(3, this.bar_layout.getId());
    this.web_view.setLayoutParams(paramConfiguration);
    first_draw = true;
    this.overlay.invalidate();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    is_open = true;
    this.back_button = new ADCImage(ADC.get_String("browser_back_image_normal"));
    this.stop_button = new ADCImage(ADC.get_String("browser_stop_image_normal"));
    this.reload_button = new ADCImage(ADC.get_String("browser_reload_image_normal"));
    this.forward_button = new ADCImage(ADC.get_String("browser_forward_image_normal"));
    this.close_button = new ADCImage(ADC.get_String("browser_close_image_normal"));
    this.glow_button = new ADCImage(ADC.get_String("browser_glow_button"));
    this.browser_icon = new ADCImage(ADC.get_String("browser_icon"));
    this.back_button_enabled = new ADCImage(ADC.get_String("browser_back_image_normal"), true);
    this.forward_button_enabled = new ADCImage(ADC.get_String("browser_forward_image_normal"), true);
    this.dm = AdColony.activity().getResources().getDisplayMetrics();
    float f1 = this.dm.widthPixels / this.dm.xdpi;
    float f2 = this.dm.heightPixels / this.dm.ydpi;
    double d1 = Math.sqrt(f1 * f1 + f2 * f2);
    double d2 = Math.sqrt(this.dm.widthPixels * this.dm.widthPixels + this.dm.heightPixels * this.dm.heightPixels) / d1 / 220.0D;
    d1 = d2;
    if (d2 > 1.8D) {
      d1 = 1.8D;
    }
    first_draw = true;
    enable_back_button = false;
    enable_forward_button = false;
    finishing = false;
    this.back_button.resize(d1);
    this.stop_button.resize(d1);
    this.reload_button.resize(d1);
    this.forward_button.resize(d1);
    this.close_button.resize(d1);
    this.glow_button.resize(d1);
    this.back_button_enabled.resize(d1);
    this.forward_button_enabled.resize(d1);
    this.pb = new ProgressBar(this);
    this.pb.setVisibility(4);
    this.web_view_layout = new RelativeLayout(this);
    this.bar_layout = new RelativeLayout(this);
    this.bar_layout.setBackgroundColor(-3355444);
    if (!ADC.is_tablet)
    {
      this.bar_layout.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)(this.back_button.height * 1.5D)));
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
      getWindow().requestFeature(2);
      setVolumeControlStream(3);
      this.web_view = new WebView(this);
      this.web_view.getSettings().setJavaScriptEnabled(true);
      this.web_view.getSettings().setBuiltInZoomControls(true);
      this.web_view.getSettings().setUseWideViewPort(true);
      this.web_view.getSettings().setLoadWithOverviewMode(true);
      this.web_view.getSettings().setGeolocationEnabled(true);
      if (ADC.is_tablet) {
        break label939;
      }
      if (Build.VERSION.SDK_INT < 10) {
        break label931;
      }
      setRequestedOrientation(6);
      label566:
      this.web_view.setWebChromeClient(new WebChromeClient()
      {
        public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
        {
          paramAnonymousCallback.invoke(paramAnonymousString, true, false);
        }
        
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          AdColonyBrowser.this.setProgress(paramAnonymousInt * 1000);
        }
      });
      this.web_view.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (!AdColonyBrowser.finishing)
          {
            AdColonyBrowser.page_loaded = true;
            AdColonyBrowser.loading = false;
            AdColonyBrowser.this.pb.setVisibility(4);
            AdColonyBrowser.enable_back_button = AdColonyBrowser.this.web_view.canGoBack();
            AdColonyBrowser.enable_forward_button = AdColonyBrowser.this.web_view.canGoForward();
          }
          AdColonyBrowser.this.overlay.invalidate();
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          if (!AdColonyBrowser.finishing)
          {
            AdColonyBrowser.loading = true;
            AdColonyBrowser.page_loaded = false;
            AdColonyBrowser.this.pb.setVisibility(0);
          }
          AdColonyBrowser.this.overlay.invalidate();
        }
        
        public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          ADCLog.error.print("Error viewing URL: ").println(paramAnonymousString1);
          AdColonyBrowser.this.finish();
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if ((paramAnonymousString.startsWith("market://")) || (paramAnonymousString.startsWith("amzn://")))
          {
            paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            if (ADC.current_video != null) {
              ADC.current_video.startActivity(paramAnonymousWebView);
            }
            return true;
          }
          return false;
        }
      });
      this.overlay = new ButtonOverlay(this);
      this.shadow_overlay = new ShadowOverlay(this);
      this.web_view_layout.setBackgroundColor(16777215);
      this.web_view_layout.addView(this.bar_layout);
      this.bar_layout.setId(12345);
      paramBundle = new RelativeLayout.LayoutParams(-2, this.dm.heightPixels - (int)(1.5D * this.close_button.height));
      paramBundle.addRule(3, this.bar_layout.getId());
      this.web_view_layout.addView(this.web_view, paramBundle);
      paramBundle = new RelativeLayout.LayoutParams(-2, 20);
      paramBundle.addRule(3, this.bar_layout.getId());
      paramBundle.setMargins(0, -10, 0, 0);
      this.web_view_layout.addView(this.shadow_overlay, paramBundle);
      if (this.dm.widthPixels <= this.dm.heightPixels) {
        break label949;
      }
    }
    label931:
    label939:
    label949:
    for (int i = this.dm.widthPixels;; i = this.dm.heightPixels)
    {
      this.web_view_layout.addView(this.overlay, new RelativeLayout.LayoutParams(i * 2, i * 2));
      paramBundle = new RelativeLayout.LayoutParams(-2, this.dm.heightPixels - (int)(1.5D * this.close_button.height));
      paramBundle.addRule(3, this.bar_layout.getId());
      this.web_view_layout.addView(new LoadingView(this), paramBundle);
      setContentView(this.web_view_layout);
      this.web_view.loadUrl(url);
      ADCLog.info.print("Viewing ").println(url);
      return;
      this.bar_layout.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)(this.back_button.height * 1.5D)));
      break;
      setRequestedOrientation(0);
      break label566;
      setRequestedOrientation(ADC.orientation);
      break label566;
    }
  }
  
  public void onDestroy()
  {
    if ((!ADC.show_post_popup) && (should_recycle == true))
    {
      int i = 0;
      while (i < ADC.bitmaps.size())
      {
        ((Bitmap)ADC.bitmaps.get(i)).recycle();
        i += 1;
      }
      ADC.bitmaps.clear();
    }
    should_recycle = false;
    is_open = false;
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.overlay.draw_upstates();
  }
  
  public void onResume()
  {
    super.onResume();
    first_draw = true;
    this.overlay.invalidate();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  class ButtonOverlay
    extends View
  {
    Rect bounds = new Rect();
    Paint paint = new Paint();
    
    public ButtonOverlay(Activity paramActivity)
    {
      super();
    }
    
    public void addProgress()
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AdColonyBrowser.this.pb.getWidth(), AdColonyBrowser.this.pb.getHeight());
      localLayoutParams.topMargin = ((AdColonyBrowser.this.bar_layout.getHeight() - AdColonyBrowser.this.stop_button.height) / 2);
      localLayoutParams.leftMargin = (AdColonyBrowser.this.bar_layout.getWidth() / 10 + AdColonyBrowser.this.stop_button.x() + AdColonyBrowser.this.stop_button.width);
      if ((AdColonyBrowser.first_draw) && (AdColonyBrowser.this.stop_button.x() != 0))
      {
        AdColonyBrowser.this.web_view_layout.removeView(AdColonyBrowser.this.pb);
        AdColonyBrowser.this.web_view_layout.addView(AdColonyBrowser.this.pb, localLayoutParams);
        AdColonyBrowser.first_draw = false;
      }
      if (AdColonyBrowser.this.pb.getLayoutParams() == null) {
        return;
      }
      AdColonyBrowser.this.pb.getLayoutParams().height = AdColonyBrowser.this.stop_button.height;
      AdColonyBrowser.this.pb.getLayoutParams().width = AdColonyBrowser.this.stop_button.width;
    }
    
    public boolean clicked(ADCImage paramADCImage, int paramInt1, int paramInt2)
    {
      return (paramInt1 < paramADCImage.x() + paramADCImage.width + 16) && (paramInt1 > paramADCImage.x() - 16) && (paramInt2 < paramADCImage.y() + paramADCImage.height + 16) && (paramInt2 > paramADCImage.y() - 16);
    }
    
    public void draw_upstates()
    {
      AdColonyBrowser.this.back_button_down = false;
      AdColonyBrowser.this.forward_button_down = false;
      AdColonyBrowser.this.reload_button_down = false;
      AdColonyBrowser.this.close_button_down = false;
      invalidate();
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      getDrawingRect(this.bounds);
      int i = (AdColonyBrowser.this.bar_layout.getHeight() - AdColonyBrowser.this.back_button.height) / 2;
      if (!AdColonyBrowser.enable_back_button)
      {
        AdColonyBrowser.this.back_button.draw(paramCanvas, AdColonyBrowser.this.back_button.width, i);
        if (AdColonyBrowser.enable_forward_button) {
          break label643;
        }
        AdColonyBrowser.this.forward_button.draw(paramCanvas, AdColonyBrowser.this.back_button.x() + AdColonyBrowser.this.bar_layout.getWidth() / 10 + AdColonyBrowser.this.back_button.width, i);
        label113:
        if (!AdColonyBrowser.loading) {
          break label693;
        }
        AdColonyBrowser.this.stop_button.draw(paramCanvas, AdColonyBrowser.this.forward_button.x() + AdColonyBrowser.this.forward_button.width + AdColonyBrowser.this.bar_layout.getWidth() / 10, i);
      }
      for (;;)
      {
        AdColonyBrowser.this.close_button.draw(paramCanvas, AdColonyBrowser.this.bar_layout.getWidth() - AdColonyBrowser.this.close_button.width * 2, i);
        if (AdColonyBrowser.this.back_button_down)
        {
          AdColonyBrowser.this.glow_button.set_position(AdColonyBrowser.this.back_button.x() - AdColonyBrowser.this.glow_button.width / 2 + AdColonyBrowser.this.back_button.width / 2, AdColonyBrowser.this.back_button.y() - AdColonyBrowser.this.glow_button.height / 2 + AdColonyBrowser.this.back_button.height / 2);
          AdColonyBrowser.this.glow_button.draw(paramCanvas);
        }
        if (AdColonyBrowser.this.forward_button_down)
        {
          AdColonyBrowser.this.glow_button.set_position(AdColonyBrowser.this.forward_button.x() - AdColonyBrowser.this.glow_button.width / 2 + AdColonyBrowser.this.forward_button.width / 2, AdColonyBrowser.this.forward_button.y() - AdColonyBrowser.this.glow_button.height / 2 + AdColonyBrowser.this.forward_button.height / 2);
          AdColonyBrowser.this.glow_button.draw(paramCanvas);
        }
        if (AdColonyBrowser.this.reload_button_down)
        {
          AdColonyBrowser.this.glow_button.set_position(AdColonyBrowser.this.reload_button.x() - AdColonyBrowser.this.glow_button.width / 2 + AdColonyBrowser.this.reload_button.width / 2, AdColonyBrowser.this.reload_button.y() - AdColonyBrowser.this.glow_button.height / 2 + AdColonyBrowser.this.reload_button.height / 2);
          AdColonyBrowser.this.glow_button.draw(paramCanvas);
        }
        if (AdColonyBrowser.this.close_button_down)
        {
          AdColonyBrowser.this.glow_button.set_position(AdColonyBrowser.this.close_button.x() - AdColonyBrowser.this.glow_button.width / 2 + AdColonyBrowser.this.close_button.width / 2, AdColonyBrowser.this.close_button.y() - AdColonyBrowser.this.glow_button.height / 2 + AdColonyBrowser.this.close_button.height / 2);
          AdColonyBrowser.this.glow_button.draw(paramCanvas);
        }
        addProgress();
        return;
        AdColonyBrowser.this.back_button_enabled.draw(paramCanvas, AdColonyBrowser.this.back_button.width, i);
        break;
        label643:
        AdColonyBrowser.this.forward_button_enabled.draw(paramCanvas, AdColonyBrowser.this.back_button.x() + AdColonyBrowser.this.bar_layout.getWidth() / 10 + AdColonyBrowser.this.back_button.width, i);
        break label113;
        label693:
        AdColonyBrowser.this.reload_button.draw(paramCanvas, AdColonyBrowser.this.forward_button.x() + AdColonyBrowser.this.forward_button.width + AdColonyBrowser.this.bar_layout.getWidth() / 10, i);
      }
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if (i == 0)
      {
        if ((clicked(AdColonyBrowser.this.back_button, j, k)) && (AdColonyBrowser.enable_back_button))
        {
          AdColonyBrowser.this.back_button_down = true;
          invalidate();
          return true;
        }
        if ((clicked(AdColonyBrowser.this.forward_button, j, k)) && (AdColonyBrowser.enable_forward_button))
        {
          AdColonyBrowser.this.forward_button_down = true;
          invalidate();
          return true;
        }
        if (clicked(AdColonyBrowser.this.reload_button, j, k))
        {
          AdColonyBrowser.this.reload_button_down = true;
          invalidate();
          return true;
        }
        if (clicked(AdColonyBrowser.this.close_button, j, k))
        {
          AdColonyBrowser.this.close_button_down = true;
          invalidate();
          return true;
        }
      }
      if (i == 1)
      {
        if ((clicked(AdColonyBrowser.this.back_button, j, k)) && (AdColonyBrowser.enable_back_button))
        {
          AdColonyBrowser.this.web_view.goBack();
          draw_upstates();
          return true;
        }
        if ((clicked(AdColonyBrowser.this.forward_button, j, k)) && (AdColonyBrowser.enable_forward_button))
        {
          AdColonyBrowser.this.web_view.goForward();
          draw_upstates();
          return true;
        }
        if ((clicked(AdColonyBrowser.this.reload_button, j, k)) && (AdColonyBrowser.loading))
        {
          AdColonyBrowser.this.web_view.stopLoading();
          draw_upstates();
          return true;
        }
        if ((clicked(AdColonyBrowser.this.reload_button, j, k)) && (!AdColonyBrowser.loading))
        {
          AdColonyBrowser.this.web_view.reload();
          draw_upstates();
          return true;
        }
        if (clicked(AdColonyBrowser.this.close_button, j, k))
        {
          AdColonyBrowser.finishing = true;
          AdColonyBrowser.this.web_view.loadData("", "text/html", "utf-8");
          AdColonyBrowser.enable_forward_button = false;
          AdColonyBrowser.enable_back_button = false;
          AdColonyBrowser.loading = false;
          draw_upstates();
          AdColonyBrowser.this.finish();
          return true;
        }
        draw_upstates();
      }
      return false;
    }
  }
  
  class LoadingView
    extends View
  {
    Rect bounds = new Rect();
    
    public LoadingView(Activity paramActivity)
    {
      super();
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      if (!AdColonyBrowser.page_loaded)
      {
        paramCanvas.drawARGB(255, 0, 0, 0);
        getDrawingRect(this.bounds);
        AdColonyBrowser.this.browser_icon.draw(paramCanvas, (this.bounds.width() - AdColonyBrowser.this.browser_icon.width) / 2, (this.bounds.height() - AdColonyBrowser.this.browser_icon.height) / 2);
        invalidate();
      }
    }
  }
  
  class ShadowOverlay
    extends View
  {
    ADCImage img_close_button = new ADCImage(ADC.get_String("close_image_normal"));
    ADCImage img_close_button_down = new ADCImage(ADC.get_String("close_image_down"));
    Paint paint = new Paint();
    
    public ShadowOverlay(Activity paramActivity)
    {
      super();
      try
      {
        getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
        this.paint.setColor(-3355444);
        this.paint.setStrokeWidth(10.0F);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setShadowLayer(3.0F, 0.0F, 1.0F, -16777216);
        return;
      }
      catch (Exception this$1)
      {
        for (;;) {}
      }
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      paramCanvas.drawRect(0.0F, 0.0F, AdColonyBrowser.this.bar_layout.getWidth(), 10.0F, this.paint);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/AdColonyBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */