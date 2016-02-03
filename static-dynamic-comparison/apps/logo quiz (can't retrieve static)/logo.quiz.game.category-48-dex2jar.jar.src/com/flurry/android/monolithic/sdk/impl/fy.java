package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class fy
{
  public static void a() {}
  
  public static void a(String paramString)
  {
    try
    {
      Context localContext = ia.a().b();
      SharedPreferences.Editor localEditor = localContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
      localEditor.putString("flurry_last_user_id", paramString);
      localEditor.commit();
      if (!TextUtils.isEmpty(paramString)) {
        go.a(localContext, paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SharedPreferences.Editor localEditor = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
      if (!TextUtils.isEmpty(paramString1)) {
        localEditor.putString("flurry_last_user_name", paramString1);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localEditor.putString("flurry_last_user_email", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localEditor.putString("flurry_last_user_session", paramString3);
      }
      localEditor.commit();
      ja.a(4, "AppCloudUserHelper", "saveLastLoggedInUserData, (Name, Email, Token) = ( " + paramString1 + " , " + paramString2 + " , " + paramString3 + " )");
      return;
    }
    finally {}
  }
  
  public static void b()
  {
    try
    {
      SharedPreferences.Editor localEditor = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
      localEditor.putString("flurry_last_user_session", "");
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
      localEditor.putString("flurry_last_user_pass", paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static ft c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 95	com/flurry/android/monolithic/sdk/impl/ft
    //   6: dup
    //   7: invokespecial 96	com/flurry/android/monolithic/sdk/impl/ft:<init>	()V
    //   10: astore_0
    //   11: invokestatic 99	com/flurry/android/monolithic/sdk/impl/fy:d	()Ljava/lang/String;
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +52 -> 71
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 101	com/flurry/android/monolithic/sdk/impl/ft:b	(Ljava/lang/String;)V
    //   27: invokestatic 104	com/flurry/android/monolithic/sdk/impl/fy:e	()Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +8 -> 43
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 106	com/flurry/android/monolithic/sdk/impl/ft:e	(Ljava/lang/String;)V
    //   43: invokestatic 109	com/flurry/android/monolithic/sdk/impl/fy:f	()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +8 -> 59
    //   54: aload_0
    //   55: aload_1
    //   56: invokevirtual 111	com/flurry/android/monolithic/sdk/impl/ft:d	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 114	com/flurry/android/monolithic/sdk/impl/fy:g	()Ljava/lang/String;
    //   63: putfield 117	com/flurry/android/monolithic/sdk/impl/ft:f	Ljava/lang/String;
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: areturn
    //   71: aconst_null
    //   72: astore_0
    //   73: goto -7 -> 66
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	63	0	localft	ft
    //   76	5	0	localObject	Object
    //   14	42	1	str	String
    // Exception table:
    //   from	to	target	type
    //   3	43	76	finally
    //   43	59	76	finally
    //   59	66	76	finally
  }
  
  public static String d()
  {
    try
    {
      String str = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_id", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String e()
  {
    try
    {
      String str = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_name", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String f()
  {
    try
    {
      String str = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_email", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String g()
  {
    try
    {
      String str = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_pass", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String h()
  {
    try
    {
      String str = ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_session", "");
      ja.a(4, "AppCloudUserHelper", "User Session = " + str);
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void i()
  {
    try
    {
      ia.a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */