package com.jirbo.adcolony;

import java.io.File;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

class ADCDownload
  extends ADCEvent
  implements Runnable
{
  ADCController controller;
  String data;
  File file;
  Object info;
  Listener listener;
  String post_content_type;
  String post_data;
  int size;
  SSLContext ssl_context;
  boolean success;
  boolean third_party_tracking;
  String url;
  boolean use_ssl;
  
  ADCDownload(ADCController paramADCController, String paramString, Listener paramListener)
  {
    this(paramADCController, paramString, paramListener, null);
  }
  
  ADCDownload(ADCController paramADCController, String paramString1, Listener paramListener, String paramString2)
  {
    super(paramADCController, false);
    this.url = paramString1;
    this.listener = paramListener;
    if (paramString2 != null) {
      this.file = new File(paramString2);
    }
  }
  
  void dispatch()
  {
    this.listener.on_download_finished(this);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iload_3
    //   3: iconst_3
    //   4: if_icmpgt +882 -> 886
    //   7: iload_3
    //   8: istore 4
    //   10: aload_0
    //   11: getfield 72	com/jirbo/adcolony/ADCDownload:post_content_type	Ljava/lang/String;
    //   14: ifnull +956 -> 970
    //   17: iload_3
    //   18: istore 4
    //   20: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   23: ldc 80
    //   25: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   28: pop
    //   29: iconst_3
    //   30: istore 6
    //   32: iload 6
    //   34: istore 4
    //   36: aload_0
    //   37: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   40: astore 12
    //   42: iload 6
    //   44: istore 4
    //   46: aload_0
    //   47: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   50: astore 10
    //   52: ldc 86
    //   54: astore 11
    //   56: iload 6
    //   58: istore 4
    //   60: aload_0
    //   61: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   64: invokevirtual 92	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   67: ldc 94
    //   69: invokevirtual 98	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifeq +20 -> 92
    //   75: iload 6
    //   77: istore 4
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   84: bipush 7
    //   86: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   89: putfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   92: iload 6
    //   94: istore 4
    //   96: aload_0
    //   97: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   100: bipush 47
    //   102: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   105: istore_2
    //   106: iload_2
    //   107: iconst_m1
    //   108: if_icmpeq +32 -> 140
    //   111: iload 6
    //   113: istore 4
    //   115: aload_0
    //   116: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   119: iload_2
    //   120: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   123: astore 11
    //   125: iload 6
    //   127: istore 4
    //   129: aload_0
    //   130: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   133: iconst_0
    //   134: iload_2
    //   135: invokevirtual 109	java/lang/String:substring	(II)Ljava/lang/String;
    //   138: astore 10
    //   140: iload 6
    //   142: istore 4
    //   144: new 111	java/net/Socket
    //   147: dup
    //   148: aload 10
    //   150: bipush 80
    //   152: invokespecial 114	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   155: astore 13
    //   157: iload 6
    //   159: istore 4
    //   161: aload 13
    //   163: sipush 30000
    //   166: invokevirtual 118	java/net/Socket:setSoTimeout	(I)V
    //   169: iload 6
    //   171: istore 4
    //   173: new 120	java/io/PrintStream
    //   176: dup
    //   177: aload 13
    //   179: invokevirtual 124	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   182: invokespecial 127	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   185: astore 15
    //   187: iload 6
    //   189: istore 4
    //   191: aload 13
    //   193: invokevirtual 131	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   196: astore 14
    //   198: iload 6
    //   200: istore 4
    //   202: new 133	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   209: astore 16
    //   211: iload 6
    //   213: istore 4
    //   215: aload 16
    //   217: ldc -119
    //   219: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: iload 6
    //   225: istore 4
    //   227: aload 16
    //   229: aload 11
    //   231: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: iload 6
    //   237: istore 4
    //   239: aload 16
    //   241: ldc -113
    //   243: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: iload 6
    //   249: istore 4
    //   251: aload 16
    //   253: ldc -111
    //   255: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: iload 6
    //   261: istore 4
    //   263: aload 16
    //   265: aload 10
    //   267: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: iload 6
    //   273: istore 4
    //   275: aload 16
    //   277: ldc -109
    //   279: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: iload 6
    //   285: istore 4
    //   287: aload 16
    //   289: ldc -107
    //   291: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: iload 6
    //   297: istore 4
    //   299: aload 16
    //   301: aload_0
    //   302: getfield 72	com/jirbo/adcolony/ADCDownload:post_content_type	Ljava/lang/String;
    //   305: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: iload 6
    //   311: istore 4
    //   313: aload 16
    //   315: ldc -109
    //   317: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: iload 6
    //   323: istore 4
    //   325: aload 16
    //   327: ldc -105
    //   329: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: iload 6
    //   335: istore 4
    //   337: aload 16
    //   339: aload_0
    //   340: getfield 153	com/jirbo/adcolony/ADCDownload:post_data	Ljava/lang/String;
    //   343: invokevirtual 157	java/lang/String:length	()I
    //   346: iconst_4
    //   347: iadd
    //   348: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: iload 6
    //   354: istore 4
    //   356: aload 16
    //   358: ldc -94
    //   360: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: iload 6
    //   366: istore 4
    //   368: aload 16
    //   370: aload_0
    //   371: getfield 153	com/jirbo/adcolony/ADCDownload:post_data	Ljava/lang/String;
    //   374: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: iload 6
    //   380: istore 4
    //   382: aload 16
    //   384: ldc -94
    //   386: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: iload 6
    //   392: istore 4
    //   394: aload 16
    //   396: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: astore 10
    //   401: iload 6
    //   403: istore 4
    //   405: aload 15
    //   407: aload 10
    //   409: invokevirtual 168	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   412: iload 6
    //   414: istore 4
    //   416: aload 15
    //   418: invokevirtual 171	java/io/PrintStream:flush	()V
    //   421: iload 6
    //   423: istore 4
    //   425: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   428: ldc -83
    //   430: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   433: aload 10
    //   435: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   438: pop
    //   439: iload 6
    //   441: istore 4
    //   443: new 133	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   450: astore 10
    //   452: iload 6
    //   454: istore 4
    //   456: aload 14
    //   458: invokevirtual 178	java/io/InputStream:read	()I
    //   461: istore_2
    //   462: iload_2
    //   463: iconst_m1
    //   464: if_icmpeq +49 -> 513
    //   467: iload 6
    //   469: istore 4
    //   471: aload 10
    //   473: iload_2
    //   474: i2c
    //   475: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: iload 6
    //   481: istore 4
    //   483: aload 10
    //   485: invokevirtual 182	java/lang/StringBuilder:length	()I
    //   488: iconst_4
    //   489: if_icmplt +119 -> 608
    //   492: iload 6
    //   494: istore 4
    //   496: aload 10
    //   498: ldc -94
    //   500: aload 10
    //   502: invokevirtual 182	java/lang/StringBuilder:length	()I
    //   505: iconst_4
    //   506: isub
    //   507: invokevirtual 185	java/lang/StringBuilder:indexOf	(Ljava/lang/String;I)I
    //   510: iflt +98 -> 608
    //   513: iload 6
    //   515: istore 4
    //   517: aload 10
    //   519: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: astore 10
    //   524: iconst_m1
    //   525: istore_2
    //   526: iload 6
    //   528: istore 4
    //   530: aload 10
    //   532: ldc -69
    //   534: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   537: istore_3
    //   538: iload_3
    //   539: iflt +264 -> 803
    //   542: iload 6
    //   544: istore 4
    //   546: iload_3
    //   547: ldc -69
    //   549: invokevirtual 157	java/lang/String:length	()I
    //   552: iadd
    //   553: istore_2
    //   554: iload 6
    //   556: istore 4
    //   558: aload 10
    //   560: iload_2
    //   561: aload 10
    //   563: ldc -109
    //   565: iload_2
    //   566: invokevirtual 191	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   569: invokevirtual 109	java/lang/String:substring	(II)Ljava/lang/String;
    //   572: astore 10
    //   574: aload 10
    //   576: astore 11
    //   578: iload 6
    //   580: istore 4
    //   582: aload 10
    //   584: iconst_0
    //   585: invokevirtual 195	java/lang/String:charAt	(I)C
    //   588: bipush 32
    //   590: if_icmpne +31 -> 621
    //   593: iload 6
    //   595: istore 4
    //   597: aload 10
    //   599: iconst_1
    //   600: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   603: astore 10
    //   605: goto -31 -> 574
    //   608: iload 6
    //   610: istore 4
    //   612: aload 14
    //   614: invokevirtual 178	java/io/InputStream:read	()I
    //   617: istore_2
    //   618: goto -156 -> 462
    //   621: iload 6
    //   623: istore 4
    //   625: aload 11
    //   627: aload 11
    //   629: invokevirtual 157	java/lang/String:length	()I
    //   632: iconst_1
    //   633: isub
    //   634: invokevirtual 195	java/lang/String:charAt	(I)C
    //   637: bipush 32
    //   639: if_icmpne +25 -> 664
    //   642: iload 6
    //   644: istore 4
    //   646: aload 11
    //   648: iconst_0
    //   649: aload 11
    //   651: invokevirtual 157	java/lang/String:length	()I
    //   654: iconst_1
    //   655: isub
    //   656: invokevirtual 109	java/lang/String:substring	(II)Ljava/lang/String;
    //   659: astore 11
    //   661: goto -40 -> 621
    //   664: iload 6
    //   666: istore 4
    //   668: aload 11
    //   670: invokestatic 200	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   673: istore_2
    //   674: iload 6
    //   676: istore 4
    //   678: new 133	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   685: astore 10
    //   687: iload_2
    //   688: ifeq +22 -> 710
    //   691: iload 6
    //   693: istore 4
    //   695: iload_2
    //   696: istore_3
    //   697: aload 14
    //   699: invokevirtual 178	java/io/InputStream:read	()I
    //   702: istore 5
    //   704: iload 5
    //   706: iconst_m1
    //   707: if_icmpne +189 -> 896
    //   710: iload 6
    //   712: istore 4
    //   714: aload 13
    //   716: invokevirtual 203	java/net/Socket:close	()V
    //   719: iload 6
    //   721: istore 4
    //   723: aload_0
    //   724: aload 10
    //   726: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: putfield 205	com/jirbo/adcolony/ADCDownload:data	Ljava/lang/String;
    //   732: iload 6
    //   734: istore 4
    //   736: aload_0
    //   737: aload_0
    //   738: getfield 205	com/jirbo/adcolony/ADCDownload:data	Ljava/lang/String;
    //   741: invokevirtual 157	java/lang/String:length	()I
    //   744: putfield 207	com/jirbo/adcolony/ADCDownload:size	I
    //   747: iload 6
    //   749: istore 4
    //   751: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   754: ldc -47
    //   756: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   759: aload 12
    //   761: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   764: ldc -42
    //   766: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   769: pop
    //   770: iload 6
    //   772: istore 4
    //   774: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   777: aload_0
    //   778: getfield 205	com/jirbo/adcolony/ADCDownload:data	Ljava/lang/String;
    //   781: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   784: pop
    //   785: iload 6
    //   787: istore 4
    //   789: aload_0
    //   790: iconst_1
    //   791: putfield 216	com/jirbo/adcolony/ADCDownload:success	Z
    //   794: iload 6
    //   796: istore 4
    //   798: aload_0
    //   799: invokestatic 222	com/jirbo/adcolony/ADC:queue_event	(Lcom/jirbo/adcolony/ADCEvent;)V
    //   802: return
    //   803: iload 6
    //   805: istore 4
    //   807: new 133	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   814: ldc -32
    //   816: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload_0
    //   820: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   823: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: ldc -30
    //   828: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 229	com/jirbo/adcolony/ADC:log_error	(Ljava/lang/String;)V
    //   837: goto -163 -> 674
    //   840: astore 10
    //   842: new 133	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   849: ldc -25
    //   851: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload_0
    //   855: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   858: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: ldc -23
    //   863: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload 10
    //   868: invokevirtual 234	java/io/IOException:toString	()Ljava/lang/String;
    //   871: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: invokestatic 237	com/jirbo/adcolony/ADC:log_debug	(Ljava/lang/String;)V
    //   880: iload 4
    //   882: iconst_3
    //   883: if_icmpne +941 -> 1824
    //   886: aload_0
    //   887: iconst_0
    //   888: putfield 216	com/jirbo/adcolony/ADCDownload:success	Z
    //   891: aload_0
    //   892: invokestatic 222	com/jirbo/adcolony/ADC:queue_event	(Lcom/jirbo/adcolony/ADCEvent;)V
    //   895: return
    //   896: iload 5
    //   898: i2c
    //   899: istore_1
    //   900: iload 6
    //   902: istore 4
    //   904: iload_2
    //   905: istore_3
    //   906: aload 10
    //   908: iload_1
    //   909: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: iload_2
    //   914: ifle -227 -> 687
    //   917: iload_2
    //   918: iconst_1
    //   919: isub
    //   920: istore 5
    //   922: iload 5
    //   924: istore_2
    //   925: iload 5
    //   927: ifne -240 -> 687
    //   930: iload 6
    //   932: istore 4
    //   934: iload 5
    //   936: istore_3
    //   937: aload 14
    //   939: invokevirtual 240	java/io/InputStream:available	()I
    //   942: istore 7
    //   944: iload 5
    //   946: istore_2
    //   947: iload 7
    //   949: ifle -262 -> 687
    //   952: iconst_m1
    //   953: istore_2
    //   954: goto -267 -> 687
    //   957: astore 11
    //   959: iload_3
    //   960: ifle -250 -> 710
    //   963: iload 6
    //   965: istore 4
    //   967: aload 11
    //   969: athrow
    //   970: aconst_null
    //   971: astore 10
    //   973: iload_3
    //   974: istore 4
    //   976: new 242	java/net/URL
    //   979: dup
    //   980: aload_0
    //   981: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   984: invokespecial 243	java/net/URL:<init>	(Ljava/lang/String;)V
    //   987: invokevirtual 247	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   990: checkcast 249	java/net/HttpURLConnection
    //   993: checkcast 249	java/net/HttpURLConnection
    //   996: astore 11
    //   998: iload_3
    //   999: istore 4
    //   1001: aload 11
    //   1003: sipush 30000
    //   1006: invokevirtual 252	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1009: iload_3
    //   1010: istore 4
    //   1012: aload_0
    //   1013: getfield 254	com/jirbo/adcolony/ADCDownload:third_party_tracking	Z
    //   1016: ifeq +12 -> 1028
    //   1019: iload_3
    //   1020: istore 4
    //   1022: aload 11
    //   1024: iconst_0
    //   1025: invokevirtual 258	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1028: iload_3
    //   1029: istore 4
    //   1031: aload_0
    //   1032: getfield 55	com/jirbo/adcolony/ADCDownload:file	Ljava/io/File;
    //   1035: ifnull +247 -> 1282
    //   1038: iload_3
    //   1039: istore 4
    //   1041: aload_0
    //   1042: getfield 260	com/jirbo/adcolony/ADCDownload:controller	Lcom/jirbo/adcolony/ADCController;
    //   1045: ifnull +29 -> 1074
    //   1048: iload_3
    //   1049: istore 4
    //   1051: aload_0
    //   1052: getfield 260	com/jirbo/adcolony/ADCDownload:controller	Lcom/jirbo/adcolony/ADCController;
    //   1055: getfield 266	com/jirbo/adcolony/ADCController:storage	Lcom/jirbo/adcolony/ADCStorage;
    //   1058: ifnull +16 -> 1074
    //   1061: iload_3
    //   1062: istore 4
    //   1064: aload_0
    //   1065: getfield 260	com/jirbo/adcolony/ADCDownload:controller	Lcom/jirbo/adcolony/ADCController;
    //   1068: getfield 266	com/jirbo/adcolony/ADCController:storage	Lcom/jirbo/adcolony/ADCStorage;
    //   1071: invokevirtual 271	com/jirbo/adcolony/ADCStorage:validate_storage_paths	()V
    //   1074: iload_3
    //   1075: istore 4
    //   1077: aload_0
    //   1078: getfield 55	com/jirbo/adcolony/ADCDownload:file	Ljava/io/File;
    //   1081: invokevirtual 274	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1084: astore 10
    //   1086: iload_3
    //   1087: istore 4
    //   1089: new 276	java/io/FileOutputStream
    //   1092: dup
    //   1093: aload 10
    //   1095: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1098: astore 12
    //   1100: iload_3
    //   1101: istore 4
    //   1103: aload 11
    //   1105: invokevirtual 278	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1108: astore 13
    //   1110: iload_3
    //   1111: istore 4
    //   1113: aload 11
    //   1115: invokevirtual 281	java/net/HttpURLConnection:getContentLength	()I
    //   1118: istore 5
    //   1120: iload_3
    //   1121: istore 4
    //   1123: aload_0
    //   1124: iconst_0
    //   1125: putfield 207	com/jirbo/adcolony/ADCDownload:size	I
    //   1128: iload_3
    //   1129: istore 4
    //   1131: sipush 1024
    //   1134: newarray <illegal type>
    //   1136: astore 11
    //   1138: iload_3
    //   1139: istore 4
    //   1141: aload 13
    //   1143: aload 11
    //   1145: iconst_0
    //   1146: sipush 1024
    //   1149: invokevirtual 284	java/io/InputStream:read	([BII)I
    //   1152: istore_2
    //   1153: iload 5
    //   1155: istore 4
    //   1157: goto +727 -> 1884
    //   1160: iload_3
    //   1161: istore 4
    //   1163: aload_0
    //   1164: aload_0
    //   1165: getfield 207	com/jirbo/adcolony/ADCDownload:size	I
    //   1168: iload 5
    //   1170: iadd
    //   1171: putfield 207	com/jirbo/adcolony/ADCDownload:size	I
    //   1174: iload_3
    //   1175: istore 4
    //   1177: aload 12
    //   1179: aload 11
    //   1181: iconst_0
    //   1182: iload 5
    //   1184: invokevirtual 290	java/io/OutputStream:write	([BII)V
    //   1187: iload_3
    //   1188: istore 4
    //   1190: aload 13
    //   1192: aload 11
    //   1194: iconst_0
    //   1195: sipush 1024
    //   1198: invokevirtual 284	java/io/InputStream:read	([BII)I
    //   1201: istore_2
    //   1202: iload 6
    //   1204: istore 4
    //   1206: iload 6
    //   1208: ifne +676 -> 1884
    //   1211: iload_3
    //   1212: istore 4
    //   1214: aload 13
    //   1216: invokevirtual 291	java/io/InputStream:close	()V
    //   1219: iload_3
    //   1220: istore 4
    //   1222: aload 12
    //   1224: invokevirtual 292	java/io/OutputStream:flush	()V
    //   1227: iload_3
    //   1228: istore 4
    //   1230: aload 12
    //   1232: invokevirtual 293	java/io/OutputStream:close	()V
    //   1235: iload_3
    //   1236: istore 4
    //   1238: getstatic 296	com/jirbo/adcolony/ADCLog:debug	Lcom/jirbo/adcolony/ADCLog;
    //   1241: ldc_w 298
    //   1244: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   1247: aload_0
    //   1248: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   1251: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   1254: ldc_w 300
    //   1257: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   1260: aload 10
    //   1262: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1265: pop
    //   1266: iload_3
    //   1267: istore 4
    //   1269: aload_0
    //   1270: iconst_1
    //   1271: putfield 216	com/jirbo/adcolony/ADCDownload:success	Z
    //   1274: iload_3
    //   1275: istore 4
    //   1277: aload_0
    //   1278: invokestatic 222	com/jirbo/adcolony/ADC:queue_event	(Lcom/jirbo/adcolony/ADCEvent;)V
    //   1281: return
    //   1282: iload_3
    //   1283: istore 4
    //   1285: aload_0
    //   1286: getfield 254	com/jirbo/adcolony/ADCDownload:third_party_tracking	Z
    //   1289: ifeq +92 -> 1381
    //   1292: iload_3
    //   1293: istore 4
    //   1295: aload 11
    //   1297: invokevirtual 303	java/net/HttpURLConnection:getResponseCode	()I
    //   1300: istore_2
    //   1301: iload_2
    //   1302: ifle +79 -> 1381
    //   1305: iload_3
    //   1306: istore 4
    //   1308: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   1311: ldc_w 305
    //   1314: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   1317: iload_2
    //   1318: invokevirtual 308	com/jirbo/adcolony/ADCLog:print	(I)Lcom/jirbo/adcolony/ADCLog;
    //   1321: ldc_w 310
    //   1324: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1327: pop
    //   1328: iload_3
    //   1329: istore 4
    //   1331: getstatic 296	com/jirbo/adcolony/ADCLog:debug	Lcom/jirbo/adcolony/ADCLog;
    //   1334: ldc_w 298
    //   1337: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   1340: aload_0
    //   1341: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   1344: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1347: pop
    //   1348: iload_3
    //   1349: istore 4
    //   1351: aload_0
    //   1352: ldc 86
    //   1354: putfield 205	com/jirbo/adcolony/ADCDownload:data	Ljava/lang/String;
    //   1357: iload_3
    //   1358: istore 4
    //   1360: aload_0
    //   1361: iconst_0
    //   1362: putfield 207	com/jirbo/adcolony/ADCDownload:size	I
    //   1365: iload_3
    //   1366: istore 4
    //   1368: aload_0
    //   1369: iconst_1
    //   1370: putfield 216	com/jirbo/adcolony/ADCDownload:success	Z
    //   1373: iload_3
    //   1374: istore 4
    //   1376: aload_0
    //   1377: invokestatic 222	com/jirbo/adcolony/ADC:queue_event	(Lcom/jirbo/adcolony/ADCEvent;)V
    //   1380: return
    //   1381: iload_3
    //   1382: istore 4
    //   1384: aload_0
    //   1385: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   1388: ldc_w 312
    //   1391: invokevirtual 98	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1394: ifeq +306 -> 1700
    //   1397: iload_3
    //   1398: istore 4
    //   1400: getstatic 317	android/os/Build$VERSION:SDK_INT	I
    //   1403: bipush 10
    //   1405: if_icmplt +295 -> 1700
    //   1408: iload_3
    //   1409: istore 4
    //   1411: new 242	java/net/URL
    //   1414: dup
    //   1415: aload_0
    //   1416: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   1419: invokespecial 243	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1422: invokevirtual 247	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1425: checkcast 319	javax/net/ssl/HttpsURLConnection
    //   1428: checkcast 319	javax/net/ssl/HttpsURLConnection
    //   1431: astore 10
    //   1433: iload_3
    //   1434: istore 4
    //   1436: aload_0
    //   1437: iconst_1
    //   1438: putfield 321	com/jirbo/adcolony/ADCDownload:use_ssl	Z
    //   1441: iload_3
    //   1442: istore 4
    //   1444: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   1447: ldc_w 323
    //   1450: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1453: pop
    //   1454: iload_3
    //   1455: istore 4
    //   1457: aload 10
    //   1459: new 8	com/jirbo/adcolony/ADCDownload$1
    //   1462: dup
    //   1463: aload_0
    //   1464: invokespecial 325	com/jirbo/adcolony/ADCDownload$1:<init>	(Lcom/jirbo/adcolony/ADCDownload;)V
    //   1467: invokevirtual 329	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   1470: iload_3
    //   1471: istore 4
    //   1473: ldc_w 331
    //   1476: invokestatic 337	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   1479: astore 12
    //   1481: iload_3
    //   1482: istore 4
    //   1484: new 10	com/jirbo/adcolony/ADCDownload$DefaultTrustManager
    //   1487: dup
    //   1488: aconst_null
    //   1489: invokespecial 340	com/jirbo/adcolony/ADCDownload$DefaultTrustManager:<init>	(Lcom/jirbo/adcolony/ADCDownload$1;)V
    //   1492: astore 13
    //   1494: iload_3
    //   1495: istore 4
    //   1497: new 342	java/security/SecureRandom
    //   1500: dup
    //   1501: invokespecial 343	java/security/SecureRandom:<init>	()V
    //   1504: astore 14
    //   1506: iload_3
    //   1507: istore 4
    //   1509: aload 12
    //   1511: aconst_null
    //   1512: iconst_1
    //   1513: anewarray 345	javax/net/ssl/TrustManager
    //   1516: dup
    //   1517: iconst_0
    //   1518: aload 13
    //   1520: aastore
    //   1521: aload 14
    //   1523: invokevirtual 349	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   1526: iload_3
    //   1527: istore 4
    //   1529: aload 12
    //   1531: invokestatic 353	javax/net/ssl/SSLContext:setDefault	(Ljavax/net/ssl/SSLContext;)V
    //   1534: iload_3
    //   1535: istore 4
    //   1537: aload 12
    //   1539: invokevirtual 357	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   1542: invokestatic 361	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   1545: iload_3
    //   1546: istore 4
    //   1548: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   1551: ldc_w 363
    //   1554: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1557: pop
    //   1558: iload_3
    //   1559: istore 4
    //   1561: ldc2_w 364
    //   1564: invokestatic 371	java/lang/Thread:sleep	(J)V
    //   1567: iload_3
    //   1568: istore 4
    //   1570: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   1573: ldc_w 373
    //   1576: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1579: pop
    //   1580: iload_3
    //   1581: istore 4
    //   1583: aload_0
    //   1584: getfield 321	com/jirbo/adcolony/ADCDownload:use_ssl	Z
    //   1587: ifeq +124 -> 1711
    //   1590: iload_3
    //   1591: istore 4
    //   1593: aload 10
    //   1595: invokevirtual 374	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1598: astore 10
    //   1600: iload_3
    //   1601: istore 4
    //   1603: new 133	java/lang/StringBuilder
    //   1606: dup
    //   1607: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1610: astore 11
    //   1612: iload_3
    //   1613: istore 4
    //   1615: sipush 1024
    //   1618: newarray <illegal type>
    //   1620: astore 12
    //   1622: iload_3
    //   1623: istore 4
    //   1625: aload 10
    //   1627: aload 12
    //   1629: iconst_0
    //   1630: sipush 1024
    //   1633: invokevirtual 284	java/io/InputStream:read	([BII)I
    //   1636: istore_2
    //   1637: goto +287 -> 1924
    //   1640: iload 4
    //   1642: iconst_1
    //   1643: iadd
    //   1644: istore 5
    //   1646: iload 5
    //   1648: iload_2
    //   1649: if_icmpge +75 -> 1724
    //   1652: iload_3
    //   1653: istore 4
    //   1655: aload 11
    //   1657: aload 12
    //   1659: iload 5
    //   1661: baload
    //   1662: i2c
    //   1663: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1666: pop
    //   1667: iload 5
    //   1669: istore 4
    //   1671: goto -31 -> 1640
    //   1674: astore 12
    //   1676: iload_3
    //   1677: istore 4
    //   1679: getstatic 78	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   1682: ldc_w 376
    //   1685: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1688: pop
    //   1689: iload_3
    //   1690: istore 4
    //   1692: aload 12
    //   1694: invokevirtual 379	java/lang/Exception:printStackTrace	()V
    //   1697: goto -152 -> 1545
    //   1700: iload_3
    //   1701: istore 4
    //   1703: aload_0
    //   1704: iconst_0
    //   1705: putfield 321	com/jirbo/adcolony/ADCDownload:use_ssl	Z
    //   1708: goto -163 -> 1545
    //   1711: iload_3
    //   1712: istore 4
    //   1714: aload 11
    //   1716: invokevirtual 278	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1719: astore 10
    //   1721: goto -121 -> 1600
    //   1724: iload_3
    //   1725: istore 4
    //   1727: aload 10
    //   1729: aload 12
    //   1731: iconst_0
    //   1732: sipush 1024
    //   1735: invokevirtual 284	java/io/InputStream:read	([BII)I
    //   1738: istore_2
    //   1739: goto +185 -> 1924
    //   1742: iload_3
    //   1743: istore 4
    //   1745: aload 10
    //   1747: invokevirtual 291	java/io/InputStream:close	()V
    //   1750: iload_3
    //   1751: istore 4
    //   1753: aload_0
    //   1754: aload 11
    //   1756: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1759: putfield 205	com/jirbo/adcolony/ADCDownload:data	Ljava/lang/String;
    //   1762: iload_3
    //   1763: istore 4
    //   1765: aload_0
    //   1766: aload_0
    //   1767: getfield 205	com/jirbo/adcolony/ADCDownload:data	Ljava/lang/String;
    //   1770: invokevirtual 157	java/lang/String:length	()I
    //   1773: putfield 207	com/jirbo/adcolony/ADCDownload:size	I
    //   1776: iload_3
    //   1777: istore 4
    //   1779: aload_0
    //   1780: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   1783: ldc_w 381
    //   1786: invokevirtual 385	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1789: ifeq +12 -> 1801
    //   1792: iload_3
    //   1793: istore 4
    //   1795: invokestatic 391	java/lang/System:currentTimeMillis	()J
    //   1798: putstatic 395	com/jirbo/adcolony/ADC:last_config_ms	J
    //   1801: iload_3
    //   1802: istore 4
    //   1804: getstatic 296	com/jirbo/adcolony/ADCLog:debug	Lcom/jirbo/adcolony/ADCLog;
    //   1807: ldc_w 298
    //   1810: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   1813: aload_0
    //   1814: getfield 46	com/jirbo/adcolony/ADCDownload:url	Ljava/lang/String;
    //   1817: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1820: pop
    //   1821: goto -555 -> 1266
    //   1824: iload 4
    //   1826: iconst_1
    //   1827: iadd
    //   1828: bipush 10
    //   1830: imul
    //   1831: sipush 1000
    //   1834: imul
    //   1835: i2l
    //   1836: lstore 8
    //   1838: lload 8
    //   1840: invokestatic 371	java/lang/Thread:sleep	(J)V
    //   1843: getstatic 296	com/jirbo/adcolony/ADCLog:debug	Lcom/jirbo/adcolony/ADCLog;
    //   1846: ldc_w 397
    //   1849: invokevirtual 212	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   1852: iload 4
    //   1854: iconst_1
    //   1855: iadd
    //   1856: invokevirtual 308	com/jirbo/adcolony/ADCLog:print	(I)Lcom/jirbo/adcolony/ADCLog;
    //   1859: ldc_w 399
    //   1862: invokevirtual 84	com/jirbo/adcolony/ADCLog:println	(Ljava/lang/Object;)Lcom/jirbo/adcolony/ADCLog;
    //   1865: pop
    //   1866: iload 4
    //   1868: iconst_1
    //   1869: iadd
    //   1870: istore_3
    //   1871: goto -1869 -> 2
    //   1874: astore 12
    //   1876: goto -309 -> 1567
    //   1879: astore 10
    //   1881: goto -38 -> 1843
    //   1884: iload_2
    //   1885: iconst_m1
    //   1886: if_icmpeq -675 -> 1211
    //   1889: iload 4
    //   1891: istore 6
    //   1893: iload_2
    //   1894: istore 5
    //   1896: iload 4
    //   1898: ifle -738 -> 1160
    //   1901: iload_2
    //   1902: istore 5
    //   1904: iload_2
    //   1905: iload 4
    //   1907: if_icmple +7 -> 1914
    //   1910: iload 4
    //   1912: istore 5
    //   1914: iload 4
    //   1916: iload 5
    //   1918: isub
    //   1919: istore 6
    //   1921: goto -761 -> 1160
    //   1924: iload_2
    //   1925: iconst_m1
    //   1926: if_icmpeq -184 -> 1742
    //   1929: iconst_m1
    //   1930: istore 4
    //   1932: goto -292 -> 1640
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1935	0	this	ADCDownload
    //   899	10	1	c	char
    //   105	1822	2	i	int
    //   1	1870	3	j	int
    //   8	1923	4	k	int
    //   702	1217	5	m	int
    //   30	1890	6	n	int
    //   942	6	7	i1	int
    //   1836	3	8	l	long
    //   50	675	10	localObject1	Object
    //   840	67	10	localIOException	java.io.IOException
    //   971	775	10	localObject2	Object
    //   1879	1	10	localInterruptedException	InterruptedException
    //   54	615	11	localObject3	Object
    //   957	11	11	localSocketTimeoutException	java.net.SocketTimeoutException
    //   996	759	11	localObject4	Object
    //   40	1618	12	localObject5	Object
    //   1674	56	12	localException1	Exception
    //   1874	1	12	localException2	Exception
    //   155	1364	13	localObject6	Object
    //   196	1326	14	localObject7	Object
    //   185	232	15	localPrintStream	java.io.PrintStream
    //   209	186	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	17	840	java/io/IOException
    //   20	29	840	java/io/IOException
    //   36	42	840	java/io/IOException
    //   46	52	840	java/io/IOException
    //   60	75	840	java/io/IOException
    //   79	92	840	java/io/IOException
    //   96	106	840	java/io/IOException
    //   115	125	840	java/io/IOException
    //   129	140	840	java/io/IOException
    //   144	157	840	java/io/IOException
    //   161	169	840	java/io/IOException
    //   173	187	840	java/io/IOException
    //   191	198	840	java/io/IOException
    //   202	211	840	java/io/IOException
    //   215	223	840	java/io/IOException
    //   227	235	840	java/io/IOException
    //   239	247	840	java/io/IOException
    //   251	259	840	java/io/IOException
    //   263	271	840	java/io/IOException
    //   275	283	840	java/io/IOException
    //   287	295	840	java/io/IOException
    //   299	309	840	java/io/IOException
    //   313	321	840	java/io/IOException
    //   325	333	840	java/io/IOException
    //   337	352	840	java/io/IOException
    //   356	364	840	java/io/IOException
    //   368	378	840	java/io/IOException
    //   382	390	840	java/io/IOException
    //   394	401	840	java/io/IOException
    //   405	412	840	java/io/IOException
    //   416	421	840	java/io/IOException
    //   425	439	840	java/io/IOException
    //   443	452	840	java/io/IOException
    //   456	462	840	java/io/IOException
    //   471	479	840	java/io/IOException
    //   483	492	840	java/io/IOException
    //   496	513	840	java/io/IOException
    //   517	524	840	java/io/IOException
    //   530	538	840	java/io/IOException
    //   546	554	840	java/io/IOException
    //   558	574	840	java/io/IOException
    //   582	593	840	java/io/IOException
    //   597	605	840	java/io/IOException
    //   612	618	840	java/io/IOException
    //   625	642	840	java/io/IOException
    //   646	661	840	java/io/IOException
    //   668	674	840	java/io/IOException
    //   678	687	840	java/io/IOException
    //   697	704	840	java/io/IOException
    //   714	719	840	java/io/IOException
    //   723	732	840	java/io/IOException
    //   736	747	840	java/io/IOException
    //   751	770	840	java/io/IOException
    //   774	785	840	java/io/IOException
    //   789	794	840	java/io/IOException
    //   798	802	840	java/io/IOException
    //   807	837	840	java/io/IOException
    //   906	913	840	java/io/IOException
    //   937	944	840	java/io/IOException
    //   967	970	840	java/io/IOException
    //   976	998	840	java/io/IOException
    //   1001	1009	840	java/io/IOException
    //   1012	1019	840	java/io/IOException
    //   1022	1028	840	java/io/IOException
    //   1031	1038	840	java/io/IOException
    //   1041	1048	840	java/io/IOException
    //   1051	1061	840	java/io/IOException
    //   1064	1074	840	java/io/IOException
    //   1077	1086	840	java/io/IOException
    //   1089	1100	840	java/io/IOException
    //   1103	1110	840	java/io/IOException
    //   1113	1120	840	java/io/IOException
    //   1123	1128	840	java/io/IOException
    //   1131	1138	840	java/io/IOException
    //   1141	1153	840	java/io/IOException
    //   1163	1174	840	java/io/IOException
    //   1177	1187	840	java/io/IOException
    //   1190	1202	840	java/io/IOException
    //   1214	1219	840	java/io/IOException
    //   1222	1227	840	java/io/IOException
    //   1230	1235	840	java/io/IOException
    //   1238	1266	840	java/io/IOException
    //   1269	1274	840	java/io/IOException
    //   1277	1281	840	java/io/IOException
    //   1285	1292	840	java/io/IOException
    //   1295	1301	840	java/io/IOException
    //   1308	1328	840	java/io/IOException
    //   1331	1348	840	java/io/IOException
    //   1351	1357	840	java/io/IOException
    //   1360	1365	840	java/io/IOException
    //   1368	1373	840	java/io/IOException
    //   1376	1380	840	java/io/IOException
    //   1384	1397	840	java/io/IOException
    //   1400	1408	840	java/io/IOException
    //   1411	1433	840	java/io/IOException
    //   1436	1441	840	java/io/IOException
    //   1444	1454	840	java/io/IOException
    //   1457	1470	840	java/io/IOException
    //   1473	1481	840	java/io/IOException
    //   1484	1494	840	java/io/IOException
    //   1497	1506	840	java/io/IOException
    //   1509	1526	840	java/io/IOException
    //   1529	1534	840	java/io/IOException
    //   1537	1545	840	java/io/IOException
    //   1548	1558	840	java/io/IOException
    //   1561	1567	840	java/io/IOException
    //   1570	1580	840	java/io/IOException
    //   1583	1590	840	java/io/IOException
    //   1593	1600	840	java/io/IOException
    //   1603	1612	840	java/io/IOException
    //   1615	1622	840	java/io/IOException
    //   1625	1637	840	java/io/IOException
    //   1655	1667	840	java/io/IOException
    //   1679	1689	840	java/io/IOException
    //   1692	1697	840	java/io/IOException
    //   1703	1708	840	java/io/IOException
    //   1714	1721	840	java/io/IOException
    //   1727	1739	840	java/io/IOException
    //   1745	1750	840	java/io/IOException
    //   1753	1762	840	java/io/IOException
    //   1765	1776	840	java/io/IOException
    //   1779	1792	840	java/io/IOException
    //   1795	1801	840	java/io/IOException
    //   1804	1821	840	java/io/IOException
    //   697	704	957	java/net/SocketTimeoutException
    //   906	913	957	java/net/SocketTimeoutException
    //   937	944	957	java/net/SocketTimeoutException
    //   1473	1481	1674	java/lang/Exception
    //   1484	1494	1674	java/lang/Exception
    //   1497	1506	1674	java/lang/Exception
    //   1509	1526	1674	java/lang/Exception
    //   1529	1534	1674	java/lang/Exception
    //   1537	1545	1674	java/lang/Exception
    //   1561	1567	1874	java/lang/Exception
    //   1838	1843	1879	java/lang/InterruptedException
  }
  
  public void start()
  {
    ADCThreadPool.run(this);
  }
  
  ADCDownload with_info(Object paramObject)
  {
    this.info = paramObject;
    return this;
  }
  
  ADCDownload with_post_data(String paramString1, String paramString2)
  {
    this.post_content_type = paramString1;
    this.post_data = paramString2;
    return this;
  }
  
  private static class DefaultTrustManager
    implements X509TrustManager
  {
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
  
  public static abstract interface Listener
  {
    public abstract void on_download_finished(ADCDownload paramADCDownload);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */