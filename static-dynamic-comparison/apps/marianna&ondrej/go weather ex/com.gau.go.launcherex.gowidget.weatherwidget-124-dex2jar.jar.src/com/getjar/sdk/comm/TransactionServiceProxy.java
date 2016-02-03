package com.getjar.sdk.comm;

import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.OutOfBandManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;

public class TransactionServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20131025";
  private static volatile TransactionServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_BUY_CURRENCY;
  private static final String _URL_TEMPLATE_CANCEL_TRANSACTION;
  private static final String _URL_TEMPLATE_CONFIRM_MANAGED_OFFER = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/confirm?version=", "20131025" });
  private static final String _URL_TEMPLATE_CONFIRM_UNMANAGED_OFFER;
  private static final String _URL_TEMPLATE_EARN;
  private static final String _URL_TEMPLATE_GRANT_GETJAR_PASS = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/grant_getjar_pass?version=", "20131025" });
  private static final String _URL_TEMPLATE_RESERVE_MANAGED_OFFER;
  private static final String _URL_TEMPLATE_RESERVE_UNMANAGED_OFFER = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/reserve?developer_product_id=%2$s&developer_product_name=%3$s&developer_product_description=%4$s&amount=%5$s&license_scope=%6$s&client_transaction_token=%7$s&version=", "20131025" });
  
  static
  {
    _URL_TEMPLATE_CONFIRM_UNMANAGED_OFFER = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/confirm?client_transaction_token=%2$s&version=", "20131025" });
    _URL_TEMPLATE_CANCEL_TRANSACTION = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/cancel?client_transaction_token=%2$s&version=", "20131025" });
    _URL_TEMPLATE_EARN = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/earn?item_id=%2$s&client_transaction_token=%3$s&version=", "20131025" });
    _URL_TEMPLATE_BUY_CURRENCY = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/buy_currency?version=", "20131025" });
    _URL_TEMPLATE_RESERVE_MANAGED_OFFER = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$stransaction/transactions/reserve?version=", "20131025" });
  }
  
  public static TransactionServiceProxy getInstance()
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
        _Instance = new TransactionServiceProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public Operation buyCurrency(CommContext paramCommContext, String paramString1, String paramString2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 86	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 88
    //   10: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: invokestatic 97	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: new 86	java/lang/IllegalArgumentException
    //   24: dup
    //   25: ldc 99
    //   27: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   30: athrow
    //   31: aload_3
    //   32: invokestatic 97	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   35: ifeq +13 -> 48
    //   38: new 86	java/lang/IllegalArgumentException
    //   41: dup
    //   42: ldc 101
    //   44: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: aload 4
    //   50: ifnonnull +13 -> 63
    //   53: new 86	java/lang/IllegalArgumentException
    //   56: dup
    //   57: ldc 103
    //   59: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: aload 5
    //   65: ifnonnull +13 -> 78
    //   68: new 86	java/lang/IllegalArgumentException
    //   71: dup
    //   72: ldc 105
    //   74: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: aload_1
    //   79: invokevirtual 111	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   82: invokestatic 117	com/getjar/sdk/comm/auth/AuthManager:initialize	(Landroid/content/Context;)V
    //   85: invokestatic 120	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
    //   88: invokevirtual 123	com/getjar/sdk/comm/auth/AuthManager:waitOnAuth	()V
    //   91: getstatic 28	java/util/Locale:US	Ljava/util/Locale;
    //   94: getstatic 58	com/getjar/sdk/comm/TransactionServiceProxy:_URL_TEMPLATE_BUY_CURRENCY	Ljava/lang/String;
    //   97: iconst_1
    //   98: anewarray 32	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: iconst_1
    //   105: invokestatic 128	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   108: ldc -126
    //   110: getstatic 136	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   113: invokevirtual 140	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   116: aastore
    //   117: invokestatic 40	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   120: astore 7
    //   122: new 142	java/util/HashMap
    //   125: dup
    //   126: iconst_5
    //   127: invokespecial 145	java/util/HashMap:<init>	(I)V
    //   130: astore 8
    //   132: aload 8
    //   134: ldc -109
    //   136: ldc -107
    //   138: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: pop
    //   142: aload 8
    //   144: ldc -101
    //   146: aload_3
    //   147: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload 8
    //   153: ldc -99
    //   155: aload 4
    //   157: invokestatic 163	com/getjar/sdk/utilities/Utility:mapToJsonString	(Ljava/util/Map;)Ljava/lang/String;
    //   160: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload 8
    //   166: ldc -91
    //   168: aload 5
    //   170: invokestatic 163	com/getjar/sdk/utilities/Utility:mapToJsonString	(Ljava/util/Map;)Ljava/lang/String;
    //   173: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload 8
    //   179: ldc -89
    //   181: aload_2
    //   182: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: aload_1
    //   187: invokevirtual 111	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   190: invokestatic 172	com/getjar/sdk/comm/auth/OutOfBandManager:resetLastUnredeemedVouchersCheckTimestamp	(Landroid/content/Context;)V
    //   193: aload_0
    //   194: ldc -83
    //   196: getstatic 179	com/getjar/sdk/comm/Operation$Priority:HIGH	Lcom/getjar/sdk/comm/Operation$Priority;
    //   199: aload_1
    //   200: aload 7
    //   202: aload 8
    //   204: aconst_null
    //   205: aconst_null
    //   206: iload 6
    //   208: iconst_1
    //   209: iconst_1
    //   210: invokevirtual 183	com/getjar/sdk/comm/TransactionServiceProxy:makeAsyncPOSTRequestForJson	(Ljava/lang/String;Lcom/getjar/sdk/comm/Operation$Priority;Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/getjar/sdk/comm/CallbackInterface;ZZZ)Lcom/getjar/sdk/comm/Operation;
    //   213: areturn
    //   214: astore_1
    //   215: new 185	com/getjar/sdk/exceptions/CommunicationException
    //   218: dup
    //   219: ldc -69
    //   221: invokespecial 188	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/String;)V
    //   224: athrow
    //   225: astore_1
    //   226: new 185	com/getjar/sdk/exceptions/CommunicationException
    //   229: dup
    //   230: ldc -66
    //   232: invokespecial 188	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/String;)V
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	TransactionServiceProxy
    //   0	236	1	paramCommContext	CommContext
    //   0	236	2	paramString1	String
    //   0	236	3	paramString2	String
    //   0	236	4	paramHashMap1	HashMap<String, String>
    //   0	236	5	paramHashMap2	HashMap<String, String>
    //   0	236	6	paramBoolean	boolean
    //   120	81	7	str	String
    //   130	73	8	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   151	164	214	org/json/JSONException
    //   164	177	225	org/json/JSONException
  }
  
  public Operation cancelTransaction(CommContext paramCommContext, String paramString, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("The required parameter 'client_transaction_id' was not provided");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString = String.format(Locale.US, _URL_TEMPLATE_CANCEL_TRANSACTION, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.transaction_service.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramString, "UTF-8") });
    return makeAsyncPOSTRequestForJson("cancelTransaction", Operation.Priority.HIGH, paramCommContext, paramString, null, null, null, paramBoolean, false, true);
  }
  
  public Operation confirmManagedOffer(CommContext paramCommContext, String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("The required parameter 'clientTransactionId' was not provided");
    }
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      throw new IllegalArgumentException("The required parameter 'purchaseMetadata' cannot be NULL or empty");
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("client_transaction_token", paramString);
    localHashMap.put("purchase_metadata", Utility.mapToJsonString(paramHashMap));
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString = String.format(Locale.US, _URL_TEMPLATE_CONFIRM_MANAGED_OFFER, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.transaction_service.endpoint", SettingsManager.Scope.CLIENT) });
    OutOfBandManager.resetLastUnredeemedVouchersCheckTimestamp(paramCommContext.getApplicationContext());
    return makeAsyncPOSTRequestForJson("confirmManagedOffer", Operation.Priority.HIGH, paramCommContext, paramString, localHashMap, null, null, paramBoolean, true, true);
  }
  
  protected Operation confirmUnmanagedPurchase(CommContext paramCommContext, String paramString, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("The required parameter 'client_transaction_id' was not provided");
    }
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString = String.format(Locale.US, _URL_TEMPLATE_CONFIRM_UNMANAGED_OFFER, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.transaction_service.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramString, "UTF-8") });
    OutOfBandManager.resetLastUnredeemedVouchersCheckTimestamp(paramCommContext.getApplicationContext());
    return makeAsyncPOSTRequestForJson("confirmUnmanagedPurchase", Operation.Priority.HIGH, paramCommContext, paramString, null, null, null, paramBoolean, false, true);
  }
  
  protected Operation earn(CommContext paramCommContext, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'item_id' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("The required parameter 'client_transaction_id' was not provided");
    }
    if (paramHashMap1 == null) {
      throw new IllegalArgumentException("The required parameter 'item_metadata' was not provided");
    }
    if (paramHashMap2 == null) {
      throw new IllegalArgumentException("The required parameter 'tracking_metadata' was not provided");
    }
    if (paramHashMap2.size() <= 0) {
      throw new IllegalArgumentException("The required parameter 'tracking_metadata' contains no data");
    }
    paramString2 = new HashMap(2);
    paramString2.put("item_metadata", Utility.mapToJsonString(paramHashMap1));
    paramString2.put("tracking_metadata", Utility.mapToJsonString(paramHashMap2));
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString1 = String.format(Locale.US, _URL_TEMPLATE_EARN, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.transaction_service.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramString1, "UTF-8"), URLEncoder.encode(paramString3, "UTF-8") });
    OutOfBandManager.resetLastUnredeemedVouchersCheckTimestamp(paramCommContext.getApplicationContext());
    return makeAsyncPOSTRequestForJson("earn", Operation.Priority.HIGH, paramCommContext, paramString1, paramString2, null, null, paramBoolean, false, true);
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.TRANSACTION;
  }
  
  public Operation grantGetjarPass(CommContext paramCommContext, String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("The required parameter 'clientTransactionId' was not provided");
    }
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      throw new IllegalArgumentException("The required parameter 'purchaseMetadata' cannot be NULL or empty");
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("client_transaction_token", paramString);
    localHashMap.put("purchase_metadata", Utility.mapToJsonString(paramHashMap));
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString = String.format(Locale.US, _URL_TEMPLATE_GRANT_GETJAR_PASS, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.transaction_service.endpoint", SettingsManager.Scope.CLIENT) });
    OutOfBandManager.resetLastUnredeemedVouchersCheckTimestamp(paramCommContext.getApplicationContext());
    return makeAsyncPOSTRequestForJson("grantGetjarPass", Operation.Priority.HIGH, paramCommContext, paramString, localHashMap, null, null, paramBoolean, true, true);
  }
  
  public Operation reserveManagedOffer(CommContext paramCommContext, String paramString1, String paramString2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'offerId' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("The required parameter 'client_transaction_id' was not provided");
    }
    if ((paramHashMap1 == null) || (paramHashMap1.size() <= 0)) {
      throw new IllegalArgumentException("The required parameter 'purchaseMetadata' cannot be NULL or empty");
    }
    if ((paramHashMap2 == null) || (paramHashMap2.size() <= 0)) {
      throw new IllegalArgumentException("The required parameter 'trackingMetadata' cannot be NULL or empty");
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("offer_id", paramString1);
    localHashMap.put("client_transaction_token", paramString2);
    localHashMap.put("purchase_metadata", Utility.mapToJsonString(paramHashMap1));
    localHashMap.put("tracking_metadata", Utility.mapToJsonString(paramHashMap2));
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramString1 = String.format(Locale.US, _URL_TEMPLATE_RESERVE_MANAGED_OFFER, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.transaction_service.endpoint", SettingsManager.Scope.CLIENT) });
    OutOfBandManager.resetLastUnredeemedVouchersCheckTimestamp(paramCommContext.getApplicationContext());
    return makeAsyncPOSTRequestForJson("reserveManagedOffer", Operation.Priority.HIGH, paramCommContext, paramString1, localHashMap, null, null, paramBoolean, true, true);
  }
  
  protected Operation reserveUnmanagedPurchase(CommContext paramCommContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, GetjarLicense.Scope paramScope, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'productId' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("The required parameter 'productName' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("The required parameter 'productDescription' was not provided");
    }
    if (paramInteger == null) {
      throw new IllegalArgumentException("The required parameter 'amount' was not provided");
    }
    if (paramInteger.intValue() < 0) {
      throw new IllegalArgumentException("The parameter 'amount' can not have a negative value");
    }
    if (StringUtility.isNullOrEmpty(paramString4)) {
      throw new IllegalArgumentException("The required parameter 'client_transaction_id' was not provided");
    }
    if (paramHashMap == null) {
      throw new IllegalArgumentException("The required parameter 'trackingData' was not provided");
    }
    if (paramHashMap.size() <= 0) {
      throw new IllegalArgumentException("The required parameter 'trackingData' contains no data");
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("tracking_metadata", Utility.mapToJsonString(paramHashMap));
    AuthManager.initialize(paramCommContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    paramHashMap = Locale.US;
    String str1 = _URL_TEMPLATE_RESERVE_UNMANAGED_OFFER;
    String str2 = GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.transaction_service.endpoint", SettingsManager.Scope.CLIENT);
    String str3 = URLEncoder.encode(paramString1, "UTF-8");
    paramString2 = URLEncoder.encode(paramString2, "UTF-8");
    paramString3 = URLEncoder.encode(paramString3, "UTF-8");
    paramInteger = Integer.toString(paramInteger.intValue());
    paramString1 = paramScope;
    if (paramScope == null) {
      paramString1 = "";
    }
    paramString1 = String.format(paramHashMap, str1, new Object[] { str2, str3, paramString2, paramString3, paramInteger, paramString1, URLEncoder.encode(paramString4, "UTF-8") });
    OutOfBandManager.resetLastUnredeemedVouchersCheckTimestamp(paramCommContext.getApplicationContext());
    return makeAsyncPOSTRequestForJson("reserveUnmanagedPurchase", Operation.Priority.HIGH, paramCommContext, paramString1, localHashMap, null, null, paramBoolean, false, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/TransactionServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */