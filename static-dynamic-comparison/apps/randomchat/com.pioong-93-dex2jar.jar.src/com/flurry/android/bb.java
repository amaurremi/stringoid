package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class bb
  implements bq
{
  private static final String d = bb.class.getSimpleName();
  private final Map<String, bq> cq;
  
  public bb(Map<String, bq> paramMap)
  {
    this.cq = paramMap;
  }
  
  public final ao a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAds == null) || (paramcz == null) || (paramAdUnit == null))
    {
      paramContext = null;
      return paramContext;
    }
    Object localObject = paramAdUnit.getAdFrames();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return null;
    }
    localObject = (AdFrame)((List)localObject).get(0);
    if (localObject == null) {
      return null;
    }
    String str = ((AdFrame)localObject).getContent().toString();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (this.cq != null) {}
    for (localObject = (bq)this.cq.get(str.toUpperCase(Locale.US));; localObject = null)
    {
      if (localObject == null) {
        return null;
      }
      new StringBuilder().append("Creating ad network takeover launcher: ").append(localObject.getClass().getSimpleName()).append(" for type: ").append(str).toString();
      paramFlurryAds = ((bq)localObject).a(paramContext, paramFlurryAds, paramcz, paramAdUnit);
      paramContext = paramFlurryAds;
      if (paramFlurryAds != null) {
        break;
      }
      db.d(d, "Cannot create ad network takeover launcher for type: " + str);
      return paramFlurryAds;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */