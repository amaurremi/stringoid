package com.google.analytics.tracking.android;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HitBuilder
{
  public static String encode(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError("URL encoding failed for: " + paramString);
    }
  }
  
  public static Map<String, String> generateHitParams(MetaModel paramMetaModel, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      MetaModel.MetaInfo localMetaInfo = paramMetaModel.getMetaInfo((String)paramMap.getKey());
      if (localMetaInfo != null)
      {
        String str2 = localMetaInfo.getUrlParam((String)paramMap.getKey());
        if (str2 != null)
        {
          String str1 = (String)paramMap.getValue();
          paramMap = str1;
          if (localMetaInfo.getFormatter() != null) {
            paramMap = localMetaInfo.getFormatter().format(str1);
          }
          if ((paramMap != null) && (!paramMap.equals(localMetaInfo.getDefaultValue()))) {
            localHashMap.put(str2, paramMap);
          }
        }
      }
    }
    return localHashMap;
  }
  
  static String postProcessHit(Hit paramHit, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHit.getHitParams());
    if (paramHit.getHitTime() > 0L)
    {
      paramLong -= paramHit.getHitTime();
      if (paramLong >= 0L) {
        localStringBuilder.append("&").append("qt").append("=").append(paramLong);
      }
    }
    localStringBuilder.append("&").append("z").append("=").append(paramHit.getHitId());
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/HitBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */