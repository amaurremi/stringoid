package com.vungle.publisher.net.http;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.vungle.publisher.ad.AdPreparer;
import com.vungle.publisher.at.b;
import com.vungle.publisher.cq;
import com.vungle.publisher.di;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.s;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class DownloadHttpResponseHandler
  extends MaxRetryAgeHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  public String a;
  public String b;
  public at.b c;
  @Inject
  AdPreparer d;
  @Inject
  di e;
  
  protected final DownloadHttpResponseHandler a(Parcel paramParcel)
  {
    ClassLoader localClassLoader = DownloadHttpResponseHandler.class.getClassLoader();
    super.b(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((at.b)paramParcel.readParcelable(localClassLoader));
    return this;
  }
  
  protected final void a()
  {
    this.e.b(new s());
  }
  
  /* Error */
  protected final void a(HttpTransaction paramHttpTransaction, com.vungle.publisher.bv parambv, HttpTransaction.a parama)
    throws java.io.IOException, org.json.JSONException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_2
    //   7: getfield 92	com/vungle/publisher/bv:b	Ljava/net/HttpURLConnection;
    //   10: astore 7
    //   12: aload 7
    //   14: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   17: astore_3
    //   18: new 100	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: getfield 64	com/vungle/publisher/net/http/DownloadHttpResponseHandler:b	Ljava/lang/String;
    //   26: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 107	java/io/File:getParentFile	()Ljava/io/File;
    //   34: astore 8
    //   36: aload 8
    //   38: ifnonnull +165 -> 203
    //   41: ldc 109
    //   43: ldc 111
    //   45: invokestatic 117	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: iconst_0
    //   49: istore 4
    //   51: iload 4
    //   53: ifeq +272 -> 325
    //   56: aload 8
    //   58: invokevirtual 121	java/io/File:canWrite	()Z
    //   61: ifeq +242 -> 303
    //   64: ldc 109
    //   66: new 123	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 125
    //   72: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload 8
    //   77: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 136	com/vungle/publisher/log/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: iload 5
    //   88: istore 4
    //   90: iload 4
    //   92: ifeq +467 -> 559
    //   95: ldc -118
    //   97: new 123	java/lang/StringBuilder
    //   100: dup
    //   101: ldc -116
    //   103: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 64	com/vungle/publisher/net/http/DownloadHttpResponseHandler:b	Ljava/lang/String;
    //   110: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 145	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: sipush 8192
    //   122: newarray <illegal type>
    //   124: astore 8
    //   126: new 147	java/io/FileOutputStream
    //   129: dup
    //   130: aload_2
    //   131: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   134: astore_2
    //   135: iconst_0
    //   136: istore 4
    //   138: aload_3
    //   139: aload 8
    //   141: invokevirtual 156	java/io/InputStream:read	([B)I
    //   144: istore 5
    //   146: iload 5
    //   148: ifle +183 -> 331
    //   151: iload 4
    //   153: iload 5
    //   155: iadd
    //   156: istore 4
    //   158: aload_2
    //   159: aload 8
    //   161: iconst_0
    //   162: iload 5
    //   164: invokevirtual 162	java/io/OutputStream:write	([BII)V
    //   167: goto -29 -> 138
    //   170: astore 7
    //   172: aload_2
    //   173: astore 6
    //   175: aload 7
    //   177: astore_2
    //   178: aload_1
    //   179: getfield 167	com/vungle/publisher/net/http/HttpTransaction:a	Lcom/vungle/publisher/net/http/HttpRequest;
    //   182: astore_1
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 170	java/io/InputStream:close	()V
    //   191: aload 6
    //   193: ifnull +8 -> 201
    //   196: aload 6
    //   198: invokevirtual 171	java/io/OutputStream:close	()V
    //   201: aload_2
    //   202: athrow
    //   203: aload 8
    //   205: invokevirtual 174	java/io/File:mkdirs	()Z
    //   208: ifeq +31 -> 239
    //   211: ldc 109
    //   213: new 123	java/lang/StringBuilder
    //   216: dup
    //   217: ldc -80
    //   219: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: aload 8
    //   224: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 145	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: iconst_1
    //   234: istore 4
    //   236: goto -185 -> 51
    //   239: aload 8
    //   241: invokevirtual 179	java/io/File:isDirectory	()Z
    //   244: ifeq +31 -> 275
    //   247: ldc 109
    //   249: new 123	java/lang/StringBuilder
    //   252: dup
    //   253: ldc -75
    //   255: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload 8
    //   260: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 136	com/vungle/publisher/log/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: iconst_1
    //   270: istore 4
    //   272: goto -221 -> 51
    //   275: ldc 109
    //   277: new 123	java/lang/StringBuilder
    //   280: dup
    //   281: ldc -73
    //   283: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: aload 8
    //   288: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 145	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: iconst_0
    //   298: istore 4
    //   300: goto -249 -> 51
    //   303: ldc 109
    //   305: new 123	java/lang/StringBuilder
    //   308: dup
    //   309: ldc -71
    //   311: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload 8
    //   316: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 145	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: iconst_0
    //   326: istore 4
    //   328: goto -238 -> 90
    //   331: aload_2
    //   332: invokevirtual 188	java/io/OutputStream:flush	()V
    //   335: aload 7
    //   337: invokevirtual 192	java/net/HttpURLConnection:getContentLength	()I
    //   340: istore 5
    //   342: iload 5
    //   344: iflt +10 -> 354
    //   347: iload 5
    //   349: iload 4
    //   351: if_icmpne +157 -> 508
    //   354: ldc -118
    //   356: new 123	java/lang/StringBuilder
    //   359: dup
    //   360: ldc -62
    //   362: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: aload_0
    //   366: getfield 64	com/vungle/publisher/net/http/DownloadHttpResponseHandler:b	Ljava/lang/String;
    //   369: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc -60
    //   374: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: iload 4
    //   379: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 145	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload_0
    //   389: getfield 201	com/vungle/publisher/net/http/DownloadHttpResponseHandler:d	Lcom/vungle/publisher/ad/AdPreparer;
    //   392: astore 6
    //   394: aload_0
    //   395: getfield 62	com/vungle/publisher/net/http/DownloadHttpResponseHandler:a	Ljava/lang/String;
    //   398: astore 7
    //   400: aload_0
    //   401: getfield 72	com/vungle/publisher/net/http/DownloadHttpResponseHandler:c	Lcom/vungle/publisher/at$b;
    //   404: astore 8
    //   406: ldc -53
    //   408: new 123	java/lang/StringBuilder
    //   411: dup
    //   412: ldc -51
    //   414: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   417: aload 8
    //   419: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   422: ldc -49
    //   424: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 7
    //   429: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 145	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload 6
    //   440: invokevirtual 212	com/vungle/publisher/ad/AdPreparer:a	()Landroid/content/Intent;
    //   443: astore 9
    //   445: aload 9
    //   447: ldc -42
    //   449: aload 7
    //   451: invokevirtual 220	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   454: pop
    //   455: aload 9
    //   457: ldc -34
    //   459: aload 8
    //   461: invokevirtual 225	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   464: pop
    //   465: aload 9
    //   467: ldc -29
    //   469: iload 4
    //   471: invokevirtual 230	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   474: pop
    //   475: aload 6
    //   477: getfield 233	com/vungle/publisher/ad/AdPreparer:a	Landroid/content/Context;
    //   480: aload 9
    //   482: invokevirtual 239	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   485: pop
    //   486: aload_1
    //   487: getfield 167	com/vungle/publisher/net/http/HttpTransaction:a	Lcom/vungle/publisher/net/http/HttpRequest;
    //   490: astore_1
    //   491: aload_3
    //   492: ifnull +7 -> 499
    //   495: aload_3
    //   496: invokevirtual 170	java/io/InputStream:close	()V
    //   499: aload_2
    //   500: ifnull +7 -> 507
    //   503: aload_2
    //   504: invokevirtual 171	java/io/OutputStream:close	()V
    //   507: return
    //   508: ldc -118
    //   510: new 123	java/lang/StringBuilder
    //   513: dup
    //   514: ldc -15
    //   516: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload_0
    //   520: getfield 64	com/vungle/publisher/net/http/DownloadHttpResponseHandler:b	Ljava/lang/String;
    //   523: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc -13
    //   528: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: iload 5
    //   533: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc -11
    //   538: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: iload 4
    //   543: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 117	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload_0
    //   553: invokevirtual 247	com/vungle/publisher/net/http/DownloadHttpResponseHandler:a	()V
    //   556: goto -70 -> 486
    //   559: ldc -118
    //   561: new 123	java/lang/StringBuilder
    //   564: dup
    //   565: ldc -7
    //   567: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   570: aload_2
    //   571: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 117	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: aload_0
    //   581: invokevirtual 247	com/vungle/publisher/net/http/DownloadHttpResponseHandler:a	()V
    //   584: aconst_null
    //   585: astore_2
    //   586: goto -100 -> 486
    //   589: astore_3
    //   590: ldc -118
    //   592: new 123	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   599: aload_1
    //   600: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   603: ldc -4
    //   605: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: aload_3
    //   612: invokestatic 255	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   615: goto -116 -> 499
    //   618: astore_2
    //   619: ldc -118
    //   621: new 123	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   628: aload_1
    //   629: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   632: ldc_w 257
    //   635: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: aload_2
    //   642: invokestatic 255	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   645: return
    //   646: astore_3
    //   647: ldc -118
    //   649: new 123	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   656: aload_1
    //   657: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   660: ldc -4
    //   662: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: aload_3
    //   669: invokestatic 255	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   672: goto -481 -> 191
    //   675: astore_3
    //   676: ldc -118
    //   678: new 123	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   685: aload_1
    //   686: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   689: ldc_w 257
    //   692: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: aload_3
    //   699: invokestatic 255	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   702: goto -501 -> 201
    //   705: astore_2
    //   706: aconst_null
    //   707: astore_3
    //   708: goto -530 -> 178
    //   711: astore_2
    //   712: goto -534 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	715	0	this	DownloadHttpResponseHandler
    //   0	715	1	paramHttpTransaction	HttpTransaction
    //   0	715	2	parambv	com.vungle.publisher.bv
    //   0	715	3	parama	HttpTransaction.a
    //   49	493	4	i	int
    //   4	528	5	j	int
    //   1	475	6	localObject1	Object
    //   10	3	7	localHttpURLConnection	java.net.HttpURLConnection
    //   170	166	7	localObject2	Object
    //   398	52	7	str	String
    //   34	426	8	localObject3	Object
    //   443	38	9	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   138	146	170	finally
    //   158	167	170	finally
    //   331	342	170	finally
    //   354	486	170	finally
    //   508	556	170	finally
    //   495	499	589	java/io/IOException
    //   503	507	618	java/io/IOException
    //   187	191	646	java/io/IOException
    //   196	201	675	java/io/IOException
    //   6	18	705	finally
    //   18	36	711	finally
    //   41	48	711	finally
    //   56	86	711	finally
    //   95	135	711	finally
    //   203	233	711	finally
    //   239	269	711	finally
    //   275	297	711	finally
    //   303	325	711	finally
    //   559	584	711	finally
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<DownloadHttpResponseHandler>
  {
    @Inject
    Provider<DownloadHttpResponseHandler> a;
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    public Provider<DownloadHttpResponseHandler> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */