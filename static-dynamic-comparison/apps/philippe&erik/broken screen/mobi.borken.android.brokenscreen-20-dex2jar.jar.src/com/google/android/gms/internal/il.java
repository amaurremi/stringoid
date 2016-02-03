package com.google.android.gms.internal;

import android.database.CharArrayBuffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class il
{
  public static byte[] a(InputStream paramInputStream, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['✐'];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      if (!paramBoolean) {
        break label56;
      }
    }
    catch (IOException paramInputStream)
    {
      throw new RuntimeException(paramInputStream);
    }
    paramInputStream.close();
    label56:
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void b(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if ((paramCharArrayBuffer.data == null) || (paramCharArrayBuffer.data.length < paramString.length())) {
      paramCharArrayBuffer.data = paramString.toCharArray();
    }
    for (;;)
    {
      paramCharArrayBuffer.sizeCopied = paramString.length();
      return;
      paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */