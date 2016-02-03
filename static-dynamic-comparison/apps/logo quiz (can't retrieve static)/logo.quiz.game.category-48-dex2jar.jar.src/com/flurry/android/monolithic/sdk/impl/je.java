package com.flurry.android.monolithic.sdk.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class je
{
  private static final String a = je.class.getSimpleName();
  
  public static float a()
  {
    return ia.a().d().density;
  }
  
  public static int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = ia.a().d();
    return Math.round(paramInt / localDisplayMetrics.density);
  }
  
  public static String a(String paramString)
  {
    return a(paramString, 255);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= paramInt);
    return paramString.substring(0, paramInt);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    char[] arrayOfChar = new char[16];
    char[] tmp21_19 = arrayOfChar;
    tmp21_19[0] = 48;
    char[] tmp26_21 = tmp21_19;
    tmp26_21[1] = 49;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[2] = 50;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[3] = 51;
    char[] tmp41_36 = tmp36_31;
    tmp41_36[4] = 52;
    char[] tmp46_41 = tmp41_36;
    tmp46_41[5] = 53;
    char[] tmp51_46 = tmp46_41;
    tmp51_46[6] = 54;
    char[] tmp57_51 = tmp51_46;
    tmp57_51[7] = 55;
    char[] tmp63_57 = tmp57_51;
    tmp63_57[8] = 56;
    char[] tmp69_63 = tmp63_57;
    tmp69_63[9] = 57;
    char[] tmp75_69 = tmp69_63;
    tmp75_69[10] = 97;
    char[] tmp81_75 = tmp75_69;
    tmp81_75[11] = 98;
    char[] tmp87_81 = tmp81_75;
    tmp87_81[12] = 99;
    char[] tmp93_87 = tmp87_81;
    tmp93_87[13] = 100;
    char[] tmp99_93 = tmp93_87;
    tmp99_93[14] = 101;
    char[] tmp105_99 = tmp99_93;
    tmp105_99[15] = 102;
    tmp105_99;
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      int m = (byte)(k & 0xF);
      localStringBuilder.append(arrayOfChar[((byte)((k & 0xF0) >> 4))]);
      localStringBuilder.append(arrayOfChar[m]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool = false;
    if (System.currentTimeMillis() <= paramLong) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Intent paramIntent)
  {
    return ia.a().c().queryIntentActivities(paramIntent, 65536).size() > 0;
  }
  
  public static int b()
  {
    return ia.a().d().widthPixels;
  }
  
  public static int b(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = ia.a().d();
    float f = paramInt;
    return Math.round(localDisplayMetrics.density * f);
  }
  
  public static String b(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ja.a(5, a, "Cannot encode '" + paramString + "'");
    }
    return "";
  }
  
  public static boolean b(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.resolveActivity(ia.a().c());
      bool = ia.a().b().getPackageName().equals(paramIntent.getPackageName());
    }
    return bool;
  }
  
  public static int c()
  {
    return ia.a().d().heightPixels;
  }
  
  public static String c(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ja.a(5, a, "Cannot decode '" + paramString + "'");
    }
    return "";
  }
  
  public static int d()
  {
    return a(b());
  }
  
  public static byte[] d(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      ja.a(6, a, "Unsupported SHA1: " + paramString.getMessage());
    }
    return null;
  }
  
  public static int e()
  {
    return a(c());
  }
  
  public static String e(String paramString)
  {
    return paramString.replace("'", "\\'").replace("\\n", "").replace("\\r", "").replace("\\t", "");
  }
  
  public static int f()
  {
    Point localPoint = new Point(b(), c());
    if (localPoint.x == localPoint.y) {
      return 3;
    }
    if (localPoint.x < localPoint.y) {
      return 1;
    }
    return 2;
  }
  
  public static Map<String, String> f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (!arrayOfString[0].equals("event")) {
          localHashMap.put(c(arrayOfString[0]), c(arrayOfString[1]));
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static Pair<Integer, Integer> g()
  {
    return Pair.create(Integer.valueOf(d()), Integer.valueOf(e()));
  }
  
  public static Pair<Integer, Integer> h()
  {
    int i = d();
    int j = e();
    switch (f())
    {
    default: 
      return Pair.create(Integer.valueOf(i), Integer.valueOf(j));
    }
    return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/je.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */