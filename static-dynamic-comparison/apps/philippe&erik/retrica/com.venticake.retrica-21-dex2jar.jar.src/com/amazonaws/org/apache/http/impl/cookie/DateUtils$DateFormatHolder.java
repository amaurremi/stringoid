package com.amazonaws.org.apache.http.impl.cookie;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

final class DateUtils$DateFormatHolder
{
  private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal()
  {
    protected SoftReference<Map<String, SimpleDateFormat>> initialValue()
    {
      return new SoftReference(new HashMap());
    }
  };
  
  public static SimpleDateFormat formatFor(String paramString)
  {
    Object localObject = (Map)((SoftReference)THREADLOCAL_FORMATS.get()).get();
    if (localObject == null)
    {
      localObject = new HashMap();
      THREADLOCAL_FORMATS.set(new SoftReference(localObject));
    }
    for (;;)
    {
      SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)((Map)localObject).get(paramString);
      SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
      if (localSimpleDateFormat2 == null)
      {
        localSimpleDateFormat1 = new SimpleDateFormat(paramString, Locale.US);
        localSimpleDateFormat1.setTimeZone(TimeZone.getTimeZone("GMT"));
        ((Map)localObject).put(paramString, localSimpleDateFormat1);
      }
      return localSimpleDateFormat1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/DateUtils$DateFormatHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */