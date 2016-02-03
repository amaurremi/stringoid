package com.flurry.android;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.monolithic.sdk.impl.ac;
import com.flurry.android.monolithic.sdk.impl.m;
import java.util.Map;

public abstract class AdNetworkView
  extends ac
{
  private final AdCreative a;
  
  public AdNetworkView(Context paramContext, AdCreative paramAdCreative)
  {
    super(paramContext, null, null);
    this.a = paramAdCreative;
  }
  
  public AdNetworkView(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative)
  {
    super(paramContext, paramFlurryAdModule, paramm);
    this.a = paramAdCreative;
  }
  
  public AdCreative getAdCreative()
  {
    return this.a;
  }
  
  public void onAdClicked(Map<String, String> paramMap)
  {
    super.onEvent("clicked", paramMap);
  }
  
  public void onAdClosed(Map<String, String> paramMap)
  {
    super.onEvent("adClosed", paramMap);
  }
  
  public void onAdFilled(Map<String, String> paramMap)
  {
    super.onEvent("filled", paramMap);
  }
  
  public void onAdShown(Map<String, String> paramMap)
  {
    super.onEvent("rendered", paramMap);
  }
  
  public void onAdUnFilled(Map<String, String> paramMap)
  {
    super.onEvent("unfilled", paramMap);
  }
  
  public void onRenderFailed(Map<String, String> paramMap)
  {
    super.onEvent("renderFailed", paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/AdNetworkView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */