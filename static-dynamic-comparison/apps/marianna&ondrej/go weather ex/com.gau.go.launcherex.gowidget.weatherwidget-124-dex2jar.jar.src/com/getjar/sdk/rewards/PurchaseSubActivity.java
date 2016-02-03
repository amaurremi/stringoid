package com.getjar.sdk.rewards;

import android.content.Intent;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.exceptions.UnauthorizedException;
import com.getjar.sdk.internal.LicensableProduct;
import java.util.ArrayList;

public class PurchaseSubActivity
  extends GetJarWebViewSubActivity
{
  private final String _baseUrl;
  private final String _uiSpecifier;
  
  PurchaseSubActivity(GetJarActivity paramGetJarActivity, String paramString)
  {
    super(paramGetJarActivity, true);
    this._baseUrl = GetJarConfig.getInstance(paramGetJarActivity).getDirectiveValue("webview.purchase_url", SettingsManager.Scope.CLIENT);
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
    if (!AuthManager.getInstance().getClaimsManager(this.getJarActivity).canPurchaseUnmanagedProducts()) {
      throw new UnauthorizedException("The provided Application Token is not allowed to use Unmanaged Purchase features");
    }
    Object localObject = this.getJarActivity.getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("productList")))
    {
      localObject = ((Intent)localObject).getParcelableArrayListExtra("productList");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0) && ((((ArrayList)localObject).get(0) instanceof LicensableProduct)) && (!AuthManager.getInstance().getClaimsManager(this.getJarActivity).canModifyUnmanagedLicenses())) {
        throw new UnauthorizedException("The provided Application Token is not allowed to use Licensing features");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/PurchaseSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */