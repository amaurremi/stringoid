package org.osmdroid.tileprovider.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamUtils
{
  public static final int IO_BUFFER_SIZE = 8192;
  private static final Logger logger = LoggerFactory.getLogger(StreamUtils.class);
  
  public static void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      logger.error("IO", "Could not close stream", paramCloseable);
    }
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    long l = 0L;
    byte[] arrayOfByte = new byte[' '];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    return l;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/util/StreamUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */