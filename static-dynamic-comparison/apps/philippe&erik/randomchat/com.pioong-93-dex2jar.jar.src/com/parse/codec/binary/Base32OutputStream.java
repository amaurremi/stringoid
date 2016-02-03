package com.parse.codec.binary;

import java.io.OutputStream;

public class Base32OutputStream
  extends BaseNCodecOutputStream
{
  public Base32OutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, true);
  }
  
  public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    super(paramOutputStream, new Base32(false), paramBoolean);
  }
  
  public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramOutputStream, new Base32(paramInt, paramArrayOfByte), paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/binary/Base32OutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */