package com.mapbar.android.maps;

public class v
{
  public static String a(String paramString)
  {
    s locals = new s(123231312L);
    byte[] arrayOfByte1 = paramString.getBytes();
    paramString = "";
    int i = 0;
    while (i < arrayOfByte1.length / 16)
    {
      byte[] arrayOfByte2 = new byte[8];
      int j = 0;
      while (j <= 7)
      {
        arrayOfByte2[j] = ((byte)(((byte)(arrayOfByte1[(i * 16 + j * 2)] - 65) << 4) + (byte)(arrayOfByte1[(i * 16 + j * 2 + 1)] - 97)));
        j += 1;
      }
      long l = s.a(arrayOfByte2);
      arrayOfByte2 = new byte[8];
      s.a(locals.a(l), arrayOfByte2);
      paramString = paramString + new String(arrayOfByte2);
      i += 1;
    }
    return paramString.trim();
  }
  
  public static String b(String paramString)
  {
    s locals = new s(123231312L);
    paramString = paramString.getBytes();
    int j = paramString.length;
    int k = j + (8 - j % 8) % 8;
    byte[] arrayOfByte1 = new byte[k];
    int i = 0;
    if (i < k)
    {
      if (i <= j - 1) {
        arrayOfByte1[i] = paramString[i];
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfByte1[i] = 32;
      }
    }
    paramString = "";
    i = 0;
    while (i < k / 8)
    {
      byte[] arrayOfByte2 = new byte[8];
      j = 0;
      while (j <= 7)
      {
        arrayOfByte2[j] = arrayOfByte1[(i * 8 + j)];
        j += 1;
      }
      long l = s.a(arrayOfByte2);
      arrayOfByte2 = new byte[8];
      s.a(locals.b(l), arrayOfByte2);
      byte[] arrayOfByte3 = new byte[16];
      j = 0;
      while (j < 8)
      {
        arrayOfByte3[(j * 2)] = ((byte)((((char)arrayOfByte2[j] & 0xF0) >> '\004') + 65));
        arrayOfByte3[(j * 2 + 1)] = ((byte)(((char)arrayOfByte2[j] & 0xF) + 'a'));
        j += 1;
      }
      paramString = paramString + new String(arrayOfByte3);
      i += 1;
    }
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */