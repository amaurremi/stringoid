package com.flurry.android;

import android.content.Context;
import android.location.Criteria;
import com.flurry.android.monolithic.sdk.impl.eg;
import com.flurry.android.monolithic.sdk.impl.ia;
import com.flurry.android.monolithic.sdk.impl.ib;
import com.flurry.android.monolithic.sdk.impl.ic;
import com.flurry.android.monolithic.sdk.impl.ig;
import com.flurry.android.monolithic.sdk.impl.ij;
import com.flurry.android.monolithic.sdk.impl.ja;
import com.flurry.android.monolithic.sdk.impl.je;
import java.util.Date;
import java.util.Map;

public final class FlurryAgent
{
  private static final String a = FlurryAgent.class.getSimpleName();
  
  public static void endTimedEvent(String paramString)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to endTimedEvent was null.");
      return;
    }
    try
    {
      eg.a().b(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      ja.b(a, "Failed to signify the end of event: " + paramString, localThrowable);
    }
  }
  
  public static void endTimedEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to endTimedEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      ja.b(a, "String eventId passed to endTimedEvent was null.");
      return;
    }
    try
    {
      eg.a().b(paramString, paramMap);
      return;
    }
    catch (Throwable paramMap)
    {
      ja.b(a, "Failed to signify the end of event: " + paramString, paramMap);
    }
  }
  
  public static int getAgentVersion()
  {
    return eg.a().b();
  }
  
  public static String getReleaseVersion()
  {
    return eg.a().c();
  }
  
  public static boolean getUseHttps()
  {
    return ((Boolean)ib.a().a("UseHttps")).booleanValue();
  }
  
  public static void logEvent(String paramString)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    try
    {
      eg.a().a(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      ja.b(a, "Failed to log event: " + paramString, localThrowable);
    }
  }
  
  public static void logEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      ja.b(a, "String parameters passed to logEvent was null.");
      return;
    }
    try
    {
      eg.a().a(paramString, paramMap);
      return;
    }
    catch (Throwable paramMap)
    {
      ja.b(a, "Failed to log event: " + paramString, paramMap);
    }
  }
  
  public static void logEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      ja.b(a, "String parameters passed to logEvent was null.");
      return;
    }
    try
    {
      eg.a().a(paramString, paramMap, paramBoolean);
      return;
    }
    catch (Throwable paramMap)
    {
      ja.b(a, "Failed to log event: " + paramString, paramMap);
    }
  }
  
  public static void logEvent(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    try
    {
      eg.a().a(paramString, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      ja.b(a, "Failed to log event: " + paramString, localThrowable);
    }
  }
  
  public static void onEndSession(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    ij.a().b(paramContext);
    ig.a().g(paramContext);
    try
    {
      eg.a().a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      ja.b(a, "", paramContext);
    }
  }
  
  @Deprecated
  public static void onError(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      ja.b(a, "String errorId passed to onError was null.");
      return;
    }
    if (paramString2 == null)
    {
      ja.b(a, "String message passed to onError was null.");
      return;
    }
    if (paramString3 == null)
    {
      ja.b(a, "String errorClass passed to onError was null.");
      return;
    }
    try
    {
      eg.a().a(paramString1, paramString2, paramString3);
      return;
    }
    catch (Throwable paramString1)
    {
      ja.b(a, "", paramString1);
    }
  }
  
  public static void onError(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString1 == null)
    {
      ja.b(a, "String errorId passed to onError was null.");
      return;
    }
    if (paramString2 == null)
    {
      ja.b(a, "String message passed to onError was null.");
      return;
    }
    if (paramThrowable == null)
    {
      ja.b(a, "Throwable passed to onError was null.");
      return;
    }
    try
    {
      eg.a().a(paramString1, paramString2, paramThrowable);
      return;
    }
    catch (Throwable paramString1)
    {
      ja.b(a, "", paramString1);
    }
  }
  
  @Deprecated
  public static void onEvent(String paramString)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to onEvent was null.");
      return;
    }
    try
    {
      eg.a().c(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      ja.b(a, "", paramString);
    }
  }
  
  @Deprecated
  public static void onEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      ja.b(a, "String eventId passed to onEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      ja.b(a, "Parameters Map passed to onEvent was null.");
      return;
    }
    try
    {
      eg.a().c(paramString, paramMap);
      return;
    }
    catch (Throwable paramString)
    {
      ja.b(a, "", paramString);
    }
  }
  
  public static void onPageView()
  {
    try
    {
      eg.a().e();
      return;
    }
    catch (Throwable localThrowable)
    {
      ja.b(a, "", localThrowable);
    }
  }
  
  public static void onStartSession(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("Api key not specified");
    }
    ia.a(paramContext);
    try
    {
      eg.a().a(paramContext, paramString);
      ij.a().a(paramContext);
      ig.a().f(paramContext);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        ja.b(a, "", paramString);
      }
    }
  }
  
  public static void setAge(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 110))
    {
      long l = new Date(new Date(System.currentTimeMillis() - paramInt * 31449600000L).getYear(), 1, 1).getTime();
      ib.a().a("Age", Long.valueOf(l));
    }
  }
  
  public static void setCaptureUncaughtExceptions(boolean paramBoolean)
  {
    ib.a().a("CaptureUncaughtExceptions", Boolean.valueOf(paramBoolean));
  }
  
  public static void setContinueSessionMillis(long paramLong)
  {
    if (paramLong < 5000L)
    {
      ja.b(a, "Invalid time set for session resumption: " + paramLong);
      return;
    }
    ib.a().a("ContinueSessionMillis", Long.valueOf(paramLong));
  }
  
  public static void setGender(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      ib.a().a("Gender", Byte.valueOf((byte)-1));
      return;
    }
    ib.a().a("Gender", Byte.valueOf(paramByte));
  }
  
  public static void setLocationCriteria(Criteria paramCriteria)
  {
    ib.a().a("LocationCriteria", paramCriteria);
  }
  
  public static void setLogEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ja.b();
      return;
    }
    ja.a();
  }
  
  public static void setLogEvents(boolean paramBoolean)
  {
    ib.a().a("LogEvents", Boolean.valueOf(paramBoolean));
  }
  
  public static void setLogLevel(int paramInt)
  {
    ja.a(paramInt);
  }
  
  public static void setReportLocation(boolean paramBoolean)
  {
    ib.a().a("ReportLocation", Boolean.valueOf(paramBoolean));
  }
  
  public static void setReportUrl(String paramString)
  {
    ib.a().a("ReportUrl", paramString);
  }
  
  public static void setUseHttps(boolean paramBoolean)
  {
    ib.a().a("UseHttps", Boolean.valueOf(paramBoolean));
  }
  
  public static void setUserId(String paramString)
  {
    if (paramString == null)
    {
      ja.b(a, "String userId passed to setUserId was null.");
      return;
    }
    ib.a().a("UserId", je.a(paramString));
  }
  
  public static void setVersionName(String paramString)
  {
    if (paramString == null)
    {
      ja.b(a, "String versionName passed to setVersionName was null.");
      return;
    }
    ib.a().a("VesionName", paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/FlurryAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */