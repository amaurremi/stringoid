package com.inmobi.commons.internal;

import com.inmobi.commons.uid.UID;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonsConfig
{
  static Log.INTERNAL_LOG_LEVEL a = Log.INTERNAL_LOG_LEVEL.NONE;
  static Log.INTERNAL_LOG_LEVEL b = a;
  private ThinICEConfig c = new ThinICEConfig();
  
  public CommonsConfig()
  {
    setFromJSON(new JSONObject());
  }
  
  public ThinICEConfig getTic()
  {
    return this.c;
  }
  
  /* Error */
  public void setFromJSON(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 44
    //   3: invokevirtual 48	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore_2
    //   7: aload_1
    //   8: ldc 50
    //   10: invokevirtual 48	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   13: astore_3
    //   14: aload_3
    //   15: aload_2
    //   16: iconst_1
    //   17: invokestatic 56	com/inmobi/commons/internal/InternalSDKUtil:populateToNewJSON	(Lorg/json/JSONObject;Lorg/json/JSONObject;Z)Lorg/json/JSONObject;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: getstatic 62	com/inmobi/commons/uid/UID:commons	Lcom/inmobi/commons/uid/UID;
    //   26: aload_1
    //   27: ldc 64
    //   29: invokevirtual 48	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   32: invokevirtual 65	com/inmobi/commons/uid/UID:setFromJSON	(Lorg/json/JSONObject;)V
    //   35: aload_0
    //   36: getfield 29	com/inmobi/commons/internal/CommonsConfig:c	Lcom/inmobi/commons/internal/ThinICEConfig;
    //   39: aload_1
    //   40: ldc 67
    //   42: invokevirtual 48	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   45: invokevirtual 69	com/inmobi/commons/internal/ThinICEConfig:a	(Lorg/json/JSONObject;)V
    //   48: aload_1
    //   49: ldc 71
    //   51: getstatic 20	com/inmobi/commons/internal/CommonsConfig:b	Lcom/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL;
    //   54: invokevirtual 75	com/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL:getValue	()I
    //   57: iconst_0
    //   58: iconst_2
    //   59: invokestatic 79	com/inmobi/commons/internal/InternalSDKUtil:getIntFromJSON	(Lorg/json/JSONObject;Ljava/lang/String;III)I
    //   62: i2l
    //   63: invokestatic 85	com/inmobi/commons/internal/Log:getLogLevelValue	(J)Lcom/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL;
    //   66: putstatic 20	com/inmobi/commons/internal/CommonsConfig:b	Lcom/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL;
    //   69: return
    //   70: astore_2
    //   71: new 31	org/json/JSONObject
    //   74: dup
    //   75: invokespecial 32	org/json/JSONObject:<init>	()V
    //   78: astore_2
    //   79: goto -72 -> 7
    //   82: astore_3
    //   83: new 31	org/json/JSONObject
    //   86: dup
    //   87: invokespecial 32	org/json/JSONObject:<init>	()V
    //   90: astore_3
    //   91: goto -77 -> 14
    //   94: astore_2
    //   95: ldc 87
    //   97: new 89	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   104: ldc 92
    //   106: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 100	org/json/JSONObject:toString	()Ljava/lang/String;
    //   113: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 105	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -99 -> 23
    //   125: astore_1
    //   126: ldc 87
    //   128: ldc 107
    //   130: invokestatic 105	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: return
    //   134: astore_2
    //   135: goto -87 -> 48
    //   138: astore_2
    //   139: goto -104 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	CommonsConfig
    //   0	142	1	paramJSONObject	JSONObject
    //   6	16	2	localJSONObject1	JSONObject
    //   70	1	2	localException1	Exception
    //   78	1	2	localJSONObject2	JSONObject
    //   94	1	2	localJSONException1	JSONException
    //   134	1	2	localJSONException2	JSONException
    //   138	1	2	localJSONException3	JSONException
    //   13	2	3	localJSONObject3	JSONObject
    //   82	1	3	localException2	Exception
    //   90	1	3	localJSONObject4	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	7	70	java/lang/Exception
    //   7	14	82	java/lang/Exception
    //   0	7	94	org/json/JSONException
    //   7	14	94	org/json/JSONException
    //   14	21	94	org/json/JSONException
    //   71	79	94	org/json/JSONException
    //   83	91	94	org/json/JSONException
    //   48	69	125	java/lang/Exception
    //   35	48	134	org/json/JSONException
    //   23	35	138	org/json/JSONException
  }
  
  public void setTic(ThinICEConfig paramThinICEConfig)
  {
    this.c = paramThinICEConfig;
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = UID.commons.toJSON();
    JSONObject localJSONObject4 = this.c.toJSON();
    localJSONObject1.put("AND", localJSONObject2);
    localJSONObject1.put("common", new JSONObject());
    localJSONObject2.put("ids", localJSONObject3);
    localJSONObject2.put("tic", localJSONObject4);
    localJSONObject2.put("ll", b);
    return localJSONObject1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/CommonsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */