package com.getjar.sdk.comm.auth;

import android.content.Context;
import com.getjar.sdk.comm.AuthorizationServiceProxy;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.RequestUtilities;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.comm.ResultCachingManager;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.data.MetadataValue.MetadataReliability;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.ScreenUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ProxyAccountUserAuthProvider
  implements UserAuthProvider
{
  public static final String _KeyProviderHintUserDeviceHash = "android_account.user_device_hash";
  public static final String _KeyProviderHintUsernameDataHash = "android_account.username_data_hash";
  
  private Map<String, MetadataValue> getProviderData(CommContext paramCommContext, ProviderHint paramProviderHint)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    validateProviderHint(paramProviderHint);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source.provider_filter", new MetadataValue(paramProviderHint.getFilter(), MetadataValue.MetadataReliability.AVAILABLE));
    localHashMap.put("android_account.username_data_hash", new MetadataValue((String)paramProviderHint.getData().get("android_account.username_data_hash"), MetadataValue.MetadataReliability.AVAILABLE));
    localHashMap.put("android_account.user_device_hash", new MetadataValue((String)paramProviderHint.getData().get("android_account.user_device_hash"), MetadataValue.MetadataReliability.AVAILABLE));
    paramProviderHint = paramCommContext.getDeviceMetadata().getMetadataWithReliability();
    if ((paramProviderHint == null) || (paramProviderHint.size() <= 0))
    {
      Logger.w(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: getProviderData() failed to get device metadata", new Object[0]);
      return null;
    }
    localHashMap.putAll(paramProviderHint);
    localHashMap.putAll(ScreenUtility.getDisplayDetails(paramCommContext.getApplicationContext()));
    AuthMetadataUtility.addSDKMetadataValues(localHashMap, paramCommContext.getApplicationContext());
    return localHashMap;
  }
  
  private boolean isProviderHintForMe(ProviderHint paramProviderHint)
  {
    return (paramProviderHint != null) && (paramProviderHint.getFilter().equals(getProviderFilter()));
  }
  
  private void validateProviderHint(ProviderHint paramProviderHint)
  {
    if ((isProviderHintForMe(paramProviderHint)) && ((!paramProviderHint.getData().containsKey("android_account.username_data_hash")) || (StringUtility.isNullOrEmpty((String)paramProviderHint.getData().get("android_account.username_data_hash"))) || (!paramProviderHint.getData().containsKey("android_account.user_device_hash")) || (StringUtility.isNullOrEmpty((String)paramProviderHint.getData().get("android_account.user_device_hash"))))) {
      throw new IllegalArgumentException("'providerHint' does not contain required data");
    }
  }
  
  public UserAuthResult ensureUser(String paramString1, CommContext paramCommContext, String paramString2, AuthUIParentInterface paramAuthUIParentInterface, ProviderHint paramProviderHint)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'currentAuthToken' cannot be NULL or empty");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'authFlowId' cannot be NULL or empty");
    }
    if (paramProviderHint == null) {
      throw new IllegalArgumentException("'providerHint' cannot be NULL");
    }
    validateProviderHint(paramProviderHint);
    Logger.d(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() START", new Object[0]);
    try
    {
      Logger.d(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() Calling validateAuth()", new Object[0]);
      paramString1 = AuthorizationServiceProxy.getInstance().validateAuth(paramCommContext, paramString2, paramString1, getProviderData(paramCommContext, paramProviderHint), getProviderFilter());
      try
      {
        paramString2 = paramString1.get();
        if (paramString2 == null)
        {
          Logger.e(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() failed to get results", new Object[0]);
          paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
          return paramString1;
        }
      }
      catch (InterruptedException paramString1)
      {
        Logger.e(Area.AUTH.value(), paramString1, "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() operation.get() failed", new Object[0]);
        paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
        return paramString1;
      }
      catch (ExecutionException paramString1)
      {
        Logger.e(Area.AUTH.value(), paramString1, "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() operation.get() failed", new Object[0]);
        paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
        return paramString1;
      }
      if (paramString2.isSuccessfulResponse())
      {
        Logger.d(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() got successful results", new Object[0]);
        paramAuthUIParentInterface = AuthUtilities.getClaimsFromResult(paramString2);
        paramProviderHint = AuthUtilities.getSettingsFromResult(paramString2);
        String str = AuthUtilities.getAuthTokenFromHeaders(paramString2);
        long l1 = AuthUtilities.getTTLFromClaims(paramAuthUIParentInterface, 172800000L);
        long l2 = ResultCachingManager.getTtlFromResult(paramString2).longValue();
        paramString1 = null;
        paramCommContext = null;
        if (paramAuthUIParentInterface != null)
        {
          paramString1 = (String)paramAuthUIParentInterface.get("claims.user.user_access_id");
          paramCommContext = (String)paramAuthUIParentInterface.get("claims.user.device.id");
        }
        paramString1 = new UserAuthResult(getProviderFilter(), paramString1, paramCommContext, paramString2.isSuccessfulCreationResponse(), str, paramAuthUIParentInterface, paramProviderHint, l1, l2);
        Logger.d(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() DONE [userAccessId:%1$s, userDeviceId%2$s, authToken:%3$s, claimsCount:%4$d, ttl:%5$d]", new Object[] { paramString1.getUserAccessId(), paramString1.getUserDeviceId(), paramString1.getAuthToken(), Integer.valueOf(paramString1.getClaims().size()), Long.valueOf(paramString1.getTTL()) });
        return paramString1;
      }
      Logger.w(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() got failure results", new Object[0]);
      paramString1 = RequestUtilities.getServicesException(paramString2);
      if (paramString1 != null) {
        paramCommContext.addException(paramString1);
      }
      if (paramString2.checkForNonReAuthableSubCodesAndMakeCallbacks(paramCommContext))
      {
        Logger.d(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() We are blacklisted or unsupported", new Object[0]);
        paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNSUPPORTED);
        return paramString1;
      }
      paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Logger.e(Area.AUTH.value(), paramString1, "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() failed", new Object[0]);
      return new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
    }
    finally
    {
      Logger.d(Area.AUTH.value(), "AuthFlow: ProxyAccountUserAuthProvider: ensureUser() DONE", new Object[0]);
    }
  }
  
  public String getProviderFilter()
  {
    return "proxy_account";
  }
  
  public Map<String, String> getProxiableAuthData(Context paramContext)
  {
    throw new UnsupportedOperationException("'ProxyAccountUserAuthProvider' does not support getHashedAuthData()");
  }
  
  public boolean isUINeeded(CommContext paramCommContext, String paramString, ProviderHint paramProviderHint)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/ProxyAccountUserAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */