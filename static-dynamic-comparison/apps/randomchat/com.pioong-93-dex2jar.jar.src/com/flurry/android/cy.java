package com.flurry.android;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class cy
  implements bq
{
  private static final bq fa;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Admob".toUpperCase(Locale.US), new da());
    localHashMap.put("Millennial Media".toUpperCase(Locale.US), new cd());
    localHashMap.put("InMobi".toUpperCase(Locale.US), new b());
    localHashMap.put("Mobclix".toUpperCase(Locale.US), new al());
    localHashMap.put("Jumptap".toUpperCase(Locale.US), new be());
    fa = new bb(Collections.unmodifiableMap(localHashMap));
  }
  
  public final ao a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    return fa.a(paramContext, paramFlurryAds, paramcz, paramAdUnit);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */