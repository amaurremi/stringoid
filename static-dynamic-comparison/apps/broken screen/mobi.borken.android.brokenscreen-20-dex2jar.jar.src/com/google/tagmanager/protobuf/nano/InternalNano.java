package com.google.tagmanager.protobuf.nano;

import java.io.UnsupportedEncodingException;

public class InternalNano
{
  public static final byte[] bytesDefaultValue(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", paramString);
    }
  }
  
  public static final byte[] copyFromUtf8(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?");
    }
  }
  
  public static final String stringDefaultValue(String paramString)
  {
    try
    {
      paramString = new String(paramString.getBytes("ISO-8859-1"), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/protobuf/nano/InternalNano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */