package org.a.a;

import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.a.a.d.b;
import org.a.a.d.t;
import org.a.a.e.h;
import org.a.a.e.j;
import org.a.a.e.k;
import org.a.a.e.l;
import org.a.a.e.m;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public abstract class i
  implements Serializable
{
  public static final i a = new org.a.a.e.i("UTC", "UTC", 0, 0);
  private static k b;
  private static j c;
  private static Set<String> d;
  private static volatile i e;
  private static b f;
  private static Map<String, SoftReference<i>> g;
  private static Map<String, String> h;
  private final String i;
  
  static
  {
    a(null);
    a(null);
  }
  
  protected i(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Id must not be null");
    }
    this.i = paramString;
  }
  
  public static i a()
  {
    Object localObject1 = e;
    if (localObject1 == null)
    {
      for (;;)
      {
        Object localObject4;
        i locali;
        String str;
        try
        {
          localObject4 = e;
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            locali = null;
            localObject4 = null;
            localObject1 = locali;
          }
        }
        finally {}
        try
        {
          str = System.getProperty("user.timezone");
          localObject1 = localObject4;
          if (str != null)
          {
            localObject1 = locali;
            locali = a(str);
            localObject1 = locali;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject5 = localObject2;
        }
        catch (RuntimeException localRuntimeException)
        {
          Object localObject5;
          localObject3 = localObject5;
        }
      }
      localObject4 = localObject1;
      if (localObject1 == null) {
        localObject4 = a(TimeZone.getDefault());
      }
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = a;
      }
      e = (i)localObject1;
      return (i)localObject1;
    }
    Object localObject3;
    return (i)localObject3;
  }
  
  public static i a(int paramInt)
  {
    return a(b(paramInt), paramInt);
  }
  
  @FromString
  public static i a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = a();
    }
    i locali;
    do
    {
      return (i)localObject;
      if (paramString.equals("UTC")) {
        return a;
      }
      locali = b.a(paramString);
      localObject = locali;
    } while (locali != null);
    if ((paramString.startsWith("+")) || (paramString.startsWith("-")))
    {
      int j = c(paramString);
      if (j == 0L) {
        return a;
      }
      return a(b(j), j);
    }
    throw new IllegalArgumentException("The datetime zone id '" + paramString + "' is not recognised");
  }
  
  private static i a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject = a;
        return (i)localObject;
      }
      finally {}
      if (g == null) {
        g = new HashMap();
      }
      Object localObject = (Reference)g.get(paramString);
      if (localObject != null)
      {
        i locali = (i)((Reference)localObject).get();
        localObject = locali;
        if (locali != null) {}
      }
      else
      {
        localObject = new org.a.a.e.i(paramString, null, paramInt, paramInt);
        g.put(paramString, new SoftReference(localObject));
      }
    }
  }
  
  public static i a(TimeZone paramTimeZone)
  {
    Object localObject2;
    if (paramTimeZone == null) {
      localObject2 = a();
    }
    String str1;
    String str2;
    Object localObject1;
    do
    {
      return (i)localObject2;
      str1 = paramTimeZone.getID();
      if (str1.equals("UTC")) {
        return a;
      }
      localObject2 = null;
      str2 = b(str1);
      if (str2 != null) {
        localObject2 = b.a(str2);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = b.a(str1);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    if (str2 == null)
    {
      paramTimeZone = paramTimeZone.getID();
      if ((paramTimeZone.startsWith("GMT+")) || (paramTimeZone.startsWith("GMT-")))
      {
        int j = c(paramTimeZone.substring(3));
        if (j == 0L) {
          return a;
        }
        return a(b(j), j);
      }
    }
    throw new IllegalArgumentException("The datetime zone id '" + str1 + "' is not recognised");
  }
  
  private static void a(j paramj)
  {
    j localj = paramj;
    if (paramj == null) {
      localj = f();
    }
    c = localj;
  }
  
  private static void a(k paramk)
  {
    k localk = paramk;
    if (paramk == null) {
      localk = e();
    }
    paramk = localk.a();
    if ((paramk == null) || (paramk.size() == 0)) {
      throw new IllegalArgumentException("The provider doesn't have any available ids");
    }
    if (!paramk.contains("UTC")) {
      throw new IllegalArgumentException("The provider doesn't support UTC");
    }
    if (!a.equals(localk.a("UTC"))) {
      throw new IllegalArgumentException("Invalid UTC zone provided");
    }
    b = localk;
    d = paramk;
  }
  
  private static String b(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt >= 0) {
      localStringBuffer.append('+');
    }
    for (;;)
    {
      j = paramInt / 3600000;
      t.a(localStringBuffer, j, 2);
      paramInt -= j * 3600000;
      j = paramInt / 60000;
      localStringBuffer.append(':');
      t.a(localStringBuffer, j, 2);
      paramInt -= j * 60000;
      if (paramInt != 0) {
        break;
      }
      return localStringBuffer.toString();
      localStringBuffer.append('-');
      paramInt = -paramInt;
    }
    int j = paramInt / 1000;
    localStringBuffer.append(':');
    t.a(localStringBuffer, j, 2);
    paramInt -= j * 1000;
    if (paramInt == 0) {
      return localStringBuffer.toString();
    }
    localStringBuffer.append('.');
    t.a(localStringBuffer, paramInt, 3);
    return localStringBuffer.toString();
  }
  
  private static String b(String paramString)
  {
    try
    {
      Map localMap = h;
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        ((Map)localObject).put("GMT", "UTC");
        ((Map)localObject).put("WET", "WET");
        ((Map)localObject).put("CET", "CET");
        ((Map)localObject).put("MET", "CET");
        ((Map)localObject).put("ECT", "CET");
        ((Map)localObject).put("EET", "EET");
        ((Map)localObject).put("MIT", "Pacific/Apia");
        ((Map)localObject).put("HST", "Pacific/Honolulu");
        ((Map)localObject).put("AST", "America/Anchorage");
        ((Map)localObject).put("PST", "America/Los_Angeles");
        ((Map)localObject).put("MST", "America/Denver");
        ((Map)localObject).put("PNT", "America/Phoenix");
        ((Map)localObject).put("CST", "America/Chicago");
        ((Map)localObject).put("EST", "America/New_York");
        ((Map)localObject).put("IET", "America/Indiana/Indianapolis");
        ((Map)localObject).put("PRT", "America/Puerto_Rico");
        ((Map)localObject).put("CNT", "America/St_Johns");
        ((Map)localObject).put("AGT", "America/Argentina/Buenos_Aires");
        ((Map)localObject).put("BET", "America/Sao_Paulo");
        ((Map)localObject).put("ART", "Africa/Cairo");
        ((Map)localObject).put("CAT", "Africa/Harare");
        ((Map)localObject).put("EAT", "Africa/Addis_Ababa");
        ((Map)localObject).put("NET", "Asia/Yerevan");
        ((Map)localObject).put("PLT", "Asia/Karachi");
        ((Map)localObject).put("IST", "Asia/Kolkata");
        ((Map)localObject).put("BST", "Asia/Dhaka");
        ((Map)localObject).put("VST", "Asia/Ho_Chi_Minh");
        ((Map)localObject).put("CTT", "Asia/Shanghai");
        ((Map)localObject).put("JST", "Asia/Tokyo");
        ((Map)localObject).put("ACT", "Australia/Darwin");
        ((Map)localObject).put("AET", "Australia/Sydney");
        ((Map)localObject).put("SST", "Pacific/Guadalcanal");
        ((Map)localObject).put("NST", "Pacific/Auckland");
        h = (Map)localObject;
      }
      paramString = (String)((Map)localObject).get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public static Set<String> b()
  {
    return d;
  }
  
  private static int c(String paramString)
  {
    org.a.a.b.c local1 = new org.a.a.b.c()
    {
      public a a(i paramAnonymousi)
      {
        return this;
      }
      
      public i a()
      {
        return null;
      }
      
      public a b()
      {
        return this;
      }
      
      public String toString()
      {
        return getClass().getName();
      }
    };
    return -(int)g().a(local1).a(paramString);
  }
  
  private static k e()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = System.getProperty("org.joda.time.DateTimeZone.Provider");
        if (localObject2 == null) {
          continue;
        }
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject2;
        Thread localThread;
        continue;
      }
      try
      {
        localObject2 = (k)Class.forName((String)localObject2).newInstance();
        localObject1 = localObject2;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = new m("org/joda/time/tz/data");
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new l();
          }
          return (k)localObject2;
        }
        catch (Exception localException2)
        {
          localThread = Thread.currentThread();
          localThread.getThreadGroup().uncaughtException(localThread, localException2);
        }
        localException1 = localException1;
        localThread = Thread.currentThread();
        localThread.getThreadGroup().uncaughtException(localThread, localException1);
      }
    }
  }
  
  private static j f()
  {
    for (;;)
    {
      try
      {
        localObject1 = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
        if (localObject1 == null) {
          continue;
        }
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject1;
        Object localObject4;
        Object localObject2;
        Object localObject3 = null;
        continue;
      }
      try
      {
        localObject1 = (j)Class.forName((String)localObject1).newInstance();
        localObject4 = localObject1;
        if (localObject1 == null) {
          localObject4 = new h();
        }
        return (j)localObject4;
      }
      catch (Exception localException)
      {
        localObject4 = Thread.currentThread();
        ((Thread)localObject4).getThreadGroup().uncaughtException((Thread)localObject4, localException);
      }
      localObject2 = null;
    }
  }
  
  private static b g()
  {
    try
    {
      if (f == null) {
        f = new org.a.a.d.c().a(null, true, 2, 4).a();
      }
      b localb = f;
      return localb;
    }
    finally {}
  }
  
  public long a(long paramLong, boolean paramBoolean)
  {
    long l2 = Long.MAX_VALUE;
    int j = b(paramLong);
    int k = b(paramLong - j);
    long l3;
    long l1;
    if ((j != k) && ((paramBoolean) || (j < 0)))
    {
      l3 = e(paramLong - j);
      l1 = l3;
      if (l3 == paramLong - j) {
        l1 = Long.MAX_VALUE;
      }
      l3 = e(paramLong - k);
      if (l3 != paramLong - k) {
        break label164;
      }
    }
    for (;;)
    {
      if (l1 != l2) {
        if (paramBoolean) {
          throw new n(paramLong, c());
        }
      }
      for (;;)
      {
        l1 = paramLong - j;
        if (((paramLong ^ l1) < 0L) && ((j ^ paramLong) < 0L)) {
          throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }
        return l1;
        j = k;
      }
      label164:
      l2 = l3;
    }
  }
  
  public long a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    int j = b(paramLong2);
    paramLong2 = paramLong1 - j;
    if (b(paramLong2) == j) {
      return paramLong2;
    }
    return a(paramLong1, paramBoolean);
  }
  
  public abstract String a(long paramLong);
  
  public String a(long paramLong, Locale paramLocale)
  {
    Object localObject = paramLocale;
    if (paramLocale == null) {
      localObject = Locale.getDefault();
    }
    paramLocale = a(paramLong);
    if (paramLocale == null) {
      paramLocale = this.i;
    }
    do
    {
      return paramLocale;
      localObject = c.a((Locale)localObject, this.i, paramLocale);
      paramLocale = (Locale)localObject;
    } while (localObject != null);
    return b(b(paramLong));
  }
  
  public abstract int b(long paramLong);
  
  public String b(long paramLong, Locale paramLocale)
  {
    Object localObject = paramLocale;
    if (paramLocale == null) {
      localObject = Locale.getDefault();
    }
    paramLocale = a(paramLong);
    if (paramLocale == null) {
      paramLocale = this.i;
    }
    do
    {
      return paramLocale;
      localObject = c.b((Locale)localObject, this.i, paramLocale);
      paramLocale = (Locale)localObject;
    } while (localObject != null);
    return b(b(paramLong));
  }
  
  public int c(long paramLong)
  {
    int j = b(paramLong);
    long l = paramLong - j;
    int k = b(l);
    if (j != k)
    {
      if ((j - k < 0) && (e(l) != e(paramLong - k))) {
        return j;
      }
    }
    else if (j >= 0)
    {
      paramLong = f(l);
      if (paramLong < l)
      {
        int m = b(paramLong);
        if (l - paramLong <= m - j) {
          return m;
        }
      }
    }
    return k;
  }
  
  @ToString
  public final String c()
  {
    return this.i;
  }
  
  public long d(long paramLong)
  {
    int j = b(paramLong);
    long l = j + paramLong;
    if (((paramLong ^ l) < 0L) && ((j ^ paramLong) >= 0L)) {
      throw new ArithmeticException("Adding time zone offset caused overflow");
    }
    return l;
  }
  
  public abstract boolean d();
  
  public abstract long e(long paramLong);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract long f(long paramLong);
  
  public int hashCode()
  {
    return c().hashCode() + 57;
  }
  
  public String toString()
  {
    return c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */