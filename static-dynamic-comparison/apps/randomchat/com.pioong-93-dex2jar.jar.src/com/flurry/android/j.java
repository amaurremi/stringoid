package com.flurry.android;

import android.content.Context;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class j
  implements k
{
  private static String d = j.class.getSimpleName();
  private static final Map<String, k> v;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("FLURRY", new t());
    localHashMap.put("THIRD_PARTY", new z());
    v = Collections.unmodifiableMap(localHashMap);
  }
  
  public final p b(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAds == null) || (paramcz == null) || (paramAdUnit == null)) {
      return null;
    }
    Object localObject;
    if (paramAdUnit != null)
    {
      localObject = paramAdUnit.getAdFrames();
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        localObject = null;
      }
    }
    while (localObject == null)
    {
      return null;
      localObject = (AdFrame)((List)localObject).get(0);
      if (localObject != null)
      {
        int i = ((AdFrame)localObject).getBinding().intValue();
        if ((paramAdUnit.getCombinable().intValue() == 1) || (i == 2) || (i == 1) || (i == 3))
        {
          localObject = "FLURRY";
          continue;
        }
        if (i == 4)
        {
          localObject = "THIRD_PARTY";
          continue;
        }
      }
      localObject = null;
    }
    k localk = (k)v.get(localObject);
    if (localk == null)
    {
      Log.w(d, "Cannot create ad banner for type: " + (String)localObject);
      return null;
    }
    new StringBuilder().append("Creating ad banner for type: ").append((String)localObject).toString();
    return localk.b(paramContext, paramFlurryAds, paramcz, paramAdUnit);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */