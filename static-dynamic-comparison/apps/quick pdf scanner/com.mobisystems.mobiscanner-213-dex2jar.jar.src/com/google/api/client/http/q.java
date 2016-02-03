package com.google.api.client.http;

import com.google.api.client.util.z;

public final class q
{
  private z ZG = z.aef;
  private final w ZP;
  private String aaB;
  private com.google.api.client.util.v aaw;
  private o abA;
  private u abB;
  @Deprecated
  private c abC;
  private boolean abD = true;
  private boolean abE = true;
  @Deprecated
  private boolean abF = false;
  private boolean abG;
  private k aba;
  private m abo;
  private n abp = new n();
  private n abq = new n();
  private int abr = 10;
  private int abs = 16384;
  private boolean abt = true;
  private boolean abu = true;
  private j abv;
  private i abw;
  private int abx = 20000;
  private int aby = 20000;
  private x abz;
  
  q(w paramw, String paramString)
  {
    this.ZP = paramw;
    cf(paramString);
  }
  
  @Deprecated
  public q a(c paramc)
  {
    this.abC = paramc;
    return this;
  }
  
  public q a(k paramk)
  {
    this.aba = paramk;
    return this;
  }
  
  public q a(m paramm)
  {
    this.abo = paramm;
    return this;
  }
  
  public q a(o paramo)
  {
    this.abA = paramo;
    return this;
  }
  
  public q a(u paramu)
  {
    this.abB = paramu;
    return this;
  }
  
  public q a(x paramx)
  {
    this.abz = paramx;
    return this;
  }
  
  public q a(com.google.api.client.util.v paramv)
  {
    this.aaw = paramv;
    return this;
  }
  
  public boolean a(int paramInt, n paramn)
  {
    paramn = paramn.getLocation();
    if ((getFollowRedirects()) && (v.eH(paramInt)) && (paramn != null))
    {
      e(new i(this.abw.bK(paramn)));
      if (paramInt == 303) {
        cf("GET");
      }
      this.abp.bP((String)null);
      this.abp.bU((String)null);
      this.abp.bV((String)null);
      this.abp.bT((String)null);
      this.abp.bW((String)null);
      this.abp.bX((String)null);
      return true;
    }
    return false;
  }
  
  public q as(boolean paramBoolean)
  {
    this.abE = paramBoolean;
    return this;
  }
  
  public q c(j paramj)
  {
    this.abv = paramj;
    return this;
  }
  
  public q cf(String paramString)
  {
    if ((paramString == null) || (p.cd(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.api.client.util.x.av(bool);
      this.aaB = paramString;
      return this;
    }
  }
  
  public q e(i parami)
  {
    this.abw = ((i)com.google.api.client.util.x.ad(parami));
    return this;
  }
  
  public boolean getFollowRedirects()
  {
    return this.abD;
  }
  
  public String getRequestMethod()
  {
    return this.aaB;
  }
  
  public int xA()
  {
    return this.abs;
  }
  
  public boolean xB()
  {
    return this.abt;
  }
  
  public n xC()
  {
    return this.abp;
  }
  
  public n xD()
  {
    return this.abq;
  }
  
  public x xE()
  {
    return this.abz;
  }
  
  public o xF()
  {
    return this.abA;
  }
  
  public u xG()
  {
    return this.abB;
  }
  
  public final com.google.api.client.util.v xH()
  {
    return this.aaw;
  }
  
  public boolean xI()
  {
    return this.abE;
  }
  
  /* Error */
  public t xJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/google/api/client/http/q:abr	I
    //   4: iflt +815 -> 819
    //   7: iconst_1
    //   8: istore 4
    //   10: iload 4
    //   12: invokestatic 182	com/google/api/client/util/x:av	(Z)V
    //   15: aload_0
    //   16: getfield 58	com/google/api/client/http/q:abr	I
    //   19: istore_1
    //   20: aload_0
    //   21: getfield 92	com/google/api/client/http/q:abC	Lcom/google/api/client/http/c;
    //   24: ifnull +12 -> 36
    //   27: aload_0
    //   28: getfield 92	com/google/api/client/http/q:abC	Lcom/google/api/client/http/c;
    //   31: invokeinterface 215 1 0
    //   36: aconst_null
    //   37: astore 9
    //   39: aload_0
    //   40: getfield 184	com/google/api/client/http/q:aaB	Ljava/lang/String;
    //   43: invokestatic 188	com/google/api/client/util/x:ad	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: aload_0
    //   48: getfield 130	com/google/api/client/http/q:abw	Lcom/google/api/client/http/i;
    //   51: invokestatic 188	com/google/api/client/util/x:ad	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload 9
    //   57: ifnull +8 -> 65
    //   60: aload 9
    //   62: invokevirtual 220	com/google/api/client/http/t:xO	()V
    //   65: aload_0
    //   66: getfield 99	com/google/api/client/http/q:abo	Lcom/google/api/client/http/m;
    //   69: ifnull +13 -> 82
    //   72: aload_0
    //   73: getfield 99	com/google/api/client/http/q:abo	Lcom/google/api/client/http/m;
    //   76: aload_0
    //   77: invokeinterface 226 2 0
    //   82: aload_0
    //   83: getfield 130	com/google/api/client/http/q:abw	Lcom/google/api/client/http/i;
    //   86: invokevirtual 229	com/google/api/client/http/i:xo	()Ljava/lang/String;
    //   89: astore 14
    //   91: aload_0
    //   92: getfield 83	com/google/api/client/http/q:ZP	Lcom/google/api/client/http/w;
    //   95: aload_0
    //   96: getfield 184	com/google/api/client/http/q:aaB	Ljava/lang/String;
    //   99: aload 14
    //   101: invokevirtual 235	com/google/api/client/http/w:l	(Ljava/lang/String;Ljava/lang/String;)Lcom/google/api/client/http/z;
    //   104: astore 15
    //   106: getstatic 239	com/google/api/client/http/w:aao	Ljava/util/logging/Logger;
    //   109: astore 13
    //   111: aload_0
    //   112: getfield 62	com/google/api/client/http/q:abt	Z
    //   115: ifeq +710 -> 825
    //   118: aload 13
    //   120: getstatic 245	java/util/logging/Level:CONFIG	Ljava/util/logging/Level;
    //   123: invokevirtual 251	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   126: ifeq +699 -> 825
    //   129: iconst_1
    //   130: istore_2
    //   131: aconst_null
    //   132: astore 11
    //   134: aconst_null
    //   135: astore 9
    //   137: aload 9
    //   139: astore 10
    //   141: iload_2
    //   142: ifeq +124 -> 266
    //   145: new 253	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   152: astore 12
    //   154: aload 12
    //   156: ldc_w 256
    //   159: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: getstatic 265	com/google/api/client/util/ab:aeg	Ljava/lang/String;
    //   165: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 12
    //   171: aload_0
    //   172: getfield 184	com/google/api/client/http/q:aaB	Ljava/lang/String;
    //   175: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: bipush 32
    //   180: invokevirtual 268	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   183: aload 14
    //   185: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 265	com/google/api/client/util/ab:aeg	Ljava/lang/String;
    //   191: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 9
    //   197: astore 10
    //   199: aload 12
    //   201: astore 11
    //   203: aload_0
    //   204: getfield 64	com/google/api/client/http/q:abu	Z
    //   207: ifeq +59 -> 266
    //   210: new 253	java/lang/StringBuilder
    //   213: dup
    //   214: ldc_w 270
    //   217: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: astore 9
    //   222: aload 9
    //   224: astore 10
    //   226: aload 12
    //   228: astore 11
    //   230: aload_0
    //   231: getfield 184	com/google/api/client/http/q:aaB	Ljava/lang/String;
    //   234: ldc -113
    //   236: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifne +27 -> 266
    //   242: aload 9
    //   244: ldc_w 279
    //   247: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: getfield 184	com/google/api/client/http/q:aaB	Ljava/lang/String;
    //   254: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 12
    //   260: astore 11
    //   262: aload 9
    //   264: astore 10
    //   266: aload_0
    //   267: getfield 54	com/google/api/client/http/q:abp	Lcom/google/api/client/http/n;
    //   270: invokevirtual 282	com/google/api/client/http/n:xt	()Ljava/lang/String;
    //   273: astore 9
    //   275: aload_0
    //   276: getfield 284	com/google/api/client/http/q:abG	Z
    //   279: ifne +19 -> 298
    //   282: aload 9
    //   284: ifnonnull +546 -> 830
    //   287: aload_0
    //   288: getfield 54	com/google/api/client/http/q:abp	Lcom/google/api/client/http/n;
    //   291: ldc_w 286
    //   294: invokevirtual 289	com/google/api/client/http/n:bY	(Ljava/lang/String;)Lcom/google/api/client/http/n;
    //   297: pop
    //   298: aload_0
    //   299: getfield 54	com/google/api/client/http/q:abp	Lcom/google/api/client/http/n;
    //   302: aload 11
    //   304: aload 10
    //   306: aload 13
    //   308: aload 15
    //   310: invokestatic 292	com/google/api/client/http/n:a	(Lcom/google/api/client/http/n;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/util/logging/Logger;Lcom/google/api/client/http/z;)V
    //   313: aload_0
    //   314: getfield 284	com/google/api/client/http/q:abG	Z
    //   317: ifne +13 -> 330
    //   320: aload_0
    //   321: getfield 54	com/google/api/client/http/q:abp	Lcom/google/api/client/http/n;
    //   324: aload 9
    //   326: invokevirtual 289	com/google/api/client/http/n:bY	(Ljava/lang/String;)Lcom/google/api/client/http/n;
    //   329: pop
    //   330: aload_0
    //   331: getfield 170	com/google/api/client/http/q:abv	Lcom/google/api/client/http/j;
    //   334: astore 9
    //   336: aload 9
    //   338: ifnull +15 -> 353
    //   341: aload_0
    //   342: getfield 170	com/google/api/client/http/q:abv	Lcom/google/api/client/http/j;
    //   345: invokeinterface 297 1 0
    //   350: ifeq +518 -> 868
    //   353: iconst_1
    //   354: istore_3
    //   355: aload 9
    //   357: astore 12
    //   359: aload 9
    //   361: ifnull +230 -> 591
    //   364: aload_0
    //   365: getfield 170	com/google/api/client/http/q:abv	Lcom/google/api/client/http/j;
    //   368: invokeinterface 300 1 0
    //   373: astore 16
    //   375: iload_2
    //   376: ifeq +802 -> 1178
    //   379: new 302	com/google/api/client/util/s
    //   382: dup
    //   383: aload 9
    //   385: getstatic 239	com/google/api/client/http/w:aao	Ljava/util/logging/Logger;
    //   388: getstatic 245	java/util/logging/Level:CONFIG	Ljava/util/logging/Level;
    //   391: aload_0
    //   392: getfield 60	com/google/api/client/http/q:abs	I
    //   395: invokespecial 305	com/google/api/client/util/s:<init>	(Lcom/google/api/client/util/aa;Ljava/util/logging/Logger;Ljava/util/logging/Level;I)V
    //   398: astore 9
    //   400: aload_0
    //   401: getfield 96	com/google/api/client/http/q:aba	Lcom/google/api/client/http/k;
    //   404: ifnonnull +469 -> 873
    //   407: aload_0
    //   408: getfield 170	com/google/api/client/http/q:abv	Lcom/google/api/client/http/j;
    //   411: invokeinterface 309 1 0
    //   416: lstore 7
    //   418: aconst_null
    //   419: astore 12
    //   421: iload_2
    //   422: ifeq +123 -> 545
    //   425: aload 16
    //   427: ifnull +78 -> 505
    //   430: new 253	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 311
    //   440: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 16
    //   445: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore 17
    //   453: aload 11
    //   455: aload 17
    //   457: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: getstatic 265	com/google/api/client/util/ab:aeg	Ljava/lang/String;
    //   463: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 10
    //   469: ifnull +36 -> 505
    //   472: aload 10
    //   474: new 253	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 316
    //   484: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 17
    //   489: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 318
    //   495: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: lload 7
    //   507: lconst_0
    //   508: lcmp
    //   509: iflt +36 -> 545
    //   512: aload 11
    //   514: new 253	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 320
    //   524: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: lload 7
    //   529: invokevirtual 323	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   532: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: getstatic 265	com/google/api/client/util/ab:aeg	Ljava/lang/String;
    //   541: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 10
    //   547: ifnull +12 -> 559
    //   550: aload 10
    //   552: ldc_w 325
    //   555: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 15
    //   561: aload 16
    //   563: invokevirtual 330	com/google/api/client/http/z:setContentType	(Ljava/lang/String;)V
    //   566: aload 15
    //   568: aload 12
    //   570: invokevirtual 333	com/google/api/client/http/z:setContentEncoding	(Ljava/lang/String;)V
    //   573: aload 15
    //   575: lload 7
    //   577: invokevirtual 337	com/google/api/client/http/z:setContentLength	(J)V
    //   580: aload 15
    //   582: aload 9
    //   584: invokevirtual 340	com/google/api/client/http/z:a	(Lcom/google/api/client/util/aa;)V
    //   587: aload 9
    //   589: astore 12
    //   591: iload_2
    //   592: ifeq +77 -> 669
    //   595: aload 13
    //   597: aload 11
    //   599: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokevirtual 343	java/util/logging/Logger:config	(Ljava/lang/String;)V
    //   605: aload 10
    //   607: ifnull +62 -> 669
    //   610: aload 10
    //   612: ldc_w 345
    //   615: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 10
    //   621: aload 14
    //   623: ldc_w 318
    //   626: ldc_w 347
    //   629: invokevirtual 351	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   632: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 10
    //   638: ldc_w 318
    //   641: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload 12
    //   647: ifnull +12 -> 659
    //   650: aload 10
    //   652: ldc_w 353
    //   655: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 13
    //   661: aload 10
    //   663: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokevirtual 343	java/util/logging/Logger:config	(Ljava/lang/String;)V
    //   669: iload_3
    //   670: ifeq +251 -> 921
    //   673: iload_1
    //   674: ifle +247 -> 921
    //   677: iconst_1
    //   678: istore 6
    //   680: aload 15
    //   682: aload_0
    //   683: getfield 66	com/google/api/client/http/q:abx	I
    //   686: aload_0
    //   687: getfield 68	com/google/api/client/http/q:aby	I
    //   690: invokevirtual 357	com/google/api/client/http/z:v	(II)V
    //   693: aload 15
    //   695: invokevirtual 361	com/google/api/client/http/z:xu	()Lcom/google/api/client/http/aa;
    //   698: astore 10
    //   700: new 217	com/google/api/client/http/t
    //   703: dup
    //   704: aload_0
    //   705: aload 10
    //   707: invokespecial 364	com/google/api/client/http/t:<init>	(Lcom/google/api/client/http/q;Lcom/google/api/client/http/aa;)V
    //   710: astore 9
    //   712: aconst_null
    //   713: astore 10
    //   715: aload 9
    //   717: ifnull +358 -> 1075
    //   720: aload 9
    //   722: invokevirtual 367	com/google/api/client/http/t:xL	()Z
    //   725: ifne +350 -> 1075
    //   728: iconst_0
    //   729: istore 4
    //   731: aload_0
    //   732: getfield 108	com/google/api/client/http/q:abz	Lcom/google/api/client/http/x;
    //   735: ifnull +19 -> 754
    //   738: aload_0
    //   739: getfield 108	com/google/api/client/http/q:abz	Lcom/google/api/client/http/x;
    //   742: aload_0
    //   743: aload 9
    //   745: iload 6
    //   747: invokeinterface 372 4 0
    //   752: istore 4
    //   754: iload 4
    //   756: istore 5
    //   758: iload 4
    //   760: ifne +23 -> 783
    //   763: aload_0
    //   764: aload 9
    //   766: invokevirtual 375	com/google/api/client/http/t:getStatusCode	()I
    //   769: aload 9
    //   771: invokevirtual 377	com/google/api/client/http/t:xC	()Lcom/google/api/client/http/n;
    //   774: invokevirtual 379	com/google/api/client/http/q:a	(ILcom/google/api/client/http/n;)Z
    //   777: ifeq +216 -> 993
    //   780: iconst_1
    //   781: istore 5
    //   783: iload 6
    //   785: iload 5
    //   787: iand
    //   788: istore_3
    //   789: iload_3
    //   790: istore_2
    //   791: iload_3
    //   792: ifeq +10 -> 802
    //   795: aload 9
    //   797: invokevirtual 220	com/google/api/client/http/t:xO	()V
    //   800: iload_3
    //   801: istore_2
    //   802: aload 9
    //   804: ifnull +3 -> 807
    //   807: iload_2
    //   808: ifne +363 -> 1171
    //   811: aload 9
    //   813: ifnonnull +297 -> 1110
    //   816: aload 10
    //   818: athrow
    //   819: iconst_0
    //   820: istore 4
    //   822: goto -812 -> 10
    //   825: iconst_0
    //   826: istore_2
    //   827: goto -696 -> 131
    //   830: aload_0
    //   831: getfield 54	com/google/api/client/http/q:abp	Lcom/google/api/client/http/n;
    //   834: new 253	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   841: aload 9
    //   843: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: ldc_w 381
    //   849: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: ldc_w 286
    //   855: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: invokevirtual 289	com/google/api/client/http/n:bY	(Ljava/lang/String;)Lcom/google/api/client/http/n;
    //   864: pop
    //   865: goto -567 -> 298
    //   868: iconst_0
    //   869: istore_3
    //   870: goto -515 -> 355
    //   873: aload_0
    //   874: getfield 96	com/google/api/client/http/q:aba	Lcom/google/api/client/http/k;
    //   877: invokeinterface 386 1 0
    //   882: astore 12
    //   884: new 388	com/google/api/client/http/l
    //   887: dup
    //   888: aload 9
    //   890: aload_0
    //   891: getfield 96	com/google/api/client/http/q:aba	Lcom/google/api/client/http/k;
    //   894: invokespecial 391	com/google/api/client/http/l:<init>	(Lcom/google/api/client/util/aa;Lcom/google/api/client/http/k;)V
    //   897: astore 9
    //   899: iload_3
    //   900: ifeq +13 -> 913
    //   903: aload 9
    //   905: invokestatic 396	com/google/api/client/util/m:b	(Lcom/google/api/client/util/aa;)J
    //   908: lstore 7
    //   910: goto -489 -> 421
    //   913: ldc2_w 397
    //   916: lstore 7
    //   918: goto -8 -> 910
    //   921: iconst_0
    //   922: istore 6
    //   924: goto -244 -> 680
    //   927: astore 9
    //   929: aload 10
    //   931: invokevirtual 404	com/google/api/client/http/aa:getContent	()Ljava/io/InputStream;
    //   934: invokevirtual 409	java/io/InputStream:close	()V
    //   937: aload 9
    //   939: athrow
    //   940: astore 10
    //   942: aconst_null
    //   943: astore 9
    //   945: aload_0
    //   946: getfield 74	com/google/api/client/http/q:abF	Z
    //   949: ifne +28 -> 977
    //   952: aload_0
    //   953: getfield 102	com/google/api/client/http/q:abA	Lcom/google/api/client/http/o;
    //   956: ifnull +18 -> 974
    //   959: aload_0
    //   960: getfield 102	com/google/api/client/http/q:abA	Lcom/google/api/client/http/o;
    //   963: aload_0
    //   964: iload 6
    //   966: invokeinterface 414 3 0
    //   971: ifne +6 -> 977
    //   974: aload 10
    //   976: athrow
    //   977: aload 13
    //   979: getstatic 417	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   982: ldc_w 419
    //   985: aload 10
    //   987: invokevirtual 423	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   990: goto -275 -> 715
    //   993: iload 4
    //   995: istore 5
    //   997: iload 6
    //   999: ifeq -216 -> 783
    //   1002: iload 4
    //   1004: istore 5
    //   1006: aload_0
    //   1007: getfield 92	com/google/api/client/http/q:abC	Lcom/google/api/client/http/c;
    //   1010: ifnull -227 -> 783
    //   1013: iload 4
    //   1015: istore 5
    //   1017: aload_0
    //   1018: getfield 92	com/google/api/client/http/q:abC	Lcom/google/api/client/http/c;
    //   1021: aload 9
    //   1023: invokevirtual 375	com/google/api/client/http/t:getStatusCode	()I
    //   1026: invokeinterface 426 2 0
    //   1031: ifeq -248 -> 783
    //   1034: aload_0
    //   1035: getfield 92	com/google/api/client/http/q:abC	Lcom/google/api/client/http/c;
    //   1038: invokeinterface 429 1 0
    //   1043: lstore 7
    //   1045: iload 4
    //   1047: istore 5
    //   1049: lload 7
    //   1051: ldc2_w 397
    //   1054: lcmp
    //   1055: ifeq -272 -> 783
    //   1058: aload_0
    //   1059: getfield 81	com/google/api/client/http/q:ZG	Lcom/google/api/client/util/z;
    //   1062: lload 7
    //   1064: invokeinterface 432 3 0
    //   1069: iconst_1
    //   1070: istore 5
    //   1072: goto -289 -> 783
    //   1075: aload 9
    //   1077: ifnonnull +13 -> 1090
    //   1080: iconst_1
    //   1081: istore_2
    //   1082: iload 6
    //   1084: iload_2
    //   1085: iand
    //   1086: istore_2
    //   1087: goto -285 -> 802
    //   1090: iconst_0
    //   1091: istore_2
    //   1092: goto -10 -> 1082
    //   1095: astore 10
    //   1097: aload 9
    //   1099: ifnull +8 -> 1107
    //   1102: aload 9
    //   1104: invokevirtual 435	com/google/api/client/http/t:disconnect	()V
    //   1107: aload 10
    //   1109: athrow
    //   1110: aload_0
    //   1111: getfield 105	com/google/api/client/http/q:abB	Lcom/google/api/client/http/u;
    //   1114: ifnull +14 -> 1128
    //   1117: aload_0
    //   1118: getfield 105	com/google/api/client/http/q:abB	Lcom/google/api/client/http/u;
    //   1121: aload 9
    //   1123: invokeinterface 440 2 0
    //   1128: aload_0
    //   1129: getfield 72	com/google/api/client/http/q:abE	Z
    //   1132: ifeq +31 -> 1163
    //   1135: aload 9
    //   1137: invokevirtual 367	com/google/api/client/http/t:xL	()Z
    //   1140: ifne +23 -> 1163
    //   1143: new 442	com/google/api/client/http/HttpResponseException
    //   1146: dup
    //   1147: aload 9
    //   1149: invokespecial 444	com/google/api/client/http/HttpResponseException:<init>	(Lcom/google/api/client/http/t;)V
    //   1152: athrow
    //   1153: astore 10
    //   1155: aload 9
    //   1157: invokevirtual 435	com/google/api/client/http/t:disconnect	()V
    //   1160: aload 10
    //   1162: athrow
    //   1163: aload 9
    //   1165: areturn
    //   1166: astore 11
    //   1168: goto -99 -> 1069
    //   1171: iload_1
    //   1172: iconst_1
    //   1173: isub
    //   1174: istore_1
    //   1175: goto -1120 -> 55
    //   1178: goto -778 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1181	0	this	q
    //   19	1156	1	i	int
    //   130	962	2	bool1	boolean
    //   354	546	3	bool2	boolean
    //   8	1038	4	bool3	boolean
    //   756	315	5	bool4	boolean
    //   678	408	6	bool5	boolean
    //   416	647	7	l	long
    //   37	867	9	localObject1	Object
    //   927	11	9	localObject2	Object
    //   943	221	9	localt	t
    //   139	791	10	localObject3	Object
    //   940	46	10	localIOException	java.io.IOException
    //   1095	13	10	localObject4	Object
    //   1153	8	10	localObject5	Object
    //   132	466	11	localObject6	Object
    //   1166	1	11	localInterruptedException	InterruptedException
    //   152	731	12	localObject7	Object
    //   109	869	13	localLogger	java.util.logging.Logger
    //   89	533	14	str1	String
    //   104	590	15	localz	z
    //   373	189	16	str2	String
    //   451	37	17	str3	String
    // Exception table:
    //   from	to	target	type
    //   700	712	927	finally
    //   693	700	940	java/io/IOException
    //   929	940	940	java/io/IOException
    //   720	728	1095	finally
    //   731	754	1095	finally
    //   763	780	1095	finally
    //   795	800	1095	finally
    //   1006	1013	1095	finally
    //   1017	1045	1095	finally
    //   1058	1069	1095	finally
    //   1143	1153	1153	finally
    //   1058	1069	1166	java/lang/InterruptedException
  }
  
  public w xx()
  {
    return this.ZP;
  }
  
  public i xy()
  {
    return this.abw;
  }
  
  public j xz()
  {
    return this.abv;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */