package com.vladium.util;

public abstract class Descriptors
{
  public static final char JAVA_NAME_SEPARATOR = '.';
  private static final boolean RENAME_INNER_CLASSES = false;
  public static final char VM_NAME_SEPARATOR = '/';
  
  public static String combine(String paramString1, String paramString2, char paramChar)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new IllegalArgumentException("null or empty input: name");
    }
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return paramString2;
    }
    return paramString1 + paramChar + paramString2;
  }
  
  public static String combineJavaName(String paramString1, String paramString2)
  {
    return combine(paramString1, paramString2, '.');
  }
  
  public static String combineVMName(String paramString1, String paramString2)
  {
    return combine(paramString1, paramString2, '/');
  }
  
  public static String javaNameToVMName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace('.', '/');
  }
  
  public static String methodVMNameToJavaName(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean1)
    {
      if ("<clinit>".equals(paramString2)) {
        return "<static initializer>";
      }
      if ("<init>".equals(paramString2)) {
        localStringBuffer.append(paramString1);
      }
    }
    int j;
    for (;;)
    {
      paramString1 = paramString3.toCharArray();
      localStringBuffer.append(" (");
      int i = paramString1.length;
      do
      {
        j = i - 1;
        i = j;
      } while (paramString1[j] != ')');
      for (i = 1; i < j; i = typeDescriptorToJavaName(paramString1, i, paramBoolean2, localStringBuffer)) {
        if (i > 1) {
          localStringBuffer.append(", ");
        }
      }
      localStringBuffer.append(paramString2);
      continue;
      if ("<clinit>".equals(paramString2)) {
        return "<clinit>";
      }
      localStringBuffer.append(paramString2);
    }
    if (paramBoolean3)
    {
      localStringBuffer.append("): ");
      typeDescriptorToJavaName(paramString1, j + 1, paramBoolean2, localStringBuffer);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(')');
    }
  }
  
  private static int typeDescriptorToJavaName(char[] paramArrayOfChar, int paramInt, boolean paramBoolean, StringBuffer paramStringBuffer)
  {
    int j = 0;
    int i = paramInt;
    while (paramArrayOfChar[i] == '[')
    {
      j += 1;
      i += 1;
    }
    paramInt = i + 1;
    char c = paramArrayOfChar[i];
    switch (c)
    {
    default: 
      throw new IllegalStateException("unknown type descriptor element: " + c);
    case 'L': 
      if (paramBoolean)
      {
        int k = -1;
        i = paramInt;
        while (paramArrayOfChar[i] != ';')
        {
          if (paramArrayOfChar[i] == '/') {
            k = i;
          }
          i += 1;
        }
        if (k > 0) {
          paramInt = k + 1;
        }
        for (;;)
        {
          i = paramInt;
          if (paramArrayOfChar[paramInt] == ';') {
            break;
          }
          paramStringBuffer.append(paramArrayOfChar[paramInt]);
          paramInt += 1;
        }
      }
      break;
    }
    for (;;)
    {
      i = paramInt;
      if (paramArrayOfChar[paramInt] != ';')
      {
        c = paramArrayOfChar[paramInt];
        if (c != '/') {}
        for (;;)
        {
          paramStringBuffer.append(c);
          paramInt += 1;
          break;
          c = '.';
        }
      }
      paramInt = i + 1;
      while (j > 0)
      {
        paramStringBuffer.append(' ');
        i = 0;
        while (i < j)
        {
          paramStringBuffer.append("[]");
          i += 1;
        }
        paramStringBuffer.append("byte");
        continue;
        paramStringBuffer.append("char");
        continue;
        paramStringBuffer.append("double");
        continue;
        paramStringBuffer.append("float");
        continue;
        paramStringBuffer.append("int");
        continue;
        paramStringBuffer.append("long");
        continue;
        paramStringBuffer.append("short");
        continue;
        paramStringBuffer.append("boolean");
        continue;
        paramStringBuffer.append("void");
      }
      return paramInt;
    }
  }
  
  public static String vmNameToJavaName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace('/', '.');
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/Descriptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */