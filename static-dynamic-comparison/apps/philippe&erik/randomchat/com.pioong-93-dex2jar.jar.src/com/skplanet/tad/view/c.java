package com.skplanet.tad.view;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ProgressBar;
import com.skplanet.tad.AdActivity;
import com.skplanet.tad.AdActivity.a;
import com.skplanet.tad.AdInterstitialListener;
import com.skplanet.tad.AdInterstitialListener.ErrorCode;
import com.skplanet.tad.content.AdContent;
import com.skplanet.tad.content.AdContent.AD_TYPE;
import com.skplanet.tad.controller.d;
import com.skplanet.tad.controller.d.a;
import com.skplanet.tad.controller.e;
import com.skplanet.tad.protocol.AdInAppResponse;
import com.skplanet.tad.protocol.AdInAppResponseRich;
import java.io.Serializable;
import java.util.HashMap;

public class c
{
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
        com.skplanet.tad.common.a.d("AdInterstitail.getWidth()");
      }
      return 0;
    }
    
    private void a(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
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
                      com.skplanet.tad.common.a.a("onAdFailed(NO_AD) will be called.");
                    } while (c.a(c.this) == null);
                    c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.NO_AD);
                    return;
                    com.skplanet.tad.common.a.a("onAdFailed(INTERNAL_ERROR) will be called.");
                  } while (c.a(c.this) == null);
                  c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.INTERNAL_ERROR);
                  return;
                  com.skplanet.tad.common.a.a("onAdFailed(INTERNAL_ERROR) will be called.");
                } while (c.a(c.this) == null);
                c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.INTERNAL_ERROR);
                return;
                com.skplanet.tad.common.a.a("onAdReceived() will be called.");
              } while (c.a(c.this) == null);
              c.a(c.this).onAdReceived();
              return;
              com.skplanet.tad.common.a.a("onAdFailed(CLIENTID_DENIED_ERROR) will be called.");
            } while (c.a(c.this) == null);
            c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.CLIENTID_DENIED_ERROR);
            return;
            com.skplanet.tad.common.a.a("onAdFailed(CLIENTID_DENIED_ERROR) will be called.");
          } while (c.a(c.this) == null);
          c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.INTERNAL_ERROR);
          return;
          com.skplanet.tad.common.a.a("onAdFailed(INVAILD_SLOT_NUMBER) will be called.");
        } while (c.a(c.this) == null);
        c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.INVAILD_SLOT_NUMBER);
        return;
        com.skplanet.tad.common.a.a("onAdFailed(INVAILD_SLOT_NUMBER) will be called.");
      } while (c.a(c.this) == null);
      c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.INTERNAL_ERROR);
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
        com.skplanet.tad.common.a.d("AdInterstitail.getHeight()");
      }
      return 0;
    }
    
    public void a(d.a paramAnonymousa)
    {
      com.skplanet.tad.common.a.a("interstitial ad is not downloaded.");
      c.b(c.this);
      com.skplanet.tad.common.a.a("onAdFailed() will be called.");
      if (c.a(c.this) != null) {
        c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.INTERNAL_ERROR);
      }
    }
    
    public void a(Object paramAnonymousObject)
    {
      int j = -1;
      c.b(c.this);
      AdInAppResponse localAdInAppResponse = (AdInAppResponse)paramAnonymousObject;
      if (localAdInAppResponse == null)
      {
        a(500);
        com.skplanet.tad.common.a.c("AdInterstitail.onFinished(), internal error, inAppResult == null");
      }
      for (;;)
      {
        return;
        if (TextUtils.isEmpty(localAdInAppResponse.ret_code))
        {
          a(500);
          com.skplanet.tad.common.a.c("AdInterstitail.onFinished(),internal error, inAppResult.ret_code == null");
          return;
        }
        try
        {
          i = Integer.parseInt(localAdInAppResponse.ret_code);
          a(i);
          if (i == 200) {
            if ((TextUtils.isEmpty(localAdInAppResponse.x_bypass)) || (TextUtils.isEmpty(localAdInAppResponse.c_type)) || (TextUtils.isEmpty(localAdInAppResponse.c_url)))
            {
              com.skplanet.tad.common.a.c("AdInterstitail.onFinished(), internal error, field error");
              a(500);
              return;
            }
          }
        }
        catch (NumberFormatException paramAnonymousObject)
        {
          a(500);
          com.skplanet.tad.common.a.d("AdInterstitail.onFinished(),NumberFormatException");
          return;
        }
      }
      String str1;
      String str2;
      try
      {
        i = Integer.parseInt(localAdInAppResponse.c_type);
        switch (i)
        {
        default: 
          com.skplanet.tad.common.a.c("[AdinterstitailV3]Not Defined c_type");
          a(500);
          return;
        }
      }
      catch (Exception paramAnonymousObject)
      {
        for (;;)
        {
          com.skplanet.tad.common.a.d("AdInterstitail.onFinished(),c_type, NumberFormatException");
          i = -1;
        }
        if (localAdInAppResponse.c_data == null)
        {
          com.skplanet.tad.common.a.c("AdInterstitail.onFinished(), internal error, inAppResult.c_data == null");
          a(500);
          return;
        }
        str1 = "utf-8";
        str2 = "-2147483648";
        if (TextUtils.isEmpty(localAdInAppResponse.c_data.resolution)) {
          break label697;
        }
      }
      j = a(localAdInAppResponse.c_data.resolution);
      int i = b(localAdInAppResponse.c_data.resolution);
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
          c.a(c.this, new com.skplanet.tad.content.a(j, i, (String)paramAnonymousObject, localAdInAppResponse.c_url));
          ((com.skplanet.tad.content.a)c.c(c.this)).d(str1);
          c.c(c.this).a(localAdInAppResponse.x_bypass);
          ((com.skplanet.tad.content.a)c.c(c.this)).e(str2);
          if (c.c(c.this) == null) {
            break;
          }
          com.skplanet.tad.common.a.a("AdInterstitialListener.onAdWillLoad() will be called. and received ad will be loaded.");
          if (c.a(c.this) != null) {
            c.a(c.this).onAdWillLoad();
          }
          c.a(c.this, new e(c.this.b, null));
          c.d(c.this).execute(new String[] { ((com.skplanet.tad.content.a)c.c(c.this)).f() });
          c.e(c.this);
          return;
          com.skplanet.tad.common.a.a("onAdWillLoad() will be called.");
          if (c.a(c.this) != null) {
            c.a(c.this).onAdWillLoad();
          }
          c.a(c.this, new com.skplanet.tad.content.c(localAdInAppResponse.c_url));
          com.skplanet.tad.common.a.a("onAdLoaded() will be called.");
          if (c.a(c.this) == null) {
            break;
          }
          c.a(c.this).onAdLoaded();
          return;
          com.skplanet.tad.common.a.a("onAdWillLoad() will be called.");
          if (c.a(c.this) != null) {
            c.a(c.this).onAdWillLoad();
          }
          c.a(c.this, new com.skplanet.tad.content.b(localAdInAppResponse.c_url));
          c.c(c.this).a(localAdInAppResponse.x_bypass);
          com.skplanet.tad.common.a.a("onAdLoaded() will be called.");
          if (c.a(c.this) == null) {
            break;
          }
          c.a(c.this).onAdLoaded();
          return;
        }
        label697:
        int k = -1;
        i = j;
        j = k;
      }
    }
  };
  public d b = new d()
  {
    public void a(d.a paramAnonymousa)
    {
      com.skplanet.tad.common.a.a("interstitial ad is not loaded.");
      c.b(c.this);
      switch (a()[paramAnonymousa.ordinal()])
      {
      }
      for (paramAnonymousa = AdInterstitialListener.ErrorCode.INTERNAL_ERROR;; paramAnonymousa = AdInterstitialListener.ErrorCode.NETWORK_ERROR)
      {
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed() will be called.");
        if (c.a(c.this) != null) {
          c.a(c.this).onAdFailed(paramAnonymousa);
        }
        return;
      }
    }
    
    public void a(Object paramAnonymousObject)
    {
      c.b(c.this);
      if (c.c(c.this) == null)
      {
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdFailed() will be called.");
        if (c.a(c.this) != null) {
          c.a(c.this).onAdFailed(AdInterstitialListener.ErrorCode.INTERNAL_ERROR);
        }
      }
      do
      {
        return;
        ((com.skplanet.tad.content.a)c.c(c.this)).c((String)paramAnonymousObject);
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdLoaded() will be called.");
      } while (c.a(c.this) == null);
      c.a(c.this).onAdLoaded();
    }
  };
  private Context c;
  private String d;
  private AdContent e;
  private AdInterstitialListener f;
  private int g;
  private boolean h;
  private boolean i = false;
  private Dialog j;
  private com.skplanet.tad.controller.a k;
  private e l;
  private final Handler m = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.skplanet.tad.common.a.c("in AdIntersititialV3.handleMessage() msg : " + paramAnonymousMessage.what);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        com.skplanet.tad.common.a.a("AdInterstitialListener.onAdClosed() will be called.");
      } while (c.a(c.this) == null);
      c.a(c.this).onAdClosed();
    }
  };
  
  public c(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private com.skplanet.tad.controller.b a(AdContent paramAdContent)
  {
    com.skplanet.tad.controller.b localb = new com.skplanet.tad.controller.b();
    localb.a = this.d;
    localb.c = paramAdContent.b();
    localb.b = this.g;
    return localb;
  }
  
  private void c()
  {
    this.j = new Dialog(this.c);
    this.j.setCancelable(true);
    this.j.setContentView(new ProgressBar(this.c));
    this.j.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.j.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        c.a(c.this, null);
        if (c.f(c.this) != null)
        {
          c.f(c.this).cancel(true);
          c.a(c.this, null);
        }
        if (c.d(c.this) != null)
        {
          c.d(c.this).cancel(true);
          c.a(c.this, null);
        }
      }
    });
    this.j.show();
  }
  
  private void d()
  {
    if ((this.j != null) && (this.j.isShowing()))
    {
      this.j.dismiss();
      this.j = null;
    }
  }
  
  public void a()
  {
    c();
    this.k = new com.skplanet.tad.controller.a(this.c, this.a, this.d, "3", this.h);
    this.k.execute(new String[] { "" });
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(AdInterstitialListener paramAdInterstitialListener)
  {
    this.f = paramAdInterstitialListener;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b()
  {
    Object localObject1 = a(this.e);
    new Thread(new com.skplanet.tad.controller.c(this.c, 0, (com.skplanet.tad.controller.b)localObject1)).start();
    if ((this.e == null) || (this.e.a() == null)) {
      com.skplanet.tad.common.a.d("AdIntersititialV3.show(), mDownloadedAd is null, mDownloadedAd.getAdType() is null");
    }
    do
    {
      return;
      if (this.e.a() == AdContent.AD_TYPE.VIDEO)
      {
        com.skplanet.tad.v2.controller.a.a(this.c, this.e.c(), this.m.obtainMessage(0));
        return;
      }
      if (this.e.a() == AdContent.AD_TYPE.PLAYER)
      {
        com.skplanet.tad.v2.controller.a.a(this.c, com.skplanet.tad.common.b.a(this.c).f, this.e.b(), this.d, this.e.c(), this.g, this.m.obtainMessage(0));
        return;
      }
    } while (this.e.a() != AdContent.AD_TYPE.MRAID);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("interstitial", true);
    ((Bundle)localObject1).putString("action", AdActivity.a.a.toString());
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("client_id", this.d);
    ((HashMap)localObject2).put("ad_bypass", this.e.b());
    ((HashMap)localObject2).put("slot_num", this.g);
    ((Bundle)localObject1).putSerializable("ad.event_params", (Serializable)localObject2);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("mraid_ad.content.base_url", ((com.skplanet.tad.content.a)this.e).d());
    ((HashMap)localObject2).put("mraid_ad.content.html", ((com.skplanet.tad.content.a)this.e).e());
    ((HashMap)localObject2).put("mraid_ad.content.width_dip", ((com.skplanet.tad.content.a)this.e).h());
    ((HashMap)localObject2).put("mraid_ad.content.height_dip", ((com.skplanet.tad.content.a)this.e).i());
    if (this.i) {
      ((HashMap)localObject2).put("mraid_ad.backfill_color", ((com.skplanet.tad.content.a)this.e).j());
    }
    ((Bundle)localObject1).putSerializable("mraid_ad.content", (Serializable)localObject2);
    if (this.m != null) {
      AdActivity.a(this.m.obtainMessage(0));
    }
    try
    {
      localObject2 = new Intent(this.c, AdActivity.class);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      this.c.startActivity((Intent)localObject2);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      d();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */