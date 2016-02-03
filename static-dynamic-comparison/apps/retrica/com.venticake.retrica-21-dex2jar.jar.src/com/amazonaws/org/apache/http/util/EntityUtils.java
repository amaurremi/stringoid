package com.amazonaws.org.apache.http.util;

import com.amazonaws.org.apache.http.HttpEntity;
import java.io.InputStream;

public final class EntityUtils
{
  public static void consume(HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity == null) {}
    do
    {
      do
      {
        return;
      } while (!paramHttpEntity.isStreaming());
      paramHttpEntity = paramHttpEntity.getContent();
    } while (paramHttpEntity == null);
    paramHttpEntity.close();
  }
  
  public static byte[] toByteArray(HttpEntity paramHttpEntity)
  {
    int i = 4096;
    if (paramHttpEntity == null) {
      throw new IllegalArgumentException("HTTP entity may not be null");
    }
    InputStream localInputStream = paramHttpEntity.getContent();
    if (localInputStream == null) {
      return null;
    }
    try
    {
      if (paramHttpEntity.getContentLength() > 2147483647L) {
        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
      }
    }
    finally
    {
      localInputStream.close();
    }
    int j = (int)paramHttpEntity.getContentLength();
    if (j < 0) {}
    for (;;)
    {
      paramHttpEntity = new ByteArrayBuffer(i);
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramHttpEntity.append(arrayOfByte, 0, i);
      }
      paramHttpEntity = paramHttpEntity.toByteArray();
      localInputStream.close();
      return paramHttpEntity;
      i = j;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/util/EntityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */