package com.google.ads.util;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.internal.i;
import com.google.ads.m;
import com.google.ads.m.a;
import com.google.ads.n;
import com.google.ads.o;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@TargetApi(11)
public class g
{
  public static void a(View paramView)
  {
    paramView.setLayerType(1, null);
  }
  
  public static void a(Window paramWindow)
  {
    paramWindow.setFlags(16777216, 16777216);
  }
  
  public static void a(WebSettings paramWebSettings, n paramn)
  {
    Context localContext = (Context)paramn.f.a();
    paramn = (m.a)((m)paramn.d.a()).b.a();
    paramWebSettings.setAppCacheEnabled(true);
    paramWebSettings.setAppCacheMaxSize(((Long)paramn.i.a()).longValue());
    paramWebSettings.setAppCachePath(new File(localContext.getCacheDir(), "admob").getAbsolutePath());
    paramWebSettings.setDatabaseEnabled(true);
    paramWebSettings.setDatabasePath(localContext.getDatabasePath("admob").getAbsolutePath());
    paramWebSettings.setDomStorageEnabled(true);
    paramWebSettings.setSupportZoom(true);
    paramWebSettings.setBuiltInZoomControls(true);
    paramWebSettings.setDisplayZoomControls(false);
  }
  
  public static void b(View paramView)
  {
    paramView.setLayerType(0, null);
  }
  
  public static class a
    extends WebChromeClient
  {
    private final n a;
    
    public a(n paramn)
    {
      this.a = paramn;
    }
    
    private static void a(AlertDialog.Builder paramBuilder, final Context paramContext, String paramString1, String paramString2, JsPromptResult paramJsPromptResult)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      TextView localTextView = new TextView(paramContext);
      localTextView.setText(paramString1);
      paramContext = new EditText(paramContext);
      paramContext.setText(paramString2);
      localLinearLayout.addView(localTextView);
      localLinearLayout.addView(paramContext);
      paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.a.confirm(paramContext.getText().toString());
        }
      }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.a.cancel();
        }
      }).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.a.cancel();
        }
      }).create().show();
    }
    
    private static void a(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult)
    {
      paramBuilder.setMessage(paramString).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.a.confirm();
        }
      }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.a.cancel();
        }
      }).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.a.cancel();
        }
      }).create().show();
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
  
  public static class b
    extends i
  {
    public b(d paramd, Map<String, o> paramMap, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramMap, paramBoolean1, paramBoolean2);
    }
    
    private static WebResourceResponse a(String paramString, Context paramContext)
      throws IOException
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      try
      {
        AdUtil.a(paramString, paramContext.getApplicationContext());
        paramString.connect();
        paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(AdUtil.a(new InputStreamReader(paramString.getInputStream())).getBytes("UTF-8")));
        return paramContext;
      }
      finally
      {
        paramString.disconnect();
      }
    }
    
    /* Error */
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      // Byte code:
      //   0: ldc 86
      //   2: new 88	java/io/File
      //   5: dup
      //   6: aload_2
      //   7: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   10: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
      //   13: invokevirtual 97	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   16: ifeq +131 -> 147
      //   19: aload_0
      //   20: getfield 100	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
      //   23: invokevirtual 106	com/google/ads/internal/d:k	()Lcom/google/ads/internal/c;
      //   26: astore_3
      //   27: aload_3
      //   28: ifnull +101 -> 129
      //   31: aload_3
      //   32: iconst_1
      //   33: invokevirtual 112	com/google/ads/internal/c:c	(Z)V
      //   36: aload_0
      //   37: getfield 100	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
      //   40: invokevirtual 116	com/google/ads/internal/d:i	()Lcom/google/ads/n;
      //   43: getfield 122	com/google/ads/n:d	Lcom/google/ads/util/i$b;
      //   46: invokevirtual 127	com/google/ads/util/i$b:a	()Ljava/lang/Object;
      //   49: checkcast 129	com/google/ads/m
      //   52: getfield 131	com/google/ads/m:b	Lcom/google/ads/util/i$b;
      //   55: invokevirtual 127	com/google/ads/util/i$b:a	()Ljava/lang/Object;
      //   58: checkcast 133	com/google/ads/m$a
      //   61: astore_3
      //   62: aload_0
      //   63: getfield 100	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
      //   66: invokevirtual 116	com/google/ads/internal/d:i	()Lcom/google/ads/n;
      //   69: invokevirtual 136	com/google/ads/n:b	()Z
      //   72: ifne +129 -> 201
      //   75: aload_0
      //   76: getfield 139	com/google/ads/util/g$b:b	Z
      //   79: ifeq +75 -> 154
      //   82: aload_3
      //   83: getfield 143	com/google/ads/m$a:f	Lcom/google/ads/util/i$c;
      //   86: invokevirtual 146	com/google/ads/util/i$c:a	()Ljava/lang/Object;
      //   89: checkcast 66	java/lang/String
      //   92: astore_3
      //   93: new 148	java/lang/StringBuilder
      //   96: dup
      //   97: invokespecial 150	java/lang/StringBuilder:<init>	()V
      //   100: ldc -104
      //   102: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: aload_3
      //   106: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   109: ldc -98
      //   111: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   117: invokestatic 165	com/google/ads/util/b:a	(Ljava/lang/String;)V
      //   120: aload_3
      //   121: aload_1
      //   122: invokevirtual 170	android/webkit/WebView:getContext	()Landroid/content/Context;
      //   125: invokestatic 172	com/google/ads/util/g$b:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/webkit/WebResourceResponse;
      //   128: areturn
      //   129: aload_0
      //   130: getfield 100	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
      //   133: iconst_1
      //   134: invokevirtual 174	com/google/ads/internal/d:a	(Z)V
      //   137: goto -101 -> 36
      //   140: astore_3
      //   141: ldc -80
      //   143: aload_3
      //   144: invokestatic 179	com/google/ads/util/b:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   147: aload_0
      //   148: aload_1
      //   149: aload_2
      //   150: invokespecial 181	com/google/ads/internal/i:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
      //   153: areturn
      //   154: aload_3
      //   155: getfield 184	com/google/ads/m$a:e	Lcom/google/ads/util/i$c;
      //   158: invokevirtual 146	com/google/ads/util/i$c:a	()Ljava/lang/Object;
      //   161: checkcast 66	java/lang/String
      //   164: astore_3
      //   165: new 148	java/lang/StringBuilder
      //   168: dup
      //   169: invokespecial 150	java/lang/StringBuilder:<init>	()V
      //   172: ldc -104
      //   174: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   177: aload_3
      //   178: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   181: ldc -98
      //   183: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   186: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   189: invokestatic 165	com/google/ads/util/b:a	(Ljava/lang/String;)V
      //   192: aload_3
      //   193: aload_1
      //   194: invokevirtual 170	android/webkit/WebView:getContext	()Landroid/content/Context;
      //   197: invokestatic 172	com/google/ads/util/g$b:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/webkit/WebResourceResponse;
      //   200: areturn
      //   201: aload_3
      //   202: getfield 187	com/google/ads/m$a:g	Lcom/google/ads/util/i$c;
      //   205: invokevirtual 146	com/google/ads/util/i$c:a	()Ljava/lang/Object;
      //   208: checkcast 66	java/lang/String
      //   211: astore_3
      //   212: new 148	java/lang/StringBuilder
      //   215: dup
      //   216: invokespecial 150	java/lang/StringBuilder:<init>	()V
      //   219: ldc -104
      //   221: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   224: aload_3
      //   225: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: ldc -98
      //   230: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   233: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   236: invokestatic 165	com/google/ads/util/b:a	(Ljava/lang/String;)V
      //   239: aload_3
      //   240: aload_1
      //   241: invokevirtual 170	android/webkit/WebView:getContext	()Landroid/content/Context;
      //   244: invokestatic 172	com/google/ads/util/g$b:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/webkit/WebResourceResponse;
      //   247: astore_3
      //   248: aload_3
      //   249: areturn
      //   250: astore_3
      //   251: ldc -67
      //   253: aload_3
      //   254: invokestatic 179	com/google/ads/util/b:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   257: goto -110 -> 147
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	260	0	this	b
      //   0	260	1	paramWebView	WebView
      //   0	260	2	paramString	String
      //   26	95	3	localObject1	Object
      //   140	15	3	localIOException	IOException
      //   164	85	3	localObject2	Object
      //   250	4	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	27	140	java/io/IOException
      //   31	36	140	java/io/IOException
      //   36	129	140	java/io/IOException
      //   129	137	140	java/io/IOException
      //   154	201	140	java/io/IOException
      //   201	248	140	java/io/IOException
      //   0	27	250	java/lang/Throwable
      //   31	36	250	java/lang/Throwable
      //   36	129	250	java/lang/Throwable
      //   129	137	250	java/lang/Throwable
      //   154	201	250	java/lang/Throwable
      //   201	248	250	java/lang/Throwable
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */