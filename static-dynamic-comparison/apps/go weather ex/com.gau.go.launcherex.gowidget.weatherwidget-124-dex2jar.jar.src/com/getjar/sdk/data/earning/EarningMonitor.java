package com.getjar.sdk.data.earning;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.getjar.sdk.comm.BeaconManager;
import com.getjar.sdk.comm.BeaconMessage.BeaconType;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.CommManager;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.comm.TransactionManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.cache.Ad;
import com.getjar.sdk.data.cache.AdManager;
import com.getjar.sdk.data.cache.AdManager.AdType;
import com.getjar.sdk.data.usage.AnalyticsManager;
import com.getjar.sdk.data.usage.AnalyticsManager.TrackingType;
import com.getjar.sdk.data.usage.UsageScreenReceiver;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.NotificationsUtility;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EarningMonitor
{
  private static final long _EARNING_APP_INSTALL_NOTIFY_MILLISECONDS = 300000L;
  private static final long _EARNING_APP_OPEN_NOTIFY_MILLISECONDS = 60000L;
  private static final long _EARNING_APP_OPEN_TIMEOUT_MILLISECONDS = 86400000L;
  private static boolean _FirstRun = true;
  private static volatile EarningMonitor _Instance = null;
  private final CommContext _commContext;
  private final Context _context;
  private final long _monitorIntervalInMilliseconds;
  private volatile EarningMonitoringThread _monitoringThread = null;
  private volatile Object _monitoringThreadLock = new Object();
  private final Set<String> alreadyOpenedPackages = new HashSet();
  
  private EarningMonitor(Context paramContext)
  {
    this._context = paramContext.getApplicationContext();
    this._commContext = getCommContext(paramContext);
    long l2 = Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(this._commContext, true).getDirectiveValue("earn.on.open.monitoring.interval", SettingsManager.Scope.CLIENT)));
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 1000L;
    }
    this._monitorIntervalInMilliseconds = l1;
  }
  
  private Future<Operation> earn(Context paramContext, CommContext paramCommContext, EarnStateRecord paramEarnStateRecord, boolean paramBoolean)
    throws Exception
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    if (paramEarnStateRecord == null) {
      throw new IllegalArgumentException("'appState' cannot be NULL");
    }
    Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: earn() for: %1$s", new Object[] { paramEarnStateRecord.toString() });
    new HashMap();
    new HashMap();
    HashMap localHashMap1;
    if ((!StringUtility.isNullOrEmpty(paramEarnStateRecord.getTrackingMetadata())) && ((paramEarnStateRecord.getTrackingMetadata().startsWith("[{\"key\":")) || (paramEarnStateRecord.getTrackingMetadata().startsWith("[{\"value\":"))))
    {
      localHashMap1 = Utility.jsonArrayStringToMap(paramEarnStateRecord.getTrackingMetadata());
      localHashMap1.put("earn.by_fail_recover", String.valueOf(paramBoolean));
      if ((StringUtility.isNullOrEmpty(paramEarnStateRecord.getApplicationMetadata())) || ((!paramEarnStateRecord.getApplicationMetadata().startsWith("[{\"key\":")) && (!paramEarnStateRecord.getApplicationMetadata().startsWith("[{\"value\":")))) {
        break label284;
      }
    }
    label284:
    for (HashMap localHashMap2 = Utility.jsonArrayStringToMap(paramEarnStateRecord.getApplicationMetadata());; localHashMap2 = Utility.jsonArrayStringToMapUnchange(paramEarnStateRecord.getApplicationMetadata()))
    {
      String str1 = (String)localHashMap2.get("app.id");
      String str2 = paramEarnStateRecord.getClientTransactionId();
      Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: earn() Sending Earn transaction for %1$s [clientTransactionId: %2$s]", new Object[] { paramEarnStateRecord.getPackageName(), str2 });
      paramContext = new TransactionManager(paramContext).runEarnTransaction(str2, paramCommContext, str1, paramEarnStateRecord.getPackageName(), localHashMap2, localHashMap1);
      paramContext.get();
      return paramContext;
      localHashMap1 = Utility.jsonArrayStringToMapUnchange(paramEarnStateRecord.getTrackingMetadata());
      break;
    }
  }
  
  private CommContext getCommContext(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    return CommManager.createContext(paramContext);
  }
  
  public static EarningMonitor getInstance(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new EarningMonitor(paramContext);
      }
      paramContext = _Instance;
      return paramContext;
    }
    finally {}
  }
  
  public EarnStateRecord ensureAppMetadataOnEarnStateRecord(EarnStateRecord paramEarnStateRecord)
  {
    if (paramEarnStateRecord == null) {
      throw new IllegalArgumentException("'appState' cannot be NULL");
    }
    int m = 0;
    int n = 0;
    int i = 0;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject1 = paramEarnStateRecord;
    int j = m;
    int k = n;
    Object localObject4;
    for (;;)
    {
      try
      {
        localObject6 = Utility.jsonArrayStringToMap(paramEarnStateRecord.getApplicationMetadata());
        localObject3 = localObject6;
        j = m;
        localObject5 = localObject6;
        k = n;
        Logger.d(Area.EARN.value(), "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() [packageName:'%1$s' metadataCount:%2$d]", new Object[] { paramEarnStateRecord.getPackageName(), Integer.valueOf(((Map)localObject6).size()) });
        localObject3 = localObject6;
        j = m;
        localObject5 = localObject6;
        k = n;
        if (((Map)localObject6).containsKey("device.platform"))
        {
          localObject3 = localObject6;
          j = m;
          localObject5 = localObject6;
          k = n;
          if (((Map)localObject6).containsKey("device.platform_version")) {}
        }
        else
        {
          localObject3 = localObject6;
          j = m;
          localObject5 = localObject6;
          k = n;
          ((Map)localObject6).put("device.platform", "android");
          localObject3 = localObject6;
          j = m;
          localObject5 = localObject6;
          k = n;
          ((Map)localObject6).put("device.platform_version", Build.VERSION.RELEASE);
          i = 1;
        }
        localObject3 = localObject6;
        j = i;
        localObject5 = localObject6;
        k = i;
        if (((Map)localObject6).containsKey("android.package.version_code"))
        {
          localObject3 = localObject6;
          j = i;
          localObject5 = localObject6;
          k = i;
          boolean bool = ((Map)localObject6).containsKey("android.package.version_name");
          j = i;
          if (bool) {}
        }
        else
        {
          Object localObject9 = null;
          m = 0;
          localObject8 = localObject9;
          if (m <= 3)
          {
            localObject3 = localObject6;
            j = i;
            localObject5 = localObject6;
            k = i;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject6;
        Object localObject8;
        localObject5 = localObject4;
        k = j;
        Logger.e(Area.EARN.value(), localException, "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() failed", new Object[0]);
        localObject5 = localObject1;
        if (j == 0) {
          continue;
        }
        localObject5 = localObject1;
        if (localObject4 == null) {
          continue;
        }
        localObject5 = localObject1;
        Object localObject7 = localObject1;
        try
        {
          if (((Map)localObject4).size() <= 0) {
            continue;
          }
          localObject7 = localObject1;
          localObject8 = Utility.mapToJsonString((Map)localObject4);
          localObject5 = localObject1;
          localObject7 = localObject1;
          if (StringUtility.isNullOrEmpty((String)localObject8)) {
            continue;
          }
          localObject7 = localObject1;
          EarnStateDatabase.getInstance(this._context).updateApplicationMetadata(paramEarnStateRecord.getPackageName(), (String)localObject8);
          localObject7 = localObject1;
          localObject4 = EarnStateDatabase.getInstance(this._context).getAppState(paramEarnStateRecord.getPackageName());
          if (localObject4 != null) {
            localObject1 = localObject4;
          }
          localObject7 = localObject1;
          Logger.d(Area.EARN.value(), "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() Application metadata update [packageName:'%1$s' metadata:'%2$s']", new Object[] { paramEarnStateRecord.getPackageName(), localObject8 });
          return (EarnStateRecord)localObject1;
        }
        catch (Exception paramEarnStateRecord)
        {
          Logger.e(Area.EARN.value(), paramEarnStateRecord, "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() failed", new Object[0]);
          return (EarnStateRecord)localObject7;
        }
        localObject4 = localObject7;
        j = i;
        localObject5 = localObject7;
        k = i;
        ((Map)localObject7).put("android.package.version_code", Integer.toString(((PackageInfo)localObject8).versionCode));
        localObject4 = localObject7;
        j = i;
        localObject5 = localObject7;
        k = i;
        ((Map)localObject7).put("android.package.version_name", ((PackageInfo)localObject8).versionName);
        j = 1;
        continue;
      }
      finally
      {
        if ((k == 0) || (localObject5 == null)) {
          break label935;
        }
      }
      try
      {
        localObject8 = this._context.getPackageManager().getPackageInfo(paramEarnStateRecord.getPackageName(), 128);
        if (localObject8 != null) {
          continue;
        }
        localObject3 = localObject6;
        j = i;
        localObject5 = localObject6;
        k = i;
        Logger.w(Area.EARN.value(), "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() [packageName: %1$s] Failed to get PackageInfo", new Object[] { paramEarnStateRecord.getPackageName() });
        j = i;
        localObject5 = localObject1;
        if (j != 0)
        {
          localObject5 = localObject1;
          if (localObject6 != null)
          {
            localObject5 = localObject1;
            localObject3 = localObject1;
          }
        }
        if (n > 3) {
          continue;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        try
        {
          if (((Map)localObject6).size() > 0)
          {
            localObject3 = localObject1;
            localObject6 = Utility.mapToJsonString((Map)localObject6);
            localObject5 = localObject1;
            localObject3 = localObject1;
            if (!StringUtility.isNullOrEmpty((String)localObject6))
            {
              localObject3 = localObject1;
              EarnStateDatabase.getInstance(this._context).updateApplicationMetadata(paramEarnStateRecord.getPackageName(), (String)localObject6);
              localObject3 = localObject1;
              localObject5 = EarnStateDatabase.getInstance(this._context).getAppState(paramEarnStateRecord.getPackageName());
              if (localObject5 != null) {
                localObject1 = localObject5;
              }
              localObject3 = localObject1;
              Logger.d(Area.EARN.value(), "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() Application metadata update [packageName:'%1$s' metadata:'%2$s']", new Object[] { paramEarnStateRecord.getPackageName(), localObject6 });
              localObject5 = localObject1;
            }
          }
          return (EarnStateRecord)localObject5;
        }
        catch (Exception paramEarnStateRecord)
        {
          Logger.e(Area.EARN.value(), paramEarnStateRecord, "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() failed", new Object[0]);
          return (EarnStateRecord)localObject4;
        }
        localNameNotFoundException = localNameNotFoundException;
        n = m + 1;
        m = n;
      }
      localObject4 = localObject6;
      j = i;
      localObject5 = localObject6;
      k = i;
      Thread.sleep(333L);
      m = n;
    }
    try
    {
      if (((Map)localObject5).size() > 0)
      {
        localObject4 = Utility.mapToJsonString((Map)localObject5);
        if (!StringUtility.isNullOrEmpty((String)localObject4))
        {
          EarnStateDatabase.getInstance(this._context).updateApplicationMetadata(paramEarnStateRecord.getPackageName(), (String)localObject4);
          if (EarnStateDatabase.getInstance(this._context).getAppState(paramEarnStateRecord.getPackageName()) != null) {}
          Logger.d(Area.EARN.value(), "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() Application metadata update [packageName:'%1$s' metadata:'%2$s']", new Object[] { paramEarnStateRecord.getPackageName(), localObject4 });
        }
      }
    }
    catch (Exception paramEarnStateRecord)
    {
      for (;;)
      {
        label935:
        Logger.e(Area.EARN.value(), paramEarnStateRecord, "Earning: EarningMonitor: ensureAppMetadataOnEarnStateRecord() failed", new Object[0]);
      }
    }
    throw ((Throwable)localObject2);
  }
  
  public void ensureMonitoring()
  {
    try
    {
      UsageScreenReceiver.getInstance().registerReceiver(this._context);
      if ((UsageScreenReceiver.isScreenOn(this._context)) && ((this._monitoringThread == null) || (!this._monitoringThread.isAlive())))
      {
        Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor:  ensureMonitoring() is calling startMonitoring because there is no active monitoring thread when the screen is on", new Object[0]);
        startMonitoring();
      }
      return;
    }
    finally {}
  }
  
  public boolean isMonitoring()
  {
    try
    {
      if (this._monitoringThread != null)
      {
        boolean bool = this._monitoringThread.isMonitoring();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void startMonitoring()
  {
    synchronized (this._monitoringThreadLock)
    {
      if ((this._monitoringThread == null) || (!this._monitoringThread.isAlive()) || (!this._monitoringThread.isMonitoring()))
      {
        this._monitoringThread = new EarningMonitoringThread(null);
        this._monitoringThread.start();
        Logger.v(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: earning monitoring thread [instantiated]", new Object[0]);
      }
      return;
    }
  }
  
  /* Error */
  public void stopMonitoring()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 8
    //   12: aload 5
    //   14: astore 7
    //   16: aload 10
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 55	com/getjar/sdk/data/earning/EarningMonitor:_monitoringThreadLock	Ljava/lang/Object;
    //   24: astore 11
    //   26: aload 5
    //   28: astore 7
    //   30: aload 10
    //   32: astore 6
    //   34: aload 11
    //   36: monitorenter
    //   37: aload 8
    //   39: astore 5
    //   41: aload 9
    //   43: astore 6
    //   45: aload_0
    //   46: getfield 53	com/getjar/sdk/data/earning/EarningMonitor:_monitoringThread	Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
    //   49: ifnull +51 -> 100
    //   52: aload 8
    //   54: astore 5
    //   56: aload 9
    //   58: astore 6
    //   60: aload_0
    //   61: getfield 53	com/getjar/sdk/data/earning/EarningMonitor:_monitoringThread	Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
    //   64: invokevirtual 367	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:isMonitoring	()Z
    //   67: ifeq +33 -> 100
    //   70: aload 9
    //   72: astore 6
    //   74: aload_0
    //   75: getfield 53	com/getjar/sdk/data/earning/EarningMonitor:_monitoringThread	Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
    //   78: invokevirtual 382	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:requestThreadExit	()V
    //   81: aload 9
    //   83: astore 6
    //   85: aload_0
    //   86: getfield 53	com/getjar/sdk/data/earning/EarningMonitor:_monitoringThread	Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
    //   89: astore 5
    //   91: aload 5
    //   93: astore 6
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 53	com/getjar/sdk/data/earning/EarningMonitor:_monitoringThread	Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
    //   100: aload 5
    //   102: astore 6
    //   104: aload 11
    //   106: monitorexit
    //   107: aload 5
    //   109: ifnull +28 -> 137
    //   112: aload 5
    //   114: astore 6
    //   116: aload 5
    //   118: ldc2_w 383
    //   121: invokevirtual 387	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:join	(J)V
    //   124: aload 5
    //   126: astore 7
    //   128: aload 5
    //   130: astore 6
    //   132: aload 5
    //   134: invokevirtual 390	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:interrupt	()V
    //   137: getstatic 145	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   140: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   143: lstore_1
    //   144: getstatic 152	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   147: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   150: lstore_3
    //   151: aload 5
    //   153: ifnull +213 -> 366
    //   156: aload 5
    //   158: invokevirtual 393	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:getId	()J
    //   161: invokestatic 396	java/lang/Long:toString	(J)Ljava/lang/String;
    //   164: astore 5
    //   166: lload_1
    //   167: lload_3
    //   168: lor
    //   169: ldc_w 398
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload 5
    //   180: aastore
    //   181: invokestatic 378	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   184: return
    //   185: astore 5
    //   187: aload 11
    //   189: monitorexit
    //   190: aload 6
    //   192: astore 7
    //   194: aload 5
    //   196: athrow
    //   197: astore 5
    //   199: aload 7
    //   201: astore 6
    //   203: getstatic 145	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   206: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   209: getstatic 152	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   212: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   215: lor
    //   216: aload 5
    //   218: ldc_w 400
    //   221: iconst_0
    //   222: anewarray 4	java/lang/Object
    //   225: invokestatic 331	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: getstatic 145	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   231: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   234: lstore_1
    //   235: getstatic 152	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   238: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   241: lstore_3
    //   242: aload 7
    //   244: ifnull +130 -> 374
    //   247: aload 7
    //   249: invokevirtual 393	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:getId	()J
    //   252: invokestatic 396	java/lang/Long:toString	(J)Ljava/lang/String;
    //   255: astore 5
    //   257: lload_1
    //   258: lload_3
    //   259: lor
    //   260: ldc_w 398
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload 5
    //   271: aastore
    //   272: invokestatic 378	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   275: return
    //   276: astore 8
    //   278: aload 5
    //   280: astore 7
    //   282: aload 5
    //   284: astore 6
    //   286: getstatic 145	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   289: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   292: getstatic 152	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   295: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   298: lor
    //   299: aload 8
    //   301: ldc_w 402
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 331	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: goto -187 -> 124
    //   314: astore 7
    //   316: getstatic 145	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   319: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   322: lstore_1
    //   323: getstatic 152	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   326: invokevirtual 149	com/getjar/sdk/logging/Area:value	()J
    //   329: lstore_3
    //   330: aload 6
    //   332: ifnull +50 -> 382
    //   335: aload 6
    //   337: invokevirtual 393	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:getId	()J
    //   340: invokestatic 396	java/lang/Long:toString	(J)Ljava/lang/String;
    //   343: astore 5
    //   345: lload_1
    //   346: lload_3
    //   347: lor
    //   348: ldc_w 398
    //   351: iconst_1
    //   352: anewarray 4	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: aload 5
    //   359: aastore
    //   360: invokestatic 378	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   363: aload 7
    //   365: athrow
    //   366: ldc_w 404
    //   369: astore 5
    //   371: goto -205 -> 166
    //   374: ldc_w 404
    //   377: astore 5
    //   379: goto -122 -> 257
    //   382: ldc_w 404
    //   385: astore 5
    //   387: goto -42 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	EarningMonitor
    //   143	203	1	l1	long
    //   150	197	3	l2	long
    //   4	175	5	localObject1	Object
    //   185	10	5	localObject2	Object
    //   197	20	5	localException1	Exception
    //   255	131	5	str	String
    //   18	318	6	localObject3	Object
    //   14	267	7	localObject4	Object
    //   314	50	7	localObject5	Object
    //   10	43	8	localObject6	Object
    //   276	24	8	localException2	Exception
    //   1	81	9	localObject7	Object
    //   7	24	10	localObject8	Object
    //   24	164	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   45	52	185	finally
    //   60	70	185	finally
    //   74	81	185	finally
    //   85	91	185	finally
    //   95	100	185	finally
    //   104	107	185	finally
    //   187	190	185	finally
    //   20	26	197	java/lang/Exception
    //   34	37	197	java/lang/Exception
    //   132	137	197	java/lang/Exception
    //   194	197	197	java/lang/Exception
    //   286	311	197	java/lang/Exception
    //   116	124	276	java/lang/Exception
    //   20	26	314	finally
    //   34	37	314	finally
    //   116	124	314	finally
    //   132	137	314	finally
    //   194	197	314	finally
    //   203	228	314	finally
    //   286	311	314	finally
  }
  
  private class EarningMonitoringThread
    extends Thread
  {
    private final Object _intervalWaitMonitor = new Object();
    private boolean _requestThreadExit = false;
    private final ActivityManager activityManager = (ActivityManager)EarningMonitor.this._context.getSystemService("activity");
    private final long incentivizedInFocusTimeInMilliseconds = Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(EarningMonitor.this._commContext, true).getDirectiveValue("earn.incentivized.monitoring.in_focus_time", SettingsManager.Scope.CLIENT)));
    private final long nonIncentivizedInFocusTimeInMilliseconds = Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(EarningMonitor.this._commContext, true).getDirectiveValue("earn.non_incentivized.monitoring.in_focus_time", SettingsManager.Scope.CLIENT)));
    
    private EarningMonitoringThread() {}
    
    private String getRunningPackageName()
    {
      return ((ActivityManager.RunningTaskInfo)this.activityManager.getRunningTasks(1).get(0)).topActivity.getPackageName();
    }
    
    private boolean sendEarnEvent(CommContext paramCommContext, EarnStateRecord paramEarnStateRecord, boolean paramBoolean)
    {
      AnalyticsManager.getInstance(EarningMonitor.this._commContext.getApplicationContext()).trackEvent("sdk_detected_open_enough", new Object[] { "package_name", paramEarnStateRecord.getPackageName(), "type", AnalyticsManager.TrackingType.EARN_CURRENCY.value() });
      try
      {
        paramCommContext = EarningMonitor.this.earn(EarningMonitor.this._context, paramCommContext, paramEarnStateRecord, paramBoolean);
        if ((paramCommContext == null) || (paramCommContext.get() == null) || (((Operation)paramCommContext.get()).getResult() == null) || (!((Operation)paramCommContext.get()).getResult().isSuccessfulResponse())) {
          Logger.w(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: EarningMonitoringThread: sendEarnEvent() earn operation failed", new Object[0]);
        }
        for (;;)
        {
          EarnStateDatabase.getInstance(EarningMonitor.this._context).updateStatus(paramEarnStateRecord.getPackageName(), EarnStateDatabase.Status.OPENED);
          return true;
          Logger.v(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: EarningMonitoringThread: sendEarnEvent() earn operation succeeded", new Object[0]);
        }
        return false;
      }
      catch (Exception paramCommContext)
      {
        Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), paramCommContext, "Earning: EarningMonitor: EarningMonitoringThread: sendEarnEvent() failed", new Object[0]);
      }
    }
    
    private boolean sendOpenEvent(CommContext paramCommContext, EarnStateRecord paramEarnStateRecord)
    {
      if (paramCommContext == null) {
        throw new IllegalArgumentException("commContext cannot be null");
      }
      if (paramEarnStateRecord == null) {
        throw new IllegalArgumentException("appState cannot be null");
      }
      AnalyticsManager.getInstance(EarningMonitor.this._commContext.getApplicationContext()).trackEvent("sdk_detected_open", new Object[] { "package_name", paramEarnStateRecord.getPackageName(), "type", AnalyticsManager.TrackingType.EARN_CURRENCY.value() });
      for (;;)
      {
        Object localObject;
        try
        {
          EarnStateRecord localEarnStateRecord = EarningMonitor.this.ensureAppMetadataOnEarnStateRecord(paramEarnStateRecord);
          localObject = null;
          paramCommContext = null;
          AdManager.initialize(EarningMonitor.this._commContext);
          paramEarnStateRecord = AdManager.getInstance().getTriggeredAd(localEarnStateRecord.getPackageName());
          if (paramEarnStateRecord != null)
          {
            localObject = paramEarnStateRecord.getType();
            paramCommContext = paramEarnStateRecord.getAdPlacementTag();
            paramEarnStateRecord = Utility.jsonArrayStringToMap(paramEarnStateRecord.getTrackingMetadata());
            AdManager.getInstance().removeTriggeredAd(localEarnStateRecord.getPackageName());
            if (localObject != null)
            {
              paramEarnStateRecord.put("ads.layout_type", ((AdManager.AdType)localObject).name());
              break label238;
              paramEarnStateRecord.put("ads.placement", localObject);
              BeaconManager.getInstance(EarningMonitor.this._context).initiateBeaconMessage(EarningMonitor.this._commContext, BeaconMessage.BeaconType.AD_OPENED, paramEarnStateRecord);
              return true;
            }
          }
          else
          {
            paramEarnStateRecord = Utility.jsonArrayStringToMapUnchange(localEarnStateRecord.getTrackingMetadata());
            continue;
          }
          localObject = paramCommContext;
        }
        catch (Exception paramCommContext)
        {
          Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), paramCommContext, "Earning: EarningMonitor: EarningMonitoringThread: sendOpenEvent() failed", new Object[0]);
          return false;
        }
        label238:
        if (paramCommContext == null) {
          localObject = "";
        }
      }
    }
    
    private void showNotifications(CommContext paramCommContext, EarnStateRecord paramEarnStateRecord)
    {
      long l1 = System.currentTimeMillis();
      long l3;
      try
      {
        long l2 = paramEarnStateRecord.getTimestampCreated();
        l3 = l1 - paramEarnStateRecord.getTimestampModified();
        if (l1 - l2 > 86400000L)
        {
          Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: EarningMonitoringThread: %s timed out", new Object[] { paramEarnStateRecord.getPackageName() });
          NotificationsUtility.clearEarnInstallNotification(EarningMonitor.this._context, paramEarnStateRecord.getPackageName());
          NotificationsUtility.clearEarnOpenNotification(EarningMonitor.this._context, paramEarnStateRecord.getPackageName());
          EarnStateDatabase.getInstance(EarningMonitor.this._context).updateNotificationState(paramEarnStateRecord.getPackageName(), EarnStateDatabase.NotificationState.DONE);
          return;
        }
        if ((l3 <= 60000L) || (!EarnStateDatabase.Status.INSTALLED.equals(paramEarnStateRecord.getStatus())) || (!paramEarnStateRecord.canShowOpenReminder())) {
          break label442;
        }
        Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: EarningMonitoringThread: %s showing open reminder notification", new Object[] { paramEarnStateRecord.getPackageName() });
        paramCommContext = null;
      }
      catch (Exception paramCommContext)
      {
        JSONObject localJSONObject;
        label189:
        Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), paramCommContext, "Earning: EarningMonitor: EarningMonitoringThread: failed timeout and notification processing for %1$s", new Object[] { paramEarnStateRecord.getPackageName() });
        return;
      }
      try
      {
        localJSONObject = new JSONArray(paramEarnStateRecord.getTrackingMetadata()).getJSONObject(0);
        paramCommContext = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        Logger.w(Area.EARN.value() | Area.TRANSACTION.value(), localJSONException, "Error getting trackingMetaMap", new Object[0]);
        break label189;
        EarnStateDatabase.getInstance(EarningMonitor.this._context).updateNotificationState(paramEarnStateRecord.getPackageName(), EarnStateDatabase.NotificationState.OPEN_REMINDER);
        NotificationsUtility.clearEarnInstallNotification(EarningMonitor.this._context, paramEarnStateRecord.getPackageName());
        return;
      }
      if ((paramCommContext != null) && (paramCommContext.has("earn.currency_key")) && (!"none".equals(paramCommContext.getString("earn.currency_key")))) {
        if (!NotificationsUtility.showEarnOpenNotification(EarningMonitor.this._context, paramEarnStateRecord.getPackageName(), paramEarnStateRecord.getFriendlyName()))
        {
          Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: EarningMonitoringThread: %s no-longer installed, push the install notification instead", new Object[] { paramEarnStateRecord.getPackageName() });
          NotificationsUtility.showEarnInstallNotification(EarningMonitor.this._context, paramEarnStateRecord.getPackageName(), paramEarnStateRecord.getFriendlyName());
          EarnStateDatabase.getInstance(EarningMonitor.this._context).updateNotificationState(paramEarnStateRecord.getPackageName(), EarnStateDatabase.NotificationState.INSTALL_REMINDER);
          NotificationsUtility.clearEarnOpenNotification(EarningMonitor.this._context, paramEarnStateRecord.getPackageName());
          return;
        }
      }
      EarnStateDatabase.getInstance(EarningMonitor.this._context).updateNotificationState(paramEarnStateRecord.getPackageName(), EarnStateDatabase.NotificationState.OPEN_REMINDER);
      return;
      label442:
      if ((l3 > 300000L) && (EarnStateDatabase.Status.DOWNLOADED.equals(paramEarnStateRecord.getStatus())) && (paramEarnStateRecord.canShowInstallReminder()))
      {
        Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "Earning: EarningMonitor: EarningMonitoringThread: %s showing install reminder notification", new Object[] { paramEarnStateRecord.getPackageName() });
        EarnStateDatabase.getInstance(EarningMonitor.this._context).updateNotificationState(paramEarnStateRecord.getPackageName(), EarnStateDatabase.NotificationState.INSTALL_REMINDER);
        NotificationsUtility.clearEarnOpenNotification(EarningMonitor.this._context, paramEarnStateRecord.getPackageName());
      }
    }
    
    public boolean isMonitoring()
    {
      return !this._requestThreadExit;
    }
    
    public void requestThreadExit()
    {
      this._requestThreadExit = true;
      synchronized (this._intervalWaitMonitor)
      {
        this._intervalWaitMonitor.notify();
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   3: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   6: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   9: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   12: lor
      //   13: getstatic 437	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
      //   16: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   19: lor
      //   20: ldc_w 439
      //   23: iconst_1
      //   24: anewarray 85	java/lang/Object
      //   27: dup
      //   28: iconst_0
      //   29: invokestatic 443	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   32: invokevirtual 446	java/lang/Thread:getId	()J
      //   35: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   38: aastore
      //   39: invokestatic 328	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   42: aload_0
      //   43: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   46: invokestatic 69	com/getjar/sdk/data/earning/EarningMonitor:access$200	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Landroid/content/Context;
      //   49: invokestatic 455	com/getjar/sdk/comm/auth/AuthManager:initialize	(Landroid/content/Context;)V
      //   52: invokestatic 458	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   55: invokevirtual 461	com/getjar/sdk/comm/auth/AuthManager:waitOnAuth	()V
      //   58: invokestatic 464	com/getjar/sdk/data/earning/EarningMonitor:access$300	()Z
      //   61: ifeq +404 -> 465
      //   64: aload_0
      //   65: getfield 83	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_requestThreadExit	Z
      //   68: ifne +397 -> 465
      //   71: aload_0
      //   72: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   75: invokestatic 69	com/getjar/sdk/data/earning/EarningMonitor:access$200	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Landroid/content/Context;
      //   78: invokestatic 198	com/getjar/sdk/data/earning/EarnStateDatabase:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/earning/EarnStateDatabase;
      //   81: invokevirtual 468	com/getjar/sdk/data/earning/EarnStateDatabase:getAllDownloadedOrInstalledAppStates	()Ljava/util/List;
      //   84: astore 6
      //   86: new 470	java/util/HashSet
      //   89: dup
      //   90: invokespecial 471	java/util/HashSet:<init>	()V
      //   93: astore 4
      //   95: aload 6
      //   97: invokeinterface 475 1 0
      //   102: ifle +263 -> 365
      //   105: new 470	java/util/HashSet
      //   108: dup
      //   109: aload_0
      //   110: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   113: invokestatic 69	com/getjar/sdk/data/earning/EarningMonitor:access$200	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Landroid/content/Context;
      //   116: invokestatic 481	com/getjar/sdk/utilities/SystemUtility:getRecentlyRunAppsFromOS	(Landroid/content/Context;)Ljava/util/List;
      //   119: invokespecial 484	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   122: astore 5
      //   124: aload_0
      //   125: getfield 81	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:activityManager	Landroid/app/ActivityManager;
      //   128: bipush 100
      //   130: invokevirtual 98	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
      //   133: invokeinterface 488 1 0
      //   138: astore 7
      //   140: aload 5
      //   142: astore 4
      //   144: aload 7
      //   146: invokeinterface 493 1 0
      //   151: ifeq +214 -> 365
      //   154: aload 5
      //   156: aload 7
      //   158: invokeinterface 496 1 0
      //   163: checkcast 106	android/app/ActivityManager$RunningTaskInfo
      //   166: getfield 110	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
      //   169: invokevirtual 115	android/content/ComponentName:getPackageName	()Ljava/lang/String;
      //   172: invokeinterface 501 2 0
      //   177: pop
      //   178: goto -38 -> 140
      //   181: astore 4
      //   183: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   186: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   189: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   192: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   195: lor
      //   196: aload 4
      //   198: ldc_w 503
      //   201: iconst_0
      //   202: anewarray 85	java/lang/Object
      //   205: invokestatic 219	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   208: aload_0
      //   209: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   212: invokestatic 507	com/getjar/sdk/data/earning/EarningMonitor:access$600	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Ljava/lang/Object;
      //   215: astore 4
      //   217: aload 4
      //   219: monitorenter
      //   220: aload_0
      //   221: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   224: aconst_null
      //   225: invokestatic 511	com/getjar/sdk/data/earning/EarningMonitor:access$702	(Lcom/getjar/sdk/data/earning/EarningMonitor;Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;)Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
      //   228: pop
      //   229: aload 4
      //   231: monitorexit
      //   232: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   235: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   238: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   241: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   244: lor
      //   245: ldc_w 513
      //   248: iconst_1
      //   249: anewarray 85	java/lang/Object
      //   252: dup
      //   253: iconst_0
      //   254: invokestatic 443	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   257: invokevirtual 446	java/lang/Thread:getId	()J
      //   260: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   263: aastore
      //   264: invokestatic 328	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   267: return
      //   268: astore 4
      //   270: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   273: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   276: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   279: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   282: lor
      //   283: ldc_w 515
      //   286: iconst_0
      //   287: anewarray 85	java/lang/Object
      //   290: invokestatic 193	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   293: aload_0
      //   294: iconst_1
      //   295: putfield 83	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_requestThreadExit	Z
      //   298: goto -240 -> 58
      //   301: astore 5
      //   303: aload_0
      //   304: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   307: invokestatic 507	com/getjar/sdk/data/earning/EarningMonitor:access$600	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Ljava/lang/Object;
      //   310: astore 4
      //   312: aload 4
      //   314: monitorenter
      //   315: aload_0
      //   316: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   319: aconst_null
      //   320: invokestatic 511	com/getjar/sdk/data/earning/EarningMonitor:access$702	(Lcom/getjar/sdk/data/earning/EarningMonitor;Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;)Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
      //   323: pop
      //   324: aload 4
      //   326: monitorexit
      //   327: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   330: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   333: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   336: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   339: lor
      //   340: ldc_w 513
      //   343: iconst_1
      //   344: anewarray 85	java/lang/Object
      //   347: dup
      //   348: iconst_0
      //   349: invokestatic 443	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   352: invokevirtual 446	java/lang/Thread:getId	()J
      //   355: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   358: aastore
      //   359: invokestatic 328	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   362: aload 5
      //   364: athrow
      //   365: aload 6
      //   367: invokeinterface 488 1 0
      //   372: astore 5
      //   374: aload 5
      //   376: invokeinterface 493 1 0
      //   381: ifeq +79 -> 460
      //   384: aload 5
      //   386: invokeinterface 496 1 0
      //   391: checkcast 136	com/getjar/sdk/data/earning/EarnStateRecord
      //   394: astore 6
      //   396: aload 4
      //   398: aload 6
      //   400: invokevirtual 137	com/getjar/sdk/data/earning/EarnStateRecord:getPackageName	()Ljava/lang/String;
      //   403: invokeinterface 518 2 0
      //   408: ifeq -34 -> 374
      //   411: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   414: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   417: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   420: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   423: lor
      //   424: ldc_w 520
      //   427: iconst_1
      //   428: anewarray 85	java/lang/Object
      //   431: dup
      //   432: iconst_0
      //   433: aload 6
      //   435: invokevirtual 137	com/getjar/sdk/data/earning/EarnStateRecord:getPackageName	()Ljava/lang/String;
      //   438: aastore
      //   439: invokestatic 328	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   442: aload_0
      //   443: aload_0
      //   444: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   447: invokestatic 29	com/getjar/sdk/data/earning/EarningMonitor:access$100	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Lcom/getjar/sdk/comm/CommContext;
      //   450: aload 6
      //   452: iconst_1
      //   453: invokespecial 522	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:sendEarnEvent	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/data/earning/EarnStateRecord;Z)Z
      //   456: pop
      //   457: goto -83 -> 374
      //   460: iconst_0
      //   461: invokestatic 526	com/getjar/sdk/data/earning/EarningMonitor:access$302	(Z)Z
      //   464: pop
      //   465: aload_0
      //   466: getfield 83	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_requestThreadExit	Z
      //   469: istore_1
      //   470: iload_1
      //   471: ifne +488 -> 959
      //   474: aload_0
      //   475: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   478: invokestatic 69	com/getjar/sdk/data/earning/EarningMonitor:access$200	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Landroid/content/Context;
      //   481: invokestatic 532	com/getjar/sdk/data/usage/UsageScreenReceiver:isScreenOn	(Landroid/content/Context;)Z
      //   484: ifne +73 -> 557
      //   487: aload_0
      //   488: iconst_1
      //   489: putfield 83	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_requestThreadExit	Z
      //   492: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   495: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   498: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   501: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   504: lor
      //   505: ldc_w 534
      //   508: iconst_0
      //   509: anewarray 85	java/lang/Object
      //   512: invokestatic 536	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   515: goto -50 -> 465
      //   518: astore 4
      //   520: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   523: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   526: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   529: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   532: lor
      //   533: ldc_w 538
      //   536: iconst_0
      //   537: anewarray 85	java/lang/Object
      //   540: invokestatic 193	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   543: invokestatic 458	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   546: invokevirtual 541	com/getjar/sdk/comm/auth/AuthManager:reAuth	()V
      //   549: goto -84 -> 465
      //   552: astore 4
      //   554: goto -89 -> 465
      //   557: aload_0
      //   558: getfield 83	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_requestThreadExit	Z
      //   561: ifne +29 -> 590
      //   564: aload_0
      //   565: getfield 88	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_intervalWaitMonitor	Ljava/lang/Object;
      //   568: astore 4
      //   570: aload 4
      //   572: monitorenter
      //   573: aload_0
      //   574: getfield 88	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_intervalWaitMonitor	Ljava/lang/Object;
      //   577: aload_0
      //   578: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   581: invokestatic 545	com/getjar/sdk/data/earning/EarningMonitor:access$400	(Lcom/getjar/sdk/data/earning/EarningMonitor;)J
      //   584: invokevirtual 549	java/lang/Object:wait	(J)V
      //   587: aload 4
      //   589: monitorexit
      //   590: aload_0
      //   591: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   594: invokestatic 69	com/getjar/sdk/data/earning/EarningMonitor:access$200	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Landroid/content/Context;
      //   597: invokestatic 198	com/getjar/sdk/data/earning/EarnStateDatabase:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/earning/EarnStateDatabase;
      //   600: ldc2_w 322
      //   603: invokevirtual 552	com/getjar/sdk/data/earning/EarnStateDatabase:deleteOldRecords	(J)V
      //   606: aload_0
      //   607: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   610: invokestatic 69	com/getjar/sdk/data/earning/EarningMonitor:access$200	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Landroid/content/Context;
      //   613: invokestatic 198	com/getjar/sdk/data/earning/EarnStateDatabase:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/earning/EarnStateDatabase;
      //   616: invokevirtual 468	com/getjar/sdk/data/earning/EarnStateDatabase:getAllDownloadedOrInstalledAppStates	()Ljava/util/List;
      //   619: astore 6
      //   621: aload 6
      //   623: invokeinterface 475 1 0
      //   628: ifgt +69 -> 697
      //   631: aload_0
      //   632: iconst_1
      //   633: putfield 83	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_requestThreadExit	Z
      //   636: aload_0
      //   637: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   640: invokestatic 556	com/getjar/sdk/data/earning/EarningMonitor:access$500	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Ljava/util/Set;
      //   643: invokeinterface 559 1 0
      //   648: goto -183 -> 465
      //   651: astore 4
      //   653: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   656: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   659: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   662: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   665: lor
      //   666: ldc_w 561
      //   669: iconst_1
      //   670: anewarray 85	java/lang/Object
      //   673: dup
      //   674: iconst_0
      //   675: aload_0
      //   676: getfield 83	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:_requestThreadExit	Z
      //   679: invokestatic 566	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   682: aastore
      //   683: invokestatic 328	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   686: goto -221 -> 465
      //   689: astore 5
      //   691: aload 4
      //   693: monitorexit
      //   694: aload 5
      //   696: athrow
      //   697: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   700: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   703: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   706: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   709: lor
      //   710: ldc_w 568
      //   713: iconst_1
      //   714: anewarray 85	java/lang/Object
      //   717: dup
      //   718: iconst_0
      //   719: aload 6
      //   721: invokeinterface 475 1 0
      //   726: invokestatic 573	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   729: aastore
      //   730: invokestatic 328	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   733: aload_0
      //   734: invokespecial 575	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:getRunningPackageName	()Ljava/lang/String;
      //   737: astore 4
      //   739: aload_0
      //   740: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   743: invokestatic 69	com/getjar/sdk/data/earning/EarningMonitor:access$200	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Landroid/content/Context;
      //   746: invokestatic 580	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
      //   749: aload 6
      //   751: aload_0
      //   752: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   755: invokestatic 545	com/getjar/sdk/data/earning/EarningMonitor:access$400	(Lcom/getjar/sdk/data/earning/EarningMonitor;)J
      //   758: invokevirtual 584	com/getjar/sdk/data/usage/UsageManager:getPackageDurationForEarning	(Ljava/util/List;J)Ljava/util/Map;
      //   761: astore 5
      //   763: aload 6
      //   765: invokeinterface 488 1 0
      //   770: astore 6
      //   772: aload 6
      //   774: invokeinterface 493 1 0
      //   779: ifeq -314 -> 465
      //   782: aload 6
      //   784: invokeinterface 496 1 0
      //   789: checkcast 136	com/getjar/sdk/data/earning/EarnStateRecord
      //   792: astore 7
      //   794: aload 7
      //   796: invokevirtual 137	com/getjar/sdk/data/earning/EarnStateRecord:getPackageName	()Ljava/lang/String;
      //   799: astore 8
      //   801: aload 5
      //   803: aload 8
      //   805: invokeinterface 589 2 0
      //   810: checkcast 49	java/lang/Long
      //   813: astore 9
      //   815: aload 9
      //   817: ifnull +116 -> 933
      //   820: aload 9
      //   822: invokevirtual 592	java/lang/Long:longValue	()J
      //   825: lconst_0
      //   826: lcmp
      //   827: ifle +106 -> 933
      //   830: aload_0
      //   831: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   834: invokestatic 556	com/getjar/sdk/data/earning/EarningMonitor:access$500	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Ljava/util/Set;
      //   837: aload 8
      //   839: invokeinterface 518 2 0
      //   844: ifne +34 -> 878
      //   847: aload_0
      //   848: aload_0
      //   849: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   852: invokestatic 29	com/getjar/sdk/data/earning/EarningMonitor:access$100	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Lcom/getjar/sdk/comm/CommContext;
      //   855: aload 7
      //   857: invokespecial 594	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:sendOpenEvent	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/data/earning/EarnStateRecord;)Z
      //   860: ifeq +18 -> 878
      //   863: aload_0
      //   864: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   867: invokestatic 556	com/getjar/sdk/data/earning/EarningMonitor:access$500	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Ljava/util/Set;
      //   870: aload 8
      //   872: invokeinterface 501 2 0
      //   877: pop
      //   878: aload 7
      //   880: invokevirtual 597	com/getjar/sdk/data/earning/EarnStateRecord:getCurrencyKey	()Ljava/lang/String;
      //   883: ldc_w 382
      //   886: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   889: ifeq +36 -> 925
      //   892: aload_0
      //   893: getfield 65	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:nonIncentivizedInFocusTimeInMilliseconds	J
      //   896: lstore_2
      //   897: aload 9
      //   899: invokevirtual 592	java/lang/Long:longValue	()J
      //   902: lload_2
      //   903: lcmp
      //   904: ifle +29 -> 933
      //   907: aload_0
      //   908: aload_0
      //   909: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   912: invokestatic 29	com/getjar/sdk/data/earning/EarningMonitor:access$100	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Lcom/getjar/sdk/comm/CommContext;
      //   915: aload 7
      //   917: iconst_0
      //   918: invokespecial 522	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:sendEarnEvent	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/data/earning/EarnStateRecord;Z)Z
      //   921: pop
      //   922: goto -150 -> 772
      //   925: aload_0
      //   926: getfield 61	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:incentivizedInFocusTimeInMilliseconds	J
      //   929: lstore_2
      //   930: goto -33 -> 897
      //   933: aload 8
      //   935: aload 4
      //   937: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   940: ifne -168 -> 772
      //   943: aload_0
      //   944: aload_0
      //   945: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   948: invokestatic 29	com/getjar/sdk/data/earning/EarningMonitor:access$100	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Lcom/getjar/sdk/comm/CommContext;
      //   951: aload 7
      //   953: invokespecial 599	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:showNotifications	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/data/earning/EarnStateRecord;)V
      //   956: goto -184 -> 772
      //   959: aload_0
      //   960: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   963: invokestatic 507	com/getjar/sdk/data/earning/EarningMonitor:access$600	(Lcom/getjar/sdk/data/earning/EarningMonitor;)Ljava/lang/Object;
      //   966: astore 4
      //   968: aload 4
      //   970: monitorenter
      //   971: aload_0
      //   972: getfield 22	com/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread:this$0	Lcom/getjar/sdk/data/earning/EarningMonitor;
      //   975: aconst_null
      //   976: invokestatic 511	com/getjar/sdk/data/earning/EarningMonitor:access$702	(Lcom/getjar/sdk/data/earning/EarningMonitor;Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;)Lcom/getjar/sdk/data/earning/EarningMonitor$EarningMonitoringThread;
      //   979: pop
      //   980: aload 4
      //   982: monitorexit
      //   983: getstatic 179	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
      //   986: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   989: getstatic 185	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   992: invokevirtual 182	com/getjar/sdk/logging/Area:value	()J
      //   995: lor
      //   996: ldc_w 513
      //   999: iconst_1
      //   1000: anewarray 85	java/lang/Object
      //   1003: dup
      //   1004: iconst_0
      //   1005: invokestatic 443	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1008: invokevirtual 446	java/lang/Thread:getId	()J
      //   1011: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1014: aastore
      //   1015: invokestatic 328	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   1018: return
      //   1019: astore 5
      //   1021: aload 4
      //   1023: monitorexit
      //   1024: aload 5
      //   1026: athrow
      //   1027: astore 5
      //   1029: aload 4
      //   1031: monitorexit
      //   1032: aload 5
      //   1034: athrow
      //   1035: astore 5
      //   1037: aload 4
      //   1039: monitorexit
      //   1040: aload 5
      //   1042: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1043	0	this	EarningMonitoringThread
      //   469	2	1	bool	boolean
      //   896	34	2	l	long
      //   93	50	4	localObject1	Object
      //   181	16	4	localException	Exception
      //   215	15	4	localObject2	Object
      //   268	1	4	localAuthException1	com.getjar.sdk.exceptions.AuthException
      //   310	87	4	localObject3	Object
      //   518	1	4	localAuthException2	com.getjar.sdk.exceptions.AuthException
      //   552	1	4	localAuthException3	com.getjar.sdk.exceptions.AuthException
      //   651	41	4	localInterruptedException	InterruptedException
      //   122	33	5	localHashSet	HashSet
      //   301	62	5	localObject6	Object
      //   372	13	5	localIterator	java.util.Iterator
      //   689	6	5	localObject7	Object
      //   761	41	5	localMap	Map
      //   1019	6	5	localObject8	Object
      //   1027	6	5	localObject9	Object
      //   1035	6	5	localObject10	Object
      //   84	699	6	localObject11	Object
      //   138	814	7	localObject12	Object
      //   799	135	8	str	String
      //   813	85	9	localLong	Long
      // Exception table:
      //   from	to	target	type
      //   0	42	181	java/lang/Exception
      //   42	58	181	java/lang/Exception
      //   58	95	181	java/lang/Exception
      //   95	140	181	java/lang/Exception
      //   144	178	181	java/lang/Exception
      //   270	298	181	java/lang/Exception
      //   365	374	181	java/lang/Exception
      //   374	457	181	java/lang/Exception
      //   460	465	181	java/lang/Exception
      //   465	470	181	java/lang/Exception
      //   474	515	181	java/lang/Exception
      //   520	543	181	java/lang/Exception
      //   543	549	181	java/lang/Exception
      //   557	573	181	java/lang/Exception
      //   590	648	181	java/lang/Exception
      //   653	686	181	java/lang/Exception
      //   694	697	181	java/lang/Exception
      //   697	772	181	java/lang/Exception
      //   772	815	181	java/lang/Exception
      //   820	878	181	java/lang/Exception
      //   878	897	181	java/lang/Exception
      //   897	922	181	java/lang/Exception
      //   925	930	181	java/lang/Exception
      //   933	956	181	java/lang/Exception
      //   42	58	268	com/getjar/sdk/exceptions/AuthException
      //   0	42	301	finally
      //   42	58	301	finally
      //   58	95	301	finally
      //   95	140	301	finally
      //   144	178	301	finally
      //   183	208	301	finally
      //   270	298	301	finally
      //   365	374	301	finally
      //   374	457	301	finally
      //   460	465	301	finally
      //   465	470	301	finally
      //   474	515	301	finally
      //   520	543	301	finally
      //   543	549	301	finally
      //   557	573	301	finally
      //   590	648	301	finally
      //   653	686	301	finally
      //   694	697	301	finally
      //   697	772	301	finally
      //   772	815	301	finally
      //   820	878	301	finally
      //   878	897	301	finally
      //   897	922	301	finally
      //   925	930	301	finally
      //   933	956	301	finally
      //   474	515	518	com/getjar/sdk/exceptions/AuthException
      //   557	573	518	com/getjar/sdk/exceptions/AuthException
      //   590	648	518	com/getjar/sdk/exceptions/AuthException
      //   694	697	518	com/getjar/sdk/exceptions/AuthException
      //   697	772	518	com/getjar/sdk/exceptions/AuthException
      //   772	815	518	com/getjar/sdk/exceptions/AuthException
      //   820	878	518	com/getjar/sdk/exceptions/AuthException
      //   878	897	518	com/getjar/sdk/exceptions/AuthException
      //   897	922	518	com/getjar/sdk/exceptions/AuthException
      //   925	930	518	com/getjar/sdk/exceptions/AuthException
      //   933	956	518	com/getjar/sdk/exceptions/AuthException
      //   543	549	552	com/getjar/sdk/exceptions/AuthException
      //   474	515	651	java/lang/InterruptedException
      //   557	573	651	java/lang/InterruptedException
      //   590	648	651	java/lang/InterruptedException
      //   694	697	651	java/lang/InterruptedException
      //   697	772	651	java/lang/InterruptedException
      //   772	815	651	java/lang/InterruptedException
      //   820	878	651	java/lang/InterruptedException
      //   878	897	651	java/lang/InterruptedException
      //   897	922	651	java/lang/InterruptedException
      //   925	930	651	java/lang/InterruptedException
      //   933	956	651	java/lang/InterruptedException
      //   573	590	689	finally
      //   691	694	689	finally
      //   971	983	1019	finally
      //   1021	1024	1019	finally
      //   220	232	1027	finally
      //   1029	1032	1027	finally
      //   315	327	1035	finally
      //   1037	1040	1035	finally
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/earning/EarningMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */