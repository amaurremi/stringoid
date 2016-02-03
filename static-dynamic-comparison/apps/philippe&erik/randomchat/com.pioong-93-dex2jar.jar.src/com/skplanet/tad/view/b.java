package com.skplanet.tad.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ProgressBar;
import com.skplanet.tad.AdActivity;
import com.skplanet.tad.AdActivity.a;
import com.skplanet.tad.AdInterstitialListener;
import com.skplanet.tad.AdInterstitialListener.ErrorCode;
import com.skplanet.tad.controller.d.a;

public class b
{
  public com.skplanet.tad.controller.d a = new com.skplanet.tad.controller.d()
  {
    public void a(d.a paramAnonymousa)
    {
      com.skplanet.tad.common.a.a("interstitial ad is not downloaded.");
      b.d(b.this);
      if (paramAnonymousa == d.a.e)
      {
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed(NO_AD) will be called.");
        if (b.a(b.this) != null) {
          b.a(b.this).onAdFailed(AdInterstitialListener.ErrorCode.NO_AD);
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
            com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed(CLIENTID_DENIED_ERROR) will be called.");
          } while (b.a(b.this) == null);
          b.a(b.this).onAdFailed(AdInterstitialListener.ErrorCode.CLIENTID_DENIED_ERROR);
          return;
        } while (paramAnonymousa != d.a.d);
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed(CONNECTION_ERROR) will be called.");
      } while (b.a(b.this) == null);
      b.a(b.this).onAdFailed(AdInterstitialListener.ErrorCode.CONNECTION_ERROR);
    }
    
    public void a(Object paramAnonymousObject)
    {
      com.skplanet.tad.common.a.a("interstitial ad is downloaded.");
      com.skplanet.tad.common.a.a("AdInterstitialListener.onAdReceived() will be called.");
      if (b.a(b.this) != null) {
        b.a(b.this).onAdReceived();
      }
      b.a(b.this, (com.skplanet.tad.v2.content.a)paramAnonymousObject);
      if (b.b(b.this) != null)
      {
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdWillLoad() will be called. and received ad will be loaded.");
        if (b.a(b.this) != null) {
          b.a(b.this).onAdWillLoad();
        }
        if (b.b(b.this).n() == com.skplanet.tad.v2.content.a.a.c) {
          b.this.b.a(null);
        }
      }
      else
      {
        return;
      }
      paramAnonymousObject = new com.skplanet.tad.v2.controller.d(b.this.b);
      if (b.c(b.this).getResources().getConfiguration().orientation == 1)
      {
        b.a(b.this, 1);
        ((com.skplanet.tad.v2.controller.d)paramAnonymousObject).execute(new String[][] { b.b(b.this).i() });
        return;
      }
      b.a(b.this, 0);
      ((com.skplanet.tad.v2.controller.d)paramAnonymousObject).execute(new String[][] { { b.b(b.this).t() } });
    }
  };
  public com.skplanet.tad.controller.d b = new com.skplanet.tad.controller.d()
  {
    public void a(d.a paramAnonymousa)
    {
      com.skplanet.tad.common.a.a("interstitial ad is not loaded.");
      b.d(b.this);
      switch (a()[paramAnonymousa.ordinal()])
      {
      }
      for (paramAnonymousa = AdInterstitialListener.ErrorCode.INTERNAL_ERROR;; paramAnonymousa = AdInterstitialListener.ErrorCode.NETWORK_ERROR)
      {
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed(" + paramAnonymousa + ") will be called.");
        if (b.a(b.this) != null) {
          b.a(b.this).onAdFailed(paramAnonymousa);
        }
        return;
      }
    }
    
    public void a(Object paramAnonymousObject)
    {
      if (b.b(b.this) == null)
      {
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed(INTERNAL_ERROR) will be called.");
        if (b.a(b.this) != null) {
          b.a(b.this).onAdFailed(AdInterstitialListener.ErrorCode.INTERNAL_ERROR);
        }
      }
      do
      {
        return;
        if (b.b(b.this) != null) {
          b.b(b.this).a((Bitmap[])paramAnonymousObject);
        }
        b.b(b.this, b.b(b.this));
        b.a(b.this, true);
        b.d(b.this);
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdLoaded() will be called.");
      } while (b.a(b.this) == null);
      b.a(b.this).onAdLoaded();
    }
  };
  private Context c;
  private String d;
  private com.skplanet.tad.v2.content.a e;
  private com.skplanet.tad.v2.content.a f;
  private AdInterstitialListener g;
  private boolean h;
  private Dialog i;
  private boolean j;
  private int k = 1;
  private final Handler l = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.skplanet.tad.common.a.c("in AdIntersititialV2.handleMessage() msg : " + paramAnonymousMessage.what);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdClosed() will be called.");
      } while (b.a(b.this) == null);
      b.a(b.this).onAdClosed();
    }
  };
  private int m;
  
  public b(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private void e()
  {
    this.m = ((Activity)this.c).getRequestedOrientation();
    Activity localActivity = (Activity)this.c;
    if (this.c.getResources().getConfiguration().orientation == 1) {}
    for (int i1 = 1;; i1 = 0)
    {
      localActivity.setRequestedOrientation(i1);
      this.i = new Dialog(this.c);
      this.i.setCancelable(true);
      this.i.setContentView(new ProgressBar(this.c));
      this.i.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.i.show();
      return;
    }
  }
  
  private void f()
  {
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
    ((Activity)this.c).setRequestedOrientation(this.m);
  }
  
  public void a()
  {
    e();
    new com.skplanet.tad.v2.controller.b(this.c, this.a, true, this.j).execute(new String[] { this.d, null, null, null, null });
  }
  
  public void a(AdInterstitialListener paramAdInterstitialListener)
  {
    this.g = paramAdInterstitialListener;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void b()
  {
    if (!c())
    {
      com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed(SHOW_ERROR) will be called. There is no ad to show.");
      if (this.g != null) {
        this.g.onAdFailed(AdInterstitialListener.ErrorCode.SHOW_ERROR);
      }
      return;
    }
    if (this.f.n() == com.skplanet.tad.v2.content.a.a.c)
    {
      switch (d()[this.f.r().ordinal()])
      {
      }
      for (;;)
      {
        this.h = false;
        return;
        com.skplanet.tad.v2.controller.a.a(this.c, this.f.s(), this.l.obtainMessage(0));
        continue;
        com.skplanet.tad.v2.controller.a.a(this.c, this.f.o(), this.f.p(), this.d, this.f.s(), null, this.l.obtainMessage(0));
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("interstitial", true);
    localBundle.putString("action", AdActivity.a.b.toString());
    localBundle.putString("client_id", this.d);
    localBundle.putSerializable("image_ad.landing_type", this.f.r());
    localBundle.putString("image_ad.landing_url", this.f.s());
    localBundle.putString("image_ad.noti_url", this.f.a());
    localBundle.putString("image_ad.appstate", this.f.b());
    localBundle.putString("image_ad.res_id", this.f.e());
    localBundle.putString("image_ad.cate_id", this.f.c());
    localBundle.putInt("image_orientation", this.k);
    if (this.f.r() == com.skplanet.tad.v2.controller.a.a.e)
    {
      localBundle.putString("image_ad.cookie", this.f.o());
      localBundle.putString("btb.adsid", this.f.p());
      localBundle.putString("client_id", this.d);
    }
    AdActivity.a(this.l.obtainMessage(0));
    AdActivity.a(this.f.q());
    try
    {
      Intent localIntent = new Intent(this.c, AdActivity.class);
      localIntent.putExtras(localBundle);
      this.c.startActivity(localIntent);
      this.h = false;
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public boolean c()
  {
    return this.f != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */