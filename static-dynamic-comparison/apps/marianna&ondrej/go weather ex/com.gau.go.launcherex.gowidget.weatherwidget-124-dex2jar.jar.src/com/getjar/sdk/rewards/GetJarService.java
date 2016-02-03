package com.getjar.sdk.rewards;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.getjar.sdk.comm.TransactionManager;
import com.getjar.sdk.data.GooglePurchaseResponse;
import com.getjar.sdk.data.earning.EarningMonitor;
import com.getjar.sdk.data.usage.UsageMonitor;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.remote.implementation.IRemoteService.Stub;
import com.getjar.sdk.remote.implementation.RemoteServer;
import com.getjar.sdk.utilities.Constants;
import com.getjar.sdk.utilities.Constants.PurchaseState;
import com.getjar.sdk.utilities.Constants.ResponseCode;
import com.getjar.sdk.utilities.Security;
import com.getjar.sdk.vending.billing.IMarketBillingService;
import com.getjar.sdk.vending.billing.IMarketBillingService.Stub;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

public class GetJarService
  extends Service
  implements ServiceConnection
{
  private static final Class[] START_INTENT_SENDER_SIG = { IntentSender.class, Intent.class, Integer.TYPE, Integer.TYPE, Integer.TYPE };
  private static IMarketBillingService googlePlayBillingService;
  private static LinkedList<BillingRequest> mPendingRequests = new LinkedList();
  private static HashMap<Long, BillingRequest> mSentRequests = new HashMap();
  private final IRemoteService.Stub _aidlBinder = new RemoteServer(this);
  private Method mStartIntentSender;
  private Object[] mStartIntentSenderArgs = new Object[5];
  
  private boolean bindToMarketBillingService()
  {
    try
    {
      if (bindService(new Intent("com.android.vending.billing.MarketBillingService.BIND"), this, 1))
      {
        Logger.i(Area.BUY_GOLD.value(), "Bound to Google Play billing service.", new Object[0]);
        return true;
      }
      Logger.e(Area.BUY_GOLD.value(), "Could not bind to service.", new Object[0]);
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Logger.e(Area.BUY_GOLD.value(), "Security exception: " + localSecurityException, new Object[0]);
      }
    }
    return false;
  }
  
  private void checkResponseCode(long paramLong, Constants.ResponseCode paramResponseCode)
  {
    BillingRequest localBillingRequest = (BillingRequest)mSentRequests.get(Long.valueOf(paramLong));
    if (localBillingRequest != null) {
      localBillingRequest.responseCodeReceived(paramResponseCode);
    }
    mSentRequests.remove(Long.valueOf(paramLong));
  }
  
  private boolean confirmNotifications(int paramInt, String[] paramArrayOfString)
  {
    return new ConfirmNotifications(paramInt, paramArrayOfString).runRequest();
  }
  
  private boolean getPurchaseInformation(int paramInt, String[] paramArrayOfString)
  {
    return new GetPurchaseInformation(paramInt, paramArrayOfString).runRequest();
  }
  
  private void initCompatibilityLayer()
  {
    try
    {
      this.mStartIntentSender = getApplicationContext().getClass().getMethod("startIntentSender", START_INTENT_SENDER_SIG);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      Logger.e(Area.BUY_GOLD.value() | Area.UI.value(), localSecurityException, "GooglePlayBillingService initCompatibilityLayer", new Object[0]);
      this.mStartIntentSender = null;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Logger.e(Area.BUY_GOLD.value() | Area.UI.value(), localNoSuchMethodException, "GooglePlayBillingService initCompatibilityLayer", new Object[0]);
      this.mStartIntentSender = null;
    }
  }
  
  private void purchaseStateChanged(int paramInt, String paramString1, String paramString2)
  {
    Logger.d(Area.BUY_GOLD.value() | Area.STORAGE.value(), "GooglePlayBillingService purchaseStateChanged started", new Object[0]);
    paramString2 = Security.getPurchaseDetails(paramString1, paramString2, getApplicationContext());
    if (paramString2 == null) {
      Logger.d(Area.BUY_GOLD.value() | Area.STORAGE.value(), "GooglePlayBillingService purchases null", new Object[0]);
    }
    do
    {
      return;
      paramString1 = new ArrayList();
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        GooglePurchaseResponse localGooglePurchaseResponse = (GooglePurchaseResponse)paramString2.next();
        if (localGooglePurchaseResponse.getNotificationId() != null) {
          paramString1.add(localGooglePurchaseResponse.getNotificationId());
        }
        if (localGooglePurchaseResponse.getPurchaseState() == Constants.PurchaseState.PURCHASED.ordinal())
        {
          InAppPurchaseManager.getInstance(getApplicationContext()).storePurchaseResponse(localGooglePurchaseResponse);
          new TransactionManager(getApplicationContext()).buyCurrencyForGoogleTransactions(InAppPurchaseManager.getInstance(getApplicationContext()).getCommContext());
        }
      }
    } while (paramString1.isEmpty());
    confirmNotifications(paramInt, (String[])paramString1.toArray(new String[paramString1.size()]));
  }
  
  private void runPendingRequests()
  {
    Logger.d(Area.BUY_GOLD.value(), "GooglePlayBillingService runPendingRequests mPendingRequests size " + mPendingRequests.size(), new Object[0]);
    int i = -1;
    for (;;)
    {
      BillingRequest localBillingRequest = (BillingRequest)mPendingRequests.peek();
      if (localBillingRequest == null) {
        break label122;
      }
      if (!localBillingRequest.runIfConnected()) {
        break;
      }
      Logger.d(Area.BUY_GOLD.value(), "GooglePlayBillingService runPendingRequests runIfConnected", new Object[0]);
      mPendingRequests.remove();
      if (i < localBillingRequest.getStartId()) {
        i = localBillingRequest.getStartId();
      }
    }
    Logger.d(Area.BUY_GOLD.value(), "GooglePlayBillingService runPendingRequests bind", new Object[0]);
    bindToMarketBillingService();
    label122:
    while (i < 0) {
      return;
    }
    stopSelf(i);
  }
  
  private void setBillingSupported(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getApplicationContext().getSharedPreferences("GetJarClientPrefs", 0).edit();
    localEditor.putBoolean("billing_supported", paramBoolean);
    localEditor.commit();
  }
  
  public boolean checkBillingSupported()
  {
    return new CheckBillingSupported().runRequest();
  }
  
  public void handleCommand(Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getAction();
    Logger.d(Area.BUY_GOLD.value(), "GooglePlayBillingService handleCommand - action %1$s", new Object[] { str });
    if ("com.getjar.sdk.ENSURE_USAGE_MONITORING".equals(str)) {
      UsageMonitor.getInstance(this).ensureMonitoring();
    }
    do
    {
      return;
      if ("com.getjar.sdk.CONFIRM_NOTIFICATION".equals(str))
      {
        confirmNotifications(paramInt, paramIntent.getStringArrayExtra("notification_id"));
        return;
      }
      if ("com.getjar.sdk.GET_PURCHASE_INFORMATION".equals(str))
      {
        getPurchaseInformation(paramInt, new String[] { paramIntent.getStringExtra("notification_id") });
        return;
      }
      if ("com.android.vending.billing.PURCHASE_STATE_CHANGED".equals(str))
      {
        purchaseStateChanged(paramInt, paramIntent.getStringExtra("inapp_signed_data"), paramIntent.getStringExtra("inapp_signature"));
        return;
      }
    } while (!"com.android.vending.billing.RESPONSE_CODE".equals(str));
    checkResponseCode(paramIntent.getLongExtra("request_id", -1L), Constants.ResponseCode.valueOf(paramIntent.getIntExtra("response_code", Constants.ResponseCode.RESULT_ERROR.ordinal())));
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this._aidlBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    try
    {
      Logger.v(Area.OS_ENTRY_POINT.value(), "GetJarService: onCreate()", new Object[0]);
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            Logger.v(Area.EARN.value() | Area.OS_ENTRY_POINT.value(), "GetJarService: onCreate() starting earning monitoring thread", new Object[0]);
            EarningMonitor.getInstance(GetJarService.this.getApplicationContext()).ensureMonitoring();
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OS_ENTRY_POINT.value(), localException, "GetJarService: onCreate() start EarningMonitor failed", new Object[0]);
          }
        }
      }).start();
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            Logger.v(Area.USAGE.value() | Area.OS_ENTRY_POINT.value(), "GetJarService: onCreate() starting usage monitoring thread", new Object[0]);
            UsageMonitor.getInstance(GetJarService.this.getApplicationContext()).ensureMonitoring();
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OS_ENTRY_POINT.value(), localException, "GetJarService: onCreate() start UsageMonitor failed", new Object[0]);
          }
        }
      }).start();
      return;
    }
    catch (Exception localException)
    {
      Logger.w(Area.OS_ENTRY_POINT.value(), localException, "GetJarService onCreate", new Object[0]);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Logger.d(Area.OS_ENTRY_POINT.value() | Area.BUY_GOLD.value(), "GooglePlayBillingService onServiceConnected", new Object[0]);
    try
    {
      googlePlayBillingService = IMarketBillingService.Stub.asInterface(paramIBinder);
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            GetJarService.this.initCompatibilityLayer();
            GetJarService.this.runPendingRequests();
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.BUY_GOLD.value(), localException, "GetjarService onServiceConnected", new Object[0]);
          }
        }
      }, "GooglePlayRequestThread").start();
      return;
    }
    catch (Exception paramComponentName)
    {
      Logger.w(Area.BUY_GOLD.value(), paramComponentName, "GetJarService onServiceConnected", new Object[0]);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Logger.w(Area.BUY_GOLD.value(), "GooglePlayBillingService onServiceDisconnected", new Object[0]);
    googlePlayBillingService = null;
  }
  
  public int onStartCommand(final Intent paramIntent, int paramInt1, final int paramInt2)
  {
    Logger.d(Area.OS_ENTRY_POINT.value(), "GetJarService.onStartCommand() START", new Object[0]);
    if (paramIntent != null) {}
    try
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            GetJarService.this.handleCommand(paramIntent, paramInt2);
            if (!GetJarService.this.getApplicationContext().getSharedPreferences("GetJarClientPrefs", 0).getBoolean("billing_supported", false)) {
              GetJarService.this.checkBillingSupported();
            }
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OS_ENTRY_POINT.value(), localException, "GetJarService onStartCommand", new Object[0]);
          }
        }
      }).start();
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Logger.e(Area.OS_ENTRY_POINT.value(), paramIntent, "GetJarService.onStartCommand() failed", new Object[0]);
        Logger.d(Area.OS_ENTRY_POINT.value(), "GetJarService.onStartCommand() FINISHED", new Object[0]);
      }
    }
    finally
    {
      Logger.d(Area.OS_ENTRY_POINT.value(), "GetJarService.onStartCommand() FINISHED", new Object[0]);
    }
    return 1;
  }
  
  public boolean requestPurchase(String paramString)
  {
    return new RequestPurchase(paramString).runRequest();
  }
  
  public void setContext(Context paramContext)
  {
    attachBaseContext(paramContext);
  }
  
  void startBuyPageActivity(PendingIntent paramPendingIntent, Intent paramIntent)
  {
    if (this.mStartIntentSender != null) {
      try
      {
        this.mStartIntentSenderArgs[0] = paramPendingIntent.getIntentSender();
        this.mStartIntentSenderArgs[1] = paramIntent;
        this.mStartIntentSenderArgs[2] = Integer.valueOf(0);
        this.mStartIntentSenderArgs[3] = Integer.valueOf(0);
        this.mStartIntentSenderArgs[4] = Integer.valueOf(0);
        this.mStartIntentSender.invoke(getApplicationContext(), this.mStartIntentSenderArgs);
        return;
      }
      catch (Exception paramPendingIntent)
      {
        Logger.e(Area.BUY_GOLD.value() | Area.UI.value(), paramPendingIntent, "error starting activity", new Object[0]);
        return;
      }
    }
    try
    {
      paramPendingIntent.send(getApplicationContext(), 0, paramIntent);
      return;
    }
    catch (PendingIntent.CanceledException paramPendingIntent)
    {
      Logger.e(Area.BUY_GOLD.value() | Area.UI.value(), paramPendingIntent, "error starting activity", new Object[0]);
    }
  }
  
  public void unbind()
  {
    try
    {
      unbindService(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  abstract class BillingRequest
  {
    protected long mRequestId;
    private final int mStartId;
    
    public BillingRequest(int paramInt)
    {
      this.mStartId = paramInt;
    }
    
    public int getStartId()
    {
      return this.mStartId;
    }
    
    protected Bundle makeRequestBundle(String paramString)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("BILLING_REQUEST", paramString);
      localBundle.putInt("API_VERSION", 2);
      localBundle.putString("PACKAGE_NAME", GetJarService.this.getPackageName());
      return localBundle;
    }
    
    protected void onRemoteException(RemoteException paramRemoteException)
    {
      Logger.w(Area.BUY_GOLD.value(), "remote billing service crashed", new Object[0]);
      GetJarService.access$202(null);
    }
    
    protected void responseCodeReceived(Constants.ResponseCode paramResponseCode) {}
    
    protected abstract long run()
      throws RemoteException;
    
    public boolean runIfConnected()
    {
      boolean bool = false;
      if (GetJarService.googlePlayBillingService != null) {}
      try
      {
        Logger.d(Area.BUY_GOLD.value(), "GooglePlayBillingService runIfConnected", new Object[0]);
        this.mRequestId = run();
        if (this.mRequestId >= 0L) {
          GetJarService.mSentRequests.put(Long.valueOf(this.mRequestId), this);
        }
        bool = true;
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        onRemoteException(localRemoteException);
      }
      return false;
    }
    
    public boolean runRequest()
    {
      if (runIfConnected()) {
        return true;
      }
      if (GetJarService.this.bindToMarketBillingService())
      {
        GetJarService.mPendingRequests.add(this);
        return true;
      }
      return false;
    }
  }
  
  class CheckBillingSupported
    extends GetJarService.BillingRequest
  {
    public CheckBillingSupported()
    {
      super(-1);
    }
    
    protected long run()
      throws RemoteException
    {
      Bundle localBundle = makeRequestBundle("CHECK_BILLING_SUPPORTED");
      for (;;)
      {
        try
        {
          if (GetJarService.googlePlayBillingService != null)
          {
            if (GetJarService.googlePlayBillingService.sendBillingRequest(localBundle).getInt("RESPONSE_CODE") == Constants.ResponseCode.RESULT_OK.ordinal())
            {
              bool = true;
              GetJarService.this.setBillingSupported(bool);
              Logger.i(Area.BUY_GOLD.value(), "GooglePlayBillingService CheckBillingSupported -- isSupported " + bool, new Object[0]);
              return Constants.BILLING_RESPONSE_VALID_REQUEST_ID;
            }
          }
          else
          {
            GetJarService.this.bindToMarketBillingService();
            long l = Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
            return l;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          Logger.w(Area.BUY_GOLD.value(), localNullPointerException, "GetJarService CheckBillingSupported ", new Object[0]);
          GetJarService.this.setBillingSupported(false);
          return Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
        }
        boolean bool = false;
      }
    }
  }
  
  class ConfirmNotifications
    extends GetJarService.BillingRequest
  {
    final String[] mNotifyIds;
    
    public ConfirmNotifications(int paramInt, String[] paramArrayOfString)
    {
      super(paramInt);
      this.mNotifyIds = paramArrayOfString;
    }
    
    protected long run()
      throws RemoteException
    {
      Logger.d(Area.BUY_GOLD.value(), "GooglePlayBillingService ConfirmNotifications", new Object[0]);
      Bundle localBundle = makeRequestBundle("CONFIRM_NOTIFICATIONS");
      localBundle.putStringArray("NOTIFY_IDS", this.mNotifyIds);
      if (GetJarService.googlePlayBillingService != null) {
        return GetJarService.googlePlayBillingService.sendBillingRequest(localBundle).getLong("REQUEST_ID", Constants.BILLING_RESPONSE_INVALID_REQUEST_ID);
      }
      return Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
    }
  }
  
  class GetPurchaseInformation
    extends GetJarService.BillingRequest
  {
    long mNonce;
    final String[] mNotifyIds;
    
    public GetPurchaseInformation(int paramInt, String[] paramArrayOfString)
    {
      super(paramInt);
      this.mNotifyIds = paramArrayOfString;
    }
    
    protected void onRemoteException(RemoteException paramRemoteException)
    {
      super.onRemoteException(paramRemoteException);
    }
    
    protected long run()
      throws RemoteException
    {
      this.mNonce = Security.generateNonce();
      Bundle localBundle = makeRequestBundle("GET_PURCHASE_INFORMATION");
      localBundle.putLong("NONCE", this.mNonce);
      localBundle.putStringArray("NOTIFY_IDS", this.mNotifyIds);
      try
      {
        if (GetJarService.googlePlayBillingService != null)
        {
          long l = GetJarService.googlePlayBillingService.sendBillingRequest(localBundle).getLong("REQUEST_ID", Constants.BILLING_RESPONSE_INVALID_REQUEST_ID);
          return l;
        }
      }
      catch (Exception localException) {}
      return Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
    }
  }
  
  class RequestPurchase
    extends GetJarService.BillingRequest
  {
    public final String mProductId;
    
    public RequestPurchase(String paramString)
    {
      super(-1);
      this.mProductId = paramString;
    }
    
    protected void responseCodeReceived(Constants.ResponseCode paramResponseCode)
    {
      if (!Constants.ResponseCode.RESULT_OK.equals(paramResponseCode))
      {
        if (paramResponseCode.equals(Constants.ResponseCode.RESULT_ITEM_UNAVAILABLE)) {
          InAppPurchaseManager.getInstance(GetJarService.this.getApplicationContext()).handleFailure(this.mProductId, InAppPurchaseManager.InAppBillingFailure.ITEM_NOT_AVAILABLE, GetJarService.this.getApplicationContext());
        }
      }
      else {
        return;
      }
      if (paramResponseCode.equals(Constants.ResponseCode.RESULT_USER_CANCELED))
      {
        InAppPurchaseManager.getInstance(GetJarService.this.getApplicationContext()).handleFailure(this.mProductId, InAppPurchaseManager.InAppBillingFailure.CANCELLED, GetJarService.this.getApplicationContext());
        return;
      }
      InAppPurchaseManager.getInstance(GetJarService.this.getApplicationContext()).handleFailure(this.mProductId, InAppPurchaseManager.InAppBillingFailure.GOOGLE_PLAY_BIND_FAILURE, GetJarService.this.getApplicationContext());
    }
    
    protected long run()
      throws RemoteException
    {
      Logger.d(Area.BUY_GOLD.value(), "GooglePlayBillingService RequestPurchase run mProductId %s", new Object[] { this.mProductId });
      Bundle localBundle = makeRequestBundle("REQUEST_PURCHASE");
      localBundle.putString("ITEM_ID", this.mProductId);
      localBundle.putString("DEVELOPER_PAYLOAD", String.format(Locale.US, "%s%s", new Object[] { "db8ecd00-3db5-11e2-a25f-0800200c9a66", UUID.randomUUID().toString() }));
      Logger.d(Area.BUY_GOLD.value(), "GetJarService requestBundle: %s", new Object[] { localBundle });
      if (GetJarService.googlePlayBillingService != null)
      {
        localBundle = GetJarService.googlePlayBillingService.sendBillingRequest(localBundle);
        PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("PURCHASE_INTENT");
        if (localPendingIntent == null)
        {
          Logger.e(Area.BUY_GOLD.value(), "Error with requestPurchase", new Object[0]);
          return Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
        }
        Intent localIntent = new Intent();
        GetJarService.this.startBuyPageActivity(localPendingIntent, localIntent);
        return localBundle.getLong("REQUEST_ID", Constants.BILLING_RESPONSE_INVALID_REQUEST_ID);
      }
      GetJarService.this.bindToMarketBillingService();
      return Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */