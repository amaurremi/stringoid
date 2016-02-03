package com.ideashower.readitlater.f;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.g.k;
import com.pocket.k.b;
import com.pocket.k.c;
import com.pocket.m.a.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class i
  extends k
{
  private static com.pocket.m.d.e a;
  private final e b;
  private final com.pocket.m.a.a c;
  private final com.pocket.k.a d;
  private boolean e;
  private String f;
  private File g;
  private String h;
  private File p;
  
  private i(e parame)
  {
    this.b = parame;
    this.c = parame.f();
    this.d = parame.i();
  }
  
  @TargetApi(10)
  public static Bitmap a(BitmapRegionDecoder paramBitmapRegionDecoder, com.pocket.k.a parama, int paramInt, Rect paramRect)
  {
    try
    {
      paramBitmapRegionDecoder = b(paramBitmapRegionDecoder, parama, paramInt, paramRect);
      return paramBitmapRegionDecoder;
    }
    catch (Throwable paramBitmapRegionDecoder)
    {
      com.ideashower.readitlater.util.e.a(paramBitmapRegionDecoder);
    }
    return null;
  }
  
  public static Bitmap a(String paramString, com.pocket.k.a parama)
  {
    return a(paramString, parama, -1);
  }
  
  /* Error */
  public static Bitmap a(String paramString, com.pocket.k.a parama, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +208 -> 209
    //   4: iconst_1
    //   5: istore 4
    //   7: new 63	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore 11
    //   17: new 68	android/graphics/BitmapFactory$Options
    //   20: dup
    //   21: invokespecial 69	android/graphics/BitmapFactory$Options:<init>	()V
    //   24: astore_0
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 72	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload 11
    //   32: invokevirtual 76	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   35: aconst_null
    //   36: aload_0
    //   37: invokestatic 82	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: pop
    //   41: aload_0
    //   42: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   45: istore_2
    //   46: aload_0
    //   47: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   50: istore 5
    //   52: iload_2
    //   53: ifle +518 -> 571
    //   56: iload 5
    //   58: ifle +513 -> 571
    //   61: new 68	android/graphics/BitmapFactory$Options
    //   64: dup
    //   65: invokespecial 69	android/graphics/BitmapFactory$Options:<init>	()V
    //   68: astore 12
    //   70: aload 12
    //   72: iconst_0
    //   73: putfield 92	android/graphics/BitmapFactory$Options:inDither	Z
    //   76: aload 12
    //   78: aload_1
    //   79: iload_2
    //   80: iload 5
    //   82: invokevirtual 97	com/pocket/k/a:a	(II)I
    //   85: putfield 100	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   88: aload 12
    //   90: iconst_0
    //   91: putfield 103	android/graphics/BitmapFactory$Options:inScaled	Z
    //   94: aload 12
    //   96: getstatic 109	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   99: putfield 112	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   102: invokestatic 117	com/ideashower/readitlater/util/a:e	()Z
    //   105: ifeq +8 -> 113
    //   108: aload 12
    //   110: invokestatic 120	com/ideashower/readitlater/f/i:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   113: aload 11
    //   115: invokevirtual 76	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   118: aload 12
    //   120: invokestatic 125	com/ideashower/readitlater/util/a/c:a	(Ljava/io/FileDescriptor;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   123: astore_0
    //   124: aload 12
    //   126: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   129: ifle +11 -> 140
    //   132: aload 12
    //   134: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   137: ifgt +78 -> 215
    //   140: new 127	com/pocket/k/b
    //   143: dup
    //   144: aload 12
    //   146: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   149: aload 12
    //   151: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   154: invokespecial 130	com/pocket/k/b:<init>	(II)V
    //   157: athrow
    //   158: astore 13
    //   160: aload_0
    //   161: astore_1
    //   162: aconst_null
    //   163: astore 12
    //   165: aload 13
    //   167: astore_0
    //   168: aload 11
    //   170: astore 13
    //   172: aload_1
    //   173: astore 11
    //   175: aload 13
    //   177: astore_1
    //   178: aload_1
    //   179: invokestatic 135	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   182: aload 11
    //   184: ifnull +23 -> 207
    //   187: aload 11
    //   189: aload 12
    //   191: if_acmpeq +16 -> 207
    //   194: aload 11
    //   196: invokevirtual 140	android/graphics/Bitmap:isRecycled	()Z
    //   199: ifne +8 -> 207
    //   202: aload 11
    //   204: invokevirtual 143	android/graphics/Bitmap:recycle	()V
    //   207: aload_0
    //   208: athrow
    //   209: iconst_0
    //   210: istore 4
    //   212: goto -205 -> 7
    //   215: aload 11
    //   217: invokestatic 135	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   220: aload_0
    //   221: ifnull +345 -> 566
    //   224: aload_0
    //   225: invokevirtual 146	android/graphics/Bitmap:hasAlpha	()Z
    //   228: ifeq +317 -> 545
    //   231: aload 12
    //   233: getfield 149	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   236: ldc -105
    //   238: invokevirtual 157	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   241: ifne +304 -> 545
    //   244: iconst_1
    //   245: istore_2
    //   246: iload 4
    //   248: ifeq +381 -> 629
    //   251: iload_2
    //   252: ifeq +377 -> 629
    //   255: aload_0
    //   256: invokevirtual 160	android/graphics/Bitmap:isMutable	()Z
    //   259: ifeq +370 -> 629
    //   262: new 162	android/graphics/Canvas
    //   265: dup
    //   266: aload_0
    //   267: invokespecial 165	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   270: iconst_m1
    //   271: getstatic 171	android/graphics/PorterDuff$Mode:DST_ATOP	Landroid/graphics/PorterDuff$Mode;
    //   274: invokevirtual 175	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   277: iconst_0
    //   278: istore_2
    //   279: new 177	android/graphics/Matrix
    //   282: dup
    //   283: invokespecial 178	android/graphics/Matrix:<init>	()V
    //   286: astore 13
    //   288: aload_1
    //   289: aload 12
    //   291: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   294: aload 12
    //   296: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   299: invokevirtual 181	com/pocket/k/a:b	(II)F
    //   302: fstore_3
    //   303: aload_1
    //   304: aload 12
    //   306: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   309: aload 12
    //   311: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   314: fload_3
    //   315: invokevirtual 184	com/pocket/k/a:a	(IIF)I
    //   318: istore 6
    //   320: aload_1
    //   321: aload 12
    //   323: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   326: aload 12
    //   328: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   331: fload_3
    //   332: invokevirtual 186	com/pocket/k/a:b	(IIF)I
    //   335: istore 5
    //   337: iload 6
    //   339: i2f
    //   340: fload_3
    //   341: fdiv
    //   342: ldc -69
    //   344: fadd
    //   345: f2i
    //   346: istore 8
    //   348: ldc -69
    //   350: iload 5
    //   352: i2f
    //   353: fload_3
    //   354: fdiv
    //   355: fadd
    //   356: f2i
    //   357: istore 9
    //   359: fload_3
    //   360: fconst_1
    //   361: fcmpl
    //   362: ifeq +188 -> 550
    //   365: iconst_1
    //   366: istore 10
    //   368: iload 10
    //   370: ifeq +11 -> 381
    //   373: aload 13
    //   375: fload_3
    //   376: fload_3
    //   377: invokevirtual 191	android/graphics/Matrix:postScale	(FF)Z
    //   380: pop
    //   381: aload 12
    //   383: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   386: iload 8
    //   388: isub
    //   389: iconst_1
    //   390: ishr
    //   391: istore 6
    //   393: aload 12
    //   395: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   398: istore 5
    //   400: iload 5
    //   402: iload 9
    //   404: isub
    //   405: iconst_1
    //   406: ishr
    //   407: istore 7
    //   409: iload 6
    //   411: istore 5
    //   413: iload 6
    //   415: ifge +6 -> 421
    //   418: iconst_0
    //   419: istore 5
    //   421: iload 7
    //   423: istore 6
    //   425: iload 7
    //   427: ifge +6 -> 433
    //   430: iconst_0
    //   431: istore 6
    //   433: aload_0
    //   434: iload 5
    //   436: iload 6
    //   438: iload 8
    //   440: iload 9
    //   442: aload 13
    //   444: iload 10
    //   446: invokestatic 195	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   449: astore 12
    //   451: iload 4
    //   453: ifeq +170 -> 623
    //   456: iload_2
    //   457: ifeq +166 -> 623
    //   460: aload 12
    //   462: invokevirtual 146	android/graphics/Bitmap:hasAlpha	()Z
    //   465: ifeq +158 -> 623
    //   468: aload 12
    //   470: invokevirtual 199	android/graphics/Bitmap:getWidth	()I
    //   473: aload 12
    //   475: invokevirtual 202	android/graphics/Bitmap:getHeight	()I
    //   478: aload 12
    //   480: invokevirtual 206	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   483: invokestatic 209	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   486: astore_1
    //   487: aload_1
    //   488: iconst_m1
    //   489: invokevirtual 213	android/graphics/Bitmap:eraseColor	(I)V
    //   492: new 162	android/graphics/Canvas
    //   495: dup
    //   496: aload_1
    //   497: invokespecial 165	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   500: aload 12
    //   502: new 177	android/graphics/Matrix
    //   505: dup
    //   506: invokespecial 178	android/graphics/Matrix:<init>	()V
    //   509: aconst_null
    //   510: invokevirtual 217	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   513: aload 12
    //   515: invokevirtual 143	android/graphics/Bitmap:recycle	()V
    //   518: aload 11
    //   520: invokestatic 135	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   523: aload_0
    //   524: ifnull +19 -> 543
    //   527: aload_0
    //   528: aload_1
    //   529: if_acmpeq +14 -> 543
    //   532: aload_0
    //   533: invokevirtual 140	android/graphics/Bitmap:isRecycled	()Z
    //   536: ifne +7 -> 543
    //   539: aload_0
    //   540: invokevirtual 143	android/graphics/Bitmap:recycle	()V
    //   543: aload_1
    //   544: areturn
    //   545: iconst_0
    //   546: istore_2
    //   547: goto -301 -> 246
    //   550: iconst_0
    //   551: istore 10
    //   553: goto -185 -> 368
    //   556: astore_1
    //   557: new 219	com/pocket/k/c
    //   560: dup
    //   561: aload_1
    //   562: invokespecial 222	com/pocket/k/c:<init>	(Ljava/lang/IllegalArgumentException;)V
    //   565: athrow
    //   566: aconst_null
    //   567: astore_1
    //   568: goto -50 -> 518
    //   571: aconst_null
    //   572: astore_1
    //   573: aconst_null
    //   574: astore_0
    //   575: goto -57 -> 518
    //   578: astore_0
    //   579: aconst_null
    //   580: astore 12
    //   582: aconst_null
    //   583: astore_1
    //   584: aconst_null
    //   585: astore 11
    //   587: goto -409 -> 178
    //   590: astore_0
    //   591: aconst_null
    //   592: astore 13
    //   594: aconst_null
    //   595: astore 12
    //   597: aload 11
    //   599: astore_1
    //   600: aload 13
    //   602: astore 11
    //   604: goto -426 -> 178
    //   607: astore_1
    //   608: aload_0
    //   609: astore 13
    //   611: aload_1
    //   612: astore_0
    //   613: aload 11
    //   615: astore_1
    //   616: aload 13
    //   618: astore 11
    //   620: goto -442 -> 178
    //   623: aload 12
    //   625: astore_1
    //   626: goto -108 -> 518
    //   629: goto -350 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	paramString	String
    //   0	632	1	parama	com.pocket.k.a
    //   0	632	2	paramInt	int
    //   302	75	3	f1	float
    //   5	447	4	i	int
    //   50	385	5	j	int
    //   318	119	6	k	int
    //   407	19	7	m	int
    //   346	93	8	n	int
    //   357	84	9	i1	int
    //   366	186	10	bool	boolean
    //   15	604	11	localObject1	Object
    //   68	556	12	localObject2	Object
    //   158	8	13	localObject3	Object
    //   170	447	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   124	140	158	finally
    //   140	158	158	finally
    //   215	220	158	finally
    //   224	244	158	finally
    //   255	277	158	finally
    //   279	359	158	finally
    //   373	381	158	finally
    //   381	400	158	finally
    //   433	451	158	finally
    //   557	566	158	finally
    //   433	451	556	java/lang/IllegalArgumentException
    //   7	17	578	finally
    //   17	52	590	finally
    //   61	113	590	finally
    //   113	124	590	finally
    //   460	518	607	finally
  }
  
  public static i a(e parame)
  {
    if (b(parame)) {
      return null;
    }
    return new i(parame);
  }
  
  @TargetApi(11)
  private static void a(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
  }
  
  public static void a(com.pocket.m.d.e parame)
  {
    a = parame;
  }
  
  public static boolean a(e parame, Bitmap paramBitmap)
  {
    return a(parame.c(), paramBitmap, parame.e());
  }
  
  private static boolean a(File paramFile1, File paramFile2)
  {
    if (g()) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return false;
      } while (!paramFile2.exists());
      l1 = paramFile2.lastModified();
      l2 = paramFile1.lastModified();
    } while ((l1 != 0L) && (l2 != 0L) && (l1 < l2));
    return true;
  }
  
  /* Error */
  public static boolean a(String paramString, Bitmap paramBitmap, com.pocket.m.a.d paramd)
  {
    // Byte code:
    //   0: new 259	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 260	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload 6
    //   12: astore 5
    //   14: aload_1
    //   15: getstatic 266	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   18: bipush 90
    //   20: aload 6
    //   22: invokevirtual 270	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   25: pop
    //   26: aload 6
    //   28: astore 5
    //   30: aload 6
    //   32: invokevirtual 273	java/io/FileOutputStream:flush	()V
    //   35: aload 6
    //   37: astore 5
    //   39: aload 6
    //   41: invokevirtual 274	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   44: invokevirtual 279	java/io/FileDescriptor:sync	()V
    //   47: aload 6
    //   49: astore 5
    //   51: new 250	java/io/File
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 280	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokestatic 285	org/apache/a/b/b:h	(Ljava/io/File;)J
    //   62: lstore_3
    //   63: aload 6
    //   65: astore 5
    //   67: aload_0
    //   68: aload_2
    //   69: invokestatic 290	com/pocket/m/a/e:a	(Ljava/lang/String;Lcom/pocket/m/a/d;)V
    //   72: aload 6
    //   74: astore 5
    //   76: getstatic 235	com/ideashower/readitlater/f/i:a	Lcom/pocket/m/d/e;
    //   79: ifnull +17 -> 96
    //   82: aload 6
    //   84: astore 5
    //   86: getstatic 235	com/ideashower/readitlater/f/i:a	Lcom/pocket/m/d/e;
    //   89: aload_0
    //   90: lload_3
    //   91: invokeinterface 295 4 0
    //   96: aload 6
    //   98: invokestatic 298	org/apache/a/b/d:a	(Ljava/io/OutputStream;)V
    //   101: iconst_1
    //   102: ireturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_0
    //   107: astore 5
    //   109: aload_1
    //   110: invokestatic 54	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: invokestatic 298	org/apache/a/b/d:a	(Ljava/io/OutputStream;)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: aconst_null
    //   121: astore 5
    //   123: aload 5
    //   125: invokestatic 298	org/apache/a/b/d:a	(Ljava/io/OutputStream;)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: goto -8 -> 123
    //   134: astore_1
    //   135: aload 6
    //   137: astore_0
    //   138: goto -32 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   0	141	1	paramBitmap	Bitmap
    //   0	141	2	paramd	com.pocket.m.a.d
    //   62	29	3	l	long
    //   12	112	5	localObject	Object
    //   8	128	6	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	10	103	java/lang/Throwable
    //   0	10	119	finally
    //   14	26	130	finally
    //   30	35	130	finally
    //   39	47	130	finally
    //   51	63	130	finally
    //   67	72	130	finally
    //   76	82	130	finally
    //   86	96	130	finally
    //   109	113	130	finally
    //   14	26	134	java/lang/Throwable
    //   30	35	134	java/lang/Throwable
    //   39	47	134	java/lang/Throwable
    //   51	63	134	java/lang/Throwable
    //   67	72	134	java/lang/Throwable
    //   76	82	134	java/lang/Throwable
    //   86	96	134	java/lang/Throwable
  }
  
  /* Error */
  @TargetApi(10)
  public static Bitmap b(BitmapRegionDecoder paramBitmapRegionDecoder, com.pocket.k.a parama, int paramInt, Rect paramRect)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: iload_2
    //   4: ifeq +151 -> 155
    //   7: iconst_1
    //   8: istore 5
    //   10: aload_3
    //   11: invokevirtual 303	android/graphics/Rect:width	()I
    //   14: istore_2
    //   15: aload_3
    //   16: invokevirtual 306	android/graphics/Rect:height	()I
    //   19: istore 6
    //   21: iload_2
    //   22: ifle +485 -> 507
    //   25: iload 6
    //   27: ifle +480 -> 507
    //   30: new 68	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 69	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 13
    //   39: aload 13
    //   41: iconst_0
    //   42: putfield 92	android/graphics/BitmapFactory$Options:inDither	Z
    //   45: aload 13
    //   47: aload_1
    //   48: iload_2
    //   49: iload 6
    //   51: invokevirtual 97	com/pocket/k/a:a	(II)I
    //   54: putfield 100	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   57: aload 13
    //   59: iconst_0
    //   60: putfield 103	android/graphics/BitmapFactory$Options:inScaled	Z
    //   63: aload 13
    //   65: getstatic 109	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   68: putfield 112	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   71: invokestatic 117	com/ideashower/readitlater/util/a:e	()Z
    //   74: ifeq +8 -> 82
    //   77: aload 13
    //   79: invokestatic 120	com/ideashower/readitlater/f/i:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   82: aload_3
    //   83: aload_0
    //   84: aload 13
    //   86: invokestatic 309	com/ideashower/readitlater/util/a/c:a	(Landroid/graphics/Rect;Landroid/graphics/BitmapRegionDecoder;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: astore_0
    //   90: aload 13
    //   92: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   95: ifle +11 -> 106
    //   98: aload 13
    //   100: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   103: ifgt +58 -> 161
    //   106: new 127	com/pocket/k/b
    //   109: dup
    //   110: aload 13
    //   112: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   115: aload 13
    //   117: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   120: invokespecial 130	com/pocket/k/b:<init>	(II)V
    //   123: athrow
    //   124: astore 12
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_0
    //   129: astore_3
    //   130: aload 12
    //   132: astore_0
    //   133: aload_3
    //   134: ifnull +19 -> 153
    //   137: aload_3
    //   138: aload_1
    //   139: if_acmpeq +14 -> 153
    //   142: aload_3
    //   143: invokevirtual 140	android/graphics/Bitmap:isRecycled	()Z
    //   146: ifne +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 143	android/graphics/Bitmap:recycle	()V
    //   153: aload_0
    //   154: athrow
    //   155: iconst_0
    //   156: istore 5
    //   158: goto -148 -> 10
    //   161: aload_0
    //   162: ifnull +340 -> 502
    //   165: aload_0
    //   166: invokevirtual 146	android/graphics/Bitmap:hasAlpha	()Z
    //   169: ifeq +312 -> 481
    //   172: aload 13
    //   174: getfield 149	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   177: ldc -105
    //   179: invokevirtual 157	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   182: ifne +299 -> 481
    //   185: iconst_1
    //   186: istore_2
    //   187: iload 5
    //   189: ifeq +347 -> 536
    //   192: iload_2
    //   193: ifeq +343 -> 536
    //   196: aload_0
    //   197: invokevirtual 160	android/graphics/Bitmap:isMutable	()Z
    //   200: ifeq +336 -> 536
    //   203: new 162	android/graphics/Canvas
    //   206: dup
    //   207: aload_0
    //   208: invokespecial 165	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   211: iconst_m1
    //   212: getstatic 171	android/graphics/PorterDuff$Mode:DST_ATOP	Landroid/graphics/PorterDuff$Mode;
    //   215: invokevirtual 175	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   218: iconst_0
    //   219: istore_2
    //   220: new 177	android/graphics/Matrix
    //   223: dup
    //   224: invokespecial 178	android/graphics/Matrix:<init>	()V
    //   227: astore_3
    //   228: aload_1
    //   229: aload 13
    //   231: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   234: aload 13
    //   236: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   239: invokevirtual 181	com/pocket/k/a:b	(II)F
    //   242: fstore 4
    //   244: aload_1
    //   245: aload 13
    //   247: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   250: aload 13
    //   252: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   255: fload 4
    //   257: invokevirtual 184	com/pocket/k/a:a	(IIF)I
    //   260: istore 7
    //   262: aload_1
    //   263: aload 13
    //   265: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   268: aload 13
    //   270: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   273: fload 4
    //   275: invokevirtual 186	com/pocket/k/a:b	(IIF)I
    //   278: istore 6
    //   280: iload 7
    //   282: i2f
    //   283: fload 4
    //   285: fdiv
    //   286: ldc -69
    //   288: fadd
    //   289: f2i
    //   290: istore 9
    //   292: ldc -69
    //   294: iload 6
    //   296: i2f
    //   297: fload 4
    //   299: fdiv
    //   300: fadd
    //   301: f2i
    //   302: istore 10
    //   304: fload 4
    //   306: fconst_1
    //   307: fcmpl
    //   308: ifeq +178 -> 486
    //   311: iconst_1
    //   312: istore 11
    //   314: iload 11
    //   316: ifeq +12 -> 328
    //   319: aload_3
    //   320: fload 4
    //   322: fload 4
    //   324: invokevirtual 191	android/graphics/Matrix:postScale	(FF)Z
    //   327: pop
    //   328: aload 13
    //   330: getfield 86	android/graphics/BitmapFactory$Options:outWidth	I
    //   333: iload 9
    //   335: isub
    //   336: iconst_1
    //   337: ishr
    //   338: istore 7
    //   340: aload 13
    //   342: getfield 89	android/graphics/BitmapFactory$Options:outHeight	I
    //   345: istore 6
    //   347: iload 6
    //   349: iload 10
    //   351: isub
    //   352: iconst_1
    //   353: ishr
    //   354: istore 8
    //   356: iload 7
    //   358: istore 6
    //   360: iload 7
    //   362: ifge +6 -> 368
    //   365: iconst_0
    //   366: istore 6
    //   368: iload 8
    //   370: istore 7
    //   372: iload 8
    //   374: ifge +6 -> 380
    //   377: iconst_0
    //   378: istore 7
    //   380: aload_0
    //   381: iload 6
    //   383: iload 7
    //   385: iload 9
    //   387: iload 10
    //   389: aload_3
    //   390: iload 11
    //   392: invokestatic 195	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   395: astore_1
    //   396: iload 5
    //   398: ifeq +135 -> 533
    //   401: iload_2
    //   402: ifeq +131 -> 533
    //   405: aload_1
    //   406: invokevirtual 146	android/graphics/Bitmap:hasAlpha	()Z
    //   409: ifeq +124 -> 533
    //   412: aload_1
    //   413: invokevirtual 199	android/graphics/Bitmap:getWidth	()I
    //   416: aload_1
    //   417: invokevirtual 202	android/graphics/Bitmap:getHeight	()I
    //   420: aload_1
    //   421: invokevirtual 206	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   424: invokestatic 209	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   427: astore_3
    //   428: aload_3
    //   429: iconst_m1
    //   430: invokevirtual 213	android/graphics/Bitmap:eraseColor	(I)V
    //   433: new 162	android/graphics/Canvas
    //   436: dup
    //   437: aload_3
    //   438: invokespecial 165	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   441: aload_1
    //   442: new 177	android/graphics/Matrix
    //   445: dup
    //   446: invokespecial 178	android/graphics/Matrix:<init>	()V
    //   449: aconst_null
    //   450: invokevirtual 217	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   453: aload_1
    //   454: invokevirtual 143	android/graphics/Bitmap:recycle	()V
    //   457: aload_3
    //   458: astore_1
    //   459: aload_0
    //   460: ifnull +19 -> 479
    //   463: aload_0
    //   464: aload_1
    //   465: if_acmpeq +14 -> 479
    //   468: aload_0
    //   469: invokevirtual 140	android/graphics/Bitmap:isRecycled	()Z
    //   472: ifne +7 -> 479
    //   475: aload_0
    //   476: invokevirtual 143	android/graphics/Bitmap:recycle	()V
    //   479: aload_1
    //   480: areturn
    //   481: iconst_0
    //   482: istore_2
    //   483: goto -296 -> 187
    //   486: iconst_0
    //   487: istore 11
    //   489: goto -175 -> 314
    //   492: astore_1
    //   493: new 219	com/pocket/k/c
    //   496: dup
    //   497: aload_1
    //   498: invokespecial 222	com/pocket/k/c:<init>	(Ljava/lang/IllegalArgumentException;)V
    //   501: athrow
    //   502: aconst_null
    //   503: astore_1
    //   504: goto -45 -> 459
    //   507: aconst_null
    //   508: astore_1
    //   509: aconst_null
    //   510: astore_0
    //   511: goto -52 -> 459
    //   514: astore_0
    //   515: aconst_null
    //   516: astore_1
    //   517: aload 12
    //   519: astore_3
    //   520: goto -387 -> 133
    //   523: astore 12
    //   525: aload_0
    //   526: astore_3
    //   527: aload 12
    //   529: astore_0
    //   530: goto -397 -> 133
    //   533: goto -74 -> 459
    //   536: goto -316 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	paramBitmapRegionDecoder	BitmapRegionDecoder
    //   0	539	1	parama	com.pocket.k.a
    //   0	539	2	paramInt	int
    //   0	539	3	paramRect	Rect
    //   242	81	4	f1	float
    //   8	389	5	i	int
    //   19	363	6	j	int
    //   260	124	7	k	int
    //   354	19	8	m	int
    //   290	96	9	n	int
    //   302	86	10	i1	int
    //   312	176	11	bool	boolean
    //   1	1	12	localObject1	Object
    //   124	394	12	localObject2	Object
    //   523	5	12	localObject3	Object
    //   37	304	13	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   90	106	124	finally
    //   106	124	124	finally
    //   165	185	124	finally
    //   196	218	124	finally
    //   220	304	124	finally
    //   319	328	124	finally
    //   328	347	124	finally
    //   380	396	124	finally
    //   493	502	124	finally
    //   380	396	492	java/lang/IllegalArgumentException
    //   10	21	514	finally
    //   30	82	514	finally
    //   82	90	514	finally
    //   405	457	523	finally
  }
  
  public static Bitmap b(String paramString, com.pocket.k.a parama)
  {
    try
    {
      paramString = a(paramString, parama);
      return paramString;
    }
    catch (Throwable paramString)
    {
      com.ideashower.readitlater.util.e.a(paramString);
    }
    return null;
  }
  
  public static boolean b(e parame)
  {
    if (parame.i() == null) {
      return true;
    }
    return a(new File(parame.f().c()), new File(parame.c()));
  }
  
  private static boolean g()
  {
    return false;
  }
  
  public void a()
  {
    boolean bool = false;
    this.f = this.c.c();
    this.g = new File(this.f);
    this.h = this.b.c();
    this.p = new File(this.h);
    this.e = a(this.g, this.p);
    if (this.e) {
      x.a(this);
    }
    int i;
    do
    {
      do
      {
        return;
      } while (!this.g.exists());
      try
      {
        localBitmap = a(this.f, this.d);
        i = 0;
      }
      catch (b localb)
      {
        for (;;)
        {
          Bitmap localBitmap;
          com.ideashower.readitlater.util.e.a(localb);
          Object localObject1 = null;
          i = 1;
        }
      }
      catch (IOException localIOException)
      {
        while ((localIOException instanceof FileNotFoundException))
        {
          i = 0;
          com.ideashower.readitlater.util.e.a(localIOException);
          Object localObject2 = null;
        }
        i = 1;
        continue;
      }
      catch (c localc)
      {
        for (;;)
        {
          com.ideashower.readitlater.util.e.a(localc);
          Object localObject3 = null;
          i = 0;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject4 = null;
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.ideashower.readitlater.util.e.a(localThrowable);
          Object localObject5 = null;
          i = 0;
        }
      }
      if (localBitmap != null) {
        bool = a(this.b, localBitmap);
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      if (bool)
      {
        this.e = true;
        x.a(this);
        return;
      }
    } while (i == 0);
    l.a(this.c);
  }
  
  public int c()
  {
    if (this.b.a() == null) {
      return 1;
    }
    if (this.b.a().a(this.b)) {
      return 3;
    }
    return 2;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public e f()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */