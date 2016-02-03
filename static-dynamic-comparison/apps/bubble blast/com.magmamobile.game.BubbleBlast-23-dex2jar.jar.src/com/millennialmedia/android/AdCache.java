package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import java.io.File;
import java.io.FileFilter;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class AdCache
{
  private static final String CACHED_AD_FILE = "ad.dat";
  private static final String CACHE_INCOMPLETE_PREFIX = "incompleteDownload_";
  private static final String CACHE_PREFIX = "nextCachedAd_";
  private static final String CACHE_PREFIX_APID = "nextCachedAd_apids";
  static final int ITERATE_ID = 0;
  static final int ITERATE_INFO = 1;
  static final int ITERATE_OBJECT = 2;
  private static final String LOCK_FILE = "ad.lock";
  static final int PRIORITY_FETCH = 3;
  static final int PRIORITY_PRECACHE = 1;
  static final int PRIORITY_REFRESH = 2;
  private static Set<String> apidListSet;
  private static String cachedVideoList;
  private static boolean cachedVideoListLoaded;
  private static HashSet cachedVideoSet;
  private static Map<String, String> incompleteDownloadHashMap;
  private static boolean incompleteDownloadHashMapLoaded;
  private static Map<String, String> nextCachedAdHashMap;
  private static boolean nextCachedAdHashMapLoaded;
  
  static void cachedVideoWasAdded(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!cachedVideoListLoaded) {
        getCachedVideoList(paramContext);
      }
      if (cachedVideoSet == null) {
        cachedVideoSet = new HashSet();
      }
      cachedVideoSet.add(paramString);
      cachedVideoList = null;
      return;
    }
    finally {}
  }
  
  static void cachedVideoWasRemoved(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!cachedVideoListLoaded) {
        getCachedVideoList(paramContext);
      }
      if (cachedVideoSet != null)
      {
        cachedVideoSet.remove(paramString);
        cachedVideoList = null;
      }
      return;
    }
    finally {}
  }
  
  static void cleanUpExpiredAds(Context paramContext)
  {
    iterateCachedAds(paramContext, 1, new Iterator()
    {
      boolean callback(String paramAnonymousString1, int paramAnonymousInt, Date paramAnonymousDate, String paramAnonymousString2, long paramAnonymousLong, ObjectInputStream paramAnonymousObjectInputStream)
      {
        if ((paramAnonymousDate != null) && (paramAnonymousDate.getTime() <= System.currentTimeMillis())) {}
        try
        {
          paramAnonymousDate = (CachedAd)paramAnonymousObjectInputStream.readObject();
          MMAdViewSDK.Log.d("Deleting expired ad %s.", new Object[] { paramAnonymousDate.id });
          paramAnonymousDate.delete(this.val$context);
          return true;
        }
        catch (Exception paramAnonymousDate)
        {
          MMAdViewSDK.Log.d("There was a problem reading the cached ad %s.", new Object[] { paramAnonymousString1 });
          MMAdViewSDK.Log.d(paramAnonymousDate);
        }
        return true;
      }
    });
  }
  
  /* Error */
  static boolean downloadComponent(String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: new 105	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: aload_1
    //   6: invokespecial 108	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   9: astore 15
    //   11: ldc 110
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: aastore
    //   25: invokestatic 116	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload 15
    //   30: invokevirtual 120	java/io/File:exists	()Z
    //   33: ifeq +41 -> 74
    //   36: aload 15
    //   38: invokevirtual 124	java/io/File:length	()J
    //   41: lconst_0
    //   42: lcmp
    //   43: ifle +31 -> 74
    //   46: new 126	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc -123
    //   59: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 140	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
    //   68: iconst_1
    //   69: istore 4
    //   71: iload 4
    //   73: ireturn
    //   74: aconst_null
    //   75: astore 14
    //   77: aconst_null
    //   78: astore 13
    //   80: aconst_null
    //   81: astore 11
    //   83: aconst_null
    //   84: astore 12
    //   86: ldc2_w 141
    //   89: lstore 5
    //   91: aload 11
    //   93: astore 9
    //   95: aload 13
    //   97: astore_2
    //   98: aload 14
    //   100: astore 10
    //   102: new 144	java/net/URL
    //   105: dup
    //   106: aload_0
    //   107: invokespecial 146	java/net/URL:<init>	(Ljava/lang/String;)V
    //   110: astore_0
    //   111: aload 11
    //   113: astore 9
    //   115: aload 13
    //   117: astore_2
    //   118: aload 14
    //   120: astore 10
    //   122: iconst_1
    //   123: invokestatic 152	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   126: aload 11
    //   128: astore 9
    //   130: aload 13
    //   132: astore_2
    //   133: aload 14
    //   135: astore 10
    //   137: aload_0
    //   138: invokevirtual 156	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   141: checkcast 148	java/net/HttpURLConnection
    //   144: astore 16
    //   146: aload 11
    //   148: astore 9
    //   150: aload 13
    //   152: astore_2
    //   153: aload 14
    //   155: astore 10
    //   157: aload 16
    //   159: sipush 30000
    //   162: invokevirtual 160	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   165: aload 11
    //   167: astore 9
    //   169: aload 13
    //   171: astore_2
    //   172: aload 14
    //   174: astore 10
    //   176: aload 16
    //   178: ldc -94
    //   180: invokevirtual 165	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   183: aload 11
    //   185: astore 9
    //   187: aload 13
    //   189: astore_2
    //   190: aload 14
    //   192: astore 10
    //   194: aload 16
    //   196: invokevirtual 168	java/net/HttpURLConnection:connect	()V
    //   199: aload 11
    //   201: astore 9
    //   203: aload 13
    //   205: astore_2
    //   206: aload 14
    //   208: astore 10
    //   210: aload 16
    //   212: invokevirtual 172	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   215: astore_0
    //   216: aload 11
    //   218: astore 9
    //   220: aload_0
    //   221: astore_2
    //   222: aload_0
    //   223: astore 10
    //   225: aload 16
    //   227: ldc -82
    //   229: invokevirtual 178	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 13
    //   234: aload 13
    //   236: ifnull +19 -> 255
    //   239: aload 11
    //   241: astore 9
    //   243: aload_0
    //   244: astore_2
    //   245: aload_0
    //   246: astore 10
    //   248: aload 13
    //   250: invokestatic 184	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   253: lstore 5
    //   255: aload_0
    //   256: ifnonnull +78 -> 334
    //   259: aload 11
    //   261: astore 9
    //   263: aload_0
    //   264: astore_2
    //   265: aload_0
    //   266: astore 10
    //   268: ldc -70
    //   270: iconst_1
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_1
    //   277: aastore
    //   278: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: iconst_0
    //   282: istore 4
    //   284: aload_0
    //   285: ifnull +7 -> 292
    //   288: aload_0
    //   289: invokevirtual 194	java/io/InputStream:close	()V
    //   292: iconst_0
    //   293: ifeq -222 -> 71
    //   296: new 196	java/lang/NullPointerException
    //   299: dup
    //   300: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   303: athrow
    //   304: astore_0
    //   305: ldc -57
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload_0
    //   314: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   317: aastore
    //   318: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aload 15
    //   323: ifnull +9 -> 332
    //   326: aload 15
    //   328: invokevirtual 205	java/io/File:delete	()Z
    //   331: pop
    //   332: iconst_0
    //   333: ireturn
    //   334: aload 11
    //   336: astore 9
    //   338: aload_0
    //   339: astore_2
    //   340: aload_0
    //   341: astore 10
    //   343: new 207	java/io/FileOutputStream
    //   346: dup
    //   347: aload 15
    //   349: invokespecial 210	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   352: astore 11
    //   354: sipush 1024
    //   357: newarray <illegal type>
    //   359: astore_2
    //   360: aload_0
    //   361: aload_2
    //   362: invokevirtual 214	java/io/InputStream:read	([B)I
    //   365: istore_3
    //   366: iload_3
    //   367: ifgt +85 -> 452
    //   370: aload 15
    //   372: ifnull +164 -> 536
    //   375: aload 15
    //   377: invokevirtual 124	java/io/File:length	()J
    //   380: lstore 7
    //   382: lload 7
    //   384: lload 5
    //   386: lcmp
    //   387: ifeq +12 -> 399
    //   390: lload 5
    //   392: ldc2_w 141
    //   395: lcmp
    //   396: ifne +135 -> 531
    //   399: iconst_1
    //   400: istore 4
    //   402: aload_0
    //   403: ifnull +7 -> 410
    //   406: aload_0
    //   407: invokevirtual 194	java/io/InputStream:close	()V
    //   410: aload 11
    //   412: ifnull -341 -> 71
    //   415: aload 11
    //   417: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   420: iconst_1
    //   421: ireturn
    //   422: astore_0
    //   423: ldc -57
    //   425: iconst_1
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: aload_0
    //   432: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   435: aastore
    //   436: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: aload 15
    //   441: ifnull +9 -> 450
    //   444: aload 15
    //   446: invokevirtual 205	java/io/File:delete	()Z
    //   449: pop
    //   450: iconst_0
    //   451: ireturn
    //   452: aload 11
    //   454: aload_2
    //   455: iconst_0
    //   456: iload_3
    //   457: invokevirtual 219	java/io/FileOutputStream:write	([BII)V
    //   460: goto -100 -> 360
    //   463: astore_2
    //   464: aload_0
    //   465: astore 10
    //   467: aload 11
    //   469: astore_0
    //   470: aload_2
    //   471: astore 11
    //   473: aload_0
    //   474: astore 9
    //   476: aload 10
    //   478: astore_2
    //   479: ldc -35
    //   481: iconst_2
    //   482: anewarray 4	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: aload_1
    //   488: aastore
    //   489: dup
    //   490: iconst_1
    //   491: aload 11
    //   493: invokevirtual 222	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   496: aastore
    //   497: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload 10
    //   502: ifnull +8 -> 510
    //   505: aload 10
    //   507: invokevirtual 194	java/io/InputStream:close	()V
    //   510: aload_0
    //   511: ifnull +7 -> 518
    //   514: aload_0
    //   515: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   518: aload 15
    //   520: ifnull +9 -> 529
    //   523: aload 15
    //   525: invokevirtual 205	java/io/File:delete	()Z
    //   528: pop
    //   529: iconst_0
    //   530: ireturn
    //   531: ldc -32
    //   533: invokestatic 226	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;)V
    //   536: aload_0
    //   537: ifnull +7 -> 544
    //   540: aload_0
    //   541: invokevirtual 194	java/io/InputStream:close	()V
    //   544: aload 11
    //   546: ifnull +8 -> 554
    //   549: aload 11
    //   551: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   554: goto -36 -> 518
    //   557: astore_2
    //   558: ldc -35
    //   560: iconst_2
    //   561: anewarray 4	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: aload_1
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: aload_2
    //   571: invokevirtual 227	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   574: aastore
    //   575: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: goto -42 -> 536
    //   581: astore_1
    //   582: aload 11
    //   584: astore 9
    //   586: aload_0
    //   587: ifnull +7 -> 594
    //   590: aload_0
    //   591: invokevirtual 194	java/io/InputStream:close	()V
    //   594: aload 9
    //   596: ifnull +8 -> 604
    //   599: aload 9
    //   601: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   604: aload_1
    //   605: athrow
    //   606: astore_0
    //   607: ldc -57
    //   609: iconst_1
    //   610: anewarray 4	java/lang/Object
    //   613: dup
    //   614: iconst_0
    //   615: aload_0
    //   616: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   619: aastore
    //   620: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   623: aload 15
    //   625: ifnull +9 -> 634
    //   628: aload 15
    //   630: invokevirtual 205	java/io/File:delete	()Z
    //   633: pop
    //   634: iconst_0
    //   635: ireturn
    //   636: astore_0
    //   637: ldc -57
    //   639: iconst_1
    //   640: anewarray 4	java/lang/Object
    //   643: dup
    //   644: iconst_0
    //   645: aload_0
    //   646: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   649: aastore
    //   650: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   653: aload 15
    //   655: ifnull +9 -> 664
    //   658: aload 15
    //   660: invokevirtual 205	java/io/File:delete	()Z
    //   663: pop
    //   664: iconst_0
    //   665: ireturn
    //   666: astore_0
    //   667: ldc -57
    //   669: iconst_1
    //   670: anewarray 4	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: aload_0
    //   676: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   679: aastore
    //   680: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   683: aload 15
    //   685: ifnull +9 -> 694
    //   688: aload 15
    //   690: invokevirtual 205	java/io/File:delete	()Z
    //   693: pop
    //   694: iconst_0
    //   695: ireturn
    //   696: astore_1
    //   697: aload_2
    //   698: astore_0
    //   699: goto -113 -> 586
    //   702: astore 11
    //   704: aload 12
    //   706: astore_0
    //   707: goto -234 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	paramString1	String
    //   0	710	1	paramString2	String
    //   0	710	2	paramFile	File
    //   365	92	3	i	int
    //   69	332	4	bool	boolean
    //   89	302	5	l1	long
    //   380	3	7	l2	long
    //   93	507	9	localObject1	Object
    //   100	406	10	localObject2	Object
    //   81	502	11	localObject3	Object
    //   702	1	11	localException	Exception
    //   84	621	12	localObject4	Object
    //   78	171	13	str	String
    //   75	132	14	localObject5	Object
    //   9	680	15	localFile	File
    //   144	82	16	localHttpURLConnection	java.net.HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   288	292	304	java/io/IOException
    //   296	304	304	java/io/IOException
    //   406	410	422	java/io/IOException
    //   415	420	422	java/io/IOException
    //   354	360	463	java/lang/Exception
    //   360	366	463	java/lang/Exception
    //   375	382	463	java/lang/Exception
    //   452	460	463	java/lang/Exception
    //   531	536	463	java/lang/Exception
    //   558	578	463	java/lang/Exception
    //   375	382	557	java/lang/SecurityException
    //   531	536	557	java/lang/SecurityException
    //   354	360	581	finally
    //   360	366	581	finally
    //   375	382	581	finally
    //   452	460	581	finally
    //   531	536	581	finally
    //   558	578	581	finally
    //   540	544	606	java/io/IOException
    //   549	554	606	java/io/IOException
    //   505	510	636	java/io/IOException
    //   514	518	636	java/io/IOException
    //   590	594	666	java/io/IOException
    //   599	604	666	java/io/IOException
    //   102	111	696	finally
    //   122	126	696	finally
    //   137	146	696	finally
    //   157	165	696	finally
    //   176	183	696	finally
    //   194	199	696	finally
    //   210	216	696	finally
    //   225	234	696	finally
    //   248	255	696	finally
    //   268	281	696	finally
    //   343	354	696	finally
    //   479	500	696	finally
    //   102	111	702	java/lang/Exception
    //   122	126	702	java/lang/Exception
    //   137	146	702	java/lang/Exception
    //   157	165	702	java/lang/Exception
    //   176	183	702	java/lang/Exception
    //   194	199	702	java/lang/Exception
    //   210	216	702	java/lang/Exception
    //   225	234	702	java/lang/Exception
    //   248	255	702	java/lang/Exception
    //   268	281	702	java/lang/Exception
    //   343	354	702	java/lang/Exception
  }
  
  static File getCacheDirectory(Context paramContext)
  {
    return getCacheDirectory(paramContext, null);
  }
  
  static File getCacheDirectory(Context paramContext, boolean[] paramArrayOfBoolean)
  {
    Object localObject2 = null;
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localObject1 = new File(Environment.getExternalStorageDirectory(), ".mmsyscache");
        localObject2 = localObject1;
      }
    }
    catch (Exception paramContext)
    {
      Object localObject1;
      boolean bool;
      label51:
      MMAdViewSDK.Log.e(paramContext);
      return null;
    }
    try
    {
      if (((File)localObject1).exists()) {
        break label159;
      }
      localObject2 = localObject1;
      bool = ((File)localObject1).mkdirs();
      if (bool) {
        break label159;
      }
      localObject1 = null;
    }
    catch (Exception paramContext)
    {
      break label146;
      break label143;
      break label51;
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (paramArrayOfBoolean != null)
      {
        paramArrayOfBoolean[0] = true;
        localObject2 = localObject1;
      }
    }
    localObject1 = localObject2;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      paramContext = paramContext.getCacheDir();
      if (paramContext != null)
      {
        localObject2 = localObject1;
        localObject1 = new File(paramContext, ".mmsyscache");
        paramContext = (Context)localObject1;
        if (!((File)localObject1).exists())
        {
          paramContext = (Context)localObject1;
          if (!((File)localObject1).mkdirs()) {
            paramContext = null;
          }
        }
        localObject1 = paramContext;
        if (paramContext != null)
        {
          localObject1 = paramContext;
          if (paramArrayOfBoolean != null)
          {
            paramArrayOfBoolean[0] = false;
            localObject1 = paramContext;
          }
        }
        label143:
        return (File)localObject1;
      }
    }
  }
  
  static File getCachedAdFile(Context paramContext, String paramString)
  {
    return getCachedAdFile(paramContext, paramString, null);
  }
  
  static File getCachedAdFile(Context paramContext, String paramString, boolean[] paramArrayOfBoolean)
  {
    boolean[] arrayOfBoolean = new boolean[1];
    File localFile = getCacheDirectory(paramContext, arrayOfBoolean);
    Object localObject2 = null;
    if (paramArrayOfBoolean != null) {
      paramArrayOfBoolean[0] = arrayOfBoolean[0];
    }
    Object localObject1 = localObject2;
    if (localFile != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (localFile.isDirectory()) {
        localObject1 = new File(localFile, paramString + "ad.dat");
      }
      if (((localObject1 == null) || (!((File)localObject1).exists())) && (arrayOfBoolean[0] != 0))
      {
        paramContext = paramContext.getCacheDir();
        if (paramContext != null)
        {
          paramContext = new File(paramContext, ".mmsyscache" + File.separator + paramString + "ad.dat");
          if ((paramContext.exists()) && (paramContext.isFile()))
          {
            if (paramArrayOfBoolean != null) {
              paramArrayOfBoolean[0] = false;
            }
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      MMAdViewSDK.Log.e(paramContext);
      return null;
    }
    return (File)localObject1;
  }
  
  static String getCachedVideoList(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (cachedVideoList != null) {
          break label154;
        }
        if (!cachedVideoListLoaded)
        {
          localObject1 = new HashSet();
          iterateCachedAds(paramContext, 2, new Iterator()
          {
            boolean callback(CachedAd paramAnonymousCachedAd)
            {
              if ((paramAnonymousCachedAd.acid != null) && (paramAnonymousCachedAd.getType() == 1) && (paramAnonymousCachedAd.isOnDisk(this.val$context))) {
                localObject1.add(paramAnonymousCachedAd.acid);
              }
              return true;
            }
          });
          cachedVideoSet = (HashSet)localObject1;
          cachedVideoListLoaded = true;
        }
        if ((cachedVideoSet == null) || (cachedVideoSet.size() <= 0)) {
          break label154;
        }
        paramContext = new StringBuilder();
        final Object localObject1 = cachedVideoSet.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (paramContext.length() > 0) {
          paramContext.append("," + (String)localObject2);
        } else {
          paramContext.append((String)localObject2);
        }
      }
      finally {}
    }
    cachedVideoList = paramContext.toString();
    label154:
    paramContext = cachedVideoList;
    return paramContext;
  }
  
  /* Error */
  static String getIncompleteDownload(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 303	com/millennialmedia/android/AdCache:incompleteDownloadHashMapLoaded	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokestatic 306	com/millennialmedia/android/AdCache:loadIncompleteDownloadHashMap	(Landroid/content/Context;)V
    //   13: aload_1
    //   14: ifnonnull +10 -> 24
    //   17: aconst_null
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: getstatic 308	com/millennialmedia/android/AdCache:incompleteDownloadHashMap	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 314 2 0
    //   33: checkcast 241	java/lang/String
    //   36: astore_0
    //   37: goto -18 -> 19
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   0	46	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	13	40	finally
    //   24	37	40	finally
  }
  
  /* Error */
  static String getNextCachedAd(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 317	com/millennialmedia/android/AdCache:nextCachedAdHashMapLoaded	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokestatic 320	com/millennialmedia/android/AdCache:loadNextCachedAdHashMap	(Landroid/content/Context;)V
    //   13: aload_1
    //   14: ifnonnull +10 -> 24
    //   17: aconst_null
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: getstatic 322	com/millennialmedia/android/AdCache:nextCachedAdHashMap	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 314 2 0
    //   33: checkcast 241	java/lang/String
    //   36: astore_0
    //   37: goto -18 -> 19
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   0	46	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	13	40	finally
    //   24	37	40	finally
  }
  
  /* Error */
  static void iterateCachedAds(Context paramContext, int paramInt, Iterator paramIterator)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 324	com/millennialmedia/android/AdCache:getCacheDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnull +104 -> 110
    //   9: aload_0
    //   10: new 8	com/millennialmedia/android/AdCache$2
    //   13: dup
    //   14: invokespecial 325	com/millennialmedia/android/AdCache$2:<init>	()V
    //   17: invokevirtual 329	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   20: astore 11
    //   22: aload 11
    //   24: arraylength
    //   25: istore 4
    //   27: iconst_0
    //   28: istore_3
    //   29: aconst_null
    //   30: astore_0
    //   31: iload_3
    //   32: iload 4
    //   34: if_icmpge +364 -> 398
    //   37: aload 11
    //   39: iload_3
    //   40: aaload
    //   41: astore 12
    //   43: aload 12
    //   45: ifnull +15 -> 60
    //   48: aload 12
    //   50: invokevirtual 120	java/io/File:exists	()Z
    //   53: istore 8
    //   55: iload 8
    //   57: ifne +25 -> 82
    //   60: aload_0
    //   61: ifnull +334 -> 395
    //   64: aload_0
    //   65: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   68: aconst_null
    //   69: astore_0
    //   70: iload_3
    //   71: iconst_1
    //   72: iadd
    //   73: istore_3
    //   74: goto -43 -> 31
    //   77: astore 9
    //   79: goto -9 -> 70
    //   82: iload_1
    //   83: ifne +48 -> 131
    //   86: aload_2
    //   87: aload 12
    //   89: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   92: invokevirtual 339	com/millennialmedia/android/AdCache$Iterator:callback	(Ljava/lang/String;)Z
    //   95: istore 8
    //   97: iload 8
    //   99: ifne +14 -> 113
    //   102: aload_0
    //   103: ifnull +295 -> 398
    //   106: aload_0
    //   107: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   110: return
    //   111: astore_0
    //   112: return
    //   113: aload_0
    //   114: ifnull +281 -> 395
    //   117: aload_0
    //   118: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -53 -> 70
    //   126: astore 9
    //   128: goto -58 -> 70
    //   131: new 331	java/io/ObjectInputStream
    //   134: dup
    //   135: new 341	java/io/FileInputStream
    //   138: dup
    //   139: aload 12
    //   141: invokespecial 342	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   144: invokespecial 345	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   147: astore 9
    //   149: aload 9
    //   151: astore_0
    //   152: aload 9
    //   154: invokevirtual 348	java/io/ObjectInputStream:readInt	()I
    //   157: istore 5
    //   159: aload 9
    //   161: astore_0
    //   162: aload 9
    //   164: invokevirtual 351	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   167: checkcast 353	java/util/Date
    //   170: astore 13
    //   172: aload 9
    //   174: astore_0
    //   175: aload 9
    //   177: invokevirtual 351	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   180: checkcast 241	java/lang/String
    //   183: astore 10
    //   185: aload 9
    //   187: astore_0
    //   188: aload 9
    //   190: invokevirtual 356	java/io/ObjectInputStream:readLong	()J
    //   193: lstore 6
    //   195: iload_1
    //   196: iconst_1
    //   197: if_icmpne +48 -> 245
    //   200: aload 9
    //   202: astore_0
    //   203: aload_2
    //   204: aload 12
    //   206: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   209: iload 5
    //   211: aload 13
    //   213: aload 10
    //   215: lload 6
    //   217: aload 9
    //   219: invokevirtual 359	com/millennialmedia/android/AdCache$Iterator:callback	(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;JLjava/io/ObjectInputStream;)Z
    //   222: ifne +61 -> 283
    //   225: aload 9
    //   227: astore_0
    //   228: aload 9
    //   230: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   233: iconst_0
    //   234: ifeq -124 -> 110
    //   237: new 196	java/lang/NullPointerException
    //   240: dup
    //   241: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   244: athrow
    //   245: aload 9
    //   247: astore_0
    //   248: aload_2
    //   249: aload 9
    //   251: invokevirtual 351	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   254: checkcast 361	com/millennialmedia/android/CachedAd
    //   257: invokevirtual 364	com/millennialmedia/android/AdCache$Iterator:callback	(Lcom/millennialmedia/android/CachedAd;)Z
    //   260: ifne +23 -> 283
    //   263: aload 9
    //   265: astore_0
    //   266: aload 9
    //   268: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   271: iconst_0
    //   272: ifeq -162 -> 110
    //   275: new 196	java/lang/NullPointerException
    //   278: dup
    //   279: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   282: athrow
    //   283: aload 9
    //   285: astore_0
    //   286: aload 9
    //   288: ifnull -218 -> 70
    //   291: aload 9
    //   293: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   296: aconst_null
    //   297: astore_0
    //   298: goto -228 -> 70
    //   301: astore 10
    //   303: aload_0
    //   304: astore 9
    //   306: aload 9
    //   308: astore_0
    //   309: ldc_w 366
    //   312: iconst_1
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload 12
    //   320: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   323: aastore
    //   324: invokestatic 369	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: aload 9
    //   329: astore_0
    //   330: aload 10
    //   332: invokestatic 371	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/Throwable;)V
    //   335: aload 9
    //   337: astore_0
    //   338: aload 9
    //   340: ifnull -270 -> 70
    //   343: aload 9
    //   345: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   348: aconst_null
    //   349: astore_0
    //   350: goto -280 -> 70
    //   353: astore_2
    //   354: aload_0
    //   355: ifnull +7 -> 362
    //   358: aload_0
    //   359: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   362: aload_2
    //   363: athrow
    //   364: astore_0
    //   365: return
    //   366: astore_0
    //   367: return
    //   368: astore_0
    //   369: aload 9
    //   371: astore_0
    //   372: goto -302 -> 70
    //   375: astore_0
    //   376: aload 9
    //   378: astore_0
    //   379: goto -309 -> 70
    //   382: astore_0
    //   383: goto -21 -> 362
    //   386: astore_2
    //   387: goto -33 -> 354
    //   390: astore 10
    //   392: goto -86 -> 306
    //   395: goto -325 -> 70
    //   398: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramContext	Context
    //   0	399	1	paramInt	int
    //   0	399	2	paramIterator	Iterator
    //   28	46	3	i	int
    //   25	10	4	j	int
    //   157	53	5	k	int
    //   193	23	6	l	long
    //   53	45	8	bool	boolean
    //   77	1	9	localIOException1	java.io.IOException
    //   126	1	9	localIOException2	java.io.IOException
    //   147	230	9	localObject	Object
    //   183	31	10	str	String
    //   301	30	10	localException1	Exception
    //   390	1	10	localException2	Exception
    //   20	18	11	arrayOfFile	File[]
    //   41	278	12	localFile	File
    //   170	42	13	localDate	Date
    // Exception table:
    //   from	to	target	type
    //   64	68	77	java/io/IOException
    //   106	110	111	java/io/IOException
    //   117	121	126	java/io/IOException
    //   48	55	301	java/lang/Exception
    //   86	97	301	java/lang/Exception
    //   131	149	301	java/lang/Exception
    //   48	55	353	finally
    //   86	97	353	finally
    //   131	149	353	finally
    //   237	245	364	java/io/IOException
    //   275	283	366	java/io/IOException
    //   291	296	368	java/io/IOException
    //   343	348	375	java/io/IOException
    //   358	362	382	java/io/IOException
    //   152	159	386	finally
    //   162	172	386	finally
    //   175	185	386	finally
    //   188	195	386	finally
    //   203	225	386	finally
    //   228	233	386	finally
    //   248	263	386	finally
    //   266	271	386	finally
    //   309	327	386	finally
    //   330	335	386	finally
    //   152	159	390	java/lang/Exception
    //   162	172	390	java/lang/Exception
    //   175	185	390	java/lang/Exception
    //   188	195	390	java/lang/Exception
    //   203	225	390	java/lang/Exception
    //   228	233	390	java/lang/Exception
    //   248	263	390	java/lang/Exception
    //   266	271	390	java/lang/Exception
  }
  
  /* Error */
  static CachedAd load(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_0
    //   6: aload_0
    //   7: areturn
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore_3
    //   27: iconst_1
    //   28: newarray <illegal type>
    //   30: astore 9
    //   32: aload_0
    //   33: aload_1
    //   34: aload 9
    //   36: invokestatic 266	com/millennialmedia/android/AdCache:getCachedAdFile	(Landroid/content/Context;Ljava/lang/String;[Z)Ljava/io/File;
    //   39: astore 10
    //   41: aload 10
    //   43: ifnonnull +5 -> 48
    //   46: aconst_null
    //   47: areturn
    //   48: aload_2
    //   49: astore_0
    //   50: new 331	java/io/ObjectInputStream
    //   53: dup
    //   54: new 341	java/io/FileInputStream
    //   57: dup
    //   58: aload 10
    //   60: invokespecial 342	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 345	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_2
    //   67: aload 4
    //   69: astore_0
    //   70: aload 6
    //   72: astore_3
    //   73: aload_2
    //   74: invokevirtual 348	java/io/ObjectInputStream:readInt	()I
    //   77: pop
    //   78: aload 4
    //   80: astore_0
    //   81: aload 6
    //   83: astore_3
    //   84: aload_2
    //   85: invokevirtual 351	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   88: checkcast 353	java/util/Date
    //   91: astore 5
    //   93: aload 4
    //   95: astore_0
    //   96: aload 6
    //   98: astore_3
    //   99: aload_2
    //   100: invokevirtual 351	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   103: pop
    //   104: aload 4
    //   106: astore_0
    //   107: aload 6
    //   109: astore_3
    //   110: aload_2
    //   111: invokevirtual 356	java/io/ObjectInputStream:readLong	()J
    //   114: pop2
    //   115: aload 4
    //   117: astore_0
    //   118: aload 6
    //   120: astore_3
    //   121: aload_2
    //   122: invokevirtual 351	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   125: checkcast 361	com/millennialmedia/android/CachedAd
    //   128: astore 4
    //   130: aload 4
    //   132: astore_0
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: aload 9
    //   140: iconst_0
    //   141: baload
    //   142: putfield 378	com/millennialmedia/android/CachedAd:storedOnSdCard	Z
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   153: aload 4
    //   155: areturn
    //   156: astore_0
    //   157: aload 4
    //   159: areturn
    //   160: astore_0
    //   161: aload 7
    //   163: astore_2
    //   164: aload_2
    //   165: astore_0
    //   166: ldc_w 380
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_1
    //   176: aastore
    //   177: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload_3
    //   181: astore_0
    //   182: aload_2
    //   183: ifnull -177 -> 6
    //   186: aload_2
    //   187: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   190: aload_3
    //   191: areturn
    //   192: astore_0
    //   193: aload_3
    //   194: areturn
    //   195: astore 4
    //   197: aload 8
    //   199: astore_3
    //   200: aload 5
    //   202: astore_2
    //   203: aload_3
    //   204: astore_0
    //   205: ldc_w 382
    //   208: iconst_1
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_1
    //   215: aastore
    //   216: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload_3
    //   220: astore_0
    //   221: aload 4
    //   223: invokevirtual 222	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokestatic 384	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   229: aload_3
    //   230: astore_0
    //   231: aload 4
    //   233: invokestatic 371	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/Throwable;)V
    //   236: aload_2
    //   237: astore_0
    //   238: aload_3
    //   239: ifnull -233 -> 6
    //   242: aload_3
    //   243: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   246: aload_2
    //   247: areturn
    //   248: astore_0
    //   249: aload_2
    //   250: areturn
    //   251: astore_1
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 332	java/io/ObjectInputStream:close	()V
    //   260: aload_1
    //   261: athrow
    //   262: astore_0
    //   263: goto -3 -> 260
    //   266: astore_1
    //   267: aload_2
    //   268: astore_0
    //   269: goto -17 -> 252
    //   272: astore 4
    //   274: aload_2
    //   275: astore_3
    //   276: aload_0
    //   277: astore_2
    //   278: goto -75 -> 203
    //   281: astore_0
    //   282: goto -118 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramContext	Context
    //   0	285	1	paramString	String
    //   12	266	2	localObject1	Object
    //   26	250	3	localObject2	Object
    //   20	138	4	localCachedAd	CachedAd
    //   195	37	4	localException1	Exception
    //   272	1	4	localException2	Exception
    //   17	184	5	localDate	Date
    //   23	96	6	localObject3	Object
    //   14	148	7	localObject4	Object
    //   9	189	8	localObject5	Object
    //   30	109	9	arrayOfBoolean	boolean[]
    //   39	20	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   149	153	156	java/io/IOException
    //   50	67	160	java/io/FileNotFoundException
    //   186	190	192	java/io/IOException
    //   50	67	195	java/lang/Exception
    //   242	246	248	java/io/IOException
    //   50	67	251	finally
    //   166	180	251	finally
    //   205	219	251	finally
    //   221	229	251	finally
    //   231	236	251	finally
    //   256	260	262	java/io/IOException
    //   73	78	266	finally
    //   84	93	266	finally
    //   99	104	266	finally
    //   110	115	266	finally
    //   121	130	266	finally
    //   136	145	266	finally
    //   73	78	272	java/lang/Exception
    //   84	93	272	java/lang/Exception
    //   99	104	272	java/lang/Exception
    //   110	115	272	java/lang/Exception
    //   121	130	272	java/lang/Exception
    //   136	145	272	java/lang/Exception
    //   73	78	281	java/io/FileNotFoundException
    //   84	93	281	java/io/FileNotFoundException
    //   99	104	281	java/io/FileNotFoundException
    //   110	115	281	java/io/FileNotFoundException
    //   121	130	281	java/io/FileNotFoundException
    //   136	145	281	java/io/FileNotFoundException
  }
  
  private static void loadApidListSet(SharedPreferences paramSharedPreferences)
  {
    apidListSet = new HashSet();
    paramSharedPreferences = paramSharedPreferences.getString("nextCachedAd_apids", null);
    if (paramSharedPreferences != null)
    {
      paramSharedPreferences = paramSharedPreferences.split(MMAdViewSDK.COMMA);
      if ((paramSharedPreferences != null) && (paramSharedPreferences.length > 0))
      {
        int j = paramSharedPreferences.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramSharedPreferences[i];
          apidListSet.add(localObject);
          i += 1;
        }
      }
    }
  }
  
  static CachedAd loadIncompleteDownload(Context paramContext, String paramString)
  {
    paramString = getIncompleteDownload(paramContext, paramString);
    if (paramString == null) {
      return null;
    }
    return load(paramContext, paramString);
  }
  
  private static void loadIncompleteDownloadHashMap(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
    incompleteDownloadHashMap = new ConcurrentHashMap();
    if (apidListSet == null) {
      loadApidListSet(paramContext);
    }
    Iterator localIterator = apidListSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String[] arrayOfString = MMAdView.getAdTypes();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        String str3 = paramContext.getString("incompleteDownload_" + str2 + '_' + str1, null);
        if (str3 != null) {
          incompleteDownloadHashMap.put(str2 + '_' + str1, str3);
        }
        i += 1;
      }
    }
    incompleteDownloadHashMapLoaded = true;
  }
  
  static CachedAd loadNextCachedAd(Context paramContext, String paramString)
  {
    paramString = getNextCachedAd(paramContext, paramString);
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return load(paramContext, paramString);
  }
  
  private static void loadNextCachedAdHashMap(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
    nextCachedAdHashMap = new ConcurrentHashMap();
    if (apidListSet == null) {
      loadApidListSet(paramContext);
    }
    Iterator localIterator = apidListSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String[] arrayOfString = MMAdView.getAdTypes();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        String str3 = paramContext.getString("nextCachedAd_" + str2 + '_' + str1, null);
        if (str3 != null) {
          nextCachedAdHashMap.put(str2 + '_' + str1, str3);
        }
        i += 1;
      }
    }
    nextCachedAdHashMapLoaded = true;
  }
  
  static void resetCache(Context paramContext)
  {
    iterateCachedAds(paramContext, 2, new Iterator()
    {
      boolean callback(CachedAd paramAnonymousCachedAd)
      {
        MMAdViewSDK.Log.d("Deleting ad %s.", new Object[] { paramAnonymousCachedAd.id });
        paramAnonymousCachedAd.delete(this.val$context);
        return true;
      }
    });
    cachedVideoSet = null;
    cachedVideoList = null;
    cachedVideoListLoaded = false;
    Iterator localIterator;
    if (nextCachedAdHashMap != null)
    {
      localIterator = nextCachedAdHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        setNextCachedAd(paramContext, (String)localIterator.next(), null);
      }
    }
    if (incompleteDownloadHashMap != null)
    {
      localIterator = incompleteDownloadHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        setIncompleteDownload(paramContext, (String)localIterator.next(), null);
      }
    }
  }
  
  /* Error */
  static boolean save(Context paramContext, CachedAd paramCachedAd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 5
    //   14: iconst_1
    //   15: newarray <illegal type>
    //   17: astore 8
    //   19: aload_1
    //   20: ifnonnull +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: aload_1
    //   27: getfield 459	com/millennialmedia/android/CachedAd:id	Ljava/lang/String;
    //   30: aload 8
    //   32: invokestatic 266	com/millennialmedia/android/AdCache:getCachedAdFile	(Landroid/content/Context;Ljava/lang/String;[Z)Ljava/io/File;
    //   35: astore 9
    //   37: aload 9
    //   39: ifnull -16 -> 23
    //   42: ldc_w 461
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: getfield 459	com/millennialmedia/android/CachedAd:id	Ljava/lang/String;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload 9
    //   60: aastore
    //   61: invokestatic 116	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: new 105	java/io/File
    //   67: dup
    //   68: aload 9
    //   70: invokevirtual 464	java/io/File:getParent	()Ljava/lang/String;
    //   73: new 126	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   80: aload_1
    //   81: getfield 459	com/millennialmedia/android/CachedAd:id	Ljava/lang/String;
    //   84: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 41
    //   89: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 467	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 470	java/io/File:createNewFile	()Z
    //   103: ifne +39 -> 142
    //   106: ldc_w 472
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: getfield 459	com/millennialmedia/android/CachedAd:id	Ljava/lang/String;
    //   119: aastore
    //   120: invokestatic 116	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_2
    //   124: invokevirtual 205	java/io/File:delete	()Z
    //   127: pop
    //   128: iconst_0
    //   129: ifeq +11 -> 140
    //   132: new 196	java/lang/NullPointerException
    //   135: dup
    //   136: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   139: athrow
    //   140: iconst_0
    //   141: ireturn
    //   142: new 474	java/io/ObjectOutputStream
    //   145: dup
    //   146: new 207	java/io/FileOutputStream
    //   149: dup
    //   150: aload 9
    //   152: invokespecial 210	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 477	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_3
    //   159: aload_3
    //   160: aload_1
    //   161: invokevirtual 480	com/millennialmedia/android/CachedAd:getType	()I
    //   164: invokevirtual 483	java/io/ObjectOutputStream:writeInt	(I)V
    //   167: aload_3
    //   168: aload_1
    //   169: getfield 487	com/millennialmedia/android/CachedAd:expiration	Ljava/util/Date;
    //   172: invokevirtual 491	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   175: aload_3
    //   176: aload_1
    //   177: getfield 494	com/millennialmedia/android/CachedAd:acid	Ljava/lang/String;
    //   180: invokevirtual 491	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   183: aload_3
    //   184: aload_1
    //   185: getfield 498	com/millennialmedia/android/CachedAd:deferredViewStart	J
    //   188: invokevirtual 502	java/io/ObjectOutputStream:writeLong	(J)V
    //   191: aload_3
    //   192: aload_1
    //   193: invokevirtual 491	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   196: aload_1
    //   197: aload 8
    //   199: iconst_0
    //   200: baload
    //   201: putfield 378	com/millennialmedia/android/CachedAd:storedOnSdCard	Z
    //   204: aload_2
    //   205: invokevirtual 205	java/io/File:delete	()Z
    //   208: pop
    //   209: aload_3
    //   210: ifnull +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 503	java/io/ObjectOutputStream:close	()V
    //   217: aload_1
    //   218: aload_0
    //   219: invokevirtual 507	com/millennialmedia/android/CachedAd:saveAssets	(Landroid/content/Context;)Z
    //   222: ifne +98 -> 320
    //   225: aload_1
    //   226: aload_0
    //   227: invokevirtual 509	com/millennialmedia/android/CachedAd:delete	(Landroid/content/Context;)V
    //   230: iconst_0
    //   231: ireturn
    //   232: astore_2
    //   233: aload 7
    //   235: astore_0
    //   236: aload_0
    //   237: astore_3
    //   238: aload 5
    //   240: astore 4
    //   242: ldc_w 511
    //   245: iconst_1
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload_1
    //   252: getfield 459	com/millennialmedia/android/CachedAd:id	Ljava/lang/String;
    //   255: aastore
    //   256: invokestatic 189	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload_0
    //   260: astore_3
    //   261: aload 5
    //   263: astore 4
    //   265: aload_2
    //   266: invokevirtual 222	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   269: invokestatic 384	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   272: aload_0
    //   273: astore_3
    //   274: aload 5
    //   276: astore 4
    //   278: aload_2
    //   279: invokestatic 371	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/Throwable;)V
    //   282: aload_0
    //   283: invokevirtual 205	java/io/File:delete	()Z
    //   286: pop
    //   287: aload 5
    //   289: ifnull -266 -> 23
    //   292: aload 5
    //   294: invokevirtual 503	java/io/ObjectOutputStream:close	()V
    //   297: iconst_0
    //   298: ireturn
    //   299: astore_0
    //   300: iconst_0
    //   301: ireturn
    //   302: astore_0
    //   303: aload_3
    //   304: invokevirtual 205	java/io/File:delete	()Z
    //   307: pop
    //   308: aload 4
    //   310: ifnull +8 -> 318
    //   313: aload 4
    //   315: invokevirtual 503	java/io/ObjectOutputStream:close	()V
    //   318: aload_0
    //   319: athrow
    //   320: iconst_1
    //   321: ireturn
    //   322: astore_1
    //   323: goto -5 -> 318
    //   326: astore_0
    //   327: aload_2
    //   328: astore_3
    //   329: aload 6
    //   331: astore 4
    //   333: goto -30 -> 303
    //   336: astore_0
    //   337: aload_3
    //   338: astore 4
    //   340: aload_2
    //   341: astore_3
    //   342: goto -39 -> 303
    //   345: astore_3
    //   346: aload_2
    //   347: astore_0
    //   348: aload_3
    //   349: astore_2
    //   350: goto -114 -> 236
    //   353: astore 4
    //   355: aload_2
    //   356: astore_0
    //   357: aload 4
    //   359: astore_2
    //   360: aload_3
    //   361: astore 5
    //   363: goto -127 -> 236
    //   366: astore_2
    //   367: goto -150 -> 217
    //   370: astore_0
    //   371: goto -231 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramContext	Context
    //   0	374	1	paramCachedAd	CachedAd
    //   98	107	2	localFile1	File
    //   232	115	2	localException1	Exception
    //   349	11	2	localException2	Exception
    //   366	1	2	localIOException	java.io.IOException
    //   1	341	3	localObject1	Object
    //   345	16	3	localException3	Exception
    //   6	333	4	localObject2	Object
    //   353	5	4	localException4	Exception
    //   12	350	5	localException5	Exception
    //   9	321	6	localObject3	Object
    //   3	231	7	localObject4	Object
    //   17	181	8	arrayOfBoolean	boolean[]
    //   35	116	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   64	99	232	java/lang/Exception
    //   282	287	299	java/io/IOException
    //   292	297	299	java/io/IOException
    //   64	99	302	finally
    //   242	259	302	finally
    //   265	272	302	finally
    //   278	282	302	finally
    //   303	308	322	java/io/IOException
    //   313	318	322	java/io/IOException
    //   99	123	326	finally
    //   142	159	326	finally
    //   159	204	336	finally
    //   99	123	345	java/lang/Exception
    //   142	159	345	java/lang/Exception
    //   159	204	353	java/lang/Exception
    //   204	209	366	java/io/IOException
    //   213	217	366	java/io/IOException
    //   123	128	370	java/io/IOException
    //   132	140	370	java/io/IOException
  }
  
  private static void saveApidListSet(SharedPreferences.Editor paramEditor, String paramString)
  {
    int i = paramString.indexOf('_');
    String str;
    StringBuilder localStringBuilder;
    if ((i >= 0) && (i < paramString.length()))
    {
      str = paramString.substring(i + 1);
      if ((str != null) && (!apidListSet.contains(str)))
      {
        paramString = null;
        if (!apidListSet.isEmpty())
        {
          Iterator localIterator = apidListSet.iterator();
          localStringBuilder = new StringBuilder();
          for (;;)
          {
            paramString = localStringBuilder;
            if (!localIterator.hasNext()) {
              break;
            }
            localStringBuilder.append((String)localIterator.next() + MMAdViewSDK.COMMA);
          }
        }
        localStringBuilder = new StringBuilder();
        if (paramString != null) {
          break label176;
        }
      }
    }
    label176:
    for (paramString = "";; paramString = paramString.toString())
    {
      paramEditor.putString("nextCachedAd_apids", paramString + str);
      apidListSet.add(str);
      return;
    }
  }
  
  private static void saveIncompleteDownloadHashMap(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
      saveApidListSet(paramContext, paramString);
      paramContext.putString("incompleteDownload_" + paramString, (String)incompleteDownloadHashMap.get(paramString));
      paramContext.commit();
    }
  }
  
  private static void saveNextCachedAdHashMapValue(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
      saveApidListSet(paramContext, paramString);
      paramContext.putString("nextCachedAd_" + paramString, (String)nextCachedAdHashMap.get(paramString));
      paramContext.commit();
    }
  }
  
  static void setIncompleteDownload(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (!incompleteDownloadHashMapLoaded) {
        loadIncompleteDownloadHashMap(paramContext);
      }
      if (paramString1 != null)
      {
        Map localMap = incompleteDownloadHashMap;
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        localMap.put(paramString1, str);
        saveIncompleteDownloadHashMap(paramContext, paramString1);
      }
      return;
    }
    finally {}
  }
  
  static void setNextCachedAd(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (!nextCachedAdHashMapLoaded) {
        loadNextCachedAdHashMap(paramContext);
      }
      if (paramString1 != null)
      {
        Map localMap = nextCachedAdHashMap;
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        localMap.put(paramString1, str);
        saveNextCachedAdHashMapValue(paramContext, paramString1);
      }
      return;
    }
    finally {}
  }
  
  static void startDownloadTask(Context paramContext, String paramString, CachedAd paramCachedAd, AdCacheTaskListener paramAdCacheTaskListener)
  {
    AdCacheThreadPool.sharedThreadPool().startDownloadTask(paramContext, paramString, paramCachedAd, paramAdCacheTaskListener);
  }
  
  static abstract interface AdCacheTaskListener
  {
    public abstract void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean);
  }
  
  static class Iterator
  {
    boolean callback(CachedAd paramCachedAd)
    {
      return false;
    }
    
    boolean callback(String paramString)
    {
      return false;
    }
    
    boolean callback(String paramString1, int paramInt, Date paramDate, String paramString2, long paramLong, ObjectInputStream paramObjectInputStream)
    {
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/AdCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */