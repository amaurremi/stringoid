package org.a.a.b;

import java.lang.ref.WeakReference;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TreeMap;
import java.util.WeakHashMap;
import org.a.a.d;
import org.a.a.f;
import org.a.a.m;

class p
{
  private static final p[] a = new p[64];
  private static WeakHashMap<Locale, p> b = new WeakHashMap();
  private final WeakReference<Locale> c;
  private final String[] d;
  private final String[] e;
  private final String[] f;
  private final String[] g;
  private final String[] h;
  private final String[] i;
  private final TreeMap<String, Integer> j;
  private final TreeMap<String, Integer> k;
  private final TreeMap<String, Integer> l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  
  private p(Locale paramLocale)
  {
    this.c = new WeakReference(paramLocale);
    Object localObject = f.a(paramLocale);
    this.d = ((DateFormatSymbols)localObject).getEras();
    this.e = b(((DateFormatSymbols)localObject).getWeekdays());
    this.f = b(((DateFormatSymbols)localObject).getShortWeekdays());
    this.g = a(((DateFormatSymbols)localObject).getMonths());
    this.h = a(((DateFormatSymbols)localObject).getShortMonths());
    this.i = ((DateFormatSymbols)localObject).getAmPmStrings();
    localObject = new Integer[13];
    int i1 = 0;
    while (i1 < 13)
    {
      localObject[i1] = Integer.valueOf(i1);
      i1 += 1;
    }
    this.j = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    a(this.j, this.d, (Integer[])localObject);
    if ("en".equals(paramLocale.getLanguage()))
    {
      this.j.put("BCE", localObject[0]);
      this.j.put("CE", localObject[1]);
    }
    this.k = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    a(this.k, this.e, (Integer[])localObject);
    a(this.k, this.f, (Integer[])localObject);
    a(this.k, 1, 7, (Integer[])localObject);
    this.l = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    a(this.l, this.g, (Integer[])localObject);
    a(this.l, this.h, (Integer[])localObject);
    a(this.l, 1, 12, (Integer[])localObject);
    this.m = c(this.d);
    this.n = c(this.e);
    this.o = c(this.f);
    this.p = c(this.g);
    this.q = c(this.h);
    this.r = c(this.i);
  }
  
  public static p a(Locale paramLocale)
  {
    Locale localLocale = paramLocale;
    if (paramLocale == null) {
      localLocale = Locale.getDefault();
    }
    int i1 = System.identityHashCode(localLocale) & 0x3F;
    paramLocale = a[i1];
    if ((paramLocale != null) && (paramLocale.c.get() == localLocale)) {
      return paramLocale;
    }
    synchronized (b)
    {
      p localp = (p)b.get(localLocale);
      paramLocale = localp;
      if (localp == null)
      {
        paramLocale = new p(localLocale);
        b.put(localLocale, paramLocale);
      }
      a[i1] = paramLocale;
      return paramLocale;
    }
  }
  
  private static void a(TreeMap<String, Integer> paramTreeMap, int paramInt1, int paramInt2, Integer[] paramArrayOfInteger)
  {
    while (paramInt1 <= paramInt2)
    {
      paramTreeMap.put(String.valueOf(paramInt1).intern(), paramArrayOfInteger[paramInt1]);
      paramInt1 += 1;
    }
  }
  
  private static void a(TreeMap<String, Integer> paramTreeMap, String[] paramArrayOfString, Integer[] paramArrayOfInteger)
  {
    int i1 = paramArrayOfString.length;
    for (;;)
    {
      int i2 = i1 - 1;
      if (i2 < 0) {
        break;
      }
      String str = paramArrayOfString[i2];
      i1 = i2;
      if (str != null)
      {
        paramTreeMap.put(str, paramArrayOfInteger[i2]);
        i1 = i2;
      }
    }
  }
  
  private static String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[13];
    int i1 = 1;
    while (i1 < 13)
    {
      arrayOfString[i1] = paramArrayOfString[(i1 - 1)];
      i1 += 1;
    }
    return arrayOfString;
  }
  
  private static String[] b(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[8];
    int i1 = 1;
    if (i1 < 8)
    {
      if (i1 < 7) {}
      for (int i2 = i1 + 1;; i2 = 1)
      {
        arrayOfString[i1] = paramArrayOfString[i2];
        i1 += 1;
        break;
      }
    }
    return arrayOfString;
  }
  
  private static int c(String[] paramArrayOfString)
  {
    int i1 = 0;
    int i2 = paramArrayOfString.length;
    i2 -= 1;
    if (i2 >= 0)
    {
      String str = paramArrayOfString[i2];
      if (str == null) {
        break label41;
      }
      int i3 = str.length();
      if (i3 <= i1) {
        break label41;
      }
      i1 = i3;
    }
    label41:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public int a()
  {
    return this.m;
  }
  
  public int a(String paramString)
  {
    Integer localInteger = (Integer)this.j.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new m(d.w(), paramString);
  }
  
  public String a(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public int b()
  {
    return this.p;
  }
  
  public int b(String paramString)
  {
    Integer localInteger = (Integer)this.l.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new m(d.r(), paramString);
  }
  
  public String b(int paramInt)
  {
    return this.g[paramInt];
  }
  
  public int c()
  {
    return this.n;
  }
  
  public int c(String paramString)
  {
    Integer localInteger = (Integer)this.k.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new m(d.l(), paramString);
  }
  
  public String c(int paramInt)
  {
    return this.h[paramInt];
  }
  
  public int d()
  {
    return this.r;
  }
  
  public int d(String paramString)
  {
    String[] arrayOfString = this.i;
    int i1 = arrayOfString.length;
    int i2;
    do
    {
      i2 = i1 - 1;
      if (i2 < 0) {
        break;
      }
      i1 = i2;
    } while (!arrayOfString[i2].equalsIgnoreCase(paramString));
    return i2;
    throw new m(d.k(), paramString);
  }
  
  public String d(int paramInt)
  {
    return this.e[paramInt];
  }
  
  public String e(int paramInt)
  {
    return this.f[paramInt];
  }
  
  public String f(int paramInt)
  {
    return this.i[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */