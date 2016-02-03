package com.jirbo.adcolony;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

class ab
{
  static byte[] a = new byte['Ѐ'];
  static StringBuilder b = new StringBuilder();
  
  static String a()
  {
    try
    {
      String str = AdColony.activity().getPackageManager().getPackageInfo(AdColony.activity().getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      a.e("Failed to retrieve package info.");
    }
    return "1.0";
  }
  
  static String a(double paramDouble, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramDouble, paramInt, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        l.a.a("Loading ").b(paramString1);
        FileInputStream localFileInputStream = new FileInputStream(paramString1);
        synchronized (a)
        {
          b.setLength(0);
          b.append(paramString2);
          i = localFileInputStream.read(a, 0, a.length);
          break label152;
          if (j < i)
          {
            b.append((char)a[j]);
            j += 1;
            continue;
          }
          i = localFileInputStream.read(a, 0, a.length);
          break label152;
          localFileInputStream.close();
          paramString2 = b.toString();
          return paramString2;
        }
        return "";
      }
      catch (IOException paramString2)
      {
        l.d.a("Unable to load ").b(paramString1);
        return "";
      }
      label152:
      if (i != -1) {
        j = 0;
      }
    }
  }
  
  static void a(double paramDouble, int paramInt, StringBuilder paramStringBuilder)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      paramStringBuilder.append(paramDouble);
    }
    long l2;
    long l3;
    for (;;)
    {
      return;
      double d = paramDouble;
      if (paramDouble < 0.0D)
      {
        d = -paramDouble;
        paramStringBuilder.append('-');
      }
      if (paramInt == 0)
      {
        paramStringBuilder.append(Math.round(d));
        return;
      }
      l2 = Math.pow(10.0D, paramInt);
      l1 = Math.round(l2 * d);
      paramStringBuilder.append(l1 / l2);
      paramStringBuilder.append('.');
      l3 = l1 % l2;
      if (l3 != 0L) {
        break;
      }
      int i = 0;
      while (i < paramInt)
      {
        paramStringBuilder.append('0');
        i += 1;
      }
    }
    for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(l3);
  }
  
  static boolean a(String paramString)
  {
    try
    {
      AdColony.activity().getApplication().getPackageManager().getApplicationInfo(paramString, 0);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static String b()
  {
    return UUID.randomUUID().toString();
  }
  
  static String b(String paramString)
  {
    try
    {
      paramString = ai.a(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static double c()
  {
    return System.currentTimeMillis() / 1000.0D;
  }
  
  static String c(String paramString)
  {
    return a(paramString, "");
  }
  
  static String d()
  {
    return a.b().getPackageName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */