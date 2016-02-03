package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.quoord.tools.ForumHttpStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class AsyncBitmapLoader {
    public static final String GIFSHOW = "GIFSHOW";
    public HashMap<String, SoftReference<CustomBitmapWithType>> imageCache = null;

    public AsyncBitmapLoader() {
        init();
    }

    private CustomBitmapWithType getLocalCustomBitmapWithType(Context paramContext, String paramString, int paramInt) {
        if (new File(paramString).exists()) {
            if (paramInt == 5) {
                paramContext = Util.getLogoRemoteForumLogo(paramString);
            }
            for (; ; ) {
                paramString = getImageType(paramString);
                CustomBitmapWithType localCustomBitmapWithType = new CustomBitmapWithType();
                localCustomBitmapWithType.tempBitmap = paramContext;
                localCustomBitmapWithType.imageType = paramString;
                return localCustomBitmapWithType;
                if (paramInt == 6) {
                    paramContext = Util.getRemoteBlog(paramContext, paramString);
                } else if (paramInt == 7) {
                    paramContext = Util.getRemoteTapatalkPic(paramString, paramContext);
                } else {
                    paramContext = Util.getRemoteAvatar(paramString);
                }
            }
        }
        return null;
    }

    /* Error */
    private CustomBitmapWithType getRomoteBitmapWithType(Context paramContext, ForumHttpStatus paramForumHttpStatus, String paramString, int paramInt) {
        // Byte code:
        //   0: aload_1
        //   1: invokestatic 85	com/quoord/tapatalkpro/cache/AppCacheManager:getRemoteImageCacheDir	(Landroid/content/Context;)Ljava/lang/String;
        //   4: invokestatic 89	com/quoord/tapatalkpro/cache/AppCacheManager:checkFile	(Ljava/lang/String;)Z
        //   7: ifne +7 -> 14
        //   10: aload_1
        //   11: invokestatic 93	com/quoord/tapatalkpro/cache/AppCacheManager:createCacheDir	(Landroid/content/Context;)V
        //   14: aload_1
        //   15: iload 4
        //   17: aload_3
        //   18: invokestatic 99	com/quoord/tapatalkpro/util/AvatarTool:getLocalUrl	(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;
        //   21: astore 9
        //   23: new 37	java/io/File
        //   26: dup
        //   27: aload 9
        //   29: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
        //   32: astore 10
        //   34: aload_3
        //   35: ifnull +10 -> 45
        //   38: aload_3
        //   39: invokevirtual 105	java/lang/String:length	()I
        //   42: ifne +5 -> 47
        //   45: aconst_null
        //   46: areturn
        //   47: aload_3
        //   48: ldc 107
        //   50: ldc 109
        //   52: invokevirtual 113	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   55: ldc 115
        //   57: ldc 117
        //   59: invokevirtual 113	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   62: astore 6
        //   64: aload 6
        //   66: astore_3
        //   67: aload 6
        //   69: ldc 119
        //   71: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   74: ifne +34 -> 108
        //   77: aload 6
        //   79: astore_3
        //   80: aload 6
        //   82: ldc 124
        //   84: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   87: ifne +21 -> 108
        //   90: new 126	java/lang/StringBuilder
        //   93: dup
        //   94: ldc 119
        //   96: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   99: aload 6
        //   101: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   104: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   107: astore_3
        //   108: new 137	java/net/URL
        //   111: dup
        //   112: aload_3
        //   113: invokespecial 138	java/net/URL:<init>	(Ljava/lang/String;)V
        //   116: astore 7
        //   118: aconst_null
        //   119: astore 8
        //   121: aload 8
        //   123: astore 6
        //   125: aload_3
        //   126: ldc -116
        //   128: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   131: ifeq +587 -> 718
        //   134: aload 8
        //   136: astore 6
        //   138: invokestatic 143	com/quoord/tapatalkpro/util/Util:trustAllHosts	()V
        //   141: aload 8
        //   143: astore 6
        //   145: aload 7
        //   147: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   150: checkcast 149	javax/net/ssl/HttpsURLConnection
        //   153: astore_3
        //   154: aload 8
        //   156: astore 6
        //   158: aload_3
        //   159: getstatic 153	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   162: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   165: aload_3
        //   166: astore 6
        //   168: aload_3
        //   169: sipush 5000
        //   172: invokevirtual 163	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   175: aload_3
        //   176: astore 6
        //   178: aload_3
        //   179: sipush 30000
        //   182: invokevirtual 166	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   185: aload_3
        //   186: astore 6
        //   188: aload 7
        //   190: invokevirtual 167	java/net/URL:toString	()Ljava/lang/String;
        //   193: ldc -87
        //   195: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   198: ifeq +764 -> 962
        //   201: aload_3
        //   202: astore 6
        //   204: aload_3
        //   205: invokevirtual 172	java/net/HttpURLConnection:getResponseCode	()I
        //   208: istore 5
        //   210: iload 5
        //   212: sipush 302
        //   215: if_icmpeq +27 -> 242
        //   218: iload 5
        //   220: sipush 301
        //   223: if_icmpeq +19 -> 242
        //   226: iload 5
        //   228: sipush 303
        //   231: if_icmpeq +11 -> 242
        //   234: iload 5
        //   236: sipush 307
        //   239: if_icmpne +525 -> 764
        //   242: aload_3
        //   243: astore 6
        //   245: aload_3
        //   246: invokevirtual 176	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
        //   249: astore 8
        //   251: aload_3
        //   252: astore 7
        //   254: aload 8
        //   256: invokevirtual 167	java/net/URL:toString	()Ljava/lang/String;
        //   259: ldc -87
        //   261: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   264: ifeq +470 -> 734
        //   267: aload_3
        //   268: astore 7
        //   270: aload 8
        //   272: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   275: checkcast 159	java/net/HttpURLConnection
        //   278: astore_3
        //   279: aload_3
        //   280: astore 6
        //   282: aload_3
        //   283: astore 7
        //   285: aload 8
        //   287: invokevirtual 167	java/net/URL:toString	()Ljava/lang/String;
        //   290: ldc -116
        //   292: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   295: ifeq +82 -> 377
        //   298: aload_3
        //   299: astore 7
        //   301: aload_3
        //   302: invokevirtual 172	java/net/HttpURLConnection:getResponseCode	()I
        //   305: istore 5
        //   307: iload 5
        //   309: sipush 302
        //   312: if_icmpeq +27 -> 339
        //   315: iload 5
        //   317: sipush 301
        //   320: if_icmpeq +19 -> 339
        //   323: iload 5
        //   325: sipush 303
        //   328: if_icmpeq +11 -> 339
        //   331: iload 5
        //   333: sipush 307
        //   336: if_icmpne +474 -> 810
        //   339: aload_3
        //   340: astore 7
        //   342: aload_3
        //   343: invokevirtual 176	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
        //   346: astore 6
        //   348: aload_3
        //   349: astore 7
        //   351: aload 6
        //   353: invokevirtual 167	java/net/URL:toString	()Ljava/lang/String;
        //   356: ldc -87
        //   358: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   361: ifeq +422 -> 783
        //   364: aload_3
        //   365: astore 7
        //   367: aload 6
        //   369: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   372: checkcast 159	java/net/HttpURLConnection
        //   375: astore 6
        //   377: aload 6
        //   379: astore 7
        //   381: aload 6
        //   383: sipush 20000
        //   386: invokevirtual 163	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   389: aload 6
        //   391: astore 7
        //   393: aload 6
        //   395: ldc -79
        //   397: invokevirtual 166	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   400: aload 6
        //   402: astore 7
        //   404: aload 6
        //   406: iconst_1
        //   407: invokevirtual 181	java/net/HttpURLConnection:setDoInput	(Z)V
        //   410: aload_2
        //   411: ifnull +46 -> 457
        //   414: aload 6
        //   416: astore 7
        //   418: aload_2
        //   419: invokeinterface 186 1 0
        //   424: astore_3
        //   425: aload_3
        //   426: ifnull +31 -> 457
        //   429: aload 6
        //   431: astore 7
        //   433: aload_3
        //   434: invokevirtual 105	java/lang/String:length	()I
        //   437: ifle +20 -> 457
        //   440: aload 6
        //   442: astore 7
        //   444: aload 6
        //   446: ldc -68
        //   448: aload_2
        //   449: invokeinterface 186 1 0
        //   454: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   457: aload_2
        //   458: ifnull +20 -> 478
        //   461: aload 6
        //   463: astore 7
        //   465: aload 6
        //   467: ldc -62
        //   469: aload_2
        //   470: invokeinterface 197 1 0
        //   475: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   478: aload 6
        //   480: astore 7
        //   482: aload_1
        //   483: aload 6
        //   485: aload_2
        //   486: invokestatic 203	com/quoord/tapatalkpro/util/UserAgent:setHTTPURLConn	(Landroid/content/Context;Ljava/net/HttpURLConnection;Lcom/quoord/tools/ForumHttpStatus;)V
        //   489: aload_2
        //   490: ifnull +29 -> 519
        //   493: aload 6
        //   495: astore 7
        //   497: aload_2
        //   498: invokeinterface 206 1 0
        //   503: ifeq +16 -> 519
        //   506: aload 6
        //   508: astore 7
        //   510: aload 6
        //   512: ldc -48
        //   514: ldc -46
        //   516: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   519: aload_2
        //   520: ifnull +29 -> 549
        //   523: aload 6
        //   525: astore 7
        //   527: aload_2
        //   528: invokeinterface 213 1 0
        //   533: ifeq +16 -> 549
        //   536: aload 6
        //   538: astore 7
        //   540: aload 6
        //   542: ldc -41
        //   544: ldc -39
        //   546: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   549: aload 6
        //   551: astore 7
        //   553: aload 6
        //   555: ldc -37
        //   557: ldc -35
        //   559: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   562: aload 6
        //   564: astore 7
        //   566: aload 6
        //   568: invokevirtual 224	java/net/HttpURLConnection:connect	()V
        //   571: aload 6
        //   573: astore 7
        //   575: new 226	java/io/DataInputStream
        //   578: dup
        //   579: aload 6
        //   581: invokevirtual 230	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   584: invokespecial 233	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
        //   587: astore_2
        //   588: aload 6
        //   590: astore 7
        //   592: new 235	java/io/FileOutputStream
        //   595: dup
        //   596: aload 10
        //   598: invokespecial 238	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   601: astore_3
        //   602: aload 6
        //   604: astore 7
        //   606: sipush 1024
        //   609: newarray <illegal type>
        //   611: astore 8
        //   613: aload 6
        //   615: astore 7
        //   617: aload_2
        //   618: aload 8
        //   620: invokevirtual 242	java/io/DataInputStream:read	([B)I
        //   623: istore 5
        //   625: iload 5
        //   627: iconst_m1
        //   628: if_icmpne +209 -> 837
        //   631: aload 6
        //   633: astore 7
        //   635: aload 6
        //   637: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
        //   640: aload 6
        //   642: astore 7
        //   644: aload_2
        //   645: invokevirtual 248	java/io/DataInputStream:close	()V
        //   648: aload 6
        //   650: astore 7
        //   652: aload_3
        //   653: invokevirtual 251	java/io/FileOutputStream:flush	()V
        //   656: aload 6
        //   658: astore 7
        //   660: aload_3
        //   661: invokevirtual 252	java/io/FileOutputStream:close	()V
        //   664: aload 10
        //   666: invokevirtual 44	java/io/File:exists	()Z
        //   669: ifeq +287 -> 956
        //   672: iload 4
        //   674: iconst_5
        //   675: if_icmpne +200 -> 875
        //   678: aload 9
        //   680: invokestatic 50	com/quoord/tapatalkpro/util/Util:getLogoRemoteForumLogo	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   683: astore_1
        //   684: aload_0
        //   685: aload 9
        //   687: invokevirtual 54	com/quoord/tapatalkpro/util/AsyncBitmapLoader:getImageType	(Ljava/lang/String;)Ljava/lang/String;
        //   690: astore_2
        //   691: new 56	com/quoord/tapatalkpro/util/CustomBitmapWithType
        //   694: dup
        //   695: invokespecial 57	com/quoord/tapatalkpro/util/CustomBitmapWithType:<init>	()V
        //   698: astore_3
        //   699: aload_3
        //   700: aload_1
        //   701: putfield 61	com/quoord/tapatalkpro/util/CustomBitmapWithType:tempBitmap	Landroid/graphics/Bitmap;
        //   704: aload_3
        //   705: aload_2
        //   706: putfield 64	com/quoord/tapatalkpro/util/CustomBitmapWithType:imageType	Ljava/lang/String;
        //   709: aload_3
        //   710: areturn
        //   711: astore_1
        //   712: aload_1
        //   713: invokevirtual 255	java/net/MalformedURLException:printStackTrace	()V
        //   716: aconst_null
        //   717: areturn
        //   718: aload 8
        //   720: astore 6
        //   722: aload 7
        //   724: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   727: checkcast 159	java/net/HttpURLConnection
        //   730: astore_3
        //   731: goto -566 -> 165
        //   734: aload_3
        //   735: astore 7
        //   737: aload 8
        //   739: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   742: checkcast 149	javax/net/ssl/HttpsURLConnection
        //   745: astore 6
        //   747: aload_3
        //   748: astore 7
        //   750: aload 6
        //   752: getstatic 153	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   755: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   758: aload 6
        //   760: astore_3
        //   761: goto -482 -> 279
        //   764: aload_3
        //   765: astore 6
        //   767: aload 7
        //   769: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   772: checkcast 159	java/net/HttpURLConnection
        //   775: astore_3
        //   776: aload 7
        //   778: astore 8
        //   780: goto -501 -> 279
        //   783: aload_3
        //   784: astore 7
        //   786: aload 6
        //   788: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   791: checkcast 149	javax/net/ssl/HttpsURLConnection
        //   794: astore 6
        //   796: aload_3
        //   797: astore 7
        //   799: aload 6
        //   801: getstatic 153	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   804: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   807: goto -430 -> 377
        //   810: aload_3
        //   811: astore 7
        //   813: aload 8
        //   815: invokevirtual 147	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   818: checkcast 149	javax/net/ssl/HttpsURLConnection
        //   821: astore 6
        //   823: aload_3
        //   824: astore 7
        //   826: aload 6
        //   828: getstatic 153	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   831: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   834: goto -457 -> 377
        //   837: aload 6
        //   839: astore 7
        //   841: aload_3
        //   842: aload 8
        //   844: iconst_0
        //   845: iload 5
        //   847: invokevirtual 259	java/io/FileOutputStream:write	([BII)V
        //   850: goto -237 -> 613
        //   853: astore_2
        //   854: aload 7
        //   856: astore 6
        //   858: aload 6
        //   860: ifnull +8 -> 868
        //   863: aload 6
        //   865: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
        //   868: aload_2
        //   869: invokevirtual 260	java/lang/Exception:printStackTrace	()V
        //   872: goto -208 -> 664
        //   875: iload 4
        //   877: bipush 6
        //   879: if_icmpne +51 -> 930
        //   882: aload_1
        //   883: aload 9
        //   885: invokestatic 68	com/quoord/tapatalkpro/util/Util:getRemoteBlog	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   888: astore_2
        //   889: aload_0
        //   890: new 126	java/lang/StringBuilder
        //   893: dup
        //   894: aload_1
        //   895: invokestatic 85	com/quoord/tapatalkpro/cache/AppCacheManager:getRemoteImageCacheDir	(Landroid/content/Context;)Ljava/lang/String;
        //   898: invokestatic 264	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   901: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   904: aload 9
        //   906: invokevirtual 267	java/lang/String:hashCode	()I
        //   909: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   912: ldc_w 272
        //   915: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   918: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   921: aload_2
        //   922: invokespecial 276	com/quoord/tapatalkpro/util/AsyncBitmapLoader:saveBlogIconBitmap	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
        //   925: aload_2
        //   926: astore_1
        //   927: goto -243 -> 684
        //   930: iload 4
        //   932: bipush 7
        //   934: if_icmpne +13 -> 947
        //   937: aload 9
        //   939: aload_1
        //   940: invokestatic 72	com/quoord/tapatalkpro/util/Util:getRemoteTapatalkPic	(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/Bitmap;
        //   943: astore_1
        //   944: goto -260 -> 684
        //   947: aload 9
        //   949: invokestatic 75	com/quoord/tapatalkpro/util/Util:getRemoteAvatar	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   952: astore_1
        //   953: goto -269 -> 684
        //   956: aconst_null
        //   957: areturn
        //   958: astore_2
        //   959: goto -101 -> 858
        //   962: aload 7
        //   964: astore 8
        //   966: goto -687 -> 279
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	969	0	this	AsyncBitmapLoader
        //   0	969	1	paramContext	Context
        //   0	969	2	paramForumHttpStatus	ForumHttpStatus
        //   0	969	3	paramString	String
        //   0	969	4	paramInt	int
        //   208	638	5	i	int
        //   62	802	6	localObject1	Object
        //   116	847	7	localObject2	Object
        //   119	846	8	localObject3	Object
        //   21	927	9	str	String
        //   32	633	10	localFile	File
        // Exception table:
        //   from	to	target	type
        //   108	118	711	java/net/MalformedURLException
        //   254	267	853	java/lang/Exception
        //   270	279	853	java/lang/Exception
        //   285	298	853	java/lang/Exception
        //   301	307	853	java/lang/Exception
        //   342	348	853	java/lang/Exception
        //   351	364	853	java/lang/Exception
        //   367	377	853	java/lang/Exception
        //   381	389	853	java/lang/Exception
        //   393	400	853	java/lang/Exception
        //   404	410	853	java/lang/Exception
        //   418	425	853	java/lang/Exception
        //   433	440	853	java/lang/Exception
        //   444	457	853	java/lang/Exception
        //   465	478	853	java/lang/Exception
        //   482	489	853	java/lang/Exception
        //   497	506	853	java/lang/Exception
        //   510	519	853	java/lang/Exception
        //   527	536	853	java/lang/Exception
        //   540	549	853	java/lang/Exception
        //   553	562	853	java/lang/Exception
        //   566	571	853	java/lang/Exception
        //   575	588	853	java/lang/Exception
        //   592	602	853	java/lang/Exception
        //   606	613	853	java/lang/Exception
        //   617	625	853	java/lang/Exception
        //   635	640	853	java/lang/Exception
        //   644	648	853	java/lang/Exception
        //   652	656	853	java/lang/Exception
        //   660	664	853	java/lang/Exception
        //   737	747	853	java/lang/Exception
        //   750	758	853	java/lang/Exception
        //   786	796	853	java/lang/Exception
        //   799	807	853	java/lang/Exception
        //   813	823	853	java/lang/Exception
        //   826	834	853	java/lang/Exception
        //   841	850	853	java/lang/Exception
        //   125	134	958	java/lang/Exception
        //   138	141	958	java/lang/Exception
        //   145	154	958	java/lang/Exception
        //   158	165	958	java/lang/Exception
        //   168	175	958	java/lang/Exception
        //   178	185	958	java/lang/Exception
        //   188	201	958	java/lang/Exception
        //   204	210	958	java/lang/Exception
        //   245	251	958	java/lang/Exception
        //   722	731	958	java/lang/Exception
        //   767	776	958	java/lang/Exception
    }

    private void saveBlogIconBitmap(String paramString, Bitmap paramBitmap) {
        Object localObject = new File(paramString);
        try {
            ((File) localObject).createNewFile();
            paramString = null;
        } catch (IOException localFileNotFoundException) {
            try {
                localObject = new FileOutputStream((File) localObject);
                paramString = (String) localObject;
                paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
            } catch (FileNotFoundException localFileNotFoundException) {
                try {
                    for (; ; ) {
                        paramString.flush();
                        try {
                            paramString.close();
                            return;
                        } catch (IOException paramString) {
                            paramString.printStackTrace();
                        }
                        paramString = paramString;
                        paramString.printStackTrace();
                    }
                    localFileNotFoundException = localFileNotFoundException;
                    localFileNotFoundException.printStackTrace();
                } catch (IOException paramBitmap) {
                    for (; ; ) {
                        paramBitmap.printStackTrace();
                    }
                }
            }
        }
    }

    public void clearCash() {
        this.imageCache = null;
    }

    public void closeThreadPools() {
    }

    public String getImageType(String paramString) {
        Object localObject2 = new File(paramString);
        Object localObject1 = null;
        paramString = (String) localObject1;
        try {
            FileInputStream localFileInputStream = new FileInputStream((File) localObject2);
            paramString = (String) localObject1;
            localObject2 = ImageItem.getImageType(localFileInputStream);
            localObject1 = localObject2;
            if (localFileInputStream != null) {
                localObject1 = localObject2;
                paramString = (String) localObject2;
                if (localFileInputStream.available() > 30000) {
                    paramString = (String) localObject2;
                    localObject1 = ImageItem.JPEG;
                }
            }
            paramString = (String) localObject1;
            localFileInputStream.close();
            paramString = (String) localObject1;
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
        localObject1 = paramString;
        if (paramString == null) {
            localObject1 = ImageItem.JPEG;
        }
        return (String) localObject1;
    }

    public void init() {
        this.imageCache = new HashMap();
    }

    public CustomBitmapWithType loadBitmap(Context paramContext, View paramView, String paramString, ImageCallBack paramImageCallBack, int paramInt) {
        return loadBitmap(paramContext, null, paramView, paramString, paramImageCallBack, paramInt);
    }

    public CustomBitmapWithType loadBitmap(final Context paramContext, final ForumHttpStatus paramForumHttpStatus, final View paramView, final String paramString, final ImageCallBack paramImageCallBack, final int paramInt) {
        if (this.imageCache == null) {
            init();
        }
        CustomBitmapWithType localCustomBitmapWithType;
        if (this.imageCache.containsKey(paramString)) {
            localCustomBitmapWithType = (CustomBitmapWithType) ((SoftReference) this.imageCache.get(paramString)).get();
            if ((localCustomBitmapWithType != null) && (localCustomBitmapWithType.tempBitmap != null)) {
                return localCustomBitmapWithType;
            }
            this.imageCache.remove(paramString);
            localCustomBitmapWithType = getLocalCustomBitmapWithType(paramContext, AvatarTool.getLocalUrl(paramContext, paramInt, paramString), paramInt);
            if ((localCustomBitmapWithType != null) && (localCustomBitmapWithType.tempBitmap != null)) {
                this.imageCache.put(paramString, new SoftReference(localCustomBitmapWithType));
                return localCustomBitmapWithType;
            }
        } else {
            localCustomBitmapWithType = getLocalCustomBitmapWithType(paramContext, AvatarTool.getLocalUrl(paramContext, paramInt, paramString), paramInt);
            if ((localCustomBitmapWithType != null) && (localCustomBitmapWithType.tempBitmap != null)) {
                this.imageCache.put(paramString, new SoftReference(localCustomBitmapWithType));
                return localCustomBitmapWithType;
            }
        }
        ThreadPoolManager.addExecuteTask(new Runnable() {
            public void handleMessage(Message paramAnonymousMessage) {
                paramImageCallBack.imageLoad(paramView, (CustomBitmapWithType) paramAnonymousMessage.obj, paramString);
            }
        }
        {
            public void run ()
            {
                try {
                    Object localObject = AsyncBitmapLoader.this.getRomoteBitmapWithType(paramContext, paramForumHttpStatus, paramString, paramInt);
                    if ((localObject != null) && (((CustomBitmapWithType) localObject).tempBitmap != null)) {
                        AsyncBitmapLoader.this.imageCache.put(paramString, new SoftReference(localObject));
                        localObject = this.val$handler.obtainMessage(0, localObject);
                        this.val$handler.sendMessage((Message) localObject);
                    }
                    return;
                } catch (Exception localException) {
                }
            }
        });
        return null;
    }

    public static abstract interface ImageCallBack {
        public abstract void imageLoad(View paramView, CustomBitmapWithType paramCustomBitmapWithType, String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/AsyncBitmapLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */