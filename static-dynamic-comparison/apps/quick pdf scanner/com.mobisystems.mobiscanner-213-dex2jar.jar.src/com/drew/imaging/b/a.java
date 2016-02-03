package com.drew.imaging.b;

import com.drew.lang.b;
import com.drew.metadata.b.k;
import java.io.ByteArrayOutputStream;
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
      new k().b(new com.drew.lang.d(paramFile), locald);
      return locald;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  @Deprecated
  public static com.drew.metadata.d a(InputStream paramInputStream, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(i);
    }
    paramInputStream = new com.drew.metadata.d();
    new k().b(new b(localByteArrayOutputStream.toByteArray()), paramInputStream);
    return paramInputStream;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/imaging/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */