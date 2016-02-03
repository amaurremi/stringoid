package com.jirbo.adcolony;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ADCImage
{
  static int k;
  static int l;
  Bitmap a;
  Bitmap b;
  Paint c = new Paint();
  Rect d = new Rect();
  Rect e = new Rect();
  int f;
  int g;
  boolean h;
  int i;
  int j;
  boolean m;
  
  ADCImage(String paramString)
  {
    this(paramString, 1.0D);
  }
  
  ADCImage(String paramString, double paramDouble)
  {
    this(paramString, paramDouble, false);
  }
  
  ADCImage(String paramString, double paramDouble, boolean paramBoolean)
  {
    this(paramString, paramDouble, paramBoolean, false);
  }
  
  ADCImage(String paramString, double paramDouble, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      int n;
      try
      {
        this.a = BitmapFactory.decodeStream(new FileInputStream(paramString));
        this.b = this.a;
        this.f = this.a.getWidth();
        this.g = this.a.getHeight();
        this.i = this.a.getWidth();
        this.j = this.a.getHeight();
        k = this.i;
        l = this.j;
        a(paramDouble);
        this.h = true;
        if (paramBoolean1)
        {
          this.a = convertToMutable(this.a);
          int[] arrayOfInt = new int[this.a.getWidth() * this.a.getHeight()];
          this.a.getPixels(arrayOfInt, 0, this.a.getWidth(), 0, 0, this.a.getWidth(), this.a.getHeight());
          n = 0;
          if (n < arrayOfInt.length)
          {
            if ((arrayOfInt[n] < 255) && (arrayOfInt[n] != 0)) {
              arrayOfInt[n] = (arrayOfInt[n] >> 1 & 0x7F7F7F | 0xFF000000);
            }
          }
          else
          {
            this.a.setPixels(arrayOfInt, 0, this.a.getWidth(), 0, 0, this.a.getWidth(), this.a.getHeight());
            this.b = this.a;
          }
        }
        else
        {
          if (!paramBoolean2) {
            a.Z.add(this.a);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.e("Failed to load image " + paramString);
        this.m = true;
        return;
      }
      n += 1;
    }
  }
  
  ADCImage(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, 1.0D);
    b(paramInt1, paramInt2);
  }
  
  ADCImage(String paramString, boolean paramBoolean)
  {
    this(paramString, 1.0D, paramBoolean);
  }
  
  ADCImage(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, 1.0D, paramBoolean2, paramBoolean1);
  }
  
  /* Error */
  public static Bitmap convertToMutable(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 143	java/io/File
    //   3: dup
    //   4: new 120	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 149	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   14: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17: getstatic 156	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc -98
    //   25: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: new 161	java/io/RandomAccessFile
    //   39: dup
    //   40: aload 4
    //   42: ldc -93
    //   44: invokespecial 166	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore 5
    //   49: getstatic 84	com/jirbo/adcolony/ADCImage:k	I
    //   52: istore_1
    //   53: getstatic 86	com/jirbo/adcolony/ADCImage:l	I
    //   56: istore_2
    //   57: aload_0
    //   58: invokevirtual 170	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   61: astore_3
    //   62: aload 5
    //   64: invokevirtual 174	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   67: astore 6
    //   69: aload 6
    //   71: getstatic 180	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   74: lconst_0
    //   75: aload_0
    //   76: invokevirtual 183	android/graphics/Bitmap:getRowBytes	()I
    //   79: iload_2
    //   80: imul
    //   81: i2l
    //   82: invokevirtual 189	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   85: astore 7
    //   87: aload_0
    //   88: aload 7
    //   90: invokevirtual 193	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   93: iload_1
    //   94: iload_2
    //   95: aload_3
    //   96: invokestatic 197	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   99: astore_3
    //   100: aload 7
    //   102: iconst_0
    //   103: invokevirtual 203	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   106: pop
    //   107: aload_3
    //   108: aload 7
    //   110: invokevirtual 206	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   113: aload 6
    //   115: invokevirtual 209	java/nio/channels/FileChannel:close	()V
    //   118: aload 5
    //   120: invokevirtual 210	java/io/RandomAccessFile:close	()V
    //   123: aload 4
    //   125: invokevirtual 214	java/io/File:delete	()Z
    //   128: pop
    //   129: aload_3
    //   130: areturn
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   136: aload_0
    //   137: areturn
    //   138: astore 4
    //   140: aload_3
    //   141: astore_0
    //   142: aload 4
    //   144: astore_3
    //   145: goto -13 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramBitmap	Bitmap
    //   52	42	1	n	int
    //   56	39	2	i1	int
    //   61	69	3	localObject	Object
    //   131	10	3	localException1	Exception
    //   144	1	3	localException2	Exception
    //   34	90	4	localFile	java.io.File
    //   138	5	4	localException3	Exception
    //   47	72	5	localRandomAccessFile	java.io.RandomAccessFile
    //   67	47	6	localFileChannel	java.nio.channels.FileChannel
    //   85	24	7	localMappedByteBuffer	java.nio.MappedByteBuffer
    // Exception table:
    //   from	to	target	type
    //   0	100	131	java/lang/Exception
    //   100	129	138	java/lang/Exception
  }
  
  void a(double paramDouble)
  {
    a(paramDouble, false);
  }
  
  void a(double paramDouble, boolean paramBoolean)
  {
    if (this.a == null) {}
    while (this.a.isRecycled()) {
      return;
    }
    if (paramDouble != 1.0D)
    {
      int n = (int)(this.b.getWidth() * paramDouble);
      int i1 = (int)(this.b.getHeight() * paramDouble);
      if ((n != this.f) || (i1 != this.g))
      {
        this.f = n;
        this.g = i1;
        this.a = Bitmap.createScaledBitmap(this.b, this.f, this.g, true);
        if (!paramBoolean) {
          a.Z.add(this.a);
        }
      }
      if (paramBoolean)
      {
        this.b.recycle();
        this.b = null;
      }
    }
    this.d.right = this.f;
    this.d.bottom = this.g;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    Bitmap localBitmap1 = Bitmap.createBitmap(this.b, 0, 0, this.i / 3, this.j);
    Bitmap localBitmap2 = Bitmap.createBitmap(this.b, this.i * 2 / 3, 0, this.i / 3, this.j);
    Bitmap localBitmap3 = Bitmap.createScaledBitmap(Bitmap.createBitmap(this.b, this.i / 3, 0, this.i / 3, this.j), paramInt1, this.j, false);
    int[] arrayOfInt1 = new int[this.i / 3 * this.j];
    int[] arrayOfInt2 = new int[this.i / 3 * this.j];
    localBitmap1.getPixels(arrayOfInt1, 0, this.i / 3, 0, 0, this.i / 3, this.j);
    localBitmap2.getPixels(arrayOfInt2, 0, this.i / 3, 0, 0, this.i / 3, this.j);
    localBitmap3.getPixels(new int[localBitmap3.getWidth() * localBitmap3.getHeight()], 0, localBitmap3.getWidth(), 0, 0, localBitmap3.getWidth(), localBitmap3.getHeight());
    int i1 = 0;
    int n = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    if (paramInt2 < localBitmap3.getHeight())
    {
      int i3;
      int i2;
      if (paramInt1 < this.i / 3)
      {
        if (n < arrayOfInt1.length) {
          localBitmap3.setPixel(paramInt1, paramInt2, arrayOfInt1[n]);
        }
        i3 = n + 1;
        i2 = i1;
      }
      for (;;)
      {
        int i4 = paramInt1 + 1;
        i1 = i2;
        n = i3;
        paramInt1 = i4;
        if (i4 != localBitmap3.getWidth()) {
          break;
        }
        paramInt2 += 1;
        paramInt1 = 0;
        i1 = i2;
        n = i3;
        break;
        i2 = i1;
        i3 = n;
        if (paramInt1 >= localBitmap3.getWidth() - this.i / 3)
        {
          if (i1 < arrayOfInt2.length) {
            localBitmap3.setPixel(paramInt1, paramInt2, arrayOfInt2[i1]);
          }
          i2 = i1 + 1;
          i3 = n;
        }
      }
    }
    this.a = localBitmap3;
    this.b = this.a;
    this.f = this.a.getWidth();
    this.g = this.a.getHeight();
    this.i = this.f;
    this.j = this.g;
    this.d.right = this.f;
    this.d.bottom = this.g;
  }
  
  void a(Canvas paramCanvas)
  {
    if (this.a == null) {}
    while (this.a.isRecycled()) {
      return;
    }
    paramCanvas.drawBitmap(this.a, this.d, this.e, this.c);
  }
  
  void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    a(paramCanvas);
  }
  
  int[] a()
  {
    return new int[] { this.e.left, this.e.top };
  }
  
  int b()
  {
    return this.e.left;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.a == null) {}
    while ((this.a.isRecycled()) || ((paramInt1 == this.f) && (paramInt2 == this.g))) {
      return;
    }
    this.a = Bitmap.createScaledBitmap(this.b, paramInt1, paramInt2, true);
    this.f = paramInt1;
    this.g = paramInt2;
    this.d.right = paramInt1;
    this.d.bottom = paramInt2;
    a.Z.add(this.a);
  }
  
  int c()
  {
    return this.e.top;
  }
  
  void c(int paramInt1, int paramInt2)
  {
    this.e.left = paramInt1;
    this.e.top = paramInt2;
    this.e.right = (this.f + paramInt1);
    this.e.bottom = (this.g + paramInt2);
  }
  
  void d(int paramInt1, int paramInt2)
  {
    c((paramInt1 - this.f) / 2, (paramInt2 - this.g) / 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */