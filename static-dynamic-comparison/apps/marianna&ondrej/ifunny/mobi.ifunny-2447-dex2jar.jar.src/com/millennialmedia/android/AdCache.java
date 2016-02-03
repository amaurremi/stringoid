package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class AdCache {
    static boolean a = true;
    private static Set<String> b;
    private static String c;
    private static boolean d;
    private static Map<String, String> e;
    private static Set<String> f;
    private static boolean g;
    private static Map<String, String> h;
    private static boolean i;

    static String a(Context paramContext) {
        for (; ; ) {
            try {
                if (c != null) {
                    break label160;
                }
                if (!d) {
                    localObject = new HashSet();
                    a(paramContext, 2, new AdCache .1 (paramContext, (Set) localObject));
                    b = (Set) localObject;
                    d = true;
                }
                if ((b == null) || (b.size() <= 0)) {
                    break label160;
                }
                paramContext = new StringBuilder();
                Object localObject = b.iterator();
                if (!((Iterator) localObject).hasNext()) {
                    break;
                }
                String str = (String) ((Iterator) localObject).next();
                if (paramContext.length() > 0) {
                    paramContext.append("," + (String) str);
                } else {
                    paramContext.append((String) str);
                }
            } finally {
            }
        }
        c = paramContext.toString();
        label160:
        paramContext = c;
        return paramContext;
    }

    /* Error */
    static void a(Context paramContext, int paramInt, AdCache.Iterator paramIterator) {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic 90	com/millennialmedia/android/AdCache:h	(Landroid/content/Context;)Ljava/io/File;
        //   4: astore_0
        //   5: aload_0
        //   6: ifnull +124 -> 130
        //   9: aload_0
        //   10: new 92	com/millennialmedia/android/AdCache$2
        //   13: dup
        //   14: invokespecial 93	com/millennialmedia/android/AdCache$2:<init>	()V
        //   17: invokevirtual 99	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
        //   20: astore 11
        //   22: aload 11
        //   24: ifnull +106 -> 130
        //   27: aload 11
        //   29: arraylength
        //   30: istore 4
        //   32: iconst_0
        //   33: istore_3
        //   34: aconst_null
        //   35: astore_0
        //   36: iload_3
        //   37: iload 4
        //   39: if_icmpge +91 -> 130
        //   42: aload 11
        //   44: iload_3
        //   45: aaload
        //   46: astore 12
        //   48: aload 12
        //   50: ifnull +18 -> 68
        //   53: aload_0
        //   54: astore 10
        //   56: aload 12
        //   58: invokevirtual 102	java/io/File:exists	()Z
        //   61: istore 8
        //   63: iload 8
        //   65: ifne +34 -> 99
        //   68: aload_0
        //   69: ifnull +401 -> 470
        //   72: aload_0
        //   73: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   76: aconst_null
        //   77: astore_0
        //   78: iload_3
        //   79: iconst_1
        //   80: iadd
        //   81: istore_3
        //   82: goto -46 -> 36
        //   85: astore 9
        //   87: ldc 109
        //   89: ldc 111
        //   91: aload 9
        //   93: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   96: goto -18 -> 78
        //   99: iload_1
        //   100: ifne +74 -> 174
        //   103: aload_0
        //   104: astore 10
        //   106: aload_2
        //   107: aload 12
        //   109: invokevirtual 119	java/io/File:getName	()Ljava/lang/String;
        //   112: invokevirtual 124	com/millennialmedia/android/AdCache$Iterator:a	(Ljava/lang/String;)Z
        //   115: istore 8
        //   117: iload 8
        //   119: ifne +28 -> 147
        //   122: aload_0
        //   123: ifnull +7 -> 130
        //   126: aload_0
        //   127: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   130: aload_2
        //   131: invokevirtual 126	com/millennialmedia/android/AdCache$Iterator:a	()V
        //   134: return
        //   135: astore_0
        //   136: ldc 109
        //   138: ldc 111
        //   140: aload_0
        //   141: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   144: goto -14 -> 130
        //   147: aload_0
        //   148: ifnull +322 -> 470
        //   151: aload_0
        //   152: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   155: aconst_null
        //   156: astore_0
        //   157: goto -79 -> 78
        //   160: astore 9
        //   162: ldc 109
        //   164: ldc 111
        //   166: aload 9
        //   168: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   171: goto -93 -> 78
        //   174: aload_0
        //   175: astore 10
        //   177: new 104	java/io/ObjectInputStream
        //   180: dup
        //   181: new 128	java/io/FileInputStream
        //   184: dup
        //   185: aload 12
        //   187: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   190: invokespecial 134	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
        //   193: astore 9
        //   195: aload 9
        //   197: invokevirtual 137	java/io/ObjectInputStream:readInt	()I
        //   200: istore 5
        //   202: aload 9
        //   204: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   207: checkcast 142	java/util/Date
        //   210: astore_0
        //   211: aload 9
        //   213: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   216: checkcast 70	java/lang/String
        //   219: astore 10
        //   221: aload 9
        //   223: invokevirtual 146	java/io/ObjectInputStream:readLong	()J
        //   226: lstore 6
        //   228: iload_1
        //   229: iconst_1
        //   230: if_icmpne +53 -> 283
        //   233: aload_2
        //   234: aload 12
        //   236: invokevirtual 119	java/io/File:getName	()Ljava/lang/String;
        //   239: iload 5
        //   241: aload_0
        //   242: aload 10
        //   244: lload 6
        //   246: aload 9
        //   248: invokevirtual 149	com/millennialmedia/android/AdCache$Iterator:a	(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;JLjava/io/ObjectInputStream;)Z
        //   251: ifne +76 -> 327
        //   254: aload 9
        //   256: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   259: iconst_0
        //   260: ifeq -130 -> 130
        //   263: new 151	java/lang/NullPointerException
        //   266: dup
        //   267: invokespecial 152	java/lang/NullPointerException:<init>	()V
        //   270: athrow
        //   271: astore_0
        //   272: ldc 109
        //   274: ldc 111
        //   276: aload_0
        //   277: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   280: goto -150 -> 130
        //   283: aload_2
        //   284: aload 9
        //   286: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   289: checkcast 154	com/millennialmedia/android/CachedAd
        //   292: invokevirtual 157	com/millennialmedia/android/AdCache$Iterator:a	(Lcom/millennialmedia/android/CachedAd;)Z
        //   295: ifne +32 -> 327
        //   298: aload 9
        //   300: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   303: iconst_0
        //   304: ifeq -174 -> 130
        //   307: new 151	java/lang/NullPointerException
        //   310: dup
        //   311: invokespecial 152	java/lang/NullPointerException:<init>	()V
        //   314: athrow
        //   315: astore_0
        //   316: ldc 109
        //   318: ldc 111
        //   320: aload_0
        //   321: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   324: goto -194 -> 130
        //   327: aload 9
        //   329: astore_0
        //   330: aload 9
        //   332: ifnull -254 -> 78
        //   335: aload 9
        //   337: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   340: aconst_null
        //   341: astore_0
        //   342: goto -264 -> 78
        //   345: astore_0
        //   346: ldc 109
        //   348: ldc 111
        //   350: aload_0
        //   351: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   354: aload 9
        //   356: astore_0
        //   357: goto -279 -> 78
        //   360: astore_0
        //   361: aload 9
        //   363: astore 10
        //   365: aload_0
        //   366: astore 9
        //   368: aload 10
        //   370: astore_0
        //   371: aload_0
        //   372: astore 10
        //   374: ldc 109
        //   376: ldc -97
        //   378: iconst_1
        //   379: anewarray 4	java/lang/Object
        //   382: dup
        //   383: iconst_0
        //   384: aload 12
        //   386: invokevirtual 119	java/io/File:getName	()Ljava/lang/String;
        //   389: aastore
        //   390: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   393: aload 9
        //   395: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   398: aload_0
        //   399: astore 9
        //   401: aload_0
        //   402: ifnull +10 -> 412
        //   405: aload_0
        //   406: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   409: aconst_null
        //   410: astore 9
        //   412: aload 9
        //   414: astore_0
        //   415: goto -337 -> 78
        //   418: astore 9
        //   420: ldc 109
        //   422: ldc 111
        //   424: aload 9
        //   426: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   429: goto -351 -> 78
        //   432: astore_0
        //   433: aload 9
        //   435: ifnull +8 -> 443
        //   438: aload 9
        //   440: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   443: aload_0
        //   444: athrow
        //   445: astore_2
        //   446: ldc 109
        //   448: ldc 111
        //   450: aload_2
        //   451: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   454: goto -11 -> 443
        //   457: astore_0
        //   458: aload 10
        //   460: astore 9
        //   462: goto -29 -> 433
        //   465: astore 9
        //   467: goto -96 -> 371
        //   470: goto -392 -> 78
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	473	0	paramContext	Context
        //   0	473	1	paramInt	int
        //   0	473	2	paramIterator	AdCache.Iterator
        //   33	49	3	j	int
        //   30	10	4	k	int
        //   200	40	5	m	int
        //   226	19	6	l	long
        //   61	57	8	bool	boolean
        //   85	7	9	localIOException1	java.io.IOException
        //   160	7	9	localIOException2	java.io.IOException
        //   193	220	9	localObject1	Object
        //   418	21	9	localIOException3	java.io.IOException
        //   460	1	9	localObject2	Object
        //   465	1	9	localException	Exception
        //   54	405	10	localObject3	Object
        //   20	23	11	arrayOfFile	File[]
        //   46	339	12	localFile	File
        // Exception table:
        //   from	to	target	type
        //   72	76	85	java/io/IOException
        //   126	130	135	java/io/IOException
        //   151	155	160	java/io/IOException
        //   263	271	271	java/io/IOException
        //   307	315	315	java/io/IOException
        //   335	340	345	java/io/IOException
        //   195	228	360	java/lang/Exception
        //   233	259	360	java/lang/Exception
        //   283	303	360	java/lang/Exception
        //   405	409	418	java/io/IOException
        //   195	228	432	finally
        //   233	259	432	finally
        //   283	303	432	finally
        //   438	443	445	java/io/IOException
        //   56	63	457	finally
        //   106	117	457	finally
        //   177	195	457	finally
        //   374	398	457	finally
        //   56	63	465	java/lang/Exception
        //   106	117	465	java/lang/Exception
        //   177	195	465	java/lang/Exception
    }

    static void a(Context paramContext, String paramString) {
        if (paramString != null) {
        }
        try {
            if (!d) {
                a(paramContext);
            }
            if (b == null) {
                b = new HashSet();
            }
            b.add(paramString);
            c = null;
            return;
        } finally {
        }
    }

    static void a(Context paramContext, String paramString1, String paramString2) {
        try {
            if (!g) {
                j(paramContext);
            }
            if (paramString1 != null) {
                Map localMap = e;
                String str = paramString2;
                if (paramString2 == null) {
                    str = "";
                }
                localMap.put(paramString1, str);
                k(paramContext, paramString1);
            }
            return;
        } finally {
        }
    }

    private static void a(SharedPreferences.Editor paramEditor, String paramString) {
        int j = paramString.indexOf('_');
        String str;
        Object localObject;
        if ((j >= 0) && (j < paramString.length())) {
            str = paramString.substring(j + 1);
            if ((str != null) && (!f.contains(str))) {
                paramString = null;
                if (!f.isEmpty()) {
                    localObject = f.iterator();
                    paramString = new StringBuilder();
                    while (((Iterator) localObject).hasNext()) {
                        paramString.append((String) ((Iterator) localObject).next() + MMSDK.c);
                    }
                }
                localObject = new StringBuilder();
                if (paramString != null) {
                    break label170;
                }
            }
        }
        label170:
        for (paramString = ""; ; paramString = paramString.toString()) {
            paramEditor.putString("nextCachedAd_apids", paramString + str);
            f.add(str);
            return;
        }
    }

    private static void a(SharedPreferences paramSharedPreferences) {
        f = new HashSet();
        paramSharedPreferences = paramSharedPreferences.getString("nextCachedAd_apids", null);
        if (paramSharedPreferences != null) {
            paramSharedPreferences = paramSharedPreferences.split(MMSDK.c);
            if ((paramSharedPreferences != null) && (paramSharedPreferences.length > 0)) {
                int k = paramSharedPreferences.length;
                int j = 0;
                while (j < k) {
                    Object localObject = paramSharedPreferences[j];
                    f.add(localObject);
                    j += 1;
                }
            }
        }
    }

    static void a(File paramFile, long paramLong) {
        paramFile = paramFile.listFiles();
        int k = paramFile.length;
        int j = 0;
        if (j < k) {
            File localFile = paramFile[j];
            if (localFile.isFile()) {
                if (System.currentTimeMillis() - localFile.lastModified() > paramLong) {
                    localFile.delete();
                }
            }
            for (; ; ) {
                j += 1;
                break;
                if (localFile.isDirectory()) {
                    try {
                        a(localFile, paramLong);
                        if ((localFile.list() != null) && (localFile.list().length == 0)) {
                            localFile.delete();
                        }
                    } catch (SecurityException localSecurityException) {
                        MMLog.a("AdCache", "Security Exception cleaning up directory", localSecurityException);
                    }
                }
            }
        }
    }

    static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* Error */
    static boolean a(Context paramContext, CachedAd paramCachedAd) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aconst_null
        //   4: astore 4
        //   6: aload_1
        //   7: ifnonnull +5 -> 12
        //   10: iconst_0
        //   11: ireturn
        //   12: aload_0
        //   13: aload_1
        //   14: invokevirtual 274	com/millennialmedia/android/CachedAd:e	()Ljava/lang/String;
        //   17: invokestatic 278	com/millennialmedia/android/AdCache:m	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
        //   20: astore_3
        //   21: aload_3
        //   22: ifnull -12 -> 10
        //   25: ldc 109
        //   27: ldc_w 280
        //   30: iconst_2
        //   31: anewarray 4	java/lang/Object
        //   34: dup
        //   35: iconst_0
        //   36: aload_1
        //   37: invokevirtual 274	com/millennialmedia/android/CachedAd:e	()Ljava/lang/String;
        //   40: aastore
        //   41: dup
        //   42: iconst_1
        //   43: aload_3
        //   44: aastore
        //   45: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   48: invokestatic 283	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   51: new 95	java/io/File
        //   54: dup
        //   55: aload_3
        //   56: invokevirtual 286	java/io/File:getParent	()Ljava/lang/String;
        //   59: new 53	java/lang/StringBuilder
        //   62: dup
        //   63: invokespecial 54	java/lang/StringBuilder:<init>	()V
        //   66: aload_1
        //   67: invokevirtual 274	com/millennialmedia/android/CachedAd:e	()Ljava/lang/String;
        //   70: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   73: ldc_w 288
        //   76: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   79: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   82: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   85: astore_2
        //   86: aload_2
        //   87: invokevirtual 293	java/io/File:createNewFile	()Z
        //   90: ifne +53 -> 143
        //   93: ldc 109
        //   95: ldc_w 295
        //   98: iconst_1
        //   99: anewarray 4	java/lang/Object
        //   102: dup
        //   103: iconst_0
        //   104: aload_1
        //   105: invokevirtual 274	com/millennialmedia/android/CachedAd:e	()Ljava/lang/String;
        //   108: aastore
        //   109: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   112: invokestatic 283	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   115: aload_2
        //   116: invokevirtual 250	java/io/File:delete	()Z
        //   119: pop
        //   120: iconst_0
        //   121: ifeq -111 -> 10
        //   124: new 151	java/lang/NullPointerException
        //   127: dup
        //   128: invokespecial 152	java/lang/NullPointerException:<init>	()V
        //   131: athrow
        //   132: astore_0
        //   133: ldc 109
        //   135: ldc 111
        //   137: aload_0
        //   138: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   141: iconst_0
        //   142: ireturn
        //   143: new 297	java/io/ObjectOutputStream
        //   146: dup
        //   147: new 299	java/io/FileOutputStream
        //   150: dup
        //   151: aload_3
        //   152: invokespecial 300	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   155: invokespecial 303	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   158: astore_3
        //   159: aload_3
        //   160: aload_1
        //   161: invokevirtual 305	com/millennialmedia/android/CachedAd:c	()I
        //   164: invokevirtual 309	java/io/ObjectOutputStream:writeInt	(I)V
        //   167: aload_3
        //   168: aload_1
        //   169: getfield 312	com/millennialmedia/android/CachedAd:b	Ljava/util/Date;
        //   172: invokevirtual 316	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
        //   175: aload_3
        //   176: aload_1
        //   177: getfield 318	com/millennialmedia/android/CachedAd:a	Ljava/lang/String;
        //   180: invokevirtual 316	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
        //   183: aload_3
        //   184: aload_1
        //   185: getfield 321	com/millennialmedia/android/CachedAd:c	J
        //   188: invokevirtual 325	java/io/ObjectOutputStream:writeLong	(J)V
        //   191: aload_3
        //   192: aload_1
        //   193: invokevirtual 316	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
        //   196: aload_2
        //   197: invokevirtual 250	java/io/File:delete	()Z
        //   200: pop
        //   201: aload_3
        //   202: ifnull +7 -> 209
        //   205: aload_3
        //   206: invokevirtual 326	java/io/ObjectOutputStream:close	()V
        //   209: aload_1
        //   210: aload_0
        //   211: invokevirtual 329	com/millennialmedia/android/CachedAd:a	(Landroid/content/Context;)Z
        //   214: ifne +110 -> 324
        //   217: aload_1
        //   218: aload_0
        //   219: invokevirtual 331	com/millennialmedia/android/CachedAd:c	(Landroid/content/Context;)V
        //   222: iconst_0
        //   223: ireturn
        //   224: astore_2
        //   225: ldc 109
        //   227: ldc 111
        //   229: aload_2
        //   230: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   233: goto -24 -> 209
        //   236: astore_3
        //   237: aconst_null
        //   238: astore_0
        //   239: aload 4
        //   241: astore_2
        //   242: ldc 109
        //   244: ldc_w 333
        //   247: iconst_1
        //   248: anewarray 4	java/lang/Object
        //   251: dup
        //   252: iconst_0
        //   253: aload_1
        //   254: invokevirtual 274	com/millennialmedia/android/CachedAd:e	()Ljava/lang/String;
        //   257: aastore
        //   258: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   261: aload_3
        //   262: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   265: aload_0
        //   266: invokevirtual 250	java/io/File:delete	()Z
        //   269: pop
        //   270: aload_2
        //   271: ifnull -261 -> 10
        //   274: aload_2
        //   275: invokevirtual 326	java/io/ObjectOutputStream:close	()V
        //   278: iconst_0
        //   279: ireturn
        //   280: astore_0
        //   281: ldc 109
        //   283: ldc 111
        //   285: aload_0
        //   286: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   289: iconst_0
        //   290: ireturn
        //   291: astore_0
        //   292: aconst_null
        //   293: astore_2
        //   294: aload 5
        //   296: astore_1
        //   297: aload_2
        //   298: invokevirtual 250	java/io/File:delete	()Z
        //   301: pop
        //   302: aload_1
        //   303: ifnull +7 -> 310
        //   306: aload_1
        //   307: invokevirtual 326	java/io/ObjectOutputStream:close	()V
        //   310: aload_0
        //   311: athrow
        //   312: astore_1
        //   313: ldc 109
        //   315: ldc 111
        //   317: aload_1
        //   318: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   321: goto -11 -> 310
        //   324: iconst_1
        //   325: ireturn
        //   326: astore_0
        //   327: aload 5
        //   329: astore_1
        //   330: goto -33 -> 297
        //   333: astore_0
        //   334: aload_3
        //   335: astore_1
        //   336: goto -39 -> 297
        //   339: astore_1
        //   340: aload_0
        //   341: astore_3
        //   342: aload_1
        //   343: astore_0
        //   344: aload_2
        //   345: astore_1
        //   346: aload_3
        //   347: astore_2
        //   348: goto -51 -> 297
        //   351: astore_3
        //   352: aload_2
        //   353: astore_0
        //   354: aload 4
        //   356: astore_2
        //   357: goto -115 -> 242
        //   360: astore 5
        //   362: aload_3
        //   363: astore_0
        //   364: aload_2
        //   365: astore 4
        //   367: aload 5
        //   369: astore_3
        //   370: aload_0
        //   371: astore_2
        //   372: aload 4
        //   374: astore_0
        //   375: goto -133 -> 242
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	378	0	paramContext	Context
        //   0	378	1	paramCachedAd	CachedAd
        //   85	112	2	localFile	File
        //   224	6	2	localIOException	java.io.IOException
        //   241	131	2	localObject1	Object
        //   20	186	3	localObject2	Object
        //   236	99	3	localException1	Exception
        //   341	6	3	localContext	Context
        //   351	12	3	localException2	Exception
        //   369	1	3	localException3	Exception
        //   4	369	4	localObject3	Object
        //   1	327	5	localObject4	Object
        //   360	8	5	localException4	Exception
        // Exception table:
        //   from	to	target	type
        //   115	120	132	java/io/IOException
        //   124	132	132	java/io/IOException
        //   196	201	224	java/io/IOException
        //   205	209	224	java/io/IOException
        //   51	86	236	java/lang/Exception
        //   265	270	280	java/io/IOException
        //   274	278	280	java/io/IOException
        //   51	86	291	finally
        //   297	302	312	java/io/IOException
        //   306	310	312	java/io/IOException
        //   86	115	326	finally
        //   143	159	326	finally
        //   159	196	333	finally
        //   242	265	339	finally
        //   86	115	351	java/lang/Exception
        //   143	159	351	java/lang/Exception
        //   159	196	360	java/lang/Exception
    }

    static boolean a(Context paramContext, String paramString, CachedAd paramCachedAd, AdCache.AdCacheTaskListener paramAdCacheTaskListener) {
        return AdCacheThreadPool.a().a(paramContext, paramString, paramCachedAd, paramAdCacheTaskListener);
    }

    static boolean a(String paramString1, String paramString2, Context paramContext) {
        File localFile = h(paramContext);
        if ((localFile == null) || (!localFile.isDirectory())) {
            return false;
        }
        return a(paramString1, paramString2, localFile, paramContext);
    }

    /* Error */
    private static boolean a(String paramString1, String paramString2, File paramFile, Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic 350	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   4: ifeq +17 -> 21
        //   7: ldc 109
        //   9: ldc_w 352
        //   12: invokestatic 354	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   15: iconst_0
        //   16: istore 9
        //   18: iload 9
        //   20: ireturn
        //   21: new 95	java/io/File
        //   24: dup
        //   25: aload_2
        //   26: aload_1
        //   27: invokespecial 357	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   30: astore 12
        //   32: ldc 109
        //   34: ldc_w 359
        //   37: iconst_2
        //   38: anewarray 4	java/lang/Object
        //   41: dup
        //   42: iconst_0
        //   43: aload_1
        //   44: aastore
        //   45: dup
        //   46: iconst_1
        //   47: aload_0
        //   48: aastore
        //   49: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   52: invokestatic 283	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   55: aload 12
        //   57: invokevirtual 363	java/io/File:getParentFile	()Ljava/io/File;
        //   60: astore_2
        //   61: aload_2
        //   62: invokevirtual 102	java/io/File:exists	()Z
        //   65: ifne +37 -> 102
        //   68: aload_2
        //   69: invokevirtual 366	java/io/File:mkdirs	()Z
        //   72: ifne +30 -> 102
        //   75: ldc 109
        //   77: new 53	java/lang/StringBuilder
        //   80: dup
        //   81: invokespecial 54	java/lang/StringBuilder:<init>	()V
        //   84: aload_2
        //   85: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   88: ldc_w 371
        //   91: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   94: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   97: invokestatic 283	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   100: iconst_0
        //   101: ireturn
        //   102: aload 12
        //   104: invokevirtual 102	java/io/File:exists	()Z
        //   107: ifeq +40 -> 147
        //   110: aload 12
        //   112: invokevirtual 373	java/io/File:length	()J
        //   115: lconst_0
        //   116: lcmp
        //   117: ifle +30 -> 147
        //   120: ldc 109
        //   122: new 53	java/lang/StringBuilder
        //   125: dup
        //   126: invokespecial 54	java/lang/StringBuilder:<init>	()V
        //   129: aload_1
        //   130: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   133: ldc_w 375
        //   136: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   142: invokestatic 283	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   145: iconst_1
        //   146: ireturn
        //   147: aconst_null
        //   148: astore 11
        //   150: aconst_null
        //   151: astore_3
        //   152: aconst_null
        //   153: astore 10
        //   155: ldc2_w 376
        //   158: lstore 5
        //   160: new 379	java/net/URL
        //   163: dup
        //   164: aload_0
        //   165: invokespecial 382	java/net/URL:<init>	(Ljava/lang/String;)V
        //   168: astore_0
        //   169: iconst_1
        //   170: invokestatic 388	java/net/HttpURLConnection:setFollowRedirects	(Z)V
        //   173: aload_0
        //   174: invokevirtual 392	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   177: checkcast 384	java/net/HttpURLConnection
        //   180: astore_2
        //   181: aload_2
        //   182: sipush 30000
        //   185: invokevirtual 395	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   188: aload_2
        //   189: ldc_w 397
        //   192: invokevirtual 400	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   195: aload_2
        //   196: invokevirtual 403	java/net/HttpURLConnection:connect	()V
        //   199: aload_2
        //   200: invokevirtual 407	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   203: astore_0
        //   204: aload_2
        //   205: ldc_w 409
        //   208: invokevirtual 413	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   211: astore_2
        //   212: aload_2
        //   213: ifnull +9 -> 222
        //   216: aload_2
        //   217: invokestatic 419	java/lang/Long:parseLong	(Ljava/lang/String;)J
        //   220: lstore 5
        //   222: aload_0
        //   223: ifnonnull +68 -> 291
        //   226: ldc 109
        //   228: ldc_w 421
        //   231: iconst_1
        //   232: anewarray 4	java/lang/Object
        //   235: dup
        //   236: iconst_0
        //   237: aload_1
        //   238: aastore
        //   239: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   242: invokestatic 423	com/millennialmedia/android/MMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   245: iconst_0
        //   246: istore 9
        //   248: aload_0
        //   249: ifnull +7 -> 256
        //   252: aload_0
        //   253: invokevirtual 426	java/io/InputStream:close	()V
        //   256: iconst_0
        //   257: ifeq -239 -> 18
        //   260: new 151	java/lang/NullPointerException
        //   263: dup
        //   264: invokespecial 152	java/lang/NullPointerException:<init>	()V
        //   267: athrow
        //   268: astore_0
        //   269: ldc 109
        //   271: ldc_w 428
        //   274: aload_0
        //   275: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   278: aload 12
        //   280: ifnull +9 -> 289
        //   283: aload 12
        //   285: invokevirtual 250	java/io/File:delete	()Z
        //   288: pop
        //   289: iconst_0
        //   290: ireturn
        //   291: new 299	java/io/FileOutputStream
        //   294: dup
        //   295: aload 12
        //   297: invokespecial 300	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   300: astore_2
        //   301: sipush 4096
        //   304: newarray <illegal type>
        //   306: astore_3
        //   307: aload_0
        //   308: aload_3
        //   309: invokevirtual 432	java/io/InputStream:read	([B)I
        //   312: istore 4
        //   314: iload 4
        //   316: ifle +67 -> 383
        //   319: aload_2
        //   320: aload_3
        //   321: iconst_0
        //   322: iload 4
        //   324: invokevirtual 436	java/io/FileOutputStream:write	([BII)V
        //   327: goto -20 -> 307
        //   330: astore_3
        //   331: ldc 109
        //   333: ldc_w 438
        //   336: iconst_2
        //   337: anewarray 4	java/lang/Object
        //   340: dup
        //   341: iconst_0
        //   342: aload_1
        //   343: aastore
        //   344: dup
        //   345: iconst_1
        //   346: aload_3
        //   347: aastore
        //   348: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   351: invokestatic 423	com/millennialmedia/android/MMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   354: aload_0
        //   355: ifnull +7 -> 362
        //   358: aload_0
        //   359: invokevirtual 426	java/io/InputStream:close	()V
        //   362: aload_2
        //   363: ifnull +7 -> 370
        //   366: aload_2
        //   367: invokevirtual 439	java/io/FileOutputStream:close	()V
        //   370: aload 12
        //   372: ifnull +9 -> 381
        //   375: aload 12
        //   377: invokevirtual 250	java/io/File:delete	()Z
        //   380: pop
        //   381: iconst_0
        //   382: ireturn
        //   383: aload 12
        //   385: ifnull +79 -> 464
        //   388: aload 12
        //   390: invokevirtual 373	java/io/File:length	()J
        //   393: lstore 7
        //   395: lload 7
        //   397: lload 5
        //   399: lcmp
        //   400: ifeq +12 -> 412
        //   403: lload 5
        //   405: ldc2_w 376
        //   408: lcmp
        //   409: ifne +47 -> 456
        //   412: iconst_1
        //   413: istore 9
        //   415: aload_0
        //   416: ifnull +7 -> 423
        //   419: aload_0
        //   420: invokevirtual 426	java/io/InputStream:close	()V
        //   423: aload_2
        //   424: ifnull -406 -> 18
        //   427: aload_2
        //   428: invokevirtual 439	java/io/FileOutputStream:close	()V
        //   431: iconst_1
        //   432: ireturn
        //   433: astore_0
        //   434: ldc 109
        //   436: ldc_w 428
        //   439: aload_0
        //   440: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   443: aload 12
        //   445: ifnull +9 -> 454
        //   448: aload 12
        //   450: invokevirtual 250	java/io/File:delete	()Z
        //   453: pop
        //   454: iconst_0
        //   455: ireturn
        //   456: ldc 109
        //   458: ldc_w 441
        //   461: invokestatic 423	com/millennialmedia/android/MMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   464: aload_0
        //   465: ifnull +7 -> 472
        //   468: aload_0
        //   469: invokevirtual 426	java/io/InputStream:close	()V
        //   472: aload_2
        //   473: ifnull -103 -> 370
        //   476: aload_2
        //   477: invokevirtual 439	java/io/FileOutputStream:close	()V
        //   480: goto -110 -> 370
        //   483: astore_0
        //   484: ldc 109
        //   486: ldc_w 428
        //   489: aload_0
        //   490: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   493: aload 12
        //   495: ifnull +9 -> 504
        //   498: aload 12
        //   500: invokevirtual 250	java/io/File:delete	()Z
        //   503: pop
        //   504: iconst_0
        //   505: ireturn
        //   506: astore_3
        //   507: ldc 109
        //   509: ldc_w 443
        //   512: iconst_1
        //   513: anewarray 4	java/lang/Object
        //   516: dup
        //   517: iconst_0
        //   518: aload_1
        //   519: aastore
        //   520: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   523: aload_3
        //   524: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   527: goto -63 -> 464
        //   530: astore_1
        //   531: aload_0
        //   532: ifnull +7 -> 539
        //   535: aload_0
        //   536: invokevirtual 426	java/io/InputStream:close	()V
        //   539: aload_2
        //   540: ifnull +7 -> 547
        //   543: aload_2
        //   544: invokevirtual 439	java/io/FileOutputStream:close	()V
        //   547: aload_1
        //   548: athrow
        //   549: astore_0
        //   550: ldc 109
        //   552: ldc_w 428
        //   555: aload_0
        //   556: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   559: aload 12
        //   561: ifnull +9 -> 570
        //   564: aload 12
        //   566: invokevirtual 250	java/io/File:delete	()Z
        //   569: pop
        //   570: iconst_0
        //   571: ireturn
        //   572: astore_0
        //   573: ldc 109
        //   575: ldc_w 428
        //   578: aload_0
        //   579: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   582: aload 12
        //   584: ifnull +9 -> 593
        //   587: aload 12
        //   589: invokevirtual 250	java/io/File:delete	()Z
        //   592: pop
        //   593: iconst_0
        //   594: ireturn
        //   595: astore_1
        //   596: aconst_null
        //   597: astore_0
        //   598: aload_3
        //   599: astore_2
        //   600: goto -69 -> 531
        //   603: astore_1
        //   604: aload_3
        //   605: astore_2
        //   606: goto -75 -> 531
        //   609: astore_1
        //   610: goto -79 -> 531
        //   613: astore_3
        //   614: aload 10
        //   616: astore_2
        //   617: aload 11
        //   619: astore_0
        //   620: goto -289 -> 331
        //   623: astore_3
        //   624: aload 10
        //   626: astore_2
        //   627: goto -296 -> 331
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	630	0	paramString1	String
        //   0	630	1	paramString2	String
        //   0	630	2	paramFile	File
        //   0	630	3	paramContext	Context
        //   312	11	4	j	int
        //   158	246	5	l1	long
        //   393	3	7	l2	long
        //   16	398	9	bool	boolean
        //   153	472	10	localObject1	Object
        //   148	470	11	localObject2	Object
        //   30	558	12	localFile	File
        // Exception table:
        //   from	to	target	type
        //   252	256	268	java/io/IOException
        //   260	268	268	java/io/IOException
        //   301	307	330	java/lang/Exception
        //   307	314	330	java/lang/Exception
        //   319	327	330	java/lang/Exception
        //   388	395	330	java/lang/Exception
        //   456	464	330	java/lang/Exception
        //   507	527	330	java/lang/Exception
        //   419	423	433	java/io/IOException
        //   427	431	433	java/io/IOException
        //   468	472	483	java/io/IOException
        //   476	480	483	java/io/IOException
        //   388	395	506	java/lang/SecurityException
        //   456	464	506	java/lang/SecurityException
        //   301	307	530	finally
        //   307	314	530	finally
        //   319	327	530	finally
        //   388	395	530	finally
        //   456	464	530	finally
        //   507	527	530	finally
        //   358	362	549	java/io/IOException
        //   366	370	549	java/io/IOException
        //   535	539	572	java/io/IOException
        //   543	547	572	java/io/IOException
        //   160	204	595	finally
        //   204	212	603	finally
        //   216	222	603	finally
        //   226	245	603	finally
        //   291	301	603	finally
        //   331	354	609	finally
        //   160	204	613	java/lang/Exception
        //   204	212	623	java/lang/Exception
        //   216	222	623	java/lang/Exception
        //   226	245	623	java/lang/Exception
        //   291	301	623	java/lang/Exception
    }

    static boolean a(String paramString1, String paramString2, String paramString3, Context paramContext) {
        File localFile = g(paramContext);
        if ((localFile == null) || (!localFile.isDirectory())) {
            return false;
        }
        return a(paramString1, paramString3, new File(localFile, paramString2), paramContext);
    }

    static void b(Context paramContext) {
        Utils.ThreadUtils.a(new AdCache .3 (paramContext));
    }

    static void b(Context paramContext, String paramString) {
        if (paramString != null) {
        }
        try {
            if (!d) {
                a(paramContext);
            }
            if (b != null) {
                b.remove(paramString);
                c = null;
            }
            return;
        } finally {
        }
    }

    static void b(Context paramContext, String paramString1, String paramString2) {
        try {
            if (!i) {
                k(paramContext);
            }
            if (paramString1 != null) {
                Map localMap = h;
                String str = paramString2;
                if (paramString2 == null) {
                    str = "";
                }
                localMap.put(paramString1, str);
                l(paramContext, paramString1);
            }
            return;
        } finally {
        }
    }

    static boolean b(String paramString1, String paramString2, Context paramContext) {
        File localFile = g(paramContext);
        if ((localFile == null) || (!localFile.isDirectory())) {
            return false;
        }
        return a(paramString1, paramString2, localFile, paramContext);
    }

    static File c(Context paramContext, String paramString1, String paramString2) {
        File localFile = g(paramContext);
        paramContext = null;
        if (localFile != null) {
            paramContext = new File(localFile, paramString1 + File.separator + paramString2);
        }
        return paramContext;
    }

    /* Error */
    static String c(Context paramContext, String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 173	com/millennialmedia/android/AdCache:g	Z
        //   6: ifne +7 -> 13
        //   9: aload_0
        //   10: invokestatic 177	com/millennialmedia/android/AdCache:j	(Landroid/content/Context;)V
        //   13: aload_1
        //   14: ifnonnull +10 -> 24
        //   17: aconst_null
        //   18: astore_0
        //   19: ldc 2
        //   21: monitorexit
        //   22: aload_0
        //   23: areturn
        //   24: getstatic 179	com/millennialmedia/android/AdCache:e	Ljava/util/Map;
        //   27: aload_1
        //   28: invokeinterface 476 2 0
        //   33: checkcast 70	java/lang/String
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

    static void c(Context paramContext) {
        a(paramContext, 1, new AdCache .4 ());
    }

    static CachedAd d(Context paramContext, String paramString) {
        paramString = c(paramContext, paramString);
        if ((paramString == null) || (paramString.equals(""))) {
            return null;
        }
        return i(paramContext, paramString);
    }

    static void d(Context paramContext) {
        l(paramContext);
        if (i(paramContext)) {
            m(paramContext);
        }
    }

    /* Error */
    static String e(Context paramContext, String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 460	com/millennialmedia/android/AdCache:i	Z
        //   6: ifne +7 -> 13
        //   9: aload_0
        //   10: invokestatic 462	com/millennialmedia/android/AdCache:k	(Landroid/content/Context;)V
        //   13: aload_1
        //   14: ifnonnull +10 -> 24
        //   17: aconst_null
        //   18: astore_0
        //   19: ldc 2
        //   21: monitorexit
        //   22: aload_0
        //   23: areturn
        //   24: getstatic 464	com/millennialmedia/android/AdCache:h	Ljava/util/Map;
        //   27: aload_1
        //   28: invokeinterface 476 2 0
        //   33: checkcast 70	java/lang/String
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

    static void e(Context paramContext) {
        a(paramContext, 2, new AdCache .5 (paramContext));
        b = null;
        c = null;
        d = false;
        Iterator localIterator;
        if (e != null) {
            localIterator = e.keySet().iterator();
            while (localIterator.hasNext()) {
                a(paramContext, (String) localIterator.next(), null);
            }
        }
        if (h != null) {
            localIterator = h.keySet().iterator();
            while (localIterator.hasNext()) {
                b(paramContext, (String) localIterator.next(), null);
            }
        }
    }

    static CachedAd f(Context paramContext, String paramString) {
        paramString = e(paramContext, paramString);
        if (paramString == null) {
            return null;
        }
        return i(paramContext, paramString);
    }

    static File f(Context paramContext) {
        if (i(paramContext)) {
            return g(paramContext);
        }
        return h(paramContext);
    }

    static File g(Context paramContext) {
        paramContext = Environment.getExternalStorageDirectory();
        if (paramContext != null) {
            paramContext = new File(paramContext, ".mmsyscache");
            if ((paramContext.exists()) || (paramContext.mkdirs())) {
            }
        } else {
            return null;
        }
        return paramContext;
    }

    static File g(Context paramContext, String paramString) {
        File localFile = g(paramContext);
        paramContext = null;
        if (localFile != null) {
            paramContext = new File(localFile, paramString);
        }
        return paramContext;
    }

    static File h(Context paramContext) {
        if (paramContext == null) {
        }
        do {
            return null;
            paramContext = new File(paramContext.getFilesDir(), ".mmsyscache");
        } while ((paramContext != null) && (!paramContext.exists()) && (!paramContext.mkdirs()));
        return paramContext;
    }

    static boolean h(Context paramContext, String paramString) {
        paramContext = g(paramContext, paramString);
        return (paramContext != null) && (paramContext.exists());
    }

    /* Error */
    static CachedAd i(Context paramContext, String paramString) {
        // Byte code:
        //   0: aload_1
        //   1: ifnull +12 -> 13
        //   4: aload_1
        //   5: ldc -75
        //   7: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   10: ifeq +5 -> 15
        //   13: aconst_null
        //   14: areturn
        //   15: aload_0
        //   16: aload_1
        //   17: invokestatic 278	com/millennialmedia/android/AdCache:m	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
        //   20: astore_0
        //   21: aload_0
        //   22: ifnull -9 -> 13
        //   25: new 104	java/io/ObjectInputStream
        //   28: dup
        //   29: new 128	java/io/FileInputStream
        //   32: dup
        //   33: aload_0
        //   34: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   37: invokespecial 134	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
        //   40: astore_2
        //   41: aload_2
        //   42: astore_0
        //   43: aload_2
        //   44: invokevirtual 137	java/io/ObjectInputStream:readInt	()I
        //   47: pop
        //   48: aload_2
        //   49: astore_0
        //   50: aload_2
        //   51: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   54: checkcast 142	java/util/Date
        //   57: astore_3
        //   58: aload_2
        //   59: astore_0
        //   60: aload_2
        //   61: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   64: pop
        //   65: aload_2
        //   66: astore_0
        //   67: aload_2
        //   68: invokevirtual 146	java/io/ObjectInputStream:readLong	()J
        //   71: pop2
        //   72: aload_2
        //   73: astore_0
        //   74: aload_2
        //   75: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   78: checkcast 154	com/millennialmedia/android/CachedAd
        //   81: astore_3
        //   82: aload_3
        //   83: astore_0
        //   84: aload_2
        //   85: ifnull +9 -> 94
        //   88: aload_2
        //   89: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   92: aload_3
        //   93: astore_0
        //   94: aload_0
        //   95: areturn
        //   96: astore_0
        //   97: ldc 109
        //   99: ldc 111
        //   101: aload_0
        //   102: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   105: aload_3
        //   106: astore_0
        //   107: goto -13 -> 94
        //   110: astore_3
        //   111: aconst_null
        //   112: astore_2
        //   113: aload_2
        //   114: astore_0
        //   115: ldc 109
        //   117: new 53	java/lang/StringBuilder
        //   120: dup
        //   121: invokespecial 54	java/lang/StringBuilder:<init>	()V
        //   124: ldc_w 520
        //   127: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   130: aload_1
        //   131: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   134: ldc_w 522
        //   137: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   140: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   143: aload_3
        //   144: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   147: aload_2
        //   148: ifnull +7 -> 155
        //   151: aload_2
        //   152: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   155: aconst_null
        //   156: astore_0
        //   157: goto -63 -> 94
        //   160: astore_0
        //   161: ldc 109
        //   163: ldc 111
        //   165: aload_0
        //   166: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   169: aconst_null
        //   170: astore_0
        //   171: goto -77 -> 94
        //   174: astore_3
        //   175: aconst_null
        //   176: astore_2
        //   177: aload_2
        //   178: astore_0
        //   179: ldc 109
        //   181: ldc_w 524
        //   184: iconst_1
        //   185: anewarray 4	java/lang/Object
        //   188: dup
        //   189: iconst_0
        //   190: aload_1
        //   191: aastore
        //   192: invokestatic 163	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   195: aload_3
        //   196: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   199: aload_2
        //   200: ifnull +7 -> 207
        //   203: aload_2
        //   204: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   207: aconst_null
        //   208: astore_0
        //   209: goto -115 -> 94
        //   212: astore_0
        //   213: ldc 109
        //   215: ldc 111
        //   217: aload_0
        //   218: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   221: aconst_null
        //   222: astore_0
        //   223: goto -129 -> 94
        //   226: astore_1
        //   227: aconst_null
        //   228: astore_0
        //   229: aload_0
        //   230: ifnull +7 -> 237
        //   233: aload_0
        //   234: invokevirtual 107	java/io/ObjectInputStream:close	()V
        //   237: aload_1
        //   238: athrow
        //   239: astore_0
        //   240: ldc 109
        //   242: ldc 111
        //   244: aload_0
        //   245: invokestatic 116	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   248: goto -11 -> 237
        //   251: astore_1
        //   252: goto -23 -> 229
        //   255: astore_3
        //   256: goto -79 -> 177
        //   259: astore_3
        //   260: goto -147 -> 113
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	263	0	paramContext	Context
        //   0	263	1	paramString	String
        //   40	164	2	localObjectInputStream	java.io.ObjectInputStream
        //   57	49	3	localObject	Object
        //   110	34	3	localFileNotFoundException1	java.io.FileNotFoundException
        //   174	22	3	localException1	Exception
        //   255	1	3	localException2	Exception
        //   259	1	3	localFileNotFoundException2	java.io.FileNotFoundException
        // Exception table:
        //   from	to	target	type
        //   88	92	96	java/io/IOException
        //   25	41	110	java/io/FileNotFoundException
        //   151	155	160	java/io/IOException
        //   25	41	174	java/lang/Exception
        //   203	207	212	java/io/IOException
        //   25	41	226	finally
        //   233	237	239	java/io/IOException
        //   43	48	251	finally
        //   50	58	251	finally
        //   60	65	251	finally
        //   67	72	251	finally
        //   74	82	251	finally
        //   115	147	251	finally
        //   179	199	251	finally
        //   43	48	255	java/lang/Exception
        //   50	58	255	java/lang/Exception
        //   60	65	255	java/lang/Exception
        //   67	72	255	java/lang/Exception
        //   74	82	255	java/lang/Exception
        //   43	48	259	java/io/FileNotFoundException
        //   50	58	259	java/io/FileNotFoundException
        //   60	65	259	java/io/FileNotFoundException
        //   67	72	259	java/io/FileNotFoundException
        //   74	82	259	java/io/FileNotFoundException
    }

    static boolean i(Context paramContext) {
        if (paramContext == null) {
        }
        String str;
        do {
            return false;
            str = Environment.getExternalStorageState();
        }
        while ((paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) || (TextUtils.isEmpty(str)) || (!str.equals("mounted")) || (!a));
        return true;
    }

    private static void j(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
        e = new ConcurrentHashMap();
        if (f == null) {
            a(paramContext);
        }
        Iterator localIterator = f.iterator();
        while (localIterator.hasNext()) {
            String str1 = (String) localIterator.next();
            String[] arrayOfString = MMAdImpl.l();
            int k = arrayOfString.length;
            int j = 0;
            while (j < k) {
                String str2 = arrayOfString[j];
                String str3 = paramContext.getString("nextCachedAd_" + str2 + '_' + str1, null);
                if (str3 != null) {
                    e.put(str2 + '_' + str1, str3);
                }
                j += 1;
            }
        }
        g = true;
    }

    static boolean j(Context paramContext, String paramString) {
        paramContext = m(paramContext, paramString);
        if (paramContext != null) {
            return paramContext.delete();
        }
        return false;
    }

    private static void k(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
        h = new ConcurrentHashMap();
        if (f == null) {
            a(paramContext);
        }
        Iterator localIterator = f.iterator();
        while (localIterator.hasNext()) {
            String str1 = (String) localIterator.next();
            String[] arrayOfString = MMAdImpl.l();
            int k = arrayOfString.length;
            int j = 0;
            while (j < k) {
                String str2 = arrayOfString[j];
                String str3 = paramContext.getString("incompleteDownload_" + str2 + '_' + str1, null);
                if (str3 != null) {
                    h.put(str2 + '_' + str1, str3);
                }
                j += 1;
            }
        }
        i = true;
    }

    private static void k(Context paramContext, String paramString) {
        if (paramString != null) {
            paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
            a(paramContext, paramString);
            paramContext.putString("nextCachedAd_" + paramString, (String) e.get(paramString));
            paramContext.commit();
        }
    }

    private static void l(Context paramContext) {
        File localFile = h(paramContext);
        if (localFile == null) {
        }
        while ((!localFile.exists()) || (!localFile.isDirectory())) {
            return;
        }
        a(localFile, HandShake.a(paramContext).d);
    }

    private static void l(Context paramContext, String paramString) {
        if (paramString != null) {
            paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
            a(paramContext, paramString);
            paramContext.putString("incompleteDownload_" + paramString, (String) h.get(paramString));
            paramContext.commit();
        }
    }

    private static File m(Context paramContext, String paramString) {
        String str = paramString + "ad.dat";
        boolean bool = i(paramContext);
        paramString = h(paramContext);
        if (paramString != null) {
        }
        for (; ; ) {
            try {
                if (!paramString.isDirectory()) {
                    break label143;
                }
                paramString = new File(paramString, str);
                if (((paramString == null) || (!paramString.exists())) && (!bool)) {
                    paramContext = paramContext.getFilesDir();
                    if (paramContext != null) {
                        paramContext = new File(paramContext, ".mmsyscache" + File.separator + str);
                        if (paramContext.exists()) {
                            bool = paramContext.isFile();
                            if (bool) {
                                return paramContext;
                            }
                        }
                    }
                }
            } catch (Exception paramContext) {
                MMLog.a("AdCache", "getCachedAdFile: ", paramContext);
                return null;
            }
            return paramString;
            label143:
            paramString = null;
        }
    }

    private static void m(Context paramContext) {
        File localFile = g(paramContext);
        if (localFile == null) {
        }
        while ((!localFile.exists()) || (!localFile.isDirectory())) {
            return;
        }
        a(localFile, HandShake.a(paramContext).d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */