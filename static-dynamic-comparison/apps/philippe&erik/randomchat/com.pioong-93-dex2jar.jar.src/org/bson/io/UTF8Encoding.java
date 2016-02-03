package org.bson.io;

import java.io.IOException;
import java.text.MessageFormat;

class UTF8Encoding
{
  private static final int MAX_CODE_POINT = 1114111;
  private static final int MIN_2_BYTES = 128;
  private static final int MIN_3_BYTES = 2048;
  private static final int MIN_4_BYTES = 65536;
  private char[] decoderArray = new char['Ѐ'];
  
  private static final void checkByte(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if ((paramInt1 & 0xC0) != 128) {
      throw new IOException(MessageFormat.format("Illegal UTF-8 sequence: byte {0} of {1} byte sequence is not 10xxxxxx: {2}", new Object[] { new Integer(paramInt2), new Integer(paramInt3), new Integer(paramInt1) }));
    }
  }
  
  private static final void checkMinimal(int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 >= paramInt2) {
      return;
    }
    int i;
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unexpected minValue passed to checkMinimal: " + paramInt2);
    case 128: 
      paramInt2 = 2;
      if (paramInt1 < 128) {
        i = 1;
      }
      break;
    }
    for (;;)
    {
      throw new IOException(MessageFormat.format("Illegal UTF-8 sequence: {0} bytes used to encode a {1} byte value: {2}", new Object[] { new Integer(paramInt2), new Integer(i), new Integer(paramInt1) }));
      paramInt2 = 3;
      break;
      paramInt2 = 4;
      break;
      if (paramInt1 < 2048)
      {
        i = 2;
      }
      else
      {
        if (paramInt1 >= 65536) {
          break label161;
        }
        i = 3;
      }
    }
    label161:
    throw new IllegalArgumentException("unexpected ch passed to checkMinimal: " + paramInt1);
  }
  
  public String decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    for (;;)
    {
      char[] arrayOfChar1;
      int n;
      int j;
      int m;
      int k;
      try
      {
        char[] arrayOfChar2 = this.decoderArray;
        arrayOfChar1 = arrayOfChar2;
        if (arrayOfChar2.length < paramInt2)
        {
          arrayOfChar1 = new char[paramInt2];
          this.decoderArray = arrayOfChar1;
        }
        n = paramInt2 + paramInt1;
        j = 0;
        if (paramInt1 >= n) {
          break label559;
        }
        m = paramInt1 + 1;
        k = paramArrayOfByte[paramInt1] & 0xFF;
        if (k < 128)
        {
          paramInt1 = m;
          paramInt2 = k;
          if (paramInt2 <= 1114111) {
            break label444;
          }
          try
          {
            throw new IOException(MessageFormat.format("Illegal UTF-8 sequence: final value is out of range: {0}", new Object[] { new Integer(paramInt2) }));
          }
          catch (ArrayIndexOutOfBoundsException paramArrayOfByte) {}
          throw new IOException("Illegal UTF-8 sequence: multibyte sequence was truncated");
        }
      }
      finally {}
      if (k < 192) {
        throw new IOException(MessageFormat.format("Illegal UTF-8 sequence: initial byte is {0}: {1}", new Object[] { "10xxxxxx", new Integer(k) }));
      }
      if (k < 224)
      {
        checkByte(paramArrayOfByte[m], 2, 2);
        paramInt2 = m + 1;
        k = (k & 0x1F) << 6 | paramArrayOfByte[m] & 0x3F;
        paramInt1 = paramInt2;
      }
      label444:
      label559:
      try
      {
        checkMinimal(k, 128);
        paramInt1 = paramInt2;
        paramInt2 = k;
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte) {}
      if (k < 240)
      {
        checkByte(paramArrayOfByte[m], 2, 3);
        paramInt2 = m + 1;
        m = paramArrayOfByte[m];
        paramInt1 = paramInt2;
        checkByte(paramArrayOfByte[paramInt2], 3, 3);
        paramInt1 = paramInt2 + 1;
        paramInt2 = (k & 0xF) << 12 | (m & 0x3F) << 6 | paramArrayOfByte[paramInt2] & 0x3F;
        checkMinimal(paramInt2, 2048);
      }
      else if (k < 248)
      {
        checkByte(paramArrayOfByte[m], 2, 4);
        paramInt2 = m + 1;
        m = paramArrayOfByte[m];
        paramInt1 = paramInt2;
        checkByte(paramArrayOfByte[paramInt2], 3, 4);
        paramInt1 = paramInt2 + 1;
        int i1 = paramArrayOfByte[paramInt2];
        checkByte(paramArrayOfByte[paramInt1], 4, 4);
        paramInt2 = paramInt1 + 1;
        k = (k & 0x7) << 18 | (m & 0x3F) << 12 | (i1 & 0x3F) << 6 | paramArrayOfByte[paramInt1] & 0x3F;
        paramInt1 = paramInt2;
        checkMinimal(k, 65536);
        paramInt1 = paramInt2;
        paramInt2 = k;
      }
      else
      {
        throw new IOException(MessageFormat.format("Illegal UTF-8 sequence: initial byte is {0}: {1}", new Object[] { "11111xxx", new Integer(k) }));
        if (paramInt2 > 65535)
        {
          paramInt2 -= 65536;
          k = j + 1;
          arrayOfChar1[j] = ((char)(55296 + (paramInt2 >> 10)));
          int i = (char)(56320 + (paramInt2 & 0x3FF));
          arrayOfChar1[k] = i;
          paramInt2 = k + 1;
        }
        else
        {
          if ((paramInt2 >= 55296) && (paramInt2 < 57344)) {
            throw new IOException(MessageFormat.format("Illegal UTF-8 sequence: final value is a surrogate value: {0}", new Object[] { new Integer(paramInt2) }));
          }
          k = j + 1;
          arrayOfChar1[j] = ((char)paramInt2);
          paramInt2 = k;
          break label596;
          if (paramInt1 > n) {
            throw new IOException("Illegal UTF-8 sequence: multibyte sequence was truncated");
          }
          paramArrayOfByte = new String(arrayOfChar1, 0, j);
          return paramArrayOfByte;
          continue;
        }
        label596:
        j = paramInt2;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/io/UTF8Encoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */