package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class z
  implements k
{
  private static final Map<String, k> ac;
  private static final String d = z.class.getSimpleName();
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Admob".toUpperCase(Locale.US), new da());
    localHashMap.put("Millennial Media".toUpperCase(Locale.US), new cd());
    localHashMap.put("InMobi".toUpperCase(Locale.US), new b());
    localHashMap.put("Mobclix".toUpperCase(Locale.US), new al());
    localHashMap.put("Jumptap".toUpperCase(Locale.US), new be());
    ac = Collections.unmodifiableMap(localHashMap);
  }
  
  public final p b(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAds == null) || (paramcz == null) || (paramAdUnit == null)) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      Object localObject1 = paramAdUnit.getAdFrames();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        return null;
      }
      localObject1 = (AdFrame)((List)localObject1).get(0);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((AdFrame)localObject1).getContent().toString();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      Object localObject2 = ((String)localObject1).toUpperCase(Locale.US);
      localObject2 = (k)ac.get(localObject2);
      if (localObject2 == null)
      {
        db.g(d, "Cannot create ad network view for type: " + (String)localObject1);
        return null;
      }
      new StringBuilder().append("Creating ad network view for type: ").append((String)localObject1).toString();
      paramFlurryAds = ((k)localObject2).b(paramContext, paramFlurryAds, paramcz, paramAdUnit);
      if (paramFlurryAds == null)
      {
        db.d(d, "Cannot create ad network view for type: " + (String)localObject1);
        return null;
      }
      paramContext = paramFlurryAds;
    } while (paramFlurryAds == null);
    paramFlurryAds.M = paramAdUnit;
    return paramFlurryAds;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */