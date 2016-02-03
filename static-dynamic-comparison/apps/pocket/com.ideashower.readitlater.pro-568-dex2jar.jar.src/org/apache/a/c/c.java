package org.apache.a.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  public static final String a = String.valueOf('.');
  public static final String b = String.valueOf('$');
  private static final Map c = new HashMap();
  private static final Map d;
  private static final Map e;
  private static final Map f;
  
  static
  {
    c.put(Boolean.TYPE, Boolean.class);
    c.put(Byte.TYPE, Byte.class);
    c.put(Character.TYPE, Character.class);
    c.put(Short.TYPE, Short.class);
    c.put(Integer.TYPE, Integer.class);
    c.put(Long.TYPE, Long.class);
    c.put(Double.TYPE, Double.class);
    c.put(Float.TYPE, Float.class);
    c.put(Void.TYPE, Void.TYPE);
    d = new HashMap();
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass1 = (Class)localIterator.next();
      Class localClass2 = (Class)c.get(localClass1);
      if (!localClass1.equals(localClass2)) {
        d.put(localClass2, localClass1);
      }
    }
    e = new HashMap();
    f = new HashMap();
    a("int", "I");
    a("boolean", "Z");
    a("float", "F");
    a("long", "J");
    a("short", "S");
    a("byte", "B");
    a("double", "D");
    a("char", "C");
  }
  
  public static String a(Class paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return a(paramClass.getName());
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString.startsWith("["))
    {
      while (paramString.charAt(0) == '[')
      {
        paramString = paramString.substring(1);
        localStringBuilder.append("[]");
      }
      str = paramString;
      if (paramString.charAt(0) == 'L')
      {
        str = paramString;
        if (paramString.charAt(paramString.length() - 1) == ';') {
          str = paramString.substring(1, paramString.length() - 1);
        }
      }
    }
    if (f.containsKey(str)) {}
    for (paramString = (String)f.get(str);; paramString = str)
    {
      int j = paramString.lastIndexOf('.');
      if (j == -1) {}
      for (;;)
      {
        i = paramString.indexOf('$', i);
        str = paramString.substring(j + 1);
        paramString = str;
        if (i != -1) {
          paramString = str.replace('$', '.');
        }
        return paramString + localStringBuilder;
        i = j + 1;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    e.put(paramString1, paramString2);
    f.put(paramString2, paramString1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */