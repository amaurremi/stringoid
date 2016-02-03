package com.ideashower.readitlater.objects;

import android.os.Build;
import android.os.Build.VERSION;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.w;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.u;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.a.a.a.d;
import org.apache.a.c.k;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class a
{
  private static final String b;
  private static Object c = { "yde", "r a ebi", "rp o", "tco", "a n", "er", "t lli", "I" };
  private static String d = "rcse";
  private static String e;
  public final String a;
  private final List f;
  private List g;
  private com.e.a.a.a h;
  private b i;
  private int j;
  private int k;
  private ErrorReport l;
  private boolean m = true;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private String q;
  private String r;
  
  static
  {
    Object localObject2 = g.b();
    StringBuilder localStringBuilder = u.a().append("Pocket").append(";").append(((com.pocket.g.a)localObject2).g()).append(";").append(((com.pocket.g.a)localObject2).i()).append(";").append("Android").append(";").append(Build.VERSION.RELEASE).append(";").append(Build.MANUFACTURER).append(";").append(Build.MODEL).append(";");
    if (j.f()) {}
    for (Object localObject1 = "mobile";; localObject1 = "tablet")
    {
      localObject1 = localStringBuilder.append((String)localObject1).append(";").append(((com.pocket.g.a)localObject2).a(true)).append(";").append(((com.pocket.g.a)localObject2).a(false));
      b = ((StringBuilder)localObject1).toString();
      u.b((StringBuilder)localObject1);
      localObject2 = new String[2];
      localObject2[0] = "t ro";
      localObject2[1] = "w t";
      e = ((StringBuilder)localObject1).append(((String[])(String[])c)[0]).append("me").append(((String[])(String[])c)[1]).append(d).append(((String[])(String[])c)[2]).append(localObject2[0]).append(((String[])(String[])c)[3]).append("d ").append(((String[])(String[])c)[4]).append("aht ").append(((String[])(String[])c)[5]).append("om eka").append(((String[])(String[])c)[6]).append(localObject2[1]).append(((String[])(String[])c)[7]).reverse().toString();
      u.a((StringBuilder)localObject1);
      return;
    }
  }
  
  public a(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.h = w.c();
    this.f = new ArrayList();
    this.p = paramBoolean;
    a("locale_lang", g.z());
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 400: 
      return 400;
    case 401: 
      return 401;
    case 403: 
      return 403;
    }
    return 503;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = u.a();
    localStringBuilder.append(paramString1).append(paramString2).append(paramString3).append(e).toString();
    paramString1 = new String(d.a(org.apache.a.a.b.a.a(localStringBuilder.toString().getBytes())));
    u.a(localStringBuilder);
    return paramString1;
  }
  
  private static boolean a(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.getFirstHeader("X-Source");
    if (paramHttpResponse == null) {
      return false;
    }
    return k.a(paramHttpResponse.getValue(), "Pocket");
  }
  
  public static String d(String paramString)
  {
    return g.a(paramString);
  }
  
  public void a()
  {
    this.n = true;
  }
  
  public void a(b paramb)
  {
    this.i = paramb;
  }
  
  public void a(String paramString)
  {
    this.f.add(new BasicNameValuePair(paramString, "1"));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, String.valueOf(paramInt));
  }
  
  public void a(String paramString, long paramLong)
  {
    a(paramString, String.valueOf(paramLong));
  }
  
  public void a(String paramString, File paramFile)
  {
    if (this.g == null) {
      this.g = new ArrayList();
    }
    this.g.add(new c(this, paramString, paramFile));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.f.add(new BasicNameValuePair(paramString1, paramString2));
  }
  
  public void a(HttpPost paramHttpPost) {}
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: istore_2
    //   6: invokestatic 265	com/ideashower/readitlater/a/as:d	()Z
    //   9: ifne +29 -> 38
    //   12: iload_1
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 153	com/ideashower/readitlater/objects/a:a	Ljava/lang/String;
    //   18: ldc_w 267
    //   21: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifne +14 -> 38
    //   27: iconst_1
    //   28: invokestatic 275	com/pocket/c/e:d	(Z)Z
    //   31: ifeq +699 -> 730
    //   34: iconst_0
    //   35: istore_1
    //   36: iload_1
    //   37: istore_2
    //   38: iload_2
    //   39: istore_1
    //   40: iload_2
    //   41: ifne +196 -> 237
    //   44: aload_0
    //   45: getfield 153	com/ideashower/readitlater/objects/a:a	Ljava/lang/String;
    //   48: ldc_w 277
    //   51: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifne +16 -> 70
    //   57: aload_0
    //   58: ldc_w 279
    //   61: invokestatic 60	com/ideashower/readitlater/a/g:b	()Lcom/pocket/g/a;
    //   64: invokevirtual 281	com/pocket/g/a:c	()Ljava/lang/String;
    //   67: invokevirtual 173	com/ideashower/readitlater/objects/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 151	com/ideashower/readitlater/objects/a:p	Z
    //   74: ifeq +123 -> 197
    //   77: aload_0
    //   78: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   81: new 220	org/apache/http/message/BasicNameValuePair
    //   84: dup
    //   85: ldc_w 283
    //   88: invokestatic 285	com/ideashower/readitlater/a/as:h	()Ljava/lang/String;
    //   91: invokespecial 224	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: invokeinterface 230 2 0
    //   99: pop
    //   100: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   103: invokestatic 239	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   106: astore 5
    //   108: bipush 16
    //   110: invokestatic 295	org/apache/a/c/g:a	(I)Ljava/lang/String;
    //   113: astore 6
    //   115: aload_0
    //   116: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   119: new 220	org/apache/http/message/BasicNameValuePair
    //   122: dup
    //   123: ldc_w 297
    //   126: aload 5
    //   128: invokespecial 224	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: invokeinterface 230 2 0
    //   136: pop
    //   137: aload_0
    //   138: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   141: new 220	org/apache/http/message/BasicNameValuePair
    //   144: dup
    //   145: ldc_w 299
    //   148: aload 6
    //   150: invokespecial 224	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: invokeinterface 230 2 0
    //   158: pop
    //   159: aload_0
    //   160: getfield 301	com/ideashower/readitlater/objects/a:q	Ljava/lang/String;
    //   163: ifnull +572 -> 735
    //   166: aload_0
    //   167: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   170: new 220	org/apache/http/message/BasicNameValuePair
    //   173: dup
    //   174: ldc_w 303
    //   177: aload 5
    //   179: aload 6
    //   181: aload_0
    //   182: getfield 301	com/ideashower/readitlater/objects/a:q	Ljava/lang/String;
    //   185: invokestatic 305	com/ideashower/readitlater/objects/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: invokespecial 224	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: invokeinterface 230 2 0
    //   196: pop
    //   197: iload_2
    //   198: istore_1
    //   199: aload_0
    //   200: getfield 147	com/ideashower/readitlater/objects/a:n	Z
    //   203: ifeq +34 -> 237
    //   206: invokestatic 310	com/ideashower/readitlater/a/q:d	()Lcom/ideashower/readitlater/a/u;
    //   209: astore 5
    //   211: aload 5
    //   213: invokevirtual 314	com/ideashower/readitlater/a/u:c	()Z
    //   216: ifeq +552 -> 768
    //   219: aload_0
    //   220: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   223: dup
    //   224: iconst_1
    //   225: aconst_null
    //   226: ldc_w 318
    //   229: invokespecial 321	com/ideashower/readitlater/objects/ErrorReport:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   232: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   235: iconst_2
    //   236: istore_1
    //   237: iload_1
    //   238: ifne +1173 -> 1411
    //   241: new 325	org/apache/http/client/methods/HttpPost
    //   244: dup
    //   245: aload_0
    //   246: getfield 153	com/ideashower/readitlater/objects/a:a	Ljava/lang/String;
    //   249: invokespecial 327	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   252: astore 5
    //   254: aload 5
    //   256: ldc_w 329
    //   259: getstatic 112	com/ideashower/readitlater/objects/a:b	Ljava/lang/String;
    //   262: invokevirtual 332	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 5
    //   267: ldc_w 334
    //   270: ldc_w 336
    //   273: invokevirtual 339	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 5
    //   278: ldc_w 341
    //   281: ldc_w 343
    //   284: invokevirtual 339	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: getfield 242	com/ideashower/readitlater/objects/a:g	Ljava/util/List;
    //   291: ifnull +617 -> 908
    //   294: aload_0
    //   295: getfield 242	com/ideashower/readitlater/objects/a:g	Ljava/util/List;
    //   298: invokeinterface 347 1 0
    //   303: ifle +605 -> 908
    //   306: new 349	org/apache/http/entity/mime/MultipartEntity
    //   309: dup
    //   310: getstatic 355	org/apache/http/entity/mime/HttpMultipartMode:BROWSER_COMPATIBLE	Lorg/apache/http/entity/mime/HttpMultipartMode;
    //   313: invokespecial 358	org/apache/http/entity/mime/MultipartEntity:<init>	(Lorg/apache/http/entity/mime/HttpMultipartMode;)V
    //   316: astore 6
    //   318: ldc_w 360
    //   321: invokestatic 366	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   324: astore 7
    //   326: aload_0
    //   327: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   330: invokeinterface 370 1 0
    //   335: astore 8
    //   337: aload 8
    //   339: invokeinterface 375 1 0
    //   344: ifeq +486 -> 830
    //   347: aload 8
    //   349: invokeinterface 379 1 0
    //   354: checkcast 381	org/apache/http/NameValuePair
    //   357: astore 9
    //   359: aload 6
    //   361: aload 9
    //   363: invokeinterface 384 1 0
    //   368: new 386	org/apache/http/entity/mime/content/StringBody
    //   371: dup
    //   372: aload 9
    //   374: invokeinterface 387 1 0
    //   379: aload 7
    //   381: invokespecial 390	org/apache/http/entity/mime/content/StringBody:<init>	(Ljava/lang/String;Ljava/nio/charset/Charset;)V
    //   384: invokevirtual 394	org/apache/http/entity/mime/MultipartEntity:addPart	(Ljava/lang/String;Lorg/apache/http/entity/mime/content/ContentBody;)V
    //   387: goto -50 -> 337
    //   390: astore 6
    //   392: aload 6
    //   394: invokestatic 399	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   397: aload_0
    //   398: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   401: dup
    //   402: aload 6
    //   404: iconst_m1
    //   405: invokespecial 402	com/ideashower/readitlater/objects/ErrorReport:<init>	(Ljava/lang/Throwable;I)V
    //   408: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   411: iconst_2
    //   412: istore_1
    //   413: iload_1
    //   414: ifne +994 -> 1408
    //   417: aload_0
    //   418: aload 5
    //   420: invokevirtual 404	com/ideashower/readitlater/objects/a:a	(Lorg/apache/http/client/methods/HttpPost;)V
    //   423: aload_0
    //   424: getfield 160	com/ideashower/readitlater/objects/a:h	Lcom/e/a/a/a;
    //   427: aload 5
    //   429: invokevirtual 410	com/e/a/a/a:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   432: astore 9
    //   434: aload 9
    //   436: invokeinterface 414 1 0
    //   441: astore 8
    //   443: aload_0
    //   444: aload 9
    //   446: invokeinterface 418 1 0
    //   451: invokeinterface 423 1 0
    //   456: putfield 425	com/ideashower/readitlater/objects/a:k	I
    //   459: iload_1
    //   460: istore_2
    //   461: aload 8
    //   463: ifnull +132 -> 595
    //   466: aload_0
    //   467: getfield 425	com/ideashower/readitlater/objects/a:k	I
    //   470: sipush 200
    //   473: if_icmpne +644 -> 1117
    //   476: aload_0
    //   477: getfield 217	com/ideashower/readitlater/objects/a:i	Lcom/ideashower/readitlater/objects/b;
    //   480: ifnull +106 -> 586
    //   483: aload 8
    //   485: invokeinterface 431 1 0
    //   490: astore 7
    //   492: aload 9
    //   494: ldc_w 433
    //   497: invokeinterface 201 2 0
    //   502: astore 10
    //   504: aload 7
    //   506: astore 6
    //   508: aload 10
    //   510: ifnull +41 -> 551
    //   513: aload 7
    //   515: astore 6
    //   517: aload 10
    //   519: invokeinterface 206 1 0
    //   524: ldc_w 336
    //   527: invokevirtual 437	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   530: ifeq +21 -> 551
    //   533: new 439	java/io/BufferedInputStream
    //   536: dup
    //   537: new 441	java/util/zip/GZIPInputStream
    //   540: dup
    //   541: aload 7
    //   543: invokespecial 444	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   546: invokespecial 445	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   549: astore 6
    //   551: aload 9
    //   553: invokestatic 447	com/ideashower/readitlater/objects/a:a	(Lorg/apache/http/HttpResponse;)Z
    //   556: istore 4
    //   558: aload_0
    //   559: getfield 217	com/ideashower/readitlater/objects/a:i	Lcom/ideashower/readitlater/objects/b;
    //   562: aload 6
    //   564: iload 4
    //   566: invokeinterface 452 3 0
    //   571: istore_2
    //   572: iload_2
    //   573: istore_1
    //   574: aload 6
    //   576: ifnull +10 -> 586
    //   579: aload 6
    //   581: invokevirtual 457	java/io/InputStream:close	()V
    //   584: iload_2
    //   585: istore_1
    //   586: aload 8
    //   588: invokeinterface 460 1 0
    //   593: iload_1
    //   594: istore_2
    //   595: iload_2
    //   596: istore_1
    //   597: aload_0
    //   598: getfield 425	com/ideashower/readitlater/objects/a:k	I
    //   601: sipush 401
    //   604: if_icmpne +801 -> 1405
    //   607: aload_0
    //   608: getfield 145	com/ideashower/readitlater/objects/a:m	Z
    //   611: ifeq +794 -> 1405
    //   614: iconst_4
    //   615: istore_1
    //   616: iload_1
    //   617: istore_2
    //   618: iload_1
    //   619: tableswitch	default:+29->648, 0:+723->1342, 1:+31->650, 2:+728->1347, 3:+31->650
    //   648: iload_1
    //   649: istore_2
    //   650: aload_0
    //   651: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   654: ifnull +51 -> 705
    //   657: ldc_w 462
    //   660: new 69	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 463	java/lang/StringBuilder:<init>	()V
    //   667: ldc_w 465
    //   670: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_0
    //   674: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   677: invokevirtual 467	com/ideashower/readitlater/objects/ErrorReport:b	()Ljava/lang/String;
    //   680: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc_w 469
    //   686: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_0
    //   690: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   693: invokevirtual 471	com/ideashower/readitlater/objects/ErrorReport:a	()Ljava/lang/String;
    //   696: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 473	com/ideashower/readitlater/util/e:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   705: aload_0
    //   706: iload_2
    //   707: putfield 475	com/ideashower/readitlater/objects/a:j	I
    //   710: aload_0
    //   711: aconst_null
    //   712: putfield 217	com/ideashower/readitlater/objects/a:i	Lcom/ideashower/readitlater/objects/b;
    //   715: aload_0
    //   716: aconst_null
    //   717: putfield 160	com/ideashower/readitlater/objects/a:h	Lcom/e/a/a/a;
    //   720: aload_0
    //   721: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   724: invokeinterface 478 1 0
    //   729: return
    //   730: iconst_2
    //   731: istore_1
    //   732: goto -696 -> 36
    //   735: aload_0
    //   736: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   739: new 220	org/apache/http/message/BasicNameValuePair
    //   742: dup
    //   743: ldc_w 303
    //   746: aload 5
    //   748: aload 6
    //   750: invokestatic 285	com/ideashower/readitlater/a/as:h	()Ljava/lang/String;
    //   753: invokestatic 305	com/ideashower/readitlater/objects/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   756: invokespecial 224	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   759: invokeinterface 230 2 0
    //   764: pop
    //   765: goto -568 -> 197
    //   768: aload 5
    //   770: invokevirtual 479	com/ideashower/readitlater/a/u:a	()Ljava/lang/String;
    //   773: ifnull +20 -> 793
    //   776: iconst_0
    //   777: istore_1
    //   778: aload_0
    //   779: ldc_w 481
    //   782: aload 5
    //   784: invokevirtual 479	com/ideashower/readitlater/a/u:a	()Ljava/lang/String;
    //   787: invokevirtual 173	com/ideashower/readitlater/objects/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   790: goto -553 -> 237
    //   793: aload_0
    //   794: aload 5
    //   796: invokevirtual 484	com/ideashower/readitlater/a/u:b	()Lcom/ideashower/readitlater/objects/ErrorReport;
    //   799: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   802: aload_0
    //   803: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   806: ifnonnull +19 -> 825
    //   809: aload_0
    //   810: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   813: dup
    //   814: iconst_1
    //   815: aconst_null
    //   816: ldc_w 486
    //   819: invokespecial 321	com/ideashower/readitlater/objects/ErrorReport:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   822: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   825: iconst_2
    //   826: istore_1
    //   827: goto -590 -> 237
    //   830: aload_0
    //   831: getfield 242	com/ideashower/readitlater/objects/a:g	Ljava/util/List;
    //   834: invokeinterface 370 1 0
    //   839: astore 7
    //   841: aload 7
    //   843: invokeinterface 375 1 0
    //   848: ifeq +40 -> 888
    //   851: aload 7
    //   853: invokeinterface 379 1 0
    //   858: checkcast 244	com/ideashower/readitlater/objects/c
    //   861: astore 8
    //   863: aload 6
    //   865: aload 8
    //   867: invokevirtual 487	com/ideashower/readitlater/objects/c:getName	()Ljava/lang/String;
    //   870: new 489	org/apache/http/entity/mime/content/FileBody
    //   873: dup
    //   874: aload 8
    //   876: getfield 492	com/ideashower/readitlater/objects/c:a	Ljava/io/File;
    //   879: invokespecial 495	org/apache/http/entity/mime/content/FileBody:<init>	(Ljava/io/File;)V
    //   882: invokevirtual 394	org/apache/http/entity/mime/MultipartEntity:addPart	(Ljava/lang/String;Lorg/apache/http/entity/mime/content/ContentBody;)V
    //   885: goto -44 -> 841
    //   888: aload 5
    //   890: aload 6
    //   892: invokevirtual 499	org/apache/http/entity/mime/MultipartEntity:getContentType	()Lorg/apache/http/Header;
    //   895: invokevirtual 502	org/apache/http/client/methods/HttpPost:addHeader	(Lorg/apache/http/Header;)V
    //   898: aload 5
    //   900: aload 6
    //   902: invokevirtual 506	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   905: goto -492 -> 413
    //   908: new 508	org/apache/http/client/entity/UrlEncodedFormEntity
    //   911: dup
    //   912: aload_0
    //   913: getfield 165	com/ideashower/readitlater/objects/a:f	Ljava/util/List;
    //   916: ldc_w 360
    //   919: invokespecial 511	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   922: astore 6
    //   924: aload 5
    //   926: ldc_w 513
    //   929: ldc_w 515
    //   932: invokevirtual 339	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   935: goto -37 -> 898
    //   938: astore 6
    //   940: aload 6
    //   942: invokestatic 399	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   945: iload_2
    //   946: istore_1
    //   947: goto -361 -> 586
    //   950: astore 6
    //   952: aload 5
    //   954: invokevirtual 518	org/apache/http/client/methods/HttpPost:abort	()V
    //   957: aload_0
    //   958: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   961: dup
    //   962: aload 6
    //   964: iconst_1
    //   965: invokespecial 402	com/ideashower/readitlater/objects/ErrorReport:<init>	(Ljava/lang/Throwable;I)V
    //   968: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   971: aload_0
    //   972: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   975: ldc_w 519
    //   978: invokestatic 520	com/ideashower/readitlater/a/g:a	(I)Ljava/lang/String;
    //   981: invokevirtual 522	com/ideashower/readitlater/objects/ErrorReport:b	(Ljava/lang/String;)V
    //   984: aload 6
    //   986: invokestatic 399	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   989: iload_3
    //   990: istore_1
    //   991: goto -394 -> 597
    //   994: astore 5
    //   996: aload 5
    //   998: athrow
    //   999: astore 7
    //   1001: aload 7
    //   1003: athrow
    //   1004: astore 7
    //   1006: aload 6
    //   1008: ifnull +8 -> 1016
    //   1011: aload 6
    //   1013: invokevirtual 457	java/io/InputStream:close	()V
    //   1016: aload 7
    //   1018: athrow
    //   1019: astore 6
    //   1021: aload 5
    //   1023: invokevirtual 518	org/apache/http/client/methods/HttpPost:abort	()V
    //   1026: aload_0
    //   1027: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   1030: dup
    //   1031: aload 6
    //   1033: iconst_1
    //   1034: invokespecial 402	com/ideashower/readitlater/objects/ErrorReport:<init>	(Ljava/lang/Throwable;I)V
    //   1037: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1040: aload_0
    //   1041: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1044: ldc_w 523
    //   1047: invokestatic 520	com/ideashower/readitlater/a/g:a	(I)Ljava/lang/String;
    //   1050: invokevirtual 522	com/ideashower/readitlater/objects/ErrorReport:b	(Ljava/lang/String;)V
    //   1053: aload 6
    //   1055: invokestatic 399	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   1058: iload_3
    //   1059: istore_1
    //   1060: goto -463 -> 597
    //   1063: astore 6
    //   1065: aload 6
    //   1067: invokestatic 399	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   1070: goto -54 -> 1016
    //   1073: astore 6
    //   1075: aload 5
    //   1077: invokevirtual 518	org/apache/http/client/methods/HttpPost:abort	()V
    //   1080: aload_0
    //   1081: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   1084: dup
    //   1085: aload 6
    //   1087: iconst_1
    //   1088: invokespecial 402	com/ideashower/readitlater/objects/ErrorReport:<init>	(Ljava/lang/Throwable;I)V
    //   1091: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1094: aload_0
    //   1095: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1098: ldc_w 523
    //   1101: invokestatic 520	com/ideashower/readitlater/a/g:a	(I)Ljava/lang/String;
    //   1104: invokevirtual 522	com/ideashower/readitlater/objects/ErrorReport:b	(Ljava/lang/String;)V
    //   1107: aload 6
    //   1109: invokestatic 399	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   1112: iload_3
    //   1113: istore_1
    //   1114: goto -517 -> 597
    //   1117: aload 9
    //   1119: ldc_w 525
    //   1122: invokeinterface 201 2 0
    //   1127: astore 6
    //   1129: aload_0
    //   1130: getfield 425	com/ideashower/readitlater/objects/a:k	I
    //   1133: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1136: astore 7
    //   1138: aload 6
    //   1140: ifnull +119 -> 1259
    //   1143: aload 6
    //   1145: invokevirtual 526	java/lang/Object:toString	()Ljava/lang/String;
    //   1148: astore 6
    //   1150: aload 6
    //   1152: ifnull +50 -> 1202
    //   1155: aload 6
    //   1157: invokevirtual 529	java/lang/String:length	()I
    //   1160: ifle +42 -> 1202
    //   1163: aload_0
    //   1164: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   1167: dup
    //   1168: aload_0
    //   1169: getfield 425	com/ideashower/readitlater/objects/a:k	I
    //   1172: invokestatic 531	com/ideashower/readitlater/objects/a:a	(I)I
    //   1175: aload 6
    //   1177: ldc_w 533
    //   1180: ldc_w 535
    //   1183: invokestatic 536	org/apache/a/c/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1186: invokevirtual 539	java/lang/String:trim	()Ljava/lang/String;
    //   1189: aload 7
    //   1191: invokespecial 321	com/ideashower/readitlater/objects/ErrorReport:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1194: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1197: aload_0
    //   1198: iconst_1
    //   1199: putfield 149	com/ideashower/readitlater/objects/a:o	Z
    //   1202: aload 9
    //   1204: ldc_w 541
    //   1207: invokeinterface 201 2 0
    //   1212: astore 6
    //   1214: aload 6
    //   1216: ifnull +76 -> 1292
    //   1219: aload 6
    //   1221: invokevirtual 526	java/lang/Object:toString	()Ljava/lang/String;
    //   1224: astore 6
    //   1226: aload_0
    //   1227: aload 6
    //   1229: putfield 543	com/ideashower/readitlater/objects/a:r	Ljava/lang/String;
    //   1232: aload_0
    //   1233: getfield 543	com/ideashower/readitlater/objects/a:r	Ljava/lang/String;
    //   1236: ifnull +23 -> 1259
    //   1239: aload_0
    //   1240: aload_0
    //   1241: getfield 543	com/ideashower/readitlater/objects/a:r	Ljava/lang/String;
    //   1244: ldc_w 545
    //   1247: ldc_w 535
    //   1250: invokestatic 536	org/apache/a/c/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1253: invokevirtual 539	java/lang/String:trim	()Ljava/lang/String;
    //   1256: putfield 543	com/ideashower/readitlater/objects/a:r	Ljava/lang/String;
    //   1259: aload_0
    //   1260: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1263: ifnonnull +24 -> 1287
    //   1266: aload_0
    //   1267: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   1270: dup
    //   1271: aload_0
    //   1272: getfield 425	com/ideashower/readitlater/objects/a:k	I
    //   1275: invokestatic 531	com/ideashower/readitlater/objects/a:a	(I)I
    //   1278: aconst_null
    //   1279: aload 7
    //   1281: invokespecial 321	com/ideashower/readitlater/objects/ErrorReport:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1284: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1287: iconst_2
    //   1288: istore_1
    //   1289: goto -703 -> 586
    //   1292: aconst_null
    //   1293: astore 6
    //   1295: goto -69 -> 1226
    //   1298: astore 6
    //   1300: aload 5
    //   1302: invokevirtual 518	org/apache/http/client/methods/HttpPost:abort	()V
    //   1305: aload_0
    //   1306: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   1309: dup
    //   1310: aload 6
    //   1312: iconst_m1
    //   1313: invokespecial 402	com/ideashower/readitlater/objects/ErrorReport:<init>	(Ljava/lang/Throwable;I)V
    //   1316: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1319: aload_0
    //   1320: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1323: ldc_w 523
    //   1326: invokestatic 520	com/ideashower/readitlater/a/g:a	(I)Ljava/lang/String;
    //   1329: invokevirtual 522	com/ideashower/readitlater/objects/ErrorReport:b	(Ljava/lang/String;)V
    //   1332: aload 6
    //   1334: invokestatic 399	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   1337: iload_3
    //   1338: istore_1
    //   1339: goto -742 -> 597
    //   1342: iconst_1
    //   1343: istore_2
    //   1344: goto -694 -> 650
    //   1347: aload_0
    //   1348: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1351: ifnonnull +24 -> 1375
    //   1354: aload_0
    //   1355: new 316	com/ideashower/readitlater/objects/ErrorReport
    //   1358: dup
    //   1359: iconst_m1
    //   1360: ldc_w 523
    //   1363: invokestatic 520	com/ideashower/readitlater/a/g:a	(I)Ljava/lang/String;
    //   1366: ldc_w 547
    //   1369: invokespecial 321	com/ideashower/readitlater/objects/ErrorReport:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1372: putfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1375: iload_1
    //   1376: istore_2
    //   1377: aload_0
    //   1378: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1381: invokevirtual 548	com/ideashower/readitlater/objects/ErrorReport:c	()Z
    //   1384: ifne -734 -> 650
    //   1387: aload_0
    //   1388: getfield 323	com/ideashower/readitlater/objects/a:l	Lcom/ideashower/readitlater/objects/ErrorReport;
    //   1391: ldc_w 523
    //   1394: invokestatic 520	com/ideashower/readitlater/a/g:a	(I)Ljava/lang/String;
    //   1397: invokevirtual 522	com/ideashower/readitlater/objects/ErrorReport:b	(Ljava/lang/String;)V
    //   1400: iload_1
    //   1401: istore_2
    //   1402: goto -752 -> 650
    //   1405: goto -789 -> 616
    //   1408: goto -811 -> 597
    //   1411: aconst_null
    //   1412: astore 5
    //   1414: goto -1001 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1417	0	this	a
    //   3	1398	1	i1	int
    //   5	1397	2	i2	int
    //   1	1337	3	i3	int
    //   556	9	4	bool	boolean
    //   106	847	5	localObject1	Object
    //   994	307	5	localObject2	Object
    //   1412	1	5	localObject3	Object
    //   113	247	6	localObject4	Object
    //   390	13	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   506	417	6	localObject5	Object
    //   938	3	6	localException1	Exception
    //   950	62	6	localUnknownHostException	java.net.UnknownHostException
    //   1019	35	6	localSocketException	java.net.SocketException
    //   1063	3	6	localException2	Exception
    //   1073	35	6	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1127	167	6	localObject6	Object
    //   1298	35	6	localThrowable	Throwable
    //   324	528	7	localObject7	Object
    //   999	3	7	localException3	Exception
    //   1004	13	7	localObject8	Object
    //   1136	144	7	str	String
    //   335	540	8	localObject9	Object
    //   357	846	9	localObject10	Object
    //   502	16	10	localHeader	Header
    // Exception table:
    //   from	to	target	type
    //   287	337	390	java/io/UnsupportedEncodingException
    //   337	387	390	java/io/UnsupportedEncodingException
    //   830	841	390	java/io/UnsupportedEncodingException
    //   841	885	390	java/io/UnsupportedEncodingException
    //   888	898	390	java/io/UnsupportedEncodingException
    //   898	905	390	java/io/UnsupportedEncodingException
    //   908	935	390	java/io/UnsupportedEncodingException
    //   579	584	938	java/lang/Exception
    //   417	459	950	java/net/UnknownHostException
    //   466	476	950	java/net/UnknownHostException
    //   476	504	950	java/net/UnknownHostException
    //   517	551	950	java/net/UnknownHostException
    //   579	584	950	java/net/UnknownHostException
    //   586	593	950	java/net/UnknownHostException
    //   940	945	950	java/net/UnknownHostException
    //   1011	1016	950	java/net/UnknownHostException
    //   1016	1019	950	java/net/UnknownHostException
    //   1065	1070	950	java/net/UnknownHostException
    //   1117	1138	950	java/net/UnknownHostException
    //   1143	1150	950	java/net/UnknownHostException
    //   1155	1202	950	java/net/UnknownHostException
    //   1202	1214	950	java/net/UnknownHostException
    //   1219	1226	950	java/net/UnknownHostException
    //   1226	1259	950	java/net/UnknownHostException
    //   1259	1287	950	java/net/UnknownHostException
    //   417	459	994	finally
    //   466	476	994	finally
    //   476	504	994	finally
    //   517	551	994	finally
    //   579	584	994	finally
    //   586	593	994	finally
    //   940	945	994	finally
    //   952	989	994	finally
    //   1011	1016	994	finally
    //   1016	1019	994	finally
    //   1021	1058	994	finally
    //   1065	1070	994	finally
    //   1075	1112	994	finally
    //   1117	1138	994	finally
    //   1143	1150	994	finally
    //   1155	1202	994	finally
    //   1202	1214	994	finally
    //   1219	1226	994	finally
    //   1226	1259	994	finally
    //   1259	1287	994	finally
    //   1300	1337	994	finally
    //   551	572	999	java/lang/Exception
    //   551	572	1004	finally
    //   1001	1004	1004	finally
    //   417	459	1019	java/net/SocketException
    //   466	476	1019	java/net/SocketException
    //   476	504	1019	java/net/SocketException
    //   517	551	1019	java/net/SocketException
    //   579	584	1019	java/net/SocketException
    //   586	593	1019	java/net/SocketException
    //   940	945	1019	java/net/SocketException
    //   1011	1016	1019	java/net/SocketException
    //   1016	1019	1019	java/net/SocketException
    //   1065	1070	1019	java/net/SocketException
    //   1117	1138	1019	java/net/SocketException
    //   1143	1150	1019	java/net/SocketException
    //   1155	1202	1019	java/net/SocketException
    //   1202	1214	1019	java/net/SocketException
    //   1219	1226	1019	java/net/SocketException
    //   1226	1259	1019	java/net/SocketException
    //   1259	1287	1019	java/net/SocketException
    //   1011	1016	1063	java/lang/Exception
    //   417	459	1073	java/net/SocketTimeoutException
    //   466	476	1073	java/net/SocketTimeoutException
    //   476	504	1073	java/net/SocketTimeoutException
    //   517	551	1073	java/net/SocketTimeoutException
    //   579	584	1073	java/net/SocketTimeoutException
    //   586	593	1073	java/net/SocketTimeoutException
    //   940	945	1073	java/net/SocketTimeoutException
    //   1011	1016	1073	java/net/SocketTimeoutException
    //   1016	1019	1073	java/net/SocketTimeoutException
    //   1065	1070	1073	java/net/SocketTimeoutException
    //   1117	1138	1073	java/net/SocketTimeoutException
    //   1143	1150	1073	java/net/SocketTimeoutException
    //   1155	1202	1073	java/net/SocketTimeoutException
    //   1202	1214	1073	java/net/SocketTimeoutException
    //   1219	1226	1073	java/net/SocketTimeoutException
    //   1226	1259	1073	java/net/SocketTimeoutException
    //   1259	1287	1073	java/net/SocketTimeoutException
    //   417	459	1298	java/lang/Throwable
    //   466	476	1298	java/lang/Throwable
    //   476	504	1298	java/lang/Throwable
    //   517	551	1298	java/lang/Throwable
    //   579	584	1298	java/lang/Throwable
    //   586	593	1298	java/lang/Throwable
    //   940	945	1298	java/lang/Throwable
    //   1011	1016	1298	java/lang/Throwable
    //   1016	1019	1298	java/lang/Throwable
    //   1065	1070	1298	java/lang/Throwable
    //   1117	1138	1298	java/lang/Throwable
    //   1143	1150	1298	java/lang/Throwable
    //   1155	1202	1298	java/lang/Throwable
    //   1202	1214	1298	java/lang/Throwable
    //   1219	1226	1298	java/lang/Throwable
    //   1226	1259	1298	java/lang/Throwable
    //   1259	1287	1298	java/lang/Throwable
  }
  
  public void b(String paramString)
  {
    paramString = URLEncodedUtils.parse(new URI(this.a + "?" + paramString), "UTF-8");
    this.f.addAll(paramString);
  }
  
  public int c()
  {
    return this.j;
  }
  
  public void c(String paramString)
  {
    this.q = paramString;
  }
  
  public int d()
  {
    return this.k;
  }
  
  public int e()
  {
    return org.apache.a.c.d.a.a(this.r);
  }
  
  public ErrorReport f()
  {
    return this.l;
  }
  
  public boolean g()
  {
    return this.o;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */