package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ae
  extends View
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  static float[] at = new float[80];
  boolean A = true;
  boolean B = true;
  boolean C = true;
  boolean D;
  boolean E;
  boolean F;
  boolean G;
  boolean H;
  boolean I;
  boolean J;
  boolean K;
  boolean L;
  boolean M;
  boolean N;
  boolean O;
  boolean P;
  boolean Q;
  boolean R;
  Canvas S;
  String T = a.l.a.b;
  String U;
  String V;
  String W;
  ab.b Z;
  WebView a;
  float aA;
  Paint aB = new Paint(1);
  RectF aC = new RectF();
  ae.b aD = new ae.b(this);
  Handler aE = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (ae.this.d.isFinishing()) {}
      while (ae.this.d.D == null) {
        return;
      }
      ae.this.a(paramAnonymousMessage.what);
    }
  };
  Paint aa = new Paint();
  Paint ab = new Paint(1);
  Paint ac = new Paint(1);
  Paint ad = new Paint(1);
  Rect ae = new Rect();
  ADCImage af;
  ADCImage ag;
  ADCImage ah;
  ADCImage ai;
  ADCImage aj;
  ADCImage ak;
  ADCImage al;
  ADCImage am;
  ADCImage an;
  ADCImage ao;
  ADCImage[] ap = new ADCImage[4];
  ADCImage[] aq = new ADCImage[4];
  m ar;
  String[] as = new String[4];
  float au;
  float av;
  float aw;
  float ax;
  float ay;
  float az;
  WebView b;
  View c;
  ADCVideo d;
  double e = 1.0D;
  double f = 1.0D;
  int g = 99;
  int h = 0;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  int r;
  int s;
  int t;
  int u;
  long v;
  long w;
  boolean x = true;
  boolean y = true;
  boolean z = true;
  
  ae(ADCVideo paramADCVideo)
  {
    super(paramADCVideo);
    this.d = paramADCVideo;
    this.L = a.l.a.s;
    if (a.H != null)
    {
      this.L |= a.H.i.v.n.a;
      a.H.m = a.H.n;
    }
    this.P = a.M;
    if (a.e != null) {
      a.R = a.e;
    }
    boolean bool;
    if ((a.H != null) && (a.H.i.u.d))
    {
      if (!this.P)
      {
        bool = true;
        this.M = bool;
      }
    }
    else
    {
      if (!this.M) {
        break label1097;
      }
      this.af = new ADCImage(a.j("end_card_filepath"));
      this.n = this.af.f;
      this.o = this.af.g;
      if (this.n == 0) {
        this.n = 480;
      }
      if (this.o == 0) {
        this.o = 320;
      }
      this.ap[0] = new ADCImage(a.j("info_image_normal"));
      this.ap[1] = new ADCImage(a.j("download_image_normal"));
      this.ap[2] = new ADCImage(a.j("replay_image_normal"));
      this.ap[3] = new ADCImage(a.j("continue_image_normal"));
      this.aq[0] = new ADCImage(a.j("info_image_down"), true);
      this.aq[1] = new ADCImage(a.j("download_image_down"), true);
      this.aq[2] = new ADCImage(a.j("replay_image_down"), true);
      this.aq[3] = new ADCImage(a.j("continue_image_down"), true);
      this.as[0] = "Info";
      this.as[1] = "Download";
      this.as[2] = "Replay";
      this.as[3] = "Continue";
    }
    for (;;)
    {
      if (this.L)
      {
        this.ag = new ADCImage(a.j("skip_video_image_normal"));
        this.ah = new ADCImage(a.j("skip_video_image_down"));
        this.p = (a.h("skip_delay") * 1000);
      }
      this.aB.setStyle(Paint.Style.STROKE);
      float f2 = 2.0F * paramADCVideo.getResources().getDisplayMetrics().density;
      float f1 = f2;
      if (f2 > 6.0F) {
        f1 = 6.0F;
      }
      if (f1 < 4.0F) {}
      this.aB.setStrokeWidth(2.0F * paramADCVideo.getResources().getDisplayMetrics().density);
      this.aB.setColor(-3355444);
      this.R = false;
      this.K = false;
      if (a.H != null) {
        this.K = a.H.i.v.o.a;
      }
      if (this.K)
      {
        this.am = new ADCImage(a.j("engagement_image_normal"));
        this.an = new ADCImage(a.j("engagement_image_down"));
        this.W = a.H.i.v.o.j;
        this.U = a.H.i.v.o.l;
        this.V = a.H.i.v.o.o;
        this.r = a.H.i.v.o.c;
        this.q = (a.h("engagement_delay") * 1000);
        if (this.U.equals("")) {
          this.U = "Learn More";
        }
        if (!this.V.equals("")) {
          this.F = true;
        }
        if (this.F)
        {
          this.b = new WebView(paramADCVideo);
          this.b.setBackgroundColor(0);
        }
        if ((this.am == null) || (this.an == null)) {
          this.K = false;
        }
      }
      if (ADCVideo.d) {
        e();
      }
      this.aa.setColor(-1);
      this.ac.setTextSize(24.0F);
      this.ac.setColor(-16777216);
      this.ab.setColor(-3355444);
      this.ab.setTextSize(20.0F);
      this.ab.setTextAlign(Paint.Align.CENTER);
      this.ad.setTextSize(20.0F);
      this.ad.setColor(-1);
      label1097:
      try
      {
        getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
        return;
      }
      catch (Exception paramADCVideo) {}
      bool = false;
      break;
      if (this.P)
      {
        this.ak = new ADCImage(a.j("reload_image_normal"));
        this.ai = new ADCImage(a.j("close_image_normal"));
        this.aj = new ADCImage(a.j("close_image_down"));
        this.al = new ADCImage(a.j("reload_image_down"));
        this.ao = new ADCImage(a.j("browser_icon"));
        this.c = new ae.a(this, paramADCVideo);
        b();
      }
    }
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1;
    if ((paramInt1 >= this.g) && (paramInt1 < this.g + 62)) {
      i1 = 1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i1;
            if ((paramInt1 >= this.g + 78) && (paramInt1 < this.g + 78 + 62)) {
              return 2;
            }
            if ((paramInt1 >= this.g + 78 + 78) && (paramInt1 < this.g + 78 + 78 + 62)) {
              return 3;
            }
            if ((paramInt1 >= this.g + 78 + 78 + 78) && (paramInt1 < this.g + 78 + 78 + 78 + 62)) {
              return 4;
            }
            i1 = i2;
          } while (this.d.D == null);
          i1 = i2;
        } while (!this.L);
        i1 = i2;
      } while (paramInt1 < this.d.D.getWidth() - this.ag.f);
      i1 = i2;
    } while (paramInt2 > this.ag.g);
    return 10;
  }
  
  public void a()
  {
    boolean bool = this.d.b();
    this.x |= bool;
    if (this.d.D != null)
    {
      if (this.s <= 0) {
        this.s = this.d.D.getDuration();
      }
      if (bool)
      {
        setLayoutParams(new FrameLayout.LayoutParams(this.d.t, this.d.u, 17));
        this.d.D.setLayoutParams(new FrameLayout.LayoutParams(this.d.x, this.d.y, 17));
        this.x = true;
      }
    }
    float f1;
    float f2;
    double d1;
    int i1;
    label300:
    label320:
    label488:
    label570:
    double d2;
    if (this.x)
    {
      this.x = false;
      int i2;
      if (this.y)
      {
        DisplayMetrics localDisplayMetrics = AdColony.activity().getResources().getDisplayMetrics();
        f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        d1 = Math.sqrt(f1 * f1 + f2 * f2);
        i1 = localDisplayMetrics.widthPixels;
        i2 = localDisplayMetrics.widthPixels;
        int i3 = localDisplayMetrics.heightPixels;
        d1 = Math.sqrt(localDisplayMetrics.heightPixels * i3 + i1 * i2) / d1;
        if (d1 / 280.0D >= 0.7D) {
          break label940;
        }
        d1 = 0.7D;
        this.f = d1;
        if ((!AdColony.isTablet()) && (this.f == 0.7D)) {
          this.f = 1.0D;
        }
        if (this.f * 20.0D >= 18.0D) {
          break label949;
        }
        f1 = 18.0F;
        if (this.f * 20.0D >= 18.0D) {
          break label963;
        }
        f2 = 18.0F;
        this.ab.setTextSize(f1);
        this.ad.setTextSize(f1);
        this.ac.setTextSize(f2);
        if ((this.K) && (this.am != null) && (this.an != null))
        {
          this.am.a(b(this.U + this.am.f * 2), this.am.g);
          this.an.a(b(this.U + this.an.f * 2), this.an.g);
        }
        if (this.d.t <= this.d.u) {
          break label977;
        }
        i1 = this.d.u;
        this.y = false;
      }
      if (this.P)
      {
        if ((bool) && (this.a != null)) {
          this.a.setLayoutParams(new FrameLayout.LayoutParams(this.d.t, this.d.u - this.m, 17));
        }
        if (this.d.y / 640.0D >= 0.9D) {
          break label989;
        }
        d1 = 0.9D;
        this.e = d1;
        if ((!AdColony.isTablet()) && (this.e == 0.9D)) {
          this.e = 1.2D;
        }
      }
      if (this.M)
      {
        d2 = this.n / this.o;
        if (this.d.t / d2 <= this.d.u / 1.0D) {
          break label1005;
        }
        d1 = this.d.u / 1.0D;
        label652:
        this.d.x = ((int)(d2 * d1));
        this.d.y = ((int)(d1 * 1.0D));
        if (this.d.t <= this.d.u) {
          break label1019;
        }
        d1 = this.d.y / 640.0D;
        label704:
        this.e = d1;
        if (this.d.t / this.n <= this.d.u / this.o) {
          break label1035;
        }
        d1 = this.d.u / this.o;
        label756:
        this.af.a(d1);
        this.af.d(this.d.t, this.d.u);
      }
      if ((this.K) && (this.am != null) && (this.an != null))
      {
        if ((this.am == null) || (this.an == null) || (this.am.b == null) || (this.an.b == null)) {
          break label1053;
        }
        i1 = (int)(this.am.b.getHeight() * this.f);
        i2 = (int)(this.an.b.getHeight() * this.f);
        this.am.b(this.am.f, i1);
        this.an.b(this.an.f, i2);
      }
    }
    for (;;)
    {
      if (this.L)
      {
        this.ag.a(this.f);
        this.ah.a(this.f);
      }
      return;
      label940:
      d1 /= 280.0D;
      break;
      label949:
      f1 = (float)(this.f * 20.0D);
      break label300;
      label963:
      f2 = (float)(this.f * 20.0D);
      break label320;
      label977:
      i1 = this.d.t;
      break label488;
      label989:
      d1 = this.d.y / 640.0D;
      break label570;
      label1005:
      d1 = this.d.t / d2;
      break label652;
      label1019:
      d1 = this.d.y / 960.0D;
      break label704;
      label1035:
      d1 = this.d.t / this.n;
      break label756;
      label1053:
      this.K = false;
    }
  }
  
  void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((!this.B) && (paramInt != 10)) {
          break;
        }
        this.B = false;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          this.t = 0;
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              ae.this.B = true;
            }
          }, 1500L);
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        String str1;
        this.B = true;
        return;
      }
      this.t = 0;
      a.a("info", "{\"ad_slot\":" + a.H.h.k.c + "}", this.d.F);
      str1 = a.j("info_url");
      l.b.a("INFO ").b(str1);
      if ((str1.startsWith("market:")) || (str1.startsWith("amzn:")))
      {
        this.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str1)));
      }
      else
      {
        AdColonyBrowser.url = localRuntimeException;
        this.d.startActivity(new Intent(this.d, AdColonyBrowser.class));
        continue;
        this.t = 0;
        a.a("download", "{\"ad_slot\":" + a.H.h.k.c + "}", this.d.F);
        String str2 = a.j("download_url");
        l.b.a("DOWNLOAD ").b(str2);
        if ((str2.startsWith("market:")) || (str2.startsWith("amzn:")))
        {
          this.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
        }
        else
        {
          AdColonyBrowser.url = str2;
          this.d.startActivity(new Intent(this.d, AdColonyBrowser.class));
          continue;
          this.t = 0;
          h();
          invalidate();
          continue;
          this.t = 0;
          this.d.D.a();
          f();
          continue;
          this.t = 0;
          g();
        }
      }
    }
  }
  
  void a(String paramString)
  {
    if (this.M) {}
    while (this.a == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.a.evaluateJavascript(paramString, null);
      return;
    }
    this.a.loadUrl("javascript:" + paramString);
  }
  
  void a(boolean paramBoolean)
  {
    if (this.M) {
      return;
    }
    if (paramBoolean)
    {
      a("adc_bridge.fireChangeEvent({viewable:true});");
      return;
    }
    a("adc_bridge.fireChangeEvent({viewable:false});");
  }
  
  public boolean a(ADCImage paramADCImage, int paramInt1, int paramInt2)
  {
    return (paramInt1 < paramADCImage.b() + paramADCImage.f + 8) && (paramInt1 > paramADCImage.b() - 8) && (paramInt2 < paramADCImage.c() + paramADCImage.g + 8) && (paramInt2 > paramADCImage.c() - 8);
  }
  
  int b(String paramString)
  {
    this.ac.getTextWidths(paramString, at);
    float f1 = 0.0F;
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      f1 += at[i1];
      i1 += 1;
    }
    return (int)f1;
  }
  
  void b()
  {
    this.a = new WebView(this.d);
    this.a.setFocusable(true);
    this.a.setHorizontalScrollBarEnabled(false);
    this.a.setVerticalScrollBarEnabled(false);
    Object localObject = this.a.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setPluginState(WebSettings.PluginState.ON_DEMAND);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setGeolocationEnabled(true);
    this.a.setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        String str2 = paramAnonymousConsoleMessage.sourceId();
        String str1;
        if (str2 == null) {
          str1 = "Internal";
        }
        for (;;)
        {
          l.b.a(paramAnonymousConsoleMessage.message()).a(" [").a(str1).a(" line ").a(paramAnonymousConsoleMessage.lineNumber()).b("]");
          return true;
          int i = str2.lastIndexOf('/');
          str1 = str2;
          if (i != -1) {
            str1 = str2.substring(i + 1);
          }
        }
      }
      
      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }
    });
    this.d.I = new FrameLayout(this.d);
    if (a.i("hardware_acceleration_disabled")) {}
    try
    {
      this.d.I.getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this.a, new Object[] { Integer.valueOf(1), null });
      this.ar = new m(this.d, this.a, this.d);
      localObject = new WebViewClient()
      {
        String a = a.R;
        
        public void onLoadResource(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          l.a.a("DEC onLoad: ").b(paramAnonymousString);
          if (paramAnonymousString.equals(this.a))
          {
            l.a.b("DEC disabling mouse events");
            ae.this.a("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
          }
        }
        
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (paramAnonymousString.equals(this.a))
          {
            ae.this.C = false;
            ae.this.d.l = true;
            ae.this.w = System.currentTimeMillis();
            ae.this.d.p = ((ae.this.w - ae.this.v) / 1000.0D);
          }
          ae.this.d.H.removeView(ae.this.c);
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          if (paramAnonymousString.equals(this.a))
          {
            ae.this.d.k = true;
            ae.this.v = System.currentTimeMillis();
          }
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          l.a.a("DEC request: ").b(paramAnonymousString);
          if (paramAnonymousString.contains("mraid:")) {
            ae.this.ar.a(paramAnonymousString);
          }
          do
          {
            return true;
            if (paramAnonymousString.contains("youtube"))
            {
              paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + paramAnonymousString));
              paramAnonymousWebView.putExtra("VIDEO_ID", paramAnonymousString);
              ae.this.d.startActivity(paramAnonymousWebView);
              return true;
            }
          } while (paramAnonymousString.contains("mraid.js"));
          return false;
        }
      };
      this.a.setWebViewClient((WebViewClient)localObject);
      if (Build.VERSION.SDK_INT >= 19) {
        this.a.loadUrl(a.R);
      }
      localObject = ab.a(a.S, "");
      l.a.b("Injecting mraid");
      a((String)localObject);
      if (a.m)
      {
        localObject = "true";
        a("var is_tablet=" + (String)localObject + ";");
        if (!a.m) {
          break label439;
        }
      }
      label439:
      for (localObject = "tablet";; localObject = "phone")
      {
        a("adc_bridge.adc_version='" + a.U + "'");
        a("adc_bridge.os_version='" + a.T + "'");
        a("adc_bridge.os_name='android'");
        a("adc_bridge.device_type='" + (String)localObject + "'");
        a("adc_bridge.fireChangeEvent({state:'default'});");
        a("adc_bridge.fireReadyEvent()");
        if (Build.VERSION.SDK_INT < 19) {
          this.a.loadUrl(a.R);
        }
        return;
        localObject = "false";
        break;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void b(int paramInt)
  {
    this.h = paramInt;
    if (paramInt < 0) {
      this.h = 0;
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (this.M) {}
  }
  
  public void c()
  {
    ??? = a.l;
    final Object localObject2 = this.d;
    ((d)???).a(ADCVideo.e, this.d.F);
    if ((this.P) && (this.C) && (a.P))
    {
      this.d.H.addView(this.c);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if ((ae.this.C) && (ae.this.d != null) && (ae.this.P) && (ae.this.a != null))
          {
            ae.this.d.m = true;
            ae.this.f();
          }
        }
      }, a.Q * 1000);
    }
    if (a.N) {
      f();
    }
    a.a("card_shown", this.d.F);
    synchronized (this.aD)
    {
      this.Z = null;
      if (a.H.i.u.e) {
        this.Z = new ab.b(a.H.i.u.g);
      }
      if (this.P)
      {
        ??? = new Handler();
        localObject2 = new View(this.d);
        Runnable local6 = new Runnable()
        {
          public void run()
          {
            ae.this.d.H.removeView(localObject2);
            ae.this.a(true);
            ae.this.d.r = System.currentTimeMillis();
          }
        };
        ((View)localObject2).setBackgroundColor(-16777216);
        this.d.H.addView((View)localObject2);
        ((Handler)???).postDelayed(local6, 500L);
        this.d.I.setVisibility(0);
      }
      this.d.r = System.currentTimeMillis();
      e();
      return;
    }
  }
  
  void d()
  {
    this.a.loadUrl(a.R);
    l.a.a("Loading - end card url = ").b(a.R);
  }
  
  void e()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (ae.this.d.D != null) {
          ae.this.d.D.setVisibility(8);
        }
      }
    }, 300L);
    ADCVideo localADCVideo = this.d;
    ADCVideo.d = true;
    if (this.d.D != null) {
      this.d.D.a();
    }
    w.H = null;
    invalidate();
    this.H = false;
    invalidate();
  }
  
  void f()
  {
    if ((this.d == null) || ((this.P) && ((this.a == null) || (this.d.I == null) || (this.d.H == null)))) {
      return;
    }
    a.D = true;
    this.d.s = System.currentTimeMillis();
    ADCVideo localADCVideo = this.d;
    localADCVideo.q += (this.d.s - this.d.r) / 1000.0D;
    a.W = true;
    int i1 = 0;
    while (i1 < a.ac.size())
    {
      if (a.ac.get(i1) != null) {
        ((AdColonyNativeAdView)a.ac.get(i1)).a();
      }
      i1 += 1;
    }
    this.d.finish();
    this.Z = null;
    if (this.P)
    {
      this.d.H.removeView(this.d.I);
      this.a.destroy();
      this.a = null;
    }
    a.K.a(this.d.F);
    AdColonyBrowser.A = true;
  }
  
  void g()
  {
    a.D = true;
    if (a.H.b())
    {
      ADCVideo localADCVideo = this.d;
      ADCVideo.a = this.d.D.getCurrentPosition();
      w.H = new w(this.d, (AdColonyV4VCAd)a.H);
      return;
    }
    int i1 = 0;
    while (i1 < a.ac.size())
    {
      if (a.ac.get(i1) != null) {
        ((AdColonyNativeAdView)a.ac.get(i1)).a();
      }
      i1 += 1;
    }
    this.d.finish();
    a.K.b(this.d.F);
    a.W = true;
    AdColonyBrowser.A = true;
  }
  
  void h()
  {
    a.a("replay", this.d.F);
    final Object localObject = this.d;
    ADCVideo.e = true;
    localObject = this.d;
    ADCVideo.d = false;
    localObject = this.d;
    ADCVideo.a = 0;
    this.R = false;
    localObject = new View(this.d);
    ((View)localObject).setBackgroundColor(-16777216);
    this.d.H.addView((View)localObject, new FrameLayout.LayoutParams(this.d.t, this.d.u, 17));
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (ae.this.P) {
          ae.this.d.I.setVisibility(4);
        }
        ae.this.d.H.removeView(localObject);
      }
    }, 900L);
    this.d.D.start();
    a.l.a(this.d.F);
    this.d.D.requestFocus();
    this.d.D.setBackgroundColor(0);
    this.d.D.setVisibility(0);
    a(false);
  }
  
  void i()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Rect localRect = new Rect();
        jdField_this.getWindowVisibleDisplayFrame(localRect);
        if (ae.this.a != null) {
          ae.this.b(jdField_this.getRootView().getHeight() - (localRect.bottom - localRect.top) - (ae.this.d.u - ae.this.a.getHeight()) / 2);
        }
        ae.this.j();
      }
    });
  }
  
  void j()
  {
    if ((this.h >= 70) && (!this.D))
    {
      this.D = true;
      b(true);
    }
    while ((!this.D) || (this.h != 0)) {
      return;
    }
    this.D = false;
    b(false);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    c();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.E) {
      return;
    }
    a();
    this.S = paramCanvas;
    boolean bool;
    label51:
    label91:
    int i1;
    int i3;
    int i4;
    int i2;
    if ((!this.N) && (this.L))
    {
      if (this.d.D.getCurrentPosition() > this.p)
      {
        bool = true;
        this.N = bool;
      }
    }
    else
    {
      if ((!this.O) && (this.K))
      {
        if (this.d.D.getCurrentPosition() <= this.q) {
          break label415;
        }
        bool = true;
        this.O = bool;
      }
      localObject = this.d;
      if ((!ADCVideo.d) || (!this.M)) {
        break label491;
      }
      paramCanvas.drawARGB(this.d.z >> 24 & 0xFF, 0, 0, 0);
      this.af.a(paramCanvas, (this.d.t - this.af.f) / 2, (this.d.u - this.af.g) / 2);
      i1 = (int)(186.0D * this.e);
      i3 = this.af.b() + i1;
      i1 = (int)(470.0D * this.e);
      i4 = this.af.c() + i1;
      i2 = 0;
      label228:
      if (i2 < this.ap.length)
      {
        if ((this.t != i2 + 1) && ((this.u != i2 + 1) || (this.z) || (this.u == 0))) {
          break label421;
        }
        this.aq[i2].a(this.e);
        this.aq[i2].a(paramCanvas, i3, i4);
        i1 = (int)(i3 + 157.0F * this.e);
      }
    }
    for (;;)
    {
      this.ab.setColor(-1);
      this.ab.clearShadowLayer();
      paramCanvas.drawText(this.as[i2], this.ap[i2].b() + this.ap[i2].f / 2, this.ap[i2].c() + this.ap[i2].g, this.ab);
      i2 += 1;
      i3 = i1;
      break label228;
      break;
      bool = false;
      break label51;
      label415:
      bool = false;
      break label91;
      label421:
      if (!this.z)
      {
        i1 = i3;
        if (i2 + 1 == this.u) {}
      }
      else
      {
        this.ap[i2].a(this.e);
        this.ap[i2].a(paramCanvas, i3, i4);
        i1 = (int)(i3 + 157.0F * this.e);
      }
    }
    label491:
    Object localObject = this.d;
    if ((ADCVideo.d) && (this.P))
    {
      this.ai.a(this.f);
      this.aj.a(this.f);
      this.ak.a(this.f);
      this.al.a(this.f);
      if ((!a.m) && (this.i != 0))
      {
        i1 = this.i;
        this.i = i1;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        if (this.G) {
          break label665;
        }
        this.ai.a(paramCanvas, this.i, this.j);
        label617:
        if (this.H) {
          break label684;
        }
        this.ak.a(paramCanvas, this.k, this.l);
      }
      for (;;)
      {
        i();
        return;
        i1 = this.d.t - this.ai.f;
        break;
        label665:
        this.aj.a(paramCanvas, this.i, this.j);
        break label617;
        label684:
        this.al.a(paramCanvas, this.k, this.l);
      }
    }
    if (this.d.D != null)
    {
      a.l.a(this.d.D.getCurrentPosition() / this.d.D.getDuration(), this.d.F);
      i2 = this.d.D.getCurrentPosition();
      i1 = (this.s - i2 + 999) / 1000;
      if ((!this.R) || (i1 != 1)) {
        break label1528;
      }
      i1 = 0;
    }
    label1238:
    label1423:
    label1458:
    label1528:
    for (;;)
    {
      if (i1 == 0) {
        this.R = true;
      }
      if (i2 >= 500)
      {
        if (this.A)
        {
          this.av = ((float)(360.0D / (this.s / 1000.0D)));
          this.A = false;
          localObject = new Rect();
          this.ab.getTextBounds("0123456789", 0, 9, (Rect)localObject);
          this.ay = ((Rect)localObject).height();
        }
        this.aw = getWidth();
        this.ax = getHeight();
        this.az = this.ay;
        this.aA = (this.d.u - this.ay - this.m);
        this.aC.set(this.az - this.ay / 2.0F, this.aA - 2.0F * this.ay, this.az + 2.0F * this.ay, this.aA + this.ay / 2.0F);
        this.aB.setShadowLayer((int)(4.0D * this.e), 0.0F, 0.0F, -16777216);
        double d1 = this.av;
        this.au = ((float)((this.s / 1000.0D - i2 / 1000.0D) * d1));
        paramCanvas.drawArc(this.aC, 270.0F, this.au, false, this.aB);
        localObject = this.d;
        if (!ADCVideo.d)
        {
          this.ab.setColor(-3355444);
          this.ab.setShadowLayer((int)(2.0D * this.e), 0.0F, 0.0F, -16777216);
          this.ab.setTextAlign(Paint.Align.CENTER);
          this.ab.setLinearText(true);
          paramCanvas.drawText("" + i1, this.aC.centerX(), (float)(this.aC.centerY() + this.ab.getFontMetrics().bottom * 1.35D), this.ab);
        }
        if (this.L)
        {
          localObject = this.d;
          if ((!ADCVideo.d) && (this.N))
          {
            if (this.t != 10) {
              break label1423;
            }
            this.ah.a(paramCanvas, this.d.t - this.ah.f, (int)(this.e * 4.0D));
          }
        }
        if ((this.K) && (this.O) && (!this.F))
        {
          if (!this.I) {
            break label1458;
          }
          this.an.c((int)(this.d.t - this.an.f - this.ay / 2.0F), this.d.u - this.an.g - this.m - (int)(this.ay / 2.0F));
          this.an.a(paramCanvas);
        }
      }
      for (;;)
      {
        this.ac.setTextAlign(Paint.Align.CENTER);
        paramCanvas.drawText(this.U, this.am.e.centerX(), (float)(this.am.e.centerY() + this.ac.getFontMetrics().bottom * 1.35D), this.ac);
        if (w.H != null) {
          w.H.onDraw(paramCanvas);
        }
        paramCanvas = this.d;
        if (!ADCVideo.i) {
          break;
        }
        invalidate();
        return;
        this.ag.a(paramCanvas, this.d.t - this.ag.f, (int)(this.e * 4.0D));
        break label1238;
        this.am.c((int)(this.d.t - this.am.f - this.ay / 2.0F), this.d.u - this.am.g - this.m - (int)(this.ay / 2.0F));
        this.am.a(paramCanvas);
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    g();
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m = (this.d.u - paramInt2);
    if (Build.MODEL.equals("Kindle Fire")) {
      this.m = 20;
    }
    if (Build.MODEL.equals("SCH-I800")) {
      this.m = 25;
    }
    if ((Build.MODEL.equals("SHW-M380K")) || (Build.MODEL.equals("SHW-M380S")) || (Build.MODEL.equals("SHW-M380W"))) {
      this.m = 40;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = paramMotionEvent.getAction();
    if (w.H != null)
    {
      w.H.onTouchEvent(paramMotionEvent);
      return true;
    }
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    ADCVideo localADCVideo;
    int i4;
    if (i3 == 0)
    {
      localADCVideo = this.d;
      if ((ADCVideo.d) && (this.P))
      {
        if (a(this.ai, i1, i2))
        {
          this.G = true;
          invalidate();
          return true;
        }
        if (a(this.ak, i1, i2))
        {
          this.H = true;
          invalidate();
          return true;
        }
        return false;
      }
      localADCVideo = this.d;
      i3 = i2;
      i4 = i1;
      if (ADCVideo.d)
      {
        i3 = i2;
        i4 = i1;
        if (this.M)
        {
          i1 = (int)((paramMotionEvent.getX() - this.af.b()) / (this.e * 2.0D));
          i2 = (int)((paramMotionEvent.getY() - this.af.c()) / (this.e * 2.0D));
          i3 = i2;
          i4 = i1;
          if (this.t == 0)
          {
            i3 = i2;
            i4 = i1;
            if (i2 >= 235)
            {
              i3 = i2;
              i4 = i1;
              if (i2 < 305)
              {
                i3 = a(i1, i2);
                this.t = i3;
                this.u = i3;
                this.z = false;
                invalidate();
                i4 = i1;
                i3 = i2;
              }
            }
          }
        }
      }
      if ((this.L) && (this.N) && (this.d.D != null) && (a(this.ag, i4, i3)))
      {
        this.t = 10;
        this.u = this.t;
        this.z = false;
        invalidate();
        return true;
      }
      if ((this.K) && (this.O) && (a(this.am, i4, i3)))
      {
        this.I = true;
        invalidate();
        return true;
      }
    }
    else
    {
      if (i3 == 1)
      {
        localADCVideo = this.d;
        if ((ADCVideo.d) && (this.P))
        {
          if ((a(this.ai, i1, i2)) && (this.G))
          {
            this.t = 4;
            if (this.a != null) {
              this.a.clearCache(true);
            }
            this.aE.sendMessageDelayed(this.aE.obtainMessage(this.t), 250L);
            return true;
          }
          if ((a(this.ak, i1, i2)) && (this.H))
          {
            this.t = 3;
            if (this.a != null) {
              this.a.clearCache(true);
            }
            this.aE.sendMessageDelayed(this.aE.obtainMessage(this.t), 250L);
            return true;
          }
        }
        localADCVideo = this.d;
        i3 = i2;
        i4 = i1;
        if (ADCVideo.d)
        {
          i3 = i2;
          i4 = i1;
          if (this.M)
          {
            i1 = (int)((paramMotionEvent.getX() - this.af.b()) / (this.e * 2.0D));
            i2 = (int)((paramMotionEvent.getY() - this.af.c()) / (this.e * 2.0D));
            i3 = i2;
            i4 = i1;
            if (!this.z)
            {
              i3 = i2;
              i4 = i1;
              if (i2 >= 235)
              {
                i3 = i2;
                i4 = i1;
                if (i2 < 305)
                {
                  int i5 = a(i1, i2);
                  i3 = i2;
                  i4 = i1;
                  if (i5 > 0)
                  {
                    i3 = i2;
                    i4 = i1;
                    if (i5 == this.u)
                    {
                      this.aE.sendMessageDelayed(this.aE.obtainMessage(i5), 250L);
                      i4 = i1;
                      i3 = i2;
                    }
                  }
                }
              }
            }
          }
        }
        if ((this.L) && (this.N) && (this.d.D != null) && (a(this.ag, i4, i3)))
        {
          this.t = 10;
          this.z = true;
          this.u = this.t;
          this.aE.sendMessageDelayed(this.aE.obtainMessage(this.t), 250L);
          return true;
        }
        if ((this.K) && (this.O) && (a(this.am, i4, i3)))
        {
          this.I = false;
          if ((this.W.startsWith("market:")) || (this.W.startsWith("amzn:"))) {
            this.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.W)));
          }
          for (;;)
          {
            a.a("in_video_engagement", "{\"ad_slot\":" + a.H.h.k.c + "}", this.d.F);
            return true;
            AdColonyBrowser.url = this.W;
            this.d.startActivity(new Intent(this.d, AdColonyBrowser.class));
          }
        }
        this.G = false;
        this.H = false;
        this.I = false;
        this.z = true;
        this.t = 0;
        invalidate();
        return true;
      }
      if (i3 == 3)
      {
        this.G = false;
        this.H = false;
        this.I = false;
        this.z = true;
        this.t = 0;
        invalidate();
        return true;
      }
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */