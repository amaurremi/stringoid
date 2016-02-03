package com.inmobi.commons.analytics.db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.internal.Log;

import java.util.ArrayList;

import org.json.JSONObject;

public class FunctionTagTransaction
        extends AnalyticsFunctions {
    private Context a;
    private Intent b;
    private Bundle c;

    public FunctionTagTransaction(Context paramContext, Intent paramIntent, Bundle paramBundle) {
        this.a = paramContext;
        this.b = paramIntent;
        this.c = paramBundle;
    }

    /* Error */
    private AnalyticsEvent a() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	com/inmobi/commons/analytics/db/FunctionTagTransaction:a	Landroid/content/Context;
        //   4: invokestatic 33	com/inmobi/commons/analytics/util/SessionInfo:getSessionId	(Landroid/content/Context;)Ljava/lang/String;
        //   7: ifnull +299 -> 306
        //   10: aload_0
        //   11: getfield 19	com/inmobi/commons/analytics/db/FunctionTagTransaction:b	Landroid/content/Intent;
        //   14: ifnull +292 -> 306
        //   17: new 35	com/inmobi/commons/analytics/db/AnalyticsEvent
        //   20: dup
        //   21: ldc 37
        //   23: invokespecial 40	com/inmobi/commons/analytics/db/AnalyticsEvent:<init>	(Ljava/lang/String;)V
        //   26: astore 6
        //   28: aload_0
        //   29: getfield 19	com/inmobi/commons/analytics/db/FunctionTagTransaction:b	Landroid/content/Intent;
        //   32: ldc 42
        //   34: iconst_0
        //   35: invokevirtual 48	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
        //   38: istore_1
        //   39: aload_0
        //   40: getfield 19	com/inmobi/commons/analytics/db/FunctionTagTransaction:b	Landroid/content/Intent;
        //   43: ldc 50
        //   45: invokevirtual 54	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   48: astore 8
        //   50: aload 6
        //   52: astore 7
        //   54: iload_1
        //   55: ifne +148 -> 203
        //   58: new 56	org/json/JSONObject
        //   61: dup
        //   62: aload 8
        //   64: invokespecial 57	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   67: astore 7
        //   69: aload 6
        //   71: aload 7
        //   73: ldc 59
        //   75: invokevirtual 62	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   78: invokevirtual 65	com/inmobi/commons/analytics/db/AnalyticsEvent:setTransactionId	(Ljava/lang/String;)V
        //   81: aload 6
        //   83: aload 7
        //   85: ldc 67
        //   87: invokevirtual 62	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   90: invokevirtual 70	com/inmobi/commons/analytics/db/AnalyticsEvent:setTransactionProductId	(Ljava/lang/String;)V
        //   93: aload 7
        //   95: ldc 72
        //   97: invokevirtual 76	org/json/JSONObject:getLong	(Ljava/lang/String;)J
        //   100: lstore 4
        //   102: lload 4
        //   104: lstore_2
        //   105: lconst_0
        //   106: lload 4
        //   108: lcmp
        //   109: ifne +7 -> 116
        //   112: invokestatic 82	java/lang/System:currentTimeMillis	()J
        //   115: lstore_2
        //   116: aload 6
        //   118: lload_2
        //   119: ldc2_w 83
        //   122: ldiv
        //   123: invokevirtual 88	com/inmobi/commons/analytics/db/AnalyticsEvent:setEventTimeStamp	(J)V
        //   126: aload 7
        //   128: ldc 90
        //   130: invokevirtual 94	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   133: istore_1
        //   134: getstatic 100	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES:PURCHASED	Lcom/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES;
        //   137: invokevirtual 104	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES:getValue	()I
        //   140: iload_1
        //   141: if_icmpne +65 -> 206
        //   144: getstatic 109	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:PURCHASED	Lcom/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE;
        //   147: invokevirtual 110	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:getValue	()I
        //   150: istore_1
        //   151: aload 6
        //   153: iload_1
        //   154: invokevirtual 114	com/inmobi/commons/analytics/db/AnalyticsEvent:setTransactionStatus	(I)V
        //   157: aload_0
        //   158: aload 6
        //   160: invokespecial 117	com/inmobi/commons/analytics/db/FunctionTagTransaction:a	(Lcom/inmobi/commons/analytics/db/AnalyticsEvent;)Lcom/inmobi/commons/analytics/db/AnalyticsEvent;
        //   163: astore 7
        //   165: aload 7
        //   167: astore 6
        //   169: aload 6
        //   171: aload_0
        //   172: getfield 17	com/inmobi/commons/analytics/db/FunctionTagTransaction:a	Landroid/content/Context;
        //   175: invokestatic 33	com/inmobi/commons/analytics/util/SessionInfo:getSessionId	(Landroid/content/Context;)Ljava/lang/String;
        //   178: invokevirtual 120	com/inmobi/commons/analytics/db/AnalyticsEvent:setEventSessionId	(Ljava/lang/String;)V
        //   181: aload 6
        //   183: aload_0
        //   184: getfield 17	com/inmobi/commons/analytics/db/FunctionTagTransaction:a	Landroid/content/Context;
        //   187: invokestatic 124	com/inmobi/commons/analytics/util/SessionInfo:getSessionTime	(Landroid/content/Context;)J
        //   190: invokevirtual 127	com/inmobi/commons/analytics/db/AnalyticsEvent:setEventSessionTimeStamp	(J)V
        //   193: aload_0
        //   194: aload 6
        //   196: invokevirtual 131	com/inmobi/commons/analytics/db/FunctionTagTransaction:insertInDatabase	(Lcom/inmobi/commons/analytics/db/AnalyticsEvent;)V
        //   199: aload 6
        //   201: astore 7
        //   203: aload 7
        //   205: areturn
        //   206: getstatic 134	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES:FAILED	Lcom/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES;
        //   209: invokevirtual 104	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES:getValue	()I
        //   212: iload_1
        //   213: if_icmpne +13 -> 226
        //   216: getstatic 136	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:FAILED	Lcom/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE;
        //   219: invokevirtual 110	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:getValue	()I
        //   222: istore_1
        //   223: goto -72 -> 151
        //   226: getstatic 139	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES:REFUNDED	Lcom/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES;
        //   229: invokevirtual 104	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES:getValue	()I
        //   232: iload_1
        //   233: if_icmpne +13 -> 246
        //   236: getstatic 141	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:REFUNDED	Lcom/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE;
        //   239: invokevirtual 110	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:getValue	()I
        //   242: istore_1
        //   243: goto -92 -> 151
        //   246: getstatic 144	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:RESTORED	Lcom/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE;
        //   249: invokevirtual 110	com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE:getValue	()I
        //   252: istore_1
        //   253: goto -102 -> 151
        //   256: astore 6
        //   258: ldc -110
        //   260: ldc -108
        //   262: invokestatic 154	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   265: ldc -110
        //   267: ldc -100
        //   269: aload 6
        //   271: invokestatic 160	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   274: aconst_null
        //   275: areturn
        //   276: ldc -110
        //   278: ldc -94
        //   280: invokestatic 154	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   283: ldc -110
        //   285: ldc -92
        //   287: aload 7
        //   289: invokestatic 160	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   292: goto -99 -> 193
        //   295: astore 6
        //   297: ldc -110
        //   299: ldc -90
        //   301: aload 6
        //   303: invokestatic 160	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   306: aconst_null
        //   307: areturn
        //   308: astore 7
        //   310: goto -34 -> 276
        //   313: astore 7
        //   315: goto -39 -> 276
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	318	0	this	FunctionTagTransaction
        //   38	215	1	i	int
        //   104	15	2	l1	long
        //   100	7	4	l2	long
        //   26	174	6	localObject1	Object
        //   256	14	6	localJSONException	org.json.JSONException
        //   295	7	6	localException1	Exception
        //   52	236	7	localObject2	Object
        //   308	1	7	localException2	Exception
        //   313	1	7	localException3	Exception
        //   48	15	8	str	String
        // Exception table:
        //   from	to	target	type
        //   58	102	256	org/json/JSONException
        //   112	116	256	org/json/JSONException
        //   116	151	256	org/json/JSONException
        //   151	157	256	org/json/JSONException
        //   206	223	256	org/json/JSONException
        //   226	243	256	org/json/JSONException
        //   246	253	256	org/json/JSONException
        //   0	50	295	java/lang/Exception
        //   58	102	295	java/lang/Exception
        //   112	116	295	java/lang/Exception
        //   116	151	295	java/lang/Exception
        //   151	157	295	java/lang/Exception
        //   193	199	295	java/lang/Exception
        //   206	223	295	java/lang/Exception
        //   226	243	295	java/lang/Exception
        //   246	253	295	java/lang/Exception
        //   258	274	295	java/lang/Exception
        //   276	292	295	java/lang/Exception
        //   169	193	308	java/lang/Exception
        //   157	165	313	java/lang/Exception
    }

    private AnalyticsEvent a(AnalyticsEvent paramAnalyticsEvent) {
        for (; ; ) {
            try {
                if (this.c.getInt("RESPONSE_CODE") != 0) {
                    break;
                }
                ArrayList localArrayList = this.c.getStringArrayList("DETAILS_LIST");
                int i = 0;
                if (i >= localArrayList.size()) {
                    break;
                }
                Object localObject = new JSONObject((String) localArrayList.get(i));
                String str1 = ((JSONObject) localObject).getString("productId");
                long l = ((JSONObject) localObject).getLong("price_amount_micros");
                String str2 = ((JSONObject) localObject).getString("price_currency_code");
                String str3 = ((JSONObject) localObject).optString("type");
                String str4 = ((JSONObject) localObject).optString("title");
                localObject = ((JSONObject) localObject).optString("description");
                if (str1.equals(paramAnalyticsEvent.getTransactionProductId())) {
                    paramAnalyticsEvent.setTransactionItemCount(1);
                    paramAnalyticsEvent.setTransactionItemDescription((String) localObject);
                    paramAnalyticsEvent.setTransactionItemName(str4);
                    if ("inapp".equals(str3)) {
                        paramAnalyticsEvent.setTransactionItemType(AnalyticsEvent.TRANSACTION_ITEM_TYPE.INAPP.getValue());
                        paramAnalyticsEvent.setTransactionItemPrice(l / 1000000.0D);
                        paramAnalyticsEvent.setTransactionCurrencyCode(str2);
                        return paramAnalyticsEvent;
                    }
                    if (!"subs".equals(str3)) {
                        continue;
                    }
                    paramAnalyticsEvent.setTransactionItemType(AnalyticsEvent.TRANSACTION_ITEM_TYPE.SUBSCRIPTION.getValue());
                    continue;
                }
                i += 1;
            } catch (Exception localException) {
                Log.internal("[InMobi]-[Analytics]-4.5.1", "Failed to set purchase bundle info", localException);
                return paramAnalyticsEvent;
            }
        }
        return paramAnalyticsEvent;
    }

    public AnalyticsEvent processFunction() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/FunctionTagTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */