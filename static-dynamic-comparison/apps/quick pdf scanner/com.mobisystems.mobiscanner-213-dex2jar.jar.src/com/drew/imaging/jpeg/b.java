package com.drew.imaging.jpeg;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
{
  private final JpegSegmentData fB;
  
  /* Error */
  public b(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 11	java/lang/Object:<init>	()V
    //   4: aload_1
    //   5: ifnonnull +11 -> 16
    //   8: new 13	java/lang/NullPointerException
    //   11: dup
    //   12: invokespecial 14	java/lang/NullPointerException:<init>	()V
    //   15: athrow
    //   16: new 16	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 18	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_2
    //   25: aload_0
    //   26: aload_0
    //   27: new 20	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 23	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: iconst_0
    //   36: invokespecial 27	com/drew/imaging/jpeg/b:b	(Ljava/io/BufferedInputStream;Z)Lcom/drew/imaging/jpeg/JpegSegmentData;
    //   39: putfield 29	com/drew/imaging/jpeg/b:fB	Lcom/drew/imaging/jpeg/JpegSegmentData;
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 34	java/io/InputStream:close	()V
    //   50: return
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 34	java/io/InputStream:close	()V
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -11 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	b
    //   0	68	1	paramFile	java.io.File
    //   24	35	2	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   16	25	51	finally
    //   25	42	64	finally
  }
  
  public b(InputStream paramInputStream, boolean paramBoolean)
  {
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    if ((paramInputStream instanceof BufferedInputStream)) {}
    for (paramInputStream = (BufferedInputStream)paramInputStream;; paramInputStream = new BufferedInputStream(paramInputStream))
    {
      this.fB = b(paramInputStream, paramBoolean);
      return;
    }
  }
  
  private boolean a(BufferedInputStream paramBufferedInputStream, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramInt <= paramBufferedInputStream.available();
    }
    int i = 40;
    while ((i <= 0) || (paramInt > paramBufferedInputStream.available())) {
      try
      {
        Thread.sleep(100L);
        i -= 1;
        continue;
        return false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  private JpegSegmentData b(BufferedInputStream paramBufferedInputStream, boolean paramBoolean)
  {
    int j = 1;
    JpegSegmentData localJpegSegmentData1 = new JpegSegmentData();
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = new byte[2];
      if (paramBufferedInputStream.read(arrayOfByte, 0, 2) != 2) {
        throw new JpegProcessingException("not a jpeg file");
      }
    }
    catch (IOException localIOException)
    {
      throw new JpegProcessingException("IOException processing Jpeg file: " + localIOException.getMessage(), localIOException);
    }
    finally
    {
      if (paramBufferedInputStream != null) {}
      try
      {
        paramBufferedInputStream.close();
        throw localJpegSegmentData2;
      }
      catch (IOException paramBufferedInputStream)
      {
        throw new JpegProcessingException("IOException processing Jpeg file: " + paramBufferedInputStream.getMessage(), paramBufferedInputStream);
      }
      if (((arrayOfByte[0] & 0xFF) != 255) || ((arrayOfByte[1] & 0xFF) != 216)) {
        break label512;
      }
    }
    if (j == 0) {
      throw new JpegProcessingException("not a jpeg file");
    }
    for (;;)
    {
      if (!a(paramBufferedInputStream, 4, paramBoolean)) {
        throw new JpegProcessingException("stream ended before segment header could be read");
      }
      int k = (byte)(paramBufferedInputStream.read() & 0xFF);
      if ((k & 0xFF) != 255) {
        throw new JpegProcessingException("expected jpeg segment start identifier 0xFF at offset " + j + ", not 0x" + Integer.toHexString(k & 0xFF));
      }
      int i = (byte)(paramBufferedInputStream.read() & 0xFF);
      arrayOfByte = new byte[2];
      if (paramBufferedInputStream.read(arrayOfByte, 0, 2) != 2) {
        throw new JpegProcessingException("Jpeg data ended unexpectedly.");
      }
      k = arrayOfByte[0];
      k = (arrayOfByte[1] & 0xFF | k << 8 & 0xFF00) - 2;
      if (!a(paramBufferedInputStream, k, paramBoolean)) {
        throw new JpegProcessingException("segment size would extend beyond file stream length");
      }
      if (k < 0) {
        throw new JpegProcessingException("segment size would be less than zero");
      }
      arrayOfByte = new byte[k];
      if (paramBufferedInputStream.read(arrayOfByte, 0, k) != k) {
        throw new JpegProcessingException("Jpeg data ended unexpectedly.");
      }
      j = j + 1 + 1 + 2 + k;
      if ((i & 0xFF) == 218) {
        if (paramBufferedInputStream == null) {}
      }
      do
      {
        try
        {
          paramBufferedInputStream.close();
          return localJpegSegmentData2;
        }
        catch (IOException paramBufferedInputStream)
        {
          throw new JpegProcessingException("IOException processing Jpeg file: " + paramBufferedInputStream.getMessage(), paramBufferedInputStream);
        }
        if ((i & 0xFF) != 217) {
          break;
        }
      } while (paramBufferedInputStream == null);
      try
      {
        paramBufferedInputStream.close();
        return localJpegSegmentData2;
      }
      catch (IOException paramBufferedInputStream)
      {
        throw new JpegProcessingException("IOException processing Jpeg file: " + paramBufferedInputStream.getMessage(), paramBufferedInputStream);
      }
      localJpegSegmentData2.a(i, arrayOfByte);
      continue;
      label512:
      j = 0;
      break;
      j = 2;
    }
  }
  
  public final JpegSegmentData aq()
  {
    return this.fB;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/imaging/jpeg/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */