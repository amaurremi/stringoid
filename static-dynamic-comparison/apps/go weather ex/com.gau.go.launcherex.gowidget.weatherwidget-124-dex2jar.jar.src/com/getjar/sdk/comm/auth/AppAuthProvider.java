package com.getjar.sdk.comm.auth;

import com.getjar.sdk.comm.AuthorizationServiceProxy;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.comm.ResultCachingManager;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.ScreenUtility;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;

class AppAuthProvider
  implements AuthProvider
{
  private Map<String, MetadataValue> getProviderData(CommContext paramCommContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramCommContext.getDeviceMetadata().getMetadataWithReliability());
    localHashMap.putAll(ScreenUtility.getDisplayDetails(paramCommContext.getApplicationContext()));
    AuthMetadataUtility.addSDKMetadataValues(localHashMap, paramCommContext.getApplicationContext());
    return localHashMap;
  }
  
  protected AuthResult authorizeApplication(CommContext paramCommContext, String paramString)
  {
    Logger.d(Area.AUTH.value(), "AuthFlow: authorizeApplication() START", new Object[0]);
    try
    {
      paramString = AuthorizationServiceProxy.getInstance().authorize(paramCommContext, paramString, getProviderData(paramCommContext), getProviderFilter());
      try
      {
        paramString = paramString.get();
        if (paramString == null)
        {
          Logger.d(Area.AUTH.value(), "AuthFlow: authorizeApplication() Failed to get results, returning NULL", new Object[0]);
          paramCommContext = new AuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
          return paramCommContext;
        }
      }
      catch (InterruptedException paramCommContext)
      {
        Logger.e(Area.AUTH.value(), paramCommContext, "AuthFlow: authorizeApplication() opBaseAuth.get() failed", new Object[0]);
        paramCommContext = new AuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
        return paramCommContext;
      }
      catch (ExecutionException paramCommContext)
      {
        Logger.e(Area.AUTH.value(), paramCommContext, "AuthFlow: authorizeApplication() opBaseAuth.get() failed", new Object[0]);
        paramCommContext = new AuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
        return paramCommContext;
      }
      if (paramString.isSuccessfulResponse())
      {
        paramCommContext = AuthUtilities.getClaimsFromResult(paramString);
        Map localMap = AuthUtilities.getSettingsFromResult(paramString);
        String str = AuthUtilities.getAuthTokenFromHeaders(paramString);
        long l1 = AuthUtilities.getTTLFromClaims(paramCommContext, 172800000L);
        long l2 = ResultCachingManager.getTtlFromResult(paramString).longValue();
        paramCommContext = new AuthResult(getProviderFilter(), str, paramCommContext, localMap, l1, l2);
        Logger.d(Area.AUTH.value(), "AuthFlow: authorizeApplication() DONE [authToken:%1$s, claimsCount:%2$d, ttl:%3$d]", new Object[] { paramCommContext.getAuthToken(), Integer.valueOf(paramCommContext.getClaims().size()), Long.valueOf(paramCommContext.getTTL()) });
        return paramCommContext;
      }
      try
      {
        boolean bool = paramString.checkForNonReAuthableSubCodesAndMakeCallbacks(paramCommContext);
        if (bool)
        {
          Logger.d(Area.AUTH.value(), "AuthFlow: authorizeApplication() We are blacklisted or unsupported", new Object[0]);
          paramCommContext = new AuthResult(getProviderFilter(), AuthResult.State.UNSUPPORTED);
          return paramCommContext;
        }
      }
      catch (JSONException paramCommContext)
      {
        Logger.e(Area.AUTH.value(), paramCommContext, "AuthFlow: authorizeApplication() result.checkForBlacklistedOrUnsupported() failed", new Object[0]);
        paramCommContext = new AuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
        return paramCommContext;
      }
      paramCommContext = new AuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
      return paramCommContext;
    }
    catch (Exception paramCommContext)
    {
      Logger.e(Area.AUTH.value(), paramCommContext, "AuthFlow: authorizeApplication() failed", new Object[0]);
      return new AuthResult(getProviderFilter(), AuthResult.State.UNKNOWN_FAILURE);
    }
    finally
    {
      Logger.d(Area.AUTH.value(), "AuthFlow: authorizeApplication() DONE", new Object[0]);
    }
  }
  
  public String getProviderFilter()
  {
    return "app";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AppAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */