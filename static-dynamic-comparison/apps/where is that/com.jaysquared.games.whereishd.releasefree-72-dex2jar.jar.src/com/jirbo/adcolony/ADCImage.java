package com.jirbo.adcolony;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;

public class ADCImage
{
  static int mutable_h;
  static int mutable_w;
  Bitmap bitmap;
  Rect dest_rect = new Rect();
  boolean error;
  int height;
  Bitmap original_bitmap;
  int original_height;
  int original_width;
  Paint paint = new Paint();
  Rect src_rect = new Rect();
  int width;
  
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
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new FileInputStream(paramString);
        byte[] arrayOfByte = new byte[((InputStream)localObject).available()];
        ((InputStream)localObject).read(arrayOfByte);
        ((InputStream)localObject).close();
        this.bitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        this.original_bitmap = this.bitmap;
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
        this.original_width = this.bitmap.getWidth();
        this.original_height = this.bitmap.getHeight();
        mutable_w = this.original_width;
        mutable_h = this.original_height;
        resize(paramDouble);
        if (paramBoolean)
        {
          this.bitmap = convertToMutable(this.bitmap);
          localObject = new int[this.bitmap.getWidth() * this.bitmap.getHeight()];
          this.bitmap.getPixels((int[])localObject, 0, this.bitmap.getWidth(), 0, 0, this.bitmap.getWidth(), this.bitmap.getHeight());
          i = 0;
          if (i < localObject.length)
          {
            if ((localObject[i] < 255) && (localObject[i] != 0)) {
              localObject[i] = (localObject[i] >> 1 & 0x7F7F7F | 0xFF000000);
            }
          }
          else
          {
            this.bitmap.setPixels((int[])localObject, 0, this.bitmap.getWidth(), 0, 0, this.bitmap.getWidth(), this.bitmap.getHeight());
            this.original_bitmap = this.bitmap;
          }
        }
        else
        {
          ADC.bitmaps.add(this.bitmap);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        ADC.log_error("Failed to load image " + paramString);
        this.error = true;
        return;
      }
      i += 1;
    }
  }
  
  ADCImage(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, 1.0D);
    resize(paramInt1, paramInt2);
  }
  
  ADCImage(String paramString, boolean paramBoolean)
  {
    this(paramString, 1.0D, paramBoolean);
  }
  
  public static Bitmap convertToMutable(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    try
    {
      File localFile = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.tmp");
      localBitmap = paramBitmap;
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      localBitmap = paramBitmap;
      int i = mutable_w;
      localBitmap = paramBitmap;
      int j = mutable_h;
      localBitmap = paramBitmap;
      Bitmap.Config localConfig = paramBitmap.getConfig();
      localBitmap = paramBitmap;
      FileChannel localFileChannel = localRandomAccessFile.getChannel();
      localBitmap = paramBitmap;
      MappedByteBuffer localMappedByteBuffer = localFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, paramBitmap.getRowBytes() * j);
      localBitmap = paramBitmap;
      paramBitmap.copyPixelsToBuffer(localMappedByteBuffer);
      localBitmap = paramBitmap;
      paramBitmap = Bitmap.createBitmap(i, j, localConfig);
      localBitmap = paramBitmap;
      localMappedByteBuffer.position(0);
      localBitmap = paramBitmap;
      paramBitmap.copyPixelsFromBuffer(localMappedByteBuffer);
      localBitmap = paramBitmap;
      localFileChannel.close();
      localBitmap = paramBitmap;
      localRandomAccessFile.close();
      localBitmap = paramBitmap;
      localFile.delete();
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return localBitmap;
  }
  
  void center_within(int paramInt1, int paramInt2)
  {
    set_position((paramInt1 - this.width) / 2, (paramInt2 - this.height) / 2);
  }
  
  void draw(Canvas paramCanvas)
  {
    if (this.bitmap == null) {}
    while (this.bitmap.isRecycled()) {
      return;
    }
    paramCanvas.drawBitmap(this.bitmap, this.src_rect, this.dest_rect, this.paint);
  }
  
  void draw(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    set_position(paramInt1, paramInt2);
    draw(paramCanvas);
  }
  
  int[] get_position()
  {
    return new int[] { this.dest_rect.left, this.dest_rect.top };
  }
  
  void ninePatch(int paramInt1, int paramInt2)
  {
    if (this.bitmap == null) {
      return;
    }
    Bitmap localBitmap1 = Bitmap.createBitmap(this.original_bitmap, 0, 0, this.original_width / 3, this.original_height);
    Bitmap localBitmap2 = Bitmap.createBitmap(this.original_bitmap, this.original_width * 2 / 3, 0, this.original_width / 3, this.original_height);
    Bitmap localBitmap3 = Bitmap.createScaledBitmap(Bitmap.createBitmap(this.original_bitmap, this.original_width / 3, 0, this.original_width / 3, this.original_height), paramInt1, this.original_height, false);
    int[] arrayOfInt1 = new int[this.original_width / 3 * this.original_height];
    int[] arrayOfInt2 = new int[this.original_width / 3 * this.original_height];
    localBitmap1.getPixels(arrayOfInt1, 0, this.original_width / 3, 0, 0, this.original_width / 3, this.original_height);
    localBitmap2.getPixels(arrayOfInt2, 0, this.original_width / 3, 0, 0, this.original_width / 3, this.original_height);
    localBitmap3.getPixels(new int[localBitmap3.getWidth() * localBitmap3.getHeight()], 0, localBitmap3.getWidth(), 0, 0, localBitmap3.getWidth(), localBitmap3.getHeight());
    int i = 0;
    paramInt1 = 0;
    int j = 0;
    paramInt2 = 0;
    if (i < localBitmap3.getHeight())
    {
      int k;
      int m;
      if (paramInt1 < this.original_width / 3)
      {
        if (j < arrayOfInt1.length) {
          localBitmap3.setPixel(paramInt1, i, arrayOfInt1[j]);
        }
        k = j + 1;
        m = paramInt2;
      }
      for (;;)
      {
        int n = paramInt1 + 1;
        paramInt1 = n;
        j = k;
        paramInt2 = m;
        if (n != localBitmap3.getWidth()) {
          break;
        }
        i += 1;
        paramInt1 = 0;
        j = k;
        paramInt2 = m;
        break;
        k = j;
        m = paramInt2;
        if (paramInt1 >= localBitmap3.getWidth() - this.original_width / 3)
        {
          if (paramInt2 < arrayOfInt2.length) {
            localBitmap3.setPixel(paramInt1, i, arrayOfInt2[paramInt2]);
          }
          m = paramInt2 + 1;
          k = j;
        }
      }
    }
    this.bitmap = localBitmap3;
    this.original_bitmap = this.bitmap;
    this.width = this.bitmap.getWidth();
    this.height = this.bitmap.getHeight();
    this.original_width = this.width;
    this.original_height = this.height;
    this.src_rect.right = this.width;
    this.src_rect.bottom = this.height;
  }
  
  void resize(double paramDouble)
  {
    if (this.bitmap == null) {}
    while (this.bitmap.isRecycled()) {
      return;
    }
    if (paramDouble != 1.0D)
    {
      int i = (int)(this.original_bitmap.getWidth() * paramDouble);
      int j = (int)(this.original_bitmap.getHeight() * paramDouble);
      if ((i != this.width) || (j != this.height))
      {
        this.width = i;
        this.height = j;
        this.bitmap = Bitmap.createScaledBitmap(this.original_bitmap, this.width, this.height, true);
        ADC.bitmaps.add(this.bitmap);
      }
    }
    this.src_rect.right = this.width;
    this.src_rect.bottom = this.height;
  }
  
  void resize(int paramInt1, int paramInt2)
  {
    if (this.bitmap == null) {}
    while ((this.bitmap.isRecycled()) || ((paramInt1 == this.width) && (paramInt2 == this.height))) {
      return;
    }
    this.bitmap = Bitmap.createScaledBitmap(this.original_bitmap, paramInt1, paramInt2, true);
    this.width = paramInt1;
    this.height = paramInt2;
    this.src_rect.right = paramInt1;
    this.src_rect.bottom = paramInt2;
    ADC.bitmaps.add(this.bitmap);
  }
  
  void set_position(int paramInt1, int paramInt2)
  {
    this.dest_rect.left = paramInt1;
    this.dest_rect.top = paramInt2;
    this.dest_rect.right = (this.width + paramInt1);
    this.dest_rect.bottom = (this.height + paramInt2);
  }
  
  int x()
  {
    return this.dest_rect.left;
  }
  
  int y()
  {
    return this.dest_rect.top;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */