package com.gtp.go.weather.sharephoto.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.gtp.go.weather.sharephoto.takephoto.ab;
import java.io.File;

public class h
{
  public static final String a = com.gtp.a.a.c.c.a() + "/download/photoes/";
  
  /* Error */
  public static Bitmap a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload 5
    //   3: invokestatic 42	com/gtp/go/weather/sharephoto/d/h:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   6: astore 7
    //   8: aload 7
    //   10: astore 6
    //   12: aload 7
    //   14: ifnonnull +89 -> 103
    //   17: aload_3
    //   18: iload_1
    //   19: iload_2
    //   20: invokestatic 47	com/gtp/go/weather/sharephoto/takephoto/ab:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   23: astore_3
    //   24: aload 7
    //   26: astore 6
    //   28: aload_3
    //   29: ifnull +74 -> 103
    //   32: aload_0
    //   33: aload 4
    //   35: invokestatic 42	com/gtp/go/weather/sharephoto/d/h:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +66 -> 106
    //   43: aload_3
    //   44: aload_0
    //   45: invokestatic 50	com/gtp/go/weather/sharephoto/d/h:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   48: astore_0
    //   49: aload_0
    //   50: astore 6
    //   52: aload_0
    //   53: ifnull +50 -> 103
    //   56: new 52	java/io/FileOutputStream
    //   59: dup
    //   60: aload 5
    //   62: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   65: astore 4
    //   67: aload 4
    //   69: astore_3
    //   70: aload_0
    //   71: getstatic 61	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   74: bipush 100
    //   76: aload 4
    //   78: invokevirtual 67	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   81: pop
    //   82: aload_0
    //   83: astore 6
    //   85: aload 4
    //   87: ifnull +16 -> 103
    //   90: aload 4
    //   92: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   95: aload 4
    //   97: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   100: aload_0
    //   101: astore 6
    //   103: aload 6
    //   105: areturn
    //   106: aload_3
    //   107: astore_0
    //   108: goto -59 -> 49
    //   111: astore 5
    //   113: aconst_null
    //   114: astore 4
    //   116: aload 4
    //   118: astore_3
    //   119: aload 5
    //   121: invokevirtual 76	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aload_0
    //   125: astore 6
    //   127: aload 4
    //   129: ifnull -26 -> 103
    //   132: aload 4
    //   134: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   137: aload 4
    //   139: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   142: aload_0
    //   143: areturn
    //   144: astore_3
    //   145: aload_3
    //   146: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   149: aload_0
    //   150: areturn
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +11 -> 166
    //   158: aload_3
    //   159: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   162: aload_3
    //   163: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   166: aload_0
    //   167: athrow
    //   168: astore_3
    //   169: aload_3
    //   170: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_3
    //   177: goto -32 -> 145
    //   180: astore_3
    //   181: goto -36 -> 145
    //   184: astore_0
    //   185: goto -31 -> 154
    //   188: astore 5
    //   190: goto -74 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   0	193	1	paramInt1	int
    //   0	193	2	paramInt2	int
    //   0	193	3	paramString1	String
    //   0	193	4	paramString2	String
    //   0	193	5	paramString3	String
    //   10	116	6	localObject	Object
    //   6	19	7	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   56	67	111	java/io/FileNotFoundException
    //   132	142	144	java/io/IOException
    //   56	67	151	finally
    //   158	166	168	java/io/IOException
    //   90	95	176	java/io/IOException
    //   95	100	180	java/io/IOException
    //   70	82	184	finally
    //   119	124	184	finally
    //   70	82	188	java/io/FileNotFoundException
  }
  
  public static Bitmap a(Context paramContext, j paramj, String paramString)
  {
    paramj = a(paramj, paramString);
    if (!TextUtils.isEmpty(paramj)) {
      return a(paramContext, paramj);
    }
    return null;
  }
  
  public static Bitmap a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }
  
  public static Bitmap a(Context paramContext, String paramString, b paramb)
  {
    b localb = paramb;
    if (paramb == null) {
      localb = new b(paramContext);
    }
    if (localb.d() != null) {
      return a(paramString, localb.d());
    }
    return ab.a(paramString, localb.b(), localb.c());
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 != null) && (paramBitmap2 != null))
    {
      int j = paramBitmap1.getWidth();
      int i = paramBitmap1.getHeight();
      int k;
      if ((j > 0) && (i > 0)) {
        k = 0;
      }
      for (;;)
      {
        try
        {
          Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ALPHA_8);
          if (localBitmap != null)
          {
            Rect localRect = a(localBitmap);
            Canvas localCanvas = new Canvas(localBitmap);
            localCanvas.drawBitmap(paramBitmap1, a(paramBitmap1), localRect, null);
            localCanvas.drawBitmap(paramBitmap2, a(paramBitmap2), localRect, null);
          }
          return localBitmap;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (k == 0)
          {
            k = 1;
            j /= 2;
            i /= 2;
            continue;
          }
          localObject = null;
          continue;
        }
        Object localObject = null;
      }
    }
    return null;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Object localObject2 = null;
    localObject3 = null;
    int i;
    int j;
    if (paramDrawable != null)
    {
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    }
    for (;;)
    {
      try
      {
        if (paramDrawable.getOpacity() == -1) {
          continue;
        }
        localObject1 = Bitmap.Config.ARGB_8888;
        localObject1 = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject1);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject1 = localObject3;
        if (!com.gtp.a.a.b.c.a()) {
          continue;
        }
        localOutOfMemoryError.printStackTrace();
        localObject1 = localObject3;
        continue;
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = new Canvas((Bitmap)localObject1);
        paramDrawable.setBounds(0, 0, i, j);
        paramDrawable.draw((Canvas)localObject2);
        localObject2 = localObject1;
      }
      return (Bitmap)localObject2;
      localObject1 = Bitmap.Config.RGB_565;
    }
  }
  
  private static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    Object localObject3 = null;
    for (int i = 0;; i = 1)
    {
      if ((i == 0) || (paramOptions == null)) {}
      do
      {
        for (;;)
        {
          try
          {
            localObject1 = new BitmapFactory.Options();
            paramOptions = (BitmapFactory.Options)localObject1;
          }
          catch (OutOfMemoryError localOutOfMemoryError1) {}
          try
          {
            ((BitmapFactory.Options)localObject1).inSampleSize = 2;
            paramOptions = (BitmapFactory.Options)localObject1;
            localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
            return (Bitmap)localObject1;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            Object localObject2;
            for (;;) {}
          }
          paramOptions.inSampleSize += 1;
          Object localObject1 = paramOptions;
        }
        localObject2 = localObject3;
      } while (i != 0);
    }
  }
  
  private static Rect a(Bitmap paramBitmap)
  {
    Rect localRect = null;
    if (paramBitmap != null) {
      localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    }
    return localRect;
  }
  
  public static String a(long paramLong)
  {
    return ab.a(paramLong) + "/" + "photo_thumbnail_temporary.png";
  }
  
  public static String a(j paramj)
  {
    Object localObject = null;
    switch (i.a[paramj.ordinal()])
    {
    default: 
      paramj = (j)localObject;
    }
    for (;;)
    {
      return a + paramj;
      paramj = "compose";
      continue;
      paramj = "original";
      continue;
      paramj = "watermark";
    }
  }
  
  public static String a(j paramj, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramj = a(paramj);
    paramString = a(paramString);
    return paramj + File.separator + paramString + ".png";
  }
  
  public static String a(String paramString)
  {
    return m.a(paramString);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 220	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokevirtual 235	java/io/File:exists	()Z
    //   17: ifne +4 -> 21
    //   20: return
    //   21: new 220	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 235	java/io/File:exists	()Z
    //   36: ifne -16 -> 20
    //   39: aload 4
    //   41: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   44: invokevirtual 241	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload 4
    //   50: invokevirtual 244	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: new 246	java/io/BufferedInputStream
    //   57: dup
    //   58: new 248	java/io/FileInputStream
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 254	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore_1
    //   70: new 256	java/io/BufferedOutputStream
    //   73: dup
    //   74: new 52	java/io/FileOutputStream
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 260	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore_0
    //   87: sipush 4096
    //   90: newarray <illegal type>
    //   92: astore_2
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual 264	java/io/BufferedInputStream:read	([B)I
    //   98: ifle +57 -> 155
    //   101: aload_0
    //   102: aload_2
    //   103: invokevirtual 268	java/io/BufferedOutputStream:write	([B)V
    //   106: goto -13 -> 93
    //   109: astore_2
    //   110: invokestatic 170	com/gtp/a/a/b/c:a	()Z
    //   113: ifeq +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 270	java/io/BufferedInputStream:close	()V
    //   128: aload_0
    //   129: ifnull -109 -> 20
    //   132: aload_0
    //   133: invokevirtual 271	java/io/BufferedOutputStream:close	()V
    //   136: return
    //   137: astore_0
    //   138: invokestatic 170	com/gtp/a/a/b/c:a	()Z
    //   141: ifeq -121 -> 20
    //   144: aload_0
    //   145: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   148: return
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   154: return
    //   155: aload_0
    //   156: invokevirtual 272	java/io/BufferedOutputStream:flush	()V
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 270	java/io/BufferedInputStream:close	()V
    //   167: aload_0
    //   168: ifnull -148 -> 20
    //   171: aload_0
    //   172: invokevirtual 271	java/io/BufferedOutputStream:close	()V
    //   175: return
    //   176: astore_0
    //   177: invokestatic 170	com/gtp/a/a/b/c:a	()Z
    //   180: ifeq -160 -> 20
    //   183: goto -39 -> 144
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 270	java/io/BufferedInputStream:close	()V
    //   197: aload_2
    //   198: ifnull +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 271	java/io/BufferedOutputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_1
    //   208: invokestatic 170	com/gtp/a/a/b/c:a	()Z
    //   211: ifeq -14 -> 197
    //   214: aload_1
    //   215: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   218: goto -21 -> 197
    //   221: astore_1
    //   222: invokestatic 170	com/gtp/a/a/b/c:a	()Z
    //   225: ifeq -20 -> 205
    //   228: aload_1
    //   229: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   232: goto -27 -> 205
    //   235: astore_1
    //   236: invokestatic 170	com/gtp/a/a/b/c:a	()Z
    //   239: ifeq -111 -> 128
    //   242: aload_1
    //   243: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   246: goto -118 -> 128
    //   249: astore_1
    //   250: invokestatic 170	com/gtp/a/a/b/c:a	()Z
    //   253: ifeq -86 -> 167
    //   256: aload_1
    //   257: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   260: goto -93 -> 167
    //   263: astore_0
    //   264: goto -75 -> 189
    //   267: astore_3
    //   268: aload_0
    //   269: astore_2
    //   270: aload_3
    //   271: astore_0
    //   272: goto -83 -> 189
    //   275: astore_3
    //   276: aload_0
    //   277: astore_2
    //   278: aload_3
    //   279: astore_0
    //   280: goto -91 -> 189
    //   283: astore_2
    //   284: aconst_null
    //   285: astore_0
    //   286: aload_3
    //   287: astore_1
    //   288: goto -178 -> 110
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_0
    //   294: goto -184 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramString1	String
    //   0	297	1	paramString2	String
    //   1	102	2	arrayOfByte	byte[]
    //   109	93	2	localException1	Exception
    //   269	9	2	str	String
    //   283	1	2	localException2	Exception
    //   291	1	2	localException3	Exception
    //   3	1	3	localObject1	Object
    //   267	4	3	localObject2	Object
    //   275	12	3	localObject3	Object
    //   29	50	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   87	93	109	java/lang/Exception
    //   93	106	109	java/lang/Exception
    //   155	159	109	java/lang/Exception
    //   132	136	137	java/lang/Exception
    //   48	54	149	java/lang/Exception
    //   171	175	176	java/lang/Exception
    //   54	70	186	finally
    //   193	197	207	java/lang/Exception
    //   201	205	221	java/lang/Exception
    //   124	128	235	java/lang/Exception
    //   163	167	249	java/lang/Exception
    //   70	87	263	finally
    //   87	93	267	finally
    //   93	106	267	finally
    //   155	159	267	finally
    //   110	120	275	finally
    //   54	70	283	java/lang/Exception
    //   70	87	291	java/lang/Exception
  }
  
  public static String b(long paramLong)
  {
    return ab.a(paramLong) + "/" + "publish_photo_original.jpg";
  }
  
  public static boolean b(String paramString)
  {
    if (!c(paramString)) {}
    int i;
    int j;
    do
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      i = localOptions.outWidth;
      j = localOptions.outHeight;
    } while ((i == -1) || (j == -1));
    return true;
  }
  
  public static String c(long paramLong)
  {
    return ab.a(paramLong) + "/" + "publish_photo_watermark.png";
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */