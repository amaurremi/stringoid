package com.google.api.client.util;

import java.io.InputStream;
import java.io.OutputStream;

public class m
{
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
  {
    try
    {
      f.a(paramInputStream, paramOutputStream);
      return;
    }
    finally
    {
      if (paramBoolean) {
        paramInputStream.close();
      }
    }
  }
  
  public static long b(aa paramaa)
  {
    e locale = new e();
    try
    {
      paramaa.writeTo(locale);
      return locale.acZ;
    }
    finally
    {
      locale.close();
    }
  }
  
  public static void b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    a(paramInputStream, paramOutputStream, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */