package com.getjar.sdk.comm;

import java.util.Locale;

public class LicenseServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20131025";
  private static volatile LicenseServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_GET_LICENSES = String.format(Locale.US, "%1$s%2$s%3$s", new Object[] { "%1$slicense/licenses?version=", "20131025", "&user_lookup_id=%2$s&user_device_id=%3$s&scope=%4$s&ct=%5$s&l=%6$s" });
  
  public static LicenseServiceProxy getInstance()
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
        _Instance = new LicenseServiceProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.LICENSE;
  }
  
  /* Error */
  public Operation getUnmanagedProductLicenses(CommContext paramCommContext, com.getjar.sdk.GetjarLicense.Scope paramScope, String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 61	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 63
    //   10: invokespecial 66	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_3
    //   15: astore 6
    //   17: aload_3
    //   18: invokestatic 72	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   21: ifeq +7 -> 28
    //   24: ldc 74
    //   26: astore 6
    //   28: iload 4
    //   30: iconst_1
    //   31: if_icmpge +13 -> 44
    //   34: new 61	java/lang/IllegalArgumentException
    //   37: dup
    //   38: ldc 76
    //   40: invokespecial 66	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: aload_1
    //   45: invokevirtual 82	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   48: invokestatic 88	com/getjar/sdk/comm/auth/AuthManager:initialize	(Landroid/content/Context;)V
    //   51: invokestatic 91	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
    //   54: invokevirtual 94	com/getjar/sdk/comm/auth/AuthManager:waitOnAuth	()V
    //   57: getstatic 21	java/util/Locale:US	Ljava/util/Locale;
    //   60: astore_3
    //   61: getstatic 37	com/getjar/sdk/comm/LicenseServiceProxy:_URL_TEMPLATE_GET_LICENSES	Ljava/lang/String;
    //   64: astore 7
    //   66: aload_1
    //   67: iconst_1
    //   68: invokestatic 99	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   71: ldc 101
    //   73: getstatic 107	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   76: invokevirtual 111	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   79: astore 8
    //   81: invokestatic 91	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
    //   84: invokevirtual 115	com/getjar/sdk/comm/auth/AuthManager:getUserAccessId	()Ljava/lang/String;
    //   87: ldc 117
    //   89: invokestatic 123	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 9
    //   94: invokestatic 91	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
    //   97: invokevirtual 126	com/getjar/sdk/comm/auth/AuthManager:getUserDeviceId	()Ljava/lang/String;
    //   100: ldc 117
    //   102: invokestatic 123	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 10
    //   107: aload_2
    //   108: ifnull +110 -> 218
    //   111: aload_2
    //   112: invokevirtual 131	com/getjar/sdk/GetjarLicense$Scope:toString	()Ljava/lang/String;
    //   115: astore_2
    //   116: aload_3
    //   117: aload 7
    //   119: bipush 6
    //   121: anewarray 25	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload 8
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload 9
    //   133: aastore
    //   134: dup
    //   135: iconst_2
    //   136: aload 10
    //   138: aastore
    //   139: dup
    //   140: iconst_3
    //   141: aload_2
    //   142: ldc 117
    //   144: invokestatic 123	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   147: aastore
    //   148: dup
    //   149: iconst_4
    //   150: aload 6
    //   152: ldc 117
    //   154: invokestatic 123	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: aastore
    //   158: dup
    //   159: iconst_5
    //   160: iload 4
    //   162: invokestatic 135	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   165: ldc 117
    //   167: invokestatic 123	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: aastore
    //   171: invokestatic 35	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_2
    //   177: aload 5
    //   179: ifnull +22 -> 201
    //   182: new 137	java/util/HashMap
    //   185: dup
    //   186: invokespecial 138	java/util/HashMap:<init>	()V
    //   189: astore_2
    //   190: aload_2
    //   191: ldc -116
    //   193: aload 5
    //   195: invokeinterface 146 3 0
    //   200: pop
    //   201: aload_0
    //   202: ldc -109
    //   204: getstatic 153	com/getjar/sdk/comm/Operation$Priority:HIGH	Lcom/getjar/sdk/comm/Operation$Priority;
    //   207: aload_1
    //   208: aload_3
    //   209: aload_2
    //   210: aconst_null
    //   211: iconst_1
    //   212: iconst_1
    //   213: iconst_1
    //   214: invokevirtual 157	com/getjar/sdk/comm/LicenseServiceProxy:makeAsyncGETRequestForJson	(Ljava/lang/String;Lcom/getjar/sdk/comm/Operation$Priority;Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;Ljava/util/Map;Lcom/getjar/sdk/comm/CallbackInterface;ZZZ)Lcom/getjar/sdk/comm/Operation;
    //   217: areturn
    //   218: ldc 74
    //   220: astore_2
    //   221: goto -105 -> 116
    //   224: astore_1
    //   225: new 159	com/getjar/sdk/exceptions/CommunicationException
    //   228: dup
    //   229: aload_1
    //   230: invokespecial 162	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	LicenseServiceProxy
    //   0	234	1	paramCommContext	CommContext
    //   0	234	2	paramScope	com.getjar.sdk.GetjarLicense.Scope
    //   0	234	3	paramString1	String
    //   0	234	4	paramInt	int
    //   0	234	5	paramString2	String
    //   15	136	6	str1	String
    //   64	54	7	str2	String
    //   79	48	8	str3	String
    //   92	40	9	str4	String
    //   105	32	10	str5	String
    // Exception table:
    //   from	to	target	type
    //   57	107	224	java/io/UnsupportedEncodingException
    //   111	116	224	java/io/UnsupportedEncodingException
    //   116	175	224	java/io/UnsupportedEncodingException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/LicenseServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */