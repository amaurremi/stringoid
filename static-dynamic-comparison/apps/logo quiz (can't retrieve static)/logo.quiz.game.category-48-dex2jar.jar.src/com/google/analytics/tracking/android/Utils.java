package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils
{
  private static final char[] HEXBYTES = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String filterCampaign(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (paramString.contains("?")) {
      localObject = paramString.split("[\\?]")[1];
    }
    if (((String)localObject).contains("%3D")) {}
    StringBuilder localStringBuilder;
    while (((String)localObject).contains("=")) {
      try
      {
        paramString = URLDecoder.decode((String)localObject, "UTF-8");
        paramString = parseURLParameters(paramString);
        localObject = new String[9];
        localObject[0] = "dclid";
        localObject[1] = "utm_source";
        localObject[2] = "gclid";
        localObject[3] = "utm_campaign";
        localObject[4] = "utm_medium";
        localObject[5] = "utm_term";
        localObject[6] = "utm_content";
        localObject[7] = "utm_id";
        localObject[8] = "gmob_t";
        localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < localObject.length)
        {
          if (!TextUtils.isEmpty((CharSequence)paramString.get(localObject[i])))
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("&");
            }
            localStringBuilder.append(localObject[i]).append("=").append((String)paramString.get(localObject[i]));
          }
          i += 1;
        }
        paramString = (String)localObject;
      }
      catch (UnsupportedEncodingException paramString)
      {
        return null;
      }
    }
    return null;
    return localStringBuilder.toString();
  }
  
  static int fromHexDigit(char paramChar)
  {
    char c = paramChar - '0';
    paramChar = c;
    if (c > '\t') {
      paramChar = c - '\007';
    }
    return paramChar;
  }
  
  static String getLanguage(Locale paramLocale)
  {
    if (paramLocale == null) {}
    while (TextUtils.isEmpty(paramLocale.getLanguage())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
    if (!TextUtils.isEmpty(paramLocale.getCountry())) {
      localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
    }
    return localStringBuilder.toString();
  }
  
  static String getSlottedModelField(String paramString, int paramInt)
  {
    return paramString + "*" + paramInt;
  }
  
  static byte[] hexDecode(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(fromHexDigit(paramString.charAt(i * 2)) << 4 | fromHexDigit(paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    return arrayOfByte;
  }
  
  static String hexEncode(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = HEXBYTES[(j >> 4)];
      arrayOfChar[(i * 2 + 1)] = HEXBYTES[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static Map<String, String> parseURLParameters(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfString.length == 1) && (arrayOfString[0].length() != 0)) {
          localHashMap.put(arrayOfString[0], null);
        }
      }
    }
    return localHashMap;
  }
  
  public static boolean safeParseBoolean(String paramString)
  {
    return Boolean.parseBoolean(paramString);
  }
  
  public static double safeParseDouble(String paramString)
  {
    if (paramString == null) {
      return 0.0D;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return 0.0D;
  }
  
  public static long safeParseLong(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */