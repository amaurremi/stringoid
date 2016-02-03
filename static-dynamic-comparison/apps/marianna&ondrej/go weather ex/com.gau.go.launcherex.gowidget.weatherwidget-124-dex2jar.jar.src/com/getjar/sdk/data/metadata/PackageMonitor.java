package com.getjar.sdk.data.metadata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.getjar.sdk.comm.BeaconManager;
import com.getjar.sdk.comm.BeaconMessage.BeaconType;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.TransactionManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.cache.Ad;
import com.getjar.sdk.data.cache.AdManager;
import com.getjar.sdk.data.cache.AdManager.AdType;
import com.getjar.sdk.data.earning.EarnStateDatabase;
import com.getjar.sdk.data.earning.EarnStateDatabase.Status;
import com.getjar.sdk.data.earning.EarnStateRecord;
import com.getjar.sdk.data.earning.EarningMonitor;
import com.getjar.sdk.data.usage.AnalyticsManager;
import com.getjar.sdk.data.usage.AnalyticsManager.TrackingType;
import com.getjar.sdk.data.usage.UsageMonitor;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.rewards.GooglePlayLaunchCachingManager;
import com.getjar.sdk.rewards.GooglePlayLaunchReason;
import com.getjar.sdk.utilities.NotificationsUtility;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.HashMap;

public class PackageMonitor
  extends BroadcastReceiver
{
  public static final int MAX_EARN_RETRIES = 3;
  public static final String OPERATION_KEY_USAGE_MONITORING_ALARM = "usageMonitoringAlarm";
  public static final String OPERATION_KEY_USAGE_TRACKING = "usageAndEventTracking";
  public static final String OPERATION_KEY_VOUCHER_REDEMPTION_CHECK = "voucherRedemptionCheck";
  public static int mEarnRetries = 0;
  private GooglePlayLaunchCachingManager _googlePlayLaunchCache = null;
  private Context mContext;
  
  private void checkForAndHandleManagedInstalls(CommContext paramCommContext, String paramString)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    Logger.d(Area.OS_ENTRY_POINT.value(), "PackageMonitor: checkForAndHandleManagedInstalls() START", new Object[0]);
    for (;;)
    {
      String str;
      try
      {
        Context localContext = paramCommContext.getApplicationContext();
        localEarnStateRecord = EarnStateDatabase.getInstance(localContext).getAppState(paramString);
        AdManager.AdType localAdType;
        if (localEarnStateRecord != null)
        {
          Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "PackageMonitor: checkForAndHandleManagedInstalls() Host app %1$s is managing an EARN related event for %2$s", new Object[] { localContext.getPackageName(), paramString });
          AnalyticsManager.getInstance(localContext).trackEvent("user_performed_install", new Object[] { "package_name", paramString, "type", AnalyticsManager.TrackingType.EARN_CURRENCY.value() });
          localAdType = null;
          str = null;
        }
        try
        {
          AdManager.initialize(paramCommContext);
          localObject = AdManager.getInstance().getTriggeredAd(paramString);
          if (localObject == null) {
            continue;
          }
          localAdType = ((Ad)localObject).getType();
          str = ((Ad)localObject).getAdPlacementTag();
          localObject = Utility.jsonArrayStringToMap(((Ad)localObject).getTrackingMetadata());
          if (localAdType == null) {
            break label443;
          }
          ((HashMap)localObject).put("ads.layout_type", localAdType.name());
        }
        catch (Exception paramCommContext)
        {
          Object localObject;
          Logger.e(Area.OS_ENTRY_POINT.value(), paramCommContext, "PackageMonitor: doOnReceive(): sending 'installed' beacon failed", new Object[0]);
          continue;
        }
        ((HashMap)localObject).put("ads.placement", str);
        BeaconManager.getInstance(localContext).initiateBeaconMessage(paramCommContext, BeaconMessage.BeaconType.AD_INSTALLED, (HashMap)localObject);
        EarnStateDatabase.getInstance(localContext).updateStatus(paramString, EarnStateDatabase.Status.INSTALLED);
        EarningMonitor.getInstance(localContext).ensureMonitoring();
        UsageMonitor.getInstance(localContext).ensureMonitoring();
        EarningMonitor.getInstance(localContext).ensureAppMetadataOnEarnStateRecord(localEarnStateRecord);
        paramCommContext = this._googlePlayLaunchCache.get(paramString);
        if ((paramCommContext != null) && (GooglePlayLaunchReason.REDEEM.equals(paramCommContext)))
        {
          Logger.d(Area.REDEEM.value() | Area.OFFER.value(), "PackageMonitor: checkForAndHandleManagedInstalls() Host app %1$s is managing a REDEEM related event for %2$s", new Object[] { localContext.getPackageName(), paramString });
          NotificationsUtility.showRedeemReminderNotification(localContext);
          this._googlePlayLaunchCache.remove(paramString);
        }
        return;
      }
      catch (Exception paramCommContext)
      {
        EarnStateRecord localEarnStateRecord;
        Logger.e(Area.OS_ENTRY_POINT.value(), paramCommContext, "PackageMonitor: checkForAndHandleManagedInstalls() failed", new Object[0]);
        return;
      }
      finally
      {
        Logger.d(Area.OS_ENTRY_POINT.value(), "PackageMonitor: checkForAndHandleManagedInstalls() DONE", new Object[0]);
      }
      localObject = Utility.jsonArrayStringToMapUnchange(localEarnStateRecord.getTrackingMetadata());
      continue;
      continue;
      label443:
      if (str == null) {
        str = "";
      }
    }
  }
  
  /* Error */
  private void doOnReceive(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   6: ldc_w 277
    //   9: iconst_0
    //   10: anewarray 73	java/lang/Object
    //   13: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_1
    //   17: ifnonnull +77 -> 94
    //   20: new 46	java/lang/IllegalArgumentException
    //   23: dup
    //   24: ldc_w 279
    //   27: invokespecial 51	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   30: athrow
    //   31: astore_1
    //   32: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   35: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   38: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   41: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   44: lor
    //   45: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   48: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   51: lor
    //   52: aload_1
    //   53: ldc_w 284
    //   56: iconst_0
    //   57: anewarray 73	java/lang/Object
    //   60: invokestatic 267	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   66: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   69: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   72: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   75: lor
    //   76: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   79: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   82: lor
    //   83: ldc_w 286
    //   86: iconst_0
    //   87: anewarray 73	java/lang/Object
    //   90: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   93: return
    //   94: aload_2
    //   95: ifnonnull +47 -> 142
    //   98: new 46	java/lang/IllegalArgumentException
    //   101: dup
    //   102: ldc_w 288
    //   105: invokespecial 51	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   108: athrow
    //   109: astore_1
    //   110: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   113: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   116: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   119: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   122: lor
    //   123: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   126: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   129: lor
    //   130: ldc_w 286
    //   133: iconst_0
    //   134: anewarray 73	java/lang/Object
    //   137: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_1
    //   141: athrow
    //   142: aload_0
    //   143: aload_1
    //   144: putfield 290	com/getjar/sdk/data/metadata/PackageMonitor:mContext	Landroid/content/Context;
    //   147: aload_0
    //   148: getfield 34	com/getjar/sdk/data/metadata/PackageMonitor:_googlePlayLaunchCache	Lcom/getjar/sdk/rewards/GooglePlayLaunchCachingManager;
    //   151: ifnonnull +15 -> 166
    //   154: aload_0
    //   155: new 223	com/getjar/sdk/rewards/GooglePlayLaunchCachingManager
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 292	com/getjar/sdk/rewards/GooglePlayLaunchCachingManager:<init>	(Landroid/content/Context;)V
    //   163: putfield 34	com/getjar/sdk/data/metadata/PackageMonitor:_googlePlayLaunchCache	Lcom/getjar/sdk/rewards/GooglePlayLaunchCachingManager;
    //   166: aload_1
    //   167: invokestatic 295	com/getjar/sdk/utilities/Utility:previousVersionCleanUp	(Landroid/content/Context;)V
    //   170: aload_1
    //   171: invokestatic 300	com/getjar/sdk/comm/auth/ApplicationTokenDatabase:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/comm/auth/ApplicationTokenDatabase;
    //   174: invokevirtual 303	com/getjar/sdk/comm/auth/ApplicationTokenDatabase:getApplicationToken	()Ljava/lang/String;
    //   177: invokestatic 57	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   180: ifeq +64 -> 244
    //   183: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   186: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   189: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   192: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   195: lor
    //   196: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   199: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   202: lor
    //   203: ldc_w 305
    //   206: iconst_0
    //   207: anewarray 73	java/lang/Object
    //   210: invokestatic 308	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   213: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   216: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   219: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   222: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   225: lor
    //   226: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   229: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   232: lor
    //   233: ldc_w 286
    //   236: iconst_0
    //   237: anewarray 73	java/lang/Object
    //   240: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   243: return
    //   244: aload_1
    //   245: invokestatic 314	com/getjar/sdk/comm/CommManager:createContext	(Landroid/content/Context;)Lcom/getjar/sdk/comm/CommContext;
    //   248: astore 6
    //   250: aload_1
    //   251: invokestatic 318	com/getjar/sdk/comm/auth/AuthManager:initialize	(Landroid/content/Context;)V
    //   254: invokestatic 321	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
    //   257: invokevirtual 324	com/getjar/sdk/comm/auth/AuthManager:waitOnAuth	()V
    //   260: aload_2
    //   261: invokevirtual 330	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   264: astore 7
    //   266: invokestatic 321	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
    //   269: invokevirtual 333	com/getjar/sdk/comm/auth/AuthManager:getAuthToken	()Ljava/lang/String;
    //   272: astore 8
    //   274: aload 6
    //   276: ifnull +27 -> 303
    //   279: aload 8
    //   281: invokestatic 57	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   284: ifne +19 -> 303
    //   287: aload_0
    //   288: aload_1
    //   289: aload 6
    //   291: invokespecial 337	com/getjar/sdk/data/metadata/PackageMonitor:shouldRetryTransactions	(Landroid/content/Context;Lcom/getjar/sdk/comm/CommContext;)Z
    //   294: ifeq +9 -> 303
    //   297: aload_0
    //   298: aload 6
    //   300: invokespecial 340	com/getjar/sdk/data/metadata/PackageMonitor:runPendingEarnTransactionsAndCleanup	(Lcom/getjar/sdk/comm/CommContext;)V
    //   303: aload 7
    //   305: ifnull +213 -> 518
    //   308: aload 7
    //   310: ldc 13
    //   312: invokevirtual 346	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokestatic 57	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   318: ifne +200 -> 518
    //   321: new 326	android/content/Intent
    //   324: dup
    //   325: ldc_w 348
    //   328: invokespecial 349	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   331: astore_2
    //   332: aload_2
    //   333: aload_1
    //   334: ldc_w 351
    //   337: invokevirtual 355	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   340: pop
    //   341: aload_1
    //   342: aload_2
    //   343: invokevirtual 359	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   346: pop
    //   347: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   350: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   353: ldc_w 361
    //   356: iconst_0
    //   357: anewarray 73	java/lang/Object
    //   360: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   363: aload_1
    //   364: invokestatic 208	com/getjar/sdk/data/earning/EarningMonitor:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/earning/EarningMonitor;
    //   367: invokevirtual 211	com/getjar/sdk/data/earning/EarningMonitor:ensureMonitoring	()V
    //   370: aload_1
    //   371: invokestatic 216	com/getjar/sdk/data/usage/UsageMonitor:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageMonitor;
    //   374: invokevirtual 217	com/getjar/sdk/data/usage/UsageMonitor:ensureMonitoring	()V
    //   377: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   380: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   383: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   386: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   389: lor
    //   390: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   393: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   396: lor
    //   397: ldc_w 286
    //   400: iconst_0
    //   401: anewarray 73	java/lang/Object
    //   404: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   407: return
    //   408: astore_1
    //   409: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   412: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   415: ldc_w 363
    //   418: iconst_1
    //   419: anewarray 73	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: aload_1
    //   425: invokevirtual 366	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   428: aastore
    //   429: invokestatic 368	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   432: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   435: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   438: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   441: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   444: lor
    //   445: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   448: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   451: lor
    //   452: ldc_w 286
    //   455: iconst_0
    //   456: anewarray 73	java/lang/Object
    //   459: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   462: return
    //   463: astore_1
    //   464: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   467: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   470: ldc_w 363
    //   473: iconst_1
    //   474: anewarray 73	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_1
    //   480: invokevirtual 369	com/getjar/sdk/exceptions/AuthException:getMessage	()Ljava/lang/String;
    //   483: aastore
    //   484: invokestatic 368	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   487: getstatic 65	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   490: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   493: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   496: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   499: lor
    //   500: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   503: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   506: lor
    //   507: ldc_w 286
    //   510: iconst_0
    //   511: anewarray 73	java/lang/Object
    //   514: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   517: return
    //   518: aload 7
    //   520: ifnull +304 -> 824
    //   523: aload 7
    //   525: ldc 19
    //   527: invokevirtual 346	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   530: invokestatic 57	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   533: ifne +291 -> 824
    //   536: aload 7
    //   538: ldc_w 371
    //   541: invokevirtual 346	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   544: astore_2
    //   545: getstatic 239	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
    //   548: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   551: getstatic 242	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
    //   554: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   557: lor
    //   558: ldc_w 373
    //   561: iconst_1
    //   562: anewarray 73	java/lang/Object
    //   565: dup
    //   566: iconst_0
    //   567: aload_2
    //   568: aastore
    //   569: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   572: aload_2
    //   573: invokestatic 57	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   576: istore 5
    //   578: iload 5
    //   580: ifne -217 -> 363
    //   583: iconst_0
    //   584: istore 4
    //   586: invokestatic 378	com/getjar/sdk/comm/VoucherServiceProxy:getInstance	()Lcom/getjar/sdk/comm/VoucherServiceProxy;
    //   589: aload 6
    //   591: aload_2
    //   592: iconst_1
    //   593: invokevirtual 382	com/getjar/sdk/comm/VoucherServiceProxy:getVoucher	(Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;Z)Lcom/getjar/sdk/comm/Operation;
    //   596: invokevirtual 387	com/getjar/sdk/comm/Operation:get	()Lcom/getjar/sdk/comm/Result;
    //   599: astore 6
    //   601: iload 4
    //   603: istore_3
    //   604: aload 6
    //   606: ifnull +100 -> 706
    //   609: iload 4
    //   611: istore_3
    //   612: aload 6
    //   614: invokevirtual 393	com/getjar/sdk/comm/Result:isSuccessfulResponse	()Z
    //   617: ifeq +89 -> 706
    //   620: iload 4
    //   622: istore_3
    //   623: aload 6
    //   625: invokevirtual 397	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   628: ifnull +78 -> 706
    //   631: iload 4
    //   633: istore_3
    //   634: aload 6
    //   636: invokevirtual 397	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   639: ldc_w 399
    //   642: invokevirtual 404	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   645: ifeq +61 -> 706
    //   648: iload 4
    //   650: istore_3
    //   651: aload 6
    //   653: invokevirtual 397	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   656: ldc_w 399
    //   659: invokevirtual 408	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   662: ldc_w 410
    //   665: invokevirtual 404	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   668: ifeq +38 -> 706
    //   671: ldc_w 412
    //   674: aload 6
    //   676: invokevirtual 397	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   679: ldc_w 399
    //   682: invokevirtual 408	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   685: ldc_w 410
    //   688: invokevirtual 413	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   691: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   694: istore 5
    //   696: iload 4
    //   698: istore_3
    //   699: iload 5
    //   701: ifeq +5 -> 706
    //   704: iconst_1
    //   705: istore_3
    //   706: iload_3
    //   707: ifne +87 -> 794
    //   710: aload_1
    //   711: invokestatic 250	com/getjar/sdk/utilities/NotificationsUtility:showRedeemReminderNotification	(Landroid/content/Context;)V
    //   714: getstatic 239	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
    //   717: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   720: getstatic 242	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
    //   723: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   726: lor
    //   727: ldc_w 418
    //   730: iconst_1
    //   731: anewarray 73	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload_2
    //   737: aastore
    //   738: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   741: goto -378 -> 363
    //   744: astore_2
    //   745: aload_1
    //   746: invokestatic 208	com/getjar/sdk/data/earning/EarningMonitor:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/earning/EarningMonitor;
    //   749: invokevirtual 211	com/getjar/sdk/data/earning/EarningMonitor:ensureMonitoring	()V
    //   752: aload_1
    //   753: invokestatic 216	com/getjar/sdk/data/usage/UsageMonitor:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageMonitor;
    //   756: invokevirtual 217	com/getjar/sdk/data/usage/UsageMonitor:ensureMonitoring	()V
    //   759: aload_2
    //   760: athrow
    //   761: astore 6
    //   763: getstatic 239	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
    //   766: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   769: getstatic 242	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
    //   772: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   775: lor
    //   776: aload 6
    //   778: ldc_w 420
    //   781: iconst_0
    //   782: anewarray 73	java/lang/Object
    //   785: invokestatic 267	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   788: iload 4
    //   790: istore_3
    //   791: goto -85 -> 706
    //   794: getstatic 239	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
    //   797: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   800: getstatic 242	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
    //   803: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   806: lor
    //   807: ldc_w 422
    //   810: iconst_1
    //   811: anewarray 73	java/lang/Object
    //   814: dup
    //   815: iconst_0
    //   816: aload_2
    //   817: aastore
    //   818: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   821: goto -458 -> 363
    //   824: aload 7
    //   826: ifnull +92 -> 918
    //   829: aload 7
    //   831: ldc 16
    //   833: invokevirtual 346	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   836: invokestatic 57	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   839: ifne +79 -> 918
    //   842: aload_1
    //   843: invokestatic 427	com/getjar/sdk/utilities/AlarmsUtility:updateLastRunTimestampUsageReporting	(Landroid/content/Context;)V
    //   846: aload_1
    //   847: invokestatic 432	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
    //   850: invokevirtual 435	com/getjar/sdk/data/usage/UsageManager:isUsageSessionBackgroundSendEnabled	()Z
    //   853: ifeq +11 -> 864
    //   856: aload 6
    //   858: invokestatic 440	com/getjar/sdk/data/usage/UsageReporter:getInstance	(Lcom/getjar/sdk/comm/CommContext;)Lcom/getjar/sdk/data/usage/UsageReporter;
    //   861: invokevirtual 443	com/getjar/sdk/data/usage/UsageReporter:sendUnsyncedData	()V
    //   864: aload_1
    //   865: invokestatic 432	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
    //   868: invokevirtual 446	com/getjar/sdk/data/usage/UsageManager:isUsageInstallBackgroundSendEnabled	()Z
    //   871: ifeq +28 -> 899
    //   874: aload_1
    //   875: invokestatic 451	com/getjar/sdk/data/package_events/PackageEventManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/package_events/PackageEventManager;
    //   878: aload 6
    //   880: invokevirtual 454	com/getjar/sdk/data/package_events/PackageEventManager:sendUnsyncedEvents	(Lcom/getjar/sdk/comm/CommContext;)V
    //   883: aload_1
    //   884: invokestatic 459	com/getjar/sdk/data/install_state/InstallStateManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/install_state/InstallStateManager;
    //   887: invokevirtual 462	com/getjar/sdk/data/install_state/InstallStateManager:updateCurrentState	()V
    //   890: aload_1
    //   891: invokestatic 459	com/getjar/sdk/data/install_state/InstallStateManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/install_state/InstallStateManager;
    //   894: aload 6
    //   896: invokevirtual 465	com/getjar/sdk/data/install_state/InstallStateManager:sendCurrentStateDeltas	(Lcom/getjar/sdk/comm/CommContext;)V
    //   899: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   902: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   905: ldc_w 467
    //   908: iconst_0
    //   909: anewarray 73	java/lang/Object
    //   912: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   915: goto -552 -> 363
    //   918: aload_2
    //   919: invokevirtual 470	android/content/Intent:getAction	()Ljava/lang/String;
    //   922: astore 7
    //   924: aload_2
    //   925: ldc_w 472
    //   928: iconst_0
    //   929: invokevirtual 476	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   932: ifne -569 -> 363
    //   935: aload 7
    //   937: ifnull -574 -> 363
    //   940: ldc_w 478
    //   943: aload 7
    //   945: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   948: ifne +14 -> 962
    //   951: ldc_w 480
    //   954: aload 7
    //   956: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   959: ifeq -596 -> 363
    //   962: aload_2
    //   963: invokestatic 484	com/getjar/sdk/utilities/Utility:getPackageNameFromBroadcastIntent	(Landroid/content/Intent;)Ljava/lang/String;
    //   966: astore_2
    //   967: getstatic 98	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   970: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   973: ldc_w 486
    //   976: iconst_2
    //   977: anewarray 73	java/lang/Object
    //   980: dup
    //   981: iconst_0
    //   982: aload_2
    //   983: aastore
    //   984: dup
    //   985: iconst_1
    //   986: aload 7
    //   988: aastore
    //   989: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   992: ldc_w 478
    //   995: aload 7
    //   997: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1000: ifeq +59 -> 1059
    //   1003: aload_0
    //   1004: aload 6
    //   1006: aload_2
    //   1007: invokespecial 488	com/getjar/sdk/data/metadata/PackageMonitor:checkForAndHandleManagedInstalls	(Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;)V
    //   1010: aload_1
    //   1011: invokestatic 432	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
    //   1014: invokevirtual 446	com/getjar/sdk/data/usage/UsageManager:isUsageInstallBackgroundSendEnabled	()Z
    //   1017: ifeq -654 -> 363
    //   1020: aload_1
    //   1021: invokestatic 451	com/getjar/sdk/data/package_events/PackageEventManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/package_events/PackageEventManager;
    //   1024: aload_2
    //   1025: getstatic 493	com/getjar/sdk/data/package_events/PackageEventManager$EventType:INSTALLED	Lcom/getjar/sdk/data/package_events/PackageEventManager$EventType;
    //   1028: invokevirtual 497	com/getjar/sdk/data/package_events/PackageEventManager:logEvent	(Ljava/lang/String;Lcom/getjar/sdk/data/package_events/PackageEventManager$EventType;)V
    //   1031: aload_1
    //   1032: invokestatic 451	com/getjar/sdk/data/package_events/PackageEventManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/package_events/PackageEventManager;
    //   1035: aload 6
    //   1037: invokevirtual 454	com/getjar/sdk/data/package_events/PackageEventManager:sendUnsyncedEvents	(Lcom/getjar/sdk/comm/CommContext;)V
    //   1040: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   1043: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   1046: ldc_w 499
    //   1049: iconst_0
    //   1050: anewarray 73	java/lang/Object
    //   1053: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1056: goto -693 -> 363
    //   1059: ldc_w 480
    //   1062: aload 7
    //   1064: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1067: ifeq -704 -> 363
    //   1070: aload_1
    //   1071: invokestatic 432	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
    //   1074: invokevirtual 446	com/getjar/sdk/data/usage/UsageManager:isUsageInstallBackgroundSendEnabled	()Z
    //   1077: ifeq -714 -> 363
    //   1080: aload_1
    //   1081: invokestatic 451	com/getjar/sdk/data/package_events/PackageEventManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/package_events/PackageEventManager;
    //   1084: aload_2
    //   1085: getstatic 502	com/getjar/sdk/data/package_events/PackageEventManager$EventType:UNINSTALLED	Lcom/getjar/sdk/data/package_events/PackageEventManager$EventType;
    //   1088: invokevirtual 497	com/getjar/sdk/data/package_events/PackageEventManager:logEvent	(Ljava/lang/String;Lcom/getjar/sdk/data/package_events/PackageEventManager$EventType;)V
    //   1091: aload_1
    //   1092: invokestatic 451	com/getjar/sdk/data/package_events/PackageEventManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/package_events/PackageEventManager;
    //   1095: aload 6
    //   1097: invokevirtual 454	com/getjar/sdk/data/package_events/PackageEventManager:sendUnsyncedEvents	(Lcom/getjar/sdk/comm/CommContext;)V
    //   1100: getstatic 282	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   1103: invokevirtual 69	com/getjar/sdk/logging/Area:value	()J
    //   1106: ldc_w 504
    //   1109: iconst_0
    //   1110: anewarray 73	java/lang/Object
    //   1113: invokestatic 79	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1116: goto -753 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1119	0	this	PackageMonitor
    //   0	1119	1	paramContext	Context
    //   0	1119	2	paramIntent	Intent
    //   603	188	3	i	int
    //   584	205	4	j	int
    //   576	124	5	bool	boolean
    //   248	427	6	localObject1	Object
    //   761	335	6	localException	Exception
    //   264	799	7	localObject2	Object
    //   272	8	8	str	String
    // Exception table:
    //   from	to	target	type
    //   0	16	31	java/lang/Exception
    //   20	31	31	java/lang/Exception
    //   98	109	31	java/lang/Exception
    //   142	166	31	java/lang/Exception
    //   166	213	31	java/lang/Exception
    //   244	260	31	java/lang/Exception
    //   363	377	31	java/lang/Exception
    //   409	432	31	java/lang/Exception
    //   464	487	31	java/lang/Exception
    //   745	761	31	java/lang/Exception
    //   0	16	109	finally
    //   20	31	109	finally
    //   32	63	109	finally
    //   98	109	109	finally
    //   142	166	109	finally
    //   166	213	109	finally
    //   244	260	109	finally
    //   363	377	109	finally
    //   409	432	109	finally
    //   464	487	109	finally
    //   745	761	109	finally
    //   244	260	408	java/lang/IllegalStateException
    //   244	260	463	com/getjar/sdk/exceptions/AuthException
    //   260	274	744	finally
    //   279	303	744	finally
    //   308	363	744	finally
    //   523	578	744	finally
    //   586	601	744	finally
    //   612	620	744	finally
    //   623	631	744	finally
    //   634	648	744	finally
    //   651	696	744	finally
    //   710	741	744	finally
    //   763	788	744	finally
    //   794	821	744	finally
    //   829	864	744	finally
    //   864	899	744	finally
    //   899	915	744	finally
    //   918	935	744	finally
    //   940	962	744	finally
    //   962	1056	744	finally
    //   1059	1116	744	finally
    //   586	601	761	java/lang/Exception
    //   612	620	761	java/lang/Exception
    //   623	631	761	java/lang/Exception
    //   634	648	761	java/lang/Exception
    //   651	696	761	java/lang/Exception
  }
  
  private void runPendingEarnTransactionsAndCleanup(CommContext paramCommContext)
    throws Exception
  {
    Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "PackageMonitor: runPendingEarnTransactionsAndCleanup()", new Object[0]);
    new TransactionManager(this.mContext).runTransactionsBlocking(paramCommContext);
    long l = Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("download.match.ttl", SettingsManager.Scope.CLIENT)));
    EarnStateDatabase.getInstance(paramCommContext.getApplicationContext()).deleteOldRecords(l);
  }
  
  private boolean shouldRetryTransactions(Context paramContext, CommContext paramCommContext)
  {
    Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "PackageMonitor: shouldRetryTransactions()", new Object[0]);
    if (paramCommContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getSharedPreferences("timestamp", 0);
      long l1 = System.currentTimeMillis();
      long l2 = paramContext.getLong("transactiontimestamp", 0L);
      long l3 = l1 - l2;
      long l4 = Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("transaction.fail.retry.time", SettingsManager.Scope.CLIENT)));
      Logger.d(Area.EARN.value() | Area.TRANSACTION.value(), "PackageMonitor: shouldRetryTransactions: [lastRetryTime: %1$d] [currentTime: %2$d] [delta: %3$d] [minimumDelta: %4$d]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4) });
      if (l3 >= l4)
      {
        paramContext.edit().putLong("transactiontimestamp", System.currentTimeMillis()).commit();
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), paramContext, "PackageMonitor: shouldRetryTransactions() failed", new Object[0]);
    }
    return false;
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    Logger.d(Area.OS_ENTRY_POINT.value(), "PackageMonitor: onReceive(): START", new Object[0]);
    try
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            PackageMonitor.this.doOnReceive(paramContext, paramIntent);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OS_ENTRY_POINT.value(), localException, "PackageMonitor: onReceive() failed", new Object[0]);
          }
        }
      }, "PackageMonitor Worker Thread").start();
      return;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.OS_ENTRY_POINT.value(), paramContext, "PackageMonitor: onReceive() failed", new Object[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/metadata/PackageMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */