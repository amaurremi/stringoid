package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class be
  implements co
{
  static final String a = be.class.getSimpleName();
  private static final Map<String, co> b = a();
  
  private static co a(String paramString)
  {
    return (co)b.get(paramString);
  }
  
  private static String a(AdUnit paramAdUnit)
  {
    if (paramAdUnit == null) {
      return null;
    }
    Object localObject = paramAdUnit.d();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return null;
    }
    localObject = (AdFrame)((List)localObject).get(0);
    if (localObject == null) {
      return null;
    }
    int i = ((AdFrame)localObject).b().intValue();
    if ((paramAdUnit.e().intValue() == 1) || (i == 2) || (i == 1) || (i == 3)) {
      return "FLURRY";
    }
    if (i == 4) {
      return "THIRD_PARTY";
    }
    return null;
  }
  
  private static Map<String, co> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("FLURRY", new bg(null));
    localHashMap.put("THIRD_PARTY", new dd());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public cn a_(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdUnit == null)) {}
    String str;
    do
    {
      return null;
      str = a(paramAdUnit);
    } while (str == null);
    co localco = a(str);
    if (localco == null)
    {
      ja.e(a, "Cannot create ad takeover for type: " + str);
      return null;
    }
    ja.a(3, a, "Creating ad takeover for type: " + str);
    return localco.a_(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */