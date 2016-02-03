package com.google.tagmanager.protobuf.nano;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public final class MessageNanoPrinter
{
  private static final String INDENT = "  ";
  private static final int MAX_STRING_LEN = 200;
  
  private static String deCamelCaseify(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0) {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isUpperCase(c)) {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        } else {
          localStringBuffer.append(c);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private static String escapeString(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static <T extends MessageNano> String print(T paramT)
  {
    if (paramT == null) {
      return "null";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      print(paramT.getClass().getSimpleName(), paramT.getClass(), paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException paramT) {}
    return "Error printing proto: " + paramT.getMessage();
  }
  
  private static void print(String paramString, Class<?> paramClass, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException
  {
    if (MessageNano.class.isAssignableFrom(paramClass)) {
      if (paramObject != null) {}
    }
    while (paramObject == null)
    {
      return;
      paramStringBuffer2.append(paramStringBuffer1).append(paramString);
      paramStringBuffer1.append("  ");
      paramStringBuffer2.append(" <\n");
      paramString = paramClass.getFields();
      int m = paramString.length;
      int i = 0;
      if (i < m)
      {
        Object localObject = paramString[i];
        int j = ((Field)localObject).getModifiers();
        paramClass = ((Field)localObject).getName();
        if (((j & 0x1) != 1) || ((j & 0x8) == 8) || (paramClass.startsWith("_")) || (paramClass.endsWith("_"))) {}
        for (;;)
        {
          i += 1;
          break;
          Class localClass1 = ((Field)localObject).getType();
          localObject = ((Field)localObject).get(paramObject);
          if (localClass1.isArray())
          {
            Class localClass2 = localClass1.getComponentType();
            if (localClass2 == Byte.TYPE)
            {
              print(paramClass, localClass1, localObject, paramStringBuffer1, paramStringBuffer2);
            }
            else
            {
              if (localObject == null) {}
              for (j = 0;; j = Array.getLength(localObject))
              {
                int k = 0;
                while (k < j)
                {
                  print(paramClass, localClass2, Array.get(localObject, k), paramStringBuffer1, paramStringBuffer2);
                  k += 1;
                }
                break;
              }
            }
          }
          else
          {
            print(paramClass, localClass1, localObject, paramStringBuffer1, paramStringBuffer2);
          }
        }
      }
      paramStringBuffer1.delete(paramStringBuffer1.length() - "  ".length(), paramStringBuffer1.length());
      paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      return;
    }
    paramString = deCamelCaseify(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
    if ((paramObject instanceof String))
    {
      paramString = sanitizeString((String)paramObject);
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    for (;;)
    {
      paramStringBuffer2.append("\n");
      return;
      paramStringBuffer2.append(paramObject);
    }
  }
  
  private static String sanitizeString(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.length() > 200) {
        str = paramString.substring(0, 200) + "[...]";
      }
    }
    return escapeString(str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/protobuf/nano/MessageNanoPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */