package com.appflood.e;

import android.net.Uri;
import com.appflood.b.b;
import com.appflood.c.d;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  private static final byte[] a = new byte[8];
  private static final byte[] b = new byte[8];
  private static final j.b c;
  
  static
  {
    int i = 0;
    while (i < 8)
    {
      a[i] = 0;
      b[i] = 0;
      i += 1;
    }
    c = new j.b("papaya social 1.5", a);
    new j.b("papaya social 1.5", b);
  }
  
  public static String a(String paramString, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(paramString.length()).append(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      int i;
      label62:
      StringBuilder localStringBuilder2;
      if (!paramString.contains("?"))
      {
        localStringBuilder1.append('?');
        paramMap = paramMap.entrySet();
        Iterator localIterator = paramMap.iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label172;
        }
        paramString = (Map.Entry)localIterator.next();
        i += 1;
        localStringBuilder2 = localStringBuilder1.append((String)paramString.getKey()).append('=');
        if (paramString.getValue() != null) {
          break label156;
        }
      }
      label156:
      for (paramString = "";; paramString = Uri.encode(paramString.getValue().toString()))
      {
        localStringBuilder2.append(paramString);
        if (i < paramMap.size()) {
          localStringBuilder1.append('&');
        }
        break label62;
        localStringBuilder1.append('&');
        break;
      }
    }
    label172:
    return new String(localStringBuilder1);
  }
  
  public static URL a(String paramString)
  {
    return a(paramString.replace("http://data.appflood.com/", d.g), d.h);
  }
  
  private static URL a(String paramString, URL paramURL)
  {
    if (paramString == null) {
      return paramURL;
    }
    if (paramURL == null) {}
    try
    {
      localURL = new URL(paramString);
      paramString = localURL;
    }
    catch (Throwable localThrowable)
    {
      URL localURL;
      j.a(localThrowable, "failed to makeURL " + paramString + " " + paramURL);
      return null;
    }
    localURL = new URL(paramURL, paramString);
    paramString = localURL;
    return paramString;
  }
  
  public static boolean a(URL paramURL1, URL paramURL2)
  {
    if (paramURL1 == paramURL2) {
      return true;
    }
    if ((paramURL1 != null) && (paramURL2 != null)) {
      return paramURL1.toString().equals(paramURL2.toString());
    }
    return false;
  }
  
  public static URL b(String paramString, Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if ((!j.a(d.w)) && (!paramString.contains("tkn=" + d.w))) {
      ((Map)localObject).put("tkn", d.w);
    }
    return a(a(paramString, (Map)localObject));
  }
  
  public static boolean b(String paramString)
  {
    return !paramString.startsWith("http:");
  }
  
  public static void c(String paramString)
  {
    new StringBuilder("trackingEvent  url = ").append(paramString).toString();
    j.a();
    if (j.a(paramString)) {
      return;
    }
    new b(paramString).f();
  }
  
  public static String d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    synchronized (c)
    {
      paramString = c.a(paramString);
      return paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */