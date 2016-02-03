package com.jiubang.playsdk.f;

import android.content.Context;
import android.text.TextUtils;
import com.jiubang.playsdk.c.d;
import java.util.Calendar;
import java.util.TimeZone;

public class a
{
  public static String a()
  {
    label307:
    label310:
    label313:
    for (;;)
    {
      try
      {
        Object localObject = Calendar.getInstance();
        ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone("GMT+8"));
        int i = ((Calendar)localObject).get(1);
        String str1 = String.valueOf(((Calendar)localObject).get(2) + 1);
        if (str1.length() > 1) {
          break label313;
        }
        str1 = "0" + str1;
        String str2 = String.valueOf(((Calendar)localObject).get(5));
        if (str2.length() > 1) {
          break label310;
        }
        str2 = "0" + str2;
        String str3 = String.valueOf(((Calendar)localObject).get(11));
        if (str3.length() > 1) {
          break label307;
        }
        str3 = "0" + str3;
        String str4 = String.valueOf(((Calendar)localObject).get(12));
        if (str4.length() <= 1)
        {
          str4 = "0" + str4;
          String str5 = String.valueOf(((Calendar)localObject).get(13));
          localObject = str5;
          if (str5.length() <= 1) {
            localObject = "0" + str5;
          }
          str1 = String.valueOf(i) + "-" + str1 + "-" + str2 + " " + str3 + ":" + str4 + ":" + (String)localObject;
          return str1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return "0";
      }
      continue;
      continue;
    }
  }
  
  public static String a(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return paramInt + "";
      paramInt = 30;
      continue;
      paramInt = 106;
      continue;
      paramInt = 10;
      continue;
      paramInt = 31;
      continue;
      paramInt = 11;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return "2_30";
    }
    int i = com.jiubang.playsdk.g.a.a(paramString);
    if (!com.jiubang.playsdk.g.a.a(paramContext, paramString, null))
    {
      switch (i)
      {
      default: 
        return "";
      case 80: 
        return "2_30";
      case 81: 
        return "2_106";
      case 82: 
        return "2_10";
      case 83: 
        return "2_31";
      }
      return "2_11";
    }
    switch (i)
    {
    default: 
      return "";
    case 80: 
      return "1_30";
    case 81: 
      return "1_106";
    case 82: 
      return "1_10";
    case 83: 
      return "1_31";
    }
    return "1_11";
  }
  
  public static void a(Context paramContext) {}
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    a(paramContext, a(paramInt1), "", "more", "1", paramInt2 + "", paramLong + "", "", "0", "", "");
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    a(paramContext, a(paramInt1), "", "h000", "1", paramInt2 + "", paramString + "", paramInt3 + "", "0", "", "");
  }
  
  public static void a(Context paramContext, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    a(paramContext, a(paramInt1), paramLong + "", "a000", "1", paramInt2 + "", paramString + "", paramInt3 + "", "0", "", "");
  }
  
  public static void a(Context paramContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3)
  {
    a(paramContext, a(paramInt1), paramLong1 + "", "c000", "1", paramInt2 + "", paramLong2 + "", paramInt3 + "", "0", "", "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    d.a(new c(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10));
  }
  
  public static void b(Context paramContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3)
  {
    a(paramContext, a(paramInt1), paramLong1 + "", "a003", "1", paramInt2 + "", paramLong2 + "", paramInt3 + "", "0", "", "");
  }
  
  public static void c(Context paramContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3)
  {
    d.a(new b(paramContext, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */