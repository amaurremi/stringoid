package com.chartboost.sdk.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class ah
{
  public static final BigInteger a = BigInteger.valueOf(1024L);
  public static final BigInteger b = a.multiply(a);
  public static final BigInteger c = a.multiply(b);
  public static final BigInteger d = a.multiply(c);
  public static final BigInteger e = a.multiply(d);
  public static final BigInteger f = a.multiply(e);
  public static final BigInteger g = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
  public static final BigInteger h = a.multiply(g);
  public static final File[] i = new File[0];
  private static final Charset j = Charset.forName("UTF-8");
  
  public static FileOutputStream a(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
        throw new IOException("Directory '" + localFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramFile, paramArrayOfByte, false);
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
    throws IOException
  {
    File localFile = null;
    try
    {
      paramFile = a(paramFile, paramBoolean);
      localFile = paramFile;
      paramFile.write(paramArrayOfByte);
      localFile = paramFile;
      paramFile.close();
      return;
    }
    finally
    {
      ai.a(localFile);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */