package org.a.a;

import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.a.a.b.t;

public class f
{
  private static final h a = new h();
  private static volatile g b = a;
  private static volatile Map<String, i> c;
  
  static
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("UT", i.a);
    localLinkedHashMap.put("UTC", i.a);
    localLinkedHashMap.put("GMT", i.a);
    a(localLinkedHashMap, "EST", "America/New_York");
    a(localLinkedHashMap, "EDT", "America/New_York");
    a(localLinkedHashMap, "CST", "America/Chicago");
    a(localLinkedHashMap, "CDT", "America/Chicago");
    a(localLinkedHashMap, "MST", "America/Denver");
    a(localLinkedHashMap, "MDT", "America/Denver");
    a(localLinkedHashMap, "PST", "America/Los_Angeles");
    a(localLinkedHashMap, "PDT", "America/Los_Angeles");
    c = Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public static final long a()
  {
    return b.a();
  }
  
  public static final long a(u paramu)
  {
    if (paramu == null) {
      return a();
    }
    return paramu.a();
  }
  
  public static final DateFormatSymbols a(Locale paramLocale)
  {
    try
    {
      DateFormatSymbols localDateFormatSymbols = (DateFormatSymbols)DateFormatSymbols.class.getMethod("getInstance", new Class[] { Locale.class }).invoke(null, new Object[] { paramLocale });
      return localDateFormatSymbols;
    }
    catch (Exception localException) {}
    return new DateFormatSymbols(paramLocale);
  }
  
  public static final a a(a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = t.O();
    }
    return (a)localObject;
  }
  
  private static void a(Map<String, i> paramMap, String paramString1, String paramString2)
  {
    try
    {
      paramMap.put(paramString1, i.a(paramString2));
      return;
    }
    catch (RuntimeException paramMap) {}
  }
  
  public static final Map<String, i> b()
  {
    return c;
  }
  
  public static final a b(u paramu)
  {
    if (paramu == null) {
      paramu = t.O();
    }
    a locala;
    do
    {
      return paramu;
      locala = paramu.b();
      paramu = locala;
    } while (locala != null);
    return t.O();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */