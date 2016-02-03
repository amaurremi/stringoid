package com.mopub.common.util;

import java.io.IOException;
import java.io.InputStream;

public class Strings
{
  public static String fromStream(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte['က'];
    while (i != -1)
    {
      localStringBuffer.append(new String(arrayOfByte, 0, i));
      i = paramInputStream.read(arrayOfByte);
    }
    paramInputStream.close();
    return localStringBuffer.toString();
  }
  
  public static boolean isEmpty(String paramString)
  {
    if (paramString == null) {}
    while (paramString.length() != 0) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */