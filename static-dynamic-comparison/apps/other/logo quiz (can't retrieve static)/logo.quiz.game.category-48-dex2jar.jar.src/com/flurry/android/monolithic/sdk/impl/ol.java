package com.flurry.android.monolithic.sdk.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ol
  extends oi
{
  private final File a;
  private final String b;
  private final String c;
  
  public ol(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    if (paramFile == null) {
      throw new IllegalArgumentException("File may not be null");
    }
    this.a = paramFile;
    if (paramString1 != null) {}
    for (this.b = paramString1;; this.b = paramFile.getName())
    {
      this.c = paramString3;
      return;
    }
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    FileInputStream localFileInputStream = new FileInputStream(this.a);
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localFileInputStream.close();
    }
    localFileInputStream.close();
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return "binary";
  }
  
  public long e()
  {
    return this.a.length();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */