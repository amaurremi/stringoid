package com.drew.lang;

import java.io.IOException;

public final class BufferBoundsException
  extends Exception
{
  private static final long serialVersionUID = 2911102837808946396L;
  
  public BufferBoundsException(String paramString)
  {
    super(paramString);
  }
  
  public BufferBoundsException(String paramString, IOException paramIOException)
  {
    super(paramString, paramIOException);
  }
  
  public BufferBoundsException(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(a(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return String.format("Attempt to read from buffer using a negative index (%s)", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 1) {}
    for (String str = "";; str = "s") {
      return String.format("Attempt to read %d byte%s from beyond end of buffer (requested index: %d, max index: %d)", new Object[] { Integer.valueOf(paramInt2), str, Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.length - 1) });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/lang/BufferBoundsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */