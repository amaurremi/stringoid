package com.parse.codec;

public abstract interface BinaryDecoder
  extends Decoder
{
  public abstract byte[] decode(byte[] paramArrayOfByte)
    throws DecoderException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/BinaryDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */