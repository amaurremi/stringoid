package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class MMDevice
  extends MMJSObject
{
  public MMJSResponse call(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    String str = (String)paramHashMap.get("number");
    if ((localContext != null) && (str != null))
    {
      MMAdViewSDK.Log.d("Dialing Phone: %s", new Object[] { str });
      localContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE");
      if ((Boolean.parseBoolean((String)paramHashMap.get("dial"))) && (localContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)) {}
      for (paramHashMap = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));; paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str)))
      {
        paramHashMap.setFlags(603979776);
        if (!(localContext instanceof Activity)) {
          paramHashMap.addFlags(268435456);
        }
        localContext.startActivity(paramHashMap);
        MMAdViewSDK.Event.intentStarted(localContext, null, "tel");
        return MMJSResponse.responseWithSuccess();
      }
    }
    return null;
  }
  
  public MMJSResponse composeEmail(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    String str1 = (String)paramHashMap.get("recipients");
    String str2 = (String)paramHashMap.get("subject");
    paramHashMap = (String)paramHashMap.get("message");
    if (localContext != null)
    {
      MMAdViewSDK.Log.d("Creating email");
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      if (str1 != null) {
        localIntent.putExtra("android.intent.extra.EMAIL", str1.split(","));
      }
      if (str2 != null) {
        localIntent.putExtra("android.intent.extra.SUBJECT", str2);
      }
      if (paramHashMap != null) {
        localIntent.putExtra("android.intent.extra.TEXT", paramHashMap);
      }
      localIntent.setFlags(603979776);
      if (!(localContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      localContext.startActivity(localIntent);
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
  
  public MMJSResponse composeSms(HashMap<String, String> paramHashMap)
  {
    Object localObject = null;
    Context localContext = (Context)this.contextRef.get();
    String str1 = (String)paramHashMap.get("number");
    String str2 = (String)paramHashMap.get("message");
    paramHashMap = (HashMap<String, String>)localObject;
    if (localContext != null)
    {
      paramHashMap = (HashMap<String, String>)localObject;
      if (str1 != null)
      {
        MMAdViewSDK.Log.d("Creating sms: %s", new Object[] { str1 });
        paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + str1));
        if (str2 != null) {
          paramHashMap.putExtra("sms_body", str2);
        }
        paramHashMap.setFlags(603979776);
        if (!(localContext instanceof Activity)) {
          paramHashMap.addFlags(268435456);
        }
        localContext.startActivity(paramHashMap);
        MMAdViewSDK.Event.intentStarted(localContext, null, "sms");
        paramHashMap = MMJSResponse.responseWithSuccess();
      }
    }
    return paramHashMap;
  }
  
  public MMJSResponse getAvailableSchemes(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (Context)this.contextRef.get();
    if (paramHashMap != null)
    {
      HandShake localHandShake = HandShake.sharedHandShake(paramHashMap);
      MMJSResponse localMMJSResponse = new MMJSResponse();
      localMMJSResponse.result = 1;
      localMMJSResponse.response = localHandShake.getSchemesJSONArray(paramHashMap);
      return localMMJSResponse;
    }
    return null;
  }
  
  /* Error */
  public MMJSResponse getInfo(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 15	com/millennialmedia/android/MMDevice:contextRef	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 21	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 23	android/content/Context
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +303 -> 317
    //   17: new 190	org/json/JSONObject
    //   20: dup
    //   21: invokespecial 191	org/json/JSONObject:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc -63
    //   28: ldc -61
    //   30: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload_1
    //   35: ldc -55
    //   37: aload_3
    //   38: invokestatic 207	com/millennialmedia/android/MMAdViewSDK:getConnectionType	(Landroid/content/Context;)Ljava/lang/String;
    //   41: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload_1
    //   46: ldc -47
    //   48: ldc -45
    //   50: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   53: pop
    //   54: getstatic 217	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   57: ifnull +13 -> 70
    //   60: aload_1
    //   61: ldc -37
    //   63: getstatic 217	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   66: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   69: pop
    //   70: getstatic 224	android/os/Build:MODEL	Ljava/lang/String;
    //   73: ifnull +13 -> 86
    //   76: aload_1
    //   77: ldc -30
    //   79: getstatic 224	android/os/Build:MODEL	Ljava/lang/String;
    //   82: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload_3
    //   87: invokestatic 172	com/millennialmedia/android/HandShake:sharedHandShake	(Landroid/content/Context;)Lcom/millennialmedia/android/HandShake;
    //   90: getfield 230	com/millennialmedia/android/HandShake:hdid	Z
    //   93: ifeq +205 -> 298
    //   96: aload_1
    //   97: ldc -25
    //   99: aload_3
    //   100: invokestatic 234	com/millennialmedia/android/MMAdViewSDK:getHdid	(Landroid/content/Context;)Ljava/lang/String;
    //   103: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload_1
    //   108: ldc -20
    //   110: aload_3
    //   111: invokestatic 239	com/millennialmedia/android/MMAdViewSDK:getMMdid	(Landroid/content/Context;)Ljava/lang/String;
    //   114: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_3
    //   119: invokevirtual 243	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   122: invokevirtual 249	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   125: astore_2
    //   126: aload_1
    //   127: ldc -5
    //   129: new 253	java/lang/Float
    //   132: dup
    //   133: aload_2
    //   134: getfield 258	android/util/DisplayMetrics:density	F
    //   137: invokespecial 261	java/lang/Float:<init>	(F)V
    //   140: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc_w 263
    //   148: new 265	java/lang/Integer
    //   151: dup
    //   152: aload_2
    //   153: getfield 268	android/util/DisplayMetrics:heightPixels	I
    //   156: invokespecial 271	java/lang/Integer:<init>	(I)V
    //   159: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   162: pop
    //   163: aload_1
    //   164: ldc_w 273
    //   167: new 265	java/lang/Integer
    //   170: dup
    //   171: aload_2
    //   172: getfield 276	android/util/DisplayMetrics:widthPixels	I
    //   175: invokespecial 271	java/lang/Integer:<init>	(I)V
    //   178: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   181: pop
    //   182: invokestatic 282	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +27 -> 214
    //   190: aload_1
    //   191: ldc_w 284
    //   194: aload_2
    //   195: invokevirtual 287	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   198: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload_1
    //   203: ldc_w 289
    //   206: aload_2
    //   207: invokevirtual 292	java/util/Locale:getCountry	()Ljava/lang/String;
    //   210: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: new 190	org/json/JSONObject
    //   217: dup
    //   218: invokespecial 191	org/json/JSONObject:<init>	()V
    //   221: astore_2
    //   222: aload_2
    //   223: ldc_w 294
    //   226: ldc_w 296
    //   229: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_2
    //   234: ldc_w 298
    //   237: ldc_w 300
    //   240: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload_2
    //   245: ldc_w 302
    //   248: getstatic 305	com/millennialmedia/android/MMAdViewSDK:macId	Ljava/lang/String;
    //   251: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   254: pop
    //   255: new 307	org/json/JSONArray
    //   258: dup
    //   259: invokespecial 308	org/json/JSONArray:<init>	()V
    //   262: astore_3
    //   263: aload_3
    //   264: aload_2
    //   265: invokevirtual 311	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   268: pop
    //   269: aload_1
    //   270: ldc_w 313
    //   273: aload_3
    //   274: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   277: pop
    //   278: new 107	com/millennialmedia/android/MMJSResponse
    //   281: dup
    //   282: invokespecial 173	com/millennialmedia/android/MMJSResponse:<init>	()V
    //   285: astore_2
    //   286: aload_2
    //   287: iconst_1
    //   288: putfield 177	com/millennialmedia/android/MMJSResponse:result	I
    //   291: aload_2
    //   292: aload_1
    //   293: putfield 185	com/millennialmedia/android/MMJSResponse:response	Ljava/lang/Object;
    //   296: aload_2
    //   297: areturn
    //   298: aload_1
    //   299: ldc_w 315
    //   302: aload_3
    //   303: invokestatic 318	com/millennialmedia/android/MMAdViewSDK:getAuid	(Landroid/content/Context;)Ljava/lang/String;
    //   306: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: goto -203 -> 107
    //   313: astore_2
    //   314: goto -36 -> 278
    //   317: aconst_null
    //   318: areturn
    //   319: astore_1
    //   320: aload_2
    //   321: astore_1
    //   322: goto -44 -> 278
    //   325: astore_2
    //   326: goto -48 -> 278
    //   329: astore_2
    //   330: goto -52 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	MMDevice
    //   0	333	1	paramHashMap	HashMap<String, String>
    //   1	296	2	localObject1	Object
    //   313	8	2	localJSONException1	JSONException
    //   325	1	2	localJSONException2	JSONException
    //   329	1	2	localJSONException3	JSONException
    //   12	291	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	70	313	org/json/JSONException
    //   70	86	313	org/json/JSONException
    //   86	107	313	org/json/JSONException
    //   107	186	313	org/json/JSONException
    //   190	214	313	org/json/JSONException
    //   214	222	313	org/json/JSONException
    //   298	310	313	org/json/JSONException
    //   17	25	319	org/json/JSONException
    //   222	263	325	org/json/JSONException
    //   263	278	329	org/json/JSONException
  }
  
  public MMJSResponse getLocation(HashMap<String, String> paramHashMap)
  {
    if (MMAdViewSDK.location != null) {
      localMMJSResponse = null;
    }
    for (;;)
    {
      try
      {
        paramHashMap = new JSONObject();
      }
      catch (JSONException paramHashMap)
      {
        paramHashMap = localMMJSResponse;
        continue;
      }
      try
      {
        paramHashMap.put("lat", Double.toString(MMAdViewSDK.location.getLatitude()));
        paramHashMap.put("long", Double.toString(MMAdViewSDK.location.getLongitude()));
        if (MMAdViewSDK.location.hasAccuracy())
        {
          paramHashMap.put("ha", Float.toString(MMAdViewSDK.location.getAccuracy()));
          paramHashMap.put("va", Float.toString(MMAdViewSDK.location.getAccuracy()));
        }
        if (MMAdViewSDK.location.hasSpeed()) {
          paramHashMap.put("spd", Float.toString(MMAdViewSDK.location.getSpeed()));
        }
        if (MMAdViewSDK.location.hasBearing()) {
          paramHashMap.put("brg", Float.toString(MMAdViewSDK.location.getBearing()));
        }
        if (MMAdViewSDK.location.hasAltitude()) {
          paramHashMap.put("alt", Double.toString(MMAdViewSDK.location.getAltitude()));
        }
        paramHashMap.put("tslr", Long.toString(MMAdViewSDK.location.getTime()));
      }
      catch (JSONException localJSONException) {}
    }
    localMMJSResponse = new MMJSResponse();
    localMMJSResponse.result = 1;
    localMMJSResponse.response = paramHashMap;
    return localMMJSResponse;
    return null;
  }
  
  public MMJSResponse getOrientation(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (Context)this.contextRef.get();
    if (paramHashMap != null)
    {
      int j = paramHashMap.getResources().getConfiguration().orientation;
      int i = j;
      if (j == 0) {
        i = ((WindowManager)paramHashMap.getSystemService("window")).getDefaultDisplay().getOrientation();
      }
      paramHashMap = new MMJSResponse();
      paramHashMap.result = 1;
      switch (i)
      {
      default: 
        paramHashMap.response = "portrait";
        return paramHashMap;
      }
      paramHashMap.response = "landscape";
      return paramHashMap;
    }
    return null;
  }
  
  public MMJSResponse getPlacementType(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("OVERLAY_type");
    if (paramHashMap != null)
    {
      MMJSResponse localMMJSResponse = new MMJSResponse();
      localMMJSResponse.result = 1;
      if (paramHashMap.equals("true")) {}
      for (paramHashMap = "inline";; paramHashMap = "interstitial")
      {
        localMMJSResponse.response = paramHashMap;
        return localMMJSResponse;
      }
    }
    return null;
  }
  
  public MMJSResponse getState(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("OVERLAY_state");
    if (paramHashMap != null)
    {
      MMJSResponse localMMJSResponse = new MMJSResponse();
      localMMJSResponse.result = 1;
      localMMJSResponse.response = paramHashMap;
      return localMMJSResponse;
    }
    return null;
  }
  
  public MMJSResponse isSchemeAvailable(HashMap<String, String> paramHashMap)
  {
    Object localObject = (String)paramHashMap.get("scheme");
    paramHashMap = (HashMap<String, String>)localObject;
    if (!((String)localObject).contains(":")) {
      paramHashMap = (String)localObject + ":";
    }
    localObject = (Context)this.contextRef.get();
    if ((paramHashMap != null) && (localObject != null))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramHashMap));
      if (((Context)localObject).getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0) {
        return MMJSResponse.responseWithSuccess(paramHashMap);
      }
    }
    return MMJSResponse.responseWithError(paramHashMap);
  }
  
  public MMJSResponse openAppStore(HashMap<String, String> paramHashMap)
  {
    Object localObject = null;
    Context localContext = (Context)this.contextRef.get();
    String str1 = (String)paramHashMap.get("appId");
    String str2 = (String)paramHashMap.get("referrer");
    paramHashMap = (HashMap<String, String>)localObject;
    if (localContext != null)
    {
      paramHashMap = (HashMap<String, String>)localObject;
      if (str1 != null)
      {
        MMAdViewSDK.Log.d("Opening marketplace: %s", new Object[] { str1 });
        paramHashMap = new Intent("android.intent.action.VIEW");
        if (str2 == null) {
          break label151;
        }
        paramHashMap.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[] { str1, URLEncoder.encode(str2) })));
      }
    }
    for (;;)
    {
      paramHashMap.setFlags(603979776);
      if (!(localContext instanceof Activity)) {
        paramHashMap.addFlags(268435456);
      }
      MMAdViewSDK.Event.intentStarted(localContext, null, "market");
      localContext.startActivity(paramHashMap);
      paramHashMap = MMJSResponse.responseWithSuccess();
      return paramHashMap;
      label151:
      paramHashMap.setData(Uri.parse("market://details?id=" + str1));
    }
  }
  
  public MMJSResponse openUrl(HashMap<String, String> paramHashMap)
  {
    Object localObject = null;
    Context localContext = (Context)this.contextRef.get();
    String str = (String)paramHashMap.get("url");
    paramHashMap = (HashMap<String, String>)localObject;
    if (localContext != null)
    {
      paramHashMap = (HashMap<String, String>)localObject;
      if (str != null)
      {
        MMAdViewSDK.Log.d("Opening: %s", new Object[] { str });
        paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse(str));
        paramHashMap.setFlags(603979776);
        if (!(localContext instanceof Activity)) {
          paramHashMap.addFlags(268435456);
        }
        if ((paramHashMap.getScheme().startsWith("http")) || (paramHashMap.getScheme().startsWith("https"))) {
          MMAdViewSDK.Event.intentStarted(localContext, null, "browser");
        }
        localContext.startActivity(paramHashMap);
        paramHashMap = MMJSResponse.responseWithSuccess();
      }
    }
    return paramHashMap;
  }
  
  public MMJSResponse setMMDID(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("mmdid");
    Context localContext = (Context)this.contextRef.get();
    if (localContext != null)
    {
      HandShake.sharedHandShake(localContext).setMMdid(localContext, paramHashMap);
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
  
  public MMJSResponse showMap(HashMap<String, String> paramHashMap)
  {
    Object localObject = null;
    Context localContext = (Context)this.contextRef.get();
    String str = (String)paramHashMap.get("location");
    paramHashMap = (HashMap<String, String>)localObject;
    if (localContext != null)
    {
      paramHashMap = (HashMap<String, String>)localObject;
      if (str != null)
      {
        MMAdViewSDK.Log.d("Launching Google Maps: %s", new Object[] { str });
        paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + str));
        paramHashMap.setFlags(603979776);
        if (!(localContext instanceof Activity)) {
          paramHashMap.addFlags(268435456);
        }
        localContext.startActivity(paramHashMap);
        MMAdViewSDK.Event.intentStarted(localContext, null, "geo");
        paramHashMap = MMJSResponse.responseWithSuccess();
      }
    }
    return paramHashMap;
  }
  
  public MMJSResponse tweet(HashMap<String, String> paramHashMap)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */