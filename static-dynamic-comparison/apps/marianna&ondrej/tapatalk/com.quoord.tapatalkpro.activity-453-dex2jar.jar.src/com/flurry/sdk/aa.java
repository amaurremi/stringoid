package com.flurry.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class aa {
    private static final String a = aa.class.getSimpleName();
    private boolean b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;

    private Bitmap a(InputStream paramInputStream, boolean paramBoolean) {
        if (paramInputStream == null) {
            return null;
        }
        paramInputStream = BitmapFactory.decodeStream(paramInputStream);
        if (paramInputStream != null) {
            if (!paramBoolean) {
                break label30;
            }
        }
        label30:
        for (int i = 320; ; i = 160) {
            paramInputStream.setDensity(i);
            return paramInputStream;
        }
    }

    private Bitmap a(String paramString) {
        if (paramString == null) {
        }
        do {
            return null;
            paramString = Base64.decode(paramString, 0);
        } while (paramString == null);
        return a(new ByteArrayInputStream(paramString), false);
    }

    private void a(InputStream paramInputStream, String paramString) {
        if (paramInputStream == null) {
        }
        do {
            do {
                return;
                if (!g()) {
                    break;
                }
                if ("closeX_retina.png".equals(paramString)) {
                    this.c = a(paramInputStream, true);
                    return;
                }
                if ("pause_button_retina.png".equals(paramString)) {
                    this.d = a(paramInputStream, true);
                    return;
                }
                if ("play_button_retina.png".equals(paramString)) {
                    this.e = a(paramInputStream, true);
                    return;
                }
            } while (!"more_info_retina.png".equals(paramString));
            this.f = a(paramInputStream, true);
            return;
            if ("closeX.png".equals(paramString)) {
                this.c = a(paramInputStream, false);
                return;
            }
            if ("pause_button.png".equals(paramString)) {
                this.d = a(paramInputStream, false);
                return;
            }
            if ("play_button.png".equals(paramString)) {
                this.e = a(paramInputStream, false);
                return;
            }
        } while (!"more_info.png".equals(paramString));
        this.f = a(paramInputStream, false);
    }

    private boolean g() {
        return fc.d() >= 1.5F;
    }

    public boolean a() {
        return (this.c != null) && (this.d != null) && (this.e != null) && (this.f != null);
    }

    public Bitmap b() {
        return this.c;
    }

    public Bitmap c() {
        return this.d;
    }

    public Bitmap d() {
        return this.e;
    }

    public Bitmap e() {
        return this.f;
    }

    /* Error */
    public void f() {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: aconst_null
        //   3: astore 4
        //   5: aconst_null
        //   6: astore 5
        //   8: aconst_null
        //   9: astore_3
        //   10: aload_0
        //   11: getfield 102	com/flurry/sdk/aa:b	Z
        //   14: ifeq +4 -> 18
        //   17: return
        //   18: invokestatic 108	com/flurry/android/impl/ads/FlurryAdModule:getInstance	()Lcom/flurry/android/impl/ads/FlurryAdModule;
        //   21: invokevirtual 111	com/flurry/android/impl/ads/FlurryAdModule:e	()Lcom/flurry/sdk/t;
        //   24: invokevirtual 116	com/flurry/sdk/t:c	()Ljava/io/File;
        //   27: astore 6
        //   29: aload 6
        //   31: ifnull +104 -> 135
        //   34: new 118	java/io/BufferedInputStream
        //   37: dup
        //   38: new 120	java/io/FileInputStream
        //   41: dup
        //   42: aload 6
        //   44: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   47: invokespecial 126	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   50: astore_1
        //   51: aload_1
        //   52: astore 4
        //   54: new 128	java/util/zip/ZipInputStream
        //   57: dup
        //   58: new 118	java/io/BufferedInputStream
        //   61: dup
        //   62: aload_1
        //   63: invokespecial 126	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   66: invokespecial 129	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
        //   69: astore_3
        //   70: aload_3
        //   71: invokevirtual 133	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
        //   74: astore_2
        //   75: aload_2
        //   76: ifnull +169 -> 245
        //   79: aload_0
        //   80: aload_3
        //   81: aload_2
        //   82: invokevirtual 138	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
        //   85: invokespecial 140	com/flurry/sdk/aa:a	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   88: goto -18 -> 70
        //   91: astore_2
        //   92: aload_1
        //   93: astore_2
        //   94: aload_3
        //   95: astore_1
        //   96: iconst_3
        //   97: getstatic 23	com/flurry/sdk/aa:a	Ljava/lang/String;
        //   100: ldc -114
        //   102: invokestatic 147	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   105: aload_1
        //   106: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   109: aload_2
        //   110: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   113: aload_0
        //   114: invokevirtual 154	com/flurry/sdk/aa:a	()Z
        //   117: ifne +18 -> 135
        //   120: iconst_3
        //   121: getstatic 23	com/flurry/sdk/aa:a	Ljava/lang/String;
        //   124: ldc -100
        //   126: invokestatic 147	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   129: aload 6
        //   131: invokevirtual 161	java/io/File:delete	()Z
        //   134: pop
        //   135: aload_0
        //   136: getfield 69	com/flurry/sdk/aa:c	Landroid/graphics/Bitmap;
        //   139: ifnonnull +22 -> 161
        //   142: iconst_3
        //   143: getstatic 23	com/flurry/sdk/aa:a	Ljava/lang/String;
        //   146: ldc -93
        //   148: invokestatic 147	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   151: aload_0
        //   152: aload_0
        //   153: ldc -91
        //   155: invokespecial 167	com/flurry/sdk/aa:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   158: putfield 69	com/flurry/sdk/aa:c	Landroid/graphics/Bitmap;
        //   161: aload_0
        //   162: getfield 73	com/flurry/sdk/aa:d	Landroid/graphics/Bitmap;
        //   165: ifnonnull +22 -> 187
        //   168: iconst_3
        //   169: getstatic 23	com/flurry/sdk/aa:a	Ljava/lang/String;
        //   172: ldc -87
        //   174: invokestatic 147	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   177: aload_0
        //   178: aload_0
        //   179: ldc -85
        //   181: invokespecial 167	com/flurry/sdk/aa:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   184: putfield 73	com/flurry/sdk/aa:d	Landroid/graphics/Bitmap;
        //   187: aload_0
        //   188: getfield 77	com/flurry/sdk/aa:e	Landroid/graphics/Bitmap;
        //   191: ifnonnull +22 -> 213
        //   194: iconst_3
        //   195: getstatic 23	com/flurry/sdk/aa:a	Ljava/lang/String;
        //   198: ldc -83
        //   200: invokestatic 147	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   203: aload_0
        //   204: aload_0
        //   205: ldc -81
        //   207: invokespecial 167	com/flurry/sdk/aa:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   210: putfield 77	com/flurry/sdk/aa:e	Landroid/graphics/Bitmap;
        //   213: aload_0
        //   214: getfield 81	com/flurry/sdk/aa:f	Landroid/graphics/Bitmap;
        //   217: ifnonnull +22 -> 239
        //   220: iconst_3
        //   221: getstatic 23	com/flurry/sdk/aa:a	Ljava/lang/String;
        //   224: ldc -79
        //   226: invokestatic 147	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   229: aload_0
        //   230: aload_0
        //   231: ldc -77
        //   233: invokespecial 167	com/flurry/sdk/aa:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   236: putfield 81	com/flurry/sdk/aa:f	Landroid/graphics/Bitmap;
        //   239: aload_0
        //   240: iconst_1
        //   241: putfield 102	com/flurry/sdk/aa:b	Z
        //   244: return
        //   245: aload_3
        //   246: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   249: aload_1
        //   250: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   253: goto -140 -> 113
        //   256: astore_1
        //   257: aconst_null
        //   258: astore_1
        //   259: aload_2
        //   260: astore 5
        //   262: aload_1
        //   263: astore 4
        //   265: iconst_3
        //   266: getstatic 23	com/flurry/sdk/aa:a	Ljava/lang/String;
        //   269: ldc -75
        //   271: invokestatic 147	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   274: aload_2
        //   275: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   278: aload_1
        //   279: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   282: goto -169 -> 113
        //   285: astore_2
        //   286: aconst_null
        //   287: astore_1
        //   288: aload 4
        //   290: astore_3
        //   291: aload_3
        //   292: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   295: aload_1
        //   296: invokestatic 152	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   299: aload_2
        //   300: athrow
        //   301: astore_2
        //   302: aload 5
        //   304: astore_3
        //   305: aload 4
        //   307: astore_1
        //   308: goto -17 -> 291
        //   311: astore_2
        //   312: goto -21 -> 291
        //   315: astore_3
        //   316: aload_2
        //   317: astore 4
        //   319: aload_3
        //   320: astore_2
        //   321: aload_1
        //   322: astore_3
        //   323: aload 4
        //   325: astore_1
        //   326: goto -35 -> 291
        //   329: astore_3
        //   330: goto -71 -> 259
        //   333: astore_2
        //   334: aload_3
        //   335: astore_2
        //   336: goto -77 -> 259
        //   339: astore_1
        //   340: aconst_null
        //   341: astore_1
        //   342: aload_3
        //   343: astore_2
        //   344: goto -248 -> 96
        //   347: astore_2
        //   348: aconst_null
        //   349: astore_3
        //   350: aload_1
        //   351: astore_2
        //   352: aload_3
        //   353: astore_1
        //   354: goto -258 -> 96
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	357	0	this	aa
        //   50	200	1	localObject1	Object
        //   256	1	1	localIOException1	java.io.IOException
        //   258	68	1	localObject2	Object
        //   339	1	1	localFileNotFoundException1	java.io.FileNotFoundException
        //   341	13	1	localObject3	Object
        //   1	81	2	localZipEntry	java.util.zip.ZipEntry
        //   91	1	2	localFileNotFoundException2	java.io.FileNotFoundException
        //   93	182	2	localObject4	Object
        //   285	15	2	localObject5	Object
        //   301	1	2	localObject6	Object
        //   311	6	2	localObject7	Object
        //   320	1	2	localObject8	Object
        //   333	1	2	localIOException2	java.io.IOException
        //   335	9	2	localObject9	Object
        //   347	1	2	localFileNotFoundException3	java.io.FileNotFoundException
        //   351	1	2	localObject10	Object
        //   9	296	3	localObject11	Object
        //   315	5	3	localObject12	Object
        //   322	1	3	localObject13	Object
        //   329	14	3	localIOException3	java.io.IOException
        //   349	4	3	localObject14	Object
        //   3	321	4	localObject15	Object
        //   6	297	5	localObject16	Object
        //   27	103	6	localFile	java.io.File
        // Exception table:
        //   from	to	target	type
        //   70	75	91	java/io/FileNotFoundException
        //   79	88	91	java/io/FileNotFoundException
        //   34	51	256	java/io/IOException
        //   34	51	285	finally
        //   54	70	301	finally
        //   265	274	301	finally
        //   70	75	311	finally
        //   79	88	311	finally
        //   96	105	315	finally
        //   54	70	329	java/io/IOException
        //   70	75	333	java/io/IOException
        //   79	88	333	java/io/IOException
        //   34	51	339	java/io/FileNotFoundException
        //   54	70	347	java/io/FileNotFoundException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */