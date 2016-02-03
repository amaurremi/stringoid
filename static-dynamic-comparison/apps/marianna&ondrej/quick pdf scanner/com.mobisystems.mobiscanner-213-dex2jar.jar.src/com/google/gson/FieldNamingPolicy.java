package com.google.gson;

import java.lang.reflect.Field;

public enum FieldNamingPolicy
  implements c
{
  private FieldNamingPolicy() {}
  
  private static String a(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length()) {
      return paramChar + paramString.substring(paramInt);
    }
    return String.valueOf(paramChar);
  }
  
  private static String cI(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    char c = paramString.charAt(0);
    String str;
    if ((i >= paramString.length() - 1) || (Character.isLetter(c)))
    {
      if (i != paramString.length()) {
        break label70;
      }
      str = localStringBuilder.toString();
    }
    label70:
    do
    {
      return str;
      localStringBuilder.append(c);
      i += 1;
      c = paramString.charAt(i);
      break;
      str = paramString;
    } while (Character.isUpperCase(c));
    return a(Character.toUpperCase(c), paramString, i + 1);
  }
  
  private static String o(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString1.length())
    {
      char c = paramString1.charAt(i);
      if ((Character.isUpperCase(c)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/FieldNamingPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */