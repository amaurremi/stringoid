package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Map;

public abstract class cr
  extends cn
{
  private static final String b = cr.class.getSimpleName();
  
  public cr(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    ja.a(3, b, "onEvent: " + paramString);
    if (e() != null)
    {
      c().a(new bh(paramString, paramMap, b(), e(), d(), 0), c().a(), 0);
      return;
    }
    ja.a(3, b, "adUnit == null");
  }
  
  public void a(Map<String, String> paramMap)
  {
    a("rendered", paramMap);
  }
  
  public void b(Map<String, String> paramMap)
  {
    a("clicked", paramMap);
  }
  
  public void c(Map<String, String> paramMap)
  {
    a("adClosed", paramMap);
  }
  
  public void d(Map<String, String> paramMap)
  {
    a("renderFailed", paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */