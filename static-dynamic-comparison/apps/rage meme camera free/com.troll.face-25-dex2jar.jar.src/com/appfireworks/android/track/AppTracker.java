package com.appfireworks.android.track;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.util.Log;
import com.appfireworks.android.listener.AppListener;
import com.appfireworks.android.listener.AppModuleListener;
import com.appfireworks.android.module.AppModuleController;
import com.appfireworks.android.request.AppRequest;
import com.appfireworks.android.request.AppRequest.TYPE;
import com.appfireworks.android.util.AppEncryption;
import com.appfireworks.android.util.AppExceptionHandler;
import com.appfireworks.android.util.AppLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppTracker
{
  private static Activity activity;
  private static String apikey;
  private static Context context;
  private static boolean crashSyncInProgress;
  static SharedPreferences.Editor editor;
  private static boolean internetAccess = false;
  private static AppModuleListener listener = null;
  private static boolean loadModule = false;
  private static AppModuleController modController;
  private static int postTimer;
  private static SharedPreferences prefs;
  private static boolean readAccess;
  private static boolean syncInProgress;
  private static boolean writeAccess = false;
  
  static
  {
    readAccess = false;
    syncInProgress = false;
    crashSyncInProgress = false;
    postTimer = 60;
    modController = null;
  }
  
  public static void closeSession(Context paramContext, boolean paramBoolean)
  {
    context = paramContext;
    if (apikey == null) {
      apikey = getApiKey();
    }
    if ((postTimer == 0) && (isInternetAvailable(context))) {
      AppRequest.request(context, AppRequest.TYPE.CLOSE, apikey, getSID(), timeSinceOpen(), timeSinceLast());
    }
    for (;;)
    {
      if (paramBoolean) {
        sync(paramContext);
      }
      return;
      saveData("close", 0.0F, "", 0, getSID(), "", "", "", timeSinceOpen(), timeSinceLast());
    }
  }
  
  public static void closeSession(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    context = paramContext;
    if (apikey == null) {
      apikey = getApiKey();
    }
    if (((paramBoolean2) || (postTimer == 0)) && (isInternetAvailable(context))) {
      AppRequest.request(context, AppRequest.TYPE.CLOSE, apikey, getSID(), timeSinceOpen(), timeSinceLast());
    }
    for (;;)
    {
      if (paramBoolean1) {
        sync(paramContext);
      }
      return;
      saveData("close", 0.0F, "", 0, getSID(), "", "", "", timeSinceOpen(), timeSinceLast());
    }
  }
  
  /* Error */
  private static JSONArray crashDataFromPath(File paramFile)
  {
    // Byte code:
    //   0: new 129	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 130	org/json/JSONArray:<init>	()V
    //   7: astore 5
    //   9: invokestatic 136	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   12: astore 6
    //   14: aload_0
    //   15: ldc -118
    //   17: invokestatic 142	com/appfireworks/android/track/AppTracker:getListFiles	(Ljava/io/File;Ljava/lang/String;)Ljava/util/List;
    //   20: astore_0
    //   21: aload_0
    //   22: invokeinterface 148 1 0
    //   27: ifle +21 -> 48
    //   30: aload_0
    //   31: invokeinterface 152 1 0
    //   36: astore 7
    //   38: aload 7
    //   40: invokeinterface 158 1 0
    //   45: ifne +6 -> 51
    //   48: aload 5
    //   50: areturn
    //   51: aload 7
    //   53: invokeinterface 162 1 0
    //   58: checkcast 164	java/io/File
    //   61: astore_0
    //   62: aload 6
    //   64: invokevirtual 167	java/util/Calendar:getTimeInMillis	()J
    //   67: aload_0
    //   68: invokevirtual 170	java/io/File:lastModified	()J
    //   71: lsub
    //   72: ldc2_w 171
    //   75: ldiv
    //   76: lstore_1
    //   77: ldc -82
    //   79: new 176	java/lang/StringBuilder
    //   82: dup
    //   83: ldc -78
    //   85: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: lload_1
    //   89: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: ifnull -61 -> 38
    //   102: lload_1
    //   103: ldc2_w 195
    //   106: lcmp
    //   107: ifgt -69 -> 38
    //   110: aconst_null
    //   111: astore_3
    //   112: aconst_null
    //   113: astore 4
    //   115: new 198	java/io/BufferedReader
    //   118: dup
    //   119: new 200	java/io/FileReader
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 203	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   127: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore_3
    //   136: aload_3
    //   137: ifnonnull +14 -> 151
    //   140: aload_0
    //   141: invokevirtual 211	java/io/BufferedReader:close	()V
    //   144: goto -106 -> 38
    //   147: astore_0
    //   148: goto -110 -> 38
    //   151: ldc -82
    //   153: new 176	java/lang/StringBuilder
    //   156: dup
    //   157: ldc -43
    //   159: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: aload_3
    //   163: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   166: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc -33
    //   177: aload_3
    //   178: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   181: invokestatic 229	com/appfireworks/android/util/AppEncryption:decryptAES	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   184: ldc -25
    //   186: iconst_m1
    //   187: invokevirtual 235	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   190: astore_3
    //   191: aload_3
    //   192: arraylength
    //   193: iconst_4
    //   194: if_icmpne -63 -> 131
    //   197: new 237	org/json/JSONObject
    //   200: dup
    //   201: invokespecial 238	org/json/JSONObject:<init>	()V
    //   204: astore 4
    //   206: aload 4
    //   208: ldc -16
    //   210: aload_3
    //   211: iconst_0
    //   212: aaload
    //   213: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload 4
    //   219: ldc -11
    //   221: aload_3
    //   222: iconst_1
    //   223: aaload
    //   224: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 4
    //   230: ldc -9
    //   232: aload_3
    //   233: iconst_2
    //   234: aaload
    //   235: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   238: pop
    //   239: aload 4
    //   241: ldc -7
    //   243: aload_3
    //   244: iconst_3
    //   245: aaload
    //   246: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload 5
    //   252: aload 4
    //   254: invokevirtual 252	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   257: pop
    //   258: goto -127 -> 131
    //   261: astore_3
    //   262: aload_0
    //   263: invokevirtual 211	java/io/BufferedReader:close	()V
    //   266: goto -228 -> 38
    //   269: astore_0
    //   270: goto -232 -> 38
    //   273: astore_0
    //   274: aload_3
    //   275: invokevirtual 211	java/io/BufferedReader:close	()V
    //   278: aload_0
    //   279: athrow
    //   280: astore_3
    //   281: goto -3 -> 278
    //   284: astore 4
    //   286: aload_0
    //   287: astore_3
    //   288: aload 4
    //   290: astore_0
    //   291: goto -17 -> 274
    //   294: astore_0
    //   295: aload 4
    //   297: astore_0
    //   298: goto -36 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramFile	File
    //   76	27	1	l	long
    //   111	133	3	localObject1	Object
    //   261	14	3	localException1	Exception
    //   280	1	3	localException2	Exception
    //   287	1	3	localFile	File
    //   113	140	4	localJSONObject	JSONObject
    //   284	12	4	localObject2	Object
    //   7	244	5	localJSONArray	JSONArray
    //   12	51	6	localCalendar	Calendar
    //   36	16	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   140	144	147	java/lang/Exception
    //   131	136	261	java/lang/Exception
    //   151	258	261	java/lang/Exception
    //   262	266	269	java/lang/Exception
    //   115	131	273	finally
    //   274	278	280	java/lang/Exception
    //   131	136	284	finally
    //   151	258	284	finally
    //   115	131	294	java/lang/Exception
  }
  
  public static void crashReport(Context paramContext, String paramString1, String paramString2)
  {
    context = paramContext;
    if (apikey == null) {
      apikey = getApiKey();
    }
    paramContext = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    int i = (int)(Calendar.getInstance().getTimeInMillis() / 1000L);
    try
    {
      localJSONObject.put("ts", i);
      localJSONObject.put("d", paramString1);
      localJSONObject.put("t", paramString2);
      localJSONObject.put("sid", getSID());
      paramContext.put(localJSONObject);
      AppRequest.crashReport(context, apikey, paramContext, null);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static void deleteCrashData()
  {
    int i;
    Object localObject2;
    Object localObject1;
    if ((Environment.getExternalStorageState().equals("mounted")) && (getReadAccess()))
    {
      i = 1;
      localObject2 = "/AppData/" + getApiKey() + "/";
      localObject1 = null;
      if (i != 0) {
        localObject1 = getListFiles(new File(Environment.getExternalStorageDirectory(), (String)localObject2), ".stacktrace");
      }
      localObject2 = getListFiles(new File(context.getFilesDir(), (String)localObject2), ".stacktrace");
      if (localObject1 != null) {
        break label126;
      }
      localObject1 = localObject2;
      label95:
      if (((List)localObject1).size() > 0) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        return;
        i = 0;
        break;
        label126:
        ((List)localObject1).addAll((Collection)localObject2);
        break label95;
      }
      localObject2 = (File)((Iterator)localObject1).next();
      try
      {
        ((File)localObject2).delete();
      }
      catch (Exception localException) {}
    }
  }
  
  public static void event(Context paramContext, String paramString)
  {
    event(paramContext, paramString, 0, "", false);
  }
  
  public static void event(Context paramContext, String paramString, float paramFloat)
  {
    event(paramContext, paramString, paramFloat, "", false);
  }
  
  public static void event(Context paramContext, String paramString1, float paramFloat, String paramString2)
  {
    event(paramContext, paramString1, paramFloat, paramString2, false);
  }
  
  public static void event(Context paramContext, String paramString1, float paramFloat, String paramString2, boolean paramBoolean)
  {
    context = paramContext;
    if (apikey == null) {
      apikey = getApiKey();
    }
    if (((paramBoolean) || (postTimer == 0)) && (isInternetAvailable(context))) {
      AppRequest.request(paramContext, AppRequest.TYPE.EVENT, apikey, getSID(), paramString1, paramFloat, "", 0, paramString2, "", "", timeSinceOpen(), timeSinceLast());
    }
    for (;;)
    {
      paramContext = getPrefs().edit();
      paramContext.putLong("LT", Calendar.getInstance().getTimeInMillis());
      paramContext.commit();
      return;
      saveData(paramString1, paramFloat, "", 0, getSID(), paramString2, "", "", timeSinceOpen(), timeSinceLast());
    }
  }
  
  public static void event(Context paramContext, String paramString, float paramFloat, boolean paramBoolean)
  {
    event(paramContext, paramString, paramFloat, "", paramBoolean);
  }
  
  public static void event(Context paramContext, String paramString, int paramInt)
  {
    event(paramContext, paramString, paramInt, "", false);
  }
  
  public static void event(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    event(paramContext, paramString1, paramInt, paramString2, false);
  }
  
  public static void event(Context paramContext, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    context = paramContext;
    if (apikey == null) {
      apikey = getApiKey();
    }
    if (((paramBoolean) || (postTimer == 0)) && (isInternetAvailable(context))) {
      AppRequest.request(paramContext, AppRequest.TYPE.EVENT, apikey, getSID(), paramString1, 0.0F, "", paramInt, paramString2, "", "", timeSinceOpen(), timeSinceLast());
    }
    for (;;)
    {
      paramContext = getPrefs().edit();
      paramContext.putLong("LT", Calendar.getInstance().getTimeInMillis());
      paramContext.commit();
      return;
      saveData(paramString1, 0.0F, "", paramInt, getSID(), "", "", "", timeSinceOpen(), timeSinceLast());
    }
  }
  
  public static void event(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    event(paramContext, paramString, paramInt, "", paramBoolean);
  }
  
  public static void event(Context paramContext, String paramString1, String paramString2)
  {
    event(paramContext, paramString1, paramString2, "", false);
  }
  
  public static void event(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    event(paramContext, paramString1, paramString2, paramString3, false);
  }
  
  public static void event(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    context = paramContext;
    if (apikey == null) {
      apikey = getApiKey();
    }
    if (((paramBoolean) || (postTimer == 0)) && (isInternetAvailable(context))) {
      AppRequest.request(paramContext, AppRequest.TYPE.EVENT, apikey, getSID(), paramString1, 0.0F, paramString2, 0, paramString3, "", "", timeSinceOpen(), timeSinceLast());
    }
    for (;;)
    {
      paramContext = getPrefs().edit();
      paramContext.putLong("LT", Calendar.getInstance().getTimeInMillis());
      paramContext.commit();
      return;
      saveData(paramString1, 0.0F, paramString2, 0, getSID(), "", "", "", timeSinceOpen(), timeSinceLast());
    }
  }
  
  public static void event(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    event(paramContext, paramString1, paramString2, "", paramBoolean);
  }
  
  public static void event(Context paramContext, String paramString, boolean paramBoolean)
  {
    event(paramContext, paramString, 0, "", paramBoolean);
  }
  
  public static String getApiKey()
  {
    if (apikey == null) {
      apikey = getPrefs().getString("A", "");
    }
    return apikey;
  }
  
  private static JSONArray getCrashReportsFromSD()
  {
    if ((Environment.getExternalStorageState().equals("mounted")) && (getReadAccess())) {}
    for (int i = 1;; i = 0)
    {
      JSONArray localJSONArray = new JSONArray();
      if (i != 0)
      {
        localObject = "/AppData//" + getApiKey() + "/";
        localObject = crashDataFromPath(new File(Environment.getExternalStorageDirectory(), (String)localObject));
        if (((JSONArray)localObject).length() > 0) {
          localJSONArray.put(localObject);
        }
      }
      Object localObject = "/AppData//" + getApiKey() + "/";
      localObject = crashDataFromPath(new File(context.getFilesDir(), (String)localObject));
      if (((JSONArray)localObject).length() > 0) {
        localJSONArray.put(localObject);
      }
      return localJSONArray;
    }
  }
  
  /* Error */
  private static ArrayList<String> getExistingActionFromFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 6
    //   8: astore 4
    //   10: aload_0
    //   11: invokevirtual 363	java/io/File:exists	()Z
    //   14: ifeq +112 -> 126
    //   17: aload 6
    //   19: astore 4
    //   21: invokestatic 274	com/appfireworks/android/track/AppTracker:getReadAccess	()Z
    //   24: ifeq +102 -> 126
    //   27: ldc -82
    //   29: ldc_w 365
    //   32: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 136	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   38: invokevirtual 167	java/util/Calendar:getTimeInMillis	()J
    //   41: lstore_2
    //   42: aload 5
    //   44: astore 4
    //   46: aload_0
    //   47: ifnull +64 -> 111
    //   50: new 367	java/util/ArrayList
    //   53: dup
    //   54: invokespecial 368	java/util/ArrayList:<init>	()V
    //   57: astore 5
    //   59: aconst_null
    //   60: astore 4
    //   62: aconst_null
    //   63: astore 6
    //   65: new 198	java/io/BufferedReader
    //   68: dup
    //   69: new 200	java/io/FileReader
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 203	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   77: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   80: astore_0
    //   81: new 225	com/appfireworks/android/util/AppEncryption
    //   84: dup
    //   85: ldc -33
    //   87: invokespecial 369	com/appfireworks/android/util/AppEncryption:<init>	(Ljava/lang/String;)V
    //   90: astore 4
    //   92: aload_0
    //   93: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   96: astore 6
    //   98: aload 6
    //   100: ifnonnull +29 -> 129
    //   103: aload_0
    //   104: invokevirtual 211	java/io/BufferedReader:close	()V
    //   107: aload 5
    //   109: astore 4
    //   111: ldc -82
    //   113: ldc_w 371
    //   116: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc_w 373
    //   122: invokestatic 377	com/appfireworks/android/track/AppTracker:removeData	(Ljava/lang/String;)Z
    //   125: pop
    //   126: aload 4
    //   128: areturn
    //   129: aload 4
    //   131: aload 6
    //   133: invokevirtual 381	com/appfireworks/android/util/AppEncryption:decrypt128	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 6
    //   138: aload 6
    //   140: ldc_w 383
    //   143: invokevirtual 387	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   146: istore_1
    //   147: iload_1
    //   148: ifle +176 -> 324
    //   151: iload_1
    //   152: aload 6
    //   154: invokevirtual 388	java/lang/String:length	()I
    //   157: if_icmpge +167 -> 324
    //   160: lload_2
    //   161: aload 6
    //   163: ldc_w 383
    //   166: invokevirtual 388	java/lang/String:length	()I
    //   169: iload_1
    //   170: iadd
    //   171: invokevirtual 392	java/lang/String:substring	(I)Ljava/lang/String;
    //   174: invokestatic 398	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   177: lsub
    //   178: ldc2_w 171
    //   181: ldiv
    //   182: ldc2_w 195
    //   185: lcmp
    //   186: ifgt +34 -> 220
    //   189: aload 5
    //   191: aload 6
    //   193: invokevirtual 401	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: ldc -82
    //   199: new 176	java/lang/StringBuilder
    //   202: dup
    //   203: ldc_w 403
    //   206: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload 6
    //   211: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: ldc -82
    //   222: new 176	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 405
    //   229: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload 6
    //   234: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -151 -> 92
    //   246: astore 6
    //   248: ldc -82
    //   250: new 176	java/lang/StringBuilder
    //   253: dup
    //   254: ldc_w 407
    //   257: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload 6
    //   262: invokevirtual 410	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 413	com/appfireworks/android/util/AppLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: goto -182 -> 92
    //   277: astore 5
    //   279: aload_0
    //   280: astore 4
    //   282: ldc -82
    //   284: new 176	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 415
    //   291: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: aload 5
    //   296: invokevirtual 410	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   299: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 413	com/appfireworks/android/util/AppLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: astore 4
    //   311: ldc -82
    //   313: aload 5
    //   315: invokestatic 419	com/appfireworks/android/util/AppLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   318: aload_0
    //   319: invokevirtual 211	java/io/BufferedReader:close	()V
    //   322: aconst_null
    //   323: areturn
    //   324: ldc -82
    //   326: new 176	java/lang/StringBuilder
    //   329: dup
    //   330: ldc_w 421
    //   333: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: aload 6
    //   338: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 413	com/appfireworks/android/util/AppLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: goto -127 -> 220
    //   350: astore 5
    //   352: aload_0
    //   353: astore 4
    //   355: aload 5
    //   357: astore_0
    //   358: aload 4
    //   360: invokevirtual 211	java/io/BufferedReader:close	()V
    //   363: aload_0
    //   364: athrow
    //   365: astore_0
    //   366: goto -44 -> 322
    //   369: astore 4
    //   371: goto -8 -> 363
    //   374: astore_0
    //   375: aload 5
    //   377: astore 4
    //   379: goto -268 -> 111
    //   382: astore_0
    //   383: goto -25 -> 358
    //   386: astore 5
    //   388: aload 6
    //   390: astore_0
    //   391: goto -112 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramFile	File
    //   146	25	1	i	int
    //   41	120	2	l	long
    //   8	351	4	localObject1	Object
    //   369	1	4	localException1	Exception
    //   377	1	4	localObject2	Object
    //   4	186	5	localArrayList	ArrayList
    //   277	37	5	localException2	Exception
    //   350	26	5	localObject3	Object
    //   386	1	5	localException3	Exception
    //   1	232	6	str	String
    //   246	143	6	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   129	147	246	java/lang/Exception
    //   151	220	246	java/lang/Exception
    //   220	243	246	java/lang/Exception
    //   324	347	246	java/lang/Exception
    //   81	92	277	java/lang/Exception
    //   92	98	277	java/lang/Exception
    //   248	274	277	java/lang/Exception
    //   81	92	350	finally
    //   92	98	350	finally
    //   129	147	350	finally
    //   151	220	350	finally
    //   220	243	350	finally
    //   248	274	350	finally
    //   324	347	350	finally
    //   318	322	365	java/lang/Exception
    //   358	363	369	java/lang/Exception
    //   103	107	374	java/lang/Exception
    //   65	81	382	finally
    //   282	308	382	finally
    //   311	318	382	finally
    //   65	81	386	java/lang/Exception
  }
  
  private static boolean getInternetAccess()
  {
    return getPrefs().getBoolean("I", false);
  }
  
  private static List<File> getListFiles(File paramFile, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = paramFile.listFiles();
    int i;
    if ((paramFile != null) && (paramFile.length > 0))
    {
      int j = paramFile.length;
      i = 0;
      if (i < j) {}
    }
    else
    {
      return localArrayList;
    }
    File localFile = paramFile[i];
    if (localFile.isDirectory()) {
      localArrayList.addAll(getListFiles(localFile, paramString));
    }
    for (;;)
    {
      i += 1;
      break;
      if (localFile.getName().endsWith(paramString)) {
        localArrayList.add(localFile);
      }
    }
  }
  
  private static SharedPreferences getPrefs()
  {
    if (prefs == null) {
      prefs = context.getSharedPreferences("APPFIREWORKS_" + apikey, 0);
    }
    return prefs;
  }
  
  private static boolean getReadAccess()
  {
    return getPrefs().getBoolean("R", false);
  }
  
  private static String getSID()
  {
    return getPrefs().getString("SID", "");
  }
  
  private static boolean getWriteAccess()
  {
    return getPrefs().getBoolean("W", false);
  }
  
  private static void initialize()
  {
    AppLog.d("AppFireworks", "Going to initialize");
    boolean bool;
    if ((context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) && (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)) {
      bool = true;
    }
    for (;;)
    {
      internetAccess = bool;
      label52:
      String str1;
      String str2;
      if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
      {
        bool = true;
        writeAccess = bool;
        if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
          break label628;
        }
        bool = true;
        readAccess = bool;
        if (prefs == null)
        {
          prefs = context.getSharedPreferences("APPFIREWORKS_" + apikey, 0);
          editor = prefs.edit();
        }
        if (editor == null) {
          editor = prefs.edit();
        }
        long l = Calendar.getInstance().getTimeInMillis();
        str1 = AppEncryption.sha1((Settings.Secure.getString(context.getContentResolver(), "android_id") + l).getBytes());
        editor.putString("SID", str1);
        editor.putLong("OT", l);
        editor.putLong("LT", l);
        editor.putLong("PT", 0L);
        editor.putLong("RT", 0L);
        editor.putString("A", apikey);
        editor.putBoolean("R", readAccess);
        editor.putBoolean("W", writeAccess);
        editor.putBoolean("I", internetAccess);
        editor.commit();
        Thread.setDefaultUncaughtExceptionHandler(new AppExceptionHandler(context, apikey));
        str2 = prefs.getString("installed", "0");
        if (str2.equals("0")) {
          AppLog.d("AppFireworks", "Going to fire Install pixel");
        }
      }
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("n", "install");
        localJSONObject.put("v", 0);
        localJSONObject.put("ts", 0);
        localJSONObject.put("tso", 0);
        localJSONObject.put("tsl", 0);
        localJSONObject.put("sid", str1);
        localJSONObject.put("cv", 0);
        localJSONObject.put("g", "");
        localJSONObject.put("c", "");
        localJSONObject.put("ct", "");
        localJSONObject.put("r", "");
        localJSONArray.put(localJSONObject);
        AppRequest.install(context, apikey, localJSONArray, new AppListener()
        {
          public void onServerSync(ArrayList<String> paramAnonymousArrayList)
          {
            if (paramAnonymousArrayList == null)
            {
              if (AppTracker.isInternetAvailable(AppTracker.context))
              {
                AppRequest.request(AppTracker.context, AppRequest.TYPE.OPEN, AppTracker.apikey, AppTracker.this, 0L, 0L);
                return;
              }
              AppTracker.saveData("open", 0.0F, "", 0, AppTracker.this, "", "", "", 0L, 0L);
              return;
            }
            AppTracker.saveData("open", 0.0F, "", 0, AppTracker.this, "", "", "", 0L, 0L);
          }
        });
        editor.putString("installed", "1");
        editor.commit();
        sync(context);
        if (str2.equals("1"))
        {
          if (isInternetAvailable(context)) {
            AppRequest.request(context, AppRequest.TYPE.OPEN, apikey, str1, 0L, 0L);
          }
        }
        else
        {
          if (postTimer > 0) {
            startAutoService();
          }
          if (loadModule)
          {
            loadModule = false;
            loadModule(activity, "welcome");
          }
          return;
          bool = false;
          continue;
          bool = false;
          break label52;
          label628:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppRequest.request(context, AppRequest.TYPE.INSTALL, apikey, str1, 0L, 0L);
          continue;
          saveData("open", 0.0F, "", 0, str1, "", "", "", 0L, 0L);
        }
      }
    }
  }
  
  public static boolean isInternetAvailable(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getInternetAccess())
    {
      bool1 = bool2;
      if (((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void loadModule(Activity paramActivity, String paramString)
  {
    context = paramActivity.getApplicationContext();
    modController = new AppModuleController(paramActivity);
    if (listener != null) {
      modController.setListener(listener);
    }
    modController.loadingModule(context, paramString);
  }
  
  public static void pause(Context paramContext)
  {
    AppLog.d("AppFireworks", "App paused");
    context = paramContext;
    apikey = getApiKey();
    paramContext = getPrefs().edit();
    paramContext.putLong("PT", Calendar.getInstance().getTimeInMillis());
    paramContext.commit();
  }
  
  private static void purchase(Context paramContext, String paramString1, float paramFloat, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    context = paramContext;
    if (apikey == null) {
      apikey = getApiKey();
    }
    if (((paramBoolean) || (postTimer == 0)) && (isInternetAvailable(context))) {
      AppRequest.request(paramContext, AppRequest.TYPE.EVENT, apikey, getSID(), paramString1, paramFloat, "", 0, paramString4, paramString2, paramString3, timeSinceOpen(), timeSinceLast());
    }
    for (;;)
    {
      paramContext = getPrefs().edit();
      paramContext.putLong("LT", Calendar.getInstance().getTimeInMillis());
      paramContext.commit();
      return;
      saveData(paramString1, paramFloat, "", 0, getSID(), paramString4, paramString2, paramString3, timeSinceOpen(), timeSinceLast());
    }
  }
  
  public static ArrayList<String> readActionData()
  {
    ArrayList localArrayList = null;
    AppLog.d("AppFireworks", "readActionData called");
    Object localObject = "/AppData/" + getApiKey() + "/";
    String str = "ActionData_" + getApiKey();
    int i;
    if ((Environment.getExternalStorageState().equals("mounted")) && (getReadAccess()))
    {
      i = 1;
      if (i == 0) {
        break label170;
      }
      AppLog.d("AppFireworks", "readActionData called & readAccess enabled");
      AppLog.d("AppFireworks", "savepath = " + (String)localObject);
      localArrayList = getExistingActionFromFile(new File(new File(Environment.getExternalStorageDirectory(), (String)localObject), str));
    }
    for (;;)
    {
      localObject = new File(new File(context.getFilesDir(), (String)localObject), str);
      if (localArrayList != null) {
        break label181;
      }
      return getExistingActionFromFile((File)localObject);
      i = 0;
      break;
      label170:
      AppLog.d("AppFireworks", "no read access");
    }
    label181:
    localArrayList.addAll(getExistingActionFromFile((File)localObject));
    return localArrayList;
  }
  
  /* Error */
  public static JSONArray readData()
  {
    // Byte code:
    //   0: invokestatic 265	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 267
    //   6: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +238 -> 247
    //   12: invokestatic 274	com/appfireworks/android/track/AppTracker:getReadAccess	()Z
    //   15: ifeq +232 -> 247
    //   18: iconst_1
    //   19: istore_0
    //   20: new 176	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 623
    //   27: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: invokestatic 89	com/appfireworks/android/track/AppTracker:getApiKey	()Ljava/lang/String;
    //   33: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 7
    //   41: new 129	org/json/JSONArray
    //   44: dup
    //   45: invokespecial 130	org/json/JSONArray:<init>	()V
    //   48: astore 6
    //   50: iload_0
    //   51: ifeq +488 -> 539
    //   54: ldc -82
    //   56: ldc_w 625
    //   59: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: new 176	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 353
    //   69: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: invokestatic 89	com/appfireworks/android/track/AppTracker:getApiKey	()Ljava/lang/String;
    //   75: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 278
    //   81: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_3
    //   88: ldc -82
    //   90: new 176	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 615
    //   97: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_3
    //   101: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: new 164	java/io/File
    //   113: dup
    //   114: new 164	java/io/File
    //   117: dup
    //   118: invokestatic 282	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   121: aload_3
    //   122: invokespecial 285	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   125: aload 7
    //   127: invokespecial 285	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   130: astore 4
    //   132: invokestatic 136	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   135: invokevirtual 167	java/util/Calendar:getTimeInMillis	()J
    //   138: aload 4
    //   140: invokevirtual 170	java/io/File:lastModified	()J
    //   143: lsub
    //   144: ldc2_w 171
    //   147: ldiv
    //   148: lstore_1
    //   149: ldc -82
    //   151: new 176	java/lang/StringBuilder
    //   154: dup
    //   155: ldc -78
    //   157: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: lload_1
    //   161: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload 4
    //   172: ifnull +367 -> 539
    //   175: lload_1
    //   176: ldc2_w 195
    //   179: lcmp
    //   180: ifgt +359 -> 539
    //   183: aconst_null
    //   184: astore_3
    //   185: aconst_null
    //   186: astore 5
    //   188: new 198	java/io/BufferedReader
    //   191: dup
    //   192: new 200	java/io/FileReader
    //   195: dup
    //   196: aload 4
    //   198: invokespecial 203	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   201: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   204: astore 4
    //   206: aload 4
    //   208: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   211: astore_3
    //   212: aload_3
    //   213: ifnonnull +39 -> 252
    //   216: ldc -82
    //   218: new 176	java/lang/StringBuilder
    //   221: dup
    //   222: ldc_w 627
    //   225: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload 6
    //   230: invokevirtual 630	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 4
    //   241: invokevirtual 211	java/io/BufferedReader:close	()V
    //   244: aload 6
    //   246: areturn
    //   247: iconst_0
    //   248: istore_0
    //   249: goto -229 -> 20
    //   252: ldc -82
    //   254: new 176	java/lang/StringBuilder
    //   257: dup
    //   258: ldc -43
    //   260: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   263: aload_3
    //   264: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   267: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: ldc -33
    //   278: aload_3
    //   279: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   282: invokestatic 229	com/appfireworks/android/util/AppEncryption:decryptAES	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_3
    //   286: ldc -82
    //   288: new 176	java/lang/StringBuilder
    //   291: dup
    //   292: ldc_w 405
    //   295: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   298: aload_3
    //   299: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_3
    //   309: ldc_w 632
    //   312: iconst_m1
    //   313: invokevirtual 235	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   316: astore_3
    //   317: aload_3
    //   318: arraylength
    //   319: bipush 6
    //   321: if_icmplt -115 -> 206
    //   324: aload_3
    //   325: arraylength
    //   326: bipush 11
    //   328: if_icmpgt -122 -> 206
    //   331: new 237	org/json/JSONObject
    //   334: dup
    //   335: invokespecial 238	org/json/JSONObject:<init>	()V
    //   338: astore 5
    //   340: aload 5
    //   342: ldc_w 530
    //   345: aload_3
    //   346: iconst_0
    //   347: aaload
    //   348: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload 5
    //   354: ldc_w 540
    //   357: aload_3
    //   358: iconst_1
    //   359: aaload
    //   360: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   363: pop
    //   364: aload 5
    //   366: ldc -16
    //   368: aload_3
    //   369: iconst_2
    //   370: aaload
    //   371: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   374: pop
    //   375: aload 5
    //   377: ldc_w 536
    //   380: aload_3
    //   381: iconst_3
    //   382: aaload
    //   383: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload 5
    //   389: ldc_w 538
    //   392: aload_3
    //   393: iconst_4
    //   394: aaload
    //   395: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   398: pop
    //   399: aload 5
    //   401: ldc -7
    //   403: aload_3
    //   404: iconst_5
    //   405: aaload
    //   406: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload_3
    //   411: arraylength
    //   412: bipush 6
    //   414: if_icmple +68 -> 482
    //   417: aload 5
    //   419: ldc_w 542
    //   422: aload_3
    //   423: bipush 6
    //   425: aaload
    //   426: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 5
    //   432: ldc_w 534
    //   435: aload_3
    //   436: bipush 7
    //   438: aaload
    //   439: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload 5
    //   445: ldc_w 548
    //   448: aload_3
    //   449: bipush 8
    //   451: aaload
    //   452: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   455: pop
    //   456: aload 5
    //   458: ldc_w 544
    //   461: aload_3
    //   462: bipush 9
    //   464: aaload
    //   465: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   468: pop
    //   469: aload 5
    //   471: ldc_w 546
    //   474: aload_3
    //   475: bipush 10
    //   477: aaload
    //   478: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: aload 6
    //   484: aload 5
    //   486: invokevirtual 252	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   489: pop
    //   490: goto -284 -> 206
    //   493: astore 5
    //   495: aload 4
    //   497: astore_3
    //   498: ldc -82
    //   500: new 176	java/lang/StringBuilder
    //   503: dup
    //   504: ldc_w 634
    //   507: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   510: aload 5
    //   512: invokevirtual 410	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   515: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 413	com/appfireworks/android/util/AppLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload 4
    //   526: astore_3
    //   527: ldc -82
    //   529: aload 5
    //   531: invokestatic 419	com/appfireworks/android/util/AppLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   534: aload 4
    //   536: invokevirtual 211	java/io/BufferedReader:close	()V
    //   539: aconst_null
    //   540: astore 4
    //   542: aconst_null
    //   543: astore 5
    //   545: new 198	java/io/BufferedReader
    //   548: dup
    //   549: new 636	java/io/InputStreamReader
    //   552: dup
    //   553: getstatic 63	com/appfireworks/android/track/AppTracker:context	Landroid/content/Context;
    //   556: aload 7
    //   558: invokevirtual 640	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   561: invokespecial 643	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   564: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   567: astore_3
    //   568: aload_3
    //   569: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   572: astore 4
    //   574: aload 4
    //   576: ifnonnull +19 -> 595
    //   579: aload_3
    //   580: invokevirtual 211	java/io/BufferedReader:close	()V
    //   583: aload 6
    //   585: areturn
    //   586: astore 4
    //   588: aload_3
    //   589: invokevirtual 211	java/io/BufferedReader:close	()V
    //   592: aload 4
    //   594: athrow
    //   595: ldc -82
    //   597: new 176	java/lang/StringBuilder
    //   600: dup
    //   601: ldc_w 645
    //   604: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   607: aload 4
    //   609: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   612: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: ldc -33
    //   623: aload 4
    //   625: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   628: invokestatic 229	com/appfireworks/android/util/AppEncryption:decryptAES	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   631: astore 4
    //   633: ldc -82
    //   635: new 176	java/lang/StringBuilder
    //   638: dup
    //   639: ldc_w 647
    //   642: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   645: aload 4
    //   647: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   656: aload 4
    //   658: ldc_w 632
    //   661: iconst_m1
    //   662: invokevirtual 235	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   665: astore 4
    //   667: aload 4
    //   669: arraylength
    //   670: bipush 6
    //   672: if_icmplt -104 -> 568
    //   675: aload 4
    //   677: arraylength
    //   678: bipush 11
    //   680: if_icmpgt -112 -> 568
    //   683: new 237	org/json/JSONObject
    //   686: dup
    //   687: invokespecial 238	org/json/JSONObject:<init>	()V
    //   690: astore 5
    //   692: aload 5
    //   694: ldc_w 530
    //   697: aload 4
    //   699: iconst_0
    //   700: aaload
    //   701: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   704: pop
    //   705: aload 5
    //   707: ldc_w 540
    //   710: aload 4
    //   712: iconst_1
    //   713: aaload
    //   714: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   717: pop
    //   718: aload 5
    //   720: ldc -16
    //   722: aload 4
    //   724: iconst_2
    //   725: aaload
    //   726: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   729: pop
    //   730: aload 5
    //   732: ldc_w 536
    //   735: aload 4
    //   737: iconst_3
    //   738: aaload
    //   739: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   742: pop
    //   743: aload 5
    //   745: ldc_w 538
    //   748: aload 4
    //   750: iconst_4
    //   751: aaload
    //   752: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   755: pop
    //   756: aload 5
    //   758: ldc -7
    //   760: aload 4
    //   762: iconst_5
    //   763: aaload
    //   764: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   767: pop
    //   768: aload 4
    //   770: arraylength
    //   771: bipush 6
    //   773: if_icmple +73 -> 846
    //   776: aload 5
    //   778: ldc_w 542
    //   781: aload 4
    //   783: bipush 6
    //   785: aaload
    //   786: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   789: pop
    //   790: aload 5
    //   792: ldc_w 534
    //   795: aload 4
    //   797: bipush 7
    //   799: aaload
    //   800: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   803: pop
    //   804: aload 5
    //   806: ldc_w 548
    //   809: aload 4
    //   811: bipush 8
    //   813: aaload
    //   814: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   817: pop
    //   818: aload 5
    //   820: ldc_w 544
    //   823: aload 4
    //   825: bipush 9
    //   827: aaload
    //   828: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   831: pop
    //   832: aload 5
    //   834: ldc_w 546
    //   837: aload 4
    //   839: bipush 10
    //   841: aaload
    //   842: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   845: pop
    //   846: aload 6
    //   848: aload 5
    //   850: invokevirtual 252	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   853: pop
    //   854: goto -286 -> 568
    //   857: astore 4
    //   859: aload_3
    //   860: invokevirtual 211	java/io/BufferedReader:close	()V
    //   863: aload 6
    //   865: areturn
    //   866: astore_3
    //   867: aload 6
    //   869: areturn
    //   870: astore_3
    //   871: aload 4
    //   873: invokevirtual 211	java/io/BufferedReader:close	()V
    //   876: aload_3
    //   877: athrow
    //   878: astore_3
    //   879: aload 6
    //   881: areturn
    //   882: astore_3
    //   883: aload 6
    //   885: areturn
    //   886: astore_3
    //   887: goto -348 -> 539
    //   890: astore_3
    //   891: goto -299 -> 592
    //   894: astore 4
    //   896: goto -20 -> 876
    //   899: astore 5
    //   901: aload_3
    //   902: astore 4
    //   904: aload 5
    //   906: astore_3
    //   907: goto -36 -> 871
    //   910: astore_3
    //   911: aload 5
    //   913: astore_3
    //   914: goto -55 -> 859
    //   917: astore 5
    //   919: aload 4
    //   921: astore_3
    //   922: aload 5
    //   924: astore 4
    //   926: goto -338 -> 588
    //   929: astore_3
    //   930: aload 5
    //   932: astore 4
    //   934: aload_3
    //   935: astore 5
    //   937: goto -442 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	230	0	i	int
    //   148	28	1	l	long
    //   87	773	3	localObject1	Object
    //   866	1	3	localException1	Exception
    //   870	7	3	localObject2	Object
    //   878	1	3	localException2	Exception
    //   882	1	3	localException3	Exception
    //   886	1	3	localException4	Exception
    //   890	12	3	localException5	Exception
    //   906	1	3	localObject3	Object
    //   910	1	3	localException6	Exception
    //   913	9	3	localObject4	Object
    //   929	6	3	localException7	Exception
    //   130	445	4	localObject5	Object
    //   586	38	4	localObject6	Object
    //   631	207	4	localObject7	Object
    //   857	15	4	localException8	Exception
    //   894	1	4	localException9	Exception
    //   902	31	4	localObject8	Object
    //   186	299	5	localJSONObject1	JSONObject
    //   493	37	5	localException10	Exception
    //   543	306	5	localJSONObject2	JSONObject
    //   899	13	5	localObject9	Object
    //   917	14	5	localObject10	Object
    //   935	1	5	localException11	Exception
    //   48	836	6	localJSONArray	JSONArray
    //   39	518	7	str	String
    // Exception table:
    //   from	to	target	type
    //   206	212	493	java/lang/Exception
    //   216	239	493	java/lang/Exception
    //   252	482	493	java/lang/Exception
    //   482	490	493	java/lang/Exception
    //   188	206	586	finally
    //   498	524	586	finally
    //   527	534	586	finally
    //   568	574	857	java/lang/Exception
    //   595	846	857	java/lang/Exception
    //   846	854	857	java/lang/Exception
    //   859	863	866	java/lang/Exception
    //   545	568	870	finally
    //   579	583	878	java/lang/Exception
    //   239	244	882	java/lang/Exception
    //   534	539	886	java/lang/Exception
    //   588	592	890	java/lang/Exception
    //   871	876	894	java/lang/Exception
    //   568	574	899	finally
    //   595	846	899	finally
    //   846	854	899	finally
    //   545	568	910	java/lang/Exception
    //   206	212	917	finally
    //   216	239	917	finally
    //   252	482	917	finally
    //   482	490	917	finally
    //   188	206	929	java/lang/Exception
  }
  
  public static boolean removeData(String paramString)
  {
    if ((Environment.getExternalStorageState().equals("mounted")) && (getReadAccess())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppLog.d("AppFireworks", "readData called & readAccess enabled");
      String str = "/AppData//" + getApiKey() + "/";
      AppLog.d("AppFireworks", "savepath = " + str);
      return new File(new File(Environment.getExternalStorageDirectory(), str), paramString + getApiKey()).delete();
    }
    try
    {
      boolean bool = new File(context.getFilesDir(), paramString).delete();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void resume(Context paramContext)
  {
    AppLog.d("AppFireworks", "App resumed");
    context = paramContext;
    apikey = getApiKey();
    paramContext = getPrefs().edit();
    paramContext.putLong("RT", Calendar.getInstance().getTimeInMillis());
    paramContext.commit();
  }
  
  private static void saveData(String paramString1, float paramFloat, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
  {
    String str3 = "AppData_" + getApiKey();
    int i = (int)(Calendar.getInstance().getTimeInMillis() / 1000L);
    String str1 = paramString2;
    if (paramString2.equals("")) {
      str1 = " ";
    }
    paramString2 = paramString4;
    if (paramString4.equals("")) {
      paramString2 = " ";
    }
    paramString4 = paramString5;
    if (paramString5.equals("")) {
      paramString4 = " ";
    }
    paramString5 = paramString6;
    if (paramString6.equals("")) {
      paramString5 = " ";
    }
    String str2 = paramString1 + ":" + paramFloat + ":" + i + ":" + paramLong1 + ":" + paramLong2 + ":" + paramString3 + ":" + str1 + ":" + paramInt + ":" + paramString2 + ":" + paramString4 + ":" + paramString5;
    AppLog.d("AppFireworks", "Content - " + str2);
    paramString6 = "";
    try
    {
      str2 = AppEncryption.encryptAES("tiJ8e+8Fb^21xd|5", str2);
      paramString6 = str2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!paramString6.equals(""))
    {
      str2 = "/AppData//" + getApiKey() + "/";
      AppLog.d("AppFireworks", "savepath = " + str2);
      if (!saveFileWithContent(str3, str2, paramString6)) {
        AppRequest.request(context, AppRequest.TYPE.EVENT, apikey, paramString3, paramString1, paramFloat, str1, paramInt, paramString2, paramString4, paramString5, paramLong1, paramLong2);
      }
    }
  }
  
  /* Error */
  public static boolean saveFileWithContent(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 265	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 267
    //   6: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +228 -> 237
    //   12: invokestatic 669	com/appfireworks/android/track/AppTracker:getWriteAccess	()Z
    //   15: ifeq +222 -> 237
    //   18: iconst_1
    //   19: istore_3
    //   20: iload_3
    //   21: ifeq +115 -> 136
    //   24: ldc -82
    //   26: ldc_w 671
    //   29: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 164	java/io/File
    //   35: dup
    //   36: invokestatic 282	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   39: aload_1
    //   40: invokespecial 285	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 363	java/io/File:exists	()Z
    //   48: ifne +8 -> 56
    //   51: aload_1
    //   52: invokevirtual 674	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: new 676	java/io/PrintWriter
    //   59: dup
    //   60: new 678	java/io/FileWriter
    //   63: dup
    //   64: new 164	java/io/File
    //   67: dup
    //   68: aload_1
    //   69: aload_0
    //   70: invokespecial 285	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: iconst_1
    //   74: invokespecial 681	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   77: invokespecial 684	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   80: astore_1
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 687	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   86: aload_1
    //   87: invokevirtual 690	java/io/PrintWriter:flush	()V
    //   90: aload_1
    //   91: invokevirtual 691	java/io/PrintWriter:close	()V
    //   94: iconst_1
    //   95: ireturn
    //   96: astore 4
    //   98: aload_1
    //   99: invokevirtual 691	java/io/PrintWriter:close	()V
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_1
    //   105: ldc -82
    //   107: new 176	java/lang/StringBuilder
    //   110: dup
    //   111: ldc_w 693
    //   114: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 410	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 413	com/appfireworks/android/util/AppLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: ldc -82
    //   132: aload_1
    //   133: invokestatic 419	com/appfireworks/android/util/AppLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   136: getstatic 63	com/appfireworks/android/track/AppTracker:context	Landroid/content/Context;
    //   139: aload_0
    //   140: ldc_w 694
    //   143: invokevirtual 698	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   146: astore_0
    //   147: aload_0
    //   148: new 176	java/lang/StringBuilder
    //   151: dup
    //   152: aload_2
    //   153: invokestatic 490	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: ldc_w 700
    //   162: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 494	java/lang/String:getBytes	()[B
    //   171: invokevirtual 706	java/io/FileOutputStream:write	([B)V
    //   174: aload_0
    //   175: invokevirtual 707	java/io/FileOutputStream:close	()V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_0
    //   181: ldc -82
    //   183: new 176	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 709
    //   190: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: invokevirtual 410	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 413	com/appfireworks/android/util/AppLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: ldc -82
    //   208: aload_0
    //   209: invokestatic 419	com/appfireworks/android/util/AppLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore 4
    //   216: aload_1
    //   217: invokevirtual 691	java/io/PrintWriter:close	()V
    //   220: aload 4
    //   222: athrow
    //   223: astore_1
    //   224: aload_0
    //   225: invokevirtual 707	java/io/FileOutputStream:close	()V
    //   228: iconst_1
    //   229: ireturn
    //   230: astore_1
    //   231: aload_0
    //   232: invokevirtual 707	java/io/FileOutputStream:close	()V
    //   235: aload_1
    //   236: athrow
    //   237: iconst_0
    //   238: istore_3
    //   239: goto -219 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramString1	String
    //   0	242	1	paramString2	String
    //   0	242	2	paramString3	String
    //   19	220	3	i	int
    //   96	1	4	localException	Exception
    //   214	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   81	90	96	java/lang/Exception
    //   32	56	104	java/lang/Exception
    //   56	81	104	java/lang/Exception
    //   90	94	104	java/lang/Exception
    //   98	102	104	java/lang/Exception
    //   216	223	104	java/lang/Exception
    //   136	147	180	java/lang/Exception
    //   174	178	180	java/lang/Exception
    //   224	228	180	java/lang/Exception
    //   231	237	180	java/lang/Exception
    //   81	90	214	finally
    //   147	174	223	java/lang/Exception
    //   147	174	230	finally
  }
  
  public static void setApiKey(String paramString)
  {
    if (paramString != null) {
      apikey = paramString;
    }
  }
  
  private static void startAutoService()
  {
    int j = postTimer;
    int i = j;
    if (j > 0) {
      i = 60;
    }
    AlarmManager localAlarmManager = (AlarmManager)context.getSystemService("alarm");
    Object localObject = new Intent(context, AppAutoReceiver.class);
    ((Intent)localObject).putExtra("apikey", apikey);
    localObject = PendingIntent.getBroadcast(context, 0, (Intent)localObject, 134217728);
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.add(12, 2);
    long l1 = localCalendar.getTimeInMillis();
    long l2 = i * 60 * 1000;
    localAlarmManager.setInexactRepeating(0, l1, l2, (PendingIntent)localObject);
    AppLog.d("AppFireworks", "Receiver set to go off at " + l1 + ", repeatTime = " + l2);
  }
  
  public static void startSession(Activity paramActivity, String paramString)
  {
    startSession(paramActivity, paramString, null, 0);
  }
  
  public static void startSession(Activity paramActivity, String paramString, int paramInt)
  {
    startSession(paramActivity, paramString, null, paramInt);
  }
  
  public static void startSession(Activity paramActivity, String paramString, AppModuleListener paramAppModuleListener)
  {
    startSession(paramActivity, paramString, paramAppModuleListener, 0);
  }
  
  public static void startSession(Activity paramActivity, String paramString, AppModuleListener paramAppModuleListener, int paramInt)
  {
    activity = paramActivity;
    context = paramActivity.getApplicationContext();
    if (paramAppModuleListener != null) {
      listener = paramAppModuleListener;
    }
    loadModule = true;
    startSession(context, paramString, paramInt);
  }
  
  public static void startSession(Context paramContext)
  {
    context = paramContext;
    paramContext = null;
    try
    {
      String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("APPFIREWORKS_APIKEY");
      paramContext = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AppLog.e("AppFireworks", "Error with getting APIKEY - " + localException.getMessage());
      }
      apikey = paramContext;
      initialize();
    }
    if (paramContext == null)
    {
      Log.e("AppFireworks", "APIFIREWORKS_APIKEY <meta-data> not defined properly");
      return;
    }
  }
  
  public static void startSession(Context paramContext, String paramString)
  {
    startSession(paramContext, paramString, 0);
  }
  
  public static void startSession(Context paramContext, String paramString, int paramInt)
  {
    context = paramContext;
    apikey = paramString;
    if (paramInt < 0) {}
    for (postTimer = 0;; postTimer = paramInt * 60)
    {
      initialize();
      return;
    }
  }
  
  /* Error */
  public static int storeActions(ArrayList<String> paramArrayList, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: iconst_0
    //   5: istore 4
    //   7: iconst_0
    //   8: istore 5
    //   10: getstatic 63	com/appfireworks/android/track/AppTracker:context	Landroid/content/Context;
    //   13: ldc_w 471
    //   16: invokevirtual 467	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   19: ifne +273 -> 292
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore 8
    //   28: aconst_null
    //   29: astore 7
    //   31: invokestatic 89	com/appfireworks/android/track/AppTracker:getApiKey	()Ljava/lang/String;
    //   34: astore 9
    //   36: ldc -82
    //   38: new 176	java/lang/StringBuilder
    //   41: dup
    //   42: ldc_w 795
    //   45: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: iload_1
    //   49: invokevirtual 660	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 176	java/lang/StringBuilder
    //   61: dup
    //   62: ldc_w 276
    //   65: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: aload 9
    //   70: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 278
    //   76: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore 10
    //   84: ldc -82
    //   86: new 176	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 615
    //   93: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 10
    //   98: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: new 164	java/io/File
    //   110: dup
    //   111: invokestatic 282	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   114: aload 10
    //   116: invokespecial 285	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   119: astore 10
    //   121: aload 10
    //   123: invokevirtual 363	java/io/File:exists	()Z
    //   126: ifne +9 -> 135
    //   129: aload 10
    //   131: invokevirtual 674	java/io/File:mkdirs	()Z
    //   134: pop
    //   135: new 678	java/io/FileWriter
    //   138: dup
    //   139: new 164	java/io/File
    //   142: dup
    //   143: aload 10
    //   145: new 176	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 373
    //   152: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload 9
    //   157: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 285	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   166: iconst_1
    //   167: invokespecial 681	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   170: astore 9
    //   172: new 676	java/io/PrintWriter
    //   175: dup
    //   176: aload 9
    //   178: invokespecial 684	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   181: astore 6
    //   183: ldc 122
    //   185: astore 7
    //   187: ldc 122
    //   189: astore 8
    //   191: iload 4
    //   193: istore_3
    //   194: new 225	com/appfireworks/android/util/AppEncryption
    //   197: dup
    //   198: ldc -33
    //   200: invokespecial 369	com/appfireworks/android/util/AppEncryption:<init>	(Ljava/lang/String;)V
    //   203: astore 9
    //   205: iload 4
    //   207: istore_3
    //   208: aload_0
    //   209: invokevirtual 796	java/util/ArrayList:size	()I
    //   212: iconst_1
    //   213: isub
    //   214: istore 4
    //   216: iload 5
    //   218: istore_2
    //   219: iload 4
    //   221: iload_1
    //   222: if_icmpge +72 -> 294
    //   225: iload_2
    //   226: istore_3
    //   227: aload 6
    //   229: aload 7
    //   231: invokevirtual 799	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   234: iload_2
    //   235: istore_3
    //   236: aload 6
    //   238: invokevirtual 690	java/io/PrintWriter:flush	()V
    //   241: iload_2
    //   242: istore_3
    //   243: ldc -82
    //   245: new 176	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 801
    //   252: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: iload_2
    //   256: invokevirtual 660	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: ldc_w 803
    //   262: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 8
    //   267: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 805
    //   273: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 7
    //   278: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 194	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload 6
    //   289: invokevirtual 691	java/io/PrintWriter:close	()V
    //   292: iload_2
    //   293: ireturn
    //   294: iload_2
    //   295: istore_3
    //   296: aload_0
    //   297: iload 4
    //   299: invokevirtual 809	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   302: checkcast 215	java/lang/String
    //   305: astore 8
    //   307: iload_2
    //   308: istore_3
    //   309: aload 9
    //   311: aload 8
    //   313: invokevirtual 812	com/appfireworks/android/util/AppEncryption:encrypt128	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 10
    //   318: iload_2
    //   319: istore_3
    //   320: new 176	java/lang/StringBuilder
    //   323: dup
    //   324: aload 7
    //   326: invokestatic 490	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   329: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   332: aload 10
    //   334: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 700
    //   340: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: astore 7
    //   348: iload_2
    //   349: iconst_1
    //   350: iadd
    //   351: istore_2
    //   352: iload 4
    //   354: iconst_1
    //   355: isub
    //   356: istore 4
    //   358: goto -139 -> 219
    //   361: astore_0
    //   362: aload 7
    //   364: astore 6
    //   366: ldc -82
    //   368: aload_0
    //   369: invokestatic 419	com/appfireworks/android/util/AppLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   372: aload 7
    //   374: astore 6
    //   376: ldc -82
    //   378: new 176	java/lang/StringBuilder
    //   381: dup
    //   382: ldc_w 814
    //   385: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: aload_0
    //   389: invokevirtual 410	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   392: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 413	com/appfireworks/android/util/AppLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload 7
    //   403: invokevirtual 691	java/io/PrintWriter:close	()V
    //   406: iload_3
    //   407: ireturn
    //   408: astore_0
    //   409: iload_3
    //   410: ireturn
    //   411: astore_0
    //   412: aload 6
    //   414: invokevirtual 691	java/io/PrintWriter:close	()V
    //   417: aload_0
    //   418: athrow
    //   419: astore 6
    //   421: goto -4 -> 417
    //   424: astore_0
    //   425: iload_2
    //   426: ireturn
    //   427: astore_0
    //   428: aload 8
    //   430: astore 6
    //   432: goto -20 -> 412
    //   435: astore_0
    //   436: goto -24 -> 412
    //   439: astore_0
    //   440: goto -78 -> 362
    //   443: astore_0
    //   444: aload 6
    //   446: astore 7
    //   448: goto -86 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	paramArrayList	ArrayList<String>
    //   0	451	1	paramInt	int
    //   1	425	2	i	int
    //   3	407	3	j	int
    //   5	352	4	k	int
    //   8	209	5	m	int
    //   23	390	6	localObject1	Object
    //   419	1	6	localException	Exception
    //   430	15	6	localObject2	Object
    //   29	418	7	localObject3	Object
    //   26	403	8	str	String
    //   34	276	9	localObject4	Object
    //   82	251	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   135	172	361	java/lang/Exception
    //   401	406	408	java/lang/Exception
    //   135	172	411	finally
    //   366	372	411	finally
    //   376	401	411	finally
    //   412	417	419	java/lang/Exception
    //   287	292	424	java/lang/Exception
    //   172	183	427	finally
    //   194	205	435	finally
    //   208	216	435	finally
    //   227	234	435	finally
    //   236	241	435	finally
    //   243	287	435	finally
    //   296	307	435	finally
    //   309	318	435	finally
    //   320	348	435	finally
    //   172	183	439	java/lang/Exception
    //   194	205	443	java/lang/Exception
    //   208	216	443	java/lang/Exception
    //   227	234	443	java/lang/Exception
    //   236	241	443	java/lang/Exception
    //   243	287	443	java/lang/Exception
    //   296	307	443	java/lang/Exception
    //   309	318	443	java/lang/Exception
    //   320	348	443	java/lang/Exception
  }
  
  public static void sync(Context paramContext)
  {
    AppLog.d("AppFireworks", "sync() called - " + syncInProgress);
    if (!syncInProgress)
    {
      syncInProgress = true;
      context = paramContext;
      AppLog.d("AppFireworks", "Going to Sync data");
      JSONArray localJSONArray = readData();
      AppLog.d("AppFireworks", "Data to be synced = " + localJSONArray);
      if (localJSONArray.length() == 0) {
        break label103;
      }
      AppRequest.request(context, getApiKey(), localJSONArray, new AppListener()
      {
        public void onServerSync(ArrayList<String> paramAnonymousArrayList)
        {
          AppTracker.syncCrashReport(AppTracker.context);
          if (paramAnonymousArrayList == null) {
            AppLog.d("AppFireworks", "Successfully synced, Data deleted - " + AppTracker.removeData("AppData_"));
          }
          AppTracker.syncInProgress = false;
        }
      });
    }
    for (;;)
    {
      syncModuleAction(paramContext, null, false);
      return;
      label103:
      syncInProgress = false;
    }
  }
  
  private static void syncCrashReport(Context paramContext)
  {
    if (!crashSyncInProgress)
    {
      crashSyncInProgress = true;
      if (apikey == null) {
        apikey = getApiKey();
      }
      context = paramContext;
      AppLog.d("AppFireworks", "Going to Sync crash reports");
      paramContext = getCrashReportsFromSD();
      if (paramContext.length() != 0) {
        AppRequest.crashReport(context, apikey, paramContext, new AppListener()
        {
          public void onServerSync(ArrayList<String> paramAnonymousArrayList)
          {
            if (paramAnonymousArrayList == null)
            {
              AppTracker.access$5();
              AppLog.d("AppFireworks", "Successfully synced, Crash data deleted");
            }
            AppTracker.crashSyncInProgress = false;
          }
        });
      }
    }
    else
    {
      return;
    }
    crashSyncInProgress = false;
  }
  
  public static void syncModuleAction(Context paramContext, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = readActionData();
    if (localArrayList != null) {
      AppLog.d("AppFireworks", "#actions from file: " + localArrayList.size());
    }
    AppRequest.requestBatchAction(paramContext, paramString, localArrayList, getApiKey(), paramBoolean, new AppListener()
    {
      public void onServerSync(ArrayList<String> paramAnonymousArrayList)
      {
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
          AppTracker.storeActions(paramAnonymousArrayList, 0);
        }
      }
    });
    syncInProgress = false;
  }
  
  private static long timeSinceLast()
  {
    SharedPreferences localSharedPreferences = getPrefs();
    long l1 = Calendar.getInstance().getTimeInMillis();
    long l2 = localSharedPreferences.getLong("LT", 0L);
    if (l2 == 0L) {
      return 0L;
    }
    long l3 = localSharedPreferences.getLong("PT", 0L);
    l3 = (localSharedPreferences.getLong("RT", 0L) - l3) / 1000L;
    return (l1 - l2) / 1000L - l3;
  }
  
  private static long timeSinceOpen()
  {
    SharedPreferences localSharedPreferences = getPrefs();
    long l1 = Calendar.getInstance().getTimeInMillis();
    long l2 = localSharedPreferences.getLong("OT", 0L);
    if (l2 == 0L) {
      return 0L;
    }
    long l3 = localSharedPreferences.getLong("PT", 0L);
    l3 = (localSharedPreferences.getLong("RT", 0L) - l3) / 1000L;
    return (l1 - l2) / 1000L - l3;
  }
  
  public static void transaction(Context paramContext, String paramString1, float paramFloat, String paramString2)
  {
    purchase(paramContext, paramString1, paramFloat, paramString2, "real", "", false);
  }
  
  public static void transaction(Context paramContext, String paramString1, float paramFloat, String paramString2, String paramString3)
  {
    purchase(paramContext, paramString1, paramFloat, paramString2, "real", paramString3, false);
  }
  
  public static void transaction(Context paramContext, String paramString1, float paramFloat, String paramString2, String paramString3, boolean paramBoolean)
  {
    purchase(paramContext, paramString1, paramFloat, paramString2, "real", paramString3, paramBoolean);
  }
  
  public static void transaction(Context paramContext, String paramString1, float paramFloat, String paramString2, boolean paramBoolean)
  {
    purchase(paramContext, paramString1, paramFloat, paramString2, "real", "", paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/track/AppTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */