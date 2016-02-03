package com.skplanet.tad;

import android.app.Activity;
import android.content.Context;
import com.skplanet.tad.common.a;
import com.skplanet.tad.controller.d.a;
import com.skplanet.tad.controller.f;
import com.skplanet.tad.view.c;

public class AdInterstitial
{
  AdInterstitialListener a = null;
  private Context b;
  private String c = null;
  private int d = 3;
  private boolean e = false;
  private boolean f = false;
  private com.skplanet.tad.view.b g = null;
  private c h = null;
  private AdInterstitialListener i = new AdInterstitialListener()
  {
    public void onAdClosed()
    {
      a.a("AdInterstitialListener.onAdClosed() will be called.");
      if (AdInterstitial.this.a != null) {
        AdInterstitial.this.a.onAdClosed();
      }
    }
    
    public void onAdFailed(AdInterstitialListener.ErrorCode paramAnonymousErrorCode)
    {
      a.a("AdInterstitialListener.onAdFailed(" + paramAnonymousErrorCode + ") will be called.");
      if (AdInterstitial.this.a != null) {
        AdInterstitial.this.a.onAdFailed(paramAnonymousErrorCode);
      }
    }
    
    public void onAdLoaded()
    {
      a.a("AdInterstitialListener.onAdLoaded() will be called.");
      if (AdInterstitial.this.a != null) {
        AdInterstitial.this.a.onAdLoaded();
      }
      AdInterstitial.a(AdInterstitial.this);
    }
    
    public void onAdReceived()
    {
      a.a("AdInterstitialListener.onAdReceived() will be called.");
      if (AdInterstitial.this.a != null) {
        AdInterstitial.this.a.onAdReceived();
      }
    }
    
    public void onAdWillLoad()
    {
      a.a("AdInterstitialListener.onAdWillLoad() will be called.");
      if (AdInterstitial.this.a != null) {
        AdInterstitial.this.a.onAdWillLoad();
      }
    }
    
    public void onAdWillReceive()
    {
      a.a("AdInterstitialListener.onAdWillReceive() will be called.");
      if (AdInterstitial.this.a != null) {
        AdInterstitial.this.a.onAdWillReceive();
      }
    }
  };
  
  public AdInterstitial(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private com.skplanet.tad.view.b a()
  {
    com.skplanet.tad.view.b localb = new com.skplanet.tad.view.b(this.b);
    localb.a(this.i);
    localb.a(this.c);
    return localb;
  }
  
  private final void a(int paramInt)
  {
    a.a("AdInterstitial.loadAd(" + paramInt + ") is called.");
    if (paramInt == 2)
    {
      a.a("client id : " + this.c);
      a.a("test mode : " + this.e);
      this.g = a();
      this.g.a(this.e);
      this.g.a();
      return;
    }
    a.a("client id : " + this.c);
    a.a("slot no : " + this.d);
    a.a("back fill : " + this.f);
    a.a("test mode : " + this.e);
    this.h = b();
    this.h.a(this.d);
    this.h.b(this.f);
    this.h.a(this.e);
    this.h.a();
  }
  
  private c b()
  {
    c localc = new c(this.b);
    localc.a(this.i);
    localc.a(this.c);
    return localc;
  }
  
  private void c()
  {
    a.a("AdInterstitial.loadAd() is called.");
    a.a("step 1 : check abusing");
    long l = System.currentTimeMillis();
    if (5000L > l - com.skplanet.tad.view.d.b().a())
    {
      a.a("AdInterstitialListener.onAdFailed(LOAD_ERROR) will be called. because of checking abusing time.");
      if (this.a != null) {
        this.a.onAdFailed(AdInterstitialListener.ErrorCode.LOAD_ERROR);
      }
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
            com.skplanet.tad.view.d.b().a(l);
            a.a("step 2 : check essential permissions");
            if (com.skplanet.tad.common.b.a(this.b).h()) {
              break;
            }
            a.a("AdInterstitialListener.onAdFailed(PERMISSION_DENIED_ERROR) will be called.");
          } while (this.a == null);
          this.a.onAdFailed(AdInterstitialListener.ErrorCode.PERMISSION_DENIED_ERROR);
          return;
          a.a("step 3 : check essential activities");
          if (com.skplanet.tad.common.b.a(this.b).i()) {
            break;
          }
          a.a("AdInterstitialListener.onAdFailed(NOT_FOUND_ACTIVITY_ERROR) will be called.");
        } while (this.a == null);
        this.a.onAdFailed(AdInterstitialListener.ErrorCode.NOT_FOUND_ACTIVITY_ERROR);
        return;
        a.a("step 4 : check client id");
        if (com.skplanet.tad.common.b.a(this.b).a(this.c)) {
          break;
        }
        a.a("AdInterstitialListener.onAdFailed(CLIENTID_DENIED_ERROR) will be called.");
      } while (this.a == null);
      this.a.onAdFailed(AdInterstitialListener.ErrorCode.CLIENTID_DENIED_ERROR);
      return;
      a.a("step 5 : check slot number");
      if (this.d == 3) {
        break;
      }
      a.a("AdInterstitialListener.onAdFailed(INVAILD_SLOT_NUMBER) will be called.");
    } while (this.a == null);
    this.a.onAdFailed(AdInterstitialListener.ErrorCode.INVAILD_SLOT_NUMBER);
    return;
    a.a("step 6 : check server version");
    new f(new com.skplanet.tad.controller.d()
    {
      public void a(d.a paramAnonymousa)
      {
        a.d("AdServerVersionChecker > AdInterstialListener.onFailed(" + paramAnonymousa + ")");
      }
      
      public void a(Object paramAnonymousObject)
      {
        if (((Activity)AdInterstitial.b(AdInterstitial.this)).isFinishing())
        {
          a.d("AdServerVersionChecker > AdInterstialListener.onFinished(), isFinishing true");
          return;
        }
        int i = ((Integer)paramAnonymousObject).intValue();
        if ((i == 2) || (i == 3))
        {
          a.c("AdServerVersionChecker > AdInterstitial.loadAd(" + i + ")");
          AdInterstitial.a(AdInterstitial.this, i);
          return;
        }
        a.d("AdServerVersionChecker Error : result (" + i + ")");
      }
    }).execute(new String[] { com.skplanet.tad.common.b.a(this.b).c, this.c });
  }
  
  private void d()
  {
    a.a("AdInterstitial.show() is called.");
    if (this.g != null) {
      this.g.b();
    }
    while (this.h == null) {
      return;
    }
    this.h.b();
  }
  
  public boolean canLoadInterstitail()
  {
    return 5000L <= System.currentTimeMillis() - com.skplanet.tad.view.d.b().a();
  }
  
  public final boolean getUseBackFill()
  {
    return this.f;
  }
  
  public void loadAndShow()
  {
    a.a("AdInterstitial.loadAndShow() is called.");
    c();
  }
  
  public void setClientId(String paramString)
  {
    this.c = paramString;
  }
  
  public void setListener(AdInterstitialListener paramAdInterstitialListener)
  {
    this.a = paramAdInterstitialListener;
  }
  
  public void setSlotNo(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void setTestMode(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final void setUseBackFill(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/AdInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */