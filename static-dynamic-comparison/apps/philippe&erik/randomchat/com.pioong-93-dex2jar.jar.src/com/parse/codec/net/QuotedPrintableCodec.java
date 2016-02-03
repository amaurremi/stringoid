package com.parse.codec.net;

import com.parse.codec.BinaryDecoder;
import com.parse.codec.BinaryEncoder;
import com.parse.codec.DecoderException;
import com.parse.codec.EncoderException;
import com.parse.codec.StringDecoder;
import com.parse.codec.StringEncoder;
import com.parse.codec.binary.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class QuotedPrintableCodec
  implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder
{
  private static final byte ESCAPE_CHAR = 61;
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  private static final byte SPACE = 32;
  private static final byte TAB = 9;
  private final String charset;
  
  static
  {
    int i = 33;
    if (i > 60) {
      i = 62;
    }
    for (;;)
    {
      if (i > 126)
      {
        PRINTABLE_CHARS.set(9);
        PRINTABLE_CHARS.set(32);
        return;
        PRINTABLE_CHARS.set(i);
        i += 1;
        break;
      }
      PRINTABLE_CHARS.set(i);
      i += 1;
    }
  }
  
  public QuotedPrintableCodec()
  {
    this("UTF-8");
  }
  
  public QuotedPrintableCodec(String paramString)
  {
    this.charset = paramString;
  }
  
  public static final byte[] decodeQuotedPrintable(byte[] paramArrayOfByte)
    throws DecoderException
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    if (i >= paramArrayOfByte.length) {
      return localByteArrayOutputStream.toByteArray();
    }
    int j = paramArrayOfByte[i];
    if (j == 61) {
      i += 1;
    }
    for (;;)
    {
      try
      {
        j = Utils.digit16(paramArrayOfByte[i]);
        i += 1;
        localByteArrayOutputStream.write((char)((j << 4) + Utils.digit16(paramArrayOfByte[i])));
        i += 1;
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        throw new DecoderException("Invalid quoted-printable encoding", paramArrayOfByte);
      }
      localByteArrayOutputStream.write(j);
    }
  }
  
  private static final void encodeQuotedPrintable(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    paramByteArrayOutputStream.write(61);
    int i = Character.toUpperCase(Character.forDigit(paramInt >> 4 & 0xF, 16));
    paramInt = Character.toUpperCase(Character.forDigit(paramInt & 0xF, 16));
    paramByteArrayOutputStream.write(i);
    paramByteArrayOutputStream.write(paramInt);
  }
  
  public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    BitSet localBitSet = paramBitSet;
    if (paramBitSet == null) {
      localBitSet = PRINTABLE_CHARS;
    }
    paramBitSet = new ByteArrayOutputStream();
    int i = 0;
    if (i >= paramArrayOfByte.length) {
      return paramBitSet.toByteArray();
    }
    int k = paramArrayOfByte[i];
    int j = k;
    if (k < 0) {
      j = k + 256;
    }
    if (localBitSet.get(j)) {
      paramBitSet.write(j);
    }
    for (;;)
    {
      i += 1;
      break;
      encodeQuotedPrintable(j, paramBitSet);
    }
  }
  
  public Object decode(Object paramObject)
    throws DecoderException
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof byte[])) {
      return decode((byte[])paramObject);
    }
    if ((paramObject instanceof String)) {
      return decode((String)paramObject);
    }
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable decoded");
  }
  
  public String decode(String paramString)
    throws DecoderException
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = decode(paramString, getDefaultCharset());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new DecoderException(paramString.getMessage(), paramString);
    }
  }
  
  public String decode(String paramString1, String paramString2)
    throws DecoderException, UnsupportedEncodingException
  {
    if (paramString1 == null) {
      return null;
    }
    return new String(decode(StringUtils.getBytesUsAscii(paramString1)), paramString2);
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
    throws DecoderException
  {
    return decodeQuotedPrintable(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof byte[])) {
      return encode((byte[])paramObject);
    }
    if ((paramObject instanceof String)) {
      return encode((String)paramObject);
    }
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable encoded");
  }
  
  public String encode(String paramString)
    throws EncoderException
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = encode(paramString, getDefaultCharset());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new EncoderException(paramString.getMessage(), paramString);
    }
  }
  
  public String encode(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    if (paramString1 == null) {
      return null;
    }
    return StringUtils.newStringUsAscii(encode(paramString1.getBytes(paramString2)));
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfByte);
  }
  
  public String getDefaultCharset()
  {
    return this.charset;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/net/QuotedPrintableCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */