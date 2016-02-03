package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class dc
  implements am
{
  private static final String a = dc.class.getSimpleName();
  private static final Map<String, am> b = a();
  
  private static am a(String paramString)
  {
    return (am)b.get(paramString);
  }
  
  private static Map<String, am> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Admob".toUpperCase(Locale.US), new df());
    localHashMap.put("Millennial Media".toUpperCase(Locale.US), new dw());
    localHashMap.put("InMobi".toUpperCase(Locale.US), new dm());
    localHashMap.put("Mobclix".toUpperCase(Locale.US), new eb());
    localHashMap.put("Jumptap".toUpperCase(Locale.US), new dr());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public ac a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdUnit == null)) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      Object localObject = paramAdUnit.d();
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        return null;
      }
      localObject = (AdFrame)((List)localObject).get(0);
      if (localObject == null) {
        return null;
      }
      localObject = ((AdFrame)localObject).d().toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      am localam = a(((String)localObject).toUpperCase(Locale.US));
      if (localam == null) {
        return null;
      }
      ja.a(3, a, "Creating ad network view for type: " + (String)localObject);
      paramFlurryAdModule = localam.a(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
      if (paramFlurryAdModule == null)
      {
        ja.b(a, "Cannot create ad network view for type: " + (String)localObject);
        return null;
      }
      paramContext = paramFlurryAdModule;
    } while (paramFlurryAdModule == null);
    paramFlurryAdModule.setAdUnit(paramAdUnit);
    return paramFlurryAdModule;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */