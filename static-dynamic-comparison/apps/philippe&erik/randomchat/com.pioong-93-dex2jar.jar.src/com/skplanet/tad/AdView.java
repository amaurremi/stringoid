package com.skplanet.tad;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings.RenderPriority;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.b;
import com.skplanet.tad.controller.d;
import com.skplanet.tad.controller.d.a;
import com.skplanet.tad.controller.f;
import com.skplanet.tad.view.AdViewV2;
import com.skplanet.tad.view.AdViewV3;
import com.skplanet.tad.view.LogoView;

public class AdView
  extends RelativeLayout
{
  private AdViewV2 a = null;
  private AdViewV3 b = null;
  private b c = null;
  private AdListener d = null;
  private String e = null;
  private int f = 2;
  private AnimationType g = AnimationType.NONE;
  private long h = 20L;
  private WebSettings.RenderPriority i;
  private int j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private LogoView p;
  
  public AdView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a.c("AdView - constructor");
    this.c = b.a(paramContext);
    if (paramAttributeSet != null)
    {
      setClientId(paramAttributeSet.getAttributeValue(null, "clientId"));
      setSlotNo(paramAttributeSet.getAttributeIntValue(null, "slotNo", 2));
      paramContext = AnimationType.NONE;
      String str = paramAttributeSet.getAttributeValue(null, "animationType");
      if (str != null) {
        paramContext = AnimationType.valueOf(str.toUpperCase());
      }
      setAnimationType(paramContext);
      setRefreshInterval(paramAttributeSet.getAttributeIntValue(null, "refreshInterval", 20));
      setTestMode(paramAttributeSet.getAttributeBooleanValue(null, "testMode", false));
      setUseBackFill(paramAttributeSet.getAttributeBooleanValue(null, "useBackFill", false));
      startAd();
    }
  }
  
  private AdViewV2 a()
  {
    a.a("AdView.createAdViewV2() is called.");
    a.a("client id : " + this.e);
    a.a("animation type : " + this.g);
    a.a("refresh interval : " + this.h);
    a.a("back fill : " + this.k);
    a.a("render priority : " + this.i);
    a.a("thread priority : " + this.j);
    a.a("test mode : " + this.l);
    AdViewV2 localAdViewV2 = new AdViewV2(getContext());
    localAdViewV2.setId(localAdViewV2.hashCode());
    localAdViewV2.setListener(this.d);
    localAdViewV2.setClientId(this.e);
    localAdViewV2.setAnimationType(this.g);
    localAdViewV2.setRefreshInterval(this.h);
    localAdViewV2.setUseBackFill(this.k);
    localAdViewV2.setWebViewRenderPriority(this.i);
    localAdViewV2.setThreadPriority(this.j);
    localAdViewV2.setTestMode(this.l);
    addView(localAdViewV2);
    return localAdViewV2;
  }
  
  private final void a(int paramInt)
  {
    a.a("AdView.startAd(" + paramInt + ") is called.");
    if (this.a != null) {
      this.a.c();
    }
    if (this.b != null) {
      this.b.c();
    }
    if (paramInt == 2)
    {
      this.a = a();
      if (this.a != null)
      {
        this.p = new LogoView(getContext(), this.e);
        this.p.setVisibility(8);
        localLayoutParams = new RelativeLayout.LayoutParams(this.p.a(), this.p.a());
        localLayoutParams.setMargins(this.p.b(), this.p.b(), this.p.b(), this.p.b());
        localLayoutParams.addRule(8, this.a.hashCode());
        localLayoutParams.addRule(7, this.a.hashCode());
        addView(this.p, localLayoutParams);
        this.a.setLogoView(this.p);
        this.a.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 3);
      this.b = b();
    } while (this.b == null);
    this.p = new LogoView(getContext());
    this.p.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.p.a(), this.p.a());
    localLayoutParams.setMargins(this.p.b(), this.p.b(), this.p.b(), this.p.b());
    localLayoutParams.addRule(8, this.b.hashCode());
    localLayoutParams.addRule(7, this.b.hashCode());
    addView(this.p, localLayoutParams);
    this.b.setLogoView(this.p);
    this.b.b();
  }
  
  private AdViewV3 b()
  {
    a.a("AdView.createAdViewV3() is called.");
    a.a("client id : " + this.e);
    a.a("slot no : " + this.f);
    a.a("animation type : " + this.g);
    a.a("refresh interval : " + this.h);
    a.a("back fill : " + this.k);
    a.a("render priority : " + this.i);
    a.a("thread priority : " + this.j);
    a.a("test mode : " + this.l);
    AdViewV3 localAdViewV3 = new AdViewV3(getContext());
    localAdViewV3.setId(localAdViewV3.hashCode());
    localAdViewV3.setListener(this.d);
    localAdViewV3.setClientId(this.e);
    localAdViewV3.setSlotNo(this.f);
    localAdViewV3.setAnimationType(this.g);
    localAdViewV3.setRefreshInterval(this.h);
    localAdViewV3.setUseBackFill(this.k);
    localAdViewV3.setWebViewRenderPriority(this.i);
    localAdViewV3.setThreadPriority(this.j);
    localAdViewV3.setTestMode(this.l);
    addView(localAdViewV3);
    return localAdViewV3;
  }
  
  public final void destroyAd()
  {
    a.a("AdView.destroyAd() is called.");
    this.n = true;
    if (this.a != null) {
      this.a.c();
    }
    if (this.b != null) {
      this.b.c();
    }
    if (this.p != null) {
      removeView(this.p);
    }
  }
  
  public final AnimationType getAnimationType()
  {
    return this.g;
  }
  
  public final WebSettings.RenderPriority getWebViewRenderPriority()
  {
    return this.i;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    a.a("AdView.onVisibilityChanged(" + paramInt + ") is called.");
    if (this.a != null) {
      this.a.a();
    }
    if (this.b != null) {
      this.b.a();
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public final void setAnimationType(AnimationType paramAnimationType)
  {
    this.g = paramAnimationType;
  }
  
  public void setClientId(String paramString)
  {
    this.e = paramString;
  }
  
  public void setListener(AdListener paramAdListener)
  {
    this.d = paramAdListener;
  }
  
  public final void setRefreshInterval(long paramLong)
  {
    long l1 = 60L;
    long l2 = 15L;
    if (paramLong < 15L)
    {
      a.a("AdView.setRefreshInterval() is called. The minimum value is 15 seconds.");
      paramLong = l2;
    }
    for (;;)
    {
      if (paramLong > 60L)
      {
        a.a("AdView.setRefreshInterval() is called. The maximum value is 60 seconds");
        paramLong = l1;
      }
      for (;;)
      {
        this.h = paramLong;
        return;
      }
    }
  }
  
  public void setSlotNo(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void setTestMode(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final void setThreadPriority(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 10))
    {
      a.b("out of range in setThreadPriority");
      this.j = 5;
      return;
    }
    this.j = paramInt;
  }
  
  public final void setUseBackFill(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    a.a("AdView.setVisibility(" + paramInt + ") is called.");
    super.setVisibility(paramInt);
  }
  
  public final void setWebViewRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    this.i = paramRenderPriority;
  }
  
  public final void startAd()
  {
    a.a("AdView.startAd() is called.");
    a.a("step 0 : Check Start Duplication");
    if (this.o) {
      a.a("AdView start already..");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.o = true;
            a.a("step 1 : check essential permissions");
            if (this.c.h()) {
              break;
            }
            a.a("AdListener.onAdFailed(PERMISSION_DENIED_ERROR) will be called.");
          } while (this.d == null);
          this.d.onAdFailed(AdListener.ErrorCode.PERMISSION_DENIED_ERROR);
          return;
          a.a("step 2 : check essential activities");
          if (this.c.i()) {
            break;
          }
          a.a("AdListener.onAdFailed(NOT_FOUND_ACTIVITY_ERROR) will be called.");
        } while (this.d == null);
        this.d.onAdFailed(AdListener.ErrorCode.NOT_FOUND_ACTIVITY_ERROR);
        return;
        a.a("step 3 : check client id");
        if (b.a(getContext()).a(this.e)) {
          break;
        }
        a.a("AdListener.onAdFailed(CLIENTID_DENIED_ERROR) will be called.");
      } while (this.d == null);
      this.d.onAdFailed(AdListener.ErrorCode.CLIENTID_DENIED_ERROR);
      return;
      a.a("step 4 : check slot number");
      if (this.f == 2) {
        break;
      }
      a.a("AdListener.onAdFailed(INVAILD_SLOT_NUMBER) will be called.");
    } while (this.d == null);
    this.d.onAdFailed(AdListener.ErrorCode.INVAILD_SLOT_NUMBER);
    return;
    a.a("step 5 : check server version");
    new f(new d()
    {
      public void a(d.a paramAnonymousa)
      {
        if (AdView.b(AdView.this) != null) {
          AdView.b(AdView.this).onAdFailed(AdListener.ErrorCode.RECEIVE_AD_ERROR);
        }
      }
      
      public void a(Object paramAnonymousObject)
      {
        if (((Activity)AdView.this.getContext()).isFinishing()) {
          a.d("AdView.onFinished() is called. isFinishing : true");
        }
        do
        {
          return;
          if (AdView.a(AdView.this))
          {
            a.d("AdView.onFinished() is called. isDestroyed is true");
            return;
          }
          int i = ((Integer)paramAnonymousObject).intValue();
          if ((i == 2) || (i == 3))
          {
            a.c("AdView.startAd(" + i + ")");
            AdView.a(AdView.this, i);
            return;
          }
          a.d("AdView.AdServerVersionChecker() Error(" + i + ")");
        } while (AdView.b(AdView.this) == null);
        AdView.b(AdView.this).onAdFailed(AdListener.ErrorCode.RECEIVE_AD_ERROR);
      }
    }).execute(new String[] { this.c.c, this.e });
  }
  
  public static enum AnimationType
  {
    static
    {
      FADE = new AnimationType("FADE", 1);
      ZOOM = new AnimationType("ZOOM", 2);
      ROTATE = new AnimationType("ROTATE", 3);
      SLIDE_FROM_RIGHT_TO_LEFT = new AnimationType("SLIDE_FROM_RIGHT_TO_LEFT", 4);
      SLIDE_FROM_LEFT_TO_RIGHT = new AnimationType("SLIDE_FROM_LEFT_TO_RIGHT", 5);
      SLIDE_FROM_BOTTOM_TO_TOP = new AnimationType("SLIDE_FROM_BOTTOM_TO_TOP", 6);
      SLIDE_FROM_TOP_TO_BOTTOM = new AnimationType("SLIDE_FROM_TOP_TO_BOTTOM", 7);
    }
  }
  
  public static class Slot
  {
    public static final int RICHMEDIA_320X480_INTERSTITIAL = 3;
    public static final int RICHMEDIA_320X50_INLINE = 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */