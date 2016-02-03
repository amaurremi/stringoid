package mobi.ifunny.util.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;

@TargetApi(11)
public class c {
    public static BitmapFactory.Options a() {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inScaled = false;
        localOptions.inDither = false;
        localOptions.inPreferQualityOverSpeed = false;
        localOptions.inTempStorage = new byte['䀀'];
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return localOptions;
    }

    /* Error */
    public static d a(byte[] paramArrayOfByte, a parama) {
        // Byte code:
        //   0: invokestatic 44	mobi/ifunny/util/a/c:a	()Landroid/graphics/BitmapFactory$Options;
        //   3: astore 7
        //   5: aload 7
        //   7: iconst_1
        //   8: putfield 47	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   11: aload 7
        //   13: iconst_1
        //   14: putfield 51	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   17: aload_0
        //   18: iconst_0
        //   19: aload_0
        //   20: arraylength
        //   21: aload 7
        //   23: invokestatic 57	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   26: pop
        //   27: aload 7
        //   29: getfield 60	android/graphics/BitmapFactory$Options:outWidth	I
        //   32: istore_2
        //   33: aload 7
        //   35: getfield 63	android/graphics/BitmapFactory$Options:outHeight	I
        //   38: istore_3
        //   39: iload_2
        //   40: ifle +7 -> 47
        //   43: iload_3
        //   44: ifgt +5 -> 49
        //   47: aconst_null
        //   48: areturn
        //   49: aload 7
        //   51: iconst_0
        //   52: putfield 47	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   55: aload_1
        //   56: ifnull +32 -> 88
        //   59: new 65	android/graphics/Point
        //   62: dup
        //   63: iload_2
        //   64: iload_3
        //   65: invokespecial 68	android/graphics/Point:<init>	(II)V
        //   68: astore 8
        //   70: aload 7
        //   72: aload_1
        //   73: invokevirtual 74	mobi/ifunny/util/a/a:d	()Landroid/graphics/Point;
        //   76: aload 8
        //   78: aload_1
        //   79: invokevirtual 78	mobi/ifunny/util/a/a:e	()Z
        //   82: invokestatic 83	mobi/ifunny/util/a/b:a	(Landroid/graphics/Point;Landroid/graphics/Point;Z)I
        //   85: putfield 51	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   88: aload_1
        //   89: ifnonnull +234 -> 323
        //   92: new 85	android/graphics/Rect
        //   95: dup
        //   96: invokespecial 86	android/graphics/Rect:<init>	()V
        //   99: astore_1
        //   100: new 85	android/graphics/Rect
        //   103: dup
        //   104: aload_1
        //   105: getfield 89	android/graphics/Rect:left	I
        //   108: aload_1
        //   109: getfield 92	android/graphics/Rect:top	I
        //   112: iload_2
        //   113: aload_1
        //   114: getfield 95	android/graphics/Rect:right	I
        //   117: isub
        //   118: iload_3
        //   119: aload_1
        //   120: getfield 98	android/graphics/Rect:bottom	I
        //   123: isub
        //   124: invokespecial 101	android/graphics/Rect:<init>	(IIII)V
        //   127: astore 8
        //   129: aload_1
        //   130: getfield 89	android/graphics/Rect:left	I
        //   133: ifgt +24 -> 157
        //   136: aload_1
        //   137: getfield 92	android/graphics/Rect:top	I
        //   140: ifgt +17 -> 157
        //   143: aload_1
        //   144: getfield 95	android/graphics/Rect:right	I
        //   147: ifgt +10 -> 157
        //   150: aload_1
        //   151: getfield 98	android/graphics/Rect:bottom	I
        //   154: ifle +219 -> 373
        //   157: aload_0
        //   158: iconst_0
        //   159: aload_0
        //   160: arraylength
        //   161: iconst_1
        //   162: invokestatic 107	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
        //   165: astore_1
        //   166: aload_1
        //   167: astore_0
        //   168: aload_1
        //   169: aload 8
        //   171: aload 7
        //   173: invokevirtual 111	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   176: astore 7
        //   178: aload 7
        //   180: astore_0
        //   181: aload_1
        //   182: ifnull +10 -> 192
        //   185: aload_1
        //   186: invokevirtual 114	android/graphics/BitmapRegionDecoder:recycle	()V
        //   189: aload 7
        //   191: astore_0
        //   192: aload_0
        //   193: ifnull -146 -> 47
        //   196: aload_0
        //   197: invokevirtual 120	android/graphics/Bitmap:getWidth	()I
        //   200: istore 4
        //   202: aload_0
        //   203: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
        //   206: istore 5
        //   208: new 125	java/util/ArrayList
        //   211: dup
        //   212: invokespecial 126	java/util/ArrayList:<init>	()V
        //   215: astore_1
        //   216: iconst_0
        //   217: istore_2
        //   218: iload_2
        //   219: iload 4
        //   221: if_icmpge +174 -> 395
        //   224: iload_2
        //   225: sipush 2048
        //   228: iadd
        //   229: iload 4
        //   231: invokestatic 132	java/lang/Math:min	(II)I
        //   234: istore 6
        //   236: iconst_0
        //   237: istore_3
        //   238: iload_3
        //   239: iload 5
        //   241: if_icmpge +145 -> 386
        //   244: new 85	android/graphics/Rect
        //   247: dup
        //   248: iload_2
        //   249: iload_3
        //   250: iload 6
        //   252: iload_3
        //   253: sipush 2048
        //   256: iadd
        //   257: iload 5
        //   259: invokestatic 132	java/lang/Math:min	(II)I
        //   262: invokespecial 101	android/graphics/Rect:<init>	(IIII)V
        //   265: astore 7
        //   267: aload_0
        //   268: aload 7
        //   270: getfield 89	android/graphics/Rect:left	I
        //   273: aload 7
        //   275: getfield 92	android/graphics/Rect:top	I
        //   278: aload 7
        //   280: invokevirtual 135	android/graphics/Rect:width	()I
        //   283: aload 7
        //   285: invokevirtual 138	android/graphics/Rect:height	()I
        //   288: invokestatic 142	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
        //   291: astore 8
        //   293: aload 8
        //   295: ifnull -248 -> 47
        //   298: aload_1
        //   299: new 144	mobi/ifunny/util/a/e
        //   302: dup
        //   303: aload 8
        //   305: aload 7
        //   307: invokespecial 147	mobi/ifunny/util/a/e:<init>	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;)V
        //   310: invokevirtual 151	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   313: pop
        //   314: iload_3
        //   315: sipush 2048
        //   318: iadd
        //   319: istore_3
        //   320: goto -82 -> 238
        //   323: aload_1
        //   324: invokevirtual 155	mobi/ifunny/util/a/a:b	()Landroid/graphics/Rect;
        //   327: astore_1
        //   328: goto -228 -> 100
        //   331: astore 7
        //   333: aconst_null
        //   334: astore_1
        //   335: aload_1
        //   336: astore_0
        //   337: getstatic 158	mobi/ifunny/util/a/b:a	Ljava/lang/String;
        //   340: ldc -96
        //   342: aload 7
        //   344: invokestatic 166	mobi/ifunny/d:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   347: aload_1
        //   348: ifnull +91 -> 439
        //   351: aload_1
        //   352: invokevirtual 114	android/graphics/BitmapRegionDecoder:recycle	()V
        //   355: aconst_null
        //   356: astore_0
        //   357: goto -165 -> 192
        //   360: astore_1
        //   361: aconst_null
        //   362: astore_0
        //   363: aload_0
        //   364: ifnull +7 -> 371
        //   367: aload_0
        //   368: invokevirtual 114	android/graphics/BitmapRegionDecoder:recycle	()V
        //   371: aload_1
        //   372: athrow
        //   373: aload_0
        //   374: iconst_0
        //   375: aload_0
        //   376: arraylength
        //   377: aload 7
        //   379: invokestatic 57	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   382: astore_0
        //   383: goto -191 -> 192
        //   386: iload_2
        //   387: sipush 2048
        //   390: iadd
        //   391: istore_2
        //   392: goto -174 -> 218
        //   395: aload_1
        //   396: ifnull +10 -> 406
        //   399: aload_1
        //   400: invokevirtual 169	java/util/ArrayList:isEmpty	()Z
        //   403: ifeq +14 -> 417
        //   406: getstatic 158	mobi/ifunny/util/a/b:a	Ljava/lang/String;
        //   409: ldc -85
        //   411: invokestatic 176	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   414: pop
        //   415: aconst_null
        //   416: areturn
        //   417: new 178	mobi/ifunny/util/a/d
        //   420: dup
        //   421: iload 4
        //   423: iload 5
        //   425: aload_1
        //   426: invokespecial 181	mobi/ifunny/util/a/d:<init>	(IILjava/util/ArrayList;)V
        //   429: areturn
        //   430: astore_1
        //   431: goto -68 -> 363
        //   434: astore 7
        //   436: goto -101 -> 335
        //   439: aconst_null
        //   440: astore_0
        //   441: goto -249 -> 192
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	444	0	paramArrayOfByte	byte[]
        //   0	444	1	parama	a
        //   32	360	2	i	int
        //   38	282	3	j	int
        //   200	222	4	k	int
        //   206	218	5	m	int
        //   234	17	6	n	int
        //   3	303	7	localObject1	Object
        //   331	47	7	localIOException1	java.io.IOException
        //   434	1	7	localIOException2	java.io.IOException
        //   68	236	8	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   157	166	331	java/io/IOException
        //   157	166	360	finally
        //   168	178	430	finally
        //   337	347	430	finally
        //   168	178	434	java/io/IOException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */