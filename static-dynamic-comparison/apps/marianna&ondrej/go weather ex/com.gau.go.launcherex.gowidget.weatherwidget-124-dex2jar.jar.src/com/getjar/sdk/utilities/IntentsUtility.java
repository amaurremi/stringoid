package com.getjar.sdk.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.getjar.sdk.GetjarLicense;
import com.getjar.sdk.comm.auth.AndroidAccountUserAuthProvider;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.exceptions.AuthException;
import com.getjar.sdk.internal.Product;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.rewards.GetJarActivity;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class IntentsUtility
{
  private static final String GetjarPayloadIntentKey = "getjar.payload";
  public static final String INTENT_FORCE_AUTH = "forceAuthToGivenAccount";
  public static final String INTENT_OFFER_LOOKUP_KEY = "offer_lookup_key";
  public static final String INTENT_PRODUCT_LIST_KEY = "productList";
  public static final String INTENT_TYPE_DEAL_REDEMPTION = "redeemDeal";
  public static final String INTENT_TYPE_KEY = "getjarIntentType";
  public static final String INTENT_TYPE_SHOW_ACCOUNT_PICKER = "accountPicker";
  public static final String INTENT_TYPE_SHOW_ACCOUNT_PICKER_OLD = "accountPickerOld";
  public static final String INTENT_TYPE_SHOW_EARN = "showEarn";
  public static final String INTENT_TYPE_SHOW_INTERSTITIAL = "showInterstitial";
  public static final String INTENT_TYPE_SHOW_MANAGED_PURCHASE = "showManagedPurchase";
  public static final String INTENT_TYPE_SHOW_PURCHASE = "showPurchase";
  public static final String INTENT_TYPE_SHOW_SHOP = "showShop";
  public static final String INTENT_TYPE_SHOW_WALLET = "showWallet";
  public static final String INTENT_UI_CLEAR_HISTORY = "clearHistoryOnFirstLoad";
  public static final String INTENT_UI_CLEAR_NOTIFICATION_TYPES = "notificationTypesToClear";
  public static final String INTENT_UI_SPECIFIER = "uiSpecifier";
  private static final String UserDeviceHashKey = "android_account.user_device_hash";
  
  private static void addCheckoutIntentExtras(Intent paramIntent, String paramString)
  {
    addCommonIntentExtras(paramIntent);
    paramIntent.putExtra("getjarIntentType", "showShop");
    paramIntent.putExtra("uiSpecifier", "#checkout");
    paramIntent.putExtra("EXTRA_MANAGED_CHECKOUT_DATA", paramString);
  }
  
  private static void addCommonIntentExtras(Intent paramIntent)
  {
    paramIntent.putExtra("getjar", true);
    paramIntent.putExtra("getjar.sdk_level", 19);
  }
  
  private static void addGetjarPayloadIntentExtra(Context paramContext, Intent paramIntent)
    throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("provider_filter_name", "android_account");
    localJSONObject.put("provider_filter_data", getProviderFilterJson(paramContext));
    paramContext = new JSONObject();
    paramContext.put("sdk_level", 19);
    paramContext.put("auth", localJSONObject);
    paramIntent.putExtra("getjar.payload", paramContext.toString());
  }
  
  private static void addRedeemVoucherIntentExtras(Intent paramIntent, String paramString)
  {
    addCommonIntentExtras(paramIntent);
    paramIntent.putExtra("getjar.intent.type", "redeem_voucher");
    paramIntent.putExtra("getjar.voucher_token", paramString);
  }
  
  private static void addWalletIntentExtras(Intent paramIntent)
  {
    addCommonIntentExtras(paramIntent);
    paramIntent.putExtra("getjarIntentType", "showShop");
    paramIntent.putExtra("uiSpecifier", "#wallet");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(NotificationsUtility.NotificationType.OPEN_WALLET.name());
    paramIntent.putExtra("notificationTypesToClear", localArrayList);
  }
  
  public static String getAccountNameHashFromIntent(Intent paramIntent)
  {
    Object localObject = null;
    try
    {
      JSONArray localJSONArray = new JSONObject(paramIntent.getStringExtra("getjar.payload")).getJSONObject("auth").getJSONArray("provider_filter_data");
      int i = 0;
      for (;;)
      {
        paramIntent = (Intent)localObject;
        if (i < localJSONArray.length())
        {
          paramIntent = localJSONArray.getJSONObject(i);
          if ("android_account.username_data_hash".equalsIgnoreCase(paramIntent.getString("key"))) {
            paramIntent = paramIntent.getString("value");
          }
        }
        else
        {
          return paramIntent;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramIntent)
    {
      Logger.e(Area.UI.value() | Area.PURCHASE.value() | Area.OFFER.value(), paramIntent, "RedemptionEngine: showCheckoutPage() failed", new Object[0]);
    }
  }
  
  public static Intent getAccountPickerIntent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    paramContext.addFlags(8388608);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "accountPicker");
    paramContext.putExtra("theTitle", paramString);
    return paramContext;
  }
  
  public static Intent getAccountPickerIntentOld(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'authWithUiId' can not be NULL or empty");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    paramContext.addFlags(276824064);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "accountPickerOld");
    paramContext.putExtra("theTitle", paramString1);
    paramContext.putExtra("auth.with.ui.id", paramString2);
    return paramContext;
  }
  
  public static Intent getCheckoutIntent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'purchaseData' can not be NULL or empty");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    paramContext.setFlags(882900992);
    addCheckoutIntentExtras(paramContext, paramString);
    return paramContext;
  }
  
  public static Intent getEarnIntent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'currencyKey' can not be NULL or empty");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "showEarn");
    paramContext.putExtra("currency_key", paramString.toLowerCase());
    return paramContext;
  }
  
  public static Intent getExternalCheckoutIntent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'purchaseData' can not be NULL or empty");
    }
    Intent localIntent = paramContext.getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.getjar.rewards");
    if (localIntent != null)
    {
      localIntent.setFlags(882900992);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      addCheckoutIntentExtras(localIntent, paramString);
      localIntent.putExtra("forceAuthToGivenAccount", true);
    }
    try
    {
      addGetjarPayloadIntentExtra(paramContext, localIntent);
      localIntent.putExtra("clearHistoryOnFirstLoad", false);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      throw new AuthException(paramContext);
    }
  }
  
  public static Intent getExternalRedeemVoucherIntent(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'packageName' can not be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'voucherToken' can not be NULL or empty");
    }
    UUID.fromString(paramString1);
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString2);
    if (localIntent == null) {
      throw new IllegalArgumentException(String.format(Locale.US, "The package name '%1$s' is not installed", new Object[] { paramString2 }));
    }
    Logger.d(Area.REDEEM.value() | Area.OFFER.value(), "IntentsUtility: getRedeemVoucherIntent() [packageName:%1$s voucherToken:%2$s]", new Object[] { paramString2, paramString1 });
    addRedeemVoucherIntentExtras(localIntent, paramString1);
    try
    {
      addGetjarPayloadIntentExtra(paramContext, localIntent);
      localIntent.addFlags(536870912);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      throw new AuthException(paramContext);
    }
  }
  
  public static Intent getExternalWalletIntent(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    paramContext = paramContext.getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.getjar.rewards");
    if (paramContext != null)
    {
      paramContext.setFlags(874512384);
      paramContext.addCategory("android.intent.category.LAUNCHER");
      addWalletIntentExtras(paramContext);
    }
    return paramContext;
  }
  
  private static String getHashedAccountName(Context paramContext)
  {
    Object localObject = null;
    Map localMap = new AndroidAccountUserAuthProvider().getProxiableAuthData(paramContext);
    paramContext = (Context)localObject;
    if (localMap != null) {
      paramContext = (String)localMap.get("android_account.username_data_hash");
    }
    if (StringUtility.isNullOrEmpty(paramContext)) {
      throw new AuthException("Failed to get hashed provider data");
    }
    return paramContext;
  }
  
  public static Intent getInterstitialIntent(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'currencyKey' can not be NULL or empty");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "showInterstitial");
    paramContext.putExtra("currency_key", paramString2.toLowerCase());
    paramContext.putExtra("placement_tag", paramString1);
    return paramContext;
  }
  
  public static Intent getLicenseUpdatedIntent(Context paramContext, GetjarLicense paramGetjarLicense)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (paramGetjarLicense == null) {
      throw new IllegalArgumentException("'license' can not be NULL");
    }
    paramContext = new Intent();
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjar.intent.type", "update_license");
    paramContext.putExtra("getjar.key_index", paramGetjarLicense.getKeyIndex());
    paramContext.putExtra("getjar.license_signature", paramGetjarLicense.getLicenseSignature());
    paramContext.putExtra("getjar.signed_license_data", paramGetjarLicense.getSignedLicenseData());
    return paramContext;
  }
  
  public static JSONArray getProviderFilterJson(Context paramContext)
    throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException
  {
    AuthManager.initialize(paramContext);
    if (!AuthManager.getInstance().isAuthed()) {
      throw new AuthException("Must already be authed to call 'buildRedeemVoucherIntent()'");
    }
    Object localObject1 = AuthManager.getInstance().getUserAuthProviderFilter();
    if (!"android_account".equals(localObject1))
    {
      if (!StringUtility.isNullOrEmpty((String)localObject1)) {
        throw new AuthException("Can only call 'buildRedeemVoucherIntent()' when authed via the 'android_account' user auth provider");
      }
      AuthManager.getInstance().fixUpgradedMissingUserAuthProviderFilter("android_account");
    }
    Object localObject3 = getHashedAccountName(paramContext);
    localObject1 = AuthManager.getInstance().getUserDeviceId();
    Object localObject2 = CryptoUtility.getSHA256(((String)localObject1).toLowerCase(Locale.US));
    Logger.d(Area.REDEEM.value() | Area.OFFER.value(), "RedemptionEngine: buildRedeemVoucherIntent() [hashedAccountName:%1$s userDeviceId:%2$s hashedUserDeviceId:%3$s]", new Object[] { localObject3, localObject1, localObject2 });
    localObject1 = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", "android_account.username_data_hash");
    localJSONObject.put("value", localObject3);
    ((JSONArray)localObject1).put(localJSONObject);
    localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("key", "android_account.user_device_hash");
    ((JSONObject)localObject3).put("value", localObject2);
    ((JSONArray)localObject1).put(localObject3);
    paramContext = new DeviceMetadata(paramContext);
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("key", DeviceMetadata.KEY_DEVICE_PLATFORM_VERSION);
    ((JSONObject)localObject2).put("value", paramContext.getMetadataValue(DeviceMetadata.KEY_DEVICE_PLATFORM_VERSION));
    ((JSONArray)localObject1).put(localObject2);
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("key", DeviceMetadata.KEY_DEVICE_PLATFORM);
    ((JSONObject)localObject2).put("value", paramContext.getMetadataValue(DeviceMetadata.KEY_DEVICE_PLATFORM));
    ((JSONArray)localObject1).put(localObject2);
    return (JSONArray)localObject1;
  }
  
  public static Intent getPurchaseIntent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("'offerLookupKey' can not be NULL or empty");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "showManagedPurchase");
    paramContext.putExtra("offer_lookup_key", paramString);
    return paramContext;
  }
  
  public static Intent getPurchaseIntent(Context paramContext, ArrayList<Product> paramArrayList)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      throw new IllegalArgumentException("'products' can not be NULL or empty");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "showPurchase");
    paramContext.putParcelableArrayListExtra("productList", paramArrayList);
    return paramContext;
  }
  
  public static Intent getRedeemVoucherIntent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'voucherToken' can not be NULL or empty");
    }
    UUID.fromString(paramString);
    Intent localIntent = new Intent();
    addRedeemVoucherIntentExtras(localIntent, paramString);
    try
    {
      addGetjarPayloadIntentExtra(paramContext, localIntent);
      return localIntent;
    }
    catch (Exception paramContext)
    {
      throw new AuthException(paramContext);
    }
  }
  
  public static Intent getShopIntent(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "showShop");
    return paramContext;
  }
  
  public static Intent getWalletIntent(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    paramContext.setFlags(874512384);
    addWalletIntentExtras(paramContext);
    return paramContext;
  }
  
  public static Intent getWalletUiIntent(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    paramContext = new Intent(paramContext, GetJarActivity.class);
    addCommonIntentExtras(paramContext);
    paramContext.putExtra("getjarIntentType", "showWallet");
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/IntentsUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */