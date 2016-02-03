package com.google.api.client.json;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class d
{
  private String k(Object paramObject, boolean paramBoolean)
  {
    return l(paramObject, paramBoolean).toString("UTF-8");
  }
  
  private ByteArrayOutputStream l(Object paramObject, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    e locale = a(localByteArrayOutputStream, com.google.api.client.util.g.UTF_8);
    if (paramBoolean) {
      locale.yj();
    }
    locale.ab(paramObject);
    locale.flush();
    return localByteArrayOutputStream;
  }
  
  public abstract e a(OutputStream paramOutputStream, Charset paramCharset);
  
  public abstract g a(InputStream paramInputStream, Charset paramCharset);
  
  public final String aa(Object paramObject)
  {
    return k(paramObject, true);
  }
  
  public abstract g b(InputStream paramInputStream);
  
  public abstract g co(String paramString);
  
  public final String toString(Object paramObject)
  {
    return k(paramObject, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */