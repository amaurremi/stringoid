package com.getjar.sdk.comm.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.CommManager;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.comm.TransactionManager;
import com.getjar.sdk.comm.VoucherServiceProxy;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.rewards.InAppPurchaseManager;
import com.getjar.sdk.utilities.IntentsUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public class OutOfBandManager
{
  private static final String PREFS_UNREDEEMED_VOUCHER_CHECK_TIMESTAMP = "lastUnredeemedVoucherCheckTimestamp";
  private static final ExecutorService _ExecutorServiceForOutOfBandWork = Executors.newSingleThreadExecutor();
  private static volatile OutOfBandManager _Instance = null;
  private final CommContext _commContext;
  private volatile int _outOfBandWorkRunCount = 0;
  
  private OutOfBandManager(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    this._commContext = paramCommContext;
  }
  
  public static OutOfBandManager getInstance()
  {
    if (_Instance == null) {
      throw new IllegalStateException("OutOfBandManager.initialize() must be called first");
    }
    return _Instance;
  }
  
  public static void initialize(CommContext paramCommContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new OutOfBandManager(paramCommContext);
      }
      return;
    }
    finally
    {
      paramCommContext = finally;
      throw paramCommContext;
    }
  }
  
  public static void resetLastUnredeemedVouchersCheckTimestamp(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("GetJarClientPrefs", 0).edit();
    paramContext.remove("lastUnredeemedVoucherCheckTimestamp");
    paramContext.commit();
    Logger.v(Area.COMM.value(), "OutOfBandManager: OutOfBandWorker.makeCallbacksForUnredeemedVouchers() rate limit timestamp reset", new Object[0]);
  }
  
  public void startOutOfBandWork(boolean paramBoolean)
  {
    _ExecutorServiceForOutOfBandWork.execute(new OutOfBandWorker(paramBoolean));
  }
  
  private class OutOfBandWorker
    implements Runnable
  {
    private final boolean _forceWork;
    
    public OutOfBandWorker(boolean paramBoolean)
    {
      this._forceWork = paramBoolean;
    }
    
    private void doOutOfBandTransactionWork(CommContext paramCommContext)
    {
      Logger.v(Area.COMM.value(), "OutOfBandManager: OutOfBandWorker.doOutOfBandTransactionWork() START", new Object[0]);
      try
      {
        new TransactionManager(paramCommContext.getApplicationContext()).recoverOrphanedTransactions(paramCommContext);
        if (AuthManager.getInstance().getClaimsManager(paramCommContext.getApplicationContext()).hasGetjarPass()) {}
      }
      catch (Exception localException3)
      {
        try
        {
          InAppPurchaseManager.getInstance(paramCommContext.getApplicationContext()).processOustandingSubscriptions(null);
          Logger.i(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), "OutOfBandManager: processOustandingSubscriptions() success", new Object[0]);
          if (!AuthManager.getInstance().getClaimsManager(paramCommContext.getApplicationContext()).canPurchaseManagedProducts()) {}
        }
        catch (Exception localException3)
        {
          try
          {
            InAppPurchaseManager.getInstance(paramCommContext.getApplicationContext()).cancelOrphanedManagedOffers();
            Logger.i(Area.OFFER.value() | Area.TRANSACTION.value(), "OutOfBandManager: cancelOrphanedManagedOffers() success", new Object[0]);
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                InAppPurchaseManager.getInstance(paramCommContext.getApplicationContext()).processOutstandingPurchases(false);
                Logger.i(Area.OFFER.value() | Area.TRANSACTION.value(), "OutOfBandManager: processOutstandingPurchases() success", new Object[0]);
                Logger.v(Area.COMM.value(), "OutOfBandManager: OutOfBandWorker.doOutOfBandTransactionWork() FINISHED", new Object[0]);
                return;
                localException1 = localException1;
                Logger.e(Area.TRANSACTION.value(), localException1, "OutOfBandManager: Recovering orphaned transactions failed", new Object[0]);
                continue;
                localException2 = localException2;
                Logger.e(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), localException2, "OutOfBandManager: processOustandingSubscriptions() failed", new Object[0]);
                continue;
                localException3 = localException3;
                Logger.e(Area.OFFER.value() | Area.TRANSACTION.value(), localException3, "OutOfBandManager: cancelOrphanedManagedOffers() failed", new Object[0]);
              }
            }
            catch (Exception paramCommContext)
            {
              for (;;)
              {
                Logger.e(Area.OFFER.value() | Area.TRANSACTION.value(), paramCommContext, "OutOfBandManager: processOutstandingPurchases() failed", new Object[0]);
              }
            }
          }
        }
      }
    }
    
    private void makeCallbacksForUnredeemedVouchers()
    {
      Logger.v(Area.COMM.value(), "OutOfBandManager: OutOfBandWorker.makeCallbacksForUnredeemedVouchers() START", new Object[0]);
      long l3;
      Object localObject3;
      try
      {
        SharedPreferences localSharedPreferences = OutOfBandManager.this._commContext.getApplicationContext().getSharedPreferences("GetJarClientPrefs", 0);
        long l1 = localSharedPreferences.getLong("lastUnredeemedVoucherCheckTimestamp", 0L);
        long l2 = GetJarConfig.getInstance(OutOfBandManager.this._commContext.getApplicationContext()).getIntegerValue("voucher.unredeemed_request_interval", Integer.valueOf(86400), SettingsManager.Scope.CLIENT).intValue() * 1000;
        l3 = System.currentTimeMillis();
        if (l1 + l2 >= l3)
        {
          Logger.v(Area.COMM.value(), "OutOfBandManager: OutOfBandWorker.makeCallbacksForUnredeemedVouchers() now [%1$d] is less than earliest next check [%2$d], skipping", new Object[] { Long.valueOf(l3), Long.valueOf(l1 + l2) });
          return;
        }
        localObject3 = VoucherServiceProxy.getInstance().getUnredeemedVouchers(OutOfBandManager.this._commContext, true);
        if ((localObject3 == null) || (((Operation)localObject3).get() == null)) {
          throw new CommunicationException("Failed to get a result for getUnredeemedVouchers() call");
        }
      }
      catch (Exception localException1)
      {
        Logger.e(Area.COMM.value(), localException1, "OutOfBandManager: OutOfBandWorker.makeCallbacksForUnredeemedVouchers() failed", new Object[0]);
        return;
        localObject3 = ((Operation)localObject3).get();
        if (!((Result)localObject3).isSuccessfulResponse()) {
          throw new CommunicationException(String.format(Locale.US, "Got a failure response from getUnredeemedVouchers() [%1$d]", new Object[] { Integer.valueOf(((Result)localObject3).getResponseCode()) }));
        }
      }
      finally
      {
        Logger.v(Area.COMM.value(), "OutOfBandManager: OutOfBandWorker.makeCallbacksForUnredeemedVouchers() FINISHED", new Object[0]);
      }
      Object localObject2 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject2).putLong("lastUnredeemedVoucherCheckTimestamp", l3);
      ((SharedPreferences.Editor)localObject2).commit();
      localObject2 = ((Result)localObject3).getResponseJson().getJSONObject("return").getJSONArray("results");
      int i = 0;
      for (;;)
      {
        if (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          try
          {
            if (((JSONObject)localObject3).has("token"))
            {
              String str = ((JSONObject)localObject3).getString("token");
              if (!StringUtility.isNullOrEmpty(str)) {
                CommManager.sendIntentToFirstRegisteredGetjarClient(IntentsUtility.getRedeemVoucherIntent(OutOfBandManager.this._commContext.getApplicationContext(), str));
              }
            }
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Logger.e(Area.COMM.value(), localException2, "OutOfBandManager: OutOfBandWorker.makeCallbacksForUnredeemedVouchers() failed to proccess '%1$s'", new Object[] { localObject3 });
            }
          }
        }
      }
      Logger.v(Area.COMM.value(), "OutOfBandManager: OutOfBandWorker.makeCallbacksForUnredeemedVouchers() FINISHED", new Object[0]);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: getstatic 33	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
      //   3: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   6: ldc_w 307
      //   9: iconst_1
      //   10: anewarray 4	java/lang/Object
      //   13: dup
      //   14: iconst_0
      //   15: aload_0
      //   16: getfield 22	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:_forceWork	Z
      //   19: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   22: aastore
      //   23: invokestatic 45	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   26: aload_0
      //   27: getfield 22	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:_forceWork	Z
      //   30: ifne +59 -> 89
      //   33: aload_0
      //   34: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   37: invokestatic 316	com/getjar/sdk/comm/auth/OutOfBandManager:access$100	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)I
      //   40: ifle +49 -> 89
      //   43: getstatic 33	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
      //   46: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   49: ldc_w 318
      //   52: iconst_1
      //   53: anewarray 4	java/lang/Object
      //   56: dup
      //   57: iconst_0
      //   58: aload_0
      //   59: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   62: invokestatic 316	com/getjar/sdk/comm/auth/OutOfBandManager:access$100	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)I
      //   65: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   68: aastore
      //   69: invokestatic 45	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   72: getstatic 33	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
      //   75: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   78: ldc_w 320
      //   81: iconst_0
      //   82: anewarray 4	java/lang/Object
      //   85: invokestatic 45	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   88: return
      //   89: aload_0
      //   90: invokespecial 322	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:makeCallbacksForUnredeemedVouchers	()V
      //   93: invokestatic 65	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   96: invokevirtual 325	com/getjar/sdk/comm/auth/AuthManager:isNewUser	()Z
      //   99: ifne +149 -> 248
      //   102: invokestatic 65	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   105: aload_0
      //   106: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   109: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   112: invokevirtual 53	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
      //   115: invokevirtual 69	com/getjar/sdk/comm/auth/AuthManager:getClaimsManager	(Landroid/content/Context;)Lcom/getjar/sdk/comm/auth/ClaimsManager;
      //   118: invokevirtual 328	com/getjar/sdk/comm/auth/ClaimsManager:canUseUnmanagedLicenses	()Z
      //   121: istore_1
      //   122: iload_1
      //   123: ifeq +114 -> 237
      //   126: aload_0
      //   127: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   130: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   133: invokestatic 333	com/getjar/sdk/data/LicenseEngine:initialize	(Lcom/getjar/sdk/comm/CommContext;)V
      //   136: invokestatic 336	com/getjar/sdk/data/LicenseEngine:getInstance	()Lcom/getjar/sdk/data/LicenseEngine;
      //   139: iconst_0
      //   140: invokevirtual 340	com/getjar/sdk/data/LicenseEngine:retrieveServerProductLicenses	(Z)Ljava/util/List;
      //   143: astore_2
      //   144: getstatic 343	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
      //   147: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   150: ldc_w 345
      //   153: iconst_1
      //   154: anewarray 4	java/lang/Object
      //   157: dup
      //   158: iconst_0
      //   159: aload_2
      //   160: invokeinterface 350 1 0
      //   165: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   168: aastore
      //   169: invokestatic 95	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   172: aload_2
      //   173: invokeinterface 354 1 0
      //   178: astore_2
      //   179: aload_2
      //   180: invokeinterface 359 1 0
      //   185: ifeq +184 -> 369
      //   188: aload_2
      //   189: invokeinterface 363 1 0
      //   194: checkcast 365	com/getjar/sdk/GetjarLicense
      //   197: astore_3
      //   198: aload_0
      //   199: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   202: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   205: invokevirtual 53	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
      //   208: aload_3
      //   209: invokestatic 369	com/getjar/sdk/utilities/IntentsUtility:getLicenseUpdatedIntent	(Landroid/content/Context;Lcom/getjar/sdk/GetjarLicense;)Landroid/content/Intent;
      //   212: invokestatic 302	com/getjar/sdk/comm/CommManager:sendIntentToFirstRegisteredGetjarClient	(Landroid/content/Intent;)Z
      //   215: pop
      //   216: goto -37 -> 179
      //   219: astore_2
      //   220: getstatic 343	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
      //   223: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   226: aload_2
      //   227: ldc_w 371
      //   230: iconst_0
      //   231: anewarray 4	java/lang/Object
      //   234: invokestatic 120	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   237: aload_0
      //   238: aload_0
      //   239: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   242: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   245: invokespecial 373	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:doOutOfBandTransactionWork	(Lcom/getjar/sdk/comm/CommContext;)V
      //   248: aload_0
      //   249: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   252: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   255: invokevirtual 53	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
      //   258: invokestatic 378	com/getjar/sdk/comm/BeaconManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/comm/BeaconManager;
      //   261: aload_0
      //   262: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   265: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   268: invokevirtual 381	com/getjar/sdk/comm/BeaconManager:recoverUnsentBeacons	(Lcom/getjar/sdk/comm/CommContext;)V
      //   271: invokestatic 65	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   274: aload_0
      //   275: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   278: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   281: invokevirtual 53	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
      //   284: invokevirtual 69	com/getjar/sdk/comm/auth/AuthManager:getClaimsManager	(Landroid/content/Context;)Lcom/getjar/sdk/comm/auth/ClaimsManager;
      //   287: invokevirtual 384	com/getjar/sdk/comm/auth/ClaimsManager:canBuy	()Z
      //   290: istore_1
      //   291: iload_1
      //   292: ifeq +20 -> 312
      //   295: aload_0
      //   296: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   299: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   302: invokevirtual 53	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
      //   305: invokestatic 80	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
      //   308: invokevirtual 388	com/getjar/sdk/rewards/InAppPurchaseManager:getGoldOffers	()Ljava/lang/String;
      //   311: pop
      //   312: aload_0
      //   313: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   316: invokestatic 133	com/getjar/sdk/comm/auth/OutOfBandManager:access$000	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)Lcom/getjar/sdk/comm/CommContext;
      //   319: invokevirtual 53	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
      //   322: invokestatic 393	com/getjar/sdk/config/SettingsManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/config/SettingsManager;
      //   325: invokevirtual 396	com/getjar/sdk/config/SettingsManager:refreshSettings	()V
      //   328: getstatic 90	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   331: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   334: ldc_w 398
      //   337: iconst_0
      //   338: anewarray 4	java/lang/Object
      //   341: invokestatic 45	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   344: aload_0
      //   345: getfield 17	com/getjar/sdk/comm/auth/OutOfBandManager$OutOfBandWorker:this$0	Lcom/getjar/sdk/comm/auth/OutOfBandManager;
      //   348: invokestatic 401	com/getjar/sdk/comm/auth/OutOfBandManager:access$108	(Lcom/getjar/sdk/comm/auth/OutOfBandManager;)I
      //   351: pop
      //   352: getstatic 33	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
      //   355: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   358: ldc_w 320
      //   361: iconst_0
      //   362: anewarray 4	java/lang/Object
      //   365: invokestatic 45	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   368: return
      //   369: getstatic 343	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
      //   372: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   375: ldc_w 403
      //   378: iconst_0
      //   379: anewarray 4	java/lang/Object
      //   382: invokestatic 95	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   385: goto -148 -> 237
      //   388: astore_2
      //   389: getstatic 33	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
      //   392: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   395: ldc_w 320
      //   398: iconst_0
      //   399: anewarray 4	java/lang/Object
      //   402: invokestatic 45	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   405: aload_2
      //   406: athrow
      //   407: astore_2
      //   408: getstatic 90	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   411: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   414: aload_2
      //   415: ldc_w 405
      //   418: iconst_0
      //   419: anewarray 4	java/lang/Object
      //   422: invokestatic 120	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   425: goto -154 -> 271
      //   428: astore_2
      //   429: getstatic 33	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
      //   432: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   435: aload_2
      //   436: ldc_w 407
      //   439: iconst_0
      //   440: anewarray 4	java/lang/Object
      //   443: invokestatic 120	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   446: getstatic 33	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
      //   449: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   452: ldc_w 320
      //   455: iconst_0
      //   456: anewarray 4	java/lang/Object
      //   459: invokestatic 45	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   462: return
      //   463: astore_2
      //   464: getstatic 90	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   467: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   470: aload_2
      //   471: ldc_w 409
      //   474: iconst_0
      //   475: anewarray 4	java/lang/Object
      //   478: invokestatic 120	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   481: goto -169 -> 312
      //   484: astore_2
      //   485: getstatic 90	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   488: invokevirtual 37	com/getjar/sdk/logging/Area:value	()J
      //   491: aload_2
      //   492: ldc_w 411
      //   495: iconst_0
      //   496: anewarray 4	java/lang/Object
      //   499: invokestatic 120	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   502: goto -158 -> 344
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	505	0	this	OutOfBandWorker
      //   121	171	1	bool	boolean
      //   143	46	2	localObject1	Object
      //   219	8	2	localException1	Exception
      //   388	18	2	localObject2	Object
      //   407	8	2	localException2	Exception
      //   428	8	2	localException3	Exception
      //   463	8	2	localException4	Exception
      //   484	8	2	localException5	Exception
      //   197	12	3	localGetjarLicense	com.getjar.sdk.GetjarLicense
      // Exception table:
      //   from	to	target	type
      //   126	179	219	java/lang/Exception
      //   179	216	219	java/lang/Exception
      //   369	385	219	java/lang/Exception
      //   26	72	388	finally
      //   89	122	388	finally
      //   126	179	388	finally
      //   179	216	388	finally
      //   220	237	388	finally
      //   237	248	388	finally
      //   248	271	388	finally
      //   271	291	388	finally
      //   295	312	388	finally
      //   312	344	388	finally
      //   344	352	388	finally
      //   369	385	388	finally
      //   408	425	388	finally
      //   429	446	388	finally
      //   464	481	388	finally
      //   485	502	388	finally
      //   248	271	407	java/lang/Exception
      //   26	72	428	java/lang/Exception
      //   89	122	428	java/lang/Exception
      //   220	237	428	java/lang/Exception
      //   237	248	428	java/lang/Exception
      //   271	291	428	java/lang/Exception
      //   344	352	428	java/lang/Exception
      //   408	425	428	java/lang/Exception
      //   464	481	428	java/lang/Exception
      //   485	502	428	java/lang/Exception
      //   295	312	463	java/lang/Exception
      //   312	344	484	java/lang/Exception
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/OutOfBandManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */