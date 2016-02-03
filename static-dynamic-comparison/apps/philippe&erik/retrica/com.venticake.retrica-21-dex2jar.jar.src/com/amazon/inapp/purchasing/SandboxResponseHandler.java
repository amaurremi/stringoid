package com.amazon.inapp.purchasing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class SandboxResponseHandler
  implements ResponseHandler
{
  private static final String TAG = "SandboxResponseHandler";
  private final HandlerAdapter _handler = HandlerManager.getMainHandlerAdapter();
  
  private Item getItem(String paramString, JSONObject paramJSONObject)
  {
    Item.ItemType localItemType = Item.ItemType.valueOf(paramJSONObject.optString("itemType"));
    return new Item(paramString, paramJSONObject.optString("price"), localItemType, paramJSONObject.optString("title"), paramJSONObject.optString("description"), paramJSONObject.optString("smallIconUrl"));
  }
  
  private ItemDataResponse getItemDataResponse(Intent paramIntent)
  {
    Iterator localIterator = null;
    localObject6 = null;
    localObject2 = ItemDataResponse.ItemDataRequestStatus.FAILED;
    for (;;)
    {
      Object localObject1;
      HashSet localHashSet;
      try
      {
        localJSONObject = new JSONObject(paramIntent.getStringExtra("itemDataOutput"));
        paramIntent = localJSONObject.optString("requestId");
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject;
        label205:
        Object localObject3;
        label237:
        label245:
        localObject1 = null;
        paramIntent = (Intent)localObject2;
        localHashSet = null;
        localObject5 = localObject6;
        localObject2 = localObject1;
        localObject1 = localHashSet;
        continue;
      }
      for (;;)
      {
        try
        {
          localObject1 = ItemDataResponse.ItemDataRequestStatus.valueOf(localJSONObject.optString("status"));
          localObject2 = localObject1;
          if (localObject1 == ItemDataResponse.ItemDataRequestStatus.FAILED) {
            continue;
          }
          localObject2 = localObject1;
          localHashSet = new HashSet();
        }
        catch (Exception localException3)
        {
          localHashSet = null;
          localObject1 = paramIntent;
          paramIntent = (Intent)localObject2;
          localObject5 = localObject6;
          localObject2 = localHashSet;
          break label205;
          localObject5 = null;
          localObject2 = localException4;
          Object localObject4 = localObject5;
          break label245;
        }
        try
        {
          localObject5 = new HashMap();
          try
          {
            localObject2 = localJSONObject.optJSONArray("unavailableSkus");
            if (localObject2 != null)
            {
              int i = 0;
              while (i < ((JSONArray)localObject2).length())
              {
                localHashSet.add(((JSONArray)localObject2).getString(i));
                i += 1;
              }
            }
            localObject2 = localJSONObject.optJSONObject("items");
            if (localObject2 == null) {
              break label237;
            }
            localIterator = ((JSONObject)localObject2).keys();
            while (localIterator.hasNext())
            {
              localObject6 = (String)localIterator.next();
              ((Map)localObject5).put(localObject6, getItem((String)localObject6, ((JSONObject)localObject2).optJSONObject((String)localObject6)));
            }
            Log.e("SandboxResponseHandler", "Error parsing item data output", localException1);
          }
          catch (Exception localException1)
          {
            localObject6 = localObject1;
            localObject1 = paramIntent;
            localObject2 = localHashSet;
            paramIntent = (Intent)localObject6;
          }
        }
        catch (Exception localException4)
        {
          localObject2 = localObject1;
          localObject1 = paramIntent;
          localObject5 = localObject6;
          paramIntent = (Intent)localObject2;
          localObject2 = localHashSet;
          break label205;
        }
      }
    }
    localObject3 = localObject2;
    localObject2 = localObject5;
    for (;;)
    {
      return new ItemDataResponse((String)localObject1, (Set)localObject3, paramIntent, (Map)localObject2);
      localObject2 = localObject5;
      localObject3 = localHashSet;
      localObject5 = localObject1;
      localObject1 = paramIntent;
      paramIntent = (Intent)localObject5;
    }
  }
  
  private PurchaseResponse getPurchaseResponse(Intent paramIntent)
  {
    Object localObject3 = null;
    localObject1 = PurchaseResponse.PurchaseRequestStatus.FAILED;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramIntent.getStringExtra("purchaseOutput"));
        String str2 = ((JSONObject)localObject2).optString("requestId");
        JSONObject localJSONObject;
        Log.e("SandboxResponseHandler", "Error parsing purchase output", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          str1 = ((JSONObject)localObject2).optString("userId");
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Object localObject2;
            Intent localIntent;
            String str3;
            String str1 = null;
            paramIntent = (Intent)localObject1;
            localObject1 = localException1;
            localException2 = localException3;
          }
        }
        try
        {
          paramIntent = PurchaseResponse.PurchaseRequestStatus.valueOf(((JSONObject)localObject2).optString("purchaseStatus"));
        }
        catch (Exception localException4)
        {
          paramIntent = (Intent)localObject1;
          localObject1 = localException2;
          localException2 = localException4;
          break label123;
        }
        try
        {
          localJSONObject = ((JSONObject)localObject2).optJSONObject("receipt");
          localObject2 = localObject3;
          localIntent = paramIntent;
          str3 = str1;
          localObject1 = str2;
          if (localJSONObject != null)
          {
            localObject2 = getReceipt(localJSONObject);
            localObject1 = str2;
            str3 = str1;
            localIntent = paramIntent;
          }
          return new PurchaseResponse((String)localObject1, str3, (Receipt)localObject2, localIntent);
        }
        catch (Exception localException5)
        {
          localObject1 = localException2;
          localException2 = localException5;
          break label123;
        }
        localException1 = localException1;
        str1 = null;
        localObject2 = null;
        paramIntent = (Intent)localObject1;
        localObject1 = localObject2;
      }
      label123:
      localObject2 = localObject3;
      localIntent = paramIntent;
      str3 = str1;
    }
  }
  
  /* Error */
  private PurchaseUpdatesResponse getPurchaseUpdatesResponse(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 9
    //   8: getstatic 196	com/amazon/inapp/purchasing/PurchaseUpdatesResponse$PurchaseUpdatesRequestStatus:FAILED	Lcom/amazon/inapp/purchasing/PurchaseUpdatesResponse$PurchaseUpdatesRequestStatus;
    //   11: astore 10
    //   13: new 39	org/json/JSONObject
    //   16: dup
    //   17: aload_1
    //   18: ldc -58
    //   20: invokevirtual 79	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 82	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore 11
    //   28: aload 11
    //   30: ldc 84
    //   32: invokevirtual 43	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_1
    //   36: aload 10
    //   38: astore 7
    //   40: aload 11
    //   42: ldc 86
    //   44: invokevirtual 43	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: invokestatic 201	com/amazon/inapp/purchasing/PurchaseUpdatesResponse$PurchaseUpdatesRequestStatus:valueOf	(Ljava/lang/String;)Lcom/amazon/inapp/purchasing/PurchaseUpdatesResponse$PurchaseUpdatesRequestStatus;
    //   50: astore 10
    //   52: aload 10
    //   54: astore 7
    //   56: aload 11
    //   58: ldc -53
    //   60: invokevirtual 43	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore 5
    //   65: aload 11
    //   67: ldc -51
    //   69: invokevirtual 209	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   72: istore 4
    //   74: aload 11
    //   76: ldc -85
    //   78: invokevirtual 43	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 6
    //   83: aload 10
    //   85: getstatic 212	com/amazon/inapp/purchasing/PurchaseUpdatesResponse$PurchaseUpdatesRequestStatus:SUCCESSFUL	Lcom/amazon/inapp/purchasing/PurchaseUpdatesResponse$PurchaseUpdatesRequestStatus;
    //   88: if_acmpne +335 -> 423
    //   91: new 91	java/util/HashSet
    //   94: dup
    //   95: invokespecial 92	java/util/HashSet:<init>	()V
    //   98: astore 7
    //   100: new 91	java/util/HashSet
    //   103: dup
    //   104: invokespecial 92	java/util/HashSet:<init>	()V
    //   107: astore 8
    //   109: aload 11
    //   111: ldc -42
    //   113: invokevirtual 101	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   116: astore 9
    //   118: aload 9
    //   120: ifnull +39 -> 159
    //   123: iconst_0
    //   124: istore_2
    //   125: iload_2
    //   126: aload 9
    //   128: invokevirtual 107	org/json/JSONArray:length	()I
    //   131: if_icmpge +28 -> 159
    //   134: aload 7
    //   136: aload_0
    //   137: aload 9
    //   139: iload_2
    //   140: invokevirtual 217	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   143: invokespecial 182	com/amazon/inapp/purchasing/SandboxResponseHandler:getReceipt	(Lorg/json/JSONObject;)Lcom/amazon/inapp/purchasing/Receipt;
    //   146: invokeinterface 117 2 0
    //   151: pop
    //   152: iload_2
    //   153: iconst_1
    //   154: iadd
    //   155: istore_2
    //   156: goto -31 -> 125
    //   159: aload 11
    //   161: ldc -37
    //   163: invokevirtual 101	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   166: astore 9
    //   168: aload 9
    //   170: ifnull +35 -> 205
    //   173: iload_3
    //   174: istore_2
    //   175: iload_2
    //   176: aload 9
    //   178: invokevirtual 107	org/json/JSONArray:length	()I
    //   181: if_icmpge +24 -> 205
    //   184: aload 8
    //   186: aload 9
    //   188: iload_2
    //   189: invokevirtual 111	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   192: invokeinterface 117 2 0
    //   197: pop
    //   198: iload_2
    //   199: iconst_1
    //   200: iadd
    //   201: istore_2
    //   202: goto -27 -> 175
    //   205: new 221	com/amazon/inapp/purchasing/PurchaseUpdatesResponse
    //   208: dup
    //   209: aload_1
    //   210: aload 6
    //   212: aload 10
    //   214: aload 7
    //   216: aload 8
    //   218: aload 5
    //   220: invokestatic 227	com/amazon/inapp/purchasing/Offset:fromString	(Ljava/lang/String;)Lcom/amazon/inapp/purchasing/Offset;
    //   223: iload 4
    //   225: invokespecial 230	com/amazon/inapp/purchasing/PurchaseUpdatesResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/inapp/purchasing/PurchaseUpdatesResponse$PurchaseUpdatesRequestStatus;Ljava/util/Set;Ljava/util/Set;Lcom/amazon/inapp/purchasing/Offset;Z)V
    //   228: areturn
    //   229: astore 9
    //   231: aconst_null
    //   232: astore 8
    //   234: aconst_null
    //   235: astore 7
    //   237: iconst_0
    //   238: istore 4
    //   240: aconst_null
    //   241: astore 6
    //   243: aconst_null
    //   244: astore_1
    //   245: ldc 18
    //   247: ldc -24
    //   249: aload 9
    //   251: invokestatic 155	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   254: pop
    //   255: aload_1
    //   256: astore 9
    //   258: aload 5
    //   260: astore_1
    //   261: aload 9
    //   263: astore 5
    //   265: goto -60 -> 205
    //   268: astore 9
    //   270: aconst_null
    //   271: astore 8
    //   273: aconst_null
    //   274: astore 11
    //   276: iconst_0
    //   277: istore 4
    //   279: aconst_null
    //   280: astore 6
    //   282: aload_1
    //   283: astore 5
    //   285: aconst_null
    //   286: astore_1
    //   287: aload 7
    //   289: astore 10
    //   291: aload 11
    //   293: astore 7
    //   295: goto -50 -> 245
    //   298: astore 9
    //   300: aconst_null
    //   301: astore 8
    //   303: iconst_0
    //   304: istore 4
    //   306: aconst_null
    //   307: astore 11
    //   309: aconst_null
    //   310: astore 7
    //   312: aload_1
    //   313: astore 6
    //   315: aload 5
    //   317: astore_1
    //   318: aload 6
    //   320: astore 5
    //   322: aload 11
    //   324: astore 6
    //   326: goto -81 -> 245
    //   329: astore 9
    //   331: aconst_null
    //   332: astore 8
    //   334: aconst_null
    //   335: astore 7
    //   337: aload_1
    //   338: astore 6
    //   340: aload 5
    //   342: astore_1
    //   343: aconst_null
    //   344: astore 11
    //   346: aload 6
    //   348: astore 5
    //   350: aload 7
    //   352: astore 6
    //   354: aload 11
    //   356: astore 7
    //   358: goto -113 -> 245
    //   361: astore 9
    //   363: aconst_null
    //   364: astore 8
    //   366: aload_1
    //   367: astore 7
    //   369: aload 5
    //   371: astore_1
    //   372: aconst_null
    //   373: astore 11
    //   375: aload 7
    //   377: astore 5
    //   379: aload 11
    //   381: astore 7
    //   383: goto -138 -> 245
    //   386: astore 9
    //   388: aconst_null
    //   389: astore 11
    //   391: aload_1
    //   392: astore 8
    //   394: aload 5
    //   396: astore_1
    //   397: aload 8
    //   399: astore 5
    //   401: aload 11
    //   403: astore 8
    //   405: goto -160 -> 245
    //   408: astore 9
    //   410: aload_1
    //   411: astore 11
    //   413: aload 5
    //   415: astore_1
    //   416: aload 11
    //   418: astore 5
    //   420: goto -175 -> 245
    //   423: aconst_null
    //   424: astore 8
    //   426: aload 9
    //   428: astore 7
    //   430: goto -225 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	SandboxResponseHandler
    //   0	433	1	paramIntent	Intent
    //   124	78	2	i	int
    //   1	173	3	j	int
    //   72	233	4	bool	boolean
    //   3	416	5	localObject1	Object
    //   81	272	6	localObject2	Object
    //   38	391	7	localObject3	Object
    //   107	318	8	localObject4	Object
    //   6	181	9	localJSONArray	JSONArray
    //   229	21	9	localException1	Exception
    //   256	6	9	localIntent	Intent
    //   268	1	9	localException2	Exception
    //   298	1	9	localException3	Exception
    //   329	1	9	localException4	Exception
    //   361	1	9	localException5	Exception
    //   386	1	9	localException6	Exception
    //   408	19	9	localException7	Exception
    //   11	279	10	localObject5	Object
    //   26	391	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   13	36	229	java/lang/Exception
    //   40	52	268	java/lang/Exception
    //   56	65	268	java/lang/Exception
    //   65	74	298	java/lang/Exception
    //   74	83	329	java/lang/Exception
    //   83	100	361	java/lang/Exception
    //   100	109	386	java/lang/Exception
    //   109	118	408	java/lang/Exception
    //   125	152	408	java/lang/Exception
    //   159	168	408	java/lang/Exception
    //   175	198	408	java/lang/Exception
  }
  
  private Receipt getReceipt(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    String str1 = paramJSONObject.optString("sku");
    Item.ItemType localItemType = Item.ItemType.valueOf(paramJSONObject.optString("itemType"));
    Object localObject1 = paramJSONObject.optJSONObject("subscripionPeriod");
    SimpleDateFormat localSimpleDateFormat;
    Date localDate;
    String str2;
    if (localItemType == Item.ItemType.SUBSCRIPTION)
    {
      localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      localDate = localSimpleDateFormat.parse(((JSONObject)localObject1).optString("startTime"));
      str2 = ((JSONObject)localObject1).optString("endTime");
      localObject1 = localObject2;
      if (str2 != null)
      {
        if (str2.length() != 0) {
          break label117;
        }
        localObject1 = localObject2;
      }
    }
    for (localObject1 = new SubscriptionPeriod(localDate, (Date)localObject1);; localObject1 = null)
    {
      return new Receipt(str1, localItemType, false, (SubscriptionPeriod)localObject1, paramJSONObject.optString("token"));
      label117:
      localObject1 = localSimpleDateFormat.parse(str2);
      break;
    }
  }
  
  private GetUserIdResponse getUserIdResponse(Intent paramIntent)
  {
    Object localObject3 = null;
    for (localObject2 = GetUserIdResponse.GetUserIdRequestStatus.FAILED;; localObject2 = null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramIntent.getStringExtra("userOutput"));
        String str = localJSONObject.optString("requestId");
        Object localObject1;
        Log.e("SandboxResponseHandler", "Error parsing userid output", (Throwable)localObject2);
      }
      catch (Exception localException1)
      {
        try
        {
          paramIntent = GetUserIdResponse.GetUserIdRequestStatus.valueOf(localJSONObject.optString("status"));
          localObject2 = localObject3;
        }
        catch (Exception localException3)
        {
          paramIntent = (Intent)localObject2;
          localObject2 = localException3;
          continue;
        }
        try
        {
          if (paramIntent == GetUserIdResponse.GetUserIdRequestStatus.SUCCESSFUL) {
            localObject2 = localJSONObject.optString("userId");
          }
          return new GetUserIdResponse(str, paramIntent, (String)localObject2);
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        localObject3 = null;
        paramIntent = (Intent)localObject2;
        localObject2 = localException1;
        localObject1 = localObject3;
      }
    }
  }
  
  private void handleItemDataResponse(Intent paramIntent)
  {
    paramIntent = new Runnable()
    {
      public void run()
      {
        if (Logger.isTraceOn()) {
          Logger.trace("SandboxResponseHandler", "Running Runnable for itemDataResponse with requestId: " + this.val$response.getRequestId());
        }
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        if (localPurchasingObserver != null) {
          localPurchasingObserver.onItemDataResponse(this.val$response);
        }
      }
    };
    this._handler.post(paramIntent);
  }
  
  private void handlePurchaseResponse(Intent paramIntent)
  {
    paramIntent = new Runnable()
    {
      public void run()
      {
        if (Logger.isTraceOn()) {
          Logger.trace("SandboxResponseHandler", "Running Runnable for purchaseResponse with requestId: " + this.val$response.getRequestId());
        }
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        if (localPurchasingObserver != null) {
          localPurchasingObserver.onPurchaseResponse(this.val$response);
        }
      }
    };
    this._handler.post(paramIntent);
  }
  
  private void handlePurchaseUpdatesResponse(Intent paramIntent)
  {
    paramIntent = new Runnable()
    {
      public void run()
      {
        if (Logger.isTraceOn()) {
          Logger.trace("SandboxResponseHandler", "Running Runnable for purchaseUpdatesResponse with requestId: " + this.val$response.getRequestId());
        }
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        if (localPurchasingObserver != null) {
          localPurchasingObserver.onPurchaseUpdatesResponse(this.val$response);
        }
      }
    };
    this._handler.post(paramIntent);
  }
  
  private void handleUserIdResponse(Intent paramIntent)
  {
    paramIntent = new Runnable()
    {
      public void run()
      {
        if (Logger.isTraceOn()) {
          Logger.trace("SandboxResponseHandler", "Running Runnable for userIdResponse with requestId: " + this.val$response.getRequestId());
        }
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        if (localPurchasingObserver != null) {
          localPurchasingObserver.onGetUserIdResponse(this.val$response);
        }
      }
    };
    this._handler.post(paramIntent);
  }
  
  public void handleResponse(Context paramContext, Intent paramIntent)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("SandboxResponseHandler", "handleResponse");
    }
    try
    {
      paramContext = paramIntent.getExtras().getString("responseType");
      if (paramContext.equalsIgnoreCase("com.amazon.testclient.iap.purchase"))
      {
        handlePurchaseResponse(paramIntent);
        return;
      }
      if (paramContext.equalsIgnoreCase("com.amazon.testclient.iap.appUserId"))
      {
        handleUserIdResponse(paramIntent);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("SandboxResponseHandler", "Error handling response.", paramContext);
      return;
    }
    if (paramContext.equalsIgnoreCase("com.amazon.testclient.iap.itemData"))
    {
      handleItemDataResponse(paramIntent);
      return;
    }
    if (paramContext.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
      handlePurchaseUpdatesResponse(paramIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/SandboxResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */