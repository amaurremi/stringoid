package com.parse.codec.binary;

import com.parse.codec.BinaryDecoder;
import com.parse.codec.BinaryEncoder;
import com.parse.codec.DecoderException;
import com.parse.codec.EncoderException;

public class BinaryCodec
  implements BinaryDecoder, BinaryEncoder
{
  private static final int[] BITS = { 1, 2, 4, 8, 16, 32, 64, 128 };
  private static final int BIT_0 = 1;
  private static final int BIT_1 = 2;
  private static final int BIT_2 = 4;
  private static final int BIT_3 = 8;
  private static final int BIT_4 = 16;
  private static final int BIT_5 = 32;
  private static final int BIT_6 = 64;
  private static final int BIT_7 = 128;
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final char[] EMPTY_CHAR_ARRAY = new char[0];
  
  static
  {
    EMPTY_BYTE_ARRAY = new byte[0];
  }
  
  public static byte[] fromAscii(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (isEmpty(paramArrayOfByte)) {
      localObject = EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte;
    int j;
    int i;
    do
    {
      return (byte[])localObject;
      arrayOfByte = new byte[paramArrayOfByte.length >> 3];
      j = 0;
      i = paramArrayOfByte.length - 1;
      localObject = arrayOfByte;
    } while (j >= arrayOfByte.length);
    int k = 0;
    for (;;)
    {
      if (k >= BITS.length)
      {
        j += 1;
        i -= 8;
        break;
      }
      if (paramArrayOfByte[(i - k)] == 49) {
        arrayOfByte[j] = ((byte)(arrayOfByte[j] | BITS[k]));
      }
      k += 1;
    }
  }
  
  public static byte[] fromAscii(char[] paramArrayOfChar)
  {
    Object localObject;
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      localObject = EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte;
    int j;
    int i;
    do
    {
      return (byte[])localObject;
      arrayOfByte = new byte[paramArrayOfChar.length >> 3];
      j = 0;
      i = paramArrayOfChar.length - 1;
      localObject = arrayOfByte;
    } while (j >= arrayOfByte.length);
    int k = 0;
    for (;;)
    {
      if (k >= BITS.length)
      {
        j += 1;
        i -= 8;
        break;
      }
      if (paramArrayOfChar[(i - k)] == '1') {
        arrayOfByte[j] = ((byte)(arrayOfByte[j] | BITS[k]));
      }
      k += 1;
    }
  }
  
  private static boolean isEmpty(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }
  
  public static byte[] toAsciiBytes(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (isEmpty(paramArrayOfByte))
    {
      localObject = EMPTY_BYTE_ARRAY;
      return (byte[])localObject;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length << 3];
    int j = 0;
    int i = arrayOfByte.length - 1;
    int k;
    for (;;)
    {
      localObject = arrayOfByte;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      k = 0;
      if (k < BITS.length) {
        break label63;
      }
      j += 1;
      i -= 8;
    }
    label63:
    if ((paramArrayOfByte[j] & BITS[k]) == 0) {
      arrayOfByte[(i - k)] = 48;
    }
    for (;;)
    {
      k += 1;
      break;
      arrayOfByte[(i - k)] = 49;
    }
  }
  
  public static char[] toAsciiChars(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (isEmpty(paramArrayOfByte))
    {
      localObject = EMPTY_CHAR_ARRAY;
      return (char[])localObject;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length << 3];
    int j = 0;
    int i = arrayOfChar.length - 1;
    int k;
    for (;;)
    {
      localObject = arrayOfChar;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      k = 0;
      if (k < BITS.length) {
        break label63;
      }
      j += 1;
      i -= 8;
    }
    label63:
    if ((paramArrayOfByte[j] & BITS[k]) == 0) {
      arrayOfChar[(i - k)] = '0';
    }
    for (;;)
    {
      k += 1;
      break;
      arrayOfChar[(i - k)] = '1';
    }
  }
  
  public static String toAsciiString(byte[] paramArrayOfByte)
  {
    return new String(toAsciiChars(paramArrayOfByte));
  }
  
  public Object decode(Object paramObject)
    throws DecoderException
  {
    if (paramObject == null) {
      return EMPTY_BYTE_ARRAY;
    }
    if ((paramObject instanceof byte[])) {
      return fromAscii((byte[])paramObject);
    }
    if ((paramObject instanceof char[])) {
      return fromAscii((char[])paramObject);
    }
    if ((paramObject instanceof String)) {
      return fromAscii(((String)paramObject).toCharArray());
    }
    throw new DecoderException("argument not a byte array");
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return fromAscii(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof byte[])) {
      throw new EncoderException("argument not a byte array");
    }
    return toAsciiChars((byte[])paramObject);
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return toAsciiBytes(paramArrayOfByte);
  }
  
  public byte[] toByteArray(String paramString)
  {
    if (paramString == null) {
      return EMPTY_BYTE_ARRAY;
    }
    return fromAscii(paramString.toCharArray());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/binary/BinaryCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */