package com.getjar.sdk.rewards;

import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.exceptions.UnauthorizedException;

public class WalletSubActivity
  extends GetJarWebViewSubActivity
{
  private final String _baseUrl;
  private final String _uiSpecifier;
  
  WalletSubActivity(GetJarActivity paramGetJarActivity, String paramString)
  {
    super(paramGetJarActivity, false);
    this._baseUrl = GetJarConfig.getInstance(paramGetJarActivity).getDirectiveValue("webview.wallet_url", SettingsManager.Scope.CLIENT);
    this._uiSpecifier = paramString;
  }
  
  protected String getBaseUrl()
  {
    return this._baseUrl;
  }
  
  protected String getUiSpecifier()
  {
    return this._uiSpecifier;
  }
  
  public void onResume()
  {
    super.onResume();
    AuthManager.initialize(this.getJarActivity);
    if (!AuthManager.getInstance().getClaimsManager(this.getJarActivity).canUseWallet()) {
      throw new UnauthorizedException("The provided Application Token is not allowed to use the Wallet features");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/WalletSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */