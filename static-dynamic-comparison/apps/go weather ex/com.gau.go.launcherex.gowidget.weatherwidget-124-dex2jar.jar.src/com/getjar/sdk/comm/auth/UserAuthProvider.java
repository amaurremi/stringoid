package com.getjar.sdk.comm.auth;

import android.content.Context;
import com.getjar.sdk.comm.CommContext;
import java.util.Map;

public abstract interface UserAuthProvider
  extends AuthProvider
{
  public abstract UserAuthResult ensureUser(String paramString1, CommContext paramCommContext, String paramString2, AuthUIParentInterface paramAuthUIParentInterface, ProviderHint paramProviderHint);
  
  public abstract Map<String, String> getProxiableAuthData(Context paramContext);
  
  public abstract boolean isUINeeded(CommContext paramCommContext, String paramString, ProviderHint paramProviderHint);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/UserAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */