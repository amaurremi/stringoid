package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ImageInThread;
import com.quoord.tapatalkpro.cache.AppCacheManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageInThreadLoader {
    public static final String BROKEN = "BROKEN";
    public static JSONArray image_log = new JSONArray();
    public static HashMap<String, GifTypeandLocalUrl> localStrCash = null;

    public static boolean checkLocal(String paramString) {
        return new File(paramString).exists();
    }

    public static boolean checkLocalImg(Context paramContext, String paramString) {
        if (localStrCash == null) {
            init();
        }
        if (localStrCash.containsKey(paramString)) {
            paramContext = (GifTypeandLocalUrl) localStrCash.get(paramString);
            if ((!checkLocal(paramContext.localUrl)) || (!Util.checkBitmap(paramContext.localUrl))) {
            }
        } else {
            GifTypeandLocalUrl localGifTypeandLocalUrl;
            do {
                return true;
                localGifTypeandLocalUrl = new GifTypeandLocalUrl();
                localGifTypeandLocalUrl.localUrl = (AppCacheManager.getRemoteImageCacheDir(paramContext) + paramString.hashCode());
            }
            while ((checkLocal(localGifTypeandLocalUrl.localUrl)) && (Util.checkBitmap(localGifTypeandLocalUrl.localUrl)));
        }
        return false;
    }

    public static void clearCash() {
        String str;
        if (localStrCash != null) {
            str = (String) localStrCash.keySet().iterator().next();
        }
        for (; ; ) {
            if (str == null) {
                return;
            }
            localStrCash.remove(str);
        }
    }

    public static void closeThreadPools() {
    }

    public static void destory(String paramString, Activity paramActivity) {
        if ((paramActivity.getResources().getBoolean(2131558401)) && (image_log.length() > 0)) {
            TapatalkJsonEngine.logImage(paramString, image_log.toString());
        }
    }

    public static String getImageType(String paramString) {
        Object localObject3 = new File(paramString);
        Object localObject2 = null;
        paramString = null;
        localObject1 = localObject2;
        try {
            if (((File) localObject3).exists()) {
                localObject1 = localObject2;
                localObject3 = new FileInputStream((File) localObject3);
                localObject1 = localObject2;
                paramString = ImageItem.getImageType((InputStream) localObject3);
                localObject1 = paramString;
                ((InputStream) localObject3).close();
            }
        } catch (Exception paramString) {
            for (; ; ) {
                paramString.printStackTrace();
                paramString = (String) localObject1;
            }
        }
        localObject1 = paramString;
        if (paramString == null) {
            localObject1 = ImageItem.JPEG;
        }
        return (String) localObject1;
    }

    public static GifTypeandLocalUrl getLocalStringAndType(ForumStatus paramForumStatus, final ImageInThread paramImageInThread, final String paramString1, ImageCallBack paramImageCallBack, final String paramString2, final String paramString3, final int paramInt1, final String paramString4, final String paramString5, final int paramInt2, final Context paramContext) {
        if (localStrCash == null) {
            init();
        }
        if (!paramString1.contains("pt.tapatalk.com/vimeo.php?id=")) {
            GifTypeandLocalUrl localGifTypeandLocalUrl;
            if (localStrCash.containsKey(paramString1)) {
                localGifTypeandLocalUrl = (GifTypeandLocalUrl) localStrCash.get(paramString1);
                if (checkLocal(localGifTypeandLocalUrl.localUrl)) {
                    if (Util.checkBitmap(localGifTypeandLocalUrl.localUrl)) {
                        localStrCash.put(paramString1, localGifTypeandLocalUrl);
                        return localGifTypeandLocalUrl;
                    }
                    localGifTypeandLocalUrl.localUrl = "BROKEN";
                    localStrCash.put(paramString1, localGifTypeandLocalUrl);
                    return localGifTypeandLocalUrl;
                }
            } else {
                localGifTypeandLocalUrl = new GifTypeandLocalUrl();
                localGifTypeandLocalUrl.localUrl = (AppCacheManager.getRemoteImageCacheDir(paramContext) + paramString1.hashCode());
                if (checkLocal(localGifTypeandLocalUrl.localUrl)) {
                    if (Util.checkBitmap(localGifTypeandLocalUrl.localUrl)) {
                        localGifTypeandLocalUrl.type = getImageType(localGifTypeandLocalUrl.localUrl);
                        localStrCash.put(paramString1, localGifTypeandLocalUrl);
                        return localGifTypeandLocalUrl;
                    }
                    localGifTypeandLocalUrl.localUrl = "BROKEN";
                    localGifTypeandLocalUrl.localUrl = ImageItem.JPEG;
                    localStrCash.put(paramString1, localGifTypeandLocalUrl);
                    return localGifTypeandLocalUrl;
                }
            }
        }
        ThreadPoolManager.addExecuteTask(new Thread() {
            public void handleMessage(Message paramAnonymousMessage) {
                paramAnonymousMessage = (GifTypeandLocalUrl) paramAnonymousMessage.obj;
                if ((paramAnonymousMessage != null) && (!paramAnonymousMessage.localUrl.equals("BROKEN")) && (Util.checkBitmap(paramAnonymousMessage.localUrl))) {
                    ImageInThreadLoader.this.imageLoad(paramImageInThread, paramAnonymousMessage.localUrl, paramString1, paramAnonymousMessage.type);
                    return;
                }
                ImageInThreadLoader.this.imageLoad(paramImageInThread, "BROKEN", paramString1, paramAnonymousMessage.type);
            }
        }
        {
            public void run ()
            {
                try {
                    Object localObject = ImageInThreadLoader.getRomoteBitmapLocalUrl(ImageInThreadLoader.this, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramContext);
                    GifTypeandLocalUrl localGifTypeandLocalUrl = new GifTypeandLocalUrl();
                    if (localObject != null) {
                        String str = ImageInThreadLoader.getImageType((String) localObject);
                        localGifTypeandLocalUrl.localUrl = ((String) localObject);
                        localGifTypeandLocalUrl.type = str;
                        ImageInThreadLoader.localStrCash.put(paramString1, localGifTypeandLocalUrl);
                    }
                    localObject = this.val$handler.obtainMessage(0, localGifTypeandLocalUrl);
                    this.val$handler.sendMessage((Message) localObject);
                    return;
                } catch (Exception localException) {
                    localException.printStackTrace();
                    Message localMessage = this.val$handler.obtainMessage(0, null);
                    this.val$handler.sendMessage(localMessage);
                }
            }
        });
        return null;
    }

    /* Error */
    public static String getRomoteBitmapLocalUrl(ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, Context paramContext) {
        // Byte code:
        //   0: aload 8
        //   2: invokestatic 79	com/quoord/tapatalkpro/cache/AppCacheManager:getRemoteImageCacheDir	(Landroid/content/Context;)Ljava/lang/String;
        //   5: invokestatic 207	com/quoord/tapatalkpro/cache/AppCacheManager:checkFile	(Ljava/lang/String;)Z
        //   8: ifne +8 -> 16
        //   11: aload 8
        //   13: invokestatic 211	com/quoord/tapatalkpro/cache/AppCacheManager:createCacheDir	(Landroid/content/Context;)V
        //   16: new 73	java/lang/StringBuilder
        //   19: dup
        //   20: aload 8
        //   22: invokestatic 79	com/quoord/tapatalkpro/cache/AppCacheManager:getRemoteImageCacheDir	(Landroid/content/Context;)Ljava/lang/String;
        //   25: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   28: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   31: ldc -43
        //   33: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   36: aload_1
        //   37: invokevirtual 90	java/lang/String:hashCode	()I
        //   40: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   43: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   46: astore 11
        //   48: new 36	java/io/File
        //   51: dup
        //   52: aload 11
        //   54: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
        //   57: astore 12
        //   59: aload_0
        //   60: invokevirtual 221	com/quoord/tapatalkpro/bean/ForumStatus:getCookie	()Ljava/lang/String;
        //   63: astore 13
        //   65: aload_1
        //   66: ifnull +10 -> 76
        //   69: aload_1
        //   70: invokevirtual 222	java/lang/String:length	()I
        //   73: ifne +8 -> 81
        //   76: ldc 14
        //   78: astore_0
        //   79: aload_0
        //   80: areturn
        //   81: aload_1
        //   82: ldc -32
        //   84: ldc -30
        //   86: invokevirtual 230	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   89: ldc -24
        //   91: ldc -22
        //   93: invokevirtual 230	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   96: astore 9
        //   98: aload 9
        //   100: astore 10
        //   102: aload 9
        //   104: ldc -20
        //   106: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   109: ifne +36 -> 145
        //   112: aload 9
        //   114: astore 10
        //   116: aload 9
        //   118: ldc -15
        //   120: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   123: ifne +22 -> 145
        //   126: new 73	java/lang/StringBuilder
        //   129: dup
        //   130: ldc -20
        //   132: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   135: aload 9
        //   137: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   140: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   143: astore 10
        //   145: new 243	java/net/URL
        //   148: dup
        //   149: aload 10
        //   151: invokespecial 244	java/net/URL:<init>	(Ljava/lang/String;)V
        //   154: astore 9
        //   156: aload_1
        //   157: aload_2
        //   158: aload_3
        //   159: iload 4
        //   161: aload 5
        //   163: aload 6
        //   165: iload 7
        //   167: invokestatic 247	com/quoord/tapatalkpro/util/ImageInThreadLoader:logImage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V
        //   170: aload 10
        //   172: ldc -7
        //   174: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   177: ifeq +402 -> 579
        //   180: invokestatic 252	com/quoord/tapatalkpro/util/Util:trustAllHosts	()V
        //   183: aload 9
        //   185: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   188: checkcast 258	javax/net/ssl/HttpsURLConnection
        //   191: astore_1
        //   192: aload_1
        //   193: getstatic 262	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   196: invokevirtual 266	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   199: aload_1
        //   200: sipush 20000
        //   203: invokevirtual 272	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   206: aload_1
        //   207: ldc_w 273
        //   210: invokevirtual 276	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   213: aload_1
        //   214: ldc_w 278
        //   217: ldc_w 280
        //   220: invokevirtual 283	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   223: aload 9
        //   225: invokevirtual 284	java/net/URL:toString	()Ljava/lang/String;
        //   228: ldc_w 286
        //   231: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   234: ifeq +453 -> 687
        //   237: aload_1
        //   238: invokevirtual 289	java/net/HttpURLConnection:getResponseCode	()I
        //   241: istore 4
        //   243: iload 4
        //   245: sipush 302
        //   248: if_icmpeq +27 -> 275
        //   251: iload 4
        //   253: sipush 301
        //   256: if_icmpeq +19 -> 275
        //   259: iload 4
        //   261: sipush 303
        //   264: if_icmpeq +11 -> 275
        //   267: iload 4
        //   269: sipush 307
        //   272: if_icmpne +337 -> 609
        //   275: aload_1
        //   276: invokevirtual 293	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
        //   279: astore_3
        //   280: aload_3
        //   281: invokevirtual 284	java/net/URL:toString	()Ljava/lang/String;
        //   284: ldc_w 286
        //   287: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   290: ifeq +301 -> 591
        //   293: aload_3
        //   294: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   297: checkcast 268	java/net/HttpURLConnection
        //   300: astore_1
        //   301: aload_1
        //   302: astore_2
        //   303: aload_3
        //   304: invokevirtual 284	java/net/URL:toString	()Ljava/lang/String;
        //   307: ldc -7
        //   309: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   312: ifeq +67 -> 379
        //   315: aload_1
        //   316: invokevirtual 289	java/net/HttpURLConnection:getResponseCode	()I
        //   319: istore 4
        //   321: iload 4
        //   323: sipush 302
        //   326: if_icmpeq +27 -> 353
        //   329: iload 4
        //   331: sipush 301
        //   334: if_icmpeq +19 -> 353
        //   337: iload 4
        //   339: sipush 303
        //   342: if_icmpeq +11 -> 353
        //   345: iload 4
        //   347: sipush 307
        //   350: if_icmpne +292 -> 642
        //   353: aload_1
        //   354: invokevirtual 293	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
        //   357: astore_1
        //   358: aload_1
        //   359: invokevirtual 284	java/net/URL:toString	()Ljava/lang/String;
        //   362: ldc_w 286
        //   365: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   368: ifeq +256 -> 624
        //   371: aload_1
        //   372: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   375: checkcast 268	java/net/HttpURLConnection
        //   378: astore_2
        //   379: aload_2
        //   380: sipush 20000
        //   383: invokevirtual 272	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   386: aload_2
        //   387: ldc_w 273
        //   390: invokevirtual 276	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   393: aload_2
        //   394: iconst_1
        //   395: invokevirtual 297	java/net/HttpURLConnection:setDoInput	(Z)V
        //   398: aload 13
        //   400: ifnull +22 -> 422
        //   403: aload 13
        //   405: invokevirtual 222	java/lang/String:length	()I
        //   408: ifle +14 -> 422
        //   411: aload_2
        //   412: ldc_w 299
        //   415: aload_0
        //   416: invokevirtual 221	com/quoord/tapatalkpro/bean/ForumStatus:getCookie	()Ljava/lang/String;
        //   419: invokevirtual 283	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   422: aload_0
        //   423: ifnull +14 -> 437
        //   426: aload_2
        //   427: ldc_w 301
        //   430: aload_0
        //   431: invokevirtual 304	com/quoord/tapatalkpro/bean/ForumStatus:getUrl	()Ljava/lang/String;
        //   434: invokevirtual 283	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   437: aload 8
        //   439: aload_2
        //   440: aload_0
        //   441: invokestatic 310	com/quoord/tapatalkpro/util/UserAgent:setHTTPURLConn	(Landroid/content/Context;Ljava/net/HttpURLConnection;Lcom/quoord/tools/ForumHttpStatus;)V
        //   444: aload_0
        //   445: ifnull +20 -> 465
        //   448: aload_0
        //   449: invokevirtual 313	com/quoord/tapatalkpro/bean/ForumStatus:isContentType	()Z
        //   452: ifeq +13 -> 465
        //   455: aload_2
        //   456: ldc_w 315
        //   459: ldc_w 317
        //   462: invokevirtual 283	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   465: aload_0
        //   466: ifnull +20 -> 486
        //   469: aload_0
        //   470: invokevirtual 320	com/quoord/tapatalkpro/bean/ForumStatus:isRequestZip	()Z
        //   473: ifeq +13 -> 486
        //   476: aload_2
        //   477: ldc_w 322
        //   480: ldc_w 324
        //   483: invokevirtual 283	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   486: aload_2
        //   487: ldc_w 278
        //   490: ldc_w 326
        //   493: invokevirtual 283	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   496: aload_2
        //   497: invokevirtual 329	java/net/HttpURLConnection:connect	()V
        //   500: new 331	java/io/DataInputStream
        //   503: dup
        //   504: aload_2
        //   505: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   508: invokespecial 338	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
        //   511: astore_0
        //   512: new 340	java/io/FileOutputStream
        //   515: dup
        //   516: aload 12
        //   518: invokespecial 341	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   521: astore_1
        //   522: sipush 1024
        //   525: newarray <illegal type>
        //   527: astore_3
        //   528: aload_0
        //   529: aload_3
        //   530: invokevirtual 345	java/io/DataInputStream:read	([B)I
        //   533: istore 4
        //   535: iload 4
        //   537: iconst_m1
        //   538: if_icmpne +122 -> 660
        //   541: aload_2
        //   542: invokevirtual 348	java/net/HttpURLConnection:disconnect	()V
        //   545: aload_0
        //   546: invokevirtual 349	java/io/DataInputStream:close	()V
        //   549: aload_1
        //   550: invokevirtual 352	java/io/FileOutputStream:flush	()V
        //   553: aload_1
        //   554: invokevirtual 353	java/io/FileOutputStream:close	()V
        //   557: aload 11
        //   559: astore_0
        //   560: aload 12
        //   562: invokevirtual 43	java/io/File:exists	()Z
        //   565: ifne -486 -> 79
        //   568: ldc 14
        //   570: areturn
        //   571: astore_0
        //   572: aload_0
        //   573: invokevirtual 354	java/net/MalformedURLException:printStackTrace	()V
        //   576: ldc 14
        //   578: areturn
        //   579: aload 9
        //   581: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   584: checkcast 268	java/net/HttpURLConnection
        //   587: astore_1
        //   588: goto -389 -> 199
        //   591: aload_3
        //   592: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   595: checkcast 258	javax/net/ssl/HttpsURLConnection
        //   598: astore_1
        //   599: aload_1
        //   600: getstatic 262	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   603: invokevirtual 266	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   606: goto -305 -> 301
        //   609: aload 9
        //   611: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   614: checkcast 268	java/net/HttpURLConnection
        //   617: astore_1
        //   618: aload 9
        //   620: astore_3
        //   621: goto -320 -> 301
        //   624: aload_1
        //   625: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   628: checkcast 258	javax/net/ssl/HttpsURLConnection
        //   631: astore_2
        //   632: aload_2
        //   633: getstatic 262	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   636: invokevirtual 266	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   639: goto -260 -> 379
        //   642: aload_3
        //   643: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   646: checkcast 258	javax/net/ssl/HttpsURLConnection
        //   649: astore_2
        //   650: aload_2
        //   651: getstatic 262	com/quoord/tapatalkpro/util/Util:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
        //   654: invokevirtual 266	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   657: goto -278 -> 379
        //   660: aload_1
        //   661: aload_3
        //   662: iconst_0
        //   663: iload 4
        //   665: invokevirtual 358	java/io/FileOutputStream:write	([BII)V
        //   668: goto -140 -> 528
        //   671: astore_0
        //   672: ldc 14
        //   674: areturn
        //   675: astore_0
        //   676: ldc 14
        //   678: areturn
        //   679: astore_0
        //   680: goto -4 -> 676
        //   683: astore_0
        //   684: goto -12 -> 672
        //   687: aload 9
        //   689: astore_3
        //   690: goto -389 -> 301
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	693	0	paramForumStatus	ForumStatus
        //   0	693	1	paramString1	String
        //   0	693	2	paramString2	String
        //   0	693	3	paramString3	String
        //   0	693	4	paramInt1	int
        //   0	693	5	paramString4	String
        //   0	693	6	paramString5	String
        //   0	693	7	paramInt2	int
        //   0	693	8	paramContext	Context
        //   96	592	9	localObject1	Object
        //   100	71	10	localObject2	Object
        //   46	512	11	str1	String
        //   57	504	12	localFile	File
        //   63	341	13	str2	String
        // Exception table:
        //   from	to	target	type
        //   145	156	571	java/net/MalformedURLException
        //   280	301	671	java/net/SocketTimeoutException
        //   303	321	671	java/net/SocketTimeoutException
        //   353	379	671	java/net/SocketTimeoutException
        //   379	398	671	java/net/SocketTimeoutException
        //   403	422	671	java/net/SocketTimeoutException
        //   426	437	671	java/net/SocketTimeoutException
        //   437	444	671	java/net/SocketTimeoutException
        //   448	465	671	java/net/SocketTimeoutException
        //   469	486	671	java/net/SocketTimeoutException
        //   486	528	671	java/net/SocketTimeoutException
        //   528	535	671	java/net/SocketTimeoutException
        //   541	557	671	java/net/SocketTimeoutException
        //   591	606	671	java/net/SocketTimeoutException
        //   624	639	671	java/net/SocketTimeoutException
        //   642	657	671	java/net/SocketTimeoutException
        //   660	668	671	java/net/SocketTimeoutException
        //   170	199	675	java/lang/Exception
        //   199	243	675	java/lang/Exception
        //   275	280	675	java/lang/Exception
        //   579	588	675	java/lang/Exception
        //   609	618	675	java/lang/Exception
        //   280	301	679	java/lang/Exception
        //   303	321	679	java/lang/Exception
        //   353	379	679	java/lang/Exception
        //   379	398	679	java/lang/Exception
        //   403	422	679	java/lang/Exception
        //   426	437	679	java/lang/Exception
        //   437	444	679	java/lang/Exception
        //   448	465	679	java/lang/Exception
        //   469	486	679	java/lang/Exception
        //   486	528	679	java/lang/Exception
        //   528	535	679	java/lang/Exception
        //   541	557	679	java/lang/Exception
        //   591	606	679	java/lang/Exception
        //   624	639	679	java/lang/Exception
        //   642	657	679	java/lang/Exception
        //   660	668	679	java/lang/Exception
        //   170	199	683	java/net/SocketTimeoutException
        //   199	243	683	java/net/SocketTimeoutException
        //   275	280	683	java/net/SocketTimeoutException
        //   579	588	683	java/net/SocketTimeoutException
        //   609	618	683	java/net/SocketTimeoutException
    }

    public static void init() {
        localStrCash = new HashMap();
        new ArrayBlockingQueue(8);
    }

    private static void logImage(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2) {
        JSONObject localJSONObject;
        if (paramString2 != null) {
            localJSONObject = new JSONObject();
        }
        try {
            localJSONObject.put("sfid", paramString3);
            localJSONObject.put("tid", paramString2);
            localJSONObject.put("title", URLEncoder.encode(paramString5));
            localJSONObject.put("pid", paramString4);
            localJSONObject.put("post_time", paramInt1);
            localJSONObject.put("post_level", paramInt2);
            localJSONObject.put("url", paramString1);
            image_log.put(localJSONObject);
            return;
        } catch (JSONException paramString1) {
            for (; ; ) {
                paramString1.printStackTrace();
            }
        }
    }

    public static abstract interface ImageCallBack {
        public abstract void imageLoad(ImageInThread paramImageInThread, String paramString1, String paramString2, String paramString3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ImageInThreadLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */