package com.millennialmedia.android;

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

class BridgeMMDevice
  extends MMJSObject
{
  /* Error */
  static JSONObject getDeviceInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 15	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 16	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 18
    //   11: ldc 20
    //   13: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   16: pop
    //   17: aload_1
    //   18: ldc 26
    //   20: ldc 20
    //   22: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   25: pop
    //   26: aload_1
    //   27: ldc 28
    //   29: aload_0
    //   30: invokestatic 34	com/millennialmedia/android/MMSDK:getConnectionType	(Landroid/content/Context;)Ljava/lang/String;
    //   33: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   36: pop
    //   37: aload_1
    //   38: ldc 36
    //   40: ldc 38
    //   42: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   45: pop
    //   46: getstatic 44	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   49: ifnull +13 -> 62
    //   52: aload_1
    //   53: ldc 46
    //   55: getstatic 44	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   58: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: getstatic 51	android/os/Build:MODEL	Ljava/lang/String;
    //   65: ifnull +13 -> 78
    //   68: aload_1
    //   69: ldc 53
    //   71: getstatic 51	android/os/Build:MODEL	Ljava/lang/String;
    //   74: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   77: pop
    //   78: aload_1
    //   79: ldc 55
    //   81: aload_0
    //   82: invokestatic 58	com/millennialmedia/android/MMSDK:getMMdid	(Landroid/content/Context;)Ljava/lang/String;
    //   85: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload_0
    //   90: invokevirtual 64	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   93: invokevirtual 70	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   96: astore_0
    //   97: aload_1
    //   98: ldc 72
    //   100: new 74	java/lang/Float
    //   103: dup
    //   104: aload_0
    //   105: getfield 79	android/util/DisplayMetrics:density	F
    //   108: invokespecial 82	java/lang/Float:<init>	(F)V
    //   111: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   114: pop
    //   115: aload_1
    //   116: ldc 84
    //   118: new 86	java/lang/Integer
    //   121: dup
    //   122: aload_0
    //   123: getfield 90	android/util/DisplayMetrics:heightPixels	I
    //   126: invokespecial 93	java/lang/Integer:<init>	(I)V
    //   129: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   132: pop
    //   133: aload_1
    //   134: ldc 95
    //   136: new 86	java/lang/Integer
    //   139: dup
    //   140: aload_0
    //   141: getfield 98	android/util/DisplayMetrics:widthPixels	I
    //   144: invokespecial 93	java/lang/Integer:<init>	(I)V
    //   147: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: invokestatic 104	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   154: astore_0
    //   155: aload_0
    //   156: ifnull +25 -> 181
    //   159: aload_1
    //   160: ldc 106
    //   162: aload_0
    //   163: invokevirtual 110	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   166: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload_1
    //   171: ldc 112
    //   173: aload_0
    //   174: invokevirtual 115	java/util/Locale:getCountry	()Ljava/lang/String;
    //   177: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   180: pop
    //   181: new 15	org/json/JSONObject
    //   184: dup
    //   185: invokespecial 16	org/json/JSONObject:<init>	()V
    //   188: astore_0
    //   189: aload_0
    //   190: ldc 117
    //   192: ldc 119
    //   194: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   197: pop
    //   198: aload_0
    //   199: ldc 121
    //   201: ldc 123
    //   203: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   206: pop
    //   207: aload_0
    //   208: ldc 125
    //   210: getstatic 128	com/millennialmedia/android/MMSDK:macId	Ljava/lang/String;
    //   213: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   216: pop
    //   217: new 130	org/json/JSONArray
    //   220: dup
    //   221: invokespecial 131	org/json/JSONArray:<init>	()V
    //   224: astore_2
    //   225: aload_2
    //   226: aload_0
    //   227: invokevirtual 134	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   230: pop
    //   231: aload_1
    //   232: ldc -120
    //   234: aload_2
    //   235: invokevirtual 24	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   238: pop
    //   239: aload_1
    //   240: areturn
    //   241: astore_0
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aload_1
    //   246: areturn
    //   247: astore_0
    //   248: aload_1
    //   249: areturn
    //   250: astore_0
    //   251: aload_1
    //   252: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramContext	Context
    //   7	245	1	localJSONObject	JSONObject
    //   224	11	2	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   0	8	241	org/json/JSONException
    //   8	62	244	org/json/JSONException
    //   62	78	244	org/json/JSONException
    //   78	155	244	org/json/JSONException
    //   159	181	244	org/json/JSONException
    //   181	189	244	org/json/JSONException
    //   189	225	247	org/json/JSONException
    //   225	239	250	org/json/JSONException
  }
  
  public MMJSResponse call(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    Object localObject = (String)paramHashMap.get("number");
    if ((localContext != null) && (localObject != null))
    {
      MMSDK.Log.d("Dialing Phone: %s", new Object[] { localObject });
      if ((Boolean.parseBoolean((String)paramHashMap.get("dial"))) && (localContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)) {}
      for (localObject = new Intent("android.intent.action.CALL", Uri.parse("tel:" + (String)localObject));; localObject = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + (String)localObject)))
      {
        Utils.IntentUtils.startActivity(localContext, (Intent)localObject);
        MMSDK.Event.intentStarted(localContext, "tel", getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
        return MMJSResponse.responseWithSuccess();
      }
    }
    return null;
  }
  
  public MMJSResponse composeEmail(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    String str1 = (String)paramHashMap.get("recipient");
    String str2 = (String)paramHashMap.get("subject");
    String str3 = (String)paramHashMap.get("message");
    if (localContext != null)
    {
      MMSDK.Log.d("Creating email");
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      if (str1 != null) {
        localIntent.putExtra("android.intent.extra.EMAIL", str1.split(","));
      }
      if (str2 != null) {
        localIntent.putExtra("android.intent.extra.SUBJECT", str2);
      }
      if (str3 != null) {
        localIntent.putExtra("android.intent.extra.TEXT", str3);
      }
      Utils.IntentUtils.startActivity(localContext, localIntent);
      MMSDK.Event.intentStarted(localContext, "email", getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
  
  public MMJSResponse composeSms(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    Object localObject = (String)paramHashMap.get("number");
    String str = (String)paramHashMap.get("message");
    if ((localContext != null) && (localObject != null))
    {
      MMSDK.Log.d("Creating sms: %s", new Object[] { localObject });
      localObject = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + (String)localObject));
      if (str != null) {
        ((Intent)localObject).putExtra("sms_body", str);
      }
      Utils.IntentUtils.startActivity(localContext, (Intent)localObject);
      MMSDK.Event.intentStarted(localContext, "sms", getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
      return MMJSResponse.responseWithSuccess("SMS Sent");
    }
    return null;
  }
  
  public MMJSResponse enableHardwareAcceleration(HashMap<String, String> paramHashMap)
  {
    MMSDK.Log.d("hardware accel call" + paramHashMap);
    paramHashMap = (String)paramHashMap.get("enabled");
    MMWebView localMMWebView = (MMWebView)this.mmWebViewRef.get();
    if ((localMMWebView != null) && (localMMWebView != null))
    {
      if (Boolean.parseBoolean(paramHashMap)) {
        localMMWebView.enableHardwareAcceleration();
      }
      for (;;)
      {
        return MMJSResponse.responseWithSuccess();
        localMMWebView.disableAllAcceleration();
      }
    }
    return null;
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
  
  public MMJSResponse getInfo(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (Context)this.contextRef.get();
    if (paramHashMap != null)
    {
      MMJSResponse localMMJSResponse = new MMJSResponse();
      localMMJSResponse.result = 1;
      localMMJSResponse.response = getDeviceInfo(paramHashMap);
      return localMMJSResponse;
    }
    return null;
  }
  
  public MMJSResponse getLocation(HashMap<String, String> paramHashMap)
  {
    if (MMRequest.location != null) {
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
        paramHashMap.put("lat", Double.toString(MMRequest.location.getLatitude()));
        paramHashMap.put("long", Double.toString(MMRequest.location.getLongitude()));
        if (MMRequest.location.hasAccuracy())
        {
          paramHashMap.put("ha", Float.toString(MMRequest.location.getAccuracy()));
          paramHashMap.put("va", Float.toString(MMRequest.location.getAccuracy()));
        }
        if (MMRequest.location.hasSpeed()) {
          paramHashMap.put("spd", Float.toString(MMRequest.location.getSpeed()));
        }
        if (MMRequest.location.hasBearing()) {
          paramHashMap.put("brg", Float.toString(MMRequest.location.getBearing()));
        }
        if (MMRequest.location.hasAltitude()) {
          paramHashMap.put("alt", Double.toString(MMRequest.location.getAltitude()));
        }
        paramHashMap.put("tslr", Long.toString(MMRequest.location.getTime()));
      }
      catch (JSONException localJSONException) {}
    }
    localMMJSResponse = new MMJSResponse();
    localMMJSResponse.result = 1;
    localMMJSResponse.response = paramHashMap;
    return localMMJSResponse;
    return MMJSResponse.responseWithError("location object has not been set");
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
    Context localContext = (Context)this.contextRef.get();
    String str1 = (String)paramHashMap.get("appId");
    String str2 = (String)paramHashMap.get("referrer");
    if ((localContext != null) && (str1 != null))
    {
      MMSDK.Log.d("Opening marketplace: %s", new Object[] { str1 });
      Intent localIntent = new Intent("android.intent.action.VIEW");
      if (str2 != null) {
        localIntent.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[] { str1, URLEncoder.encode(str2) })));
      }
      for (;;)
      {
        MMSDK.Event.intentStarted(localContext, "market", getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
        Utils.IntentUtils.startActivity(localContext, localIntent);
        return MMJSResponse.responseWithSuccess();
        localIntent.setData(Uri.parse("market://details?id=" + str1));
      }
    }
    return null;
  }
  
  public MMJSResponse openUrl(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    Object localObject = (String)paramHashMap.get("url");
    if ((localContext != null) && (localObject != null))
    {
      MMSDK.Log.d("Opening: %s", new Object[] { localObject });
      localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      if ((((Intent)localObject).getScheme().startsWith("http")) || (((Intent)localObject).getScheme().startsWith("https"))) {
        MMSDK.Event.intentStarted(localContext, "browser", getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
      }
      Utils.IntentUtils.startActivity(localContext, (Intent)localObject);
      return MMJSResponse.responseWithSuccess("Overlay opened");
    }
    return MMJSResponse.responseWithError("URL could not be opened");
  }
  
  public MMJSResponse setMMDID(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("mmdid");
    Context localContext = (Context)this.contextRef.get();
    if (localContext != null)
    {
      HandShake.sharedHandShake(localContext).setMMdid(localContext, paramHashMap);
      return MMJSResponse.responseWithSuccess("MMDID is set");
    }
    return null;
  }
  
  public MMJSResponse showMap(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    String str = (String)paramHashMap.get("location");
    if ((localContext != null) && (str != null))
    {
      MMSDK.Log.d("Launching Google Maps: %s", new Object[] { str });
      Utils.IntentUtils.startActivity(localContext, new Intent("android.intent.action.VIEW", Uri.parse("geo:" + str)));
      MMSDK.Event.intentStarted(localContext, "geo", getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
      return MMJSResponse.responseWithSuccess("Map successfully opened");
    }
    return null;
  }
  
  public MMJSResponse tweet(HashMap<String, String> paramHashMap)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/BridgeMMDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */