package com.getjar.sdk.rewards;

import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;

public class ShopSubActivity
  extends GetJarWebViewSubActivity
{
  private final String _baseUrl;
  private final String _uiSpecifier;
  
  ShopSubActivity(GetJarActivity paramGetJarActivity, String paramString)
  {
    super(paramGetJarActivity, true);
    this._baseUrl = GetJarConfig.getInstance(paramGetJarActivity).getDirectiveValue("webview.shop_url", SettingsManager.Scope.CLIENT);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/ShopSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */