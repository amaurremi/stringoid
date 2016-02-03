package com.inmobi.commons.analytics.iat.impl;

import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import org.json.JSONObject;

public class AdTrackerUtils
{
  public static boolean checkDownloadGoalAdded()
  {
    if (InternalSDKUtil.getContext() == null)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Application Context NULL cannot checkStatusUpload");
      return false;
    }
    return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "insertStatus");
  }
  
  public static boolean checkDownloadGoalUploaded()
  {
    if (InternalSDKUtil.getContext() == null)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Application Context NULL cannot checkStatusUpload");
      return false;
    }
    return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus");
  }
  
  /* Error */
  public static String getReferrerFromLogs()
  {
    // Byte code:
    //   0: ldc 19
    //   2: ldc 46
    //   4: invokestatic 27	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 52	com/inmobi/commons/analytics/iat/impl/config/AdTrackerInitializer:getConfigParams	()Lcom/inmobi/commons/analytics/iat/impl/config/AdTrackerConfigParams;
    //   10: invokevirtual 57	com/inmobi/commons/analytics/iat/impl/config/AdTrackerConfigParams:getLogcatPattern	()Ljava/lang/String;
    //   13: invokestatic 63	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   16: astore_2
    //   17: new 65	java/io/BufferedReader
    //   20: dup
    //   21: new 67	java/io/InputStreamReader
    //   24: dup
    //   25: invokestatic 73	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   28: iconst_3
    //   29: anewarray 75	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc 77
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc 79
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc 81
    //   46: aastore
    //   47: invokevirtual 85	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   50: invokevirtual 91	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   53: invokespecial 94	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 97	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_3
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_0
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 100	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull +30 -> 100
    //   73: aload_2
    //   74: aload_0
    //   75: invokevirtual 104	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   78: astore 4
    //   80: aload_1
    //   81: astore_0
    //   82: aload 4
    //   84: invokevirtual 109	java/util/regex/Matcher:find	()Z
    //   87: ifeq -25 -> 62
    //   90: aload 4
    //   92: iconst_1
    //   93: invokevirtual 113	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   96: astore_0
    //   97: goto -35 -> 62
    //   100: ldc 19
    //   102: new 115	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   109: ldc 118
    //   111: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 27	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_1
    //   125: areturn
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: ldc 19
    //   131: ldc 127
    //   133: aload_0
    //   134: invokestatic 130	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: aload_1
    //   138: areturn
    //   139: astore_0
    //   140: goto -11 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   61	36	0	localObject1	Object
    //   126	8	0	localException1	Exception
    //   139	1	0	localException2	Exception
    //   63	75	1	localObject2	Object
    //   16	58	2	localPattern	java.util.regex.Pattern
    //   59	6	3	localBufferedReader	java.io.BufferedReader
    //   78	13	4	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   0	60	126	java/lang/Exception
    //   64	69	139	java/lang/Exception
    //   73	80	139	java/lang/Exception
    //   82	97	139	java/lang/Exception
    //   100	124	139	java/lang/Exception
  }
  
  public static boolean isPermissionGranted(String paramString)
  {
    try
    {
      int i = InternalSDKUtil.getContext().checkCallingOrSelfPermission(paramString);
      if (i == 0) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cant check permissions", paramString);
    }
    return false;
  }
  
  public static void reportMetric(AdTrackerEventType paramAdTrackerEventType, Goal paramGoal, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    try
    {
      if (!AdTrackerNetworkInterface.isMetricSample()) {
        return;
      }
      if (AdTrackerEventType.GOAL_SUCCESS.equals(paramAdTrackerEventType))
      {
        paramAdTrackerEventType = new JSONObject();
        paramAdTrackerEventType.put("g", paramGoal.getGoalName());
        paramAdTrackerEventType.put("n", paramGoal.getRetryCount());
        paramAdTrackerEventType.put("t", paramLong);
        paramAdTrackerEventType.put("r", paramInt1);
        AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_SUCCESS, paramAdTrackerEventType));
        return;
      }
      if (AdTrackerEventType.GOAL_FAILURE.equals(paramAdTrackerEventType))
      {
        paramAdTrackerEventType = new JSONObject();
        paramAdTrackerEventType.put("g", paramGoal.getGoalName());
        paramAdTrackerEventType.put("n", paramGoal.getRetryCount());
        paramAdTrackerEventType.put("e", paramInt2);
        if (paramString != null) {
          paramAdTrackerEventType.put("m", paramString);
        }
        AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_FAILURE, paramAdTrackerEventType));
        return;
      }
    }
    catch (Exception paramAdTrackerEventType)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Error reporting metric", paramAdTrackerEventType);
      return;
    }
    paramAdTrackerEventType = new JSONObject();
    paramAdTrackerEventType.put("g", paramGoal.getGoalName());
    paramAdTrackerEventType.put("n", paramGoal.getRetryCount());
    AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_DUMPED, paramAdTrackerEventType));
  }
  
  public static boolean resetStatus()
  {
    if (InternalSDKUtil.getContext() == null) {
      return false;
    }
    FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", false);
    return true;
  }
  
  public static boolean sendBroadcastMessage(int paramInt)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action.inmobi.ADTRACKER");
      localIntent.putExtra("iatError", paramInt);
      InternalSDKUtil.getContext().sendBroadcast(localIntent);
      return true;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cant send test broadcast", localException);
    }
    return false;
  }
  
  public static void setInternalReferrer(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    try
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cannot set Market Referrer..Referrer NULL");
      return;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cannot set referrer", paramContext);
      return;
    }
    if (0L == FileOperations.getLongPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t2")) {
      FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t2", System.currentTimeMillis());
    }
    Log.internal("[InMobi]-[AdTracker]-4.1.1", "Saving referrer from broadcast receiver: " + paramString);
    FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "referrer", paramString);
    FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "rlc", "0");
    paramString = FileOperations.getPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "appId");
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "Initialization incomplete. Please call InMobi initialize with a valid app Id");
      return;
    }
    if (FileOperations.getBooleanPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "waitForReferrer"))
    {
      InternalSDKUtil.setContext(paramContext);
      AdTrackerNetworkInterface.init();
      AdTrackerNetworkInterface.getGoalList().addGoal("download", 1, 0L, 0, true);
      AdTrackerNetworkInterface.reportToServer(paramString);
    }
    AdTrackerNetworkInterface.notifyThread();
  }
  
  public static void setReferrerFromLogs(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    try
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cannot set Market Referrer from logs..Referrer NULL");
      return;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cannot set referrer from logs", paramContext);
    }
    if (0L == FileOperations.getLongPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t2")) {
      FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t2", System.currentTimeMillis());
    }
    FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "referrer", paramString);
    FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "rlc", "1");
    return;
  }
  
  public static boolean updateStatus()
  {
    if (InternalSDKUtil.getContext() == null) {
      return false;
    }
    FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", true);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/AdTrackerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */