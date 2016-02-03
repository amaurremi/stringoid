package crittercism.android;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.crittercism.app.Crittercism;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  final String a = "critter_did";
  final int b = 100;
  private final String c = d.b();
  private c d = null;
  private Context e = null;
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = null;
  private int k = 0;
  private boolean l = false;
  private String m = "";
  private JSONObject n = new JSONObject();
  private Object o = new Object();
  
  public b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.e = paramContext;
    this.d = new c(this.c, this.e);
    this.f = paramString1;
    this.g = null;
    this.h = paramString2;
    this.i = paramString3;
    this.k = paramInt;
    this.j = paramString4;
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.equals("")) {}
    }
    try
    {
      str = new String(new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(paramString.getBytes())).toString(16));
      if (str.equals("")) {
        return null;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        str = null;
      }
    }
    return str;
  }
  
  private int c(String paramString)
  {
    try
    {
      int i1 = this.e.getPackageManager().checkPermission(paramString, this.e.getPackageName());
      return i1;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  private double j()
  {
    double d2 = 1.0D;
    try
    {
      Intent localIntent = this.e.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      int i1 = localIntent.getIntExtra("level", -1);
      int i2 = localIntent.getIntExtra("scale", -1);
      double d3 = i2;
      double d1 = d2;
      if (i1 >= 0)
      {
        d1 = d2;
        if (d3 > 0.0D) {
          d1 = i1 / d3;
        }
      }
      return d1;
    }
    catch (Exception localException) {}
    return 1.0D;
  }
  
  private static long k()
  {
    int i1 = -1;
    try
    {
      Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
      Debug.getMemoryInfo(localMemoryInfo);
      int i2 = localMemoryInfo.dalvikPss;
      int i3 = localMemoryInfo.nativePss;
      int i4 = localMemoryInfo.otherPss;
      i1 = (i4 + (i2 + i3)) * 1024;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return i1;
  }
  
  private String l()
  {
    try
    {
      String str = ((TelephonyManager)this.e.getSystemService("phone")).getNetworkOperatorName();
      return str;
    }
    catch (Exception localException) {}
    return Build.BRAND;
  }
  
  private JSONObject m()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.e.getSystemService("connectivity")).getNetworkInfo(1);
      localJSONObject.put("available", localNetworkInfo.isAvailable());
      localJSONObject.put("connected", localNetworkInfo.isConnected());
      if (!localNetworkInfo.isConnected()) {
        localJSONObject.put("connecting", localNetworkInfo.isConnectedOrConnecting());
      }
      localJSONObject.put("failover", localNetworkInfo.isFailover());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      b.class.getCanonicalName();
      localException.toString();
    }
    return localJSONObject;
  }
  
  private JSONObject n()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.e.getSystemService("connectivity")).getNetworkInfo(0);
      localJSONObject.put("available", localNetworkInfo.isAvailable());
      localJSONObject.put("connected", localNetworkInfo.isConnected());
      if (!localNetworkInfo.isConnected()) {
        localJSONObject.put("connecting", localNetworkInfo.isConnectedOrConnecting());
      }
      localJSONObject.put("failover", localNetworkInfo.isFailover());
      localJSONObject.put("roaming", localNetworkInfo.isRoaming());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      b.class.getCanonicalName();
      new StringBuilder().append(localException.toString()).append(" in getMobileNetworkStatus").toString();
    }
    return localJSONObject;
  }
  
  private String o()
  {
    try
    {
      if (c("android.permission.GET_TASKS") == 0)
      {
        Object localObject = ((ActivityManager)this.e.getSystemService("activity")).getRunningTasks(1);
        new StringBuilder("CURRENT Activity ::").append(((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName()).toString();
        localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.flattenToShortString().replace("/", "");
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return "";
  }
  
  /* Error */
  private JSONArray p()
  {
    // Byte code:
    //   0: new 304	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 305	org/json/JSONArray:<init>	()V
    //   7: astore 4
    //   9: new 247	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 77	crittercism/android/b:o	Ljava/lang/Object;
    //   21: astore 6
    //   23: aload 6
    //   25: monitorenter
    //   26: invokestatic 311	java/util/concurrent/Executors:newCachedThreadPool	()Ljava/util/concurrent/ExecutorService;
    //   29: astore 7
    //   31: new 6	crittercism/android/b$a
    //   34: dup
    //   35: aload_0
    //   36: getfield 77	crittercism/android/b:o	Ljava/lang/Object;
    //   39: invokestatic 317	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   42: invokespecial 320	crittercism/android/b$a:<init>	(Ljava/lang/Object;Ljava/lang/Thread;)V
    //   45: astore 9
    //   47: aload 7
    //   49: aload 9
    //   51: invokeinterface 326 2 0
    //   56: astore 8
    //   58: invokestatic 328	crittercism/android/b$a:a	()Z
    //   61: ifne +242 -> 303
    //   64: aload 8
    //   66: ldc2_w 329
    //   69: getstatic 336	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   72: invokeinterface 341 4 0
    //   77: checkcast 247	java/lang/StringBuilder
    //   80: astore 5
    //   82: aload 5
    //   84: astore_3
    //   85: aload 8
    //   87: iconst_1
    //   88: invokeinterface 345 2 0
    //   93: pop
    //   94: aload 7
    //   96: invokeinterface 349 1 0
    //   101: pop
    //   102: aload 6
    //   104: monitorexit
    //   105: aload_3
    //   106: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokevirtual 353	java/lang/String:length	()I
    //   112: ifle +100 -> 212
    //   115: aload_3
    //   116: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: ldc_w 355
    //   122: invokevirtual 359	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   125: astore_3
    //   126: iconst_0
    //   127: istore_1
    //   128: iload_1
    //   129: aload_3
    //   130: arraylength
    //   131: if_icmpge +81 -> 212
    //   134: aload 4
    //   136: aload_3
    //   137: iload_1
    //   138: aaload
    //   139: invokevirtual 362	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   142: pop
    //   143: iload_1
    //   144: iconst_1
    //   145: iadd
    //   146: istore_1
    //   147: goto -19 -> 128
    //   150: astore 5
    //   152: invokestatic 364	crittercism/android/b$a:b	()V
    //   155: aload 9
    //   157: invokevirtual 366	crittercism/android/b$a:c	()V
    //   160: ldc2_w 367
    //   163: invokestatic 372	java/lang/Thread:sleep	(J)V
    //   166: aload 8
    //   168: iconst_1
    //   169: invokeinterface 345 2 0
    //   174: pop
    //   175: aload 7
    //   177: invokeinterface 349 1 0
    //   182: pop
    //   183: goto -81 -> 102
    //   186: astore_3
    //   187: aload 8
    //   189: iconst_1
    //   190: invokeinterface 345 2 0
    //   195: pop
    //   196: aload 7
    //   198: invokeinterface 349 1 0
    //   203: pop
    //   204: aload_3
    //   205: athrow
    //   206: astore_3
    //   207: aload 6
    //   209: monitorexit
    //   210: aload_3
    //   211: athrow
    //   212: aload 4
    //   214: invokevirtual 373	org/json/JSONArray:length	()I
    //   217: istore_2
    //   218: iload_2
    //   219: bipush 100
    //   221: if_icmple +77 -> 298
    //   224: new 304	org/json/JSONArray
    //   227: dup
    //   228: invokespecial 305	org/json/JSONArray:<init>	()V
    //   231: astore 5
    //   233: iload_2
    //   234: bipush 100
    //   236: isub
    //   237: istore_1
    //   238: aload 5
    //   240: astore_3
    //   241: iload_1
    //   242: iload_2
    //   243: if_icmpge +58 -> 301
    //   246: aload 5
    //   248: aload 4
    //   250: iload_1
    //   251: invokevirtual 376	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   254: invokevirtual 362	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   257: pop
    //   258: iload_1
    //   259: iconst_1
    //   260: iadd
    //   261: istore_1
    //   262: goto -24 -> 238
    //   265: astore_3
    //   266: new 247	java/lang/StringBuilder
    //   269: dup
    //   270: ldc_w 378
    //   273: invokespecial 270	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: aload_3
    //   277: invokevirtual 382	java/lang/Object:getClass	()Ljava/lang/Class;
    //   280: invokevirtual 385	java/lang/Class:getName	()Ljava/lang/String;
    //   283: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: pop
    //   290: goto -32 -> 258
    //   293: astore 5
    //   295: goto -129 -> 166
    //   298: aload 4
    //   300: astore_3
    //   301: aload_3
    //   302: areturn
    //   303: goto -218 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	b
    //   127	135	1	i1	int
    //   217	27	2	i2	int
    //   16	121	3	localObject1	Object
    //   186	19	3	localObject2	Object
    //   206	5	3	localObject3	Object
    //   240	1	3	localObject4	Object
    //   265	12	3	localJSONException	JSONException
    //   300	2	3	localJSONArray1	JSONArray
    //   7	292	4	localJSONArray2	JSONArray
    //   80	3	5	localStringBuilder	StringBuilder
    //   150	1	5	localException	Exception
    //   231	16	5	localJSONArray3	JSONArray
    //   293	1	5	localInterruptedException	InterruptedException
    //   21	187	6	localObject5	Object
    //   29	168	7	localExecutorService	java.util.concurrent.ExecutorService
    //   56	132	8	localFuture	java.util.concurrent.Future
    //   45	111	9	locala	a
    // Exception table:
    //   from	to	target	type
    //   58	82	150	java/lang/Exception
    //   58	82	186	finally
    //   152	160	186	finally
    //   160	166	186	finally
    //   26	58	206	finally
    //   85	102	206	finally
    //   102	105	206	finally
    //   166	183	206	finally
    //   187	206	206	finally
    //   246	258	265	org/json/JSONException
    //   160	166	293	java/lang/InterruptedException
  }
  
  private float q()
  {
    try
    {
      float f1 = this.e.getResources().getDisplayMetrics().ydpi;
      return f1;
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  private boolean r()
  {
    int i1 = 30;
    try
    {
      while ((!this.l) && (i1 > 0))
      {
        i1 -= 1;
        Thread.sleep(1000L);
      }
      return this.l;
    }
    catch (Exception localException) {}
  }
  
  public final String a()
  {
    return this.f;
  }
  
  /* Error */
  public final JSONObject a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 88	java/lang/String
    //   6: dup
    //   7: invokespecial 412	java/lang/String:<init>	()V
    //   10: astore 5
    //   12: new 72	org/json/JSONObject
    //   15: dup
    //   16: invokespecial 73	org/json/JSONObject:<init>	()V
    //   19: astore 6
    //   21: new 72	org/json/JSONObject
    //   24: dup
    //   25: invokespecial 73	org/json/JSONObject:<init>	()V
    //   28: astore 8
    //   30: new 88	java/lang/String
    //   33: dup
    //   34: invokespecial 412	java/lang/String:<init>	()V
    //   37: pop
    //   38: aload 5
    //   40: astore_3
    //   41: aload 5
    //   43: astore 4
    //   45: aload 8
    //   47: ldc_w 414
    //   50: iconst_0
    //   51: invokevirtual 417	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload 5
    //   57: astore_3
    //   58: aload 5
    //   60: astore 4
    //   62: aload_1
    //   63: ldc_w 419
    //   66: invokevirtual 421	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 5
    //   71: aload 5
    //   73: astore_3
    //   74: aload 5
    //   76: astore 4
    //   78: aload_1
    //   79: ldc_w 423
    //   82: invokevirtual 427	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   85: astore_1
    //   86: aload 5
    //   88: astore_3
    //   89: aload_1
    //   90: ldc_w 429
    //   93: invokevirtual 433	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   96: ifeq +303 -> 399
    //   99: aload_1
    //   100: ldc_w 435
    //   103: invokevirtual 433	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   106: ifeq +293 -> 399
    //   109: new 304	org/json/JSONArray
    //   112: dup
    //   113: invokespecial 305	org/json/JSONArray:<init>	()V
    //   116: pop
    //   117: aload_1
    //   118: ldc_w 429
    //   121: invokevirtual 439	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   124: astore 4
    //   126: aload 4
    //   128: invokevirtual 373	org/json/JSONArray:length	()I
    //   131: anewarray 88	java/lang/String
    //   134: astore 5
    //   136: iconst_0
    //   137: istore_2
    //   138: iload_2
    //   139: aload 4
    //   141: invokevirtual 373	org/json/JSONArray:length	()I
    //   144: if_icmpge +45 -> 189
    //   147: aload 5
    //   149: iload_2
    //   150: aload 4
    //   152: iload_2
    //   153: invokevirtual 376	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   156: aastore
    //   157: iload_2
    //   158: iconst_1
    //   159: iadd
    //   160: istore_2
    //   161: goto -23 -> 138
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 442	org/json/JSONException:printStackTrace	()V
    //   169: aload 6
    //   171: astore_1
    //   172: goto -83 -> 89
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 443	java/lang/Exception:printStackTrace	()V
    //   180: aload 4
    //   182: astore_3
    //   183: aload 6
    //   185: astore_1
    //   186: goto -97 -> 89
    //   189: aload_1
    //   190: ldc_w 435
    //   193: invokevirtual 421	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 4
    //   198: aload_1
    //   199: ldc_w 429
    //   202: invokevirtual 446	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   205: pop
    //   206: aload_1
    //   207: ldc_w 435
    //   210: invokevirtual 446	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   213: pop
    //   214: aload 5
    //   216: ifnull +113 -> 329
    //   219: aload 4
    //   221: ifnull +108 -> 329
    //   224: aload_0
    //   225: getfield 44	crittercism/android/b:d	Lcrittercism/android/c;
    //   228: aload_3
    //   229: aload_1
    //   230: aload 5
    //   232: aload 4
    //   234: invokevirtual 449	crittercism/android/c:a	(Ljava/lang/String;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   237: astore 4
    //   239: aload 4
    //   241: ifnull +155 -> 396
    //   244: aload 4
    //   246: ldc 48
    //   248: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +145 -> 396
    //   254: new 72	org/json/JSONObject
    //   257: dup
    //   258: aload 4
    //   260: invokespecial 450	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   263: astore 4
    //   265: new 247	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 452
    //   272: invokespecial 270	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_3
    //   276: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 454
    //   282: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 455	org/json/JSONObject:toString	()Ljava/lang/String;
    //   289: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: pop
    //   296: new 247	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 457
    //   303: invokespecial 270	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: aload 4
    //   308: invokevirtual 455	org/json/JSONObject:toString	()Ljava/lang/String;
    //   311: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: pop
    //   318: aload 4
    //   320: areturn
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 443	java/lang/Exception:printStackTrace	()V
    //   326: aload 8
    //   328: areturn
    //   329: aload_0
    //   330: getfield 44	crittercism/android/b:d	Lcrittercism/android/c;
    //   333: aload_3
    //   334: aload_1
    //   335: invokevirtual 460	crittercism/android/c:a	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   338: astore 4
    //   340: goto -101 -> 239
    //   343: astore_1
    //   344: aload_1
    //   345: athrow
    //   346: astore_1
    //   347: aload_1
    //   348: athrow
    //   349: astore_1
    //   350: new 247	java/lang/StringBuilder
    //   353: dup
    //   354: ldc_w 462
    //   357: invokespecial 270	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: aload_1
    //   361: invokevirtual 382	java/lang/Object:getClass	()Ljava/lang/Class;
    //   364: invokevirtual 385	java/lang/Class:getName	()Ljava/lang/String;
    //   367: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: pop
    //   374: new 72	org/json/JSONObject
    //   377: dup
    //   378: invokespecial 73	org/json/JSONObject:<init>	()V
    //   381: astore_1
    //   382: aload_1
    //   383: ldc_w 414
    //   386: iconst_0
    //   387: invokevirtual 417	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload_1
    //   392: areturn
    //   393: astore_3
    //   394: aload_1
    //   395: areturn
    //   396: aload 8
    //   398: areturn
    //   399: aconst_null
    //   400: astore 5
    //   402: aload 7
    //   404: astore 4
    //   406: goto -192 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	b
    //   0	409	1	paramJSONObject	JSONObject
    //   137	24	2	i1	int
    //   40	294	3	localObject1	Object
    //   393	1	3	localException	Exception
    //   43	362	4	localObject2	Object
    //   10	391	5	localObject3	Object
    //   19	165	6	localJSONObject1	JSONObject
    //   1	402	7	localObject4	Object
    //   28	369	8	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   45	55	164	org/json/JSONException
    //   62	71	164	org/json/JSONException
    //   78	86	164	org/json/JSONException
    //   45	55	175	java/lang/Exception
    //   62	71	175	java/lang/Exception
    //   78	86	175	java/lang/Exception
    //   89	136	321	java/lang/Exception
    //   138	157	321	java/lang/Exception
    //   189	214	321	java/lang/Exception
    //   224	239	343	crittercism/android/f
    //   244	318	343	crittercism/android/f
    //   329	340	343	crittercism/android/f
    //   224	239	346	java/io/IOException
    //   244	318	346	java/io/IOException
    //   329	340	346	java/io/IOException
    //   224	239	349	java/lang/Exception
    //   244	318	349	java/lang/Exception
    //   329	340	349	java/lang/Exception
    //   382	391	393	java/lang/Exception
  }
  
  public final JSONObject a(boolean... paramVarArgs)
  {
    int i1 = 0;
    int i2 = 1;
    if (paramVarArgs.length > 0) {}
    Object localObject1;
    for (int i3 = paramVarArgs[0];; i3 = 1)
    {
      if (paramVarArgs.length > 1) {}
      Object localObject2;
      label494:
      for (int i4 = paramVarArgs[1];; i4 = 0)
      {
        localObject2 = new JSONObject();
        for (;;)
        {
          try
          {
            localObject1 = d();
          }
          catch (Exception paramVarArgs)
          {
            localObject1 = localObject2;
            new StringBuilder("Exception with getStateInfo(): ").append(paramVarArgs.getClass().getName()).toString();
            return (JSONObject)localObject1;
          }
          try
          {
            ((JSONObject)localObject1).put("battery_level", j());
            ((JSONObject)localObject1).put("memory_usage", k());
            paramVarArgs = (ActivityManager)this.e.getSystemService("activity");
            localObject2 = new ActivityManager.MemoryInfo();
            paramVarArgs.getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
            if (((ActivityManager.MemoryInfo)localObject2).lowMemory) {
              i1 = 1;
            }
            ((JSONObject)localObject1).put("low_memory", i1);
            if (c("android.permission.ACCESS_NETWORK_STATE") == 0)
            {
              ((JSONObject)localObject1).put("wifi", m());
              ((JSONObject)localObject1).put("mobile_network", n());
            }
            ((JSONObject)localObject1).put("disk_space_free", h.a().toString());
            ((JSONObject)localObject1).put("disk_space_total", h.b().toString());
            ((JSONObject)localObject1).put("sd_space_free", h.c().toString());
            ((JSONObject)localObject1).put("sd_space_total", h.d().toString());
            i1 = this.e.getResources().getConfiguration().orientation;
            if (i1 != 0) {
              break label494;
            }
            paramVarArgs = ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay();
            if (paramVarArgs.getWidth() != paramVarArgs.getHeight()) {
              continue;
            }
            i1 = 3;
          }
          catch (Exception paramVarArgs)
          {
            continue;
            continue;
          }
          ((JSONObject)localObject1).put("orientation", i1);
          ((JSONObject)localObject1).put("activity", o());
          if (i4 != 0) {
            ((JSONObject)localObject1).put("metadata", this.n);
          }
          if (i3 != 0)
          {
            if (c("android.permission.READ_LOGS") == 0)
            {
              paramVarArgs = p();
              i1 = paramVarArgs.length();
              if (i1 <= 0) {
                break label509;
              }
              try
              {
                ((JSONObject)localObject1).put("logcat", paramVarArgs);
                return (JSONObject)localObject1;
              }
              catch (Exception paramVarArgs)
              {
                new StringBuilder("put logcat EXCEPTION: ").append(paramVarArgs.getClass().getName()).toString();
              }
              i1 = i2;
              if (paramVarArgs.getWidth() <= paramVarArgs.getHeight()) {
                continue;
              }
              i1 = 2;
              continue;
            }
            if ((Build.VERSION.SDK_INT >= 16) && (Crittercism.x()))
            {
              paramVarArgs = p();
              i1 = paramVarArgs.length();
              if (i1 > 0) {
                try
                {
                  ((JSONObject)localObject1).put("logcat", paramVarArgs);
                  return (JSONObject)localObject1;
                }
                catch (Exception paramVarArgs)
                {
                  new StringBuilder("put logcat EXCEPTION: ").append(paramVarArgs.getClass().getName()).toString();
                }
              }
            }
          }
          return (JSONObject)localObject1;
        }
      }
    }
    label509:
    return (JSONObject)localObject1;
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
  }
  
  public final String b()
  {
    Object localObject1 = Settings.Secure.getString(this.e.getContentResolver(), "android_id");
    if ((localObject1 != null) && (!((String)localObject1).equals("")) && (!"9774d56d682e549c".equals(localObject1)))
    {
      try
      {
        localObject1 = UUID.nameUUIDFromBytes(((String)localObject1).getBytes("utf8"));
        if (localObject1 == null) {
          break label141;
        }
        localObject3 = ((UUID)localObject1).toString();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject3 = null;
        }
      }
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (!((String)localObject3).equals("")) {}
      }
    }
    label141:
    Object localObject2;
    for (localObject1 = null;; localObject2 = null)
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (this.e.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", Crittercism.a().u()) == 0) {
          localObject3 = b(((TelephonyManager)this.e.getSystemService("phone")).getDeviceId());
        }
      }
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = UUID.randomUUID().toString();
      }
      return (String)localObject1;
    }
  }
  
  /* Error */
  public final boolean b(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ldc_w 620
    //   8: invokevirtual 433	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11: ifeq +111 -> 122
    //   14: aload_0
    //   15: aload_1
    //   16: ldc_w 620
    //   19: invokevirtual 421	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: putfield 70	crittercism/android/b:m	Ljava/lang/String;
    //   25: aload_0
    //   26: invokespecial 622	crittercism/android/b:r	()Z
    //   29: ifeq +140 -> 169
    //   32: new 72	org/json/JSONObject
    //   35: dup
    //   36: invokespecial 73	org/json/JSONObject:<init>	()V
    //   39: astore 4
    //   41: new 72	org/json/JSONObject
    //   44: dup
    //   45: invokespecial 73	org/json/JSONObject:<init>	()V
    //   48: pop
    //   49: aload_0
    //   50: invokevirtual 624	crittercism/android/b:c	()Lorg/json/JSONObject;
    //   53: astore 5
    //   55: aload 5
    //   57: ldc_w 553
    //   60: aload_1
    //   61: invokevirtual 499	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload 4
    //   67: ldc_w 419
    //   70: getstatic 628	crittercism/android/a$c:e	Ljava/lang/String;
    //   73: invokevirtual 499	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload 4
    //   79: ldc_w 423
    //   82: aload 5
    //   84: invokevirtual 499	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_0
    //   89: aload 4
    //   91: invokevirtual 630	crittercism/android/b:a	(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   94: astore_1
    //   95: aload_1
    //   96: ldc_w 414
    //   99: invokevirtual 433	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   102: ifeq +67 -> 169
    //   105: aload_1
    //   106: ldc_w 414
    //   109: invokevirtual 633	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   112: istore_2
    //   113: iload_2
    //   114: iconst_1
    //   115: if_icmpne +54 -> 169
    //   118: aload_0
    //   119: monitorexit
    //   120: iload_3
    //   121: ireturn
    //   122: aload_0
    //   123: getfield 70	crittercism/android/b:m	Ljava/lang/String;
    //   126: ldc 48
    //   128: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne -106 -> 25
    //   134: aload_1
    //   135: ldc_w 620
    //   138: aload_0
    //   139: getfield 70	crittercism/android/b:m	Ljava/lang/String;
    //   142: invokevirtual 499	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   145: pop
    //   146: goto -121 -> 25
    //   149: astore_1
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: astore_1
    //   158: ldc 2
    //   160: invokevirtual 238	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   163: pop
    //   164: aload_1
    //   165: invokevirtual 240	java/lang/Exception:toString	()Ljava/lang/String;
    //   168: pop
    //   169: iconst_0
    //   170: istore_3
    //   171: goto -53 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	b
    //   0	174	1	paramJSONObject	JSONObject
    //   112	4	2	i1	int
    //   1	170	3	bool	boolean
    //   39	51	4	localJSONObject1	JSONObject
    //   53	30	5	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   4	25	149	crittercism/android/f
    //   25	113	149	crittercism/android/f
    //   122	146	149	crittercism/android/f
    //   4	25	152	finally
    //   25	113	152	finally
    //   122	146	152	finally
    //   150	152	152	finally
    //   158	169	152	finally
    //   4	25	157	java/lang/Exception
    //   25	113	157	java/lang/Exception
    //   122	146	157	java/lang/Exception
  }
  
  public final JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("app_id", this.f);
      if (this.g == null) {
        this.g = b();
      }
      localJSONObject.put("hashed_device_id", this.g);
      localJSONObject.put("device_name", "android");
      localJSONObject.put("library_version", this.h);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      new StringBuilder("Exception in getRequiredParams(): ").append(localException.getClass().getName()).toString();
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    this.n = paramJSONObject;
  }
  
  public final JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("arch", System.getProperty("os.arch"));
      localJSONObject.put("locale", a.b(this.e));
      localJSONObject.put("dpi", e());
      localJSONObject.put("xdpi", f());
      localJSONObject.put("ydpi", q());
      localJSONObject.put("name", "");
      localJSONObject.put("system", "android");
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("carrier", l());
      localJSONObject.put("app_version", this.i);
      localJSONObject.put("system_version", Build.VERSION.RELEASE);
      localJSONObject.put("app_version_code", this.k);
      if ((this.j != null) && (this.j.length() > 0)) {
        localJSONObject.put("app_version", this.j);
      }
      return localJSONObject;
    }
    catch (Exception localException) {}
    return new JSONObject();
  }
  
  public final float e()
  {
    try
    {
      float f1 = this.e.getResources().getDisplayMetrics().density;
      return f1;
    }
    catch (Exception localException) {}
    return 1.0F;
  }
  
  public final float f()
  {
    try
    {
      float f1 = this.e.getResources().getDisplayMetrics().xdpi;
      return f1;
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  public final String g()
  {
    new JSONObject();
    new JSONObject();
    String str1 = new String();
    String str3 = str1;
    String str4 = str1;
    String str5 = str1;
    String str2 = str1;
    Object localObject;
    try
    {
      localObject = c();
      str3 = str1;
      str4 = str1;
      str5 = str1;
      str2 = str1;
      ((JSONObject)localObject).put("pkg", this.e.getPackageName());
      str3 = str1;
      str4 = str1;
      str5 = str1;
      str2 = str1;
      str1 = this.d.a(a.c.f, (JSONObject)localObject);
      localObject = str1;
      if (str1 != null)
      {
        str3 = str1;
        str4 = str1;
        str5 = str1;
        str2 = str1;
        localObject = str1;
        if (!str1.equals(""))
        {
          str3 = str1;
          str4 = str1;
          str5 = str1;
          str2 = str1;
          JSONObject localJSONObject = new JSONObject(str1);
          str3 = str1;
          str4 = str1;
          str5 = str1;
          str2 = str1;
          if (localJSONObject.has("success"))
          {
            str3 = str1;
            str4 = str1;
            str5 = str1;
            str2 = str1;
            localObject = str1;
            if (localJSONObject.getInt("success") == 1)
            {
              str3 = str1;
              str4 = str1;
              str5 = str1;
              str2 = str1;
              new StringBuilder("app_id: ").append(localJSONObject.getString("app_id")).toString();
              str3 = str1;
              str4 = str1;
              str5 = str1;
              str2 = str1;
              new StringBuilder("package name: ").append(localJSONObject.getString("pkg")).toString();
              str3 = str1;
              str4 = str1;
              str5 = str1;
              str2 = str1;
              new StringBuilder("updated settings: ").append(localJSONObject.getJSONObject("updated_settings")).toString();
              return str1;
            }
          }
          else
          {
            str3 = str1;
            str4 = str1;
            str5 = str1;
            str2 = str1;
            new StringBuilder().append(a.c.f).append(" response: ").append(str1).toString();
            return str1;
          }
        }
      }
    }
    catch (f localf)
    {
      return str3;
    }
    catch (Exception localException)
    {
      new StringBuilder("sendPackageName: Exception! ").append(localException.getClass().getName()).toString();
      return str4;
    }
    catch (JSONException localJSONException)
    {
      return str5;
    }
    catch (IOException localIOException)
    {
      localObject = str2;
    }
    return (String)localObject;
  }
  
  public final void h()
  {
    this.l = true;
  }
  
  public final JSONObject i()
  {
    return this.n;
  }
  
  static final class a
    implements Callable
  {
    private static boolean d = false;
    private static Object f;
    private StringBuilder a = new StringBuilder();
    private StringBuilder b = new StringBuilder();
    private String[] c;
    private Process e = null;
    private Thread g;
    private b.b h;
    private b.b i;
    
    public a(Object paramObject, Thread paramThread)
    {
      f = paramObject;
      this.g = paramThread;
      if (Build.VERSION.SDK_INT >= 8)
      {
        this.c = new String[5];
        this.c[0] = "logcat";
        this.c[1] = "-t";
        this.c[2] = "100";
        this.c[3] = "-v";
        this.c[4] = "time";
        return;
      }
      this.c = new String[4];
      this.c[0] = "logcat";
      this.c[1] = "-d";
      this.c[2] = "-v";
      this.c[3] = "time";
    }
    
    public static boolean a()
    {
      return d;
    }
    
    public static void b()
    {
      d = true;
    }
    
    /* Error */
    private StringBuilder d()
    {
      // Byte code:
      //   0: aload_0
      //   1: aconst_null
      //   2: putfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   5: aload_0
      //   6: aconst_null
      //   7: putfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   10: getstatic 28	crittercism/android/b$a:d	Z
      //   13: ifne +155 -> 168
      //   16: aload_0
      //   17: invokestatic 82	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   20: aload_0
      //   21: getfield 56	crittercism/android/b$a:c	[Ljava/lang/String;
      //   24: invokevirtual 86	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
      //   27: putfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   30: aload_0
      //   31: new 88	crittercism/android/b$b
      //   34: dup
      //   35: aload_0
      //   36: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   39: invokevirtual 94	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   42: invokespecial 97	crittercism/android/b$b:<init>	(Ljava/io/InputStream;)V
      //   45: putfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   48: aload_0
      //   49: new 88	crittercism/android/b$b
      //   52: dup
      //   53: aload_0
      //   54: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   57: invokevirtual 100	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   60: invokespecial 97	crittercism/android/b$b:<init>	(Ljava/io/InputStream;)V
      //   63: putfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   66: aload_0
      //   67: getfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   70: invokevirtual 103	crittercism/android/b$b:start	()V
      //   73: aload_0
      //   74: getfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   77: invokevirtual 103	crittercism/android/b$b:start	()V
      //   80: aload_0
      //   81: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   84: invokevirtual 107	java/lang/Process:waitFor	()I
      //   87: pop
      //   88: aload_0
      //   89: getfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   92: ifnull +14 -> 106
      //   95: aload_0
      //   96: aload_0
      //   97: getfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   100: invokevirtual 109	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   103: putfield 38	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   106: aload_0
      //   107: getfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   110: ifnull +14 -> 124
      //   113: aload_0
      //   114: aload_0
      //   115: getfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   118: invokevirtual 109	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   121: putfield 40	crittercism/android/b$a:b	Ljava/lang/StringBuilder;
      //   124: aload_0
      //   125: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   128: ifnull +40 -> 168
      //   131: aload_0
      //   132: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   135: invokevirtual 94	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   138: invokevirtual 114	java/io/InputStream:close	()V
      //   141: aload_0
      //   142: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   145: invokevirtual 100	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   148: invokevirtual 114	java/io/InputStream:close	()V
      //   151: aload_0
      //   152: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   155: invokevirtual 118	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   158: invokevirtual 121	java/io/OutputStream:close	()V
      //   161: aload_0
      //   162: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   165: invokevirtual 124	java/lang/Process:destroy	()V
      //   168: aload_0
      //   169: getfield 38	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   172: areturn
      //   173: astore_1
      //   174: iconst_1
      //   175: putstatic 28	crittercism/android/b$a:d	Z
      //   178: aload_0
      //   179: getfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   182: ifnull +14 -> 196
      //   185: aload_0
      //   186: aload_0
      //   187: getfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   190: invokevirtual 109	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   193: putfield 38	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   196: aload_0
      //   197: getfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   200: ifnull +14 -> 214
      //   203: aload_0
      //   204: aload_0
      //   205: getfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   208: invokevirtual 109	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   211: putfield 40	crittercism/android/b$a:b	Ljava/lang/StringBuilder;
      //   214: aload_0
      //   215: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   218: ifnull -50 -> 168
      //   221: aload_0
      //   222: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   225: invokevirtual 94	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   228: invokevirtual 114	java/io/InputStream:close	()V
      //   231: aload_0
      //   232: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   235: invokevirtual 100	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   238: invokevirtual 114	java/io/InputStream:close	()V
      //   241: aload_0
      //   242: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   245: invokevirtual 118	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   248: invokevirtual 121	java/io/OutputStream:close	()V
      //   251: aload_0
      //   252: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   255: invokevirtual 124	java/lang/Process:destroy	()V
      //   258: goto -90 -> 168
      //   261: astore_1
      //   262: goto -94 -> 168
      //   265: astore_1
      //   266: aload_0
      //   267: getfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   270: ifnull +14 -> 284
      //   273: aload_0
      //   274: aload_0
      //   275: getfield 74	crittercism/android/b$a:h	Lcrittercism/android/b$b;
      //   278: invokevirtual 109	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   281: putfield 38	crittercism/android/b$a:a	Ljava/lang/StringBuilder;
      //   284: aload_0
      //   285: getfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   288: ifnull +14 -> 302
      //   291: aload_0
      //   292: aload_0
      //   293: getfield 76	crittercism/android/b$a:i	Lcrittercism/android/b$b;
      //   296: invokevirtual 109	crittercism/android/b$b:a	()Ljava/lang/StringBuilder;
      //   299: putfield 40	crittercism/android/b$a:b	Ljava/lang/StringBuilder;
      //   302: aload_0
      //   303: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   306: ifnull +40 -> 346
      //   309: aload_0
      //   310: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   313: invokevirtual 94	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   316: invokevirtual 114	java/io/InputStream:close	()V
      //   319: aload_0
      //   320: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   323: invokevirtual 100	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   326: invokevirtual 114	java/io/InputStream:close	()V
      //   329: aload_0
      //   330: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   333: invokevirtual 118	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   336: invokevirtual 121	java/io/OutputStream:close	()V
      //   339: aload_0
      //   340: getfield 42	crittercism/android/b$a:e	Ljava/lang/Process;
      //   343: invokevirtual 124	java/lang/Process:destroy	()V
      //   346: aload_1
      //   347: athrow
      //   348: astore_2
      //   349: goto -3 -> 346
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	352	0	this	a
      //   173	1	1	localException1	Exception
      //   261	1	1	localException2	Exception
      //   265	82	1	localObject	Object
      //   348	1	2	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   16	88	173	java/lang/Exception
      //   131	168	261	java/lang/Exception
      //   221	258	261	java/lang/Exception
      //   16	88	265	finally
      //   174	178	265	finally
      //   309	346	348	java/lang/Exception
    }
    
    public final void c()
    {
      try
      {
        synchronized (f)
        {
          this.h.b();
          this.i.b();
          if (this.e != null)
          {
            this.e.getInputStream().close();
            this.e.getErrorStream().close();
            this.e.getOutputStream().close();
          }
        }
        try
        {
          if (this.e != null) {
            this.e.destroy();
          }
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  static final class b
    extends Thread
  {
    private InputStream a;
    private StringBuilder b = new StringBuilder();
    private BufferedReader c = null;
    
    public b(InputStream paramInputStream)
    {
      this.a = paramInputStream;
    }
    
    public final StringBuilder a()
    {
      return this.b;
    }
    
    public final void b()
    {
      if (this.c != null) {}
      try
      {
        this.c.close();
        return;
      }
      catch (Exception localException)
      {
        this.c = null;
      }
    }
    
    public final void run()
    {
      new String();
      this.c = new BufferedReader(new InputStreamReader(this.a));
      try
      {
        for (;;)
        {
          String str = this.c.readLine();
          if (str == null) {
            break;
          }
          this.b.append(str);
          this.b.append("\n");
        }
        try
        {
          this.c.close();
          throw ((Throwable)localObject);
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            new StringBuilder("CrittercismAPI.StreamThread$makeLogcatJsonArray: ERROR closing bufferedReader!!! ").append(localException4.getClass().getName()).toString();
          }
        }
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        for (;;)
        {
          try
          {
            this.c.close();
            return;
          }
          catch (Exception localException3)
          {
            new StringBuilder("CrittercismAPI.StreamThread$makeLogcatJsonArray: ERROR closing bufferedReader!!! ").append(localException3.getClass().getName()).toString();
            return;
          }
          try
          {
            this.c.close();
            return;
          }
          catch (Exception localException2)
          {
            new StringBuilder("CrittercismAPI.StreamThread$makeLogcatJsonArray: ERROR closing bufferedReader!!! ").append(localException2.getClass().getName()).toString();
            return;
          }
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */