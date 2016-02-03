package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.model.b;
import java.util.concurrent.atomic.AtomicInteger;

public class ai
  extends bb
{
  private long aAa;
  private String[] aDP;
  private boolean aDQ;
  private b axZ;
  
  public ai(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aAa = paramBundle.getLong("doc_id");
    this.axZ = new b(paramBundle);
    this.aDP = paramBundle.getStringArray("IMAGE_IMPORT_FILES");
    this.aDQ = paramBundle.getBoolean("COPY_FLAG");
  }
  
  /* Error */
  protected Bundle c(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 64	com/mobisystems/mobiscanner/controller/ai:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   6: new 66	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   13: ldc 71
    //   15: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: getfield 26	com/mobisystems/mobiscanner/controller/ai:aAa	J
    //   22: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokevirtual 88	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   31: new 90	com/mobisystems/mobiscanner/model/DocumentModel
    //   34: dup
    //   35: invokespecial 91	com/mobisystems/mobiscanner/model/DocumentModel:<init>	()V
    //   38: astore 13
    //   40: aload_0
    //   41: getstatic 97	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   44: putfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   47: aload_0
    //   48: getfield 26	com/mobisystems/mobiscanner/controller/ai:aAa	J
    //   51: lstore_3
    //   52: lload_3
    //   53: lconst_0
    //   54: lcmp
    //   55: iflt +564 -> 619
    //   58: aload 13
    //   60: lload_3
    //   61: invokevirtual 104	com/mobisystems/mobiscanner/model/DocumentModel:ae	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +553 -> 619
    //   69: aload_1
    //   70: invokevirtual 108	com/mobisystems/mobiscanner/model/b:IA	()J
    //   73: lstore 7
    //   75: new 110	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 111	java/util/ArrayList:<init>	()V
    //   82: astore 14
    //   84: iconst_0
    //   85: istore_2
    //   86: iload_2
    //   87: aload_0
    //   88: getfield 41	com/mobisystems/mobiscanner/controller/ai:aDP	[Ljava/lang/String;
    //   91: arraylength
    //   92: if_icmpge +524 -> 616
    //   95: aload_0
    //   96: getfield 41	com/mobisystems/mobiscanner/controller/ai:aDP	[Ljava/lang/String;
    //   99: iload_2
    //   100: aaload
    //   101: astore 12
    //   103: aload 12
    //   105: ifnonnull +6 -> 111
    //   108: goto +519 -> 627
    //   111: aload_0
    //   112: getfield 49	com/mobisystems/mobiscanner/controller/ai:aDQ	Z
    //   115: istore 11
    //   117: aconst_null
    //   118: astore_1
    //   119: new 113	java/io/File
    //   122: dup
    //   123: aload 12
    //   125: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: invokevirtual 119	java/io/File:isFile	()Z
    //   131: ifeq +189 -> 320
    //   134: aload 12
    //   136: astore_1
    //   137: lload_3
    //   138: lstore 5
    //   140: aload_1
    //   141: ifnull +102 -> 243
    //   144: new 121	com/mobisystems/mobiscanner/model/c
    //   147: dup
    //   148: invokespecial 122	com/mobisystems/mobiscanner/model/c:<init>	()V
    //   151: astore 12
    //   153: aload 12
    //   155: aload_0
    //   156: getfield 33	com/mobisystems/mobiscanner/controller/ai:axZ	Lcom/mobisystems/mobiscanner/model/b;
    //   159: invokevirtual 126	com/mobisystems/mobiscanner/model/c:g	(Lcom/mobisystems/mobiscanner/model/b;)V
    //   162: aload 13
    //   164: lload_3
    //   165: aload_1
    //   166: iload 11
    //   168: aload 12
    //   170: invokevirtual 130	com/mobisystems/mobiscanner/model/DocumentModel:a	(JLjava/lang/String;ZLcom/mobisystems/mobiscanner/model/c;)J
    //   173: lstore 9
    //   175: lload 9
    //   177: lconst_0
    //   178: lcmp
    //   179: ifge +325 -> 504
    //   182: aload_0
    //   183: aload 13
    //   185: invokevirtual 134	com/mobisystems/mobiscanner/model/DocumentModel:It	()Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   188: putfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   191: aload_0
    //   192: getfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   195: getstatic 137	com/mobisystems/mobiscanner/common/OperationStatus:awf	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   198: invokevirtual 141	com/mobisystems/mobiscanner/common/OperationStatus:equals	(Ljava/lang/Object;)Z
    //   201: ifne +32 -> 233
    //   204: aload_0
    //   205: getfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   208: getstatic 144	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   211: invokevirtual 141	com/mobisystems/mobiscanner/common/OperationStatus:equals	(Ljava/lang/Object;)Z
    //   214: ifne +19 -> 233
    //   217: lload_3
    //   218: lstore 5
    //   220: aload_0
    //   221: getfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   224: getstatic 147	com/mobisystems/mobiscanner/common/OperationStatus:awe	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   227: invokevirtual 141	com/mobisystems/mobiscanner/common/OperationStatus:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +13 -> 243
    //   233: aload_0
    //   234: getstatic 150	com/mobisystems/mobiscanner/common/OperationStatus:avM	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   237: putfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   240: lload_3
    //   241: lstore 5
    //   243: aload_0
    //   244: iload_2
    //   245: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: invokevirtual 160	com/mobisystems/mobiscanner/controller/ai:e	(Ljava/lang/Integer;)V
    //   251: lload 5
    //   253: lstore_3
    //   254: aload_0
    //   255: invokevirtual 163	com/mobisystems/mobiscanner/controller/ai:isCancelled	()Z
    //   258: ifeq +369 -> 627
    //   261: lload 5
    //   263: lstore_3
    //   264: aload_0
    //   265: invokevirtual 163	com/mobisystems/mobiscanner/controller/ai:isCancelled	()Z
    //   268: ifeq +333 -> 601
    //   271: aload_0
    //   272: getfield 26	com/mobisystems/mobiscanner/controller/ai:aAa	J
    //   275: lconst_0
    //   276: lcmp
    //   277: ifge +274 -> 551
    //   280: aload 13
    //   282: lload_3
    //   283: invokevirtual 167	com/mobisystems/mobiscanner/model/DocumentModel:ag	(J)Z
    //   286: pop
    //   287: aconst_null
    //   288: astore_1
    //   289: aload_0
    //   290: getfield 171	com/mobisystems/mobiscanner/controller/ai:mContext	Landroid/content/Context;
    //   293: invokestatic 177	com/mobisystems/mobiscanner/common/d:Y	(Landroid/content/Context;)Ljava/io/File;
    //   296: invokestatic 181	com/mobisystems/mobiscanner/common/d:d	(Ljava/io/File;)V
    //   299: aload_1
    //   300: ifnull +11 -> 311
    //   303: aload_1
    //   304: aload_0
    //   305: getfield 185	com/mobisystems/mobiscanner/controller/ai:aFZ	Landroid/os/Bundle;
    //   308: invokevirtual 188	com/mobisystems/mobiscanner/model/b:p	(Landroid/os/Bundle;)V
    //   311: aload_0
    //   312: getfield 185	com/mobisystems/mobiscanner/controller/ai:aFZ	Landroid/os/Bundle;
    //   315: astore_1
    //   316: aload_0
    //   317: monitorexit
    //   318: aload_1
    //   319: areturn
    //   320: new 190	java/net/URL
    //   323: dup
    //   324: aload 12
    //   326: invokespecial 191	java/net/URL:<init>	(Ljava/lang/String;)V
    //   329: astore 12
    //   331: aload 12
    //   333: invokevirtual 194	java/net/URL:getProtocol	()Ljava/lang/String;
    //   336: astore 15
    //   338: ldc -60
    //   340: aload 15
    //   342: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   345: ifeq +16 -> 361
    //   348: aload 12
    //   350: invokevirtual 202	java/net/URL:getPath	()Ljava/lang/String;
    //   353: astore 12
    //   355: aload 12
    //   357: astore_1
    //   358: goto -221 -> 137
    //   361: ldc -52
    //   363: aload 15
    //   365: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   368: ifne +23 -> 391
    //   371: ldc -50
    //   373: aload 15
    //   375: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifne +13 -> 391
    //   381: ldc -48
    //   383: aload 15
    //   385: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   388: ifeq +35 -> 423
    //   391: aload_0
    //   392: getfield 171	com/mobisystems/mobiscanner/controller/ai:mContext	Landroid/content/Context;
    //   395: invokestatic 211	com/mobisystems/mobiscanner/common/d:af	(Landroid/content/Context;)Ljava/io/File;
    //   398: astore 15
    //   400: aload 12
    //   402: aload 15
    //   404: invokestatic 214	com/mobisystems/mobiscanner/common/d:a	(Ljava/net/URL;Ljava/io/File;)V
    //   407: aload 15
    //   409: invokevirtual 217	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   412: astore 12
    //   414: iconst_0
    //   415: istore 11
    //   417: aload 12
    //   419: astore_1
    //   420: goto -283 -> 137
    //   423: aload_0
    //   424: getstatic 150	com/mobisystems/mobiscanner/common/OperationStatus:avM	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   427: putfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   430: goto -293 -> 137
    //   433: astore 12
    //   435: aload_0
    //   436: getfield 64	com/mobisystems/mobiscanner/controller/ai:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   439: ldc -37
    //   441: aload 12
    //   443: invokevirtual 222	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   446: aload_0
    //   447: getstatic 225	com/mobisystems/mobiscanner/common/OperationStatus:awi	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   450: putfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   453: goto -316 -> 137
    //   456: astore_1
    //   457: aload_0
    //   458: monitorexit
    //   459: aload_1
    //   460: athrow
    //   461: astore_1
    //   462: aload_0
    //   463: getfield 64	com/mobisystems/mobiscanner/controller/ai:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   466: ldc -29
    //   468: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   471: aload_0
    //   472: getstatic 233	com/mobisystems/mobiscanner/common/OperationStatus:awj	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   475: putfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   478: goto -214 -> 264
    //   481: astore 12
    //   483: aload_0
    //   484: getfield 64	com/mobisystems/mobiscanner/controller/ai:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   487: ldc -21
    //   489: aload 12
    //   491: invokevirtual 222	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload_0
    //   495: getstatic 225	com/mobisystems/mobiscanner/common/OperationStatus:awi	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   498: putfield 100	com/mobisystems/mobiscanner/controller/ai:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   501: goto -364 -> 137
    //   504: aload 14
    //   506: lload 9
    //   508: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: invokevirtual 243	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   514: pop
    //   515: lload_3
    //   516: lstore 5
    //   518: aload_0
    //   519: getfield 26	com/mobisystems/mobiscanner/controller/ai:aAa	J
    //   522: lconst_0
    //   523: lcmp
    //   524: ifge -281 -> 243
    //   527: aload 13
    //   529: lload 9
    //   531: invokevirtual 245	com/mobisystems/mobiscanner/model/DocumentModel:af	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   534: astore_1
    //   535: lload_3
    //   536: lstore 5
    //   538: aload_1
    //   539: ifnull -296 -> 243
    //   542: aload_1
    //   543: invokevirtual 248	com/mobisystems/mobiscanner/model/b:getId	()J
    //   546: lstore 5
    //   548: goto -305 -> 243
    //   551: aload 14
    //   553: invokevirtual 252	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   556: astore_1
    //   557: aload_1
    //   558: invokeinterface 257 1 0
    //   563: ifeq +24 -> 587
    //   566: aload 13
    //   568: aload_1
    //   569: invokeinterface 261 1 0
    //   574: checkcast 237	java/lang/Long
    //   577: invokevirtual 264	java/lang/Long:longValue	()J
    //   580: invokevirtual 267	com/mobisystems/mobiscanner/model/DocumentModel:ak	(J)Z
    //   583: pop
    //   584: goto -27 -> 557
    //   587: aload 13
    //   589: lload_3
    //   590: lload 7
    //   592: invokevirtual 270	com/mobisystems/mobiscanner/model/DocumentModel:g	(JJ)Z
    //   595: pop
    //   596: aconst_null
    //   597: astore_1
    //   598: goto -309 -> 289
    //   601: aload 13
    //   603: lload_3
    //   604: invokevirtual 104	com/mobisystems/mobiscanner/model/DocumentModel:ae	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   607: astore_1
    //   608: goto -319 -> 289
    //   611: astore 12
    //   613: goto -314 -> 299
    //   616: goto -352 -> 264
    //   619: ldc2_w 271
    //   622: lstore 7
    //   624: goto -549 -> 75
    //   627: iload_2
    //   628: iconst_1
    //   629: iadd
    //   630: istore_2
    //   631: goto -545 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	ai
    //   0	634	1	paramVarArgs	Void[]
    //   85	546	2	i	int
    //   51	553	3	l1	long
    //   138	409	5	l2	long
    //   73	550	7	l3	long
    //   173	357	9	l4	long
    //   115	301	11	bool	boolean
    //   101	317	12	localObject1	Object
    //   433	9	12	localMalformedURLException	java.net.MalformedURLException
    //   481	9	12	localIOException1	java.io.IOException
    //   611	1	12	localIOException2	java.io.IOException
    //   38	564	13	localDocumentModel	com.mobisystems.mobiscanner.model.DocumentModel
    //   82	470	14	localArrayList	java.util.ArrayList
    //   336	72	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   320	355	433	java/net/MalformedURLException
    //   361	391	433	java/net/MalformedURLException
    //   391	414	433	java/net/MalformedURLException
    //   423	430	433	java/net/MalformedURLException
    //   2	52	456	finally
    //   58	65	456	finally
    //   69	75	456	finally
    //   75	84	456	finally
    //   86	103	456	finally
    //   111	117	456	finally
    //   119	134	456	finally
    //   144	175	456	finally
    //   182	217	456	finally
    //   220	233	456	finally
    //   233	240	456	finally
    //   243	251	456	finally
    //   254	261	456	finally
    //   264	287	456	finally
    //   289	299	456	finally
    //   303	311	456	finally
    //   311	316	456	finally
    //   320	355	456	finally
    //   361	391	456	finally
    //   391	414	456	finally
    //   423	430	456	finally
    //   435	453	456	finally
    //   462	478	456	finally
    //   483	501	456	finally
    //   504	515	456	finally
    //   518	535	456	finally
    //   542	548	456	finally
    //   551	557	456	finally
    //   557	584	456	finally
    //   587	596	456	finally
    //   601	608	456	finally
    //   320	355	461	java/net/SocketTimeoutException
    //   361	391	461	java/net/SocketTimeoutException
    //   391	414	461	java/net/SocketTimeoutException
    //   423	430	461	java/net/SocketTimeoutException
    //   320	355	481	java/io/IOException
    //   361	391	481	java/io/IOException
    //   391	414	481	java/io/IOException
    //   423	430	481	java/io/IOException
    //   289	299	611	java/io/IOException
  }
  
  protected void onPreExecute()
  {
    this.aGd.set(this.aDP.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */