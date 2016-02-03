package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class de
  implements co
{
  private static final co a = new cs(a());
  
  private static Map<String, co> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Admob".toUpperCase(Locale.US), new df());
    localHashMap.put("Millennial Media".toUpperCase(Locale.US), new dw());
    localHashMap.put("InMobi".toUpperCase(Locale.US), new dm());
    localHashMap.put("Mobclix".toUpperCase(Locale.US), new eb());
    localHashMap.put("Jumptap".toUpperCase(Locale.US), new dr());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public cn a_(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    return a.a_(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */