package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TapjoyVideo
{
  private static final String TAG = "TapjoyVideo";
  private static TapjoyVideo tapjoyVideo = null;
  private static TapjoyVideoNotifier tapjoyVideoNotifier;
  private static Bitmap watermarkImage;
  private static final String watermarkURL = "https://s3.amazonaws.com/tapjoy/videos/assets/watermark.png";
  private boolean cache3g = false;
  private boolean cacheAuto = false;
  private boolean cacheWifi = false;
  private Hashtable<String, TapjoyVideoObject> cachedVideos;
  Context context;
  private String imageCacheDir = null;
  private boolean initialized = false;
  private Hashtable<String, TapjoyVideoObject> uncachedVideos;
  private String videoCacheDir = null;
  private int videoCacheLimit = 5;
  private Vector<String> videoQueue;
  private TapjoyVideoObject videoToPlay;
  
  public TapjoyVideo(Context paramContext)
  {
    this.context = paramContext;
    tapjoyVideo = this;
    if (Environment.getExternalStorageDirectory() != null)
    {
      this.videoCacheDir = (Environment.getExternalStorageDirectory().toString() + "/tjcache/data/");
      this.imageCacheDir = (Environment.getExternalStorageDirectory().toString() + "/tjcache/tmp/");
      TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory().toString() + "/tapjoy/"));
      TapjoyUtil.deleteFileOrDirectory(new File(this.imageCacheDir));
    }
    this.videoQueue = new Vector();
    this.uncachedVideos = new Hashtable();
    this.cachedVideos = new Hashtable();
    if ((TapjoyConnectCore.getFlagValue("video_cache_count") != null) && (TapjoyConnectCore.getFlagValue("video_cache_count").length() > 0)) {}
    try
    {
      TapjoyLog.i("TapjoyVideo", "Setting video cache count to: " + TapjoyConnectCore.getFlagValue("video_cache_count"));
      setVideoCacheCount(Integer.parseInt(TapjoyConnectCore.getFlagValue("video_cache_count")));
      init();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TapjoyLog.e("TapjoyVideo", "Error, invalid value for video_cache_count: " + TapjoyConnectCore.getFlagValue("video_cache_count"));
      }
    }
  }
  
  /* Error */
  private void cacheVideoFromURL(String paramString)
  {
    // Byte code:
    //   0: ldc 12
    //   2: new 76	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   9: ldc -54
    //   11: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   27: lstore 6
    //   29: iconst_0
    //   30: istore 4
    //   32: iconst_0
    //   33: istore_3
    //   34: iconst_0
    //   35: istore_2
    //   36: aconst_null
    //   37: astore 15
    //   39: aconst_null
    //   40: astore 16
    //   42: aconst_null
    //   43: astore 12
    //   45: aconst_null
    //   46: astore 13
    //   48: aconst_null
    //   49: astore 14
    //   51: aconst_null
    //   52: astore 11
    //   54: new 210	java/net/URL
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 211	java/net/URL:<init>	(Ljava/lang/String;)V
    //   62: invokevirtual 215	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   65: astore 10
    //   67: aload 10
    //   69: sipush 15000
    //   72: invokevirtual 220	java/net/URLConnection:setConnectTimeout	(I)V
    //   75: aload 10
    //   77: sipush 30000
    //   80: invokevirtual 223	java/net/URLConnection:setReadTimeout	(I)V
    //   83: aload 10
    //   85: invokevirtual 226	java/net/URLConnection:connect	()V
    //   88: new 228	java/io/BufferedInputStream
    //   91: dup
    //   92: aload 10
    //   94: invokevirtual 232	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   97: invokespecial 235	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore 10
    //   102: new 79	java/io/File
    //   105: dup
    //   106: aload_0
    //   107: getfield 54	com/tapjoy/TapjoyVideo:videoCacheDir	Ljava/lang/String;
    //   110: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: astore 15
    //   115: aload_1
    //   116: iconst_0
    //   117: aload_1
    //   118: ldc -19
    //   120: invokevirtual 240	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   123: iconst_1
    //   124: iadd
    //   125: invokevirtual 244	java/lang/String:substring	(II)Ljava/lang/String;
    //   128: astore 16
    //   130: aload_1
    //   131: aload_1
    //   132: ldc -19
    //   134: invokevirtual 240	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   137: iconst_1
    //   138: iadd
    //   139: invokevirtual 247	java/lang/String:substring	(I)Ljava/lang/String;
    //   142: astore_1
    //   143: aload_1
    //   144: iconst_0
    //   145: aload_1
    //   146: bipush 46
    //   148: invokevirtual 251	java/lang/String:indexOf	(I)I
    //   151: invokevirtual 244	java/lang/String:substring	(II)Ljava/lang/String;
    //   154: astore_1
    //   155: ldc 12
    //   157: new 76	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   164: ldc -3
    //   166: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: ldc 12
    //   182: new 76	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 258
    //   192: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 16
    //   197: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: ldc 12
    //   208: new 76	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 260
    //   218: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_1
    //   222: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 15
    //   233: invokevirtual 263	java/io/File:mkdirs	()Z
    //   236: ifeq +32 -> 268
    //   239: ldc 12
    //   241: new 76	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 265
    //   251: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 15
    //   256: invokevirtual 268	java/io/File:getPath	()Ljava/lang/String;
    //   259: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: new 79	java/io/File
    //   271: dup
    //   272: aload_0
    //   273: getfield 54	com/tapjoy/TapjoyVideo:videoCacheDir	Ljava/lang/String;
    //   276: aload_1
    //   277: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: astore_1
    //   281: new 272	java/io/FileOutputStream
    //   284: dup
    //   285: aload_1
    //   286: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   289: astore 11
    //   291: ldc 12
    //   293: new 76	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 276
    //   303: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 83	java/io/File:toString	()Ljava/lang/String;
    //   310: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: sipush 1024
    //   322: newarray <illegal type>
    //   324: astore 12
    //   326: aload 10
    //   328: aload 12
    //   330: invokevirtual 280	java/io/BufferedInputStream:read	([B)I
    //   333: istore 5
    //   335: iload 5
    //   337: iconst_m1
    //   338: if_icmpeq +199 -> 537
    //   341: aload 11
    //   343: aload 12
    //   345: iconst_0
    //   346: iload 5
    //   348: invokevirtual 286	java/io/OutputStream:write	([BII)V
    //   351: goto -25 -> 326
    //   354: astore 13
    //   356: aload 11
    //   358: astore 12
    //   360: aload_1
    //   361: astore 11
    //   363: aload 10
    //   365: astore_1
    //   366: aload 13
    //   368: astore 10
    //   370: ldc 12
    //   372: new 76	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 288
    //   382: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 10
    //   387: invokevirtual 289	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   390: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 155	com/tapjoy/TapjoyLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: iconst_1
    //   400: istore_3
    //   401: iconst_1
    //   402: istore_2
    //   403: iload_3
    //   404: iconst_1
    //   405: if_icmpne +20 -> 425
    //   408: ldc 12
    //   410: ldc_w 291
    //   413: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_1
    //   417: invokevirtual 294	java/io/BufferedInputStream:close	()V
    //   420: aload 12
    //   422: invokevirtual 295	java/io/OutputStream:close	()V
    //   425: iload_3
    //   426: ifne +257 -> 683
    //   429: iload_2
    //   430: ifne +253 -> 683
    //   433: aload_0
    //   434: getfield 108	com/tapjoy/TapjoyVideo:videoQueue	Ljava/util/Vector;
    //   437: iconst_0
    //   438: invokevirtual 299	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   441: checkcast 125	java/lang/String
    //   444: astore_1
    //   445: aload_0
    //   446: getfield 113	com/tapjoy/TapjoyVideo:uncachedVideos	Ljava/util/Hashtable;
    //   449: aload_1
    //   450: invokevirtual 303	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   453: checkcast 305	com/tapjoy/TapjoyVideoObject
    //   456: astore 10
    //   458: aload 10
    //   460: aload 11
    //   462: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   465: putfield 311	com/tapjoy/TapjoyVideoObject:dataLocation	Ljava/lang/String;
    //   468: aload_0
    //   469: getfield 115	com/tapjoy/TapjoyVideo:cachedVideos	Ljava/util/Hashtable;
    //   472: aload_1
    //   473: aload 10
    //   475: invokevirtual 315	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   478: pop
    //   479: aload_0
    //   480: getfield 113	com/tapjoy/TapjoyVideo:uncachedVideos	Ljava/util/Hashtable;
    //   483: aload_1
    //   484: invokevirtual 318	java/util/Hashtable:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   487: pop
    //   488: aload_0
    //   489: getfield 108	com/tapjoy/TapjoyVideo:videoQueue	Ljava/util/Vector;
    //   492: iconst_0
    //   493: invokevirtual 321	java/util/Vector:removeElementAt	(I)V
    //   496: aload_0
    //   497: invokespecial 189	com/tapjoy/TapjoyVideo:setVideoIDs	()V
    //   500: ldc 12
    //   502: new 76	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 323
    //   512: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   518: lload 6
    //   520: lsub
    //   521: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   524: ldc_w 328
    //   527: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: return
    //   537: aload 11
    //   539: invokevirtual 295	java/io/OutputStream:close	()V
    //   542: aload 10
    //   544: invokevirtual 294	java/io/BufferedInputStream:close	()V
    //   547: ldc 12
    //   549: new 76	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 330
    //   559: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_1
    //   563: invokevirtual 332	java/io/File:length	()J
    //   566: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   569: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 137	com/tapjoy/TapjoyLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   575: aload_1
    //   576: invokevirtual 332	java/io/File:length	()J
    //   579: lstore 8
    //   581: iload 4
    //   583: istore_3
    //   584: lload 8
    //   586: lconst_0
    //   587: lcmp
    //   588: ifne +5 -> 593
    //   591: iconst_1
    //   592: istore_3
    //   593: aload_1
    //   594: astore 13
    //   596: aload 10
    //   598: astore_1
    //   599: aload 11
    //   601: astore 12
    //   603: aload 13
    //   605: astore 11
    //   607: goto -204 -> 403
    //   610: astore 10
    //   612: aload 14
    //   614: astore 11
    //   616: aload 15
    //   618: astore_1
    //   619: ldc 12
    //   621: new 76	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 334
    //   631: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 10
    //   636: invokevirtual 335	java/lang/Exception:toString	()Ljava/lang/String;
    //   639: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 155	com/tapjoy/TapjoyLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   648: iconst_1
    //   649: istore_2
    //   650: goto -247 -> 403
    //   653: astore_1
    //   654: ldc 12
    //   656: new 76	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   663: ldc_w 337
    //   666: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload_1
    //   670: invokevirtual 335	java/lang/Exception:toString	()Ljava/lang/String;
    //   673: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 155	com/tapjoy/TapjoyLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: return
    //   683: iconst_2
    //   684: invokestatic 340	com/tapjoy/TapjoyVideo:videoNotifierError	(I)V
    //   687: return
    //   688: astore_1
    //   689: goto -264 -> 425
    //   692: astore 11
    //   694: aload 10
    //   696: astore_1
    //   697: aload 11
    //   699: astore 10
    //   701: aload 14
    //   703: astore 11
    //   705: goto -86 -> 619
    //   708: astore 13
    //   710: aload_1
    //   711: astore 11
    //   713: aload 10
    //   715: astore_1
    //   716: aload 13
    //   718: astore 10
    //   720: goto -101 -> 619
    //   723: astore 12
    //   725: aload_1
    //   726: astore 13
    //   728: aload 10
    //   730: astore_1
    //   731: aload 12
    //   733: astore 10
    //   735: aload 11
    //   737: astore 12
    //   739: aload 13
    //   741: astore 11
    //   743: goto -124 -> 619
    //   746: astore 10
    //   748: aload 16
    //   750: astore_1
    //   751: aload 13
    //   753: astore 12
    //   755: goto -385 -> 370
    //   758: astore 12
    //   760: aload 10
    //   762: astore_1
    //   763: aload 12
    //   765: astore 10
    //   767: aload 13
    //   769: astore 12
    //   771: goto -401 -> 370
    //   774: astore 12
    //   776: aload_1
    //   777: astore 11
    //   779: aload 10
    //   781: astore_1
    //   782: aload 12
    //   784: astore 10
    //   786: aload 13
    //   788: astore 12
    //   790: goto -420 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	this	TapjoyVideo
    //   0	793	1	paramString	String
    //   35	615	2	i	int
    //   33	560	3	j	int
    //   30	552	4	k	int
    //   333	14	5	m	int
    //   27	492	6	l1	long
    //   579	6	8	l2	long
    //   65	532	10	localObject1	Object
    //   610	85	10	localException1	Exception
    //   699	35	10	localException2	Exception
    //   746	15	10	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   765	20	10	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   52	563	11	localObject2	Object
    //   692	6	11	localException3	Exception
    //   703	75	11	localObject3	Object
    //   43	559	12	localObject4	Object
    //   723	9	12	localException4	Exception
    //   737	17	12	localObject5	Object
    //   758	6	12	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   769	1	12	localObject6	Object
    //   774	9	12	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   788	1	12	localObject7	Object
    //   46	1	13	localObject8	Object
    //   354	13	13	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   594	10	13	str1	String
    //   708	9	13	localException5	Exception
    //   726	61	13	str2	String
    //   49	653	14	localObject9	Object
    //   37	580	15	localFile	File
    //   40	709	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   291	326	354	java/net/SocketTimeoutException
    //   326	335	354	java/net/SocketTimeoutException
    //   341	351	354	java/net/SocketTimeoutException
    //   537	581	354	java/net/SocketTimeoutException
    //   54	102	610	java/lang/Exception
    //   433	536	653	java/lang/Exception
    //   416	425	688	java/lang/Exception
    //   102	268	692	java/lang/Exception
    //   268	281	692	java/lang/Exception
    //   281	291	708	java/lang/Exception
    //   291	326	723	java/lang/Exception
    //   326	335	723	java/lang/Exception
    //   341	351	723	java/lang/Exception
    //   537	581	723	java/lang/Exception
    //   54	102	746	java/net/SocketTimeoutException
    //   102	268	758	java/net/SocketTimeoutException
    //   268	281	758	java/net/SocketTimeoutException
    //   281	291	774	java/net/SocketTimeoutException
  }
  
  public static TapjoyVideo getInstance()
  {
    return tapjoyVideo;
  }
  
  public static Bitmap getWatermarkImage()
  {
    return watermarkImage;
  }
  
  private boolean handleGetVideosResponse(String paramString)
  {
    Object localObject1 = DocumentBuilderFactory.newInstance();
    TapjoyLog.i("TapjoyVideo", "========================================");
    for (;;)
    {
      int i;
      TapjoyVideoObject localTapjoyVideoObject;
      int j;
      int k;
      String str1;
      Object localObject2;
      try
      {
        paramString = new ByteArrayInputStream(paramString.getBytes("UTF-8"));
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(paramString);
        paramString.getDocumentElement().normalize();
        paramString = paramString.getElementsByTagName("TapjoyVideos");
        NodeList localNodeList1 = paramString.item(0).getChildNodes();
        localObject1 = paramString.item(0).getAttributes();
        if ((((NamedNodeMap)localObject1).getNamedItem("cache_auto") != null) && (((NamedNodeMap)localObject1).getNamedItem("cache_auto").getNodeValue() != null)) {
          this.cacheAuto = Boolean.valueOf(((NamedNodeMap)localObject1).getNamedItem("cache_auto").getNodeValue()).booleanValue();
        }
        if ((((NamedNodeMap)localObject1).getNamedItem("cache_wifi") != null) && (((NamedNodeMap)localObject1).getNamedItem("cache_wifi").getNodeValue() != null)) {
          this.cacheWifi = Boolean.valueOf(((NamedNodeMap)localObject1).getNamedItem("cache_wifi").getNodeValue()).booleanValue();
        }
        if ((((NamedNodeMap)localObject1).getNamedItem("cache_mobile") != null) && (((NamedNodeMap)localObject1).getNamedItem("cache_mobile").getNodeValue() != null)) {
          this.cache3g = Boolean.valueOf(((NamedNodeMap)localObject1).getNamedItem("cache_mobile").getNodeValue()).booleanValue();
        }
        TapjoyLog.i("TapjoyVideo", "cacheAuto: " + this.cacheAuto);
        TapjoyLog.i("TapjoyVideo", "cacheWifi: " + this.cacheWifi);
        TapjoyLog.i("TapjoyVideo", "cache3g: " + this.cache3g);
        TapjoyLog.i("TapjoyVideo", "nodelistParent length: " + paramString.getLength());
        TapjoyLog.i("TapjoyVideo", "nodelist length: " + localNodeList1.getLength());
        i = 0;
        if (i >= localNodeList1.getLength()) {
          break label1157;
        }
        paramString = localNodeList1.item(i);
        localTapjoyVideoObject = new TapjoyVideoObject();
        if ((paramString == null) || (paramString.getNodeType() != 1)) {
          break label1150;
        }
        paramString = (Element)paramString;
        localObject1 = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("ClickURL"));
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          localTapjoyVideoObject.clickURL = ((String)localObject1);
        }
        localObject1 = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("OfferID"));
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          localTapjoyVideoObject.offerID = ((String)localObject1);
        }
        localObject1 = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("Name"));
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          localTapjoyVideoObject.videoAdName = ((String)localObject1);
        }
        localObject1 = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("Amount"));
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          localTapjoyVideoObject.currencyAmount = ((String)localObject1);
        }
        localObject1 = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("CurrencyName"));
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          localTapjoyVideoObject.currencyName = ((String)localObject1);
        }
        localObject1 = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("VideoURL"));
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          localTapjoyVideoObject.videoURL = ((String)localObject1);
        }
        localObject1 = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("IconURL"));
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          localTapjoyVideoObject.iconURL = ((String)localObject1);
        }
        TapjoyLog.i("TapjoyVideo", "-----");
        TapjoyLog.i("TapjoyVideo", "videoObject.offerID: " + localTapjoyVideoObject.offerID);
        TapjoyLog.i("TapjoyVideo", "videoObject.videoAdName: " + localTapjoyVideoObject.videoAdName);
        TapjoyLog.i("TapjoyVideo", "videoObject.videoURL: " + localTapjoyVideoObject.videoURL);
        NodeList localNodeList2 = paramString.getElementsByTagName("Buttons").item(0).getChildNodes();
        j = 0;
        if (j >= localNodeList2.getLength()) {
          break label1123;
        }
        localNodeList3 = localNodeList2.item(j).getChildNodes();
        if (localNodeList3.getLength() != 0) {
          break label1174;
        }
      }
      catch (Exception paramString)
      {
        NodeList localNodeList3;
        String str2;
        TapjoyLog.e("TapjoyVideo", "Error parsing XML: " + paramString.toString());
        return false;
      }
      if (k < localNodeList3.getLength())
      {
        str1 = paramString;
        localObject2 = localObject1;
        if ((Element)localNodeList3.item(k) != null)
        {
          str2 = ((Element)localNodeList3.item(k)).getTagName();
          if ((str2.equals("Name")) && (localNodeList3.item(k).getFirstChild() != null))
          {
            str1 = localNodeList3.item(k).getFirstChild().getNodeValue();
            localObject2 = localObject1;
          }
          else
          {
            str1 = paramString;
            localObject2 = localObject1;
            if (str2.equals("URL"))
            {
              str1 = paramString;
              localObject2 = localObject1;
              if (localNodeList3.item(k).getFirstChild() != null)
              {
                localObject2 = localNodeList3.item(k).getFirstChild().getNodeValue();
                str1 = paramString;
              }
            }
          }
        }
      }
      else
      {
        TapjoyLog.i("TapjoyVideo", "name: " + paramString + ", url: " + (String)localObject1);
        localTapjoyVideoObject.addButton(paramString, (String)localObject1);
        break label1167;
        label1123:
        this.videoQueue.addElement(localTapjoyVideoObject.offerID);
        this.uncachedVideos.put(localTapjoyVideoObject.offerID, localTapjoyVideoObject);
        label1150:
        i += 1;
        continue;
        label1157:
        TapjoyLog.i("TapjoyVideo", "========================================");
        return true;
        label1167:
        j += 1;
        continue;
        label1174:
        paramString = "";
        localObject1 = "";
        k = 0;
        continue;
      }
      k += 1;
      paramString = str1;
      localObject1 = localObject2;
    }
  }
  
  private void printCachedVideos()
  {
    TapjoyLog.i("TapjoyVideo", "cachedVideos size: " + this.cachedVideos.size());
    Iterator localIterator = this.cachedVideos.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      TapjoyLog.i("TapjoyVideo", "key: " + (String)localEntry.getKey() + ", name: " + ((TapjoyVideoObject)localEntry.getValue()).videoAdName);
    }
  }
  
  private void setVideoIDs()
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (this.cachedVideos != null)
    {
      localObject2 = localObject1;
      if (this.cachedVideos.size() > 0)
      {
        Enumeration localEnumeration = this.cachedVideos.keys();
        while (localEnumeration.hasMoreElements())
        {
          localObject2 = (String)localEnumeration.nextElement();
          localObject2 = (String)localObject1 + (String)localObject2;
          localObject1 = localObject2;
          if (localEnumeration.hasMoreElements()) {
            localObject1 = (String)localObject2 + ",";
          }
        }
        TapjoyLog.i("TapjoyVideo", "cachedVideos size: " + this.cachedVideos.size());
        localObject2 = localObject1;
      }
    }
    TapjoyLog.i("TapjoyVideo", "videoIDs: [" + (String)localObject2 + "]");
    TapjoyConnectCore.setVideoIDs((String)localObject2);
  }
  
  private boolean validateCachedVideos()
  {
    boolean bool2 = false;
    int i = 1;
    File[] arrayOfFile = new File(this.videoCacheDir).listFiles();
    if (this.uncachedVideos == null)
    {
      TapjoyLog.e("TapjoyVideo", "Error: uncachedVideos is null");
      i = 0;
    }
    if (this.cachedVideos == null)
    {
      TapjoyLog.e("TapjoyVideo", "Error: cachedVideos is null");
      i = 0;
    }
    if (this.videoQueue == null)
    {
      TapjoyLog.e("TapjoyVideo", "Error: videoQueue is null");
      i = 0;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (arrayOfFile != null)
      {
        i = 0;
        if (i < arrayOfFile.length)
        {
          String str1 = arrayOfFile[i].getName();
          TapjoyLog.i("TapjoyVideo", "-----");
          TapjoyLog.i("TapjoyVideo", "Examining cached file[" + i + "]: " + arrayOfFile[i].getAbsolutePath() + " --- " + arrayOfFile[i].getName());
          TapjoyVideoObject localTapjoyVideoObject;
          if (this.uncachedVideos.containsKey(str1))
          {
            TapjoyLog.i("TapjoyVideo", "Local file found");
            localTapjoyVideoObject = (TapjoyVideoObject)this.uncachedVideos.get(str1);
            if (localTapjoyVideoObject != null) {}
          }
          for (;;)
          {
            i += 1;
            break;
            String str2 = new TapjoyURLConnection().getContentLength(localTapjoyVideoObject.videoURL);
            TapjoyLog.i("TapjoyVideo", "local file size: " + arrayOfFile[i].length() + " vs. target: " + str2);
            if ((str2 != null) && (Integer.parseInt(str2) == arrayOfFile[i].length()))
            {
              localTapjoyVideoObject.dataLocation = arrayOfFile[i].getAbsolutePath();
              this.cachedVideos.put(str1, localTapjoyVideoObject);
              this.uncachedVideos.remove(str1);
              this.videoQueue.remove(str1);
              TapjoyLog.i("TapjoyVideo", "VIDEO PREVIOUSLY CACHED -- " + str1 + ", location: " + localTapjoyVideoObject.dataLocation);
            }
            else
            {
              TapjoyLog.i("TapjoyVideo", "file size mismatch --- deleting video: " + arrayOfFile[i].getAbsolutePath());
              TapjoyUtil.deleteFileOrDirectory(arrayOfFile[i]);
              continue;
              TapjoyLog.i("TapjoyVideo", "VIDEO EXPIRED? removing video from cache: " + str1 + " --- " + arrayOfFile[i].getAbsolutePath());
              TapjoyUtil.deleteFileOrDirectory(arrayOfFile[i]);
            }
          }
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void videoNotifierComplete()
  {
    if (tapjoyVideoNotifier != null) {
      tapjoyVideoNotifier.videoComplete();
    }
  }
  
  public static void videoNotifierError(int paramInt)
  {
    if (tapjoyVideoNotifier != null) {
      tapjoyVideoNotifier.videoError(paramInt);
    }
  }
  
  public static void videoNotifierStart()
  {
    if (tapjoyVideoNotifier != null) {
      tapjoyVideoNotifier.videoStart();
    }
  }
  
  public void cacheVideos()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        TapjoyLog.i("TapjoyVideo", "--- cacheAllVideos called ---");
        int i = 0;
        while (!TapjoyVideo.this.initialized)
        {
          int j = i;
          try
          {
            Thread.sleep(500L);
            j = (int)(i + 500L);
            i = j;
            if (j > 10000L)
            {
              TapjoyLog.e("TapjoyVideo", "Error during cacheVideos.  Timeout while waiting for initVideos to finish.");
              return;
            }
          }
          catch (Exception localException)
          {
            TapjoyLog.e("TapjoyVideo", "Exception in cacheAllVideos: " + localException.toString());
            i = j;
          }
        }
        TapjoyLog.i("TapjoyVideo", "cacheVideos connection_type: " + TapjoyConnectCore.getConnectionType());
        TapjoyLog.i("TapjoyVideo", "cache3g: " + TapjoyVideo.this.cache3g);
        TapjoyLog.i("TapjoyVideo", "cacheWifi: " + TapjoyVideo.this.cacheWifi);
        if (((TapjoyVideo.this.cache3g) && (TapjoyConnectCore.getConnectionType().equals("mobile"))) || ((TapjoyVideo.this.cacheWifi) && (TapjoyConnectCore.getConnectionType().equals("wifi")))) {
          if (!"mounted".equals(Environment.getExternalStorageState()))
          {
            TapjoyLog.i("TapjoyVideo", "Media storage unavailable.  Aborting caching videos.");
            TapjoyVideo.videoNotifierError(1);
            return;
          }
        }
        while ((TapjoyVideo.this.cachedVideos.size() < TapjoyVideo.this.videoCacheLimit) && (TapjoyVideo.this.videoQueue.size() > 0))
        {
          String str = ((TapjoyVideoObject)TapjoyVideo.this.uncachedVideos.get(TapjoyVideo.this.videoQueue.elementAt(0))).videoURL;
          TapjoyVideo.this.cacheVideoFromURL(str);
          continue;
          TapjoyLog.i("TapjoyVideo", " * Skipping caching videos because of video flags and connection_type...");
        }
        TapjoyVideo.this.printCachedVideos();
      }
    }).start();
  }
  
  public void enableVideoCache(boolean paramBoolean) {}
  
  public TapjoyVideoObject getCurrentVideoData()
  {
    return this.videoToPlay;
  }
  
  public void init()
  {
    TapjoyLog.i("TapjoyVideo", "initVideoAd");
    if ((TapjoyConnectCore.getFlagValue("disable_videos") != null) && (TapjoyConnectCore.getFlagValue("disable_videos").equals("true")))
    {
      TapjoyLog.i("TapjoyVideo", "disable_videos: " + TapjoyConnectCore.getFlagValue("disable_videos") + ". Aborting video initializing... ");
      TapjoyConnectCore.setVideoEnabled(false);
      return;
    }
    setVideoIDs();
    new Thread(new Runnable()
    {
      public void run()
      {
        boolean bool2 = false;
        Object localObject = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + "videos?", TapjoyConnectCore.getURLParams());
        boolean bool1 = bool2;
        if (((TapjoyHttpURLResponse)localObject).response != null)
        {
          bool1 = bool2;
          if (((TapjoyHttpURLResponse)localObject).response.length() > 0) {
            bool1 = TapjoyVideo.this.handleGetVideosResponse(((TapjoyHttpURLResponse)localObject).response);
          }
        }
        if (bool1)
        {
          TapjoyVideo.this.validateCachedVideos();
          if (("https://s3.amazonaws.com/tapjoy/videos/assets/watermark.png" != null) && ("https://s3.amazonaws.com/tapjoy/videos/assets/watermark.png".length() > 0)) {}
          try
          {
            localObject = new URL("https://s3.amazonaws.com/tapjoy/videos/assets/watermark.png");
            URLConnection localURLConnection = ((URL)localObject).openConnection();
            localURLConnection.setConnectTimeout(15000);
            localURLConnection.setReadTimeout(25000);
            localURLConnection.connect();
            TapjoyVideo.access$202(BitmapFactory.decodeStream(((URL)localObject).openConnection().getInputStream()));
            localURLConnection.getInputStream().close();
            TapjoyVideo.this.setVideoIDs();
            TapjoyVideo.access$402(TapjoyVideo.this, true);
            if (TapjoyVideo.this.cacheAuto)
            {
              TapjoyLog.i("TapjoyVideo", "trying to cache because of cache_auto flag...");
              TapjoyVideo.this.cacheVideos();
            }
            TapjoyLog.i("TapjoyVideo", "------------------------------");
            TapjoyLog.i("TapjoyVideo", "------------------------------");
            TapjoyLog.i("TapjoyVideo", "INIT DONE!");
            TapjoyLog.i("TapjoyVideo", "------------------------------");
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              TapjoyLog.e("TapjoyVideo", "e: " + localException.toString());
            }
          }
        }
        TapjoyVideo.videoNotifierError(2);
      }
    }).start();
    TapjoyConnectCore.setVideoEnabled(true);
  }
  
  public void initVideoAd(TapjoyVideoNotifier paramTapjoyVideoNotifier)
  {
    initVideoAd(paramTapjoyVideoNotifier, false);
  }
  
  public void initVideoAd(TapjoyVideoNotifier paramTapjoyVideoNotifier, boolean paramBoolean)
  {
    tapjoyVideoNotifier = paramTapjoyVideoNotifier;
    if (paramTapjoyVideoNotifier == null)
    {
      Log.e("TapjoyVideo", "Error during initVideoAd -- TapjoyVideoNotifier is null");
      return;
    }
    cacheVideos();
  }
  
  public void setVideoCacheCount(int paramInt)
  {
    this.videoCacheLimit = paramInt;
  }
  
  public void setVideoNotifier(TapjoyVideoNotifier paramTapjoyVideoNotifier)
  {
    tapjoyVideoNotifier = paramTapjoyVideoNotifier;
  }
  
  public boolean startVideo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int i = 1;
    TapjoyLog.i("TapjoyVideo", "Starting video activity with video: " + paramString1);
    if ((paramString1 == null) || (paramString4 == null) || (paramString5 == null) || (paramString1.length() == 0) || (paramString4.length() == 0) || (paramString5.length() == 0))
    {
      TapjoyLog.i("TapjoyVideo", "aborting video playback... invalid or missing parameter");
      return false;
    }
    this.videoToPlay = ((TapjoyVideoObject)this.cachedVideos.get(paramString1));
    if (this.videoToPlay == null)
    {
      TapjoyLog.i("TapjoyVideo", "video not cached... checking uncached videos");
      this.videoToPlay = ((TapjoyVideoObject)this.uncachedVideos.get(paramString1));
      if (this.videoToPlay == null)
      {
        if ((paramString6 != null) && (paramString6.length() > 0))
        {
          TapjoyVideoObject localTapjoyVideoObject = new TapjoyVideoObject();
          localTapjoyVideoObject.offerID = paramString1;
          localTapjoyVideoObject.currencyName = paramString2;
          localTapjoyVideoObject.currencyAmount = paramString3;
          localTapjoyVideoObject.clickURL = paramString4;
          localTapjoyVideoObject.webviewURL = paramString5;
          localTapjoyVideoObject.videoURL = paramString6;
          this.uncachedVideos.put(paramString1, localTapjoyVideoObject);
          this.videoToPlay = ((TapjoyVideoObject)this.uncachedVideos.get(paramString1));
        }
      }
      else {
        i = 0;
      }
    }
    else
    {
      this.videoToPlay.currencyName = paramString2;
      this.videoToPlay.currencyAmount = paramString3;
      this.videoToPlay.clickURL = paramString4;
      this.videoToPlay.webviewURL = paramString5;
      this.videoToPlay.videoURL = paramString6;
      TapjoyLog.i("TapjoyVideo", "videoToPlay: " + this.videoToPlay.offerID);
      TapjoyLog.i("TapjoyVideo", "amount: " + this.videoToPlay.currencyAmount);
      TapjoyLog.i("TapjoyVideo", "currency: " + this.videoToPlay.currencyName);
      TapjoyLog.i("TapjoyVideo", "clickURL: " + this.videoToPlay.clickURL);
      TapjoyLog.i("TapjoyVideo", "location: " + this.videoToPlay.dataLocation);
      TapjoyLog.i("TapjoyVideo", "webviewURL: " + this.videoToPlay.webviewURL);
      TapjoyLog.i("TapjoyVideo", "videoURL: " + this.videoToPlay.videoURL);
      if ((i == 0) || (this.videoToPlay.dataLocation == null)) {
        break label538;
      }
      paramString1 = new File(this.videoToPlay.dataLocation);
      if ((paramString1 != null) && (paramString1.exists())) {
        break label538;
      }
      TapjoyLog.e("TapjoyVideo", "video file does not exist.");
      return false;
    }
    TapjoyLog.e("TapjoyVideo", "no video data and no video url - aborting playback...");
    return false;
    label538:
    paramString1 = new Intent(this.context, TapjoyVideoView.class);
    paramString1.setFlags(268435456);
    paramString1.putExtra("VIDEO_DATA", this.videoToPlay);
    this.context.startActivity(paramString1);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */