package com.millennialmedia.android;

final class MMConversionTracker {
    /* Error */
    protected static void a(android.content.Context paramContext, String paramString, MMRequest paramMMRequest) {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: ldc 2
        //   4: monitorenter
        //   5: aload_0
        //   6: ifnull +18 -> 24
        //   9: aload_1
        //   10: ifnull +14 -> 24
        //   13: aload_1
        //   14: invokevirtual 21	java/lang/String:length	()I
        //   17: istore 4
        //   19: iload 4
        //   21: ifne +7 -> 28
        //   24: ldc 2
        //   26: monitorexit
        //   27: return
        //   28: aload_0
        //   29: ldc 23
        //   31: iconst_0
        //   32: invokevirtual 29	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   35: astore 9
        //   37: aload 9
        //   39: new 31	java/lang/StringBuilder
        //   42: dup
        //   43: invokespecial 32	java/lang/StringBuilder:<init>	()V
        //   46: ldc 34
        //   48: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   51: aload_1
        //   52: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   55: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   58: iconst_1
        //   59: invokeinterface 48 3 0
        //   64: istore 5
        //   66: aload 9
        //   68: ldc 50
        //   70: aconst_null
        //   71: invokeinterface 54 3 0
        //   76: astore 10
        //   78: new 56	java/util/TreeMap
        //   81: dup
        //   82: invokespecial 57	java/util/TreeMap:<init>	()V
        //   85: astore 8
        //   87: aload_2
        //   88: ifnull +14 -> 102
        //   91: aload_2
        //   92: aload 8
        //   94: invokevirtual 62	com/millennialmedia/android/MMRequest:a	(Ljava/util/Map;)V
        //   97: aload 8
        //   99: invokestatic 65	com/millennialmedia/android/MMRequest:b	(Ljava/util/Map;)V
        //   102: aload 10
        //   104: ifnull +55 -> 159
        //   107: aload 10
        //   109: ldc 67
        //   111: invokevirtual 71	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   114: astore_2
        //   115: aload_2
        //   116: arraylength
        //   117: istore 4
        //   119: iload_3
        //   120: iload 4
        //   122: if_icmpge +37 -> 159
        //   125: aload_2
        //   126: iload_3
        //   127: aaload
        //   128: ldc 73
        //   130: invokevirtual 71	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   133: astore 10
        //   135: aload 10
        //   137: arraylength
        //   138: iconst_2
        //   139: if_icmplt +250 -> 389
        //   142: aload 8
        //   144: aload 10
        //   146: iconst_0
        //   147: aaload
        //   148: aload 10
        //   150: iconst_1
        //   151: aaload
        //   152: invokevirtual 77	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   155: pop
        //   156: goto +233 -> 389
        //   159: iload 5
        //   161: ifeq +45 -> 206
        //   164: aload 9
        //   166: invokeinterface 81 1 0
        //   171: astore_2
        //   172: aload_2
        //   173: new 31	java/lang/StringBuilder
        //   176: dup
        //   177: invokespecial 32	java/lang/StringBuilder:<init>	()V
        //   180: ldc 34
        //   182: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   185: aload_1
        //   186: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   192: iconst_0
        //   193: invokeinterface 87 3 0
        //   198: pop
        //   199: aload_2
        //   200: invokeinterface 91 1 0
        //   205: pop
        //   206: aload_0
        //   207: invokevirtual 95	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
        //   210: aload_0
        //   211: invokevirtual 98	android/content/Context:getPackageName	()Ljava/lang/String;
        //   214: iconst_0
        //   215: invokevirtual 104	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   218: astore_2
        //   219: aload_2
        //   220: invokevirtual 108	java/lang/Object:getClass	()Ljava/lang/Class;
        //   223: ldc 110
        //   225: invokevirtual 116	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   228: aload_2
        //   229: invokevirtual 122	java/lang/reflect/Field:getLong	(Ljava/lang/Object;)J
        //   232: lstore 6
        //   234: lload 6
        //   236: lconst_0
        //   237: lcmp
        //   238: ifle +148 -> 386
        //   241: new 124	java/util/GregorianCalendar
        //   244: dup
        //   245: invokespecial 125	java/util/GregorianCalendar:<init>	()V
        //   248: astore_2
        //   249: aload_2
        //   250: lload 6
        //   252: invokevirtual 129	java/util/GregorianCalendar:setTimeInMillis	(J)V
        //   255: aload_2
        //   256: ldc -125
        //   258: invokestatic 137	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
        //   261: invokevirtual 141	java/util/GregorianCalendar:setTimeZone	(Ljava/util/TimeZone;)V
        //   264: aload_2
        //   265: invokevirtual 145	java/util/GregorianCalendar:getTimeInMillis	()J
        //   268: lstore 6
        //   270: aload_0
        //   271: invokestatic 150	com/millennialmedia/android/MMSDK:a	(Landroid/content/Context;)Z
        //   274: ifeq +102 -> 376
        //   277: aload 8
        //   279: ldc -104
        //   281: new 31	java/lang/StringBuilder
        //   284: dup
        //   285: invokespecial 32	java/lang/StringBuilder:<init>	()V
        //   288: ldc -102
        //   290: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: getstatic 160	android/os/Build:MODEL	Ljava/lang/String;
        //   296: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   299: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   302: invokevirtual 77	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   305: pop
        //   306: aload 8
        //   308: ldc -94
        //   310: getstatic 166	com/millennialmedia/android/HandShake:a	Ljava/lang/String;
        //   313: invokevirtual 77	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   316: pop
        //   317: aload_0
        //   318: aload 8
        //   320: invokestatic 169	com/millennialmedia/android/MMSDK:a	(Landroid/content/Context;Ljava/util/Map;)V
        //   323: new 171	com/millennialmedia/android/MMConversionTracker$1
        //   326: dup
        //   327: aload_1
        //   328: iload 5
        //   330: lload 6
        //   332: aload 8
        //   334: invokespecial 174	com/millennialmedia/android/MMConversionTracker$1:<init>	(Ljava/lang/String;ZJLjava/util/TreeMap;)V
        //   337: invokestatic 179	com/millennialmedia/android/Utils$ThreadUtils:a	(Ljava/lang/Runnable;)V
        //   340: goto -316 -> 24
        //   343: astore_0
        //   344: ldc 2
        //   346: monitorexit
        //   347: aload_0
        //   348: athrow
        //   349: astore_2
        //   350: ldc -75
        //   352: ldc -73
        //   354: aload_2
        //   355: invokestatic 188	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   358: lconst_0
        //   359: lstore 6
        //   361: goto -127 -> 234
        //   364: astore_2
        //   365: ldc -75
        //   367: ldc -66
        //   369: aload_2
        //   370: invokestatic 188	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   373: goto -15 -> 358
        //   376: ldc -75
        //   378: ldc -64
        //   380: invokestatic 196	com/millennialmedia/android/MMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   383: goto -359 -> 24
        //   386: goto -116 -> 270
        //   389: iload_3
        //   390: iconst_1
        //   391: iadd
        //   392: istore_3
        //   393: goto -274 -> 119
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	396	0	paramContext	android.content.Context
        //   0	396	1	paramString	String
        //   0	396	2	paramMMRequest	MMRequest
        //   1	392	3	i	int
        //   17	106	4	j	int
        //   64	265	5	bool	boolean
        //   232	128	6	l	long
        //   85	248	8	localTreeMap	java.util.TreeMap
        //   35	130	9	localSharedPreferences	android.content.SharedPreferences
        //   76	73	10	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	19	343	finally
        //   28	87	343	finally
        //   91	102	343	finally
        //   107	119	343	finally
        //   125	156	343	finally
        //   164	206	343	finally
        //   206	219	343	finally
        //   219	234	343	finally
        //   241	270	343	finally
        //   270	340	343	finally
        //   350	358	343	finally
        //   365	373	343	finally
        //   376	383	343	finally
        //   219	234	349	java/lang/Exception
        //   206	219	364	android/content/pm/PackageManager$NameNotFoundException
        //   219	234	364	android/content/pm/PackageManager$NameNotFoundException
        //   350	358	364	android/content/pm/PackageManager$NameNotFoundException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMConversionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */