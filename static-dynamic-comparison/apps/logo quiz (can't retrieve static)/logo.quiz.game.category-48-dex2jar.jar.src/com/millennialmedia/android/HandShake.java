package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.WindowManager.BadTokenException;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.millennialmedia.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HandShake
{
  static final String BASE_URL = "http://androidsdk.ads.mp.mydas.mobi/";
  static final String BASE_URL_PATH = "getAd.php5?";
  private static final String HANDSHAKE_FALLBACK_URL = "http://ads.mp.mydas.mobi/appConfigServlet?apid=";
  private static final String HANDSHAKE_HTTPS_SCHEME = "https://";
  private static final String HANDSHAKE_HTTP_SCHEME = "http://";
  private static final String HANDSHAKE_URL_HOST = "ads.mp.mydas.mobi/";
  private static final String HANDSHAKE_URL_OVERRIDE_PARMS = "?apid=";
  private static final String HANDSHAKE_URL_PARMS = "appConfigServlet?apid=";
  private static final String KEY_CACHED_VIDEOS = "handshake_cachedvideos5.0";
  private static String adUrl = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
  static String apid = "28913";
  private static boolean forceRefresh;
  private static String handShakeURL = "https://ads.mp.mydas.mobi/appConfigServlet?apid=";
  private static HandShake sharedInstance;
  long adRefreshSecs;
  private LinkedHashMap<String, AdTypeHandShake> adTypeHandShakes = new LinkedHashMap();
  private WeakReference<Context> appContextRef;
  DTOCachedVideo[] cachedVideos;
  private WeakReference<Context> contextRef;
  long creativeCacheTimeout = 259200000L;
  private long deferredViewTimeout = 3600000L;
  String endSessionURL;
  private long handShakeCallback = 86400000L;
  private final Handler handler = new Handler(Looper.getMainLooper());
  boolean hardwareAccelerationEnabled;
  boolean kill = false;
  private long lastHandShake;
  String mmdid;
  String mmjsUrl;
  private String noVideosToCacheURL;
  NuanceCredentials nuanceCredentials;
  private ArrayList<Scheme> schemes = new ArrayList();
  private String schemesList;
  String startSessionURL;
  private Runnable updateHandShakeRunnable = new Runnable()
  {
    public void run()
    {
      Context localContext2 = (Context)HandShake.this.contextRef.get();
      Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = (Context)HandShake.this.appContextRef.get();
      }
      if (localContext1 != null) {
        HandShake.sharedHandShake(localContext1);
      }
    }
  };
  
  private HandShake() {}
  
  private HandShake(Context paramContext)
  {
    this.contextRef = new WeakReference(paramContext);
    this.appContextRef = new WeakReference(paramContext.getApplicationContext());
    if ((forceRefresh) || (!loadHandShake(paramContext)) || (System.currentTimeMillis() - this.lastHandShake > this.handShakeCallback))
    {
      forceRefresh = false;
      this.lastHandShake = System.currentTimeMillis();
      requestHandshake(false);
    }
  }
  
  private void deserializeFromObj(JSONObject paramJSONObject)
  {
    final Context localContext = (Context)this.contextRef.get();
    if (paramJSONObject == null) {
      return;
    }
    int i;
    Object localObject3;
    final Object localObject2;
    try
    {
      localObject1 = paramJSONObject.optJSONArray("errors");
      if (localObject1 != null)
      {
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 == null) {
            break label575;
          }
          localObject2 = ((JSONObject)localObject3).optString("message", null);
          localObject3 = ((JSONObject)localObject3).optString("type", null);
          if ((localObject2 == null) || (localObject3 == null)) {
            break label575;
          }
          if (((String)localObject3).equalsIgnoreCase("log")) {
            MMSDK.Log.e((String)localObject2);
          } else if (((String)localObject3).equalsIgnoreCase("prompt")) {
            this.handler.post(new Runnable()
            {
              public void run()
              {
                try
                {
                  Toast.makeText(localContext, "Error: " + localObject2, 1).show();
                  return;
                }
                catch (WindowManager.BadTokenException localBadTokenException)
                {
                  localBadTokenException.printStackTrace();
                }
              }
            });
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    Object localObject1 = paramJSONObject.optJSONObject("adtypes");
    if (localObject1 != null)
    {
      localObject2 = MMAdImpl.getAdTypes();
      i = 0;
      label161:
      if (i < localObject2.length)
      {
        localObject3 = ((JSONObject)localObject1).optJSONObject(localObject2[i]);
        if (localObject3 == null) {
          break label582;
        }
        AdTypeHandShake localAdTypeHandShake = new AdTypeHandShake();
        localAdTypeHandShake.deserializeFromObj((JSONObject)localObject3);
        localAdTypeHandShake.loadLastVideo(localContext, localObject2[i]);
        this.adTypeHandShakes.put(localObject2[i], localAdTypeHandShake);
        break label582;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.optJSONArray("schemes");
        if (localObject1 != null)
        {
          if ((this.schemes == null) || (this.schemes.size() <= 0)) {
            break label589;
          }
          this.schemes.removeAll(this.schemes);
          break label589;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 == null) {
              break label594;
            }
            localObject3 = new Scheme();
            ((Scheme)localObject3).deserializeFromObj((JSONObject)localObject2);
            this.schemes.add(localObject3);
            break label594;
          }
        }
        this.adRefreshSecs = paramJSONObject.optLong("adrefresh", 0L);
        this.deferredViewTimeout = (paramJSONObject.optLong("deferredviewtimeout", 3600L) * 1000L);
        this.kill = paramJSONObject.optBoolean("kill");
        setAdUrl(localContext, paramJSONObject.optString("baseURL"));
        this.handShakeCallback = (paramJSONObject.optLong("handshakecallback", 86400L) * 1000L);
        this.creativeCacheTimeout = (paramJSONObject.optLong("creativeCacheTimeout", 259200L) * 1000L);
        this.hardwareAccelerationEnabled = paramJSONObject.optBoolean("hardwareAccelerationEnabled");
        this.startSessionURL = paramJSONObject.optString("startSessionURL");
        this.endSessionURL = paramJSONObject.optString("endSessionURL");
        localObject1 = paramJSONObject.optString("nuanceCredentials");
        this.nuanceCredentials = ((NuanceCredentials)new Gson().fromJson((String)localObject1, NuanceCredentials.class));
        this.mmjsUrl = paramJSONObject.optString("mmjs");
        handleCachedVideos(paramJSONObject, localContext);
        if ((!TextUtils.isEmpty(this.mmjsUrl)) && (!MRaid.isMRaidUpdated(localContext, this.mmjsUrl)))
        {
          MRaid.downloadMraidJs((Context)this.appContextRef.get(), this.mmjsUrl);
          return;
        }
      }
      finally {}
      MMSDK.Log.w("Not downloading MMJS - (" + this.mmjsUrl + ")");
      return;
      label575:
      i += 1;
      break;
      label582:
      i += 1;
      break label161;
      label589:
      i = 0;
      continue;
      label594:
      i += 1;
    }
  }
  
  static String getAdUrl()
  {
    if ((!TextUtils.isEmpty(adUrl)) && (URLUtil.isHttpUrl(adUrl.replace("getAd.php5?", "")))) {
      return adUrl;
    }
    return "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
  }
  
  private void handleCachedVideos(JSONObject paramJSONObject, Context paramContext)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("cachedVideos");
    if (localJSONArray != null)
    {
      this.cachedVideos = ((DTOCachedVideo[])new Gson().fromJson(localJSONArray.toString(), DTOCachedVideo[].class));
      MMSDK.Log.d(this.cachedVideos.toString());
    }
    this.noVideosToCacheURL = paramJSONObject.optString("noVideosToCacheURL");
    if (this.cachedVideos != null) {
      PreCacheWorker.preCacheVideos(this.cachedVideos, paramContext, this.noVideosToCacheURL);
    }
  }
  
  private boolean isFirstLaunch(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return paramContext.getSharedPreferences("MillennialMediaSettings", 0).getBoolean("firstlaunchHandshake", true);
  }
  
  private boolean loadHandShake(Context paramContext)
  {
    boolean bool1 = false;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
    if (localSharedPreferences == null) {
      return false;
    }
    if (localSharedPreferences.contains("handshake_deferredviewtimeout"))
    {
      this.deferredViewTimeout = localSharedPreferences.getLong("handshake_deferredviewtimeout", this.deferredViewTimeout);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_baseUrl"))
    {
      adUrl = localSharedPreferences.getString("handshake_baseUrl", adUrl);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_callback"))
    {
      this.handShakeCallback = localSharedPreferences.getLong("handshake_callback", this.handShakeCallback);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_hardwareAccelerationEnabled"))
    {
      this.hardwareAccelerationEnabled = localSharedPreferences.getBoolean("handshake_hardwareAccelerationEnabled", false);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_startSessionURL"))
    {
      this.startSessionURL = localSharedPreferences.getString("handshake_startSessionURL", "");
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_endSessionURL"))
    {
      this.endSessionURL = localSharedPreferences.getString("handshake_endSessionURL", "");
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_nuanceCredentials"))
    {
      localObject1 = localSharedPreferences.getString("handshake_nuanceCredentials", "");
      this.nuanceCredentials = ((NuanceCredentials)new Gson().fromJson((String)localObject1, NuanceCredentials.class));
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_mmdid"))
    {
      setMMdid(paramContext, localSharedPreferences.getString("handshake_mmdid", this.mmdid), false);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_creativecachetimeout"))
    {
      this.creativeCacheTimeout = localSharedPreferences.getLong("handshake_creativecachetimeout", this.creativeCacheTimeout);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_mmjs"))
    {
      this.mmjsUrl = localSharedPreferences.getString("handshake_mmjs", this.mmjsUrl);
      bool1 = true;
    }
    Object localObject1 = MMAdImpl.getAdTypes();
    int i = 0;
    Object localObject2;
    while (i < localObject1.length)
    {
      localObject2 = new AdTypeHandShake();
      if (((AdTypeHandShake)localObject2).load(localSharedPreferences, localObject1[i]))
      {
        bool1 = true;
        this.adTypeHandShakes.put(localObject1[i], localObject2);
      }
      i += 1;
    }
    boolean bool2 = bool1;
    for (;;)
    {
      try
      {
        if (localSharedPreferences.contains("handshake_schemes"))
        {
          localObject1 = localSharedPreferences.getString("handshake_schemes", "");
          bool2 = bool1;
          if (((String)localObject1).length() > 0)
          {
            localObject1 = ((String)localObject1).split("\n");
            int j = localObject1.length;
            i = 0;
            if (i >= j) {
              break label750;
            }
            localObject2 = localObject1[i].split("\t");
            if (localObject2.length < 2) {
              break label743;
            }
            localObject2 = new Scheme(localObject2[0], Integer.parseInt(localObject2[1]));
            this.schemes.add(localObject2);
            break label743;
          }
        }
        if (localSharedPreferences.contains("handshake_cachedvideos5.0"))
        {
          localObject1 = localSharedPreferences.getString("handshake_cachedvideos5.0", "");
          if (((String)localObject1).length() > 0) {
            this.cachedVideos = ((DTOCachedVideo[])new Gson().fromJson((String)localObject1, DTOCachedVideo[].class));
          }
        }
        if (localSharedPreferences.contains("handshake_lasthandshake"))
        {
          this.lastHandShake = localSharedPreferences.getLong("handshake_lasthandshake", this.lastHandShake);
          bool2 = true;
        }
        if (bool2)
        {
          MMSDK.Log.d("Handshake successfully loaded from shared preferences.");
          if (System.currentTimeMillis() - this.lastHandShake < this.handShakeCallback) {
            this.handler.postDelayed(this.updateHandShakeRunnable, this.handShakeCallback - (System.currentTimeMillis() - this.lastHandShake));
          }
          this.noVideosToCacheURL = localSharedPreferences.getString("handshake_novideostocacheurl", "");
          if (this.cachedVideos != null) {
            PreCacheWorker.preCacheVideos(this.cachedVideos, paramContext, this.noVideosToCacheURL);
          }
        }
        return bool2;
      }
      finally {}
      label743:
      i += 1;
      continue;
      label750:
      bool2 = true;
    }
  }
  
  private JSONObject parseJson(String paramString)
  {
    MMSDK.Log.d("JSON String: %s", new Object[] { paramString });
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString);
        MMSDK.Log.v(paramString.toString());
        if (paramString.has("mmishake"))
        {
          paramString = paramString.getJSONObject("mmishake");
          return paramString;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private void requestHandshake(final boolean paramBoolean)
  {
    Utils.ThreadUtils.execute(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   4: invokestatic 34	com/millennialmedia/android/HandShake:access$000	(Lcom/millennialmedia/android/HandShake;)Ljava/lang/ref/WeakReference;
        //   7: invokevirtual 40	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   10: checkcast 42	android/content/Context
        //   13: astore 8
        //   15: aload 8
        //   17: astore 10
        //   19: aload 8
        //   21: ifnonnull +18 -> 39
        //   24: aload_0
        //   25: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   28: invokestatic 45	com/millennialmedia/android/HandShake:access$100	(Lcom/millennialmedia/android/HandShake;)Ljava/lang/ref/WeakReference;
        //   31: invokevirtual 40	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   34: checkcast 42	android/content/Context
        //   37: astore 10
        //   39: aload 10
        //   41: ifnonnull +4 -> 45
        //   44: return
        //   45: iconst_0
        //   46: istore 6
        //   48: iconst_0
        //   49: istore 7
        //   51: iconst_0
        //   52: istore_3
        //   53: iload_3
        //   54: istore 4
        //   56: iload 6
        //   58: istore 5
        //   60: iload 7
        //   62: istore_2
        //   63: new 47	java/lang/StringBuilder
        //   66: dup
        //   67: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   70: astore 11
        //   72: iload_3
        //   73: istore 4
        //   75: iload 6
        //   77: istore 5
        //   79: iload 7
        //   81: istore_2
        //   82: new 50	java/util/TreeMap
        //   85: dup
        //   86: invokespecial 51	java/util/TreeMap:<init>	()V
        //   89: astore 8
        //   91: iload_3
        //   92: istore 4
        //   94: iload 6
        //   96: istore 5
        //   98: iload 7
        //   100: istore_2
        //   101: aload 8
        //   103: ldc 53
        //   105: new 47	java/lang/StringBuilder
        //   108: dup
        //   109: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   112: ldc 55
        //   114: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   117: getstatic 65	android/os/Build:MODEL	Ljava/lang/String;
        //   120: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   126: invokeinterface 75 3 0
        //   131: pop
        //   132: iload_3
        //   133: istore 4
        //   135: iload 6
        //   137: istore 5
        //   139: iload 7
        //   141: istore_2
        //   142: aload_0
        //   143: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   146: aload 10
        //   148: invokestatic 79	com/millennialmedia/android/HandShake:access$200	(Lcom/millennialmedia/android/HandShake;Landroid/content/Context;)Z
        //   151: istore_3
        //   152: iload_3
        //   153: ifeq +23 -> 176
        //   156: iload_3
        //   157: istore 4
        //   159: iload_3
        //   160: istore 5
        //   162: iload_3
        //   163: istore_2
        //   164: aload 8
        //   166: ldc 81
        //   168: ldc 83
        //   170: invokeinterface 75 3 0
        //   175: pop
        //   176: iload_3
        //   177: istore 4
        //   179: iload_3
        //   180: istore 5
        //   182: iload_3
        //   183: istore_2
        //   184: aload_0
        //   185: getfield 21	com/millennialmedia/android/HandShake$1:val$isInitialize	Z
        //   188: ifeq +23 -> 211
        //   191: iload_3
        //   192: istore 4
        //   194: iload_3
        //   195: istore 5
        //   197: iload_3
        //   198: istore_2
        //   199: aload 8
        //   201: ldc 85
        //   203: ldc 83
        //   205: invokeinterface 75 3 0
        //   210: pop
        //   211: iload_3
        //   212: istore 4
        //   214: iload_3
        //   215: istore 5
        //   217: iload_3
        //   218: istore_2
        //   219: aload 10
        //   221: aload 8
        //   223: invokestatic 91	com/millennialmedia/android/MMSDK:insertUrlCommonValues	(Landroid/content/Context;Ljava/util/Map;)V
        //   226: iload_3
        //   227: istore 4
        //   229: iload_3
        //   230: istore 5
        //   232: iload_3
        //   233: istore_2
        //   234: aload 8
        //   236: invokeinterface 95 1 0
        //   241: invokeinterface 101 1 0
        //   246: astore 8
        //   248: iload_3
        //   249: istore 4
        //   251: iload_3
        //   252: istore 5
        //   254: iload_3
        //   255: istore_2
        //   256: aload 8
        //   258: invokeinterface 107 1 0
        //   263: ifeq +113 -> 376
        //   266: iload_3
        //   267: istore 4
        //   269: iload_3
        //   270: istore 5
        //   272: iload_3
        //   273: istore_2
        //   274: aload 8
        //   276: invokeinterface 110 1 0
        //   281: checkcast 112	java/util/Map$Entry
        //   284: astore 9
        //   286: iload_3
        //   287: istore 4
        //   289: iload_3
        //   290: istore 5
        //   292: iload_3
        //   293: istore_2
        //   294: aload 11
        //   296: ldc 114
        //   298: iconst_2
        //   299: anewarray 4	java/lang/Object
        //   302: dup
        //   303: iconst_0
        //   304: aload 9
        //   306: invokeinterface 117 1 0
        //   311: aastore
        //   312: dup
        //   313: iconst_1
        //   314: aload 9
        //   316: invokeinterface 120 1 0
        //   321: checkcast 122	java/lang/String
        //   324: ldc 124
        //   326: invokestatic 130	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   329: aastore
        //   330: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   333: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   336: pop
        //   337: goto -89 -> 248
        //   340: astore 8
        //   342: iload 4
        //   344: istore_2
        //   345: ldc -120
        //   347: iconst_1
        //   348: anewarray 4	java/lang/Object
        //   351: dup
        //   352: iconst_0
        //   353: aload 8
        //   355: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
        //   358: aastore
        //   359: invokestatic 145	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   362: iconst_0
        //   363: ifeq -319 -> 44
        //   366: aload_0
        //   367: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   370: aload 10
        //   372: invokestatic 149	com/millennialmedia/android/HandShake:access$1000	(Lcom/millennialmedia/android/HandShake;Landroid/content/Context;)V
        //   375: return
        //   376: iload_3
        //   377: istore 4
        //   379: iload_3
        //   380: istore 5
        //   382: iload_3
        //   383: istore_2
        //   384: new 47	java/lang/StringBuilder
        //   387: dup
        //   388: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   391: invokestatic 152	com/millennialmedia/android/HandShake:access$300	()Ljava/lang/String;
        //   394: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   397: getstatic 155	com/millennialmedia/android/HandShake:apid	Ljava/lang/String;
        //   400: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   403: aload 11
        //   405: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   408: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   411: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   414: astore 8
        //   416: iload_3
        //   417: istore 4
        //   419: iload_3
        //   420: istore 5
        //   422: iload_3
        //   423: istore_2
        //   424: ldc -99
        //   426: iconst_1
        //   427: anewarray 4	java/lang/Object
        //   430: dup
        //   431: iconst_0
        //   432: aload 8
        //   434: aastore
        //   435: invokestatic 160	com/millennialmedia/android/MMSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   438: aconst_null
        //   439: astore 9
        //   441: iload_3
        //   442: istore 5
        //   444: iload_3
        //   445: istore_2
        //   446: new 162	com/millennialmedia/android/HttpGetRequest
        //   449: dup
        //   450: sipush 3000
        //   453: invokespecial 165	com/millennialmedia/android/HttpGetRequest:<init>	(I)V
        //   456: aload 8
        //   458: invokevirtual 168	com/millennialmedia/android/HttpGetRequest:get	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
        //   461: astore 8
        //   463: aload 8
        //   465: astore 9
        //   467: aload 9
        //   469: ifnull +35 -> 504
        //   472: iload_3
        //   473: istore 4
        //   475: iload_3
        //   476: istore 5
        //   478: iload_3
        //   479: istore_2
        //   480: aload 9
        //   482: invokeinterface 174 1 0
        //   487: invokeinterface 180 1 0
        //   492: istore_1
        //   493: aload 9
        //   495: astore 8
        //   497: iload_1
        //   498: sipush 200
        //   501: if_icmpeq +97 -> 598
        //   504: iload_3
        //   505: istore 5
        //   507: iload_3
        //   508: istore_2
        //   509: invokestatic 152	com/millennialmedia/android/HandShake:access$300	()Ljava/lang/String;
        //   512: ldc -74
        //   514: ldc -72
        //   516: invokevirtual 187	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   519: invokestatic 191	com/millennialmedia/android/HandShake:access$302	(Ljava/lang/String;)Ljava/lang/String;
        //   522: pop
        //   523: iload_3
        //   524: istore 5
        //   526: iload_3
        //   527: istore_2
        //   528: new 47	java/lang/StringBuilder
        //   531: dup
        //   532: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   535: invokestatic 152	com/millennialmedia/android/HandShake:access$300	()Ljava/lang/String;
        //   538: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   541: getstatic 155	com/millennialmedia/android/HandShake:apid	Ljava/lang/String;
        //   544: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   547: aload 11
        //   549: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   552: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   555: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   558: astore 8
        //   560: iload_3
        //   561: istore 5
        //   563: iload_3
        //   564: istore_2
        //   565: ldc -63
        //   567: iconst_1
        //   568: anewarray 4	java/lang/Object
        //   571: dup
        //   572: iconst_0
        //   573: aload 8
        //   575: aastore
        //   576: invokestatic 160	com/millennialmedia/android/MMSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   579: iload_3
        //   580: istore 5
        //   582: iload_3
        //   583: istore_2
        //   584: new 162	com/millennialmedia/android/HttpGetRequest
        //   587: dup
        //   588: invokespecial 194	com/millennialmedia/android/HttpGetRequest:<init>	()V
        //   591: aload 8
        //   593: invokevirtual 168	com/millennialmedia/android/HttpGetRequest:get	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
        //   596: astore 8
        //   598: aload 8
        //   600: ifnull +35 -> 635
        //   603: iload_3
        //   604: istore 4
        //   606: iload_3
        //   607: istore 5
        //   609: iload_3
        //   610: istore_2
        //   611: aload 8
        //   613: invokeinterface 174 1 0
        //   618: invokeinterface 180 1 0
        //   623: istore_1
        //   624: aload 8
        //   626: astore 9
        //   628: iload_1
        //   629: sipush 200
        //   632: if_icmpeq +77 -> 709
        //   635: iload_3
        //   636: istore 5
        //   638: iload_3
        //   639: istore_2
        //   640: new 47	java/lang/StringBuilder
        //   643: dup
        //   644: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   647: ldc -60
        //   649: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   652: getstatic 155	com/millennialmedia/android/HandShake:apid	Ljava/lang/String;
        //   655: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   658: aload 11
        //   660: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   663: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   666: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   669: astore 9
        //   671: iload_3
        //   672: istore 5
        //   674: iload_3
        //   675: istore_2
        //   676: ldc -58
        //   678: iconst_1
        //   679: anewarray 4	java/lang/Object
        //   682: dup
        //   683: iconst_0
        //   684: aload 9
        //   686: aastore
        //   687: invokestatic 160	com/millennialmedia/android/MMSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   690: iload_3
        //   691: istore 5
        //   693: iload_3
        //   694: istore_2
        //   695: new 162	com/millennialmedia/android/HttpGetRequest
        //   698: dup
        //   699: invokespecial 194	com/millennialmedia/android/HttpGetRequest:<init>	()V
        //   702: aload 9
        //   704: invokevirtual 168	com/millennialmedia/android/HttpGetRequest:get	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
        //   707: astore 9
        //   709: aload 9
        //   711: ifnull +295 -> 1006
        //   714: iload_3
        //   715: istore 4
        //   717: iload_3
        //   718: istore 5
        //   720: iload_3
        //   721: istore_2
        //   722: aload 9
        //   724: invokeinterface 174 1 0
        //   729: invokeinterface 180 1 0
        //   734: sipush 200
        //   737: if_icmpne +269 -> 1006
        //   740: iload_3
        //   741: istore 4
        //   743: iload_3
        //   744: istore 5
        //   746: iload_3
        //   747: istore_2
        //   748: aload_0
        //   749: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   752: aload_0
        //   753: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   756: aload 9
        //   758: invokeinterface 202 1 0
        //   763: invokeinterface 208 1 0
        //   768: invokestatic 212	com/millennialmedia/android/HttpGetRequest:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
        //   771: invokestatic 216	com/millennialmedia/android/HandShake:access$400	(Lcom/millennialmedia/android/HandShake;Ljava/lang/String;)Lorg/json/JSONObject;
        //   774: invokestatic 220	com/millennialmedia/android/HandShake:access$500	(Lcom/millennialmedia/android/HandShake;Lorg/json/JSONObject;)V
        //   777: iload_3
        //   778: istore 4
        //   780: iload_3
        //   781: istore 5
        //   783: iload_3
        //   784: istore_2
        //   785: aload_0
        //   786: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   789: aload 10
        //   791: invokestatic 223	com/millennialmedia/android/HandShake:access$600	(Lcom/millennialmedia/android/HandShake;Landroid/content/Context;)V
        //   794: iload_3
        //   795: istore 4
        //   797: iload_3
        //   798: istore 5
        //   800: iload_3
        //   801: istore_2
        //   802: aload_0
        //   803: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   806: invokestatic 227	com/millennialmedia/android/HandShake:access$900	(Lcom/millennialmedia/android/HandShake;)Landroid/os/Handler;
        //   809: aload_0
        //   810: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   813: invokestatic 231	com/millennialmedia/android/HandShake:access$700	(Lcom/millennialmedia/android/HandShake;)Ljava/lang/Runnable;
        //   816: aload_0
        //   817: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   820: invokestatic 235	com/millennialmedia/android/HandShake:access$800	(Lcom/millennialmedia/android/HandShake;)J
        //   823: invokevirtual 241	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
        //   826: pop
        //   827: iload_3
        //   828: istore 4
        //   830: iload_3
        //   831: istore 5
        //   833: iload_3
        //   834: istore_2
        //   835: ldc -13
        //   837: invokestatic 246	com/millennialmedia/android/MMSDK$Log:v	(Ljava/lang/String;)V
        //   840: iload_3
        //   841: ifeq -797 -> 44
        //   844: aload_0
        //   845: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   848: aload 10
        //   850: invokestatic 149	com/millennialmedia/android/HandShake:access$1000	(Lcom/millennialmedia/android/HandShake;Landroid/content/Context;)V
        //   853: return
        //   854: astore 8
        //   856: iload_3
        //   857: istore 4
        //   859: iload_3
        //   860: istore 5
        //   862: iload_3
        //   863: istore_2
        //   864: ldc -120
        //   866: iconst_1
        //   867: anewarray 4	java/lang/Object
        //   870: dup
        //   871: iconst_0
        //   872: aload 8
        //   874: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
        //   877: aastore
        //   878: invokestatic 145	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   881: goto -414 -> 467
        //   884: astore 8
        //   886: iload 5
        //   888: istore_2
        //   889: ldc -120
        //   891: iconst_1
        //   892: anewarray 4	java/lang/Object
        //   895: dup
        //   896: iconst_0
        //   897: aload 8
        //   899: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   902: aastore
        //   903: invokestatic 145	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   906: iconst_0
        //   907: ifeq -863 -> 44
        //   910: aload_0
        //   911: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   914: aload 10
        //   916: invokestatic 149	com/millennialmedia/android/HandShake:access$1000	(Lcom/millennialmedia/android/HandShake;Landroid/content/Context;)V
        //   919: return
        //   920: astore 8
        //   922: iload_3
        //   923: istore 4
        //   925: iload_3
        //   926: istore 5
        //   928: iload_3
        //   929: istore_2
        //   930: ldc -120
        //   932: iconst_1
        //   933: anewarray 4	java/lang/Object
        //   936: dup
        //   937: iconst_0
        //   938: aload 8
        //   940: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
        //   943: aastore
        //   944: invokestatic 145	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   947: aload 9
        //   949: astore 8
        //   951: goto -353 -> 598
        //   954: astore 8
        //   956: iload_2
        //   957: ifeq +12 -> 969
        //   960: aload_0
        //   961: getfield 19	com/millennialmedia/android/HandShake$1:this$0	Lcom/millennialmedia/android/HandShake;
        //   964: aload 10
        //   966: invokestatic 149	com/millennialmedia/android/HandShake:access$1000	(Lcom/millennialmedia/android/HandShake;Landroid/content/Context;)V
        //   969: aload 8
        //   971: athrow
        //   972: astore 9
        //   974: iload_3
        //   975: istore 4
        //   977: iload_3
        //   978: istore 5
        //   980: iload_3
        //   981: istore_2
        //   982: ldc -120
        //   984: iconst_1
        //   985: anewarray 4	java/lang/Object
        //   988: dup
        //   989: iconst_0
        //   990: aload 9
        //   992: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
        //   995: aastore
        //   996: invokestatic 145	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   999: aload 8
        //   1001: astore 9
        //   1003: goto -294 -> 709
        //   1006: iconst_0
        //   1007: istore_3
        //   1008: goto -168 -> 840
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1011	0	this	1
        //   492	141	1	i	int
        //   62	920	2	j	int
        //   52	956	3	bool1	boolean
        //   54	922	4	bool2	boolean
        //   58	921	5	k	int
        //   46	90	6	m	int
        //   49	91	7	n	int
        //   13	262	8	localObject1	Object
        //   340	14	8	localIOException1	java.io.IOException
        //   414	211	8	localObject2	Object
        //   854	19	8	localIOException2	java.io.IOException
        //   884	14	8	localException	Exception
        //   920	19	8	localIOException3	java.io.IOException
        //   949	1	8	localObject3	Object
        //   954	46	8	localObject4	Object
        //   284	664	9	localObject5	Object
        //   972	19	9	localIOException4	java.io.IOException
        //   1001	1	9	localObject6	Object
        //   17	948	10	localObject7	Object
        //   70	589	11	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   63	72	340	java/io/IOException
        //   82	91	340	java/io/IOException
        //   101	132	340	java/io/IOException
        //   142	152	340	java/io/IOException
        //   164	176	340	java/io/IOException
        //   184	191	340	java/io/IOException
        //   199	211	340	java/io/IOException
        //   219	226	340	java/io/IOException
        //   234	248	340	java/io/IOException
        //   256	266	340	java/io/IOException
        //   274	286	340	java/io/IOException
        //   294	337	340	java/io/IOException
        //   384	416	340	java/io/IOException
        //   424	438	340	java/io/IOException
        //   480	493	340	java/io/IOException
        //   611	624	340	java/io/IOException
        //   722	740	340	java/io/IOException
        //   748	777	340	java/io/IOException
        //   785	794	340	java/io/IOException
        //   802	827	340	java/io/IOException
        //   835	840	340	java/io/IOException
        //   864	881	340	java/io/IOException
        //   930	947	340	java/io/IOException
        //   982	999	340	java/io/IOException
        //   446	463	854	java/io/IOException
        //   63	72	884	java/lang/Exception
        //   82	91	884	java/lang/Exception
        //   101	132	884	java/lang/Exception
        //   142	152	884	java/lang/Exception
        //   164	176	884	java/lang/Exception
        //   184	191	884	java/lang/Exception
        //   199	211	884	java/lang/Exception
        //   219	226	884	java/lang/Exception
        //   234	248	884	java/lang/Exception
        //   256	266	884	java/lang/Exception
        //   274	286	884	java/lang/Exception
        //   294	337	884	java/lang/Exception
        //   384	416	884	java/lang/Exception
        //   424	438	884	java/lang/Exception
        //   446	463	884	java/lang/Exception
        //   480	493	884	java/lang/Exception
        //   509	523	884	java/lang/Exception
        //   528	560	884	java/lang/Exception
        //   565	579	884	java/lang/Exception
        //   584	598	884	java/lang/Exception
        //   611	624	884	java/lang/Exception
        //   640	671	884	java/lang/Exception
        //   676	690	884	java/lang/Exception
        //   695	709	884	java/lang/Exception
        //   722	740	884	java/lang/Exception
        //   748	777	884	java/lang/Exception
        //   785	794	884	java/lang/Exception
        //   802	827	884	java/lang/Exception
        //   835	840	884	java/lang/Exception
        //   864	881	884	java/lang/Exception
        //   930	947	884	java/lang/Exception
        //   982	999	884	java/lang/Exception
        //   509	523	920	java/io/IOException
        //   528	560	920	java/io/IOException
        //   565	579	920	java/io/IOException
        //   584	598	920	java/io/IOException
        //   63	72	954	finally
        //   82	91	954	finally
        //   101	132	954	finally
        //   142	152	954	finally
        //   164	176	954	finally
        //   184	191	954	finally
        //   199	211	954	finally
        //   219	226	954	finally
        //   234	248	954	finally
        //   256	266	954	finally
        //   274	286	954	finally
        //   294	337	954	finally
        //   345	362	954	finally
        //   384	416	954	finally
        //   424	438	954	finally
        //   446	463	954	finally
        //   480	493	954	finally
        //   509	523	954	finally
        //   528	560	954	finally
        //   565	579	954	finally
        //   584	598	954	finally
        //   611	624	954	finally
        //   640	671	954	finally
        //   676	690	954	finally
        //   695	709	954	finally
        //   722	740	954	finally
        //   748	777	954	finally
        //   785	794	954	finally
        //   802	827	954	finally
        //   835	840	954	finally
        //   864	881	954	finally
        //   889	906	954	finally
        //   930	947	954	finally
        //   982	999	954	finally
        //   640	671	972	java/io/IOException
        //   676	690	972	java/io/IOException
        //   695	709	972	java/io/IOException
      }
    });
  }
  
  private void saveHandShake(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
    paramContext.putLong("handshake_deferredviewtimeout", this.deferredViewTimeout);
    paramContext.putBoolean("handshake_kill", this.kill);
    paramContext.putString("handshake_baseUrl", adUrl);
    paramContext.putLong("handshake_callback", this.handShakeCallback);
    paramContext.putBoolean("handshake_hardwareAccelerationEnabled", this.hardwareAccelerationEnabled);
    paramContext.putString("handshake_startSessionURL", this.startSessionURL);
    if (this.nuanceCredentials != null) {
      paramContext.putString("handshake_nuanceCredentials", new Gson().toJson(this.nuanceCredentials));
    }
    paramContext.putString("handshake_endSessionURL", this.endSessionURL);
    paramContext.putLong("handshake_creativecaetimeout", this.creativeCacheTimeout);
    paramContext.putString("handshake_mmjs", this.mmjsUrl);
    Object localObject1 = this.adTypeHandShakes.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((AdTypeHandShake)this.adTypeHandShakes.get(localObject2)).save(paramContext, (String)localObject2);
    }
    try
    {
      localObject1 = new StringBuilder();
      int i = 0;
      while (i < this.schemes.size())
      {
        localObject2 = (Scheme)this.schemes.get(i);
        if (i > 0) {
          ((StringBuilder)localObject1).append("\n");
        }
        ((StringBuilder)localObject1).append(((Scheme)localObject2).scheme + "\t" + ((Scheme)localObject2).id);
        i += 1;
      }
      paramContext.putString("handshake_schemes", ((StringBuilder)localObject1).toString());
      if (this.cachedVideos != null) {
        paramContext.putString("handshake_cachedvideos5.0", new Gson().toJson(this.cachedVideos));
      }
      paramContext.putString("handshake_novideostocacheurl", this.noVideosToCacheURL);
      paramContext.putLong("handshake_lasthandshake", this.lastHandShake);
      paramContext.commit();
      return;
    }
    finally {}
  }
  
  private void sentFirstLaunch(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
      paramContext.putBoolean("firstlaunchHandshake", false);
      paramContext.commit();
    }
  }
  
  static void setAdUrl(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.endsWith("/")) {
        adUrl = paramString + "/" + "getAd.php5?";
      }
    }
    else {
      return;
    }
    adUrl = paramString + "getAd.php5?";
  }
  
  static void setHandShakeURL(Context paramContext, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        String str = paramString;
        if (paramString.startsWith("http://")) {
          str = paramString.replaceFirst("http://", "https://");
        }
        handShakeURL = str + "?apid=";
        forceRefresh = true;
        sharedInstance = new HandShake(paramContext);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  static HandShake sharedHandShake(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 92	com/millennialmedia/android/HandShake:apid	Ljava/lang/String;
    //   6: ifnonnull +16 -> 22
    //   9: ldc_w 635
    //   12: invokestatic 266	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;)V
    //   15: aconst_null
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: getstatic 631	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   25: ifnonnull +21 -> 46
    //   28: new 2	com/millennialmedia/android/HandShake
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 629	com/millennialmedia/android/HandShake:<init>	(Landroid/content/Context;)V
    //   36: putstatic 631	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   39: getstatic 631	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   42: astore_0
    //   43: goto -26 -> 17
    //   46: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   49: getstatic 631	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   52: getfield 176	com/millennialmedia/android/HandShake:lastHandShake	J
    //   55: lsub
    //   56: getstatic 631	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   59: getfield 137	com/millennialmedia/android/HandShake:handShakeCallback	J
    //   62: lcmp
    //   63: ifle -24 -> 39
    //   66: ldc_w 637
    //   69: invokestatic 424	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   72: new 2	com/millennialmedia/android/HandShake
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 629	com/millennialmedia/android/HandShake:<init>	(Landroid/content/Context;)V
    //   80: putstatic 631	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   83: goto -44 -> 39
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	15	86	finally
    //   22	39	86	finally
    //   39	43	86	finally
    //   46	83	86	finally
  }
  
  /* Error */
  boolean canDisplayCachedAd(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 122	com/millennialmedia/android/HandShake:adTypeHandShakes	Ljava/util/LinkedHashMap;
    //   6: aload_1
    //   7: invokevirtual 595	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 12	com/millennialmedia/android/HandShake$AdTypeHandShake
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +15 -> 30
    //   18: aload_1
    //   19: lload_2
    //   20: invokevirtual 642	com/millennialmedia/android/HandShake$AdTypeHandShake:canDisplayCachedAd	(J)Z
    //   23: istore 4
    //   25: aload_0
    //   26: monitorexit
    //   27: iload 4
    //   29: ireturn
    //   30: iconst_1
    //   31: istore 4
    //   33: goto -8 -> 25
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	HandShake
    //   0	41	1	paramString	String
    //   0	41	2	paramLong	long
    //   23	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	36	finally
    //   18	25	36	finally
  }
  
  /* Error */
  boolean canRequestVideo(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 122	com/millennialmedia/android/HandShake:adTypeHandShakes	Ljava/util/LinkedHashMap;
    //   6: aload_2
    //   7: invokevirtual 595	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 12	com/millennialmedia/android/HandShake$AdTypeHandShake
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +13 -> 28
    //   18: aload_2
    //   19: aload_1
    //   20: invokevirtual 645	com/millennialmedia/android/HandShake$AdTypeHandShake:canRequestVideo	(Landroid/content/Context;)Z
    //   23: istore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: iconst_1
    //   29: istore_3
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	HandShake
    //   0	38	1	paramContext	Context
    //   0	38	2	paramString	String
    //   23	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   18	24	33	finally
  }
  
  void endSession()
  {
    if (!TextUtils.isEmpty(this.endSessionURL)) {
      Utils.HttpUtils.executeUrl(this.endSessionURL);
    }
  }
  
  JSONArray getSchemesJSONArray(Context paramContext)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      if (this.schemes.size() > 0)
      {
        Iterator localIterator = this.schemes.iterator();
        while (localIterator.hasNext())
        {
          Scheme localScheme = (Scheme)localIterator.next();
          boolean bool = localScheme.checkAvailability(paramContext);
          if (bool) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("scheme", localScheme.scheme);
              localJSONObject.put("schemeid", localScheme.id);
              localJSONArray.put(localJSONObject);
            }
            catch (JSONException localJSONException) {}
          }
        }
      }
      return localJSONArray;
    }
    finally {}
  }
  
  String getSchemesList(Context paramContext)
  {
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        if ((this.schemesList != null) || (this.schemes.size() <= 0)) {
          break label139;
        }
        localStringBuilder = new StringBuilder();
        Iterator localIterator = this.schemes.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Scheme localScheme = (Scheme)localIterator.next();
        if (localScheme.checkAvailability(paramContext)) {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("," + localScheme.id);
          } else {
            localStringBuilder.append(Integer.toString(localScheme.id));
          }
        }
      }
      finally {}
    }
    if (localStringBuilder.length() > 0) {
      this.schemesList = localStringBuilder.toString();
    }
    label139:
    paramContext = this.schemesList;
    return paramContext;
  }
  
  /* Error */
  boolean isAdTypeDownloading(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 122	com/millennialmedia/android/HandShake:adTypeHandShakes	Ljava/util/LinkedHashMap;
    //   6: aload_1
    //   7: invokevirtual 595	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 12	com/millennialmedia/android/HandShake$AdTypeHandShake
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: getfield 685	com/millennialmedia/android/HandShake$AdTypeHandShake:downloading	Z
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_2
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	HandShake
    //   0	37	1	paramString	String
    //   22	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	32	finally
    //   18	23	32	finally
  }
  
  void lockAdTypeDownload(String paramString)
  {
    try
    {
      paramString = (AdTypeHandShake)this.adTypeHandShakes.get(paramString);
      if (paramString != null) {
        paramString.downloading = true;
      }
      return;
    }
    finally {}
  }
  
  void sendInitRequest()
  {
    requestHandshake(true);
  }
  
  void setMMdid(Context paramContext, String paramString)
  {
    setMMdid(paramContext, paramString, true);
  }
  
  /* Error */
  void setMMdid(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +74 -> 77
    //   6: aload_2
    //   7: invokevirtual 489	java/lang/String:length	()I
    //   10: ifeq +13 -> 23
    //   13: aload_2
    //   14: ldc_w 689
    //   17: invokevirtual 692	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +57 -> 77
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 474	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
    //   28: aload_0
    //   29: getfield 474	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
    //   32: invokestatic 696	com/millennialmedia/android/MMSDK:setMMdid	(Ljava/lang/String;)V
    //   35: iload_3
    //   36: ifeq +38 -> 74
    //   39: aload_1
    //   40: ldc_w 435
    //   43: iconst_0
    //   44: invokevirtual 439	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   47: invokeinterface 551 1 0
    //   52: astore_1
    //   53: aload_1
    //   54: ldc_w 472
    //   57: aload_0
    //   58: getfield 474	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
    //   61: invokeinterface 567 3 0
    //   66: pop
    //   67: aload_1
    //   68: invokeinterface 615 1 0
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_0
    //   78: aload_2
    //   79: putfield 474	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
    //   82: goto -54 -> 28
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	HandShake
    //   0	90	1	paramContext	Context
    //   0	90	2	paramString	String
    //   0	90	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   6	23	85	finally
    //   23	28	85	finally
    //   28	35	85	finally
    //   39	74	85	finally
    //   77	82	85	finally
  }
  
  void startSession()
  {
    if (!TextUtils.isEmpty(this.startSessionURL)) {
      Utils.HttpUtils.executeUrl(this.startSessionURL);
    }
  }
  
  void unlockAdTypeDownload(String paramString)
  {
    try
    {
      paramString = (AdTypeHandShake)this.adTypeHandShakes.get(paramString);
      if (paramString != null) {
        paramString.downloading = false;
      }
      return;
    }
    finally {}
  }
  
  void updateLastVideoViewedTime(Context paramContext, String paramString)
  {
    try
    {
      AdTypeHandShake localAdTypeHandShake = (AdTypeHandShake)this.adTypeHandShakes.get(paramString);
      if (localAdTypeHandShake != null) {
        localAdTypeHandShake.updateLastVideoViewedTime(paramContext, paramString);
      }
      return;
    }
    finally {}
  }
  
  private class AdTypeHandShake
  {
    boolean downloading;
    long lastVideo = 0L;
    long videoInterval = 0L;
    
    AdTypeHandShake() {}
    
    boolean canDisplayCachedAd(long paramLong)
    {
      return System.currentTimeMillis() - paramLong < HandShake.this.deferredViewTimeout;
    }
    
    boolean canRequestVideo(Context paramContext)
    {
      MMSDK.Log.d("canRequestVideo() Current Time: %d Last Video: %d  Diff: %d  Video interval: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.lastVideo / 1000L), Long.valueOf((System.currentTimeMillis() - this.lastVideo) / 1000L), Long.valueOf(this.videoInterval / 1000L) });
      return System.currentTimeMillis() - this.lastVideo > this.videoInterval;
    }
    
    void deserializeFromObj(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return;
      }
      this.videoInterval = (paramJSONObject.optLong("videointerval") * 1000L);
    }
    
    boolean load(SharedPreferences paramSharedPreferences, String paramString)
    {
      boolean bool = false;
      if (paramSharedPreferences.contains("handshake_lastvideo_" + paramString))
      {
        this.lastVideo = paramSharedPreferences.getLong("handshake_lastvideo_" + paramString, this.lastVideo);
        bool = true;
      }
      if (paramSharedPreferences.contains("handshake_videointerval_" + paramString))
      {
        this.videoInterval = paramSharedPreferences.getLong("handshake_videointerval_" + paramString, this.videoInterval);
        bool = true;
      }
      return bool;
    }
    
    void loadLastVideo(Context paramContext, String paramString)
    {
      paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
      if ((paramContext != null) && (paramContext.contains("handshake_lastvideo_" + paramString))) {
        this.lastVideo = paramContext.getLong("handshake_lastvideo_" + paramString, this.lastVideo);
      }
    }
    
    void save(Context paramContext, String paramString)
    {
      paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
      save(paramContext, paramString);
      paramContext.commit();
    }
    
    void save(SharedPreferences.Editor paramEditor, String paramString)
    {
      paramEditor.putLong("handshake_lastvideo_" + paramString, this.lastVideo);
      paramEditor.putLong("handshake_videointerval_" + paramString, this.videoInterval);
    }
    
    void updateLastVideoViewedTime(Context paramContext, String paramString)
    {
      this.lastVideo = System.currentTimeMillis();
      save(paramContext, paramString);
    }
  }
  
  static class NuanceCredentials
  {
    String appID;
    String appKey;
    int port;
    String server;
    String sessionID;
    
    public String toString()
    {
      return "Credentials: appid=" + this.appID + " server=" + this.server + " port=" + this.port + " appKey=" + this.appKey + "sessionID=" + this.sessionID;
    }
  }
  
  private class Scheme
  {
    int id;
    String scheme;
    
    Scheme() {}
    
    Scheme(String paramString, int paramInt)
    {
      this.scheme = paramString;
      this.id = paramInt;
    }
    
    boolean checkAvailability(Context paramContext)
    {
      if (this.scheme.contains("://")) {}
      for (Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.scheme)); paramContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0; localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.scheme + "://"))) {
        return true;
      }
      return false;
    }
    
    void deserializeFromObj(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return;
      }
      this.scheme = paramJSONObject.optString("scheme", null);
      this.id = paramJSONObject.optInt("schemeid");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/HandShake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */