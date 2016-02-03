package com.jtpgodorncrqoeurl;

import android.os.Bundle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AdUtils
{
  public static String byteToHex(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static String convert(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      for (;;)
      {
        if (i < paramString.length)
        {
          if ((paramString[i] & 0x80) > 0) {
            localStringBuffer.append("%" + byteToHex(paramString[i]));
          } else {
            localStringBuffer.append((char)paramString[i]);
          }
        }
        else
        {
          paramString = new String(localStringBuffer.toString().getBytes(), "ISO-8859-1");
          return paramString;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          AdLog.printStackTrace("LBAdController", paramInputStream);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      AdLog.printStackTrace("LBAdController", localIOException);
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            AdLog.printStackTrace("LBAdController", paramInputStream);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          AdLog.printStackTrace("LBAdController", paramInputStream);
        }
      }
    }
    finally {}
  }
  
  public static String getData(String paramString, Bundle paramBundle)
  {
    return paramBundle.getString(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */