package com.parse.codec.binary;

import com.parse.codec.BinaryDecoder;
import com.parse.codec.BinaryEncoder;
import com.parse.codec.DecoderException;
import java.io.UnsupportedEncodingException;

public class Hex
  implements BinaryEncoder, BinaryDecoder
{
  public static final String DEFAULT_CHARSET_NAME = "UTF-8";
  private static final char[] DIGITS_LOWER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] DIGITS_UPPER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final String charsetName;
  
  public Hex()
  {
    this.charsetName = "UTF-8";
  }
  
  public Hex(String paramString)
  {
    this.charsetName = paramString;
  }
  
  public static byte[] decodeHex(char[] paramArrayOfChar)
    throws DecoderException
  {
    int k = paramArrayOfChar.length;
    if ((k & 0x1) != 0) {
      throw new DecoderException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[k >> 1];
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j >= k) {
        return arrayOfByte;
      }
      int m = toDigit(paramArrayOfChar[j], j);
      j += 1;
      int n = toDigit(paramArrayOfChar[j], j);
      j += 1;
      arrayOfByte[i] = ((byte)((m << 4 | n) & 0xFF));
      i += 1;
    }
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte)
  {
    return encodeHex(paramArrayOfByte, true);
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (char[] arrayOfChar = DIGITS_LOWER;; arrayOfChar = DIGITS_UPPER) {
      return encodeHex(paramArrayOfByte, arrayOfChar);
    }
  }
  
  protected static char[] encodeHex(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= k) {
        return arrayOfChar;
      }
      int m = j + 1;
      arrayOfChar[j] = paramArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = paramArrayOfChar[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
  }
  
  public static String encodeHexString(byte[] paramArrayOfByte)
  {
    return new String(encodeHex(paramArrayOfByte));
  }
  
  protected static int toDigit(char paramChar, int paramInt)
    throws DecoderException
  {
    int i = Character.digit(paramChar, 16);
    if (i == -1) {
      throw new DecoderException("Illegal hexadecimal character " + paramChar + " at index " + paramInt);
    }
    return i;
  }
  
  /* Error */
  public Object decode(Object paramObject)
    throws DecoderException
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 76
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 76	java/lang/String
    //   11: invokevirtual 115	java/lang/String:toCharArray	()[C
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 117	com/parse/codec/binary/Hex:decodeHex	([C)[B
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 118	[C
    //   24: astore_1
    //   25: goto -10 -> 15
    //   28: astore_1
    //   29: new 55	com/parse/codec/DecoderException
    //   32: dup
    //   33: aload_1
    //   34: invokevirtual 121	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   37: aload_1
    //   38: invokespecial 124	com/parse/codec/DecoderException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	Hex
    //   0	42	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	28	java/lang/ClassCastException
    //   15	20	28	java/lang/ClassCastException
    //   20	25	28	java/lang/ClassCastException
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
    throws DecoderException
  {
    try
    {
      paramArrayOfByte = decodeHex(new String(paramArrayOfByte, getCharsetName()).toCharArray());
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new DecoderException(paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
  }
  
  /* Error */
  public Object encode(Object paramObject)
    throws com.parse.codec.EncoderException
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 76
    //   4: ifeq +20 -> 24
    //   7: aload_1
    //   8: checkcast 76	java/lang/String
    //   11: aload_0
    //   12: invokevirtual 130	com/parse/codec/binary/Hex:getCharsetName	()Ljava/lang/String;
    //   15: invokevirtual 141	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   18: astore_1
    //   19: aload_1
    //   20: invokestatic 78	com/parse/codec/binary/Hex:encodeHex	([B)[C
    //   23: areturn
    //   24: aload_1
    //   25: checkcast 143	[B
    //   28: astore_1
    //   29: goto -10 -> 19
    //   32: astore_1
    //   33: new 137	com/parse/codec/EncoderException
    //   36: dup
    //   37: aload_1
    //   38: invokevirtual 121	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   41: aload_1
    //   42: invokespecial 144	com/parse/codec/EncoderException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   45: athrow
    //   46: astore_1
    //   47: new 137	com/parse/codec/EncoderException
    //   50: dup
    //   51: aload_1
    //   52: invokevirtual 134	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   55: aload_1
    //   56: invokespecial 144	com/parse/codec/EncoderException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	Hex
    //   0	60	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	19	32	java/lang/ClassCastException
    //   19	24	32	java/lang/ClassCastException
    //   24	29	32	java/lang/ClassCastException
    //   0	19	46	java/io/UnsupportedEncodingException
    //   19	24	46	java/io/UnsupportedEncodingException
    //   24	29	46	java/io/UnsupportedEncodingException
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return StringUtils.getBytesUnchecked(encodeHexString(paramArrayOfByte), getCharsetName());
  }
  
  public String getCharsetName()
  {
    return this.charsetName;
  }
  
  public String toString()
  {
    return super.toString() + "[charsetName=" + this.charsetName + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/binary/Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */