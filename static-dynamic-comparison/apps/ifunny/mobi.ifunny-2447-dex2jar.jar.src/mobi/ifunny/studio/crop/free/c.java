package mobi.ifunny.studio.crop.free;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;

import java.io.File;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.e;
import mobi.ifunny.util.a.d;

public class c
        extends mobi.ifunny.l.f<FreeCropImageFragment, File, Void, Uri> {
    private final Uri a;
    private final Rect b;
    private final int c;

    public c(FreeCropImageFragment paramFreeCropImageFragment, Uri paramUri, Rect paramRect, int paramInt) {
        super(paramFreeCropImageFragment, "task.process");
        this.a = paramUri;
        this.b = paramRect;
        this.c = paramInt;
    }

    private static Bitmap a(d paramd, Rect paramRect) {
        int j = 1;
        int k = 1;
        int i = 1;
        paramd = new mobi.ifunny.view.drawable.f(paramd);
        paramd.a(paramRect);
        int m = paramd.getIntrinsicWidth();
        int n = paramd.getIntrinsicHeight();
        float f5 = m / n;
        paramRect = IFunnyApplication.a.getResources();
        float f1;
        float f2;
        float f4;
        if (paramRect != null) {
            f1 = paramRect.getDimensionPixelSize(2131427495);
            f2 = paramRect.getDimensionPixelSize(2131427492);
            float f3 = paramRect.getDimensionPixelSize(2131427494);
            f4 = paramRect.getDimensionPixelSize(2131427493);
            if (f5 <= 2.0F) {
                break label183;
            }
            if (m <= f3) {
                break label177;
            }
            f1 = f3;
        }
        for (; ; ) {
            label108:
            if (i != 0) {
                if (f5 > f1 / f2) {
                    j = (int) f1;
                    i = (int) (j * n / m);
                }
                for (; ; ) {
                    paramd.setBounds(0, 0, j, i);
                    paramRect = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
                    paramd.draw(new Canvas(paramRect));
                    return paramRect;
                    return null;
                    label177:
                    i = 0;
                    break;
                    label183:
                    if (f5 < 0.5F) {
                        if (n > f4) {
                        }
                        for (i = k; ; i = 0) {
                            f2 = f4;
                            break;
                        }
                    }
                    if ((m <= f1) && (n <= f2)) {
                        break label265;
                    }
                    i = j;
                    break label108;
                    i = (int) f2;
                    j = (int) (i * m / n);
                }
            }
            return paramd.c();
            label265:
            i = 0;
        }
    }

    /* Error */
    protected Uri a(File... paramVarArgs) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: getstatic 97	mobi/ifunny/e:a	Lmobi/ifunny/e;
        //   6: invokevirtual 52	mobi/ifunny/e:getResources	()Landroid/content/res/Resources;
        //   9: astore_2
        //   10: aload_2
        //   11: ifnonnull +5 -> 16
        //   14: aconst_null
        //   15: areturn
        //   16: new 99	mobi/ifunny/util/a/a
        //   19: dup
        //   20: new 101	android/graphics/Point
        //   23: dup
        //   24: aload_2
        //   25: ldc 61
        //   27: invokevirtual 59	android/content/res/Resources:getDimensionPixelSize	(I)I
        //   30: aload_2
        //   31: ldc 62
        //   33: invokevirtual 59	android/content/res/Resources:getDimensionPixelSize	(I)I
        //   36: invokespecial 104	android/graphics/Point:<init>	(II)V
        //   39: iconst_0
        //   40: invokespecial 107	mobi/ifunny/util/a/a:<init>	(Landroid/graphics/Point;Z)V
        //   43: astore_2
        //   44: getstatic 46	mobi/ifunny/IFunnyApplication:a	Lmobi/ifunny/e;
        //   47: aload_0
        //   48: getfield 20	mobi/ifunny/studio/crop/free/c:a	Landroid/net/Uri;
        //   51: aload_2
        //   52: invokestatic 112	mobi/ifunny/e/l:a	(Landroid/content/Context;Landroid/net/Uri;Lmobi/ifunny/util/a/a;)Lmobi/ifunny/util/a/d;
        //   55: astore_2
        //   56: aload_0
        //   57: invokevirtual 116	mobi/ifunny/studio/crop/free/c:isCanceled	()Z
        //   60: ifne +7 -> 67
        //   63: aload_2
        //   64: ifnonnull +5 -> 69
        //   67: aconst_null
        //   68: areturn
        //   69: invokestatic 122	mobi/ifunny/studio/crop/free/FreeCropImageFragment:d	()Ljava/lang/String;
        //   72: new 124	java/lang/StringBuilder
        //   75: dup
        //   76: invokespecial 127	java/lang/StringBuilder:<init>	()V
        //   79: ldc -127
        //   81: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   84: aload_2
        //   85: invokevirtual 138	mobi/ifunny/util/a/d:toString	()Ljava/lang/String;
        //   88: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   91: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   94: invokestatic 144	mobi/ifunny/d:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   97: invokestatic 122	mobi/ifunny/studio/crop/free/FreeCropImageFragment:d	()Ljava/lang/String;
        //   100: new 124	java/lang/StringBuilder
        //   103: dup
        //   104: invokespecial 127	java/lang/StringBuilder:<init>	()V
        //   107: ldc -110
        //   109: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: aload_0
        //   113: getfield 22	mobi/ifunny/studio/crop/free/c:b	Landroid/graphics/Rect;
        //   116: invokevirtual 149	android/graphics/Rect:toString	()Ljava/lang/String;
        //   119: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   122: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   125: invokestatic 144	mobi/ifunny/d:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   128: aload_2
        //   129: aload_0
        //   130: getfield 22	mobi/ifunny/studio/crop/free/c:b	Landroid/graphics/Rect;
        //   133: invokestatic 151	mobi/ifunny/studio/crop/free/c:a	(Lmobi/ifunny/util/a/d;Landroid/graphics/Rect;)Landroid/graphics/Bitmap;
        //   136: astore_3
        //   137: aload_0
        //   138: invokevirtual 116	mobi/ifunny/studio/crop/free/c:isCanceled	()Z
        //   141: ifne +7 -> 148
        //   144: aload_3
        //   145: ifnonnull +5 -> 150
        //   148: aconst_null
        //   149: areturn
        //   150: invokestatic 122	mobi/ifunny/studio/crop/free/FreeCropImageFragment:d	()Ljava/lang/String;
        //   153: ldc -103
        //   155: iconst_2
        //   156: anewarray 155	java/lang/Object
        //   159: dup
        //   160: iconst_0
        //   161: aload_3
        //   162: invokevirtual 158	android/graphics/Bitmap:getWidth	()I
        //   165: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   168: aastore
        //   169: dup
        //   170: iconst_1
        //   171: aload_3
        //   172: invokevirtual 167	android/graphics/Bitmap:getHeight	()I
        //   175: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   178: aastore
        //   179: invokestatic 173	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   182: invokestatic 144	mobi/ifunny/d:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   185: aload_3
        //   186: astore_2
        //   187: aload_0
        //   188: getfield 24	mobi/ifunny/studio/crop/free/c:c	I
        //   191: invokestatic 178	mobi/ifunny/util/i:a	(I)Lmobi/ifunny/util/j;
        //   194: astore 7
        //   196: aload 7
        //   198: ifnull +273 -> 471
        //   201: aload_3
        //   202: astore_2
        //   203: aload 7
        //   205: getfield 183	mobi/ifunny/util/j:a	Ljava/lang/Integer;
        //   208: ifnonnull +13 -> 221
        //   211: aload_3
        //   212: astore_2
        //   213: aload 7
        //   215: getfield 185	mobi/ifunny/util/j:b	Ljava/lang/Integer;
        //   218: ifnull +253 -> 471
        //   221: aload_3
        //   222: astore_2
        //   223: new 187	android/graphics/Matrix
        //   226: dup
        //   227: invokespecial 188	android/graphics/Matrix:<init>	()V
        //   230: astore 6
        //   232: aload_3
        //   233: astore_2
        //   234: aload 7
        //   236: getfield 183	mobi/ifunny/util/j:a	Ljava/lang/Integer;
        //   239: ifnull +20 -> 259
        //   242: aload_3
        //   243: astore_2
        //   244: aload 6
        //   246: aload 7
        //   248: getfield 183	mobi/ifunny/util/j:a	Ljava/lang/Integer;
        //   251: invokevirtual 191	java/lang/Integer:intValue	()I
        //   254: i2f
        //   255: invokevirtual 195	android/graphics/Matrix:postRotate	(F)Z
        //   258: pop
        //   259: aload 6
        //   261: astore 4
        //   263: aload_3
        //   264: astore_2
        //   265: aload 7
        //   267: getfield 185	mobi/ifunny/util/j:b	Ljava/lang/Integer;
        //   270: ifnull +25 -> 295
        //   273: aload_3
        //   274: astore_2
        //   275: aload 6
        //   277: aload 7
        //   279: getfield 185	mobi/ifunny/util/j:b	Ljava/lang/Integer;
        //   282: invokevirtual 191	java/lang/Integer:intValue	()I
        //   285: i2f
        //   286: fconst_1
        //   287: invokevirtual 199	android/graphics/Matrix:postScale	(FF)Z
        //   290: pop
        //   291: aload 6
        //   293: astore 4
        //   295: aload_3
        //   296: astore_2
        //   297: aload 4
        //   299: ifnull +62 -> 361
        //   302: aload_3
        //   303: astore_2
        //   304: aload_3
        //   305: iconst_0
        //   306: iconst_0
        //   307: aload_3
        //   308: invokevirtual 158	android/graphics/Bitmap:getWidth	()I
        //   311: aload_3
        //   312: invokevirtual 167	android/graphics/Bitmap:getHeight	()I
        //   315: aload 4
        //   317: iconst_0
        //   318: invokestatic 202	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
        //   321: astore_3
        //   322: aload_3
        //   323: astore_2
        //   324: invokestatic 122	mobi/ifunny/studio/crop/free/FreeCropImageFragment:d	()Ljava/lang/String;
        //   327: ldc -52
        //   329: iconst_2
        //   330: anewarray 155	java/lang/Object
        //   333: dup
        //   334: iconst_0
        //   335: aload_3
        //   336: invokevirtual 158	android/graphics/Bitmap:getWidth	()I
        //   339: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   342: aastore
        //   343: dup
        //   344: iconst_1
        //   345: aload_3
        //   346: invokevirtual 167	android/graphics/Bitmap:getHeight	()I
        //   349: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   352: aastore
        //   353: invokestatic 173	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   356: invokestatic 144	mobi/ifunny/d:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   359: aload_3
        //   360: astore_2
        //   361: new 206	java/io/File
        //   364: dup
        //   365: aload_1
        //   366: iconst_0
        //   367: aaload
        //   368: ldc -48
        //   370: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   373: astore_3
        //   374: new 213	java/io/BufferedOutputStream
        //   377: dup
        //   378: new 215	java/io/FileOutputStream
        //   381: dup
        //   382: aload_3
        //   383: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   386: invokespecial 221	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   389: astore_1
        //   390: aload_2
        //   391: getstatic 227	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   394: bipush 100
        //   396: aload_1
        //   397: invokevirtual 231	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   400: ifeq +17 -> 417
        //   403: aload_3
        //   404: invokestatic 237	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
        //   407: astore_2
        //   408: aload_1
        //   409: invokevirtual 240	java/io/BufferedOutputStream:close	()V
        //   412: aload_2
        //   413: areturn
        //   414: astore_1
        //   415: aload_2
        //   416: areturn
        //   417: aload_1
        //   418: invokevirtual 240	java/io/BufferedOutputStream:close	()V
        //   421: aconst_null
        //   422: areturn
        //   423: astore_1
        //   424: aconst_null
        //   425: astore_1
        //   426: aload_1
        //   427: invokevirtual 240	java/io/BufferedOutputStream:close	()V
        //   430: goto -9 -> 421
        //   433: astore_1
        //   434: goto -13 -> 421
        //   437: astore_1
        //   438: aload 5
        //   440: astore_2
        //   441: aload_2
        //   442: invokevirtual 240	java/io/BufferedOutputStream:close	()V
        //   445: aload_1
        //   446: athrow
        //   447: astore_1
        //   448: goto -27 -> 421
        //   451: astore_2
        //   452: goto -7 -> 445
        //   455: astore_3
        //   456: aload_1
        //   457: astore_2
        //   458: aload_3
        //   459: astore_1
        //   460: goto -19 -> 441
        //   463: astore_2
        //   464: goto -38 -> 426
        //   467: astore_3
        //   468: goto -107 -> 361
        //   471: aconst_null
        //   472: astore 4
        //   474: goto -179 -> 295
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	477	0	this	c
        //   0	477	1	paramVarArgs	File[]
        //   9	433	2	localObject1	Object
        //   451	1	2	localException1	Exception
        //   457	1	2	arrayOfFile	File[]
        //   463	1	2	localFileNotFoundException	java.io.FileNotFoundException
        //   136	268	3	localObject2	Object
        //   455	4	3	localObject3	Object
        //   467	1	3	localException2	Exception
        //   261	212	4	localMatrix1	android.graphics.Matrix
        //   1	438	5	localObject4	Object
        //   230	62	6	localMatrix2	android.graphics.Matrix
        //   194	84	7	localj	mobi.ifunny.util.j
        // Exception table:
        //   from	to	target	type
        //   408	412	414	java/lang/Exception
        //   374	390	423	java/io/FileNotFoundException
        //   426	430	433	java/lang/Exception
        //   374	390	437	finally
        //   417	421	447	java/lang/Exception
        //   441	445	451	java/lang/Exception
        //   390	408	455	finally
        //   390	408	463	java/io/FileNotFoundException
        //   187	196	467	java/lang/Exception
        //   203	211	467	java/lang/Exception
        //   213	221	467	java/lang/Exception
        //   223	232	467	java/lang/Exception
        //   234	242	467	java/lang/Exception
        //   244	259	467	java/lang/Exception
        //   265	273	467	java/lang/Exception
        //   275	291	467	java/lang/Exception
        //   304	322	467	java/lang/Exception
        //   324	359	467	java/lang/Exception
    }

    protected void a(FreeCropImageFragment paramFreeCropImageFragment) {
        super.onStarted(paramFreeCropImageFragment);
        paramFreeCropImageFragment.b();
    }

    protected void a(FreeCropImageFragment paramFreeCropImageFragment, Uri paramUri) {
        paramFreeCropImageFragment.b(paramUri);
    }

    protected void b(FreeCropImageFragment paramFreeCropImageFragment) {
        super.onFinished(paramFreeCropImageFragment);
        paramFreeCropImageFragment.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */