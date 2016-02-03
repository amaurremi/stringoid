package com.parse;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParsePushRouter
{
  private static final Pattern CHANNEL_PATTERN;
  private static final String LEGACY_ROUTE_LOCATION = "persistentCallbacks";
  private static final String STATE_LOCATION = "pushState";
  private static final String TAG = "com.parse.ParsePushRouter";
  static Map<String, CallbackFactory> channelRoutes;
  static Set<String> channels;
  static CallbackFactory defaultRoute;
  private static boolean hasLoadedStateFromDisk;
  static JSONObject history;
  static String ignoreAfter;
  static String lastTime;
  static int maxHistory;
  
  static
  {
    if (!ParsePushRouter.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      CHANNEL_PATTERN = Pattern.compile("^$|^[a-zA-Z][A-Za-z0-9_-]*$");
      channelRoutes = null;
      defaultRoute = null;
      channels = new HashSet();
      lastTime = null;
      ignoreAfter = null;
      history = null;
      maxHistory = 10;
      hasLoadedStateFromDisk = false;
      return;
    }
  }
  
  static boolean addChannelRoute(Context paramContext, String paramString, Class<? extends Activity> paramClass, int paramInt)
  {
    if (paramString == null) {
      throw new NullPointerException("invalid channel: you cannot subscribe to null");
    }
    if (!CHANNEL_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("invalid channel name: " + paramString);
    }
    paramClass = dataForActivity(paramContext, paramClass, paramInt);
    if (paramClass == null) {
      return false;
    }
    return addChannelRoute(paramContext, paramString, paramClass, StandardPushCallback.class);
  }
  
  static boolean addChannelRoute(Context paramContext, String paramString, JSONObject paramJSONObject, Class<? extends PushCallback> paramClass)
  {
    for (;;)
    {
      try
      {
        ensureStateIsLoaded(paramContext);
        try
        {
          paramJSONObject = new JSONObject(paramJSONObject.toString());
          if (channelRoutes.put(paramString, new CallbackFactory(paramClass, paramJSONObject)) != null) {
            continue;
          }
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            paramJSONObject = (ParseInstallation)ParseObject.create(ParseInstallation.class);
            paramJSONObject.addUnique("channels", paramString);
            saveEventually(paramContext, paramJSONObject);
            bool2 = bool1;
          }
        }
        catch (JSONException paramContext)
        {
          boolean bool1;
          Parse.logE("com.parse.ParsePushRouter", "Impossible exception when deserializing a serialized JSON string: " + paramContext.getMessage());
          boolean bool2 = false;
          continue;
        }
        return bool2;
      }
      finally {}
      bool1 = false;
    }
  }
  
  static void addSingletonRoute(Context paramContext, String paramString, PushCallback paramPushCallback)
  {
    ensureStateIsLoaded(paramContext);
    if (paramString != null)
    {
      channelRoutes.put(paramString, new SingletonFactory(paramPushCallback));
      return;
    }
    defaultRoute = new SingletonFactory(paramPushCallback);
  }
  
  static void clearStateFromDisk(Context paramContext)
  {
    clearStateFromMemory();
    ParseObject.deleteDiskObject(paramContext, "persistentCallbacks");
    ParseObject.deleteDiskObject(paramContext, "pushState");
  }
  
  static void clearStateFromMemory()
  {
    hasLoadedStateFromDisk = false;
    channelRoutes = null;
    defaultRoute = null;
    lastTime = null;
    channels = new HashSet();
    history = null;
  }
  
  static JSONObject dataForActivity(Context paramContext, Class<? extends Activity> paramClass, int paramInt)
  {
    getApplicationId(paramContext);
    Object localObject1 = paramContext.getPackageName();
    Object localObject2 = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = ((PackageManager)localObject2).getApplicationInfo((String)localObject1, 0);
        localObject1 = localApplicationInfo.loadLabel((PackageManager)localObject2);
        if (localObject1 != null)
        {
          localObject1 = ((CharSequence)localObject1).toString();
          paramClass = new ComponentName(paramContext, paramClass);
          paramContext = paramClass.getClassName();
          paramClass = paramClass.getPackageName();
          localObject2 = new JSONObject();
        }
        localObject1 = null;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        try
        {
          ((JSONObject)localObject2).put("icon", paramInt);
          ((JSONObject)localObject2).put("appName", localObject1);
          ((JSONObject)localObject2).put("activityClass", paramContext);
          ((JSONObject)localObject2).put("activityPackage", paramClass);
          return (JSONObject)localObject2;
        }
        catch (JSONException paramContext)
        {
          throw new RuntimeException(paramContext.getMessage());
        }
        paramContext = paramContext;
        Parse.logE("com.parse.ParsePushRouter", "missing package " + (String)localObject1, paramContext);
        return null;
      }
    }
  }
  
  /* Error */
  static void ensureStateIsLoaded(Context arg0)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 88	com/parse/ParsePushRouter:hasLoadedStateFromDisk	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: iconst_1
    //   18: putstatic 88	com/parse/ParsePushRouter:hasLoadedStateFromDisk	Z
    //   21: aconst_null
    //   22: putstatic 71	com/parse/ParsePushRouter:defaultRoute	Lcom/parse/ParsePushRouter$CallbackFactory;
    //   25: new 274	java/util/HashMap
    //   28: dup
    //   29: invokespecial 275	java/util/HashMap:<init>	()V
    //   32: putstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   35: new 152	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 245	org/json/JSONObject:<init>	()V
    //   42: putstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   45: aload_0
    //   46: ldc 26
    //   48: invokestatic 279	com/parse/ParseObject:getDiskObject	(Landroid/content/Context;Ljava/lang/String;)Lorg/json/JSONObject;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +96 -> 151
    //   58: ldc 32
    //   60: new 122	java/lang/StringBuilder
    //   63: dup
    //   64: ldc_w 281
    //   67: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload 4
    //   72: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   75: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 284	com/parse/Parse:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 4
    //   86: invokestatic 288	com/parse/ParsePushRouter:parseChannelRoutes	(Lorg/json/JSONObject;)V
    //   89: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   92: invokeinterface 293 1 0
    //   97: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   100: getstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   103: invokeinterface 297 1 0
    //   108: invokeinterface 301 2 0
    //   113: pop
    //   114: ldc -91
    //   116: invokestatic 171	com/parse/ParseObject:create	(Ljava/lang/Class;)Lcom/parse/ParseObject;
    //   119: checkcast 165	com/parse/ParseInstallation
    //   122: astore 4
    //   124: aload 4
    //   126: ldc -84
    //   128: getstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   131: invokeinterface 297 1 0
    //   136: invokevirtual 305	com/parse/ParseInstallation:addAllUnique	(Ljava/lang/String;Ljava/util/Collection;)V
    //   139: aload_0
    //   140: aload 4
    //   142: invokestatic 180	com/parse/ParsePushRouter:saveEventually	(Landroid/content/Context;Lcom/parse/ParseInstallation;)V
    //   145: aload_0
    //   146: ldc 26
    //   148: invokestatic 205	com/parse/ParseObject:deleteDiskObject	(Landroid/content/Context;Ljava/lang/String;)V
    //   151: aload_0
    //   152: ldc 29
    //   154: invokestatic 279	com/parse/ParseObject:getDiskObject	(Landroid/content/Context;Ljava/lang/String;)Lorg/json/JSONObject;
    //   157: astore 4
    //   159: aload 4
    //   161: ifnull -148 -> 13
    //   164: aload 4
    //   166: ldc_w 307
    //   169: invokevirtual 311	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   172: invokestatic 288	com/parse/ParsePushRouter:parseChannelRoutes	(Lorg/json/JSONObject;)V
    //   175: aload 4
    //   177: ldc_w 312
    //   180: invokevirtual 311	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +13 -> 200
    //   190: new 14	com/parse/ParsePushRouter$CallbackFactory
    //   193: dup
    //   194: aload 5
    //   196: invokespecial 314	com/parse/ParsePushRouter$CallbackFactory:<init>	(Lorg/json/JSONObject;)V
    //   199: astore_3
    //   200: aload_3
    //   201: putstatic 71	com/parse/ParsePushRouter:defaultRoute	Lcom/parse/ParsePushRouter$CallbackFactory;
    //   204: aload 4
    //   206: ldc_w 315
    //   209: aconst_null
    //   210: invokevirtual 319	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   213: putstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   216: aload 4
    //   218: ldc_w 320
    //   221: aconst_null
    //   222: invokevirtual 319	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   225: putstatic 82	com/parse/ParsePushRouter:ignoreAfter	Ljava/lang/String;
    //   228: aload 4
    //   230: ldc_w 322
    //   233: invokevirtual 326	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   236: astore 5
    //   238: aload 5
    //   240: ifnull +46 -> 286
    //   243: new 328	java/util/ArrayList
    //   246: dup
    //   247: invokespecial 329	java/util/ArrayList:<init>	()V
    //   250: astore_3
    //   251: iconst_0
    //   252: istore_1
    //   253: iload_1
    //   254: aload 5
    //   256: invokevirtual 335	org/json/JSONArray:length	()I
    //   259: if_icmplt +244 -> 503
    //   262: ldc -91
    //   264: invokestatic 171	com/parse/ParseObject:create	(Ljava/lang/Class;)Lcom/parse/ParseObject;
    //   267: checkcast 165	com/parse/ParseInstallation
    //   270: astore 5
    //   272: aload 5
    //   274: ldc -84
    //   276: aload_3
    //   277: invokevirtual 176	com/parse/ParseInstallation:addUnique	(Ljava/lang/String;Ljava/lang/Object;)V
    //   280: aload_0
    //   281: aload 5
    //   283: invokestatic 180	com/parse/ParsePushRouter:saveEventually	(Landroid/content/Context;Lcom/parse/ParseInstallation;)V
    //   286: aload 4
    //   288: ldc_w 337
    //   291: invokevirtual 326	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   294: astore 5
    //   296: aload 5
    //   298: ifnull +46 -> 344
    //   301: new 328	java/util/ArrayList
    //   304: dup
    //   305: invokespecial 329	java/util/ArrayList:<init>	()V
    //   308: astore_3
    //   309: iconst_0
    //   310: istore_1
    //   311: iload_1
    //   312: aload 5
    //   314: invokevirtual 335	org/json/JSONArray:length	()I
    //   317: if_icmplt +206 -> 523
    //   320: ldc -91
    //   322: invokestatic 171	com/parse/ParseObject:create	(Ljava/lang/Class;)Lcom/parse/ParseObject;
    //   325: checkcast 165	com/parse/ParseInstallation
    //   328: astore 5
    //   330: aload 5
    //   332: ldc -84
    //   334: aload_3
    //   335: invokevirtual 340	com/parse/ParseInstallation:removeAll	(Ljava/lang/String;Ljava/util/Collection;)V
    //   338: aload_0
    //   339: aload 5
    //   341: invokestatic 180	com/parse/ParsePushRouter:saveEventually	(Landroid/content/Context;Lcom/parse/ParseInstallation;)V
    //   344: aload 4
    //   346: ldc_w 342
    //   349: invokevirtual 346	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   352: ifeq +196 -> 548
    //   355: ldc -91
    //   357: invokestatic 171	com/parse/ParseObject:create	(Ljava/lang/Class;)Lcom/parse/ParseObject;
    //   360: checkcast 165	com/parse/ParseInstallation
    //   363: astore_0
    //   364: aload_0
    //   365: aload 4
    //   367: ldc_w 342
    //   370: invokevirtual 311	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   373: iconst_1
    //   374: invokevirtual 350	com/parse/ParseInstallation:mergeAfterFetch	(Lorg/json/JSONObject;Z)V
    //   377: aload_0
    //   378: ldc -84
    //   380: invokevirtual 354	com/parse/ParseInstallation:getList	(Ljava/lang/String;)Ljava/util/List;
    //   383: astore_3
    //   384: aload_3
    //   385: ifnull +29 -> 414
    //   388: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   391: astore_0
    //   392: aload_0
    //   393: monitorenter
    //   394: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   397: invokeinterface 293 1 0
    //   402: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   405: aload_3
    //   406: invokeinterface 301 2 0
    //   411: pop
    //   412: aload_0
    //   413: monitorexit
    //   414: aload 4
    //   416: ldc_w 355
    //   419: invokevirtual 346	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   422: ifeq -409 -> 13
    //   425: aload 4
    //   427: ldc_w 355
    //   430: invokevirtual 311	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   433: putstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   436: goto -423 -> 13
    //   439: astore_0
    //   440: ldc 2
    //   442: monitorexit
    //   443: aload_0
    //   444: athrow
    //   445: astore_3
    //   446: ldc 32
    //   448: new 122	java/lang/StringBuilder
    //   451: dup
    //   452: ldc_w 357
    //   455: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_3
    //   459: invokevirtual 358	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   462: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 191	com/parse/Parse:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -267 -> 204
    //   474: astore_3
    //   475: ldc 32
    //   477: new 122	java/lang/StringBuilder
    //   480: dup
    //   481: ldc_w 360
    //   484: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: aload_3
    //   488: invokevirtual 361	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   491: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 191	com/parse/Parse:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: goto -296 -> 204
    //   503: aload_3
    //   504: aload 5
    //   506: iload_1
    //   507: invokevirtual 364	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   510: invokeinterface 370 2 0
    //   515: pop
    //   516: iload_1
    //   517: iconst_1
    //   518: iadd
    //   519: istore_1
    //   520: goto -267 -> 253
    //   523: aload_3
    //   524: aload 5
    //   526: iload_1
    //   527: invokevirtual 364	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   530: invokeinterface 370 2 0
    //   535: pop
    //   536: iload_1
    //   537: iconst_1
    //   538: iadd
    //   539: istore_1
    //   540: goto -229 -> 311
    //   543: astore_3
    //   544: aload_0
    //   545: monitorexit
    //   546: aload_3
    //   547: athrow
    //   548: aload 4
    //   550: ldc -84
    //   552: invokevirtual 346	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   555: ifeq -141 -> 414
    //   558: aload 4
    //   560: ldc -84
    //   562: invokevirtual 326	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   565: astore_3
    //   566: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   569: astore_0
    //   570: aload_0
    //   571: monitorenter
    //   572: iconst_0
    //   573: istore_1
    //   574: iload_1
    //   575: aload_3
    //   576: invokevirtual 335	org/json/JSONArray:length	()I
    //   579: if_icmplt +13 -> 592
    //   582: aload_0
    //   583: monitorexit
    //   584: goto -170 -> 414
    //   587: astore_3
    //   588: aload_0
    //   589: monitorexit
    //   590: aload_3
    //   591: athrow
    //   592: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   595: aload_3
    //   596: iload_1
    //   597: invokevirtual 364	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   600: invokeinterface 371 2 0
    //   605: pop
    //   606: iload_1
    //   607: iconst_1
    //   608: iadd
    //   609: istore_1
    //   610: goto -36 -> 574
    // Local variable table:
    //   start	length	slot	name	signature
    //   252	358	1	i	int
    //   8	2	2	bool	boolean
    //   1	405	3	localObject1	Object
    //   445	14	3	localClassNotFoundException	ClassNotFoundException
    //   474	50	3	localClassCastException	ClassCastException
    //   543	4	3	localObject2	Object
    //   565	11	3	localJSONArray	JSONArray
    //   587	9	3	localObject3	Object
    //   51	508	4	localObject4	Object
    //   183	342	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	439	finally
    //   17	53	439	finally
    //   58	151	439	finally
    //   151	159	439	finally
    //   164	185	439	finally
    //   190	200	439	finally
    //   200	204	439	finally
    //   204	238	439	finally
    //   243	251	439	finally
    //   253	286	439	finally
    //   286	296	439	finally
    //   301	309	439	finally
    //   311	344	439	finally
    //   344	384	439	finally
    //   388	394	439	finally
    //   414	436	439	finally
    //   446	471	439	finally
    //   475	500	439	finally
    //   503	516	439	finally
    //   523	536	439	finally
    //   546	548	439	finally
    //   548	572	439	finally
    //   590	592	439	finally
    //   190	200	445	java/lang/ClassNotFoundException
    //   200	204	445	java/lang/ClassNotFoundException
    //   190	200	474	java/lang/ClassCastException
    //   200	204	474	java/lang/ClassCastException
    //   394	414	543	finally
    //   544	546	543	finally
    //   574	584	587	finally
    //   588	590	587	finally
    //   592	606	587	finally
  }
  
  /* Error */
  static String getApplicationId(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc_w 373
    //   7: invokestatic 279	com/parse/ParseObject:getDiskObject	(Landroid/content/Context;Ljava/lang/String;)Lorg/json/JSONObject;
    //   10: astore_2
    //   11: aload_2
    //   12: astore_1
    //   13: aload_2
    //   14: ifnonnull +11 -> 25
    //   17: new 152	org/json/JSONObject
    //   20: dup
    //   21: invokespecial 245	org/json/JSONObject:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 375
    //   29: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_2
    //   33: aload_2
    //   34: ldc_w 380
    //   37: if_acmpeq +10 -> 47
    //   40: aload_2
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: invokestatic 382	com/parse/ParseObject:getApplicationId	()Ljava/lang/String;
    //   50: astore_2
    //   51: aload_1
    //   52: ldc_w 375
    //   55: aload_2
    //   56: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_0
    //   61: ldc_w 373
    //   64: aload_1
    //   65: invokestatic 386	com/parse/ParseObject:saveDiskObject	(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   68: aload_2
    //   69: astore_0
    //   70: goto -28 -> 42
    //   73: astore_3
    //   74: ldc 32
    //   76: ldc_w 388
    //   79: aload_3
    //   80: invokestatic 264	com/parse/Parse:logE	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: goto -23 -> 60
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   12	53	1	localObject1	Object
    //   10	59	2	localObject2	Object
    //   73	7	3	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   51	60	73	org/json/JSONException
    //   3	11	86	finally
    //   17	25	86	finally
    //   25	33	86	finally
    //   47	51	86	finally
    //   51	60	86	finally
    //   60	68	86	finally
    //   74	83	86	finally
  }
  
  /* Error */
  static JSONObject getPushRequestJSON(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 150	com/parse/ParsePushRouter:ensureStateIsLoaded	(Landroid/content/Context;)V
    //   7: new 152	org/json/JSONObject
    //   10: dup
    //   11: invokespecial 245	org/json/JSONObject:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc_w 392
    //   19: invokestatic 396	com/parse/ParseInstallation:getCurrentInstallation	()Lcom/parse/ParseInstallation;
    //   22: invokevirtual 399	com/parse/ParseInstallation:getInstallationId	()Ljava/lang/String;
    //   25: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   28: pop
    //   29: aload_1
    //   30: ldc_w 401
    //   33: aload_0
    //   34: invokestatic 211	com/parse/ParsePushRouter:getApplicationId	(Landroid/content/Context;)Ljava/lang/String;
    //   37: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_1
    //   42: ldc_w 403
    //   45: ldc_w 405
    //   48: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   51: pop
    //   52: getstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   55: ifnonnull +74 -> 129
    //   58: aload_1
    //   59: ldc_w 407
    //   62: getstatic 411	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   65: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   72: invokevirtual 412	org/json/JSONObject:length	()I
    //   75: ifeq +36 -> 111
    //   78: new 331	org/json/JSONArray
    //   81: dup
    //   82: invokespecial 413	org/json/JSONArray:<init>	()V
    //   85: astore_0
    //   86: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   89: invokevirtual 417	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   92: astore_2
    //   93: aload_2
    //   94: invokeinterface 422 1 0
    //   99: ifne +59 -> 158
    //   102: aload_1
    //   103: ldc_w 424
    //   106: aload_0
    //   107: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload_1
    //   112: ldc_w 426
    //   115: getstatic 82	com/parse/ParsePushRouter:ignoreAfter	Ljava/lang/String;
    //   118: invokevirtual 429	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_1
    //   123: astore_0
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_0
    //   128: areturn
    //   129: aload_1
    //   130: ldc_w 407
    //   133: getstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   136: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: goto -71 -> 69
    //   143: astore_0
    //   144: ldc 32
    //   146: ldc_w 431
    //   149: aload_0
    //   150: invokestatic 264	com/parse/Parse:logE	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -31 -> 124
    //   158: aload_0
    //   159: aload_2
    //   160: invokeinterface 435 1 0
    //   165: invokevirtual 438	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   168: pop
    //   169: goto -76 -> 93
    //   172: astore_0
    //   173: ldc 2
    //   175: monitorexit
    //   176: aload_0
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramContext	Context
    //   14	116	1	localJSONObject	JSONObject
    //   92	68	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   15	69	143	org/json/JSONException
    //   69	93	143	org/json/JSONException
    //   93	111	143	org/json/JSONException
    //   111	122	143	org/json/JSONException
    //   129	140	143	org/json/JSONException
    //   158	169	143	org/json/JSONException
    //   3	15	172	finally
    //   15	69	172	finally
    //   69	93	172	finally
    //   93	111	172	finally
    //   111	122	172	finally
    //   129	140	172	finally
    //   144	153	172	finally
    //   158	169	172	finally
  }
  
  static Set<String> getSubscriptions(Context paramContext)
  {
    try
    {
      ensureStateIsLoaded(paramContext);
      paramContext = Collections.unmodifiableSet(channels);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private static void handlePushData(PushService paramPushService, String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 455
    //   3: monitorenter
    //   4: getstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   7: aload_1
    //   8: invokeinterface 459 2 0
    //   13: checkcast 14	com/parse/ParsePushRouter$CallbackFactory
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload 4
    //   23: ifnonnull +49 -> 72
    //   26: getstatic 71	com/parse/ParsePushRouter:defaultRoute	Lcom/parse/ParsePushRouter$CallbackFactory;
    //   29: ifnonnull +39 -> 68
    //   32: ldc 32
    //   34: new 122	java/lang/StringBuilder
    //   37: dup
    //   38: ldc_w 461
    //   41: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload_2
    //   45: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   48: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 463
    //   54: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 466	com/parse/Parse:logW	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: ldc_w 455
    //   66: monitorexit
    //   67: return
    //   68: getstatic 71	com/parse/ParsePushRouter:defaultRoute	Lcom/parse/ParsePushRouter$CallbackFactory;
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual 470	com/parse/ParsePushRouter$CallbackFactory:newCallback	()Lcom/parse/PushCallback;
    //   76: astore 4
    //   78: ldc_w 455
    //   81: monitorexit
    //   82: ldc 32
    //   84: new 122	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 472
    //   91: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 284	com/parse/Parse:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload 4
    //   106: aload_0
    //   107: invokevirtual 478	com/parse/PushCallback:setService	(Landroid/app/Service;)V
    //   110: aload 4
    //   112: aload_2
    //   113: invokevirtual 481	com/parse/PushCallback:setPushData	(Lorg/json/JSONObject;)V
    //   116: aload 4
    //   118: aload_1
    //   119: invokevirtual 484	com/parse/PushCallback:setChannel	(Ljava/lang/String;)V
    //   122: aload 4
    //   124: invokevirtual 487	com/parse/PushCallback:run	()V
    //   127: return
    //   128: astore_0
    //   129: ldc 32
    //   131: new 122	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 489
    //   138: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_3
    //   142: getfield 493	com/parse/ParsePushRouter$CallbackFactory:clazz	Ljava/lang/Class;
    //   145: invokevirtual 496	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   148: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload_0
    //   155: invokestatic 264	com/parse/Parse:logE	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: ldc_w 455
    //   161: monitorexit
    //   162: return
    //   163: astore_0
    //   164: ldc_w 455
    //   167: monitorexit
    //   168: aload_0
    //   169: athrow
    //   170: astore_0
    //   171: ldc 32
    //   173: new 122	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 498
    //   180: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_3
    //   184: getfield 493	com/parse/ParsePushRouter$CallbackFactory:clazz	Ljava/lang/Class;
    //   187: invokevirtual 496	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   190: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload_0
    //   197: invokestatic 264	com/parse/Parse:logE	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: ldc_w 455
    //   203: monitorexit
    //   204: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramPushService	PushService
    //   0	205	1	paramString	String
    //   0	205	2	paramJSONObject	JSONObject
    //   20	164	3	localObject1	Object
    //   16	107	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   72	78	128	java/lang/IllegalAccessException
    //   4	18	163	finally
    //   26	67	163	finally
    //   68	72	163	finally
    //   72	78	163	finally
    //   78	82	163	finally
    //   129	162	163	finally
    //   164	168	163	finally
    //   171	204	163	finally
    //   72	78	170	java/lang/InstantiationException
  }
  
  /* Error */
  public static boolean hasRoutes(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 150	com/parse/ParsePushRouter:ensureStateIsLoaded	(Landroid/content/Context;)V
    //   7: getstatic 71	com/parse/ParsePushRouter:defaultRoute	Lcom/parse/ParsePushRouter$CallbackFactory;
    //   10: ifnonnull +41 -> 51
    //   13: getstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   16: ifnull +14 -> 30
    //   19: getstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   22: invokeinterface 503 1 0
    //   27: ifeq +24 -> 51
    //   30: aload_0
    //   31: invokestatic 505	com/parse/ParsePushRouter:getSubscriptions	(Landroid/content/Context;)Ljava/util/Set;
    //   34: invokeinterface 506 1 0
    //   39: istore_1
    //   40: iload_1
    //   41: ifeq +10 -> 51
    //   44: iconst_0
    //   45: istore_1
    //   46: ldc 2
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: iconst_1
    //   52: istore_1
    //   53: goto -7 -> 46
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramContext	Context
    //   39	14	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	30	56	finally
    //   30	40	56	finally
  }
  
  /* Error */
  static void insertIntoHistory(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 429	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11: pop
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: getstatic 57	com/parse/ParsePushRouter:$assertionsDisabled	Z
    //   19: ifne +70 -> 89
    //   22: aload_1
    //   23: astore_0
    //   24: getstatic 86	com/parse/ParsePushRouter:maxHistory	I
    //   27: ifgt +62 -> 89
    //   30: new 509	java/lang/AssertionError
    //   33: dup
    //   34: invokespecial 510	java/lang/AssertionError:<init>	()V
    //   37: athrow
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    //   44: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   47: invokevirtual 417	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore 5
    //   52: aload 5
    //   54: invokeinterface 435 1 0
    //   59: checkcast 512	java/lang/String
    //   62: astore_1
    //   63: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   66: aload_1
    //   67: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_0
    //   71: aload 5
    //   73: invokeinterface 422 1 0
    //   78: ifne +35 -> 113
    //   81: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   84: aload_1
    //   85: invokevirtual 516	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   88: pop
    //   89: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   92: invokevirtual 412	org/json/JSONObject:length	()I
    //   95: getstatic 86	com/parse/ParsePushRouter:maxHistory	I
    //   98: if_icmpgt -54 -> 44
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: putstatic 82	com/parse/ParsePushRouter:ignoreAfter	Ljava/lang/String;
    //   109: ldc 2
    //   111: monitorexit
    //   112: return
    //   113: aload 5
    //   115: invokeinterface 435 1 0
    //   120: checkcast 512	java/lang/String
    //   123: astore 4
    //   125: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   128: aload 4
    //   130: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: aload_3
    //   135: aload_0
    //   136: invokevirtual 520	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   139: istore_2
    //   140: iload_2
    //   141: ifge -70 -> 71
    //   144: aload 4
    //   146: astore_1
    //   147: aload_3
    //   148: astore_0
    //   149: goto -78 -> 71
    //   152: astore_0
    //   153: goto -141 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString1	String
    //   0	156	1	paramString2	String
    //   139	2	2	i	int
    //   133	15	3	str1	String
    //   123	22	4	str2	String
    //   50	64	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   3	12	38	finally
    //   16	22	38	finally
    //   24	38	38	finally
    //   44	71	38	finally
    //   71	89	38	finally
    //   89	101	38	finally
    //   105	109	38	finally
    //   113	140	38	finally
    //   3	12	152	org/json/JSONException
  }
  
  /* Error */
  private static boolean isSubscribedToChannel(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 78	com/parse/ParsePushRouter:channels	Ljava/util/Set;
    //   8: aload_1
    //   9: invokeinterface 523 2 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifeq +8 -> 24
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: getstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 459 2 0
    //   33: checkcast 14	com/parse/ParsePushRouter$CallbackFactory
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 526	com/parse/ParsePushRouter$CallbackFactory:requiresSubscription	()Z
    //   45: istore_3
    //   46: iload_3
    //   47: ifeq -28 -> 19
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -33 -> 19
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	Context
    //   0	61	1	paramString	String
    //   1	51	2	bool1	boolean
    //   14	33	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	15	55	finally
    //   24	37	55	finally
    //   41	46	55	finally
  }
  
  private static void parseChannelRoutes(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      channelRoutes.clear();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = null;
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
          localObject = localJSONObject;
          channelRoutes.put(str, new CallbackFactory(localJSONObject));
        }
        catch (JSONException localJSONException)
        {
          Parse.logE("com.parse.ParsePushRouter", "Failed to parse push route " + localObject);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Parse.logE("com.parse.ParsePushRouter", "Route references missing class: " + localClassNotFoundException.getMessage());
        }
        catch (ClassCastException localClassCastException)
        {
          Parse.logE("com.parse.ParsePushRouter", "Route references class which is not a PushCallback: " + localClassCastException.getMessage());
        }
      }
    }
  }
  
  /* Error */
  static boolean removeChannelRoute(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 150	com/parse/ParsePushRouter:ensureStateIsLoaded	(Landroid/content/Context;)V
    //   9: getstatic 69	com/parse/ParsePushRouter:channelRoutes	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 542 2 0
    //   18: ifnull +39 -> 57
    //   21: ldc -91
    //   23: invokestatic 171	com/parse/ParseObject:create	(Ljava/lang/Class;)Lcom/parse/ParseObject;
    //   26: checkcast 165	com/parse/ParseInstallation
    //   29: astore_3
    //   30: aload_3
    //   31: ldc -84
    //   33: iconst_1
    //   34: anewarray 512	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: invokestatic 548	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   44: invokevirtual 340	com/parse/ParseInstallation:removeAll	(Ljava/lang/String;Ljava/util/Collection;)V
    //   47: aload_0
    //   48: aload_3
    //   49: invokestatic 180	com/parse/ParsePushRouter:saveEventually	(Landroid/content/Context;Lcom/parse/ParseInstallation;)V
    //   52: ldc 2
    //   54: monitorexit
    //   55: iload_2
    //   56: ireturn
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -7 -> 52
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	Context
    //   0	68	1	paramString	String
    //   1	58	2	bool	boolean
    //   29	20	3	localParseInstallation	ParseInstallation
    // Exception table:
    //   from	to	target	type
    //   5	52	62	finally
  }
  
  /* Error */
  static void routePush(final PushService paramPushService, final JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_1
    //   8: ldc_w 552
    //   11: aconst_null
    //   12: invokevirtual 319	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 6
    //   17: iload 5
    //   19: istore 4
    //   21: aload_1
    //   22: ldc_w 554
    //   25: invokevirtual 346	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   28: ifeq +118 -> 146
    //   31: iload 5
    //   33: istore 4
    //   35: getstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   38: ifnull +23 -> 61
    //   41: iload 5
    //   43: istore 4
    //   45: aload_1
    //   46: ldc_w 554
    //   49: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: getstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   55: invokevirtual 520	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   58: ifle +19 -> 77
    //   61: iload 5
    //   63: istore 4
    //   65: aload_1
    //   66: ldc_w 554
    //   69: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   75: iconst_1
    //   76: istore_3
    //   77: iload_3
    //   78: istore_2
    //   79: iload_3
    //   80: istore 4
    //   82: getstatic 82	com/parse/ParsePushRouter:ignoreAfter	Ljava/lang/String;
    //   85: ifnull +61 -> 146
    //   88: iload_3
    //   89: istore_2
    //   90: iload_3
    //   91: istore 4
    //   93: aload_1
    //   94: ldc_w 554
    //   97: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: getstatic 82	com/parse/ParsePushRouter:ignoreAfter	Ljava/lang/String;
    //   103: invokevirtual 520	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   106: ifgt +40 -> 146
    //   109: iload_3
    //   110: istore 4
    //   112: ldc 32
    //   114: new 122	java/lang/StringBuilder
    //   117: dup
    //   118: ldc_w 556
    //   121: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   128: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 284	com/parse/Parse:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iload_3
    //   138: ifeq +7 -> 145
    //   141: aload_0
    //   142: invokestatic 95	com/parse/ParsePushRouter:saveStateToDisk	(Landroid/content/Context;)V
    //   145: return
    //   146: aload 6
    //   148: ifnull +54 -> 202
    //   151: iload_2
    //   152: istore 4
    //   154: aload_0
    //   155: aload 6
    //   157: invokestatic 100	com/parse/ParsePushRouter:isSubscribedToChannel	(Landroid/content/Context;Ljava/lang/String;)Z
    //   160: ifne +42 -> 202
    //   163: iload_2
    //   164: istore 4
    //   166: new 12	com/parse/ParsePushRouter$3
    //   169: dup
    //   170: new 10	com/parse/ParsePushRouter$2
    //   173: dup
    //   174: aload_0
    //   175: aload_1
    //   176: invokespecial 558	com/parse/ParsePushRouter$2:<init>	(Lcom/parse/PushService;Lorg/json/JSONObject;)V
    //   179: aload 6
    //   181: aload_0
    //   182: invokespecial 561	com/parse/ParsePushRouter$3:<init>	(Lcom/parse/ParseCallback;Ljava/lang/String;Lcom/parse/PushService;)V
    //   185: iconst_0
    //   186: anewarray 563	java/lang/Void
    //   189: invokevirtual 567	com/parse/ParsePushRouter$3:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   192: pop
    //   193: iload_2
    //   194: ifeq -49 -> 145
    //   197: aload_0
    //   198: invokestatic 95	com/parse/ParsePushRouter:saveStateToDisk	(Landroid/content/Context;)V
    //   201: return
    //   202: iload_2
    //   203: istore 4
    //   205: aload_1
    //   206: ldc_w 569
    //   209: invokevirtual 346	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   212: ifeq +105 -> 317
    //   215: iload_2
    //   216: istore 4
    //   218: aload_1
    //   219: ldc_w 569
    //   222: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 7
    //   227: iload_2
    //   228: istore 4
    //   230: getstatic 84	com/parse/ParsePushRouter:history	Lorg/json/JSONObject;
    //   233: aload 7
    //   235: invokevirtual 346	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   238: ifeq +40 -> 278
    //   241: iload_2
    //   242: istore 4
    //   244: ldc 32
    //   246: new 122	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 571
    //   253: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: aload_1
    //   257: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   260: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 284	com/parse/Parse:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: iload_2
    //   270: ifeq -125 -> 145
    //   273: aload_0
    //   274: invokestatic 95	com/parse/ParsePushRouter:saveStateToDisk	(Landroid/content/Context;)V
    //   277: return
    //   278: iload_2
    //   279: istore 4
    //   281: aload 7
    //   283: aload_1
    //   284: ldc_w 554
    //   287: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   290: invokestatic 573	com/parse/ParsePushRouter:insertIntoHistory	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: iconst_1
    //   294: istore_3
    //   295: iload_3
    //   296: ifeq +7 -> 303
    //   299: aload_0
    //   300: invokestatic 95	com/parse/ParsePushRouter:saveStateToDisk	(Landroid/content/Context;)V
    //   303: aload_0
    //   304: aload 6
    //   306: aload_1
    //   307: ldc_w 575
    //   310: invokevirtual 311	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   313: invokestatic 577	com/parse/ParsePushRouter:handlePushData	(Lcom/parse/PushService;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   316: return
    //   317: iload_2
    //   318: istore_3
    //   319: iload_2
    //   320: istore 4
    //   322: aload_1
    //   323: ldc_w 554
    //   326: invokevirtual 346	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   329: ifeq -34 -> 295
    //   332: iload_2
    //   333: istore 4
    //   335: getstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   338: ifnull +24 -> 362
    //   341: iload_2
    //   342: istore_3
    //   343: iload_2
    //   344: istore 4
    //   346: aload_1
    //   347: ldc_w 554
    //   350: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   353: getstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   356: invokevirtual 520	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   359: ifle -64 -> 295
    //   362: iload_2
    //   363: istore 4
    //   365: aload_1
    //   366: ldc_w 554
    //   369: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   372: putstatic 80	com/parse/ParsePushRouter:lastTime	Ljava/lang/String;
    //   375: iconst_1
    //   376: istore_3
    //   377: goto -82 -> 295
    //   380: astore_1
    //   381: iload 4
    //   383: ifeq +7 -> 390
    //   386: aload_0
    //   387: invokestatic 95	com/parse/ParsePushRouter:saveStateToDisk	(Landroid/content/Context;)V
    //   390: aload_1
    //   391: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramPushService	PushService
    //   0	392	1	paramJSONObject	JSONObject
    //   1	362	2	i	int
    //   6	371	3	j	int
    //   19	363	4	k	int
    //   3	59	5	m	int
    //   15	290	6	str1	String
    //   225	57	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   21	31	380	finally
    //   35	41	380	finally
    //   45	61	380	finally
    //   65	75	380	finally
    //   82	88	380	finally
    //   93	109	380	finally
    //   112	137	380	finally
    //   154	163	380	finally
    //   166	193	380	finally
    //   205	215	380	finally
    //   218	227	380	finally
    //   230	241	380	finally
    //   244	269	380	finally
    //   281	293	380	finally
    //   322	332	380	finally
    //   335	341	380	finally
    //   346	362	380	finally
    //   365	375	380	finally
  }
  
  private static void saveEventually(Context paramContext, final ParseInstallation paramParseInstallation)
  {
    paramParseInstallation.saveEventually(new SaveCallback()
    {
      public void done(ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException != null)
        {
          Parse.logE("com.parse.ParsePushRouter", "Failed to save installation eventually", paramAnonymousParseException);
          return;
        }
        ParsePushRouter.ensureStateIsLoaded(ParsePushRouter.this);
        try
        {
          ParsePushRouter.channels.clear();
          paramAnonymousParseException = paramParseInstallation.getList("channels");
          ParsePushRouter.channels.addAll(paramAnonymousParseException);
          if (!ParsePushRouter.hasRoutes(ParsePushRouter.this))
          {
            Parse.logD("com.parse.ParsePushRouter", "Shutting down push service. No remaining channels");
            ParsePushRouter.this.stopService(new Intent(ParsePushRouter.this, PushService.class));
          }
          new BackgroundTask(null)
          {
            public Void run()
              throws ParseException
            {
              ParsePushRouter.saveStateToDisk(this.val$context);
              return null;
            }
          }.execute(new Void[0]);
          return;
        }
        finally {}
      }
    });
  }
  
  private static void saveStateToDisk(Context paramContext)
  {
    for (;;)
    {
      try
      {
        ensureStateIsLoaded(paramContext);
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("version", 3);
          if (defaultRoute != null) {
            localJSONObject1.putOpt("defaultRoute", defaultRoute.toJSON());
          }
          localJSONObject2 = new JSONObject();
          localIterator = channelRoutes.keySet().iterator();
          if (localIterator.hasNext()) {
            continue;
          }
          localJSONObject1.putOpt("routes", localJSONObject2);
          localJSONObject1.put("channels", new JSONArray(channels));
          localJSONObject1.putOpt("lastTime", lastTime);
          localJSONObject1.putOpt("history", history);
          localJSONObject1.putOpt("ignoreAfter", ignoreAfter);
          ParseObject.saveDiskObject(paramContext, "pushState", localJSONObject1);
        }
        catch (JSONException paramContext)
        {
          JSONObject localJSONObject2;
          Iterator localIterator;
          String str;
          Parse.logE("com.parse.ParsePushRouter", "Failed to save push routes to disk" + paramContext.getMessage());
          continue;
        }
        return;
      }
      finally {}
      str = (String)localIterator.next();
      localJSONObject2.putOpt(str, ((CallbackFactory)channelRoutes.get(str)).toJSON());
    }
  }
  
  static void setDefaultRoute(Context paramContext, Class<? extends Activity> paramClass, int paramInt)
  {
    ensureStateIsLoaded(paramContext);
    if (paramClass == null) {}
    for (defaultRoute = null;; defaultRoute = new CallbackFactory(StandardPushCallback.class, paramClass))
    {
      saveStateToDisk(paramContext);
      return;
      JSONObject localJSONObject = dataForActivity(paramContext, paramClass, paramInt);
      paramClass = localJSONObject;
      if (localJSONObject == null) {
        paramClass = new JSONObject();
      }
    }
  }
  
  static class CallbackFactory
  {
    Class<? extends PushCallback> clazz;
    JSONObject contextData;
    
    protected CallbackFactory() {}
    
    CallbackFactory(Class<? extends PushCallback> paramClass, JSONObject paramJSONObject)
    {
      this.clazz = paramClass;
      this.contextData = paramJSONObject;
    }
    
    CallbackFactory(JSONObject paramJSONObject)
      throws ClassNotFoundException
    {
      Parse.logD("com.parse.ParsePushRouter", "Creating factory for class " + paramJSONObject.optString("name"));
      this.clazz = Class.forName(paramJSONObject.optString("name"));
      if (this.clazz == null) {
        throw new ClassNotFoundException("Missing class definition in " + paramJSONObject);
      }
      this.contextData = paramJSONObject.optJSONObject("data");
    }
    
    PushCallback newCallback()
      throws IllegalAccessException, InstantiationException
    {
      PushCallback localPushCallback = (PushCallback)this.clazz.newInstance();
      localPushCallback.setLocalData(this.contextData);
      return localPushCallback;
    }
    
    boolean requiresSubscription()
    {
      return true;
    }
    
    JSONObject toJSON()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("name", this.clazz.getCanonicalName());
        localJSONObject.putOpt("data", this.contextData);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        Parse.logE("com.parse.ParsePushRouter", "Failed to encode route: " + localJSONException.getMessage());
      }
      return null;
    }
  }
  
  static class SingletonFactory
    extends ParsePushRouter.CallbackFactory
  {
    PushCallback singleton;
    
    SingletonFactory(PushCallback paramPushCallback)
    {
      this.singleton = paramPushCallback;
    }
    
    PushCallback newCallback()
    {
      return this.singleton;
    }
    
    boolean requiresSubscription()
    {
      return false;
    }
    
    JSONObject toJSON()
    {
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParsePushRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */