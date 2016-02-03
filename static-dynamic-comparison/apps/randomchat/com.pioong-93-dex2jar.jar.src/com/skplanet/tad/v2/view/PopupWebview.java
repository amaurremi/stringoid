package com.skplanet.tad.v2.view;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.skplanet.tad.view.a;

public class PopupWebview
  extends WebView
{
  private a a;
  public final String webViewInterface = "AdWebView";
  
  public PopupWebview(Context paramContext, a parama)
  {
    super(paramContext);
    this.a = parama;
    init();
  }
  
  public void init()
  {
    setPadding(0, 0, 0, 0);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSupportMultipleWindows(false);
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setBlockNetworkImage(false);
    localWebSettings.setLoadsImagesAutomatically(true);
    localWebSettings.setSaveFormData(false);
    addJavascriptInterface(new CloseWebViewJSI(), "AdWebView");
  }
  
  public class CloseWebViewJSI
  {
    public CloseWebViewJSI() {}
    
    public void ajsSelfPopupClose()
    {
      PopupWebview.a(PopupWebview.this).a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/view/PopupWebview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */