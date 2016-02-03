package com.inmobi.monetization.internal;

import com.inmobi.monetization.internal.abstraction.IGetLtvpRuleRequestListener;
import com.inmobi.monetization.internal.abstraction.INativeAdController;
import com.inmobi.monetization.internal.abstraction.IServiceProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceProvider
  implements IServiceProvider
{
  private static ServiceProvider a;
  private ExecutorService b = Executors.newFixedThreadPool(15);
  
  public static ServiceProvider getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ServiceProvider();
      }
      return a;
    }
    finally {}
  }
  
  public void getLtvpRule(GetLtvpRulesRequest paramGetLtvpRulesRequest, IGetLtvpRuleRequestListener paramIGetLtvpRuleRequestListener)
  {
    this.b.execute(new GetLtvpRuleRequestTask(paramGetLtvpRulesRequest, paramIGetLtvpRuleRequestListener));
  }
  
  public void getNativeAd(NativeAdRequest paramNativeAdRequest, INativeAdController paramINativeAdController)
  {
    this.b.execute(new NativeAdRequestTask(paramNativeAdRequest, paramINativeAdController));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/ServiceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */