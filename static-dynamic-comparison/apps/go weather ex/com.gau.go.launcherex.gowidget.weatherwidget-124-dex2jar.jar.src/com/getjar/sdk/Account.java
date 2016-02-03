package com.getjar.sdk;

public class Account
{
  private final String _authProviderKey;
  private final Long _lastAuthTime;
  private final String _name;
  private final Status _status;
  
  /* Error */
  protected Account(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 21	java/lang/Object:<init>	()V
    //   4: aload_1
    //   5: ifnonnull +13 -> 18
    //   8: new 23	java/lang/IllegalArgumentException
    //   11: dup
    //   12: ldc 25
    //   14: invokespecial 28	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: ldc 30
    //   21: invokevirtual 36	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   24: ifne +13 -> 37
    //   27: new 38	java/lang/IllegalStateException
    //   30: dup
    //   31: ldc 40
    //   33: invokespecial 41	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: aload_1
    //   38: ldc 43
    //   40: invokevirtual 36	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   43: ifne +13 -> 56
    //   46: new 38	java/lang/IllegalStateException
    //   49: dup
    //   50: ldc 45
    //   52: invokespecial 41	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: aload_1
    //   57: ldc 47
    //   59: invokevirtual 36	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   62: ifne +13 -> 75
    //   65: new 38	java/lang/IllegalStateException
    //   68: dup
    //   69: ldc 49
    //   71: invokespecial 41	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: aload_0
    //   76: aload_1
    //   77: ldc 30
    //   79: invokevirtual 53	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: putfield 55	com/getjar/sdk/Account:_name	Ljava/lang/String;
    //   85: aload_0
    //   86: getstatic 61	java/util/Locale:US	Ljava/util/Locale;
    //   89: ldc 63
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: ldc 43
    //   100: invokevirtual 53	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 69	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   107: putfield 71	com/getjar/sdk/Account:_authProviderKey	Ljava/lang/String;
    //   110: aload_1
    //   111: ldc 73
    //   113: invokevirtual 36	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   116: ifeq +30 -> 146
    //   119: aload_0
    //   120: aload_1
    //   121: ldc 73
    //   123: invokevirtual 77	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   126: invokestatic 83	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   129: putfield 85	com/getjar/sdk/Account:_lastAuthTime	Ljava/lang/Long;
    //   132: aload_0
    //   133: aload_1
    //   134: ldc 47
    //   136: invokevirtual 53	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokestatic 88	com/getjar/sdk/Account$Status:valueOf	(Ljava/lang/String;)Lcom/getjar/sdk/Account$Status;
    //   142: putfield 90	com/getjar/sdk/Account:_status	Lcom/getjar/sdk/Account$Status;
    //   145: return
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield 85	com/getjar/sdk/Account:_lastAuthTime	Ljava/lang/Long;
    //   151: goto -19 -> 132
    //   154: astore_1
    //   155: new 92	com/getjar/sdk/GetjarException
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 95	com/getjar/sdk/GetjarException:<init>	(Ljava/lang/Throwable;)V
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	Account
    //   0	164	1	paramJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   75	132	154	org/json/JSONException
    //   132	145	154	org/json/JSONException
    //   146	151	154	org/json/JSONException
  }
  
  public String getAuthProviderKey()
  {
    return this._authProviderKey;
  }
  
  public Long getLastAuthTime()
  {
    return this._lastAuthTime;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public Status getStatus()
  {
    return this._status;
  }
  
  public static enum Status
  {
    CURRENT,  PREVIOUS,  UNKNOWN;
    
    private Status() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/Account.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */