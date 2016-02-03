package com.crittercism.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.crittercism.NotificationActivity;
import crittercism.android.a.a;
import crittercism.android.b;
import crittercism.android.d;
import crittercism.android.e;
import crittercism.android.i;
import crittercism.android.k;
import crittercism.android.l;
import crittercism.android.m;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Crittercism
{
  public static final String a = d.b();
  private static Crittercism c = new Crittercism();
  private Thread A = null;
  final Handler b = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      paramAnonymousMessage = paramAnonymousMessage.getData();
      if (paramAnonymousMessage.containsKey("notification")) {}
      try
      {
        Intent localIntent = new Intent(Crittercism.c(Crittercism.this), NotificationActivity.class);
        localIntent.setFlags(272629760);
        localIntent.putExtra("com.crittercism.notification", paramAnonymousMessage.getString("notification"));
        Crittercism.c(Crittercism.this).startActivity(localIntent);
        return;
      }
      catch (Exception paramAnonymousMessage) {}
    }
  };
  private b d;
  private d e;
  private e f = null;
  private boolean g = false;
  private Context h = null;
  private float i = 1.0F;
  private i j = new i();
  private m k = new m();
  private k l = new k();
  private l m = new l();
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private String t = "";
  private int u = 0;
  private String v = null;
  private String w = "";
  private String x = "Developer Reply";
  private String y = "com.crittercism/dumps";
  private boolean z = false;
  
  private String B()
  {
    try
    {
      String str = this.h.getPackageManager().getPackageInfo(this.h.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException) {}
    return "1.0";
  }
  
  private int C()
  {
    try
    {
      int i1 = this.h.getPackageManager().getPackageInfo(this.h.getPackageName(), 0).versionCode;
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private static long a(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.s", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    String str = localSimpleDateFormat.format(paramDate);
    long l1 = 0L;
    try
    {
      long l2 = localSimpleDateFormat.parse(str).getTime();
      l1 = l2;
      new StringBuilder("longFormat = ").append(Long.toString(l2)).append("\tdate = ").append(paramDate.toString()).toString();
      return l2;
    }
    catch (Exception paramDate) {}
    return l1;
  }
  
  public static Crittercism a()
  {
    return c;
  }
  
  public static boolean c()
  {
    return c.s;
  }
  
  private static boolean c(Context paramContext)
  {
    try
    {
      boolean bool = paramContext.getSharedPreferences("com.crittercism.prefs", 0).getBoolean("optOutStatus", false);
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    try
    {
      paramContext = paramContext.getSharedPreferences("com.crittercism.prefs", 0);
      bool = paramContext.getBoolean("crashedOnLastAppLoad", false);
      paramContext = paramContext.edit();
      paramContext.remove("crashedOnLastAppLoad");
      if (!paramContext.commit()) {
        throw new Exception();
      }
    }
    catch (Exception paramContext)
    {
      new StringBuilder("Exception when trying to retrieve crashedOnLastAppLoad from SharedPreferences! ").append(paramContext.getClass().getName()).toString();
      bool = false;
      localStringBuilder = new StringBuilder("read crashedOnLastAppLoad as: ");
      if (!bool) {}
    }
    for (paramContext = "true";; paramContext = "false")
    {
      localStringBuilder.append(paramContext).toString();
      return bool;
    }
  }
  
  public static boolean didCrashOnLastAppLoad()
  {
    if (c == null)
    {
      Log.w("Crittercism", "Call to didCrashOnLastAppLoad() failed.  Please contact us at support@crittercism.com.");
      return false;
    }
    try
    {
      boolean bool = c.o;
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String getNotificationTitle()
  {
    if (c == null)
    {
      Log.w("Crittercism", "Call to getNotificationTitle failed.  Please contact us at support@crittercism.com.");
      return "Developer Reply";
    }
    return c.x;
  }
  
  /* Error */
  public static boolean getOptOutStatus()
  {
    // Byte code:
    //   0: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   3: ifnonnull +15 -> 18
    //   6: ldc_w 385
    //   9: ldc_w 403
    //   12: invokestatic 392	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: iconst_0
    //   17: ireturn
    //   18: new 405	java/util/concurrent/FutureTask
    //   21: dup
    //   22: new 10	com/crittercism/app/Crittercism$11
    //   25: dup
    //   26: invokespecial 406	com/crittercism/app/Crittercism$11:<init>	()V
    //   29: invokespecial 409	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   32: astore_1
    //   33: bipush 10
    //   35: invokestatic 415	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   38: astore_2
    //   39: aload_2
    //   40: aload_1
    //   41: invokeinterface 421 2 0
    //   46: iconst_0
    //   47: istore_0
    //   48: aload_1
    //   49: invokevirtual 424	java/util/concurrent/FutureTask:isDone	()Z
    //   52: ifne +26 -> 78
    //   55: aload_1
    //   56: ldc2_w 425
    //   59: getstatic 432	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   62: invokevirtual 436	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   65: checkcast 438	java/lang/Boolean
    //   68: invokevirtual 441	java/lang/Boolean:booleanValue	()Z
    //   71: istore_0
    //   72: goto -24 -> 48
    //   75: astore_1
    //   76: iconst_0
    //   77: istore_0
    //   78: iload_0
    //   79: ireturn
    //   80: astore_1
    //   81: new 260	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 443
    //   88: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   95: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   98: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: pop
    //   105: iconst_0
    //   106: istore_0
    //   107: goto -29 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	60	0	bool	boolean
    //   32	24	1	localFutureTask	java.util.concurrent.FutureTask
    //   75	1	1	localTimeoutException	java.util.concurrent.TimeoutException
    //   80	12	1	localException	Exception
    //   38	2	2	localExecutorService	java.util.concurrent.ExecutorService
    // Exception table:
    //   from	to	target	type
    //   39	46	75	java/util/concurrent/TimeoutException
    //   48	72	75	java/util/concurrent/TimeoutException
    //   39	46	80	java/lang/Exception
    //   48	72	80	java/lang/Exception
  }
  
  /* Error */
  public static String getUserUUID()
  {
    // Byte code:
    //   0: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   3: ifnonnull +15 -> 18
    //   6: ldc_w 385
    //   9: ldc_w 446
    //   12: invokestatic 392	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: aconst_null
    //   17: areturn
    //   18: new 405	java/util/concurrent/FutureTask
    //   21: dup
    //   22: new 12	com/crittercism/app/Crittercism$2
    //   25: dup
    //   26: invokespecial 447	com/crittercism/app/Crittercism$2:<init>	()V
    //   29: invokespecial 409	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   32: astore_1
    //   33: bipush 10
    //   35: invokestatic 415	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   38: astore_0
    //   39: aload_0
    //   40: aload_1
    //   41: invokeinterface 421 2 0
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 424	java/util/concurrent/FutureTask:isDone	()Z
    //   52: ifne +23 -> 75
    //   55: aload_1
    //   56: ldc2_w 425
    //   59: getstatic 432	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   62: invokevirtual 436	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   65: checkcast 449	java/lang/String
    //   68: astore_0
    //   69: goto -21 -> 48
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: areturn
    //   77: astore_0
    //   78: new 260	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 451
    //   85: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   92: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   95: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: pop
    //   102: aconst_null
    //   103: astore_0
    //   104: goto -29 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	31	0	localObject1	Object
    //   72	1	0	localTimeoutException	java.util.concurrent.TimeoutException
    //   74	2	0	str	String
    //   77	12	0	localException	Exception
    //   103	1	0	localObject2	Object
    //   32	24	1	localFutureTask	java.util.concurrent.FutureTask
    // Exception table:
    //   from	to	target	type
    //   39	46	72	java/util/concurrent/TimeoutException
    //   48	69	72	java/util/concurrent/TimeoutException
    //   39	46	77	java/lang/Exception
    //   48	69	77	java/lang/Exception
  }
  
  /* Error */
  public static boolean init(Context paramContext, String paramString, JSONObject... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ldc_w 455
    //   7: invokevirtual 459	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 385
    //   16: ldc_w 461
    //   19: invokestatic 463	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: iconst_0
    //   24: istore_3
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: new 303	org/json/JSONObject
    //   33: dup
    //   34: invokespecial 304	org/json/JSONObject:<init>	()V
    //   37: astore 4
    //   39: aload_2
    //   40: arraylength
    //   41: ifle +455 -> 496
    //   44: aload_2
    //   45: iconst_0
    //   46: aaload
    //   47: astore_2
    //   48: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   51: ifnull +452 -> 503
    //   54: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   57: getfield 96	com/crittercism/app/Crittercism:g	Z
    //   60: istore_3
    //   61: iload_3
    //   62: ifne +441 -> 503
    //   65: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   68: astore 4
    //   70: aload 4
    //   72: iconst_1
    //   73: putfield 96	com/crittercism/app/Crittercism:g	Z
    //   76: aload 4
    //   78: aload_0
    //   79: putfield 98	com/crittercism/app/Crittercism:h	Landroid/content/Context;
    //   82: aload 4
    //   84: aload 4
    //   86: invokespecial 465	com/crittercism/app/Crittercism:B	()Ljava/lang/String;
    //   89: putfield 136	com/crittercism/app/Crittercism:t	Ljava/lang/String;
    //   92: aload 4
    //   94: aload 4
    //   96: invokespecial 467	com/crittercism/app/Crittercism:C	()I
    //   99: putfield 138	com/crittercism/app/Crittercism:u	I
    //   102: aload_2
    //   103: ldc_w 469
    //   106: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   109: istore_3
    //   110: iload_3
    //   111: ifeq +15 -> 126
    //   114: aload 4
    //   116: aload_2
    //   117: ldc_w 469
    //   120: invokevirtual 473	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: putfield 140	com/crittercism/app/Crittercism:v	Ljava/lang/String;
    //   126: aload 4
    //   128: new 475	crittercism/android/b
    //   131: dup
    //   132: aload_0
    //   133: aload_1
    //   134: getstatic 90	com/crittercism/app/Crittercism:a	Ljava/lang/String;
    //   137: aload 4
    //   139: getfield 136	com/crittercism/app/Crittercism:t	Ljava/lang/String;
    //   142: aload 4
    //   144: getfield 138	com/crittercism/app/Crittercism:u	I
    //   147: aload 4
    //   149: getfield 140	com/crittercism/app/Crittercism:v	Ljava/lang/String;
    //   152: invokespecial 478	crittercism/android/b:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   155: putfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   158: aload 4
    //   160: aload 4
    //   162: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   165: invokevirtual 481	crittercism/android/b:e	()F
    //   168: putfield 100	com/crittercism/app/Crittercism:i	F
    //   171: aload 4
    //   173: getfield 285	com/crittercism/app/Crittercism:e	Lcrittercism/android/d;
    //   176: ifnonnull +15 -> 191
    //   179: aload 4
    //   181: new 85	crittercism/android/d
    //   184: dup
    //   185: invokespecial 482	crittercism/android/d:<init>	()V
    //   188: putfield 285	com/crittercism/app/Crittercism:e	Lcrittercism/android/d;
    //   191: aload_0
    //   192: invokestatic 487	crittercism/android/a:a	(Landroid/content/Context;)V
    //   195: aload_2
    //   196: ldc_w 489
    //   199: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   202: istore_3
    //   203: iload_3
    //   204: ifeq +15 -> 219
    //   207: aload 4
    //   209: aload_2
    //   210: ldc_w 489
    //   213: invokevirtual 491	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   216: putfield 130	com/crittercism/app/Crittercism:r	Z
    //   219: aload_2
    //   220: ldc_w 493
    //   223: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   226: istore_3
    //   227: iload_3
    //   228: ifeq +15 -> 243
    //   231: aload 4
    //   233: aload_2
    //   234: ldc_w 493
    //   237: invokevirtual 473	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   240: putfield 150	com/crittercism/app/Crittercism:y	Ljava/lang/String;
    //   243: aload_2
    //   244: ldc_w 495
    //   247: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   250: istore_3
    //   251: iload_3
    //   252: ifeq +200 -> 452
    //   255: aload 4
    //   257: aload_2
    //   258: ldc_w 495
    //   261: invokevirtual 491	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   264: putfield 152	com/crittercism/app/Crittercism:z	Z
    //   267: aload_2
    //   268: ldc_w 497
    //   271: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: istore_3
    //   275: iload_3
    //   276: ifeq +15 -> 291
    //   279: aload 4
    //   281: aload_2
    //   282: ldc_w 497
    //   285: invokevirtual 491	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   288: putfield 126	com/crittercism/app/Crittercism:p	Z
    //   291: aload_2
    //   292: ldc_w 499
    //   295: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   298: istore_3
    //   299: iload_3
    //   300: ifeq +15 -> 315
    //   303: aload 4
    //   305: aload_2
    //   306: ldc_w 499
    //   309: invokevirtual 473	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   312: putfield 146	com/crittercism/app/Crittercism:x	Ljava/lang/String;
    //   315: aload 4
    //   317: invokestatic 501	com/crittercism/app/Crittercism:getNotificationTitle	()Ljava/lang/String;
    //   320: putfield 146	com/crittercism/app/Crittercism:x	Ljava/lang/String;
    //   323: new 260	java/lang/StringBuilder
    //   326: dup
    //   327: ldc_w 503
    //   330: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: aload 4
    //   335: getfield 146	com/crittercism/app/Crittercism:x	Ljava/lang/String;
    //   338: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: pop
    //   345: aload_2
    //   346: ldc_w 505
    //   349: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   352: istore_3
    //   353: iload_3
    //   354: ifeq +15 -> 369
    //   357: aload 4
    //   359: aload_2
    //   360: ldc_w 505
    //   363: invokevirtual 491	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   366: putfield 128	com/crittercism/app/Crittercism:q	Z
    //   369: aload 4
    //   371: new 507	java/lang/Thread
    //   374: dup
    //   375: new 6	com/crittercism/app/Crittercism$1
    //   378: dup
    //   379: aload 4
    //   381: invokespecial 508	com/crittercism/app/Crittercism$1:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   384: invokespecial 510	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   387: putfield 154	com/crittercism/app/Crittercism:A	Ljava/lang/Thread;
    //   390: aload 4
    //   392: getfield 154	com/crittercism/app/Crittercism:A	Ljava/lang/Thread;
    //   395: invokevirtual 513	java/lang/Thread:start	()V
    //   398: ldc_w 385
    //   401: ldc_w 515
    //   404: invokestatic 517	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   407: pop
    //   408: invokestatic 519	com/crittercism/app/Crittercism:didCrashOnLastAppLoad	()Z
    //   411: istore_3
    //   412: goto -387 -> 25
    //   415: astore 5
    //   417: aload 4
    //   419: aconst_null
    //   420: putfield 140	com/crittercism/app/Crittercism:v	Ljava/lang/String;
    //   423: goto -297 -> 126
    //   426: astore_0
    //   427: aload 4
    //   429: iconst_0
    //   430: putfield 130	com/crittercism/app/Crittercism:r	Z
    //   433: goto -214 -> 219
    //   436: astore_0
    //   437: ldc 2
    //   439: monitorexit
    //   440: aload_0
    //   441: athrow
    //   442: astore_0
    //   443: aload 4
    //   445: iconst_0
    //   446: putfield 130	com/crittercism/app/Crittercism:r	Z
    //   449: goto -230 -> 219
    //   452: aload 4
    //   454: iconst_0
    //   455: putfield 152	com/crittercism/app/Crittercism:z	Z
    //   458: goto -191 -> 267
    //   461: astore_0
    //   462: aload 4
    //   464: iconst_0
    //   465: putfield 126	com/crittercism/app/Crittercism:p	Z
    //   468: goto -177 -> 291
    //   471: astore_0
    //   472: aload 4
    //   474: ldc -112
    //   476: putfield 146	com/crittercism/app/Crittercism:x	Ljava/lang/String;
    //   479: goto -164 -> 315
    //   482: astore_0
    //   483: aload 4
    //   485: iconst_0
    //   486: putfield 128	com/crittercism/app/Crittercism:q	Z
    //   489: goto -120 -> 369
    //   492: astore_0
    //   493: goto -250 -> 243
    //   496: aload 4
    //   498: astore_2
    //   499: goto -451 -> 48
    //   502: astore_0
    //   503: iconst_0
    //   504: istore_3
    //   505: goto -480 -> 25
    //   508: astore_0
    //   509: goto -57 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	paramContext	Context
    //   0	512	1	paramString	String
    //   0	512	2	paramVarArgs	JSONObject[]
    //   24	481	3	bool	boolean
    //   37	460	4	localObject	Object
    //   415	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   114	126	415	java/lang/Exception
    //   207	219	426	org/json/JSONException
    //   3	23	436	finally
    //   30	44	436	finally
    //   48	61	436	finally
    //   65	110	436	finally
    //   114	126	436	finally
    //   126	191	436	finally
    //   191	203	436	finally
    //   207	219	436	finally
    //   219	227	436	finally
    //   231	243	436	finally
    //   243	251	436	finally
    //   255	267	436	finally
    //   267	275	436	finally
    //   279	291	436	finally
    //   291	299	436	finally
    //   303	315	436	finally
    //   315	353	436	finally
    //   357	369	436	finally
    //   369	412	436	finally
    //   417	423	436	finally
    //   427	433	436	finally
    //   443	449	436	finally
    //   452	458	436	finally
    //   462	468	436	finally
    //   472	479	436	finally
    //   483	489	436	finally
    //   207	219	442	java/lang/Exception
    //   279	291	461	java/lang/Exception
    //   303	315	471	java/lang/Exception
    //   357	369	482	java/lang/Exception
    //   231	243	492	java/lang/Exception
    //   65	110	502	java/lang/Exception
    //   126	191	502	java/lang/Exception
    //   191	203	502	java/lang/Exception
    //   219	227	502	java/lang/Exception
    //   243	251	502	java/lang/Exception
    //   267	275	502	java/lang/Exception
    //   291	299	502	java/lang/Exception
    //   315	353	502	java/lang/Exception
    //   369	412	502	java/lang/Exception
    //   417	423	502	java/lang/Exception
    //   427	433	502	java/lang/Exception
    //   443	449	502	java/lang/Exception
    //   452	458	502	java/lang/Exception
    //   462	468	502	java/lang/Exception
    //   472	479	502	java/lang/Exception
    //   483	489	502	java/lang/Exception
    //   255	267	508	java/lang/Exception
  }
  
  public static void leaveBreadcrumb(String paramString)
  {
    for (;;)
    {
      try
      {
        if (c == null)
        {
          Log.w("Crittercism", "Call to leaveBreadcrumb() failed.  Please contact us at support@crittercism.com.");
          return;
        }
        if (paramString == null)
        {
          Log.w("Crittercism", "Cannot leave null breadcrumb");
          continue;
        }
        str = paramString;
      }
      finally {}
      String str;
      if (paramString.length() > 140) {
        str = paramString.substring(0, 140);
      }
      new Thread(new b(str)).start();
    }
  }
  
  /* Error */
  public static void logHandledException(Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   6: ifnonnull +17 -> 23
    //   9: ldc_w 385
    //   12: ldc_w 534
    //   15: invokestatic 392	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 536	com/crittercism/app/Crittercism:getOptOutStatus	()Z
    //   26: iconst_1
    //   27: if_icmpeq -8 -> 19
    //   30: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   33: astore_2
    //   34: aload_2
    //   35: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   38: getfield 538	crittercism/android/k:h	I
    //   41: bipush 50
    //   43: if_icmpge -24 -> 19
    //   46: aload_2
    //   47: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   50: invokevirtual 541	crittercism/android/k:e	()Ljava/util/Vector;
    //   53: invokevirtual 546	java/util/Vector:size	()I
    //   56: iconst_5
    //   57: if_icmpge -38 -> 19
    //   60: aload_2
    //   61: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   64: invokevirtual 541	crittercism/android/k:e	()Ljava/util/Vector;
    //   67: invokevirtual 546	java/util/Vector:size	()I
    //   70: aload_2
    //   71: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   74: getfield 538	crittercism/android/k:h	I
    //   77: iadd
    //   78: bipush 50
    //   80: if_icmpge -61 -> 19
    //   83: aload_2
    //   84: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   87: astore_3
    //   88: new 303	org/json/JSONObject
    //   91: dup
    //   92: invokespecial 304	org/json/JSONObject:<init>	()V
    //   95: astore 4
    //   97: new 449	java/lang/String
    //   100: dup
    //   101: invokespecial 547	java/lang/String:<init>	()V
    //   104: pop
    //   105: ldc -122
    //   107: astore_1
    //   108: aload_0
    //   109: invokevirtual 550	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   112: ifnull +8 -> 120
    //   115: aload_0
    //   116: invokevirtual 550	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   119: astore_1
    //   120: aload_3
    //   121: aload_0
    //   122: invokevirtual 552	crittercism/android/k:a	(Ljava/lang/Throwable;)V
    //   125: aload_3
    //   126: invokevirtual 554	crittercism/android/k:d	()V
    //   129: aload_3
    //   130: invokevirtual 556	crittercism/android/k:g	()V
    //   133: aload 4
    //   135: ldc_w 558
    //   138: getstatic 83	com/crittercism/app/Crittercism:c	Lcom/crittercism/app/Crittercism;
    //   141: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   144: iconst_2
    //   145: newarray <illegal type>
    //   147: dup
    //   148: iconst_0
    //   149: ldc_w 559
    //   152: bastore
    //   153: dup
    //   154: iconst_1
    //   155: ldc_w 559
    //   158: bastore
    //   159: invokevirtual 562	crittercism/android/b:a	([Z)Lorg/json/JSONObject;
    //   162: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload 4
    //   168: ldc_w 564
    //   171: aload_3
    //   172: getfield 567	crittercism/android/k:f	Lorg/json/JSONObject;
    //   175: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 4
    //   181: ldc_w 569
    //   184: invokestatic 573	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   187: invokevirtual 576	java/lang/Thread:getId	()J
    //   190: invokevirtual 579	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 4
    //   196: ldc_w 581
    //   199: aload_3
    //   200: getfield 583	crittercism/android/k:c	Ljava/lang/String;
    //   203: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   206: pop
    //   207: aload 4
    //   209: ldc_w 585
    //   212: aload_1
    //   213: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload 4
    //   219: ldc_w 587
    //   222: ldc_w 589
    //   225: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload 4
    //   231: ldc_w 591
    //   234: aload_3
    //   235: getfield 594	crittercism/android/k:e	Lorg/json/JSONArray;
    //   238: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   241: pop
    //   242: aload 4
    //   244: ldc_w 596
    //   247: invokestatic 301	com/crittercism/app/Crittercism:z	()Ljava/lang/String;
    //   250: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   253: pop
    //   254: invokestatic 573	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   257: invokevirtual 576	java/lang/Thread:getId	()J
    //   260: lconst_1
    //   261: lcmp
    //   262: ifne +207 -> 469
    //   265: aload 4
    //   267: ldc_w 598
    //   270: getstatic 601	crittercism/android/a$a:c	Ljava/lang/String;
    //   273: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   276: pop
    //   277: aload 4
    //   279: ldc_w 603
    //   282: aload_3
    //   283: getfield 605	crittercism/android/k:d	Lorg/json/JSONArray;
    //   286: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload_3
    //   291: aload 4
    //   293: invokevirtual 608	crittercism/android/k:a	(Ljava/lang/Object;)V
    //   296: aload_2
    //   297: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   300: getfield 611	crittercism/android/k:g	Ljava/util/Date;
    //   303: astore_0
    //   304: aload_0
    //   305: ifnull +29 -> 334
    //   308: aload_0
    //   309: ifnull -290 -> 19
    //   312: new 254	java/util/Date
    //   315: dup
    //   316: invokespecial 612	java/util/Date:<init>	()V
    //   319: invokestatic 614	com/crittercism/app/Crittercism:a	(Ljava/util/Date;)J
    //   322: aload_0
    //   323: invokestatic 614	com/crittercism/app/Crittercism:a	(Ljava/util/Date;)J
    //   326: lsub
    //   327: ldc2_w 615
    //   330: lcmp
    //   331: ifle -312 -> 19
    //   334: new 507	java/lang/Thread
    //   337: dup
    //   338: new 24	com/crittercism/app/Crittercism$8
    //   341: dup
    //   342: aload_2
    //   343: invokespecial 617	com/crittercism/app/Crittercism$8:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   346: invokespecial 510	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   349: invokevirtual 513	java/lang/Thread:start	()V
    //   352: goto -333 -> 19
    //   355: astore_0
    //   356: new 260	java/lang/StringBuilder
    //   359: dup
    //   360: ldc_w 619
    //   363: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   370: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   373: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: pop
    //   380: goto -361 -> 19
    //   383: astore_0
    //   384: new 260	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 621
    //   391: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload_0
    //   395: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   398: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   401: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: pop
    //   408: new 449	java/lang/String
    //   411: dup
    //   412: invokespecial 547	java/lang/String:<init>	()V
    //   415: astore_1
    //   416: aload_3
    //   417: new 449	java/lang/String
    //   420: dup
    //   421: invokespecial 547	java/lang/String:<init>	()V
    //   424: putfield 583	crittercism/android/k:c	Ljava/lang/String;
    //   427: aload_3
    //   428: new 292	org/json/JSONArray
    //   431: dup
    //   432: invokespecial 293	org/json/JSONArray:<init>	()V
    //   435: putfield 605	crittercism/android/k:d	Lorg/json/JSONArray;
    //   438: aload_3
    //   439: new 292	org/json/JSONArray
    //   442: dup
    //   443: invokespecial 293	org/json/JSONArray:<init>	()V
    //   446: putfield 594	crittercism/android/k:e	Lorg/json/JSONArray;
    //   449: aload_3
    //   450: new 303	org/json/JSONObject
    //   453: dup
    //   454: invokespecial 304	org/json/JSONObject:<init>	()V
    //   457: putfield 567	crittercism/android/k:f	Lorg/json/JSONObject;
    //   460: goto -327 -> 133
    //   463: astore_0
    //   464: ldc 2
    //   466: monitorexit
    //   467: aload_0
    //   468: athrow
    //   469: aload 4
    //   471: ldc_w 598
    //   474: getstatic 623	crittercism/android/a$a:d	Ljava/lang/String;
    //   477: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   480: pop
    //   481: goto -204 -> 277
    //   484: astore_0
    //   485: new 260	java/lang/StringBuilder
    //   488: dup
    //   489: ldc_w 625
    //   492: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   495: aload_0
    //   496: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   499: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   502: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: pop
    //   509: goto -219 -> 290
    //   512: astore_0
    //   513: new 260	java/lang/StringBuilder
    //   516: dup
    //   517: ldc_w 621
    //   520: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: aload_0
    //   524: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   527: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   530: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: pop
    //   537: goto -247 -> 290
    //   540: astore_0
    //   541: goto -522 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	paramThrowable	Throwable
    //   107	309	1	str	String
    //   33	310	2	localCrittercism	Crittercism
    //   87	363	3	localk	k
    //   95	375	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   296	304	355	java/lang/Exception
    //   312	334	355	java/lang/Exception
    //   334	352	355	java/lang/Exception
    //   108	120	383	java/lang/Exception
    //   120	133	383	java/lang/Exception
    //   3	19	463	finally
    //   23	105	463	finally
    //   108	120	463	finally
    //   120	133	463	finally
    //   133	277	463	finally
    //   277	290	463	finally
    //   290	296	463	finally
    //   296	304	463	finally
    //   312	334	463	finally
    //   334	352	463	finally
    //   356	380	463	finally
    //   384	460	463	finally
    //   469	481	463	finally
    //   485	509	463	finally
    //   513	537	463	finally
    //   133	277	484	org/json/JSONException
    //   277	290	484	org/json/JSONException
    //   469	481	484	org/json/JSONException
    //   133	277	512	java/lang/Exception
    //   277	290	512	java/lang/Exception
    //   469	481	512	java/lang/Exception
    //   23	105	540	java/lang/Exception
    //   290	296	540	java/lang/Exception
    //   356	380	540	java/lang/Exception
    //   384	460	540	java/lang/Exception
    //   485	509	540	java/lang/Exception
    //   513	537	540	java/lang/Exception
  }
  
  public static void sendAppLoadData()
  {
    if (c == null) {
      Log.w("Crittercism", "Failed to send app load data.  Please contact us at support@crittercism.com");
    }
    for (;;)
    {
      return;
      try
      {
        if (c.z)
        {
          if (getOptOutStatus() != true) {
            new Thread(new Runnable()
            {
              public final void run()
              {
                Thread localThread = new Thread(new Crittercism.a((byte)0));
                for (;;)
                {
                  if ((!Crittercism.c()) && (Crittercism.d(Crittercism.a()) != null) && (Crittercism.d(Crittercism.a()).isAlive())) {}
                  try
                  {
                    Crittercism.d(Crittercism.a()).join();
                  }
                  catch (InterruptedException localInterruptedException)
                  {
                    if (Crittercism.c())
                    {
                      localThread.start();
                      return;
                    }
                  }
                  catch (Exception localException)
                  {
                    Log.w("Crittercism", "Exception in Thread in sendAppLoadData");
                    localException.printStackTrace();
                  }
                }
              }
            }).start();
          }
        }
        else
        {
          Log.i("Crittercism", "sendAppLoadData() will only send data to Crittercism if \"delaySendingAppLoad\" is set to true in the configuration settings you include in the init call.");
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public static void setMetadata(final JSONObject paramJSONObject)
  {
    if (c == null)
    {
      Log.w("Crittercism", "Call to setMetadata() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    try
    {
      c.d.c(paramJSONObject);
      if (c.g)
      {
        new Thread(new Runnable()
        {
          public final void run()
          {
            try
            {
              Crittercism.e(Crittercism.this).b(paramJSONObject);
              return;
            }
            catch (Exception localException) {}
          }
        }).start();
        return;
      }
      Log.e("Crittercism", "Initialize the Crittercism library before using its methods.");
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void setOptOutStatus(boolean paramBoolean)
  {
    if (c == null)
    {
      Log.w("Crittercism", "Call to setOptOutStatus() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    new Thread(new d(paramBoolean)).start();
  }
  
  public static void setUsername(String paramString)
  {
    if (c == null)
    {
      Log.w("Crittercism", "Call to setUsername() failed.  Please contact us at support@crittercism.com.");
      return;
    }
    try
    {
      if (c.g)
      {
        if (c.f == null) {
          c.f = new e();
        }
        c.f.b = paramString;
        JSONObject localJSONObject = c.d.i();
        localJSONObject.put("username", paramString);
        setMetadata(localJSONObject);
        return;
      }
      Log.e("Crittercism", "Initialize the Crittercism library before using its methods.");
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean x()
  {
    if (c == null) {
      return false;
    }
    return c.p;
  }
  
  public static String z()
  {
    new String();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sZ", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(new Date());
  }
  
  public final void a(i parami)
  {
    this.j = parami;
  }
  
  public final void a(k paramk)
  {
    this.l = paramk;
  }
  
  public final void a(l paraml)
  {
    this.m = paraml;
  }
  
  public final void a(m paramm)
  {
    this.k = paramm;
  }
  
  public final boolean a(Throwable paramThrowable)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        m localm = this.k;
        localJSONObject = new JSONObject();
        new String();
        String str = "";
        try
        {
          if (paramThrowable.getMessage() != null) {
            str = paramThrowable.getMessage();
          }
          localm.a(paramThrowable);
          localm.d();
          localm.g();
        }
        catch (Exception paramThrowable)
        {
          boolean bool;
          new StringBuilder("Exception in addThrowableToVector: ").append(paramThrowable.getClass().getName()).toString();
          str = new String();
          localm.c = new String();
          localm.d = new JSONArray();
          localm.e = new JSONArray();
          localm.f = new JSONObject();
          continue;
        }
      }
      finally {}
      try
      {
        localJSONObject.put("app_state", c.d.a(new boolean[] { 1, 1 }));
        localJSONObject.put("breadcrumbs", localm.f);
        localJSONObject.put("current_thread_id", Thread.currentThread().getId());
        localJSONObject.put("exception_name", localm.c);
        localJSONObject.put("exception_reason", str);
        localJSONObject.put("platform", "android");
        localJSONObject.put("threads", localm.e);
        localJSONObject.put("ts", z());
        if (Thread.currentThread().getId() != 1L) {
          break label322;
        }
        localJSONObject.put("type", a.a.a);
        localJSONObject.put("unsymbolized_stacktrace", localm.d);
      }
      catch (JSONException paramThrowable)
      {
        new StringBuilder("JSONException in addThrowableToVector: ").append(paramThrowable.getClass().getName()).toString();
        continue;
      }
      catch (Exception paramThrowable)
      {
        new StringBuilder("Exception in addThrowableToVector: ").append(paramThrowable.getClass().getName()).toString();
        continue;
      }
      localm.a(localJSONObject);
      bool = g();
      return bool;
      label322:
      localJSONObject.put("type", a.a.b);
    }
  }
  
  public final void b()
  {
    this.j.b();
    try
    {
      if (!this.z)
      {
        if (getOptOutStatus() == true) {
          return;
        }
        e();
        g();
        i();
        k();
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public final void d()
  {
    this.s = true;
  }
  
  /* Error */
  public final boolean e()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: new 405	java/util/concurrent/FutureTask
    //   7: dup
    //   8: new 20	com/crittercism/app/Crittercism$6
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 691	com/crittercism/app/Crittercism$6:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   16: invokespecial 409	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   19: astore 4
    //   21: bipush 10
    //   23: invokestatic 415	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   26: astore 5
    //   28: aload 5
    //   30: aload 4
    //   32: invokeinterface 421 2 0
    //   37: iconst_0
    //   38: istore_2
    //   39: aload 4
    //   41: invokevirtual 424	java/util/concurrent/FutureTask:isDone	()Z
    //   44: ifne +24 -> 68
    //   47: aload 4
    //   49: ldc2_w 425
    //   52: getstatic 432	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: invokevirtual 436	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   58: checkcast 438	java/lang/Boolean
    //   61: invokevirtual 441	java/lang/Boolean:booleanValue	()Z
    //   64: istore_2
    //   65: goto -26 -> 39
    //   68: iload_1
    //   69: ifeq +17 -> 86
    //   72: aload_0
    //   73: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   76: invokevirtual 693	crittercism/android/b:h	()V
    //   79: aload_0
    //   80: getfield 105	com/crittercism/app/Crittercism:j	Lcrittercism/android/i;
    //   83: invokevirtual 695	crittercism/android/i:f	()V
    //   86: new 260	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 697
    //   93: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: astore 5
    //   98: iload_2
    //   99: ifeq +67 -> 166
    //   102: ldc_w 699
    //   105: astore 4
    //   107: aload 5
    //   109: aload 4
    //   111: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: pop
    //   118: iload_2
    //   119: ireturn
    //   120: astore 4
    //   122: iconst_1
    //   123: istore_1
    //   124: iload_3
    //   125: istore_2
    //   126: goto -58 -> 68
    //   129: astore 4
    //   131: iconst_0
    //   132: istore_2
    //   133: goto -65 -> 68
    //   136: astore 4
    //   138: new 260	java/lang/StringBuilder
    //   141: dup
    //   142: ldc_w 701
    //   145: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: aload 4
    //   150: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   153: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   156: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: pop
    //   163: goto -77 -> 86
    //   166: ldc_w 703
    //   169: astore 4
    //   171: goto -64 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	Crittercism
    //   3	121	1	i1	int
    //   38	95	2	bool1	boolean
    //   1	124	3	bool2	boolean
    //   19	91	4	localObject1	Object
    //   120	1	4	localTimeoutException	java.util.concurrent.TimeoutException
    //   129	1	4	localException1	Exception
    //   136	13	4	localException2	Exception
    //   169	1	4	str	String
    //   26	82	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	120	java/util/concurrent/TimeoutException
    //   39	65	120	java/util/concurrent/TimeoutException
    //   28	37	129	java/lang/Exception
    //   39	65	129	java/lang/Exception
    //   72	86	136	java/lang/Exception
  }
  
  /* Error */
  public final boolean f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: new 303	org/json/JSONObject
    //   8: dup
    //   9: invokespecial 304	org/json/JSONObject:<init>	()V
    //   12: astore 4
    //   14: new 303	org/json/JSONObject
    //   17: dup
    //   18: invokespecial 304	org/json/JSONObject:<init>	()V
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 105	com/crittercism/app/Crittercism:j	Lcrittercism/android/i;
    //   27: invokevirtual 705	crittercism/android/i:c	()Lorg/json/JSONObject;
    //   30: astore 6
    //   32: aload 6
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   40: aload 4
    //   42: invokevirtual 708	crittercism/android/b:a	(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   45: astore 4
    //   47: iload_3
    //   48: istore_2
    //   49: aload 4
    //   51: ldc_w 710
    //   54: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   57: ifeq +35 -> 92
    //   60: aload 4
    //   62: ldc_w 710
    //   65: invokevirtual 714	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   68: istore_1
    //   69: iload_3
    //   70: istore_2
    //   71: iload_1
    //   72: iconst_1
    //   73: if_icmpne +19 -> 92
    //   76: aload_0
    //   77: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   80: invokevirtual 693	crittercism/android/b:h	()V
    //   83: aload_0
    //   84: getfield 105	com/crittercism/app/Crittercism:j	Lcrittercism/android/i;
    //   87: invokevirtual 695	crittercism/android/i:f	()V
    //   90: iconst_1
    //   91: istore_2
    //   92: new 303	org/json/JSONObject
    //   95: dup
    //   96: invokespecial 304	org/json/JSONObject:<init>	()V
    //   99: pop
    //   100: aload 4
    //   102: ldc_w 716
    //   105: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   108: ifeq +510 -> 618
    //   111: aload 4
    //   113: ldc_w 716
    //   116: invokevirtual 720	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   119: invokestatic 723	crittercism/android/e:a	(Lorg/json/JSONObject;)Lcrittercism/android/e;
    //   122: astore 5
    //   124: aload 5
    //   126: ifnull +62 -> 188
    //   129: aload 7
    //   131: astore 6
    //   133: aload_0
    //   134: getfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   137: ifnull +31 -> 168
    //   140: aload 7
    //   142: astore 6
    //   144: aload_0
    //   145: getfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   148: getfield 656	crittercism/android/e:b	Ljava/lang/String;
    //   151: ldc -122
    //   153: invokevirtual 727	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifne +12 -> 168
    //   159: aload_0
    //   160: getfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   163: getfield 656	crittercism/android/e:b	Ljava/lang/String;
    //   166: astore 6
    //   168: aload_0
    //   169: aload 5
    //   171: putfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   174: aload 6
    //   176: ifnull +12 -> 188
    //   179: aload_0
    //   180: getfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   183: aload 6
    //   185: putfield 656	crittercism/android/e:b	Ljava/lang/String;
    //   188: aload 4
    //   190: ldc_w 729
    //   193: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   196: ifeq +105 -> 301
    //   199: aload 4
    //   201: ldc_w 729
    //   204: invokevirtual 720	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   207: astore 4
    //   209: aload 4
    //   211: ldc_w 731
    //   214: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   217: ifeq +84 -> 301
    //   220: aload 4
    //   222: ldc_w 731
    //   225: invokevirtual 720	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   228: astore 5
    //   230: aload 5
    //   232: ldc_w 733
    //   235: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   238: ifeq +63 -> 301
    //   241: new 260	java/lang/StringBuilder
    //   244: dup
    //   245: ldc_w 735
    //   248: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: astore 6
    //   253: aload 5
    //   255: ldc_w 733
    //   258: invokevirtual 714	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   261: iconst_1
    //   262: if_icmpne +270 -> 532
    //   265: ldc_w 380
    //   268: astore 4
    //   270: aload 6
    //   272: aload 4
    //   274: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: pop
    //   281: aload 5
    //   283: ldc_w 733
    //   286: invokevirtual 714	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   289: iconst_1
    //   290: if_icmpne +11 -> 301
    //   293: aload_0
    //   294: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   297: invokevirtual 737	crittercism/android/b:g	()Ljava/lang/String;
    //   300: pop
    //   301: aload_0
    //   302: getfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   305: ifnull +121 -> 426
    //   308: aload_0
    //   309: getfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   312: astore 5
    //   314: aload 5
    //   316: getfield 738	crittercism/android/e:a	Ljava/lang/String;
    //   319: astore 4
    //   321: aload 5
    //   323: ldc -122
    //   325: putfield 738	crittercism/android/e:a	Ljava/lang/String;
    //   328: new 260	java/lang/StringBuilder
    //   331: dup
    //   332: ldc_w 740
    //   335: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   338: aload 4
    //   340: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: pop
    //   347: new 260	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 742
    //   354: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload_0
    //   358: getfield 94	com/crittercism/app/Crittercism:f	Lcrittercism/android/e;
    //   361: getfield 656	crittercism/android/e:b	Ljava/lang/String;
    //   364: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: pop
    //   371: aload 4
    //   373: ifnull +53 -> 426
    //   376: aload 4
    //   378: ldc -122
    //   380: invokevirtual 727	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: ifne +43 -> 426
    //   386: aload_0
    //   387: getfield 159	com/crittercism/app/Crittercism:b	Landroid/os/Handler;
    //   390: invokestatic 748	android/os/Message:obtain	(Landroid/os/Handler;)Landroid/os/Message;
    //   393: astore 5
    //   395: new 750	android/os/Bundle
    //   398: dup
    //   399: invokespecial 751	android/os/Bundle:<init>	()V
    //   402: astore 6
    //   404: aload 6
    //   406: ldc_w 753
    //   409: aload 4
    //   411: invokevirtual 757	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: aload 5
    //   416: aload 6
    //   418: invokevirtual 761	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   421: aload 5
    //   423: invokevirtual 764	android/os/Message:sendToTarget	()V
    //   426: iload_2
    //   427: ireturn
    //   428: astore 6
    //   430: aload 5
    //   432: astore 4
    //   434: iconst_0
    //   435: istore_2
    //   436: aload 6
    //   438: astore 5
    //   440: new 260	java/lang/StringBuilder
    //   443: dup
    //   444: ldc_w 766
    //   447: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   450: aload 5
    //   452: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   455: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   458: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: pop
    //   465: goto -373 -> 92
    //   468: astore 5
    //   470: new 260	java/lang/StringBuilder
    //   473: dup
    //   474: ldc_w 768
    //   477: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   480: aload 5
    //   482: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   485: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   488: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: pop
    //   495: goto +123 -> 618
    //   498: astore 5
    //   500: new 260	java/lang/StringBuilder
    //   503: dup
    //   504: ldc_w 770
    //   507: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   510: aload 5
    //   512: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   515: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   518: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: pop
    //   525: goto -337 -> 188
    //   528: astore 4
    //   530: iload_2
    //   531: ireturn
    //   532: ldc_w 382
    //   535: astore 4
    //   537: goto -267 -> 270
    //   540: astore 4
    //   542: new 260	java/lang/StringBuilder
    //   545: dup
    //   546: ldc_w 772
    //   549: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: aload 4
    //   554: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   557: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   560: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: pop
    //   567: goto -266 -> 301
    //   570: astore 4
    //   572: new 260	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 774
    //   579: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 4
    //   584: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   587: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   590: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: pop
    //   597: iload_2
    //   598: ireturn
    //   599: astore 5
    //   601: iconst_0
    //   602: istore_2
    //   603: goto -163 -> 440
    //   606: astore 5
    //   608: iconst_1
    //   609: istore_2
    //   610: goto -170 -> 440
    //   613: astore 6
    //   615: goto -579 -> 36
    //   618: aconst_null
    //   619: astore 5
    //   621: goto -497 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	Crittercism
    //   68	6	1	i1	int
    //   48	562	2	bool1	boolean
    //   4	66	3	bool2	boolean
    //   12	421	4	localObject1	Object
    //   528	1	4	localException1	Exception
    //   535	1	4	str	String
    //   540	13	4	localException2	Exception
    //   570	13	4	localException3	Exception
    //   21	430	5	localObject2	Object
    //   468	13	5	localException4	Exception
    //   498	13	5	localException5	Exception
    //   599	1	5	localException6	Exception
    //   606	1	5	localException7	Exception
    //   619	1	5	localObject3	Object
    //   30	387	6	localObject4	Object
    //   428	9	6	localException8	Exception
    //   613	1	6	localException9	Exception
    //   1	140	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   36	47	428	java/lang/Exception
    //   100	124	468	java/lang/Exception
    //   133	140	498	java/lang/Exception
    //   144	168	498	java/lang/Exception
    //   168	174	498	java/lang/Exception
    //   179	188	498	java/lang/Exception
    //   92	100	528	java/lang/Exception
    //   470	495	528	java/lang/Exception
    //   500	525	528	java/lang/Exception
    //   542	567	528	java/lang/Exception
    //   572	597	528	java/lang/Exception
    //   188	265	540	java/lang/Exception
    //   270	301	540	java/lang/Exception
    //   301	371	570	java/lang/Exception
    //   376	426	570	java/lang/Exception
    //   49	69	599	java/lang/Exception
    //   76	90	606	java/lang/Exception
    //   23	32	613	java/lang/Exception
  }
  
  /* Error */
  public final boolean g()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: new 405	java/util/concurrent/FutureTask
    //   7: dup
    //   8: new 22	com/crittercism/app/Crittercism$7
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 775	com/crittercism/app/Crittercism$7:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   16: invokespecial 409	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   19: astore 4
    //   21: bipush 10
    //   23: invokestatic 415	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   26: astore 5
    //   28: aload 5
    //   30: aload 4
    //   32: invokeinterface 421 2 0
    //   37: iconst_0
    //   38: istore_2
    //   39: aload 4
    //   41: invokevirtual 424	java/util/concurrent/FutureTask:isDone	()Z
    //   44: ifne +24 -> 68
    //   47: aload 4
    //   49: ldc2_w 425
    //   52: getstatic 432	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: invokevirtual 436	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   58: checkcast 438	java/lang/Boolean
    //   61: invokevirtual 441	java/lang/Boolean:booleanValue	()Z
    //   64: istore_2
    //   65: goto -26 -> 39
    //   68: iload_1
    //   69: ifeq +10 -> 79
    //   72: aload_0
    //   73: getfield 110	com/crittercism/app/Crittercism:k	Lcrittercism/android/m;
    //   76: invokevirtual 776	crittercism/android/m:f	()V
    //   79: new 260	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 778
    //   86: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: astore 5
    //   91: iload_2
    //   92: ifeq +67 -> 159
    //   95: ldc_w 699
    //   98: astore 4
    //   100: aload 5
    //   102: aload 4
    //   104: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: pop
    //   111: iload_2
    //   112: ireturn
    //   113: astore 4
    //   115: iconst_1
    //   116: istore_1
    //   117: iload_3
    //   118: istore_2
    //   119: goto -51 -> 68
    //   122: astore 4
    //   124: iconst_0
    //   125: istore_2
    //   126: goto -58 -> 68
    //   129: astore 4
    //   131: new 260	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 780
    //   138: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload 4
    //   143: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   146: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   149: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: pop
    //   156: goto -77 -> 79
    //   159: ldc_w 703
    //   162: astore 4
    //   164: goto -64 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	Crittercism
    //   3	114	1	i1	int
    //   38	88	2	bool1	boolean
    //   1	117	3	bool2	boolean
    //   19	84	4	localObject1	Object
    //   113	1	4	localTimeoutException	java.util.concurrent.TimeoutException
    //   122	1	4	localException1	Exception
    //   129	13	4	localException2	Exception
    //   162	1	4	str	String
    //   26	75	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	113	java/util/concurrent/TimeoutException
    //   39	65	113	java/util/concurrent/TimeoutException
    //   28	37	122	java/lang/Exception
    //   39	65	122	java/lang/Exception
    //   72	79	129	java/lang/Exception
  }
  
  /* Error */
  public final boolean h()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 303	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 304	org/json/JSONObject:<init>	()V
    //   9: astore_3
    //   10: new 303	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 304	org/json/JSONObject:<init>	()V
    //   17: pop
    //   18: aload_0
    //   19: getfield 110	com/crittercism/app/Crittercism:k	Lcrittercism/android/m;
    //   22: invokevirtual 782	crittercism/android/m:b	()Lorg/json/JSONObject;
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload_0
    //   31: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   34: aload_3
    //   35: invokevirtual 708	crittercism/android/b:a	(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   38: astore_3
    //   39: aload_3
    //   40: ldc_w 710
    //   43: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   46: ifeq +63 -> 109
    //   49: aload_3
    //   50: ldc_w 710
    //   53: invokevirtual 714	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   56: istore_1
    //   57: iload_1
    //   58: iconst_1
    //   59: if_icmpne +50 -> 109
    //   62: aload_0
    //   63: getfield 110	com/crittercism/app/Crittercism:k	Lcrittercism/android/m;
    //   66: invokevirtual 776	crittercism/android/m:f	()V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_3
    //   72: iconst_0
    //   73: istore_2
    //   74: new 260	java/lang/StringBuilder
    //   77: dup
    //   78: ldc_w 784
    //   81: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_3
    //   85: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   88: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   91: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: pop
    //   98: iload_2
    //   99: ireturn
    //   100: astore_3
    //   101: goto -27 -> 74
    //   104: astore 4
    //   106: goto -76 -> 30
    //   109: iconst_0
    //   110: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	Crittercism
    //   56	4	1	i1	int
    //   1	98	2	bool	boolean
    //   9	41	3	localObject	Object
    //   71	14	3	localException1	Exception
    //   100	1	3	localException2	Exception
    //   25	3	4	localJSONObject	JSONObject
    //   104	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   30	57	71	java/lang/Exception
    //   62	69	100	java/lang/Exception
    //   18	27	104	java/lang/Exception
  }
  
  /* Error */
  public final boolean i()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: new 405	java/util/concurrent/FutureTask
    //   7: dup
    //   8: new 26	com/crittercism/app/Crittercism$9
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 785	com/crittercism/app/Crittercism$9:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   16: invokespecial 409	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   19: astore 4
    //   21: bipush 10
    //   23: invokestatic 415	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   26: astore 5
    //   28: aload 5
    //   30: aload 4
    //   32: invokeinterface 421 2 0
    //   37: iconst_0
    //   38: istore_2
    //   39: aload 4
    //   41: invokevirtual 424	java/util/concurrent/FutureTask:isDone	()Z
    //   44: ifne +24 -> 68
    //   47: aload 4
    //   49: ldc2_w 425
    //   52: getstatic 432	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: invokevirtual 436	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   58: checkcast 438	java/lang/Boolean
    //   61: invokevirtual 441	java/lang/Boolean:booleanValue	()Z
    //   64: istore_2
    //   65: goto -26 -> 39
    //   68: iload_1
    //   69: ifeq +27 -> 96
    //   72: aload_0
    //   73: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   76: aload_0
    //   77: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   80: invokevirtual 541	crittercism/android/k:e	()Ljava/util/Vector;
    //   83: invokevirtual 546	java/util/Vector:size	()I
    //   86: invokevirtual 788	crittercism/android/k:a	(I)V
    //   89: aload_0
    //   90: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   93: invokevirtual 789	crittercism/android/k:f	()V
    //   96: new 260	java/lang/StringBuilder
    //   99: dup
    //   100: ldc_w 791
    //   103: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: iload_2
    //   109: ifeq +67 -> 176
    //   112: ldc_w 699
    //   115: astore 4
    //   117: aload 5
    //   119: aload 4
    //   121: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: pop
    //   128: iload_2
    //   129: ireturn
    //   130: astore 4
    //   132: iconst_1
    //   133: istore_1
    //   134: iload_3
    //   135: istore_2
    //   136: goto -68 -> 68
    //   139: astore 4
    //   141: iconst_0
    //   142: istore_2
    //   143: goto -75 -> 68
    //   146: astore 4
    //   148: new 260	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 793
    //   155: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   163: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   166: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: pop
    //   173: goto -77 -> 96
    //   176: ldc_w 703
    //   179: astore 4
    //   181: goto -64 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	Crittercism
    //   3	131	1	i1	int
    //   38	105	2	bool1	boolean
    //   1	134	3	bool2	boolean
    //   19	101	4	localObject1	Object
    //   130	1	4	localTimeoutException	java.util.concurrent.TimeoutException
    //   139	1	4	localException1	Exception
    //   146	13	4	localException2	Exception
    //   179	1	4	str	String
    //   26	92	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	130	java/util/concurrent/TimeoutException
    //   39	65	130	java/util/concurrent/TimeoutException
    //   28	37	139	java/lang/Exception
    //   39	65	139	java/lang/Exception
    //   72	96	146	java/lang/Exception
  }
  
  /* Error */
  public final boolean j()
  {
    // Byte code:
    //   0: new 303	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 304	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: new 303	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 304	org/json/JSONObject:<init>	()V
    //   15: pop
    //   16: aload_0
    //   17: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   20: invokevirtual 794	crittercism/android/k:b	()Lorg/json/JSONObject;
    //   23: astore 4
    //   25: aload 4
    //   27: astore_3
    //   28: aload_0
    //   29: getfield 395	com/crittercism/app/Crittercism:d	Lcrittercism/android/b;
    //   32: aload_3
    //   33: invokevirtual 708	crittercism/android/b:a	(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc_w 710
    //   41: invokevirtual 311	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   44: ifeq +102 -> 146
    //   47: aload_3
    //   48: ldc_w 710
    //   51: invokevirtual 714	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_1
    //   57: if_icmpne +89 -> 146
    //   60: aload_0
    //   61: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   64: aload_0
    //   65: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   68: invokevirtual 541	crittercism/android/k:e	()Ljava/util/Vector;
    //   71: invokevirtual 546	java/util/Vector:size	()I
    //   74: invokevirtual 788	crittercism/android/k:a	(I)V
    //   77: aload_0
    //   78: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   81: invokevirtual 789	crittercism/android/k:f	()V
    //   84: iconst_1
    //   85: istore_2
    //   86: aload_0
    //   87: getfield 115	com/crittercism/app/Crittercism:l	Lcrittercism/android/k;
    //   90: new 254	java/util/Date
    //   93: dup
    //   94: invokespecial 612	java/util/Date:<init>	()V
    //   97: putfield 611	crittercism/android/k:g	Ljava/util/Date;
    //   100: iload_2
    //   101: ireturn
    //   102: astore_3
    //   103: iconst_0
    //   104: istore_2
    //   105: new 260	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 796
    //   112: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_3
    //   116: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   119: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   122: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: pop
    //   129: iload_2
    //   130: ireturn
    //   131: astore_3
    //   132: iconst_1
    //   133: istore_2
    //   134: goto -29 -> 105
    //   137: astore_3
    //   138: goto -33 -> 105
    //   141: astore 4
    //   143: goto -115 -> 28
    //   146: iconst_0
    //   147: istore_2
    //   148: goto -62 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	Crittercism
    //   54	4	1	i1	int
    //   85	63	2	bool	boolean
    //   7	41	3	localObject	Object
    //   102	14	3	localException1	Exception
    //   131	1	3	localException2	Exception
    //   137	1	3	localException3	Exception
    //   23	3	4	localJSONObject	JSONObject
    //   141	1	4	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   28	55	102	java/lang/Exception
    //   60	84	131	java/lang/Exception
    //   86	100	137	java/lang/Exception
    //   16	25	141	java/lang/Exception
  }
  
  /* Error */
  public final boolean k()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: new 405	java/util/concurrent/FutureTask
    //   7: dup
    //   8: new 8	com/crittercism/app/Crittercism$10
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 797	com/crittercism/app/Crittercism$10:<init>	(Lcom/crittercism/app/Crittercism;)V
    //   16: invokespecial 409	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   19: astore 4
    //   21: bipush 10
    //   23: invokestatic 415	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   26: astore 5
    //   28: aload 5
    //   30: aload 4
    //   32: invokeinterface 421 2 0
    //   37: iconst_0
    //   38: istore_2
    //   39: aload 4
    //   41: invokevirtual 424	java/util/concurrent/FutureTask:isDone	()Z
    //   44: ifne +24 -> 68
    //   47: aload 4
    //   49: ldc2_w 798
    //   52: getstatic 432	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: invokevirtual 436	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   58: checkcast 438	java/lang/Boolean
    //   61: invokevirtual 441	java/lang/Boolean:booleanValue	()Z
    //   64: istore_2
    //   65: goto -26 -> 39
    //   68: iload_1
    //   69: ifeq +17 -> 86
    //   72: aload_0
    //   73: getfield 120	com/crittercism/app/Crittercism:m	Lcrittercism/android/l;
    //   76: invokevirtual 800	crittercism/android/l:b	()V
    //   79: aload_0
    //   80: getfield 120	com/crittercism/app/Crittercism:m	Lcrittercism/android/l;
    //   83: invokevirtual 801	crittercism/android/l:f	()V
    //   86: new 260	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 803
    //   93: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: astore 5
    //   98: iload_2
    //   99: ifeq +67 -> 166
    //   102: ldc_w 699
    //   105: astore 4
    //   107: aload 5
    //   109: aload 4
    //   111: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: pop
    //   118: iload_2
    //   119: ireturn
    //   120: astore 4
    //   122: iconst_1
    //   123: istore_1
    //   124: iload_3
    //   125: istore_2
    //   126: goto -58 -> 68
    //   129: astore 4
    //   131: iconst_0
    //   132: istore_2
    //   133: goto -65 -> 68
    //   136: astore 4
    //   138: new 260	java/lang/StringBuilder
    //   141: dup
    //   142: ldc_w 805
    //   145: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: aload 4
    //   150: invokevirtual 362	java/lang/Object:getClass	()Ljava/lang/Class;
    //   153: invokevirtual 367	java/lang/Class:getName	()Ljava/lang/String;
    //   156: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: pop
    //   163: goto -77 -> 86
    //   166: ldc_w 703
    //   169: astore 4
    //   171: goto -64 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	Crittercism
    //   3	121	1	i1	int
    //   38	95	2	bool1	boolean
    //   1	124	3	bool2	boolean
    //   19	91	4	localObject1	Object
    //   120	1	4	localTimeoutException	java.util.concurrent.TimeoutException
    //   129	1	4	localException1	Exception
    //   136	13	4	localException2	Exception
    //   169	1	4	str	String
    //   26	82	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	120	java/util/concurrent/TimeoutException
    //   39	65	120	java/util/concurrent/TimeoutException
    //   28	37	129	java/lang/Exception
    //   39	65	129	java/lang/Exception
    //   72	86	136	java/lang/Exception
  }
  
  public final boolean l()
  {
    bool1 = true;
    bool2 = false;
    Object localObject = new JSONObject();
    new JSONObject();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = this.m.a();
        localObject = localJSONObject;
      }
      catch (Exception localException3)
      {
        int i1;
        continue;
        bool1 = false;
        continue;
      }
      try
      {
        localObject = this.d.a((JSONObject)localObject);
        if (!((JSONObject)localObject).has("success")) {
          continue;
        }
        i1 = ((JSONObject)localObject).getInt("success");
        if (i1 != 1) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.m.b();
          this.m.f();
          return bool1;
        }
        catch (Exception localException2)
        {
          new StringBuilder("Exception removing ndk dump files from disk in attemptToSendNdkCrashes: ").append(localException2.getClass().getName()).toString();
          return bool1;
        }
        localException1 = localException1;
        new StringBuilder("Exception obtaining or handling response object or clearing pending ndk filenames vector in attemptToSendNdkCrashes: ").append(localException1.getClass().getName()).toString();
        bool1 = bool2;
      }
    }
    if (!bool1) {}
  }
  
  public final String m()
  {
    if (this.d == null)
    {
      Log.w("Crittercism", "Failed to get app id.  Please contact us at support@crittercism.com.");
      return new String();
    }
    return this.d.a();
  }
  
  public final Context n()
  {
    return this.h;
  }
  
  public final b o()
  {
    return this.d;
  }
  
  public final d p()
  {
    return this.e;
  }
  
  public final i q()
  {
    return this.j;
  }
  
  public final m r()
  {
    return this.k;
  }
  
  public final k s()
  {
    return this.l;
  }
  
  public final l t()
  {
    return this.m;
  }
  
  public final String u()
  {
    try
    {
      if ((this.w == null) || (this.w.equals(""))) {
        this.w = this.h.getPackageName();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("Crittercism", "Call to getPackageName() failed.  Please contact us at support@crittercism.com.");
        this.w = new String();
      }
    }
    return this.w;
  }
  
  public final String v()
  {
    return this.y;
  }
  
  public final String w()
  {
    if (this.h == null) {
      return null;
    }
    d locald = this.e;
    return d.a(this.h, "com.crittercism.prefs.did");
  }
  
  public final int y()
  {
    try
    {
      float f1 = this.d.f();
      return (int)(f1 * 10.0F / 160.0F);
    }
    catch (Exception localException) {}
    return -1;
  }
  
  static final class a
    implements Runnable
  {
    public final void run()
    {
      try
      {
        Crittercism.a().e();
        Crittercism.a().g();
        Crittercism.a().i();
        Crittercism.a().k();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  static final class b
    implements Runnable
  {
    private String a = "";
    
    public b(String paramString)
    {
      this.a = paramString;
    }
    
    public final void run()
    {
      try
      {
        Crittercism.a(Crittercism.a(), this.a);
        return;
      }
      catch (Exception localException)
      {
        Log.w("Crittercism", "Failed to leave breadcrumb.  Please contact us at support@crittercism.com.");
      }
    }
  }
  
  final class c
    implements Thread.UncaughtExceptionHandler
  {
    private Thread.UncaughtExceptionHandler b;
    
    public c(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
    {
      this.b = paramUncaughtExceptionHandler;
    }
    
    public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      try
      {
        StringWriter localStringWriter = new StringWriter();
        paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
        if (!Crittercism.getOptOutStatus()) {
          Log.e("Crittercism", localStringWriter.toString());
        }
        try
        {
          if (Crittercism.a() == null) {
            throw new Exception("Failed to log error to Crittercism.");
          }
        }
        catch (Exception localException1)
        {
          Log.w("Crittercism", "Failed to log error with Crittercism.  Please contact us at support@crittercism.com.");
          new StringBuilder("Did not log error to Crittercism.  EXCEPTION: ").append(localException1.getClass().getName()).toString();
          return;
          if (!Crittercism.getOptOutStatus())
          {
            Crittercism.A();
            Crittercism.a().a(paramThrowable);
            Crittercism.a().i();
            SharedPreferences.Editor localEditor;
            if (Crittercism.a().q().e().size() > 0)
            {
              i locali = i.d();
              locali.a(Crittercism.a().q().e());
              Crittercism.a().a(locali);
              locali = Crittercism.a().q();
              try
              {
                localEditor = Crittercism.a().n().getSharedPreferences("com.crittercism.loads", 0).edit();
                localEditor.remove(i.a());
                localEditor.putString(i.a(), locali.c().toString());
                if (!localEditor.commit()) {
                  throw new Exception("commit failed");
                }
              }
              catch (Exception localException2) {}
            }
            if (Crittercism.a().r().e().size() > 0)
            {
              m localm = Crittercism.a().r();
              try
              {
                localEditor = Crittercism.a().n().getSharedPreferences("com.crittercism.crashes", 0).edit();
                localEditor.remove(m.a());
                localEditor.putString(m.a(), localm.b().toString());
                if (!localEditor.commit()) {
                  throw new Exception("commit failed");
                }
              }
              catch (Exception localException3) {}
            }
            if (Crittercism.a().s().e().size() > 0)
            {
              k localk = Crittercism.a().s();
              try
              {
                localEditor = Crittercism.a().n().getSharedPreferences("com.crittercism.exceptions", 0).edit();
                localEditor.remove(k.a());
                localEditor.putString(k.a(), localk.b().toString());
                if (!localEditor.commit()) {
                  throw new Exception("commit failed");
                }
              }
              catch (Exception localException4) {}
            }
          }
          return;
        }
        finally
        {
          if ((this.b != null) && (!(this.b instanceof c))) {
            this.b.uncaughtException(paramThread, paramThrowable);
          }
        }
      }
      catch (Exception localException5)
      {
        for (;;) {}
      }
    }
  }
  
  static final class d
    implements Runnable
  {
    private boolean a = false;
    
    public d(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public final void run()
    {
      try
      {
        Object localObject = Crittercism.a().n().getSharedPreferences("com.crittercism.prefs", 0).edit();
        ((SharedPreferences.Editor)localObject).remove("optOutStatus");
        ((SharedPreferences.Editor)localObject).putBoolean("optOutStatus", this.a);
        if (!((SharedPreferences.Editor)localObject).commit()) {
          throw new Exception();
        }
        StringBuilder localStringBuilder = new StringBuilder("Saved optOutStatus as ");
        if (this.a) {}
        for (localObject = "true";; localObject = "false")
        {
          localStringBuilder.append((String)localObject).append(" to SharedPreferences!!").toString();
          Crittercism.a(Crittercism.a(), this.a);
          return;
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/crittercism/app/Crittercism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */