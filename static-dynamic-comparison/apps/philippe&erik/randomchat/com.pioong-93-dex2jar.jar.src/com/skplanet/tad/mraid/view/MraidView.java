package com.skplanet.tad.mraid.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.skplanet.tad.AdActivity;
import com.skplanet.tad.AdActivity.a;
import com.skplanet.tad.controller.c;
import com.skplanet.tad.controller.d;
import com.skplanet.tad.controller.d.a;
import com.skplanet.tad.controller.e;
import com.skplanet.tad.controller.h;
import com.skplanet.tad.mraid.controller.MraidController.ExpandProperties;
import com.skplanet.tad.mraid.controller.MraidController.OrientationProperties;
import com.skplanet.tad.mraid.controller.MraidController.PlayerProperties;
import com.skplanet.tad.mraid.controller.MraidController.ResizeProperties;
import com.skplanet.tad.mraid.controller.MraidUtilityController;
import com.skplanet.tad.mraid.controller.util.MraidPlayer;
import com.skplanet.tad.mraid.controller.util.MraidPlayerListener;
import com.skplanet.tad.mraid.controller.util.MraidUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MraidView
  extends WebView
{
  private static MraidPlayer m;
  public int a;
  public int b;
  WebViewClient c = new WebViewClient()
  {
    public void onLoadResource(WebView paramAnonymousWebView, String paramAnonymousString) {}
    
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      com.skplanet.tad.common.a.c("onPageFinished() mIsDestroyed : " + MraidView.a(MraidView.this));
      if (MraidView.h(MraidView.this) != null) {
        MraidView.h(MraidView.this).sendEmptyMessage(1000);
      }
    }
    
    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
    }
    
    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      com.skplanet.tad.common.a.c("[MariudView]WebViewClient error : " + paramAnonymousString1);
      super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      paramAnonymousWebView = Uri.parse(paramAnonymousString);
      try
      {
        if (paramAnonymousWebView.getScheme().equalsIgnoreCase("tel")) {
          MraidView.this.a("MAKE_CALL");
        }
        for (;;)
        {
          paramAnonymousWebView = new Intent("android.intent.action.VIEW", paramAnonymousWebView);
          paramAnonymousWebView.addFlags(268435456);
          MraidView.this.getContext().startActivity(paramAnonymousWebView);
          return true;
          if (paramAnonymousWebView.getScheme().equalsIgnoreCase("sms")) {
            MraidView.this.a("SEND_SMS");
          } else if (paramAnonymousWebView.getScheme().equalsIgnoreCase("mailto")) {
            MraidView.this.a("SEND_MAIL");
          } else if (paramAnonymousWebView.getScheme().equalsIgnoreCase("geo")) {
            MraidView.this.a("OPEN_MAP");
          } else {
            MraidView.this.a("ETC");
          }
        }
        return false;
      }
      catch (Exception paramAnonymousWebView) {}
    }
  };
  WebChromeClient d = new WebChromeClient()
  {
    public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
    {
      com.skplanet.tad.common.a.e("onConsoleMessage message : " + paramAnonymousConsoleMessage.message() + " - Line " + paramAnonymousConsoleMessage.lineNumber() + " of " + paramAnonymousConsoleMessage.sourceId());
      return true;
    }
    
    public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      com.skplanet.tad.common.a.e("onJsAlert message : " + paramAnonymousString2);
      return false;
    }
  };
  private h e;
  private MraidUtilityController f;
  private DisplayMetrics g;
  private WindowManager h;
  private float i;
  private int j;
  private a k = a.a;
  private a l;
  private int n;
  private boolean o = false;
  private com.skplanet.tad.controller.b p;
  private FrameLayout q;
  private boolean r = false;
  private Handler s = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (MraidView.a(MraidView.this))
      {
        com.skplanet.tad.common.a.d("MraidView.handleMessage(), already mraidview is destroyed.");
        return;
      }
      Object localObject = paramAnonymousMessage.getData();
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        MraidView.b(MraidView.this);
        continue;
        MraidView.c(MraidView.this);
        continue;
        switch (a()[MraidView.d(MraidView.this).ordinal()])
        {
        default: 
          break;
        case 1: 
          MraidView.this.g();
          break;
        case 2: 
          MraidView.e(MraidView.this);
          break;
        case 3: 
          MraidView.this.h();
          continue;
          MraidView.f(MraidView.this);
          continue;
          MraidView.g(MraidView.this);
          continue;
          MraidView.a(MraidView.this, (Bundle)localObject);
          MraidView.b(MraidView.this, (Bundle)localObject);
          continue;
          MraidView.c(MraidView.this, (Bundle)localObject);
          continue;
          MraidView.a(MraidView.this, (Bundle)localObject);
          continue;
          MraidView.d(MraidView.this, (Bundle)localObject);
          continue;
          if (localObject != null)
          {
            String str = ((Bundle)localObject).getString("message");
            localObject = ((Bundle)localObject).getString("action");
            MraidView.this.b("window.mraidview.fireErrorEvent(\"" + str + "\", \"" + (String)localObject + "\")");
          }
          break;
        }
      }
    }
  };
  
  public MraidView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    n();
  }
  
  public MraidView(Context paramContext, a parama, boolean paramBoolean, com.skplanet.tad.controller.b paramb)
  {
    super(paramContext);
    setListener(parama);
    this.o = paramBoolean;
    this.p = paramb;
    n();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.skplanet.tad.common.a.a("in MraidView.resizeWindow()", ", width:" + paramInt1 + ", height:" + paramInt2);
    com.skplanet.tad.common.a.c("width : " + paramInt1);
    com.skplanet.tad.common.a.c("height : " + paramInt2);
    com.skplanet.tad.common.a.c("offsetX : " + paramInt3);
    com.skplanet.tad.common.a.c("offsetY : " + paramInt4);
    FrameLayout localFrameLayout1 = (FrameLayout)getRootView().findViewById(16908290);
    Object localObject = (ViewGroup)getParent();
    int i2 = ((ViewGroup)localObject).getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {}
      while (((ViewGroup)localObject).getChildAt(i1) == this)
      {
        this.j = i1;
        FrameLayout localFrameLayout2 = new FrameLayout(getContext());
        localFrameLayout2.setTag("com.skplanet.tad.mraid.placeholder" + hashCode());
        ((ViewGroup)localObject).addView(localFrameLayout2, i1, new ViewGroup.LayoutParams(getWidth(), getHeight()));
        ((ViewGroup)localObject).removeView(this);
        localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2, 0);
        ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt3;
        ((FrameLayout.LayoutParams)localObject).topMargin = paramInt4;
        localFrameLayout2 = new FrameLayout(getContext());
        localFrameLayout2.setTag("com.skplanet.tad.mraid.background.resized" + hashCode());
        localFrameLayout2.addView(this, new FrameLayout.LayoutParams(paramInt1, paramInt2, 17));
        localFrameLayout1.addView(localFrameLayout2, (ViewGroup.LayoutParams)localObject);
        requestFocus();
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, float paramFloat)
  {
    FrameLayout localFrameLayout1 = (FrameLayout)getRootView().findViewById(16908290);
    Object localObject = (ViewGroup)getParent();
    paramInt2 = ((ViewGroup)localObject).getChildCount();
    paramInt1 = 0;
    if (paramInt1 >= paramInt2)
    {
      label36:
      this.j = paramInt1;
      FrameLayout localFrameLayout2 = new FrameLayout(getContext());
      localFrameLayout2.setTag("com.skplanet.tad.mraid.placeholder" + hashCode());
      ((ViewGroup)localObject).addView(localFrameLayout2, paramInt1, new ViewGroup.LayoutParams(getWidth(), getHeight()));
      ((ViewGroup)localObject).removeView(this);
      localObject = new FrameLayout(getContext());
      ((FrameLayout)localObject).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      ((FrameLayout)localObject).setTag("com.skplanet.tad.mraid.background.expanded" + hashCode());
      ((FrameLayout)localObject).addView(this, new FrameLayout.LayoutParams(-1, -1, 17));
      if (!paramBoolean2) {
        break label256;
      }
      ((FrameLayout)localObject).setBackgroundColor((int)(255.0F * paramFloat) * 16777216 | paramInt3);
    }
    for (;;)
    {
      localFrameLayout1.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1, 17));
      requestFocus();
      if (!paramBoolean1) {
        a((ViewGroup)localObject, new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MraidView.this.j();
          }
        });
      }
      return;
      if (((ViewGroup)localObject).getChildAt(paramInt1) == this) {
        break label36;
      }
      paramInt1 += 1;
      break;
      label256:
      ((FrameLayout)localObject).setBackgroundColor(Integer.MIN_VALUE);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, float paramFloat, String paramString)
  {
    final Object localObject = (FrameLayout)getRootView().findViewById(16908290);
    final MraidView localMraidView = new MraidView(getContext(), new a()
    {
      public void a(MraidView paramAnonymousMraidView)
      {
        if (paramAnonymousMraidView != null)
        {
          paramAnonymousMraidView.m();
          if (MraidView.d(MraidView.this) == MraidView.a.c) {
            paramAnonymousMraidView.f();
          }
        }
      }
      
      public void b(MraidView paramAnonymousMraidView) {}
      
      public void c(MraidView paramAnonymousMraidView) {}
      
      public void d(MraidView paramAnonymousMraidView)
      {
        com.skplanet.tad.common.a.c("in 2-piece MraidView.onClosed()");
        ((Activity)MraidView.this.getContext()).setRequestedOrientation(MraidView.i(MraidView.this));
        MraidView.a(MraidView.this, MraidView.a.a);
        if (MraidView.j(MraidView.this) != null) {
          MraidView.j(MraidView.this).e(paramAnonymousMraidView);
        }
        MraidView.this.a("CLOSE_EXPAND");
        MraidView.this.b("window.mraidview.fireChangeEvent({ onState : 'default' });");
        MraidView.this.b("window.mraidview.fireChangeEvent({ onSize : { width : " + MraidView.this.a + ", height : " + MraidView.this.b + " }});");
        Object localObject = (FrameLayout)MraidView.this.getRootView().findViewWithTag("com.skplanet.tad.mraid.background.expanded" + paramAnonymousMraidView.hashCode());
        if (localObject != null)
        {
          ViewGroup localViewGroup = (ViewGroup)((FrameLayout)localObject).getParent();
          if (localViewGroup != null) {
            localViewGroup.removeView((View)localObject);
          }
        }
        MraidView.this.setVisibility(0);
        localObject = MraidView.this.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = ((int)(MraidView.this.a * MraidView.k(MraidView.this)));
        ((ViewGroup.LayoutParams)localObject).height = ((int)(MraidView.this.b * MraidView.k(MraidView.this)));
        MraidView.this.requestLayout();
        if (paramAnonymousMraidView != null)
        {
          MraidView.l(paramAnonymousMraidView).stopAllListeners();
          paramAnonymousMraidView.stopLoading();
          paramAnonymousMraidView.d();
        }
      }
      
      public void e(MraidView paramAnonymousMraidView) {}
      
      public void f(MraidView paramAnonymousMraidView) {}
      
      public void g(MraidView paramAnonymousMraidView) {}
    }, true, this.p);
    localMraidView.b(-1, -1);
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localFrameLayout.setTag("com.skplanet.tad.mraid.background.expanded" + localMraidView.hashCode());
    localFrameLayout.addView(localMraidView, new FrameLayout.LayoutParams(-1, -1, 17));
    if (paramBoolean2) {
      localFrameLayout.setBackgroundColor((int)(255.0F * paramFloat) * 16777216 | paramInt3);
    }
    for (;;)
    {
      if (localObject != null) {
        ((FrameLayout)localObject).addView(localFrameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
      }
      localMraidView.l();
      localMraidView.requestFocus();
      localObject = new e(new d()
      {
        public void a(d.a paramAnonymousa) {}
        
        public void a(Object paramAnonymousObject)
        {
          localMraidView.loadDataWithBaseURL(null, (String)paramAnonymousObject, "text/html", "utf-8", null);
        }
      }, null);
      ((e)localObject).execute(new String[] { paramString });
      localMraidView.setOnKeyListener(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousInt == 4)
          {
            if (paramAnonymousKeyEvent.getAction() == 1)
            {
              localMraidView.m();
              if (localObject != null) {
                localObject.cancel(true);
              }
              localMraidView.stopLoading();
              localMraidView.j();
            }
            return true;
          }
          return false;
        }
      });
      if (!paramBoolean1) {
        a(localFrameLayout, new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            localMraidView.j();
          }
        });
      }
      setVisibility(4);
      return;
      localFrameLayout.setBackgroundColor(Integer.MIN_VALUE);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    com.skplanet.tad.common.a.c("in MraidView.doExpand()");
    String str = paramBundle.getString("expand_url");
    paramBundle = (MraidController.ExpandProperties)paramBundle.getParcelable("expand_properties");
    if (this.k == a.b) {
      p();
    }
    int i1 = (int)(paramBundle.width * this.i);
    int i2 = (int)(paramBundle.height * this.i);
    if (URLUtil.isValidUrl(str))
    {
      com.skplanet.tad.common.a.c("Marid.doExpand[EXPAND] url : " + str);
      a(i1, i2, paramBundle.useCustomClose, false, 0, 0.0F, str);
    }
    for (;;)
    {
      if (this.l != null) {
        this.l.c(this);
      }
      a("EXPAND");
      this.k = a.c;
      b("window.mraidview.fireChangeEvent({ onState : 'expanded' });");
      b("window.mraidview.fireChangeEvent({ onSize : { width : " + paramBundle.width + ", height : " + paramBundle.height + " }});");
      return;
      a(i1, i2, paramBundle.useCustomClose, false, 0, 0.0F);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    com.skplanet.tad.common.a.c("in MraidView.doResize()");
    paramBundle = (MraidController.ResizeProperties)paramBundle.getParcelable("resize_properties");
    if (this.k == a.b) {
      p();
    }
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    FrameLayout localFrameLayout = (FrameLayout)getRootView().findViewById(16908290);
    int i1 = localFrameLayout.getLeft();
    int i2 = localFrameLayout.getTop();
    a((int)(paramBundle.width * this.i), (int)(paramBundle.height * this.i), arrayOfInt[0] - i1 + (int)(paramBundle.offsetX * this.i), arrayOfInt[1] - i2 + (int)(paramBundle.offsetY * this.i));
    if (this.l != null) {
      this.l.b(this);
    }
    a("RESIZE");
    this.k = a.b;
    b("window.mraidview.fireChangeEvent({ onState : 'resized' });");
    b("window.mraidview.fireChangeEvent({ onSize : { width : " + paramBundle.width + ", height : " + paramBundle.height + " }});");
  }
  
  private void c(Bundle paramBundle)
  {
    com.skplanet.tad.common.a.c("in MraidView.doOrientation()");
    paramBundle = (MraidController.OrientationProperties)paramBundle.getParcelable("orientation_properties");
    com.skplanet.tad.common.a.c("allowOrientationChange : " + paramBundle.allowOrientationChange + ", forceOrientation : " + paramBundle.forceOrientation);
    if (paramBundle.forceOrientation.equalsIgnoreCase("portrait")) {
      ((Activity)getContext()).setRequestedOrientation(1);
    }
    for (;;)
    {
      if (paramBundle.allowOrientationChange) {
        ((Activity)getContext()).setRequestedOrientation(-1);
      }
      return;
      if (paramBundle.forceOrientation.equalsIgnoreCase("landscape")) {
        ((Activity)getContext()).setRequestedOrientation(0);
      }
    }
  }
  
  private void d(final Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      com.skplanet.tad.common.a.d("MraidView.playVieoImp, data is null");
      return;
    }
    FrameLayout localFrameLayout = (FrameLayout)getRootView().findViewById(16908290);
    Object localObject = (MraidController.PlayerProperties)paramBundle.getParcelable("player_properties");
    String str = paramBundle.getString("player_url");
    paramBundle = k();
    if (paramBundle == null)
    {
      com.skplanet.tad.common.a.d("MraidView.playVieoImp, videoPlayer is null");
      return;
    }
    paramBundle.setPlayData((MraidController.PlayerProperties)localObject, str);
    localObject = new FrameLayout(getContext());
    ((FrameLayout)localObject).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    ((FrameLayout)localObject).setTag("com.skplanet.tad.mraid.background.video" + hashCode());
    ((FrameLayout)localObject).addView(paramBundle, new FrameLayout.LayoutParams(-1, -1, 17));
    ((FrameLayout)localObject).setBackgroundColor(Integer.MIN_VALUE);
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    paramBundle.requestFocus();
    paramBundle.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 4)
        {
          if (paramAnonymousKeyEvent.getAction() == 1) {
            paramBundle.releasePlayer();
          }
          return true;
        }
        return false;
      }
    });
    a((ViewGroup)localObject, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramBundle.releasePlayer();
      }
    });
    setVisibility(4);
    paramBundle.setListener(new MraidPlayerListener()
    {
      public void onComplete()
      {
        FrameLayout localFrameLayout = (FrameLayout)MraidView.this.getRootView().findViewWithTag("com.skplanet.tad.mraid.background.video" + MraidView.this.hashCode());
        if (localFrameLayout != null)
        {
          ViewGroup localViewGroup = (ViewGroup)localFrameLayout.getParent();
          if (localViewGroup != null) {
            localViewGroup.removeView(localFrameLayout);
          }
        }
        MraidView.this.setVisibility(0);
      }
      
      public void onError()
      {
        onComplete();
      }
      
      public void onPrepared() {}
    });
    paramBundle.playVideo();
    a("PLAY_VIDEO");
  }
  
  private void n()
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      View.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
      setScrollContainer(true);
      setVerticalScrollBarEnabled(false);
      setHorizontalScrollBarEnabled(false);
      setBackgroundColor(0);
      setFocusable(true);
      setFocusableInTouchMode(true);
      this.n = ((Activity)getContext()).getRequestedOrientation();
      this.g = new DisplayMetrics();
      this.h = ((WindowManager)getContext().getSystemService("window"));
      this.h.getDefaultDisplay().getMetrics(this.g);
      this.i = this.g.density;
      WebSettings localWebSettings = getSettings();
      localWebSettings.setDefaultTextEncodingName("utf-8");
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setLoadsImagesAutomatically(true);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setSavePassword(false);
      localWebSettings.setSupportMultipleWindows(false);
      localWebSettings.setSupportZoom(false);
      this.f = new MraidUtilityController(this, getContext());
      addJavascriptInterface(this.f, "MRAIDUtilityControllerBridge");
      setWebViewClient(this.c);
      setWebChromeClient(this.d);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        com.skplanet.tad.common.a.d("MraidView.initialeze(), NoSuchMethodException");
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        com.skplanet.tad.common.a.d("MraidView.initialeze(), IllegalArgumentException");
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        com.skplanet.tad.common.a.d("MraidView.initialeze(), IllegalArgumentException");
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        com.skplanet.tad.common.a.d("MraidView.initialeze(), InvocationTargetException");
        localInvocationTargetException.printStackTrace();
      }
    }
  }
  
  private void o()
  {
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)(this.a * this.i));
    ((ViewGroup.LayoutParams)localObject).height = ((int)(this.b * this.i));
    requestLayout();
    localObject = (FrameLayout)getRootView().findViewById(16908290);
    FrameLayout localFrameLayout1 = (FrameLayout)getRootView().findViewWithTag("com.skplanet.tad.mraid.placeholder" + hashCode());
    FrameLayout localFrameLayout2 = (FrameLayout)getRootView().findViewWithTag("com.skplanet.tad.mraid.background.expanded" + hashCode());
    ViewGroup localViewGroup = (ViewGroup)localFrameLayout1.getParent();
    if ((localFrameLayout2 == null) || (localObject == null) || (localViewGroup == null))
    {
      com.skplanet.tad.common.a.d("MraidView.closeExpandWindow() null exception");
      return;
    }
    if (localFrameLayout2 != null) {
      localFrameLayout2.removeView(this);
    }
    if (localObject != null) {
      ((FrameLayout)localObject).removeView(localFrameLayout2);
    }
    if (localViewGroup != null)
    {
      localViewGroup.addView(this, this.j);
      localViewGroup.removeView(localFrameLayout1);
    }
    requestFocus();
  }
  
  private void p()
  {
    int i1 = (int)(this.a * this.i);
    int i2 = (int)(this.b * this.i);
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = i1;
    ((ViewGroup.LayoutParams)localObject).height = i2;
    requestLayout();
    localObject = (FrameLayout)getRootView().findViewById(16908290);
    FrameLayout localFrameLayout1 = (FrameLayout)getRootView().findViewWithTag("com.skplanet.tad.mraid.placeholder" + hashCode());
    FrameLayout localFrameLayout2 = (FrameLayout)getRootView().findViewWithTag("com.skplanet.tad.mraid.background.resized" + hashCode());
    ViewGroup localViewGroup = (ViewGroup)localFrameLayout1.getParent();
    if ((localObject == null) || (localFrameLayout1 == null) || (localFrameLayout2 == null))
    {
      com.skplanet.tad.common.a.d("Marid View. closeResized Window, null point exception");
      return;
    }
    if (localFrameLayout2 != null) {
      localFrameLayout2.removeView(this);
    }
    if (localObject != null) {
      ((FrameLayout)localObject).removeView(localFrameLayout2);
    }
    if (localViewGroup != null)
    {
      localViewGroup.addView(this, this.j);
      localViewGroup.removeView(localFrameLayout1);
    }
    requestFocus();
  }
  
  private void q()
  {
    if (this.l != null) {
      this.l.a(this);
    }
  }
  
  private void r()
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    FrameLayout localFrameLayout = (FrameLayout)getRootView().findViewById(16908290);
    if (localFrameLayout != null)
    {
      int i2 = localFrameLayout.getLeft();
      int i1 = localFrameLayout.getTop();
      i2 = (int)((arrayOfInt[0] - i2) / this.i);
      i1 = (int)((arrayOfInt[1] - i1) / this.i);
      if (this.f != null)
      {
        this.f.setDefaultPosition(i2, i1, this.a, this.b);
        this.f.init(this.i);
      }
      a("READY");
      if (!this.o) {
        new Thread(new c(getContext(), 0, this.p)).start();
      }
    }
  }
  
  private void s()
  {
    com.skplanet.tad.common.a.c("in MraidView.doHide()");
    if (this.k == a.d)
    {
      b("window.mraidview.fireErrorEvent(\"Ad is currently hidden.\", \"hide\")");
      return;
    }
    this.k = a.d;
    setVisibility(4);
    b("window.mraidview.fireChangeEvent({ onState : 'hidden' });");
  }
  
  private void t()
  {
    com.skplanet.tad.common.a.c("in MraidView.doShow()");
    if (this.k != a.d)
    {
      b("window.mraidview.fireErrorEvent(\"Ad is currently visible.\", \"show\")");
      return;
    }
    this.k = a.a;
    b("window.mraidview.fireChangeEvent({ onState : 'default' });");
    setVisibility(0);
  }
  
  private void u()
  {
    com.skplanet.tad.common.a.c("in MraidView.closeResized()");
    this.k = a.a;
    if (this.l != null) {
      this.l.f(this);
    }
    a("CLOSE_RESIZE");
    b("window.mraidview.fireChangeEvent({ onState : 'default' });");
    b("window.mraidview.fireChangeEvent({ onSize : { width : " + this.a + ", height : " + this.b + " }});");
    p();
  }
  
  public ImageView a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setTag("com.skplanet.tad.mraid.close" + hashCode());
    localImageView.setOnClickListener(paramOnClickListener);
    localImageView.setImageBitmap(MraidUtils.bitmapFromJar("/assets/tad_close.png"));
    int i1 = (int)(this.i * 50.0F);
    int i2 = (int)(this.i * 50.0F);
    if (paramViewGroup != null) {
      paramViewGroup.addView(localImageView, new FrameLayout.LayoutParams(i1, i2, 5));
    }
    return localImageView;
  }
  
  public h a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    com.skplanet.tad.common.a.c("MraidView.sendEventCode() action : " + paramInt);
    try
    {
      new Thread(new c(getContext(), paramInt, this.p)).start();
      return;
    }
    catch (Exception localException)
    {
      com.skplanet.tad.common.a.d("MaraidView.sendEventCode(), action: " + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      this.a = ((int)(this.g.widthPixels / this.g.density));
      if (paramInt2 >= 0) {
        break label65;
      }
    }
    label65:
    for (this.b = ((int)(this.g.heightPixels / this.g.density));; this.b = paramInt2)
    {
      b(paramInt1, paramInt2);
      return;
      this.a = paramInt1;
      break;
    }
  }
  
  public void a(MraidController.ResizeProperties paramResizeProperties)
  {
    if (this.s != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("resize_properties", paramResizeProperties);
      paramResizeProperties = this.s.obtainMessage(1006);
      paramResizeProperties.setData(localBundle);
      this.s.sendMessage(paramResizeProperties);
    }
  }
  
  public void a(String paramString)
  {
    if (this.e != null) {
      this.e.a(paramString);
    }
  }
  
  public void a(String paramString, MraidController.ExpandProperties paramExpandProperties, MraidController.OrientationProperties paramOrientationProperties)
  {
    if (this.s != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("expand_url", paramString);
      localBundle.putParcelable("expand_properties", paramExpandProperties);
      localBundle.putParcelable("orientation_properties", paramOrientationProperties);
      paramString = this.s.obtainMessage(1005);
      paramString.setData(localBundle);
      this.s.sendMessage(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.s != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("message", paramString1);
      localBundle.putString("action", paramString2);
      paramString1 = this.s.obtainMessage(1009);
      paramString1.setData(localBundle);
      this.s.sendMessage(paramString1);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3)
  {
    MraidController.PlayerProperties localPlayerProperties = new MraidController.PlayerProperties();
    localPlayerProperties.setProperties(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramString3);
    paramString2 = new Bundle();
    paramString2.putString("player_url", paramString1);
    paramString2.putString("action", AdActivity.a.e.toString());
    paramString2.putParcelable("player_properties", localPlayerProperties);
    if (localPlayerProperties.isFullScreen()) {}
    while (this.s == null) {
      try
      {
        paramString1 = new Intent(getContext(), AdActivity.class);
        paramString1.putExtras(paramString2);
        getContext().startActivity(paramString1);
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        a("Cannot find AdActivity", "playVideo");
        return;
      }
    }
    paramString1 = this.s.obtainMessage(1008);
    paramString1.setData(paramString2);
    this.s.sendMessage(paramString1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i1 = -1;
    switch (paramInt1)
    {
    }
    for (paramInt1 = (int)(paramInt1 * this.i);; paramInt1 = -1)
    {
      switch (paramInt2)
      {
      default: 
        i1 = (int)(paramInt2 * this.i);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, i1);
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (this.r) {
      com.skplanet.tad.common.a.d("MraidView.injectJavaScript(), already mraidview is destroyed.");
    }
    while (paramString == null) {
      return;
    }
    com.skplanet.tad.common.a.c("Mraid.injectJavaScript : " + paramString);
    super.loadUrl("javascript:" + paramString);
  }
  
  public boolean b()
  {
    return this.o;
  }
  
  public void c()
  {
    try
    {
      FrameLayout localFrameLayout1 = (FrameLayout)getRootView().findViewById(16908290);
      FrameLayout localFrameLayout2 = (FrameLayout)getRootView().findViewWithTag("com.skplanet.tad.mraid.background.resized" + hashCode());
      FrameLayout localFrameLayout3 = (FrameLayout)getRootView().findViewWithTag("com.skplanet.tad.mraid.background.expanded" + hashCode());
      if (localFrameLayout2 != null) {
        localFrameLayout2.removeView(this);
      }
      if (localFrameLayout3 != null) {
        localFrameLayout3.removeView(this);
      }
      if (localFrameLayout1 != null)
      {
        localFrameLayout1.removeView(localFrameLayout2);
        localFrameLayout1.removeView(localFrameLayout3);
      }
      this.f.stopAllListeners();
      stopLoading();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(String paramString)
  {
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.addFlags(268435456);
      getContext().startActivity(paramString);
      a("OPEN");
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      a("Cannot open this url", "open");
    }
  }
  
  public void d()
  {
    if (this.r)
    {
      com.skplanet.tad.common.a.d("MraidView.release(), already mraidview is destroyed.");
      return;
    }
    try
    {
      this.r = true;
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null)
      {
        com.skplanet.tad.common.a.c("MraidView.release(), parent.removeView(this) called.");
        localViewGroup.removeView(this);
      }
      super.clearView();
      com.skplanet.tad.common.a.c("MraidView.release(), super.clearView() called.");
      super.destroy();
      com.skplanet.tad.common.a.c("MraidView.release(), super.destory() called.");
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(String paramString)
  {
    com.skplanet.tad.v2.controller.a.a(getContext(), com.skplanet.tad.common.b.a(getContext()).f, this.p.c, this.p.a, paramString, this.p.b, null);
  }
  
  public boolean e()
  {
    return this.f.getUseCustomClose();
  }
  
  public void f()
  {
    if (this.s != null) {
      this.s.sendEmptyMessage(1001);
    }
  }
  
  protected void g()
  {
    try
    {
      com.skplanet.tad.common.a.c("in MraidView.closeDefault()");
      if (this.l != null) {
        this.l.d(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void h()
  {
    try
    {
      com.skplanet.tad.common.a.c("in MraidView.closeExpanded()");
      ((Activity)getContext()).setRequestedOrientation(this.n);
      this.k = a.a;
      if (this.l != null) {
        this.l.e(this);
      }
      a("CLOSE_EXPAND");
      b("window.mraidview.fireChangeEvent({ onState : 'default' });");
      b("window.mraidview.fireChangeEvent({ onSize : { width : " + this.a + ", height : " + this.b + " }});");
      o();
      return;
    }
    finally {}
  }
  
  public a i()
  {
    return this.k;
  }
  
  public void j()
  {
    if (this.s != null) {
      this.s.sendEmptyMessage(1002);
    }
  }
  
  MraidPlayer k()
  {
    if (m != null) {
      m.releasePlayer();
    }
    m = new MraidPlayer(getContext());
    return m;
  }
  
  void l()
  {
    Object localObject = new FrameLayout.LayoutParams(-2, -2, 17);
    this.q = new FrameLayout(getContext());
    this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.q.addView(new ProgressBar(getContext()));
    localObject = (ViewGroup)getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).addView(this.q);
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    com.skplanet.tad.common.a.c("in MraidView.loadDataWithBaseURL()");
    com.skplanet.tad.common.a.c("baseUrl : " + paramString1);
    com.skplanet.tad.common.a.c("mimeType : " + paramString3);
    com.skplanet.tad.common.a.c("encoding : " + paramString4);
    com.skplanet.tad.common.a.c("historyUrl : " + paramString5);
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    com.skplanet.tad.common.a.c("in MraidView.loadUrl() url : " + paramString);
    super.loadUrl(paramString);
  }
  
  void m()
  {
    if (this.q != null)
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.q);
      }
      this.q = null;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    com.skplanet.tad.common.a.c("in MraidView.onDetachedFromWindow()");
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.k == a.a) && (!this.o) && (!this.r) && (this.k == a.a) && (!this.o) && (paramMotionEvent.getAction() == 0))
    {
      new Thread(new c(getContext(), 1, this.p)).start();
      if (this.l != null) {
        this.l.g(this);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((this.k == a.b) || (this.k == a.c)) && (paramInt == 4)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((this.k == a.b) || (this.k == a.c)) && (paramInt == 4))
    {
      j();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.skplanet.tad.common.a.c("in MraidView.onSizeChanged() width : " + paramInt1 + ", height : " + paramInt2);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    requestDisallowInterceptTouchEvent(true);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEventParams(com.skplanet.tad.controller.b paramb)
  {
    this.p = paramb;
  }
  
  public void setListener(a parama)
  {
    this.l = parama;
  }
  
  public void setOrientation(MraidController.OrientationProperties paramOrientationProperties)
  {
    if (this.s != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("orientation_properties", paramOrientationProperties);
      paramOrientationProperties = this.s.obtainMessage(1007);
      paramOrientationProperties.setData(localBundle);
      this.s.sendMessage(paramOrientationProperties);
    }
  }
  
  public void setTracker(h paramh)
  {
    this.e = paramh;
  }
  
  public static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/view/MraidView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */