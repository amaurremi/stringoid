package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataSource;

public class kv
{
  private static final ThreadLocal<String> To = new ThreadLocal();
  
  public static String bq(String paramString)
  {
    return s(paramString, (String)To.get());
  }
  
  public static DataSource c(DataSource paramDataSource)
  {
    if (!paramDataSource.iJ()) {}
    String str;
    do
    {
      return paramDataSource;
      str = (String)To.get();
    } while ((iU()) || (str.equals(paramDataSource.getAppPackageName())));
    return paramDataSource.iK();
  }
  
  public static boolean iU()
  {
    String str = (String)To.get();
    return (str == null) || (str.startsWith("com.google"));
  }
  
  private static String s(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return paramString1;
    }
    byte[] arrayOfByte = new byte[paramString1.length() + paramString2.length()];
    System.arraycopy(paramString1.getBytes(), 0, arrayOfByte, 0, paramString1.length());
    System.arraycopy(paramString2.getBytes(), 0, arrayOfByte, paramString1.length(), paramString2.length());
    return Integer.toHexString(kb.a(arrayOfByte, 0, arrayOfByte.length, 0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */