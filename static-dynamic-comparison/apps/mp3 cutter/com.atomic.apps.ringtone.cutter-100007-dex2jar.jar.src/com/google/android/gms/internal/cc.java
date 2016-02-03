package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.atomic.apps.ringtone.cutter.aa;

public class cc
  extends WebChromeClient
{
  private final bW a;
  
  public cc(bW parambW)
  {
    this.a = parambW;
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramString1);
    if (paramBoolean)
    {
      paramString1 = new LinearLayout(paramContext);
      paramString1.setOrientation(1);
      paramJsResult = new TextView(paramContext);
      paramJsResult.setText(paramString2);
      paramContext = new EditText(paramContext);
      paramContext.setText(paramString3);
      paramString1.addView(paramJsResult);
      paramString1.addView(paramContext);
      localBuilder.setView(paramString1).setPositiveButton(17039370, new cj(paramJsPromptResult, paramContext)).setNegativeButton(17039360, new ci(paramJsPromptResult)).setOnCancelListener(new ch(paramJsPromptResult)).create().show();
      return true;
    }
    localBuilder.setMessage(paramString2).setPositiveButton(17039370, new cg(paramJsResult)).setNegativeButton(17039360, new cf(paramJsResult)).setOnCancelListener(new cd(paramJsResult)).create().show();
    return true;
  }
  
  protected final void a(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    aw localaw = this.a.d();
    if (localaw == null)
    {
      aa.e("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    localaw.a(paramView, paramCustomViewCallback);
    localaw.a(paramInt);
  }
  
  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof bW))
    {
      aa.e("Tried to close a WebView that wasn't an AdWebView.");
      return;
    }
    paramWebView = ((bW)paramWebView).d();
    if (paramWebView == null)
    {
      aa.e("Tried to close an AdWebView not associated with an overlay.");
      return;
    }
    paramWebView.a();
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
    switch (ck.a[paramConsoleMessage.messageLevel().ordinal()])
    {
    default: 
      aa.c(str);
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      aa.b(str);
      continue;
      aa.e(str);
      continue;
      aa.c(str);
      continue;
      aa.a(str);
    }
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)paramMessage.obj;
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(this.a.f());
    localWebViewTransport.setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l = 5242880L - paramLong3;
    if (l <= 0L)
    {
      paramQuotaUpdater.updateQuota(paramLong1);
      return;
    }
    if (paramLong1 == 0L)
    {
      if ((paramLong2 <= l) && (paramLong2 <= 1048576L)) {}
      for (;;)
      {
        paramQuotaUpdater.updateQuota(paramLong2);
        return;
        paramLong2 = 0L;
      }
    }
    if (paramLong2 == 0L) {
      paramLong3 = Math.min(Math.min(131072L, l) + paramLong1, 1048576L);
    }
    for (;;)
    {
      paramLong2 = paramLong3;
      break;
      paramLong3 = paramLong1;
      if (paramLong2 <= Math.min(1048576L - paramLong1, l)) {
        paramLong3 = paramLong1 + paramLong2;
      }
    }
  }
  
  public final void onHideCustomView()
  {
    aw localaw = this.a.d();
    if (localaw == null)
    {
      aa.e("Could not get ad overlay when hiding custom view.");
      return;
    }
    localaw.c();
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramLong1 = 131072L + paramLong1;
    if (5242880L - paramLong2 < paramLong1)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(paramLong1);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, -1, paramCustomViewCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */