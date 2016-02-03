package b.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public abstract class b
  implements e
{
  private String a;
  private String b;
  private String c;
  private b.a.c.a d;
  private Map e;
  private boolean f;
  private transient f g;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = new b.a.c.a();
    this.e = new HashMap();
  }
  
  protected abstract b.a.c.b a(String paramString);
  
  protected abstract b.a.c.c a(b.a.c.b paramb);
  
  /* Error */
  public String a(d paramd, String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aconst_null
    //   4: aconst_null
    //   5: invokeinterface 48 3 0
    //   10: new 31	b/a/c/a
    //   13: dup
    //   14: invokespecial 32	b/a/c/a:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: aload_3
    //   22: iconst_1
    //   23: invokevirtual 51	b/a/c/a:a	([Ljava/lang/String;Z)V
    //   26: aload 4
    //   28: ldc 53
    //   30: aload_2
    //   31: iconst_1
    //   32: invokevirtual 56	b/a/c/a:a	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   35: pop
    //   36: aload_0
    //   37: aload_1
    //   38: aload_0
    //   39: getfield 25	b/a/b:a	Ljava/lang/String;
    //   42: aload 4
    //   44: invokevirtual 59	b/a/b:a	(Lb/a/d;Ljava/lang/String;Lb/a/c/a;)V
    //   47: aload_0
    //   48: getfield 34	b/a/b:d	Lb/a/c/a;
    //   51: ldc 61
    //   53: invokevirtual 64	b/a/c/a:b	(Ljava/lang/Object;)Ljava/lang/String;
    //   56: astore_3
    //   57: aload_0
    //   58: getfield 34	b/a/b:d	Lb/a/c/a;
    //   61: ldc 61
    //   63: invokevirtual 67	b/a/c/a:c	(Ljava/lang/Object;)Ljava/util/SortedSet;
    //   66: pop
    //   67: aload_0
    //   68: getstatic 73	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   71: invokevirtual 77	java/lang/Boolean:toString	()Ljava/lang/String;
    //   74: aload_3
    //   75: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: putfield 85	b/a/b:f	Z
    //   81: aload_0
    //   82: getfield 85	b/a/b:f	Z
    //   85: ifeq +33 -> 118
    //   88: aload_0
    //   89: getfield 29	b/a/b:c	Ljava/lang/String;
    //   92: iconst_2
    //   93: anewarray 79	java/lang/String
    //   96: dup
    //   97: iconst_0
    //   98: ldc 87
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload_1
    //   104: invokeinterface 89 1 0
    //   109: aastore
    //   110: invokestatic 94	b/a/c:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: areturn
    //   118: aload_0
    //   119: getfield 29	b/a/b:c	Ljava/lang/String;
    //   122: iconst_4
    //   123: anewarray 79	java/lang/String
    //   126: dup
    //   127: iconst_0
    //   128: ldc 87
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: aload_1
    //   134: invokeinterface 89 1 0
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: ldc 53
    //   144: aastore
    //   145: dup
    //   146: iconst_3
    //   147: aload_2
    //   148: aastore
    //   149: invokestatic 94	b/a/c:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   152: astore_1
    //   153: goto -39 -> 114
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	b
    //   0	161	1	paramd	d
    //   0	161	2	paramString	String
    //   0	161	3	paramVarArgs	String[]
    //   17	26	4	locala	b.a.c.a
    // Exception table:
    //   from	to	target	type
    //   2	114	156	finally
    //   118	153	156	finally
  }
  
  public Map a()
  {
    return this.e;
  }
  
  protected void a(int paramInt, b.a.c.c paramc)
  {
    if (paramc == null) {
      return;
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramc.a()));
    StringBuilder localStringBuilder = new StringBuilder();
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    switch (paramInt)
    {
    default: 
      throw new b.a.b.a("Service provider responded in error: " + paramInt + " (" + paramc.c() + ")", localStringBuilder.toString());
    }
    throw new b.a.b.e(localStringBuilder.toString());
  }
  
  public void a(b.a.c.a parama)
  {
    this.d = parama;
  }
  
  protected void a(b.a.c.b paramb, b.a.c.c paramc) {}
  
  /* Error */
  protected void a(d paramd, String paramString, b.a.c.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 150	b/a/b:a	()Ljava/util/Map;
    //   7: astore 7
    //   9: aload_1
    //   10: invokeinterface 151 1 0
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: invokeinterface 153 1 0
    //   24: ifnonnull +13 -> 37
    //   27: new 146	b/a/b/c
    //   30: dup
    //   31: ldc -101
    //   33: invokespecial 156	b/a/b/c:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: aload_0
    //   38: aload_2
    //   39: invokevirtual 158	b/a/b:a	(Ljava/lang/String;)Lb/a/c/b;
    //   42: astore_2
    //   43: aload 7
    //   45: invokeinterface 164 1 0
    //   50: invokeinterface 170 1 0
    //   55: astore 6
    //   57: aload 6
    //   59: invokeinterface 176 1 0
    //   64: ifeq +64 -> 128
    //   67: aload 6
    //   69: invokeinterface 180 1 0
    //   74: checkcast 79	java/lang/String
    //   77: astore 8
    //   79: aload_2
    //   80: aload 8
    //   82: aload 7
    //   84: aload 8
    //   86: invokeinterface 184 2 0
    //   91: checkcast 79	java/lang/String
    //   94: invokeinterface 187 3 0
    //   99: goto -42 -> 57
    //   102: astore 6
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_2
    //   107: astore_1
    //   108: aload 6
    //   110: astore_2
    //   111: aload_2
    //   112: athrow
    //   113: astore 6
    //   115: aload_1
    //   116: astore_2
    //   117: aload 6
    //   119: astore_1
    //   120: aload_0
    //   121: aload_2
    //   122: aload_3
    //   123: invokevirtual 189	b/a/b:a	(Lb/a/c/b;Lb/a/c/c;)V
    //   126: aload_1
    //   127: athrow
    //   128: aload_3
    //   129: ifnull +17 -> 146
    //   132: aload_3
    //   133: invokevirtual 192	b/a/c/a:isEmpty	()Z
    //   136: ifne +10 -> 146
    //   139: aload_1
    //   140: aload_3
    //   141: invokeinterface 194 2 0
    //   146: aload_0
    //   147: getfield 196	b/a/b:g	Lb/a/f;
    //   150: ifnull +13 -> 163
    //   153: aload_0
    //   154: getfield 196	b/a/b:g	Lb/a/f;
    //   157: aload_2
    //   158: invokeinterface 201 2 0
    //   163: aload_1
    //   164: aload_2
    //   165: invokeinterface 204 2 0
    //   170: pop
    //   171: aload_0
    //   172: getfield 196	b/a/b:g	Lb/a/f;
    //   175: ifnull +13 -> 188
    //   178: aload_0
    //   179: getfield 196	b/a/b:g	Lb/a/f;
    //   182: aload_2
    //   183: invokeinterface 206 2 0
    //   188: aload_0
    //   189: aload_2
    //   190: invokevirtual 208	b/a/b:a	(Lb/a/c/b;)Lb/a/c/c;
    //   193: astore_3
    //   194: aload_3
    //   195: astore 6
    //   197: aload_2
    //   198: astore 7
    //   200: aload_3
    //   201: invokeinterface 211 1 0
    //   206: istore 4
    //   208: iconst_0
    //   209: istore 5
    //   211: aload_3
    //   212: astore 6
    //   214: aload_2
    //   215: astore 7
    //   217: aload_0
    //   218: getfield 196	b/a/b:g	Lb/a/f;
    //   221: ifnull +22 -> 243
    //   224: aload_3
    //   225: astore 6
    //   227: aload_2
    //   228: astore 7
    //   230: aload_0
    //   231: getfield 196	b/a/b:g	Lb/a/f;
    //   234: aload_2
    //   235: aload_3
    //   236: invokeinterface 214 3 0
    //   241: istore 5
    //   243: iload 5
    //   245: ifeq +20 -> 265
    //   248: aload_0
    //   249: aload_2
    //   250: aload_3
    //   251: invokevirtual 189	b/a/b:a	(Lb/a/c/b;Lb/a/c/c;)V
    //   254: return
    //   255: astore_1
    //   256: new 123	b/a/b/a
    //   259: dup
    //   260: aload_1
    //   261: invokespecial 217	b/a/b/a:<init>	(Ljava/lang/Exception;)V
    //   264: athrow
    //   265: iload 4
    //   267: sipush 300
    //   270: if_icmplt +16 -> 286
    //   273: aload_3
    //   274: astore 6
    //   276: aload_2
    //   277: astore 7
    //   279: aload_0
    //   280: iload 4
    //   282: aload_3
    //   283: invokevirtual 219	b/a/b:a	(ILb/a/c/c;)V
    //   286: aload_3
    //   287: astore 6
    //   289: aload_2
    //   290: astore 7
    //   292: aload_3
    //   293: invokeinterface 105 1 0
    //   298: invokestatic 222	b/a/c:a	(Ljava/io/InputStream;)Lb/a/c/a;
    //   301: astore 8
    //   303: aload_3
    //   304: astore 6
    //   306: aload_2
    //   307: astore 7
    //   309: aload 8
    //   311: ldc 87
    //   313: invokevirtual 64	b/a/c/a:b	(Ljava/lang/Object;)Ljava/lang/String;
    //   316: astore 9
    //   318: aload_3
    //   319: astore 6
    //   321: aload_2
    //   322: astore 7
    //   324: aload 8
    //   326: ldc -32
    //   328: invokevirtual 64	b/a/c/a:b	(Ljava/lang/Object;)Ljava/lang/String;
    //   331: astore 10
    //   333: aload_3
    //   334: astore 6
    //   336: aload_2
    //   337: astore 7
    //   339: aload 8
    //   341: ldc 87
    //   343: invokevirtual 67	b/a/c/a:c	(Ljava/lang/Object;)Ljava/util/SortedSet;
    //   346: pop
    //   347: aload_3
    //   348: astore 6
    //   350: aload_2
    //   351: astore 7
    //   353: aload 8
    //   355: ldc -32
    //   357: invokevirtual 67	b/a/c/a:c	(Ljava/lang/Object;)Ljava/util/SortedSet;
    //   360: pop
    //   361: aload_3
    //   362: astore 6
    //   364: aload_2
    //   365: astore 7
    //   367: aload_0
    //   368: aload 8
    //   370: invokevirtual 225	b/a/b:a	(Lb/a/c/a;)V
    //   373: aload 9
    //   375: ifnull +8 -> 383
    //   378: aload 10
    //   380: ifnonnull +19 -> 399
    //   383: aload_3
    //   384: astore 6
    //   386: aload_2
    //   387: astore 7
    //   389: new 146	b/a/b/c
    //   392: dup
    //   393: ldc -29
    //   395: invokespecial 156	b/a/b/c:<init>	(Ljava/lang/String;)V
    //   398: athrow
    //   399: aload_3
    //   400: astore 6
    //   402: aload_2
    //   403: astore 7
    //   405: aload_1
    //   406: aload 9
    //   408: aload 10
    //   410: invokeinterface 48 3 0
    //   415: aload_0
    //   416: aload_2
    //   417: aload_3
    //   418: invokevirtual 189	b/a/b:a	(Lb/a/c/b;Lb/a/c/c;)V
    //   421: return
    //   422: astore_1
    //   423: new 123	b/a/b/a
    //   426: dup
    //   427: aload_1
    //   428: invokespecial 217	b/a/b/a:<init>	(Ljava/lang/Exception;)V
    //   431: athrow
    //   432: astore_1
    //   433: aconst_null
    //   434: astore_3
    //   435: aconst_null
    //   436: astore_2
    //   437: aload_3
    //   438: astore 6
    //   440: aload_2
    //   441: astore 7
    //   443: aload_1
    //   444: athrow
    //   445: aload_3
    //   446: astore 6
    //   448: aload_2
    //   449: astore 7
    //   451: new 123	b/a/b/a
    //   454: dup
    //   455: aload_1
    //   456: invokespecial 217	b/a/b/a:<init>	(Ljava/lang/Exception;)V
    //   459: athrow
    //   460: astore_1
    //   461: new 123	b/a/b/a
    //   464: dup
    //   465: aload_1
    //   466: invokespecial 217	b/a/b/a:<init>	(Ljava/lang/Exception;)V
    //   469: athrow
    //   470: astore_1
    //   471: aconst_null
    //   472: astore_3
    //   473: aconst_null
    //   474: astore_2
    //   475: goto -355 -> 120
    //   478: astore_1
    //   479: aconst_null
    //   480: astore_3
    //   481: goto -361 -> 120
    //   484: astore_1
    //   485: aconst_null
    //   486: astore_3
    //   487: goto -42 -> 445
    //   490: astore_1
    //   491: goto -46 -> 445
    //   494: astore_1
    //   495: aconst_null
    //   496: astore_3
    //   497: goto -60 -> 437
    //   500: astore_1
    //   501: goto -64 -> 437
    //   504: astore_2
    //   505: aconst_null
    //   506: astore_3
    //   507: aload 6
    //   509: astore_1
    //   510: goto -399 -> 111
    //   513: astore 6
    //   515: aload_2
    //   516: astore_1
    //   517: aload 6
    //   519: astore_2
    //   520: goto -409 -> 111
    //   523: astore_1
    //   524: aload 6
    //   526: astore_3
    //   527: aload 7
    //   529: astore_2
    //   530: goto -410 -> 120
    //   533: astore_1
    //   534: aconst_null
    //   535: astore_3
    //   536: aconst_null
    //   537: astore_2
    //   538: goto -93 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	b
    //   0	541	1	paramd	d
    //   0	541	2	paramString	String
    //   0	541	3	parama	b.a.c.a
    //   206	75	4	i	int
    //   209	35	5	bool	boolean
    //   1	67	6	localIterator	java.util.Iterator
    //   102	7	6	locale1	b.a.b.e
    //   113	5	6	localObject1	Object
    //   195	313	6	locala	b.a.c.a
    //   513	12	6	locale2	b.a.b.e
    //   7	521	7	localObject2	Object
    //   77	292	8	localObject3	Object
    //   316	91	9	str1	String
    //   331	78	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   43	57	102	b/a/b/e
    //   57	99	102	b/a/b/e
    //   132	146	102	b/a/b/e
    //   146	163	102	b/a/b/e
    //   163	188	102	b/a/b/e
    //   188	194	102	b/a/b/e
    //   111	113	113	finally
    //   248	254	255	java/lang/Exception
    //   415	421	422	java/lang/Exception
    //   37	43	432	b/a/b/c
    //   120	126	460	java/lang/Exception
    //   37	43	470	finally
    //   43	57	478	finally
    //   57	99	478	finally
    //   132	146	478	finally
    //   146	163	478	finally
    //   163	188	478	finally
    //   188	194	478	finally
    //   43	57	484	java/lang/Exception
    //   57	99	484	java/lang/Exception
    //   132	146	484	java/lang/Exception
    //   146	163	484	java/lang/Exception
    //   163	188	484	java/lang/Exception
    //   188	194	484	java/lang/Exception
    //   200	208	490	java/lang/Exception
    //   217	224	490	java/lang/Exception
    //   230	243	490	java/lang/Exception
    //   279	286	490	java/lang/Exception
    //   292	303	490	java/lang/Exception
    //   309	318	490	java/lang/Exception
    //   324	333	490	java/lang/Exception
    //   339	347	490	java/lang/Exception
    //   353	361	490	java/lang/Exception
    //   367	373	490	java/lang/Exception
    //   389	399	490	java/lang/Exception
    //   405	415	490	java/lang/Exception
    //   43	57	494	b/a/b/c
    //   57	99	494	b/a/b/c
    //   132	146	494	b/a/b/c
    //   146	163	494	b/a/b/c
    //   163	188	494	b/a/b/c
    //   188	194	494	b/a/b/c
    //   200	208	500	b/a/b/c
    //   217	224	500	b/a/b/c
    //   230	243	500	b/a/b/c
    //   279	286	500	b/a/b/c
    //   292	303	500	b/a/b/c
    //   309	318	500	b/a/b/c
    //   324	333	500	b/a/b/c
    //   339	347	500	b/a/b/c
    //   353	361	500	b/a/b/c
    //   367	373	500	b/a/b/c
    //   389	399	500	b/a/b/c
    //   405	415	500	b/a/b/c
    //   37	43	504	b/a/b/e
    //   200	208	513	b/a/b/e
    //   217	224	513	b/a/b/e
    //   230	243	513	b/a/b/e
    //   279	286	513	b/a/b/e
    //   292	303	513	b/a/b/e
    //   309	318	513	b/a/b/e
    //   324	333	513	b/a/b/e
    //   339	347	513	b/a/b/e
    //   353	361	513	b/a/b/e
    //   367	373	513	b/a/b/e
    //   389	399	513	b/a/b/e
    //   405	415	513	b/a/b/e
    //   200	208	523	finally
    //   217	224	523	finally
    //   230	243	523	finally
    //   279	286	523	finally
    //   292	303	523	finally
    //   309	318	523	finally
    //   324	333	523	finally
    //   339	347	523	finally
    //   353	361	523	finally
    //   367	373	523	finally
    //   389	399	523	finally
    //   405	415	523	finally
    //   443	445	523	finally
    //   451	460	523	finally
    //   37	43	533	java/lang/Exception
  }
  
  public void b(d paramd, String paramString, String... paramVarArgs)
  {
    b.a.c.a locala;
    try
    {
      if ((paramd.a() == null) || (paramd.b() == null)) {
        throw new b.a.b.c("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
      }
    }
    finally
    {
      throw paramd;
      locala = new b.a.c.a();
      locala.a(paramVarArgs, true);
      if ((this.f) && (paramString != null)) {
        locala.a("oauth_verifier", paramString, true);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */