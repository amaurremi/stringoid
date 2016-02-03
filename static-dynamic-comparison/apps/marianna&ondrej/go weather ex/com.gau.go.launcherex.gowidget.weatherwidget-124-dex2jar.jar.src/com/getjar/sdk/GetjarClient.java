package com.getjar.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.getjar.sdk.comm.BeaconManager;
import com.getjar.sdk.comm.BeaconMessage.BeaconType;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.CommManager;
import com.getjar.sdk.comm.ExternalRequestProxy;
import com.getjar.sdk.comm.NetworkStateReceiver;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.Operation.Priority;
import com.getjar.sdk.comm.auth.ApplicationTokenDatabase;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.AuthManager.AuthListener;
import com.getjar.sdk.comm.auth.AuthResult.State;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.comm.auth.OutOfBandManager;
import com.getjar.sdk.comm.auth.ProviderHint;
import com.getjar.sdk.comm.auth.UserAuthResult;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.LicenseEngine;
import com.getjar.sdk.data.RedemptionEngine;
import com.getjar.sdk.data.cache.Ad.State;
import com.getjar.sdk.data.cache.AdManager;
import com.getjar.sdk.data.cache.AdManager.AdType;
import com.getjar.sdk.exceptions.AuthException;
import com.getjar.sdk.exceptions.UnauthorizedException;
import com.getjar.sdk.internal.ConsumableProduct;
import com.getjar.sdk.internal.LicensableProduct;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.remote.RemoteClient;
import com.getjar.sdk.rewards.AdvertisingIdHelper;
import com.getjar.sdk.rewards.InAppPurchaseManager;
import com.getjar.sdk.utilities.AlarmsUtility;
import com.getjar.sdk.utilities.Constants.RequestInstallType;
import com.getjar.sdk.utilities.IntentsUtility;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;

public final class GetjarClient
{
  private static final ExecutorService _ExecutorServiceForConnect = Executors.newSingleThreadExecutor();
  private static volatile boolean _IsUsed = false;
  private final DeveloperAPIAuthListener _authListener = new DeveloperAPIAuthListener(null);
  private final Builder _builder;
  private final CommContext _commContext;
  private boolean _initialConnectionResolved = false;
  
  private GetjarClient(Builder paramBuilder)
  {
    this._builder = paramBuilder;
    this._commContext = CommManager.createContextForGetjarClient(paramBuilder._context, this);
  }
  
  public static boolean IsUsed()
  {
    return _IsUsed;
  }
  
  private static final String getLoggingPrefix()
  {
    String str2 = "";
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    String str1 = str2;
    if (arrayOfStackTraceElement != null)
    {
      str1 = str2;
      if (arrayOfStackTraceElement.length >= 3) {
        str1 = arrayOfStackTraceElement[3].getMethodName();
      }
    }
    return String.format(Locale.US, "GetjarClient: %1$s() [thread:%2$d]", new Object[] { str1, Long.valueOf(Thread.currentThread().getId()) });
  }
  
  private void makeConnectionCallback()
  {
    Logger.v(Area.DEVELOPER_API.value() | Area.AUTH.value(), "%1$s makeConnectionCallback() [stack:%2$s]", new Object[] { getLoggingPrefix(), Logger.getShortStack() });
    if (AuthManager.getInstance().isAuthed())
    {
      AdManager.initialize(this._commContext);
      this._initialConnectionResolved = true;
      LicenseEngine.initialize(this._commContext);
      this._builder._connectionCallbacks.onConnected();
      AlarmsUtility.ensureBackgroundReportingAlarm(this._commContext.getApplicationContext());
      try
      {
        OutOfBandManager.initialize(this._commContext);
        OutOfBandManager.getInstance().startOutOfBandWork(true);
        return;
      }
      catch (Exception localException)
      {
        Logger.e(Area.DEVELOPER_API.value(), localException, "%1$s OutOfBandManager.startOutOfBandWork() failed", new Object[] { getLoggingPrefix() });
        return;
      }
    }
    this._initialConnectionResolved = false;
    Object localObject = AuthManager.getInstance().getLatestAuthResult();
    if ((localObject != null) && (AuthResult.State.BLACKLISTED.equals(((UserAuthResult)localObject).getState())))
    {
      this._builder._connectionCallbacks.onConnectionFailed(new GetjarConnectionResult(false, 2, null));
      return;
    }
    if ((localObject != null) && (AuthResult.State.UNSUPPORTED.equals(((UserAuthResult)localObject).getState())))
    {
      this._builder._connectionCallbacks.onConnectionFailed(new GetjarConnectionResult(false, 3, null));
      return;
    }
    if ((localObject != null) && (AuthResult.State.NETWORK_FAILURE.equals(((UserAuthResult)localObject).getState())))
    {
      this._builder._connectionCallbacks.onConnectionFailed(new GetjarConnectionResult(false, 4, null));
      return;
    }
    if ((localObject != null) && (AuthResult.State.UI_NEEDED.equals(((UserAuthResult)localObject).getState())))
    {
      localObject = IntentsUtility.getAccountPickerIntent(getContext(), getUiTitle());
      this._builder._connectionCallbacks.onConnectionFailed(new GetjarConnectionResult(true, 6, (Intent)localObject));
      return;
    }
    this._builder._connectionCallbacks.onConnectionFailed(new GetjarConnectionResult(false, 13, null));
  }
  
  public void confirmVoucher(String paramString)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'voucherToken' cannot be null or empty");
    }
    RedemptionEngine.confirmVoucher(this._commContext, paramString);
  }
  
  public void connect()
  {
    try
    {
      _ExecutorServiceForConnect.execute(new ConnectionRunnable());
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.DEVELOPER_API.value(), localException, "%1$s failed", new Object[] { getLoggingPrefix() });
      this._builder._connectionCallbacks.onConnectionFailed(new GetjarConnectionResult(false, 13, null));
    }
  }
  
  public Ad getAd(String paramString1, String paramString2)
  {
    return getAd(paramString1, paramString2, null);
  }
  
  public Ad getAd(String paramString1, final String paramString2, OnAdExpiredListener paramOnAdExpiredListener)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    try
    {
      AuthManager.initialize(getContext());
      if (!AuthManager.getInstance().getClaimsManager(getContext()).canUseCustomAds()) {
        throw new IllegalStateException("The provided Application Token is not allowed to use custom ads");
      }
    }
    catch (UnauthorizedException paramString1)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramString1, "%1$s getAd() failed", new Object[] { getLoggingPrefix() });
      paramString2 = null;
      do
      {
        return paramString2;
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("ads.layout_type", AdManager.AdType.CUSTOM.name());
          if (paramString1 != null) {
            break;
          }
          localObject = "";
          localHashMap.put("ads.placement", localObject);
          BeaconManager.getInstance(getContext()).initiateBeaconMessage(this._commContext, BeaconMessage.BeaconType.AD_ATTEMPT_SHOWN, localHashMap);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject;
            Logger.e(Area.DEVELOPER_API.value(), localException, "%1$s getAd() beacon call failed [AD_ATTEMPT_SHOWN]", new Object[] { getLoggingPrefix() });
          }
        }
        paramOnAdExpiredListener = AdManager.getInstance().getAd(paramString1, paramString2, paramOnAdExpiredListener);
        paramString2 = paramOnAdExpiredListener;
      } while (paramOnAdExpiredListener == null);
      paramString2 = paramOnAdExpiredListener.getPingBackUrl();
      if (!StringUtility.isNullOrEmpty(paramString2)) {
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              this.val$op.get();
              return;
            }
            catch (Exception localException)
            {
              Logger.e(Area.DEVELOPER_API.value(), localException, "%1$s getAd() ping-back URL failed [%2$s]", new Object[] { GetjarClient.access$700(), paramString2 });
            }
          }
        }, "PingBackOperationThread").start();
      }
      try
      {
        localObject = Utility.jsonArrayStringToMap(paramOnAdExpiredListener.getTrackingMetadata());
        ((HashMap)localObject).put("ads.layout_type", AdManager.AdType.CUSTOM.name());
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        ((HashMap)localObject).put("ads.placement", paramString2);
        BeaconManager.getInstance(getContext()).initiateBeaconMessage(this._commContext, BeaconMessage.BeaconType.AD_SHOWN, (HashMap)localObject);
        return paramOnAdExpiredListener;
      }
      catch (Exception paramString1)
      {
        Logger.e(Area.DEVELOPER_API.value(), paramString1, "%1$s getAd() beacon call failed [AD_SHOWN]", new Object[] { getLoggingPrefix() });
        return paramOnAdExpiredListener;
      }
    }
    catch (AuthException paramString1)
    {
      for (;;)
      {
        Logger.e(Area.DEVELOPER_API.value(), paramString1, "%1$s getAd() failed", new Object[] { getLoggingPrefix() });
        continue;
        localObject = paramString1;
      }
    }
  }
  
  public String getAppAccountName()
  {
    return this._builder._appAccountName;
  }
  
  public String getAppAuthProviderKey()
  {
    return this._builder._appAuthProviderKey;
  }
  
  public Boolean getAppConfigBooleanValue(String paramString, Boolean paramBoolean)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    return GetJarConfig.getInstance(getContext()).getBooleanValue(paramString, paramBoolean, SettingsManager.Scope.APP);
  }
  
  public Integer getAppConfigIntegerValue(String paramString, Integer paramInteger)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    return GetJarConfig.getInstance(getContext()).getIntegerValue(paramString, paramInteger, SettingsManager.Scope.APP);
  }
  
  public String getAppConfigStringValue(String paramString1, String paramString2)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    return GetJarConfig.getInstance(getContext()).getDirectiveValue(paramString1, paramString2, SettingsManager.Scope.APP);
  }
  
  public String getApplicationToken()
  {
    return Builder._ApplicationToken;
  }
  
  public List<Account> getAvailableAccounts()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = RewardUtility.getAccountsJson(getContext());
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add(new Account(localJSONArray.getJSONObject(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      Logger.e(Area.DEVELOPER_API.value(), localException, "%1$s getAvailableAccounts() failed", new Object[] { getLoggingPrefix() });
    }
  }
  
  public String getClientId()
  {
    return this._commContext.getCommContextId();
  }
  
  public GetjarConnectionCallbacks getConnectionCallbacks()
  {
    return this._builder._connectionCallbacks;
  }
  
  public Context getContext()
  {
    return this._builder._context;
  }
  
  public Account getCurrentAccount()
  {
    try
    {
      Iterator localIterator = getAvailableAccounts().iterator();
      while (localIterator.hasNext())
      {
        Account localAccount = (Account)localIterator.next();
        boolean bool = Account.Status.CURRENT.equals(localAccount.getStatus());
        if (bool) {
          return localAccount;
        }
      }
    }
    catch (Exception localException)
    {
      Logger.e(Area.DEVELOPER_API.value(), localException, "%1$s getCurrentAccount() failed", new Object[] { getLoggingPrefix() });
    }
    return null;
  }
  
  public Intent getEarnIntent(String paramString)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    return IntentsUtility.getEarnIntent(getContext(), paramString);
  }
  
  public OnGetjarWorkFinishedListener getGetjarWorkListener()
  {
    return this._builder._backgroundWorkListener;
  }
  
  public Intent getInterstitialIntent(String paramString1, String paramString2)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    return IntentsUtility.getInterstitialIntent(getContext(), paramString1, paramString2);
  }
  
  public void getLicense(String paramString, OnGetjarLicensesReceivedListener paramOnGetjarLicensesReceivedListener)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    try
    {
      AuthManager.initialize(getContext());
      if (!AuthManager.getInstance().getClaimsManager(getContext()).canUseUnmanagedLicenses()) {
        throw new IllegalStateException("The provided Application Token is not allowed to use Licensing features");
      }
    }
    catch (UnauthorizedException paramString)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramString, "%1$s getLicense() failed", new Object[] { getLoggingPrefix() });
      if (paramOnGetjarLicensesReceivedListener != null) {
        paramOnGetjarLicensesReceivedListener.onLicensesReceived(4, null);
      }
      return;
      if (StringUtility.isNullOrEmpty(paramString)) {
        throw new IllegalArgumentException("'developerProductID' cannot be null or empty");
      }
    }
    catch (AuthException paramString)
    {
      do
      {
        Logger.e(Area.DEVELOPER_API.value(), paramString, "%1$s getLicense() failed", new Object[] { getLoggingPrefix() });
      } while (paramOnGetjarLicensesReceivedListener == null);
      paramOnGetjarLicensesReceivedListener.onLicensesReceived(2, null);
      return;
    }
    if (paramOnGetjarLicensesReceivedListener == null) {
      throw new IllegalArgumentException("'licenseListener' cannot be null");
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    getLicenses(localArrayList, paramOnGetjarLicensesReceivedListener);
  }
  
  public void getLicenses(OnGetjarLicensesReceivedListener paramOnGetjarLicensesReceivedListener)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    try
    {
      AuthManager.initialize(getContext());
      if (!AuthManager.getInstance().getClaimsManager(getContext()).canUseUnmanagedLicenses()) {
        throw new IllegalStateException("The provided Application Token is not allowed to use Licensing features");
      }
    }
    catch (UnauthorizedException localUnauthorizedException)
    {
      Logger.e(Area.DEVELOPER_API.value(), localUnauthorizedException, "%1$s getLicenses() failed", new Object[] { getLoggingPrefix() });
      if (paramOnGetjarLicensesReceivedListener != null) {
        paramOnGetjarLicensesReceivedListener.onLicensesReceived(4, null);
      }
      return;
      if (paramOnGetjarLicensesReceivedListener == null) {
        throw new IllegalArgumentException("'licenseListener' cannot be null");
      }
    }
    catch (AuthException localAuthException)
    {
      do
      {
        Logger.e(Area.DEVELOPER_API.value(), localAuthException, "%1$s getLicenses() failed", new Object[] { getLoggingPrefix() });
      } while (paramOnGetjarLicensesReceivedListener == null);
      paramOnGetjarLicensesReceivedListener.onLicensesReceived(2, null);
      return;
    }
    LicenseEngine.getInstance().getLicenses(null, paramOnGetjarLicensesReceivedListener);
  }
  
  public void getLicenses(List<String> paramList, OnGetjarLicensesReceivedListener paramOnGetjarLicensesReceivedListener)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    try
    {
      AuthManager.initialize(getContext());
      if (!AuthManager.getInstance().getClaimsManager(getContext()).canUseUnmanagedLicenses()) {
        throw new IllegalStateException("The provided Application Token is not allowed to use Licensing features");
      }
    }
    catch (UnauthorizedException paramList)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramList, "%1$s getLicenses() failed", new Object[] { getLoggingPrefix() });
      if (paramOnGetjarLicensesReceivedListener != null) {
        paramOnGetjarLicensesReceivedListener.onLicensesReceived(4, null);
      }
      return;
      if ((paramList == null) || (paramList.isEmpty())) {
        throw new IllegalArgumentException("'developerProductID' cannot be null or empty");
      }
    }
    catch (AuthException paramList)
    {
      do
      {
        Logger.e(Area.DEVELOPER_API.value(), paramList, "%1$s getLicenses() failed", new Object[] { getLoggingPrefix() });
      } while (paramOnGetjarLicensesReceivedListener == null);
      paramOnGetjarLicensesReceivedListener.onLicensesReceived(2, null);
      return;
    }
    if (paramOnGetjarLicensesReceivedListener == null) {
      throw new IllegalArgumentException("'licenseListener' cannot be null");
    }
    LicenseEngine.getInstance().getLicenses(paramList, paramOnGetjarLicensesReceivedListener);
  }
  
  public Intent getPurchaseIntent(String paramString)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("'offerLookupKey' cannot be null or empty");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    InAppPurchaseManager.getInstance(getContext()).isApi3BillingSupported();
    return IntentsUtility.getPurchaseIntent(getContext(), paramString);
  }
  
  public Intent getPurchaseIntent(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'developerProductID' cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'productName' cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'productDesc' cannot be null or empty");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("'amount' needs to be greater than or equal to zero");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    paramString1 = new ConsumableProduct(paramString1, paramString2, paramString3, paramLong);
    paramString2 = new ArrayList(1);
    paramString2.add(paramString1);
    return IntentsUtility.getPurchaseIntent(getContext(), paramString2);
  }
  
  public Intent getPurchaseIntent(String paramString1, String paramString2, String paramString3, long paramLong, GetjarLicense.Scope paramScope)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'developerProductID' cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'productName' cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'productDesc' cannot be null or empty");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("'amount' needs to be greater than or equal to zero");
    }
    if (paramScope == null) {
      throw new IllegalArgumentException("'licenseScope' cannot be null");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    paramString1 = new LicensableProduct(paramString1, paramString2, paramString3, paramLong, paramScope);
    paramString2 = new ArrayList(1);
    paramString2.add(paramString1);
    return IntentsUtility.getPurchaseIntent(getContext(), paramString2);
  }
  
  public String getUiTitle()
  {
    return this._builder._uiTitle;
  }
  
  public Intent getWalletIntent()
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    return IntentsUtility.getWalletUiIntent(getContext());
  }
  
  public boolean hasAppConfigValue(String paramString)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    return GetJarConfig.getInstance(getContext()).hasValue(paramString, SettingsManager.Scope.APP);
  }
  
  public boolean isAdAvailable(String paramString)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
    }
    return AdManager.getInstance().isAdAvailable(paramString);
  }
  
  public boolean isConnected()
  {
    AuthManager.initialize(getContext());
    return (AuthManager.getInstance().isAuthed()) && (this._initialConnectionResolved);
  }
  
  public void notifyAdTriggered(String paramString)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'inventoryId' cannot be null or empty");
    }
    for (;;)
    {
      com.getjar.sdk.data.cache.Ad localAd;
      try
      {
        AuthManager.initialize(getContext());
        if (!AuthManager.getInstance().getClaimsManager(getContext()).canUseCustomAds()) {
          throw new IllegalStateException("The provided Application Token is not allowed to use custom ads");
        }
      }
      catch (UnauthorizedException paramString)
      {
        Logger.e(Area.DEVELOPER_API.value(), paramString, "%1$s notifyAdTriggered() failed", new Object[] { getLoggingPrefix() });
        return;
        localAd = AdManager.getInstance().getSpecificAd(paramString);
        if (localAd == null) {
          continue;
        }
        RewardUtility.requestInstall(localAd.getProductMarketplaceApplicationId(), localAd.getProductTitle(), localAd.getDownloadUrl(), localAd.getAppMetadata(), localAd.getTrackingMetadata(), Constants.RequestInstallType.EARN, localAd.getAdPlacementTag(), localAd.getEarnVirtualCurrencyKey(), AdManager.AdType.CUSTOM, getContext());
        AdManager.getInstance().updateAdState(paramString, Ad.State.TRIGGERED, AdManager.AdType.CUSTOM);
        try
        {
          HashMap localHashMap = Utility.jsonArrayStringToMap(localAd.getTrackingMetadata());
          localHashMap.put("ads.layout_type", AdManager.AdType.CUSTOM.name());
          if (localAd.getAdPlacementTag() == null)
          {
            paramString = "";
            localHashMap.put("ads.placement", paramString);
            BeaconManager.getInstance(getContext()).initiateBeaconMessage(this._commContext, BeaconMessage.BeaconType.AD_TRIGGERED, localHashMap);
            return;
          }
        }
        catch (Exception paramString)
        {
          Logger.e(Area.DEVELOPER_API.value(), paramString, "%1$s notifyAdTriggered() beacon call failed", new Object[] { getLoggingPrefix() });
          return;
        }
      }
      catch (AuthException paramString)
      {
        Logger.e(Area.DEVELOPER_API.value(), paramString, "%1$s notifyAdTriggered() failed", new Object[] { getLoggingPrefix() });
        return;
      }
      paramString = localAd.getAdPlacementTag();
    }
  }
  
  public void prepareAd(String paramString)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    AdManager.getInstance().fetchAds(paramString);
  }
  
  public void prepareAd(String paramString, OnAdAvailableListener paramOnAdAvailableListener)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
    }
    if (paramOnAdAvailableListener == null) {
      throw new IllegalArgumentException("'adAvailableCallback' cannot be null");
    }
    if (!this._builder._isManifestValid) {
      throw new GetjarException("Invalid AndroidManifest.xml file (check LogCat for details)");
    }
    AdManager.getInstance().fetchAds(paramString, paramOnAdAvailableListener);
  }
  
  public void redeemVoucher(String paramString1, String paramString2, OnGetjarVoucherRedeemedListener paramOnGetjarVoucherRedeemedListener)
  {
    if (!this._initialConnectionResolved) {
      throw new IllegalStateException("GetjarClient.connect() must complete successfully before API calls can be made");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'voucherToken' cannot be null or empty");
    }
    if (paramOnGetjarVoucherRedeemedListener == null) {
      throw new IllegalArgumentException("'redeemListener' cannot be null");
    }
    RedemptionEngine.redeemVoucher(this._commContext, paramString1, paramString2, paramOnGetjarVoucherRedeemedListener);
  }
  
  public void setCurrentAccount(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'accountName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'authProviderKey' cannot be NULL or empty");
    }
    if (!"getjar.android_account".equals(paramString2)) {
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported 'appAuthProviderKey' value [%1$s]", new Object[] { paramString2 }));
    }
    try
    {
      _ExecutorServiceForConnect.execute(new ConnectionRunnable(paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      Logger.e(Area.DEVELOPER_API.value(), paramString1, "%1$s failed", new Object[] { getLoggingPrefix() });
      this._builder._connectionCallbacks.onConnectionFailed(new GetjarConnectionResult(false, 13, null));
    }
  }
  
  public static final class Builder
  {
    private static String _ApplicationToken;
    private String _appAccountName = null;
    private String _appAuthProviderKey = null;
    private final OnGetjarWorkFinishedListener _backgroundWorkListener;
    private final GetjarConnectionCallbacks _connectionCallbacks;
    private final Context _context;
    private final Intent _intent;
    private final boolean _isManifestValid;
    private String _uiTitle = null;
    
    public Builder(String paramString, Context paramContext, Intent paramIntent, OnGetjarWorkFinishedListener paramOnGetjarWorkFinishedListener, GetjarConnectionCallbacks paramGetjarConnectionCallbacks)
    {
      if (RemoteClient.IsUsed()) {
        throw new IllegalStateException("Any given process may only use either GetjarClient or RemoteClient, but never both.");
      }
      GetjarClient.access$1602(true);
      if (StringUtility.isNullOrEmpty(paramString)) {
        throw new IllegalArgumentException("'applicationToken' cannot be NULL or empty");
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("'context' cannot be NULL");
      }
      if (paramIntent == null) {
        throw new IllegalArgumentException("'intent' cannot be NULL");
      }
      if (paramOnGetjarWorkFinishedListener == null) {
        throw new IllegalArgumentException("'backgroundWorkListener' cannot be NULL");
      }
      if (paramGetjarConnectionCallbacks == null) {
        throw new IllegalArgumentException("'connectionCallbacks' cannot be NULL");
      }
      if (paramString.length() != 36) {
        throw new IllegalArgumentException("'applicationToken' must be 36 characters long");
      }
      UUID.fromString(paramString);
      if ((!StringUtility.isNullOrEmpty(_ApplicationToken)) && (!paramString.equals(_ApplicationToken))) {
        throw new IllegalArgumentException("'A different Application Token was used before. Please use only a single Application Token in the app.");
      }
      this._isManifestValid = CommManager.validateManifestFile(paramContext);
      _ApplicationToken = paramString;
      this._context = paramContext;
      this._intent = paramIntent;
      this._connectionCallbacks = paramGetjarConnectionCallbacks;
      this._backgroundWorkListener = paramOnGetjarWorkFinishedListener;
      AdvertisingIdHelper.getInstance(this._context);
      int i;
      if (!paramString.equalsIgnoreCase(ApplicationTokenDatabase.getInstance(paramContext).getApplicationToken())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          ApplicationTokenDatabase.getInstance(paramContext).setApplicationToken(paramString);
          AuthManager.initialize(paramContext);
          AuthManager.getInstance().clearAuth();
        }
        Logger.v(Area.DEVELOPER_API.value(), "%1$s Calling configureAppenders()", new Object[] { GetjarClient.access$700() });
        try
        {
          Logger.getInstance().configureAppenders(paramContext);
          if (RewardUtility.checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkStateReceiver.getInstance().registerReceiver(paramContext);
          }
          return;
          i = 0;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Logger.e(Area.DEVELOPER_API.value() | Area.CONFIG.value(), paramString, "%1$s configureAppenders() failed", new Object[] { GetjarClient.access$700() });
          }
        }
      }
    }
    
    public GetjarClient create()
    {
      AlarmsUtility.ensureBackgroundMonitoringAlarm(this._context);
      return new GetjarClient(this, null);
    }
    
    public Builder setAccountName(String paramString1, String paramString2)
    {
      if (StringUtility.isNullOrEmpty(paramString1)) {
        throw new IllegalArgumentException("'appAccountName' cannot be NULL or empty");
      }
      if (StringUtility.isNullOrEmpty(paramString2)) {
        throw new IllegalArgumentException("'appAuthProviderKey' cannot be NULL or empty");
      }
      if (!"getjar.android_account".equals(paramString2)) {
        throw new IllegalArgumentException(String.format(Locale.US, "Unsupported 'appAuthProviderKey' value [%1$s]", new Object[] { paramString2 }));
      }
      this._appAccountName = paramString1;
      this._appAuthProviderKey = paramString2;
      return this;
    }
    
    public Builder setAccountPickerTitle(String paramString)
    {
      if (StringUtility.isNullOrEmpty(paramString)) {
        throw new IllegalArgumentException("'uiTitle' cannot be NULL or empty");
      }
      this._uiTitle = paramString;
      return this;
    }
  }
  
  private class ConnectionRunnable
    implements Runnable
  {
    private final String _accountName;
    private final String _authProviderKey;
    
    public ConnectionRunnable()
    {
      this._accountName = null;
      this._authProviderKey = null;
    }
    
    public ConnectionRunnable(String paramString1, String paramString2)
    {
      this._accountName = paramString1;
      this._authProviderKey = paramString2;
    }
    
    private ProviderHint buildProviderHintFromIntent(Intent paramIntent)
    {
      String str = paramIntent.getStringExtra("auth.provider_filter.name");
      if (StringUtility.isNullOrEmpty(str)) {
        Logger.v(Area.DEVELOPER_API.value(), "'getjarIntent' does not contain a provider filter value", new Object[] { GetjarClient.access$700() });
      }
      HashMap localHashMap;
      for (;;)
      {
        return null;
        paramIntent = paramIntent.getStringExtra("auth.provider_filter.data");
        if (StringUtility.isNullOrEmpty(paramIntent))
        {
          Logger.v(Area.DEVELOPER_API.value(), "'getjarIntent' does not contain provider filter data", new Object[] { GetjarClient.access$700() });
        }
        else
        {
          localHashMap = ProviderHint.parseData(paramIntent);
          if ((localHashMap != null) && (localHashMap.size() > 0)) {
            break;
          }
          Logger.v(Area.DEVELOPER_API.value(), "'getjarIntent' does not contain provider filter data that can be parsed [%1$s]", new Object[] { paramIntent });
        }
      }
      return new ProviderHint(str, localHashMap);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   3: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   6: ldc 93
      //   8: iconst_1
      //   9: anewarray 4	java/lang/Object
      //   12: dup
      //   13: iconst_0
      //   14: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   17: aastore
      //   18: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   21: aload_0
      //   22: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   25: invokestatic 97	com/getjar/sdk/GetjarClient:access$800	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$Builder;
      //   28: invokestatic 103	com/getjar/sdk/GetjarClient$Builder:access$000	(Lcom/getjar/sdk/GetjarClient$Builder;)Landroid/content/Context;
      //   31: invokestatic 109	com/getjar/sdk/comm/auth/AuthManager:initialize	(Landroid/content/Context;)V
      //   34: invokestatic 113	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   37: aload_0
      //   38: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   41: invokestatic 117	com/getjar/sdk/GetjarClient:access$900	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$DeveloperAPIAuthListener;
      //   44: invokevirtual 121	com/getjar/sdk/comm/auth/AuthManager:unregisterCallbacks	(Lcom/getjar/sdk/comm/auth/AuthManager$AuthListener;)V
      //   47: aload_0
      //   48: getfield 23	com/getjar/sdk/GetjarClient$ConnectionRunnable:_accountName	Ljava/lang/String;
      //   51: invokestatic 43	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
      //   54: ifne +187 -> 241
      //   57: aload_0
      //   58: getfield 25	com/getjar/sdk/GetjarClient$ConnectionRunnable:_authProviderKey	Ljava/lang/String;
      //   61: invokestatic 43	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
      //   64: ifne +177 -> 241
      //   67: invokestatic 113	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   70: aload_0
      //   71: getfield 23	com/getjar/sdk/GetjarClient$ConnectionRunnable:_accountName	Ljava/lang/String;
      //   74: new 123	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider
      //   77: dup
      //   78: invokespecial 124	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:<init>	()V
      //   81: invokevirtual 127	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
      //   84: invokevirtual 131	com/getjar/sdk/comm/auth/AuthManager:setAccount	(Ljava/lang/String;Ljava/lang/String;)Z
      //   87: istore_1
      //   88: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   91: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   94: ldc -123
      //   96: iconst_2
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   105: aastore
      //   106: dup
      //   107: iconst_1
      //   108: iload_1
      //   109: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   112: aastore
      //   113: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   116: aload_0
      //   117: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   120: invokestatic 143	com/getjar/sdk/GetjarClient:access$1100	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/comm/CommContext;
      //   123: invokevirtual 149	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
      //   126: invokestatic 154	com/getjar/sdk/data/usage/UsageMonitor:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageMonitor;
      //   129: invokevirtual 157	com/getjar/sdk/data/usage/UsageMonitor:ensureMonitoring	()V
      //   132: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   135: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   138: ldc -97
      //   140: iconst_1
      //   141: anewarray 4	java/lang/Object
      //   144: dup
      //   145: iconst_0
      //   146: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   149: aastore
      //   150: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   153: invokestatic 113	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   156: invokevirtual 162	com/getjar/sdk/comm/auth/AuthManager:waitOnAuth	()V
      //   159: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   162: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   165: ldc -92
      //   167: iconst_1
      //   168: anewarray 4	java/lang/Object
      //   171: dup
      //   172: iconst_0
      //   173: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   176: aastore
      //   177: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   180: aload_0
      //   181: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   184: invokestatic 167	com/getjar/sdk/GetjarClient:access$1200	(Lcom/getjar/sdk/GetjarClient;)V
      //   187: invokestatic 113	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   190: invokevirtual 171	com/getjar/sdk/comm/auth/AuthManager:isAuthed	()Z
      //   193: ifeq +26 -> 219
      //   196: aload_0
      //   197: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   200: invokestatic 117	com/getjar/sdk/GetjarClient:access$900	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$DeveloperAPIAuthListener;
      //   203: invokestatic 177	com/getjar/sdk/GetjarClient$DeveloperAPIAuthListener:access$1300	(Lcom/getjar/sdk/GetjarClient$DeveloperAPIAuthListener;)V
      //   206: invokestatic 113	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   209: aload_0
      //   210: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   213: invokestatic 117	com/getjar/sdk/GetjarClient:access$900	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$DeveloperAPIAuthListener;
      //   216: invokevirtual 180	com/getjar/sdk/comm/auth/AuthManager:registerCallbacks	(Lcom/getjar/sdk/comm/auth/AuthManager$AuthListener;)V
      //   219: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   222: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   225: ldc -74
      //   227: iconst_1
      //   228: anewarray 4	java/lang/Object
      //   231: dup
      //   232: iconst_0
      //   233: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   236: aastore
      //   237: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   240: return
      //   241: aload_0
      //   242: aload_0
      //   243: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   246: invokestatic 97	com/getjar/sdk/GetjarClient:access$800	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$Builder;
      //   249: invokestatic 186	com/getjar/sdk/GetjarClient$Builder:access$1000	(Lcom/getjar/sdk/GetjarClient$Builder;)Landroid/content/Intent;
      //   252: invokespecial 188	com/getjar/sdk/GetjarClient$ConnectionRunnable:buildProviderHintFromIntent	(Landroid/content/Intent;)Lcom/getjar/sdk/comm/auth/ProviderHint;
      //   255: astore_3
      //   256: aload_3
      //   257: astore_2
      //   258: aload_3
      //   259: ifnonnull +107 -> 366
      //   262: aload_3
      //   263: astore_2
      //   264: aload_0
      //   265: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   268: invokestatic 97	com/getjar/sdk/GetjarClient:access$800	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$Builder;
      //   271: invokestatic 192	com/getjar/sdk/GetjarClient$Builder:access$600	(Lcom/getjar/sdk/GetjarClient$Builder;)Ljava/lang/String;
      //   274: invokestatic 43	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
      //   277: ifne +89 -> 366
      //   280: aload_3
      //   281: astore_2
      //   282: aload_0
      //   283: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   286: invokestatic 97	com/getjar/sdk/GetjarClient:access$800	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$Builder;
      //   289: invokestatic 195	com/getjar/sdk/GetjarClient$Builder:access$500	(Lcom/getjar/sdk/GetjarClient$Builder;)Ljava/lang/String;
      //   292: invokestatic 43	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
      //   295: ifne +71 -> 366
      //   298: aload_3
      //   299: astore_2
      //   300: ldc -59
      //   302: aload_0
      //   303: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   306: invokestatic 97	com/getjar/sdk/GetjarClient:access$800	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$Builder;
      //   309: invokestatic 192	com/getjar/sdk/GetjarClient$Builder:access$600	(Lcom/getjar/sdk/GetjarClient$Builder;)Ljava/lang/String;
      //   312: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   315: ifeq +51 -> 366
      //   318: new 77	java/util/HashMap
      //   321: dup
      //   322: iconst_1
      //   323: invokespecial 206	java/util/HashMap:<init>	(I)V
      //   326: astore_2
      //   327: aload_2
      //   328: ldc -48
      //   330: aload_0
      //   331: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   334: invokestatic 97	com/getjar/sdk/GetjarClient:access$800	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$Builder;
      //   337: invokestatic 195	com/getjar/sdk/GetjarClient$Builder:access$500	(Lcom/getjar/sdk/GetjarClient$Builder;)Ljava/lang/String;
      //   340: invokestatic 213	com/getjar/sdk/utilities/CryptoUtility:getSHA256	(Ljava/lang/String;)Ljava/lang/String;
      //   343: invokevirtual 217	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   346: pop
      //   347: new 71	com/getjar/sdk/comm/auth/ProviderHint
      //   350: dup
      //   351: new 123	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider
      //   354: dup
      //   355: invokespecial 124	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:<init>	()V
      //   358: invokevirtual 127	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
      //   361: aload_2
      //   362: invokespecial 86	com/getjar/sdk/comm/auth/ProviderHint:<init>	(Ljava/lang/String;Ljava/util/HashMap;)V
      //   365: astore_2
      //   366: aload_2
      //   367: ifnonnull +13 -> 380
      //   370: invokestatic 113	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   373: invokevirtual 220	com/getjar/sdk/comm/auth/AuthManager:ensureAuth	()Z
      //   376: istore_1
      //   377: goto -289 -> 88
      //   380: invokestatic 113	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
      //   383: aload_2
      //   384: iconst_0
      //   385: invokevirtual 224	com/getjar/sdk/comm/auth/AuthManager:ensureAuthResetCurrent	(Lcom/getjar/sdk/comm/auth/ProviderHint;Z)Z
      //   388: istore_1
      //   389: goto -301 -> 88
      //   392: astore_2
      //   393: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   396: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   399: ldc -30
      //   401: iconst_2
      //   402: anewarray 4	java/lang/Object
      //   405: dup
      //   406: iconst_0
      //   407: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   410: aastore
      //   411: dup
      //   412: iconst_1
      //   413: aload_2
      //   414: invokevirtual 229	com/getjar/sdk/exceptions/AuthException:getMessage	()Ljava/lang/String;
      //   417: aastore
      //   418: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   421: goto -262 -> 159
      //   424: astore_2
      //   425: aload_0
      //   426: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   429: iconst_0
      //   430: invokestatic 233	com/getjar/sdk/GetjarClient:access$1402	(Lcom/getjar/sdk/GetjarClient;Z)Z
      //   433: pop
      //   434: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   437: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   440: aload_2
      //   441: ldc -21
      //   443: iconst_1
      //   444: anewarray 4	java/lang/Object
      //   447: dup
      //   448: iconst_0
      //   449: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   452: aastore
      //   453: invokestatic 239	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   456: aload_0
      //   457: getfield 18	com/getjar/sdk/GetjarClient$ConnectionRunnable:this$0	Lcom/getjar/sdk/GetjarClient;
      //   460: invokestatic 97	com/getjar/sdk/GetjarClient:access$800	(Lcom/getjar/sdk/GetjarClient;)Lcom/getjar/sdk/GetjarClient$Builder;
      //   463: invokestatic 243	com/getjar/sdk/GetjarClient$Builder:access$200	(Lcom/getjar/sdk/GetjarClient$Builder;)Lcom/getjar/sdk/GetjarConnectionCallbacks;
      //   466: new 245	com/getjar/sdk/GetjarConnectionResult
      //   469: dup
      //   470: iconst_0
      //   471: bipush 13
      //   473: aconst_null
      //   474: invokespecial 248	com/getjar/sdk/GetjarConnectionResult:<init>	(ZILandroid/content/Intent;)V
      //   477: invokeinterface 254 2 0
      //   482: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   485: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   488: ldc -74
      //   490: iconst_1
      //   491: anewarray 4	java/lang/Object
      //   494: dup
      //   495: iconst_0
      //   496: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   499: aastore
      //   500: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   503: return
      //   504: astore_2
      //   505: getstatic 49	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
      //   508: invokevirtual 53	com/getjar/sdk/logging/Area:value	()J
      //   511: ldc -74
      //   513: iconst_1
      //   514: anewarray 4	java/lang/Object
      //   517: dup
      //   518: iconst_0
      //   519: invokestatic 59	com/getjar/sdk/GetjarClient:access$700	()Ljava/lang/String;
      //   522: aastore
      //   523: invokestatic 65	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   526: aload_2
      //   527: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	528	0	this	ConnectionRunnable
      //   87	302	1	bool	boolean
      //   257	127	2	localObject1	Object
      //   392	22	2	localAuthException	AuthException
      //   424	17	2	localException	Exception
      //   504	23	2	localObject2	Object
      //   255	44	3	localProviderHint	ProviderHint
      // Exception table:
      //   from	to	target	type
      //   153	159	392	com/getjar/sdk/exceptions/AuthException
      //   21	88	424	java/lang/Exception
      //   88	153	424	java/lang/Exception
      //   153	159	424	java/lang/Exception
      //   159	219	424	java/lang/Exception
      //   241	256	424	java/lang/Exception
      //   264	280	424	java/lang/Exception
      //   282	298	424	java/lang/Exception
      //   300	366	424	java/lang/Exception
      //   370	377	424	java/lang/Exception
      //   380	389	424	java/lang/Exception
      //   393	421	424	java/lang/Exception
      //   21	88	504	finally
      //   88	153	504	finally
      //   153	159	504	finally
      //   159	219	504	finally
      //   241	256	504	finally
      //   264	280	504	finally
      //   282	298	504	finally
      //   300	366	504	finally
      //   370	377	504	finally
      //   380	389	504	finally
      //   393	421	504	finally
      //   425	482	504	finally
    }
  }
  
  private class DeveloperAPIAuthListener
    implements AuthManager.AuthListener
  {
    private boolean _cachedAuthStatus = false;
    private final String _id = UUID.randomUUID().toString();
    
    private DeveloperAPIAuthListener() {}
    
    private void updateCachedAuthState()
    {
      this._cachedAuthStatus = AuthManager.getInstance().isAuthed();
    }
    
    public int compare(AuthManager.AuthListener paramAuthListener1, AuthManager.AuthListener paramAuthListener2)
    {
      return paramAuthListener1.getUniqueId().compareTo(paramAuthListener2.getUniqueId());
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof AuthManager.AuthListener))) {
        return false;
      }
      return getUniqueId().equals(((AuthManager.AuthListener)paramObject).getUniqueId());
    }
    
    public String getUniqueId()
    {
      return this._id;
    }
    
    public int hashCode()
    {
      return getUniqueId().hashCode();
    }
    
    public void notifyAuthCompleted(boolean paramBoolean)
    {
      try
      {
        if ((AuthManager.getInstance().isAuthed() != this._cachedAuthStatus) || (paramBoolean))
        {
          updateCachedAuthState();
          GetjarClient.this.makeConnectionCallback();
          Logger.v(Area.DEVELOPER_API.value() | Area.AUTH.value(), "%1$s background auth state change, connection callbacks made", new Object[] { GetjarClient.access$700() });
          return;
        }
        updateCachedAuthState();
        return;
      }
      catch (Exception localException)
      {
        Logger.e(Area.DEVELOPER_API.value() | Area.AUTH.value(), localException, "%1$s failed", new Object[] { GetjarClient.access$700() });
      }
    }
    
    public String toString()
    {
      return getUniqueId();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/GetjarClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */