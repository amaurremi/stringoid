package com.mocoplex.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.reflect.Method;

public class AdlibDialogView
  extends LinearLayout
{
  AnimationSet a;
  private Handler b;
  private Handler c;
  private String d;
  private int e;
  private int f;
  private int g;
  private WebView h = null;
  private LinearLayout i = null;
  private int j = 0;
  
  public AdlibDialogView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdlibDialogView(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this(paramContext, paramString, paramInt1, paramInt2, (byte)0);
  }
  
  private AdlibDialogView(Context paramContext, String paramString, int paramInt1, int paramInt2, byte paramByte)
  {
    super(paramContext, null);
    this.d = paramString;
    this.e = paramInt1;
    this.f = paramInt1;
    this.g = paramInt2;
    setGravity(17);
    paramString = new AlphaAnimation(0.5F, 1.0F);
    paramString.setDuration(100L);
    Object localObject = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    this.a = new AnimationSet(false);
    this.a.addAnimation(paramString);
    this.a.addAnimation((Animation)localObject);
    paramInt1 = a(this.e);
    paramInt2 = a(this.f);
    this.i = new LinearLayout(paramContext);
    this.i.setLayoutParams(new LinearLayout.LayoutParams(paramInt1, paramInt2));
    this.i.setGravity(17);
    paramString = this.i;
    localObject = new ShapeDrawable(new RoundRectShape(new float[] { 10.0F, 10.0F, 10.0F, 10.0F, 10.0F, 10.0F, 10.0F, 10.0F }, null, null));
    ((ShapeDrawable)localObject).getPaint().setColor(-1);
    paramString.setBackgroundDrawable((Drawable)localObject);
    this.h = new WebView(paramContext);
    this.h.setLayoutParams(new LinearLayout.LayoutParams(paramInt1, paramInt2));
    this.h.setScrollBarStyle(33554432);
    this.h.getSettings().setJavaScriptEnabled(true);
    this.h.setWebViewClient(new b((byte)0));
    this.h.setWebChromeClient(new a((byte)0));
    this.h.addJavascriptInterface(new JavascriptInterface(paramContext), "gotoAds");
    this.h.loadUrl("file://" + AdlibConfig.getInstance().e(this.d));
    this.c = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          return;
          try
          {
            AdlibDialogView.d(AdlibDialogView.this).loadUrl("javascript:setWidthAndHeight(" + AdlibDialogView.e(AdlibDialogView.this) + "," + AdlibDialogView.b(AdlibDialogView.this) + ")");
            return;
          }
          catch (Exception paramAnonymousMessage)
          {
            return;
          }
          try
          {
            int i = AdlibDialogView.b(AdlibDialogView.this, AdlibDialogView.e(AdlibDialogView.this));
            int j = AdlibDialogView.b(AdlibDialogView.this, AdlibDialogView.f(AdlibDialogView.this));
            AdlibDialogView.g(AdlibDialogView.this).setLayoutParams(new LinearLayout.LayoutParams(i + 12, j + 12));
            AdlibDialogView.d(AdlibDialogView.this).setLayoutParams(new LinearLayout.LayoutParams(i, j));
            AdlibDialogView.this.setVisibility(0);
            AdlibDialogView.this.setAnimation(AdlibDialogView.this.a);
            if (AdlibDialogView.f(AdlibDialogView.this) <= 0)
            {
              if (AdlibDialogView.h(AdlibDialogView.this) >= 2)
              {
                AdlibDialogView.c(AdlibDialogView.this).sendEmptyMessage(10);
                c.a();
                c.b(AdlibDialogView.this.getContext(), AdlibDialogView.i(AdlibDialogView.this));
                return;
              }
              paramAnonymousMessage = AdlibDialogView.this;
              AdlibDialogView.c(paramAnonymousMessage, AdlibDialogView.h(paramAnonymousMessage) + 1);
              AdlibDialogView.d(AdlibDialogView.this).reload();
              return;
            }
          }
          catch (Exception paramAnonymousMessage) {}
        }
      }
    };
    this.i.addView(this.h);
    addView(this.i);
    setVisibility(4);
  }
  
  private int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  private static void a(WebView paramWebView, String paramString)
  {
    try
    {
      WebView.class.getMethod(paramString, new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onDestroy()
  {
    if (this.h != null)
    {
      removeView(this.i);
      removeView(this.h);
      this.h.removeAllViews();
      this.h.destroy();
      this.i = null;
      this.h = null;
    }
  }
  
  public void onPause()
  {
    if (this.h != null)
    {
      a(this.h, "onPause");
      this.h.getSettings().setJavaScriptEnabled(false);
    }
  }
  
  public void onResume()
  {
    if (this.h != null)
    {
      a(this.h, "onResume");
      this.h.getSettings().setJavaScriptEnabled(true);
      this.h.reload();
    }
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  public class JavascriptInterface
  {
    Context a;
    private final Handler c = new Handler();
    
    JavascriptInterface(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void banner(final String paramString)
    {
      this.c.post(new Runnable()
      {
        public final void run()
        {
          Message localMessage = Message.obtain(AdlibDialogView.c(AdlibDialogView.this), 20, paramString);
          AdlibDialogView.c(AdlibDialogView.this).sendMessage(localMessage);
        }
      });
    }
    
    public void close()
    {
      this.c.post(new Runnable()
      {
        public final void run()
        {
          AdlibDialogView.c(AdlibDialogView.this).sendEmptyMessage(10);
        }
      });
    }
    
    public void go2(final String paramString1, final String paramString2, final String paramString3)
    {
      this.c.post(new Runnable()
      {
        public final void run()
        {
          if ((paramString1 != null) && (!paramString1.equals(""))) {
            new d(new Handler()
            {
              public final void handleMessage(Message paramAnonymous2Message)
              {
                int i = paramAnonymous2Message.what;
              }
            }).a(paramString1, null);
          }
          if (paramString3.equals("www"))
          {
            localMessage = Message.obtain(AdlibDialogView.c(AdlibDialogView.this), 30, paramString2);
            AdlibDialogView.c(AdlibDialogView.this).sendMessage(localMessage);
            return;
          }
          Message localMessage = Message.obtain(AdlibDialogView.c(AdlibDialogView.this), 20, paramString2);
          AdlibDialogView.c(AdlibDialogView.this).sendMessage(localMessage);
        }
      });
    }
    
    public void onReady()
    {
      this.c.post(new Runnable()
      {
        public final void run()
        {
          AdlibDialogView.a(AdlibDialogView.this).sendEmptyMessage(0);
        }
      });
    }
    
    public void showWithHeight(final int paramInt)
    {
      this.c.post(new Runnable()
      {
        public final void run()
        {
          if (paramInt > AdlibDialogView.b(AdlibDialogView.this)) {
            AdlibDialogView.a(AdlibDialogView.this, AdlibDialogView.b(AdlibDialogView.this));
          }
          for (;;)
          {
            AdlibDialogView.a(AdlibDialogView.this).sendEmptyMessage(1);
            return;
            AdlibDialogView.a(AdlibDialogView.this, paramInt);
          }
        }
      });
    }
    
    public void www(final String paramString)
    {
      this.c.post(new Runnable()
      {
        public final void run()
        {
          Message localMessage = Message.obtain(AdlibDialogView.c(AdlibDialogView.this), 20, paramString);
          AdlibDialogView.c(AdlibDialogView.this).sendMessage(localMessage);
        }
      });
    }
  }
  
  final class a
    extends WebChromeClient
  {
    private a() {}
  }
  
  final class b
    extends WebViewClient
  {
    private b() {}
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibDialogView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */