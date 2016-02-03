package com.getjar.sdk.comm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.comm.auth.AndroidAccountUserAuthProvider;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.comm.auth.EnforcedAccountUserAuthProvider;
import com.getjar.sdk.comm.persistence.ConfirmVoucherBucket;
import com.getjar.sdk.comm.persistence.DBTransactions;
import com.getjar.sdk.comm.persistence.DBTransactions.ConfirmVoucherState;
import com.getjar.sdk.comm.persistence.DBTransactions.EarnState;
import com.getjar.sdk.comm.persistence.DBTransactions.GrantGetjarPassState;
import com.getjar.sdk.comm.persistence.DBTransactions.ManagedOfferState;
import com.getjar.sdk.comm.persistence.DBTransactions.NotificationState;
import com.getjar.sdk.comm.persistence.DBTransactions.PurchaseState;
import com.getjar.sdk.comm.persistence.DBTransactions.TransactionType;
import com.getjar.sdk.comm.persistence.EarnBucket;
import com.getjar.sdk.comm.persistence.GrantGetjarPassBucket;
import com.getjar.sdk.comm.persistence.ManagedOfferBucket;
import com.getjar.sdk.comm.persistence.PurchaseUnmanagedBucket;
import com.getjar.sdk.comm.persistence.RelatedConfirmVoucherData;
import com.getjar.sdk.comm.persistence.RelatedEarnData;
import com.getjar.sdk.comm.persistence.RelatedGrantGetjarPassData;
import com.getjar.sdk.comm.persistence.RelatedManagedOfferData;
import com.getjar.sdk.comm.persistence.RelatedPurchaseData;
import com.getjar.sdk.comm.persistence.TransactionBucket;
import com.getjar.sdk.data.earning.EarnStateDatabase;
import com.getjar.sdk.data.earning.EarnStateDatabase.EarnState;
import com.getjar.sdk.data.earning.EarnUtility;
import com.getjar.sdk.data.earning.EarnUtility.EarnInfo;
import com.getjar.sdk.data.usage.AnalyticsManager;
import com.getjar.sdk.data.usage.AnalyticsManager.TrackingType;
import com.getjar.sdk.exceptions.ServiceException;
import com.getjar.sdk.exceptions.TransactionException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.rewards.GetJarWebViewSubActivity;
import com.getjar.sdk.rewards.InAppPurchaseManager;
import com.getjar.sdk.rewards.InAppPurchaseManager.PurchaseStatus;
import com.getjar.sdk.utilities.Constants.RequestInstallSubState;
import com.getjar.sdk.utilities.CryptoUtility;
import com.getjar.sdk.utilities.IntentsUtility;
import com.getjar.sdk.utilities.NotificationsUtility;
import com.getjar.sdk.utilities.SetExceptionFutureTask;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class TransactionManager
{
  private static final String CURRENCY_KEY_GETJAR_GOLD = "getjar_gold";
  private static ConcurrentLinkedQueue<String> _CanceledClientTransactionIDs;
  private static final ExecutorService _ExecutorService = ;
  private static final Object _ManagedOfferTransactionStateLock = new Object();
  private static final Object _PurchaseTransactionStateLock;
  private static final Object _TransactionFlowLock;
  private static final Object _UploadBuyGoldLock;
  private Context _applicationContext;
  
  static
  {
    _CanceledClientTransactionIDs = new ConcurrentLinkedQueue();
    _UploadBuyGoldLock = new Object();
    _TransactionFlowLock = new Object();
    _PurchaseTransactionStateLock = new Object();
  }
  
  public TransactionManager(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'applicationContext' can not be NULL");
    }
    this._applicationContext = paramContext.getApplicationContext();
  }
  
  private void checkAndCancelManagedOffer(CommContext paramCommContext, ManagedOfferBucket paramManagedOfferBucket, boolean paramBoolean)
    throws Exception
  {
    String str = paramManagedOfferBucket.getClientTransactionId();
    Result localResult;
    if (DBTransactions.ManagedOfferState.CANCELING.equals(paramManagedOfferBucket.getState()))
    {
      boolean bool2 = true;
      ??? = paramManagedOfferBucket.getRelatedObject().getPurchaseMetadata();
      boolean bool1 = bool2;
      if (??? != null)
      {
        bool1 = bool2;
        if (((HashMap)???).containsKey("order.google_play.signed_data")) {
          bool1 = InAppPurchaseManager.getInstance(this._applicationContext).consumeManagedOffer(paramManagedOfferBucket, true);
        }
      }
      if (bool1)
      {
        localResult = TransactionServiceProxy.getInstance().cancelTransaction(paramCommContext, str, paramBoolean).get();
        if ((localResult == null) || (!localResult.isSuccessfulResponse())) {
          break label235;
        }
        _CanceledClientTransactionIDs.remove(str);
      }
    }
    for (;;)
    {
      synchronized (_ManagedOfferTransactionStateLock)
      {
        updateOfferStateFromResponseState(paramCommContext, localResult, paramManagedOfferBucket, DBTransactions.ManagedOfferState.CANCELLED);
        if (!DBTransactions.ManagedOfferState.CANCELLED.equals(paramManagedOfferBucket.getState())) {}
      }
      synchronized (_ManagedOfferTransactionStateLock)
      {
        updateOfferTransactionState(paramCommContext, paramManagedOfferBucket, DBTransactions.ManagedOfferState.DONE);
        if (DBTransactions.ManagedOfferState.DONE.equals(paramManagedOfferBucket.getState()))
        {
          if (!DBTransactions.getInstance(this._applicationContext).deleteTransaction(str)) {
            Logger.e(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: checkAndCancelManagedOffer() failed to delete a Managed Offer transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str });
          }
        }
        else
        {
          return;
          paramCommContext = finally;
          throw paramCommContext;
          label235:
          if ((localResult == null) || (!"TRANSACTION_NOT_FOUND".equals(localResult.getErrorResponseSubcode()))) {
            continue;
          }
          _CanceledClientTransactionIDs.remove(str);
          synchronized (_ManagedOfferTransactionStateLock)
          {
            updateOfferTransactionState(paramCommContext, paramManagedOfferBucket, DBTransactions.ManagedOfferState.DONE);
          }
        }
      }
    }
    Logger.v(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: checkAndCancelManagedOffer() deleted a Managed Offer transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str });
  }
  
  private boolean checkCancelling(ManagedOfferBucket paramManagedOfferBucket)
  {
    if (_CanceledClientTransactionIDs.contains(paramManagedOfferBucket.getClientTransactionId()))
    {
      Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: checkCancelling() CANCELING [clientTransactionId: %1$s] [%2$s]", new Object[] { paramManagedOfferBucket.getClientTransactionId(), Logger.getShortStack() });
      paramManagedOfferBucket.setState(DBTransactions.ManagedOfferState.CANCELING);
      Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: checkCancelling() returning TRUE [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramManagedOfferBucket.getClientTransactionId(), Long.valueOf(Thread.currentThread().getId()) });
      return true;
    }
    Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: checkCancelling() returning FALSE [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramManagedOfferBucket.getClientTransactionId(), Long.valueOf(Thread.currentThread().getId()) });
    return false;
  }
  
  private boolean checkCancelling(PurchaseUnmanagedBucket paramPurchaseUnmanagedBucket)
  {
    if (_CanceledClientTransactionIDs.contains(paramPurchaseUnmanagedBucket.getClientTransactionId()))
    {
      paramPurchaseUnmanagedBucket.setState(DBTransactions.PurchaseState.CANCELING);
      Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager: checkCancelling() returning TRUE [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramPurchaseUnmanagedBucket.getClientTransactionId(), Long.valueOf(Thread.currentThread().getId()) });
      return true;
    }
    Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager: checkCancelling() returning FALSE [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramPurchaseUnmanagedBucket.getClientTransactionId(), Long.valueOf(Thread.currentThread().getId()) });
    return false;
  }
  
  private Long getEarnOnPurchaseAmount(Result paramResult)
  {
    if (paramResult != null) {
      try
      {
        if ((paramResult.getResponseJson() != null) && (paramResult.getResponseJson().has("return")))
        {
          paramResult = paramResult.getResponseJson().getJSONObject("return");
          if ((paramResult != null) && (paramResult.has("lines")))
          {
            paramResult = paramResult.getJSONArray("lines");
            if (paramResult != null)
            {
              int i = 0;
              while (i < paramResult.length())
              {
                JSONObject localJSONObject = paramResult.getJSONObject(i);
                if ((localJSONObject != null) && (localJSONObject.has("type")) && (localJSONObject.has("amount")) && ("BUY_CURRENCY".equals(localJSONObject.getString("type"))))
                {
                  long l = localJSONObject.getLong("amount");
                  return Long.valueOf(l);
                }
                i += 1;
              }
            }
          }
        }
        return null;
      }
      catch (Exception paramResult)
      {
        Logger.e(Area.OFFER.value() | Area.TRANSACTION.value() | Area.PURCHASE.value(), paramResult, "getEarnOnPurchaseAmount() failed", new Object[0]);
      }
    }
  }
  
  public static String getTransactionState(Result paramResult, String paramString)
  {
    return getTransactionValue(paramResult, paramString, "state");
  }
  
  public static String getTransactionSubstate(Result paramResult, String paramString)
  {
    return getTransactionValue(paramResult, paramString, "substate");
  }
  
  private static String getTransactionValue(Result paramResult, String paramString1, String paramString2)
  {
    if (paramResult != null) {
      try
      {
        JSONObject localJSONObject = paramResult.getResponseJson();
        if ((localJSONObject != null) && (localJSONObject.length() > 0))
        {
          Object localObject = null;
          paramResult = (Result)localObject;
          if (localJSONObject.has("return"))
          {
            localJSONObject = localJSONObject.getJSONObject("return");
            if (!localJSONObject.has(paramString2)) {
              break label73;
            }
            paramResult = localJSONObject.getString(paramString2);
          }
          while (!StringUtility.isNullOrEmpty(paramResult))
          {
            return paramResult;
            label73:
            paramResult = (Result)localObject;
            if (localJSONObject.has("transaction"))
            {
              localJSONObject = localJSONObject.getJSONObject("transaction");
              paramResult = (Result)localObject;
              if (localJSONObject.has(paramString2)) {
                paramResult = localJSONObject.getString(paramString2);
              }
            }
          }
        }
        return paramString1;
      }
      catch (JSONException paramResult)
      {
        Logger.e(Area.COMM.value() | Area.TRANSACTION.value(), paramResult, "getTransactionState() failed", new Object[0]);
      }
    }
  }
  
  /* Error */
  private void handleSuccessfulReserveResult(Result paramResult, CommContext paramCommContext, PurchaseUnmanagedBucket paramPurchaseUnmanagedBucket)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: iload 5
    //   11: istore 4
    //   13: getstatic 73	com/getjar/sdk/comm/TransactionManager:_PurchaseTransactionStateLock	Ljava/lang/Object;
    //   16: astore 9
    //   18: iload 5
    //   20: istore 4
    //   22: aload 9
    //   24: monitorenter
    //   25: iload 7
    //   27: istore 4
    //   29: aload_0
    //   30: getfield 92	com/getjar/sdk/comm/TransactionManager:_applicationContext	Landroid/content/Context;
    //   33: invokestatic 234	com/getjar/sdk/comm/persistence/DBTransactions:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/comm/persistence/DBTransactions;
    //   36: aload_3
    //   37: invokevirtual 312	com/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket:getClientTransactionId	()Ljava/lang/String;
    //   40: invokevirtual 406	com/getjar/sdk/comm/persistence/DBTransactions:loadTransaction	(Ljava/lang/String;)Lcom/getjar/sdk/comm/persistence/TransactionBucket;
    //   43: astore 10
    //   45: iload 6
    //   47: istore 5
    //   49: aload 10
    //   51: ifnull +45 -> 96
    //   54: iload 6
    //   56: istore 5
    //   58: iload 7
    //   60: istore 4
    //   62: getstatic 409	com/getjar/sdk/comm/persistence/DBTransactions$PurchaseState:RESERVING	Lcom/getjar/sdk/comm/persistence/DBTransactions$PurchaseState;
    //   65: aload 10
    //   67: checkcast 311	com/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket
    //   70: invokevirtual 412	com/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket:getState	()Lcom/getjar/sdk/comm/persistence/DBTransactions$PurchaseState;
    //   73: invokevirtual 413	com/getjar/sdk/comm/persistence/DBTransactions$PurchaseState:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +20 -> 96
    //   79: iconst_1
    //   80: istore 4
    //   82: iconst_1
    //   83: istore 5
    //   85: aload_0
    //   86: aload_2
    //   87: aload_1
    //   88: aload_3
    //   89: getstatic 416	com/getjar/sdk/comm/persistence/DBTransactions$PurchaseState:CONFIRMING	Lcom/getjar/sdk/comm/persistence/DBTransactions$PurchaseState;
    //   92: invokespecial 420	com/getjar/sdk/comm/TransactionManager:updatePurchaseStateFromResponseState	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/comm/Result;Lcom/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket;Lcom/getjar/sdk/comm/persistence/DBTransactions$PurchaseState;)Lcom/getjar/sdk/comm/persistence/DBTransactions$PurchaseState;
    //   95: pop
    //   96: iload 5
    //   98: istore 4
    //   100: aload 9
    //   102: monitorexit
    //   103: iload 5
    //   105: istore 4
    //   107: iload 4
    //   109: ifeq +29 -> 138
    //   112: aload_1
    //   113: getstatic 426	com/getjar/sdk/utilities/Constants$RequestInstallSubState:NONE	Lcom/getjar/sdk/utilities/Constants$RequestInstallSubState;
    //   116: invokevirtual 429	com/getjar/sdk/utilities/Constants$RequestInstallSubState:name	()Ljava/lang/String;
    //   119: invokestatic 431	com/getjar/sdk/comm/TransactionManager:getTransactionSubstate	(Lcom/getjar/sdk/comm/Result;Ljava/lang/String;)Ljava/lang/String;
    //   122: getstatic 434	com/getjar/sdk/utilities/Constants$RequestInstallSubState:FUNDS_INSUFFICIENT_FAILURE	Lcom/getjar/sdk/utilities/Constants$RequestInstallSubState;
    //   125: invokevirtual 429	com/getjar/sdk/utilities/Constants$RequestInstallSubState:name	()Ljava/lang/String;
    //   128: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: istore 8
    //   133: iload 8
    //   135: ifne +3 -> 138
    //   138: return
    //   139: astore_3
    //   140: aload 9
    //   142: monitorexit
    //   143: aload_3
    //   144: athrow
    //   145: astore_3
    //   146: getstatic 323	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
    //   149: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   152: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   155: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   158: lor
    //   159: getstatic 254	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   162: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   165: lor
    //   166: aload_3
    //   167: ldc_w 436
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 374	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_2
    //   178: aload_3
    //   179: invokevirtual 442	com/getjar/sdk/comm/CommContext:addException	(Ljava/lang/Throwable;)V
    //   182: goto -75 -> 107
    //   185: astore_1
    //   186: getstatic 323	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
    //   189: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   192: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   195: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   198: lor
    //   199: aload_1
    //   200: ldc_w 436
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 374	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_2
    //   211: aload_1
    //   212: invokevirtual 442	com/getjar/sdk/comm/CommContext:addException	(Ljava/lang/Throwable;)V
    //   215: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	TransactionManager
    //   0	216	1	paramResult	Result
    //   0	216	2	paramCommContext	CommContext
    //   0	216	3	paramPurchaseUnmanagedBucket	PurchaseUnmanagedBucket
    //   11	97	4	i	int
    //   4	100	5	j	int
    //   7	48	6	k	int
    //   1	58	7	m	int
    //   131	3	8	bool	boolean
    //   16	125	9	localObject	Object
    //   43	23	10	localTransactionBucket	TransactionBucket
    // Exception table:
    //   from	to	target	type
    //   29	45	139	finally
    //   62	79	139	finally
    //   85	96	139	finally
    //   100	103	139	finally
    //   140	143	139	finally
    //   13	18	145	java/lang/Exception
    //   22	25	145	java/lang/Exception
    //   143	145	145	java/lang/Exception
    //   112	133	185	java/lang/Exception
    //   146	182	185	java/lang/Exception
  }
  
  private Operation runConfirmVoucherTransaction(ConfirmVoucherBucket paramConfirmVoucherBucket, CommContext paramCommContext, boolean paramBoolean)
    throws Exception
  {
    if (paramConfirmVoucherBucket == null)
    {
      Logger.w(Area.TRANSACTION.value() | Area.REDEEM.value(), "runConfirmVoucherTransaction 'transaction' cannot be null. Returning null", new Object[0]);
      paramCommContext = null;
      return paramCommContext;
    }
    String str = paramConfirmVoucherBucket.getClientTransactionId();
    Logger.v(Area.REDEEM.value() | Area.TRANSACTION.value(), "TransactionManager: runConfirmVoucherTransaction() [clientTransactionId: %1$s] [state: %2$s] [thread: %3$d]", new Object[] { str, paramConfirmVoucherBucket.getState().name(), Long.valueOf(Thread.currentThread().getId()) });
    Object localObject1 = null;
    Operation localOperation;
    Object localObject2;
    if ((DBTransactions.ConfirmVoucherState.CREATED.equals(paramConfirmVoucherBucket.getState())) || (DBTransactions.ConfirmVoucherState.CONFIRMING.equals(paramConfirmVoucherBucket.getState())))
    {
      if (DBTransactions.ConfirmVoucherState.CREATED.equals(paramConfirmVoucherBucket.getState())) {
        updateConfirmVoucherTransactionState(paramCommContext, paramConfirmVoucherBucket, DBTransactions.ConfirmVoucherState.CONFIRMING);
      }
      localObject1 = paramConfirmVoucherBucket.getRelatedObject();
      localOperation = VoucherServiceProxy.getInstance().confirmVoucher(paramCommContext, ((RelatedConfirmVoucherData)localObject1).getVoucherToken(), paramBoolean);
      localObject2 = localOperation.get();
      if (localObject2 == null) {
        break label435;
      }
      if (!((Result)localObject2).isSuccessfulResponse()) {
        break label320;
      }
      localObject2 = getTransactionSubstate((Result)localObject2, Constants.RequestInstallSubState.NONE.toString());
      localObject1 = localOperation;
      if (!"INCOMPLETE_RECONCILE_WARNING".equalsIgnoreCase((String)localObject2))
      {
        localObject1 = localOperation;
        if (!"DEPENDENT_SERVICE_FAILURE".equalsIgnoreCase((String)localObject2))
        {
          if (!"UNKNOWN_RETRY_WARNING".equalsIgnoreCase((String)localObject2)) {
            break label305;
          }
          localObject1 = localOperation;
        }
      }
    }
    for (;;)
    {
      paramCommContext = (CommContext)localObject1;
      if (!DBTransactions.ConfirmVoucherState.DONE.equals(paramConfirmVoucherBucket.getState())) {
        break;
      }
      if (DBTransactions.getInstance(this._applicationContext).deleteTransaction(str)) {
        break label483;
      }
      Logger.e(Area.REDEEM.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runConfirmVoucherTransaction() failed to delete a Confirm Voucher transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str });
      return (Operation)localObject1;
      label305:
      updateConfirmVoucherTransactionState(paramCommContext, paramConfirmVoucherBucket, DBTransactions.ConfirmVoucherState.DONE);
      localObject1 = localOperation;
      continue;
      label320:
      localObject1 = localOperation;
      if (((Result)localObject2).getResponseCode() != 202)
      {
        localObject1 = localOperation;
        if (RequestUtilities.getServicesException((Result)localObject2) != null)
        {
          if ((!StringUtility.isNullOrEmpty(((Result)localObject2).getErrorResponseCode())) && (!StringUtility.isNullOrEmpty(((Result)localObject2).getErrorResponseSubcode())) && (((Result)localObject2).getErrorResponseCode().equals("CALLER_BAD_STATE")) && (((Result)localObject2).getErrorResponseSubcode().equals("NOT_REDEEMED"))) {
            Logger.e(Area.REDEEM.value() | Area.TRANSACTION.value(), "Integration problem: ConfirmVoucher was called before RedeemVoucher. Please call RedeemVoucher first.", new Object[0]);
          }
          updateConfirmVoucherTransactionState(paramCommContext, paramConfirmVoucherBucket, DBTransactions.ConfirmVoucherState.DONE);
          localObject1 = localOperation;
          continue;
          label435:
          Logger.e(Area.REDEEM.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runConfirmVoucherTransaction() Confirm Voucher operation %1$d failed to get results", new Object[] { Integer.valueOf(localOperation.getId()) });
          localObject1 = localOperation;
        }
      }
    }
    label483:
    Logger.v(Area.REDEEM.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runConfirmVoucherTransaction() deleted a Confirm Voucher transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str });
    return (Operation)localObject1;
  }
  
  private Operation runEarnTransaction(EarnBucket paramEarnBucket, CommContext paramCommContext, CallbackInterface paramCallbackInterface, boolean paramBoolean)
    throws Exception
  {
    String str1 = paramEarnBucket.getClientTransactionId();
    Logger.v(Area.EARN.value() | Area.TRANSACTION.value(), "TransactionManager: runEarnTransaction() [clientTransactionId: %1$s] [state: %2$s] [callback: %3$s] [thread: %4$d]", new Object[] { str1, paramEarnBucket.getState().name(), paramCallbackInterface.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    Object localObject = null;
    if ((DBTransactions.EarnState.CREATED.equals(paramEarnBucket.getState())) || (DBTransactions.EarnState.EARNING.equals(paramEarnBucket.getState())))
    {
      if (DBTransactions.EarnState.CREATED.equals(paramEarnBucket.getState())) {
        updateEarnTransactionState(paramCommContext, paramEarnBucket, DBTransactions.EarnState.EARNING);
      }
      localObject = paramEarnBucket.getRelatedObject();
      localObject = TransactionServiceProxy.getInstance().earn(paramCommContext, ((RelatedEarnData)localObject).getItemId(), ((RelatedEarnData)localObject).getPackageName(), str1, ((RelatedEarnData)localObject).getItemMetadata(), ((RelatedEarnData)localObject).getTrackingMetadata(), paramBoolean);
    }
    try
    {
      ((Operation)localObject).mapResultToCallbacks(paramCallbackInterface);
      paramCallbackInterface = ((Operation)localObject).get();
      if (paramCallbackInterface != null)
      {
        Logger.d(Area.EARN.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runEarnTransaction() Earn received a %1$d result", new Object[] { Integer.valueOf(paramCallbackInterface.getResponseCode()) });
        l2 = -1L;
        if (paramCallbackInterface.isSuccessfulResponse())
        {
          String str2 = getTransactionSubstate(paramCallbackInterface, Constants.RequestInstallSubState.NONE.toString());
          l1 = l2;
          if (!"INCOMPLETE_RECONCILE_WARNING".equalsIgnoreCase(str2))
          {
            l1 = l2;
            if (!"DEPENDENT_SERVICE_FAILURE".equalsIgnoreCase(str2))
            {
              if (!"UNKNOWN_RETRY_WARNING".equalsIgnoreCase(str2)) {
                break label475;
              }
              l1 = l2;
            }
          }
          if (l1 < 0L) {
            break label535;
          }
          AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "package_name", paramEarnBucket.getRelatedObject().getPackageName(), "response_code", Integer.valueOf(paramCallbackInterface.getResponseCode()), "type", AnalyticsManager.TrackingType.EARN_CURRENCY.value(), "currency_key", "getjar_gold", "currency_amount", Long.valueOf(l1) });
          if (DBTransactions.EarnState.DONE.equals(paramEarnBucket.getState()))
          {
            if (DBTransactions.getInstance(this._applicationContext).deleteTransaction(str1)) {
              break label720;
            }
            Logger.e(Area.EARN.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runEarnTransaction() failed to delete a Earn transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str1 });
          }
          return (Operation)localObject;
        }
      }
    }
    catch (Exception paramCallbackInterface)
    {
      for (;;)
      {
        long l2;
        Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), paramCallbackInterface, "TransactionManager: runEarnTransaction() Result to callback mapping failed", new Object[0]);
        continue;
        label475:
        updateEarnTransactionState(paramCommContext, paramEarnBucket, DBTransactions.EarnState.DONE);
        long l1 = EarnUtility.getResponseAmount(paramCallbackInterface, -1L);
        continue;
        l1 = l2;
        if (paramCallbackInterface.getResponseCode() != 202)
        {
          l1 = l2;
          if (RequestUtilities.getServicesException(paramCallbackInterface) != null)
          {
            updateEarnTransactionState(paramCommContext, paramEarnBucket, DBTransactions.EarnState.DONE);
            l1 = l2;
            continue;
            label535:
            AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "package_name", paramEarnBucket.getRelatedObject().getPackageName(), "response_code", Integer.valueOf(paramCallbackInterface.getResponseCode()), "type", AnalyticsManager.TrackingType.EARN_CURRENCY.value(), "currency_key", "getjar_gold" });
            continue;
            AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "package_name", paramEarnBucket.getRelatedObject().getPackageName(), "type", AnalyticsManager.TrackingType.EARN_CURRENCY.value(), "currency_key", "getjar_gold" });
            Logger.e(Area.EARN.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runEarnTransaction() Earn operation %1$d failed to get results", new Object[] { Integer.valueOf(((Operation)localObject).getId()) });
          }
        }
      }
      label720:
      Logger.v(Area.EARN.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runEarnTransaction() deleted a Earn transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str1 });
    }
    return (Operation)localObject;
  }
  
  private Operation runGrantGetjarPassTransaction(String paramString1, String paramString2, CommContext paramCommContext, boolean paramBoolean)
    throws Exception
  {
    if ((StringUtility.isNullOrEmpty(paramString1)) && (StringUtility.isNullOrEmpty(paramString2))) {
      throw new IllegalArgumentException("'currentClientTransactionId' and 'persistedClientTransactionId' cannot both be NULL or empty");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    Logger.v(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), "TransactionManager: runGrantGetjarPassTransaction() [currentClientTransactionId: %1$s] [persistedClientTransactionId: %2$s] [thread: %3$d]", new Object[] { paramString1, paramString2, Long.valueOf(Thread.currentThread().getId()) });
    String str1;
    if (StringUtility.isNullOrEmpty(paramString1))
    {
      str1 = paramString2;
      if (!StringUtility.isNullOrEmpty(paramString2)) {
        break label130;
      }
    }
    label130:
    for (Object localObject1 = paramString1;; localObject1 = paramString2)
    {
      paramString2 = DBTransactions.getInstance(this._applicationContext).loadTransaction(str1);
      if (paramString2 != null) {
        break label136;
      }
      paramString1 = null;
      return paramString1;
      str1 = paramString1;
      break;
    }
    label136:
    GrantGetjarPassBucket localGrantGetjarPassBucket = (GrantGetjarPassBucket)paramString2;
    paramString2 = null;
    Object localObject2 = null;
    RelatedGrantGetjarPassData localRelatedGrantGetjarPassData;
    String str2;
    if ((DBTransactions.GrantGetjarPassState.CREATED.equals(localGrantGetjarPassBucket.getState())) || (DBTransactions.GrantGetjarPassState.GRANTING.equals(localGrantGetjarPassBucket.getState())))
    {
      if (DBTransactions.GrantGetjarPassState.CREATED.equals(localGrantGetjarPassBucket.getState())) {
        updateGrantGetjarPassTransactionState(paramCommContext, localGrantGetjarPassBucket, DBTransactions.GrantGetjarPassState.GRANTING);
      }
      int j = 0;
      paramString2 = null;
      localRelatedGrantGetjarPassData = localGrantGetjarPassBucket.getRelatedObject();
      Object localObject3 = localRelatedGrantGetjarPassData.getPurchaseMetadata();
      str2 = paramString2;
      int i = j;
      if (localObject3 != null)
      {
        localObject3 = new JSONObject((String)((HashMap)localObject3).get("order.google_play.signed_data")).getString("developerPayload");
        str2 = paramString2;
        i = j;
        if (!StringUtility.isNullOrEmpty((String)localObject3))
        {
          localObject3 = ((String)localObject3).split(",");
          str2 = paramString2;
          i = j;
          if (localObject3.length >= 4)
          {
            localObject3 = localObject3[3];
            str2 = paramString2;
            i = j;
            if (!StringUtility.isNullOrEmpty((String)localObject3))
            {
              paramString2 = AndroidAccountUserAuthProvider.getAccountNameFromHash(this._applicationContext, (String)localObject3);
              String str3 = EnforcedAccountUserAuthProvider.getCurrentAccountName(this._applicationContext);
              str2 = paramString2;
              i = j;
              if (!StringUtility.isNullOrEmpty(str3))
              {
                str2 = paramString2;
                i = j;
                if (((String)localObject3).equals(CryptoUtility.getSHA256(str3)))
                {
                  i = 1;
                  str2 = paramString2;
                }
              }
            }
          }
        }
      }
      if (i != 0) {
        break label533;
      }
      Logger.v(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), "TransactionManager: runGrantGetjarPassTransaction() The current user does not match the purchasing user, not granting the pass", new Object[0]);
      paramString2 = (String)localObject2;
      if (!StringUtility.isNullOrEmpty(paramString1))
      {
        if (!StringUtility.isNullOrEmpty(str2)) {
          break label511;
        }
        updateUIWithAlreadyPurchased("", "");
        paramString2 = (String)localObject2;
      }
    }
    for (;;)
    {
      InAppPurchaseManager.getInstance(this._applicationContext).removeLastClientTransactionId();
      paramString1 = paramString2;
      if (!DBTransactions.GrantGetjarPassState.DONE.equals(localGrantGetjarPassBucket.getState())) {
        break;
      }
      if (DBTransactions.getInstance(this._applicationContext).deleteTransaction(str1)) {
        break label861;
      }
      Logger.e(Area.GETJAR_PASS.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runGrantGetjarPassTransaction() failed to delete a transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str1 });
      return paramString2;
      label511:
      updateUIWithAlreadyPurchased(new AndroidAccountUserAuthProvider().getProviderFilter(), str2);
      paramString2 = (String)localObject2;
      continue;
      label533:
      Logger.v(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), "TransactionManager: runGrantGetjarPassTransaction() The current user matches the purchasing user, granting the pass", new Object[0]);
      paramString2 = TransactionServiceProxy.getInstance().grantGetjarPass(paramCommContext, (String)localObject1, localRelatedGrantGetjarPassData.getPurchaseMetadata(), paramBoolean);
      localObject1 = paramString2.get();
      if ((localObject1 != null) && (((Result)localObject1).isSuccessfulResponse()))
      {
        updateGrantGetjarPassTransactionState(paramCommContext, localGrantGetjarPassBucket, DBTransactions.GrantGetjarPassState.DONE);
        AuthManager.getInstance().reAuth();
        AuthManager.getInstance().waitOnAuth();
        if (!StringUtility.isNullOrEmpty(paramString1)) {
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SUCCESS, ((Result)localObject1).getResponseJson().getJSONObject("return"));
        }
        AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "response_code", Integer.valueOf(((Result)localObject1).getResponseCode()), "type", AnalyticsManager.TrackingType.PURCHASE_GETJAR_PASS.value() });
      }
      else if ((localObject1 != null) && (RequestUtilities.getServicesException((Result)localObject1) != null) && (((Result)localObject1).getResponseCode() != 500))
      {
        updateGrantGetjarPassTransactionState(paramCommContext, localGrantGetjarPassBucket, DBTransactions.GrantGetjarPassState.DONE);
        if (!StringUtility.isNullOrEmpty(paramString1)) {
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SERVER_ERROR, new JSONObject());
        }
        AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "response_code", Integer.valueOf(((Result)localObject1).getResponseCode()), "type", AnalyticsManager.TrackingType.PURCHASE_GETJAR_PASS.value() });
      }
      else
      {
        if (!StringUtility.isNullOrEmpty(paramString1)) {
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SERVER_ERROR_RECOVERABLE, new JSONObject());
        }
        AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "type", AnalyticsManager.TrackingType.PURCHASE_GETJAR_PASS.value() });
      }
    }
    label861:
    Logger.v(Area.GETJAR_PASS.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runGrantGetjarPassTransaction() deleted a transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str1 });
    return paramString2;
  }
  
  private Operation runManagedOfferTransaction(String paramString, CommContext paramCommContext, boolean paramBoolean)
    throws Exception
  {
    Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: runManagedPurchaseTransaction() [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    ??? = null;
    Object localObject2 = null;
    Object localObject5 = DBTransactions.getInstance(this._applicationContext).loadTransaction(paramString);
    String str;
    if (localObject5 != null)
    {
      localObject5 = (ManagedOfferBucket)localObject5;
      checkCancelling((ManagedOfferBucket)localObject5);
      if (!DBTransactions.ManagedOfferState.CREATED.equals(((ManagedOfferBucket)localObject5).getState()))
      {
        ??? = localObject2;
        if (!DBTransactions.ManagedOfferState.RESERVING.equals(((ManagedOfferBucket)localObject5).getState())) {}
      }
      else if (!DBTransactions.ManagedOfferState.CREATED.equals(((ManagedOfferBucket)localObject5).getState())) {}
      synchronized (_ManagedOfferTransactionStateLock)
      {
        updateOfferTransactionState(paramCommContext, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.RESERVING);
        Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: RESERVING [clientTransactionId: %1$s] [state: %2$s] [thread: %3$d]", new Object[] { paramString, ((ManagedOfferBucket)localObject5).getState().name(), Long.valueOf(Thread.currentThread().getId()) });
        ??? = localObject2;
        if (!checkCancelling((ManagedOfferBucket)localObject5))
        {
          ??? = TransactionServiceProxy.getInstance().reserveManagedOffer(paramCommContext, ((ManagedOfferBucket)localObject5).getRelatedObject().getOfferToken(), paramString, ((ManagedOfferBucket)localObject5).getRelatedObject().getPurchaseMetadata(), ((ManagedOfferBucket)localObject5).getRelatedObject().getTrackingMetadata(), paramBoolean);
          localObject2 = ((Operation)???).get();
          if ((localObject2 == null) || (!((Result)localObject2).isSuccessfulResponse())) {
            break label1141;
          }
          if (!"FAIL".equalsIgnoreCase(getTransactionState((Result)localObject2, "NONE"))) {}
        }
        else
        {
          synchronized (_ManagedOfferTransactionStateLock)
          {
            updateOfferTransactionState(paramCommContext, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.DONE);
            localObject2 = getTransactionSubstate((Result)localObject2, "NONE");
            if ("FUNDS_INSUFFICIENT_FAILURE".equalsIgnoreCase((String)localObject2))
            {
              GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.FUNDS_INSUFFICIENT_FAILURE, new JSONObject());
              checkCancelling((ManagedOfferBucket)localObject5);
              if ((DBTransactions.ManagedOfferState.PURCHASED.equals(((ManagedOfferBucket)localObject5).getState())) || (DBTransactions.ManagedOfferState.CONFIRMING.equals(((ManagedOfferBucket)localObject5).getState())))
              {
                Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: CONFIRMING [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
                localObject2 = ((ManagedOfferBucket)localObject5).getRelatedObject().getPurchaseMetadata();
                Logger.d(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager runManagedPurchaseTransaction starting runManagedPurchaseTransaction()", new Object[0]);
                if (!DBTransactions.ManagedOfferState.CONFIRMING.equals(((ManagedOfferBucket)localObject5).getState())) {}
                synchronized (_ManagedOfferTransactionStateLock)
                {
                  updateOfferTransactionState(paramCommContext, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.CONFIRMING);
                  localObject2 = TransactionServiceProxy.getInstance().confirmManagedOffer(paramCommContext, paramString, (HashMap)localObject2, paramBoolean);
                  ??? = ((Operation)localObject2).get();
                  str = InAppPurchaseManager.getInstance(this._applicationContext).getCurrentClientTransactionId();
                  if ((??? == null) || (!((Result)???).isSuccessfulResponse())) {
                    break label1360;
                  }
                  AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "response_code", Integer.valueOf(((Result)???).getResponseCode()), "type", AnalyticsManager.TrackingType.PURCHASE_MANAGED_OFFER.value() });
                }
              }
            }
          }
        }
      }
    }
    int i;
    int k;
    boolean bool1;
    for (;;)
    {
      synchronized (_ManagedOfferTransactionStateLock)
      {
        updateOfferStateFromResponseState(paramCommContext, (Result)???, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.CONFIRMED);
        ??? = getEarnOnPurchaseAmount((Result)???);
        if ((??? != null) && (((Long)???).longValue() > 0L)) {
          NotificationsUtility.showEarnedFromPurchaseNotification(this._applicationContext, null, ((Long)???).longValue());
        }
        ??? = localObject2;
        if (!StringUtility.isNullOrEmpty(str))
        {
          ??? = localObject2;
          if (paramString.equals(str)) {
            ??? = null;
          }
        }
        try
        {
          ??? = ((Result)???).getResponseJson().getJSONObject("return").getJSONArray("lines").getJSONObject(0).getJSONArray("item_metadata");
          i = 0;
          paramString = (String)???;
          if (i < ((JSONArray)???).length())
          {
            paramString = ((JSONArray)???).getJSONObject(i);
            if (!paramString.getString("key").equals("voucher_token")) {
              break label1207;
            }
            paramString = paramString.getString("value");
          }
        }
        catch (JSONException paramString)
        {
          int j;
          boolean bool2;
          Logger.d(Area.TRANSACTION.value() | Area.OFFER.value(), "TransactionManager: runManagedPurchaseTransaction() 'confirm' response contains no voucher token", new Object[0]);
          paramString = (String)???;
          continue;
        }
        ??? = null;
        if (!StringUtility.isNullOrEmpty(paramString))
        {
          ??? = IntentsUtility.getRedeemVoucherIntent(paramCommContext.getApplicationContext(), paramString);
          Logger.d(Area.TRANSACTION.value() | Area.OFFER.value(), "TransactionManager: runManagedPurchaseTransaction() result Intent created", new Object[0]);
        }
        j = 0;
        k = 0;
        bool2 = false;
        bool1 = bool2;
        if (??? != null)
        {
          i = k;
          if (GetJarWebViewSubActivity.getInstance() == null) {}
        }
        try
        {
          GetJarWebViewSubActivity.getInstance().setResultAndClose((Intent)???);
          i = 1;
        }
        catch (Exception paramString)
        {
          Logger.e(Area.TRANSACTION.value() | Area.OFFER.value(), paramString, "TransactionManager: runManagedPurchaseTransaction() GetJarWebViewSubActivity.getInstance().setResultAndClose() failed", new Object[0]);
          i = k;
          continue;
          if (!bool1) {
            break label1313;
          }
          Logger.d(Area.TRANSACTION.value() | Area.OFFER.value(), "TransactionManager: runManagedPurchaseTransaction() result delivered via background work listener", new Object[0]);
          ??? = ???;
          continue;
          Logger.e(Area.TRANSACTION.value() | Area.OFFER.value(), "TransactionManager: runManagedPurchaseTransaction() unknown failure", new Object[0]);
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SERVER_ERROR, new JSONObject());
          ??? = ???;
          continue;
        }
        bool1 = bool2;
        j = i;
        if (i == 0)
        {
          bool1 = CommManager.sendIntentToFirstRegisteredGetjarClient((Intent)???);
          j = i;
        }
        if (j == 0) {
          break label1278;
        }
        Logger.d(Area.TRANSACTION.value() | Area.OFFER.value(), "TransactionManager: runManagedPurchaseTransaction() result delivered via UI", new Object[0]);
        ??? = localObject2;
        checkCancelling((ManagedOfferBucket)localObject5);
        if (DBTransactions.ManagedOfferState.CONFIRMED.equals(((ManagedOfferBucket)localObject5).getState())) {
          updateOfferTransactionState(paramCommContext, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.CONSUMING);
        }
        if (DBTransactions.ManagedOfferState.CONSUMING.equals(((ManagedOfferBucket)localObject5).getState())) {
          InAppPurchaseManager.getInstance(this._applicationContext).consumeManagedOffer((ManagedOfferBucket)localObject5, false);
        }
        checkCancelling((ManagedOfferBucket)localObject5);
        checkAndCancelManagedOffer(paramCommContext, (ManagedOfferBucket)localObject5, paramBoolean);
        return (Operation)???;
        paramString = finally;
        throw paramString;
        paramString = finally;
        throw paramString;
        if ("ALREADY_LICENSED".equalsIgnoreCase((String)localObject2))
        {
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.ALREADY_LICENSED, new JSONObject());
          break;
        }
        if ("OUTSTANDING_REDEEM".equalsIgnoreCase((String)localObject2))
        {
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.OUTSTANDING_REDEEM, new JSONObject());
          break;
        }
        GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SERVER_ERROR, new JSONObject());
        break;
        try
        {
          ??? = _ManagedOfferTransactionStateLock;
          if (localObject5 != null) {}
          try
          {
            if (DBTransactions.ManagedOfferState.RESERVING.equals(((ManagedOfferBucket)localObject5).getState())) {
              updateOfferStateFromResponseState(paramCommContext, (Result)localObject2, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.RESERVED);
            }
            break;
          }
          finally {}
        }
        catch (Exception localException)
        {
          Logger.e(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), localException, "TransactionManager: failure", new Object[0]);
          paramCommContext.addException(localException);
        }
        label1141:
        _CanceledClientTransactionIDs.add(paramString);
        synchronized (_ManagedOfferTransactionStateLock)
        {
          updateOfferTransactionState(paramCommContext, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.CANCELING);
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SERVER_ERROR, new JSONObject());
        }
        paramString = finally;
        throw paramString;
      }
      label1207:
      i += 1;
    }
    label1278:
    label1313:
    label1360:
    if ((??? != null) && (RequestUtilities.getServicesException((Result)???) != null) && (((Result)???).getResponseCode() != 500))
    {
      AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "response_code", Integer.valueOf(((Result)???).getResponseCode()), "type", AnalyticsManager.TrackingType.PURCHASE_MANAGED_OFFER.value() });
      _CanceledClientTransactionIDs.add(paramString);
    }
    for (;;)
    {
      synchronized (_ManagedOfferTransactionStateLock)
      {
        updateOfferTransactionState(paramCommContext, (ManagedOfferBucket)localObject5, DBTransactions.ManagedOfferState.CANCELING);
        if ((!StringUtility.isNullOrEmpty(str)) && (paramString.equals(str))) {
          GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SERVER_ERROR, new JSONObject());
        }
        InAppPurchaseManager.getInstance(this._applicationContext).removeLastClientTransactionId();
        ??? = ???;
      }
      if ((!StringUtility.isNullOrEmpty(str)) && (paramString.equals(str))) {
        GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.SERVER_ERROR_RECOVERABLE, new JSONObject());
      }
      AnalyticsManager.getInstance(this._applicationContext).trackEvent("transaction_responded", new Object[] { "type", AnalyticsManager.TrackingType.PURCHASE_MANAGED_OFFER.value() });
    }
  }
  
  private Operation runPurchaseTransaction(PurchaseUnmanagedBucket paramPurchaseUnmanagedBucket, CommContext paramCommContext, boolean paramBoolean)
    throws Exception
  {
    String str = paramPurchaseUnmanagedBucket.getClientTransactionId();
    Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager: runPurchaseTransaction() [clientTransactionId: %1$s] [state: %2$s] [thread: %3$d]", new Object[] { str, paramPurchaseUnmanagedBucket.getState().name(), Long.valueOf(Thread.currentThread().getId()) });
    checkCancelling(paramPurchaseUnmanagedBucket);
    if (((!DBTransactions.PurchaseState.CREATED.equals(paramPurchaseUnmanagedBucket.getState())) && (!DBTransactions.PurchaseState.RESERVING.equals(paramPurchaseUnmanagedBucket.getState()))) || (DBTransactions.PurchaseState.CREATED.equals(paramPurchaseUnmanagedBucket.getState()))) {}
    Result localResult;
    synchronized (_PurchaseTransactionStateLock)
    {
      updatePurchaseTransactionState(paramCommContext, paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState.RESERVING);
      if (!checkCancelling(paramPurchaseUnmanagedBucket))
      {
        ??? = TransactionServiceProxy.getInstance().reserveUnmanagedPurchase(paramCommContext, paramPurchaseUnmanagedBucket.getRelatedObject().getProductId(), paramPurchaseUnmanagedBucket.getRelatedObject().getProductName(), paramPurchaseUnmanagedBucket.getRelatedObject().getProductDescription(), paramPurchaseUnmanagedBucket.getRelatedObject().getAmount(), paramPurchaseUnmanagedBucket.getRelatedObject().getLicenseScope(), str, paramPurchaseUnmanagedBucket.getRelatedObject().getTrackingMetadata(), paramBoolean).get();
        if (??? != null)
        {
          if (!((Result)???).isSuccessfulResponse()) {
            break label498;
          }
          handleSuccessfulReserveResult((Result)???, paramCommContext, paramPurchaseUnmanagedBucket);
        }
      }
      checkCancelling(paramPurchaseUnmanagedBucket);
      ??? = null;
      if (DBTransactions.PurchaseState.CONFIRMING.equals(paramPurchaseUnmanagedBucket.getState()))
      {
        Logger.d(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager runPurchaseTransaction starting confirmUnmanagedPurchase()", new Object[0]);
        ??? = TransactionServiceProxy.getInstance().confirmUnmanagedPurchase(paramCommContext, str, paramBoolean);
        localResult = ((Operation)???).get();
        ??? = ???;
        if (localResult != null)
        {
          Logger.d(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager runPurchaseTransaction -- Response " + localResult.getResponseBody(), new Object[0]);
          if (!localResult.isSuccessfulResponse()) {
            break label540;
          }
        }
      }
      synchronized (_PurchaseTransactionStateLock)
      {
        updatePurchaseStateFromResponseState(paramCommContext, localResult, paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState.DONE);
        ??? = ???;
        label358:
        if (DBTransactions.PurchaseState.CANCELING.equals(paramPurchaseUnmanagedBucket.getState()))
        {
          localResult = TransactionServiceProxy.getInstance().cancelTransaction(paramCommContext, str, paramBoolean).get();
          if (localResult != null) {
            if (!localResult.isSuccessfulResponse()) {
              break label590;
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (_PurchaseTransactionStateLock)
      {
        updatePurchaseStateFromResponseState(paramCommContext, localResult, paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState.DONE);
        _CanceledClientTransactionIDs.remove(paramPurchaseUnmanagedBucket.getClass());
        if (DBTransactions.PurchaseState.DONE.equals(paramPurchaseUnmanagedBucket.getState()))
        {
          if (DBTransactions.getInstance(this._applicationContext).deleteTransaction(str)) {
            break label637;
          }
          Logger.e(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager: runPurchaseTransaction() failed to delete a Purchase transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str });
        }
        return (Operation)???;
        paramPurchaseUnmanagedBucket = finally;
        throw paramPurchaseUnmanagedBucket;
        label498:
        if (RequestUtilities.getServicesException((Result)???) == null) {
          break;
        }
        synchronized (_PurchaseTransactionStateLock)
        {
          updatePurchaseTransactionState(paramCommContext, paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState.DONE);
        }
        paramPurchaseUnmanagedBucket = finally;
        throw paramPurchaseUnmanagedBucket;
        label540:
        ??? = ???;
        if (RequestUtilities.getServicesException(localResult) == null) {
          break label358;
        }
        synchronized (_PurchaseTransactionStateLock)
        {
          updatePurchaseTransactionState(paramCommContext, paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState.DONE);
          ??? = ???;
        }
      }
      label590:
      if (RequestUtilities.getServicesException(localResult) != null) {
        synchronized (_PurchaseTransactionStateLock)
        {
          updatePurchaseTransactionState(paramCommContext, paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState.DONE);
          _CanceledClientTransactionIDs.remove(paramPurchaseUnmanagedBucket.getClass());
        }
      }
    }
    label637:
    Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager: runPurchaseTransaction() deleted a Purchase transaction in the DONE state [clientTransactionId: %1$s]", new Object[] { str });
    return (Operation)???;
  }
  
  private Future<List<TransactionBucket>> runTransactions(final CommContext paramCommContext, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    Logger.v(Area.TRANSACTION.value(), "TransactionManager: runTransactions() [thread: %1$d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    paramCommContext = new SetExceptionFutureTask(new Callable()
    {
      public List<TransactionBucket> call()
        throws Exception
      {
        try
        {
          List localList = TransactionManager.this.runTransactionsInternal(paramCommContext, paramBoolean1, paramBoolean2);
          return localList;
        }
        catch (Exception localException)
        {
          Logger.e(Area.TRANSACTION.value(), localException, "TransactionManager: Worker Thread failed", new Object[0]);
        }
        return null;
      }
    });
    _ExecutorService.execute(paramCommContext);
    return paramCommContext;
  }
  
  /* Error */
  private List<TransactionBucket> runTransactionsInternal(CommContext paramCommContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 965	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 966	java/util/ArrayList:<init>	()V
    //   7: pop
    //   8: new 965	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 966	java/util/ArrayList:<init>	()V
    //   15: astore 11
    //   17: getstatic 71	com/getjar/sdk/comm/TransactionManager:_TransactionFlowLock	Ljava/lang/Object;
    //   20: astore 10
    //   22: aload 10
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 92	com/getjar/sdk/comm/TransactionManager:_applicationContext	Landroid/content/Context;
    //   29: invokestatic 234	com/getjar/sdk/comm/persistence/DBTransactions:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/comm/persistence/DBTransactions;
    //   32: invokevirtual 970	com/getjar/sdk/comm/persistence/DBTransactions:loadAllTransactions	()Ljava/util/List;
    //   35: astore 12
    //   37: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   40: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   43: getstatic 254	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   46: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   49: lor
    //   50: ldc_w 972
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload 12
    //   61: invokeinterface 977 1 0
    //   66: invokestatic 531	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: invokestatic 297	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   75: invokevirtual 300	java/lang/Thread:getId	()J
    //   78: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: aastore
    //   82: invokestatic 275	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   85: aconst_null
    //   86: astore 8
    //   88: aload_1
    //   89: iconst_1
    //   90: invokestatic 982	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   93: ldc_w 984
    //   96: getstatic 990	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   99: invokevirtual 994	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   102: invokestatic 997	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: invokestatic 1003	com/getjar/sdk/utilities/Utility:convertMillSec	(J)J
    //   108: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: astore 9
    //   113: aload 9
    //   115: astore 8
    //   117: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   120: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   123: getstatic 1006	com/getjar/sdk/logging/Area:CONFIG	Lcom/getjar/sdk/logging/Area;
    //   126: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   129: lor
    //   130: ldc_w 1008
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload 9
    //   141: aastore
    //   142: invokestatic 275	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   145: aload 9
    //   147: astore 8
    //   149: aload 12
    //   151: invokeinterface 1012 1 0
    //   156: astore 9
    //   158: aload 9
    //   160: invokeinterface 1017 1 0
    //   165: ifeq +542 -> 707
    //   168: aload 9
    //   170: invokeinterface 1020 1 0
    //   175: checkcast 1022	com/getjar/sdk/comm/persistence/TransactionBucket
    //   178: astore 12
    //   180: iconst_0
    //   181: istore 5
    //   183: invokestatic 1027	java/lang/System:currentTimeMillis	()J
    //   186: lstore 6
    //   188: iload 5
    //   190: istore 4
    //   192: aload 8
    //   194: ifnull +82 -> 276
    //   197: iload 5
    //   199: istore 4
    //   201: aload 12
    //   203: invokevirtual 1030	com/getjar/sdk/comm/persistence/TransactionBucket:getTimestampCreated	()J
    //   206: aload 8
    //   208: invokevirtual 817	java/lang/Long:longValue	()J
    //   211: ladd
    //   212: lload 6
    //   214: lcmp
    //   215: ifge +61 -> 276
    //   218: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   221: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   224: getstatic 254	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   227: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   230: lor
    //   231: ldc_w 1032
    //   234: iconst_4
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 12
    //   242: invokevirtual 1033	com/getjar/sdk/comm/persistence/TransactionBucket:getClientTransactionId	()Ljava/lang/String;
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: aload 12
    //   250: invokevirtual 1030	com/getjar/sdk/comm/persistence/TransactionBucket:getTimestampCreated	()J
    //   253: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   256: aastore
    //   257: dup
    //   258: iconst_2
    //   259: aload 8
    //   261: aastore
    //   262: dup
    //   263: iconst_3
    //   264: lload 6
    //   266: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: invokestatic 275	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   273: iconst_1
    //   274: istore 4
    //   276: getstatic 1038	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:PURCHASE	Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   279: aload 12
    //   281: invokevirtual 1042	com/getjar/sdk/comm/persistence/TransactionBucket:getType	()Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   284: invokevirtual 1043	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:equals	(Ljava/lang/Object;)Z
    //   287: ifeq +191 -> 478
    //   290: iload_2
    //   291: ifne -133 -> 158
    //   294: iload 4
    //   296: ifeq +64 -> 360
    //   299: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   302: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   305: getstatic 254	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   308: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   311: lor
    //   312: getstatic 323	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
    //   315: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   318: lor
    //   319: ldc_w 1045
    //   322: iconst_1
    //   323: anewarray 4	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: aload 12
    //   330: invokevirtual 1033	com/getjar/sdk/comm/persistence/TransactionBucket:getClientTransactionId	()Ljava/lang/String;
    //   333: aastore
    //   334: invokestatic 275	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   337: getstatic 73	com/getjar/sdk/comm/TransactionManager:_PurchaseTransactionStateLock	Ljava/lang/Object;
    //   340: astore 13
    //   342: aload 13
    //   344: monitorenter
    //   345: aload_1
    //   346: aload 12
    //   348: checkcast 311	com/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket
    //   351: getstatic 941	com/getjar/sdk/comm/persistence/DBTransactions$PurchaseState:DONE	Lcom/getjar/sdk/comm/persistence/DBTransactions$PurchaseState;
    //   354: invokestatic 892	com/getjar/sdk/comm/TransactionManager:updatePurchaseTransactionState	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket;Lcom/getjar/sdk/comm/persistence/DBTransactions$PurchaseState;)V
    //   357: aload 13
    //   359: monitorexit
    //   360: aload_0
    //   361: aload 12
    //   363: checkcast 311	com/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket
    //   366: aload_1
    //   367: iload_3
    //   368: invokespecial 102	com/getjar/sdk/comm/TransactionManager:runPurchaseTransaction	(Lcom/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket;Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/comm/Operation;
    //   371: pop
    //   372: aload 11
    //   374: aload 12
    //   376: invokeinterface 1046 2 0
    //   381: pop
    //   382: goto -224 -> 158
    //   385: astore 13
    //   387: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   390: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   393: getstatic 254	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   396: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   399: lor
    //   400: aload 13
    //   402: ldc_w 1048
    //   405: iconst_2
    //   406: anewarray 4	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: aload 12
    //   413: invokevirtual 1042	com/getjar/sdk/comm/persistence/TransactionBucket:getType	()Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   416: invokevirtual 1049	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:name	()Ljava/lang/String;
    //   419: aastore
    //   420: dup
    //   421: iconst_1
    //   422: aload 12
    //   424: invokevirtual 1033	com/getjar/sdk/comm/persistence/TransactionBucket:getClientTransactionId	()Ljava/lang/String;
    //   427: aastore
    //   428: invokestatic 374	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: goto -273 -> 158
    //   434: astore_1
    //   435: aload 10
    //   437: monitorexit
    //   438: aload_1
    //   439: athrow
    //   440: astore 9
    //   442: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   445: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   448: getstatic 1006	com/getjar/sdk/logging/Area:CONFIG	Lcom/getjar/sdk/logging/Area;
    //   451: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   454: lor
    //   455: aload 9
    //   457: ldc_w 1051
    //   460: iconst_0
    //   461: anewarray 4	java/lang/Object
    //   464: invokestatic 374	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: goto -318 -> 149
    //   470: astore 14
    //   472: aload 13
    //   474: monitorexit
    //   475: aload 14
    //   477: athrow
    //   478: getstatic 1053	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:EARN	Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   481: aload 12
    //   483: invokevirtual 1042	com/getjar/sdk/comm/persistence/TransactionBucket:getType	()Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   486: invokevirtual 1043	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:equals	(Ljava/lang/Object;)Z
    //   489: ifeq +98 -> 587
    //   492: iload 4
    //   494: ifeq +53 -> 547
    //   497: getstatic 251	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
    //   500: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   503: getstatic 254	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   506: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   509: lor
    //   510: getstatic 539	com/getjar/sdk/logging/Area:EARN	Lcom/getjar/sdk/logging/Area;
    //   513: invokevirtual 248	com/getjar/sdk/logging/Area:value	()J
    //   516: lor
    //   517: ldc_w 1045
    //   520: iconst_1
    //   521: anewarray 4	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: aload 12
    //   528: invokevirtual 1033	com/getjar/sdk/comm/persistence/TransactionBucket:getClientTransactionId	()Ljava/lang/String;
    //   531: aastore
    //   532: invokestatic 275	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   535: aload_1
    //   536: aload 12
    //   538: checkcast 535	com/getjar/sdk/comm/persistence/EarnBucket
    //   541: getstatic 628	com/getjar/sdk/comm/persistence/DBTransactions$EarnState:DONE	Lcom/getjar/sdk/comm/persistence/DBTransactions$EarnState;
    //   544: invokestatic 567	com/getjar/sdk/comm/TransactionManager:updateEarnTransactionState	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/comm/persistence/EarnBucket;Lcom/getjar/sdk/comm/persistence/DBTransactions$EarnState;)V
    //   547: new 32	com/getjar/sdk/comm/TransactionManager$EarnCallback
    //   550: dup
    //   551: aload_0
    //   552: aload 12
    //   554: checkcast 535	com/getjar/sdk/comm/persistence/EarnBucket
    //   557: aload 12
    //   559: invokevirtual 1056	com/getjar/sdk/comm/persistence/TransactionBucket:getRelatedObject	()Ljava/io/Serializable;
    //   562: checkcast 572	com/getjar/sdk/comm/persistence/RelatedEarnData
    //   565: invokespecial 1059	com/getjar/sdk/comm/TransactionManager$EarnCallback:<init>	(Lcom/getjar/sdk/comm/TransactionManager;Lcom/getjar/sdk/comm/persistence/EarnBucket;Lcom/getjar/sdk/comm/persistence/RelatedEarnData;)V
    //   568: astore 13
    //   570: aload_0
    //   571: aload 12
    //   573: checkcast 535	com/getjar/sdk/comm/persistence/EarnBucket
    //   576: aload_1
    //   577: aload 13
    //   579: iload_3
    //   580: invokespecial 121	com/getjar/sdk/comm/TransactionManager:runEarnTransaction	(Lcom/getjar/sdk/comm/persistence/EarnBucket;Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/comm/CallbackInterface;Z)Lcom/getjar/sdk/comm/Operation;
    //   583: pop
    //   584: goto -212 -> 372
    //   587: getstatic 1062	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:MANAGED_OFFER	Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   590: aload 12
    //   592: invokevirtual 1042	com/getjar/sdk/comm/persistence/TransactionBucket:getType	()Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   595: invokevirtual 1043	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +18 -> 616
    //   601: aload_0
    //   602: aload 12
    //   604: invokevirtual 1033	com/getjar/sdk/comm/persistence/TransactionBucket:getClientTransactionId	()Ljava/lang/String;
    //   607: aload_1
    //   608: iload_3
    //   609: invokespecial 115	com/getjar/sdk/comm/TransactionManager:runManagedOfferTransaction	(Ljava/lang/String;Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/comm/Operation;
    //   612: pop
    //   613: goto -241 -> 372
    //   616: getstatic 1065	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:GRANT_GETJAR_PASS	Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   619: aload 12
    //   621: invokevirtual 1042	com/getjar/sdk/comm/persistence/TransactionBucket:getType	()Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   624: invokevirtual 1043	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:equals	(Ljava/lang/Object;)Z
    //   627: ifeq +19 -> 646
    //   630: aload_0
    //   631: aconst_null
    //   632: aload 12
    //   634: invokevirtual 1033	com/getjar/sdk/comm/persistence/TransactionBucket:getClientTransactionId	()Ljava/lang/String;
    //   637: aload_1
    //   638: iload_3
    //   639: invokespecial 127	com/getjar/sdk/comm/TransactionManager:runGrantGetjarPassTransaction	(Ljava/lang/String;Ljava/lang/String;Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/comm/Operation;
    //   642: pop
    //   643: goto -271 -> 372
    //   646: getstatic 1068	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:CONFIRM_VOUCHER	Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   649: aload 12
    //   651: invokevirtual 1042	com/getjar/sdk/comm/persistence/TransactionBucket:getType	()Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   654: invokevirtual 1043	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:equals	(Ljava/lang/Object;)Z
    //   657: ifeq +18 -> 675
    //   660: aload_0
    //   661: aload 12
    //   663: checkcast 452	com/getjar/sdk/comm/persistence/ConfirmVoucherBucket
    //   666: aload_1
    //   667: iconst_1
    //   668: invokespecial 135	com/getjar/sdk/comm/TransactionManager:runConfirmVoucherTransaction	(Lcom/getjar/sdk/comm/persistence/ConfirmVoucherBucket;Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/comm/Operation;
    //   671: pop
    //   672: goto -300 -> 372
    //   675: new 1070	java/lang/IllegalStateException
    //   678: dup
    //   679: getstatic 1076	java/util/Locale:US	Ljava/util/Locale;
    //   682: ldc_w 1078
    //   685: iconst_1
    //   686: anewarray 4	java/lang/Object
    //   689: dup
    //   690: iconst_0
    //   691: aload 12
    //   693: invokevirtual 1042	com/getjar/sdk/comm/persistence/TransactionBucket:getType	()Lcom/getjar/sdk/comm/persistence/DBTransactions$TransactionType;
    //   696: invokevirtual 1049	com/getjar/sdk/comm/persistence/DBTransactions$TransactionType:name	()Ljava/lang/String;
    //   699: aastore
    //   700: invokestatic 1082	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   703: invokespecial 1083	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   706: athrow
    //   707: aload 10
    //   709: monitorexit
    //   710: aload 11
    //   712: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	this	TransactionManager
    //   0	713	1	paramCommContext	CommContext
    //   0	713	2	paramBoolean1	boolean
    //   0	713	3	paramBoolean2	boolean
    //   190	303	4	i	int
    //   181	17	5	j	int
    //   186	79	6	l	long
    //   86	174	8	localObject1	Object
    //   111	58	9	localObject2	Object
    //   440	16	9	localException1	Exception
    //   20	688	10	localObject3	Object
    //   15	696	11	localArrayList	java.util.ArrayList
    //   35	657	12	localObject4	Object
    //   385	88	13	localException2	Exception
    //   568	10	13	localEarnCallback	EarnCallback
    //   470	6	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   183	188	385	java/lang/Exception
    //   201	273	385	java/lang/Exception
    //   276	290	385	java/lang/Exception
    //   299	345	385	java/lang/Exception
    //   360	372	385	java/lang/Exception
    //   372	382	385	java/lang/Exception
    //   475	478	385	java/lang/Exception
    //   478	492	385	java/lang/Exception
    //   497	547	385	java/lang/Exception
    //   547	584	385	java/lang/Exception
    //   587	613	385	java/lang/Exception
    //   616	643	385	java/lang/Exception
    //   646	672	385	java/lang/Exception
    //   675	707	385	java/lang/Exception
    //   25	85	434	finally
    //   88	113	434	finally
    //   117	145	434	finally
    //   149	158	434	finally
    //   158	180	434	finally
    //   183	188	434	finally
    //   201	273	434	finally
    //   276	290	434	finally
    //   299	345	434	finally
    //   360	372	434	finally
    //   372	382	434	finally
    //   387	431	434	finally
    //   435	438	434	finally
    //   442	467	434	finally
    //   475	478	434	finally
    //   478	492	434	finally
    //   497	547	434	finally
    //   547	584	434	finally
    //   587	613	434	finally
    //   616	643	434	finally
    //   646	672	434	finally
    //   675	707	434	finally
    //   707	710	434	finally
    //   88	113	440	java/lang/Exception
    //   117	145	440	java/lang/Exception
    //   345	360	470	finally
    //   472	475	470	finally
  }
  
  private static void updateConfirmVoucherTransactionState(CommContext paramCommContext, ConfirmVoucherBucket paramConfirmVoucherBucket, DBTransactions.ConfirmVoucherState paramConfirmVoucherState)
  {
    Logger.v(Area.REDEEM.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: updateConfirmVoucherTransactionState() [clientTransactionId: %1$s] [old: %2$s] [new: %3$s] [thread: %4$d]", new Object[] { paramConfirmVoucherBucket.getClientTransactionId(), paramConfirmVoucherBucket.getState().name(), paramConfirmVoucherState.name(), Long.valueOf(Thread.currentThread().getId()) });
    DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateConfirmVoucherTransaction(paramConfirmVoucherBucket, paramConfirmVoucherState);
    paramConfirmVoucherBucket.setState(paramConfirmVoucherState);
  }
  
  private static void updateEarnTransactionState(CommContext paramCommContext, EarnBucket paramEarnBucket, DBTransactions.EarnState paramEarnState)
  {
    Logger.v(Area.EARN.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: updateEarnTransactionState() [clientTransactionId: %1$s] [old: %2$s] [new: %3$s] [thread: %4$d]", new Object[] { paramEarnBucket.getClientTransactionId(), paramEarnBucket.getState().name(), paramEarnState.name(), Long.valueOf(Thread.currentThread().getId()) });
    DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateEarnTransaction(paramEarnBucket, paramEarnState);
    paramEarnBucket.setState(paramEarnState);
  }
  
  private static void updateGrantGetjarPassTransactionState(CommContext paramCommContext, GrantGetjarPassBucket paramGrantGetjarPassBucket, DBTransactions.GrantGetjarPassState paramGrantGetjarPassState)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    if (paramGrantGetjarPassBucket == null) {
      throw new IllegalArgumentException("'transaction' cannot be NULL");
    }
    if (paramGrantGetjarPassState == null) {
      throw new IllegalArgumentException("'newState' cannot be NULL");
    }
    Logger.v(Area.GETJAR_PASS.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: updateGrantGetjarPassTransactionState() [clientTransactionId: %1$s] [old: %2$s] [new: %3$s] [thread: %4$d]", new Object[] { paramGrantGetjarPassBucket.getClientTransactionId(), paramGrantGetjarPassBucket.getState().name(), paramGrantGetjarPassState.name(), Long.valueOf(Thread.currentThread().getId()) });
    DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateGrantGetjarPassTransaction(paramGrantGetjarPassBucket, paramGrantGetjarPassState);
    paramGrantGetjarPassBucket.setState(paramGrantGetjarPassState);
  }
  
  private DBTransactions.ManagedOfferState updateOfferStateFromResponseState(CommContext paramCommContext, Result paramResult, ManagedOfferBucket paramManagedOfferBucket, DBTransactions.ManagedOfferState paramManagedOfferState)
  {
    try
    {
      String str = getTransactionState(paramResult, "");
      if ("SUCCESS".equalsIgnoreCase(str)) {
        paramResult = DBTransactions.ManagedOfferState.CONSUMING;
      }
      for (;;)
      {
        updateOfferTransactionState(paramCommContext, paramManagedOfferBucket, paramResult);
        return paramResult;
        if ("FAIL".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.ManagedOfferState.DONE;
        }
        else if ("CANCELED".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.ManagedOfferState.DONE;
        }
        else if ("CREATED".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.ManagedOfferState.RESERVING;
        }
        else if ("RESERVED".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.ManagedOfferState.RESERVED;
        }
        else
        {
          paramResult = paramManagedOfferState;
          if ("CONFIRMED".equalsIgnoreCase(str)) {
            paramResult = DBTransactions.ManagedOfferState.CONSUMING;
          }
        }
      }
    }
    catch (Exception paramResult)
    {
      for (;;)
      {
        Logger.e(Area.OFFER.value() | Area.STORAGE.value() | Area.TRANSACTION.value(), paramResult, "updateOfferStateFromResponseState() failed, setting state to: %1$s", new Object[] { paramManagedOfferState.name() });
        paramResult = paramManagedOfferState;
      }
    }
  }
  
  public static void updateOfferTransactionState(CommContext paramCommContext, ManagedOfferBucket paramManagedOfferBucket, DBTransactions.ManagedOfferState paramManagedOfferState)
  {
    Logger.v(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: updateOfferTransactionState() [clientTransactionId: %1$s] [old: %2$s] [new: %3$s] [thread: %4$d]", new Object[] { paramManagedOfferBucket.getClientTransactionId(), paramManagedOfferBucket.getState().name(), paramManagedOfferState.name(), Long.valueOf(Thread.currentThread().getId()) });
    if ((_CanceledClientTransactionIDs.contains(paramManagedOfferBucket.getClientTransactionId())) && (!DBTransactions.ManagedOfferState.CANCELING.equals(paramManagedOfferState)))
    {
      Logger.v(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: updateOfferTransactionState() [clientTransactionId: %1$s] CANCELING [%2$s]", new Object[] { paramManagedOfferBucket.getClientTransactionId(), Logger.getShortStack() });
      paramManagedOfferBucket.setState(DBTransactions.ManagedOfferState.CANCELING);
      return;
    }
    Logger.v(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: updateOfferTransactionState() [clientTransactionId: %1$s] [new: %2$s]", new Object[] { paramManagedOfferBucket.getClientTransactionId(), paramManagedOfferState.name() });
    DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateManagedOfferTransaction(paramManagedOfferBucket, paramManagedOfferState);
  }
  
  private DBTransactions.PurchaseState updatePurchaseStateFromResponseState(CommContext paramCommContext, Result paramResult, PurchaseUnmanagedBucket paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState paramPurchaseState)
  {
    try
    {
      String str = getTransactionState(paramResult, "");
      if ("SUCCESS".equalsIgnoreCase(str)) {
        paramResult = DBTransactions.PurchaseState.DONE;
      }
      for (;;)
      {
        updatePurchaseTransactionState(paramCommContext, paramPurchaseUnmanagedBucket, paramResult);
        return paramResult;
        if ("FAIL".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.PurchaseState.DONE;
        }
        else if ("CANCELED".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.PurchaseState.DONE;
        }
        else if ("CREATED".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.PurchaseState.RESERVING;
        }
        else if ("RESERVED".equalsIgnoreCase(str))
        {
          paramResult = DBTransactions.PurchaseState.CONFIRMING;
        }
        else
        {
          paramResult = paramPurchaseState;
          if ("CONFIRMED".equalsIgnoreCase(str)) {
            paramResult = DBTransactions.PurchaseState.DONE;
          }
        }
      }
    }
    catch (Exception paramResult)
    {
      for (;;)
      {
        Logger.e(Area.PURCHASE.value() | Area.STORAGE.value() | Area.TRANSACTION.value(), paramResult, "updatePurchaseStateFromResponseState() failed, setting state to: %1$s", new Object[] { paramPurchaseState.name() });
        paramResult = paramPurchaseState;
      }
    }
  }
  
  private static void updatePurchaseTransactionState(CommContext paramCommContext, PurchaseUnmanagedBucket paramPurchaseUnmanagedBucket, DBTransactions.PurchaseState paramPurchaseState)
  {
    Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: updatePurchaseTransactionState() [clientTransactionId: %1$s] [old: %2$s] [new: %3$s] [thread: %4$d]", new Object[] { paramPurchaseUnmanagedBucket.getClientTransactionId(), paramPurchaseUnmanagedBucket.getState().name(), paramPurchaseState.name(), Long.valueOf(Thread.currentThread().getId()) });
    if ((_CanceledClientTransactionIDs.contains(paramPurchaseUnmanagedBucket.getClientTransactionId())) && (!DBTransactions.PurchaseState.CANCELING.equals(paramPurchaseState)))
    {
      paramPurchaseUnmanagedBucket.setState(DBTransactions.PurchaseState.CANCELING);
      return;
    }
    DBTransactions.getInstance(paramCommContext.getApplicationContext()).updatePurchaseTransaction(paramPurchaseUnmanagedBucket, paramPurchaseState);
  }
  
  private void updateUIWithAlreadyPurchased(String paramString1, String paramString2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("auth.provider_filter.name", paramString1);
    localJSONObject.put("auth.provider_filter.data", paramString2);
    GetJarWebViewSubActivity.updateUIwithPurchaseResults(this._applicationContext, InAppPurchaseManager.PurchaseStatus.ALREADY_PURCHASED_DIFFERENT_ACCOUNT, localJSONObject);
  }
  
  public void buyCurrencyForGoogleTransactions(final CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("commContext cannot be null");
    }
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: invokestatic 36	com/getjar/sdk/comm/TransactionManager:access$900	()Ljava/lang/Object;
        //   3: astore_3
        //   4: aload_3
        //   5: monitorenter
        //   6: aload_0
        //   7: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   10: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   13: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   16: invokevirtual 52	com/getjar/sdk/rewards/InAppPurchaseManager:getAllPurchaseResponses	()Ljava/util/List;
        //   19: checkcast 54	java/util/ArrayList
        //   22: invokevirtual 58	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   25: astore 4
        //   27: aload 4
        //   29: invokeinterface 64 1 0
        //   34: ifeq +333 -> 367
        //   37: aload 4
        //   39: invokeinterface 67 1 0
        //   44: checkcast 69	com/getjar/sdk/data/GooglePurchaseResponse
        //   47: astore 7
        //   49: aload 7
        //   51: aload_0
        //   52: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   55: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   58: invokevirtual 77	com/getjar/sdk/data/GooglePurchaseResponse:getResponseAsMap	(Landroid/content/Context;)Ljava/util/Map;
        //   61: checkcast 79	java/util/HashMap
        //   64: astore 6
        //   66: aload 7
        //   68: invokevirtual 83	com/getjar/sdk/data/GooglePurchaseResponse:getProductId	()Ljava/lang/String;
        //   71: astore 5
        //   73: aload 7
        //   75: invokevirtual 86	com/getjar/sdk/data/GooglePurchaseResponse:getDeveloperPayload	()Ljava/lang/String;
        //   78: astore_2
        //   79: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   82: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   85: new 98	java/lang/StringBuilder
        //   88: dup
        //   89: invokespecial 99	java/lang/StringBuilder:<init>	()V
        //   92: ldc 101
        //   94: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   97: aload_2
        //   98: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: ldc 107
        //   103: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   106: aload 5
        //   108: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   111: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   114: iconst_0
        //   115: anewarray 4	java/lang/Object
        //   118: invokestatic 116	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
        //   121: aload_2
        //   122: astore_1
        //   123: aload_2
        //   124: invokestatic 122	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   127: ifeq +53 -> 180
        //   130: aload 5
        //   132: ldc 124
        //   134: invokevirtual 129	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   137: ifeq +233 -> 370
        //   140: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   143: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   146: ldc -125
        //   148: iconst_0
        //   149: anewarray 4	java/lang/Object
        //   152: invokestatic 116	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
        //   155: new 98	java/lang/StringBuilder
        //   158: dup
        //   159: invokespecial 99	java/lang/StringBuilder:<init>	()V
        //   162: ldc -123
        //   164: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   167: invokestatic 139	java/util/UUID:randomUUID	()Ljava/util/UUID;
        //   170: invokevirtual 140	java/util/UUID:toString	()Ljava/lang/String;
        //   173: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   179: astore_1
        //   180: aload_1
        //   181: ldc -123
        //   183: invokevirtual 129	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   186: ifeq +225 -> 411
        //   189: aload 5
        //   191: ldc -114
        //   193: invokevirtual 129	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   196: ifne +13 -> 209
        //   199: aload 5
        //   201: ldc 124
        //   203: invokevirtual 129	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   206: ifeq +205 -> 411
        //   209: aload_1
        //   210: ldc -123
        //   212: invokevirtual 146	java/lang/String:length	()I
        //   215: invokevirtual 150	java/lang/String:substring	(I)Ljava/lang/String;
        //   218: astore_1
        //   219: invokestatic 155	com/getjar/sdk/comm/TransactionServiceProxy:getInstance	()Lcom/getjar/sdk/comm/TransactionServiceProxy;
        //   222: aload_0
        //   223: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   226: aload_1
        //   227: aload 5
        //   229: aload 6
        //   231: new 79	java/util/HashMap
        //   234: dup
        //   235: invokespecial 156	java/util/HashMap:<init>	()V
        //   238: iconst_1
        //   239: invokevirtual 160	com/getjar/sdk/comm/TransactionServiceProxy:buyCurrency	(Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;Z)Lcom/getjar/sdk/comm/Operation;
        //   242: astore_1
        //   243: aload_1
        //   244: invokevirtual 166	com/getjar/sdk/comm/Operation:get	()Lcom/getjar/sdk/comm/Result;
        //   247: astore_1
        //   248: aload_1
        //   249: ifnull +393 -> 642
        //   252: aload_1
        //   253: invokevirtual 171	com/getjar/sdk/comm/Result:checkForCallerUnauthorized	()Z
        //   256: ifeq +191 -> 447
        //   259: aload_0
        //   260: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   263: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   266: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   269: aload 5
        //   271: getstatic 177	com/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure:UNAUTHORIZED	Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;
        //   274: aload_0
        //   275: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   278: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   281: invokevirtual 181	com/getjar/sdk/rewards/InAppPurchaseManager:handleFailure	(Ljava/lang/String;Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;Landroid/content/Context;)V
        //   284: aload_0
        //   285: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   288: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   291: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   294: aload 7
        //   296: invokevirtual 184	com/getjar/sdk/data/GooglePurchaseResponse:getOrderId	()Ljava/lang/String;
        //   299: invokevirtual 188	com/getjar/sdk/rewards/InAppPurchaseManager:removePurchaseResponse	(Ljava/lang/String;)V
        //   302: goto -275 -> 27
        //   305: astore_1
        //   306: aload_0
        //   307: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   310: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   313: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   316: aload 5
        //   318: getstatic 191	com/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure:GETJAR_SERVICE_FAILURE	Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;
        //   321: aload_0
        //   322: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   325: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   328: invokevirtual 181	com/getjar/sdk/rewards/InAppPurchaseManager:handleFailure	(Ljava/lang/String;Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;Landroid/content/Context;)V
        //   331: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   334: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   337: aload_1
        //   338: ldc -63
        //   340: iconst_0
        //   341: anewarray 4	java/lang/Object
        //   344: invokestatic 197	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   347: goto -320 -> 27
        //   350: astore_1
        //   351: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   354: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   357: aload_1
        //   358: ldc -63
        //   360: iconst_0
        //   361: anewarray 4	java/lang/Object
        //   364: invokestatic 197	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   367: aload_3
        //   368: monitorexit
        //   369: return
        //   370: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   373: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   376: ldc -57
        //   378: iconst_0
        //   379: anewarray 4	java/lang/Object
        //   382: invokestatic 201	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
        //   385: aload_0
        //   386: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   389: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   392: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   395: aload 7
        //   397: invokevirtual 184	com/getjar/sdk/data/GooglePurchaseResponse:getOrderId	()Ljava/lang/String;
        //   400: invokevirtual 188	com/getjar/sdk/rewards/InAppPurchaseManager:removePurchaseResponse	(Ljava/lang/String;)V
        //   403: goto -376 -> 27
        //   406: astore_1
        //   407: aload_3
        //   408: monitorexit
        //   409: aload_1
        //   410: athrow
        //   411: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   414: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   417: ldc -53
        //   419: iconst_0
        //   420: anewarray 4	java/lang/Object
        //   423: invokestatic 201	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
        //   426: aload_0
        //   427: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   430: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   433: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   436: aload 7
        //   438: invokevirtual 184	com/getjar/sdk/data/GooglePurchaseResponse:getOrderId	()Ljava/lang/String;
        //   441: invokevirtual 188	com/getjar/sdk/rewards/InAppPurchaseManager:removePurchaseResponse	(Ljava/lang/String;)V
        //   444: goto -417 -> 27
        //   447: aload_1
        //   448: invokevirtual 206	com/getjar/sdk/comm/Result:isSuccessfulResponse	()Z
        //   451: ifeq +163 -> 614
        //   454: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   457: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   460: ldc -48
        //   462: iconst_0
        //   463: anewarray 4	java/lang/Object
        //   466: invokestatic 211	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
        //   469: aload_0
        //   470: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   473: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   476: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   479: aload 7
        //   481: invokevirtual 184	com/getjar/sdk/data/GooglePurchaseResponse:getOrderId	()Ljava/lang/String;
        //   484: invokevirtual 188	com/getjar/sdk/rewards/InAppPurchaseManager:removePurchaseResponse	(Ljava/lang/String;)V
        //   487: aload_0
        //   488: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   491: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   494: getstatic 217	java/util/Locale:US	Ljava/util/Locale;
        //   497: ldc -37
        //   499: iconst_1
        //   500: anewarray 4	java/lang/Object
        //   503: dup
        //   504: iconst_0
        //   505: aload 6
        //   507: ldc -35
        //   509: invokevirtual 224	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   512: aastore
        //   513: invokestatic 228	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   516: invokestatic 234	com/getjar/sdk/utilities/NotificationsUtility:pushBuyGoldSuccessNotification	(Landroid/content/Context;Ljava/lang/String;)V
        //   519: new 236	android/content/Intent
        //   522: dup
        //   523: ldc -18
        //   525: invokespecial 240	android/content/Intent:<init>	(Ljava/lang/String;)V
        //   528: astore_1
        //   529: aload_1
        //   530: ldc -14
        //   532: aload 5
        //   534: invokevirtual 246	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   537: pop
        //   538: aload_1
        //   539: ldc -35
        //   541: aload 6
        //   543: ldc -35
        //   545: invokevirtual 224	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   548: checkcast 126	java/lang/String
        //   551: invokevirtual 246	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   554: pop
        //   555: aload_0
        //   556: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   559: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   562: aload_1
        //   563: invokevirtual 252	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
        //   566: goto -539 -> 27
        //   569: astore_1
        //   570: aload_0
        //   571: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   574: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   577: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   580: aload 5
        //   582: getstatic 191	com/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure:GETJAR_SERVICE_FAILURE	Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;
        //   585: aload_0
        //   586: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   589: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   592: invokevirtual 181	com/getjar/sdk/rewards/InAppPurchaseManager:handleFailure	(Ljava/lang/String;Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;Landroid/content/Context;)V
        //   595: getstatic 92	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
        //   598: invokevirtual 96	com/getjar/sdk/logging/Area:value	()J
        //   601: aload_1
        //   602: ldc -63
        //   604: iconst_0
        //   605: anewarray 4	java/lang/Object
        //   608: invokestatic 197	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   611: goto -584 -> 27
        //   614: aload_0
        //   615: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   618: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   621: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   624: aload 5
        //   626: getstatic 191	com/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure:GETJAR_SERVICE_FAILURE	Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;
        //   629: aload_0
        //   630: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   633: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   636: invokevirtual 181	com/getjar/sdk/rewards/InAppPurchaseManager:handleFailure	(Ljava/lang/String;Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;Landroid/content/Context;)V
        //   639: goto -612 -> 27
        //   642: aload_0
        //   643: getfield 21	com/getjar/sdk/comm/TransactionManager$13:val$commContext	Lcom/getjar/sdk/comm/CommContext;
        //   646: invokevirtual 42	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
        //   649: invokestatic 48	com/getjar/sdk/rewards/InAppPurchaseManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/rewards/InAppPurchaseManager;
        //   652: aload 5
        //   654: getstatic 255	com/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure:NETWORK_ERROR	Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;
        //   657: aload_0
        //   658: getfield 19	com/getjar/sdk/comm/TransactionManager$13:this$0	Lcom/getjar/sdk/comm/TransactionManager;
        //   661: invokestatic 73	com/getjar/sdk/comm/TransactionManager:access$600	(Lcom/getjar/sdk/comm/TransactionManager;)Landroid/content/Context;
        //   664: invokevirtual 181	com/getjar/sdk/rewards/InAppPurchaseManager:handleFailure	(Ljava/lang/String;Lcom/getjar/sdk/rewards/InAppPurchaseManager$InAppBillingFailure;Landroid/content/Context;)V
        //   667: goto -640 -> 27
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	670	0	this	13
        //   122	131	1	localObject1	Object
        //   305	33	1	localInterruptedException	InterruptedException
        //   350	8	1	localException	Exception
        //   406	42	1	localObject2	Object
        //   528	35	1	localIntent	Intent
        //   569	33	1	localExecutionException	ExecutionException
        //   78	46	2	str1	String
        //   3	405	3	localObject3	Object
        //   25	13	4	localIterator	Iterator
        //   71	582	5	str2	String
        //   64	478	6	localHashMap	HashMap
        //   47	433	7	localGooglePurchaseResponse	com.getjar.sdk.data.GooglePurchaseResponse
        // Exception table:
        //   from	to	target	type
        //   243	248	305	java/lang/InterruptedException
        //   252	302	305	java/lang/InterruptedException
        //   447	566	305	java/lang/InterruptedException
        //   614	639	305	java/lang/InterruptedException
        //   642	667	305	java/lang/InterruptedException
        //   6	27	350	java/lang/Exception
        //   27	121	350	java/lang/Exception
        //   123	180	350	java/lang/Exception
        //   180	209	350	java/lang/Exception
        //   209	243	350	java/lang/Exception
        //   243	248	350	java/lang/Exception
        //   252	302	350	java/lang/Exception
        //   306	347	350	java/lang/Exception
        //   370	403	350	java/lang/Exception
        //   411	444	350	java/lang/Exception
        //   447	566	350	java/lang/Exception
        //   570	611	350	java/lang/Exception
        //   614	639	350	java/lang/Exception
        //   642	667	350	java/lang/Exception
        //   6	27	406	finally
        //   27	121	406	finally
        //   123	180	406	finally
        //   180	209	406	finally
        //   209	243	406	finally
        //   243	248	406	finally
        //   252	302	406	finally
        //   306	347	406	finally
        //   351	367	406	finally
        //   367	369	406	finally
        //   370	403	406	finally
        //   407	409	406	finally
        //   411	444	406	finally
        //   447	566	406	finally
        //   570	611	406	finally
        //   614	639	406	finally
        //   642	667	406	finally
        //   243	248	569	java/util/concurrent/ExecutionException
        //   252	302	569	java/util/concurrent/ExecutionException
        //   447	566	569	java/util/concurrent/ExecutionException
        //   614	639	569	java/util/concurrent/ExecutionException
        //   642	667	569	java/util/concurrent/ExecutionException
      }
    }).start();
  }
  
  public void cancelManagedOfferTransaction(String paramString, CommContext paramCommContext)
  {
    synchronized (_ManagedOfferTransactionStateLock)
    {
      Logger.v(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: cancelManagedPurchaseTransaction() [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      TransactionBucket localTransactionBucket = DBTransactions.getInstance(this._applicationContext).loadTransaction(paramString);
      if ((localTransactionBucket != null) && (DBTransactions.TransactionType.MANAGED_OFFER.equals(localTransactionBucket.getType())))
      {
        DBTransactions.ManagedOfferState localManagedOfferState = ((ManagedOfferBucket)localTransactionBucket).getState();
        if ((DBTransactions.ManagedOfferState.CREATED.equals(localManagedOfferState)) || (DBTransactions.ManagedOfferState.RESERVING.equals(localManagedOfferState)) || (DBTransactions.ManagedOfferState.RESERVED.equals(localManagedOfferState)) || (DBTransactions.ManagedOfferState.PURCHASING.equals(localManagedOfferState)))
        {
          Logger.v(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: Transaction %1$s was found and is in the %2$s state, cancelling...", new Object[] { paramString, localManagedOfferState.name() });
          if (!_CanceledClientTransactionIDs.contains(paramString)) {
            _CanceledClientTransactionIDs.add(paramString);
          }
          Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: cancelManagedOfferTransaction() CANCELING [clientTransactionId: %1$s] [%2$s]", new Object[] { localTransactionBucket.getClientTransactionId(), Logger.getShortStack() });
          DBTransactions.getInstance(this._applicationContext).updateManagedOfferTransaction((ManagedOfferBucket)localTransactionBucket, DBTransactions.ManagedOfferState.CANCELING);
          runTransactions(paramCommContext, false, false);
        }
      }
      return;
    }
  }
  
  public void cancelPurchaseTransaction(String paramString, CommContext paramCommContext)
  {
    synchronized (_PurchaseTransactionStateLock)
    {
      Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: cancelPurchaseTransaction() [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
      TransactionBucket localTransactionBucket = DBTransactions.getInstance(this._applicationContext).loadTransaction(paramString);
      if ((localTransactionBucket != null) && (DBTransactions.TransactionType.PURCHASE.equals(localTransactionBucket.getType())))
      {
        DBTransactions.PurchaseState localPurchaseState = ((PurchaseUnmanagedBucket)localTransactionBucket).getState();
        if ((DBTransactions.PurchaseState.CREATED.equals(localPurchaseState)) || (DBTransactions.PurchaseState.RESERVING.equals(localPurchaseState)) || (DBTransactions.PurchaseState.CANCELING.equals(localPurchaseState)))
        {
          Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: Transaction %1$s was found and is in the %2$s state, cancelling...", new Object[] { paramString, localPurchaseState.name() });
          if (!_CanceledClientTransactionIDs.contains(paramString)) {
            _CanceledClientTransactionIDs.add(paramString);
          }
          DBTransactions.getInstance(this._applicationContext).updatePurchaseTransaction((PurchaseUnmanagedBucket)localTransactionBucket, DBTransactions.PurchaseState.CANCELING);
          runTransactions(paramCommContext, false, false);
        }
      }
      return;
    }
  }
  
  public void recoverOrphanedTransactions(CommContext paramCommContext)
  {
    int i;
    int m;
    for (;;)
    {
      int j;
      try
      {
        Logger.v(Area.TRANSACTION.value(), "TransactionManager: recoverOrphanedTransactions() [thread: %1$d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        try
        {
          buyCurrencyForGoogleTransactions(paramCommContext);
          i = 0;
          Object localObject = DBTransactions.getInstance(this._applicationContext).loadAllTransactions();
          m = ((List)localObject).size();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          TransactionBucket localTransactionBucket = (TransactionBucket)((Iterator)localObject).next();
          k = i;
          try
          {
            long l1 = System.currentTimeMillis();
            k = i;
            long l2 = l1 - localTransactionBucket.getTimestampLastUpdated();
            k = i;
            Logger.v(Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: recoverOrphanedTransactions() Transaction found in persistence [now:%1$d - lastUpdate:%2$d = age:%3$d]", new Object[] { Long.valueOf(l1), Long.valueOf(localTransactionBucket.getTimestampLastUpdated()), Long.valueOf(l2) });
            if (l2 <= 300000L) {
              continue;
            }
            j = i + 1;
            i = j;
            k = j;
            if (!DBTransactions.TransactionType.PURCHASE.equals(localTransactionBucket.getType())) {
              continue;
            }
            k = j;
            if (!DBTransactions.PurchaseState.CREATED.equals(((PurchaseUnmanagedBucket)localTransactionBucket).getState())) {
              break label384;
            }
            k = j;
            Logger.d(Area.TRANSACTION.value() | Area.STORAGE.value() | Area.PURCHASE.value(), "TransactionManager: Orphaned purchase found in the CREATED state, deleting [clientTransactionId: %1$s]", new Object[] { localTransactionBucket.getClientTransactionId() });
            k = j;
            DBTransactions.getInstance(this._applicationContext).deleteTransaction(localTransactionBucket.getClientTransactionId());
            i = j;
          }
          catch (Exception localException3)
          {
            if (localTransactionBucket == null) {
              break label481;
            }
          }
          try
          {
            Logger.e(Area.TRANSACTION.value() | Area.STORAGE.value(), localException3, "TransactionManager persistence cleanup failed for transaction %1$s [created:%2$d updated:%3$d]", new Object[] { localTransactionBucket.getClientTransactionId(), Long.valueOf(localTransactionBucket.getTimestampCreated()), Long.valueOf(localTransactionBucket.getTimestampLastUpdated()) });
            i = k;
          }
          catch (Exception localException2)
          {
            i = k;
          }
          continue;
        }
        catch (Exception localException1)
        {
          Logger.e(Area.TRANSACTION.value(), localException1, "TransactionManager: recoverOrphanedTransactions() buyCurrencyForGoogleTransactions() failed", new Object[0]);
          continue;
        }
        i = j;
      }
      finally {}
      label384:
      int k = j;
      if (DBTransactions.PurchaseState.RESERVING.equals(((PurchaseUnmanagedBucket)localException2).getState()))
      {
        k = j;
        Logger.d(Area.LICENSING.value() | Area.TRANSACTION.value() | Area.STORAGE.value() | Area.PURCHASE.value(), "TransactionManager: Orphaned purchase found in the RESERVING state, updating to CANCELING [clientTransactionId: %1$s]", new Object[] { localException2.getClientTransactionId() });
        k = j;
        DBTransactions.getInstance(this._applicationContext).updatePurchaseTransaction((PurchaseUnmanagedBucket)localException2, DBTransactions.PurchaseState.CANCELING);
        i = j;
        continue;
        label481:
        Logger.e(Area.TRANSACTION.value() | Area.STORAGE.value(), localException3, "TransactionManager persistence cleanup failed for a transaction", new Object[0]);
        i = k;
      }
    }
    Logger.d(Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: Found %1$d total transactions and %2$d orphaned purchase transactions", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
    if (i > 0) {
      runTransactions(paramCommContext, false, true);
    }
    for (;;)
    {
      return;
      if (m > 0) {
        runTransactions(paramCommContext, true, true);
      }
    }
  }
  
  public Future<Operation> runConfirmVoucherTransaction(final CommContext paramCommContext, final String paramString1, String paramString2)
    throws IOException
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'clientTransactionId' cannot both be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'voucherToken' cannot both be NULL or empty");
    }
    Logger.v(Area.REDEEM.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runConfirmVoucherTransaction() [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString1, Long.valueOf(Thread.currentThread().getId()) });
    try
    {
      DBTransactions.getInstance(this._applicationContext).insertConfirmVoucherTransaction(paramString1, new RelatedConfirmVoucherData(paramString2));
      paramString1 = new SetExceptionFutureTask(new Callable()
      {
        public Operation call()
          throws Exception
        {
          try
          {
            synchronized (TransactionManager._TransactionFlowLock)
            {
              Object localObject2 = (ConfirmVoucherBucket)DBTransactions.getInstance(TransactionManager.this._applicationContext).loadTransaction(paramString1);
              localObject2 = TransactionManager.this.runConfirmVoucherTransaction((ConfirmVoucherBucket)localObject2, paramCommContext, true);
              return (Operation)localObject2;
            }
            return null;
          }
          catch (Exception localException)
          {
            Logger.e(Area.REDEEM.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runConfirmVoucherTransaction() failed", new Object[0]);
          }
        }
      });
      _ExecutorService.execute(paramString1);
      _ExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            TransactionManager.this.runTransactions(paramCommContext, true, false);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runConfirmVoucherTransaction() failed", new Object[0]);
          }
        }
      });
      return paramString1;
    }
    catch (IllegalStateException paramString2)
    {
      for (;;) {}
    }
  }
  
  public Future<Operation> runEarnTransaction(String paramString1, final CommContext paramCommContext, String paramString2, String paramString3, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
    throws IOException
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'clientTransactionId' can not be NULL or empty");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'itemId' can not be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'packageName' can not be NULL or empty");
    }
    if ((paramHashMap1 == null) || (paramHashMap1.size() <= 0)) {
      throw new IllegalArgumentException("'itemMetadata' can not be NULL or empty");
    }
    Logger.v(Area.EARN.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: startEarnTransaction() [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString1, Long.valueOf(Thread.currentThread().getId()) });
    paramString2 = new RelatedEarnData(paramString2, paramString3, paramHashMap1, paramHashMap2);
    try
    {
      DBTransactions.getInstance(this._applicationContext).insertEarnTransaction(paramString1, paramString2);
      paramString1 = new SetExceptionFutureTask(new Callable()
      {
        public Operation call()
          throws Exception
        {
          try
          {
            synchronized (TransactionManager._TransactionFlowLock)
            {
              Object localObject2 = new TransactionManager.EarnCallback(TransactionManager.this, (EarnBucket)this.val$transaction, (RelatedEarnData)this.val$transaction.getRelatedObject());
              localObject2 = TransactionManager.this.runEarnTransaction((EarnBucket)this.val$transaction, paramCommContext, (CallbackInterface)localObject2, false);
              return (Operation)localObject2;
            }
            return null;
          }
          catch (Exception localException)
          {
            Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runEarnTransactions() failed", new Object[0]);
          }
        }
      });
      _ExecutorService.execute(paramString1);
      _ExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            TransactionManager.this.runTransactions(paramCommContext, true, false);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runEarnTransactions() failed", new Object[0]);
          }
        }
      });
      return paramString1;
    }
    catch (IllegalStateException paramString2)
    {
      for (;;) {}
    }
  }
  
  public Future<Operation> runGrantGetjarPassTransaction(final CommContext paramCommContext, final String paramString1, final String paramString2, HashMap<String, String> paramHashMap)
    throws IOException
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    if ((StringUtility.isNullOrEmpty(paramString1)) && (StringUtility.isNullOrEmpty(paramString2))) {
      throw new IllegalArgumentException("'currentClientTransactionId' and 'clientTransactionIdFromGoogle' cannot both be NULL or empty");
    }
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      throw new IllegalArgumentException("'purchaseMetadata' cannot be NULL or empty");
    }
    Logger.v(Area.GETJAR_PASS.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runGrantGetjarPassTransaction() [currentClientTransactionId: %1$s] [clientTransactionIdFromGoogle: %2$s] [thread: %3$d]", new Object[] { paramString1, paramString2, Long.valueOf(Thread.currentThread().getId()) });
    for (;;)
    {
      try
      {
        DBTransactions localDBTransactions = DBTransactions.getInstance(this._applicationContext);
        if (!StringUtility.isNullOrEmpty(paramString1)) {
          continue;
        }
        str = paramString2;
        localDBTransactions.insertGrantGetjarPassTransaction(str, new RelatedGrantGetjarPassData(paramHashMap));
      }
      catch (IllegalStateException paramHashMap)
      {
        String str;
        continue;
      }
      paramString1 = new SetExceptionFutureTask(new Callable()
      {
        public Operation call()
          throws Exception
        {
          try
          {
            synchronized (TransactionManager._TransactionFlowLock)
            {
              Operation localOperation = TransactionManager.this.runGrantGetjarPassTransaction(paramString1, paramString2, paramCommContext, false);
              return localOperation;
            }
            return null;
          }
          catch (Exception localException)
          {
            Logger.e(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runGrantGetjarPassTransaction() failed", new Object[0]);
          }
        }
      });
      _ExecutorService.execute(paramString1);
      _ExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            TransactionManager.this.runTransactions(paramCommContext, true, false);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.GETJAR_PASS.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runGrantGetjarPassTransaction() failed", new Object[0]);
          }
        }
      });
      return paramString1;
      str = paramString1;
    }
  }
  
  public Future<DBTransactions.ManagedOfferState> runManagedOfferTransaction(final String paramString, final CommContext paramCommContext)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'clientTransactionId' can not be NULL or empty");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    Logger.v(Area.OFFER.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: runManagedOfferTransaction() [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = new SetExceptionFutureTask(new Callable()
    {
      public DBTransactions.ManagedOfferState call()
        throws Exception
      {
        DBTransactions.ManagedOfferState localManagedOfferState = null;
        try
        {
          TransactionManager.this.runManagedOfferTransaction(paramString, paramCommContext, false);
          TransactionBucket localTransactionBucket = DBTransactions.getInstance(TransactionManager.this._applicationContext).loadTransaction(paramString);
          if (localTransactionBucket != null) {
            localManagedOfferState = ((ManagedOfferBucket)localTransactionBucket).getState();
          }
          return localManagedOfferState;
        }
        catch (Exception localException)
        {
          Logger.e(Area.OFFER.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runManagedOfferTransaction() failed", new Object[0]);
        }
        return null;
      }
    });
    _ExecutorService.execute(paramString);
    return paramString;
  }
  
  public List<TransactionBucket> runTransactionsBlocking(CommContext paramCommContext)
  {
    paramCommContext = runTransactions(paramCommContext, true, false);
    try
    {
      paramCommContext = (List)paramCommContext.get();
      return paramCommContext;
    }
    catch (InterruptedException paramCommContext)
    {
      throw new TransactionException(paramCommContext);
    }
    catch (ExecutionException paramCommContext)
    {
      throw new TransactionException(paramCommContext);
    }
  }
  
  public Future<Operation> startManagedOfferTransaction(final CommContext paramCommContext, final String paramString1, String paramString2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
  {
    AuthManager.initialize(paramCommContext.getApplicationContext());
    if (AuthManager.getInstance().getClaimsManager(paramCommContext.getApplicationContext()).canPurchaseManagedProducts()) {
      paramString2 = new RelatedManagedOfferData(paramString2, paramHashMap1, paramHashMap2);
    }
    try
    {
      DBTransactions.getInstance(paramCommContext.getApplicationContext()).insertManagedOfferTransaction(paramString1, paramString2, DBTransactions.ManagedOfferState.CREATED);
      paramString2 = new SetExceptionFutureTask(new Callable()
      {
        public Operation call()
          throws Exception
        {
          try
          {
            synchronized (TransactionManager._TransactionFlowLock)
            {
              Operation localOperation = TransactionManager.this.runManagedOfferTransaction(paramString1, paramCommContext, false);
              return localOperation;
            }
            return null;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OFFER.value() | Area.TRANSACTION.value(), localException, "TransactionManager: startManagedOfferTransaction() failed", new Object[0]);
          }
        }
      });
      _ExecutorService.execute(paramString2);
      _ExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            TransactionManager.this.runTransactions(paramCommContext, false, false);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OFFER.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runTransactions() failed", new Object[0]);
          }
        }
      });
      Logger.v(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager: startManagedOfferTransaction() [clientTransactionId: %1$s] [thread: %2$d] finished", new Object[] { paramString1, Long.valueOf(Thread.currentThread().getId()) });
      return paramString2;
    }
    catch (IOException paramCommContext)
    {
      Logger.e(Area.OFFER.value() | Area.TRANSACTION.value(), paramCommContext, "Error occured while creating transaction", new Object[0]);
      return null;
      Logger.w(Area.OFFER.value() | Area.TRANSACTION.value(), "TransactionManager startManagedOfferTransaction: Does not have valid claim(s) to purchase managed offer", new Object[0]);
      return null;
    }
    catch (IllegalStateException paramString2)
    {
      for (;;) {}
    }
  }
  
  public Future<Operation> startPurchaseTransaction(String paramString1, final CommContext paramCommContext, String paramString2, String paramString3, String paramString4, Integer paramInteger, GetjarLicense.Scope paramScope, HashMap<String, String> paramHashMap)
    throws IOException
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'clientTransactionId' can not be NULL or empty");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'productId' can not be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'productName' can not be NULL or empty");
    }
    if ((paramInteger == null) || (paramInteger.intValue() < 0)) {
      throw new IllegalArgumentException("'amount' can not be NULL or less than 0");
    }
    Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value() | Area.STORAGE.value(), "TransactionManager: startPurchaseTransaction() [clientTransactionId: %1$s] [thread: %2$d]", new Object[] { paramString1, Long.valueOf(Thread.currentThread().getId()) });
    paramString2 = new RelatedPurchaseData(paramString2, paramString3, paramString4, paramInteger.intValue(), paramScope, paramHashMap);
    try
    {
      DBTransactions.getInstance(this._applicationContext).insertPurchaseTransaction(paramString1, paramString2);
      paramString2 = new SetExceptionFutureTask(new Callable()
      {
        public Operation call()
          throws Exception
        {
          try
          {
            synchronized (TransactionManager._TransactionFlowLock)
            {
              Operation localOperation = TransactionManager.this.runPurchaseTransaction((PurchaseUnmanagedBucket)this.val$transaction, paramCommContext, false);
              return localOperation;
            }
            return null;
          }
          catch (Exception localException)
          {
            Logger.e(Area.PURCHASE.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runPurchaseTransaction() failed", new Object[0]);
          }
        }
      });
      _ExecutorService.execute(paramString2);
      _ExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            TransactionManager.this.runTransactions(paramCommContext, false, false);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.PURCHASE.value() | Area.TRANSACTION.value(), localException, "TransactionManager: runTransactions() failed", new Object[0]);
          }
        }
      });
      Logger.v(Area.PURCHASE.value() | Area.TRANSACTION.value(), "TransactionManager: startPurchaseTransaction() [clientTransactionId: %1$s] [thread: %2$d] finished", new Object[] { paramString1, Long.valueOf(Thread.currentThread().getId()) });
      return paramString2;
    }
    catch (IllegalStateException paramString2)
    {
      for (;;) {}
    }
  }
  
  private class EarnCallback
    implements CallbackInterface
  {
    private EarnBucket _earnBucket = null;
    private RelatedEarnData _earnData = null;
    
    public EarnCallback(EarnBucket paramEarnBucket, RelatedEarnData paramRelatedEarnData)
    {
      if (paramRelatedEarnData == null) {
        throw new IllegalArgumentException("'earn' can not be NULL");
      }
      if (paramEarnBucket == null) {
        throw new IllegalArgumentException("'earnBucket' can not be NULL");
      }
      if (StringUtility.isNullOrEmpty(paramEarnBucket.getClientTransactionId())) {
        throw new IllegalArgumentException("'earnBucket.getClientTransactionId()' can not be NULL or empty");
      }
      this._earnData = paramRelatedEarnData;
      this._earnBucket = paramEarnBucket;
    }
    
    private void updateEarnStateInAppStatePersistence(CommContext paramCommContext, String paramString, Result paramResult, EarnStateDatabase.EarnState paramEarnState)
    {
      if (paramResult == null) {
        return;
      }
      paramResult = TransactionManager.getTransactionSubstate(paramResult, "NONE");
      EarnStateDatabase.getInstance(paramCommContext.getApplicationContext()).updateEarnState(paramString, paramEarnState, paramResult);
    }
    
    public void serviceRequestFailed(Result paramResult, Exception paramException, String paramString, CommContext paramCommContext)
    {
      Logger.d(Area.TRANSACTION.value() | Area.EARN.value(), "TransactionManager: EarnCallback: request failed [clientTransactionId: %1$s]", new Object[] { this._earnBucket.getClientTransactionId() });
      paramString = paramCommContext.getApplicationContext().getPackageManager();
      paramResult = this._earnData.getPackageName();
      try
      {
        paramString = (String)paramString.getPackageInfo(this._earnData.getPackageName(), 128).applicationInfo.loadLabel(paramString);
        paramResult = paramString;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        for (;;)
        {
          Logger.e(Area.TRANSACTION.value() | Area.EARN.value(), paramString, "Package info not found", new Object[0]);
        }
      }
      if ((DBTransactions.NotificationState.NONE.equals(this._earnBucket.getNotificationState())) && (!this._earnData.getPackageName().equals("com.getjar.rewards")))
      {
        if (!"none".equals(this._earnData.getTrackingMetadata().get("earn.currency_key"))) {
          NotificationsUtility.pushEarnFailNotification(paramCommContext, String.format(Locale.US, "Thank you for installing %1$s! Nothing was earned.", new Object[] { paramResult }), null);
        }
        DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateEarnTransactionNotificationState(this._earnBucket, DBTransactions.NotificationState.NO_GOLD);
      }
      if ((paramException != null) && (ServiceException.class.isAssignableFrom(paramException.getClass()))) {
        updateEarnStateInAppStatePersistence(paramCommContext, this._earnData.getPackageName(), ((ServiceException)paramException).getRequestResult(), EarnStateDatabase.EarnState.FAIL);
      }
    }
    
    public void serviceRequestRetry(Exception paramException, String paramString, CommContext paramCommContext, int paramInt)
    {
      Logger.d(Area.TRANSACTION.value() | Area.EARN.value(), "TransactionManager: EarnCallback: retrying request [clientTransactionId: %1$s]", new Object[] { this._earnBucket.getClientTransactionId() });
    }
    
    public void serviceRequestSucceeded(Result paramResult, String paramString, CommContext paramCommContext)
    {
      Logger.d(Area.TRANSACTION.value() | Area.EARN.value(), "TransactionManager: EarnCallback: request succeeded [clientTransactionId: %1$s]", new Object[] { this._earnBucket.getClientTransactionId() });
      localEarnInfo = EarnUtility.getEarnInfo(paramResult);
      Logger.d(Area.TRANSACTION.value() | Area.EARN.value(), "TransactionManager: EarnCallback: [%1$s]", new Object[] { localEarnInfo.toString() });
      str4 = TransactionManager.getTransactionState(paramResult, "");
      str5 = TransactionManager.getTransactionSubstate(paramResult, Constants.RequestInstallSubState.NONE.toString());
      l = EarnUtility.getResponseAmount(paramResult, -1L);
      str1 = this._earnData.getPackageName();
      try
      {
        paramString = paramCommContext.getApplicationContext().getPackageManager();
        paramString = (String)paramString.getPackageInfo(this._earnData.getPackageName(), 128).applicationInfo.loadLabel(paramString);
        str1 = paramString;
      }
      catch (Exception paramString)
      {
        String str3;
        for (;;) {}
      }
      str3 = paramCommContext.getApplicationContext().getPackageName();
      paramString = str3;
      try
      {
        Object localObject = paramCommContext.getApplicationContext().getPackageManager();
        localObject = (String)((PackageManager)localObject).getPackageInfo(paramCommContext.getApplicationContext().getPackageName(), 128).applicationInfo.loadLabel((PackageManager)localObject);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          int k;
          int i;
          boolean bool2;
          boolean bool1;
          Logger.e(Area.TRANSACTION.value() | Area.EARN.value(), localException, "TransactionManager: EarnCallback: Failed to get the name of the Hosting Application", new Object[0]);
          continue;
          if ((("ALREADY_REDEEMED_FAILURE".equalsIgnoreCase(str5)) || ("ALREADY_USED_FAILURE".equalsIgnoreCase(str5))) && (!this._earnData.getPackageName().equals("com.getjar.rewards")))
          {
            if ((!DBTransactions.NotificationState.SUCCEEDED.equals(this._earnBucket.getNotificationState())) && (!DBTransactions.NotificationState.FAILED.equals(this._earnBucket.getNotificationState())))
            {
              if (!"none".equals(this._earnData.getTrackingMetadata().get("earn.currency_key"))) {
                NotificationsUtility.pushEarnFailNotification(paramCommContext, String.format(Locale.US, "Thank you for installing %1$s again. Nothing was earned.", new Object[] { str1 }), localEarnInfo);
              }
              DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateEarnTransactionNotificationState(this._earnBucket, DBTransactions.NotificationState.FAILED);
            }
            updateEarnStateInAppStatePersistence(paramCommContext, this._earnData.getPackageName(), paramResult, EarnStateDatabase.EarnState.FAIL);
          }
          else if (l >= 0L)
          {
            if (StringUtility.isNullOrEmpty(paramString)) {}
            for (paramString = String.format(Locale.US, "You've earned %1$s!", new Object[] { localEarnInfo.getCurrencyDisplayAmount() });; paramString = String.format(Locale.US, "%1$s earned via %2$s!", new Object[] { localEarnInfo.getCurrencyDisplayAmount(), paramString }))
            {
              str2 = paramString;
              if (!this._earnBucket.getIsNewTransaction()) {
                str2 = String.format(Locale.US, "%1$s %2$s", new Object[] { paramString, "Thanks for your patience!" });
              }
              if ((!DBTransactions.NotificationState.SUCCEEDED.equals(this._earnBucket.getNotificationState())) && (!DBTransactions.NotificationState.FAILED.equals(this._earnBucket.getNotificationState())))
              {
                if (!"none".equals(this._earnData.getTrackingMetadata().get("earn.currency_key"))) {
                  NotificationsUtility.pushEarnSuccessNotification(paramCommContext, str2, localEarnInfo);
                }
                DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateEarnTransactionNotificationState(this._earnBucket, DBTransactions.NotificationState.SUCCEEDED);
                GetJarWebViewSubActivity.updateUIWithEarnResults(str4, str5, str1, l, str3, null);
              }
              updateEarnStateInAppStatePersistence(paramCommContext, this._earnData.getPackageName(), paramResult, EarnStateDatabase.EarnState.SUCCESS);
              EarnStateDatabase.getInstance(paramCommContext.getApplicationContext()).updateEarnAmount(this._earnData.getPackageName(), l);
              break;
            }
            paramResult = new Intent();
          }
        }
      }
      Logger.d(Area.TRANSACTION.value() | Area.EARN.value(), "TransactionManager: EarnCallback: Pushing Earn notification [amount: %1$d] [state: %2$s] [substate: %3$s]", new Object[] { Long.valueOf(l), str4, str5 });
      if (("CAP_REACHED_FAILURE".equalsIgnoreCase(str5)) && (!this._earnData.getPackageName().equals("com.getjar.rewards")))
      {
        if ((!DBTransactions.NotificationState.SUCCEEDED.equals(this._earnBucket.getNotificationState())) && (!DBTransactions.NotificationState.FAILED.equals(this._earnBucket.getNotificationState())))
        {
          if (!"none".equals(this._earnData.getTrackingMetadata().get("earn.currency_key"))) {
            NotificationsUtility.pushEarnFailNotification(paramCommContext, String.format(Locale.US, "Thank you for installing %1$s. Free earn limit reached.", new Object[] { str1 }), localEarnInfo);
          }
          DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateEarnTransactionNotificationState(this._earnBucket, DBTransactions.NotificationState.FAILED);
        }
        updateEarnStateInAppStatePersistence(paramCommContext, this._earnData.getPackageName(), paramResult, EarnStateDatabase.EarnState.FAIL);
        j = 0;
        k = 0;
        i = 0;
        bool2 = false;
        if (StringUtility.isNullOrEmpty(localEarnInfo.getVoucherToken()))
        {
          bool1 = bool2;
          if (!"none".equals(localEarnInfo.getCurrencyKey())) {}
        }
        else
        {
          if (StringUtility.isNullOrEmpty(localEarnInfo.getVoucherToken())) {
            break label1078;
          }
          paramResult = IntentsUtility.getRedeemVoucherIntent(paramCommContext.getApplicationContext(), localEarnInfo.getVoucherToken());
          Logger.d(Area.TRANSACTION.value() | Area.EARN.value(), "TransactionManager: EarnCallback: Earn result Intent created", new Object[0]);
          if (GetJarWebViewSubActivity.getInstance() != null) {
            i = k;
          }
        }
      }
      try
      {
        GetJarWebViewSubActivity.getInstance().setResultAndClose(paramResult);
        i = 1;
        j = 1;
        Logger.d(Area.TRANSACTION.value() | Area.EARN.value(), "TransactionManager: EarnCallback: GetJarWebViewSubActivity.getInstance().setResultAndClose() called", new Object[0]);
        i = j;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          String str2;
          Logger.e(Area.TRANSACTION.value() | Area.EARN.value(), paramString, "TransactionManager: EarnCallback: GetJarWebViewSubActivity.getInstance().setResultAndClose() failed", new Object[0]);
        }
      }
      bool1 = bool2;
      j = i;
      if (i == 0)
      {
        bool1 = CommManager.sendIntentToFirstRegisteredGetjarClient(paramResult);
        j = i;
      }
      if ((j == 0) && (!bool1) && (!DBTransactions.NotificationState.FAILED.equals(this._earnBucket.getNotificationState())) && (!DBTransactions.NotificationState.NO_GOLD.equals(this._earnBucket.getNotificationState())) && (!DBTransactions.NotificationState.SUCCEEDED.equals(this._earnBucket.getNotificationState())))
      {
        if (!"none".equals(this._earnData.getTrackingMetadata().get("earn.currency_key"))) {
          NotificationsUtility.pushEarnFailNotification(paramCommContext, String.format(Locale.US, "Thank you for installing %1$s! Nothing was earned.", new Object[] { str1 }), localEarnInfo);
        }
        DBTransactions.getInstance(paramCommContext.getApplicationContext()).updateEarnTransactionNotificationState(this._earnBucket, DBTransactions.NotificationState.NO_GOLD);
        GetJarWebViewSubActivity.updateUIWithEarnResults(str4, str5, str1, l, str3, null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/TransactionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */