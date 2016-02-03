package com.mobisystems.mobiscanner.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.image.Image.a;
import com.mobisystems.mobiscanner.image.ImageProcessing;

public class b
{
  private static b aJY = null;
  private OperationStatus aII = OperationStatus.avB;
  private com.mobisystems.mobiscanner.common.b aJZ = null;
  private final c mLog = new c(this);
  
  private b(Context paramContext, FragmentManager paramFragmentManager)
  {
    this.aJZ = com.mobisystems.mobiscanner.common.b.a(paramContext, paramFragmentManager, "pdf", 104857600);
    Ih();
  }
  
  private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    return new Rect(0, 0, Math.round(paramFloat1 / paramFloat3 * paramInt), Math.round(paramFloat2 / paramFloat3 * paramInt));
  }
  
  private static RectF a(Image.a parama, a parama1)
  {
    float f4 = parama1.pageWidth - parama1.aJR - parama1.aJT;
    float f3 = parama1.pageHeight - parama1.aJS - parama1.aJU;
    RectF localRectF = new RectF(0.0F, 0.0F, parama.width(), parama.height());
    ImageProcessing.c(parama.Ic()).mapRect(localRectF);
    float f1 = localRectF.width() / localRectF.height();
    float f2;
    if (f4 / localRectF.width() > f3 / localRectF.height())
    {
      f2 = f3 * f1;
      f1 = f3;
    }
    for (;;)
    {
      float f5 = parama1.aJR;
      float f6 = (f4 - f2) / 2.0F;
      float f7 = parama1.aJS;
      float f8 = (f3 - f1) / 2.0F;
      float f9 = parama1.aJR;
      f2 = (f2 + f4) / 2.0F;
      f4 = parama1.aJS;
      return new RectF(f5 + f6, f7 + f8, f2 + f9, (f1 + f3) / 2.0F + f4);
      f1 = f4 / f1;
      f2 = f4;
    }
  }
  
  public static b a(Context paramContext, FragmentManager paramFragmentManager)
  {
    if (aJY == null) {
      aJY = new b(paramContext, paramFragmentManager);
    }
    return aJY;
  }
  
  private String i(long paramLong1, long paramLong2)
  {
    return String.valueOf(paramLong1) + "_" + String.valueOf(paramLong2);
  }
  
  public void Ih()
  {
    new a().execute(new Object[] { Integer.valueOf(1) });
  }
  
  public OperationStatus It()
  {
    return this.aII;
  }
  
  /* Error */
  public java.io.File a(long paramLong, java.io.File paramFile, com.mobisystems.mobiscanner.common.a<Integer> parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: astore 15
    //   6: new 129	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   13: ldc -87
    //   15: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: ldc -82
    //   24: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore 14
    //   29: aload_3
    //   30: ifnull +198 -> 228
    //   33: aload_3
    //   34: invokevirtual 179	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   37: astore 13
    //   39: aload 15
    //   41: aload 14
    //   43: aload 13
    //   45: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   54: iconst_0
    //   55: istore 8
    //   57: aload_0
    //   58: getstatic 186	com/mobisystems/mobiscanner/common/OperationStatus:avE	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   61: putfield 38	com/mobisystems/mobiscanner/a/b:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   64: aconst_null
    //   65: astore 16
    //   67: aconst_null
    //   68: astore 14
    //   70: aconst_null
    //   71: astore 13
    //   73: aconst_null
    //   74: astore 15
    //   76: aload 4
    //   78: invokeinterface 192 1 0
    //   83: ifeq +152 -> 235
    //   86: new 167	java/lang/InterruptedException
    //   89: dup
    //   90: ldc -62
    //   92: invokespecial 196	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   95: athrow
    //   96: astore 4
    //   98: iload 8
    //   100: istore 7
    //   102: aload 16
    //   104: astore_3
    //   105: aload 15
    //   107: astore 14
    //   109: aload_0
    //   110: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   113: ldc -58
    //   115: aload 4
    //   117: invokevirtual 202	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload 13
    //   122: ifnull +10 -> 132
    //   125: aload 13
    //   127: invokeinterface 207 1 0
    //   132: aload 14
    //   134: ifnull +8 -> 142
    //   137: aload 14
    //   139: invokevirtual 210	com/mobisystems/office/pdfExport/PdfWriter:close	()V
    //   142: aload_3
    //   143: astore 4
    //   145: iload 7
    //   147: ifne +15 -> 162
    //   150: aload_3
    //   151: ifnull +8 -> 159
    //   154: aload_3
    //   155: invokevirtual 213	java/io/File:delete	()Z
    //   158: pop
    //   159: aconst_null
    //   160: astore 4
    //   162: aload 4
    //   164: astore_3
    //   165: iload 7
    //   167: istore 8
    //   169: iload 8
    //   171: ifeq +10 -> 181
    //   174: aload_0
    //   175: getstatic 216	com/mobisystems/mobiscanner/common/OperationStatus:avF	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   178: putfield 38	com/mobisystems/mobiscanner/a/b:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   181: aload_0
    //   182: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   185: astore 14
    //   187: new 129	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   194: ldc -38
    //   196: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: astore 13
    //   201: aload_3
    //   202: ifnull +1851 -> 2053
    //   205: aload_3
    //   206: invokevirtual 179	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   209: astore 4
    //   211: aload 14
    //   213: aload 13
    //   215: aload 4
    //   217: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   226: aload_3
    //   227: areturn
    //   228: ldc -36
    //   230: astore 13
    //   232: goto -193 -> 39
    //   235: new 222	com/mobisystems/mobiscanner/model/DocumentModel
    //   238: dup
    //   239: invokespecial 223	com/mobisystems/mobiscanner/model/DocumentModel:<init>	()V
    //   242: astore 21
    //   244: aload 21
    //   246: lload_1
    //   247: invokevirtual 227	com/mobisystems/mobiscanner/model/DocumentModel:ae	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   250: astore 20
    //   252: aload 20
    //   254: ifnonnull +129 -> 383
    //   257: new 163	java/io/IOException
    //   260: dup
    //   261: new 129	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   268: ldc -27
    //   270: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: lload_1
    //   274: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   277: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokespecial 230	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   283: athrow
    //   284: astore 13
    //   286: aconst_null
    //   287: astore 14
    //   289: aconst_null
    //   290: astore 4
    //   292: aconst_null
    //   293: astore 15
    //   295: iconst_0
    //   296: istore 7
    //   298: aload 14
    //   300: astore 16
    //   302: aload 4
    //   304: astore 17
    //   306: aload 15
    //   308: astore 18
    //   310: iload 7
    //   312: istore 8
    //   314: aload_0
    //   315: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   318: ldc -24
    //   320: aload 13
    //   322: invokevirtual 202	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   325: aload 4
    //   327: ifnull +10 -> 337
    //   330: aload 4
    //   332: invokeinterface 207 1 0
    //   337: aload 14
    //   339: ifnull +8 -> 347
    //   342: aload 14
    //   344: invokevirtual 210	com/mobisystems/office/pdfExport/PdfWriter:close	()V
    //   347: aload 15
    //   349: astore_3
    //   350: iload 7
    //   352: istore 8
    //   354: iload 7
    //   356: ifne -187 -> 169
    //   359: iload 7
    //   361: istore 8
    //   363: aload 15
    //   365: ifnull +13 -> 378
    //   368: aload 15
    //   370: invokevirtual 213	java/io/File:delete	()Z
    //   373: pop
    //   374: iload 7
    //   376: istore 8
    //   378: aconst_null
    //   379: astore_3
    //   380: goto -211 -> 169
    //   383: aload 20
    //   385: invokevirtual 237	com/mobisystems/mobiscanner/model/b:getName	()Ljava/lang/String;
    //   388: astore 17
    //   390: new 176	java/io/File
    //   393: dup
    //   394: aload_3
    //   395: new 129	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   402: aload 17
    //   404: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc -17
    //   409: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokespecial 242	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   418: astore_3
    //   419: aload_0
    //   420: lload_1
    //   421: aload 20
    //   423: invokevirtual 246	com/mobisystems/mobiscanner/model/b:IA	()J
    //   426: invokespecial 248	com/mobisystems/mobiscanner/a/b:i	(JJ)Ljava/lang/String;
    //   429: astore 19
    //   431: aload_0
    //   432: getfield 40	com/mobisystems/mobiscanner/a/b:aJZ	Lcom/mobisystems/mobiscanner/common/b;
    //   435: ifnull +1947 -> 2382
    //   438: invokestatic 253	java/lang/System:currentTimeMillis	()J
    //   441: lstore 11
    //   443: aload_0
    //   444: getfield 40	com/mobisystems/mobiscanner/a/b:aJZ	Lcom/mobisystems/mobiscanner/common/b;
    //   447: aload 19
    //   449: aload_3
    //   450: aload 4
    //   452: invokevirtual 257	com/mobisystems/mobiscanner/common/b:b	(Ljava/lang/String;Ljava/io/File;Lcom/mobisystems/mobiscanner/common/a;)Z
    //   455: istore 7
    //   457: iload 7
    //   459: ifeq +1920 -> 2379
    //   462: invokestatic 253	java/lang/System:currentTimeMillis	()J
    //   465: lstore 9
    //   467: lload 9
    //   469: lload 11
    //   471: lsub
    //   472: lstore 9
    //   474: lload 9
    //   476: ldc2_w 258
    //   479: lcmp
    //   480: ifge +1899 -> 2379
    //   483: ldc2_w 258
    //   486: lload 9
    //   488: lsub
    //   489: invokestatic 265	java/lang/Thread:sleep	(J)V
    //   492: iload 7
    //   494: ifne +1878 -> 2372
    //   497: new 209	com/mobisystems/office/pdfExport/PdfWriter
    //   500: dup
    //   501: aload_3
    //   502: invokespecial 268	com/mobisystems/office/pdfExport/PdfWriter:<init>	(Ljava/io/File;)V
    //   505: astore 14
    //   507: aload 14
    //   509: invokevirtual 271	com/mobisystems/office/pdfExport/PdfWriter:Kh	()V
    //   512: aload 21
    //   514: lload_1
    //   515: invokevirtual 275	com/mobisystems/mobiscanner/model/DocumentModel:ah	(J)Landroid/database/Cursor;
    //   518: astore 15
    //   520: aload 15
    //   522: ifnonnull +46 -> 568
    //   525: aload 14
    //   527: astore 16
    //   529: aload 15
    //   531: astore 17
    //   533: aload_3
    //   534: astore 18
    //   536: iload 7
    //   538: istore 8
    //   540: new 163	java/io/IOException
    //   543: dup
    //   544: new 129	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 277
    //   554: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: lload_1
    //   558: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokespecial 230	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   567: athrow
    //   568: aload 14
    //   570: astore 16
    //   572: aload 15
    //   574: astore 17
    //   576: aload_3
    //   577: astore 18
    //   579: iload 7
    //   581: istore 8
    //   583: invokestatic 282	com/mobisystems/mobiscanner/common/d:Dw	()Z
    //   586: ifeq +3 -> 589
    //   589: aload 14
    //   591: astore 16
    //   593: aload 15
    //   595: astore 17
    //   597: aload_3
    //   598: astore 18
    //   600: iload 7
    //   602: istore 8
    //   604: aload 15
    //   606: invokeinterface 285 1 0
    //   611: pop
    //   612: aload 14
    //   614: astore 16
    //   616: aload 15
    //   618: astore 17
    //   620: aload_3
    //   621: astore 18
    //   623: iload 7
    //   625: istore 8
    //   627: aload 15
    //   629: invokeinterface 288 1 0
    //   634: ifne +1241 -> 1875
    //   637: aload 14
    //   639: astore 16
    //   641: aload 15
    //   643: astore 17
    //   645: aload_3
    //   646: astore 18
    //   648: iload 7
    //   650: istore 8
    //   652: aload 4
    //   654: invokeinterface 192 1 0
    //   659: ifeq +28 -> 687
    //   662: aload 14
    //   664: astore 16
    //   666: aload 15
    //   668: astore 17
    //   670: aload_3
    //   671: astore 18
    //   673: iload 7
    //   675: istore 8
    //   677: new 167	java/lang/InterruptedException
    //   680: dup
    //   681: ldc -62
    //   683: invokespecial 196	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   686: athrow
    //   687: aload 14
    //   689: astore 16
    //   691: aload 15
    //   693: astore 17
    //   695: aload_3
    //   696: astore 18
    //   698: iload 7
    //   700: istore 8
    //   702: new 290	com/mobisystems/mobiscanner/model/c
    //   705: dup
    //   706: aload 20
    //   708: aload 15
    //   710: invokespecial 293	com/mobisystems/mobiscanner/model/c:<init>	(Lcom/mobisystems/mobiscanner/model/b;Landroid/database/Cursor;)V
    //   713: astore 22
    //   715: aload 14
    //   717: astore 16
    //   719: aload 15
    //   721: astore 17
    //   723: aload_3
    //   724: astore 18
    //   726: iload 7
    //   728: istore 8
    //   730: aload 22
    //   732: invokevirtual 296	com/mobisystems/mobiscanner/model/c:getId	()J
    //   735: lstore_1
    //   736: aload 14
    //   738: astore 16
    //   740: aload 15
    //   742: astore 17
    //   744: aload_3
    //   745: astore 18
    //   747: iload 7
    //   749: istore 8
    //   751: aload 22
    //   753: invokevirtual 299	com/mobisystems/mobiscanner/model/c:IU	()I
    //   756: istore 5
    //   758: aload 14
    //   760: astore 16
    //   762: aload 15
    //   764: astore 17
    //   766: aload_3
    //   767: astore 18
    //   769: iload 7
    //   771: istore 8
    //   773: aload 21
    //   775: lload_1
    //   776: invokevirtual 303	com/mobisystems/mobiscanner/model/DocumentModel:aq	(J)Lcom/mobisystems/mobiscanner/image/Image;
    //   779: astore 13
    //   781: aload 13
    //   783: ifnonnull +124 -> 907
    //   786: aload 14
    //   788: astore 16
    //   790: aload 15
    //   792: astore 17
    //   794: aload_3
    //   795: astore 18
    //   797: iload 7
    //   799: istore 8
    //   801: new 163	java/io/IOException
    //   804: dup
    //   805: ldc_w 305
    //   808: invokespecial 230	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   811: athrow
    //   812: astore 4
    //   814: aload_3
    //   815: astore 19
    //   817: aload 15
    //   819: astore 4
    //   821: aload 14
    //   823: astore 13
    //   825: aload 13
    //   827: astore 16
    //   829: aload 4
    //   831: astore 17
    //   833: aload 19
    //   835: astore 18
    //   837: iload 7
    //   839: istore 8
    //   841: aload_0
    //   842: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   845: ldc_w 307
    //   848: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   851: aload 4
    //   853: ifnull +10 -> 863
    //   856: aload 4
    //   858: invokeinterface 207 1 0
    //   863: aload 13
    //   865: ifnull +8 -> 873
    //   868: aload 13
    //   870: invokevirtual 210	com/mobisystems/office/pdfExport/PdfWriter:close	()V
    //   873: aload 19
    //   875: astore_3
    //   876: iload 7
    //   878: istore 8
    //   880: iload 7
    //   882: ifne -713 -> 169
    //   885: iload 7
    //   887: istore 8
    //   889: aload 19
    //   891: ifnull -513 -> 378
    //   894: aload 19
    //   896: invokevirtual 213	java/io/File:delete	()Z
    //   899: pop
    //   900: iload 7
    //   902: istore 8
    //   904: goto -526 -> 378
    //   907: aload 14
    //   909: astore 16
    //   911: aload 15
    //   913: astore 17
    //   915: aload_3
    //   916: astore 18
    //   918: iload 7
    //   920: istore 8
    //   922: aload_0
    //   923: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   926: new 129	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   933: ldc_w 309
    //   936: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 13
    //   941: invokevirtual 312	com/mobisystems/mobiscanner/image/Image:toString	()Ljava/lang/String;
    //   944: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   953: aload 14
    //   955: astore 16
    //   957: aload 15
    //   959: astore 17
    //   961: aload_3
    //   962: astore 18
    //   964: iload 7
    //   966: istore 8
    //   968: aload 13
    //   970: invokevirtual 316	com/mobisystems/mobiscanner/image/Image:HW	()Lcom/mobisystems/mobiscanner/image/Image$a;
    //   973: astore 24
    //   975: aload 14
    //   977: astore 16
    //   979: aload 15
    //   981: astore 17
    //   983: aload_3
    //   984: astore 18
    //   986: iload 7
    //   988: istore 8
    //   990: new 66	com/mobisystems/mobiscanner/a/a
    //   993: dup
    //   994: aload 22
    //   996: aload 24
    //   998: invokespecial 319	com/mobisystems/mobiscanner/a/a:<init>	(Lcom/mobisystems/mobiscanner/model/c;Lcom/mobisystems/mobiscanner/image/Image$a;)V
    //   1001: astore 26
    //   1003: aload 14
    //   1005: astore 16
    //   1007: aload 15
    //   1009: astore 17
    //   1011: aload_3
    //   1012: astore 18
    //   1014: iload 7
    //   1016: istore 8
    //   1018: aload_0
    //   1019: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1022: new 129	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   1029: ldc_w 321
    //   1032: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: iload 5
    //   1037: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1040: ldc_w 326
    //   1043: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: aload 26
    //   1048: getfield 70	com/mobisystems/mobiscanner/a/a:pageWidth	F
    //   1051: invokevirtual 329	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1054: ldc_w 331
    //   1057: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: aload 26
    //   1062: getfield 79	com/mobisystems/mobiscanner/a/a:pageHeight	F
    //   1065: invokevirtual 329	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1068: ldc_w 333
    //   1071: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload 26
    //   1076: getfield 336	com/mobisystems/mobiscanner/a/a:aJP	F
    //   1079: invokevirtual 329	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1082: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1085: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   1088: aload 14
    //   1090: astore 16
    //   1092: aload 15
    //   1094: astore 17
    //   1096: aload_3
    //   1097: astore 18
    //   1099: iload 7
    //   1101: istore 8
    //   1103: aload 14
    //   1105: aload 26
    //   1107: getfield 70	com/mobisystems/mobiscanner/a/a:pageWidth	F
    //   1110: aload 26
    //   1112: getfield 79	com/mobisystems/mobiscanner/a/a:pageHeight	F
    //   1115: aload 26
    //   1117: getfield 336	com/mobisystems/mobiscanner/a/a:aJP	F
    //   1120: invokevirtual 339	com/mobisystems/office/pdfExport/PdfWriter:b	(FFF)V
    //   1123: aload 14
    //   1125: astore 16
    //   1127: aload 15
    //   1129: astore 17
    //   1131: aload_3
    //   1132: astore 18
    //   1134: iload 7
    //   1136: istore 8
    //   1138: new 341	com/mobisystems/office/pdfExport/PdfGraphicsContext
    //   1141: dup
    //   1142: aload 14
    //   1144: invokespecial 344	com/mobisystems/office/pdfExport/PdfGraphicsContext:<init>	(Lcom/mobisystems/office/pdfExport/PdfWriter;)V
    //   1147: astore 23
    //   1149: aload 14
    //   1151: astore 16
    //   1153: aload 15
    //   1155: astore 17
    //   1157: aload_3
    //   1158: astore 18
    //   1160: iload 7
    //   1162: istore 8
    //   1164: aload 24
    //   1166: aload 26
    //   1168: invokestatic 346	com/mobisystems/mobiscanner/a/b:a	(Lcom/mobisystems/mobiscanner/image/Image$a;Lcom/mobisystems/mobiscanner/a/a;)Landroid/graphics/RectF;
    //   1171: astore 25
    //   1173: aload 14
    //   1175: astore 16
    //   1177: aload 15
    //   1179: astore 17
    //   1181: aload_3
    //   1182: astore 18
    //   1184: iload 7
    //   1186: istore 8
    //   1188: aload_0
    //   1189: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1192: new 129	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   1199: ldc_w 348
    //   1202: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: aload 25
    //   1207: invokevirtual 349	android/graphics/RectF:toString	()Ljava/lang/String;
    //   1210: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   1219: aload 14
    //   1221: astore 16
    //   1223: aload 15
    //   1225: astore 17
    //   1227: aload_3
    //   1228: astore 18
    //   1230: iload 7
    //   1232: istore 8
    //   1234: aload 25
    //   1236: invokevirtual 118	android/graphics/RectF:width	()F
    //   1239: aload 25
    //   1241: invokevirtual 120	android/graphics/RectF:height	()F
    //   1244: aload 26
    //   1246: getfield 336	com/mobisystems/mobiscanner/a/a:aJP	F
    //   1249: aload 26
    //   1251: getfield 353	com/mobisystems/mobiscanner/a/a:aJV	I
    //   1254: invokestatic 355	com/mobisystems/mobiscanner/a/b:a	(FFFI)Landroid/graphics/Rect;
    //   1257: astore 27
    //   1259: aload 14
    //   1261: astore 16
    //   1263: aload 15
    //   1265: astore 17
    //   1267: aload_3
    //   1268: astore 18
    //   1270: iload 7
    //   1272: istore 8
    //   1274: lload_1
    //   1275: invokestatic 136	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1278: astore 22
    //   1280: aload 14
    //   1282: astore 16
    //   1284: aload 15
    //   1286: astore 17
    //   1288: aload_3
    //   1289: astore 18
    //   1291: iload 7
    //   1293: istore 8
    //   1295: aload 27
    //   1297: invokevirtual 356	android/graphics/Rect:width	()I
    //   1300: istore 6
    //   1302: aload 14
    //   1304: astore 16
    //   1306: aload 15
    //   1308: astore 17
    //   1310: aload_3
    //   1311: astore 18
    //   1313: iload 7
    //   1315: istore 8
    //   1317: aload 27
    //   1319: invokevirtual 357	android/graphics/Rect:height	()I
    //   1322: istore 5
    //   1324: aload 14
    //   1326: astore 16
    //   1328: aload 15
    //   1330: astore 17
    //   1332: aload_3
    //   1333: astore 18
    //   1335: iload 7
    //   1337: istore 8
    //   1339: aload 24
    //   1341: invokevirtual 93	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   1344: aload 24
    //   1346: invokevirtual 96	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   1349: aload 24
    //   1351: invokevirtual 103	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   1354: iload 6
    //   1356: iload 5
    //   1358: getstatic 363	com/mobisystems/mobiscanner/image/Image$RestrictMemory:aHw	Lcom/mobisystems/mobiscanner/image/Image$RestrictMemory;
    //   1361: invokestatic 366	com/mobisystems/mobiscanner/image/Image:a	(IILcom/mobisystems/mobiscanner/image/ImageOrientation;IILcom/mobisystems/mobiscanner/image/Image$RestrictMemory;)I
    //   1364: iconst_1
    //   1365: if_icmpgt +329 -> 1694
    //   1368: aload 14
    //   1370: astore 16
    //   1372: aload 15
    //   1374: astore 17
    //   1376: aload_3
    //   1377: astore 18
    //   1379: iload 7
    //   1381: istore 8
    //   1383: aload 13
    //   1385: invokevirtual 370	com/mobisystems/mobiscanner/image/Image:HY	()Lcom/mobisystems/mobiscanner/image/Image$ImageStreamType;
    //   1388: getstatic 376	com/mobisystems/mobiscanner/image/Image$ImageStreamType:aHq	Lcom/mobisystems/mobiscanner/image/Image$ImageStreamType;
    //   1391: if_acmpne +303 -> 1694
    //   1394: aload 14
    //   1396: astore 16
    //   1398: aload 15
    //   1400: astore 17
    //   1402: aload_3
    //   1403: astore 18
    //   1405: iload 7
    //   1407: istore 8
    //   1409: aload_0
    //   1410: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1413: ldc_w 378
    //   1416: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   1419: aload 14
    //   1421: astore 16
    //   1423: aload 15
    //   1425: astore 17
    //   1427: aload_3
    //   1428: astore 18
    //   1430: iload 7
    //   1432: istore 8
    //   1434: aload 24
    //   1436: invokevirtual 103	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   1439: invokevirtual 384	com/mobisystems/mobiscanner/image/ImageOrientation:Il	()Lcom/mobisystems/office/pdfExport/PdfGraphicsContext$ImageOrientation;
    //   1442: astore 26
    //   1444: aload 14
    //   1446: astore 16
    //   1448: aload 15
    //   1450: astore 17
    //   1452: aload_3
    //   1453: astore 18
    //   1455: iload 7
    //   1457: istore 8
    //   1459: aload 23
    //   1461: aload 13
    //   1463: invokevirtual 388	com/mobisystems/mobiscanner/image/Image:HZ	()Ljava/io/BufferedInputStream;
    //   1466: aload 25
    //   1468: getfield 391	android/graphics/RectF:left	F
    //   1471: aload 25
    //   1473: getfield 394	android/graphics/RectF:top	F
    //   1476: aload 25
    //   1478: invokevirtual 118	android/graphics/RectF:width	()F
    //   1481: aload 25
    //   1483: invokevirtual 120	android/graphics/RectF:height	()F
    //   1486: aload 24
    //   1488: invokevirtual 93	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   1491: aload 24
    //   1493: invokevirtual 96	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   1496: aload 26
    //   1498: aload 22
    //   1500: invokevirtual 397	com/mobisystems/office/pdfExport/PdfGraphicsContext:a	(Ljava/io/InputStream;FFFFIILcom/mobisystems/office/pdfExport/PdfGraphicsContext$ImageOrientation;Ljava/lang/String;)V
    //   1503: aconst_null
    //   1504: astore 13
    //   1506: aload 14
    //   1508: astore 16
    //   1510: aload 15
    //   1512: astore 17
    //   1514: aload_3
    //   1515: astore 18
    //   1517: iload 7
    //   1519: istore 8
    //   1521: aload 14
    //   1523: invokevirtual 400	com/mobisystems/office/pdfExport/PdfWriter:Ko	()V
    //   1526: aload 13
    //   1528: ifnull +30 -> 1558
    //   1531: iconst_0
    //   1532: ifeq +320 -> 1852
    //   1535: aload 14
    //   1537: astore 16
    //   1539: aload 15
    //   1541: astore 17
    //   1543: aload_3
    //   1544: astore 18
    //   1546: iload 7
    //   1548: istore 8
    //   1550: new 402	java/lang/NullPointerException
    //   1553: dup
    //   1554: invokespecial 403	java/lang/NullPointerException:<init>	()V
    //   1557: athrow
    //   1558: aload 14
    //   1560: astore 16
    //   1562: aload 15
    //   1564: astore 17
    //   1566: aload_3
    //   1567: astore 18
    //   1569: iload 7
    //   1571: istore 8
    //   1573: aload 15
    //   1575: invokeinterface 406 1 0
    //   1580: pop
    //   1581: aload 14
    //   1583: astore 16
    //   1585: aload 15
    //   1587: astore 17
    //   1589: aload_3
    //   1590: astore 18
    //   1592: iload 7
    //   1594: istore 8
    //   1596: aload 4
    //   1598: aload 4
    //   1600: invokeinterface 410 1 0
    //   1605: checkcast 151	java/lang/Integer
    //   1608: invokevirtual 413	java/lang/Integer:intValue	()I
    //   1611: aload 15
    //   1613: invokeinterface 416 1 0
    //   1618: imul
    //   1619: aload 15
    //   1621: invokeinterface 419 1 0
    //   1626: idiv
    //   1627: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1630: invokeinterface 422 2 0
    //   1635: goto -1023 -> 612
    //   1638: astore 4
    //   1640: iload 8
    //   1642: istore 7
    //   1644: aload 18
    //   1646: astore_3
    //   1647: aload 17
    //   1649: astore 14
    //   1651: aload 16
    //   1653: astore 13
    //   1655: aload 14
    //   1657: ifnull +10 -> 1667
    //   1660: aload 14
    //   1662: invokeinterface 207 1 0
    //   1667: aload 13
    //   1669: ifnull +8 -> 1677
    //   1672: aload 13
    //   1674: invokevirtual 210	com/mobisystems/office/pdfExport/PdfWriter:close	()V
    //   1677: iload 7
    //   1679: ifne +12 -> 1691
    //   1682: aload_3
    //   1683: ifnull +8 -> 1691
    //   1686: aload_3
    //   1687: invokevirtual 213	java/io/File:delete	()Z
    //   1690: pop
    //   1691: aload 4
    //   1693: athrow
    //   1694: aload 14
    //   1696: astore 16
    //   1698: aload 15
    //   1700: astore 17
    //   1702: aload_3
    //   1703: astore 18
    //   1705: iload 7
    //   1707: istore 8
    //   1709: aload_0
    //   1710: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1713: ldc_w 424
    //   1716: invokevirtual 183	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   1719: aload 14
    //   1721: astore 16
    //   1723: aload 15
    //   1725: astore 17
    //   1727: aload_3
    //   1728: astore 18
    //   1730: iload 7
    //   1732: istore 8
    //   1734: aload 13
    //   1736: iload 6
    //   1738: iload 5
    //   1740: aconst_null
    //   1741: getstatic 363	com/mobisystems/mobiscanner/image/Image$RestrictMemory:aHw	Lcom/mobisystems/mobiscanner/image/Image$RestrictMemory;
    //   1744: invokevirtual 427	com/mobisystems/mobiscanner/image/Image:a	(IILcom/mobisystems/mobiscanner/image/k;Lcom/mobisystems/mobiscanner/image/Image$RestrictMemory;)Landroid/graphics/Bitmap;
    //   1747: astore 13
    //   1749: aload 13
    //   1751: ifnull +56 -> 1807
    //   1754: aload 14
    //   1756: astore 16
    //   1758: aload 15
    //   1760: astore 17
    //   1762: aload_3
    //   1763: astore 18
    //   1765: iload 7
    //   1767: istore 8
    //   1769: aload 23
    //   1771: aload 13
    //   1773: aload 25
    //   1775: getfield 391	android/graphics/RectF:left	F
    //   1778: aload 25
    //   1780: getfield 394	android/graphics/RectF:top	F
    //   1783: aload 25
    //   1785: invokevirtual 118	android/graphics/RectF:width	()F
    //   1788: aload 25
    //   1790: invokevirtual 120	android/graphics/RectF:height	()F
    //   1793: aload 26
    //   1795: getfield 430	com/mobisystems/mobiscanner/a/a:quality	I
    //   1798: aconst_null
    //   1799: aload 22
    //   1801: invokevirtual 433	com/mobisystems/office/pdfExport/PdfGraphicsContext:a	(Landroid/graphics/Bitmap;FFFFILandroid/graphics/Paint;Ljava/lang/String;)V
    //   1804: goto -298 -> 1506
    //   1807: aload 14
    //   1809: astore 16
    //   1811: aload 15
    //   1813: astore 17
    //   1815: aload_3
    //   1816: astore 18
    //   1818: iload 7
    //   1820: istore 8
    //   1822: aload_0
    //   1823: getfield 31	com/mobisystems/mobiscanner/a/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1826: new 129	java/lang/StringBuilder
    //   1829: dup
    //   1830: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   1833: ldc_w 435
    //   1836: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: lload_1
    //   1840: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1843: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1846: invokevirtual 438	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   1849: goto -343 -> 1506
    //   1852: aload 14
    //   1854: astore 16
    //   1856: aload 15
    //   1858: astore 17
    //   1860: aload_3
    //   1861: astore 18
    //   1863: iload 7
    //   1865: istore 8
    //   1867: aload 13
    //   1869: invokevirtual 443	android/graphics/Bitmap:recycle	()V
    //   1872: goto -314 -> 1558
    //   1875: aload 14
    //   1877: astore 16
    //   1879: aload 15
    //   1881: astore 17
    //   1883: aload_3
    //   1884: astore 18
    //   1886: iload 7
    //   1888: istore 8
    //   1890: aload 4
    //   1892: invokeinterface 192 1 0
    //   1897: ifeq +28 -> 1925
    //   1900: aload 14
    //   1902: astore 16
    //   1904: aload 15
    //   1906: astore 17
    //   1908: aload_3
    //   1909: astore 18
    //   1911: iload 7
    //   1913: istore 8
    //   1915: new 167	java/lang/InterruptedException
    //   1918: dup
    //   1919: ldc -62
    //   1921: invokespecial 196	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   1924: athrow
    //   1925: aload 14
    //   1927: astore 16
    //   1929: aload 15
    //   1931: astore 17
    //   1933: aload_3
    //   1934: astore 18
    //   1936: iload 7
    //   1938: istore 8
    //   1940: aload 14
    //   1942: invokevirtual 446	com/mobisystems/office/pdfExport/PdfWriter:endDocument	()V
    //   1945: aload 14
    //   1947: astore 16
    //   1949: aload 15
    //   1951: astore 17
    //   1953: aload_3
    //   1954: astore 18
    //   1956: iload 7
    //   1958: istore 8
    //   1960: aload 14
    //   1962: invokevirtual 210	com/mobisystems/office/pdfExport/PdfWriter:close	()V
    //   1965: iconst_1
    //   1966: istore 7
    //   1968: aload 15
    //   1970: astore 13
    //   1972: aconst_null
    //   1973: astore 14
    //   1975: iload 7
    //   1977: ifeq +22 -> 1999
    //   1980: aload_0
    //   1981: getfield 40	com/mobisystems/mobiscanner/a/b:aJZ	Lcom/mobisystems/mobiscanner/common/b;
    //   1984: ifnull +15 -> 1999
    //   1987: aload_0
    //   1988: getfield 40	com/mobisystems/mobiscanner/a/b:aJZ	Lcom/mobisystems/mobiscanner/common/b;
    //   1991: aload 19
    //   1993: aload_3
    //   1994: aload 4
    //   1996: invokevirtual 449	com/mobisystems/mobiscanner/common/b:a	(Ljava/lang/String;Ljava/io/File;Lcom/mobisystems/mobiscanner/common/a;)V
    //   1999: aload 13
    //   2001: ifnull +10 -> 2011
    //   2004: aload 13
    //   2006: invokeinterface 207 1 0
    //   2011: iconst_0
    //   2012: ifeq +11 -> 2023
    //   2015: new 402	java/lang/NullPointerException
    //   2018: dup
    //   2019: invokespecial 403	java/lang/NullPointerException:<init>	()V
    //   2022: athrow
    //   2023: aload_3
    //   2024: astore 4
    //   2026: iload 7
    //   2028: ifne +15 -> 2043
    //   2031: aload_3
    //   2032: ifnull +8 -> 2040
    //   2035: aload_3
    //   2036: invokevirtual 213	java/io/File:delete	()Z
    //   2039: pop
    //   2040: aconst_null
    //   2041: astore 4
    //   2043: aload 4
    //   2045: astore_3
    //   2046: iload 7
    //   2048: istore 8
    //   2050: goto -1881 -> 169
    //   2053: ldc -36
    //   2055: astore 4
    //   2057: goto -1846 -> 211
    //   2060: astore 4
    //   2062: aconst_null
    //   2063: astore 13
    //   2065: aconst_null
    //   2066: astore 14
    //   2068: aconst_null
    //   2069: astore_3
    //   2070: iconst_0
    //   2071: istore 7
    //   2073: goto -418 -> 1655
    //   2076: astore 4
    //   2078: aconst_null
    //   2079: astore 13
    //   2081: aconst_null
    //   2082: astore 14
    //   2084: iconst_0
    //   2085: istore 7
    //   2087: goto -432 -> 1655
    //   2090: astore 4
    //   2092: aconst_null
    //   2093: astore 13
    //   2095: aconst_null
    //   2096: astore 14
    //   2098: goto -443 -> 1655
    //   2101: astore 4
    //   2103: aconst_null
    //   2104: astore 13
    //   2106: aconst_null
    //   2107: astore 14
    //   2109: goto -454 -> 1655
    //   2112: astore 4
    //   2114: aconst_null
    //   2115: astore 15
    //   2117: aload 14
    //   2119: astore 13
    //   2121: aload 15
    //   2123: astore 14
    //   2125: goto -470 -> 1655
    //   2128: astore 4
    //   2130: aconst_null
    //   2131: astore 15
    //   2133: aload 13
    //   2135: astore 14
    //   2137: aload 15
    //   2139: astore 13
    //   2141: goto -486 -> 1655
    //   2144: astore 4
    //   2146: aload 13
    //   2148: astore 15
    //   2150: aload 14
    //   2152: astore 13
    //   2154: aload 15
    //   2156: astore 14
    //   2158: goto -503 -> 1655
    //   2161: astore_3
    //   2162: aconst_null
    //   2163: astore 13
    //   2165: aconst_null
    //   2166: astore 4
    //   2168: aconst_null
    //   2169: astore 19
    //   2171: iconst_0
    //   2172: istore 7
    //   2174: goto -1349 -> 825
    //   2177: astore 4
    //   2179: aconst_null
    //   2180: astore 13
    //   2182: aconst_null
    //   2183: astore 4
    //   2185: iconst_0
    //   2186: istore 7
    //   2188: aload_3
    //   2189: astore 19
    //   2191: goto -1366 -> 825
    //   2194: astore 4
    //   2196: aconst_null
    //   2197: astore 13
    //   2199: aconst_null
    //   2200: astore 4
    //   2202: aload_3
    //   2203: astore 19
    //   2205: goto -1380 -> 825
    //   2208: astore 4
    //   2210: aconst_null
    //   2211: astore 13
    //   2213: aconst_null
    //   2214: astore 4
    //   2216: aload_3
    //   2217: astore 19
    //   2219: goto -1394 -> 825
    //   2222: astore 4
    //   2224: aconst_null
    //   2225: astore 4
    //   2227: aload 14
    //   2229: astore 13
    //   2231: aload_3
    //   2232: astore 19
    //   2234: goto -1409 -> 825
    //   2237: astore 4
    //   2239: aconst_null
    //   2240: astore 14
    //   2242: aload 13
    //   2244: astore 4
    //   2246: aload 14
    //   2248: astore 13
    //   2250: aload_3
    //   2251: astore 19
    //   2253: goto -1428 -> 825
    //   2256: astore 13
    //   2258: aconst_null
    //   2259: astore 14
    //   2261: aconst_null
    //   2262: astore 4
    //   2264: iconst_0
    //   2265: istore 7
    //   2267: aload_3
    //   2268: astore 15
    //   2270: goto -1972 -> 298
    //   2273: astore 13
    //   2275: aconst_null
    //   2276: astore 14
    //   2278: aconst_null
    //   2279: astore 4
    //   2281: aload_3
    //   2282: astore 15
    //   2284: goto -1986 -> 298
    //   2287: astore 13
    //   2289: aconst_null
    //   2290: astore 14
    //   2292: aconst_null
    //   2293: astore 4
    //   2295: aload_3
    //   2296: astore 15
    //   2298: goto -2000 -> 298
    //   2301: astore 13
    //   2303: aconst_null
    //   2304: astore 4
    //   2306: aload_3
    //   2307: astore 15
    //   2309: goto -2011 -> 298
    //   2312: astore 15
    //   2314: aconst_null
    //   2315: astore 14
    //   2317: aload 13
    //   2319: astore 4
    //   2321: aload 15
    //   2323: astore 13
    //   2325: aload_3
    //   2326: astore 15
    //   2328: goto -2030 -> 298
    //   2331: astore 4
    //   2333: aload 15
    //   2335: astore 14
    //   2337: iload 8
    //   2339: istore 7
    //   2341: goto -2232 -> 109
    //   2344: astore 4
    //   2346: aload 15
    //   2348: astore 14
    //   2350: goto -2241 -> 109
    //   2353: astore 4
    //   2355: aload 15
    //   2357: astore 14
    //   2359: goto -2250 -> 109
    //   2362: astore 4
    //   2364: goto -2255 -> 109
    //   2367: astore 4
    //   2369: goto -2260 -> 109
    //   2372: aload 14
    //   2374: astore 13
    //   2376: goto -404 -> 1972
    //   2379: goto -1887 -> 492
    //   2382: iconst_0
    //   2383: istore 7
    //   2385: goto -1893 -> 492
    //   2388: astore 4
    //   2390: aload 15
    //   2392: astore 13
    //   2394: goto -2285 -> 109
    //   2397: astore 16
    //   2399: goto -1907 -> 492
    //   2402: astore 13
    //   2404: aload 15
    //   2406: astore 4
    //   2408: aload_3
    //   2409: astore 15
    //   2411: goto -2113 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2414	0	this	b
    //   0	2414	1	paramLong	long
    //   0	2414	3	paramFile	java.io.File
    //   0	2414	4	parama	com.mobisystems.mobiscanner.common.a<Integer>
    //   756	983	5	i	int
    //   1300	437	6	j	int
    //   100	2284	7	bool1	boolean
    //   55	2283	8	bool2	boolean
    //   465	22	9	l1	long
    //   441	29	11	l2	long
    //   37	194	13	localObject1	Object
    //   284	37	13	localOutOfMemoryError1	OutOfMemoryError
    //   779	1470	13	localObject2	Object
    //   2256	1	13	localOutOfMemoryError2	OutOfMemoryError
    //   2273	1	13	localOutOfMemoryError3	OutOfMemoryError
    //   2287	1	13	localOutOfMemoryError4	OutOfMemoryError
    //   2301	17	13	localOutOfMemoryError5	OutOfMemoryError
    //   2323	70	13	localObject3	Object
    //   2402	1	13	localOutOfMemoryError6	OutOfMemoryError
    //   27	2346	14	localObject4	Object
    //   4	2304	15	localObject5	Object
    //   2312	10	15	localOutOfMemoryError7	OutOfMemoryError
    //   2326	84	15	localFile	java.io.File
    //   65	1883	16	localObject6	Object
    //   2397	1	16	localInterruptedException	InterruptedException
    //   304	1648	17	localObject7	Object
    //   308	1647	18	localObject8	Object
    //   429	1823	19	localObject9	Object
    //   250	457	20	localb	com.mobisystems.mobiscanner.model.b
    //   242	532	21	localDocumentModel	com.mobisystems.mobiscanner.model.DocumentModel
    //   713	1087	22	localObject10	Object
    //   1147	623	23	localPdfGraphicsContext	com.mobisystems.office.pdfExport.PdfGraphicsContext
    //   973	519	24	locala	Image.a
    //   1171	618	25	localRectF	RectF
    //   1001	793	26	localObject11	Object
    //   1257	61	27	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   76	96	96	java/io/IOException
    //   235	252	96	java/io/IOException
    //   257	284	96	java/io/IOException
    //   383	419	96	java/io/IOException
    //   76	96	284	java/lang/OutOfMemoryError
    //   235	252	284	java/lang/OutOfMemoryError
    //   257	284	284	java/lang/OutOfMemoryError
    //   383	419	284	java/lang/OutOfMemoryError
    //   540	568	812	java/lang/InterruptedException
    //   583	589	812	java/lang/InterruptedException
    //   604	612	812	java/lang/InterruptedException
    //   627	637	812	java/lang/InterruptedException
    //   652	662	812	java/lang/InterruptedException
    //   677	687	812	java/lang/InterruptedException
    //   702	715	812	java/lang/InterruptedException
    //   730	736	812	java/lang/InterruptedException
    //   751	758	812	java/lang/InterruptedException
    //   773	781	812	java/lang/InterruptedException
    //   801	812	812	java/lang/InterruptedException
    //   922	953	812	java/lang/InterruptedException
    //   968	975	812	java/lang/InterruptedException
    //   990	1003	812	java/lang/InterruptedException
    //   1018	1088	812	java/lang/InterruptedException
    //   1103	1123	812	java/lang/InterruptedException
    //   1138	1149	812	java/lang/InterruptedException
    //   1164	1173	812	java/lang/InterruptedException
    //   1188	1219	812	java/lang/InterruptedException
    //   1234	1259	812	java/lang/InterruptedException
    //   1274	1280	812	java/lang/InterruptedException
    //   1295	1302	812	java/lang/InterruptedException
    //   1317	1324	812	java/lang/InterruptedException
    //   1339	1368	812	java/lang/InterruptedException
    //   1383	1394	812	java/lang/InterruptedException
    //   1409	1419	812	java/lang/InterruptedException
    //   1434	1444	812	java/lang/InterruptedException
    //   1459	1503	812	java/lang/InterruptedException
    //   1521	1526	812	java/lang/InterruptedException
    //   1550	1558	812	java/lang/InterruptedException
    //   1573	1581	812	java/lang/InterruptedException
    //   1596	1635	812	java/lang/InterruptedException
    //   1709	1719	812	java/lang/InterruptedException
    //   1734	1749	812	java/lang/InterruptedException
    //   1769	1804	812	java/lang/InterruptedException
    //   1822	1849	812	java/lang/InterruptedException
    //   1867	1872	812	java/lang/InterruptedException
    //   1890	1900	812	java/lang/InterruptedException
    //   1915	1925	812	java/lang/InterruptedException
    //   1940	1945	812	java/lang/InterruptedException
    //   1960	1965	812	java/lang/InterruptedException
    //   314	325	1638	finally
    //   540	568	1638	finally
    //   583	589	1638	finally
    //   604	612	1638	finally
    //   627	637	1638	finally
    //   652	662	1638	finally
    //   677	687	1638	finally
    //   702	715	1638	finally
    //   730	736	1638	finally
    //   751	758	1638	finally
    //   773	781	1638	finally
    //   801	812	1638	finally
    //   841	851	1638	finally
    //   922	953	1638	finally
    //   968	975	1638	finally
    //   990	1003	1638	finally
    //   1018	1088	1638	finally
    //   1103	1123	1638	finally
    //   1138	1149	1638	finally
    //   1164	1173	1638	finally
    //   1188	1219	1638	finally
    //   1234	1259	1638	finally
    //   1274	1280	1638	finally
    //   1295	1302	1638	finally
    //   1317	1324	1638	finally
    //   1339	1368	1638	finally
    //   1383	1394	1638	finally
    //   1409	1419	1638	finally
    //   1434	1444	1638	finally
    //   1459	1503	1638	finally
    //   1521	1526	1638	finally
    //   1550	1558	1638	finally
    //   1573	1581	1638	finally
    //   1596	1635	1638	finally
    //   1709	1719	1638	finally
    //   1734	1749	1638	finally
    //   1769	1804	1638	finally
    //   1822	1849	1638	finally
    //   1867	1872	1638	finally
    //   1890	1900	1638	finally
    //   1915	1925	1638	finally
    //   1940	1945	1638	finally
    //   1960	1965	1638	finally
    //   76	96	2060	finally
    //   235	252	2060	finally
    //   257	284	2060	finally
    //   383	419	2060	finally
    //   419	457	2076	finally
    //   462	467	2090	finally
    //   483	492	2090	finally
    //   497	507	2101	finally
    //   507	520	2112	finally
    //   1980	1999	2128	finally
    //   109	120	2144	finally
    //   76	96	2161	java/lang/InterruptedException
    //   235	252	2161	java/lang/InterruptedException
    //   257	284	2161	java/lang/InterruptedException
    //   383	419	2161	java/lang/InterruptedException
    //   419	457	2177	java/lang/InterruptedException
    //   462	467	2194	java/lang/InterruptedException
    //   497	507	2208	java/lang/InterruptedException
    //   507	520	2222	java/lang/InterruptedException
    //   1980	1999	2237	java/lang/InterruptedException
    //   419	457	2256	java/lang/OutOfMemoryError
    //   462	467	2273	java/lang/OutOfMemoryError
    //   483	492	2273	java/lang/OutOfMemoryError
    //   497	507	2287	java/lang/OutOfMemoryError
    //   507	520	2301	java/lang/OutOfMemoryError
    //   1980	1999	2312	java/lang/OutOfMemoryError
    //   419	457	2331	java/io/IOException
    //   462	467	2344	java/io/IOException
    //   483	492	2344	java/io/IOException
    //   497	507	2353	java/io/IOException
    //   507	520	2362	java/io/IOException
    //   1980	1999	2367	java/io/IOException
    //   540	568	2388	java/io/IOException
    //   583	589	2388	java/io/IOException
    //   604	612	2388	java/io/IOException
    //   627	637	2388	java/io/IOException
    //   652	662	2388	java/io/IOException
    //   677	687	2388	java/io/IOException
    //   702	715	2388	java/io/IOException
    //   730	736	2388	java/io/IOException
    //   751	758	2388	java/io/IOException
    //   773	781	2388	java/io/IOException
    //   801	812	2388	java/io/IOException
    //   922	953	2388	java/io/IOException
    //   968	975	2388	java/io/IOException
    //   990	1003	2388	java/io/IOException
    //   1018	1088	2388	java/io/IOException
    //   1103	1123	2388	java/io/IOException
    //   1138	1149	2388	java/io/IOException
    //   1164	1173	2388	java/io/IOException
    //   1188	1219	2388	java/io/IOException
    //   1234	1259	2388	java/io/IOException
    //   1274	1280	2388	java/io/IOException
    //   1295	1302	2388	java/io/IOException
    //   1317	1324	2388	java/io/IOException
    //   1339	1368	2388	java/io/IOException
    //   1383	1394	2388	java/io/IOException
    //   1409	1419	2388	java/io/IOException
    //   1434	1444	2388	java/io/IOException
    //   1459	1503	2388	java/io/IOException
    //   1521	1526	2388	java/io/IOException
    //   1550	1558	2388	java/io/IOException
    //   1573	1581	2388	java/io/IOException
    //   1596	1635	2388	java/io/IOException
    //   1709	1719	2388	java/io/IOException
    //   1734	1749	2388	java/io/IOException
    //   1769	1804	2388	java/io/IOException
    //   1822	1849	2388	java/io/IOException
    //   1867	1872	2388	java/io/IOException
    //   1890	1900	2388	java/io/IOException
    //   1915	1925	2388	java/io/IOException
    //   1940	1945	2388	java/io/IOException
    //   1960	1965	2388	java/io/IOException
    //   483	492	2397	java/lang/InterruptedException
    //   540	568	2402	java/lang/OutOfMemoryError
    //   583	589	2402	java/lang/OutOfMemoryError
    //   604	612	2402	java/lang/OutOfMemoryError
    //   627	637	2402	java/lang/OutOfMemoryError
    //   652	662	2402	java/lang/OutOfMemoryError
    //   677	687	2402	java/lang/OutOfMemoryError
    //   702	715	2402	java/lang/OutOfMemoryError
    //   730	736	2402	java/lang/OutOfMemoryError
    //   751	758	2402	java/lang/OutOfMemoryError
    //   773	781	2402	java/lang/OutOfMemoryError
    //   801	812	2402	java/lang/OutOfMemoryError
    //   922	953	2402	java/lang/OutOfMemoryError
    //   968	975	2402	java/lang/OutOfMemoryError
    //   990	1003	2402	java/lang/OutOfMemoryError
    //   1018	1088	2402	java/lang/OutOfMemoryError
    //   1103	1123	2402	java/lang/OutOfMemoryError
    //   1138	1149	2402	java/lang/OutOfMemoryError
    //   1164	1173	2402	java/lang/OutOfMemoryError
    //   1188	1219	2402	java/lang/OutOfMemoryError
    //   1234	1259	2402	java/lang/OutOfMemoryError
    //   1274	1280	2402	java/lang/OutOfMemoryError
    //   1295	1302	2402	java/lang/OutOfMemoryError
    //   1317	1324	2402	java/lang/OutOfMemoryError
    //   1339	1368	2402	java/lang/OutOfMemoryError
    //   1383	1394	2402	java/lang/OutOfMemoryError
    //   1409	1419	2402	java/lang/OutOfMemoryError
    //   1434	1444	2402	java/lang/OutOfMemoryError
    //   1459	1503	2402	java/lang/OutOfMemoryError
    //   1521	1526	2402	java/lang/OutOfMemoryError
    //   1550	1558	2402	java/lang/OutOfMemoryError
    //   1573	1581	2402	java/lang/OutOfMemoryError
    //   1596	1635	2402	java/lang/OutOfMemoryError
    //   1709	1719	2402	java/lang/OutOfMemoryError
    //   1734	1749	2402	java/lang/OutOfMemoryError
    //   1769	1804	2402	java/lang/OutOfMemoryError
    //   1822	1849	2402	java/lang/OutOfMemoryError
    //   1867	1872	2402	java/lang/OutOfMemoryError
    //   1890	1900	2402	java/lang/OutOfMemoryError
    //   1915	1925	2402	java/lang/OutOfMemoryError
    //   1940	1945	2402	java/lang/OutOfMemoryError
    //   1960	1965	2402	java/lang/OutOfMemoryError
  }
  
  public void flushCache()
  {
    new a().execute(new Object[] { Integer.valueOf(2) });
  }
  
  protected class a
    extends AsyncTask<Object, Void, Void>
  {
    protected a() {}
    
    protected Void b(Object... paramVarArgs)
    {
      switch (((Integer)paramVarArgs[0]).intValue())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (b.a(b.this) == null);
            b.a(b.this).clearCache();
            return null;
          } while (b.a(b.this) == null);
          b.a(b.this).Dr();
          return null;
        } while (b.a(b.this) == null);
        b.a(b.this).flush();
        return null;
      } while (b.a(b.this) == null);
      b.a(b.this).close();
      b.a(b.this, null);
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */