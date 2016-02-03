package com.flurry.android.monolithic.sdk.impl;

public class ady
{
  public static String a(xl paramxl)
  {
    String str3 = paramxl.b();
    String str2 = b(paramxl, str3);
    String str1 = str2;
    if (str2 == null) {
      str1 = a(paramxl, str3);
    }
    return str1;
  }
  
  public static String a(xl paramxl, String paramString)
  {
    if (paramString.startsWith("get"))
    {
      if (!"getCallbacks".equals(paramString)) {
        break label27;
      }
      if (!c(paramxl)) {
        break label43;
      }
    }
    label27:
    while (("getMetaClass".equals(paramString)) && (e(paramxl))) {
      return null;
    }
    label43:
    return a(paramString.substring(3));
  }
  
  protected static String a(String paramString)
  {
    Object localObject1 = null;
    int j = paramString.length();
    if (j == 0)
    {
      paramString = null;
      return paramString;
    }
    int i = 0;
    for (;;)
    {
      char c2;
      if (i < j)
      {
        char c1 = paramString.charAt(i);
        c2 = Character.toLowerCase(c1);
        if (c1 != c2) {}
      }
      else
      {
        if (localObject1 == null) {
          break;
        }
        return ((StringBuilder)localObject1).toString();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(paramString);
      }
      ((StringBuilder)localObject2).setCharAt(i, c2);
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  public static String b(xl paramxl)
  {
    String str = paramxl.b();
    if (str.startsWith("set"))
    {
      str = a(str.substring(3));
      if (str != null) {
        break label29;
      }
    }
    label29:
    while (("metaClass".equals(str)) && (d(paramxl))) {
      return null;
    }
    return str;
  }
  
  public static String b(xl paramxl, String paramString)
  {
    if (paramString.startsWith("is"))
    {
      paramxl = paramxl.d();
      if ((paramxl == Boolean.class) || (paramxl == Boolean.TYPE)) {}
    }
    else
    {
      return null;
    }
    return a(paramString.substring(2));
  }
  
  protected static boolean c(xl paramxl)
  {
    paramxl = paramxl.d();
    if ((paramxl == null) || (!paramxl.isArray())) {}
    do
    {
      do
      {
        return false;
        paramxl = paramxl.getComponentType().getPackage();
      } while (paramxl == null);
      paramxl = paramxl.getName();
    } while ((!paramxl.startsWith("net.sf.cglib")) && (!paramxl.startsWith("org.hibernate.repackage.cglib")));
    return true;
  }
  
  protected static boolean d(xl paramxl)
  {
    boolean bool2 = false;
    paramxl = paramxl.a(0).getPackage();
    boolean bool1 = bool2;
    if (paramxl != null)
    {
      bool1 = bool2;
      if (paramxl.getName().startsWith("groovy.lang")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected static boolean e(xl paramxl)
  {
    paramxl = paramxl.d();
    if ((paramxl == null) || (paramxl.isArray())) {}
    do
    {
      return false;
      paramxl = paramxl.getPackage();
    } while ((paramxl == null) || (!paramxl.getName().startsWith("groovy.lang")));
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */