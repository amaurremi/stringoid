package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class cs
  implements co
{
  private static final String a = cs.class.getSimpleName();
  private final Map<String, co> b;
  
  public cs(Map<String, co> paramMap)
  {
    this.b = paramMap;
  }
  
  private co a(String paramString)
  {
    co localco = null;
    if (this.b != null) {
      localco = (co)this.b.get(paramString.toUpperCase(Locale.US));
    }
    return localco;
  }
  
  public cn a_(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdUnit == null)) {
      paramContext = null;
    }
    Object localObject;
    do
    {
      return paramContext;
      localObject = paramAdUnit.d();
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
      co localco = a((String)localObject);
      if (localco == null) {
        return null;
      }
      ja.a(3, a, "Creating ad network takeover launcher: " + localco.getClass().getSimpleName() + " for type: " + (String)localObject);
      paramFlurryAdModule = localco.a_(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
      paramContext = paramFlurryAdModule;
    } while (paramFlurryAdModule != null);
    ja.b(a, "Cannot create ad network takeover launcher for type: " + (String)localObject);
    return paramFlurryAdModule;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */