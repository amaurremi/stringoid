package com.jirbo.adcolony;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

class ADCUtil
{
  static byte[] byte_buffer = new byte['Ѐ'];
  static StringBuilder string_buffer = new StringBuilder();
  
  static boolean application_exists(String paramString)
  {
    try
    {
      AdColony.activity().getApplication().getPackageManager().getApplicationInfo(paramString, 0);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static String application_version()
  {
    try
    {
      String str = AdColony.activity().getPackageManager().getPackageInfo(AdColony.activity().getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ADC.log_error("Failed to retrieve package info.");
    }
    return "1.0";
  }
  
  static String calculate_sha1(String paramString)
  {
    try
    {
      paramString = AeSimpleSHA1.sha1(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static String create_uuid()
  {
    return UUID.randomUUID().toString();
  }
  
  static double current_time()
  {
    return System.currentTimeMillis() / 1000.0D;
  }
  
  static String format(double paramDouble, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    format(paramDouble, paramInt, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  static void format(double paramDouble, int paramInt, StringBuilder paramStringBuilder)
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
  
  static String load_file(String paramString)
  {
    return load_file(paramString, "");
  }
  
  static String load_file(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        ADCLog.dev.print("Loading ").println(paramString1);
        FileInputStream localFileInputStream = new FileInputStream(paramString1);
        synchronized (byte_buffer)
        {
          string_buffer.setLength(0);
          string_buffer.append(paramString2);
          i = localFileInputStream.read(byte_buffer, 0, byte_buffer.length);
          break label152;
          if (j < i)
          {
            string_buffer.append((char)byte_buffer[j]);
            j += 1;
            continue;
          }
          i = localFileInputStream.read(byte_buffer, 0, byte_buffer.length);
          break label152;
          localFileInputStream.close();
          paramString2 = string_buffer.toString();
          return paramString2;
        }
        return "";
      }
      catch (IOException paramString2)
      {
        ADCLog.error.print("Unable to load ").println(paramString1);
        return "";
      }
      label152:
      if (i != -1) {
        j = 0;
      }
    }
  }
  
  static String package_name()
  {
    return ADC.activity().getPackageName();
  }
  
  static class Stopwatch
  {
    long start_ms = System.currentTimeMillis();
    
    double elapsed_seconds()
    {
      return (System.currentTimeMillis() - this.start_ms) / 1000.0D;
    }
    
    void restart()
    {
      this.start_ms = System.currentTimeMillis();
    }
    
    public String toString()
    {
      return ADCUtil.format(elapsed_seconds(), 2);
    }
  }
  
  static class Timer
  {
    double target_time = System.currentTimeMillis();
    
    Timer(double paramDouble)
    {
      restart(paramDouble);
    }
    
    boolean expired()
    {
      return remaining_seconds() == 0.0D;
    }
    
    double remaining_seconds()
    {
      double d1 = System.currentTimeMillis() / 1000.0D;
      double d2 = this.target_time - d1;
      d1 = d2;
      if (d2 <= 0.0D) {
        d1 = 0.0D;
      }
      return d1;
    }
    
    void restart(double paramDouble)
    {
      this.target_time = (System.currentTimeMillis() / 1000.0D + paramDouble);
    }
    
    public String toString()
    {
      return ADCUtil.format(remaining_seconds(), 2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */