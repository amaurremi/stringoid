package com.millennialmedia.android;

import android.app.Activity;
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
import android.os.Environment;
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
import org.json.JSONArray;

class MMMedia
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
    if (!Environment.getExternalStorageState().equals("mounted")) {
      return false;
    }
    try
    {
      paramFile1 = new FileInputStream(paramFile1).getChannel();
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
    //   15: new 137	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore 8
    //   25: new 199	android/graphics/BitmapFactory$Options
    //   28: dup
    //   29: invokespecial 200	android/graphics/BitmapFactory$Options:<init>	()V
    //   32: astore 12
    //   34: aload 12
    //   36: iconst_1
    //   37: putfield 204	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   40: aload 8
    //   42: aconst_null
    //   43: aload 12
    //   45: invokestatic 210	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload 12
    //   51: getfield 214	android/graphics/BitmapFactory$Options:outHeight	I
    //   54: istore 6
    //   56: aload 12
    //   58: getfield 217	android/graphics/BitmapFactory$Options:outWidth	I
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
    //   91: invokestatic 221	java/lang/Math:round	(F)I
    //   94: istore 5
    //   96: new 137	java/io/FileInputStream
    //   99: dup
    //   100: aload_0
    //   101: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: astore_0
    //   105: aload 12
    //   107: iconst_0
    //   108: putfield 204	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: aload 12
    //   113: iload 5
    //   115: putfield 224	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   118: aload_0
    //   119: aconst_null
    //   120: aload 12
    //   122: invokestatic 210	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   125: astore 9
    //   127: aload 8
    //   129: ifnull +8 -> 137
    //   132: aload 8
    //   134: invokevirtual 227	java/io/FileInputStream:close	()V
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 227	java/io/FileInputStream:close	()V
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
    //   162: invokestatic 229	com/millennialmedia/android/MMMedia:resizeImage	(Landroid/graphics/Bitmap;Ljava/lang/String;III)Landroid/graphics/Bitmap;
    //   165: astore 11
    //   167: aconst_null
    //   168: astore_0
    //   169: aconst_null
    //   170: astore 10
    //   172: new 231	java/io/ByteArrayOutputStream
    //   175: dup
    //   176: invokespecial 232	java/io/ByteArrayOutputStream:<init>	()V
    //   179: astore 9
    //   181: aload_3
    //   182: ldc -22
    //   184: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +157 -> 344
    //   190: aload 8
    //   192: getstatic 240	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   195: bipush 100
    //   197: aload 9
    //   199: invokevirtual 244	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   202: pop
    //   203: aload 9
    //   205: invokevirtual 248	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   208: astore_3
    //   209: aload 8
    //   211: ifnull +8 -> 219
    //   214: aload 8
    //   216: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   219: aload 11
    //   221: ifnull +8 -> 229
    //   224: aload 11
    //   226: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   229: aload_3
    //   230: astore_0
    //   231: aload 9
    //   233: ifnull +10 -> 243
    //   236: aload 9
    //   238: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
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
    //   255: invokestatic 221	java/lang/Math:round	(F)I
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
    //   284: invokevirtual 227	java/io/FileInputStream:close	()V
    //   287: aload 10
    //   289: astore 8
    //   291: aload 9
    //   293: ifnull -144 -> 149
    //   296: aload 9
    //   298: invokevirtual 227	java/io/FileInputStream:close	()V
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
    //   329: invokevirtual 227	java/io/FileInputStream:close	()V
    //   332: aload 8
    //   334: ifnull +8 -> 342
    //   337: aload 8
    //   339: invokevirtual 227	java/io/FileInputStream:close	()V
    //   342: aload_3
    //   343: athrow
    //   344: aload 11
    //   346: getstatic 240	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   349: bipush 100
    //   351: aload 9
    //   353: invokevirtual 244	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
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
    //   384: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   387: aload 11
    //   389: ifnull +8 -> 397
    //   392: aload 11
    //   394: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   397: aload 10
    //   399: astore_0
    //   400: aload_3
    //   401: ifnull -158 -> 243
    //   404: aload_3
    //   405: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
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
    //   432: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   435: aload 11
    //   437: ifnull +8 -> 445
    //   440: aload 11
    //   442: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   445: aload_0
    //   446: ifnull +7 -> 453
    //   449: aload_0
    //   450: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
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
          if (MMMedia.this.mediaScanner != null) {
            MMMedia.this.mediaScanner.scanFile(paramString, null);
          }
        }
        
        public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
        {
          if (paramAnonymousUri == null) {
            MMAdViewSDK.Log.d("Failed to scan " + paramAnonymousString);
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
  
  /* Error */
  public MMJSResponse getPicture(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/millennialmedia/android/MMMedia:contextRef	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 70	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 72	android/content/Context
    //   12: astore 6
    //   14: aload_1
    //   15: ldc_w 301
    //   18: invokevirtual 306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 131	java/lang/String
    //   24: astore 7
    //   26: aload_1
    //   27: ldc_w 308
    //   30: invokevirtual 306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 131	java/lang/String
    //   36: astore 8
    //   38: aload_1
    //   39: ldc_w 310
    //   42: invokevirtual 306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 131	java/lang/String
    //   48: astore 9
    //   50: aload_1
    //   51: ldc_w 312
    //   54: invokevirtual 306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 131	java/lang/String
    //   60: astore 5
    //   62: aload 5
    //   64: astore_1
    //   65: aload 5
    //   67: ifnonnull +352 -> 419
    //   70: ldc -22
    //   72: astore_1
    //   73: goto +346 -> 419
    //   76: ldc_w 314
    //   79: invokestatic 318	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: areturn
    //   87: aload 8
    //   89: invokestatic 324	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: istore_2
    //   93: aload 9
    //   95: invokestatic 324	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   98: istore_3
    //   99: iload_2
    //   100: iload_3
    //   101: imul
    //   102: ldc_w 325
    //   105: if_icmple +13 -> 118
    //   108: ldc_w 327
    //   111: invokestatic 318	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   114: astore_1
    //   115: goto -32 -> 83
    //   118: aload 6
    //   120: ifnull +294 -> 414
    //   123: aload 7
    //   125: ifnull +289 -> 414
    //   128: new 146	java/io/File
    //   131: dup
    //   132: invokestatic 331	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   135: new 333	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 336
    //   145: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   151: invokestatic 349	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   154: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 351
    //   160: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 357	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   169: astore 5
    //   171: aload 7
    //   173: ldc_w 279
    //   176: invokevirtual 361	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   179: ifeq +10 -> 189
    //   182: aload_0
    //   183: invokespecial 277	com/millennialmedia/android/MMMedia:isCameraAvailable	()Z
    //   186: ifne +25 -> 211
    //   189: aload 7
    //   191: ldc_w 287
    //   194: invokevirtual 361	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   197: ifeq +217 -> 414
    //   200: aload_0
    //   201: invokespecial 285	com/millennialmedia/android/MMMedia:isPictureChooserAvailable	()Z
    //   204: istore 4
    //   206: iload 4
    //   208: ifeq +206 -> 414
    //   211: new 363	java/lang/Object
    //   214: dup
    //   215: invokespecial 364	java/lang/Object:<init>	()V
    //   218: putstatic 41	com/millennialmedia/android/MMMedia:pickerActivityObject	Ljava/lang/Object;
    //   221: new 90	android/content/Intent
    //   224: dup
    //   225: aload 6
    //   227: ldc_w 366
    //   230: invokespecial 369	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   233: astore 8
    //   235: aload 8
    //   237: aload 5
    //   239: invokestatic 375	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   242: invokevirtual 379	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   245: pop
    //   246: aload 8
    //   248: ldc_w 381
    //   251: aload 7
    //   253: invokevirtual 385	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   256: pop
    //   257: aload 8
    //   259: ldc_w 387
    //   262: ldc_w 389
    //   265: invokevirtual 385	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   268: pop
    //   269: aload 6
    //   271: instanceof 391
    //   274: ifne +12 -> 286
    //   277: aload 8
    //   279: ldc_w 392
    //   282: invokevirtual 396	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   285: pop
    //   286: getstatic 41	com/millennialmedia/android/MMMedia:pickerActivityObject	Ljava/lang/Object;
    //   289: astore 7
    //   291: aload 7
    //   293: monitorenter
    //   294: aload 6
    //   296: aload 8
    //   298: invokevirtual 400	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   301: getstatic 41	com/millennialmedia/android/MMMedia:pickerActivityObject	Ljava/lang/Object;
    //   304: invokevirtual 403	java/lang/Object:wait	()V
    //   307: aload 7
    //   309: monitorexit
    //   310: aconst_null
    //   311: putstatic 41	com/millennialmedia/android/MMMedia:pickerActivityObject	Ljava/lang/Object;
    //   314: aload 5
    //   316: ifnull +98 -> 414
    //   319: aload 5
    //   321: invokevirtual 406	java/io/File:exists	()Z
    //   324: ifeq +90 -> 414
    //   327: aload 5
    //   329: invokevirtual 409	java/io/File:length	()J
    //   332: lconst_0
    //   333: lcmp
    //   334: ifle +80 -> 414
    //   337: aload 5
    //   339: iload_3
    //   340: iload_2
    //   341: aload_1
    //   342: invokestatic 411	com/millennialmedia/android/MMMedia:scaleBitmapToBytes	(Ljava/io/File;IILjava/lang/String;)[B
    //   345: astore 6
    //   347: aload 5
    //   349: invokevirtual 414	java/io/File:delete	()Z
    //   352: pop
    //   353: aload 6
    //   355: ifnull +59 -> 414
    //   358: new 289	com/millennialmedia/android/MMJSResponse
    //   361: dup
    //   362: invokespecial 290	com/millennialmedia/android/MMJSResponse:<init>	()V
    //   365: astore_1
    //   366: aload_1
    //   367: iconst_1
    //   368: putfield 293	com/millennialmedia/android/MMJSResponse:result	I
    //   371: aload_1
    //   372: aload 6
    //   374: putfield 418	com/millennialmedia/android/MMJSResponse:dataResponse	[B
    //   377: goto -294 -> 83
    //   380: astore_1
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_1
    //   384: athrow
    //   385: astore 6
    //   387: aload 7
    //   389: monitorexit
    //   390: aload 6
    //   392: athrow
    //   393: astore 6
    //   395: aload 6
    //   397: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   400: aconst_null
    //   401: putstatic 41	com/millennialmedia/android/MMMedia:pickerActivityObject	Ljava/lang/Object;
    //   404: goto -90 -> 314
    //   407: astore_1
    //   408: aconst_null
    //   409: putstatic 41	com/millennialmedia/android/MMMedia:pickerActivityObject	Ljava/lang/Object;
    //   412: aload_1
    //   413: athrow
    //   414: aconst_null
    //   415: astore_1
    //   416: goto -333 -> 83
    //   419: aload 8
    //   421: ifnull -345 -> 76
    //   424: aload 9
    //   426: ifnonnull -339 -> 87
    //   429: goto -353 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	MMMedia
    //   0	432	1	paramHashMap	HashMap<String, String>
    //   92	249	2	i	int
    //   98	242	3	j	int
    //   204	3	4	bool	boolean
    //   60	288	5	localObject1	Object
    //   12	361	6	localObject2	Object
    //   385	6	6	localObject3	Object
    //   393	3	6	localException	Exception
    //   36	384	8	localObject5	Object
    //   48	377	9	str	String
    // Exception table:
    //   from	to	target	type
    //   2	62	380	finally
    //   76	83	380	finally
    //   87	99	380	finally
    //   108	115	380	finally
    //   128	189	380	finally
    //   189	206	380	finally
    //   310	314	380	finally
    //   319	353	380	finally
    //   358	377	380	finally
    //   400	404	380	finally
    //   408	414	380	finally
    //   294	310	385	finally
    //   387	390	385	finally
    //   211	286	393	java/lang/Exception
    //   286	294	393	java/lang/Exception
    //   390	393	393	java/lang/Exception
    //   211	286	407	finally
    //   286	294	407	finally
    //   390	393	407	finally
    //   395	400	407	finally
  }
  
  public MMJSResponse isSourceTypeAvailable(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("sourceType");
    if (paramHashMap != null)
    {
      if ((paramHashMap.equalsIgnoreCase("Camera")) && (isCameraAvailable())) {
        return MMJSResponse.responseWithSuccess();
      }
      if ((paramHashMap.equalsIgnoreCase("Photo Library")) && (isPictureChooserAvailable())) {
        return MMJSResponse.responseWithSuccess();
      }
    }
    return null;
  }
  
  public MMJSResponse playAudio(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    Object localObject = (String)paramHashMap.get("path");
    if ((localContext != null) && (localObject != null))
    {
      if (Audio.sharedAudio(localContext).isPlaying()) {
        return MMJSResponse.responseWithError("Audio already playing.");
      }
      if (((String)localObject).startsWith("http")) {
        return Audio.sharedAudio(localContext).playAudio(Uri.parse((String)localObject), Boolean.parseBoolean((String)paramHashMap.get("repeat")));
      }
      File localFile = MMFileManager.getCreativeCacheDirectory(localContext);
      if (localFile != null)
      {
        localObject = new File(localFile, (String)localObject);
        if (((File)localObject).exists()) {
          return Audio.sharedAudio(localContext).playAudio(Uri.fromFile((File)localObject), Boolean.parseBoolean((String)paramHashMap.get("repeat")));
        }
      }
    }
    return null;
  }
  
  public MMJSResponse playSound(HashMap<String, String> paramHashMap)
  {
    Object localObject = (Context)this.contextRef.get();
    paramHashMap = (String)paramHashMap.get("path");
    if ((localObject != null) && (paramHashMap != null))
    {
      localObject = MMFileManager.getCreativeCacheDirectory((Context)localObject);
      if (localObject != null)
      {
        paramHashMap = new File((File)localObject, paramHashMap);
        if (paramHashMap.exists()) {
          return Audio.sharedAudio((Context)this.contextRef.get()).playSound(paramHashMap);
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
        localObject = new Intent(localContext, MMActivity.class);
        ((Intent)localObject).setData(Uri.parse(paramHashMap));
        ((Intent)localObject).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
        if (!(localContext instanceof Activity)) {
          ((Intent)localObject).addFlags(268435456);
        }
        localContext.startActivity((Intent)localObject);
        return MMJSResponse.responseWithSuccess();
      }
      Object localObject = MMFileManager.getCreativeCacheDirectory(localContext);
      if (localObject != null)
      {
        paramHashMap = new File((File)localObject, paramHashMap);
        if (paramHashMap.exists())
        {
          localObject = new Intent(localContext, VideoPlayer.class);
          ((Intent)localObject).setData(Uri.fromFile(paramHashMap));
          ((Intent)localObject).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
          if (!(localContext instanceof Activity)) {
            ((Intent)localObject).addFlags(268435456);
          }
          localContext.startActivity((Intent)localObject);
          return MMJSResponse.responseWithSuccess();
        }
      }
    }
    return null;
  }
  
  public MMJSResponse stopAudio(HashMap<String, String> paramHashMap)
  {
    return Audio.sharedAudio((Context)this.contextRef.get()).stop();
  }
  
  public MMJSResponse writeToPhotoLibrary(HashMap<String, String> paramHashMap)
  {
    for (;;)
    {
      try
      {
        Context localContext = (Context)this.contextRef.get();
        Uri localUri = Uri.parse((String)paramHashMap.get("path"));
        File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Pictures" + File.separator + localUri.getLastPathSegment());
        Object localObject = localUri.getScheme();
        if ((localObject != null) && (((String)localObject).equals("http")))
        {
          paramHashMap.put("url", localUri.toString());
          paramHashMap.put("path", localUri.getLastPathSegment());
          localObject = new MMFileManager();
          ((MMFileManager)localObject).setContext(localContext);
          if (((MMFileManager)localObject).downloadFile(paramHashMap) == null)
          {
            paramHashMap = MMJSResponse.responseWithError("Failed to download");
            return paramHashMap;
          }
          paramHashMap = new File(MMFileManager.getCreativeCacheDirectory(localContext), File.separator + localUri.getLastPathSegment());
          if (moveFile(paramHashMap, localFile))
          {
            paramHashMap = localFile.getAbsolutePath();
            scanMedia(paramHashMap);
            paramHashMap = MMJSResponse.responseWithSuccess();
            continue;
          }
          paramHashMap = paramHashMap.getAbsolutePath();
          continue;
        }
        paramHashMap = new File(MMFileManager.getCreativeCacheDirectory(localContext), File.separator + localUri.getLastPathSegment());
        if (!paramHashMap.exists())
        {
          paramHashMap = MMJSResponse.responseWithError("No file at " + paramHashMap.getAbsolutePath());
        }
        else if (moveFile(paramHashMap, localFile))
        {
          paramHashMap = localFile.getAbsolutePath();
          scanMedia(paramHashMap);
        }
        else
        {
          paramHashMap = paramHashMap.getAbsolutePath();
        }
      }
      finally {}
    }
  }
  
  static class Audio
  {
    private static final int MAX_SOUNDS = 4;
    private static Audio sharedInstance;
    private OnLoadCompleteListener completionListener;
    private WeakReference<Context> contextRef;
    private MediaPlayer mediaPlayer;
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
    
    /* Error */
    boolean isPlaying()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 53	com/millennialmedia/android/MMMedia$Audio:mediaPlayer	Landroid/media/MediaPlayer;
      //   6: ifnull +21 -> 27
      //   9: aload_0
      //   10: getfield 53	com/millennialmedia/android/MMMedia$Audio:mediaPlayer	Landroid/media/MediaPlayer;
      //   13: invokevirtual 69	android/media/MediaPlayer:isPlaying	()Z
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
        this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            try
            {
              if (MMMedia.Audio.this.mediaPlayer != null)
              {
                MMMedia.Audio.this.mediaPlayer.release();
                MMMedia.Audio.access$102(MMMedia.Audio.this, null);
              }
              return;
            }
            finally
            {
              paramAnonymousMediaPlayer = finally;
              throw paramAnonymousMediaPlayer;
            }
          }
        });
      }
      catch (Exception paramUri)
      {
        for (;;)
        {
          MMAdViewSDK.Log.e(paramUri.getCause());
        }
      }
      finally {}
      paramUri = MMJSResponse.responseWithSuccess();
      return paramUri;
    }
    
    /* Error */
    MMJSResponse playSound(File paramFile)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 118	com/millennialmedia/android/MMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   6: ifnonnull +33 -> 39
      //   9: aload_0
      //   10: new 120	android/media/SoundPool
      //   13: dup
      //   14: iconst_4
      //   15: iconst_3
      //   16: iconst_0
      //   17: invokespecial 123	android/media/SoundPool:<init>	(III)V
      //   20: putfield 118	com/millennialmedia/android/MMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   23: aload_0
      //   24: new 11	com/millennialmedia/android/MMMedia$Audio$2
      //   27: dup
      //   28: aload_0
      //   29: aload_0
      //   30: getfield 118	com/millennialmedia/android/MMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   33: invokespecial 126	com/millennialmedia/android/MMMedia$Audio$2:<init>	(Lcom/millennialmedia/android/MMMedia$Audio;Landroid/media/SoundPool;)V
      //   36: putfield 128	com/millennialmedia/android/MMMedia$Audio:completionListener	Lcom/millennialmedia/android/MMMedia$Audio$OnLoadCompleteListener;
      //   39: aload_0
      //   40: getfield 128	com/millennialmedia/android/MMMedia$Audio:completionListener	Lcom/millennialmedia/android/MMMedia$Audio$OnLoadCompleteListener;
      //   43: aload_0
      //   44: getfield 118	com/millennialmedia/android/MMMedia$Audio:soundPool	Landroid/media/SoundPool;
      //   47: aload_1
      //   48: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   51: iconst_1
      //   52: invokevirtual 138	android/media/SoundPool:load	(Ljava/lang/String;I)I
      //   55: invokevirtual 142	com/millennialmedia/android/MMMedia$Audio$OnLoadCompleteListener:testSample	(I)V
      //   58: invokestatic 104	com/millennialmedia/android/MMJSResponse:responseWithSuccess	()Lcom/millennialmedia/android/MMJSResponse;
      //   61: astore_1
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_1
      //   65: areturn
      //   66: astore_1
      //   67: aload_0
      //   68: monitorexit
      //   69: aload_1
      //   70: athrow
      //   71: astore_1
      //   72: goto -14 -> 58
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	Audio
      //   0	75	1	paramFile	File
      // Exception table:
      //   from	to	target	type
      //   2	39	66	finally
      //   39	58	66	finally
      //   58	62	66	finally
      //   2	39	71	java/lang/Exception
      //   39	58	71	java/lang/Exception
    }
    
    MMJSResponse stop()
    {
      try
      {
        if (this.mediaPlayer != null)
        {
          this.mediaPlayer.release();
          this.mediaPlayer = null;
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
        MMJSResponse localMMJSResponse = MMJSResponse.responseWithSuccess();
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
                Iterator localIterator = MMMedia.Audio.OnLoadCompleteListener.this.sampleIds.iterator();
                while (localIterator.hasNext())
                {
                  Integer localInteger = (Integer)localIterator.next();
                  int i = MMMedia.Audio.OnLoadCompleteListener.this.soundPool.play(localInteger.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                  if (i != 0)
                  {
                    MMMedia.Audio.OnLoadCompleteListener.this.soundPool.stop(i);
                    MMMedia.Audio.OnLoadCompleteListener.this.onLoadComplete(MMMedia.Audio.OnLoadCompleteListener.this.soundPool, localInteger.intValue(), 0);
                    localArrayList.add(localInteger);
                  }
                }
                MMMedia.Audio.OnLoadCompleteListener.this.sampleIds.removeAll(localArrayList);
                if (MMMedia.Audio.OnLoadCompleteListener.this.sampleIds.size() == 0)
                {
                  MMMedia.Audio.OnLoadCompleteListener.this.timer.cancel();
                  MMMedia.Audio.OnLoadCompleteListener.this.timer.purge();
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
  }
  
  static class PickerActivity
    extends MMBaseActivity
  {
    private Uri fileUri;
    
    /* Error */
    protected void onActivityResult(int paramInt1, int paramInt2, Intent arg3)
    {
      // Byte code:
      //   0: aload_3
      //   1: ifnull +199 -> 200
      //   4: aload_0
      //   5: invokevirtual 22	com/millennialmedia/android/MMMedia$PickerActivity:getIntent	()Landroid/content/Intent;
      //   8: ldc 24
      //   10: invokevirtual 30	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
      //   13: ldc 32
      //   15: invokevirtual 38	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   18: ifeq +182 -> 200
      //   21: aconst_null
      //   22: astore 4
      //   24: aconst_null
      //   25: astore 7
      //   27: aconst_null
      //   28: astore 5
      //   30: aconst_null
      //   31: astore 6
      //   33: aload_3
      //   34: invokevirtual 42	android/content/Intent:getData	()Landroid/net/Uri;
      //   37: astore_3
      //   38: aload_0
      //   39: invokevirtual 46	com/millennialmedia/android/MMMedia$PickerActivity:getContentResolver	()Landroid/content/ContentResolver;
      //   42: aload_3
      //   43: iconst_1
      //   44: anewarray 34	java/lang/String
      //   47: dup
      //   48: iconst_0
      //   49: ldc 48
      //   51: aastore
      //   52: aconst_null
      //   53: aconst_null
      //   54: aconst_null
      //   55: invokevirtual 54	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   58: astore 8
      //   60: aload 8
      //   62: ifnull +138 -> 200
      //   65: aload 8
      //   67: ldc 48
      //   69: invokeinterface 60 2 0
      //   74: istore_1
      //   75: iload_1
      //   76: iconst_m1
      //   77: if_icmpeq +123 -> 200
      //   80: aload 8
      //   82: invokeinterface 64 1 0
      //   87: pop
      //   88: new 66	java/io/File
      //   91: dup
      //   92: aload 8
      //   94: iload_1
      //   95: invokeinterface 70 2 0
      //   100: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
      //   103: astore_3
      //   104: aload 8
      //   106: invokeinterface 76 1 0
      //   111: new 66	java/io/File
      //   114: dup
      //   115: aload_0
      //   116: invokevirtual 22	com/millennialmedia/android/MMMedia$PickerActivity:getIntent	()Landroid/content/Intent;
      //   119: invokevirtual 42	android/content/Intent:getData	()Landroid/net/Uri;
      //   122: invokevirtual 82	android/net/Uri:getPath	()Ljava/lang/String;
      //   125: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
      //   128: astore 8
      //   130: new 84	java/io/FileInputStream
      //   133: dup
      //   134: aload_3
      //   135: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   138: astore_3
      //   139: new 89	java/io/FileOutputStream
      //   142: dup
      //   143: aload 8
      //   145: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   148: astore 4
      //   150: sipush 1024
      //   153: newarray <illegal type>
      //   155: astore 5
      //   157: aload_3
      //   158: aload 5
      //   160: invokevirtual 96	java/io/InputStream:read	([B)I
      //   163: istore_1
      //   164: iload_1
      //   165: ifle +54 -> 219
      //   168: aload 4
      //   170: aload 5
      //   172: iconst_0
      //   173: iload_1
      //   174: invokevirtual 102	java/io/OutputStream:write	([BII)V
      //   177: goto -20 -> 157
      //   180: astore 5
      //   182: aload_3
      //   183: ifnull +7 -> 190
      //   186: aload_3
      //   187: invokevirtual 103	java/io/InputStream:close	()V
      //   190: aload 4
      //   192: ifnull +8 -> 200
      //   195: aload 4
      //   197: invokevirtual 104	java/io/OutputStream:close	()V
      //   200: invokestatic 108	com/millennialmedia/android/MMMedia:access$000	()Ljava/lang/Object;
      //   203: astore_3
      //   204: aload_3
      //   205: monitorenter
      //   206: invokestatic 108	com/millennialmedia/android/MMMedia:access$000	()Ljava/lang/Object;
      //   209: invokevirtual 113	java/lang/Object:notify	()V
      //   212: aload_3
      //   213: monitorexit
      //   214: aload_0
      //   215: invokevirtual 116	com/millennialmedia/android/MMMedia$PickerActivity:finish	()V
      //   218: return
      //   219: aload_3
      //   220: ifnull +7 -> 227
      //   223: aload_3
      //   224: invokevirtual 103	java/io/InputStream:close	()V
      //   227: aload 4
      //   229: ifnull -29 -> 200
      //   232: aload 4
      //   234: invokevirtual 104	java/io/OutputStream:close	()V
      //   237: goto -37 -> 200
      //   240: astore_3
      //   241: goto -41 -> 200
      //   244: astore_3
      //   245: aload 4
      //   247: ifnull +8 -> 255
      //   250: aload 4
      //   252: invokevirtual 103	java/io/InputStream:close	()V
      //   255: aload 5
      //   257: ifnull +8 -> 265
      //   260: aload 5
      //   262: invokevirtual 104	java/io/OutputStream:close	()V
      //   265: aload_3
      //   266: athrow
      //   267: astore 4
      //   269: aload_3
      //   270: monitorexit
      //   271: aload 4
      //   273: athrow
      //   274: astore 4
      //   276: goto -11 -> 265
      //   279: astore 6
      //   281: aload_3
      //   282: astore 4
      //   284: aload 6
      //   286: astore_3
      //   287: goto -42 -> 245
      //   290: astore 6
      //   292: aload 4
      //   294: astore 5
      //   296: aload_3
      //   297: astore 4
      //   299: aload 6
      //   301: astore_3
      //   302: goto -57 -> 245
      //   305: astore_3
      //   306: goto -106 -> 200
      //   309: astore_3
      //   310: aload 7
      //   312: astore_3
      //   313: aload 6
      //   315: astore 4
      //   317: goto -135 -> 182
      //   320: astore 4
      //   322: aload 6
      //   324: astore 4
      //   326: goto -144 -> 182
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	329	0	this	PickerActivity
      //   0	329	1	paramInt1	int
      //   0	329	2	paramInt2	int
      //   22	229	4	localFileOutputStream	FileOutputStream
      //   267	5	4	localObject1	Object
      //   274	1	4	localException1	Exception
      //   282	34	4	localObject2	Object
      //   320	1	4	localException2	Exception
      //   324	1	4	localObject3	Object
      //   28	143	5	arrayOfByte	byte[]
      //   180	81	5	localException3	Exception
      //   294	1	5	localObject4	Object
      //   31	1	6	localObject5	Object
      //   279	6	6	localObject6	Object
      //   290	33	6	localObject7	Object
      //   25	286	7	localObject8	Object
      //   58	86	8	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   150	157	180	java/lang/Exception
      //   157	164	180	java/lang/Exception
      //   168	177	180	java/lang/Exception
      //   223	227	240	java/lang/Exception
      //   232	237	240	java/lang/Exception
      //   111	139	244	finally
      //   206	214	267	finally
      //   269	271	267	finally
      //   250	255	274	java/lang/Exception
      //   260	265	274	java/lang/Exception
      //   139	150	279	finally
      //   150	157	290	finally
      //   157	164	290	finally
      //   168	177	290	finally
      //   186	190	305	java/lang/Exception
      //   195	200	305	java/lang/Exception
      //   111	139	309	java/lang/Exception
      //   139	150	320	java/lang/Exception
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      if (getIntent().getStringExtra("type").equalsIgnoreCase("Camera"))
      {
        paramBundle = new Intent("android.media.action.IMAGE_CAPTURE");
        this.fileUri = getIntent().getData();
        paramBundle.putExtra("output", this.fileUri);
        paramBundle.putExtra("return-data", true);
        startActivityForResult(paramBundle, 0);
        return;
      }
      paramBundle = new Intent();
      paramBundle.setType("image/*");
      paramBundle.setAction("android.intent.action.GET_CONTENT");
      startActivityForResult(paramBundle, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMMedia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */