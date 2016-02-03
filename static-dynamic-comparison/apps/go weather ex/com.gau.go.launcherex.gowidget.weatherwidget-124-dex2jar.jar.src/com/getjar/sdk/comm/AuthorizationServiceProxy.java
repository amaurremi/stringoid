package com.getjar.sdk.comm;

import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

public class AuthorizationServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20140428";
  private static volatile AuthorizationServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_AUTHORIZE = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$sapp_auth/app/authorize?application_key=%2$s&provider_filter=%3$s&version=", "20140428" });
  private static final String _URL_TEMPLATE_GENERATE_SIGNATURE = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$sauth/generate_signature?provider_filter=%2$s&version=", "20140428" });
  private static final String _URL_TEMPLATE_USER_ACCESS_ENSURE = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$suser_auth/user_accesses/ensure?provider_filter=%2$s&version=", "20140428" });
  private static final String _URL_TEMPLATE_VALIDATE_AUTH = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$sauth/validate?version=", "20140428" });
  private static final String _URL_TEMPLATE_VALIDATE_PROXIED_AUTH = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$sauth/validate?provider_filter=%2$s&version=", "20140428" });
  
  public static AuthorizationServiceProxy getInstance()
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
        _Instance = new AuthorizationServiceProxy();
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
  public Operation authorize(CommContext paramCommContext, String paramString1, Map<String, MetadataValue> paramMap, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 73	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 75
    //   10: invokespecial 78	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: invokestatic 84	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: new 73	java/lang/IllegalArgumentException
    //   24: dup
    //   25: ldc 86
    //   27: invokespecial 78	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   30: athrow
    //   31: aload_3
    //   32: ifnonnull +13 -> 45
    //   35: new 73	java/lang/IllegalArgumentException
    //   38: dup
    //   39: ldc 88
    //   41: invokespecial 78	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   44: athrow
    //   45: aload 4
    //   47: invokestatic 84	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   50: ifeq +13 -> 63
    //   53: new 73	java/lang/IllegalArgumentException
    //   56: dup
    //   57: ldc 90
    //   59: invokespecial 78	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: aload_1
    //   64: invokevirtual 96	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   67: invokestatic 101	com/getjar/sdk/comm/auth/ApplicationTokenDatabase:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/comm/auth/ApplicationTokenDatabase;
    //   70: invokevirtual 105	com/getjar/sdk/comm/auth/ApplicationTokenDatabase:getApplicationToken	()Ljava/lang/String;
    //   73: astore 6
    //   75: aload 6
    //   77: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifeq +13 -> 93
    //   83: new 113	java/lang/IllegalStateException
    //   86: dup
    //   87: ldc 115
    //   89: invokespecial 116	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: new 118	java/util/HashMap
    //   96: dup
    //   97: iconst_2
    //   98: invokespecial 121	java/util/HashMap:<init>	(I)V
    //   101: astore 5
    //   103: aload 5
    //   105: ldc 123
    //   107: ldc 125
    //   109: invokeinterface 131 3 0
    //   114: pop
    //   115: aload 5
    //   117: ldc -123
    //   119: aload_3
    //   120: invokestatic 139	com/getjar/sdk/utilities/Utility:metadataMapToJsonString	(Ljava/util/Map;)Ljava/lang/String;
    //   123: invokeinterface 131 3 0
    //   128: pop
    //   129: getstatic 25	java/util/Locale:US	Ljava/util/Locale;
    //   132: getstatic 39	com/getjar/sdk/comm/AuthorizationServiceProxy:_URL_TEMPLATE_AUTHORIZE	Ljava/lang/String;
    //   135: iconst_3
    //   136: anewarray 29	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_1
    //   142: iconst_1
    //   143: invokestatic 144	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   146: ldc -110
    //   148: getstatic 152	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   151: invokevirtual 156	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload 6
    //   159: ldc -98
    //   161: invokestatic 164	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: aload 4
    //   169: aastore
    //   170: invokestatic 37	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: astore_3
    //   174: aload_0
    //   175: ldc -91
    //   177: getstatic 171	com/getjar/sdk/comm/Operation$Priority:HIGH	Lcom/getjar/sdk/comm/Operation$Priority;
    //   180: aload_1
    //   181: aload_3
    //   182: aload 5
    //   184: aconst_null
    //   185: aconst_null
    //   186: iconst_0
    //   187: iconst_1
    //   188: iconst_1
    //   189: aload_2
    //   190: invokevirtual 175	com/getjar/sdk/comm/AuthorizationServiceProxy:makeAsyncPOSTRequestForJson	(Ljava/lang/String;Lcom/getjar/sdk/comm/Operation$Priority;Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/getjar/sdk/comm/CallbackInterface;ZZZLjava/lang/String;)Lcom/getjar/sdk/comm/Operation;
    //   193: areturn
    //   194: astore_1
    //   195: new 177	com/getjar/sdk/exceptions/CommunicationException
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 180	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   203: athrow
    //   204: astore_1
    //   205: new 177	com/getjar/sdk/exceptions/CommunicationException
    //   208: dup
    //   209: aload_1
    //   210: invokespecial 180	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	AuthorizationServiceProxy
    //   0	214	1	paramCommContext	CommContext
    //   0	214	2	paramString1	String
    //   0	214	3	paramMap	Map<String, MetadataValue>
    //   0	214	4	paramString2	String
    //   101	82	5	localHashMap	HashMap
    //   73	85	6	str	String
    // Exception table:
    //   from	to	target	type
    //   115	129	194	org/json/JSONException
    //   129	174	204	java/io/UnsupportedEncodingException
  }
  
  public Operation generateSignature(CommContext paramCommContext, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, MetadataValue> paramMap, String paramString5)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'authFlowId' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("The required parameter 'authToken' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("The required parameter 'userAccessId' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString4)) {
      throw new IllegalArgumentException("The required parameter 'userDeviceId' was not provided");
    }
    if (paramMap == null) {
      throw new IllegalArgumentException("The required parameter 'providerData' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString5)) {
      throw new IllegalArgumentException("The required parameter 'providerFilter' was not provided");
    }
    HashMap localHashMap = new HashMap(1);
    try
    {
      localHashMap.put("metadata", Utility.metadataMapToJsonString(paramMap));
      localHashMap.put("user_access_id", paramString3);
      localHashMap.put("user_device_id", paramString4);
      paramString3 = new HashMap();
      paramString3.put("Authorization", paramString2);
      paramString2 = String.format(Locale.US, _URL_TEMPLATE_GENERATE_SIGNATURE, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.auth_service.endpoint", SettingsManager.Scope.CLIENT), paramString5 });
      return makeAsyncPOSTRequestForJson("validateProxyAuth", Operation.Priority.HIGH, paramCommContext, paramString2, localHashMap, paramString3, null, false, true, true, paramString1);
    }
    catch (JSONException paramCommContext)
    {
      throw new CommunicationException(paramCommContext);
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.AUTH;
  }
  
  public Operation userAccessEnsure(CommContext paramCommContext, String paramString1, String paramString2, Map<String, MetadataValue> paramMap, String paramString3)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'authFlowId' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("The required parameter 'authToken' was not provided");
    }
    if (paramMap == null) {
      throw new IllegalArgumentException("The required parameter 'providerData' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("The required parameter 'providerFilter' was not provided");
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("scope", "[\"default\"]");
    try
    {
      localHashMap.put("metadata", Utility.metadataMapToJsonString(paramMap));
      paramMap = new HashMap();
      paramMap.put("Authorization", paramString2);
      paramString2 = String.format(Locale.US, _URL_TEMPLATE_USER_ACCESS_ENSURE, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.auth_service.endpoint", SettingsManager.Scope.CLIENT), paramString3 });
      return makeAsyncPOSTRequestForJson("userAccessEnsure", Operation.Priority.HIGH, paramCommContext, paramString2, localHashMap, paramMap, null, false, true, true, paramString1);
    }
    catch (JSONException paramCommContext)
    {
      throw new CommunicationException(paramCommContext);
    }
  }
  
  public Operation validateAuth(CommContext paramCommContext, String paramString1, String paramString2)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'authFlowId' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("The required parameter 'authToken' was not provided");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("Authorization", paramString2);
    paramString2 = String.format(Locale.US, _URL_TEMPLATE_VALIDATE_AUTH, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.auth_service.endpoint", SettingsManager.Scope.CLIENT) });
    return makeAsyncGETRequestForJson("validateAuth", Operation.Priority.HIGH, paramCommContext, paramString2, localHashMap, null, false, true, true, paramString1);
  }
  
  public Operation validateAuth(CommContext paramCommContext, String paramString1, String paramString2, Map<String, MetadataValue> paramMap, String paramString3)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("The required parameter 'authFlowId' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("The required parameter 'authToken' was not provided");
    }
    if (paramMap == null) {
      throw new IllegalArgumentException("The required parameter 'providerData' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("The required parameter 'providerFilter' was not provided");
    }
    HashMap localHashMap = new HashMap(1);
    try
    {
      localHashMap.put("metadata", Utility.metadataMapToJsonString(paramMap));
      paramMap = new HashMap();
      paramMap.put("Authorization", paramString2);
      paramString2 = String.format(Locale.US, _URL_TEMPLATE_VALIDATE_PROXIED_AUTH, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.auth_service.endpoint", SettingsManager.Scope.CLIENT), paramString3 });
      return makeAsyncPOSTRequestForJson("validateProxyAuth", Operation.Priority.HIGH, paramCommContext, paramString2, localHashMap, paramMap, null, false, true, true, paramString1);
    }
    catch (JSONException paramCommContext)
    {
      throw new CommunicationException(paramCommContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/AuthorizationServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */