package com.gau.go.launcherex.gowidget.googleplay;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
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
  volatile boolean mAsyncInProgress = false;
  String mAsyncOperation = "";
  final Context mContext;
  boolean mDebugLog = false;
  String mDebugTag = "IabHelper";
  volatile boolean mDisposed = false;
  IabHelper.OnIabPurchaseFinishedListener mPurchaseListener;
  String mPurchasingItemType;
  int mRequestCode;
  volatile IInAppBillingService mService;
  volatile ServiceConnection mServiceConn;
  volatile boolean mSetupDone = false;
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
  
  public void consumeAsync(Purchase paramPurchase, IabHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    checkNotDisposed();
    checkSetupDone("consume");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPurchase);
    consumeAsyncInternal(localArrayList, paramOnConsumeFinishedListener, null);
  }
  
  public void consumeAsync(List paramList, IabHelper.OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    checkNotDisposed();
    checkSetupDone("consume");
    consumeAsyncInternal(paramList, null, paramOnConsumeMultiFinishedListener);
  }
  
  void consumeAsyncInternal(List paramList, IabHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener, IabHelper.OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    Handler localHandler = new Handler();
    flagStartAsync("consume");
    new Thread(new IabHelper.3(this, paramList, paramOnConsumeFinishedListener, localHandler, paramOnConsumeMultiFinishedListener)).start();
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 302
    //   4: invokevirtual 139	com/gau/go/launcherex/gowidget/googleplay/IabHelper:logDebug	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 113	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mSetupDone	Z
    //   12: aload_0
    //   13: getfield 304	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mServiceConn	Landroid/content/ServiceConnection;
    //   16: ifnull +28 -> 44
    //   19: aload_0
    //   20: ldc_w 306
    //   23: invokevirtual 139	com/gau/go/launcherex/gowidget/googleplay/IabHelper:logDebug	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 133	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mContext	Landroid/content/Context;
    //   30: ifnull +14 -> 44
    //   33: aload_0
    //   34: getfield 133	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mContext	Landroid/content/Context;
    //   37: aload_0
    //   38: getfield 304	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mServiceConn	Landroid/content/ServiceConnection;
    //   41: invokevirtual 310	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 115	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mDisposed	Z
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 304	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mServiceConn	Landroid/content/ServiceConnection;
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 244	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mService	Lcom/android/vending/billing/IInAppBillingService;
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 312	com/gau/go/launcherex/gowidget/googleplay/IabHelper:mPurchaseListener	Lcom/gau/go/launcherex/gowidget/googleplay/IabHelper$OnIabPurchaseFinishedListener;
    //   64: return
    //   65: astore_1
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: goto -25 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	IabHelper
    //   65	2	1	localObject	Object
    //   68	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   26	44	65	finally
    //   26	44	68	java/lang/Exception
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
  
  void flagEndAsync()
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
  
  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != this.mRequestCode) {
      return false;
    }
    checkNotDisposed();
    checkSetupDone("handleActivityResult");
    flagEndAsync();
    if (paramIntent == null)
    {
      logError("Null data in IAB activity result.");
      paramIntent = new IabResult(64534, "Null data in IAB result");
      if (this.mPurchaseListener != null) {
        this.mPurchaseListener.onIabPurchaseFinished(paramIntent, null);
      }
      return true;
    }
    paramInt1 = getResponseCodeFromIntent(paramIntent);
    Object localObject = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    String str1 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      logDebug("Successful resultcode from purchase activity.");
      logDebug("Purchase data: " + (String)localObject);
      logDebug("Data signature: " + str1);
      logDebug("Extras: " + paramIntent.getExtras());
      logDebug("Expected item type: " + this.mPurchasingItemType);
      if ((localObject == null) || (str1 == null))
      {
        logError("BUG: either purchaseData or dataSignature is null.");
        logDebug("Extras: " + paramIntent.getExtras().toString());
        paramIntent = new IabResult(64528, "IAB returned null purchaseData or dataSignature");
        if (this.mPurchaseListener != null) {
          this.mPurchaseListener.onIabPurchaseFinished(paramIntent, null);
        }
        return true;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new Purchase(this.mPurchasingItemType, (String)localObject, str1);
        String str2 = paramIntent.getSku();
        if (!Security.verifyPurchase(this.mSignatureBase64, (String)localObject, str1))
        {
          logError("Purchase signature verification FAILED for sku " + str2);
          localObject = new IabResult(64533, "Signature verification failed for sku " + str2);
          if (this.mPurchaseListener == null) {
            break;
          }
          this.mPurchaseListener.onIabPurchaseFinished((IabResult)localObject, paramIntent);
          break;
        }
        logDebug("Purchase signature successfully verified.");
        if (this.mPurchaseListener != null) {
          this.mPurchaseListener.onIabPurchaseFinished(new IabResult(0, "Success"), paramIntent);
        }
        return true;
      }
      catch (JSONException paramIntent)
      {
        logError("Failed to parse purchase data.");
        paramIntent.printStackTrace();
        paramIntent = new IabResult(64534, "Failed to parse purchase data.");
        if (this.mPurchaseListener != null) {
          this.mPurchaseListener.onIabPurchaseFinished(paramIntent, null);
        }
        return true;
      }
      if (paramInt2 == -1)
      {
        logDebug("Result code was OK but in-app billing response was not OK: " + getResponseDesc(paramInt1));
        if (this.mPurchaseListener != null)
        {
          paramIntent = new IabResult(paramInt1, "Problem purchashing item.");
          this.mPurchaseListener.onIabPurchaseFinished(paramIntent, null);
        }
      }
      else if (paramInt2 == 0)
      {
        logDebug("Purchase canceled - Response: " + getResponseDesc(paramInt1));
        paramIntent = new IabResult(64531, "User canceled.");
        if (this.mPurchaseListener != null) {
          this.mPurchaseListener.onIabPurchaseFinished(paramIntent, null);
        }
      }
      else
      {
        logError("Purchase failed. Result code: " + Integer.toString(paramInt2) + ". Response: " + getResponseDesc(paramInt1));
        paramIntent = new IabResult(64530, "Unknown purchase response.");
        if (this.mPurchaseListener != null) {
          this.mPurchaseListener.onIabPurchaseFinished(paramIntent, null);
        }
      }
    }
    return true;
  }
  
  public boolean isDisposed()
  {
    return this.mDisposed;
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString, int paramInt, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2)
  {
    launchPurchaseFlow(paramActivity, paramString1, "inapp", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
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
          if (paramOnIabPurchaseFinishedListener != null)
          {
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
            return;
          }
        }
        catch (Exception paramActivity)
        {
          logError("Exception while launching purchase flow for sku " + paramString1);
          paramActivity.printStackTrace();
          flagEndAsync();
          paramActivity = new IabResult(64535, "exception while starting purchase flow");
        }
      }
    } while (paramOnIabPurchaseFinishedListener == null);
    paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(paramActivity, null);
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString, int paramInt, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchSubscriptionPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2)
  {
    launchPurchaseFlow(paramActivity, paramString1, "subs", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  public void logDebug(String paramString)
  {
    if (this.mDebugLog) {
      Log.d(this.mDebugTag, paramString);
    }
  }
  
  public void logError(String paramString)
  {
    Log.e(this.mDebugTag, "In-app billing error: " + paramString);
  }
  
  public void logWarn(String paramString)
  {
    Log.w(this.mDebugTag, "In-app billing warning: " + paramString);
  }
  
  public Inventory queryInventory(boolean paramBoolean, List paramList)
  {
    return queryInventory(paramBoolean, paramList, null);
  }
  
  public Inventory queryInventory(boolean paramBoolean, List paramList1, List paramList2)
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
  
  public void queryInventoryAsync(IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(true, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(boolean paramBoolean, IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(paramBoolean, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(boolean paramBoolean, List paramList, IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    Handler localHandler = new Handler();
    checkNotDisposed();
    checkSetupDone("queryInventory");
    flagStartAsync("refresh inventory");
    new Thread(new IabHelper.2(this, paramBoolean, paramList, paramQueryInventoryFinishedListener, localHandler)).start();
  }
  
  int queryPurchases(Inventory paramInventory, String paramString)
  {
    if (this.mContext != null)
    {
      logDebug("Querying owned items, item type: " + paramString);
      logDebug("Package name: " + this.mContext.getPackageName());
    }
    int i = 0;
    Object localObject1 = null;
    for (;;)
    {
      logDebug("Calling getPurchases with continuation token: " + (String)localObject1);
      if (this.mService == null) {
        return 64533;
      }
      localObject1 = this.mService.getPurchases(3, this.mContext.getPackageName(), paramString, (String)localObject1);
      if (localObject1 == null) {
        return 64534;
      }
      int j = getResponseCodeFromBundle((Bundle)localObject1);
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
      ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      ArrayList localArrayList3 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      j = 0;
      if (j < localArrayList2.size())
      {
        String str1 = (String)localArrayList2.get(j);
        Object localObject2 = (String)localArrayList3.get(j);
        String str2 = (String)localArrayList1.get(j);
        if (Security.verifyPurchase(this.mSignatureBase64, str1, (String)localObject2))
        {
          logDebug("Sku is owned: " + str2);
          localObject2 = new Purchase(paramString, str1, (String)localObject2);
          if (TextUtils.isEmpty(((Purchase)localObject2).getToken()))
          {
            logWarn("BUG: empty/null token!");
            logDebug("Purchase data: " + str1);
          }
          paramInventory.addPurchase((Purchase)localObject2);
        }
        for (;;)
        {
          j += 1;
          break;
          logWarn("Purchase signature verification **FAILED**. Not adding item.");
          logDebug("   Purchase data: " + str1);
          logDebug("   Signature: " + (String)localObject2);
          i = 1;
        }
      }
      localObject1 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
      logDebug("Continuation token: " + (String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (i != 0) {
          return 64533;
        }
        return 0;
      }
    }
  }
  
  int querySkuDetails(String paramString, Inventory paramInventory, List paramList)
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
    if (((ArrayList)localObject).size() == 0)
    {
      logDebug("queryPrices: nothing to do because there are no SKUs.");
      return 0;
    }
    paramList = new Bundle();
    paramList.putStringArrayList("ITEM_ID_LIST", (ArrayList)localObject);
    if (this.mService == null) {
      return 64534;
    }
    paramList = this.mService.getSkuDetails(3, this.mContext.getPackageName(), paramString, paramList);
    if (paramList != null)
    {
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
      paramList = paramList.getStringArrayList("DETAILS_LIST");
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = new SkuDetails(paramString, (String)paramList.next());
          logDebug("Got sku details: " + localObject);
          paramInventory.addSkuDetails((SkuDetails)localObject);
        }
      }
      return 64534;
    }
    return 64534;
    return 0;
  }
  
  public void startSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    checkNotDisposed();
    if (this.mSetupDone) {
      throw new IllegalStateException("IAB helper is already set up.");
    }
    logDebug("Starting in-app billing setup.");
    this.mServiceConn = new IabHelper.1(this, paramOnIabSetupFinishedListener);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/IabHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */