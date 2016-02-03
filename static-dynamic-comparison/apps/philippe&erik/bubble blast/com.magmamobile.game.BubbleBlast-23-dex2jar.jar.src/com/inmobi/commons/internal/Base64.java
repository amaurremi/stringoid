package com.inmobi.commons.internal;

import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int CRLF = 4;
  public static final int DEFAULT = 0;
  public static final int NO_CLOSE = 16;
  public static final int NO_PADDING = 1;
  public static final int NO_WRAP = 2;
  public static final int URL_SAFE = 8;
  
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localb.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localb.b == localb.a.length) {
      return localb.a;
    }
    paramArrayOfByte = new byte[localb.b];
    System.arraycopy(localb.a, 0, paramArrayOfByte, 0, localb.b);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localc.e)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localc.f)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localc.g) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localc.a = new byte[i];
      localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((a) || (localc.b == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localc.a;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
    
    public abstract int a(int paramInt);
    
    public abstract boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  static class b
    extends Base64.a
  {
    private static final int[] c;
    private static final int[] d;
    private static final int e = -1;
    private static final int f = -2;
    private int g;
    private int h;
    private final int[] i;
    
    static
    {
      int[] arrayOfInt = new int['Ā'];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = 62;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = -1;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = 63;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = -1;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      c = arrayOfInt;
      arrayOfInt = new int['Ā'];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = -1;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = 62;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = -1;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = 63;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      d = arrayOfInt;
    }
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = c;; paramArrayOfByte = d)
      {
        this.i = paramArrayOfByte;
        this.g = 0;
        this.h = 0;
        return;
      }
    }
    
    public int a(int paramInt)
    {
      return paramInt * 3 / 4 + 10;
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.g == 6) {
        return false;
      }
      int i3 = paramInt2 + paramInt1;
      paramInt2 = this.g;
      int j = this.h;
      int k = 0;
      byte[] arrayOfByte = this.a;
      int[] arrayOfInt = this.i;
      int m;
      if (paramInt1 >= i3)
      {
        if (!paramBoolean)
        {
          this.g = paramInt2;
          this.h = j;
          this.b = k;
          return true;
        }
      }
      else
      {
        int n = k;
        int i1 = j;
        int i2 = paramInt1;
        if (paramInt2 == 0)
        {
          m = paramInt1;
          paramInt1 = j;
          for (;;)
          {
            if (m + 4 <= i3)
            {
              paramInt1 = arrayOfInt[(paramArrayOfByte[m] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(m + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(m + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(m + 3)] & 0xFF)];
              if (paramInt1 >= 0) {}
            }
            else
            {
              n = k;
              i1 = paramInt1;
              i2 = m;
              if (m < i3) {
                break label239;
              }
              j = paramInt1;
              break;
            }
            arrayOfByte[(k + 2)] = ((byte)paramInt1);
            arrayOfByte[(k + 1)] = ((byte)(paramInt1 >> 8));
            arrayOfByte[k] = ((byte)(paramInt1 >> 16));
            k += 3;
            m += 4;
          }
        }
        label239:
        paramInt1 = i2 + 1;
        j = arrayOfInt[(paramArrayOfByte[i2] & 0xFF)];
        switch (paramInt2)
        {
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    k = n;
                    j = i1;
                    break;
                    if (j >= 0)
                    {
                      paramInt2 += 1;
                      k = n;
                      break;
                    }
                  } while (j == -1);
                  this.g = 6;
                  return false;
                  if (j >= 0)
                  {
                    j = i1 << 6 | j;
                    paramInt2 += 1;
                    k = n;
                    break;
                  }
                } while (j == -1);
                this.g = 6;
                return false;
                if (j >= 0)
                {
                  j = i1 << 6 | j;
                  paramInt2 += 1;
                  k = n;
                  break;
                }
                if (j == -2)
                {
                  arrayOfByte[n] = ((byte)(i1 >> 4));
                  paramInt2 = 4;
                  k = n + 1;
                  j = i1;
                  break;
                }
              } while (j == -1);
              this.g = 6;
              return false;
              if (j >= 0)
              {
                j = i1 << 6 | j;
                arrayOfByte[(n + 2)] = ((byte)j);
                arrayOfByte[(n + 1)] = ((byte)(j >> 8));
                arrayOfByte[n] = ((byte)(j >> 16));
                k = n + 3;
                paramInt2 = 0;
                break;
              }
              if (j == -2)
              {
                arrayOfByte[(n + 1)] = ((byte)(i1 >> 2));
                arrayOfByte[n] = ((byte)(i1 >> 10));
                k = n + 2;
                paramInt2 = 5;
                j = i1;
                break;
              }
            } while (j == -1);
            this.g = 6;
            return false;
            if (j == -2)
            {
              paramInt2 += 1;
              k = n;
              j = i1;
              break;
            }
          } while (j == -1);
          this.g = 6;
          return false;
        } while (j == -1);
        this.g = 6;
        return false;
      }
      paramInt1 = k;
      switch (paramInt2)
      {
      default: 
        paramInt1 = k;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.g = paramInt2;
          this.b = paramInt1;
          return true;
          this.g = 6;
          return false;
          arrayOfByte[k] = ((byte)(j >> 4));
          paramInt1 = k + 1;
          continue;
          m = k + 1;
          arrayOfByte[k] = ((byte)(j >> 10));
          paramInt1 = m + 1;
          arrayOfByte[m] = ((byte)(j >> 2));
        }
      }
      this.g = 6;
      return false;
    }
  }
  
  static class c
    extends Base64.a
  {
    public static final int c = 19;
    private static final byte[] i;
    private static final byte[] j;
    int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final byte[] k;
    private int l;
    private final byte[] m;
    
    static
    {
      if (!Base64.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        h = bool;
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        j = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public c(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.e = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.f = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.g = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = i;
        label63:
        this.m = paramArrayOfByte;
        this.k = new byte[2];
        this.d = 0;
        if (!this.f) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.l = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = j;
        break label63;
      }
    }
    
    public int a(int paramInt)
    {
      return paramInt * 8 / 5 + 10;
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = this.m;
      byte[] arrayOfByte2 = this.a;
      int i1 = 0;
      int i3 = this.l;
      int i5 = paramInt2 + paramInt1;
      int i2 = -1;
      int n;
      switch (this.d)
      {
      default: 
        n = paramInt1;
        label63:
        paramInt1 = i3;
        paramInt2 = i1;
        i1 = n;
        if (i2 != -1)
        {
          arrayOfByte2[0] = arrayOfByte1[(i2 >> 18 & 0x3F)];
          arrayOfByte2[1] = arrayOfByte1[(i2 >> 12 & 0x3F)];
          arrayOfByte2[2] = arrayOfByte1[(i2 >> 6 & 0x3F)];
          paramInt2 = 4;
          arrayOfByte2[3] = arrayOfByte1[(i2 & 0x3F)];
          i2 = i3 - 1;
          paramInt1 = i2;
          i1 = n;
          if (i2 == 0)
          {
            if (!this.g) {
              break label1214;
            }
            paramInt1 = 5;
            arrayOfByte2[4] = 13;
          }
        }
        break;
      }
      for (;;)
      {
        arrayOfByte2[paramInt1] = 10;
        i2 = 19;
        paramInt2 = paramInt1 + 1;
        for (;;)
        {
          if (n + 3 > i5)
          {
            if (!paramBoolean) {
              break label1055;
            }
            if (n - this.d != i5 - 1) {
              break label715;
            }
            if (this.d <= 0) {
              break label698;
            }
            paramArrayOfByte = this.k;
            i3 = 1;
            i1 = paramArrayOfByte[0];
            paramInt1 = n;
            n = i3;
            label240:
            i1 = (i1 & 0xFF) << 4;
            this.d -= n;
            i3 = paramInt2 + 1;
            arrayOfByte2[paramInt2] = arrayOfByte1[(i1 >> 6 & 0x3F)];
            n = i3 + 1;
            arrayOfByte2[i3] = arrayOfByte1[(i1 & 0x3F)];
            paramInt2 = n;
            if (this.e)
            {
              i1 = n + 1;
              arrayOfByte2[n] = 61;
              paramInt2 = i1 + 1;
              arrayOfByte2[i1] = 61;
            }
            if (!this.f) {
              break label1190;
            }
            n = paramInt2;
            if (this.g)
            {
              arrayOfByte2[paramInt2] = 13;
              n = paramInt2 + 1;
            }
            paramInt2 = n + 1;
            arrayOfByte2[n] = 10;
            i1 = paramInt1;
            paramInt1 = paramInt2;
            label380:
            if ((h) || (this.d == 0)) {
              break label1028;
            }
            throw new AssertionError();
            n = paramInt1;
            break label63;
            if (paramInt1 + 2 > i5) {
              break;
            }
            n = this.k[0];
            paramInt2 = paramInt1 + 1;
            i2 = (n & 0xFF) << 16 | (paramArrayOfByte[paramInt1] & 0xFF) << 8 | paramArrayOfByte[paramInt2] & 0xFF;
            this.d = 0;
            n = paramInt2 + 1;
            break label63;
            if (paramInt1 + 1 > i5) {
              break;
            }
            paramInt2 = this.k[0];
            i2 = this.k[1];
            n = paramInt1 + 1;
            i2 = (paramInt2 & 0xFF) << 16 | (i2 & 0xFF) << 8 | paramArrayOfByte[paramInt1] & 0xFF;
            this.d = 0;
            break label63;
          }
          paramInt1 = (paramArrayOfByte[n] & 0xFF) << 16 | (paramArrayOfByte[(n + 1)] & 0xFF) << 8 | paramArrayOfByte[(n + 2)] & 0xFF;
          arrayOfByte2[paramInt2] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
          arrayOfByte2[(paramInt2 + 1)] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
          arrayOfByte2[(paramInt2 + 2)] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
          arrayOfByte2[(paramInt2 + 3)] = arrayOfByte1[(paramInt1 & 0x3F)];
          n += 3;
          i3 = paramInt2 + 4;
          i2 -= 1;
          paramInt1 = i2;
          paramInt2 = i3;
          i1 = n;
          if (i2 == 0)
          {
            if (this.g)
            {
              paramInt1 = i3 + 1;
              arrayOfByte2[i3] = 13;
            }
            for (;;)
            {
              arrayOfByte2[paramInt1] = 10;
              i2 = 19;
              paramInt2 = paramInt1 + 1;
              break;
              label698:
              i1 = paramArrayOfByte[n];
              paramInt1 = n + 1;
              n = 0;
              break label240;
              label715:
              label751:
              int i4;
              if (n - this.d == i5 - 2) {
                if (this.d > 1)
                {
                  byte[] arrayOfByte3 = this.k;
                  paramInt1 = 1;
                  i3 = arrayOfByte3[0];
                  if (this.d <= 0) {
                    break label937;
                  }
                  i4 = this.k[paramInt1];
                  paramInt1 += 1;
                  i1 = n;
                  n = i4;
                  label778:
                  n = (n & 0xFF) << 2 | (i3 & 0xFF) << 10;
                  this.d -= paramInt1;
                  paramInt1 = paramInt2 + 1;
                  arrayOfByte2[paramInt2] = arrayOfByte1[(n >> 12 & 0x3F)];
                  paramInt2 = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = arrayOfByte1[(n >> 6 & 0x3F)];
                  paramInt1 = paramInt2 + 1;
                  arrayOfByte2[paramInt2] = arrayOfByte1[(n & 0x3F)];
                  if (!this.e) {
                    break label1187;
                  }
                  paramInt2 = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 61;
                  paramInt1 = paramInt2;
                }
              }
              label937:
              label1028:
              label1055:
              label1107:
              label1187:
              for (;;)
              {
                if (this.f)
                {
                  paramInt2 = paramInt1;
                  if (this.g)
                  {
                    arrayOfByte2[paramInt1] = 13;
                    paramInt2 = paramInt1 + 1;
                  }
                  paramInt1 = paramInt2 + 1;
                  arrayOfByte2[paramInt2] = 10;
                  break;
                  i3 = paramArrayOfByte[n];
                  n += 1;
                  paramInt1 = 0;
                  break label751;
                  i4 = paramArrayOfByte[n];
                  i1 = n + 1;
                  n = i4;
                  break label778;
                  i1 = n;
                  paramInt1 = paramInt2;
                  if (!this.f) {
                    break;
                  }
                  i1 = n;
                  paramInt1 = paramInt2;
                  if (paramInt2 <= 0) {
                    break;
                  }
                  i1 = n;
                  paramInt1 = paramInt2;
                  if (i2 == 19) {
                    break;
                  }
                  if (this.g)
                  {
                    paramInt1 = paramInt2 + 1;
                    arrayOfByte2[paramInt2] = 13;
                  }
                  for (;;)
                  {
                    paramInt2 = paramInt1 + 1;
                    arrayOfByte2[paramInt1] = 10;
                    i1 = n;
                    paramInt1 = paramInt2;
                    break;
                    i3 = paramInt1;
                    if (!h)
                    {
                      i3 = paramInt1;
                      if (i1 != i5)
                      {
                        throw new AssertionError();
                        if (n != i5 - 1) {
                          break label1107;
                        }
                        arrayOfByte1 = this.k;
                        paramInt1 = this.d;
                        this.d = (paramInt1 + 1);
                        arrayOfByte1[paramInt1] = paramArrayOfByte[n];
                        i3 = paramInt2;
                      }
                    }
                    for (;;)
                    {
                      this.b = i3;
                      this.l = i2;
                      return true;
                      i3 = paramInt2;
                      if (n == i5 - 2)
                      {
                        arrayOfByte1 = this.k;
                        paramInt1 = this.d;
                        this.d = (paramInt1 + 1);
                        arrayOfByte1[paramInt1] = paramArrayOfByte[n];
                        arrayOfByte1 = this.k;
                        paramInt1 = this.d;
                        this.d = (paramInt1 + 1);
                        arrayOfByte1[paramInt1] = paramArrayOfByte[(n + 1)];
                        i3 = paramInt2;
                      }
                    }
                    paramInt1 = paramInt2;
                  }
                }
                break;
              }
              label1190:
              i1 = paramInt1;
              paramInt1 = paramInt2;
              break label380;
              paramInt1 = i3;
            }
          }
          n = i1;
          i2 = paramInt1;
        }
        label1214:
        paramInt1 = 4;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/commons/internal/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */