package com.flurry.android.impl.analytics;

import android.content.Context;
import com.flurry.sdk.dd;
import com.flurry.sdk.dj;
import com.flurry.sdk.et;

public class FlurryAnalyticsModule
  implements et
{
  private static FlurryAnalyticsModule a;
  private dd b;
  
  public static FlurryAnalyticsModule getInstance()
  {
    try
    {
      if (a == null) {
        a = new FlurryAnalyticsModule();
      }
      FlurryAnalyticsModule localFlurryAnalyticsModule = a;
      return localFlurryAnalyticsModule;
    }
    finally {}
  }
  
  public dd a()
  {
    return this.b;
  }
  
  public void a(dj paramdj) {}
  
  public void a(dj paramdj, Context paramContext)
  {
    if (this.b == null) {
      this.b = new dd();
    }
  }
  
  public void b(dj paramdj, Context paramContext) {}
  
  public void c(dj paramdj, Context paramContext) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/android/impl/analytics/FlurryAnalyticsModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */