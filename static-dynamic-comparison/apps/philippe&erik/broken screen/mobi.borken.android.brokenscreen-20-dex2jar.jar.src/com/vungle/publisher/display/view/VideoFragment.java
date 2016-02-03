package com.vungle.publisher.display.view;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.vungle.publisher.ab;
import com.vungle.publisher.ac;
import com.vungle.publisher.ad;
import com.vungle.publisher.ae;
import com.vungle.publisher.af;
import com.vungle.publisher.audio.VolumeChangeContentObserver;
import com.vungle.publisher.audio.VolumeChangeContentObserver.Factory;
import com.vungle.publisher.ax;
import com.vungle.publisher.ay;
import com.vungle.publisher.b;
import com.vungle.publisher.db.model.AdReportEvent.a;
import com.vungle.publisher.db.model.EventTracking.a;
import com.vungle.publisher.db.model.Video;
import com.vungle.publisher.di;
import com.vungle.publisher.i;
import com.vungle.publisher.image.BitmapFactory;
import com.vungle.publisher.k;
import com.vungle.publisher.l;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.m;
import com.vungle.publisher.q;
import com.vungle.publisher.reporting.AdReportingHandler;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class VideoFragment
  extends AdFragment
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final l<?> A = new b();
  private final Handler B = new c();
  private Timer C;
  private String D;
  private int E;
  private boolean F;
  private boolean G;
  private int H;
  private boolean I;
  private int J;
  private VolumeChangeContentObserver K;
  private AlertDialog L;
  public ay a;
  public AdReportingHandler b;
  public a c;
  public Video d;
  ImageView e;
  i f;
  i g;
  TouchDelegate h;
  final AtomicBoolean i = new AtomicBoolean();
  i j;
  @Inject
  AlertDialogFactory k;
  @Inject
  AudioManager l;
  @Inject
  BitmapFactory m;
  @Inject
  CountdownProgressView.Factory n;
  @Inject
  DisplayUtils o;
  @Inject
  di p;
  @Inject
  VolumeChangeContentObserver.Factory q;
  private ImageView r;
  private CountdownProgressView s;
  private ImageView t;
  private RelativeLayout u;
  private VideoView v;
  private Bitmap w;
  private Bitmap x;
  private Bitmap y;
  private Bitmap z;
  
  private Bitmap a(String paramString)
  {
    try
    {
      Bitmap localBitmap = this.m.getBitmap(paramString);
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      Logger.w("VungleAd", "error loading " + paramString);
    }
    return null;
  }
  
  private static i a(View paramView)
  {
    i locali = new i();
    locali.a("backgroundColor");
    if (locali.b != paramView)
    {
      Object localObject = locali.b;
      locali.b = paramView;
      if ((localObject == null) || (localObject.getClass() != paramView.getClass())) {
        locali.g = false;
      }
    }
    return locali;
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2)
  {
    float f2 = q.a(paramView);
    paramInt1 *= 1000;
    float f1 = 0.0F;
    int i1 = paramInt1 - 750;
    if (paramInt2 > i1) {
      if (paramInt2 < paramInt1) {
        break label47;
      }
    }
    label47:
    for (f1 = 1.0F;; f1 = (paramInt2 - i1) / (paramInt1 - i1))
    {
      if (f1 != f2) {
        q.a(paramView, f1);
      }
      return;
    }
  }
  
  private void a(i parami, int paramInt)
  {
    a(parami, 1140850688, 0, paramInt, 0.0F);
  }
  
  private void a(i parami, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Logger.v("VungleAd", "animateBar startColor: " + paramInt1 + ", endColor: " + paramInt2 + ", durationMillis: " + paramInt3 + ", startPercent: " + paramFloat);
    parami.a(paramInt3);
    parami.a(new int[] { paramInt1, paramInt2 });
    parami.c(Math.round(paramInt3 * paramFloat));
    l locall = this.A;
    if ((locall != null) && (parami.i != null) && (parami.i.length > 0))
    {
      k localk = parami.i[0];
      localk.j = locall;
      localk.e.f = locall;
    }
    parami.a();
  }
  
  private void f(boolean paramBoolean)
  {
    g(paramBoolean);
    c();
  }
  
  private void g()
  {
    Timer localTimer = this.C;
    if (localTimer != null)
    {
      localTimer.cancel();
      localTimer.purge();
      this.C = null;
    }
    this.B.removeCallbacksAndMessages(null);
  }
  
  private void g(boolean paramBoolean)
  {
    AudioManager localAudioManager = this.l;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAudioManager.setStreamMute(3, paramBoolean);
      return;
    }
  }
  
  private void h()
  {
    int i2 = 1;
    int i1;
    if (!this.I)
    {
      i1 = 1;
      this.I = true;
      if ((this.L == null) || (!this.L.isShowing())) {
        break label43;
      }
      label33:
      if (i2 == 0) {
        break label48;
      }
    }
    label43:
    label48:
    do
    {
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label33;
      c(this.v.getCurrentPosition());
      this.v.requestFocus();
      this.v.start();
      b(2000);
      if (this.C == null)
      {
        Timer localTimer = new Timer();
        this.C = localTimer;
        localTimer.schedule(new d(), 0L, 50L);
      }
    } while (i1 == 0);
    this.p.b(new af());
  }
  
  private void h(boolean paramBoolean)
  {
    Object localObject2;
    if ((paramBoolean) && (this.D != null))
    {
      paramBoolean = true;
      localObject2 = new StringBuilder("cta button ");
      if (!paramBoolean) {
        break label75;
      }
      localObject1 = "enabled";
      label32:
      Logger.v("VungleAd", (String)localObject1);
      this.F = paramBoolean;
      localObject2 = this.e;
      if (!paramBoolean) {
        break label82;
      }
    }
    label75:
    label82:
    for (Object localObject1 = this.w;; localObject1 = this.x)
    {
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
      return;
      paramBoolean = false;
      break;
      localObject1 = "disabled";
      break label32;
    }
  }
  
  private void i(boolean paramBoolean)
  {
    if (paramBoolean != this.F) {
      h(paramBoolean);
    }
  }
  
  final float a(float paramFloat)
  {
    int i1 = d();
    if (i1 == 0) {
      return -1.0F;
    }
    return paramFloat / i1;
  }
  
  public final void a()
  {
    if ((f()) || (this.a.isBackButtonImmediatelyEnabled())) {
      this.c.a();
    }
  }
  
  final void a(i parami, float paramFloat)
  {
    a(parami, 0, 1140850688, 749, paramFloat);
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      h();
      return;
    }
    this.v.pause();
    g();
  }
  
  public final boolean a(int paramInt)
  {
    if (paramInt == 24)
    {
      if (e() != 0) {
        break label36;
      }
      Logger.d("VungleAd", "volume up - pending unmute");
      d(true);
      this.i.set(true);
    }
    for (;;)
    {
      return false;
      label36:
      Logger.v("VungleAd", "volume up");
    }
  }
  
  final void b(int paramInt)
  {
    a(this.f, paramInt);
    a(this.j, paramInt);
  }
  
  final void b(boolean paramBoolean)
  {
    this.I = false;
    this.J = 0;
    g();
    int i1 = c(paramBoolean);
    di localdi = this.p;
    if (paramBoolean) {}
    for (Object localObject = new ab(i1);; localObject = new ad(i1))
    {
      localdi.b(localObject);
      return;
    }
  }
  
  final boolean b()
  {
    return (this.G) && (e() > 0);
  }
  
  final int c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    int i2;
    for (int i1 = this.v.getDuration();; i1 = this.v.getCurrentPosition())
    {
      i2 = this.J;
      if (i1 <= i2) {
        break;
      }
      this.J = i1;
      return i1;
    }
    if (i1 < i2) {
      Logger.w("VungleAd", "watched millis decreased from " + i2 + " --> " + i1);
    }
    return i2;
  }
  
  final void c()
  {
    ImageView localImageView = this.t;
    if (b()) {}
    for (Bitmap localBitmap = this.z;; localBitmap = this.y)
    {
      localImageView.setImageBitmap(localBitmap);
      return;
    }
  }
  
  final void c(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (Boolean.TRUE.equals(this.d.l))
    {
      if (!Boolean.TRUE.equals(this.d.p)) {
        break label125;
      }
      if (q.a(this.e) >= 1.0F) {
        i(bool1);
      }
    }
    else
    {
      if (!this.a.isIncentivized()) {
        break label164;
      }
    }
    label125:
    label164:
    for (Integer localInteger = this.d.r;; localInteger = this.d.s)
    {
      if (localInteger != null) {
        a(this.r, localInteger.intValue(), paramInt);
      }
      localInteger = this.d.t;
      if (localInteger != null) {
        a(this.s, localInteger.intValue(), paramInt);
      }
      return;
      bool1 = false;
      break;
      a(this.e, this.H, paramInt);
      if (paramInt >= this.E * 1000) {}
      for (bool1 = bool2;; bool1 = false)
      {
        i(bool1);
        break;
      }
    }
  }
  
  final int d()
  {
    return this.l.getStreamMaxVolume(3);
  }
  
  final void d(boolean paramBoolean)
  {
    this.G = paramBoolean;
    f(paramBoolean);
  }
  
  final int e()
  {
    return this.l.getStreamVolume(3);
  }
  
  final void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAdReportingHandler = this.b;
      localAdReportingHandler.a(AdReportEvent.a.i, null);
      localAdReportingHandler.a(EventTracking.a.k);
      return;
    }
    AdReportingHandler localAdReportingHandler = this.b;
    localAdReportingHandler.a(AdReportEvent.a.f, null);
    localAdReportingHandler.a(EventTracking.a.b);
  }
  
  final boolean f()
  {
    return q.a(this.r) == 1.0F;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Logger.d("VungleAd", "video.onCompletion");
    b(true);
    this.c.c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.q;
    e locale = new e();
    this.K = new VolumeChangeContentObserver(paramBundle.a, locale);
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = getActivity().getApplicationContext();
    VideoView localVideoView = new VideoView(paramBundle);
    this.v = localVideoView;
    ax localax = new ax(paramBundle);
    this.r = localax;
    paramViewGroup = new CountdownProgressView(paramBundle, this.n.a);
    this.s = paramViewGroup;
    ImageView localImageView = new ImageView(paramBundle);
    this.t = localImageView;
    RelativeLayout localRelativeLayout = new RelativeLayout(paramBundle);
    localRelativeLayout.addView(localVideoView);
    paramLayoutInflater = (RelativeLayout.LayoutParams)localVideoView.getLayoutParams();
    paramLayoutInflater.height = -1;
    paramLayoutInflater.width = -1;
    paramLayoutInflater.addRule(13);
    paramLayoutInflater = new RelativeLayout(paramBundle);
    this.u = paramLayoutInflater;
    localRelativeLayout.addView(paramLayoutInflater);
    Object localObject = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    paramLayoutInflater.addView(localax);
    localObject = (RelativeLayout.LayoutParams)localax.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    q.a(localax, 0.0F);
    paramBundle = new RelativeLayout(paramBundle);
    localRelativeLayout.addView(paramBundle);
    localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramBundle.addView(paramViewGroup);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    q.a(paramViewGroup, 0.0F);
    paramBundle.addView(localImageView);
    paramViewGroup = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    paramViewGroup.addRule(11);
    paramViewGroup.addRule(15);
    int i1 = Math.round(this.o.a(2));
    int i2 = Math.round(this.o.a(1));
    paramLayoutInflater.setPadding(i1, i2, i1, i2);
    paramBundle.setPadding(i1, i2, i1, i2);
    this.y = a("vg_mute_on.png");
    this.z = a("vg_mute_off.png");
    this.r.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramViewGroup = this.s;
    this.t.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramViewGroup = a("vg_close.png");
    if (paramViewGroup != null) {
      localax.setImageBitmap(paramViewGroup);
    }
    Logger.i("VungleAd", "video play URI = " + this.d.q());
    localVideoView.setVideoURI(this.d.q());
    this.f = a(paramBundle);
    this.j = a(paramLayoutInflater);
    if (Boolean.TRUE.equals(this.d.l))
    {
      this.w = a("vg_cta.png");
      this.x = a("vg_cta_disabled.png");
      paramLayoutInflater = this.d.j;
      paramBundle = this.d.q;
      if (paramLayoutInflater != null) {
        break label853;
      }
      paramViewGroup = paramBundle;
      localObject = paramLayoutInflater;
      if (paramBundle != null)
      {
        Logger.v("VungleAd", "overriding cta enabled from null to " + paramBundle);
        localObject = paramBundle;
        paramViewGroup = paramBundle;
      }
      Logger.d("VungleAd", "cta shown at " + paramViewGroup + " seconds; enabled at " + localObject + " seconds");
      if (localObject != null) {
        break label943;
      }
      i1 = 0;
      label606:
      this.E = i1;
      if (paramViewGroup != null) {
        break label953;
      }
      i1 = 0;
      label619:
      this.H = i1;
      paramLayoutInflater = new ax(getActivity());
      this.e = paramLayoutInflater;
      this.u.addView(paramLayoutInflater);
      paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.addRule(11);
      paramViewGroup.addRule(15);
      paramLayoutInflater.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramViewGroup = this.d.i;
      if ((paramViewGroup != null) && (paramViewGroup.floatValue() > 1.0F)) {
        break label962;
      }
      Logger.v("VungleAd", "cta clickable area not scaled");
    }
    for (;;)
    {
      if (!Boolean.TRUE.equals(this.d.p)) {
        break label980;
      }
      q.a(paramLayoutInflater, 0.0F);
      paramLayoutInflater.setImageBitmap(this.w);
      this.g = i.a(paramLayoutInflater, "alpha", new float[] { 0.0F, 1.0F });
      this.g.a(750L);
      paramLayoutInflater.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (VideoFragment.a(VideoFragment.this))
          {
            Logger.d("VungleAd", "cta overlay onClick");
            VideoFragment.this.b(false);
            VideoFragment.this.c.b();
            return;
          }
          Logger.v("VungleAd", "cta overlay onClick, but not enabled");
        }
      });
      localax.setOnClickListener(new b());
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (VideoFragment.this.b())
          {
            paramAnonymousView = "";
            Logger.d("VungleAd", paramAnonymousView + "mute clicked");
            paramAnonymousView = VideoFragment.this;
            if (paramAnonymousView.b()) {
              break label107;
            }
          }
          label107:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.d(bool);
            if ((bool) && (paramAnonymousView.e() == 0))
            {
              int i = (int)(0.4F * paramAnonymousView.d());
              paramAnonymousView.l.setStreamVolume(3, i, 0);
              paramAnonymousView.c();
            }
            paramAnonymousView.e(bool);
            return;
            paramAnonymousView = "un";
            break;
          }
        }
      });
      d(this.a.isSoundEnabled());
      localVideoView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          int j = 0;
          Logger.v("VungleAd", "video onTouch");
          if (VideoFragment.this.h != null) {
            VideoFragment.this.h.onTouchEvent(paramAnonymousMotionEvent);
          }
          VideoFragment localVideoFragment = VideoFragment.this;
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            paramAnonymousMotionEvent = localVideoFragment.j;
            int i;
            if (paramAnonymousMotionEvent.h == 749L)
            {
              i = 1;
              if (i == 0) {
                j = 1;
              }
              StringBuilder localStringBuilder1 = new StringBuilder("toggle bar animation");
              if (!paramAnonymousMotionEvent.f()) {
                break label239;
              }
              StringBuilder localStringBuilder2 = new StringBuilder(" - reversing ");
              if (j == 0) {
                break label233;
              }
              paramAnonymousView = "hide";
              label110:
              paramAnonymousView = paramAnonymousView + " animation";
              label125:
              Logger.v("VungleAd", paramAnonymousView);
              paramAnonymousMotionEvent.b();
              float f = 1.0F - paramAnonymousMotionEvent.e;
              if (j == 0) {
                break label245;
              }
              localVideoFragment.a(localVideoFragment.f, f);
              localVideoFragment.a(localVideoFragment.j, f);
            }
            for (;;)
            {
              if ((localVideoFragment.e != null) && (q.a(localVideoFragment.e) == 0.0F) && (localVideoFragment.g != null) && (!localVideoFragment.g.f())) {
                localVideoFragment.g.a();
              }
              return true;
              i = 0;
              break;
              label233:
              paramAnonymousView = "show";
              break label110;
              label239:
              paramAnonymousView = "";
              break label125;
              label245:
              localVideoFragment.b(750);
            }
          }
          return false;
        }
      });
      localVideoView.setOnCompletionListener(this);
      localVideoView.setOnErrorListener(this);
      localVideoView.setOnPreparedListener(this);
      return localRelativeLayout;
      label853:
      if (paramBundle == null)
      {
        Logger.v("VungleAd", "overriding cta shown from null to " + paramLayoutInflater);
        paramViewGroup = paramLayoutInflater;
        localObject = paramLayoutInflater;
        break;
      }
      paramViewGroup = paramBundle;
      localObject = paramLayoutInflater;
      if (paramBundle.intValue() <= paramLayoutInflater.intValue()) {
        break;
      }
      Logger.v("VungleAd", "overriding cta shown from " + paramBundle + " to " + paramLayoutInflater);
      paramViewGroup = paramLayoutInflater;
      localObject = paramLayoutInflater;
      break;
      label943:
      i1 = ((Integer)localObject).intValue();
      break label606;
      label953:
      i1 = paramViewGroup.intValue();
      break label619;
      label962:
      paramLayoutInflater.post(new Runnable()
      {
        public final void run()
        {
          float f = (float)Math.sqrt(paramViewGroup.floatValue());
          int i = paramLayoutInflater.getHeight();
          int j = paramLayoutInflater.getWidth();
          int k = Math.round(i * f);
          int m = Math.round(f * j);
          Logger.v("VungleAd", "scaling cta clickable area " + paramViewGroup + "x - width: " + j + " --> " + m + ", height: " + i + " --> " + k);
          Rect localRect = new Rect();
          paramLayoutInflater.getHitRect(localRect);
          localRect.bottom = (localRect.top + k);
          localRect.left = (localRect.right - m);
          VideoFragment.this.h = new TouchDelegate(localRect, paramLayoutInflater);
        }
      });
    }
    label980:
    if (this.H >= this.E) {}
    for (boolean bool = true;; bool = false)
    {
      h(bool);
      break;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Logger.e("VungleAd", "video.onError: " + paramInt1 + ", " + paramInt2);
    b(false);
    this.c.c();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    Logger.d("VungleAd", "video onPause");
    try
    {
      getActivity().getContentResolver().unregisterContentObserver(this.K);
      g(true);
      if (this.I) {
        this.p.b(new ae(this.v.getCurrentPosition()));
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.e("VungleAd", localException);
      g();
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i1 = paramMediaPlayer.getDuration();
    Logger.d("VungleAd", "video ready: duration " + i1 + " ms");
    this.s.setMax(Math.round(i1 / 1000.0F));
    this.p.b(new ac(i1));
  }
  
  public void onResume()
  {
    try
    {
      super.onResume();
      Logger.d("VungleAd", "video onResume");
      h();
      f(this.G);
      AdReportingHandler localAdReportingHandler = this.b;
      float f1 = a(e());
      localAdReportingHandler.a(AdReportEvent.a.k, Float.valueOf(f1));
      getActivity().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.K);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("VungleAd", localException);
      g();
    }
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    public Provider<VideoFragment> a;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
  
  final class b
    implements View.OnClickListener
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      Logger.v("VungleAd", "close clicked");
      if (VideoFragment.this.f())
      {
        Logger.d("VungleAd", "exiting video");
        if (VideoFragment.this.a.isIncentivized())
        {
          VideoFragment.b(VideoFragment.this).pause();
          VideoFragment.a(VideoFragment.this, VideoFragment.c(VideoFragment.this)).show();
        }
      }
      else
      {
        return;
      }
      VideoFragment.d(VideoFragment.this);
    }
  }
  
  final class c
    extends Handler
  {
    c() {}
    
    public final void handleMessage(Message paramMessage)
    {
      try
      {
        int i = VideoFragment.this.c(false);
        VideoFragment.this.c(i);
        VideoFragment.e(VideoFragment.this).setProgress(i / 1000);
        VideoFragment.this.p.b(new ae(i));
        return;
      }
      catch (Exception paramMessage)
      {
        Logger.w("VungleAd", paramMessage);
      }
    }
  }
  
  final class d
    extends TimerTask
  {
    d() {}
    
    public final void run()
    {
      VideoFragment.f(VideoFragment.this).sendEmptyMessage(0);
    }
  }
  
  final class e
    extends Handler
  {
    e() {}
    
    public final void handleMessage(Message paramMessage)
    {
      i = 1;
      try
      {
        localObject = VideoFragment.this;
        j = paramMessage.arg1;
        k = paramMessage.arg2;
        if (k != 0) {
          break label216;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          int k;
          boolean bool;
          StringBuilder localStringBuilder;
          String str1;
          float f;
          Object localObject = new StringBuilder("error handling volume change: ");
          if (paramMessage == null) {}
          for (paramMessage = "null message";; paramMessage = paramMessage.arg1 + " --> " + paramMessage.arg2)
          {
            Logger.w("VungleAd", paramMessage, localException);
            return;
          }
          i = 0;
          continue;
          String str2 = "";
        }
      }
      bool = ((VideoFragment)localObject).i.compareAndSet(true, false);
      if ((i != 0) || (bool))
      {
        localStringBuilder = new StringBuilder("volume change ");
        if (bool)
        {
          str1 = "un";
          Logger.d("VungleAd", str1 + "mute");
          ((VideoFragment)localObject).c();
          ((VideoFragment)localObject).e(bool);
        }
      }
      else
      {
        f = ((VideoFragment)localObject).a(k);
        if (k < j)
        {
          ((VideoFragment)localObject).b.a(AdReportEvent.a.l, Float.valueOf(f));
          return;
        }
        ((VideoFragment)localObject).b.a(AdReportEvent.a.m, Float.valueOf(f));
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/VideoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */