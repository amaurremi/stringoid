package com.skplanet.tad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebSettings.RenderPriority;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.skplanet.tad.AdListener;
import com.skplanet.tad.AdListener.ErrorCode;
import com.skplanet.tad.AdView.AnimationType;
import com.skplanet.tad.common.f;
import com.skplanet.tad.controller.d.a;
import com.skplanet.tad.v2.content.a.a;
import com.skplanet.tad.v2.controller.b;
import com.skplanet.tad.v2.controller.c;
import com.skplanet.tad.v2.view.BannerView;
import com.skplanet.tad.v2.view.ImageBannerView;
import com.skplanet.tad.v2.view.TextBannerView;
import java.util.Timer;
import java.util.TimerTask;

public class AdViewV2
  extends RelativeLayout
{
  private View A = null;
  private float B;
  private boolean C = false;
  private boolean D = false;
  private a E = a.a;
  private final Handler F = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.skplanet.tad.common.a.c("in AdViewV2.handleMessage() msg : " + paramAnonymousMessage.what);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        AdViewV2.a(AdViewV2.this);
        AdViewV2.a(AdViewV2.this, Long.valueOf(0L));
        com.skplanet.tad.common.a.a("AdListener.onAdWillReceive() will be called.");
        if (AdViewV2.b(AdViewV2.this) != null) {
          AdViewV2.b(AdViewV2.this).onAdWillReceive();
        }
        com.skplanet.tad.common.a.a("AdDownloaderV2 is executed.");
        new b(AdViewV2.this.getContext(), AdViewV2.this.a, false, AdViewV2.c(AdViewV2.this)).execute(new String[] { AdViewV2.d(AdViewV2.this), AdViewV2.e(AdViewV2.this), AdViewV2.f(AdViewV2.this), AdViewV2.g(AdViewV2.this), AdViewV2.h(AdViewV2.this) });
        return;
      }
      AdViewV2.this.a((View)paramAnonymousMessage.obj);
    }
  };
  private Animation.AnimationListener G = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      com.skplanet.tad.common.a.c("AdViewV2.onAnimationEnd() is called.");
      if (paramAnonymousAnimation == AdViewV2.i(AdViewV2.this))
      {
        AdViewV2.j(AdViewV2.this).removeAllViews();
        AdViewV2.this.removeView(AdViewV2.j(AdViewV2.this));
      }
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation)
    {
      com.skplanet.tad.common.a.c("AdViewV2.onAnimationRepeat() is called.");
    }
    
    public final void onAnimationStart(Animation paramAnonymousAnimation)
    {
      com.skplanet.tad.common.a.c("AdViewV2.onAnimationStart() is called.");
    }
  };
  public com.skplanet.tad.controller.d a = new com.skplanet.tad.controller.d()
  {
    public void a(d.a paramAnonymousa)
    {
      com.skplanet.tad.common.a.a("Ad is not received.");
      com.skplanet.tad.common.a.c("AdViewV2.onFailed, errorCode:" + paramAnonymousa);
      if (paramAnonymousa == d.a.e)
      {
        AdViewV2.a(AdViewV2.this);
        if (AdViewV2.l(AdViewV2.this))
        {
          com.skplanet.tad.common.a.c("AdViewV2.onFailed, before: " + AdViewV2.m(AdViewV2.this) + "=> NORMAL");
          AdViewV2.a(AdViewV2.this, AdViewV2.a.a);
          AdViewV2.a(AdViewV2.this, AdViewV2.n(AdViewV2.this) * 1000L);
        }
        if (AdViewV2.o(AdViewV2.this) != null)
        {
          if (AdViewV2.p(AdViewV2.this) != null) {
            AdViewV2.p(AdViewV2.this).setVisibility(8);
          }
          AdViewV2.this.removeView(AdViewV2.o(AdViewV2.this));
        }
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(NO_AD) will be called.");
        if (AdViewV2.b(AdViewV2.this) != null) {
          AdViewV2.b(AdViewV2.this).onAdFailed(AdListener.ErrorCode.NO_AD);
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            if (paramAnonymousa != d.a.c) {
              break;
            }
            com.skplanet.tad.common.a.a("AdListener.onAdFailed(CLIENTID_DENIED_ERROR will be called.");
          } while (AdViewV2.b(AdViewV2.this) == null);
          AdViewV2.b(AdViewV2.this).onAdFailed(AdListener.ErrorCode.CLIENTID_DENIED_ERROR);
          return;
        } while (paramAnonymousa != d.a.d);
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(CONNECTION_ERROR will be called.");
      } while (AdViewV2.b(AdViewV2.this) == null);
      AdViewV2.b(AdViewV2.this).onAdFailed(AdListener.ErrorCode.CONNECTION_ERROR);
    }
    
    public void a(Object paramAnonymousObject)
    {
      paramAnonymousObject = (com.skplanet.tad.v2.content.a)paramAnonymousObject;
      AdViewV2.a(AdViewV2.this, (com.skplanet.tad.v2.content.a)paramAnonymousObject);
      com.skplanet.tad.common.a.a("AdListener.onAdReceived() will be called.");
      if (AdViewV2.b(AdViewV2.this) != null) {
        AdViewV2.b(AdViewV2.this).onAdReceived();
      }
      if (AdViewV2.k(AdViewV2.this) != null)
      {
        AdViewV2.a(AdViewV2.this, AdViewV2.k(AdViewV2.this).b());
        AdViewV2.b(AdViewV2.this, AdViewV2.k(AdViewV2.this).c());
        AdViewV2.c(AdViewV2.this, AdViewV2.k(AdViewV2.this).d());
        AdViewV2.d(AdViewV2.this, AdViewV2.k(AdViewV2.this).e());
        com.skplanet.tad.common.a.a("AdListener.onAdWillLoad() will be called.");
        if (AdViewV2.b(AdViewV2.this) != null) {
          AdViewV2.b(AdViewV2.this).onAdWillLoad();
        }
        com.skplanet.tad.common.a.c("banner type : " + AdViewV2.k(AdViewV2.this).n());
        com.skplanet.tad.common.a.c("resource count : " + AdViewV2.k(AdViewV2.this).i().length);
        com.skplanet.tad.common.a.c("landing type : " + AdViewV2.k(AdViewV2.this).r());
        com.skplanet.tad.common.a.c("landing uri : " + AdViewV2.k(AdViewV2.this).s());
        paramAnonymousObject = AdViewV2.k(AdViewV2.this).n();
        if (paramAnonymousObject != a.a.a) {
          break label312;
        }
        new com.skplanet.tad.v2.controller.d(AdViewV2.this.b).execute(new String[][] { AdViewV2.k(AdViewV2.this).i() });
      }
      label312:
      while (paramAnonymousObject != a.a.b) {
        return;
      }
      new com.skplanet.tad.v2.controller.d(AdViewV2.this.b).execute(new String[][] { { AdViewV2.k(AdViewV2.this).m() } });
    }
  };
  public com.skplanet.tad.controller.d b = new com.skplanet.tad.controller.d()
  {
    public void a(d.a paramAnonymousa)
    {
      com.skplanet.tad.common.a.a("Ad is not loaded.");
      com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
      if (AdViewV2.b(AdViewV2.this) != null) {
        AdViewV2.b(AdViewV2.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
      }
    }
    
    public void a(Object paramAnonymousObject)
    {
      com.skplanet.tad.common.a.a("Ad is loaded.");
      if (AdViewV2.k(AdViewV2.this) == null)
      {
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
        if (AdViewV2.b(AdViewV2.this) != null) {
          AdViewV2.b(AdViewV2.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
        }
        return;
      }
      a.a locala = AdViewV2.k(AdViewV2.this).n();
      if ((locala == a.a.a) || (locala == a.a.b)) {
        AdViewV2.k(AdViewV2.this).a((Bitmap[])paramAnonymousObject);
      }
      com.skplanet.tad.common.a.a("AdListener.onAdLoaded() will be called.");
      if (AdViewV2.b(AdViewV2.this) != null) {
        AdViewV2.b(AdViewV2.this).onAdLoaded();
      }
      AdViewV2.a(AdViewV2.this, true);
      AdViewV2.q(AdViewV2.this);
    }
  };
  private BannerView c;
  private BannerView d;
  private com.skplanet.tad.v2.content.a e;
  private boolean f = false;
  private AdView.AnimationType g = AdView.AnimationType.NONE;
  private Animation h = null;
  private Animation i = null;
  private long j = 20L;
  private AdListener k = null;
  private String l = null;
  private String m;
  private String n;
  private String o;
  private String p;
  private boolean q = true;
  private boolean r;
  private WebSettings.RenderPriority s = WebSettings.RenderPriority.NORMAL;
  private int t = 5;
  private Timer u = null;
  private TimerTask v = null;
  private Long w = Long.valueOf(0L);
  private Long x = Long.valueOf(0L);
  private Long y = Long.valueOf(0L);
  private Long z = Long.valueOf(0L);
  
  public AdViewV2(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public AdViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdViewV2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
    if (paramAttributeSet != null)
    {
      setClientId(paramAttributeSet.getAttributeValue(null, "clientId"));
      setRefreshInterval(paramAttributeSet.getAttributeIntValue(null, "refreshInterval", 30));
    }
  }
  
  private void a(long paramLong)
  {
    if (paramLong < 0L) {}
    do
    {
      return;
      if (this.u == null) {
        this.u = new Timer();
      }
      if (this.v == null) {
        this.v = new TimerTask()
        {
          public void run()
          {
            com.skplanet.tad.common.a.a("refresh timer is timeout. so new ad will be downloaded.");
            if (AdViewV2.r(AdViewV2.this) != null) {
              AdViewV2.r(AdViewV2.this).sendEmptyMessage(1);
            }
          }
        };
      }
    } while ((this.u == null) || (this.v == null));
    com.skplanet.tad.common.a.c("#@ in startTimer() mTimer.schedule(mTimerTask, interval);");
    this.u.schedule(this.v, paramLong);
    this.w = Long.valueOf(paramLong);
    this.x = Long.valueOf(System.currentTimeMillis());
  }
  
  private void a(boolean paramBoolean)
  {
    com.skplanet.tad.common.a.a("AdViewV2.doDecisionWhenVisibleChanged state : " + this.E + ", remaining time :" + this.z + ", visible : " + paramBoolean);
    if (paramBoolean) {
      if (this.E == a.b)
      {
        this.E = a.a;
        if (this.z.longValue() <= 0L) {
          break label103;
        }
        h();
      }
    }
    for (;;)
    {
      com.skplanet.tad.common.a.a("AdViewV2.doDecisionWhenVisibleChanged changed state : " + this.E);
      return;
      label103:
      if (this.C)
      {
        j();
        continue;
        if (this.E == a.a)
        {
          this.E = a.b;
          g();
        }
      }
    }
  }
  
  private void e()
  {
    this.c = new BannerView(getContext());
    this.d = new BannerView(getContext());
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AdViewV2.this.a(paramAnonymousView);
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AdViewV2.this.a(paramAnonymousView);
      }
    });
    setAnimationType(AdView.AnimationType.NONE);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.B = localDisplayMetrics.density;
  }
  
  private void f()
  {
    if (this.u != null)
    {
      com.skplanet.tad.common.a.c("#@ in stopTimer(), mTimer.cancel()");
      this.u.cancel();
      this.u = null;
    }
    if (this.v != null)
    {
      this.v.cancel();
      this.v = null;
    }
  }
  
  private void g()
  {
    if (this.u != null)
    {
      this.y = Long.valueOf(System.currentTimeMillis() - this.x.longValue());
      if (this.y.longValue() < this.w.longValue())
      {
        com.skplanet.tad.common.a.c("in pauseTimer() viewState : " + this.E + ", elapsedTime : " + this.y);
        f();
      }
    }
  }
  
  private void h()
  {
    if (this.u == null)
    {
      this.z = Long.valueOf(this.w.longValue() - this.y.longValue());
      if (this.z.longValue() > 0L)
      {
        com.skplanet.tad.common.a.c("in resumeTimer() viewState : " + this.E + ", remainingTime : " + this.z);
        a(this.z.longValue());
      }
    }
  }
  
  private void i()
  {
    com.skplanet.tad.common.a.a("AdViewV2.doDecisionWhenLoaded state : " + this.E);
    PowerManager localPowerManager = (PowerManager)getContext().getSystemService("power");
    if ((this.E == a.a) && (localPowerManager.isScreenOn()) && (!this.D)) {
      j();
    }
  }
  
  private void j()
  {
    Object localObject1 = this.d;
    this.d = this.c;
    this.c = ((BannerView)localObject1);
    this.c.removeAllViews();
    removeView(this.c);
    addView(this.c);
    a(320, 50);
    Object localObject2 = this.e;
    if (this.e == null)
    {
      com.skplanet.tad.common.a.c("AdViewV2.swapContent() error > mDownloadedAd is null");
      return;
    }
    localObject1 = new RelativeLayout.LayoutParams((int)(320.0F * this.B), (int)(50.0F * this.B));
    if (this.e.n() == a.a.a)
    {
      ImageBannerView localImageBannerView = new ImageBannerView(getContext(), ((com.skplanet.tad.v2.content.a)localObject2).q());
      if (((com.skplanet.tad.v2.content.a)localObject2).q().length > 1)
      {
        localImageBannerView.setFlipInterval((int)(this.j * 1000L / ((com.skplanet.tad.v2.content.a)localObject2).q().length));
        localImageBannerView.startFlipping();
      }
      this.c.addView(localImageBannerView, (ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      this.c.startAnimation(this.h);
      this.d.startAnimation(this.i);
      if (this.A != null) {
        this.A.setVisibility(0);
      }
      com.skplanet.tad.common.a.c("AdViewV2.swap(), ViewState, before : " + this.E + "=> NORMAL");
      this.E = a.a;
      this.C = false;
      if (!this.f) {
        break;
      }
      a(this.j * 1000L);
      this.z = Long.valueOf(this.j * 1000L);
      return;
      if (this.e.n() == a.a.b)
      {
        localObject2 = new TextBannerView(getContext(), this.e);
        this.c.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  private void k()
  {
    com.skplanet.tad.common.a.a("ad creative will be run.");
    f();
    i();
  }
  
  public void a()
  {
    a(isShown());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = -2;
    if (paramInt1 > 0) {}
    for (paramInt1 = (int)(paramInt1 * this.B);; paramInt1 = -2)
    {
      if (paramInt2 > 0) {
        i1 = (int)(paramInt2 * this.B);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, i1);
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == this.d) {
      return;
    }
    com.skplanet.tad.common.a.a("AdListener.onAdClicked() will be called.");
    if (this.k != null) {
      this.k.onAdClicked();
    }
    paramView = this.e;
    if (this.e == null)
    {
      com.skplanet.tad.common.a.d("AdViewV2, mDownloadedAd is null");
      return;
    }
    switch (d()[paramView.r().ordinal()])
    {
    }
    for (;;)
    {
      paramView = new c(getContext(), paramView, this.l, false, "C");
      paramView.setPriority(this.t);
      paramView.start();
      return;
      if (this.e.f())
      {
        com.skplanet.tad.v2.controller.a.b(getContext(), paramView.s());
      }
      else
      {
        com.skplanet.tad.v2.controller.a.a(getContext(), paramView.s());
        continue;
        com.skplanet.tad.v2.controller.a.c(getContext(), paramView.s());
        continue;
        com.skplanet.tad.v2.controller.a.d(getContext(), paramView.s());
        continue;
        com.skplanet.tad.v2.controller.a.a(getContext(), paramView.s(), null);
        continue;
        com.skplanet.tad.v2.controller.a.a(getContext(), paramView.o(), paramView.p(), this.l, paramView.s(), null, null);
      }
    }
  }
  
  public final void b()
  {
    if (this.f) {}
    do
    {
      return;
      this.f = true;
    } while (this.F == null);
    this.F.sendEmptyMessage(1);
  }
  
  public final void c()
  {
    this.D = true;
    f();
    this.f = false;
    removeDetachedView(this.c, false);
    removeDetachedView(this.d, false);
    removeAllViews();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (isShown())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean);
      return;
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if ((paramInt == 0) && (isShown())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public final void setAnimationType(AdView.AnimationType paramAnimationType)
  {
    this.g = paramAnimationType;
    this.h = f.a(paramAnimationType, this.G);
    this.i = f.b(paramAnimationType, null);
  }
  
  public void setClientId(String paramString)
  {
    this.l = paramString;
  }
  
  public void setListener(AdListener paramAdListener)
  {
    this.k = paramAdListener;
  }
  
  public void setLogoView(LogoView paramLogoView)
  {
    this.A = paramLogoView;
  }
  
  public final void setRefreshInterval(long paramLong)
  {
    long l1 = 60L;
    long l2 = 15L;
    if (paramLong < 15L) {
      paramLong = l2;
    }
    for (;;)
    {
      if (paramLong > 60L) {
        paramLong = l1;
      }
      for (;;)
      {
        this.j = paramLong;
        return;
      }
    }
  }
  
  public void setTestMode(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public final void setThreadPriority(int paramInt) {}
  
  public final void setUseBackFill(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public final void setWebViewRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    this.s = paramRenderPriority;
  }
  
  static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/view/AdViewV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */