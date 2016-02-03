package com.drew.imaging;

import com.drew.metadata.d;
import java.io.BufferedInputStream;
import java.io.File;

public class a
{
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private a()
  {
    throw new Exception("Not intended for instantiation");
  }
  
  private static int a(BufferedInputStream paramBufferedInputStream)
  {
    paramBufferedInputStream.mark(2);
    int i = paramBufferedInputStream.read();
    int j = paramBufferedInputStream.read();
    paramBufferedInputStream.reset();
    return i << 8 | j;
  }
  
  private static d a(BufferedInputStream paramBufferedInputStream, File paramFile, int paramInt, boolean paramBoolean)
  {
    int j = 1;
    if (!$assertionsDisabled)
    {
      int i;
      if (paramFile != null)
      {
        i = 1;
        if (paramBufferedInputStream == null) {
          break label42;
        }
      }
      for (;;)
      {
        if ((j ^ i) != 0) {
          break label48;
        }
        throw new AssertionError();
        i = 0;
        break;
        label42:
        j = 0;
      }
    }
    label48:
    if ((paramInt & 0xFFD8) == 65496)
    {
      if (paramBufferedInputStream != null) {
        return com.drew.imaging.jpeg.a.a(paramBufferedInputStream, paramBoolean);
      }
      return com.drew.imaging.jpeg.a.a(paramFile);
    }
    if ((paramInt == 18761) || (paramInt == 19789))
    {
      if (paramBufferedInputStream != null) {
        return com.drew.imaging.b.a.a(paramBufferedInputStream, paramBoolean);
      }
      return com.drew.imaging.b.a.a(paramFile);
    }
    if (paramInt == 14402)
    {
      if (paramBufferedInputStream != null) {
        return com.drew.imaging.a.a.a(paramBufferedInputStream, paramBoolean);
      }
      return com.drew.imaging.a.a.a(paramFile);
    }
    throw new ImageProcessingException("File format is not supported");
  }
  
  public static d a(BufferedInputStream paramBufferedInputStream, boolean paramBoolean)
  {
    return a(paramBufferedInputStream, null, a(paramBufferedInputStream), paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/imaging/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */