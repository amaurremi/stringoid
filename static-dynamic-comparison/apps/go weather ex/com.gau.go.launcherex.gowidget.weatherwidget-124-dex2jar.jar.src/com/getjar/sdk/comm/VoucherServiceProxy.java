package com.getjar.sdk.comm;

import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.utilities.StringUtility;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;

public class VoucherServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20131018";
  private static volatile VoucherServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_CONFIRM_VOUCHER = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$svoucher/vouchers/%2$s/confirm?version=", "20131018" });
  private static final String _URL_TEMPLATE_GET_UNREDEEMED_VOUCHERS = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$svoucher/unredeemed_vouchers?version=", "20131018" });
  private static final String _URL_TEMPLATE_GET_VOUCHER = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$svoucher/vouchers/%2$s?version=", "20131018" });
  private static final String _URL_TEMPLATE_REDEEM_VOUCHER = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$svoucher/vouchers/%2$s/redeem?version=", "20131018" });
  
  public static VoucherServiceProxy getInstance()
  {
    if (_Instance == null) {
      makeTheInstance();
    }
    return _Instance;
  }
  
  private static void makeTheInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new VoucherServiceProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Operation confirmVoucher(CommContext paramCommContext, String paramString, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("The required parameter 'voucherToken' was not provided");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString = String.format(Locale.US, _URL_TEMPLATE_CONFIRM_VOUCHER, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.voucher_service.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramString, "UTF-8") });
    return makeAsyncPOSTRequestForJson("confirmVoucher", Operation.Priority.HIGH, paramCommContext, paramString, null, null, null, paramBoolean, true, true);
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.VOUCHER;
  }
  
  public Operation getUnredeemedVouchers(CommContext paramCommContext, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    String str = String.format(Locale.US, _URL_TEMPLATE_GET_UNREDEEMED_VOUCHERS, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.voucher_service.endpoint", SettingsManager.Scope.CLIENT) });
    return makeAsyncGETRequestForJson("getVoucher", Operation.Priority.MEDIUM, paramCommContext, str, null, null, paramBoolean, true, true);
  }
  
  public Operation getVoucher(CommContext paramCommContext, String paramString, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("The required parameter 'voucherToken' was not provided");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString = String.format(Locale.US, _URL_TEMPLATE_GET_VOUCHER, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.voucher_service.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramString, "UTF-8") });
    return makeAsyncGETRequestForJson("getVoucher", Operation.Priority.MEDIUM, paramCommContext, paramString, null, null, paramBoolean, true, true);
  }
  
  public Operation redeemVoucher(CommContext paramCommContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'voucherToken' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("The required parameter 'client_transaction_id' was not provided");
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("client_transaction_token", paramString3);
    if (!StringUtility.isNullOrEmpty(paramString2)) {
      localHashMap.put("developer_payload", paramString2);
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString1 = String.format(Locale.US, _URL_TEMPLATE_REDEEM_VOUCHER, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.voucher_service.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramString1, "UTF-8") });
    return makeAsyncPOSTRequestForJson("redeemVoucher", Operation.Priority.HIGH, paramCommContext, paramString1, localHashMap, null, null, paramBoolean, true, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/VoucherServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */