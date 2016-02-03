package com.getjar.sdk.comm.auth;

import android.content.Context;
import android.content.SharedPreferences;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ClaimsManager
{
  public static final String KeyClaimsUserAccessID = "claims.user.user_access_id";
  public static final String KeyClaimsUserDeviceID = "claims.user.device.id";
  private static final String _BillingPermission = "com.android.vending.BILLING";
  private static volatile ClaimsManager _Instance = null;
  private final Context _context;
  
  private ClaimsManager(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    this._context = paramContext;
  }
  
  private boolean checkBooleanClaim(Map<String, String> paramMap, String paramString)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("'claims' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be NULL or empty");
    }
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (paramString.equals(localEntry.getKey()))
        {
          boolean bool = Boolean.parseBoolean((String)localEntry.getValue());
          Logger.v(Area.AUTH.value(), "Auth: ClaimsManager: checkBooleanClaim() returning %1$s for %2$s", new Object[] { Boolean.valueOf(bool), paramString });
          return bool;
        }
      }
    }
    catch (Exception paramMap)
    {
      Logger.e(Area.AUTH.value(), paramMap, "Auth: ClaimsManager: checkBooleanClaim() failed", new Object[0]);
      Logger.v(Area.AUTH.value(), "Auth: ClaimsManager: checkBooleanClaim() returning false for %1$s", new Object[] { paramString });
    }
    return false;
  }
  
  private boolean checkForClaim(Map<String, String> paramMap, String paramString)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("'claims' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be NULL or empty");
    }
    return paramMap.containsKey(paramString);
  }
  
  protected static ClaimsManager getInstance()
  {
    if (_Instance == null) {
      throw new IllegalStateException("ClaimsManager.initialize() must be called first");
    }
    return _Instance;
  }
  
  protected static void initialize(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new ClaimsManager(paramContext);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public boolean canBuy()
  {
    if (!RewardUtility.checkPermission(this._context, "com.android.vending.BILLING"))
    {
      Logger.i(Area.AUTH.value() | Area.BUY_GOLD.value(), "Auth: ClaimsManager: canBuy() returning FALSE", new Object[0]);
      return false;
    }
    Map localMap = getCapabilities();
    if (!checkBooleanClaim(localMap, "user.currency.buy"))
    {
      Logger.i(Area.AUTH.value() | Area.BUY_GOLD.value(), "Auth: ClaimsManager: canBuy() returning FALSE", new Object[0]);
      return false;
    }
    if (!checkBooleanClaim(localMap, "app.currency.buy"))
    {
      Logger.i(Area.AUTH.value() | Area.BUY_GOLD.value(), "Auth: ClaimsManager: canBuy() returning FALSE", new Object[0]);
      return false;
    }
    if (!checkBooleanClaim(localMap, "app.currency.buy_as_merchant"))
    {
      Logger.i(Area.AUTH.value() | Area.BUY_GOLD.value(), "Auth: ClaimsManager: canBuy() returning FALSE", new Object[0]);
      return false;
    }
    if (!this._context.getSharedPreferences("GetJarClientPrefs", 0).getBoolean("billing_supported", true))
    {
      Logger.i(Area.AUTH.value() | Area.BUY_GOLD.value(), "Auth: ClaimsManager: canBuy() returning FALSE [isBillingSupported]", new Object[0]);
      return false;
    }
    Logger.i(Area.AUTH.value() | Area.BUY_GOLD.value(), "Auth: ClaimsManager: canBuy() returning TRUE", new Object[0]);
    return true;
  }
  
  public boolean canEarn()
  {
    Map localMap = getCapabilities();
    boolean bool2 = checkBooleanClaim(localMap, "user.currency.earn");
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (!checkForClaim(localMap, "user.currency.earn"))
      {
        Logger.e(Area.AUTH.value() | Area.EARN.value(), "Auth: ClaimsManager: canEarn() missing 'user.currency.earn' capability", new Object[0]);
        bool1 = true;
      }
    }
    boolean bool3 = checkBooleanClaim(localMap, "app.currency.earn");
    bool2 = bool3;
    if (!bool3)
    {
      bool2 = bool3;
      if (!checkForClaim(localMap, "app.currency.earn"))
      {
        Logger.e(Area.AUTH.value() | Area.EARN.value(), "Auth: ClaimsManager: canEarn() missing 'app.currency.earn' capability", new Object[0]);
        bool2 = true;
      }
    }
    long l1 = Area.AUTH.value();
    long l2 = Area.EARN.value();
    if ((bool1) && (bool2)) {}
    for (bool3 = true;; bool3 = false)
    {
      Logger.i(l1 | l2, "Auth: ClaimsManager: canEarn() userCurrencyEarn=%1$s appCurrencyEarn=%2$s returning %3$s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool1) || (!bool2)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean canModifyUnmanagedLicenses()
  {
    Map localMap = getCapabilities();
    if (!checkBooleanClaim(localMap, "user.product_licenses.modify"))
    {
      Logger.i(Area.AUTH.value() | Area.LICENSING.value(), "Auth: ClaimsManager: canModifyUnmanagedLicenses() returning FALSE", new Object[0]);
      return false;
    }
    if (!checkBooleanClaim(localMap, "app.unmanaged_product_licenses.modify"))
    {
      Logger.i(Area.AUTH.value() | Area.LICENSING.value(), "Auth: ClaimsManager: canModifyUnmanagedLicenses() returning FALSE", new Object[0]);
      return false;
    }
    Logger.i(Area.AUTH.value() | Area.LICENSING.value(), "Auth: ClaimsManager: canModifyUnmanagedLicenses() returning TRUE", new Object[0]);
    return true;
  }
  
  public boolean canPurchaseManagedProducts()
  {
    Map localMap = getCapabilities();
    if (!checkBooleanClaim(localMap, "user.products.purchase"))
    {
      Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canPurchaseManagedProducts() returning FALSE", new Object[0]);
      return false;
    }
    if (!checkBooleanClaim(localMap, "app.managed_products.purchase"))
    {
      Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canPurchaseManagedProducts() returning FALSE", new Object[0]);
      return false;
    }
    if (!RewardUtility.checkPermission(this._context, "com.android.vending.BILLING"))
    {
      Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canPurchaseManagedProducts() returning FALSE", new Object[0]);
      return false;
    }
    return true;
  }
  
  public boolean canPurchaseUnmanagedProducts()
  {
    Map localMap = getCapabilities();
    if (!checkBooleanClaim(localMap, "app.unmanaged_products.purchase"))
    {
      Logger.i(Area.AUTH.value() | Area.PURCHASE.value(), "Auth: ClaimsManager: canPurchaseUnmanagedProducts() returning FALSE", new Object[0]);
      return false;
    }
    if (!checkBooleanClaim(localMap, "user.products.purchase"))
    {
      Logger.i(Area.AUTH.value() | Area.PURCHASE.value(), "Auth: ClaimsManager: canPurchaseUnmanagedProducts() returning FALSE", new Object[0]);
      return false;
    }
    Logger.i(Area.AUTH.value() | Area.PURCHASE.value(), "Auth: ClaimsManager: canPurchaseUnmanagedProducts() returning TRUE", new Object[0]);
    return true;
  }
  
  public boolean canUseCustomAds()
  {
    if (!checkBooleanClaim(getCapabilities(), "app.ad_definition.use"))
    {
      Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canUseCustomAds() returning FALSE", new Object[0]);
      return false;
    }
    Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canUseCustomAds() returning TRUE", new Object[0]);
    return true;
  }
  
  public boolean canUseUnmanagedLicenses()
  {
    Map localMap = getCapabilities();
    if (!checkBooleanClaim(localMap, "user.product_licenses.use"))
    {
      Logger.i(Area.AUTH.value() | Area.LICENSING.value(), "Auth: ClaimsManager: canUseUnmanagedLicenses() returning FALSE", new Object[0]);
      return false;
    }
    if (!checkBooleanClaim(localMap, "app.unmanaged_product_licenses.use"))
    {
      Logger.i(Area.AUTH.value() | Area.LICENSING.value(), "Auth: ClaimsManager: canUseUnmanagedLicenses() returning FALSE", new Object[0]);
      return false;
    }
    Logger.i(Area.AUTH.value() | Area.LICENSING.value(), "Auth: ClaimsManager: canUseUnmanagedLicenses() returning TRUE", new Object[0]);
    return true;
  }
  
  public boolean canUseWallet()
  {
    if (!checkBooleanClaim(getCapabilities(), "app.profile.wallet"))
    {
      Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canUseWallet() returning FALSE", new Object[0]);
      return false;
    }
    Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canUseWallet() returning TRUE", new Object[0]);
    return true;
  }
  
  public boolean canViewManagedProducts()
  {
    if (!checkBooleanClaim(getCapabilities(), "app.managed_products.view"))
    {
      Logger.i(Area.AUTH.value() | Area.OFFER.value(), "Auth: ClaimsManager: canViewManagedProducts() returning FALSE", new Object[0]);
      return false;
    }
    return true;
  }
  
  public Map<String, String> getCapabilities()
  {
    AuthManager.initialize(this._context);
    AuthManager.getInstance().waitOnAuth();
    return AuthManager.getInstance().getCapabilities();
  }
  
  public boolean hasGetjarPass()
  {
    if (checkBooleanClaim(getCapabilities(), "user.getjar_pass.use"))
    {
      Logger.i(Area.AUTH.value() | Area.GETJAR_PASS.value(), "Auth: ClaimsManager: hasGetjarPass() returning TRUE", new Object[0]);
      return true;
    }
    Logger.i(Area.AUTH.value() | Area.GETJAR_PASS.value(), "Auth: ClaimsManager: hasGetjarPass() returning FALSE", new Object[0]);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/ClaimsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */