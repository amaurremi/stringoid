package com.vladium.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Strings
{
  private static final boolean USE_GET_CHARS = true;
  public static final String WHITE_SPACE = " \t\r\n";
  
  public static String HTMLEscape(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    HTMLEscape(paramString, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static void HTMLEscape(String paramString, StringBuffer paramStringBuffer)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null input: s");
    }
    if (paramStringBuffer == null) {
      throw new IllegalArgumentException("null input: append");
    }
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      char c = arrayOfChar[i];
      switch (c)
      {
      default: 
        paramStringBuffer.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuffer.append("&lt;");
        continue;
        paramStringBuffer.append("&gt;");
        continue;
        paramStringBuffer.append("&#34;");
        continue;
        paramStringBuffer.append("&amp;");
      }
    }
  }
  
  public static void HTMLEscapeNB(String paramString, StringBuffer paramStringBuffer)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null input: s");
    }
    if (paramStringBuffer == null) {
      throw new IllegalArgumentException("null input: append");
    }
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      char c = arrayOfChar[i];
      switch (c)
      {
      default: 
        paramStringBuffer.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuffer.append(' ');
        continue;
        paramStringBuffer.append("        ");
        continue;
        paramStringBuffer.append("&lt;");
        continue;
        paramStringBuffer.append("&gt;");
        continue;
        paramStringBuffer.append("&#34;");
        continue;
        paramStringBuffer.append("&amp;");
      }
    }
  }
  
  public static String HTMLEscapeSP(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    HTMLEscapeNB(paramString, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static String[] merge(String[] paramArrayOfString, String paramString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {}
    int j;
    do
    {
      return paramArrayOfString;
      j = paramArrayOfString.length;
    } while (j == 0);
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("null/empty input: delimiters");
    }
    HashSet localHashSet = new HashSet(j);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfString[i];
      if ((paramBoolean) && (localObject == null)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = new StringTokenizer((String)localObject, paramString);
        while (((StringTokenizer)localObject).hasMoreTokens())
        {
          String str = ((StringTokenizer)localObject).nextToken();
          if (localHashSet.add(str)) {
            localArrayList.add(str);
          }
        }
      }
    }
    paramArrayOfString = new String[localArrayList.size()];
    localArrayList.toArray(paramArrayOfString);
    return paramArrayOfString;
  }
  
  public static String[] mergeAT(String[] paramArrayOfString, String paramString, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean) {
      localObject1 = merge(paramArrayOfString, paramString, true);
    }
    int k;
    do
    {
      do
      {
        return (String[])localObject1;
        localObject1 = paramArrayOfString;
      } while (paramArrayOfString == null);
      k = paramArrayOfString.length;
      localObject1 = paramArrayOfString;
    } while (k == 0);
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("null/empty input: delimiters");
    }
    HashSet localHashSet = new HashSet(k);
    Object localObject1 = new ArrayList(k);
    int i = 0;
    if (i < k)
    {
      Object localObject2 = paramArrayOfString[i];
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = new StringTokenizer((String)localObject2, paramString);
        while (((StringTokenizer)localObject2).hasMoreTokens())
        {
          Object localObject3 = ((StringTokenizer)localObject2).nextToken();
          if (((String)localObject3).startsWith("@"))
          {
            localObject3 = Files.readFileList(new File(((String)localObject3).substring(1)));
            int j = 0;
            while (j < localObject3.length)
            {
              Object localObject4 = localObject3[j];
              if (localHashSet.add(localObject4)) {
                ((List)localObject1).add(localObject4);
              }
              j += 1;
            }
          }
          else if (localHashSet.add(localObject3))
          {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    paramArrayOfString = new String[((List)localObject1).size()];
    ((List)localObject1).toArray(paramArrayOfString);
    return paramArrayOfString;
  }
  
  public static String[] removeDuplicates(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {}
    int j;
    ArrayList localArrayList;
    int i;
    do
    {
      do
      {
        return paramArrayOfString;
        j = paramArrayOfString.length;
      } while (j == 0);
      HashSet localHashSet = new HashSet(j);
      localArrayList = new ArrayList(j);
      i = 0;
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if ((paramBoolean) && (str == null)) {}
        for (;;)
        {
          i += 1;
          break;
          if (localHashSet.add(str)) {
            localArrayList.add(str);
          }
        }
      }
      i = localArrayList.size();
    } while (i == j);
    paramArrayOfString = new String[i];
    localArrayList.toArray(paramArrayOfString);
    return paramArrayOfString;
  }
  
  public static String toListForm(String[] paramArrayOfString, char paramChar)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    if (paramArrayOfString.length == 0) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramArrayOfString.length;
    while (i < j)
    {
      if (i != 0) {
        localStringBuffer.append(paramChar);
      }
      localStringBuffer.append(paramArrayOfString[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */