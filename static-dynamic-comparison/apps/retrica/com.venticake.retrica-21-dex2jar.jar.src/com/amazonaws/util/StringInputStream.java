package com.amazonaws.util;

import java.io.ByteArrayInputStream;

public class StringInputStream
  extends ByteArrayInputStream
{
  private final String string;
  
  public StringInputStream(String paramString)
  {
    super(paramString.getBytes(StringUtils.UTF8));
    this.string = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/StringInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */