package com.jumptap.adtag.callbacks;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.jumptap.adtag.listeners.JtAdViewInnerListener;
import com.jumptap.adtag.utils.JtAdManager;

public class JtWebviewCb
{
  private JtAdViewInnerListener adView;
  private Context context;
  
  public JtWebviewCb(Context paramContext, JtAdViewInnerListener paramJtAdViewInnerListener)
  {
    this.context = paramContext;
    this.adView = paramJtAdViewInnerListener;
  }
  
  @JavascriptInterface
  public void expandTo(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    Log.d("JtAd", "JtWebViewCB::expandTo (" + paramString1 + ")");
    float f = this.context.getResources().getDisplayMetrics().density;
    paramInt2 = (int)(paramInt2 * f);
    paramInt1 = (int)(paramInt1 * f);
    this.adView.resizeWithCallback(true, paramInt1, paramInt2, paramString1, paramInt3, paramString2);
  }
  
  @JavascriptInterface
  public String getDeviceIdSha1()
  {
    String str = JtAdManager.getHIDSHA1(this.context);
    Log.d("JtAd", "JtWebViewCB::getDeviceId andId=" + str);
    return str;
  }
  
  @JavascriptInterface
  public String getLocation(String paramString1, String paramString2)
  {
    Log.d("JtAd", "JtWebViewCB::getLocation options: " + paramString2 + " callback: " + paramString1 + "  location=" + "Kuku");
    return "Kuku";
  }
  
  @JavascriptInterface
  public String getScreenSize()
  {
    float f = this.context.getResources().getDisplayMetrics().density;
    int j = this.context.getResources().getDisplayMetrics().heightPixels;
    int i = this.context.getResources().getDisplayMetrics().widthPixels;
    j = (int)(j / f);
    i = (int)(i / f);
    return "{\"width\": " + i + ",\"height\":" + j + "}";
  }
  
  @JavascriptInterface
  public void hideWidget()
  {
    this.adView.hide();
  }
  
  @JavascriptInterface
  public void openURI(String paramString1, String paramString2, String paramString3)
  {
    Log.d("JtAd", "JtWebViewCB::openURI URI: " + paramString1 + " contentType:" + paramString2 + " options: " + paramString3);
    this.adView.handleClicks(paramString1);
  }
  
  @JavascriptInterface
  public void resizeViewer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    Log.d("JtAd", "JtWebViewCB::resizeViewer left: " + paramInt1 + " top:" + paramInt2 + " right: " + paramInt3 + " bottom: " + paramInt4 + " transition: " + paramInt5 + " options: " + paramString1 + " callback: " + paramString2);
  }
  
  @JavascriptInterface
  public void restoreToBanner(String paramString1, int paramInt, String paramString2)
  {
    this.adView.resizeWithCallback(false, 0, 0, paramString1, paramInt, paramString2);
  }
  
  @JavascriptInterface
  public void setSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Log.d("JtAd", "JtWebViewCB::setSize a:" + paramInt1 + " b:" + paramInt2 + " c:" + paramInt3 + " d:" + paramInt4 + " shouldExpand:" + paramBoolean);
    float f = this.context.getResources().getDisplayMetrics().density;
    paramInt1 = (int)(paramInt3 * f);
    paramInt2 = (int)(paramInt4 * f);
    this.adView.resize(paramInt1, paramInt2, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/callbacks/JtWebviewCb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */