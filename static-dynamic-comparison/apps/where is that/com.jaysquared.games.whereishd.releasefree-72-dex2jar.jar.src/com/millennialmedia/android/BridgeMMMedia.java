package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

class BridgeMMMedia
  extends MMJSObject
{
  private static final String PATH = "path";
  private static final String PICTURES = "Pictures";
  private static Object pickerActivityObject;
  MediaScannerConnection mediaScanner;
  
  private static Bitmap centerOfImage(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f1 = (paramBitmap.getWidth() - paramInt1) / 2;
    float f2 = (paramBitmap.getHeight() - paramInt2) / 2;
    return cropImage(paramBitmap, (int)f1, (int)f2, paramInt1, paramInt2);
  }
  
  private static Bitmap cropImage(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private boolean isCameraAvailable()
  {
    boolean bool2 = false;
    Context localContext = (Context)this.contextRef.get();
    boolean bool1 = bool2;
    if (localContext != null)
    {
      bool1 = bool2;
      if (localContext.getPackageManager().checkPermission("android.permission.CAMERA", localContext.getPackageName()) == 0)
      {
        Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        bool1 = bool2;
        if (localContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isPictureChooserAvailable()
  {
    boolean bool2 = false;
    Context localContext = (Context)this.contextRef.get();
    boolean bool1 = bool2;
    if (localContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.setType("image/*");
      localIntent.setAction("android.intent.action.GET_CONTENT");
      bool1 = bool2;
      if (localContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean moveFile(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1).getChannel();
      File localFile = paramFile2.getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramFile2.createNewFile();
      paramFile2 = new FileOutputStream(paramFile2).getChannel();
      paramFile1.transferTo(0L, paramFile1.size(), paramFile2);
      return true;
    }
    catch (Exception paramFile1)
    {
      paramFile1.printStackTrace();
    }
    return false;
  }
  
  private static Bitmap resizeImage(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    return Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, true);
  }
  
  static Bitmap resizeImage(Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = paramInt1 / paramBitmap.getWidth();
    float f2 = paramInt2 / paramBitmap.getHeight();
    if (paramString.equals("Center")) {
      return centerOfImage(paramBitmap, paramInt1, paramInt2);
    }
    if (paramString.equals("ScaleToAspectFit"))
    {
      f1 = Math.min(f1, f2);
      return resizeImage(paramBitmap, (int)(paramBitmap.getWidth() * f1), (int)(paramBitmap.getHeight() * f1), paramInt3);
    }
    if (paramString.equals("ScaleToAspectFill"))
    {
      f1 = Math.max(f1, f2);
      return cropImage(resizeImage(paramBitmap, (int)(paramBitmap.getWidth() * f1), (int)(paramBitmap.getHeight() * f1), paramInt3), 0, 0, paramInt1, paramInt2);
    }
    return resizeImage(paramBitmap, paramInt1, paramInt2, paramInt3);
  }
  
  /* Error */
  private static final byte[] scaleBitmapToBytes(File paramFile, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 10
    //   15: new 127	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore 8
    //   25: new 205	android/graphics/BitmapFactory$Options
    //   28: dup
    //   29: invokespecial 206	android/graphics/BitmapFactory$Options:<init>	()V
    //   32: astore 12
    //   34: aload 12
    //   36: iconst_1
    //   37: putfield 210	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   40: aload 8
    //   42: aconst_null
    //   43: aload 12
    //   45: invokestatic 216	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload 12
    //   51: getfield 220	android/graphics/BitmapFactory$Options:outHeight	I
    //   54: istore 6
    //   56: aload 12
    //   58: getfield 223	android/graphics/BitmapFactory$Options:outWidth	I
    //   61: istore 7
    //   63: iconst_1
    //   64: istore 5
    //   66: iload 6
    //   68: iload_2
    //   69: if_icmpgt +9 -> 78
    //   72: iload 7
    //   74: iload_1
    //   75: if_icmple +21 -> 96
    //   78: iload 7
    //   80: iload 6
    //   82: if_icmple +163 -> 245
    //   85: iload 6
    //   87: i2f
    //   88: iload_2
    //   89: i2f
    //   90: fdiv
    //   91: invokestatic 227	java/lang/Math:round	(F)I
    //   94: istore 5
    //   96: new 127	java/io/FileInputStream
    //   99: dup
    //   100: aload_0
    //   101: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: astore_0
    //   105: aload 12
    //   107: iconst_0
    //   108: putfield 210	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: aload 12
    //   113: iload 5
    //   115: putfield 230	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   118: aload_0
    //   119: aconst_null
    //   120: aload 12
    //   122: invokestatic 216	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   125: astore 9
    //   127: aload 8
    //   129: ifnull +8 -> 137
    //   132: aload 8
    //   134: invokevirtual 233	java/io/FileInputStream:close	()V
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 233	java/io/FileInputStream:close	()V
    //   145: aload 9
    //   147: astore 8
    //   149: aconst_null
    //   150: astore_0
    //   151: aload 8
    //   153: ifnull +90 -> 243
    //   156: aload 8
    //   158: aload_3
    //   159: iload_1
    //   160: iload_2
    //   161: iconst_1
    //   162: invokestatic 235	com/millennialmedia/android/BridgeMMMedia:resizeImage	(Landroid/graphics/Bitmap;Ljava/lang/String;III)Landroid/graphics/Bitmap;
    //   165: astore 11
    //   167: aconst_null
    //   168: astore_0
    //   169: aconst_null
    //   170: astore 10
    //   172: new 237	java/io/ByteArrayOutputStream
    //   175: dup
    //   176: invokespecial 238	java/io/ByteArrayOutputStream:<init>	()V
    //   179: astore 9
    //   181: aload_3
    //   182: ldc -16
    //   184: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +157 -> 344
    //   190: aload 8
    //   192: getstatic 246	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   195: bipush 100
    //   197: aload 9
    //   199: invokevirtual 250	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   202: pop
    //   203: aload 9
    //   205: invokevirtual 254	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   208: astore_3
    //   209: aload 8
    //   211: ifnull +8 -> 219
    //   214: aload 8
    //   216: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   219: aload 11
    //   221: ifnull +8 -> 229
    //   224: aload 11
    //   226: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   229: aload_3
    //   230: astore_0
    //   231: aload 9
    //   233: ifnull +10 -> 243
    //   236: aload 9
    //   238: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   241: aload_3
    //   242: astore_0
    //   243: aload_0
    //   244: areturn
    //   245: iload 7
    //   247: i2f
    //   248: iload_1
    //   249: i2f
    //   250: fdiv
    //   251: fstore 4
    //   253: fload 4
    //   255: invokestatic 227	java/lang/Math:round	(F)I
    //   258: istore 5
    //   260: goto -164 -> 96
    //   263: astore_0
    //   264: aload 9
    //   266: astore 8
    //   268: goto -119 -> 149
    //   271: astore_0
    //   272: aload 11
    //   274: astore 9
    //   276: aload 13
    //   278: astore_0
    //   279: aload_0
    //   280: ifnull +7 -> 287
    //   283: aload_0
    //   284: invokevirtual 233	java/io/FileInputStream:close	()V
    //   287: aload 10
    //   289: astore 8
    //   291: aload 9
    //   293: ifnull -144 -> 149
    //   296: aload 9
    //   298: invokevirtual 233	java/io/FileInputStream:close	()V
    //   301: aload 10
    //   303: astore 8
    //   305: goto -156 -> 149
    //   308: astore_0
    //   309: aload 10
    //   311: astore 8
    //   313: goto -164 -> 149
    //   316: astore_3
    //   317: aload 9
    //   319: astore 8
    //   321: aload 12
    //   323: astore_0
    //   324: aload_0
    //   325: ifnull +7 -> 332
    //   328: aload_0
    //   329: invokevirtual 233	java/io/FileInputStream:close	()V
    //   332: aload 8
    //   334: ifnull +8 -> 342
    //   337: aload 8
    //   339: invokevirtual 233	java/io/FileInputStream:close	()V
    //   342: aload_3
    //   343: athrow
    //   344: aload 11
    //   346: getstatic 246	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   349: bipush 100
    //   351: aload 9
    //   353: invokevirtual 250	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   356: pop
    //   357: goto -154 -> 203
    //   360: astore_0
    //   361: aload 9
    //   363: astore_3
    //   364: aload_0
    //   365: astore 9
    //   367: aconst_null
    //   368: astore 10
    //   370: aload_3
    //   371: astore_0
    //   372: aload 9
    //   374: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   377: aload 8
    //   379: ifnull +8 -> 387
    //   382: aload 8
    //   384: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   387: aload 11
    //   389: ifnull +8 -> 397
    //   392: aload 11
    //   394: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   397: aload 10
    //   399: astore_0
    //   400: aload_3
    //   401: ifnull -158 -> 243
    //   404: aload_3
    //   405: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   408: aconst_null
    //   409: areturn
    //   410: astore_0
    //   411: aload_0
    //   412: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   415: aconst_null
    //   416: areturn
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   422: aload_3
    //   423: areturn
    //   424: astore_3
    //   425: aload 8
    //   427: ifnull +8 -> 435
    //   430: aload 8
    //   432: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   435: aload 11
    //   437: ifnull +8 -> 445
    //   440: aload 11
    //   442: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   445: aload_0
    //   446: ifnull +7 -> 453
    //   449: aload_0
    //   450: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   453: aload_3
    //   454: athrow
    //   455: astore_0
    //   456: aload_0
    //   457: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   460: goto -7 -> 453
    //   463: astore_3
    //   464: aload 9
    //   466: astore_0
    //   467: goto -42 -> 425
    //   470: astore 9
    //   472: aload 10
    //   474: astore_3
    //   475: goto -108 -> 367
    //   478: astore_0
    //   479: goto -137 -> 342
    //   482: astore_3
    //   483: aload 8
    //   485: astore_0
    //   486: aload 9
    //   488: astore 8
    //   490: goto -166 -> 324
    //   493: astore 9
    //   495: aload_0
    //   496: astore_3
    //   497: aload 8
    //   499: astore_0
    //   500: aload_3
    //   501: astore 8
    //   503: aload 9
    //   505: astore_3
    //   506: goto -182 -> 324
    //   509: astore_0
    //   510: aload 8
    //   512: astore_0
    //   513: aload 11
    //   515: astore 9
    //   517: goto -238 -> 279
    //   520: astore 9
    //   522: aload_0
    //   523: astore 9
    //   525: aload 8
    //   527: astore_0
    //   528: goto -249 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	paramFile	File
    //   0	531	1	paramInt1	int
    //   0	531	2	paramInt2	int
    //   0	531	3	paramString	String
    //   251	3	4	f	float
    //   64	195	5	i	int
    //   54	32	6	j	int
    //   61	185	7	k	int
    //   23	503	8	localObject1	Object
    //   7	458	9	localObject2	Object
    //   470	17	9	localException	Exception
    //   493	11	9	localObject3	Object
    //   515	1	9	localObject4	Object
    //   520	1	9	localFileNotFoundException	java.io.FileNotFoundException
    //   523	1	9	localFile	File
    //   13	460	10	localObject5	Object
    //   10	504	11	localBitmap	Bitmap
    //   1	321	12	localOptions	android.graphics.BitmapFactory.Options
    //   4	273	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   132	137	263	java/io/IOException
    //   141	145	263	java/io/IOException
    //   15	25	271	java/io/FileNotFoundException
    //   283	287	308	java/io/IOException
    //   296	301	308	java/io/IOException
    //   15	25	316	finally
    //   181	203	360	java/lang/Exception
    //   203	209	360	java/lang/Exception
    //   344	357	360	java/lang/Exception
    //   382	387	410	java/lang/Exception
    //   392	397	410	java/lang/Exception
    //   404	408	410	java/lang/Exception
    //   214	219	417	java/lang/Exception
    //   224	229	417	java/lang/Exception
    //   236	241	417	java/lang/Exception
    //   172	181	424	finally
    //   372	377	424	finally
    //   430	435	455	java/lang/Exception
    //   440	445	455	java/lang/Exception
    //   449	453	455	java/lang/Exception
    //   181	203	463	finally
    //   203	209	463	finally
    //   344	357	463	finally
    //   172	181	470	java/lang/Exception
    //   328	332	478	java/io/IOException
    //   337	342	478	java/io/IOException
    //   25	63	482	finally
    //   85	96	482	finally
    //   96	105	482	finally
    //   253	260	482	finally
    //   105	127	493	finally
    //   25	63	509	java/io/FileNotFoundException
    //   85	96	509	java/io/FileNotFoundException
    //   96	105	509	java/io/FileNotFoundException
    //   253	260	509	java/io/FileNotFoundException
    //   105	127	520	java/io/FileNotFoundException
  }
  
  private void scanMedia(final String paramString)
  {
    Context localContext = (Context)this.contextRef.get();
    if (localContext != null)
    {
      this.mediaScanner = new MediaScannerConnection(localContext.getApplicationContext(), new MediaScannerConnection.MediaScannerConnectionClient()
      {
        public void onMediaScannerConnected()
        {
          if (BridgeMMMedia.this.mediaScanner != null) {
            BridgeMMMedia.this.mediaScanner.scanFile(paramString, null);
          }
        }
        
        public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
        {
          if (paramAnonymousUri == null) {
            MMSDK.Log.d("Failed to scan " + paramAnonymousString);
          }
        }
      });
      if (this.mediaScanner != null) {
        this.mediaScanner.connect();
      }
    }
  }
  
  public MMJSResponse availableSourceTypes(HashMap<String, String> paramHashMap)
  {
    paramHashMap = new JSONArray();
    if (isCameraAvailable()) {
      paramHashMap.put("Camera");
    }
    if (isPictureChooserAvailable()) {
      paramHashMap.put("Photo Library");
    }
    MMJSResponse localMMJSResponse = new MMJSResponse();
    localMMJSResponse.result = 1;
    localMMJSResponse.response = paramHashMap;
    return localMMJSResponse;
  }
  
  public MMJSResponse getDeviceVolume(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (Context)this.contextRef.get();
    if (paramHashMap != null)
    {
      int i = MMSDK.getMediaVolume(paramHashMap);
      paramHashMap = MMJSResponse.responseWithSuccess();
      paramHashMap.response = Integer.valueOf(i);
      return paramHashMap;
    }
    return MMJSResponse.responseWithError("no volume available");
  }
  
  /* Error */
  public MMJSResponse getPicture(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/millennialmedia/android/BridgeMMMedia:contextRef	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 75	android/content/Context
    //   12: astore 6
    //   14: aload_1
    //   15: ldc_w 330
    //   18: invokevirtual 335	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 176	java/lang/String
    //   24: astore 7
    //   26: aload_1
    //   27: ldc_w 337
    //   30: invokevirtual 335	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 176	java/lang/String
    //   36: astore 8
    //   38: aload_1
    //   39: ldc_w 339
    //   42: invokevirtual 335	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 176	java/lang/String
    //   48: astore 9
    //   50: aload_1
    //   51: ldc_w 341
    //   54: invokevirtual 335	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 176	java/lang/String
    //   60: astore 5
    //   62: aload 5
    //   64: astore_1
    //   65: aload 5
    //   67: ifnonnull +304 -> 371
    //   70: ldc -16
    //   72: astore_1
    //   73: goto +298 -> 371
    //   76: ldc_w 343
    //   79: invokestatic 327	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: areturn
    //   87: aload 8
    //   89: invokestatic 349	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   92: f2i
    //   93: istore_2
    //   94: aload 9
    //   96: invokestatic 349	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   99: f2i
    //   100: istore_3
    //   101: iload_2
    //   102: iload_3
    //   103: imul
    //   104: ldc_w 350
    //   107: if_icmple +13 -> 120
    //   110: ldc_w 352
    //   113: invokestatic 327	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   116: astore_1
    //   117: goto -34 -> 83
    //   120: aload 6
    //   122: ifnull +244 -> 366
    //   125: aload 7
    //   127: ifnull +239 -> 366
    //   130: new 136	java/io/File
    //   133: dup
    //   134: aload 6
    //   136: invokestatic 358	com/millennialmedia/android/AdCache:getCacheDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   139: new 360	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 361	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 363
    //   149: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   155: invokestatic 375	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   158: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 377
    //   164: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 380	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   173: astore 5
    //   175: aload 7
    //   177: ldc_w 285
    //   180: invokevirtual 387	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   183: ifeq +10 -> 193
    //   186: aload_0
    //   187: invokespecial 283	com/millennialmedia/android/BridgeMMMedia:isCameraAvailable	()Z
    //   190: ifne +36 -> 226
    //   193: aload 7
    //   195: ldc_w 293
    //   198: invokevirtual 387	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   201: ifne +14 -> 215
    //   204: aload 7
    //   206: ldc_w 389
    //   209: invokevirtual 387	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   212: ifeq +154 -> 366
    //   215: aload_0
    //   216: invokespecial 291	com/millennialmedia/android/BridgeMMMedia:isPictureChooserAvailable	()Z
    //   219: istore 4
    //   221: iload 4
    //   223: ifeq +143 -> 366
    //   226: new 391	java/lang/Object
    //   229: dup
    //   230: invokespecial 392	java/lang/Object:<init>	()V
    //   233: putstatic 44	com/millennialmedia/android/BridgeMMMedia:pickerActivityObject	Ljava/lang/Object;
    //   236: getstatic 44	com/millennialmedia/android/BridgeMMMedia:pickerActivityObject	Ljava/lang/Object;
    //   239: astore 8
    //   241: aload 8
    //   243: monitorenter
    //   244: aload 6
    //   246: aload 5
    //   248: aload 7
    //   250: invokestatic 398	com/millennialmedia/android/Utils$IntentUtils:startPickerActivity	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)V
    //   253: getstatic 44	com/millennialmedia/android/BridgeMMMedia:pickerActivityObject	Ljava/lang/Object;
    //   256: invokevirtual 401	java/lang/Object:wait	()V
    //   259: aload 8
    //   261: monitorexit
    //   262: aconst_null
    //   263: putstatic 44	com/millennialmedia/android/BridgeMMMedia:pickerActivityObject	Ljava/lang/Object;
    //   266: aload 5
    //   268: ifnull +98 -> 366
    //   271: aload 5
    //   273: invokevirtual 143	java/io/File:exists	()Z
    //   276: ifeq +90 -> 366
    //   279: aload 5
    //   281: invokevirtual 404	java/io/File:length	()J
    //   284: lconst_0
    //   285: lcmp
    //   286: ifle +80 -> 366
    //   289: aload 5
    //   291: iload_3
    //   292: iload_2
    //   293: aload_1
    //   294: invokestatic 406	com/millennialmedia/android/BridgeMMMedia:scaleBitmapToBytes	(Ljava/io/File;IILjava/lang/String;)[B
    //   297: astore 6
    //   299: aload 5
    //   301: invokevirtual 409	java/io/File:delete	()Z
    //   304: pop
    //   305: aload 6
    //   307: ifnull +59 -> 366
    //   310: new 295	com/millennialmedia/android/MMJSResponse
    //   313: dup
    //   314: invokespecial 296	com/millennialmedia/android/MMJSResponse:<init>	()V
    //   317: astore_1
    //   318: aload_1
    //   319: iconst_1
    //   320: putfield 299	com/millennialmedia/android/MMJSResponse:result	I
    //   323: aload_1
    //   324: aload 6
    //   326: putfield 413	com/millennialmedia/android/MMJSResponse:dataResponse	[B
    //   329: goto -246 -> 83
    //   332: astore_1
    //   333: aload_0
    //   334: monitorexit
    //   335: aload_1
    //   336: athrow
    //   337: astore 6
    //   339: aload 8
    //   341: monitorexit
    //   342: aload 6
    //   344: athrow
    //   345: astore 6
    //   347: aload 6
    //   349: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   352: aconst_null
    //   353: putstatic 44	com/millennialmedia/android/BridgeMMMedia:pickerActivityObject	Ljava/lang/Object;
    //   356: goto -90 -> 266
    //   359: astore_1
    //   360: aconst_null
    //   361: putstatic 44	com/millennialmedia/android/BridgeMMMedia:pickerActivityObject	Ljava/lang/Object;
    //   364: aload_1
    //   365: athrow
    //   366: aconst_null
    //   367: astore_1
    //   368: goto -285 -> 83
    //   371: aload 8
    //   373: ifnull -297 -> 76
    //   376: aload 9
    //   378: ifnonnull -291 -> 87
    //   381: goto -305 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	BridgeMMMedia
    //   0	384	1	paramHashMap	HashMap<String, String>
    //   93	200	2	i	int
    //   100	192	3	j	int
    //   219	3	4	bool	boolean
    //   60	240	5	localObject1	Object
    //   12	313	6	localObject2	Object
    //   337	6	6	localObject3	Object
    //   345	3	6	localException	Exception
    //   24	225	7	str1	String
    //   48	329	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	62	332	finally
    //   76	83	332	finally
    //   87	101	332	finally
    //   110	117	332	finally
    //   130	193	332	finally
    //   193	215	332	finally
    //   215	221	332	finally
    //   262	266	332	finally
    //   271	305	332	finally
    //   310	329	332	finally
    //   352	356	332	finally
    //   360	366	332	finally
    //   244	262	337	finally
    //   339	342	337	finally
    //   226	244	345	java/lang/Exception
    //   342	345	345	java/lang/Exception
    //   226	244	359	finally
    //   342	345	359	finally
    //   347	352	359	finally
  }
  
  public MMJSResponse isSourceTypeAvailable(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("sourceType");
    if (paramHashMap != null)
    {
      if ((paramHashMap.equalsIgnoreCase("Camera")) && (isCameraAvailable())) {
        return MMJSResponse.responseWithSuccess("true");
      }
      if ((paramHashMap.equalsIgnoreCase("Photo Library")) && (isPictureChooserAvailable())) {
        return MMJSResponse.responseWithSuccess("true");
      }
    }
    return MMJSResponse.responseWithError("false");
  }
  
  public MMJSResponse playAudio(HashMap<String, String> paramHashMap)
  {
    Object localObject = (Context)this.contextRef.get();
    String str = (String)paramHashMap.get("path");
    Audio localAudio;
    if ((localObject != null) && (str != null))
    {
      localAudio = Audio.sharedAudio((Context)localObject);
      if (localAudio != null) {
        break label42;
      }
    }
    label42:
    do
    {
      return null;
      if (localAudio.isPlaying()) {
        return MMJSResponse.responseWithError("Audio already playing.");
      }
      if (str.startsWith("http")) {
        return localAudio.playAudio(Uri.parse(str), Boolean.parseBoolean((String)paramHashMap.get("repeat")));
      }
      localObject = AdCache.getDownloadFile((Context)localObject, str);
    } while (!((File)localObject).exists());
    return localAudio.playAudio(Uri.fromFile((File)localObject), Boolean.parseBoolean((String)paramHashMap.get("repeat")));
  }
  
  public MMJSResponse playSound(HashMap<String, String> paramHashMap)
  {
    if (this.contextRef == null) {
      return null;
    }
    Object localObject = (Context)this.contextRef.get();
    paramHashMap = (String)paramHashMap.get("path");
    if ((localObject != null) && (paramHashMap != null))
    {
      paramHashMap = AdCache.getDownloadFile((Context)localObject, paramHashMap);
      if (paramHashMap.exists())
      {
        localObject = Audio.sharedAudio((Context)this.contextRef.get());
        if (localObject != null) {
          return ((Audio)localObject).playSound(paramHashMap);
        }
      }
    }
    return null;
  }
  
  public MMJSResponse playVideo(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    paramHashMap = (String)paramHashMap.get("path");
    if ((localContext != null) && (paramHashMap != null))
    {
      if (paramHashMap.startsWith("http"))
      {
        Utils.IntentUtils.startVideoPlayerActivityWithData(localContext, paramHashMap);
        return MMJSResponse.responseWithSuccess(paramHashMap);
      }
      paramHashMap = AdCache.getDownloadFile(localContext, paramHashMap);
      if (paramHashMap.exists())
      {
        Utils.IntentUtils.startVideoPlayerActivityWithData(localContext, paramHashMap);
        return MMJSResponse.responseWithSuccess(paramHashMap.getName());
      }
    }
    return null;
  }
  
  public MMJSResponse stopAudio(HashMap<String, String> paramHashMap)
  {
    if (this.contextRef != null)
    {
      paramHashMap = Audio.sharedAudio((Context)this.contextRef.get());
      if (paramHashMap != null) {
        return paramHashMap.stop();
      }
    }
    return null;
  }
  
  /* Error */
  public MMJSResponse writeToPhotoLibrary(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/millennialmedia/android/BridgeMMMedia:contextRef	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 75	android/content/Context
    //   12: astore_3
    //   13: aload_1
    //   14: ldc 28
    //   16: invokevirtual 335	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 176	java/lang/String
    //   22: invokestatic 441	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: astore 4
    //   27: new 136	java/io/File
    //   30: dup
    //   31: new 360	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 361	java/lang/StringBuilder:<init>	()V
    //   38: aload_3
    //   39: invokestatic 358	com/millennialmedia/android/AdCache:getCacheDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   42: invokevirtual 482	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 485	java/io/File:separator	Ljava/lang/String;
    //   51: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 31
    //   56: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: getstatic 485	java/io/File:separator	Ljava/lang/String;
    //   62: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload 4
    //   67: invokevirtual 488	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   70: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 380	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 489	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore_2
    //   80: aload 4
    //   82: invokevirtual 492	android/net/Uri:getScheme	()Ljava/lang/String;
    //   85: astore 5
    //   87: aload 5
    //   89: ifnull +74 -> 163
    //   92: aload 5
    //   94: ldc_w 432
    //   97: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifeq +63 -> 163
    //   103: aload_1
    //   104: ldc_w 494
    //   107: aload 4
    //   109: invokevirtual 495	android/net/Uri:toString	()Ljava/lang/String;
    //   112: invokevirtual 498	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: aload_1
    //   117: ldc 28
    //   119: aload 4
    //   121: invokevirtual 488	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   124: invokevirtual 498	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: new 500	com/millennialmedia/android/BridgeMMFileManager
    //   131: dup
    //   132: invokespecial 501	com/millennialmedia/android/BridgeMMFileManager:<init>	()V
    //   135: astore 5
    //   137: aload 5
    //   139: aload_3
    //   140: invokevirtual 505	com/millennialmedia/android/BridgeMMFileManager:setContext	(Landroid/content/Context;)V
    //   143: aload 5
    //   145: aload_1
    //   146: invokevirtual 508	com/millennialmedia/android/BridgeMMFileManager:downloadFile	(Ljava/util/HashMap;)Lcom/millennialmedia/android/MMJSResponse;
    //   149: ifnonnull +14 -> 163
    //   152: ldc_w 510
    //   155: invokestatic 327	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: areturn
    //   163: aload_3
    //   164: aload 4
    //   166: invokevirtual 488	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   169: invokestatic 455	com/millennialmedia/android/AdCache:getDownloadFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 143	java/io/File:exists	()Z
    //   177: ifne +33 -> 210
    //   180: new 360	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 361	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 512
    //   190: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_1
    //   194: invokevirtual 482	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   197: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 380	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 327	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   206: astore_1
    //   207: goto -48 -> 159
    //   210: aload_0
    //   211: aload_1
    //   212: aload_2
    //   213: invokespecial 514	com/millennialmedia/android/BridgeMMMedia:moveFile	(Ljava/io/File;Ljava/io/File;)Z
    //   216: ifeq +29 -> 245
    //   219: aload_2
    //   220: invokevirtual 482	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   223: astore_1
    //   224: aload_0
    //   225: aload_1
    //   226: invokespecial 516	com/millennialmedia/android/BridgeMMMedia:scanMedia	(Ljava/lang/String;)V
    //   229: invokestatic 519	com/millennialmedia/android/AdCache:isExternalMounted	()Z
    //   232: ifne +21 -> 253
    //   235: ldc_w 521
    //   238: invokestatic 327	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   241: astore_1
    //   242: goto -83 -> 159
    //   245: aload_1
    //   246: invokevirtual 482	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   249: astore_1
    //   250: goto -26 -> 224
    //   253: ldc_w 523
    //   256: invokestatic 418	com/millennialmedia/android/MMJSResponse:responseWithSuccess	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   259: astore_1
    //   260: goto -101 -> 159
    //   263: astore_1
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	BridgeMMMedia
    //   0	268	1	paramHashMap	HashMap<String, String>
    //   79	141	2	localFile	File
    //   12	152	3	localContext	Context
    //   25	140	4	localUri	Uri
    //   85	59	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	87	263	finally
    //   92	159	263	finally
    //   163	207	263	finally
    //   210	224	263	finally
    //   224	242	263	finally
    //   245	250	263	finally
    //   253	260	263	finally
  }
  
  static class Audio
    implements MediaPlayer.OnCompletionListener
  {
    private static final int MAX_SOUNDS = 4;
    private static Audio sharedInstance;
    private OnLoadCompleteListener completionListener;
    CopyOnWriteArrayList<MediaPlayer.OnCompletionListener> completionListeners;
    private WeakReference<Context> contextRef;
    private MediaPlayer mediaPlayer;
    CopyOnWriteArrayList<PeriodicListener> periodicListeners;
    Runnable periodicUpdater = new Runnable()
    {
      public void run()
      {
        if (BridgeMMMedia.Audio.this.mediaPlayer != null)
        {
          if (BridgeMMMedia.Audio.this.mediaPlayer.isPlaying())
          {
            int i = BridgeMMMedia.Audio.this.mediaPlayer.getCurrentPosition();
            if (BridgeMMMedia.Audio.this.periodicListeners != null)
            {
              Iterator localIterator = BridgeMMMedia.Audio.this.periodicListeners.iterator();
              while (localIterator.hasNext()) {
                ((BridgeMMMedia.Audio.PeriodicListener)localIterator.next()).onUpdate(i);
              }
            }
          }
          MMSDK.runOnUiThreadDelayed(this, 500L);
        }
      }
    };
    private SoundPool soundPool;
    
    private Audio() {}
    
    private Audio(Context paramContext)
    {
      this.contextRef = new WeakReference(paramContext.getApplicationContext());
    }
    
    static Audio sharedAudio(Context paramContext)
    {
      try
      {
        if (sharedInstance == null) {
          sharedInstance = new Audio(paramContext);
        }
        paramContext = sharedInstance;
        return paramContext;
      }
      finally {}
    }
    
    boolean addCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
    {
      if (this.completionListeners == null) {
        this.completionListeners = new CopyOnWriteArrayList();
      }
      if (!this.completionListeners.contains(paramOnCompletionListener)) {
        return this.completionListeners.add(paramOnCompletionListener);
      }
      return false;
    }
    
    boolean addPeriodicListener(PeriodicListener paramPeriodicListener)
    {
      if (this.periodicListeners == null) {
        this.periodicListeners = new CopyOnWriteArrayList();
      }
      if (!this.periodicListeners.contains(paramPeriodicListener)) {
        return this.periodicListeners.add(paramPeriodicListener);
      }
      return false;
    }
    
    /* Error */
    boolean isPlaying()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 70	com/millennialmedia/android/BridgeMMMedia$Audio:mediaPlayer	Landroid/media/MediaPlayer;
      //   6: ifnull +21 -> 27
      //   9: aload_0
      //   10: getfield 70	com/millennialmedia/android/BridgeMMMedia$Audio:mediaPlayer	Landroid/media/MediaPlayer;
      //   13: invokevirtual 102	android/media/MediaPlayer:isPlaying	()Z
      //   16: istore_1
      //   17: iload_1
      //   18: ifeq +9 -> 27
      //   21: iconst_1
      //   22: istore_1
      //   23: aload_0
      //   24: monitorexit
      //   25: iload_1
      //   26: ireturn
      //   27: iconst_0
      //   28: istore_1
      //   29: goto -6 -> 23
      //   32: astore_2
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_2
      //   36: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	Audio
      //   16	13	1	bool	boolean
      //   32	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	17	32	finally
    }
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      try
      {
        if (this.completionListeners != null)
        {
          paramMediaPlayer = this.completionListeners.iterator();
          while (paramMediaPlayer.hasNext()) {
            ((MediaPlayer.OnCompletionListener)paramMediaPlayer.next()).onCompletion(this.mediaPlayer);
          }
        }
        if (this.mediaPlayer == null) {
          break label71;
        }
      }
      finally {}
      this.mediaPlayer.release();
      this.mediaPlayer = null;
      label71:
    }
    
    MMJSResponse playAudio(Uri paramUri, boolean paramBoolean)
    {
      try
      {
        if (this.mediaPlayer != null)
        {
          this.mediaPlayer.release();
          this.mediaPlayer = null;
        }
        this.mediaPlayer = MediaPlayer.create((Context)this.contextRef.get(), paramUri);
        this.mediaPlayer.setLooping(paramBoolean);
        this.mediaPlayer.start();
        this.mediaPlayer.setOnCompletionListener(this);
        MMSDK.runOnUiThread(this.periodicUpdater);
      }
      catch (Exception paramUri)
      {
        for (;;)
        {
          MMSDK.Log.e(paramUri.getCause());
        }
      }
      finally {}
      paramUri = MMJSResponse.responseWithSuccess("Audio playback started");
      return paramUri;
    }
    
    /* Error */
    MMJSResponse playSound(File paramFile)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 172	com/millennialmedia/android/BridgeMMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   6: ifnonnull +33 -> 39
      //   9: aload_0
      //   10: new 174	android/media/SoundPool
      //   13: dup
      //   14: iconst_4
      //   15: iconst_3
      //   16: iconst_0
      //   17: invokespecial 177	android/media/SoundPool:<init>	(III)V
      //   20: putfield 172	com/millennialmedia/android/BridgeMMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   23: aload_0
      //   24: new 13	com/millennialmedia/android/BridgeMMMedia$Audio$2
      //   27: dup
      //   28: aload_0
      //   29: aload_0
      //   30: getfield 172	com/millennialmedia/android/BridgeMMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   33: invokespecial 180	com/millennialmedia/android/BridgeMMMedia$Audio$2:<init>	(Lcom/millennialmedia/android/BridgeMMMedia$Audio;Landroid/media/SoundPool;)V
      //   36: putfield 182	com/millennialmedia/android/BridgeMMMedia$Audio:completionListener	Lcom/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener;
      //   39: aload_0
      //   40: getfield 182	com/millennialmedia/android/BridgeMMMedia$Audio:completionListener	Lcom/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener;
      //   43: aload_0
      //   44: getfield 172	com/millennialmedia/android/BridgeMMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   47: aload_1
      //   48: invokevirtual 188	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   51: iconst_1
      //   52: invokevirtual 192	android/media/SoundPool:load	(Ljava/lang/String;I)I
      //   55: invokevirtual 196	com/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener:testSample	(I)V
      //   58: ldc -58
      //   60: invokestatic 158	com/millennialmedia/android/MMJSResponse:responseWithSuccess	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
      //   63: astore_1
      //   64: aload_0
      //   65: monitorexit
      //   66: aload_1
      //   67: areturn
      //   68: astore_1
      //   69: aload_0
      //   70: monitorexit
      //   71: aload_1
      //   72: athrow
      //   73: astore_1
      //   74: goto -16 -> 58
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	77	0	this	Audio
      //   0	77	1	paramFile	File
      // Exception table:
      //   from	to	target	type
      //   2	39	68	finally
      //   39	58	68	finally
      //   58	64	68	finally
      //   2	39	73	java/lang/Exception
      //   39	58	73	java/lang/Exception
    }
    
    boolean removeCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
    {
      if (this.completionListeners != null) {
        return this.completionListeners.remove(paramOnCompletionListener);
      }
      return false;
    }
    
    boolean removePeriodicListener(PeriodicListener paramPeriodicListener)
    {
      if (this.periodicListeners != null) {
        return this.periodicListeners.remove(paramPeriodicListener);
      }
      return false;
    }
    
    MMJSResponse stop()
    {
      try
      {
        if (this.mediaPlayer != null) {
          onCompletion(this.mediaPlayer);
        }
        if (this.soundPool != null)
        {
          this.soundPool.release();
          this.soundPool = null;
        }
        if (this.completionListener != null)
        {
          this.completionListener.release();
          this.completionListener = null;
        }
        MMJSResponse localMMJSResponse = MMJSResponse.responseWithSuccess("Audio stopped");
        return localMMJSResponse;
      }
      finally {}
    }
    
    private abstract class OnLoadCompleteListener
    {
      private static final int TEST_PERIOD_MS = 100;
      private ArrayList<Integer> sampleIds = new ArrayList();
      private SoundPool soundPool;
      private Timer timer;
      
      public OnLoadCompleteListener(SoundPool paramSoundPool)
      {
        this.soundPool = paramSoundPool;
      }
      
      abstract void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2);
      
      void release()
      {
        try
        {
          if (this.timer != null)
          {
            this.timer.cancel();
            this.timer.purge();
          }
          return;
        }
        finally
        {
          localObject = finally;
          throw ((Throwable)localObject);
        }
      }
      
      void testSample(int paramInt)
      {
        try
        {
          this.sampleIds.add(Integer.valueOf(paramInt));
          if (this.sampleIds.size() == 1)
          {
            this.timer = new Timer();
            this.timer.scheduleAtFixedRate(new TimerTask()
            {
              public void run()
              {
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator = BridgeMMMedia.Audio.OnLoadCompleteListener.this.sampleIds.iterator();
                while (localIterator.hasNext())
                {
                  Integer localInteger = (Integer)localIterator.next();
                  int i = BridgeMMMedia.Audio.OnLoadCompleteListener.this.soundPool.play(localInteger.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                  if (i != 0)
                  {
                    BridgeMMMedia.Audio.OnLoadCompleteListener.this.soundPool.stop(i);
                    BridgeMMMedia.Audio.OnLoadCompleteListener.this.onLoadComplete(BridgeMMMedia.Audio.OnLoadCompleteListener.this.soundPool, localInteger.intValue(), 0);
                    localArrayList.add(localInteger);
                  }
                }
                BridgeMMMedia.Audio.OnLoadCompleteListener.this.sampleIds.removeAll(localArrayList);
                if (BridgeMMMedia.Audio.OnLoadCompleteListener.this.sampleIds.size() == 0)
                {
                  BridgeMMMedia.Audio.OnLoadCompleteListener.this.timer.cancel();
                  BridgeMMMedia.Audio.OnLoadCompleteListener.this.timer.purge();
                }
              }
            }, 0L, 100L);
          }
          return;
        }
        finally
        {
          localObject = finally;
          throw ((Throwable)localObject);
        }
      }
    }
    
    static abstract interface PeriodicListener
    {
      public abstract void onUpdate(int paramInt);
    }
  }
  
  static class PickerActivity
    extends MMBaseActivity
  {
    private Uri fileUri;
    boolean hasRequestedPic = false;
    
    /* Error */
    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: iload_2
      //   3: aload_3
      //   4: invokespecial 24	com/millennialmedia/android/MMBaseActivity:onActivityResult	(IILandroid/content/Intent;)V
      //   7: aload_3
      //   8: ifnull +167 -> 175
      //   11: aconst_null
      //   12: astore 4
      //   14: aconst_null
      //   15: astore 9
      //   17: aconst_null
      //   18: astore 8
      //   20: aconst_null
      //   21: astore 6
      //   23: aconst_null
      //   24: astore 5
      //   26: aconst_null
      //   27: astore 7
      //   29: aload_3
      //   30: invokevirtual 30	android/content/Intent:getData	()Landroid/net/Uri;
      //   33: astore 10
      //   35: aload 10
      //   37: ifnonnull +242 -> 279
      //   40: aload_3
      //   41: invokevirtual 34	android/content/Intent:getExtras	()Landroid/os/Bundle;
      //   44: ifnull +131 -> 175
      //   47: aload_3
      //   48: invokevirtual 34	android/content/Intent:getExtras	()Landroid/os/Bundle;
      //   51: ldc 36
      //   53: invokevirtual 42	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   56: checkcast 44	android/graphics/Bitmap
      //   59: astore 5
      //   61: new 46	java/io/File
      //   64: dup
      //   65: aload_0
      //   66: invokevirtual 50	com/millennialmedia/android/BridgeMMMedia$PickerActivity:getIntent	()Landroid/content/Intent;
      //   69: invokevirtual 30	android/content/Intent:getData	()Landroid/net/Uri;
      //   72: invokevirtual 56	android/net/Uri:getPath	()Ljava/lang/String;
      //   75: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
      //   78: astore_3
      //   79: new 61	java/io/ByteArrayOutputStream
      //   82: dup
      //   83: invokespecial 62	java/io/ByteArrayOutputStream:<init>	()V
      //   86: astore 4
      //   88: aload 5
      //   90: getstatic 68	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
      //   93: iconst_0
      //   94: aload 4
      //   96: invokevirtual 72	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   99: pop
      //   100: new 74	java/io/ByteArrayInputStream
      //   103: dup
      //   104: aload 4
      //   106: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   109: invokespecial 81	java/io/ByteArrayInputStream:<init>	([B)V
      //   112: astore 4
      //   114: new 83	java/io/FileOutputStream
      //   117: dup
      //   118: aload_3
      //   119: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   122: astore_3
      //   123: sipush 1024
      //   126: newarray <illegal type>
      //   128: astore 5
      //   130: aload 4
      //   132: aload 5
      //   134: invokevirtual 90	java/io/ByteArrayInputStream:read	([B)I
      //   137: istore_1
      //   138: iload_1
      //   139: ifle +55 -> 194
      //   142: aload_3
      //   143: aload 5
      //   145: iconst_0
      //   146: iload_1
      //   147: invokevirtual 96	java/io/OutputStream:write	([BII)V
      //   150: goto -20 -> 130
      //   153: astore 4
      //   155: iconst_0
      //   156: ifeq +11 -> 167
      //   159: new 98	java/lang/NullPointerException
      //   162: dup
      //   163: invokespecial 99	java/lang/NullPointerException:<init>	()V
      //   166: athrow
      //   167: aload_3
      //   168: ifnull +7 -> 175
      //   171: aload_3
      //   172: invokevirtual 102	java/io/OutputStream:close	()V
      //   175: invokestatic 106	com/millennialmedia/android/BridgeMMMedia:access$000	()Ljava/lang/Object;
      //   178: astore_3
      //   179: aload_3
      //   180: monitorenter
      //   181: invokestatic 106	com/millennialmedia/android/BridgeMMMedia:access$000	()Ljava/lang/Object;
      //   184: invokevirtual 111	java/lang/Object:notify	()V
      //   187: aload_3
      //   188: monitorexit
      //   189: aload_0
      //   190: invokevirtual 114	com/millennialmedia/android/BridgeMMMedia$PickerActivity:finish	()V
      //   193: return
      //   194: iconst_0
      //   195: ifeq +11 -> 206
      //   198: new 98	java/lang/NullPointerException
      //   201: dup
      //   202: invokespecial 99	java/lang/NullPointerException:<init>	()V
      //   205: athrow
      //   206: aload_3
      //   207: ifnull +7 -> 214
      //   210: aload_3
      //   211: invokevirtual 102	java/io/OutputStream:close	()V
      //   214: goto -39 -> 175
      //   217: astore_3
      //   218: goto -43 -> 175
      //   221: astore_3
      //   222: aload 8
      //   224: astore 4
      //   226: iconst_0
      //   227: ifeq +11 -> 238
      //   230: new 98	java/lang/NullPointerException
      //   233: dup
      //   234: invokespecial 99	java/lang/NullPointerException:<init>	()V
      //   237: athrow
      //   238: aload 4
      //   240: ifnull +8 -> 248
      //   243: aload 4
      //   245: invokevirtual 102	java/io/OutputStream:close	()V
      //   248: aload_3
      //   249: athrow
      //   250: astore_3
      //   251: new 116	java/lang/StringBuilder
      //   254: dup
      //   255: invokespecial 117	java/lang/StringBuilder:<init>	()V
      //   258: ldc 119
      //   260: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: aload_3
      //   264: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   267: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: invokestatic 134	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;)V
      //   276: goto -101 -> 175
      //   279: aload 10
      //   281: ifnull -106 -> 175
      //   284: aload_0
      //   285: invokevirtual 138	com/millennialmedia/android/BridgeMMMedia$PickerActivity:getContentResolver	()Landroid/content/ContentResolver;
      //   288: astore_3
      //   289: aload_3
      //   290: ifnull -115 -> 175
      //   293: aload_3
      //   294: aload 10
      //   296: iconst_1
      //   297: anewarray 140	java/lang/String
      //   300: dup
      //   301: iconst_0
      //   302: ldc -114
      //   304: aastore
      //   305: aconst_null
      //   306: aconst_null
      //   307: aconst_null
      //   308: invokevirtual 148	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   311: astore 7
      //   313: aload 7
      //   315: ifnull -140 -> 175
      //   318: aload 7
      //   320: ldc -114
      //   322: invokeinterface 154 2 0
      //   327: istore_1
      //   328: iload_1
      //   329: iconst_m1
      //   330: if_icmpeq -155 -> 175
      //   333: aload 7
      //   335: invokeinterface 158 1 0
      //   340: pop
      //   341: new 46	java/io/File
      //   344: dup
      //   345: aload 7
      //   347: iload_1
      //   348: invokeinterface 162 2 0
      //   353: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
      //   356: astore_3
      //   357: aload 7
      //   359: invokeinterface 163 1 0
      //   364: new 46	java/io/File
      //   367: dup
      //   368: aload_0
      //   369: invokevirtual 50	com/millennialmedia/android/BridgeMMMedia$PickerActivity:getIntent	()Landroid/content/Intent;
      //   372: invokevirtual 30	android/content/Intent:getData	()Landroid/net/Uri;
      //   375: invokevirtual 56	android/net/Uri:getPath	()Ljava/lang/String;
      //   378: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
      //   381: astore 7
      //   383: new 165	java/io/FileInputStream
      //   386: dup
      //   387: aload_3
      //   388: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   391: astore_3
      //   392: new 83	java/io/FileOutputStream
      //   395: dup
      //   396: aload 7
      //   398: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   401: astore 4
      //   403: sipush 1024
      //   406: newarray <illegal type>
      //   408: astore 5
      //   410: aload_3
      //   411: aload 5
      //   413: invokevirtual 169	java/io/InputStream:read	([B)I
      //   416: istore_1
      //   417: iload_1
      //   418: ifle +42 -> 460
      //   421: aload 4
      //   423: aload 5
      //   425: iconst_0
      //   426: iload_1
      //   427: invokevirtual 96	java/io/OutputStream:write	([BII)V
      //   430: goto -20 -> 410
      //   433: astore 5
      //   435: aload_3
      //   436: ifnull +7 -> 443
      //   439: aload_3
      //   440: invokevirtual 170	java/io/InputStream:close	()V
      //   443: aload 4
      //   445: ifnull -270 -> 175
      //   448: aload 4
      //   450: invokevirtual 102	java/io/OutputStream:close	()V
      //   453: goto -278 -> 175
      //   456: astore_3
      //   457: goto -282 -> 175
      //   460: aload_3
      //   461: ifnull +7 -> 468
      //   464: aload_3
      //   465: invokevirtual 170	java/io/InputStream:close	()V
      //   468: aload 4
      //   470: ifnull +8 -> 478
      //   473: aload 4
      //   475: invokevirtual 102	java/io/OutputStream:close	()V
      //   478: goto -303 -> 175
      //   481: astore_3
      //   482: goto -307 -> 175
      //   485: astore_3
      //   486: aload 4
      //   488: ifnull +8 -> 496
      //   491: aload 4
      //   493: invokevirtual 170	java/io/InputStream:close	()V
      //   496: aload 5
      //   498: ifnull +8 -> 506
      //   501: aload 5
      //   503: invokevirtual 102	java/io/OutputStream:close	()V
      //   506: aload_3
      //   507: athrow
      //   508: astore 4
      //   510: aload_3
      //   511: monitorexit
      //   512: aload 4
      //   514: athrow
      //   515: astore 4
      //   517: goto -11 -> 506
      //   520: astore 6
      //   522: aload_3
      //   523: astore 4
      //   525: aload 6
      //   527: astore_3
      //   528: goto -42 -> 486
      //   531: astore 6
      //   533: aload 4
      //   535: astore 5
      //   537: aload_3
      //   538: astore 4
      //   540: aload 6
      //   542: astore_3
      //   543: goto -57 -> 486
      //   546: astore_3
      //   547: aload 9
      //   549: astore_3
      //   550: aload 6
      //   552: astore 4
      //   554: goto -119 -> 435
      //   557: astore 4
      //   559: aload 6
      //   561: astore 4
      //   563: goto -128 -> 435
      //   566: astore 4
      //   568: goto -320 -> 248
      //   571: astore 5
      //   573: aload_3
      //   574: astore 4
      //   576: aload 5
      //   578: astore_3
      //   579: goto -353 -> 226
      //   582: astore_3
      //   583: goto -408 -> 175
      //   586: astore_3
      //   587: aload 7
      //   589: astore_3
      //   590: goto -435 -> 155
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	593	0	this	PickerActivity
      //   0	593	1	paramInt1	int
      //   0	593	2	paramInt2	int
      //   0	593	3	paramIntent	Intent
      //   12	119	4	localObject1	Object
      //   153	1	4	localException1	Exception
      //   224	268	4	localObject2	Object
      //   508	5	4	localObject3	Object
      //   515	1	4	localException2	Exception
      //   523	30	4	localObject4	Object
      //   557	1	4	localException3	Exception
      //   561	1	4	localObject5	Object
      //   566	1	4	localException4	Exception
      //   574	1	4	localIntent	Intent
      //   24	400	5	localObject6	Object
      //   433	69	5	localException5	Exception
      //   535	1	5	localObject7	Object
      //   571	6	5	localObject8	Object
      //   21	1	6	localObject9	Object
      //   520	6	6	localObject10	Object
      //   531	29	6	localObject11	Object
      //   27	561	7	localObject12	Object
      //   18	205	8	localObject13	Object
      //   15	533	9	localObject14	Object
      //   33	262	10	localUri	Uri
      // Exception table:
      //   from	to	target	type
      //   123	130	153	java/lang/Exception
      //   130	138	153	java/lang/Exception
      //   142	150	153	java/lang/Exception
      //   198	206	217	java/lang/Exception
      //   210	214	217	java/lang/Exception
      //   61	123	221	finally
      //   29	35	250	java/lang/Exception
      //   40	61	250	java/lang/Exception
      //   248	250	250	java/lang/Exception
      //   284	289	250	java/lang/Exception
      //   293	313	250	java/lang/Exception
      //   318	328	250	java/lang/Exception
      //   333	364	250	java/lang/Exception
      //   506	508	250	java/lang/Exception
      //   403	410	433	java/lang/Exception
      //   410	417	433	java/lang/Exception
      //   421	430	433	java/lang/Exception
      //   439	443	456	java/lang/Exception
      //   448	453	456	java/lang/Exception
      //   464	468	481	java/lang/Exception
      //   473	478	481	java/lang/Exception
      //   364	392	485	finally
      //   181	189	508	finally
      //   510	512	508	finally
      //   491	496	515	java/lang/Exception
      //   501	506	515	java/lang/Exception
      //   392	403	520	finally
      //   403	410	531	finally
      //   410	417	531	finally
      //   421	430	531	finally
      //   364	392	546	java/lang/Exception
      //   392	403	557	java/lang/Exception
      //   230	238	566	java/lang/Exception
      //   243	248	566	java/lang/Exception
      //   123	130	571	finally
      //   130	138	571	finally
      //   142	150	571	finally
      //   159	167	582	java/lang/Exception
      //   171	175	582	java/lang/Exception
      //   61	123	586	java/lang/Exception
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      if (getLastNonConfigurationInstance() != null) {
        this.hasRequestedPic = ((Bundle)getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
      }
      if (!this.hasRequestedPic)
      {
        if (getIntent().getStringExtra("type").equalsIgnoreCase("Camera"))
        {
          paramBundle = new Intent("android.media.action.IMAGE_CAPTURE");
          this.fileUri = getIntent().getData();
          paramBundle.putExtra("return-data", true);
          this.hasRequestedPic = true;
          startActivityForResult(paramBundle, 0);
        }
      }
      else {
        return;
      }
      paramBundle = new Intent();
      paramBundle.setType("image/*");
      paramBundle.setAction("android.intent.action.GET_CONTENT");
      this.hasRequestedPic = true;
      startActivityForResult(paramBundle, 0);
    }
    
    public Object onRetainNonConfigurationInstance()
    {
      super.onRetainNonConfigurationInstance();
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("hasRequestedPic", this.hasRequestedPic);
      return localBundle;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */