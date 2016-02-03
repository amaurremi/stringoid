package com.appbrain;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.appbrain.a.aa;

public class ReferrerReceiver
  extends BroadcastReceiver
{
  public static String retrieve(Context paramContext)
  {
    aa.a().a(paramContext, false);
    return aa.a().m();
  }
  
  /* Error */
  public void onReceive(Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 38
    //   3: invokevirtual 44	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +219 -> 229
    //   13: new 46	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 47	java/util/ArrayList:<init>	()V
    //   20: astore 4
    //   22: aload_1
    //   23: invokevirtual 53	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   26: new 55	android/content/ComponentName
    //   29: dup
    //   30: aload_1
    //   31: ldc 2
    //   33: invokespecial 58	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   36: sipush 128
    //   39: invokevirtual 64	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +685 -> 731
    //   49: aload 5
    //   51: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   54: ifnull +677 -> 731
    //   57: aload 5
    //   59: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   62: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   65: ifnull +666 -> 731
    //   68: aload 5
    //   70: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   73: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   76: invokeinterface 82 1 0
    //   81: ifne +4 -> 85
    //   84: return
    //   85: aload 5
    //   87: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   90: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   93: invokeinterface 86 1 0
    //   98: astore 6
    //   100: aload 6
    //   102: invokeinterface 92 1 0
    //   107: ifeq +53 -> 160
    //   110: aload 6
    //   112: invokeinterface 96 1 0
    //   117: checkcast 98	java/lang/String
    //   120: astore 7
    //   122: aload 7
    //   124: ldc 100
    //   126: invokevirtual 104	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   129: ifeq -29 -> 100
    //   132: aload 4
    //   134: aload 5
    //   136: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   139: aload 7
    //   141: invokevirtual 107	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: invokeinterface 113 2 0
    //   149: pop
    //   150: goto -50 -> 100
    //   153: astore 5
    //   155: aload 5
    //   157: invokevirtual 116	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   160: aload 4
    //   162: invokeinterface 117 1 0
    //   167: astore 4
    //   169: aload 4
    //   171: invokeinterface 92 1 0
    //   176: ifeq +555 -> 731
    //   179: aload 4
    //   181: invokeinterface 96 1 0
    //   186: checkcast 98	java/lang/String
    //   189: astore 5
    //   191: aload 5
    //   193: invokestatic 123	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   196: invokevirtual 126	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   199: astore 5
    //   201: aload 5
    //   203: instanceof 4
    //   206: istore_3
    //   207: iload_3
    //   208: ifeq -39 -> 169
    //   211: aload 5
    //   213: checkcast 4	android/content/BroadcastReceiver
    //   216: aload_1
    //   217: aload_2
    //   218: invokevirtual 128	android/content/BroadcastReceiver:onReceive	(Landroid/content/Context;Landroid/content/Intent;)V
    //   221: goto -52 -> 169
    //   224: astore 5
    //   226: goto -57 -> 169
    //   229: invokestatic 17	com/appbrain/a/aa:a	()Lcom/appbrain/a/aa;
    //   232: aload_1
    //   233: iconst_0
    //   234: invokevirtual 20	com/appbrain/a/aa:a	(Landroid/content/Context;Z)V
    //   237: invokestatic 17	com/appbrain/a/aa:a	()Lcom/appbrain/a/aa;
    //   240: aload 4
    //   242: invokevirtual 132	com/appbrain/a/aa:b	(Ljava/lang/String;)V
    //   245: new 46	java/util/ArrayList
    //   248: dup
    //   249: invokespecial 47	java/util/ArrayList:<init>	()V
    //   252: astore 4
    //   254: aload_1
    //   255: invokevirtual 53	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   258: new 55	android/content/ComponentName
    //   261: dup
    //   262: aload_1
    //   263: ldc 2
    //   265: invokespecial 58	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   268: sipush 128
    //   271: invokevirtual 64	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   274: astore 5
    //   276: aload 5
    //   278: ifnull +453 -> 731
    //   281: aload 5
    //   283: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   286: ifnull +445 -> 731
    //   289: aload 5
    //   291: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   294: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   297: ifnull +434 -> 731
    //   300: aload 5
    //   302: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   305: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   308: invokeinterface 82 1 0
    //   313: ifeq +418 -> 731
    //   316: aload 5
    //   318: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   321: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   324: invokeinterface 86 1 0
    //   329: astore 6
    //   331: aload 6
    //   333: invokeinterface 92 1 0
    //   338: ifeq +53 -> 391
    //   341: aload 6
    //   343: invokeinterface 96 1 0
    //   348: checkcast 98	java/lang/String
    //   351: astore 7
    //   353: aload 7
    //   355: ldc 100
    //   357: invokevirtual 104	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   360: ifeq -29 -> 331
    //   363: aload 4
    //   365: aload 5
    //   367: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   370: aload 7
    //   372: invokevirtual 107	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   375: invokeinterface 113 2 0
    //   380: pop
    //   381: goto -50 -> 331
    //   384: astore 5
    //   386: aload 5
    //   388: invokevirtual 116	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   391: aload 4
    //   393: invokeinterface 117 1 0
    //   398: astore 4
    //   400: aload 4
    //   402: invokeinterface 92 1 0
    //   407: ifeq +324 -> 731
    //   410: aload 4
    //   412: invokeinterface 96 1 0
    //   417: checkcast 98	java/lang/String
    //   420: astore 5
    //   422: aload 5
    //   424: invokestatic 123	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   427: invokevirtual 126	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   430: astore 5
    //   432: aload 5
    //   434: instanceof 4
    //   437: istore_3
    //   438: iload_3
    //   439: ifeq -39 -> 400
    //   442: aload 5
    //   444: checkcast 4	android/content/BroadcastReceiver
    //   447: aload_1
    //   448: aload_2
    //   449: invokevirtual 128	android/content/BroadcastReceiver:onReceive	(Landroid/content/Context;Landroid/content/Intent;)V
    //   452: goto -52 -> 400
    //   455: astore 5
    //   457: goto -57 -> 400
    //   460: astore 4
    //   462: new 46	java/util/ArrayList
    //   465: dup
    //   466: invokespecial 47	java/util/ArrayList:<init>	()V
    //   469: astore 5
    //   471: aload_1
    //   472: invokevirtual 53	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   475: new 55	android/content/ComponentName
    //   478: dup
    //   479: aload_1
    //   480: ldc 2
    //   482: invokespecial 58	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   485: sipush 128
    //   488: invokevirtual 64	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   491: astore 6
    //   493: aload 6
    //   495: ifnull +236 -> 731
    //   498: aload 6
    //   500: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   503: ifnull +228 -> 731
    //   506: aload 6
    //   508: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   511: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   514: ifnull +217 -> 731
    //   517: aload 6
    //   519: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   522: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   525: invokeinterface 82 1 0
    //   530: ifeq +201 -> 731
    //   533: aload 6
    //   535: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   538: invokevirtual 76	android/os/Bundle:keySet	()Ljava/util/Set;
    //   541: invokeinterface 86 1 0
    //   546: astore 7
    //   548: aload 7
    //   550: invokeinterface 92 1 0
    //   555: ifeq +53 -> 608
    //   558: aload 7
    //   560: invokeinterface 96 1 0
    //   565: checkcast 98	java/lang/String
    //   568: astore 8
    //   570: aload 8
    //   572: ldc 100
    //   574: invokevirtual 104	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   577: ifeq -29 -> 548
    //   580: aload 5
    //   582: aload 6
    //   584: getfield 70	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   587: aload 8
    //   589: invokevirtual 107	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   592: invokeinterface 113 2 0
    //   597: pop
    //   598: goto -50 -> 548
    //   601: astore 6
    //   603: aload 6
    //   605: invokevirtual 116	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   608: aload 5
    //   610: invokeinterface 117 1 0
    //   615: astore 5
    //   617: aload 5
    //   619: invokeinterface 92 1 0
    //   624: ifeq +53 -> 677
    //   627: aload 5
    //   629: invokeinterface 96 1 0
    //   634: checkcast 98	java/lang/String
    //   637: astore 6
    //   639: aload 6
    //   641: invokestatic 123	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   644: invokevirtual 126	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   647: astore 6
    //   649: aload 6
    //   651: instanceof 4
    //   654: istore_3
    //   655: iload_3
    //   656: ifeq -39 -> 617
    //   659: aload 6
    //   661: checkcast 4	android/content/BroadcastReceiver
    //   664: aload_1
    //   665: aload_2
    //   666: invokevirtual 128	android/content/BroadcastReceiver:onReceive	(Landroid/content/Context;Landroid/content/Intent;)V
    //   669: goto -52 -> 617
    //   672: astore 6
    //   674: goto -57 -> 617
    //   677: aload 4
    //   679: athrow
    //   680: astore_1
    //   681: aload_1
    //   682: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   685: return
    //   686: astore 6
    //   688: goto -71 -> 617
    //   691: astore 6
    //   693: goto -76 -> 617
    //   696: astore 6
    //   698: goto -81 -> 617
    //   701: astore 5
    //   703: goto -303 -> 400
    //   706: astore 5
    //   708: goto -308 -> 400
    //   711: astore 5
    //   713: goto -313 -> 400
    //   716: astore 5
    //   718: goto -549 -> 169
    //   721: astore 5
    //   723: goto -554 -> 169
    //   726: astore 5
    //   728: goto -559 -> 169
    //   731: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	this	ReferrerReceiver
    //   0	732	1	paramContext	Context
    //   0	732	2	paramIntent	android.content.Intent
    //   206	450	3	bool	boolean
    //   6	405	4	localObject1	Object
    //   460	218	4	localObject2	Object
    //   42	93	5	localActivityInfo1	android.content.pm.ActivityInfo
    //   153	3	5	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   189	23	5	localObject3	Object
    //   224	1	5	localThrowable1	Throwable
    //   274	92	5	localActivityInfo2	android.content.pm.ActivityInfo
    //   384	3	5	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   420	23	5	localObject4	Object
    //   455	1	5	localThrowable2	Throwable
    //   469	159	5	localObject5	Object
    //   701	1	5	localIllegalAccessException1	IllegalAccessException
    //   706	1	5	localInstantiationException1	InstantiationException
    //   711	1	5	localClassNotFoundException1	ClassNotFoundException
    //   716	1	5	localIllegalAccessException2	IllegalAccessException
    //   721	1	5	localInstantiationException2	InstantiationException
    //   726	1	5	localClassNotFoundException2	ClassNotFoundException
    //   98	485	6	localObject6	Object
    //   601	3	6	localNameNotFoundException3	android.content.pm.PackageManager.NameNotFoundException
    //   637	23	6	localObject7	Object
    //   672	1	6	localThrowable3	Throwable
    //   686	1	6	localIllegalAccessException3	IllegalAccessException
    //   691	1	6	localInstantiationException3	InstantiationException
    //   696	1	6	localClassNotFoundException3	ClassNotFoundException
    //   120	439	7	localObject8	Object
    //   568	20	8	str	String
    // Exception table:
    //   from	to	target	type
    //   22	44	153	android/content/pm/PackageManager$NameNotFoundException
    //   49	84	153	android/content/pm/PackageManager$NameNotFoundException
    //   85	100	153	android/content/pm/PackageManager$NameNotFoundException
    //   100	150	153	android/content/pm/PackageManager$NameNotFoundException
    //   211	221	224	java/lang/Throwable
    //   254	276	384	android/content/pm/PackageManager$NameNotFoundException
    //   281	331	384	android/content/pm/PackageManager$NameNotFoundException
    //   331	381	384	android/content/pm/PackageManager$NameNotFoundException
    //   442	452	455	java/lang/Throwable
    //   0	8	460	finally
    //   229	245	460	finally
    //   471	493	601	android/content/pm/PackageManager$NameNotFoundException
    //   498	548	601	android/content/pm/PackageManager$NameNotFoundException
    //   548	598	601	android/content/pm/PackageManager$NameNotFoundException
    //   659	669	672	java/lang/Throwable
    //   13	22	680	java/lang/Throwable
    //   22	44	680	java/lang/Throwable
    //   49	84	680	java/lang/Throwable
    //   85	100	680	java/lang/Throwable
    //   100	150	680	java/lang/Throwable
    //   155	160	680	java/lang/Throwable
    //   160	169	680	java/lang/Throwable
    //   169	191	680	java/lang/Throwable
    //   191	207	680	java/lang/Throwable
    //   245	254	680	java/lang/Throwable
    //   254	276	680	java/lang/Throwable
    //   281	331	680	java/lang/Throwable
    //   331	381	680	java/lang/Throwable
    //   386	391	680	java/lang/Throwable
    //   391	400	680	java/lang/Throwable
    //   400	422	680	java/lang/Throwable
    //   422	438	680	java/lang/Throwable
    //   462	471	680	java/lang/Throwable
    //   471	493	680	java/lang/Throwable
    //   498	548	680	java/lang/Throwable
    //   548	598	680	java/lang/Throwable
    //   603	608	680	java/lang/Throwable
    //   608	617	680	java/lang/Throwable
    //   617	639	680	java/lang/Throwable
    //   639	655	680	java/lang/Throwable
    //   677	680	680	java/lang/Throwable
    //   639	655	686	java/lang/IllegalAccessException
    //   659	669	686	java/lang/IllegalAccessException
    //   639	655	691	java/lang/InstantiationException
    //   659	669	691	java/lang/InstantiationException
    //   639	655	696	java/lang/ClassNotFoundException
    //   659	669	696	java/lang/ClassNotFoundException
    //   422	438	701	java/lang/IllegalAccessException
    //   442	452	701	java/lang/IllegalAccessException
    //   422	438	706	java/lang/InstantiationException
    //   442	452	706	java/lang/InstantiationException
    //   422	438	711	java/lang/ClassNotFoundException
    //   442	452	711	java/lang/ClassNotFoundException
    //   191	207	716	java/lang/IllegalAccessException
    //   211	221	716	java/lang/IllegalAccessException
    //   191	207	721	java/lang/InstantiationException
    //   211	221	721	java/lang/InstantiationException
    //   191	207	726	java/lang/ClassNotFoundException
    //   211	221	726	java/lang/ClassNotFoundException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/ReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */