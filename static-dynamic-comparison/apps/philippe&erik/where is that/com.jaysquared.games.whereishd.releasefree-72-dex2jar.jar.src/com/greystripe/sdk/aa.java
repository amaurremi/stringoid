package com.greystripe.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.LinkedList;
import java.util.Timer;

final class aa
  extends WebView
{
  private static boolean d = true;
  private final int a = 30000;
  private final int b = 300;
  private String c;
  private ag e;
  private Timer f;
  private Timer g;
  private boolean h = false;
  private LinkedList i = new LinkedList();
  private boolean j = true;
  private boolean k;
  private WebChromeClient l;
  
  protected aa(Context paramContext, ag paramag)
  {
    super(paramContext);
    this.e = paramag;
    setBackgroundColor(0);
    this.l = new WebChromeClient();
    setWebChromeClient(this.l);
    setWebViewClient(new af(this, (byte)0));
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setScrollContainer(false);
    setEnabled(true);
    setClickable(true);
    setPadding(0, 0, 0, 0);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramag = getSettings();
    paramag.setLightTouchEnabled(true);
    paramag.setJavaScriptEnabled(true);
    paramag.setLoadsImagesAutomatically(true);
    paramag.setJavaScriptCanOpenWindowsAutomatically(false);
    paramag.setSupportMultipleWindows(false);
    paramag.setPluginsEnabled(true);
    paramag.setCacheMode(1);
    paramag.setSupportZoom(false);
    paramag.setDatabaseEnabled(true);
    paramag.setDomStorageEnabled(true);
    if (d)
    {
      bd.b("First webview loaded.", new Object[0]);
      CookieSyncManager.createInstance(paramContext);
      CookieManager.getInstance().removeExpiredCookie();
      paramContext = CookieManager.getInstance();
      paramag = bj.c();
      int m = bj.c().indexOf("http://");
      paramag = paramag.substring("http://".length() + m + 1);
      paramContext.setCookie(paramag.substring(paramag.indexOf('/')), "GS_Session=0");
      CookieSyncManager.getInstance().sync();
      d = false;
    }
    addJavascriptInterface(bj.a(), "Preferences");
    addJavascriptInterface(bd.a(), "SdkLog");
    addJavascriptInterface(new ah(this, (byte)0), "ResponseStatus");
  }
  
  private void b()
  {
    try
    {
      this.h = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void c()
  {
    try
    {
      for (String str = (String)this.i.poll(); str != null; str = (String)this.i.poll()) {
        loadUrl(str);
      }
      this.h = true;
      return;
    }
    finally {}
  }
  
  protected final void a()
  {
    if (this.g != null)
    {
      bd.b("CANCELLING LOAD TIMER", new Object[0]);
      this.g.cancel();
      this.g = null;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    bd.b("onResponseStatusKnown(" + paramInt1 + ")", new Object[0]);
    switch (paramInt1)
    {
    default: 
      bd.b("Ad Response Status: Server Error", new Object[0]);
      this.e.a(GSAdErrorCode.SERVER_ERROR);
    }
    for (;;)
    {
      if (paramInt2 > 0)
      {
        bd.b("Starting to throttle with time " + paramInt2, new Object[0]);
        this.e.c();
        this.f = new Timer();
        this.f.schedule(new ac(this), paramInt2 * 1000);
      }
      return;
      bd.b("Ad Response Status: No Status Code", new Object[0]);
      this.e.a(GSAdErrorCode.SERVER_ERROR);
      paramInt2 = 300;
      continue;
      bd.b("Ad Response Status: Success", new Object[0]);
      this.e.a();
      continue;
      bd.b("Ad Response Status: Blank Ad", new Object[0]);
      this.e.a(GSAdErrorCode.NO_AD);
      continue;
      bd.b("Ad Response Status: Invalid Application Identifier", new Object[0]);
      this.e.a(GSAdErrorCode.INVALID_APPLICATION_IDENTIFIER);
    }
  }
  
  public final void a(String paramString)
  {
    long l1 = bj.e();
    bd.b("STARTING LOAD TIMER with time " + l1, new Object[0]);
    this.k = false;
    this.g = new Timer();
    this.g.schedule(new ad(this), l1);
    if (paramString.contains("?")) {}
    for (paramString = paramString.replaceFirst("\\?", "?z=" + System.currentTimeMillis() + '&');; paramString = paramString + "?z=" + System.currentTimeMillis())
    {
      this.c = paramString;
      loadUrl(paramString);
      this.j = true;
      return;
    }
  }
  
  /* Error */
  public final void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 343
    //   5: iconst_1
    //   6: anewarray 140	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_1
    //   12: aastore
    //   13: invokestatic 347	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 39	com/greystripe/sdk/aa:h	Z
    //   21: ifeq +11 -> 32
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 229	com/greystripe/sdk/aa:loadUrl	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 45	com/greystripe/sdk/aa:i	Ljava/util/LinkedList;
    //   36: aload_1
    //   37: invokevirtual 351	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: goto -12 -> 29
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	aa
    //   0	49	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   32	41	44	finally
  }
  
  public final void loadUrl(String paramString)
  {
    if (bd.b()) {
      bd.b("loadUrl(\"" + paramString + "\")", new Object[0]);
    }
    bm.a(new ab(this, paramString));
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.j)
    {
      this.j = false;
      bd.b("onDraw() called in webview: " + toString(), new Object[0]);
      this.e.b();
    }
  }
  
  @Deprecated
  public final boolean post(Runnable paramRunnable)
  {
    return super.post(paramRunnable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */