package biz.source_code.base64Coder;

public class Base64Coder
{
  private static final char[] map1;
  private static final byte[] map2;
  private static final String systemLineSeparator;
  
  static
  {
    int m = 0;
    systemLineSeparator = System.getProperty("line.separator");
    map1 = new char[64];
    int i = 65;
    int j = 0;
    while (i <= 90)
    {
      map1[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 97;
    while (i <= 122)
    {
      map1[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 48;
    while (i <= 57)
    {
      map1[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    char[] arrayOfChar = map1;
    int k = j + 1;
    arrayOfChar[j] = '+';
    map1[k] = '/';
    map2 = new byte[''];
    j = 0;
    for (;;)
    {
      k = m;
      if (j >= map2.length) {
        break;
      }
      map2[j] = -1;
      j += 1;
    }
    while (k < 64)
    {
      map2[map1[k]] = ((byte)k);
      k += 1;
    }
  }
  
  public static byte[] decode(String paramString)
  {
    return decode(paramString.toCharArray());
  }
  
  public static byte[] decode(char[] paramArrayOfChar)
  {
    return decode(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static byte[] decode(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 % 4 != 0) {
      throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
    while ((i > 0) && (paramArrayOfChar[(paramInt1 + i - 1)] == '=')) {
      i -= 1;
    }
    int k = i * 3 / 4;
    byte[] arrayOfByte = new byte[k];
    int m = paramInt1 + i;
    paramInt2 = 0;
    int n;
    int j;
    if (paramInt1 < m)
    {
      i = paramInt1 + 1;
      n = paramArrayOfChar[paramInt1];
      paramInt1 = i + 1;
      int i1 = paramArrayOfChar[i];
      if (paramInt1 < m)
      {
        i = paramArrayOfChar[paramInt1];
        paramInt1 += 1;
        if (paramInt1 >= m) {
          break label157;
        }
        j = paramArrayOfChar[paramInt1];
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((n <= 127) && (i1 <= 127) && (i <= 127) && (j <= 127)) {
          break label164;
        }
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
        i = 65;
        break;
        label157:
        j = 65;
      }
      label164:
      int i2 = map2[n];
      i1 = map2[i1];
      n = map2[i];
      j = map2[j];
      if ((i2 < 0) || (i1 < 0) || (n < 0) || (j < 0)) {
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
      }
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = ((byte)(i2 << 2 | i1 >>> 4));
      if (i >= k) {
        break label306;
      }
      paramInt2 = i + 1;
      arrayOfByte[i] = ((byte)((i1 & 0xF) << 4 | n >>> 2));
    }
    for (;;)
    {
      if (paramInt2 < k)
      {
        i = paramInt2 + 1;
        arrayOfByte[paramInt2] = ((byte)((n & 0x3) << 6 | j));
        paramInt2 = i;
      }
      for (;;)
      {
        break;
        return arrayOfByte;
      }
      label306:
      paramInt2 = i;
    }
  }
  
  public static byte[] decodeLines(String paramString)
  {
    char[] arrayOfChar = new char[paramString.length()];
    int j = 0;
    int m;
    for (int k = 0; j < paramString.length(); k = m)
    {
      int i = paramString.charAt(j);
      m = k;
      if (i != 32)
      {
        m = k;
        if (i != 13)
        {
          m = k;
          if (i != 10)
          {
            m = k;
            if (i != 9)
            {
              arrayOfChar[k] = i;
              m = k + 1;
            }
          }
        }
      }
      j += 1;
    }
    return decode(arrayOfChar, 0, k);
  }
  
  public static String decodeString(String paramString)
  {
    return new String(decode(paramString));
  }
  
  public static char[] encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static char[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramInt);
  }
  
  public static char[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = (paramInt2 * 4 + 2) / 3;
    char[] arrayOfChar = new char[(paramInt2 + 2) / 3 * 4];
    int i1 = paramInt1 + paramInt2;
    paramInt2 = 0;
    if (paramInt1 < i1)
    {
      int j = paramInt1 + 1;
      int i2 = paramArrayOfByte[paramInt1] & 0xFF;
      int k;
      if (j < i1)
      {
        paramInt1 = paramArrayOfByte[j] & 0xFF;
        k = j + 1;
        j = paramInt1;
        paramInt1 = k;
        label75:
        if (paramInt1 >= i1) {
          break label218;
        }
        k = paramInt1 + 1;
        int m = paramArrayOfByte[paramInt1] & 0xFF;
        paramInt1 = k;
        k = m;
        label102:
        m = paramInt2 + 1;
        arrayOfChar[paramInt2] = map1[(i2 >>> 2)];
        paramInt2 = m + 1;
        arrayOfChar[m] = map1[((i2 & 0x3) << 4 | j >>> 4)];
        if (paramInt2 >= n) {
          break label224;
        }
        i = map1[((j & 0xF) << 2 | k >>> 6)];
        label168:
        arrayOfChar[paramInt2] = i;
        paramInt2 += 1;
        if (paramInt2 >= n) {
          break label230;
        }
      }
      label218:
      label224:
      label230:
      for (int i = map1[(k & 0x3F)];; i = 61)
      {
        arrayOfChar[paramInt2] = i;
        paramInt2 += 1;
        break;
        k = 0;
        paramInt1 = j;
        j = k;
        break label75;
        k = 0;
        break label102;
        i = 61;
        break label168;
      }
    }
    return arrayOfChar;
  }
  
  public static String encodeLines(byte[] paramArrayOfByte)
  {
    return encodeLines(paramArrayOfByte, 0, paramArrayOfByte.length, 76, systemLineSeparator);
  }
  
  public static String encodeLines(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int i = paramInt3 * 3 / 4;
    if (i <= 0) {
      throw new IllegalArgumentException();
    }
    paramInt3 = (paramInt2 + i - 1) / i;
    int j = (paramInt2 + 2) / 3;
    StringBuilder localStringBuilder = new StringBuilder(paramInt3 * paramString.length() + j * 4);
    paramInt3 = 0;
    while (paramInt3 < paramInt2)
    {
      j = Math.min(paramInt2 - paramInt3, i);
      localStringBuilder.append(encode(paramArrayOfByte, paramInt1 + paramInt3, j));
      localStringBuilder.append(paramString);
      paramInt3 += j;
    }
    return localStringBuilder.toString();
  }
  
  public static String encodeString(String paramString)
  {
    return new String(encode(paramString.getBytes()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/biz/source_code/base64Coder/Base64Coder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */