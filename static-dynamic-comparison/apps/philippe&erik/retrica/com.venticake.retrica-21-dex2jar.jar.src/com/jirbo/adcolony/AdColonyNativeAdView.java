package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.util.ArrayList;

public class AdColonyNativeAdView
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  boolean A = true;
  boolean B;
  boolean C;
  boolean D;
  AdColonyInterstitialAd E;
  AdColonyNativeAdListener F;
  AdColonyNativeAdMutedListener G;
  ADCImage H;
  ADCImage I;
  ADCImage J;
  ImageView K;
  AdColonyNativeAdView.b L;
  View M;
  Bitmap N;
  ADCImage O;
  ImageView P;
  boolean Q = false;
  Button R;
  String S = "";
  String T = "";
  String U = "";
  MediaPlayer V;
  Surface W;
  String Z;
  TextView a;
  String aa;
  String ab;
  String ac;
  String ad;
  String ae;
  String af;
  int ag;
  int ah;
  int ai;
  int aj;
  int ak;
  int al = -3355444;
  int am = -16777216;
  int an;
  n.y ao;
  n.a ap;
  float aq = 0.25F;
  float ar = 0.25F;
  float as;
  FileInputStream at;
  TextView b;
  TextView c;
  Activity d;
  String e;
  String f;
  ViewGroup g;
  SurfaceTexture h;
  int i;
  int j;
  boolean k;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  boolean r;
  boolean s;
  boolean t;
  boolean u;
  boolean v;
  boolean w;
  boolean x;
  boolean y = true;
  boolean z;
  
  public AdColonyNativeAdView(Activity paramActivity, String paramString, int paramInt)
  {
    super(paramActivity);
    a.e();
    a.ac.add(this);
    a.Y = 0;
    this.d = paramActivity;
    this.e = paramString;
    this.ai = paramInt;
    this.o = true;
    this.as = a.b().getResources().getDisplayMetrics().density;
    paramActivity = a.b().getWindowManager().getDefaultDisplay();
    int i1;
    if (Build.VERSION.SDK_INT >= 14)
    {
      Point localPoint = new Point();
      paramActivity.getSize(localPoint);
      paramInt = localPoint.x;
      i1 = localPoint.y;
      if (paramInt >= i1) {
        break label241;
      }
    }
    for (;;)
    {
      this.an = paramInt;
      this.E = new AdColonyInterstitialAd(paramString);
      this.E.j = "native";
      this.E.k = "native";
      a.l.d.a(paramString, this.E);
      setBackgroundColor(-16777216);
      a();
      return;
      paramInt = paramActivity.getWidth();
      i1 = paramActivity.getHeight();
      break;
      label241:
      paramInt = i1;
    }
  }
  
  AdColonyNativeAdView(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramActivity);
    a.e();
    this.d = paramActivity;
    this.e = paramString;
    this.ai = paramInt;
    this.D = paramBoolean;
    this.o = true;
    this.as = a.b().getResources().getDisplayMetrics().density;
    paramActivity = a.b().getWindowManager().getDefaultDisplay();
    int i1;
    if (Build.VERSION.SDK_INT >= 14)
    {
      Point localPoint = new Point();
      paramActivity.getSize(localPoint);
      paramInt = localPoint.x;
      i1 = localPoint.y;
      if (paramInt >= i1) {
        break label221;
      }
    }
    for (;;)
    {
      this.an = paramInt;
      this.E = new AdColonyInterstitialAd(paramString);
      this.E.j = "native";
      this.E.k = "native";
      setBackgroundColor(-16777216);
      a();
      return;
      paramInt = paramActivity.getWidth();
      i1 = paramActivity.getHeight();
      break;
      label221:
      paramInt = i1;
    }
  }
  
  void a()
  {
    this.w = false;
    this.n = false;
    setWillNotDraw(false);
    this.E.u = this;
    label273:
    label350:
    label358:
    label375:
    float f1;
    if (this.y)
    {
      if ((a.l != null) && (a.l.a != null) && (this.E != null) && (this.E.g != null) && (a.l.a(this.E.g, true, false)))
      {
        a.l.a.b(this.e);
        this.E.b(true);
        this.ao = this.E.h;
        this.f = a.j("video_filepath");
        this.Z = a.j("advertiser_name");
        this.aa = a.j("description");
        this.ab = a.j("title");
        this.ac = a.j("poster_image");
        this.ad = a.j("unmute");
        this.ae = a.j("mute");
        this.af = a.j("thumb_image");
        this.Q = a.i("native_engagement_enabled");
        this.S = a.j("native_engagement_label");
        this.T = a.j("native_engagement_command");
        this.U = a.j("native_engagement_type");
        if ((this.E.i == null) || (this.E.i.w == null)) {
          break label350;
        }
        this.v = this.E.i.w.b;
        if (this.ao != null) {
          this.ao.k();
        }
        if ((this.E.i != null) && (this.E.i.w != null) && (this.E.i.w.a) && (this.E.h != null)) {
          break label358;
        }
        a.Y = 13;
      }
      do
      {
        return;
        this.r = true;
        break;
        this.v = true;
        break label273;
        this.p = true;
      } while (this.D);
      this.y = false;
      this.ag = this.E.i.v.c;
      this.ah = this.E.i.v.d;
      this.aj = ((int)(this.ah * (this.ai / this.ag)));
      if (this.Q)
      {
        this.R = new Button(a.b());
        this.R.setText(this.S);
        this.R.setGravity(17);
        this.R.setTextSize((int)(18.0D * (this.ai / this.an)));
        this.R.setPadding(0, 0, 0, 0);
        this.R.setBackgroundColor(this.al);
        this.R.setTextColor(this.am);
        this.R.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            int i = paramAnonymousMotionEvent.getAction();
            if (i == 0)
            {
              paramAnonymousView = new float[3];
              Color.colorToHSV(AdColonyNativeAdView.this.al, paramAnonymousView);
              paramAnonymousView[2] *= 0.8F;
              AdColonyNativeAdView.this.R.setBackgroundColor(Color.HSVToColor(paramAnonymousView));
            }
            do
            {
              return true;
              if (i == 3)
              {
                AdColonyNativeAdView.this.R.setBackgroundColor(AdColonyNativeAdView.this.al);
                return true;
              }
            } while (i != 1);
            if ((AdColonyNativeAdView.this.U.equals("install")) || (AdColonyNativeAdView.this.U.equals("url"))) {
              a.l.d.b("native_overlay_click", AdColonyNativeAdView.this.E);
            }
            try
            {
              paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse(AdColonyNativeAdView.this.T));
              a.b().startActivity(paramAnonymousView);
              AdColonyNativeAdView.this.R.setBackgroundColor(AdColonyNativeAdView.this.al);
              return true;
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                Toast.makeText(a.b(), "Unable to open store.", 0).show();
              }
            }
          }
        });
      }
      this.H = new ADCImage(this.ac, true, false);
      if (1.0F / (this.H.f / this.ai) <= 1.0F / (this.H.g / this.aj)) {
        break label1098;
      }
      f1 = 1.0F / (this.H.g / this.aj);
      label614:
      this.H.a(f1, true);
      this.J = new ADCImage(this.ad, true, false);
      this.I = new ADCImage(this.ae, true, false);
      this.O = new ADCImage(this.af, true, false);
      this.O.a(1.0F / (float)(this.O.f / this.ai / (this.ai / 5.5D / this.ai)), true);
      this.I.a(this.as / 2.0F, true);
      this.J.a(this.as / 2.0F, true);
      if (Build.VERSION.SDK_INT >= 14) {
        this.M = new AdColonyNativeAdView.a(this, a.b(), this.r);
      }
      this.L = new AdColonyNativeAdView.b(this, a.b());
      this.P = new ImageView(a.b());
      this.K = new ImageView(a.b());
      this.P.setImageBitmap(this.O.a);
      if (!this.o) {
        break label1118;
      }
      this.K.setImageBitmap(this.I.a);
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.I.f, this.I.g, 48);
      localLayoutParams.setMargins(this.ai - this.I.f, 0, 0, 0);
      this.K.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (AdColonyNativeAdView.this.o)
          {
            if (AdColonyNativeAdView.this.G != null) {
              AdColonyNativeAdView.this.G.onAdColonyNativeAdMuted(AdColonyNativeAdView.this, true);
            }
            AdColonyNativeAdView.this.setMuted(true);
            AdColonyNativeAdView.this.u = true;
          }
          while (AdColonyNativeAdView.this.N != AdColonyNativeAdView.this.J.a) {
            return;
          }
          if (AdColonyNativeAdView.this.G != null) {
            AdColonyNativeAdView.this.G.onAdColonyNativeAdMuted(AdColonyNativeAdView.this, false);
          }
          AdColonyNativeAdView.this.u = false;
          AdColonyNativeAdView.this.setMuted(false);
        }
      });
      this.N = this.I.a;
      if (this.r) {
        this.K.setVisibility(8);
      }
      if (this.s) {
        this.K.setVisibility(4);
      }
      if (Build.VERSION.SDK_INT >= 14) {
        addView(this.M, new FrameLayout.LayoutParams(this.ai, this.aj));
      }
      if (Build.VERSION.SDK_INT < 14) {
        this.r = true;
      }
      addView(this.L, new FrameLayout.LayoutParams(this.ai, this.aj));
      if ((this.v) && (Build.VERSION.SDK_INT >= 14) && (this.A)) {
        addView(this.K, localLayoutParams);
      }
      if (!this.Q) {
        break;
      }
      localLayoutParams = new FrameLayout.LayoutParams(this.ai, this.aj / 5, 80);
      addView(this.R, localLayoutParams);
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        break label375;
      }
      return;
      label1098:
      f1 = 1.0F / (this.H.f / this.ai);
      break label614;
      label1118:
      this.K.setImageBitmap(this.J.a);
    }
  }
  
  boolean a(boolean paramBoolean)
  {
    return (this.E.a(true)) && (AdColony.isZoneNative(this.e));
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 351	com/jirbo/adcolony/AdColonyNativeAdView:r	Z
    //   6: ifne +20 -> 26
    //   9: aload_0
    //   10: getfield 486	com/jirbo/adcolony/AdColonyNativeAdView:V	Landroid/media/MediaPlayer;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 486	com/jirbo/adcolony/AdColonyNativeAdView:V	Landroid/media/MediaPlayer;
    //   20: invokevirtual 492	android/media/MediaPlayer:isPlaying	()Z
    //   23: ifne +12 -> 35
    //   26: aload_0
    //   27: getfield 486	com/jirbo/adcolony/AdColonyNativeAdView:V	Landroid/media/MediaPlayer;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +6 -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 133	com/jirbo/adcolony/AdColonyNativeAdView:ar	F
    //   43: invokevirtual 495	com/jirbo/adcolony/AdColonyNativeAdView:setVolume	(F)V
    //   46: aload_0
    //   47: getfield 486	com/jirbo/adcolony/AdColonyNativeAdView:V	Landroid/media/MediaPlayer;
    //   50: invokevirtual 498	android/media/MediaPlayer:start	()V
    //   53: getstatic 227	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   56: aload_0
    //   57: getfield 218	com/jirbo/adcolony/AdColonyNativeAdView:E	Lcom/jirbo/adcolony/AdColonyInterstitialAd;
    //   60: invokevirtual 501	com/jirbo/adcolony/d:a	(Lcom/jirbo/adcolony/AdColonyAd;)V
    //   63: aload_0
    //   64: getfield 218	com/jirbo/adcolony/AdColonyNativeAdView:E	Lcom/jirbo/adcolony/AdColonyInterstitialAd;
    //   67: iconst_1
    //   68: putfield 502	com/jirbo/adcolony/AdColonyInterstitialAd:p	Z
    //   71: aload_0
    //   72: getfield 504	com/jirbo/adcolony/AdColonyNativeAdView:F	Lcom/jirbo/adcolony/AdColonyNativeAdListener;
    //   75: ifnull -40 -> 35
    //   78: aload_0
    //   79: getfield 504	com/jirbo/adcolony/AdColonyNativeAdView:F	Lcom/jirbo/adcolony/AdColonyNativeAdListener;
    //   82: iconst_0
    //   83: aload_0
    //   84: invokeinterface 510 3 0
    //   89: goto -54 -> 35
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	AdColonyNativeAdView
    //   30	2	1	localMediaPlayer	MediaPlayer
    //   92	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	92	finally
    //   26	31	92	finally
    //   38	89	92	finally
  }
  
  void b(boolean paramBoolean)
  {
    if ((this.V != null) && (this.K != null))
    {
      if (paramBoolean)
      {
        this.V.setVolume(0.0F, 0.0F);
        this.K.setImageBitmap(this.J.a);
        this.N = this.J.a;
      }
    }
    else {
      return;
    }
    this.V.setVolume(this.ar, this.ar);
    this.K.setImageBitmap(this.I.a);
    this.N = this.I.a;
  }
  
  void c()
  {
    if ((!this.r) && (this.V != null) && (this.V.isPlaying()) && (!this.s))
    {
      a.l.d.b("video_paused", this.E);
      this.V.pause();
    }
  }
  
  public void destroy()
  {
    l.c.b("[ADC] Native Ad Destroy called.");
    if (this.W != null) {
      this.W.release();
    }
    if (this.V != null) {
      this.V.release();
    }
    this.V = null;
    a.ac.remove(this);
  }
  
  public ImageView getAdvertiserImage()
  {
    if (this.O == null)
    {
      this.O = new ADCImage(this.af, true, false);
      this.O.a(this.as / 2.0F, true);
    }
    if (this.P == null)
    {
      this.P = new ImageView(a.b());
      this.P.setImageBitmap(this.O.a);
    }
    return this.P;
  }
  
  public String getAdvertiserName()
  {
    return this.Z;
  }
  
  public String getDescription()
  {
    return this.aa;
  }
  
  public int getNativeAdHeight()
  {
    if (this.Q) {
      return this.aj + this.aj / 5;
    }
    return this.aj;
  }
  
  public int getNativeAdWidth()
  {
    return this.ai;
  }
  
  public String getTitle()
  {
    return this.ab;
  }
  
  public boolean isReady()
  {
    return (this.E.a(true)) && (this.p) && (!this.C);
  }
  
  public void notifyAddedToListView()
  {
    if (!this.k)
    {
      this.k = true;
      return;
    }
    ((AdColonyNativeAdView.a)this.M).onSurfaceTextureAvailable(this.h, this.i, this.j);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.L.setVisibility(0);
    this.K.setVisibility(8);
    this.E.j = "native";
    this.E.k = "native";
    this.E.p = true;
    this.r = true;
    this.V.release();
    this.V = null;
    this.E.o = 0;
    paramMediaPlayer = new ADCData.g();
    paramMediaPlayer.b("ad_slot", this.E.h.k.d);
    paramMediaPlayer.b("replay", false);
    a.l.d.a("native_complete", paramMediaPlayer, this.E);
    if (this.F != null) {
      this.F.onAdColonyNativeAdFinished(false, this);
    }
    this.z = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.g == null) {}
    for (;;)
    {
      return;
      Rect localRect = new Rect();
      if (!this.g.hasFocus()) {
        this.g.requestFocus();
      }
      if ((!this.r) && (this.V != null)) {
        this.ak = this.V.getCurrentPosition();
      }
      if (this.ak != 0) {
        this.E.o = this.ak;
      }
      boolean bool = getLocalVisibleRect(localRect);
      if (((!bool) && (!this.l)) || ((this.l) && ((!bool) || ((localRect.bottom - localRect.top < getNativeAdHeight()) && (localRect.top != 0))))) {
        if ((!this.r) && (this.V != null) && (this.V.isPlaying()) && (!this.s))
        {
          l.c.b("[ADC] Scroll Pause");
          a.l.d.b("video_paused", this.E);
          this.V.pause();
          this.L.setVisibility(0);
        }
      }
      while ((!this.x) && (!this.r))
      {
        invalidate();
        return;
        if ((!this.r) && (this.V != null) && (this.V.isPlaying()))
        {
          if (!this.w)
          {
            paramCanvas.drawARGB(255, 0, 0, 0);
          }
          else
          {
            this.E.j = "native";
            this.E.k = "native";
            a.l.a(this.V.getCurrentPosition() / this.V.getDuration(), this.E);
          }
        }
        else if (!this.L.a) {
          paramCanvas.drawARGB(255, 0, 0, 0);
        }
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.L.setVisibility(0);
    this.K.setVisibility(8);
    this.r = true;
    this.w = true;
    this.V = null;
    this.E.o = 0;
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    l.c.b("[ADC] Native Ad onPrepared called.");
    this.w = true;
    if ((!this.o) && (this.N.equals(this.I.a)))
    {
      b(true);
      return;
    }
    setVolume(this.ar);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 1) && (a.v) && (q.c()))
    {
      a.H = this.E;
      a.l.a.a(this.e, this.E.i);
      ADCVideo.a();
      this.E.r = this.z;
      this.E.q = true;
      this.E.j = "native";
      this.E.k = "fullscreen";
      a.v = false;
      a.l.d.b("video_expanded", this.E);
      if (this.F != null) {
        this.F.onAdColonyNativeAdStarted(true, this);
      }
      if (!a.m) {
        break label304;
      }
      l.a.b("Launching AdColonyOverlay");
      a.b().startActivity(new Intent(a.b(), AdColonyOverlay.class));
    }
    for (;;)
    {
      if (this.r)
      {
        paramMotionEvent = this.E.h.k;
        paramMotionEvent.d += 1;
        a.l.a("start", "{\"ad_slot\":" + this.E.h.k.d + ", \"replay\":" + this.E.r + "}", this.E);
        a.l.h.a(this.E.g, this.E.i.d);
      }
      this.r = true;
      this.z = true;
      return true;
      label304:
      l.a.b("Launching AdColonyFullscreen");
      a.b().startActivity(new Intent(a.b(), AdColonyFullscreen.class));
    }
  }
  
  public void pause()
  {
    l.c.b("[ADC] Native Ad Pause called.");
    if ((this.V != null) && (!this.r) && (this.V.isPlaying()) && (Build.VERSION.SDK_INT >= 14))
    {
      a.l.d.b("video_paused", this.E);
      this.s = true;
      this.V.pause();
      this.L.setVisibility(0);
      this.K.setVisibility(4);
    }
  }
  
  public void prepareForListView()
  {
    this.l = true;
  }
  
  public void resume()
  {
    l.c.b("[ADC] Native Ad Resume called.");
    if ((this.V != null) && (this.s) && (!this.r) && (Build.VERSION.SDK_INT >= 14))
    {
      a.l.d.b("video_resumed", this.E);
      this.s = false;
      this.V.seekTo(this.E.o);
      this.V.start();
      this.L.setVisibility(4);
      this.K.setVisibility(0);
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.K.setImageBitmap(this.J.a);
      this.o = false;
      setVolume(0.0F);
      this.N = this.J.a;
    }
    while ((this.u) || (this.N != this.J.a)) {
      return;
    }
    this.K.setImageBitmap(this.I.a);
    this.o = true;
    if (this.V != null)
    {
      if (this.ar == 0.0D) {
        break label117;
      }
      setVolume(this.ar);
    }
    for (;;)
    {
      this.N = this.I.a;
      return;
      label117:
      setVolume(0.25F);
    }
  }
  
  public void setOverlayButtonColor(int paramInt)
  {
    if (this.Q) {
      this.R.setBackgroundColor(paramInt);
    }
    this.al = paramInt;
  }
  
  public void setOverlayButtonTextColor(int paramInt)
  {
    if (this.Q) {
      this.R.setTextColor(paramInt);
    }
    this.am = paramInt;
  }
  
  public void setOverlayButtonTypeface(Typeface paramTypeface, int paramInt)
  {
    if (this.Q) {
      this.R.setTypeface(paramTypeface, paramInt);
    }
  }
  
  public void setVolume(float paramFloat)
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      do
      {
        do
        {
          return;
          this.ar = paramFloat;
          if ((this.V == null) || (paramFloat < 0.0D) || (paramFloat > 1.0D)) {
            break;
          }
          if (!this.u) {
            this.V.setVolume(paramFloat, paramFloat);
          }
        } while (!this.w);
        if ((this.N == this.J.a) && (paramFloat > 0.0D) && (!this.u))
        {
          this.K.setImageBitmap(this.I.a);
          this.N = this.I.a;
          a.l.d.b("sound_unmute", this.E);
          this.o = true;
          return;
        }
      } while ((this.N != this.I.a) || (paramFloat != 0.0D));
      this.K.setImageBitmap(this.J.a);
      this.N = this.J.a;
      a.l.d.b("sound_mute", this.E);
      this.o = false;
      return;
    } while ((paramFloat < 0.0D) || (paramFloat > 1.0D));
    this.aq = paramFloat;
  }
  
  public AdColonyNativeAdView withListener(AdColonyNativeAdListener paramAdColonyNativeAdListener)
  {
    this.F = paramAdColonyNativeAdListener;
    this.E.t = paramAdColonyNativeAdListener;
    return this;
  }
  
  public AdColonyNativeAdView withMutedListener(AdColonyNativeAdMutedListener paramAdColonyNativeAdMutedListener)
  {
    this.G = paramAdColonyNativeAdMutedListener;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyNativeAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */