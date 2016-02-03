package com.google.ads.util;

import android.text.TextUtils;
import android.util.Log;

public class a
{
  private static boolean a = Log.isLoggable("GoogleAdsAssertion", 3);
  
  public static void a(Object paramObject)
  {
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool, "Assertion that an object is null failed.");
      return;
    }
  }
  
  public static void a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool, "Assertion that 'a' and 'b' refer to the same object failed.a: " + paramObject1 + ", b: " + paramObject2);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool, "Expected a non empty string, got: " + paramString);
      return;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    c(paramBoolean, "Assertion failed.");
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    c(paramBoolean, paramString);
  }
  
  public static void b(Object paramObject)
  {
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool, "Assertion that an object is not null failed.");
      return;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(paramBoolean, "Assertion failed.");
      return;
    }
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(paramBoolean, paramString);
      return;
    }
  }
  
  private static void c(boolean paramBoolean, String paramString)
  {
    if ((!Log.isLoggable("GoogleAdsAssertion", 3)) && (!a)) {}
    while (paramBoolean) {
      return;
    }
    a.a locala = new a.a(paramString);
    Log.d("GoogleAdsAssertion", paramString, locala);
    throw locala;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */