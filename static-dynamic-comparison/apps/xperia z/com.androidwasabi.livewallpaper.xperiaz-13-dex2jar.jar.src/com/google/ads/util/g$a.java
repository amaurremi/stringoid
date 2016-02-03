package com.google.ads.util;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.m;
import com.google.ads.m.a;
import com.google.ads.n;

public class g$a
  extends WebChromeClient
{
  private final n a;
  
  public g$a(n paramn)
  {
    this.a = paramn;
  }
  
  private static void a(AlertDialog.Builder paramBuilder, Context paramContext, String paramString1, String paramString2, JsPromptResult paramJsPromptResult)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString1);
    paramContext = new EditText(paramContext);
    paramContext.setText(paramString2);
    localLinearLayout.addView(localTextView);
    localLinearLayout.addView(paramContext);
    paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new g.a.6(paramJsPromptResult, paramContext)).setNegativeButton(17039360, new g.a.5(paramJsPromptResult)).setOnCancelListener(new g.a.4(paramJsPromptResult)).create().show();
  }
  
  private static void a(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult)
  {
    paramBuilder.setMessage(paramString).setPositiveButton(17039370, new g.a.3(paramJsResult)).setNegativeButton(17039360, new g.a.2(paramJsResult)).setOnCancelListener(new g.a.1(paramJsResult)).create().show();
  }
  
  private static boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    if ((paramWebView instanceof AdWebView))
    {
      paramWebView = ((AdWebView)paramWebView).i();
      if (paramWebView != null)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramWebView);
        localBuilder.setTitle(paramString1);
        if (paramBoolean) {
          a(localBuilder, paramWebView, paramString2, paramString3, paramJsPromptResult);
        }
        for (;;)
        {
          return true;
          a(localBuilder, paramString2, paramJsResult);
        }
      }
    }
    return false;
  }
  
  public void onCloseWindow(WebView paramWebView)
  {
    if ((paramWebView instanceof AdWebView)) {
      ((AdWebView)paramWebView).f();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
    switch (g.1.a[paramConsoleMessage.messageLevel().ordinal()])
    {
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      b.b(str);
      continue;
      b.e(str);
      continue;
      b.c(str);
      continue;
      b.a(str);
    }
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramString1 = (m.a)((m)this.a.d.a()).b.a();
    long l = ((Long)paramString1.l.a()).longValue() - paramLong3;
    if (l <= 0L)
    {
      paramQuotaUpdater.updateQuota(paramLong1);
      return;
    }
    if (paramLong1 == 0L) {
      if ((paramLong2 > l) || (paramLong2 > ((Long)paramString1.m.a()).longValue())) {}
    }
    for (;;)
    {
      paramQuotaUpdater.updateQuota(paramLong2);
      return;
      paramLong2 = 0L;
      continue;
      if (paramLong2 == 0L)
      {
        paramLong2 = Math.min(Math.min(((Long)paramString1.n.a()).longValue(), l) + paramLong1, ((Long)paramString1.m.a()).longValue());
      }
      else
      {
        paramLong3 = paramLong1;
        if (paramLong2 <= Math.min(((Long)paramString1.m.a()).longValue() - paramLong1, l)) {
          paramLong3 = paramLong1 + paramLong2;
        }
        paramLong2 = paramLong3;
      }
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView, paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView, paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView, paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return a(paramWebView, paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    m.a locala = (m.a)((m)this.a.d.a()).b.a();
    long l = ((Long)locala.k.a()).longValue();
    paramLong1 = ((Long)locala.j.a()).longValue() + paramLong1;
    if (l - paramLong2 < paramLong1)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(paramLong1);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    paramCustomViewCallback.onCustomViewHidden();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/g$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */