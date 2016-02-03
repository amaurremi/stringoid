package com.amazonaws.internal;

import java.io.IOException;

public class CRC32MismatchException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public CRC32MismatchException(String paramString)
  {
    super(paramString);
  }
  
  public CRC32MismatchException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/CRC32MismatchException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */