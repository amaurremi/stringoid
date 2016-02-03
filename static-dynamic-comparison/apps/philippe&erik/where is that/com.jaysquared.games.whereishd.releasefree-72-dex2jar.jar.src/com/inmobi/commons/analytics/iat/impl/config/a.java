package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.cache.CacheController.Validator;
import java.util.Map;

final class a
  implements CacheController.Validator
{
  public boolean validate(Map<String, Object> paramMap)
  {
    return AdTrackerInitializer.a(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/config/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */