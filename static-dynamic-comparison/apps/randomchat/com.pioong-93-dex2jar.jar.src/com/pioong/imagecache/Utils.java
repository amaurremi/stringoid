package com.pioong.imagecache;

import java.io.InputStream;
import java.io.OutputStream;

public class Utils
{
  public static void CopyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          return;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return;
    }
    catch (Exception paramInputStream) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/imagecache/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */