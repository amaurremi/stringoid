package com.bugsense.trace;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

public class Utils
{
  public static final int STATE_DONT_KNOW = 2;
  public static final int STATE_OFF = 0;
  public static final int STATE_ON = 1;
  static final String crashCounterFile = "crashCounter";
  static final String lastCrashIDFile = "lastCrashID";
  static final Runtime rt = ;
  
  private static int CheckNetworkConnection(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      if (BugSenseHandler.I_WANT_TO_DEBUG) {
        Log.w(G.TAG, "Context in CheckNetworkConnection is null!");
      }
    }
    PackageManager localPackageManager;
    label62:
    do
    {
      do
      {
        for (;;)
        {
          return 2;
          try
          {
            localPackageManager = paramContext.getPackageManager();
            if (localPackageManager != null) {
              break label62;
            }
            if (BugSenseHandler.I_WANT_TO_DEBUG)
            {
              Log.w(G.TAG, "PackageManager in CheckNetworkConnection is null!");
              return 2;
            }
          }
          catch (NullPointerException paramContext) {}
        }
      } while (!BugSenseHandler.I_WANT_TO_DEBUG);
      paramContext.printStackTrace();
      return 2;
    } while (localPackageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", G.APP_PACKAGE) != 0);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      if (BugSenseHandler.I_WANT_TO_DEBUG)
      {
        Log.w(G.TAG, "ConnectivityManager in CheckNetworkConnection is null!");
        return 2;
      }
    }
    else
    {
      paramContext = paramContext.getAllNetworkInfo();
      int m = paramContext.length;
      int k = 0;
      for (int i = 2;; i = j)
      {
        j = i;
        if (k >= m) {
          break;
        }
        localPackageManager = paramContext[k];
        j = i;
        if (localPackageManager.getTypeName().equalsIgnoreCase(paramString))
        {
          boolean bool = localPackageManager.isConnected();
          j = i;
          if (bool) {
            j = 1;
          }
        }
        k += 1;
      }
    }
    int j = 2;
    return j;
  }
  
  public static String MD5(String paramString)
    throws Exception
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
    return new BigInteger(1, localMessageDigest.digest()).toString(16);
  }
  
  protected static String[] ScreenProperties(Context paramContext)
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "Not available";
    arrayOfString[1] = "Not available";
    arrayOfString[2] = "Not available";
    arrayOfString[3] = "Not available";
    arrayOfString[4] = "Not available";
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    int k = localDisplay.getOrientation();
    arrayOfString[0] = Integer.toString(i);
    arrayOfString[1] = Integer.toString(j);
    paramContext = "";
    switch (k)
    {
    }
    for (;;)
    {
      arrayOfString[2] = paramContext;
      localDisplay.getMetrics(localDisplayMetrics);
      arrayOfString[3] = Float.toString(localDisplayMetrics.xdpi);
      arrayOfString[4] = Float.toString(localDisplayMetrics.ydpi);
      return arrayOfString;
      paramContext = "normal";
      continue;
      paramContext = "180";
      continue;
      paramContext = "270";
      continue;
      paramContext = "90";
    }
  }
  
  protected static boolean checkForRoot()
  {
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "/sbin/";
    arrayOfString[1] = "/system/bin/";
    arrayOfString[2] = "/system/xbin/";
    arrayOfString[3] = "/data/local/xbin/";
    arrayOfString[4] = "/data/local/bin/";
    arrayOfString[5] = "/system/sd/xbin/";
    arrayOfString[6] = "/system/bin/failsafe/";
    arrayOfString[7] = "/data/local/";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (new File(str + "su").exists()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected static void clearCrashCounter()
  {
    Thread localThread = new Thread(new Runnable()
    {
      public void run()
      {
        File localFile = new File(G.FILES_PATH + "/" + "crashCounter");
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
      }
    });
    ExecutorService localExecutorService = BugSense.getExecutor();
    if ((localThread != null) && (localExecutorService != null)) {
      localExecutorService.submit(localThread);
    }
  }
  
  public static final String exceedLimitString(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() < 1)) {
      str = "";
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.length() == 128);
      str = paramString;
    } while (paramString.length() <= 128);
    return paramString.substring(0, 125) + "...";
  }
  
  public static String getAppsRunning(Context paramContext)
  {
    if (paramContext.getPackageManager().checkPermission("android.permission.GET_TASKS", G.APP_PACKAGE) == 0)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null) {
        return "0";
      }
      return String.valueOf(paramContext.size());
    }
    return "no_permissions";
  }
  
  /* Error */
  public static String getCPU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 299	android/os/Process:myPid	()I
    //   9: istore_1
    //   10: invokestatic 34	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: ldc_w 301
    //   16: invokevirtual 305	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   19: astore_2
    //   20: new 307	java/io/BufferedReader
    //   23: dup
    //   24: new 309	java/io/InputStreamReader
    //   27: dup
    //   28: aload_2
    //   29: invokevirtual 315	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   32: invokespecial 318	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   35: invokespecial 321	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore 4
    //   40: ldc_w 323
    //   43: astore_3
    //   44: aload 4
    //   46: invokevirtual 326	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +74 -> 127
    //   56: aload 5
    //   58: iload_1
    //   59: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq -21 -> 44
    //   68: aload 5
    //   70: ldc_w 332
    //   73: invokevirtual 336	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   76: astore 5
    //   78: aload 5
    //   80: ifnull -36 -> 44
    //   83: iconst_0
    //   84: istore_0
    //   85: iload_0
    //   86: aload 5
    //   88: arraylength
    //   89: if_icmpge -45 -> 44
    //   92: aload 5
    //   94: iload_0
    //   95: aaload
    //   96: ifnull +24 -> 120
    //   99: aload 5
    //   101: iload_0
    //   102: aaload
    //   103: ldc_w 338
    //   106: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +11 -> 120
    //   112: aload 5
    //   114: iload_0
    //   115: aaload
    //   116: astore_3
    //   117: goto -73 -> 44
    //   120: iload_0
    //   121: iconst_1
    //   122: iadd
    //   123: istore_0
    //   124: goto -39 -> 85
    //   127: aload 4
    //   129: ifnull +8 -> 137
    //   132: aload 4
    //   134: invokevirtual 341	java/io/BufferedReader:close	()V
    //   137: aload_3
    //   138: astore 4
    //   140: aload_2
    //   141: ifnull +10 -> 151
    //   144: aload_2
    //   145: invokevirtual 344	java/lang/Process:destroy	()V
    //   148: aload_3
    //   149: astore 4
    //   151: aload 4
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 133	java/lang/String:length	()I
    //   159: iconst_1
    //   160: isub
    //   161: invokevirtual 265	java/lang/String:substring	(II)Ljava/lang/String;
    //   164: astore_2
    //   165: aload_2
    //   166: areturn
    //   167: astore_2
    //   168: ldc_w 346
    //   171: ldc_w 348
    //   174: invokestatic 351	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   177: pop
    //   178: aload_2
    //   179: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   182: aload_3
    //   183: astore 4
    //   185: goto -34 -> 151
    //   188: astore 5
    //   190: aconst_null
    //   191: astore_3
    //   192: ldc_w 323
    //   195: astore_2
    //   196: aload 6
    //   198: astore 4
    //   200: ldc_w 346
    //   203: ldc_w 354
    //   206: invokestatic 351	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   209: pop
    //   210: aload 5
    //   212: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 341	java/io/BufferedReader:close	()V
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 344	java/lang/Process:destroy	()V
    //   233: aload_2
    //   234: astore 4
    //   236: goto -85 -> 151
    //   239: astore_3
    //   240: ldc_w 346
    //   243: ldc_w 348
    //   246: invokestatic 351	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   249: pop
    //   250: aload_3
    //   251: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   254: aload_2
    //   255: astore 4
    //   257: goto -106 -> 151
    //   260: astore_3
    //   261: aconst_null
    //   262: astore_2
    //   263: aload 5
    //   265: astore 4
    //   267: aload 4
    //   269: ifnull +8 -> 277
    //   272: aload 4
    //   274: invokevirtual 341	java/io/BufferedReader:close	()V
    //   277: aload_2
    //   278: ifnull +7 -> 285
    //   281: aload_2
    //   282: invokevirtual 344	java/lang/Process:destroy	()V
    //   285: aload_3
    //   286: athrow
    //   287: astore_2
    //   288: ldc_w 346
    //   291: ldc_w 348
    //   294: invokestatic 351	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   297: pop
    //   298: aload_2
    //   299: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   302: goto -17 -> 285
    //   305: astore_2
    //   306: aload_2
    //   307: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   310: aload 4
    //   312: areturn
    //   313: astore_3
    //   314: aload 5
    //   316: astore 4
    //   318: goto -51 -> 267
    //   321: astore_3
    //   322: goto -55 -> 267
    //   325: astore 5
    //   327: aload_3
    //   328: astore_2
    //   329: aload 5
    //   331: astore_3
    //   332: goto -65 -> 267
    //   335: astore 5
    //   337: ldc_w 323
    //   340: astore 7
    //   342: aload 6
    //   344: astore 4
    //   346: aload_2
    //   347: astore_3
    //   348: aload 7
    //   350: astore_2
    //   351: goto -151 -> 200
    //   354: astore 5
    //   356: aload_3
    //   357: astore 6
    //   359: aload_2
    //   360: astore_3
    //   361: aload 6
    //   363: astore_2
    //   364: goto -164 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   84	40	0	i	int
    //   9	50	1	j	int
    //   19	147	2	localObject1	Object
    //   167	12	2	localIOException1	java.io.IOException
    //   195	87	2	str1	String
    //   287	12	2	localIOException2	java.io.IOException
    //   305	2	2	localException	Exception
    //   328	36	2	localObject2	Object
    //   43	187	3	str2	String
    //   239	12	3	localIOException3	java.io.IOException
    //   260	26	3	localObject3	Object
    //   313	1	3	localObject4	Object
    //   321	7	3	localObject5	Object
    //   331	30	3	localObject6	Object
    //   38	307	4	localObject7	Object
    //   1	112	5	localObject8	Object
    //   188	127	5	localIOException4	java.io.IOException
    //   325	5	5	localObject9	Object
    //   335	1	5	localIOException5	java.io.IOException
    //   354	1	5	localIOException6	java.io.IOException
    //   4	358	6	localObject10	Object
    //   340	9	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   132	137	167	java/io/IOException
    //   144	148	167	java/io/IOException
    //   10	20	188	java/io/IOException
    //   220	225	239	java/io/IOException
    //   229	233	239	java/io/IOException
    //   10	20	260	finally
    //   272	277	287	java/io/IOException
    //   281	285	287	java/io/IOException
    //   151	165	305	java/lang/Exception
    //   20	40	313	finally
    //   44	51	321	finally
    //   56	78	321	finally
    //   85	92	321	finally
    //   99	112	321	finally
    //   200	215	325	finally
    //   20	40	335	java/io/IOException
    //   44	51	354	java/io/IOException
    //   56	78	354	java/io/IOException
    //   85	92	354	java/io/IOException
    //   99	112	354	java/io/IOException
  }
  
  /* Error */
  protected static int getCrashCounter()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: new 224	java/io/File
    //   5: dup
    //   6: new 226	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 359	com/bugsense/trace/G:FILES_PATH	Ljava/lang/String;
    //   16: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 361
    //   22: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 21
    //   27: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 238	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +32 -> 70
    //   41: aload_2
    //   42: invokevirtual 241	java/io/File:exists	()Z
    //   45: ifne +25 -> 70
    //   48: aload_2
    //   49: invokevirtual 364	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: iconst_0
    //   54: invokestatic 367	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: invokevirtual 370	java/lang/Integer:intValue	()I
    //   60: istore_1
    //   61: iload_1
    //   62: istore_0
    //   63: iload_0
    //   64: ireturn
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   70: new 307	java/io/BufferedReader
    //   73: dup
    //   74: new 372	java/io/FileReader
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 375	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   82: invokespecial 321	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore_3
    //   86: aload_3
    //   87: astore_2
    //   88: aload_3
    //   89: invokevirtual 326	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   92: invokevirtual 378	java/lang/String:trim	()Ljava/lang/String;
    //   95: invokestatic 382	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   98: istore_1
    //   99: iload_1
    //   100: invokestatic 367	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: astore 4
    //   105: aload_3
    //   106: astore_2
    //   107: aload 4
    //   109: invokevirtual 370	java/lang/Integer:intValue	()I
    //   112: istore_1
    //   113: iload_1
    //   114: istore_0
    //   115: aload_3
    //   116: ifnull -53 -> 63
    //   119: aload_3
    //   120: invokevirtual 341	java/io/BufferedReader:close	()V
    //   123: iload_1
    //   124: ireturn
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   130: iload_1
    //   131: ireturn
    //   132: astore_2
    //   133: iconst_0
    //   134: invokestatic 367	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: astore 4
    //   139: goto -34 -> 105
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_3
    //   147: astore_2
    //   148: getstatic 50	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   151: ifeq +10 -> 161
    //   154: aload_3
    //   155: astore_2
    //   156: aload 4
    //   158: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   161: aload_3
    //   162: ifnull -99 -> 63
    //   165: aload_3
    //   166: invokevirtual 341	java/io/BufferedReader:close	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 341	java/io/BufferedReader:close	()V
    //   189: aload_3
    //   190: athrow
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   196: goto -7 -> 189
    //   199: astore_3
    //   200: goto -19 -> 181
    //   203: astore 4
    //   205: goto -59 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	114	0	i	int
    //   60	71	1	j	int
    //   36	71	2	localObject1	Object
    //   125	2	2	localIOException1	java.io.IOException
    //   132	1	2	localException1	Exception
    //   147	9	2	localObject2	Object
    //   171	2	2	localIOException2	java.io.IOException
    //   180	6	2	localObject3	Object
    //   191	2	2	localIOException3	java.io.IOException
    //   65	2	3	localIOException4	java.io.IOException
    //   85	81	3	localBufferedReader	BufferedReader
    //   178	12	3	localObject4	Object
    //   199	1	3	localObject5	Object
    //   103	35	4	localInteger	Integer
    //   142	15	4	localException2	Exception
    //   203	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   48	61	65	java/io/IOException
    //   119	123	125	java/io/IOException
    //   88	99	132	java/lang/Exception
    //   70	86	142	java/lang/Exception
    //   165	169	171	java/io/IOException
    //   70	86	178	finally
    //   185	189	191	java/io/IOException
    //   88	99	199	finally
    //   107	113	199	finally
    //   148	154	199	finally
    //   156	161	199	finally
    //   107	113	203	java/lang/Exception
  }
  
  /* Error */
  public static String getLastCrashID()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 224	java/io/File
    //   7: dup
    //   8: new 226	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   15: getstatic 359	com/bugsense/trace/G:FILES_PATH	Ljava/lang/String;
    //   18: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 361
    //   24: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 24
    //   29: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 238	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +24 -> 64
    //   43: aload_0
    //   44: invokevirtual 241	java/io/File:exists	()Z
    //   47: ifne +17 -> 64
    //   50: aload_0
    //   51: invokevirtual 364	java/io/File:createNewFile	()Z
    //   54: pop
    //   55: aload_3
    //   56: astore_2
    //   57: aload_2
    //   58: areturn
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   64: new 307	java/io/BufferedReader
    //   67: dup
    //   68: new 372	java/io/FileReader
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 375	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   76: invokespecial 321	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: aload_1
    //   83: invokevirtual 326	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: invokevirtual 378	java/lang/String:trim	()Ljava/lang/String;
    //   89: astore 4
    //   91: aload 4
    //   93: astore_0
    //   94: aload_0
    //   95: astore_2
    //   96: aload_1
    //   97: ifnull -40 -> 57
    //   100: aload_1
    //   101: invokevirtual 341	java/io/BufferedReader:close	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   111: aload_0
    //   112: areturn
    //   113: astore 4
    //   115: aload_1
    //   116: astore_0
    //   117: aload 4
    //   119: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   122: aload_2
    //   123: astore_0
    //   124: goto -30 -> 94
    //   127: astore_2
    //   128: aload_1
    //   129: astore_0
    //   130: getstatic 50	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   133: ifeq +9 -> 142
    //   136: aload_1
    //   137: astore_0
    //   138: aload_2
    //   139: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   142: aload_3
    //   143: astore_2
    //   144: aload_1
    //   145: ifnull -88 -> 57
    //   148: aload_1
    //   149: invokevirtual 341	java/io/BufferedReader:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 341	java/io/BufferedReader:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   179: goto -7 -> 172
    //   182: astore_1
    //   183: goto -19 -> 164
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -61 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	100	0	localObject1	Object
    //   154	2	0	localIOException1	java.io.IOException
    //   163	6	0	localObject2	Object
    //   174	2	0	localIOException2	java.io.IOException
    //   59	2	1	localIOException3	java.io.IOException
    //   79	22	1	localBufferedReader	BufferedReader
    //   106	43	1	localIOException4	java.io.IOException
    //   161	12	1	localObject3	Object
    //   182	1	1	localObject4	Object
    //   188	1	1	localObject5	Object
    //   1	122	2	localObject6	Object
    //   127	12	2	localException1	Exception
    //   143	1	2	localObject7	Object
    //   186	1	2	localException2	Exception
    //   3	140	3	localObject8	Object
    //   89	3	4	str	String
    //   113	5	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   50	55	59	java/io/IOException
    //   100	104	106	java/io/IOException
    //   82	91	113	java/lang/Exception
    //   117	122	127	java/lang/Exception
    //   148	152	154	java/io/IOException
    //   64	80	161	finally
    //   168	172	174	java/io/IOException
    //   82	91	182	finally
    //   117	122	182	finally
    //   130	136	182	finally
    //   138	142	182	finally
    //   64	80	186	java/lang/Exception
  }
  
  public static String getMem()
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("%.3f", new Object[] { Double.valueOf(rt.freeMemory() / 1048576.0D) }) + ":");
    localStringBuilder.append(String.format("%.3f", new Object[] { Double.valueOf(rt.maxMemory() / 1048576.0D) }) + ":");
    localStringBuilder.append(String.format("%.3f", new Object[] { Double.valueOf(rt.totalMemory() / 1048576.0D) }) + ":");
    localStringBuilder.append(String.format("%.3f", new Object[] { Double.valueOf(localMemoryInfo.availMem / 1048576.0D) }) + ":");
    localStringBuilder.append(String.format("%.3f", new Object[] { Double.valueOf(localMemoryInfo.threshold / 1048576.0D) }) + ":");
    localStringBuilder.append(String.valueOf(localMemoryInfo.lowMemory));
    return localStringBuilder.toString();
  }
  
  public static final String getTime()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      long l2 = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis() / 1000L;
      return String.valueOf(l2);
    }
    catch (Exception localException) {}
    return String.valueOf(l1);
  }
  
  protected static int isGPSOn(Context paramContext)
  {
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", G.APP_PACKAGE) == 0)
    {
      if (!((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps")) {
        return 0;
      }
    }
    else {
      return 2;
    }
    return 1;
  }
  
  protected static int isMobileNetworkOn(Context paramContext)
  {
    return CheckNetworkConnection(paramContext, "MOBILE");
  }
  
  protected static int isWifiOn(Context paramContext)
  {
    return CheckNetworkConnection(paramContext, "WIFI");
  }
  
  /* Error */
  public static String readFile(String paramString)
  {
    // Byte code:
    //   0: new 226	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_1
    //   10: new 307	java/io/BufferedReader
    //   13: dup
    //   14: new 372	java/io/FileReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 475	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 321	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 326	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +26 -> 58
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: goto -15 -> 26
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 341	java/io/BufferedReader:close	()V
    //   53: aload_2
    //   54: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: areturn
    //   58: aload_0
    //   59: ifnull -6 -> 53
    //   62: aload_0
    //   63: invokevirtual 341	java/io/BufferedReader:close	()V
    //   66: goto -13 -> 53
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   74: goto -21 -> 53
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   82: goto -29 -> 53
    //   85: astore_0
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 341	java/io/BufferedReader:close	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 352	java/io/IOException:printStackTrace	()V
    //   101: goto -7 -> 94
    //   104: astore_2
    //   105: aload_0
    //   106: astore_1
    //   107: aload_2
    //   108: astore_0
    //   109: goto -23 -> 86
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -70 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString	String
    //   9	28	1	str1	String
    //   44	47	1	localException	Exception
    //   96	2	1	localIOException	java.io.IOException
    //   106	1	1	str2	String
    //   7	47	2	localStringBuilder	StringBuilder
    //   104	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	31	44	java/lang/Exception
    //   35	41	44	java/lang/Exception
    //   62	66	69	java/io/IOException
    //   49	53	77	java/io/IOException
    //   10	26	85	finally
    //   90	94	96	java/io/IOException
    //   26	31	104	finally
    //   35	41	104	finally
    //   10	26	112	java/lang/Exception
  }
  
  public static String readLogs()
  {
    int j = G.LOG_LINES;
    int i = j;
    if (j < 0) {
      i = 100;
    }
    Object localObject = G.LOG_FILTER;
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList;
    try
    {
      localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d " + (String)localObject).getInputStream()));
      localArrayList = new ArrayList();
      for (;;)
      {
        String str2 = ((BufferedReader)localObject).readLine();
        if (str2 == null) {
          break;
        }
        localArrayList.add(str2);
      }
      if (localArrayList.size() != 0) {
        break label142;
      }
    }
    catch (Exception localException)
    {
      Log.e(G.TAG, "Error reading logcat output!");
      if (BugSenseHandler.I_WANT_TO_DEBUG) {
        localException.printStackTrace();
      }
      return localException.getMessage();
    }
    return "You must add the android.permission.READ_LOGS permission to your manifest file!";
    label142:
    j = localArrayList.size() - i;
    i = j;
    if (j < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < localArrayList.size())
      {
        localException.append((String)localArrayList.get(i) + "\n");
        i += 1;
      }
      else
      {
        String str1 = localException.toString();
        return str1;
      }
    }
  }
  
  protected static void saveCrashCounter()
  {
    Thread localThread = new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore 5
        //   6: new 22	java/io/File
        //   9: dup
        //   10: new 24	java/lang/StringBuilder
        //   13: dup
        //   14: invokespecial 25	java/lang/StringBuilder:<init>	()V
        //   17: getstatic 31	com/bugsense/trace/G:FILES_PATH	Ljava/lang/String;
        //   20: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: ldc 37
        //   25: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   28: ldc 39
        //   30: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   33: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   36: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
        //   39: astore 6
        //   41: aload 6
        //   43: ifnull +17 -> 60
        //   46: aload 6
        //   48: invokevirtual 50	java/io/File:exists	()Z
        //   51: ifne +9 -> 60
        //   54: aload 6
        //   56: invokevirtual 53	java/io/File:createNewFile	()Z
        //   59: pop
        //   60: new 55	java/io/BufferedReader
        //   63: dup
        //   64: new 57	java/io/FileReader
        //   67: dup
        //   68: aload 6
        //   70: invokespecial 60	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   73: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   76: astore_3
        //   77: aload_3
        //   78: invokevirtual 66	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   81: invokevirtual 71	java/lang/String:trim	()Ljava/lang/String;
        //   84: invokestatic 77	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   87: istore_1
        //   88: iload_1
        //   89: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   92: astore_2
        //   93: aload_2
        //   94: invokevirtual 85	java/lang/Integer:intValue	()I
        //   97: istore_1
        //   98: new 87	java/io/BufferedWriter
        //   101: dup
        //   102: new 89	java/io/FileWriter
        //   105: dup
        //   106: aload 6
        //   108: invokespecial 90	java/io/FileWriter:<init>	(Ljava/io/File;)V
        //   111: invokespecial 93	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   114: astore_2
        //   115: aload_2
        //   116: iload_1
        //   117: iconst_1
        //   118: iadd
        //   119: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   122: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   125: invokevirtual 99	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   128: aload_2
        //   129: invokevirtual 102	java/io/BufferedWriter:newLine	()V
        //   132: aload_2
        //   133: invokevirtual 105	java/io/BufferedWriter:flush	()V
        //   136: aload_2
        //   137: invokevirtual 108	java/io/BufferedWriter:close	()V
        //   140: aload_3
        //   141: ifnull +7 -> 148
        //   144: aload_3
        //   145: invokevirtual 109	java/io/BufferedReader:close	()V
        //   148: aload_2
        //   149: ifnull +7 -> 156
        //   152: aload_2
        //   153: invokevirtual 108	java/io/BufferedWriter:close	()V
        //   156: return
        //   157: astore_2
        //   158: aload_2
        //   159: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   162: goto -102 -> 60
        //   165: astore_2
        //   166: iconst_0
        //   167: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   170: astore_2
        //   171: goto -78 -> 93
        //   174: astore_3
        //   175: aload_3
        //   176: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   179: goto -31 -> 148
        //   182: astore_2
        //   183: aload_2
        //   184: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   187: return
        //   188: astore 4
        //   190: aconst_null
        //   191: astore_2
        //   192: aload 5
        //   194: astore_3
        //   195: getstatic 115	com/bugsense/trace/G:TAG	Ljava/lang/String;
        //   198: ldc 117
        //   200: invokestatic 123	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   203: pop
        //   204: getstatic 129	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
        //   207: ifeq +8 -> 215
        //   210: aload 4
        //   212: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   215: aload_2
        //   216: ifnull +7 -> 223
        //   219: aload_2
        //   220: invokevirtual 109	java/io/BufferedReader:close	()V
        //   223: aload_3
        //   224: ifnull -68 -> 156
        //   227: aload_3
        //   228: invokevirtual 108	java/io/BufferedWriter:close	()V
        //   231: return
        //   232: astore_2
        //   233: aload_2
        //   234: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   237: return
        //   238: astore_2
        //   239: aload_2
        //   240: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   243: goto -20 -> 223
        //   246: astore_2
        //   247: aconst_null
        //   248: astore_3
        //   249: aload_3
        //   250: ifnull +7 -> 257
        //   253: aload_3
        //   254: invokevirtual 109	java/io/BufferedReader:close	()V
        //   257: aload 4
        //   259: ifnull +8 -> 267
        //   262: aload 4
        //   264: invokevirtual 108	java/io/BufferedWriter:close	()V
        //   267: aload_2
        //   268: athrow
        //   269: astore_3
        //   270: aload_3
        //   271: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   274: goto -17 -> 257
        //   277: astore_3
        //   278: aload_3
        //   279: invokevirtual 112	java/io/IOException:printStackTrace	()V
        //   282: goto -15 -> 267
        //   285: astore_2
        //   286: goto -37 -> 249
        //   289: astore 5
        //   291: aload_2
        //   292: astore 4
        //   294: aload 5
        //   296: astore_2
        //   297: goto -48 -> 249
        //   300: astore 4
        //   302: aload_2
        //   303: astore 5
        //   305: aload 4
        //   307: astore_2
        //   308: aload_3
        //   309: astore 4
        //   311: aload 5
        //   313: astore_3
        //   314: goto -65 -> 249
        //   317: astore 4
        //   319: aload_3
        //   320: astore_2
        //   321: aload 5
        //   323: astore_3
        //   324: goto -129 -> 195
        //   327: astore 4
        //   329: aload_3
        //   330: astore 5
        //   332: aload_2
        //   333: astore_3
        //   334: aload 5
        //   336: astore_2
        //   337: goto -142 -> 195
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	340	0	this	2
        //   87	32	1	i	int
        //   92	61	2	localObject1	Object
        //   157	2	2	localIOException1	java.io.IOException
        //   165	1	2	localException	Exception
        //   170	1	2	localInteger	Integer
        //   182	2	2	localIOException2	java.io.IOException
        //   191	29	2	localObject2	Object
        //   232	2	2	localIOException3	java.io.IOException
        //   238	2	2	localIOException4	java.io.IOException
        //   246	22	2	localObject3	Object
        //   285	7	2	localObject4	Object
        //   296	41	2	localObject5	Object
        //   76	69	3	localBufferedReader	BufferedReader
        //   174	2	3	localIOException5	java.io.IOException
        //   194	60	3	localObject6	Object
        //   269	2	3	localIOException6	java.io.IOException
        //   277	32	3	localIOException7	java.io.IOException
        //   313	21	3	localObject7	Object
        //   1	1	4	localObject8	Object
        //   188	75	4	localIOException8	java.io.IOException
        //   292	1	4	localObject9	Object
        //   300	6	4	localObject10	Object
        //   309	1	4	localObject11	Object
        //   317	1	4	localIOException9	java.io.IOException
        //   327	1	4	localIOException10	java.io.IOException
        //   4	189	5	localObject12	Object
        //   289	6	5	localObject13	Object
        //   303	32	5	localObject14	Object
        //   39	68	6	localFile	File
        // Exception table:
        //   from	to	target	type
        //   54	60	157	java/io/IOException
        //   77	88	165	java/lang/Exception
        //   144	148	174	java/io/IOException
        //   152	156	182	java/io/IOException
        //   60	77	188	java/io/IOException
        //   227	231	232	java/io/IOException
        //   219	223	238	java/io/IOException
        //   60	77	246	finally
        //   253	257	269	java/io/IOException
        //   262	267	277	java/io/IOException
        //   77	88	285	finally
        //   93	115	285	finally
        //   115	140	289	finally
        //   195	215	300	finally
        //   77	88	317	java/io/IOException
        //   93	115	317	java/io/IOException
        //   115	140	327	java/io/IOException
      }
    });
    ExecutorService localExecutorService = BugSense.getExecutor();
    if ((localThread != null) && (localExecutorService != null)) {
      localExecutorService.submit(localThread);
    }
  }
  
  public static void saveLastCrashID(String paramString)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG) {
      Log.i(G.TAG, "Last Crash id: " + paramString);
    }
    if (paramString != null)
    {
      paramString = new Thread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: new 25	java/io/File
          //   3: dup
          //   4: new 27	java/lang/StringBuilder
          //   7: dup
          //   8: invokespecial 28	java/lang/StringBuilder:<init>	()V
          //   11: getstatic 33	com/bugsense/trace/G:FILES_PATH	Ljava/lang/String;
          //   14: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   17: ldc 39
          //   19: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   22: ldc 41
          //   24: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   27: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   30: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
          //   33: astore_1
          //   34: aload_1
          //   35: ifnull +15 -> 50
          //   38: aload_1
          //   39: invokevirtual 51	java/io/File:exists	()Z
          //   42: ifne +8 -> 50
          //   45: aload_1
          //   46: invokevirtual 54	java/io/File:createNewFile	()Z
          //   49: pop
          //   50: new 56	java/io/BufferedWriter
          //   53: dup
          //   54: new 58	java/io/FileWriter
          //   57: dup
          //   58: aload_1
          //   59: invokespecial 61	java/io/FileWriter:<init>	(Ljava/io/File;)V
          //   62: invokespecial 64	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
          //   65: astore_2
          //   66: aload_2
          //   67: astore_1
          //   68: aload_2
          //   69: aload_0
          //   70: getfield 16	com/bugsense/trace/Utils$3:val$lastID	Ljava/lang/String;
          //   73: invokevirtual 67	java/io/BufferedWriter:write	(Ljava/lang/String;)V
          //   76: aload_2
          //   77: astore_1
          //   78: aload_2
          //   79: invokevirtual 70	java/io/BufferedWriter:newLine	()V
          //   82: aload_2
          //   83: astore_1
          //   84: aload_2
          //   85: invokevirtual 73	java/io/BufferedWriter:flush	()V
          //   88: aload_2
          //   89: astore_1
          //   90: aload_2
          //   91: invokevirtual 76	java/io/BufferedWriter:close	()V
          //   94: aload_2
          //   95: ifnull +7 -> 102
          //   98: aload_2
          //   99: invokevirtual 76	java/io/BufferedWriter:close	()V
          //   102: return
          //   103: astore_2
          //   104: aload_2
          //   105: invokevirtual 79	java/io/IOException:printStackTrace	()V
          //   108: goto -58 -> 50
          //   111: astore_1
          //   112: aload_1
          //   113: invokevirtual 79	java/io/IOException:printStackTrace	()V
          //   116: return
          //   117: astore_3
          //   118: aconst_null
          //   119: astore_2
          //   120: aload_2
          //   121: astore_1
          //   122: getstatic 82	com/bugsense/trace/G:TAG	Ljava/lang/String;
          //   125: ldc 84
          //   127: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
          //   130: pop
          //   131: aload_2
          //   132: astore_1
          //   133: getstatic 96	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
          //   136: ifeq +9 -> 145
          //   139: aload_2
          //   140: astore_1
          //   141: aload_3
          //   142: invokevirtual 79	java/io/IOException:printStackTrace	()V
          //   145: aload_2
          //   146: ifnull -44 -> 102
          //   149: aload_2
          //   150: invokevirtual 76	java/io/BufferedWriter:close	()V
          //   153: return
          //   154: astore_1
          //   155: aload_1
          //   156: invokevirtual 79	java/io/IOException:printStackTrace	()V
          //   159: return
          //   160: astore_2
          //   161: aconst_null
          //   162: astore_1
          //   163: aload_1
          //   164: ifnull +7 -> 171
          //   167: aload_1
          //   168: invokevirtual 76	java/io/BufferedWriter:close	()V
          //   171: aload_2
          //   172: athrow
          //   173: astore_1
          //   174: aload_1
          //   175: invokevirtual 79	java/io/IOException:printStackTrace	()V
          //   178: goto -7 -> 171
          //   181: astore_2
          //   182: goto -19 -> 163
          //   185: astore_3
          //   186: goto -66 -> 120
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	189	0	this	3
          //   33	57	1	localObject1	Object
          //   111	2	1	localIOException1	java.io.IOException
          //   121	20	1	localObject2	Object
          //   154	2	1	localIOException2	java.io.IOException
          //   162	6	1	localObject3	Object
          //   173	2	1	localIOException3	java.io.IOException
          //   65	34	2	localBufferedWriter	java.io.BufferedWriter
          //   103	2	2	localIOException4	java.io.IOException
          //   119	31	2	localObject4	Object
          //   160	12	2	localObject5	Object
          //   181	1	2	localObject6	Object
          //   117	25	3	localIOException5	java.io.IOException
          //   185	1	3	localIOException6	java.io.IOException
          // Exception table:
          //   from	to	target	type
          //   45	50	103	java/io/IOException
          //   98	102	111	java/io/IOException
          //   50	66	117	java/io/IOException
          //   149	153	154	java/io/IOException
          //   50	66	160	finally
          //   167	171	173	java/io/IOException
          //   68	76	181	finally
          //   78	82	181	finally
          //   84	88	181	finally
          //   90	94	181	finally
          //   122	131	181	finally
          //   133	139	181	finally
          //   141	145	181	finally
          //   68	76	185	java/io/IOException
          //   78	82	185	java/io/IOException
          //   84	88	185	java/io/IOException
          //   90	94	185	java/io/IOException
        }
      });
      ExecutorService localExecutorService = BugSense.getExecutor();
      if ((paramString != null) && (localExecutorService != null)) {
        localExecutorService.submit(paramString);
      }
    }
  }
  
  public static void setProperties(Context paramContext)
  {
    G.IS_WIFI_ON = isWifiOn(paramContext);
    G.IS_MOBILENET_ON = isMobileNetworkOn(paramContext);
    G.IS_GPS_ON = isGPSOn(paramContext);
    G.SCREEN_PROPS = ScreenProperties(paramContext);
    G.LOCALE = Locale.getDefault().getDisplayLanguage();
    G.APPS_RUNNING = getAppsRunning(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */