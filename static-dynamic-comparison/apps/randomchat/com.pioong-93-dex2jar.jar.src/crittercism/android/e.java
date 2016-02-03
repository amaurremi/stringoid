package crittercism.android;

public final class e
{
  public String a = "";
  public String b = "";
  private String c = "";
  private int d = 0;
  
  public e() {}
  
  private e(String paramString1, int paramInt, String paramString2)
  {
    this.c = paramString1;
    this.d = paramInt;
    this.b = paramString2;
  }
  
  /* Error */
  public static e a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 31
    //   3: invokevirtual 37	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6: ifeq +90 -> 96
    //   9: aload_0
    //   10: ldc 31
    //   12: invokevirtual 41	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_2
    //   16: aload_0
    //   17: ldc 43
    //   19: invokevirtual 37	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   22: ifeq +69 -> 91
    //   25: aload_0
    //   26: ldc 43
    //   28: invokevirtual 47	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   31: istore_1
    //   32: new 2	crittercism/android/e
    //   35: dup
    //   36: aload_0
    //   37: ldc 49
    //   39: invokevirtual 41	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: iload_1
    //   43: aload_2
    //   44: invokespecial 51	crittercism/android/e:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: astore_2
    //   48: aload_0
    //   49: ldc 53
    //   51: invokevirtual 37	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: ifeq +29 -> 83
    //   57: aload_0
    //   58: ldc 53
    //   60: invokevirtual 57	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   63: astore_0
    //   64: aload_0
    //   65: ldc 59
    //   67: invokevirtual 37	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   70: ifeq +13 -> 83
    //   73: aload_2
    //   74: aload_0
    //   75: ldc 59
    //   77: invokevirtual 41	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: putfield 20	crittercism/android/e:a	Ljava/lang/String;
    //   83: aload_2
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aload_2
    //   90: areturn
    //   91: iconst_0
    //   92: istore_1
    //   93: goto -61 -> 32
    //   96: ldc 61
    //   98: astore_2
    //   99: goto -83 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramJSONObject	org.json.JSONObject
    //   31	62	1	i	int
    //   15	84	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	16	85	org/json/JSONException
    //   16	32	85	org/json/JSONException
    //   32	48	85	org/json/JSONException
    //   48	83	88	org/json/JSONException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */