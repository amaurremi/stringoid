package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.app.Activity;
import android.webkit.WebView;
import com.gau.go.launcherex.gowidget.messagecenter.a.e;
import com.gau.go.launcherex.gowidget.messagecenter.view.HtmlMsgDetailActivity;
import com.gau.go.launcherex.gowidget.messagecenter.view.HtmlMsgDialogActivity;

public class MessageElementClickInterface
{
  private Activity mActivity = null;
  private m mManager = null;
  private String mMsgId = null;
  private int mMsgViewType = 0;
  private WebView mWebView = null;
  
  public MessageElementClickInterface(WebView paramWebView, Activity paramActivity, String paramString, int paramInt)
  {
    this.mWebView = paramWebView;
    this.mActivity = paramActivity;
    this.mMsgId = paramString;
    this.mMsgViewType = paramInt;
    init();
  }
  
  private void init()
  {
    this.mManager = m.a(this.mActivity.getApplicationContext());
  }
  
  private void sendRunnable(Runnable paramRunnable)
  {
    if ((this.mActivity instanceof HtmlMsgDetailActivity)) {
      ((HtmlMsgDetailActivity)this.mActivity).a(paramRunnable);
    }
    while (!(this.mActivity instanceof HtmlMsgDialogActivity)) {
      return;
    }
    ((HtmlMsgDialogActivity)this.mActivity).a(paramRunnable);
  }
  
  public void clickOnAndroid(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    e locale = new e();
    locale.c = paramString1;
    locale.d = paramString2;
    locale.a = Integer.parseInt(paramString3);
    locale.b = paramString4;
    sendRunnable(new k(this, locale));
  }
  
  public void loadUrl(String paramString)
  {
    if (this.mWebView != null) {
      this.mWebView.loadUrl(paramString);
    }
  }
  
  public void onDestory()
  {
    if (this.mWebView != null)
    {
      this.mWebView.stopLoading();
      this.mWebView = null;
    }
    this.mManager = null;
    this.mActivity = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/MessageElementClickInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */