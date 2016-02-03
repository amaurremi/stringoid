package com.jirbo.adcolony;

import java.util.ArrayList;

class n$y
{
  String a;
  int b;
  int c;
  int d;
  boolean e;
  boolean f;
  ArrayList<String> g;
  n.z h;
  n.d i;
  n.aa j;
  ag k;
  
  int a(int paramInt1, int paramInt2)
  {
    int m;
    if (paramInt2 <= 0) {
      m = 0;
    }
    do
    {
      return m;
      m = paramInt2;
    } while (paramInt1 == -1);
    if (paramInt1 < paramInt2) {}
    for (;;)
    {
      return paramInt1;
      paramInt1 = paramInt2;
    }
  }
  
  /* Error */
  int a(n.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   5: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   8: aload_0
    //   9: getfield 44	com/jirbo/adcolony/n$y:a	Ljava/lang/String;
    //   12: invokevirtual 49	com/jirbo/adcolony/t:b	(Ljava/lang/String;)I
    //   15: istore 4
    //   17: iconst_m1
    //   18: istore_2
    //   19: aload_1
    //   20: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   23: getfield 59	com/jirbo/adcolony/n$l:g	I
    //   26: istore_3
    //   27: iload_3
    //   28: ifeq +50 -> 78
    //   31: getstatic 63	com/jirbo/adcolony/a:X	J
    //   34: lconst_0
    //   35: lcmp
    //   36: ifeq +42 -> 78
    //   39: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   42: getstatic 63	com/jirbo/adcolony/a:X	J
    //   45: lsub
    //   46: ldc2_w 70
    //   49: ldiv
    //   50: iload_3
    //   51: i2l
    //   52: lcmp
    //   53: iflt +25 -> 78
    //   56: aload_0
    //   57: invokevirtual 73	com/jirbo/adcolony/n$y:c	()V
    //   60: bipush 7
    //   62: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   65: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   68: ldc 83
    //   70: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   73: istore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: iload_2
    //   77: ireturn
    //   78: aload_1
    //   79: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   82: getfield 87	com/jirbo/adcolony/n$l:h	I
    //   85: istore_3
    //   86: iload_3
    //   87: ifle +36 -> 123
    //   90: aload_0
    //   91: iconst_m1
    //   92: iload_3
    //   93: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   96: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   99: aload_1
    //   100: getfield 89	com/jirbo/adcolony/n$a:d	I
    //   103: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   106: getstatic 63	com/jirbo/adcolony/a:X	J
    //   109: lsub
    //   110: ldc2_w 70
    //   113: ldiv
    //   114: l2d
    //   115: invokevirtual 92	com/jirbo/adcolony/t:a	(ID)I
    //   118: isub
    //   119: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   122: istore_2
    //   123: iload_2
    //   124: ifne +28 -> 152
    //   127: iload_3
    //   128: ifeq +24 -> 152
    //   131: aload_0
    //   132: invokevirtual 73	com/jirbo/adcolony/n$y:c	()V
    //   135: bipush 7
    //   137: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   140: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   143: ldc 96
    //   145: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   148: istore_2
    //   149: goto -75 -> 74
    //   152: aload_0
    //   153: getfield 98	com/jirbo/adcolony/n$y:c	I
    //   156: istore 5
    //   158: iload_2
    //   159: istore_3
    //   160: iload 5
    //   162: ifle +14 -> 176
    //   165: aload_0
    //   166: iload_2
    //   167: iload 5
    //   169: iload 4
    //   171: isub
    //   172: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   175: istore_3
    //   176: iload_3
    //   177: ifne +39 -> 216
    //   180: iconst_5
    //   181: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   184: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   187: new 100	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   194: ldc 103
    //   196: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: getfield 44	com/jirbo/adcolony/n$y:a	Ljava/lang/String;
    //   203: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   212: istore_2
    //   213: goto -139 -> 74
    //   216: aload_0
    //   217: getfield 112	com/jirbo/adcolony/n$y:d	I
    //   220: istore 5
    //   222: iload_3
    //   223: istore_2
    //   224: iload 5
    //   226: ifle +25 -> 251
    //   229: aload_0
    //   230: iload_3
    //   231: iload 5
    //   233: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   236: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   239: aload_0
    //   240: getfield 44	com/jirbo/adcolony/n$y:a	Ljava/lang/String;
    //   243: invokevirtual 114	com/jirbo/adcolony/t:a	(Ljava/lang/String;)I
    //   246: isub
    //   247: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   250: istore_2
    //   251: iload_2
    //   252: ifne +39 -> 291
    //   255: iconst_3
    //   256: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   259: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   262: new 100	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   269: ldc 116
    //   271: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: getfield 44	com/jirbo/adcolony/n$y:a	Ljava/lang/String;
    //   278: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   287: istore_2
    //   288: goto -214 -> 74
    //   291: iload_2
    //   292: istore_3
    //   293: aload_0
    //   294: getfield 118	com/jirbo/adcolony/n$y:j	Lcom/jirbo/adcolony/n$aa;
    //   297: getfield 122	com/jirbo/adcolony/n$aa:a	Z
    //   300: ifeq +131 -> 431
    //   303: aload_0
    //   304: getfield 118	com/jirbo/adcolony/n$y:j	Lcom/jirbo/adcolony/n$aa;
    //   307: getfield 125	com/jirbo/adcolony/n$aa:b	Lcom/jirbo/adcolony/n$w;
    //   310: getfield 129	com/jirbo/adcolony/n$w:a	I
    //   313: istore 5
    //   315: iload_2
    //   316: istore_3
    //   317: iload 5
    //   319: ifle +14 -> 333
    //   322: aload_0
    //   323: iload_2
    //   324: iload 5
    //   326: iload 4
    //   328: isub
    //   329: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   332: istore_3
    //   333: iload_3
    //   334: ifne +19 -> 353
    //   337: iconst_4
    //   338: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   341: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   344: ldc -125
    //   346: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   349: istore_2
    //   350: goto -276 -> 74
    //   353: aload_0
    //   354: getfield 118	com/jirbo/adcolony/n$y:j	Lcom/jirbo/adcolony/n$aa;
    //   357: getfield 125	com/jirbo/adcolony/n$aa:b	Lcom/jirbo/adcolony/n$w;
    //   360: getfield 132	com/jirbo/adcolony/n$w:c	I
    //   363: istore 4
    //   365: aload_0
    //   366: getfield 118	com/jirbo/adcolony/n$y:j	Lcom/jirbo/adcolony/n$aa;
    //   369: getfield 125	com/jirbo/adcolony/n$aa:b	Lcom/jirbo/adcolony/n$w;
    //   372: getfield 134	com/jirbo/adcolony/n$w:b	I
    //   375: istore 5
    //   377: iload_3
    //   378: istore_2
    //   379: iload 5
    //   381: ifle +28 -> 409
    //   384: aload_0
    //   385: iload_3
    //   386: iload 5
    //   388: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   391: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   394: aload_0
    //   395: getfield 44	com/jirbo/adcolony/n$y:a	Ljava/lang/String;
    //   398: iload 4
    //   400: i2d
    //   401: invokevirtual 137	com/jirbo/adcolony/t:a	(Ljava/lang/String;D)I
    //   404: isub
    //   405: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   408: istore_2
    //   409: iload_2
    //   410: istore_3
    //   411: iload_2
    //   412: ifne +19 -> 431
    //   415: iconst_4
    //   416: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   419: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   422: ldc -117
    //   424: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   427: istore_2
    //   428: goto -354 -> 74
    //   431: aload_1
    //   432: getfield 89	com/jirbo/adcolony/n$a:d	I
    //   435: istore 4
    //   437: aload_1
    //   438: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   441: getfield 140	com/jirbo/adcolony/n$l:a	I
    //   444: istore 5
    //   446: iload_3
    //   447: istore_2
    //   448: iload 5
    //   450: ifle +23 -> 473
    //   453: aload_0
    //   454: iload_3
    //   455: iload 5
    //   457: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   460: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   463: iload 4
    //   465: invokevirtual 143	com/jirbo/adcolony/t:a	(I)I
    //   468: isub
    //   469: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   472: istore_2
    //   473: iload_2
    //   474: ifne +24 -> 498
    //   477: bipush 7
    //   479: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   482: aload_0
    //   483: invokevirtual 73	com/jirbo/adcolony/n$y:c	()V
    //   486: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   489: ldc -111
    //   491: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   494: istore_2
    //   495: goto -421 -> 74
    //   498: aload_1
    //   499: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   502: getfield 147	com/jirbo/adcolony/n$l:f	I
    //   505: istore 5
    //   507: iload_2
    //   508: istore_3
    //   509: iload 5
    //   511: ifle +23 -> 534
    //   514: aload_0
    //   515: iload_2
    //   516: iload 5
    //   518: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   521: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   524: iload 4
    //   526: invokevirtual 149	com/jirbo/adcolony/t:b	(I)I
    //   529: isub
    //   530: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   533: istore_3
    //   534: iload_3
    //   535: ifne +24 -> 559
    //   538: bipush 7
    //   540: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   543: aload_0
    //   544: invokevirtual 73	com/jirbo/adcolony/n$y:c	()V
    //   547: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   550: ldc -105
    //   552: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   555: istore_2
    //   556: goto -482 -> 74
    //   559: aload_1
    //   560: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   563: getfield 153	com/jirbo/adcolony/n$l:e	I
    //   566: istore 5
    //   568: iload_3
    //   569: istore_2
    //   570: iload 5
    //   572: ifle +23 -> 595
    //   575: aload_0
    //   576: iload_3
    //   577: iload 5
    //   579: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   582: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   585: iload 4
    //   587: invokevirtual 155	com/jirbo/adcolony/t:c	(I)I
    //   590: isub
    //   591: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   594: istore_2
    //   595: iload_2
    //   596: ifne +24 -> 620
    //   599: bipush 7
    //   601: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   604: aload_0
    //   605: invokevirtual 73	com/jirbo/adcolony/n$y:c	()V
    //   608: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   611: ldc -99
    //   613: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   616: istore_2
    //   617: goto -543 -> 74
    //   620: aload_1
    //   621: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   624: getfield 158	com/jirbo/adcolony/n$l:d	I
    //   627: istore 5
    //   629: iload_2
    //   630: istore_3
    //   631: iload 5
    //   633: ifle +23 -> 656
    //   636: aload_0
    //   637: iload_2
    //   638: iload 5
    //   640: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   643: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   646: iload 4
    //   648: invokevirtual 160	com/jirbo/adcolony/t:d	(I)I
    //   651: isub
    //   652: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   655: istore_3
    //   656: iload_3
    //   657: ifne +24 -> 681
    //   660: bipush 7
    //   662: putstatic 76	com/jirbo/adcolony/a:Y	I
    //   665: aload_0
    //   666: invokevirtual 73	com/jirbo/adcolony/n$y:c	()V
    //   669: getstatic 81	com/jirbo/adcolony/l:c	Lcom/jirbo/adcolony/l;
    //   672: ldc -94
    //   674: invokevirtual 85	com/jirbo/adcolony/l:c	(Ljava/lang/String;)I
    //   677: istore_2
    //   678: goto -604 -> 74
    //   681: aload_1
    //   682: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   685: getfield 163	com/jirbo/adcolony/n$l:c	I
    //   688: istore 5
    //   690: aload_1
    //   691: getfield 55	com/jirbo/adcolony/n$a:p	Lcom/jirbo/adcolony/n$l;
    //   694: getfield 164	com/jirbo/adcolony/n$l:b	I
    //   697: istore 6
    //   699: iload_3
    //   700: istore_2
    //   701: iload 6
    //   703: ifle -629 -> 74
    //   706: aload_0
    //   707: iload_3
    //   708: iload 6
    //   710: getstatic 37	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   713: getfield 42	com/jirbo/adcolony/d:h	Lcom/jirbo/adcolony/t;
    //   716: iload 4
    //   718: iload 5
    //   720: i2d
    //   721: invokevirtual 92	com/jirbo/adcolony/t:a	(ID)I
    //   724: isub
    //   725: invokevirtual 94	com/jirbo/adcolony/n$y:a	(II)I
    //   728: istore_2
    //   729: goto -655 -> 74
    //   732: astore_1
    //   733: aload_0
    //   734: monitorexit
    //   735: aload_1
    //   736: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	737	0	this	y
    //   0	737	1	parama	n.a
    //   18	711	2	m	int
    //   26	682	3	n	int
    //   15	702	4	i1	int
    //   156	563	5	i2	int
    //   697	28	6	i3	int
    // Exception table:
    //   from	to	target	type
    //   2	17	732	finally
    //   19	27	732	finally
    //   31	74	732	finally
    //   78	86	732	finally
    //   90	123	732	finally
    //   131	149	732	finally
    //   152	158	732	finally
    //   165	176	732	finally
    //   180	213	732	finally
    //   216	222	732	finally
    //   229	251	732	finally
    //   255	288	732	finally
    //   293	315	732	finally
    //   322	333	732	finally
    //   337	350	732	finally
    //   353	377	732	finally
    //   384	409	732	finally
    //   415	428	732	finally
    //   431	446	732	finally
    //   453	473	732	finally
    //   477	495	732	finally
    //   498	507	732	finally
    //   514	534	732	finally
    //   538	556	732	finally
    //   559	568	732	finally
    //   575	595	732	finally
    //   599	617	732	finally
    //   620	629	732	finally
    //   636	656	732	finally
    //   660	678	732	finally
    //   681	699	732	finally
    //   706	729	732	finally
  }
  
  boolean a()
  {
    return a(false, true);
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    do
    {
      do
      {
        do
        {
          ArrayList localArrayList;
          do
          {
            return false;
            this.a = paramg.e("uuid");
            this.e = paramg.h("enabled");
            this.f = paramg.h("active");
            if ((!this.e) || (!this.f)) {
              return true;
            }
            this.b = paramg.g("play_interval");
            this.c = paramg.g("daily_play_cap");
            this.d = paramg.g("session_play_cap");
            this.g = new ArrayList();
            localArrayList = paramg.d("play_order");
            this.g = localArrayList;
          } while (localArrayList == null);
          this.h = new n.z();
        } while (!this.h.a(paramg.b("tracking")));
        this.i = new n.d();
      } while (!this.i.a(paramg.c("ads")));
      this.j = new n.aa();
    } while (!this.j.a(paramg.b("v4vc")));
    this.k = a.l.g.a(this.a);
    return true;
  }
  
  boolean a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a.h();
    }
    if ((!this.e) || (!this.f)) {}
    label108:
    for (;;)
    {
      return false;
      if ((this.i.a() != 0) && (this.g.size() != 0))
      {
        int n = this.g.size();
        int m = 0;
        n.a locala;
        if (m < n)
        {
          locala = i();
          if (locala == null) {
            continue;
          }
          if (!locala.a()) {}
        }
        for (;;)
        {
          if ((locala == null) || (a(locala) == 0)) {
            break label108;
          }
          return true;
          k();
          m += 1;
          break;
          locala = null;
        }
      }
    }
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean2)
    {
      paramBoolean1 = a(paramBoolean1);
      return paramBoolean1;
    }
    if ((!this.e) || (!this.f))
    {
      a.Y = 1;
      return l.c.b("Ad is not ready to be played, as zone " + this.a + " is disabled or inactive.");
    }
    if ((this.i.a() == 0) || (this.g.size() == 0))
    {
      a.Y = 5;
      return l.c.b("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone " + this.a + ".");
    }
    int n = this.g.size();
    int m = 0;
    label140:
    n.a locala;
    if (m < n)
    {
      locala = i();
      if (locala == null) {
        return l.c.b("Ad is not ready to be played due to an unknown error.");
      }
      if (!locala.a()) {}
    }
    for (;;)
    {
      if (locala == null)
      {
        a.Y = 6;
        return l.c.b("Ad is not ready to be played as required assets are still downloading or otherwise missing.");
        k();
        m += 1;
        break label140;
      }
      paramBoolean1 = bool;
      if (a(locala) != 0) {
        break;
      }
      return false;
      locala = null;
    }
  }
  
  boolean b()
  {
    if (this.b <= 1) {}
    int m;
    do
    {
      return false;
      a.l.g.b = true;
      ag localag = this.k;
      m = localag.b;
      localag.b = (m + 1);
    } while (m == 0);
    if (this.k.b >= this.b) {
      this.k.b = 0;
    }
    return true;
  }
  
  boolean b(boolean paramBoolean)
  {
    boolean bool = true;
    if (!paramBoolean) {
      paramBoolean = f();
    }
    do
    {
      return paramBoolean;
      if ((!this.e) || (!this.f))
      {
        a.Y = 1;
        return l.c.b("Ad is not ready, as zone " + this.a + " is disabled or inactive.");
      }
      if (this.i.a() == 0)
      {
        a.Y = 5;
        return l.c.b("Ad is not ready, as there are currently no ads to play in zone " + this.a + ".");
      }
      paramBoolean = bool;
    } while (!this.i.b().s.a);
    a.Y = 14;
    return l.c.b("Ad is not ready, as zone " + this.a + " is V4VC enabled and must be played using an AdColonyV4VCAd object.");
  }
  
  void c()
  {
    a.l.b.e();
  }
  
  boolean c(boolean paramBoolean)
  {
    boolean bool = true;
    if (!paramBoolean) {
      paramBoolean = h();
    }
    do
    {
      return paramBoolean;
      if ((!this.e) || (!this.f))
      {
        a.Y = 1;
        return l.c.b("Ad is not ready, as zone " + this.a + " is disabled or inactive.");
      }
      if (this.i.a() == 0)
      {
        a.Y = 5;
        return l.c.b("Ad is not ready, as there are currently no ads to play in zone " + this.a + ".");
      }
      paramBoolean = bool;
    } while (this.i.b().s.a);
    a.Y = 15;
    return l.c.b("Ad is not ready, as zone " + this.a + " is not V4VC enabled and must be played using an AdColonyVideoAd object.");
  }
  
  int d()
  {
    try
    {
      int m = a(i());
      return m;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean e()
  {
    return b(true);
  }
  
  boolean f()
  {
    if ((!this.e) || (!this.f)) {}
    while ((this.i.a() == 0) || (this.i.b().s.a)) {
      return false;
    }
    return true;
  }
  
  boolean g()
  {
    return c(true);
  }
  
  boolean h()
  {
    if ((!this.e) || (!this.f)) {}
    while ((this.i.a() == 0) || (!this.i.b().s.a)) {
      return false;
    }
    return true;
  }
  
  n.a i()
  {
    if (this.g.size() > 0) {
      return this.i.a((String)this.g.get(this.k.c % this.g.size()));
    }
    return null;
  }
  
  n.a j()
  {
    if (this.g.size() > 0) {
      return this.i.b(this.k.c % this.g.size());
    }
    return null;
  }
  
  void k()
  {
    if (this.g.size() > 0) {
      this.k.c = ((this.k.c + 1) % this.g.size());
    }
  }
  
  void l()
  {
    if ((!this.e) || (!this.f)) {}
    for (;;)
    {
      return;
      int m = 0;
      while (m < this.i.a())
      {
        this.i.a(m).b();
        m += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */