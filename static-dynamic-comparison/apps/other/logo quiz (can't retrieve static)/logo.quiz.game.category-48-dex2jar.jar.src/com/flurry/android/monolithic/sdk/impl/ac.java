package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.widget.RelativeLayout;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.List;
import java.util.Map;

public abstract class ac
  extends RelativeLayout
{
  private static final String a = ac.class.getSimpleName();
  FlurryAdModule b;
  m c;
  AdUnit d;
  int e;
  
  protected ac(Context paramContext)
  {
    super(paramContext);
  }
  
  public ac(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm)
  {
    super(paramContext);
    this.b = paramFlurryAdModule;
    this.c = paramm;
  }
  
  boolean e()
  {
    return !((AdFrame)this.d.d().get(this.e)).e().e().toString().equals("takeover");
  }
  
  public int getAdFrameIndex()
  {
    return this.e;
  }
  
  public m getAdLog()
  {
    return this.c;
  }
  
  public AdUnit getAdUnit()
  {
    return this.d;
  }
  
  public abstract void initLayout();
  
  public void onEvent(String paramString, Map<String, String> paramMap)
  {
    ja.a(3, a, "AppSpotBannerView.onEvent " + paramString);
    if (this.d != null)
    {
      this.b.a(new bh(paramString, paramMap, getContext(), this.d, this.c, this.e), this.b.a(), 0);
      return;
    }
    ja.a(3, a, "fAdUnit == null");
  }
  
  public void setAdFrameIndex(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setAdLog(m paramm)
  {
    this.c = paramm;
  }
  
  public void setAdUnit(AdUnit paramAdUnit)
  {
    this.d = paramAdUnit;
  }
  
  public void setPlatformModule(FlurryAdModule paramFlurryAdModule)
  {
    this.b = paramFlurryAdModule;
  }
  
  public void stop() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */