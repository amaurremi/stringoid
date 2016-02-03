package com.bubble.in.app.billing.helper;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper
{
  public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
  public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
  public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
  public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
  public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
  public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
  public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
  public static final int IABHELPER_BAD_RESPONSE = -1002;
  public static final int IABHELPER_ERROR_BASE = -1000;
  public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
  public static final int IABHELPER_MISSING_TOKEN = -1007;
  public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
  public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
  public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
  public static final int IABHELPER_UNKNOWN_ERROR = -1008;
  public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
  public static final int IABHELPER_USER_CANCELLED = -1005;
  public static final int IABHELPER_VERIFICATION_FAILED = -1003;
  public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
  public static final String ITEM_TYPE_INAPP = "inapp";
  public static final String ITEM_TYPE_SUBS = "subs";
  public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
  public static final String RESPONSE_CODE = "RESPONSE_CODE";
  public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
  public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
  public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
  public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
  boolean mAsyncInProgress = false;
  String mAsyncOperation = "";
  Context mContext;
  boolean mDebugLog = false;
  String mDebugTag = "IabHelper";
  boolean mDisposed = false;
  OnIabPurchaseFinishedListener mPurchaseListener;
  String mPurchasingItemType;
  int mRequestCode;
  IInAppBillingService mService;
  ServiceConnection mServiceConn;
  boolean mSetupDone = false;
  String mSignatureBase64 = null;
  boolean mSubscriptionsSupported = false;
  
  public IabHelper(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mSignatureBase64 = paramString;
    logDebug("IAB helper created.");
  }
  
  private void checkNotDisposed()
  {
    if (this.mDisposed) {
      throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }
  }
  
  public static String getResponseDesc(int paramInt)
  {
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= 64536)
    {
      int i = 64536 - paramInt;
      if ((i >= 0) && (i < arrayOfString2.length)) {
        return arrayOfString2[i];
      }
      return String.valueOf(paramInt) + ":Unknown IAB Helper Error";
    }
    if ((paramInt < 0) || (paramInt >= arrayOfString1.length)) {
      return String.valueOf(paramInt) + ":Unknown";
    }
    return arrayOfString1[paramInt];
  }
  
  void checkSetupDone(String paramString)
  {
    if (!this.mSetupDone)
    {
      logError("Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + paramString);
    }
  }
  
  void consume(Purchase paramPurchase)
    throws IabException
  {
    checkNotDisposed();
    checkSetupDone("consume");
    if (!paramPurchase.mItemType.equals("inapp")) {
      throw new IabException(64526, "Items of type '" + paramPurchase.mItemType + "' can't be consumed.");
    }
    String str2;
    try
    {
      String str1 = paramPurchase.getToken();
      str2 = paramPurchase.getSku();
      if ((str1 == null) || (str1.equals("")))
      {
        logError("Can't consume " + str2 + ". No token.");
        throw new IabException(64529, "PurchaseInfo is missing token for sku: " + str2 + " " + paramPurchase);
      }
    }
    catch (RemoteException localRemoteException)
    {
      throw new IabException(64535, "Remote exception while consuming. PurchaseInfo: " + paramPurchase, localRemoteException);
    }
    logDebug("Consuming sku: " + str2 + ", token: " + localRemoteException);
    int i = this.mService.consumePurchase(3, this.mContext.getPackageName(), localRemoteException);
    if (i == 0)
    {
      logDebug("Successfully consumed sku: " + str2);
      return;
    }
    logDebug("Error consuming consuming sku " + str2 + ". " + getResponseDesc(i));
    throw new IabException(i, "Error consuming sku " + str2);
  }
  
  public void consumeAsync(Purchase paramPurchase, OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    checkNotDisposed();
    checkSetupDone("consume");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPurchase);
    consumeAsyncInternal(localArrayList, paramOnConsumeFinishedListener, null);
  }
  
  public void consumeAsync(List<Purchase> paramList, OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    checkNotDisposed();
    checkSetupDone("consume");
    consumeAsyncInternal(paramList, null, paramOnConsumeMultiFinishedListener);
  }
  
  void consumeAsyncInternal(final List<Purchase> paramList, final OnConsumeFinishedListener paramOnConsumeFinishedListener, final OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    final Handler localHandler = new Handler();
    flagStartAsync("consume");
    new Thread(new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Purchase localPurchase = (Purchase)localIterator.next();
          try
          {
            IabHelper.this.consume(localPurchase);
            localArrayList.add(new IabResult(0, "Successful consume of sku " + localPurchase.getSku()));
          }
          catch (IabException localIabException)
          {
            localArrayList.add(localIabException.getResult());
          }
        }
        IabHelper.this.flagEndAsync();
        if ((!IabHelper.this.mDisposed) && (paramOnConsumeFinishedListener != null)) {
          localHandler.post(new Runnable()
          {
            public void run()
            {
              IabHelper.3.this.val$singleListener.onConsumeFinished((Purchase)IabHelper.3.this.val$purchases.get(0), (IabResult)localArrayList.get(0));
            }
          });
        }
        if ((!IabHelper.this.mDisposed) && (paramOnConsumeMultiFinishedListener != null)) {
          localHandler.post(new Runnable()
          {
            public void run()
            {
              IabHelper.3.this.val$multiListener.onConsumeMultiFinished(IabHelper.3.this.val$purchases, localArrayList);
            }
          });
        }
      }
    }).start();
  }
  
  public void dispose()
  {
    logDebug("Disposing.");
    this.mSetupDone = false;
    if (this.mServiceConn != null)
    {
      logDebug("Unbinding from service.");
      if (this.mContext != null) {
        this.mContext.unbindService(this.mServiceConn);
      }
    }
    this.mDisposed = true;
    this.mContext = null;
    this.mServiceConn = null;
    this.mService = null;
    this.mPurchaseListener = null;
  }
  
  public void enableDebugLogging(boolean paramBoolean)
  {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
  }
  
  public void enableDebugLogging(boolean paramBoolean, String paramString)
  {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
    this.mDebugTag = paramString;
  }
  
  public void flagEndAsync()
  {
    logDebug("Ending async operation: " + this.mAsyncOperation);
    this.mAsyncOperation = "";
    this.mAsyncInProgress = false;
  }
  
  void flagStartAsync(String paramString)
  {
    if (this.mAsyncInProgress) {
      throw new IllegalStateException("Can't start async operation (" + paramString + ") because another async operation(" + this.mAsyncOperation + ") is in progress.");
    }
    this.mAsyncOperation = paramString;
    this.mAsyncInProgress = true;
    logDebug("Starting async operation: " + paramString);
  }
  
  int getResponseCodeFromBundle(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      logDebug("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    logError("Unexpected type for bundle response code.");
    logError(paramBundle.getClass().getName());
    throw new RuntimeException("Unexpected type for bundle response code: " + paramBundle.getClass().getName());
  }
  
  int getResponseCodeFromIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      logError("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    logError("Unexpected type for intent response code.");
    logError(paramIntent.getClass().getName());
    throw new RuntimeException("Unexpected type for intent response code: " + paramIntent.getClass().getName());
  }
  
  /* Error */
  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: aload_0
    //   2: getfield 411	com/bubble/in/app/billing/helper/IabHelper:mRequestCode	I
    //   5: if_icmpeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: invokespecial 224	com/bubble/in/app/billing/helper/IabHelper:checkNotDisposed	()V
    //   14: aload_0
    //   15: ldc_w 412
    //   18: invokevirtual 227	com/bubble/in/app/billing/helper/IabHelper:checkSetupDone	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 414	com/bubble/in/app/billing/helper/IabHelper:flagEndAsync	()V
    //   25: aload_3
    //   26: ifnonnull +44 -> 70
    //   29: aload_0
    //   30: ldc_w 416
    //   33: invokevirtual 214	com/bubble/in/app/billing/helper/IabHelper:logError	(Ljava/lang/String;)V
    //   36: new 418	com/bubble/in/app/billing/helper/IabResult
    //   39: dup
    //   40: sipush 64534
    //   43: ldc_w 420
    //   46: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   49: astore_3
    //   50: aload_0
    //   51: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   54: ifnull +14 -> 68
    //   57: aload_0
    //   58: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   61: aload_3
    //   62: aconst_null
    //   63: invokeinterface 425 3 0
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 427	com/bubble/in/app/billing/helper/IabHelper:getResponseCodeFromIntent	(Landroid/content/Intent;)I
    //   75: istore_1
    //   76: aload_3
    //   77: ldc 99
    //   79: invokevirtual 431	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 4
    //   84: aload_3
    //   85: ldc 105
    //   87: invokevirtual 431	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 5
    //   92: iload_2
    //   93: iconst_m1
    //   94: if_icmpne +398 -> 492
    //   97: iload_1
    //   98: ifne +394 -> 492
    //   101: aload_0
    //   102: ldc_w 433
    //   105: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: new 190	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 435
    //   119: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 4
    //   124: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: new 190	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 437
    //   144: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 5
    //   149: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   158: aload_0
    //   159: new 190	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 439
    //   169: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_3
    //   173: invokevirtual 399	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   176: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   185: aload_0
    //   186: new 190	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 441
    //   196: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: getfield 443	com/bubble/in/app/billing/helper/IabHelper:mPurchasingItemType	Ljava/lang/String;
    //   203: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   212: aload 4
    //   214: ifnull +8 -> 222
    //   217: aload 5
    //   219: ifnonnull +74 -> 293
    //   222: aload_0
    //   223: ldc_w 445
    //   226: invokevirtual 214	com/bubble/in/app/billing/helper/IabHelper:logError	(Ljava/lang/String;)V
    //   229: aload_0
    //   230: new 190	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 439
    //   240: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_3
    //   244: invokevirtual 399	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   247: invokevirtual 446	android/os/Bundle:toString	()Ljava/lang/String;
    //   250: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   259: new 418	com/bubble/in/app/billing/helper/IabResult
    //   262: dup
    //   263: sipush 64528
    //   266: ldc_w 448
    //   269: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   272: astore_3
    //   273: aload_0
    //   274: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   277: ifnull +14 -> 291
    //   280: aload_0
    //   281: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   284: aload_3
    //   285: aconst_null
    //   286: invokeinterface 425 3 0
    //   291: iconst_1
    //   292: ireturn
    //   293: new 229	com/bubble/in/app/billing/helper/Purchase
    //   296: dup
    //   297: aload_0
    //   298: getfield 443	com/bubble/in/app/billing/helper/IabHelper:mPurchasingItemType	Ljava/lang/String;
    //   301: aload 4
    //   303: aload 5
    //   305: invokespecial 451	com/bubble/in/app/billing/helper/Purchase:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   308: astore_3
    //   309: aload_3
    //   310: invokevirtual 249	com/bubble/in/app/billing/helper/Purchase:getSku	()Ljava/lang/String;
    //   313: astore 6
    //   315: aload_0
    //   316: getfield 152	com/bubble/in/app/billing/helper/IabHelper:mSignatureBase64	Ljava/lang/String;
    //   319: aload 4
    //   321: aload 5
    //   323: invokestatic 457	com/bubble/in/app/billing/helper/Security:verifyPurchase	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   326: ifne +83 -> 409
    //   329: aload_0
    //   330: new 190	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 459
    //   340: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 6
    //   345: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokevirtual 214	com/bubble/in/app/billing/helper/IabHelper:logError	(Ljava/lang/String;)V
    //   354: new 418	com/bubble/in/app/billing/helper/IabResult
    //   357: dup
    //   358: sipush 64533
    //   361: new 190	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   368: ldc_w 461
    //   371: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 6
    //   376: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   385: astore 4
    //   387: aload_0
    //   388: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   391: ifnull +311 -> 702
    //   394: aload_0
    //   395: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   398: aload 4
    //   400: aload_3
    //   401: invokeinterface 425 3 0
    //   406: goto +296 -> 702
    //   409: aload_0
    //   410: ldc_w 463
    //   413: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   416: aload_0
    //   417: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   420: ifnull +24 -> 444
    //   423: aload_0
    //   424: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   427: new 418	com/bubble/in/app/billing/helper/IabResult
    //   430: dup
    //   431: iconst_0
    //   432: ldc_w 465
    //   435: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   438: aload_3
    //   439: invokeinterface 425 3 0
    //   444: iconst_1
    //   445: ireturn
    //   446: astore_3
    //   447: aload_0
    //   448: ldc_w 467
    //   451: invokevirtual 214	com/bubble/in/app/billing/helper/IabHelper:logError	(Ljava/lang/String;)V
    //   454: aload_3
    //   455: invokevirtual 470	org/json/JSONException:printStackTrace	()V
    //   458: new 418	com/bubble/in/app/billing/helper/IabResult
    //   461: dup
    //   462: sipush 64534
    //   465: ldc_w 467
    //   468: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   471: astore_3
    //   472: aload_0
    //   473: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   476: ifnull +14 -> 490
    //   479: aload_0
    //   480: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   483: aload_3
    //   484: aconst_null
    //   485: invokeinterface 425 3 0
    //   490: iconst_1
    //   491: ireturn
    //   492: iload_2
    //   493: iconst_m1
    //   494: if_icmpne +63 -> 557
    //   497: aload_0
    //   498: new 190	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 472
    //   508: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: iload_1
    //   512: invokestatic 288	com/bubble/in/app/billing/helper/IabHelper:getResponseDesc	(I)Ljava/lang/String;
    //   515: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   524: aload_0
    //   525: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   528: ifnull -84 -> 444
    //   531: new 418	com/bubble/in/app/billing/helper/IabResult
    //   534: dup
    //   535: iload_1
    //   536: ldc_w 474
    //   539: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   542: astore_3
    //   543: aload_0
    //   544: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   547: aload_3
    //   548: aconst_null
    //   549: invokeinterface 425 3 0
    //   554: goto -110 -> 444
    //   557: iload_2
    //   558: ifne +65 -> 623
    //   561: aload_0
    //   562: new 190	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 476
    //   572: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload_1
    //   576: invokestatic 288	com/bubble/in/app/billing/helper/IabHelper:getResponseDesc	(I)Ljava/lang/String;
    //   579: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokevirtual 166	com/bubble/in/app/billing/helper/IabHelper:logDebug	(Ljava/lang/String;)V
    //   588: new 418	com/bubble/in/app/billing/helper/IabResult
    //   591: dup
    //   592: sipush 64531
    //   595: ldc_w 478
    //   598: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   601: astore_3
    //   602: aload_0
    //   603: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   606: ifnull -162 -> 444
    //   609: aload_0
    //   610: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   613: aload_3
    //   614: aconst_null
    //   615: invokeinterface 425 3 0
    //   620: goto -176 -> 444
    //   623: aload_0
    //   624: new 190	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 480
    //   634: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload_2
    //   638: invokestatic 482	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   641: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: ldc_w 484
    //   647: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: iload_1
    //   651: invokestatic 288	com/bubble/in/app/billing/helper/IabHelper:getResponseDesc	(I)Ljava/lang/String;
    //   654: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokevirtual 214	com/bubble/in/app/billing/helper/IabHelper:logError	(Ljava/lang/String;)V
    //   663: new 418	com/bubble/in/app/billing/helper/IabResult
    //   666: dup
    //   667: sipush 64530
    //   670: ldc_w 486
    //   673: invokespecial 421	com/bubble/in/app/billing/helper/IabResult:<init>	(ILjava/lang/String;)V
    //   676: astore_3
    //   677: aload_0
    //   678: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   681: ifnull -237 -> 444
    //   684: aload_0
    //   685: getfield 339	com/bubble/in/app/billing/helper/IabHelper:mPurchaseListener	Lcom/bubble/in/app/billing/helper/IabHelper$OnIabPurchaseFinishedListener;
    //   688: aload_3
    //   689: aconst_null
    //   690: invokeinterface 425 3 0
    //   695: goto -251 -> 444
    //   698: astore_3
    //   699: goto -252 -> 447
    //   702: iconst_1
    //   703: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	IabHelper
    //   0	704	1	paramInt1	int
    //   0	704	2	paramInt2	int
    //   0	704	3	paramIntent	Intent
    //   82	317	4	localObject	Object
    //   90	232	5	str1	String
    //   313	62	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   293	309	446	org/json/JSONException
    //   309	406	698	org/json/JSONException
    //   409	416	698	org/json/JSONException
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    flagEndAsync();
    launchPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2)
  {
    launchPurchaseFlow(paramActivity, paramString1, "inapp", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    checkNotDisposed();
    checkSetupDone("launchPurchaseFlow");
    flagStartAsync("launchPurchaseFlow");
    if ((paramString2.equals("subs")) && (!this.mSubscriptionsSupported))
    {
      paramActivity = new IabResult(64527, "Subscriptions are not available.");
      flagEndAsync();
      if (paramOnIabPurchaseFinishedListener != null) {
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          logDebug("Constructing buy intent for " + paramString1 + ", item type: " + paramString2);
          paramString3 = this.mService.getBuyIntent(3, this.mContext.getPackageName(), paramString1, paramString2, paramString3);
          int i = getResponseCodeFromBundle(paramString3);
          if (i != 0)
          {
            logError("Unable to buy item, Error response: " + getResponseDesc(i));
            flagEndAsync();
            paramActivity = new IabResult(i, "Unable to buy item");
            if (paramOnIabPurchaseFinishedListener == null) {
              continue;
            }
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
          }
        }
        catch (IntentSender.SendIntentException paramActivity)
        {
          logError("SendIntentException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          flagEndAsync();
          paramActivity = new IabResult(64532, "Failed to send intent.");
          if (paramOnIabPurchaseFinishedListener != null)
          {
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
            return;
            paramString3 = (PendingIntent)paramString3.getParcelable("BUY_INTENT");
            logDebug("Launching buy intent for " + paramString1 + ". Request code: " + paramInt);
            this.mRequestCode = paramInt;
            this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
            this.mPurchasingItemType = paramString2;
            paramActivity.startIntentSenderForResult(paramString3.getIntentSender(), paramInt, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
            return;
          }
        }
        catch (RemoteException paramActivity)
        {
          logError("RemoteException while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          flagEndAsync();
          paramActivity = new IabResult(64535, "Remote exception while starting purchase flow");
        }
      }
    } while (paramOnIabPurchaseFinishedListener == null);
    paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchSubscriptionPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2)
  {
    launchPurchaseFlow(paramActivity, paramString1, "subs", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  void logDebug(String paramString)
  {
    if (this.mDebugLog) {
      Log.d(this.mDebugTag, paramString);
    }
  }
  
  void logError(String paramString)
  {
    Log.e(this.mDebugTag, "In-app billing error: " + paramString);
  }
  
  void logWarn(String paramString)
  {
    Log.w(this.mDebugTag, "In-app billing warning: " + paramString);
  }
  
  public Inventory queryInventory(boolean paramBoolean, List<String> paramList)
    throws IabException
  {
    return queryInventory(paramBoolean, paramList, null);
  }
  
  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    checkNotDisposed();
    checkSetupDone("queryInventory");
    int i;
    try
    {
      paramList2 = new Inventory();
      i = queryPurchases(paramList2, "inapp");
      if (i != 0) {
        throw new IabException(i, "Error refreshing inventory (querying owned items).");
      }
    }
    catch (RemoteException paramList1)
    {
      throw new IabException(64535, "Remote exception while refreshing inventory.", paramList1);
      if (paramBoolean)
      {
        i = querySkuDetails("inapp", paramList2, paramList1);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying prices of items).");
        }
      }
    }
    catch (JSONException paramList1)
    {
      throw new IabException(64534, "Error parsing JSON response while refreshing inventory.", paramList1);
    }
    if (this.mSubscriptionsSupported)
    {
      i = queryPurchases(paramList2, "subs");
      if (i != 0) {
        throw new IabException(i, "Error refreshing inventory (querying owned subscriptions).");
      }
      if (paramBoolean)
      {
        i = querySkuDetails("subs", paramList2, paramList1);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying prices of subscriptions).");
        }
      }
    }
    return paramList2;
  }
  
  public void queryInventoryAsync(QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("hints_1");
    localArrayList.add("hints_2");
    localArrayList.add("hints_3");
    localArrayList.add("hints_4");
    localArrayList.add("expert_mode_purchased");
    queryInventoryAsync(true, localArrayList, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(QueryInventoryFinishedListener paramQueryInventoryFinishedListener, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("hints_1");
    localArrayList.add("hints_2");
    localArrayList.add("hints_3");
    localArrayList.add("hints_4");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((String)paramList.next());
    }
    queryInventoryAsync(true, localArrayList, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(boolean paramBoolean, QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("hints_1");
    localArrayList.add("hints_2");
    localArrayList.add("hints_3");
    localArrayList.add("hints_4");
    localArrayList.add("expert_mode_purchased");
    queryInventoryAsync(paramBoolean, localArrayList, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(final boolean paramBoolean, final List<String> paramList, final QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    final Handler localHandler = new Handler();
    checkNotDisposed();
    checkSetupDone("queryInventory");
    flagStartAsync("refresh inventory");
    new Thread(new Runnable()
    {
      public void run()
      {
        final IabResult localIabResult1 = new IabResult(0, "Inventory refresh successful.");
        final Object localObject = null;
        try
        {
          Inventory localInventory = IabHelper.this.queryInventory(paramBoolean, paramList);
          localObject = localInventory;
        }
        catch (IabException localIabException)
        {
          for (;;)
          {
            IabResult localIabResult2 = localIabException.getResult();
          }
        }
        catch (Exception localException)
        {
          Log.e("IabHelper", "queryInventory error");
          localException.printStackTrace();
          IabHelper.this.flagEndAsync();
        }
        IabHelper.this.flagEndAsync();
        if ((!IabHelper.this.mDisposed) && (paramQueryInventoryFinishedListener != null))
        {
          localHandler.post(new Runnable()
          {
            public void run()
            {
              IabHelper.2.this.val$listener.onQueryInventoryFinished(localIabResult1, localObject);
            }
          });
          return;
        }
      }
    }).start();
  }
  
  int queryPurchases(Inventory paramInventory, String paramString)
    throws JSONException, RemoteException
  {
    logDebug("Querying owned items, item type: " + paramString);
    logDebug("Package name: " + this.mContext.getPackageName());
    int i = 0;
    Object localObject1 = null;
    int j;
    Object localObject2;
    do
    {
      logDebug("Calling getPurchases with continuation token: " + (String)localObject1);
      localObject1 = this.mService.getPurchases(3, this.mContext.getPackageName(), paramString, (String)localObject1);
      j = getResponseCodeFromBundle((Bundle)localObject1);
      logDebug("Owned items response: " + String.valueOf(j));
      if (j != 0)
      {
        logDebug("getPurchases() failed: " + getResponseDesc(j));
        return j;
      }
      if ((!((Bundle)localObject1).containsKey("INAPP_PURCHASE_ITEM_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_PURCHASE_DATA_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_DATA_SIGNATURE_LIST")))
      {
        logError("Bundle returned from getPurchases() doesn't contain required fields.");
        return 64534;
      }
      localObject2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      int k = 0;
      j = i;
      i = k;
      if (i < localArrayList1.size())
      {
        String str1 = (String)localArrayList1.get(i);
        Object localObject3 = (String)localArrayList2.get(i);
        String str2 = (String)((ArrayList)localObject2).get(i);
        if (Security.verifyPurchase(this.mSignatureBase64, str1, (String)localObject3))
        {
          logDebug("Sku is owned: " + str2);
          localObject3 = new Purchase(paramString, str1, (String)localObject3);
          if (TextUtils.isEmpty(((Purchase)localObject3).getToken()))
          {
            logWarn("BUG: empty/null token!");
            logDebug("Purchase data: " + str1);
          }
          paramInventory.addPurchase((Purchase)localObject3);
        }
        for (;;)
        {
          i += 1;
          break;
          logWarn("Purchase signature verification **FAILED**. Not adding item.");
          logDebug("   Purchase data: " + str1);
          logDebug("   Signature: " + (String)localObject3);
          j = 1;
        }
      }
      localObject2 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
      logDebug("Continuation token: " + (String)localObject2);
      localObject1 = localObject2;
      i = j;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    if (j != 0) {}
    for (i = 64533;; i = 0) {
      return i;
    }
  }
  
  int querySkuDetails(String paramString, Inventory paramInventory, List<String> paramList)
    throws RemoteException, JSONException
  {
    logDebug("Querying SKU details.");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(paramInventory.getAllOwnedSkus(paramString));
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!((ArrayList)localObject).contains(str)) {
          ((ArrayList)localObject).add(str);
        }
      }
    }
    if (((ArrayList)localObject).size() == 0) {
      logDebug("queryPrices: nothing to do because there are no SKUs.");
    }
    for (;;)
    {
      return 0;
      paramList = new Bundle();
      paramList.putStringArrayList("ITEM_ID_LIST", (ArrayList)localObject);
      paramList = this.mService.getSkuDetails(3, this.mContext.getPackageName(), paramString, paramList);
      if (!paramList.containsKey("DETAILS_LIST"))
      {
        int i = getResponseCodeFromBundle(paramList);
        if (i != 0)
        {
          logDebug("getSkuDetails() failed: " + getResponseDesc(i));
          return i;
        }
        logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return 64534;
      }
      paramList = paramList.getStringArrayList("DETAILS_LIST").iterator();
      while (paramList.hasNext())
      {
        localObject = new SkuDetails(paramString, (String)paramList.next());
        logDebug("Got sku details: " + localObject);
        paramInventory.addSkuDetails((SkuDetails)localObject);
      }
    }
  }
  
  public void startSetup(final OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    checkNotDisposed();
    if (this.mSetupDone) {
      throw new IllegalStateException("IAB helper is already set up.");
    }
    logDebug("Starting in-app billing setup.");
    this.mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        if (IabHelper.this.mDisposed) {
          return;
        }
        IabHelper.this.logDebug("Billing service connected.");
        IabHelper.this.mService = IInAppBillingService.Stub.asInterface(paramAnonymousIBinder);
        paramAnonymousComponentName = IabHelper.this.mContext.getPackageName();
        try
        {
          IabHelper.this.logDebug("Checking for in-app billing 3 support.");
          i = IabHelper.this.mService.isBillingSupported(3, paramAnonymousComponentName, "inapp");
          if (i != 0)
          {
            if (paramOnIabSetupFinishedListener != null) {
              paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(i, "Error checking for billing v3 support."));
            }
            IabHelper.this.mSubscriptionsSupported = false;
            return;
          }
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          if (paramOnIabSetupFinishedListener != null) {
            paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(64535, "RemoteException while setting up in-app billing."));
          }
          paramAnonymousComponentName.printStackTrace();
          return;
        }
        IabHelper.this.logDebug("In-app billing version 3 supported for " + paramAnonymousComponentName);
        int i = IabHelper.this.mService.isBillingSupported(3, paramAnonymousComponentName, "subs");
        if (i == 0)
        {
          IabHelper.this.logDebug("Subscriptions AVAILABLE.");
          IabHelper.this.mSubscriptionsSupported = true;
        }
        for (;;)
        {
          IabHelper.this.mSetupDone = true;
          if (paramOnIabSetupFinishedListener == null) {
            break;
          }
          paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful."));
          return;
          IabHelper.this.logDebug("Subscriptions NOT AVAILABLE. Response: " + i);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        IabHelper.this.logDebug("Billing service disconnected.");
        IabHelper.this.mService = null;
      }
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    if (!this.mContext.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()) {
      this.mContext.bindService(localIntent, this.mServiceConn, 1);
    }
    while (paramOnIabSetupFinishedListener == null) {
      return;
    }
    paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
  }
  
  public boolean subscriptionsSupported()
  {
    checkNotDisposed();
    return this.mSubscriptionsSupported;
  }
  
  public static abstract interface OnConsumeFinishedListener
  {
    public abstract void onConsumeFinished(Purchase paramPurchase, IabResult paramIabResult);
  }
  
  public static abstract interface OnConsumeMultiFinishedListener
  {
    public abstract void onConsumeMultiFinished(List<Purchase> paramList, List<IabResult> paramList1);
  }
  
  public static abstract interface OnIabPurchaseFinishedListener
  {
    public abstract void onIabPurchaseFinished(IabResult paramIabResult, Purchase paramPurchase);
  }
  
  public static abstract interface OnIabSetupFinishedListener
  {
    public abstract void onIabSetupFinished(IabResult paramIabResult);
  }
  
  public static abstract interface QueryInventoryFinishedListener
  {
    public abstract void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/in/app/billing/helper/IabHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */