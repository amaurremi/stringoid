package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

class BridgeMMMedia
        extends MMJSObject {
    private static Object m;
    MediaScannerConnection a;
    private String d = "isSourceTypeAvailable";
    private String e = "availableSourceTypes";
    private String f = "getPicture";
    private String g = "writeToPhotoLibrary";
    private String h = "playVideo";
    private String i = "stopAudio";
    private String j = "getDeviceVolume";
    private String k = "playAudio";
    private String l = "playSound";

    private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
        float f1 = (paramBitmap.getWidth() - paramInt1) / 2;
        float f2 = (paramBitmap.getHeight() - paramInt2) / 2;
        return a(paramBitmap, (int) f1, (int) f2, paramInt1, paramInt2);
    }

    private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3) {
        return Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, true);
    }

    private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    static Bitmap a(Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2, int paramInt3) {
        float f1 = paramInt1 / paramBitmap.getWidth();
        float f2 = paramInt2 / paramBitmap.getHeight();
        if (paramString.equals("Center")) {
            return a(paramBitmap, paramInt1, paramInt2);
        }
        if (paramString.equals("ScaleToAspectFit")) {
            f1 = Math.min(f1, f2);
            return a(paramBitmap, (int) (paramBitmap.getWidth() * f1), (int) (f1 * paramBitmap.getHeight()), paramInt3);
        }
        if (paramString.equals("ScaleToAspectFill")) {
            f1 = Math.max(f1, f2);
            return a(a(paramBitmap, (int) (paramBitmap.getWidth() * f1), (int) (f1 * paramBitmap.getHeight()), paramInt3), 0, 0, paramInt1, paramInt2);
        }
        return a(paramBitmap, paramInt1, paramInt2, paramInt3);
    }

    private void a(String paramString) {
        Context localContext = (Context) this.b.get();
        if (localContext != null) {
            this.a = new MediaScannerConnection(localContext.getApplicationContext(), new BridgeMMMedia .1
            (this, paramString));
            if (this.a != null) {
                this.a.connect();
            }
        }
    }

    /* Error */
    private static final byte[] a(File paramFile, int paramInt1, int paramInt2, String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 11
        //   3: new 149	java/io/FileInputStream
        //   6: dup
        //   7: aload_0
        //   8: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   11: astore 7
        //   13: new 154	android/graphics/BitmapFactory$Options
        //   16: dup
        //   17: invokespecial 155	android/graphics/BitmapFactory$Options:<init>	()V
        //   20: astore 10
        //   22: aload 10
        //   24: iconst_1
        //   25: putfield 159	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   28: aload 7
        //   30: aconst_null
        //   31: aload 10
        //   33: invokestatic 165	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   36: pop
        //   37: aload 10
        //   39: getfield 169	android/graphics/BitmapFactory$Options:outHeight	I
        //   42: istore 5
        //   44: aload 10
        //   46: getfield 172	android/graphics/BitmapFactory$Options:outWidth	I
        //   49: istore 6
        //   51: iload 5
        //   53: iload_2
        //   54: if_icmpgt +9 -> 63
        //   57: iload 6
        //   59: iload_1
        //   60: if_icmple +510 -> 570
        //   63: iload 6
        //   65: iload 5
        //   67: if_icmple +190 -> 257
        //   70: iload 5
        //   72: i2f
        //   73: iload_2
        //   74: i2f
        //   75: fdiv
        //   76: invokestatic 176	java/lang/Math:round	(F)I
        //   79: istore 5
        //   81: new 149	java/io/FileInputStream
        //   84: dup
        //   85: aload_0
        //   86: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   89: astore_0
        //   90: aload_0
        //   91: astore 9
        //   93: aload 7
        //   95: astore 8
        //   97: aload 10
        //   99: iconst_0
        //   100: putfield 159	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   103: aload_0
        //   104: astore 9
        //   106: aload 7
        //   108: astore 8
        //   110: aload 10
        //   112: iload 5
        //   114: putfield 179	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   117: aload_0
        //   118: astore 9
        //   120: aload 7
        //   122: astore 8
        //   124: aload_0
        //   125: aconst_null
        //   126: aload 10
        //   128: invokestatic 165	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   131: astore 10
        //   133: aload 7
        //   135: ifnull +8 -> 143
        //   138: aload 7
        //   140: invokevirtual 182	java/io/FileInputStream:close	()V
        //   143: aload_0
        //   144: ifnull +7 -> 151
        //   147: aload_0
        //   148: invokevirtual 182	java/io/FileInputStream:close	()V
        //   151: aload 10
        //   153: astore_0
        //   154: aload 11
        //   156: astore 7
        //   158: aload_0
        //   159: ifnull +95 -> 254
        //   162: aload_0
        //   163: aload_3
        //   164: iload_1
        //   165: iload_2
        //   166: iconst_1
        //   167: invokestatic 184	com/millennialmedia/android/BridgeMMMedia:a	(Landroid/graphics/Bitmap;Ljava/lang/String;III)Landroid/graphics/Bitmap;
        //   170: astore 9
        //   172: new 186	java/io/ByteArrayOutputStream
        //   175: dup
        //   176: invokespecial 187	java/io/ByteArrayOutputStream:<init>	()V
        //   179: astore 8
        //   181: aload 8
        //   183: astore 7
        //   185: aload_3
        //   186: ldc -67
        //   188: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   191: ifeq +200 -> 391
        //   194: aload 8
        //   196: astore 7
        //   198: aload_0
        //   199: getstatic 195	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   202: bipush 100
        //   204: aload 8
        //   206: invokevirtual 199	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   209: pop
        //   210: aload 8
        //   212: astore 7
        //   214: aload 8
        //   216: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   219: astore_3
        //   220: aload_0
        //   221: ifnull +7 -> 228
        //   224: aload_0
        //   225: invokevirtual 206	android/graphics/Bitmap:recycle	()V
        //   228: aload 9
        //   230: ifnull +8 -> 238
        //   233: aload 9
        //   235: invokevirtual 206	android/graphics/Bitmap:recycle	()V
        //   238: aload_3
        //   239: astore 7
        //   241: aload 8
        //   243: ifnull +11 -> 254
        //   246: aload 8
        //   248: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
        //   251: aload_3
        //   252: astore 7
        //   254: aload 7
        //   256: areturn
        //   257: iload 6
        //   259: i2f
        //   260: iload_1
        //   261: i2f
        //   262: fdiv
        //   263: fstore 4
        //   265: fload 4
        //   267: invokestatic 176	java/lang/Math:round	(F)I
        //   270: istore 5
        //   272: goto -191 -> 81
        //   275: astore_0
        //   276: ldc -47
        //   278: ldc -45
        //   280: aload_0
        //   281: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   284: aload 10
        //   286: astore_0
        //   287: goto -133 -> 154
        //   290: astore 10
        //   292: aconst_null
        //   293: astore_0
        //   294: aconst_null
        //   295: astore 7
        //   297: aload_0
        //   298: astore 9
        //   300: aload 7
        //   302: astore 8
        //   304: ldc -47
        //   306: ldc -38
        //   308: aload 10
        //   310: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   313: aload 7
        //   315: ifnull +8 -> 323
        //   318: aload 7
        //   320: invokevirtual 182	java/io/FileInputStream:close	()V
        //   323: aload_0
        //   324: ifnull +7 -> 331
        //   327: aload_0
        //   328: invokevirtual 182	java/io/FileInputStream:close	()V
        //   331: aconst_null
        //   332: astore_0
        //   333: goto -179 -> 154
        //   336: astore_0
        //   337: ldc -47
        //   339: ldc -45
        //   341: aload_0
        //   342: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   345: aconst_null
        //   346: astore_0
        //   347: goto -193 -> 154
        //   350: astore_0
        //   351: aconst_null
        //   352: astore 9
        //   354: aconst_null
        //   355: astore 7
        //   357: aload 7
        //   359: ifnull +8 -> 367
        //   362: aload 7
        //   364: invokevirtual 182	java/io/FileInputStream:close	()V
        //   367: aload 9
        //   369: ifnull +8 -> 377
        //   372: aload 9
        //   374: invokevirtual 182	java/io/FileInputStream:close	()V
        //   377: aload_0
        //   378: athrow
        //   379: astore_3
        //   380: ldc -47
        //   382: ldc -45
        //   384: aload_3
        //   385: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   388: goto -11 -> 377
        //   391: aload 8
        //   393: astore 7
        //   395: aload 9
        //   397: getstatic 195	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   400: bipush 100
        //   402: aload 8
        //   404: invokevirtual 199	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   407: pop
        //   408: goto -198 -> 210
        //   411: astore 7
        //   413: aload 8
        //   415: astore_3
        //   416: aload 7
        //   418: astore 8
        //   420: aload_3
        //   421: astore 7
        //   423: ldc -47
        //   425: ldc -36
        //   427: aload 8
        //   429: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   432: aload_0
        //   433: ifnull +7 -> 440
        //   436: aload_0
        //   437: invokevirtual 206	android/graphics/Bitmap:recycle	()V
        //   440: aload 9
        //   442: ifnull +8 -> 450
        //   445: aload 9
        //   447: invokevirtual 206	android/graphics/Bitmap:recycle	()V
        //   450: aload 11
        //   452: astore 7
        //   454: aload_3
        //   455: ifnull -201 -> 254
        //   458: aload_3
        //   459: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
        //   462: aconst_null
        //   463: areturn
        //   464: astore_0
        //   465: ldc -47
        //   467: ldc -45
        //   469: aload_0
        //   470: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   473: aconst_null
        //   474: areturn
        //   475: astore_0
        //   476: ldc -47
        //   478: ldc -45
        //   480: aload_0
        //   481: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   484: aload_3
        //   485: areturn
        //   486: astore_3
        //   487: aconst_null
        //   488: astore 7
        //   490: aload_0
        //   491: ifnull +7 -> 498
        //   494: aload_0
        //   495: invokevirtual 206	android/graphics/Bitmap:recycle	()V
        //   498: aload 9
        //   500: ifnull +8 -> 508
        //   503: aload 9
        //   505: invokevirtual 206	android/graphics/Bitmap:recycle	()V
        //   508: aload 7
        //   510: ifnull +8 -> 518
        //   513: aload 7
        //   515: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
        //   518: aload_3
        //   519: athrow
        //   520: astore_0
        //   521: ldc -47
        //   523: ldc -45
        //   525: aload_0
        //   526: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   529: goto -11 -> 518
        //   532: astore_3
        //   533: goto -43 -> 490
        //   536: astore 8
        //   538: aconst_null
        //   539: astore_3
        //   540: goto -120 -> 420
        //   543: astore_0
        //   544: aconst_null
        //   545: astore 9
        //   547: goto -190 -> 357
        //   550: astore_0
        //   551: aload 8
        //   553: astore 7
        //   555: goto -198 -> 357
        //   558: astore 10
        //   560: aconst_null
        //   561: astore_0
        //   562: goto -265 -> 297
        //   565: astore 10
        //   567: goto -270 -> 297
        //   570: iconst_1
        //   571: istore 5
        //   573: goto -492 -> 81
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	576	0	paramFile	File
        //   0	576	1	paramInt1	int
        //   0	576	2	paramInt2	int
        //   0	576	3	paramString	String
        //   263	3	4	f1	float
        //   42	530	5	n	int
        //   49	209	6	i1	int
        //   11	383	7	localObject1	Object
        //   411	6	7	localException1	Exception
        //   421	133	7	localObject2	Object
        //   95	333	8	localObject3	Object
        //   536	16	8	localException2	Exception
        //   91	455	9	localObject4	Object
        //   20	265	10	localObject5	Object
        //   290	19	10	localFileNotFoundException1	java.io.FileNotFoundException
        //   558	1	10	localFileNotFoundException2	java.io.FileNotFoundException
        //   565	1	10	localFileNotFoundException3	java.io.FileNotFoundException
        //   1	450	11	localObject6	Object
        // Exception table:
        //   from	to	target	type
        //   138	143	275	java/io/IOException
        //   147	151	275	java/io/IOException
        //   3	13	290	java/io/FileNotFoundException
        //   318	323	336	java/io/IOException
        //   327	331	336	java/io/IOException
        //   3	13	350	finally
        //   362	367	379	java/io/IOException
        //   372	377	379	java/io/IOException
        //   185	194	411	java/lang/Exception
        //   198	210	411	java/lang/Exception
        //   214	220	411	java/lang/Exception
        //   395	408	411	java/lang/Exception
        //   436	440	464	java/lang/Exception
        //   445	450	464	java/lang/Exception
        //   458	462	464	java/lang/Exception
        //   224	228	475	java/lang/Exception
        //   233	238	475	java/lang/Exception
        //   246	251	475	java/lang/Exception
        //   172	181	486	finally
        //   494	498	520	java/lang/Exception
        //   503	508	520	java/lang/Exception
        //   513	518	520	java/lang/Exception
        //   185	194	532	finally
        //   198	210	532	finally
        //   214	220	532	finally
        //   395	408	532	finally
        //   423	432	532	finally
        //   172	181	536	java/lang/Exception
        //   13	51	543	finally
        //   70	81	543	finally
        //   81	90	543	finally
        //   265	272	543	finally
        //   97	103	550	finally
        //   110	117	550	finally
        //   124	133	550	finally
        //   304	313	550	finally
        //   13	51	558	java/io/FileNotFoundException
        //   70	81	558	java/io/FileNotFoundException
        //   81	90	558	java/io/FileNotFoundException
        //   265	272	558	java/io/FileNotFoundException
        //   97	103	565	java/io/FileNotFoundException
        //   110	117	565	java/io/FileNotFoundException
        //   124	133	565	java/io/FileNotFoundException
    }

    private boolean b() {
        Context localContext = (Context) this.b.get();
        if ((localContext != null) && (localContext.getPackageManager().checkPermission("android.permission.CAMERA", localContext.getPackageName()) == 0)) {
            Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
            return localContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0;
        }
        return false;
    }

    private boolean c() {
        Context localContext = (Context) this.b.get();
        if (localContext != null) {
            Intent localIntent = new Intent();
            localIntent.setType("image/*");
            localIntent.setAction("android.intent.action.GET_CONTENT");
            return localContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0;
        }
        return false;
    }

    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if (this.d.equals(paramString)) {
            localMMJSResponse = isSourceTypeAvailable(paramMap);
        }
        do {
            return localMMJSResponse;
            if (this.e.equals(paramString)) {
                return availableSourceTypes(paramMap);
            }
            if (this.f.equals(paramString)) {
                return getPicture(paramMap);
            }
            if (this.g.equals(paramString)) {
                return writeToPhotoLibrary(paramMap);
            }
            if (this.h.equals(paramString)) {
                return playVideo(paramMap);
            }
            if (this.i.equals(paramString)) {
                return stopAudio(paramMap);
            }
            if (this.j.equals(paramString)) {
                return getDeviceVolume(paramMap);
            }
            if (this.k.equals(paramString)) {
                return playAudio(paramMap);
            }
        } while (!this.l.equals(paramString));
        return playSound(paramMap);
    }

    public MMJSResponse availableSourceTypes(Map<String, String> paramMap) {
        paramMap = new JSONArray();
        if (b()) {
            paramMap.put("Camera");
        }
        if (c()) {
            paramMap.put("Photo Library");
        }
        MMJSResponse localMMJSResponse = new MMJSResponse();
        localMMJSResponse.c = 1;
        localMMJSResponse.d = paramMap;
        return localMMJSResponse;
    }

    public MMJSResponse getDeviceVolume(Map<String, String> paramMap) {
        paramMap = (Context) this.b.get();
        if (paramMap != null) {
            int n = MMSDK.s(paramMap);
            paramMap = MMJSResponse.a();
            paramMap.d = Integer.valueOf(n);
            return paramMap;
        }
        return MMJSResponse.b("no volume available");
    }

    /* Error */
    public MMJSResponse getPicture(Map<String, String> paramMap) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 114	com/millennialmedia/android/BridgeMMMedia:b	Ljava/lang/ref/WeakReference;
        //   6: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   9: checkcast 121	android/content/Context
        //   12: astore 6
        //   14: aload_1
        //   15: ldc_w 333
        //   18: invokeinterface 338 2 0
        //   23: checkcast 85	java/lang/String
        //   26: astore 7
        //   28: aload_1
        //   29: ldc_w 340
        //   32: invokeinterface 338 2 0
        //   37: checkcast 85	java/lang/String
        //   40: astore 8
        //   42: aload_1
        //   43: ldc_w 342
        //   46: invokeinterface 338 2 0
        //   51: checkcast 85	java/lang/String
        //   54: astore 9
        //   56: aload_1
        //   57: ldc_w 344
        //   60: invokeinterface 338 2 0
        //   65: checkcast 85	java/lang/String
        //   68: astore 5
        //   70: aload 5
        //   72: astore_1
        //   73: aload 5
        //   75: ifnonnull +309 -> 384
        //   78: ldc -67
        //   80: astore_1
        //   81: goto +303 -> 384
        //   84: ldc_w 346
        //   87: invokestatic 331	com/millennialmedia/android/MMJSResponse:b	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   90: astore_1
        //   91: aload_0
        //   92: monitorexit
        //   93: aload_1
        //   94: areturn
        //   95: aload 8
        //   97: invokestatic 352	java/lang/Float:parseFloat	(Ljava/lang/String;)F
        //   100: f2i
        //   101: istore_2
        //   102: aload 9
        //   104: invokestatic 352	java/lang/Float:parseFloat	(Ljava/lang/String;)F
        //   107: f2i
        //   108: istore_3
        //   109: iload_2
        //   110: iload_3
        //   111: imul
        //   112: ldc_w 353
        //   115: if_icmple +13 -> 128
        //   118: ldc_w 355
        //   121: invokestatic 331	com/millennialmedia/android/MMJSResponse:b	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   124: astore_1
        //   125: goto -34 -> 91
        //   128: aload 6
        //   130: ifnull +249 -> 379
        //   133: aload 7
        //   135: ifnull +244 -> 379
        //   138: new 357	java/io/File
        //   141: dup
        //   142: aload 6
        //   144: invokestatic 362	com/millennialmedia/android/AdCache:h	(Landroid/content/Context;)Ljava/io/File;
        //   147: new 364	java/lang/StringBuilder
        //   150: dup
        //   151: invokespecial 365	java/lang/StringBuilder:<init>	()V
        //   154: ldc_w 367
        //   157: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: invokestatic 377	java/lang/System:currentTimeMillis	()J
        //   163: invokestatic 380	java/lang/String:valueOf	(J)Ljava/lang/String;
        //   166: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: ldc_w 382
        //   172: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   178: invokespecial 388	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   181: astore 5
        //   183: aload 7
        //   185: ldc_w 295
        //   188: invokevirtual 392	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   191: ifeq +10 -> 201
        //   194: aload_0
        //   195: invokespecial 293	com/millennialmedia/android/BridgeMMMedia:b	()Z
        //   198: ifne +36 -> 234
        //   201: aload 7
        //   203: ldc_w 303
        //   206: invokevirtual 392	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   209: ifne +14 -> 223
        //   212: aload 7
        //   214: ldc_w 394
        //   217: invokevirtual 392	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   220: ifeq +159 -> 379
        //   223: aload_0
        //   224: invokespecial 301	com/millennialmedia/android/BridgeMMMedia:c	()Z
        //   227: istore 4
        //   229: iload 4
        //   231: ifeq +148 -> 379
        //   234: new 396	java/lang/Object
        //   237: dup
        //   238: invokespecial 397	java/lang/Object:<init>	()V
        //   241: putstatic 109	com/millennialmedia/android/BridgeMMMedia:m	Ljava/lang/Object;
        //   244: getstatic 109	com/millennialmedia/android/BridgeMMMedia:m	Ljava/lang/Object;
        //   247: astore 8
        //   249: aload 8
        //   251: monitorenter
        //   252: aload 6
        //   254: aload 5
        //   256: aload 7
        //   258: invokestatic 402	com/millennialmedia/android/Utils$IntentUtils:a	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)V
        //   261: getstatic 109	com/millennialmedia/android/BridgeMMMedia:m	Ljava/lang/Object;
        //   264: invokevirtual 405	java/lang/Object:wait	()V
        //   267: aload 8
        //   269: monitorexit
        //   270: aconst_null
        //   271: putstatic 109	com/millennialmedia/android/BridgeMMMedia:m	Ljava/lang/Object;
        //   274: aload 5
        //   276: ifnull +103 -> 379
        //   279: aload 5
        //   281: invokevirtual 408	java/io/File:exists	()Z
        //   284: ifeq +95 -> 379
        //   287: aload 5
        //   289: invokevirtual 411	java/io/File:length	()J
        //   292: lconst_0
        //   293: lcmp
        //   294: ifle +85 -> 379
        //   297: aload 5
        //   299: iload_3
        //   300: iload_2
        //   301: aload_1
        //   302: invokestatic 413	com/millennialmedia/android/BridgeMMMedia:a	(Ljava/io/File;IILjava/lang/String;)[B
        //   305: astore 6
        //   307: aload 5
        //   309: invokevirtual 416	java/io/File:delete	()Z
        //   312: pop
        //   313: aload 6
        //   315: ifnull +64 -> 379
        //   318: new 305	com/millennialmedia/android/MMJSResponse
        //   321: dup
        //   322: invokespecial 306	com/millennialmedia/android/MMJSResponse:<init>	()V
        //   325: astore_1
        //   326: aload_1
        //   327: iconst_1
        //   328: putfield 308	com/millennialmedia/android/MMJSResponse:c	I
        //   331: aload_1
        //   332: aload 6
        //   334: putfield 419	com/millennialmedia/android/MMJSResponse:e	[B
        //   337: goto -246 -> 91
        //   340: astore_1
        //   341: aload_0
        //   342: monitorexit
        //   343: aload_1
        //   344: athrow
        //   345: astore 6
        //   347: aload 8
        //   349: monitorexit
        //   350: aload 6
        //   352: athrow
        //   353: astore 6
        //   355: ldc -47
        //   357: ldc_w 421
        //   360: aload 6
        //   362: invokestatic 216	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   365: aconst_null
        //   366: putstatic 109	com/millennialmedia/android/BridgeMMMedia:m	Ljava/lang/Object;
        //   369: goto -95 -> 274
        //   372: astore_1
        //   373: aconst_null
        //   374: putstatic 109	com/millennialmedia/android/BridgeMMMedia:m	Ljava/lang/Object;
        //   377: aload_1
        //   378: athrow
        //   379: aconst_null
        //   380: astore_1
        //   381: goto -290 -> 91
        //   384: aload 8
        //   386: ifnull -302 -> 84
        //   389: aload 9
        //   391: ifnonnull -296 -> 95
        //   394: goto -310 -> 84
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	397	0	this	BridgeMMMedia
        //   0	397	1	paramMap	Map<String, String>
        //   101	200	2	n	int
        //   108	192	3	i1	int
        //   227	3	4	bool	boolean
        //   68	240	5	localObject1	Object
        //   12	321	6	localObject2	Object
        //   345	6	6	localObject3	Object
        //   353	8	6	localException	Exception
        //   26	231	7	str1	String
        //   54	336	9	str2	String
        // Exception table:
        //   from	to	target	type
        //   2	70	340	finally
        //   84	91	340	finally
        //   95	109	340	finally
        //   118	125	340	finally
        //   138	201	340	finally
        //   201	223	340	finally
        //   223	229	340	finally
        //   270	274	340	finally
        //   279	313	340	finally
        //   318	337	340	finally
        //   365	369	340	finally
        //   373	379	340	finally
        //   252	270	345	finally
        //   347	350	345	finally
        //   234	252	353	java/lang/Exception
        //   350	353	353	java/lang/Exception
        //   234	252	372	finally
        //   350	353	372	finally
        //   355	365	372	finally
    }

    public MMJSResponse isSourceTypeAvailable(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("sourceType");
        if (paramMap != null) {
            if ((paramMap.equalsIgnoreCase("Camera")) && (b())) {
                return MMJSResponse.a("true");
            }
            if ((paramMap.equalsIgnoreCase("Photo Library")) && (c())) {
                return MMJSResponse.a("true");
            }
        }
        return MMJSResponse.b("false");
    }

    public MMJSResponse playAudio(Map<String, String> paramMap) {
        Object localObject = (Context) this.b.get();
        String str = (String) paramMap.get("path");
        if ((localObject != null) && (str != null)) {
            BridgeMMMedia.Audio localAudio = BridgeMMMedia.Audio.a((Context) localObject);
            if (localAudio == null) {
                return null;
            }
            if (localAudio.a()) {
                return MMJSResponse.b("Audio already playing.");
            }
            if (str.startsWith("http")) {
                return localAudio.a(Uri.parse(str), Boolean.parseBoolean((String) paramMap.get("repeat")));
            }
            localObject = AdCache.g((Context) localObject, str);
            if (((File) localObject).exists()) {
                return localAudio.a(Uri.fromFile((File) localObject), Boolean.parseBoolean((String) paramMap.get("repeat")));
            }
        }
        return null;
    }

    public MMJSResponse playSound(Map<String, String> paramMap) {
        if (this.b == null) {
            return null;
        }
        Object localObject = (Context) this.b.get();
        paramMap = (String) paramMap.get("path");
        if ((localObject != null) && (paramMap != null)) {
            paramMap = AdCache.g((Context) localObject, paramMap);
            if (paramMap.exists()) {
                localObject = BridgeMMMedia.Audio.a((Context) this.b.get());
                if (localObject != null) {
                    return ((BridgeMMMedia.Audio) localObject).a(paramMap);
                }
            }
        }
        return null;
    }

    public MMJSResponse playVideo(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        paramMap = (String) paramMap.get("path");
        if ((localContext != null) && (paramMap != null)) {
            if (paramMap.startsWith("http")) {
                Utils.IntentUtils.a(localContext, paramMap);
                return MMJSResponse.a(paramMap);
            }
            paramMap = AdCache.g(localContext, paramMap);
            if (paramMap.exists()) {
                Utils.IntentUtils.a(localContext, paramMap);
                return MMJSResponse.a(paramMap.getName());
            }
        }
        return null;
    }

    public MMJSResponse stopAudio(Map<String, String> paramMap) {
        if (this.b != null) {
            paramMap = BridgeMMMedia.Audio.a((Context) this.b.get());
            if (paramMap != null) {
                return paramMap.b();
            }
        }
        return null;
    }

    /* Error */
    public MMJSResponse writeToPhotoLibrary(Map<String, String> paramMap) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 114	com/millennialmedia/android/BridgeMMMedia:b	Ljava/lang/ref/WeakReference;
        //   6: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   9: checkcast 121	android/content/Context
        //   12: astore_2
        //   13: aload_1
        //   14: ldc_w 429
        //   17: invokeinterface 338 2 0
        //   22: checkcast 85	java/lang/String
        //   25: astore_3
        //   26: aload_2
        //   27: ifnull +162 -> 189
        //   30: aload_3
        //   31: invokestatic 486	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   34: ifne +155 -> 189
        //   37: aload_1
        //   38: ldc_w 429
        //   41: invokeinterface 338 2 0
        //   46: checkcast 85	java/lang/String
        //   49: invokestatic 449	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
        //   52: astore_1
        //   53: aload_1
        //   54: invokevirtual 489	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
        //   57: astore_3
        //   58: aload_1
        //   59: invokevirtual 492	android/net/Uri:getScheme	()Ljava/lang/String;
        //   62: astore 4
        //   64: aload 4
        //   66: ifnull +40 -> 106
        //   69: aload 4
        //   71: ldc_w 440
        //   74: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   77: ifeq +29 -> 106
        //   80: aload_1
        //   81: invokevirtual 493	android/net/Uri:toString	()Ljava/lang/String;
        //   84: ldc_w 495
        //   87: aload_3
        //   88: aload_2
        //   89: invokestatic 498	com/millennialmedia/android/AdCache:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Z
        //   92: ifne +14 -> 106
        //   95: ldc_w 500
        //   98: invokestatic 331	com/millennialmedia/android/MMJSResponse:b	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   101: astore_1
        //   102: aload_0
        //   103: monitorexit
        //   104: aload_1
        //   105: areturn
        //   106: aload_2
        //   107: ldc_w 495
        //   110: aload_1
        //   111: invokevirtual 489	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
        //   114: invokestatic 503	com/millennialmedia/android/AdCache:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
        //   117: astore_1
        //   118: aload_1
        //   119: invokevirtual 408	java/io/File:exists	()Z
        //   122: ifne +33 -> 155
        //   125: new 364	java/lang/StringBuilder
        //   128: dup
        //   129: invokespecial 365	java/lang/StringBuilder:<init>	()V
        //   132: ldc_w 505
        //   135: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: aload_1
        //   139: invokevirtual 508	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   142: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   145: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   148: invokestatic 331	com/millennialmedia/android/MMJSResponse:b	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   151: astore_1
        //   152: goto -50 -> 102
        //   155: aload_0
        //   156: aload_1
        //   157: invokevirtual 508	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   160: invokespecial 510	com/millennialmedia/android/BridgeMMMedia:a	(Ljava/lang/String;)V
        //   163: invokestatic 511	com/millennialmedia/android/AdCache:a	()Z
        //   166: ifne +13 -> 179
        //   169: ldc_w 513
        //   172: invokestatic 331	com/millennialmedia/android/MMJSResponse:b	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   175: astore_1
        //   176: goto -74 -> 102
        //   179: ldc_w 515
        //   182: invokestatic 425	com/millennialmedia/android/MMJSResponse:a	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   185: astore_1
        //   186: goto -84 -> 102
        //   189: aconst_null
        //   190: astore_1
        //   191: goto -89 -> 102
        //   194: astore_1
        //   195: aload_0
        //   196: monitorexit
        //   197: aload_1
        //   198: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	199	0	this	BridgeMMMedia
        //   0	199	1	paramMap	Map<String, String>
        //   12	95	2	localContext	Context
        //   25	63	3	str1	String
        //   62	8	4	str2	String
        // Exception table:
        //   from	to	target	type
        //   2	26	194	finally
        //   30	64	194	finally
        //   69	102	194	finally
        //   106	152	194	finally
        //   155	176	194	finally
        //   179	186	194	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */