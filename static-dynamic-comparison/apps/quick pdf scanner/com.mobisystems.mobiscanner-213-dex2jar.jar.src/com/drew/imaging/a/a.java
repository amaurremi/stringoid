package com.drew.imaging.a;

import com.drew.lang.b;
import com.drew.metadata.f.f;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class a
{
  public static com.drew.metadata.d a(File paramFile)
  {
    com.drew.metadata.d locald = new com.drew.metadata.d();
    paramFile = new RandomAccessFile(paramFile, "r");
    try
    {
      new f().a(new com.drew.lang.d(paramFile), locald);
      return locald;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static com.drew.metadata.d a(InputStream paramInputStream, boolean paramBoolean)
  {
    com.drew.metadata.d locald = new com.drew.metadata.d();
    byte[] arrayOfByte = new byte[26];
    paramInputStream.read(arrayOfByte, 0, 26);
    new f().a(new b(arrayOfByte), locald);
    return locald;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/imaging/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */