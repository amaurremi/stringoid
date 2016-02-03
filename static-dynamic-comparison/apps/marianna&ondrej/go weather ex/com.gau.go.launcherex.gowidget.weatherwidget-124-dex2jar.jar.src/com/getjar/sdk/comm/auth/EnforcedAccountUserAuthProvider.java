package com.getjar.sdk.comm.auth;

import android.content.Context;
import com.getjar.sdk.comm.AuthorizationServiceProxy;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.RequestUtilities;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.data.MetadataValue.MetadataReliability;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.ScreenUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class EnforcedAccountUserAuthProvider
  implements UserAuthProvider
{
  public static final String KeyPreviousAccountName = "enforced_android_account.previous_account_name";
  public static final String KeySourceAccountNameHash = "enforced_android_account.account_name_hash";
  public static final String KeySourceAppToken = "enforced_android_account.app_token";
  public static final String KeySourceUserAccessId = "enforced_android_account.user_access_id";
  public static final String KeySourceUserDeviceId = "enforced_android_account.user_device_id";
  
  public static String getCurrentAccountName(Context paramContext)
  {
    return new AndroidAccountUserAuthProvider().getCachedAccountName(paramContext);
  }
  
  private Map<String, MetadataValue> getProviderData(CommContext paramCommContext, AuthUIParentInterface paramAuthUIParentInterface, ProviderHint paramProviderHint)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    if (paramProviderHint == null) {
      throw new IllegalArgumentException("'providerHint' cannot be NULL");
    }
    if (paramProviderHint.getData() == null) {
      throw new IllegalArgumentException("'providerHint' must have data");
    }
    paramAuthUIParentInterface = (String)paramProviderHint.getData().get("enforced_android_account.app_token");
    if (StringUtility.isNullOrEmpty(paramAuthUIParentInterface)) {
      throw new IllegalArgumentException("'providerHint' does not contain a value for 'enforced_android_account.app_token'");
    }
    paramProviderHint = paramCommContext.getDeviceMetadata().getMetadataWithReliability();
    if ((paramProviderHint == null) || (paramProviderHint.size() <= 0))
    {
      Logger.w(Area.AUTH.value(), "AuthFlow: EnforcedAccountUserAuthProvider: getProviderData() failed to get device metadata", new Object[0]);
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramProviderHint);
    localHashMap.putAll(ScreenUtility.getDisplayDetails(paramCommContext.getApplicationContext()));
    AuthMetadataUtility.addSDKMetadataValues(localHashMap, paramCommContext.getApplicationContext());
    localHashMap.put("enforced_android_account.app_token", new MetadataValue(paramAuthUIParentInterface, MetadataValue.MetadataReliability.AVAILABLE));
    return localHashMap;
  }
  
  private UserAuthResult makeWrappedProviderCall(CommContext paramCommContext, String paramString1, String paramString2, String paramString3, AuthUIParentInterface paramAuthUIParentInterface, String paramString4)
  {
    Logger.v(Area.AUTH.value(), "AuthFlow: EnforcedAccountUserAuthProvider: makeWrappedProviderCall() for '%1$s'", new Object[] { paramString1 });
    String str = AndroidAccountUserAuthProvider.getAccountNameFromHash(paramCommContext.getApplicationContext(), paramString1);
    if (StringUtility.isNullOrEmpty(str)) {
      paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
    }
    for (;;)
    {
      return paramString1;
      AndroidAccountUserAuthProvider localAndroidAccountUserAuthProvider = new AndroidAccountUserAuthProvider();
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("provider.skip_cache", "true");
      localHashMap.put("android_account.username_data_hash", paramString1);
      paramString2 = localAndroidAccountUserAuthProvider.ensureUser(paramString2, paramCommContext, paramString3, paramAuthUIParentInterface, new ProviderHint(localAndroidAccountUserAuthProvider.getProviderFilter(), localHashMap));
      paramString1 = paramString2;
      try
      {
        if (AuthResult.State.SUCCEEDED.equals(paramString2.getState()))
        {
          paramString1 = paramString2;
          if (!StringUtility.isNullOrEmpty(paramString4))
          {
            paramString1 = paramString2;
            if (!str.equalsIgnoreCase(paramString4))
            {
              AccountHistoryManager.initialize(paramCommContext.getApplicationContext());
              AccountHistoryManager.getInstance().addEvent(paramString2.getUserAccessId(), AccountEventType.USER_SWITCHED);
              return paramString2;
            }
          }
        }
      }
      catch (Exception paramCommContext)
      {
        Logger.e(Area.AUTH.value(), paramCommContext, "AccountHistoryManager work failed", new Object[0]);
      }
    }
    return paramString2;
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
    if (paramProviderHint.getData() == null) {
      throw new IllegalArgumentException("'providerHint' must have data");
    }
    String str1 = (String)paramProviderHint.getData().get("enforced_android_account.account_name_hash");
    Object localObject = (String)paramProviderHint.getData().get("enforced_android_account.app_token");
    String str3 = (String)paramProviderHint.getData().get("enforced_android_account.user_access_id");
    String str4 = (String)paramProviderHint.getData().get("enforced_android_account.user_device_id");
    String str2 = (String)paramProviderHint.getData().get("enforced_android_account.previous_account_name");
    if (StringUtility.isNullOrEmpty(str1))
    {
      if (StringUtility.isNullOrEmpty((String)localObject)) {
        throw new IllegalArgumentException("'providerHint' does not contain a value for 'enforced_android_account.app_token' or 'enforced_android_account.account_name_hash'");
      }
      if (StringUtility.isNullOrEmpty(str3)) {
        throw new IllegalArgumentException("'providerHint' does not contain a value for 'enforced_android_account.user_access_id' or 'enforced_android_account.account_name_hash'");
      }
      if (StringUtility.isNullOrEmpty(str4)) {
        throw new IllegalArgumentException("'providerHint' does not contain a value for 'enforced_android_account.user_device_id' or 'enforced_android_account.account_name_hash'");
      }
    }
    Logger.d(Area.AUTH.value(), "AuthFlow: EnforcedAccountUserAuthProvider: ensureUser() START", new Object[0]);
    try
    {
      if (!StringUtility.isNullOrEmpty(str1))
      {
        paramString1 = makeWrappedProviderCall(paramCommContext, str1, paramString1, paramString2, paramAuthUIParentInterface, str2);
        return paramString1;
      }
      localObject = AuthorizationServiceProxy.getInstance().generateSignature(paramCommContext, paramString2, paramString1, str3, str4, getProviderData(paramCommContext, paramAuthUIParentInterface, paramProviderHint), getProviderFilter()).get();
      if (localObject == null)
      {
        Logger.e(Area.AUTH.value(), "AuthFlow: EnforcedAccountUserAuthProvider: ensureUser() failed to get results", new Object[0]);
        paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
        return paramString1;
      }
      if (!((Result)localObject).isSuccessfulResponse())
      {
        Logger.w(Area.AUTH.value(), "AuthFlow: EnforcedAccountUserAuthProvider: ensureUser() got failure results", new Object[0]);
        paramString1 = RequestUtilities.getServicesException((Result)localObject);
        if (paramString1 != null) {
          paramCommContext.addException(paramString1);
        }
        if (((Result)localObject).checkForNonReAuthableSubCodesAndMakeCallbacks(paramCommContext))
        {
          Logger.d(Area.AUTH.value(), "AuthFlow: EnforcedAccountUserAuthProvider: ensureUser() We are blacklisted or unsupported", new Object[0]);
          paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNSUPPORTED);
          return paramString1;
        }
        paramString1 = new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
        return paramString1;
      }
      str1 = null;
      paramProviderHint = str1;
      if (((Result)localObject).getResponseJson() != null)
      {
        paramProviderHint = str1;
        if (((Result)localObject).getResponseJson().has("return"))
        {
          paramProviderHint = str1;
          if (((Result)localObject).getResponseJson().getJSONObject("return").has("signature")) {
            paramProviderHint = ((Result)localObject).getResponseJson().getJSONObject("return").getString("signature");
          }
        }
      }
      paramString1 = makeWrappedProviderCall(paramCommContext, paramProviderHint, paramString1, paramString2, paramAuthUIParentInterface, str2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Logger.e(Area.AUTH.value(), paramString1, "AuthFlow: EnforcedAccountUserAuthProvider: ensureUser() failed", new Object[0]);
      return new UserAuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
    }
    finally
    {
      Logger.d(Area.AUTH.value(), "AuthFlow: EnforcedAccountUserAuthProvider: ensureUser() DONE", new Object[0]);
    }
  }
  
  public String getProviderFilter()
  {
    return "android_account";
  }
  
  public Map<String, String> getProxiableAuthData(Context paramContext)
  {
    throw new UnsupportedOperationException("EnforcedAccountUserAuthProvider does not support proxied auth");
  }
  
  public boolean isUINeeded(CommContext paramCommContext, String paramString, ProviderHint paramProviderHint)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/EnforcedAccountUserAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */