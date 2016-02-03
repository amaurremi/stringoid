package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HandShake
{
  private static final String HANDSHAKE_URL = "http://ads.mp.mydas.mobi/";
  private static final String HANDSHAKE_URL_PARMS = "appConfigServlet?apid=";
  static String apid;
  private static boolean forceRefresh;
  private static String overrideHandShakeURL;
  private static HandShake sharedInstance;
  private LinkedHashMap<String, AdTypeHandShake> adTypeHandShakes = new LinkedHashMap();
  private WeakReference<Context> appContextRef;
  private String[] cachedVideos;
  private WeakReference<Context> contextRef;
  long creativeCacheTimeout = 259200000L;
  private long deferredViewTimeout = 3600000L;
  private long handShakeCallback = 86400000L;
  private final Handler handler = new Handler(Looper.getMainLooper());
  boolean hdid = true;
  boolean kill = false;
  private long lastHandShake;
  String mmdid;
  private ArrayList<Scheme> schemes = new ArrayList();
  private String schemesList;
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
      new Thread(new Runnable()
      {
        public void run()
        {
          HttpGetRequest localHttpGetRequest = new HttpGetRequest();
          Object localObject2 = (Context)HandShake.this.contextRef.get();
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = (Context)HandShake.this.appContextRef.get();
          }
          if (localObject1 == null) {
            return;
          }
          StringBuilder localStringBuilder;
          Object localObject3;
          try
          {
            localStringBuilder = new StringBuilder();
            localObject2 = new TreeMap();
            ((TreeMap)localObject2).put("ua", "Android:" + Build.MODEL);
            MMAdViewController.getUrlCommonValues((Context)localObject1, (Map)localObject2);
            localObject2 = ((TreeMap)localObject2).entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              localStringBuilder.append(String.format("&%s=%s", new Object[] { ((Map.Entry)localObject3).getKey(), URLEncoder.encode((String)((Map.Entry)localObject3).getValue(), "UTF-8") }));
            }
            localObject3 = new StringBuilder();
          }
          catch (Exception localException)
          {
            MMAdViewSDK.Log.e("Could not get a handshake. %s", new Object[] { localException.getMessage() });
            return;
          }
          if (HandShake.overrideHandShakeURL == null) {}
          for (localObject2 = "http://ads.mp.mydas.mobi/appConfigServlet?apid=";; localObject2 = HandShake.overrideHandShakeURL)
          {
            localObject2 = (String)localObject2 + HandShake.apid + localStringBuilder.toString();
            MMAdViewSDK.Log.v("Performing handshake: %s", new Object[] { localObject2 });
            localObject2 = localHttpGetRequest.get((String)localObject2);
            if (localObject2 == null) {
              break;
            }
            HandShake.this.deserializeFromObj(HandShake.access$300(HandShake.this, HttpGetRequest.convertStreamToString(((HttpResponse)localObject2).getEntity().getContent())));
            HandShake.this.saveHandShake(localException);
            HandShake.this.handler.postDelayed(HandShake.this.updateHandShakeRunnable, HandShake.this.handShakeCallback);
            return;
          }
        }
      }).start();
    }
  }
  
  private void deserializeFromObj(JSONObject paramJSONObject)
  {
    final Context localContext = (Context)this.contextRef.get();
    if (paramJSONObject == null) {
      return;
    }
    int i;
    label31:
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
            break label485;
          }
          localObject2 = ((JSONObject)localObject3).optString("message", null);
          localObject3 = ((JSONObject)localObject3).optString("type", null);
          if ((localObject2 == null) || (localObject3 == null)) {
            break label485;
          }
          if (((String)localObject3).equalsIgnoreCase("log")) {
            MMAdViewSDK.Log.e((String)localObject2);
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
      localObject2 = MMAdView.getAdTypes();
      i = 0;
      label159:
      if (i < localObject2.length)
      {
        localObject3 = ((JSONObject)localObject1).optJSONObject(localObject2[i]);
        if (localObject3 == null) {
          break label492;
        }
        AdTypeHandShake localAdTypeHandShake = new AdTypeHandShake();
        localAdTypeHandShake.deserializeFromObj((JSONObject)localObject3);
        localAdTypeHandShake.loadLastVideo(localContext, localObject2[i]);
        this.adTypeHandShakes.put(localObject2[i], localAdTypeHandShake);
        break label492;
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
            break label499;
          }
          this.schemes.removeAll(this.schemes);
          break label499;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 == null) {
              break label504;
            }
            localObject3 = new Scheme();
            ((Scheme)localObject3).deserializeFromObj((JSONObject)localObject2);
            this.schemes.add(localObject3);
            break label504;
          }
        }
        this.deferredViewTimeout = (paramJSONObject.optLong("deferredviewtimeout", 3600L) * 1000L);
        this.kill = paramJSONObject.optBoolean("kill");
        this.handShakeCallback = (paramJSONObject.optLong("handshakecallback", 86400L) * 1000L);
        this.hdid = paramJSONObject.optBoolean("hdid", true);
        this.creativeCacheTimeout = (paramJSONObject.optLong("creativeCacheTimeout", 259200L) * 1000L);
        paramJSONObject = paramJSONObject.optJSONArray("cachedVideos");
        if (paramJSONObject != null)
        {
          this.cachedVideos = new String[paramJSONObject.length()];
          i = 0;
          if (i < paramJSONObject.length())
          {
            this.cachedVideos[i] = paramJSONObject.optString(i);
            i += 1;
            continue;
          }
        }
        else
        {
          this.cachedVideos = new String[0];
        }
      }
      finally {}
      if (this.cachedVideos.length <= 0) {
        break;
      }
      PreCacheWorker.preCacheVideos(this.cachedVideos, localContext);
      return;
      label485:
      i += 1;
      break label31;
      label492:
      i += 1;
      break label159;
      label499:
      i = 0;
      continue;
      label504:
      i += 1;
    }
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
    if (localSharedPreferences.contains("handshake_kill"))
    {
      this.kill = localSharedPreferences.getBoolean("handshake_kill", this.kill);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_callback"))
    {
      this.handShakeCallback = localSharedPreferences.getLong("handshake_callback", this.handShakeCallback);
      bool1 = true;
    }
    if (localSharedPreferences.contains("handshake_hdid"))
    {
      this.hdid = localSharedPreferences.getBoolean("handshake_hdid", this.hdid);
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
    Object localObject1 = MMAdView.getAdTypes();
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
              break label590;
            }
            localObject2 = localObject1[i].split("\t");
            if (localObject2.length < 2) {
              break label583;
            }
            localObject2 = new Scheme(localObject2[0], Integer.parseInt(localObject2[1]));
            this.schemes.add(localObject2);
            break label583;
          }
        }
        if (localSharedPreferences.contains("handshake_cachedvideos"))
        {
          localObject1 = localSharedPreferences.getString("handshake_cachedvideos", "");
          if (((String)localObject1).length() > 0) {
            this.cachedVideos = ((String)localObject1).split("\n");
          }
        }
        if (this.cachedVideos == null) {
          this.cachedVideos = new String[0];
        }
        if (localSharedPreferences.contains("handshake_lasthandshake"))
        {
          this.lastHandShake = localSharedPreferences.getLong("handshake_lasthandshake", this.lastHandShake);
          bool2 = true;
        }
        if (bool2)
        {
          MMAdViewSDK.Log.d("Handshake successfully loaded from shared preferences.");
          if (System.currentTimeMillis() - this.lastHandShake < this.handShakeCallback) {
            this.handler.postDelayed(this.updateHandShakeRunnable, this.handShakeCallback - (System.currentTimeMillis() - this.lastHandShake));
          }
          if (this.cachedVideos.length > 0) {
            PreCacheWorker.preCacheVideos(this.cachedVideos, paramContext);
          }
        }
        return bool2;
      }
      finally {}
      label583:
      i += 1;
      continue;
      label590:
      bool2 = true;
    }
  }
  
  private JSONObject parseJson(String paramString)
  {
    MMAdViewSDK.Log.d("JSON String: %s", new Object[] { paramString });
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString);
        MMAdViewSDK.Log.v(paramString.toString());
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
  
  private void saveHandShake(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
    paramContext.putLong("handshake_deferredviewtimeout", this.deferredViewTimeout);
    paramContext.putBoolean("handshake_kill", this.kill);
    paramContext.putLong("handshake_callback", this.handShakeCallback);
    paramContext.putBoolean("handshake_hdid", this.hdid);
    paramContext.putLong("handshake_creativecaetimeout", this.creativeCacheTimeout);
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
      localObject1 = new StringBuilder();
      i = 0;
      while (i < this.cachedVideos.length)
      {
        if (i > 0) {
          ((StringBuilder)localObject1).append("\n");
        }
        ((StringBuilder)localObject1).append(this.cachedVideos[i]);
        i += 1;
      }
      if (((StringBuilder)localObject1).length() <= 0) {
        break label324;
      }
    }
    finally {}
    paramContext.putString("handshake_cachedvideos", ((StringBuilder)localObject1).toString());
    label324:
    paramContext.putLong("handshake_lasthandshake", this.lastHandShake);
    paramContext.commit();
  }
  
  static void setHandShakeURL(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        overrideHandShakeURL = paramString + "appConfigServlet?apid=";
        forceRefresh = true;
        sharedInstance = new HandShake(paramContext);
        return;
      }
      finally {}
      overrideHandShakeURL = "http://ads.mp.mydas.mobi/appConfigServlet?apid=";
    }
  }
  
  /* Error */
  static HandShake sharedHandShake(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 485	com/millennialmedia/android/HandShake:apid	Ljava/lang/String;
    //   6: ifnonnull +16 -> 22
    //   9: ldc_w 487
    //   12: invokestatic 219	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;)V
    //   15: aconst_null
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: getstatic 479	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   25: ifnonnull +21 -> 46
    //   28: new 2	com/millennialmedia/android/HandShake
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 477	com/millennialmedia/android/HandShake:<init>	(Landroid/content/Context;)V
    //   36: putstatic 479	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   39: getstatic 479	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   42: astore_0
    //   43: goto -26 -> 17
    //   46: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   49: getstatic 479	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   52: getfield 133	com/millennialmedia/android/HandShake:lastHandShake	J
    //   55: lsub
    //   56: getstatic 479	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
    //   59: getfield 91	com/millennialmedia/android/HandShake:handShakeCallback	J
    //   62: lcmp
    //   63: ifle -24 -> 39
    //   66: ldc_w 489
    //   69: invokestatic 375	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   72: new 2	com/millennialmedia/android/HandShake
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 477	com/millennialmedia/android/HandShake:<init>	(Landroid/content/Context;)V
    //   80: putstatic 479	com/millennialmedia/android/HandShake:sharedInstance	Lcom/millennialmedia/android/HandShake;
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
    //   3: getfield 76	com/millennialmedia/android/HandShake:adTypeHandShakes	Ljava/util/LinkedHashMap;
    //   6: aload_1
    //   7: invokevirtual 441	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 12	com/millennialmedia/android/HandShake$AdTypeHandShake
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +15 -> 30
    //   18: aload_1
    //   19: lload_2
    //   20: invokevirtual 494	com/millennialmedia/android/HandShake$AdTypeHandShake:canDisplayCachedAd	(J)Z
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
    //   3: getfield 76	com/millennialmedia/android/HandShake:adTypeHandShakes	Ljava/util/LinkedHashMap;
    //   6: aload_2
    //   7: invokevirtual 441	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 12	com/millennialmedia/android/HandShake$AdTypeHandShake
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +15 -> 32
    //   20: aload 4
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 498	com/millennialmedia/android/HandShake$AdTypeHandShake:canRequestVideo	(Landroid/content/Context;Ljava/lang/String;)Z
    //   27: istore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: iconst_1
    //   33: istore_3
    //   34: goto -6 -> 28
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	HandShake
    //   0	42	1	paramContext	Context
    //   0	42	2	paramString	String
    //   27	7	3	bool	boolean
    //   13	8	4	localAdTypeHandShake	AdTypeHandShake
    // Exception table:
    //   from	to	target	type
    //   2	15	37	finally
    //   20	28	37	finally
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
    //   3: getfield 76	com/millennialmedia/android/HandShake:adTypeHandShakes	Ljava/util/LinkedHashMap;
    //   6: aload_1
    //   7: invokevirtual 441	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 12	com/millennialmedia/android/HandShake$AdTypeHandShake
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: getfield 530	com/millennialmedia/android/HandShake$AdTypeHandShake:downloading	Z
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
  
  void overrideAdRefresh(MMAdView paramMMAdView)
  {
    if (paramMMAdView.adType != null)
    {
      AdTypeHandShake localAdTypeHandShake = (AdTypeHandShake)this.adTypeHandShakes.get(paramMMAdView.adType);
      if ((localAdTypeHandShake != null) && (localAdTypeHandShake.refreshInterval != null)) {
        paramMMAdView.refreshInterval = Integer.parseInt(localAdTypeHandShake.refreshInterval);
      }
    }
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
    //   7: invokevirtual 349	java/lang/String:length	()I
    //   10: ifeq +13 -> 23
    //   13: aload_2
    //   14: ldc_w 543
    //   17: invokevirtual 546	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +57 -> 77
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 331	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
    //   28: aload_0
    //   29: getfield 331	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
    //   32: invokestatic 550	com/millennialmedia/android/MMAdViewSDK:setMMdid	(Ljava/lang/String;)V
    //   35: iload_3
    //   36: ifeq +38 -> 74
    //   39: aload_1
    //   40: ldc_w 304
    //   43: iconst_0
    //   44: invokevirtual 308	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   47: invokeinterface 407 1 0
    //   52: astore_1
    //   53: aload_1
    //   54: ldc_w 329
    //   57: aload_0
    //   58: getfield 331	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
    //   61: invokeinterface 470 3 0
    //   66: pop
    //   67: aload_1
    //   68: invokeinterface 474 1 0
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_0
    //   78: aload_2
    //   79: putfield 331	com/millennialmedia/android/HandShake:mmdid	Ljava/lang/String;
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
    String refreshInterval;
    long videoInterval = 0L;
    
    AdTypeHandShake() {}
    
    boolean canDisplayCachedAd(long paramLong)
    {
      return System.currentTimeMillis() - paramLong < HandShake.this.deferredViewTimeout;
    }
    
    boolean canRequestVideo(Context paramContext, String paramString)
    {
      MMAdViewSDK.Log.d("canRequestVideo() Current Time: %d Last Video: %d  Diff: %d  Video interval: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.lastVideo / 1000L), Long.valueOf((System.currentTimeMillis() - this.lastVideo) / 1000L), Long.valueOf(this.videoInterval / 1000L) });
      return System.currentTimeMillis() - this.lastVideo > this.videoInterval;
    }
    
    void deserializeFromObj(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {}
      do
      {
        return;
        this.videoInterval = (paramJSONObject.optLong("videointerval") * 1000L);
        this.refreshInterval = paramJSONObject.optString("adrefresh", null);
      } while ((this.refreshInterval == null) || (!this.refreshInterval.equalsIgnoreCase("sdk")));
      this.refreshInterval = null;
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
      if (paramSharedPreferences.contains("handshake_adrefresh_" + paramString))
      {
        this.refreshInterval = paramSharedPreferences.getString("handshake_adrefresh_" + paramString, null);
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
      if (this.refreshInterval != null) {
        paramEditor.putString("handshake_adrefresh_" + paramString, this.refreshInterval);
      }
    }
    
    void updateLastVideoViewedTime(Context paramContext, String paramString)
    {
      this.lastVideo = System.currentTimeMillis();
      save(paramContext, paramString);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/HandShake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */