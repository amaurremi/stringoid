package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.gtp.a.a.c.a;
import java.io.File;
import java.io.IOException;

public class ab
{
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      try
      {
        int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
        switch (i)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          return 0;
        case 3: 
          return 180;
        case 6: 
          return 90;
        }
        return 270;
      }
      catch (IOException paramString) {}
    } while (!com.gtp.a.a.b.c.a());
    paramString.printStackTrace();
    return 0;
  }
  
  public static Bitmap.CompressFormat a(File paramFile)
  {
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    Object localObject = localCompressFormat;
    if (paramFile != null)
    {
      localObject = localCompressFormat;
      if (paramFile.exists())
      {
        localObject = paramFile.getAbsolutePath();
        paramFile = new BitmapFactory.Options();
        paramFile.inJustDecodeBounds = true;
        BitmapFactory.decodeFile((String)localObject, paramFile);
        if (!"image/jpeg".equalsIgnoreCase(paramFile.outMimeType))
        {
          localObject = localCompressFormat;
          if (!"image/bmp".equalsIgnoreCase(paramFile.outMimeType)) {}
        }
        else
        {
          localObject = Bitmap.CompressFormat.JPEG;
        }
      }
    }
    return (Bitmap.CompressFormat)localObject;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, File paramFile)
  {
    return a(paramInt1, paramInt2, paramFile, null);
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, File paramFile, Bitmap.Config paramConfig)
  {
    Bitmap localBitmap = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    float f1 = localOptions.outHeight;
    float f2 = localOptions.outWidth;
    localOptions.inSampleSize = ((int)(Math.max(f1 / paramInt2, f2 / paramInt1) + 0.5F));
    localOptions.inJustDecodeBounds = false;
    if (paramConfig != null) {
      localOptions.inPreferredConfig = paramConfig;
    }
    try
    {
      paramConfig = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      paramInt1 = 0;
    }
    catch (OutOfMemoryError paramConfig)
    {
      for (;;)
      {
        try
        {
          localBitmap = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
          paramConfig = localBitmap;
          paramInt1 = 0;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!com.gtp.a.a.b.c.a()) {
            continue;
          }
          localOutOfMemoryError.printStackTrace();
          paramInt1 = 1;
        }
        paramConfig = paramConfig;
        if (com.gtp.a.a.b.c.a()) {
          paramConfig.printStackTrace();
        }
        paramInt1 = 1;
        paramConfig = localBitmap;
      }
    }
    if ((paramConfig == null) && (paramInt1 != 0)) {
      localOptions.inSampleSize += 1;
    }
    return paramConfig;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    Object localObject = new int[k * m];
    paramBitmap.getPixels((int[])localObject, 0, k, 0, 0, k, m);
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < k)
      {
        int n = localObject[(k * i + j)];
        double d = (0xFF0000 & n) >> 16;
        int i1 = (int)(((0xFF00 & n) >> 8) * 0.59D + d * 0.3D + (n & 0xFF) * 0.11D);
        localObject[(k * i + j)] = (n & 0xFF000000 | i1 << 16 | i1 << 8 | i1);
        j += 1;
      }
      i += 1;
    }
    do
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        paramBitmap = localBitmap;
        localObject = paramBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          paramBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
          localObject = paramBitmap;
          return (Bitmap)localObject;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
      }
    } while (!com.gtp.a.a.b.c.a());
    localOutOfMemoryError1.printStackTrace();
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt == 0) || (paramBitmap == null)) {}
    do
    {
      for (;;)
      {
        return paramBitmap;
        Object localObject = new Matrix();
        ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth(), paramBitmap.getHeight());
        try
        {
          localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
          if (paramBitmap != localObject) {
            return (Bitmap)localObject;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    } while (!com.gtp.a.a.b.c.a());
    localOutOfMemoryError.printStackTrace();
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {}
    for (;;)
    {
      return paramBitmap;
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      float f1 = paramInt1 * 1.0F / i;
      float f2 = paramInt2 * 1.0F / j;
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(f1, f2);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject1, true);
        if (localObject1 == null) {
          continue;
        }
        return (Bitmap)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject2 = null;
          localObject1 = localObject2;
          if (com.gtp.a.a.b.c.a())
          {
            localOutOfMemoryError.printStackTrace();
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = localObject2;
    if (a.a() != 1)
    {
      localObject1 = localObject2;
      if (a(new File(paramString)) != Bitmap.CompressFormat.PNG) {
        localObject1 = Bitmap.Config.RGB_565;
      }
    }
    return a(paramString, paramInt1, paramInt2, (Bitmap.Config)localObject1);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramConfig = null;
    }
    for (;;)
    {
      return paramConfig;
      int i = Math.max(paramInt1, paramInt2);
      paramInt2 = Math.min(paramInt1, paramInt2);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int k = Math.max(localOptions.outHeight, localOptions.outWidth);
      int j = Math.min(localOptions.outHeight, localOptions.outWidth);
      paramInt1 = 1;
      while ((k / paramInt1 > i) || (j / paramInt1 > paramInt2)) {
        paramInt1 *= 2;
      }
      if ((k > i) || (j > paramInt2))
      {
        int m = (int)Math.pow(2.0D, paramInt1 / 2);
        k /= m;
        j /= m;
        float f = Math.min(i * 1.0F / k, paramInt2 * 1.0F / j);
        localOptions.inScaled = true;
        localOptions.inDensity = 160;
        localOptions.inTargetDensity = ((int)(f * localOptions.inDensity));
      }
      localOptions.inSampleSize = paramInt1;
      localOptions.inJustDecodeBounds = false;
      Object localObject = null;
      if (paramConfig != null) {
        localOptions.inPreferredConfig = paramConfig;
      }
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        paramConfig = paramString;
        if (paramString == null) {
          continue;
        }
        com.gtp.a.a.b.c.a("LJL", "loadSuitableSizeBitmap[ decodeFile.getConfig(): " + paramString.getConfig() + ", options.inPreferredConfig: " + localOptions.inPreferredConfig + " ]");
        return paramString;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          paramString = (String)localObject;
          if (com.gtp.a.a.b.c.a())
          {
            paramConfig.printStackTrace();
            paramString = (String)localObject;
          }
        }
      }
    }
  }
  
  public static File a(long paramLong)
  {
    File localFile = new File(com.gtp.a.a.c.c.a(), "sharephoto" + File.separator + paramLong);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static File a(Context paramContext)
  {
    paramContext = new File(com.gtp.a.a.c.c.a(), "sharephoto");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    return new File(paramContext, "take_photo_temporary.jpg");
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, File paramFile, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: iload 4
    //   8: istore 5
    //   10: aload_1
    //   11: ifnull +11 -> 22
    //   14: aload_0
    //   15: ifnonnull +10 -> 25
    //   18: iload 4
    //   20: istore 5
    //   22: iload 5
    //   24: ireturn
    //   25: aload_1
    //   26: invokevirtual 259	java/io/File:getParentFile	()Ljava/io/File;
    //   29: astore 7
    //   31: aload 7
    //   33: invokevirtual 48	java/io/File:exists	()Z
    //   36: ifne +9 -> 45
    //   39: aload 7
    //   41: invokevirtual 247	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aconst_null
    //   46: astore 8
    //   48: new 261	java/io/BufferedOutputStream
    //   51: dup
    //   52: new 263	java/io/FileOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 269	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore 7
    //   65: aload 7
    //   67: astore_1
    //   68: aload_0
    //   69: aload_2
    //   70: iload_3
    //   71: aload 7
    //   73: invokevirtual 273	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: istore 5
    //   78: iload 5
    //   80: istore 4
    //   82: iload 4
    //   84: istore 5
    //   86: aload 7
    //   88: ifnull -66 -> 22
    //   91: aload 7
    //   93: invokevirtual 276	java/io/BufferedOutputStream:flush	()V
    //   96: aload 7
    //   98: invokevirtual 279	java/io/BufferedOutputStream:close	()V
    //   101: iload 4
    //   103: ireturn
    //   104: astore_0
    //   105: iload 4
    //   107: istore 5
    //   109: invokestatic 31	com/gtp/a/a/b/c:a	()Z
    //   112: ifeq -90 -> 22
    //   115: aload_0
    //   116: invokevirtual 35	java/io/IOException:printStackTrace	()V
    //   119: iload 4
    //   121: ireturn
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: astore_1
    //   127: invokestatic 31	com/gtp/a/a/b/c:a	()Z
    //   130: ifeq +9 -> 139
    //   133: aload_0
    //   134: astore_1
    //   135: aload_2
    //   136: invokevirtual 280	java/lang/Exception:printStackTrace	()V
    //   139: iload 4
    //   141: istore 5
    //   143: aload_0
    //   144: ifnull -122 -> 22
    //   147: aload_0
    //   148: invokevirtual 276	java/io/BufferedOutputStream:flush	()V
    //   151: aload_0
    //   152: invokevirtual 279	java/io/BufferedOutputStream:close	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_0
    //   158: iload 4
    //   160: istore 5
    //   162: invokestatic 31	com/gtp/a/a/b/c:a	()Z
    //   165: ifeq -143 -> 22
    //   168: iload 6
    //   170: istore 4
    //   172: goto -57 -> 115
    //   175: astore_0
    //   176: aload 8
    //   178: astore_1
    //   179: aload_1
    //   180: ifnull +11 -> 191
    //   183: aload_1
    //   184: invokevirtual 276	java/io/BufferedOutputStream:flush	()V
    //   187: aload_1
    //   188: invokevirtual 279	java/io/BufferedOutputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_2
    //   194: invokestatic 31	com/gtp/a/a/b/c:a	()Z
    //   197: ifeq -10 -> 187
    //   200: aload_2
    //   201: invokevirtual 35	java/io/IOException:printStackTrace	()V
    //   204: goto -17 -> 187
    //   207: astore_1
    //   208: invokestatic 31	com/gtp/a/a/b/c:a	()Z
    //   211: ifeq -20 -> 191
    //   214: aload_1
    //   215: invokevirtual 35	java/io/IOException:printStackTrace	()V
    //   218: goto -27 -> 191
    //   221: astore_1
    //   222: invokestatic 31	com/gtp/a/a/b/c:a	()Z
    //   225: ifeq -74 -> 151
    //   228: aload_1
    //   229: invokevirtual 35	java/io/IOException:printStackTrace	()V
    //   232: goto -81 -> 151
    //   235: astore_0
    //   236: invokestatic 31	com/gtp/a/a/b/c:a	()Z
    //   239: ifeq -143 -> 96
    //   242: aload_0
    //   243: invokevirtual 35	java/io/IOException:printStackTrace	()V
    //   246: goto -150 -> 96
    //   249: astore_0
    //   250: goto -71 -> 179
    //   253: astore_2
    //   254: aload 7
    //   256: astore_0
    //   257: goto -132 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramBitmap	Bitmap
    //   0	260	1	paramFile	File
    //   0	260	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	260	3	paramInt	int
    //   4	167	4	bool1	boolean
    //   8	153	5	bool2	boolean
    //   1	168	6	bool3	boolean
    //   29	226	7	localObject1	Object
    //   46	131	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   96	101	104	java/io/IOException
    //   48	65	122	java/lang/Exception
    //   151	155	157	java/io/IOException
    //   48	65	175	finally
    //   183	187	193	java/io/IOException
    //   187	191	207	java/io/IOException
    //   147	151	221	java/io/IOException
    //   91	96	235	java/io/IOException
    //   68	78	249	finally
    //   127	133	249	finally
    //   135	139	249	finally
    //   68	78	253	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */