package com.badlogic.gdx.backends.android.b;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class s
  extends Thread
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l = 0;
  private int m = 0;
  private int n = 1;
  private boolean o = true;
  private boolean p;
  private ArrayList<Runnable> q = new ArrayList();
  private boolean r = true;
  private r s;
  private WeakReference<j> t;
  
  s(WeakReference<j> paramWeakReference)
  {
    this.t = paramWeakReference;
  }
  
  private void j()
  {
    if (this.i)
    {
      this.i = false;
      this.s.e();
    }
  }
  
  private void k()
  {
    if (this.h)
    {
      this.s.f();
      this.h = false;
      j.d().c(this);
    }
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 65	com/badlogic/gdx/backends/android/b/r
    //   4: dup
    //   5: aload_0
    //   6: getfield 53	com/badlogic/gdx/backends/android/b/s:t	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 85	com/badlogic/gdx/backends/android/b/r:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 63	com/badlogic/gdx/backends/android/b/s:s	Lcom/badlogic/gdx/backends/android/b/r;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 69	com/badlogic/gdx/backends/android/b/s:h	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 61	com/badlogic/gdx/backends/android/b/s:i	Z
    //   25: iconst_0
    //   26: istore 10
    //   28: aconst_null
    //   29: astore 22
    //   31: iconst_0
    //   32: istore_1
    //   33: iconst_0
    //   34: istore_3
    //   35: iconst_0
    //   36: istore 5
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 7
    //   44: iconst_0
    //   45: istore 8
    //   47: iconst_0
    //   48: istore 9
    //   50: aconst_null
    //   51: astore 21
    //   53: iconst_0
    //   54: istore_2
    //   55: iconst_0
    //   56: istore 4
    //   58: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   61: astore 23
    //   63: aload 23
    //   65: monitorenter
    //   66: iload 10
    //   68: istore 11
    //   70: iload 7
    //   72: istore 10
    //   74: iload 4
    //   76: istore 14
    //   78: aload_0
    //   79: getfield 87	com/badlogic/gdx/backends/android/b/s:a	Z
    //   82: ifeq +34 -> 116
    //   85: aload 23
    //   87: monitorexit
    //   88: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   91: astore 21
    //   93: aload 21
    //   95: monitorenter
    //   96: aload_0
    //   97: invokespecial 89	com/badlogic/gdx/backends/android/b/s:j	()V
    //   100: aload_0
    //   101: invokespecial 91	com/badlogic/gdx/backends/android/b/s:k	()V
    //   104: aload 21
    //   106: monitorexit
    //   107: return
    //   108: astore 22
    //   110: aload 21
    //   112: monitorexit
    //   113: aload 22
    //   115: athrow
    //   116: aload_0
    //   117: getfield 41	com/badlogic/gdx/backends/android/b/s:q	Ljava/util/ArrayList;
    //   120: invokevirtual 95	java/util/ArrayList:isEmpty	()Z
    //   123: ifne +93 -> 216
    //   126: aload_0
    //   127: getfield 41	com/badlogic/gdx/backends/android/b/s:q	Ljava/util/ArrayList;
    //   130: iconst_0
    //   131: invokevirtual 99	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   134: checkcast 101	java/lang/Runnable
    //   137: astore 21
    //   139: iload 10
    //   141: istore 7
    //   143: iload 6
    //   145: istore 12
    //   147: iload_1
    //   148: istore 4
    //   150: iload 11
    //   152: istore 10
    //   154: iload 7
    //   156: istore 6
    //   158: iload 12
    //   160: istore 7
    //   162: iload_2
    //   163: istore_1
    //   164: iload 14
    //   166: istore_2
    //   167: aload 23
    //   169: monitorexit
    //   170: aload 21
    //   172: ifnull +614 -> 786
    //   175: aload 21
    //   177: invokeinterface 104 1 0
    //   182: iload 6
    //   184: istore 11
    //   186: aconst_null
    //   187: astore 21
    //   189: iload_1
    //   190: istore 12
    //   192: iload_2
    //   193: istore 6
    //   195: iload 4
    //   197: istore_1
    //   198: iload 12
    //   200: istore_2
    //   201: iload 6
    //   203: istore 4
    //   205: iload 7
    //   207: istore 6
    //   209: iload 11
    //   211: istore 7
    //   213: goto -155 -> 58
    //   216: aload_0
    //   217: getfield 106	com/badlogic/gdx/backends/android/b/s:d	Z
    //   220: aload_0
    //   221: getfield 108	com/badlogic/gdx/backends/android/b/s:c	Z
    //   224: if_icmpeq +991 -> 1215
    //   227: aload_0
    //   228: getfield 108	com/badlogic/gdx/backends/android/b/s:c	Z
    //   231: istore 19
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 108	com/badlogic/gdx/backends/android/b/s:c	Z
    //   238: putfield 106	com/badlogic/gdx/backends/android/b/s:d	Z
    //   241: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   244: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   247: iload_3
    //   248: istore 4
    //   250: aload_0
    //   251: getfield 115	com/badlogic/gdx/backends/android/b/s:k	Z
    //   254: ifeq +19 -> 273
    //   257: aload_0
    //   258: invokespecial 89	com/badlogic/gdx/backends/android/b/s:j	()V
    //   261: aload_0
    //   262: invokespecial 91	com/badlogic/gdx/backends/android/b/s:k	()V
    //   265: aload_0
    //   266: iconst_0
    //   267: putfield 115	com/badlogic/gdx/backends/android/b/s:k	Z
    //   270: iconst_1
    //   271: istore 4
    //   273: iload 10
    //   275: istore 7
    //   277: iload 10
    //   279: ifeq +14 -> 293
    //   282: aload_0
    //   283: invokespecial 89	com/badlogic/gdx/backends/android/b/s:j	()V
    //   286: aload_0
    //   287: invokespecial 91	com/badlogic/gdx/backends/android/b/s:k	()V
    //   290: iconst_0
    //   291: istore 7
    //   293: iload 19
    //   295: ifeq +14 -> 309
    //   298: aload_0
    //   299: getfield 61	com/badlogic/gdx/backends/android/b/s:i	Z
    //   302: ifeq +7 -> 309
    //   305: aload_0
    //   306: invokespecial 89	com/badlogic/gdx/backends/android/b/s:j	()V
    //   309: iload 19
    //   311: ifeq +48 -> 359
    //   314: aload_0
    //   315: getfield 69	com/badlogic/gdx/backends/android/b/s:h	Z
    //   318: ifeq +41 -> 359
    //   321: aload_0
    //   322: getfield 53	com/badlogic/gdx/backends/android/b/s:t	Ljava/lang/ref/WeakReference;
    //   325: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   328: checkcast 73	com/badlogic/gdx/backends/android/b/j
    //   331: astore 24
    //   333: aload 24
    //   335: ifnonnull +312 -> 647
    //   338: iconst_0
    //   339: istore 20
    //   341: iload 20
    //   343: ifeq +12 -> 355
    //   346: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   349: invokevirtual 123	com/badlogic/gdx/backends/android/b/t:a	()Z
    //   352: ifeq +7 -> 359
    //   355: aload_0
    //   356: invokespecial 91	com/badlogic/gdx/backends/android/b/s:k	()V
    //   359: iload 19
    //   361: ifeq +19 -> 380
    //   364: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   367: invokevirtual 125	com/badlogic/gdx/backends/android/b/t:b	()Z
    //   370: ifeq +10 -> 380
    //   373: aload_0
    //   374: getfield 63	com/badlogic/gdx/backends/android/b/s:s	Lcom/badlogic/gdx/backends/android/b/r;
    //   377: invokevirtual 71	com/badlogic/gdx/backends/android/b/r:f	()V
    //   380: aload_0
    //   381: getfield 127	com/badlogic/gdx/backends/android/b/s:e	Z
    //   384: ifne +37 -> 421
    //   387: aload_0
    //   388: getfield 129	com/badlogic/gdx/backends/android/b/s:g	Z
    //   391: ifne +30 -> 421
    //   394: aload_0
    //   395: getfield 61	com/badlogic/gdx/backends/android/b/s:i	Z
    //   398: ifeq +7 -> 405
    //   401: aload_0
    //   402: invokespecial 89	com/badlogic/gdx/backends/android/b/s:j	()V
    //   405: aload_0
    //   406: iconst_1
    //   407: putfield 129	com/badlogic/gdx/backends/android/b/s:g	Z
    //   410: aload_0
    //   411: iconst_0
    //   412: putfield 131	com/badlogic/gdx/backends/android/b/s:f	Z
    //   415: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   418: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   421: aload_0
    //   422: getfield 127	com/badlogic/gdx/backends/android/b/s:e	Z
    //   425: ifeq +21 -> 446
    //   428: aload_0
    //   429: getfield 129	com/badlogic/gdx/backends/android/b/s:g	Z
    //   432: ifeq +14 -> 446
    //   435: aload_0
    //   436: iconst_0
    //   437: putfield 129	com/badlogic/gdx/backends/android/b/s:g	Z
    //   440: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   443: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   446: iload 14
    //   448: istore 12
    //   450: iload 5
    //   452: istore 13
    //   454: iload 14
    //   456: ifeq +20 -> 476
    //   459: iconst_0
    //   460: istore 13
    //   462: iconst_0
    //   463: istore 12
    //   465: aload_0
    //   466: iconst_1
    //   467: putfield 133	com/badlogic/gdx/backends/android/b/s:p	Z
    //   470: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   473: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   476: iload 4
    //   478: istore_3
    //   479: iload 6
    //   481: istore 15
    //   483: iload 8
    //   485: istore 16
    //   487: iload 9
    //   489: istore 17
    //   491: iload 11
    //   493: istore 18
    //   495: aload_0
    //   496: invokespecial 135	com/badlogic/gdx/backends/android/b/s:m	()Z
    //   499: ifeq +250 -> 749
    //   502: iload 4
    //   504: istore_3
    //   505: iload 11
    //   507: istore 10
    //   509: aload_0
    //   510: getfield 69	com/badlogic/gdx/backends/android/b/s:h	Z
    //   513: ifne +14 -> 527
    //   516: iload 4
    //   518: ifeq +139 -> 657
    //   521: iconst_0
    //   522: istore_3
    //   523: iload 11
    //   525: istore 10
    //   527: aload_0
    //   528: getfield 69	com/badlogic/gdx/backends/android/b/s:h	Z
    //   531: ifeq +673 -> 1204
    //   534: aload_0
    //   535: getfield 61	com/badlogic/gdx/backends/android/b/s:i	Z
    //   538: ifne +666 -> 1204
    //   541: aload_0
    //   542: iconst_1
    //   543: putfield 61	com/badlogic/gdx/backends/android/b/s:i	Z
    //   546: iconst_1
    //   547: istore 9
    //   549: iconst_1
    //   550: istore 5
    //   552: iconst_1
    //   553: istore 4
    //   555: aload_0
    //   556: getfield 61	com/badlogic/gdx/backends/android/b/s:i	Z
    //   559: ifeq +665 -> 1224
    //   562: aload_0
    //   563: getfield 43	com/badlogic/gdx/backends/android/b/s:r	Z
    //   566: ifeq +621 -> 1187
    //   569: iconst_1
    //   570: istore_2
    //   571: aload_0
    //   572: getfield 45	com/badlogic/gdx/backends/android/b/s:l	I
    //   575: istore 6
    //   577: aload_0
    //   578: getfield 47	com/badlogic/gdx/backends/android/b/s:m	I
    //   581: istore_1
    //   582: iconst_1
    //   583: istore 8
    //   585: iconst_1
    //   586: istore 5
    //   588: aload_0
    //   589: iconst_0
    //   590: putfield 43	com/badlogic/gdx/backends/android/b/s:r	Z
    //   593: aload_0
    //   594: iconst_0
    //   595: putfield 49	com/badlogic/gdx/backends/android/b/s:o	Z
    //   598: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   601: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   604: iload 4
    //   606: istore 11
    //   608: iload 12
    //   610: istore 4
    //   612: iload 6
    //   614: istore 12
    //   616: iload 7
    //   618: istore 6
    //   620: iload_2
    //   621: istore 7
    //   623: iload 5
    //   625: istore 9
    //   627: iload 4
    //   629: istore_2
    //   630: iload_1
    //   631: istore 4
    //   633: iload 12
    //   635: istore_1
    //   636: iload 8
    //   638: istore 5
    //   640: iload 11
    //   642: istore 8
    //   644: goto -477 -> 167
    //   647: aload 24
    //   649: invokestatic 138	com/badlogic/gdx/backends/android/b/j:g	(Lcom/badlogic/gdx/backends/android/b/j;)Z
    //   652: istore 20
    //   654: goto -313 -> 341
    //   657: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   660: aload_0
    //   661: invokevirtual 141	com/badlogic/gdx/backends/android/b/t:b	(Lcom/badlogic/gdx/backends/android/b/s;)Z
    //   664: istore 19
    //   666: iload 4
    //   668: istore_3
    //   669: iload 11
    //   671: istore 10
    //   673: iload 19
    //   675: ifeq -148 -> 527
    //   678: aload_0
    //   679: getfield 63	com/badlogic/gdx/backends/android/b/s:s	Lcom/badlogic/gdx/backends/android/b/r;
    //   682: invokevirtual 143	com/badlogic/gdx/backends/android/b/r:a	()V
    //   685: aload_0
    //   686: iconst_1
    //   687: putfield 69	com/badlogic/gdx/backends/android/b/s:h	Z
    //   690: iconst_1
    //   691: istore 10
    //   693: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   696: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   699: iload 4
    //   701: istore_3
    //   702: goto -175 -> 527
    //   705: astore 21
    //   707: aload 23
    //   709: monitorexit
    //   710: aload 21
    //   712: athrow
    //   713: astore 22
    //   715: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   718: astore 21
    //   720: aload 21
    //   722: monitorenter
    //   723: aload_0
    //   724: invokespecial 89	com/badlogic/gdx/backends/android/b/s:j	()V
    //   727: aload_0
    //   728: invokespecial 91	com/badlogic/gdx/backends/android/b/s:k	()V
    //   731: aload 21
    //   733: monitorexit
    //   734: aload 22
    //   736: athrow
    //   737: astore 21
    //   739: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   742: aload_0
    //   743: invokevirtual 81	com/badlogic/gdx/backends/android/b/t:c	(Lcom/badlogic/gdx/backends/android/b/s;)V
    //   746: aload 21
    //   748: athrow
    //   749: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   752: invokevirtual 146	java/lang/Object:wait	()V
    //   755: iload 12
    //   757: istore 14
    //   759: iload 13
    //   761: istore 5
    //   763: iload 15
    //   765: istore 6
    //   767: iload 7
    //   769: istore 10
    //   771: iload 16
    //   773: istore 8
    //   775: iload 17
    //   777: istore 9
    //   779: iload 18
    //   781: istore 11
    //   783: goto -705 -> 78
    //   786: iload 9
    //   788: ifeq +396 -> 1184
    //   791: aload_0
    //   792: getfield 63	com/badlogic/gdx/backends/android/b/s:s	Lcom/badlogic/gdx/backends/android/b/r;
    //   795: invokevirtual 147	com/badlogic/gdx/backends/android/b/r:b	()Z
    //   798: ifeq +295 -> 1093
    //   801: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   804: astore 23
    //   806: aload 23
    //   808: monitorenter
    //   809: aload_0
    //   810: iconst_1
    //   811: putfield 149	com/badlogic/gdx/backends/android/b/s:j	Z
    //   814: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   817: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   820: aload 23
    //   822: monitorexit
    //   823: iconst_0
    //   824: istore 9
    //   826: iload 8
    //   828: ifeq +353 -> 1181
    //   831: aload_0
    //   832: getfield 63	com/badlogic/gdx/backends/android/b/s:s	Lcom/badlogic/gdx/backends/android/b/r;
    //   835: invokevirtual 152	com/badlogic/gdx/backends/android/b/r:c	()Ljavax/microedition/khronos/opengles/GL;
    //   838: checkcast 154	javax/microedition/khronos/opengles/GL10
    //   841: astore 22
    //   843: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   846: aload 22
    //   848: invokevirtual 157	com/badlogic/gdx/backends/android/b/t:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   851: iconst_0
    //   852: istore 8
    //   854: iload 10
    //   856: istore 11
    //   858: iload 10
    //   860: ifeq +42 -> 902
    //   863: aload_0
    //   864: getfield 53	com/badlogic/gdx/backends/android/b/s:t	Ljava/lang/ref/WeakReference;
    //   867: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   870: checkcast 73	com/badlogic/gdx/backends/android/b/j
    //   873: astore 23
    //   875: aload 23
    //   877: ifnull +366 -> 1243
    //   880: aload 23
    //   882: invokestatic 160	com/badlogic/gdx/backends/android/b/j:h	(Lcom/badlogic/gdx/backends/android/b/j;)Landroid/opengl/GLSurfaceView$Renderer;
    //   885: aload 22
    //   887: aload_0
    //   888: getfield 63	com/badlogic/gdx/backends/android/b/s:s	Lcom/badlogic/gdx/backends/android/b/r;
    //   891: getfield 163	com/badlogic/gdx/backends/android/b/r:d	Ljavax/microedition/khronos/egl/EGLConfig;
    //   894: invokeinterface 169 3 0
    //   899: goto +344 -> 1243
    //   902: iload 7
    //   904: istore 10
    //   906: iload 7
    //   908: ifeq +38 -> 946
    //   911: aload_0
    //   912: getfield 53	com/badlogic/gdx/backends/android/b/s:t	Ljava/lang/ref/WeakReference;
    //   915: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   918: checkcast 73	com/badlogic/gdx/backends/android/b/j
    //   921: astore 23
    //   923: aload 23
    //   925: ifnull +324 -> 1249
    //   928: aload 23
    //   930: invokestatic 160	com/badlogic/gdx/backends/android/b/j:h	(Lcom/badlogic/gdx/backends/android/b/j;)Landroid/opengl/GLSurfaceView$Renderer;
    //   933: aload 22
    //   935: iload_1
    //   936: iload 4
    //   938: invokeinterface 173 4 0
    //   943: goto +306 -> 1249
    //   946: aload_0
    //   947: getfield 53	com/badlogic/gdx/backends/android/b/s:t	Ljava/lang/ref/WeakReference;
    //   950: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   953: checkcast 73	com/badlogic/gdx/backends/android/b/j
    //   956: astore 23
    //   958: aload 23
    //   960: ifnull +15 -> 975
    //   963: aload 23
    //   965: invokestatic 160	com/badlogic/gdx/backends/android/b/j:h	(Lcom/badlogic/gdx/backends/android/b/j;)Landroid/opengl/GLSurfaceView$Renderer;
    //   968: aload 22
    //   970: invokeinterface 176 2 0
    //   975: aload_0
    //   976: getfield 63	com/badlogic/gdx/backends/android/b/s:s	Lcom/badlogic/gdx/backends/android/b/r;
    //   979: invokevirtual 179	com/badlogic/gdx/backends/android/b/r:d	()I
    //   982: istore 12
    //   984: iload 6
    //   986: istore 7
    //   988: iload 12
    //   990: lookupswitch	default:+265->1255, 12288:+61->1051, 12302:+169->1159
    //   1016: ldc -75
    //   1018: ldc -73
    //   1020: iload 12
    //   1022: invokestatic 186	com/badlogic/gdx/backends/android/b/r:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1025: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   1028: astore 23
    //   1030: aload 23
    //   1032: monitorenter
    //   1033: aload_0
    //   1034: iconst_1
    //   1035: putfield 131	com/badlogic/gdx/backends/android/b/s:f	Z
    //   1038: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   1041: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   1044: aload 23
    //   1046: monitorexit
    //   1047: iload 6
    //   1049: istore 7
    //   1051: iload 5
    //   1053: ifeq +168 -> 1221
    //   1056: iconst_1
    //   1057: istore_2
    //   1058: iload_1
    //   1059: istore 12
    //   1061: iload_2
    //   1062: istore 6
    //   1064: iload 4
    //   1066: istore_1
    //   1067: iload 12
    //   1069: istore_2
    //   1070: iload 6
    //   1072: istore 4
    //   1074: iload 10
    //   1076: istore 6
    //   1078: iload 11
    //   1080: istore 10
    //   1082: goto -1024 -> 58
    //   1085: astore 21
    //   1087: aload 23
    //   1089: monitorexit
    //   1090: aload 21
    //   1092: athrow
    //   1093: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   1096: astore 23
    //   1098: aload 23
    //   1100: monitorenter
    //   1101: aload_0
    //   1102: iconst_1
    //   1103: putfield 149	com/badlogic/gdx/backends/android/b/s:j	Z
    //   1106: aload_0
    //   1107: iconst_1
    //   1108: putfield 131	com/badlogic/gdx/backends/android/b/s:f	Z
    //   1111: invokestatic 76	com/badlogic/gdx/backends/android/b/j:d	()Lcom/badlogic/gdx/backends/android/b/t;
    //   1114: invokevirtual 113	java/lang/Object:notifyAll	()V
    //   1117: aload 23
    //   1119: monitorexit
    //   1120: iload 6
    //   1122: istore 11
    //   1124: iload_1
    //   1125: istore 12
    //   1127: iload_2
    //   1128: istore 6
    //   1130: iload 4
    //   1132: istore_1
    //   1133: iload 12
    //   1135: istore_2
    //   1136: iload 6
    //   1138: istore 4
    //   1140: iload 7
    //   1142: istore 6
    //   1144: iload 11
    //   1146: istore 7
    //   1148: goto -1090 -> 58
    //   1151: astore 21
    //   1153: aload 23
    //   1155: monitorexit
    //   1156: aload 21
    //   1158: athrow
    //   1159: iconst_1
    //   1160: istore 7
    //   1162: goto -111 -> 1051
    //   1165: astore 21
    //   1167: aload 23
    //   1169: monitorexit
    //   1170: aload 21
    //   1172: athrow
    //   1173: astore 22
    //   1175: aload 21
    //   1177: monitorexit
    //   1178: aload 22
    //   1180: athrow
    //   1181: goto -327 -> 854
    //   1184: goto -358 -> 826
    //   1187: iload 13
    //   1189: istore 8
    //   1191: iload_2
    //   1192: istore 6
    //   1194: iload 5
    //   1196: istore_2
    //   1197: iload 9
    //   1199: istore 5
    //   1201: goto -608 -> 593
    //   1204: iload 6
    //   1206: istore 5
    //   1208: iload 8
    //   1210: istore 4
    //   1212: goto -657 -> 555
    //   1215: iconst_0
    //   1216: istore 19
    //   1218: goto -971 -> 247
    //   1221: goto -163 -> 1058
    //   1224: iload 5
    //   1226: istore 15
    //   1228: iload 4
    //   1230: istore 16
    //   1232: iload 9
    //   1234: istore 17
    //   1236: iload 10
    //   1238: istore 18
    //   1240: goto -491 -> 749
    //   1243: iconst_0
    //   1244: istore 11
    //   1246: goto -344 -> 902
    //   1249: iconst_0
    //   1250: istore 10
    //   1252: goto -306 -> 946
    //   1255: goto -239 -> 1016
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1258	0	this	s
    //   32	1101	1	i1	int
    //   54	1143	2	i2	int
    //   34	668	3	i3	int
    //   56	1173	4	i4	int
    //   36	1189	5	i5	int
    //   39	1166	6	i6	int
    //   42	1119	7	i7	int
    //   45	1164	8	i8	int
    //   48	1185	9	i9	int
    //   26	1225	10	i10	int
    //   68	1177	11	i11	int
    //   145	989	12	i12	int
    //   452	736	13	i13	int
    //   76	682	14	i14	int
    //   481	746	15	i15	int
    //   485	746	16	i16	int
    //   489	746	17	i17	int
    //   493	746	18	i18	int
    //   231	986	19	bool1	boolean
    //   339	314	20	bool2	boolean
    //   51	137	21	localObject1	Object
    //   705	6	21	localObject2	Object
    //   737	10	21	localRuntimeException	RuntimeException
    //   1085	6	21	localObject3	Object
    //   1151	6	21	localObject4	Object
    //   1165	11	21	localObject5	Object
    //   29	1	22	localObject6	Object
    //   108	6	22	localObject7	Object
    //   713	22	22	localObject8	Object
    //   841	128	22	localGL10	javax.microedition.khronos.opengles.GL10
    //   1173	6	22	localObject9	Object
    //   331	317	24	localj	j
    // Exception table:
    //   from	to	target	type
    //   96	107	108	finally
    //   110	113	108	finally
    //   78	88	705	finally
    //   116	139	705	finally
    //   167	170	705	finally
    //   216	247	705	finally
    //   250	270	705	finally
    //   282	290	705	finally
    //   298	309	705	finally
    //   314	333	705	finally
    //   346	355	705	finally
    //   355	359	705	finally
    //   364	380	705	finally
    //   380	405	705	finally
    //   405	421	705	finally
    //   421	446	705	finally
    //   465	476	705	finally
    //   495	502	705	finally
    //   509	516	705	finally
    //   527	546	705	finally
    //   555	569	705	finally
    //   571	582	705	finally
    //   588	593	705	finally
    //   593	604	705	finally
    //   647	654	705	finally
    //   657	666	705	finally
    //   678	685	705	finally
    //   685	690	705	finally
    //   693	699	705	finally
    //   707	710	705	finally
    //   739	749	705	finally
    //   749	755	705	finally
    //   58	66	713	finally
    //   175	182	713	finally
    //   710	713	713	finally
    //   791	809	713	finally
    //   831	851	713	finally
    //   863	875	713	finally
    //   880	899	713	finally
    //   911	923	713	finally
    //   928	943	713	finally
    //   946	958	713	finally
    //   963	975	713	finally
    //   975	984	713	finally
    //   1016	1033	713	finally
    //   1090	1093	713	finally
    //   1093	1101	713	finally
    //   1156	1159	713	finally
    //   1170	1173	713	finally
    //   678	685	737	java/lang/RuntimeException
    //   809	823	1085	finally
    //   1087	1090	1085	finally
    //   1101	1120	1151	finally
    //   1153	1156	1151	finally
    //   1033	1047	1165	finally
    //   1167	1170	1165	finally
    //   723	734	1173	finally
    //   1175	1178	1173	finally
  }
  
  private boolean m()
  {
    return (!this.d) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0) && ((this.o) || (this.n == 1));
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (j.d())
    {
      this.n = paramInt;
      j.d().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.l = paramInt1;
      this.m = paramInt2;
      this.r = true;
      this.o = true;
      this.p = false;
      j.d().notifyAll();
      for (;;)
      {
        if ((!this.b) && (!this.d) && (!this.p))
        {
          boolean bool = a();
          if (bool) {
            try
            {
              j.d().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.h) && (this.i) && (m());
  }
  
  public int b()
  {
    synchronized ()
    {
      int i1 = this.n;
      return i1;
    }
  }
  
  public void c()
  {
    synchronized ()
    {
      this.o = true;
      j.d().notifyAll();
      return;
    }
  }
  
  public void d()
  {
    synchronized ()
    {
      this.e = true;
      this.j = false;
      j.d().notifyAll();
      for (;;)
      {
        if ((this.g) && (!this.j))
        {
          boolean bool = this.b;
          if (!bool) {
            try
            {
              j.d().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void e()
  {
    synchronized ()
    {
      this.e = false;
      j.d().notifyAll();
      for (;;)
      {
        if (!this.g)
        {
          boolean bool = this.b;
          if (!bool) {
            try
            {
              j.d().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void f()
  {
    synchronized ()
    {
      this.c = true;
      j.d().notifyAll();
      for (;;)
      {
        if (!this.b)
        {
          boolean bool = this.d;
          if (!bool) {
            try
            {
              j.d().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void g()
  {
    synchronized ()
    {
      this.c = false;
      this.o = true;
      this.p = false;
      j.d().notifyAll();
      for (;;)
      {
        if ((!this.b) && (this.d))
        {
          boolean bool = this.p;
          if (!bool) {
            try
            {
              j.d().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void h()
  {
    synchronized ()
    {
      this.a = true;
      j.d().notifyAll();
      for (;;)
      {
        boolean bool = this.b;
        if (!bool) {
          try
          {
            j.d().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void i()
  {
    this.k = true;
    j.d().notifyAll();
  }
  
  public void run()
  {
    setName("GLThread " + getId());
    try
    {
      l();
      j.d().a(this);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException = localInterruptedException;
      j.d().a(this);
      return;
    }
    finally
    {
      localObject = finally;
      j.d().a(this);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */