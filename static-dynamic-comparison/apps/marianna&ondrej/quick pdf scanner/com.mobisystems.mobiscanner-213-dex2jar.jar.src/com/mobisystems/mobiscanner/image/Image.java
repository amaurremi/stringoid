package com.mobisystems.mobiscanner.image;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class Image
{
  private static final c apd = new c();
  private a aHg = new a();
  private a aHh = new a();
  private ImageStreamType aHi = ImageStreamType.aHp;
  byte[] aHj = null;
  FileDescriptor aHk = null;
  private File aol = null;
  private final c mLog = new c(this);
  
  public Image(File paramFile)
  {
    this.mLog.dl("Created from file=" + paramFile);
    if (paramFile == null) {
      throw new IOException("Null file object recevied");
    }
    this.aol = paramFile;
    init();
  }
  
  public Image(FileDescriptor paramFileDescriptor)
  {
    this.mLog.dl("Created from file descriptor");
    if (paramFileDescriptor == null) {
      throw new IOException("Null file descriptor recevied");
    }
    this.aHk = paramFileDescriptor;
    init();
  }
  
  public Image(byte[] paramArrayOfByte)
  {
    this.mLog.dl("Created from byte array");
    if (paramArrayOfByte == null) {
      throw new IOException("Null byte array recevied");
    }
    this.aHj = paramArrayOfByte;
    init();
  }
  
  /* Error */
  private void Ib()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 116	com/mobisystems/mobiscanner/image/ImageOrientation:aHV	Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   5: astore_2
    //   6: aload_0
    //   7: invokevirtual 120	com/mobisystems/mobiscanner/image/Image:HZ	()Ljava/io/BufferedInputStream;
    //   10: astore_3
    //   11: aload_3
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +42 -> 56
    //   17: aload_1
    //   18: astore_3
    //   19: new 88	java/io/IOException
    //   22: dup
    //   23: ldc 122
    //   25: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   28: athrow
    //   29: astore_2
    //   30: new 6	com/mobisystems/mobiscanner/image/Image$ImageException
    //   33: dup
    //   34: aload_0
    //   35: ldc 124
    //   37: invokespecial 127	com/mobisystems/mobiscanner/image/Image$ImageException:<init>	(Lcom/mobisystems/mobiscanner/image/Image;Ljava/lang/String;)V
    //   40: athrow
    //   41: astore_2
    //   42: aload_1
    //   43: astore_3
    //   44: aload_2
    //   45: astore_1
    //   46: aload_3
    //   47: ifnull +7 -> 54
    //   50: aload_3
    //   51: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   54: aload_1
    //   55: athrow
    //   56: aload_1
    //   57: astore_3
    //   58: aload_1
    //   59: iconst_0
    //   60: invokestatic 137	com/drew/imaging/a:a	(Ljava/io/BufferedInputStream;Z)Lcom/drew/metadata/d;
    //   63: ldc -117
    //   65: invokevirtual 145	com/drew/metadata/d:b	(Ljava/lang/Class;)Lcom/drew/metadata/b;
    //   68: checkcast 139	com/drew/metadata/b/h
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +132 -> 207
    //   78: aload_1
    //   79: astore_3
    //   80: aload 5
    //   82: sipush 274
    //   85: invokevirtual 149	com/drew/metadata/b/h:Y	(I)Z
    //   88: ifeq +51 -> 139
    //   91: aload_1
    //   92: astore_3
    //   93: aload 5
    //   95: sipush 274
    //   98: invokevirtual 153	com/drew/metadata/b/h:getInt	(I)I
    //   101: invokestatic 157	com/mobisystems/mobiscanner/image/ImageOrientation:gu	(I)Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   104: astore_2
    //   105: aload_1
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   111: new 68	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   118: ldc -97
    //   120: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: getfield 55	com/mobisystems/mobiscanner/image/Image:aHh	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   127: invokestatic 162	com/mobisystems/mobiscanner/image/Image$a:b	(Lcom/mobisystems/mobiscanner/image/Image$a;)Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   130: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   139: aload_2
    //   140: astore 4
    //   142: aload_1
    //   143: astore_3
    //   144: aload 5
    //   146: sipush 296
    //   149: invokevirtual 149	com/drew/metadata/b/h:Y	(I)Z
    //   152: ifeq +69 -> 221
    //   155: aload_2
    //   156: astore 4
    //   158: aload_1
    //   159: astore_3
    //   160: aload 5
    //   162: sipush 282
    //   165: invokevirtual 149	com/drew/metadata/b/h:Y	(I)Z
    //   168: ifeq +53 -> 221
    //   171: aload_1
    //   172: astore_3
    //   173: aload 5
    //   175: sipush 296
    //   178: invokevirtual 166	com/drew/metadata/b/h:getString	(I)Ljava/lang/String;
    //   181: pop
    //   182: aload_1
    //   183: ifnull +7 -> 190
    //   186: aload_1
    //   187: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   190: aload_2
    //   191: getstatic 116	com/mobisystems/mobiscanner/image/ImageOrientation:aHV	Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   194: if_acmpeq +12 -> 206
    //   197: aload_0
    //   198: getfield 55	com/mobisystems/mobiscanner/image/Image:aHh	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   201: aload_2
    //   202: invokestatic 169	com/mobisystems/mobiscanner/image/Image$a:a	(Lcom/mobisystems/mobiscanner/image/Image$a;Lcom/mobisystems/mobiscanner/image/ImageOrientation;)Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   205: pop
    //   206: return
    //   207: aload_1
    //   208: astore_3
    //   209: aload_0
    //   210: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   213: ldc -85
    //   215: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   218: aload_2
    //   219: astore 4
    //   221: aload 4
    //   223: astore_2
    //   224: goto -42 -> 182
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_1
    //   231: astore_3
    //   232: aload_0
    //   233: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   236: ldc -83
    //   238: aload_2
    //   239: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   242: aload_1
    //   243: astore_3
    //   244: new 6	com/mobisystems/mobiscanner/image/Image$ImageException
    //   247: dup
    //   248: aload_0
    //   249: ldc -77
    //   251: invokespecial 127	com/mobisystems/mobiscanner/image/Image$ImageException:<init>	(Lcom/mobisystems/mobiscanner/image/Image;Ljava/lang/String;)V
    //   254: athrow
    //   255: astore_1
    //   256: goto -210 -> 46
    //   259: astore_2
    //   260: aload_0
    //   261: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   264: ldc -75
    //   266: aload_2
    //   267: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -216 -> 54
    //   273: astore_1
    //   274: aload_0
    //   275: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   278: ldc -75
    //   280: aload_1
    //   281: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: goto -94 -> 190
    //   287: astore_1
    //   288: aconst_null
    //   289: astore_3
    //   290: goto -244 -> 46
    //   293: astore_2
    //   294: goto -64 -> 230
    //   297: astore_2
    //   298: goto -268 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	Image
    //   1	242	1	localObject1	Object
    //   255	1	1	localObject2	Object
    //   273	8	1	localIOException1	IOException
    //   287	1	1	localObject3	Object
    //   5	1	2	localImageOrientation	ImageOrientation
    //   29	1	2	localImageProcessingException1	com.drew.imaging.ImageProcessingException
    //   41	4	2	localObject4	Object
    //   104	120	2	localObject5	Object
    //   227	12	2	localMetadataException1	com.drew.metadata.MetadataException
    //   259	8	2	localIOException2	IOException
    //   293	1	2	localMetadataException2	com.drew.metadata.MetadataException
    //   297	1	2	localImageProcessingException2	com.drew.imaging.ImageProcessingException
    //   10	280	3	localObject6	Object
    //   140	82	4	localObject7	Object
    //   71	103	5	localh	com.drew.metadata.b.h
    // Exception table:
    //   from	to	target	type
    //   19	29	29	com/drew/imaging/ImageProcessingException
    //   58	73	29	com/drew/imaging/ImageProcessingException
    //   80	91	29	com/drew/imaging/ImageProcessingException
    //   93	105	29	com/drew/imaging/ImageProcessingException
    //   107	139	29	com/drew/imaging/ImageProcessingException
    //   144	155	29	com/drew/imaging/ImageProcessingException
    //   160	171	29	com/drew/imaging/ImageProcessingException
    //   173	182	29	com/drew/imaging/ImageProcessingException
    //   209	218	29	com/drew/imaging/ImageProcessingException
    //   30	41	41	finally
    //   6	11	227	com/drew/metadata/MetadataException
    //   19	29	255	finally
    //   58	73	255	finally
    //   80	91	255	finally
    //   93	105	255	finally
    //   107	139	255	finally
    //   144	155	255	finally
    //   160	171	255	finally
    //   173	182	255	finally
    //   209	218	255	finally
    //   232	242	255	finally
    //   244	255	255	finally
    //   50	54	259	java/io/IOException
    //   186	190	273	java/io/IOException
    //   6	11	287	finally
    //   19	29	293	com/drew/metadata/MetadataException
    //   58	73	293	com/drew/metadata/MetadataException
    //   80	91	293	com/drew/metadata/MetadataException
    //   93	105	293	com/drew/metadata/MetadataException
    //   107	139	293	com/drew/metadata/MetadataException
    //   144	155	293	com/drew/metadata/MetadataException
    //   160	171	293	com/drew/metadata/MetadataException
    //   173	182	293	com/drew/metadata/MetadataException
    //   209	218	293	com/drew/metadata/MetadataException
    //   6	11	297	com/drew/imaging/ImageProcessingException
  }
  
  public static int a(int paramInt1, int paramInt2, ImageOrientation paramImageOrientation, int paramInt3, int paramInt4, RestrictMemory paramRestrictMemory)
  {
    apd.dl("calculateInSampleSize called, width=" + paramInt1 + ", height=" + paramInt2 + ", reqWitdh=" + paramInt3 + ", reqHeight=" + paramInt4 + ", orientation=" + paramImageOrientation + ", restrictMemory=" + paramRestrictMemory);
    if ((paramInt4 > 0) && (paramInt3 > 0))
    {
      int i;
      if (paramInt3 >= paramInt4)
      {
        i = Math.max(paramInt1, paramInt2);
        paramInt1 = Math.min(paramInt1, paramInt2);
        paramInt2 = i;
        if ((paramInt2 <= paramInt3) && (paramInt1 <= paramInt4)) {
          break label457;
        }
        if (paramRestrictMemory != RestrictMemory.aHw) {
          break label261;
        }
        paramInt2 = (int)Math.floor(paramInt2 / paramInt3);
        paramInt1 = (int)Math.floor(paramInt1 / paramInt4);
        apd.dl("calculateInSampleSize: widthRatio=" + paramInt2 + ", heightRatio=" + paramInt1 + ", restrictMemory=" + paramRestrictMemory);
        if (paramInt1 >= paramInt2) {
          break label231;
        }
        paramInt2 = paramInt1;
      }
      label231:
      for (;;)
      {
        paramInt1 = 1;
        while (paramInt2 >= paramInt1 * 2) {
          paramInt1 *= 2;
        }
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        paramInt2 = i;
        break;
      }
    }
    for (;;)
    {
      apd.dl("calculateInSampleSize return: " + paramInt1);
      return paramInt1;
      label261:
      if (paramRestrictMemory == RestrictMemory.aHx)
      {
        paramInt2 = (int)Math.floor(paramInt2 / paramInt3);
        paramInt1 = (int)Math.floor(paramInt1 / paramInt4);
        apd.dl("calculateInSampleSize: widthRatio=" + paramInt2 + ", heightRatio=" + paramInt1 + ", restrictMemory=" + paramRestrictMemory);
        if (paramInt1 < paramInt2) {
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          paramInt1 = 2;
          while (paramInt2 > paramInt1) {
            paramInt1 *= 2;
          }
        }
      }
      else
      {
        paramInt2 = (int)Math.ceil(paramInt2 / paramInt3);
        paramInt1 = (int)Math.ceil(paramInt1 / paramInt4);
        apd.dl("calculateInSampleSize: widthRatio=" + paramInt2 + ", heightRatio=" + paramInt1 + ", restrictMemory=" + paramRestrictMemory);
        if (paramInt1 > paramInt2) {
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          paramInt1 = 1;
          while (paramInt2 > paramInt1) {
            paramInt1 *= 2;
          }
        }
        continue;
        label457:
        paramInt1 = 1;
      }
    }
  }
  
  public static boolean a(String paramString, ImageOrientation paramImageOrientation)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      paramString.setAttribute("Orientation", String.valueOf(paramImageOrientation.Ik()));
      paramString.saveAttributes();
      return false;
    }
    catch (IOException paramString)
    {
      apd.g("Error setting image orienation in file", paramString);
    }
    return false;
  }
  
  private void init()
  {
    int j = 1;
    int k = 0;
    Object localObject = null;
    try
    {
      BufferedInputStream localBufferedInputStream = HZ();
      if (localBufferedInputStream == null)
      {
        localObject = localBufferedInputStream;
        throw new IOException("Null image stream");
      }
    }
    finally
    {
      if (localObject == null) {}
    }
    byte[] arrayOfByte;
    int i;
    try
    {
      ((BufferedInputStream)localObject).close();
      throw localInputStream;
      localObject = localInputStream;
      localInputStream.mark(100);
      localObject = localInputStream;
      arrayOfByte = new byte[12];
      localObject = localInputStream;
      localInputStream.read(arrayOfByte, 0, 12);
      localObject = localInputStream;
      localInputStream.reset();
      localObject = localInputStream;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localObject = localInputStream;
      localOptions.inJustDecodeBounds = true;
      localObject = localInputStream;
      BitmapFactory.decodeStream(localInputStream, null, localOptions);
      localObject = localInputStream;
      if (localOptions.outWidth != -1)
      {
        localObject = localInputStream;
        if (localOptions.outHeight != -1) {}
      }
      else
      {
        localObject = localInputStream;
        throw new InvalidImageTypeException("Could not decode bitmap image");
      }
      localObject = localInputStream;
      this.mLog.dl("init, width=" + localOptions.outWidth + ", height=" + localOptions.outHeight + ", mime type=" + localOptions.outMimeType);
      localObject = localInputStream;
      a.a(this.aHh, localOptions.outWidth);
      localObject = localInputStream;
      a.b(this.aHh, localOptions.outHeight);
      localObject = localInputStream;
      a.a(this.aHh, ImageOrientation.aHW);
      localObject = localInputStream;
      this.aHi = ImageStreamType.dN(localOptions.outMimeType);
      localObject = localInputStream;
      if (this.aHi == ImageStreamType.aHp)
      {
        localObject = localInputStream;
        if (localOptions.outMimeType == null)
        {
          i = 0;
          break label527;
          if ((i != 0) && (j != 0))
          {
            localObject = localInputStream;
            this.aHi = ImageStreamType.aHt;
          }
        }
      }
      localObject = localInputStream;
      if (this.aHi == ImageStreamType.aHp)
      {
        localObject = localInputStream;
        throw new InvalidImageTypeException("Unsupported image type: " + localOptions.outMimeType);
      }
      localObject = localInputStream;
      this.mLog.dl("init, Image Stream Type=" + this.aHi);
      localObject = localInputStream;
      if (this.aHi == ImageStreamType.aHq)
      {
        localObject = localInputStream;
        Ib();
        localObject = localInputStream;
        a.c(this.aHh, 72);
      }
      if (localInputStream == null) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localInputStream.close();
        a.a(this.aHg, this.aHh);
        return;
        localIOException1 = localIOException1;
        this.mLog.g("Could not close input stream", localIOException1);
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          this.mLog.g("Could not close input stream", localIOException2);
        }
      }
    }
    label527:
    label624:
    for (;;)
    {
      i = 1;
      break;
      for (;;)
      {
        if (i >= 4) {
          break label624;
        }
        if (new byte[] { 82, 73, 70, 70 }[i] != arrayOfByte[i])
        {
          i = k;
          break;
        }
        if (new byte[] { 87, 69, 66, 80 }[i] != arrayOfByte[(i + 8)])
        {
          i = 1;
          j = 0;
          break;
        }
        i += 1;
      }
    }
  }
  
  public a HW()
  {
    return this.aHg;
  }
  
  public a HX()
  {
    return this.aHh;
  }
  
  public ImageStreamType HY()
  {
    return this.aHi;
  }
  
  public BufferedInputStream HZ()
  {
    do
    {
      try
      {
        if (this.aol != null) {
          return new BufferedInputStream(new FileInputStream(this.aol));
        }
        if (this.aHj != null)
        {
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(this.aHj));
          return localBufferedInputStream;
        }
      }
      catch (IOException localIOException)
      {
        this.mLog.g("IO Exception getting input stream", localIOException);
        return null;
      }
    } while (this.aHk == null);
    Object localObject = new FileInputStream(this.aHk);
    ((FileInputStream)localObject).getChannel().position(0L);
    localObject = new BufferedInputStream((InputStream)localObject);
    return (BufferedInputStream)localObject;
  }
  
  public File Ia()
  {
    return this.aol;
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public android.graphics.Bitmap a(int paramInt1, int paramInt2, k paramk, RestrictMemory paramRestrictMemory)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: new 68	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 369
    //   14: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_1
    //   18: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: ldc -63
    //   23: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_2
    //   27: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   36: new 263	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 264	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 11
    //   45: aload 11
    //   47: aload_0
    //   48: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   51: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   54: putfield 281	android/graphics/BitmapFactory$Options:outHeight	I
    //   57: aload 11
    //   59: aload_0
    //   60: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   63: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   66: putfield 278	android/graphics/BitmapFactory$Options:outWidth	I
    //   69: aload 11
    //   71: aload_0
    //   72: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   75: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   78: aload_0
    //   79: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   82: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   85: aload_0
    //   86: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   89: invokevirtual 379	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   92: iload_1
    //   93: iload_2
    //   94: aload 4
    //   96: invokestatic 381	com/mobisystems/mobiscanner/image/Image:a	(IILcom/mobisystems/mobiscanner/image/ImageOrientation;IILcom/mobisystems/mobiscanner/image/Image$RestrictMemory;)I
    //   99: putfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   102: aload 11
    //   104: iconst_0
    //   105: putfield 268	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   108: invokestatic 390	com/mobisystems/mobiscanner/common/d:Dw	()Z
    //   111: ifeq +60 -> 171
    //   114: aload_3
    //   115: ifnull +56 -> 171
    //   118: aload 11
    //   120: iconst_1
    //   121: putfield 393	android/graphics/BitmapFactory$Options:inMutable	Z
    //   124: aload_3
    //   125: aload 11
    //   127: invokevirtual 398	com/mobisystems/mobiscanner/image/k:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +39 -> 171
    //   135: aload_0
    //   136: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   139: new 68	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 400
    //   149: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aconst_null
    //   153: invokestatic 404	com/mobisystems/mobiscanner/common/d:ay	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   165: aload 11
    //   167: aload_3
    //   168: putfield 408	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   171: aconst_null
    //   172: astore_3
    //   173: iconst_0
    //   174: istore_2
    //   175: iconst_0
    //   176: istore_1
    //   177: aconst_null
    //   178: astore 9
    //   180: aload_0
    //   181: invokevirtual 120	com/mobisystems/mobiscanner/image/Image:HZ	()Ljava/io/BufferedInputStream;
    //   184: astore 10
    //   186: aload 10
    //   188: ifnonnull +193 -> 381
    //   191: aload 10
    //   193: astore 9
    //   195: aload 10
    //   197: astore 8
    //   199: new 88	java/io/IOException
    //   202: dup
    //   203: ldc_w 410
    //   206: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   209: athrow
    //   210: astore 4
    //   212: aload 9
    //   214: astore 8
    //   216: aload 11
    //   218: aload 11
    //   220: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   223: iconst_2
    //   224: imul
    //   225: putfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   228: aload 9
    //   230: astore 8
    //   232: aload 11
    //   234: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   237: aload_0
    //   238: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   241: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   244: if_icmpge +168 -> 412
    //   247: aload 9
    //   249: astore 8
    //   251: aload 11
    //   253: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   256: aload_0
    //   257: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   260: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   263: if_icmpge +149 -> 412
    //   266: aload 9
    //   268: astore 8
    //   270: aload_0
    //   271: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   274: new 68	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 412
    //   284: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 11
    //   289: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   292: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   301: iconst_1
    //   302: istore_1
    //   303: aload_3
    //   304: astore 4
    //   306: iload_1
    //   307: istore_2
    //   308: aload 9
    //   310: ifnull +16 -> 326
    //   313: aload_3
    //   314: astore 8
    //   316: aload 9
    //   318: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   321: iload_1
    //   322: istore_2
    //   323: aload_3
    //   324: astore 4
    //   326: aload 4
    //   328: astore_3
    //   329: iload_2
    //   330: ifne -157 -> 173
    //   333: aload 4
    //   335: ifnonnull +141 -> 476
    //   338: aload 4
    //   340: astore 9
    //   342: aload 4
    //   344: astore 8
    //   346: new 6	com/mobisystems/mobiscanner/image/Image$ImageException
    //   349: dup
    //   350: aload_0
    //   351: ldc_w 417
    //   354: invokespecial 127	com/mobisystems/mobiscanner/image/Image$ImageException:<init>	(Lcom/mobisystems/mobiscanner/image/Image;Ljava/lang/String;)V
    //   357: athrow
    //   358: astore 4
    //   360: aload 9
    //   362: astore_3
    //   363: aload_0
    //   364: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   367: ldc_w 419
    //   370: aload 4
    //   372: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   375: aload_3
    //   376: astore 8
    //   378: aload 8
    //   380: areturn
    //   381: aload 10
    //   383: astore 9
    //   385: aload 10
    //   387: astore 8
    //   389: aload 10
    //   391: aconst_null
    //   392: aload 11
    //   394: invokestatic 274	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   397: astore 4
    //   399: aload 10
    //   401: ifnull +8 -> 409
    //   404: aload 10
    //   406: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   409: goto -83 -> 326
    //   412: aload 9
    //   414: astore 8
    //   416: aload_0
    //   417: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   420: ldc_w 421
    //   423: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   426: goto -123 -> 303
    //   429: astore 4
    //   431: aload 8
    //   433: astore 9
    //   435: aload 9
    //   437: ifnull +11 -> 448
    //   440: aload_3
    //   441: astore 8
    //   443: aload 9
    //   445: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   448: aload_3
    //   449: astore 9
    //   451: aload_3
    //   452: astore 8
    //   454: aload 4
    //   456: athrow
    //   457: astore_3
    //   458: aload 8
    //   460: astore 4
    //   462: aload_0
    //   463: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   466: ldc_w 423
    //   469: aload_3
    //   470: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   473: aload 4
    //   475: areturn
    //   476: aload 4
    //   478: astore 9
    //   480: aload 4
    //   482: astore 8
    //   484: aload_0
    //   485: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   488: invokevirtual 379	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   491: invokestatic 428	com/mobisystems/mobiscanner/image/ImageProcessing:c	(Lcom/mobisystems/mobiscanner/image/ImageOrientation;)Landroid/graphics/Matrix;
    //   494: astore 12
    //   496: aload 4
    //   498: astore 9
    //   500: aload 4
    //   502: astore 8
    //   504: aload 12
    //   506: invokevirtual 433	android/graphics/Matrix:isIdentity	()Z
    //   509: istore 7
    //   511: iload 7
    //   513: ifne +420 -> 933
    //   516: aconst_null
    //   517: astore 10
    //   519: aconst_null
    //   520: astore_3
    //   521: aload_3
    //   522: astore 8
    //   524: aload 10
    //   526: astore 9
    //   528: aload 11
    //   530: getfield 278	android/graphics/BitmapFactory$Options:outWidth	I
    //   533: istore 5
    //   535: aload_3
    //   536: astore 8
    //   538: aload 10
    //   540: astore 9
    //   542: aload 11
    //   544: getfield 281	android/graphics/BitmapFactory$Options:outHeight	I
    //   547: istore 6
    //   549: iconst_1
    //   550: istore_1
    //   551: aconst_null
    //   552: astore_3
    //   553: aload_3
    //   554: astore 8
    //   556: iload_1
    //   557: iconst_1
    //   558: if_icmple +366 -> 924
    //   561: aload_3
    //   562: astore 10
    //   564: aload_3
    //   565: astore 8
    //   567: aload_3
    //   568: astore 9
    //   570: aload 4
    //   572: iload 5
    //   574: iload 6
    //   576: iconst_0
    //   577: invokestatic 439	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   580: astore_3
    //   581: aload_3
    //   582: astore 8
    //   584: aload_3
    //   585: aload 4
    //   587: if_acmpeq +337 -> 924
    //   590: aload_3
    //   591: astore 10
    //   593: aload_3
    //   594: astore 8
    //   596: aload_3
    //   597: astore 9
    //   599: aload 4
    //   601: invokevirtual 442	android/graphics/Bitmap:recycle	()V
    //   604: aload_3
    //   605: astore 4
    //   607: aload 4
    //   609: iconst_0
    //   610: iconst_0
    //   611: iload 5
    //   613: iload 6
    //   615: aload 12
    //   617: iconst_0
    //   618: invokestatic 446	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   621: astore 8
    //   623: iconst_0
    //   624: istore_2
    //   625: aload 8
    //   627: astore_3
    //   628: iload_2
    //   629: ifne +301 -> 930
    //   632: aload_3
    //   633: ifnonnull +115 -> 748
    //   636: aload 4
    //   638: areturn
    //   639: astore_3
    //   640: aload 10
    //   642: astore_3
    //   643: iload_1
    //   644: iconst_2
    //   645: imul
    //   646: istore_1
    //   647: aload_3
    //   648: astore 8
    //   650: aload_3
    //   651: astore 9
    //   653: aload 11
    //   655: getfield 278	android/graphics/BitmapFactory$Options:outWidth	I
    //   658: iload_1
    //   659: idiv
    //   660: istore 5
    //   662: aload_3
    //   663: astore 8
    //   665: aload_3
    //   666: astore 9
    //   668: aload 11
    //   670: getfield 281	android/graphics/BitmapFactory$Options:outHeight	I
    //   673: iload_1
    //   674: idiv
    //   675: istore 6
    //   677: iload 5
    //   679: iconst_1
    //   680: if_icmple +47 -> 727
    //   683: iload 6
    //   685: iconst_1
    //   686: if_icmple +41 -> 727
    //   689: aload_3
    //   690: astore 8
    //   692: aload_3
    //   693: astore 9
    //   695: aload_0
    //   696: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   699: new 68	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   706: ldc_w 448
    //   709: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: iload_1
    //   713: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   722: iconst_1
    //   723: istore_2
    //   724: goto -96 -> 628
    //   727: aload_3
    //   728: astore 8
    //   730: aload_3
    //   731: astore 9
    //   733: aload_0
    //   734: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   737: ldc_w 450
    //   740: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   743: iconst_0
    //   744: istore_2
    //   745: goto -117 -> 628
    //   748: aload_3
    //   749: astore 8
    //   751: aload_3
    //   752: aload 4
    //   754: if_acmpeq -376 -> 378
    //   757: aload_3
    //   758: astore 8
    //   760: aload_3
    //   761: astore 9
    //   763: aload 4
    //   765: invokevirtual 442	android/graphics/Bitmap:recycle	()V
    //   768: aload_3
    //   769: areturn
    //   770: astore 4
    //   772: aload 8
    //   774: astore_3
    //   775: goto -412 -> 363
    //   778: astore 10
    //   780: aload_3
    //   781: astore 9
    //   783: aload_3
    //   784: astore 8
    //   786: aload_0
    //   787: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   790: ldc -75
    //   792: aload 10
    //   794: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   797: goto -349 -> 448
    //   800: astore 4
    //   802: aload_3
    //   803: astore 9
    //   805: aload_3
    //   806: astore 8
    //   808: aload_0
    //   809: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   812: ldc -75
    //   814: aload 4
    //   816: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   819: aload_3
    //   820: astore 4
    //   822: iload_1
    //   823: istore_2
    //   824: goto -498 -> 326
    //   827: astore_3
    //   828: aload_0
    //   829: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   832: ldc -75
    //   834: aload_3
    //   835: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   838: goto -429 -> 409
    //   841: astore 8
    //   843: aload 4
    //   845: astore_3
    //   846: aload 8
    //   848: astore 4
    //   850: goto -487 -> 363
    //   853: astore_3
    //   854: aconst_null
    //   855: astore 4
    //   857: goto -395 -> 462
    //   860: astore_3
    //   861: aload 9
    //   863: astore 4
    //   865: goto -403 -> 462
    //   868: astore_3
    //   869: aload 8
    //   871: astore 4
    //   873: goto -411 -> 462
    //   876: astore 8
    //   878: aload_3
    //   879: astore 4
    //   881: aload 8
    //   883: astore_3
    //   884: goto -422 -> 462
    //   887: astore_3
    //   888: goto -426 -> 462
    //   891: astore 4
    //   893: aconst_null
    //   894: astore_3
    //   895: goto -532 -> 363
    //   898: astore 4
    //   900: aload 9
    //   902: astore_3
    //   903: goto -540 -> 363
    //   906: astore 4
    //   908: goto -545 -> 363
    //   911: astore 8
    //   913: goto -270 -> 643
    //   916: astore 4
    //   918: aconst_null
    //   919: astore 9
    //   921: goto -486 -> 435
    //   924: aload 8
    //   926: astore_3
    //   927: goto -320 -> 607
    //   930: goto -377 -> 553
    //   933: aload 4
    //   935: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	936	0	this	Image
    //   0	936	1	paramInt1	int
    //   0	936	2	paramInt2	int
    //   0	936	3	paramk	k
    //   0	936	4	paramRestrictMemory	RestrictMemory
    //   533	148	5	i	int
    //   547	140	6	j	int
    //   509	3	7	bool	boolean
    //   197	610	8	localObject1	Object
    //   841	29	8	localIOException1	IOException
    //   876	6	8	localImageException	ImageException
    //   911	14	8	localOutOfMemoryError	OutOfMemoryError
    //   178	742	9	localObject2	Object
    //   184	457	10	localObject3	Object
    //   778	15	10	localIOException2	IOException
    //   43	626	11	localOptions	BitmapFactory.Options
    //   494	122	12	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   180	186	210	java/lang/OutOfMemoryError
    //   199	210	210	java/lang/OutOfMemoryError
    //   389	399	210	java/lang/OutOfMemoryError
    //   346	358	358	java/io/IOException
    //   454	457	358	java/io/IOException
    //   484	496	358	java/io/IOException
    //   504	511	358	java/io/IOException
    //   786	797	358	java/io/IOException
    //   808	819	358	java/io/IOException
    //   199	210	429	finally
    //   216	228	429	finally
    //   232	247	429	finally
    //   251	266	429	finally
    //   270	301	429	finally
    //   389	399	429	finally
    //   416	426	429	finally
    //   316	321	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   346	358	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   443	448	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   454	457	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   484	496	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   504	511	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   786	797	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   808	819	457	com/mobisystems/mobiscanner/image/Image$ImageException
    //   570	581	639	java/lang/OutOfMemoryError
    //   599	604	639	java/lang/OutOfMemoryError
    //   528	535	770	java/io/IOException
    //   542	549	770	java/io/IOException
    //   763	768	770	java/io/IOException
    //   443	448	778	java/io/IOException
    //   316	321	800	java/io/IOException
    //   404	409	827	java/io/IOException
    //   828	838	841	java/io/IOException
    //   36	114	853	com/mobisystems/mobiscanner/image/Image$ImageException
    //   118	131	853	com/mobisystems/mobiscanner/image/Image$ImageException
    //   135	171	853	com/mobisystems/mobiscanner/image/Image$ImageException
    //   528	535	860	com/mobisystems/mobiscanner/image/Image$ImageException
    //   542	549	860	com/mobisystems/mobiscanner/image/Image$ImageException
    //   763	768	860	com/mobisystems/mobiscanner/image/Image$ImageException
    //   570	581	868	com/mobisystems/mobiscanner/image/Image$ImageException
    //   599	604	868	com/mobisystems/mobiscanner/image/Image$ImageException
    //   653	662	868	com/mobisystems/mobiscanner/image/Image$ImageException
    //   668	677	868	com/mobisystems/mobiscanner/image/Image$ImageException
    //   695	722	868	com/mobisystems/mobiscanner/image/Image$ImageException
    //   733	743	868	com/mobisystems/mobiscanner/image/Image$ImageException
    //   607	623	876	com/mobisystems/mobiscanner/image/Image$ImageException
    //   404	409	887	com/mobisystems/mobiscanner/image/Image$ImageException
    //   828	838	887	com/mobisystems/mobiscanner/image/Image$ImageException
    //   36	114	891	java/io/IOException
    //   118	131	891	java/io/IOException
    //   135	171	891	java/io/IOException
    //   570	581	898	java/io/IOException
    //   599	604	898	java/io/IOException
    //   653	662	898	java/io/IOException
    //   668	677	898	java/io/IOException
    //   695	722	898	java/io/IOException
    //   733	743	898	java/io/IOException
    //   607	623	906	java/io/IOException
    //   607	623	911	java/lang/OutOfMemoryError
    //   180	186	916	finally
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public android.graphics.Bitmap b(int paramInt1, int paramInt2, k paramk, RestrictMemory paramRestrictMemory)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   7: new 68	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 453
    //   17: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_1
    //   21: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc -63
    //   26: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_2
    //   30: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   39: new 263	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 264	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 8
    //   48: aload 8
    //   50: aload_0
    //   51: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   54: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   57: putfield 281	android/graphics/BitmapFactory$Options:outHeight	I
    //   60: aload 8
    //   62: aload_0
    //   63: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   66: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   69: putfield 278	android/graphics/BitmapFactory$Options:outWidth	I
    //   72: aload 8
    //   74: aload_0
    //   75: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   78: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   81: aload_0
    //   82: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   85: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   88: aload_0
    //   89: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   92: invokevirtual 379	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   95: iload_1
    //   96: iload_2
    //   97: aload 4
    //   99: invokestatic 381	com/mobisystems/mobiscanner/image/Image:a	(IILcom/mobisystems/mobiscanner/image/ImageOrientation;IILcom/mobisystems/mobiscanner/image/Image$RestrictMemory;)I
    //   102: putfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   105: aload 8
    //   107: iconst_0
    //   108: putfield 268	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: invokestatic 390	com/mobisystems/mobiscanner/common/d:Dw	()Z
    //   114: ifeq +60 -> 174
    //   117: aload_3
    //   118: ifnull +56 -> 174
    //   121: aload 8
    //   123: iconst_1
    //   124: putfield 393	android/graphics/BitmapFactory$Options:inMutable	Z
    //   127: aload_3
    //   128: aload 8
    //   130: invokevirtual 398	com/mobisystems/mobiscanner/image/k:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +39 -> 174
    //   138: aload_0
    //   139: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   142: new 68	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 400
    //   152: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aconst_null
    //   156: invokestatic 404	com/mobisystems/mobiscanner/common/d:ay	(Ljava/lang/Object;)Ljava/lang/String;
    //   159: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   168: aload 8
    //   170: aload_3
    //   171: putfield 408	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   174: aconst_null
    //   175: astore 4
    //   177: aload_0
    //   178: invokevirtual 120	com/mobisystems/mobiscanner/image/Image:HZ	()Ljava/io/BufferedInputStream;
    //   181: astore 6
    //   183: aload 6
    //   185: ifnonnull +185 -> 370
    //   188: aload 6
    //   190: astore 5
    //   192: new 88	java/io/IOException
    //   195: dup
    //   196: ldc_w 410
    //   199: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   202: athrow
    //   203: astore_3
    //   204: aload 6
    //   206: astore 5
    //   208: aload 8
    //   210: aload 8
    //   212: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   215: iconst_2
    //   216: imul
    //   217: putfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   220: aload 6
    //   222: astore 5
    //   224: aload 8
    //   226: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   229: aload_0
    //   230: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   233: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   236: if_icmpge +162 -> 398
    //   239: aload 6
    //   241: astore 5
    //   243: aload 8
    //   245: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   248: aload_0
    //   249: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   252: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   255: if_icmpge +143 -> 398
    //   258: aload 6
    //   260: astore 5
    //   262: aload_0
    //   263: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   266: new 68	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 412
    //   276: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 8
    //   281: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   284: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   293: iconst_1
    //   294: istore_1
    //   295: aload 4
    //   297: astore_3
    //   298: iload_1
    //   299: istore_2
    //   300: aload 6
    //   302: ifnull +16 -> 318
    //   305: aload 4
    //   307: astore_3
    //   308: aload 6
    //   310: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   313: iload_1
    //   314: istore_2
    //   315: aload 4
    //   317: astore_3
    //   318: aload_3
    //   319: astore 4
    //   321: iload_2
    //   322: ifne -145 -> 177
    //   325: aload_3
    //   326: astore 4
    //   328: aload_3
    //   329: ifnonnull +38 -> 367
    //   332: aload_3
    //   333: astore 5
    //   335: new 6	com/mobisystems/mobiscanner/image/Image$ImageException
    //   338: dup
    //   339: aload_0
    //   340: ldc_w 417
    //   343: invokespecial 127	com/mobisystems/mobiscanner/image/Image$ImageException:<init>	(Lcom/mobisystems/mobiscanner/image/Image;Ljava/lang/String;)V
    //   346: athrow
    //   347: astore 4
    //   349: aload 5
    //   351: astore_3
    //   352: aload_0
    //   353: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   356: ldc_w 419
    //   359: aload 4
    //   361: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   364: aload_3
    //   365: astore 4
    //   367: aload 4
    //   369: areturn
    //   370: aload 6
    //   372: astore 5
    //   374: aload 6
    //   376: aconst_null
    //   377: aload 8
    //   379: invokestatic 274	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   382: astore_3
    //   383: aload 6
    //   385: ifnull +8 -> 393
    //   388: aload 6
    //   390: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   393: iconst_0
    //   394: istore_2
    //   395: goto -77 -> 318
    //   398: aload 6
    //   400: astore 5
    //   402: aload_0
    //   403: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   406: ldc_w 421
    //   409: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   412: iconst_0
    //   413: istore_1
    //   414: goto -119 -> 295
    //   417: astore 6
    //   419: aload 7
    //   421: astore 5
    //   423: aload 5
    //   425: ifnull +11 -> 436
    //   428: aload 4
    //   430: astore_3
    //   431: aload 5
    //   433: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   436: aload 4
    //   438: astore 5
    //   440: aload 4
    //   442: astore_3
    //   443: aload 6
    //   445: athrow
    //   446: astore 4
    //   448: aload_0
    //   449: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   452: ldc_w 423
    //   455: aload 4
    //   457: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   460: aload_3
    //   461: areturn
    //   462: astore 7
    //   464: aload 4
    //   466: astore 5
    //   468: aload 4
    //   470: astore_3
    //   471: aload_0
    //   472: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   475: ldc -75
    //   477: aload 7
    //   479: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   482: goto -46 -> 436
    //   485: astore 6
    //   487: aload 4
    //   489: astore 5
    //   491: aload 4
    //   493: astore_3
    //   494: aload_0
    //   495: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   498: ldc -75
    //   500: aload 6
    //   502: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   505: aload 4
    //   507: astore_3
    //   508: iload_1
    //   509: istore_2
    //   510: goto -192 -> 318
    //   513: astore 4
    //   515: aload_0
    //   516: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   519: ldc -75
    //   521: aload 4
    //   523: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   526: goto -133 -> 393
    //   529: astore 4
    //   531: goto -179 -> 352
    //   534: astore 4
    //   536: aconst_null
    //   537: astore_3
    //   538: goto -90 -> 448
    //   541: astore 4
    //   543: goto -95 -> 448
    //   546: astore 4
    //   548: aconst_null
    //   549: astore_3
    //   550: goto -198 -> 352
    //   553: astore 6
    //   555: goto -132 -> 423
    //   558: astore_3
    //   559: aconst_null
    //   560: astore 6
    //   562: goto -358 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	Image
    //   0	565	1	paramInt1	int
    //   0	565	2	paramInt2	int
    //   0	565	3	paramk	k
    //   0	565	4	paramRestrictMemory	RestrictMemory
    //   190	300	5	localObject1	Object
    //   181	218	6	localBufferedInputStream	BufferedInputStream
    //   417	27	6	localObject2	Object
    //   485	16	6	localIOException1	IOException
    //   553	1	6	localObject3	Object
    //   560	1	6	localObject4	Object
    //   1	419	7	localObject5	Object
    //   462	16	7	localIOException2	IOException
    //   46	332	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   192	203	203	java/lang/OutOfMemoryError
    //   374	383	203	java/lang/OutOfMemoryError
    //   335	347	347	java/io/IOException
    //   443	446	347	java/io/IOException
    //   471	482	347	java/io/IOException
    //   494	505	347	java/io/IOException
    //   177	183	417	finally
    //   308	313	446	com/mobisystems/mobiscanner/image/Image$ImageException
    //   335	347	446	com/mobisystems/mobiscanner/image/Image$ImageException
    //   431	436	446	com/mobisystems/mobiscanner/image/Image$ImageException
    //   443	446	446	com/mobisystems/mobiscanner/image/Image$ImageException
    //   471	482	446	com/mobisystems/mobiscanner/image/Image$ImageException
    //   494	505	446	com/mobisystems/mobiscanner/image/Image$ImageException
    //   431	436	462	java/io/IOException
    //   308	313	485	java/io/IOException
    //   388	393	513	java/io/IOException
    //   515	526	529	java/io/IOException
    //   39	117	534	com/mobisystems/mobiscanner/image/Image$ImageException
    //   121	134	534	com/mobisystems/mobiscanner/image/Image$ImageException
    //   138	174	534	com/mobisystems/mobiscanner/image/Image$ImageException
    //   388	393	541	com/mobisystems/mobiscanner/image/Image$ImageException
    //   515	526	541	com/mobisystems/mobiscanner/image/Image$ImageException
    //   39	117	546	java/io/IOException
    //   121	134	546	java/io/IOException
    //   138	174	546	java/io/IOException
    //   192	203	553	finally
    //   208	220	553	finally
    //   224	239	553	finally
    //   243	258	553	finally
    //   262	293	553	finally
    //   374	383	553	finally
    //   402	412	553	finally
    //   177	183	558	java/lang/OutOfMemoryError
  }
  
  public void b(ImageOrientation paramImageOrientation)
  {
    a.a(this.aHg, paramImageOrientation);
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public android.graphics.Bitmap c(int paramInt1, int paramInt2, k paramk, RestrictMemory paramRestrictMemory)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: new 68	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 456
    //   14: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_1
    //   18: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: ldc -63
    //   23: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_2
    //   27: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   36: new 263	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 264	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 13
    //   45: aload_0
    //   46: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   49: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   52: istore 7
    //   54: aload_0
    //   55: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   58: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   61: istore 8
    //   63: aload_0
    //   64: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   67: invokevirtual 379	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   70: astore 10
    //   72: iload 8
    //   74: istore 6
    //   76: iload 7
    //   78: istore 5
    //   80: iload 8
    //   82: iload 7
    //   84: if_icmple +45 -> 129
    //   87: aload 10
    //   89: getstatic 300	com/mobisystems/mobiscanner/image/ImageOrientation:aHW	Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   92: if_acmpeq +19 -> 111
    //   95: iload 8
    //   97: istore 6
    //   99: iload 7
    //   101: istore 5
    //   103: aload 10
    //   105: getstatic 459	com/mobisystems/mobiscanner/image/ImageOrientation:aHY	Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   108: if_acmpne +21 -> 129
    //   111: aload_0
    //   112: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   115: invokevirtual 375	com/mobisystems/mobiscanner/image/Image$a:width	()I
    //   118: istore 5
    //   120: aload_0
    //   121: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   124: invokevirtual 372	com/mobisystems/mobiscanner/image/Image$a:height	()I
    //   127: istore 6
    //   129: aload 13
    //   131: iload 5
    //   133: putfield 281	android/graphics/BitmapFactory$Options:outHeight	I
    //   136: aload 13
    //   138: iload 6
    //   140: putfield 278	android/graphics/BitmapFactory$Options:outWidth	I
    //   143: aload 13
    //   145: iload 6
    //   147: iload 5
    //   149: aload 10
    //   151: iload_1
    //   152: iload_2
    //   153: aload 4
    //   155: invokestatic 381	com/mobisystems/mobiscanner/image/Image:a	(IILcom/mobisystems/mobiscanner/image/ImageOrientation;IILcom/mobisystems/mobiscanner/image/Image$RestrictMemory;)I
    //   158: putfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   161: aload 13
    //   163: iconst_0
    //   164: putfield 268	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   167: invokestatic 390	com/mobisystems/mobiscanner/common/d:Dw	()Z
    //   170: ifeq +60 -> 230
    //   173: aload_3
    //   174: ifnull +56 -> 230
    //   177: aload 13
    //   179: iconst_1
    //   180: putfield 393	android/graphics/BitmapFactory$Options:inMutable	Z
    //   183: aload_3
    //   184: aload 13
    //   186: invokevirtual 398	com/mobisystems/mobiscanner/image/k:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   189: astore_3
    //   190: aload_3
    //   191: ifnull +39 -> 230
    //   194: aload_0
    //   195: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   198: new 68	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 400
    //   208: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aconst_null
    //   212: invokestatic 404	com/mobisystems/mobiscanner/common/d:ay	(Ljava/lang/Object;)Ljava/lang/String;
    //   215: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 86	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   224: aload 13
    //   226: aload_3
    //   227: putfield 408	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   230: aconst_null
    //   231: astore 4
    //   233: iconst_0
    //   234: istore_2
    //   235: iconst_0
    //   236: istore_1
    //   237: aconst_null
    //   238: astore 12
    //   240: aconst_null
    //   241: astore 11
    //   243: aload_0
    //   244: invokevirtual 120	com/mobisystems/mobiscanner/image/Image:HZ	()Ljava/io/BufferedInputStream;
    //   247: astore 10
    //   249: aload 10
    //   251: ifnonnull +180 -> 431
    //   254: aload 10
    //   256: astore 11
    //   258: aload 10
    //   260: astore 12
    //   262: new 88	java/io/IOException
    //   265: dup
    //   266: ldc_w 410
    //   269: invokespecial 92	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   272: athrow
    //   273: astore_3
    //   274: aload 11
    //   276: astore 12
    //   278: aload 13
    //   280: aload 13
    //   282: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   285: iconst_2
    //   286: imul
    //   287: putfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   290: aload 11
    //   292: astore 12
    //   294: aload 13
    //   296: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   299: iload 5
    //   301: if_icmpge +160 -> 461
    //   304: aload 11
    //   306: astore 12
    //   308: aload 13
    //   310: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   313: iload 6
    //   315: if_icmpge +146 -> 461
    //   318: aload 11
    //   320: astore 12
    //   322: aload_0
    //   323: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   326: new 68	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 412
    //   336: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 13
    //   341: getfield 384	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   344: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   353: iconst_1
    //   354: istore_1
    //   355: aload 4
    //   357: astore_3
    //   358: iload_1
    //   359: istore_2
    //   360: aload 11
    //   362: ifnull +17 -> 379
    //   365: aload 4
    //   367: astore 10
    //   369: aload 11
    //   371: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   374: iload_1
    //   375: istore_2
    //   376: aload 4
    //   378: astore_3
    //   379: aload_3
    //   380: astore 4
    //   382: iload_2
    //   383: ifne -150 -> 233
    //   386: aload_3
    //   387: ifnonnull +135 -> 522
    //   390: aload_3
    //   391: astore 11
    //   393: aload_3
    //   394: astore 10
    //   396: new 6	com/mobisystems/mobiscanner/image/Image$ImageException
    //   399: dup
    //   400: aload_0
    //   401: ldc_w 417
    //   404: invokespecial 127	com/mobisystems/mobiscanner/image/Image$ImageException:<init>	(Lcom/mobisystems/mobiscanner/image/Image;Ljava/lang/String;)V
    //   407: athrow
    //   408: astore 4
    //   410: aload 11
    //   412: astore_3
    //   413: aload_0
    //   414: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   417: ldc_w 419
    //   420: aload 4
    //   422: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   425: aload_3
    //   426: astore 10
    //   428: aload 10
    //   430: areturn
    //   431: aload 10
    //   433: astore 11
    //   435: aload 10
    //   437: astore 12
    //   439: aload 10
    //   441: aconst_null
    //   442: aload 13
    //   444: invokestatic 274	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   447: astore_3
    //   448: aload 10
    //   450: ifnull +8 -> 458
    //   453: aload 10
    //   455: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   458: goto -79 -> 379
    //   461: aload 11
    //   463: astore 12
    //   465: aload_0
    //   466: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   469: ldc_w 421
    //   472: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   475: goto -120 -> 355
    //   478: astore_3
    //   479: aload 12
    //   481: ifnull +12 -> 493
    //   484: aload 4
    //   486: astore 10
    //   488: aload 12
    //   490: invokevirtual 132	java/io/BufferedInputStream:close	()V
    //   493: aload 4
    //   495: astore 11
    //   497: aload 4
    //   499: astore 10
    //   501: aload_3
    //   502: athrow
    //   503: astore_3
    //   504: aload 10
    //   506: astore 4
    //   508: aload_0
    //   509: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   512: ldc_w 423
    //   515: aload_3
    //   516: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   519: aload 4
    //   521: areturn
    //   522: aload_3
    //   523: astore 11
    //   525: aload_3
    //   526: astore 10
    //   528: aload_0
    //   529: getfield 53	com/mobisystems/mobiscanner/image/Image:aHg	Lcom/mobisystems/mobiscanner/image/Image$a;
    //   532: invokevirtual 462	com/mobisystems/mobiscanner/image/Image$a:Id	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   535: invokestatic 428	com/mobisystems/mobiscanner/image/ImageProcessing:c	(Lcom/mobisystems/mobiscanner/image/ImageOrientation;)Landroid/graphics/Matrix;
    //   538: astore 14
    //   540: aload_3
    //   541: astore 11
    //   543: aload_3
    //   544: astore 10
    //   546: aload 14
    //   548: invokevirtual 433	android/graphics/Matrix:isIdentity	()Z
    //   551: istore 9
    //   553: aload_3
    //   554: astore 10
    //   556: iload 9
    //   558: ifne -130 -> 428
    //   561: aload 13
    //   563: getfield 278	android/graphics/BitmapFactory$Options:outWidth	I
    //   566: istore 5
    //   568: aload 13
    //   570: getfield 281	android/graphics/BitmapFactory$Options:outHeight	I
    //   573: istore 6
    //   575: iconst_1
    //   576: istore_1
    //   577: aconst_null
    //   578: astore 10
    //   580: aload_3
    //   581: astore 4
    //   583: aload 10
    //   585: astore_3
    //   586: aload_3
    //   587: astore 10
    //   589: iload_1
    //   590: iconst_1
    //   591: if_icmple +380 -> 971
    //   594: aload_3
    //   595: astore 12
    //   597: aload_3
    //   598: astore 10
    //   600: aload_3
    //   601: astore 11
    //   603: aload 4
    //   605: iload 5
    //   607: iload 6
    //   609: iconst_0
    //   610: invokestatic 439	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   613: astore_3
    //   614: aload_3
    //   615: astore 10
    //   617: aload_3
    //   618: aload 4
    //   620: if_acmpeq +351 -> 971
    //   623: aload_3
    //   624: astore 12
    //   626: aload_3
    //   627: astore 10
    //   629: aload_3
    //   630: astore 11
    //   632: aload 4
    //   634: invokevirtual 442	android/graphics/Bitmap:recycle	()V
    //   637: aload_3
    //   638: astore 4
    //   640: aload_3
    //   641: iconst_0
    //   642: iconst_0
    //   643: iload 5
    //   645: iload 6
    //   647: aload 14
    //   649: iconst_0
    //   650: invokestatic 446	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   653: astore 10
    //   655: iconst_0
    //   656: istore_2
    //   657: aload_3
    //   658: astore 4
    //   660: aload 10
    //   662: astore_3
    //   663: iload_2
    //   664: ifne +317 -> 981
    //   667: aload 4
    //   669: astore 10
    //   671: aload_3
    //   672: ifnull -244 -> 428
    //   675: aload_3
    //   676: aload 4
    //   678: if_acmpeq +8 -> 686
    //   681: aload 4
    //   683: invokevirtual 442	android/graphics/Bitmap:recycle	()V
    //   686: aload_3
    //   687: areturn
    //   688: astore_3
    //   689: aload 12
    //   691: astore_3
    //   692: iload_1
    //   693: iconst_2
    //   694: imul
    //   695: istore_1
    //   696: aload_3
    //   697: astore 10
    //   699: aload_3
    //   700: astore 11
    //   702: aload 13
    //   704: getfield 278	android/graphics/BitmapFactory$Options:outWidth	I
    //   707: iload_1
    //   708: idiv
    //   709: istore 5
    //   711: aload_3
    //   712: astore 10
    //   714: aload_3
    //   715: astore 11
    //   717: aload 13
    //   719: getfield 281	android/graphics/BitmapFactory$Options:outHeight	I
    //   722: iload_1
    //   723: idiv
    //   724: istore 6
    //   726: iload 5
    //   728: iconst_1
    //   729: if_icmple +47 -> 776
    //   732: iload 6
    //   734: iconst_1
    //   735: if_icmple +41 -> 776
    //   738: aload_3
    //   739: astore 10
    //   741: aload_3
    //   742: astore 11
    //   744: aload_0
    //   745: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   748: new 68	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 448
    //   758: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: iload_1
    //   762: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   771: iconst_1
    //   772: istore_2
    //   773: goto -110 -> 663
    //   776: aload_3
    //   777: astore 10
    //   779: aload_3
    //   780: astore 11
    //   782: aload_0
    //   783: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   786: ldc_w 450
    //   789: invokevirtual 415	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   792: iconst_0
    //   793: istore_2
    //   794: goto -131 -> 663
    //   797: astore 12
    //   799: aload 4
    //   801: astore 11
    //   803: aload 4
    //   805: astore 10
    //   807: aload_0
    //   808: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   811: ldc -75
    //   813: aload 12
    //   815: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   818: goto -325 -> 493
    //   821: astore_3
    //   822: aload 4
    //   824: astore 11
    //   826: aload 4
    //   828: astore 10
    //   830: aload_0
    //   831: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   834: ldc -75
    //   836: aload_3
    //   837: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   840: aload 4
    //   842: astore_3
    //   843: iload_1
    //   844: istore_2
    //   845: goto -466 -> 379
    //   848: astore 4
    //   850: aload_0
    //   851: getfield 50	com/mobisystems/mobiscanner/image/Image:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   854: ldc -75
    //   856: aload 4
    //   858: invokevirtual 177	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   861: goto -403 -> 458
    //   864: astore 4
    //   866: goto -453 -> 413
    //   869: astore_3
    //   870: aconst_null
    //   871: astore 4
    //   873: goto -365 -> 508
    //   876: astore_3
    //   877: aconst_null
    //   878: astore 4
    //   880: goto -372 -> 508
    //   883: astore_3
    //   884: aload 10
    //   886: astore 4
    //   888: goto -380 -> 508
    //   891: astore_3
    //   892: goto -384 -> 508
    //   895: astore 10
    //   897: aload_3
    //   898: astore 4
    //   900: aload 10
    //   902: astore_3
    //   903: goto -395 -> 508
    //   906: astore 10
    //   908: aload_3
    //   909: astore 4
    //   911: aload 10
    //   913: astore_3
    //   914: goto -406 -> 508
    //   917: astore 4
    //   919: aconst_null
    //   920: astore_3
    //   921: goto -508 -> 413
    //   924: astore 4
    //   926: aconst_null
    //   927: astore_3
    //   928: goto -515 -> 413
    //   931: astore 4
    //   933: aload 11
    //   935: astore_3
    //   936: goto -523 -> 413
    //   939: astore 10
    //   941: aload 4
    //   943: astore_3
    //   944: aload 10
    //   946: astore 4
    //   948: goto -535 -> 413
    //   951: astore 4
    //   953: goto -540 -> 413
    //   956: astore 10
    //   958: aload_3
    //   959: astore 10
    //   961: aload 4
    //   963: astore_3
    //   964: aload 10
    //   966: astore 4
    //   968: goto -276 -> 692
    //   971: aload 4
    //   973: astore_3
    //   974: aload 10
    //   976: astore 4
    //   978: goto -338 -> 640
    //   981: goto -395 -> 586
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	this	Image
    //   0	984	1	paramInt1	int
    //   0	984	2	paramInt2	int
    //   0	984	3	paramk	k
    //   0	984	4	paramRestrictMemory	RestrictMemory
    //   78	652	5	i	int
    //   74	662	6	j	int
    //   52	48	7	k	int
    //   61	35	8	m	int
    //   551	6	9	bool	boolean
    //   70	815	10	localObject1	Object
    //   895	6	10	localImageException1	ImageException
    //   906	6	10	localImageException2	ImageException
    //   939	6	10	localIOException1	IOException
    //   956	1	10	localOutOfMemoryError	OutOfMemoryError
    //   959	16	10	localk	k
    //   241	693	11	localObject2	Object
    //   238	452	12	localObject3	Object
    //   797	17	12	localIOException2	IOException
    //   43	675	13	localOptions	BitmapFactory.Options
    //   538	110	14	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   243	249	273	java/lang/OutOfMemoryError
    //   262	273	273	java/lang/OutOfMemoryError
    //   439	448	273	java/lang/OutOfMemoryError
    //   396	408	408	java/io/IOException
    //   501	503	408	java/io/IOException
    //   528	540	408	java/io/IOException
    //   546	553	408	java/io/IOException
    //   807	818	408	java/io/IOException
    //   830	840	408	java/io/IOException
    //   243	249	478	finally
    //   262	273	478	finally
    //   278	290	478	finally
    //   294	304	478	finally
    //   308	318	478	finally
    //   322	353	478	finally
    //   439	448	478	finally
    //   465	475	478	finally
    //   369	374	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   396	408	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   488	493	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   501	503	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   528	540	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   546	553	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   807	818	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   830	840	503	com/mobisystems/mobiscanner/image/Image$ImageException
    //   603	614	688	java/lang/OutOfMemoryError
    //   632	637	688	java/lang/OutOfMemoryError
    //   488	493	797	java/io/IOException
    //   369	374	821	java/io/IOException
    //   453	458	848	java/io/IOException
    //   850	861	864	java/io/IOException
    //   36	72	869	com/mobisystems/mobiscanner/image/Image$ImageException
    //   87	95	869	com/mobisystems/mobiscanner/image/Image$ImageException
    //   103	111	869	com/mobisystems/mobiscanner/image/Image$ImageException
    //   111	129	869	com/mobisystems/mobiscanner/image/Image$ImageException
    //   129	173	869	com/mobisystems/mobiscanner/image/Image$ImageException
    //   177	190	869	com/mobisystems/mobiscanner/image/Image$ImageException
    //   194	230	869	com/mobisystems/mobiscanner/image/Image$ImageException
    //   561	575	876	com/mobisystems/mobiscanner/image/Image$ImageException
    //   603	614	883	com/mobisystems/mobiscanner/image/Image$ImageException
    //   632	637	883	com/mobisystems/mobiscanner/image/Image$ImageException
    //   702	711	883	com/mobisystems/mobiscanner/image/Image$ImageException
    //   717	726	883	com/mobisystems/mobiscanner/image/Image$ImageException
    //   744	771	883	com/mobisystems/mobiscanner/image/Image$ImageException
    //   782	792	883	com/mobisystems/mobiscanner/image/Image$ImageException
    //   640	655	891	com/mobisystems/mobiscanner/image/Image$ImageException
    //   681	686	895	com/mobisystems/mobiscanner/image/Image$ImageException
    //   453	458	906	com/mobisystems/mobiscanner/image/Image$ImageException
    //   850	861	906	com/mobisystems/mobiscanner/image/Image$ImageException
    //   36	72	917	java/io/IOException
    //   87	95	917	java/io/IOException
    //   103	111	917	java/io/IOException
    //   111	129	917	java/io/IOException
    //   129	173	917	java/io/IOException
    //   177	190	917	java/io/IOException
    //   194	230	917	java/io/IOException
    //   561	575	924	java/io/IOException
    //   603	614	931	java/io/IOException
    //   632	637	931	java/io/IOException
    //   702	711	931	java/io/IOException
    //   717	726	931	java/io/IOException
    //   744	771	931	java/io/IOException
    //   782	792	931	java/io/IOException
    //   640	655	939	java/io/IOException
    //   681	686	951	java/io/IOException
    //   640	655	956	java/lang/OutOfMemoryError
  }
  
  public String toString()
  {
    return new String("ImageAttributes[" + d.ay(this) + "]: " + "mWidth=" + a.c(this.aHg) + ", mHeight=" + a.d(this.aHg) + ", mOrientation=" + a.b(this.aHg));
  }
  
  public class ImageException
    extends Exception
  {
    private static final long serialVersionUID = 200241684165149544L;
    
    public ImageException(String paramString)
    {
      super();
    }
  }
  
  public static enum ImageStreamType
  {
    private String mFileExtension;
    private String mMimeType;
    
    private ImageStreamType(String paramString1, String paramString2)
    {
      this.mMimeType = paramString1;
      this.mFileExtension = paramString2;
    }
    
    public static ImageStreamType dN(String paramString)
    {
      ImageStreamType localImageStreamType1 = aHp;
      ImageStreamType[] arrayOfImageStreamType = values();
      int j = arrayOfImageStreamType.length;
      int i = 0;
      while (i < j)
      {
        ImageStreamType localImageStreamType2 = arrayOfImageStreamType[i];
        if (localImageStreamType2.mMimeType.equals(paramString)) {
          return localImageStreamType2;
        }
        i += 1;
      }
      return localImageStreamType1;
    }
    
    public String If()
    {
      return this.mFileExtension;
    }
  }
  
  public class InvalidImageTypeException
    extends Image.ImageException
  {
    private static final long serialVersionUID = -996270814075375917L;
    
    public InvalidImageTypeException(String paramString)
    {
      super(paramString);
    }
  }
  
  public static enum RestrictMemory
  {
    private RestrictMemory() {}
  }
  
  public static class a
  {
    private int aHl = 0;
    private int aHm = 0;
    private ImageOrientation aHn = ImageOrientation.aHV;
    private int aHo = 72;
    
    private void a(a parama)
    {
      this.aHl = parama.aHl;
      this.aHm = parama.aHm;
      this.aHn = parama.aHn;
      this.aHo = parama.Ie();
    }
    
    public ImageOrientation Ic()
    {
      return this.aHn;
    }
    
    public ImageOrientation Id()
    {
      ImageOrientation localImageOrientation2 = this.aHn;
      if (width() > height())
      {
        ImageOrientation localImageOrientation1;
        if (this.aHn == ImageOrientation.aHW) {
          localImageOrientation1 = ImageOrientation.aIb;
        }
        do
        {
          return localImageOrientation1;
          if (localImageOrientation2 == ImageOrientation.aHY) {
            return ImageOrientation.aIb;
          }
          localImageOrientation1 = localImageOrientation2;
        } while (localImageOrientation2 != ImageOrientation.aId);
        return ImageOrientation.aIb;
      }
      return ImageOrientation.aHW;
    }
    
    public int Ie()
    {
      return this.aHo;
    }
    
    public int height()
    {
      return this.aHm;
    }
    
    public int width()
    {
      return this.aHl;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/Image.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */