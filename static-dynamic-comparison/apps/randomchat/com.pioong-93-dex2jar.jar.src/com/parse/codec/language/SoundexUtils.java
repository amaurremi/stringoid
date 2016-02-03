package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;
import java.util.Locale;

final class SoundexUtils
{
  static String clean(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    int m = paramString.length();
    char[] arrayOfChar = new char[m];
    int j = 0;
    int i = 0;
    if (j >= m)
    {
      if (i == m) {
        return paramString.toUpperCase(Locale.ENGLISH);
      }
    }
    else
    {
      if (!Character.isLetter(paramString.charAt(j))) {
        break label100;
      }
      int k = i + 1;
      arrayOfChar[i] = paramString.charAt(j);
      i = k;
    }
    label100:
    for (;;)
    {
      j += 1;
      break;
      return new String(arrayOfChar, 0, i).toUpperCase(Locale.ENGLISH);
    }
  }
  
  static int difference(StringEncoder paramStringEncoder, String paramString1, String paramString2)
    throws EncoderException
  {
    return differenceEncoded(paramStringEncoder.encode(paramString1), paramStringEncoder.encode(paramString2));
  }
  
  static int differenceEncoded(String paramString1, String paramString2)
  {
    int k;
    if ((paramString1 == null) || (paramString2 == null))
    {
      k = 0;
      return k;
    }
    int m = Math.min(paramString1.length(), paramString2.length());
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramString1.charAt(j) == paramString2.charAt(j)) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/language/SoundexUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */