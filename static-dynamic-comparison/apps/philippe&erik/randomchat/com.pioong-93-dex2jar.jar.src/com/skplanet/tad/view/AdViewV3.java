package com.skplanet.tad.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.skplanet.tad.AdListener;
import com.skplanet.tad.AdListener.ErrorCode;
import com.skplanet.tad.AdView.AnimationType;
import com.skplanet.tad.common.f;
import com.skplanet.tad.content.AdContent;
import com.skplanet.tad.controller.d;
import com.skplanet.tad.controller.d.a;
import com.skplanet.tad.controller.e;
import com.skplanet.tad.controller.h;
import com.skplanet.tad.mraid.view.MraidView;
import com.skplanet.tad.protocol.AdInAppResponse;
import com.skplanet.tad.protocol.AdInAppResponseRich;
import java.util.Timer;
import java.util.TimerTask;

public class AdViewV3
  extends RelativeLayout
{
  private boolean A = false;
  private a B = a.a;
  private int C;
  private View D = null;
  private final Handler E = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.skplanet.tad.common.a.c("in AdViewV3.handleMessage() msg : " + paramAnonymousMessage.what);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      AdViewV3.a(AdViewV3.this);
      AdViewV3.a(AdViewV3.this, Long.valueOf(0L));
      com.skplanet.tad.common.a.a("AdViewV3.onAdWillReceive() will be called.");
      if (AdViewV3.b(AdViewV3.this) != null) {
        AdViewV3.b(AdViewV3.this).onAdWillReceive();
      }
      AdViewV3.a(AdViewV3.this, new com.skplanet.tad.controller.a(AdViewV3.this.getContext(), AdViewV3.this.a, AdViewV3.c(AdViewV3.this), AdViewV3.d(AdViewV3.this), AdViewV3.e(AdViewV3.this)));
      AdViewV3.f(AdViewV3.this).execute(new String[] { "" });
    }
  };
  private Animation.AnimationListener F = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      com.skplanet.tad.common.a.c("AdViewV3.onAnimationEnd() is called.");
      if ((paramAnonymousAnimation == AdViewV3.g(AdViewV3.this)) && (AdViewV3.h(AdViewV3.this) != null)) {
        AdViewV3.this.post(new Runnable()
        {
          public void run()
          {
            AdViewV3.this.removeView(AdViewV3.h(AdViewV3.this));
            AdViewV3.h(AdViewV3.this).c();
            AdViewV3.h(AdViewV3.this).d();
            AdViewV3.a(AdViewV3.this, null);
          }
        });
      }
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation)
    {
      com.skplanet.tad.common.a.c("AdViewV3.onAnimationRepeat() is called.");
    }
    
    public final void onAnimationStart(Animation paramAnonymousAnimation)
    {
      com.skplanet.tad.common.a.c("AdViewV3.onAnimationStart() is called.");
    }
  };
  public d a = new d()
  {
    private int a(String paramAnonymousString)
    {
      if (TextUtils.isEmpty(paramAnonymousString)) {
        return 0;
      }
      paramAnonymousString = paramAnonymousString.split("x");
      try
      {
        int i = Integer.parseInt(paramAnonymousString[0]);
        return i;
      }
      catch (Exception paramAnonymousString)
      {
        com.skplanet.tad.common.a.d("AdViewV3.getWidth()");
      }
      return 0;
    }
    
    private void a(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        com.skplanet.tad.common.a.c("[AdViewV3]undefined ret_code");
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
        if (AdViewV3.b(AdViewV3.this) != null) {
          AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
        }
        break;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      com.skplanet.tad.common.a.a("AdListener.onAdFailed(NO_AD) will be called.");
                    } while (AdViewV3.b(AdViewV3.this) == null);
                    AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.NO_AD);
                    return;
                    com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
                  } while (AdViewV3.b(AdViewV3.this) == null);
                  AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
                  return;
                  com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
                } while (AdViewV3.b(AdViewV3.this) == null);
                AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
                return;
                com.skplanet.tad.common.a.a("AdListener.onAdReceived() will be called.");
              } while (AdViewV3.b(AdViewV3.this) == null);
              AdViewV3.b(AdViewV3.this).onAdReceived();
              return;
              com.skplanet.tad.common.a.a("AdListener.onAdFailed(CLIENTID_DENIED_ERROR) will be called.");
            } while (AdViewV3.b(AdViewV3.this) == null);
            AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.CLIENTID_DENIED_ERROR);
            return;
            com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
          } while (AdViewV3.b(AdViewV3.this) == null);
          AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
          return;
          com.skplanet.tad.common.a.a("AdListener.onAdFailed(INVAILD_SLOT_NUMBER) will be called.");
        } while (AdViewV3.b(AdViewV3.this) == null);
        AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INVAILD_SLOT_NUMBER);
        return;
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
      } while (AdViewV3.b(AdViewV3.this) == null);
      AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
    }
    
    private int b(String paramAnonymousString)
    {
      if (TextUtils.isEmpty(paramAnonymousString)) {
        return 0;
      }
      paramAnonymousString = paramAnonymousString.split("x");
      try
      {
        int i = Integer.parseInt(paramAnonymousString[1]);
        return i;
      }
      catch (Exception paramAnonymousString)
      {
        com.skplanet.tad.common.a.d("AdViewV3.getHeight()");
      }
      return 0;
    }
    
    public void a(d.a paramAnonymousa)
    {
      if (AdViewV3.i(AdViewV3.this)) {
        com.skplanet.tad.common.a.d("AdViewV3.AdDownloaderListener.onFailed(), already adview is destroyed.");
      }
      do
      {
        return;
        com.skplanet.tad.common.a.a("ad is not downloaded.");
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
      } while (AdViewV3.b(AdViewV3.this) == null);
      AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
    }
    
    public void a(Object paramAnonymousObject)
    {
      int i = -1;
      if (AdViewV3.i(AdViewV3.this))
      {
        com.skplanet.tad.common.a.d("AdViewV3.AdDownloaderListener.onFinished(), already adview is destroyed.");
        return;
      }
      AdInAppResponse localAdInAppResponse = (AdInAppResponse)paramAnonymousObject;
      if (localAdInAppResponse == null)
      {
        a(500);
        com.skplanet.tad.common.a.c("AdViewV3.AdDownloaderListener.onFinished(), internal error, inAppResult == null");
        return;
      }
      if (TextUtils.isEmpty(localAdInAppResponse.ret_code))
      {
        a(500);
        com.skplanet.tad.common.a.c("AdViewV3.AdDownloaderListener.onFinished(), internal error, inAppResult.ret_code == null");
        return;
      }
      int j;
      try
      {
        j = Integer.parseInt(localAdInAppResponse.ret_code);
        a(j);
        if (j != 200) {
          break label585;
        }
        if ((TextUtils.isEmpty(localAdInAppResponse.x_bypass)) || (TextUtils.isEmpty(localAdInAppResponse.c_type)) || (TextUtils.isEmpty(localAdInAppResponse.c_url)))
        {
          com.skplanet.tad.common.a.c("AdViewV3.AdDownloaderListener.onFinished(), internal error, field error");
          a(500);
          return;
        }
      }
      catch (NumberFormatException paramAnonymousObject)
      {
        a(500);
        com.skplanet.tad.common.a.d("AdViewV3.AdDownloaderListener.onFinished(), internal error, NumberFormatException");
        return;
      }
      try
      {
        j = Integer.parseInt(localAdInAppResponse.c_type);
        switch (j)
        {
        default: 
          com.skplanet.tad.common.a.c("[AdViewV3]Not Defined c_type");
          a(500);
          return;
        }
      }
      catch (NumberFormatException paramAnonymousObject)
      {
        a(500);
        com.skplanet.tad.common.a.d("AdViewV3.AdDownloaderListener.onFinished(c_type), internal error, NumberFormatException");
        return;
      }
      if (localAdInAppResponse.c_data == null)
      {
        com.skplanet.tad.common.a.c("AdViewV3.AdDownloaderListener.onFinished(), internal error, inAppResult.c_data == null");
        a(500);
        return;
      }
      String str1 = "utf-8";
      String str2 = "-2147483648";
      if (!TextUtils.isEmpty(localAdInAppResponse.c_data.resolution))
      {
        j = a(localAdInAppResponse.c_data.resolution);
        i = b(localAdInAppResponse.c_data.resolution);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localAdInAppResponse.c_data.base_url)) {}
        for (paramAnonymousObject = localAdInAppResponse.c_data.base_url;; paramAnonymousObject = null)
        {
          if (!TextUtils.isEmpty(localAdInAppResponse.c_data.encoding_type)) {
            str1 = localAdInAppResponse.c_data.encoding_type;
          }
          if (!TextUtils.isEmpty(localAdInAppResponse.c_data.backfill_color)) {
            str2 = localAdInAppResponse.c_data.backfill_color;
          }
          if (!TextUtils.isEmpty(localAdInAppResponse.c_data.backfill_image)) {
            String str3 = localAdInAppResponse.c_data.backfill_image;
          }
          AdViewV3.a(AdViewV3.this, new com.skplanet.tad.content.a(j, i, (String)paramAnonymousObject, localAdInAppResponse.c_url));
          ((com.skplanet.tad.content.a)AdViewV3.j(AdViewV3.this)).e(str2);
          if (!TextUtils.isEmpty(localAdInAppResponse.c_exposure_time)) {
            i = (int)AdViewV3.k(AdViewV3.this);
          }
          try
          {
            j = Integer.parseInt(localAdInAppResponse.c_exposure_time);
            i = j;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              com.skplanet.tad.common.a.d("AdViewV3.AdDownloaderListener.onFinished(), Integer.parseInt(), ");
            }
          }
          AdViewV3.j(AdViewV3.this).a(i);
          AdViewV3.this.setRefreshInterval(i);
          ((com.skplanet.tad.content.a)AdViewV3.j(AdViewV3.this)).d(str1);
          AdViewV3.j(AdViewV3.this).a(localAdInAppResponse.x_bypass);
          if (AdViewV3.j(AdViewV3.this) == null) {
            break;
          }
          com.skplanet.tad.common.a.a("onAdWillLoad() will be called.");
          if (AdViewV3.b(AdViewV3.this) != null) {
            AdViewV3.b(AdViewV3.this).onAdWillLoad();
          }
          AdViewV3.a(AdViewV3.this, new e(AdViewV3.this.b, null));
          AdViewV3.l(AdViewV3.this).execute(new String[] { ((com.skplanet.tad.content.a)AdViewV3.j(AdViewV3.this)).f() });
          return;
          label585:
          if (j != 0) {
            break;
          }
          AdViewV3.a(AdViewV3.this);
          if (!AdViewV3.m(AdViewV3.this)) {
            break;
          }
          com.skplanet.tad.common.a.c("@ " + AdViewV3.n(AdViewV3.this) + "=> NORMAL");
          AdViewV3.a(AdViewV3.this, AdViewV3.a.a);
          AdViewV3.a(AdViewV3.this, AdViewV3.k(AdViewV3.this) * 1000L);
          if (AdViewV3.o(AdViewV3.this) == null) {
            break;
          }
          AdViewV3.o(AdViewV3.this).c();
          AdViewV3.o(AdViewV3.this).d();
          AdViewV3.b(AdViewV3.this, null);
          if (AdViewV3.p(AdViewV3.this) == null) {
            break;
          }
          AdViewV3.p(AdViewV3.this).setVisibility(8);
          return;
        }
        j = -1;
      }
    }
  };
  public d b = new d()
  {
    public void a(d.a paramAnonymousa)
    {
      if (AdViewV3.i(AdViewV3.this)) {
        com.skplanet.tad.common.a.d("AdViewV3.AdLoaderListener.onFailed(), already adview is destroyed.");
      }
      do
      {
        return;
        com.skplanet.tad.common.a.a("ad is not loaded.");
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
      } while (AdViewV3.b(AdViewV3.this) == null);
      AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
    }
    
    public void a(Object paramAnonymousObject)
    {
      if (AdViewV3.i(AdViewV3.this)) {
        com.skplanet.tad.common.a.d("AdViewV3.AdLoaderListener.onFinished(), already adview is destroyed.");
      }
      do
      {
        return;
        if (AdViewV3.j(AdViewV3.this) != null) {
          break;
        }
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
      } while (AdViewV3.b(AdViewV3.this) == null);
      AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
      return;
      ((com.skplanet.tad.content.a)AdViewV3.j(AdViewV3.this)).c((String)paramAnonymousObject);
      com.skplanet.tad.common.a.a("AdListener.onAdLoaded() will be called.");
      if (AdViewV3.b(AdViewV3.this) != null) {
        AdViewV3.b(AdViewV3.this).onAdLoaded();
      }
      AdViewV3.q(AdViewV3.this);
    }
  };
  public com.skplanet.tad.mraid.view.a c = new com.skplanet.tad.mraid.view.a()
  {
    public void a(MraidView paramAnonymousMraidView)
    {
      if (AdViewV3.i(AdViewV3.this)) {
        com.skplanet.tad.common.a.d("AdViewV3.MraidViewListener.onLoaded(), already adview is destroyed.");
      }
      do
      {
        return;
        if ((AdViewV3.h(AdViewV3.this) != null) && (AdViewV3.h(AdViewV3.this) == paramAnonymousMraidView)) {
          break;
        }
        com.skplanet.tad.common.a.a("AdListener.onAdFailed(INTERNAL_ERROR) will be called.");
      } while (AdViewV3.b(AdViewV3.this) == null);
      AdViewV3.b(AdViewV3.this).onAdFailed(AdListener.ErrorCode.INTERNAL_ERROR);
      return;
      AdViewV3.a(AdViewV3.this, true);
      AdViewV3.r(AdViewV3.this);
    }
    
    public void b(MraidView paramAnonymousMraidView)
    {
      if (AdViewV3.p(AdViewV3.this) != null) {
        AdViewV3.p(AdViewV3.this).setVisibility(8);
      }
      com.skplanet.tad.common.a.c("AdViewV3.onResized():" + AdViewV3.n(AdViewV3.this));
      AdViewV3.s(AdViewV3.this);
      com.skplanet.tad.common.a.c("AdViewV3.onResized(): " + AdViewV3.n(AdViewV3.this) + "=> WAITFORCLOSE" + ", mRemainingTime : " + AdViewV3.t(AdViewV3.this));
      AdViewV3.a(AdViewV3.this, AdViewV3.a.c);
      com.skplanet.tad.common.a.c("AdViewV3.onResized():" + AdViewV3.n(AdViewV3.this));
      com.skplanet.tad.common.a.a("AdListener.onAdResized() will be called.");
      if (AdViewV3.b(AdViewV3.this) != null) {
        AdViewV3.b(AdViewV3.this).onAdResized();
      }
    }
    
    public void c(MraidView paramAnonymousMraidView)
    {
      if (AdViewV3.p(AdViewV3.this) != null) {
        AdViewV3.p(AdViewV3.this).setVisibility(8);
      }
      AdViewV3.s(AdViewV3.this);
      com.skplanet.tad.common.a.c("AdViewV3.onExpanded:" + AdViewV3.n(AdViewV3.this) + "=> WAITFORCLOSE" + ", mRemainingTime : " + AdViewV3.t(AdViewV3.this));
      AdViewV3.a(AdViewV3.this, AdViewV3.a.c);
      com.skplanet.tad.common.a.a("AdListener.onAdExpanded() will be called.");
      if (AdViewV3.b(AdViewV3.this) != null) {
        AdViewV3.b(AdViewV3.this).onAdExpanded();
      }
    }
    
    public void d(MraidView paramAnonymousMraidView) {}
    
    public void e(MraidView paramAnonymousMraidView)
    {
      if (AdViewV3.p(AdViewV3.this) != null) {
        AdViewV3.p(AdViewV3.this).setVisibility(0);
      }
      AdViewV3.u(AdViewV3.this);
      com.skplanet.tad.common.a.a("AdListener.onAdExpandClosed() will be called.");
      if (AdViewV3.b(AdViewV3.this) != null) {
        AdViewV3.b(AdViewV3.this).onAdExpandClosed();
      }
    }
    
    public void f(MraidView paramAnonymousMraidView)
    {
      if (AdViewV3.p(AdViewV3.this) != null) {
        AdViewV3.p(AdViewV3.this).setVisibility(0);
      }
      AdViewV3.u(AdViewV3.this);
      com.skplanet.tad.common.a.a("AdListener.onAdResizeClosed() will be called.");
      if (AdViewV3.b(AdViewV3.this) != null) {
        AdViewV3.b(AdViewV3.this).onAdResizeClosed();
      }
    }
    
    public void g(MraidView paramAnonymousMraidView)
    {
      com.skplanet.tad.common.a.a("AdListener.onAdClicked() will be called.");
      if (AdViewV3.b(AdViewV3.this) != null) {
        AdViewV3.b(AdViewV3.this).onAdClicked();
      }
    }
  };
  private com.skplanet.tad.controller.a d;
  private e e;
  private MraidView f;
  private MraidView g;
  private AdContent h;
  private boolean i = false;
  private AdView.AnimationType j = AdView.AnimationType.NONE;
  private Animation k = null;
  private Animation l = null;
  private long m = 20L;
  private AdListener n = null;
  private boolean o = false;
  private String p = null;
  private int q = 2;
  private boolean r = false;
  private WebSettings.RenderPriority s = WebSettings.RenderPriority.NORMAL;
  private Timer t = null;
  private TimerTask u = null;
  private Long v = Long.valueOf(0L);
  private Long w = Long.valueOf(0L);
  private Long x = Long.valueOf(0L);
  private Long y = Long.valueOf(0L);
  private boolean z = false;
  
  public AdViewV3(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public AdViewV3(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdViewV3(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
    if (paramAttributeSet != null)
    {
      setClientId(paramAttributeSet.getAttributeValue(null, "clientId"));
      setRefreshInterval(paramAttributeSet.getAttributeIntValue(null, "refreshInterval", 30));
    }
  }
  
  private com.skplanet.tad.controller.b a(AdContent paramAdContent)
  {
    com.skplanet.tad.controller.b localb = new com.skplanet.tad.controller.b();
    localb.a = this.p;
    localb.c = paramAdContent.b();
    localb.b = this.q;
    localb.d = this.o;
    return localb;
  }
  
  private void a(long paramLong)
  {
    com.skplanet.tad.common.a.c("AdViewV3.startTimer() interval : " + paramLong);
    if (paramLong < 0L) {}
    do
    {
      return;
      if (this.t == null) {
        this.t = new Timer();
      }
      if (this.u == null) {
        this.u = new TimerTask()
        {
          public void run()
          {
            com.skplanet.tad.common.a.a("refresh timer is timeout. so new ad will be downloaded.");
            if (AdViewV3.v(AdViewV3.this) != null) {
              AdViewV3.v(AdViewV3.this).sendEmptyMessage(1);
            }
          }
        };
      }
    } while ((this.t == null) || (this.u == null));
    com.skplanet.tad.common.a.a("refresh timer is started.");
    this.t.schedule(this.u, paramLong);
    this.v = Long.valueOf(paramLong);
    this.w = Long.valueOf(System.currentTimeMillis());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.A) {
      com.skplanet.tad.common.a.d("AdViewV3.doDecisionWhenVisibleChanged(), already adview is destroyed.");
    }
    do
    {
      do
      {
        do
        {
          return;
          com.skplanet.tad.common.a.c("AdView3,oDecisionWhenVisibleChanged:" + this.B + " ,  mRemainingTime:" + this.y);
          if (!paramBoolean) {
            break;
          }
        } while (this.B != a.b);
        com.skplanet.tad.common.a.c("AdView3.oDecisionWhenVisibleChanged, before : " + this.B + "=> NORMAL");
        this.B = a.a;
        if (this.y.longValue() > 0L)
        {
          g();
          return;
        }
      } while (!this.z);
      l();
      return;
    } while (this.B != a.a);
    com.skplanet.tad.common.a.c("AdView3.oDecisionWhenVisibleChanged, before : " + this.B + "=> WAITFORVISIBLE");
    this.B = a.b;
    f();
  }
  
  private void d()
  {
    com.skplanet.tad.common.b.a(getContext()).c();
    setAnimationType(AdView.AnimationType.NONE);
  }
  
  private void e()
  {
    com.skplanet.tad.common.a.c("in AdViewV3.stopTimer()");
    if (this.t != null)
    {
      com.skplanet.tad.common.a.a("refresh timer is stopped.");
      this.t.cancel();
      this.t = null;
    }
    if (this.u != null)
    {
      this.u.cancel();
      this.u = null;
    }
  }
  
  private void f()
  {
    if (this.t != null)
    {
      this.x = Long.valueOf(System.currentTimeMillis() - this.w.longValue());
      if (this.x.longValue() < this.v.longValue())
      {
        com.skplanet.tad.common.a.c("in AdViewV3.pauseTimer() viewState : " + this.B + ", elapsedTime : " + this.x);
        e();
      }
    }
  }
  
  private void g()
  {
    if (this.t == null)
    {
      this.y = Long.valueOf(this.v.longValue() - this.x.longValue());
      if (this.y.longValue() > 0L)
      {
        com.skplanet.tad.common.a.c("in AdViewV3.resumeTimer() viewState : " + this.B + ", remainingTime : " + this.y);
        a(this.y.longValue());
      }
    }
  }
  
  private void h()
  {
    if (this.A) {
      com.skplanet.tad.common.a.d("AdViewV3.deDecisionWhenLoaded(), already adview is destroyed.");
    }
    PowerManager localPowerManager;
    do
    {
      do
      {
        return;
        localPowerManager = (PowerManager)getContext().getSystemService("power");
      } while (localPowerManager == null);
      com.skplanet.tad.common.a.c("AdView3.deDecisionWhenLoaded,  deDecisionWhenLoaded:" + this.B + "pm.isScreenOn():" + localPowerManager.isScreenOn());
    } while ((this.B != a.a) || (!localPowerManager.isScreenOn()));
    l();
  }
  
  private void i()
  {
    if (this.A) {
      com.skplanet.tad.common.a.d("AdViewV3.doDecisionWhenClosed(), already adview is destroyed.");
    }
    do
    {
      do
      {
        return;
        com.skplanet.tad.common.a.c("AdView3.doDecisionWhenClosed:" + this.B + " ,  mRemainingTime:" + this.y);
      } while (this.B != a.c);
      com.skplanet.tad.common.a.c("AdView3.doDecisionWhenClosed, before : " + this.B + "=> NORMAL");
      this.B = a.a;
      if (this.y.longValue() > 0L)
      {
        g();
        return;
      }
    } while (!this.z);
    l();
  }
  
  private void j()
  {
    com.skplanet.tad.controller.b localb = a(this.h);
    this.g = new MraidView(getContext(), this.c, false, localb);
    this.g.setTracker(new h(this.g, null, this.p));
    this.g.a(((com.skplanet.tad.content.a)this.h).h(), ((com.skplanet.tad.content.a)this.h).i());
    this.g.loadDataWithBaseURL(((com.skplanet.tad.content.a)this.h).d(), ((com.skplanet.tad.content.a)this.h).e(), "text/html", ((com.skplanet.tad.content.a)this.h).g(), null);
  }
  
  private void k()
  {
    com.skplanet.tad.common.a.a("ad creative will be run.");
    j();
  }
  
  private void l()
  {
    Object localObject = this.g;
    this.g = this.f;
    this.f = ((MraidView)localObject);
    if (this.f != null)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      addView(this.f);
      this.f.f();
      setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.f != null)
    {
      this.f.startAnimation(this.k);
      if (!this.r) {
        break label258;
      }
    }
    for (;;)
    {
      try
      {
        ((ViewGroup)getParent()).setBackgroundColor(Color.parseColor(((com.skplanet.tad.content.a)this.h).j()));
        if (this.g != null) {
          this.g.startAnimation(this.l);
        }
        if (this.D != null)
        {
          this.D.setAnimation(f.a(AdView.AnimationType.FADE, null));
          this.D.setVisibility(0);
        }
        com.skplanet.tad.common.a.c("@ " + this.B + "=> NORMAL");
        this.B = a.a;
        this.z = false;
        if (this.i)
        {
          a(this.m * 1000L);
          this.y = Long.valueOf(this.m * 1000L);
        }
        return;
      }
      catch (Exception localException)
      {
        com.skplanet.tad.common.a.d("AdViewV3.swapContents, Step3, setBackgroundColor Error : " + localException);
        continue;
      }
      label258:
      ((ViewGroup)getParent()).setBackgroundColor(0);
    }
  }
  
  public void a()
  {
    a(isShown());
  }
  
  public final void b()
  {
    com.skplanet.tad.common.a.a("AdViewV3.startAd() will be called.");
    if (this.i) {
      return;
    }
    this.i = true;
    this.E.sendEmptyMessage(1);
  }
  
  public final void c()
  {
    com.skplanet.tad.common.a.a("AdViewV3.destroyAd() will be called.");
    this.A = true;
    e();
    if (this.f != null)
    {
      this.f.c();
      this.f.d();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.c();
      this.g.d();
      this.g = null;
      if (this.d != null)
      {
        this.d.cancel(true);
        this.d = null;
      }
      if (this.e != null)
      {
        this.e.cancel(true);
        this.e = null;
      }
    }
    this.i = false;
  }
  
  protected void onDetachedFromWindow()
  {
    com.skplanet.tad.common.a.c("AdViewV3.onDetachedFromWindow() is called");
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
    this.j = paramAnimationType;
    this.k = f.a(paramAnimationType, this.F);
    this.l = f.b(paramAnimationType, null);
  }
  
  public void setClientId(String paramString)
  {
    this.p = paramString;
  }
  
  public void setListener(AdListener paramAdListener)
  {
    this.n = paramAdListener;
  }
  
  public void setLogoView(LogoView paramLogoView)
  {
    this.D = paramLogoView;
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
        this.m = paramLong;
        return;
      }
    }
  }
  
  public void setSlotNo(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setTestMode(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public final void setThreadPriority(int paramInt)
  {
    this.C = paramInt;
  }
  
  public final void setUseBackFill(boolean paramBoolean)
  {
    this.r = paramBoolean;
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
    if (paramRenderPriority != null) {}
    for (this.s = paramRenderPriority;; this.s = WebSettings.RenderPriority.NORMAL) {
      try
      {
        if (this.f != null) {
          this.f.getSettings().setRenderPriority(this.s);
        }
        if (this.g != null) {
          this.g.getSettings().setRenderPriority(this.s);
        }
        return;
      }
      catch (Exception paramRenderPriority)
      {
        com.skplanet.tad.common.a.d("[AdViewV3]Webview is not initialized.");
      }
    }
  }
  
  static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/view/AdViewV3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */