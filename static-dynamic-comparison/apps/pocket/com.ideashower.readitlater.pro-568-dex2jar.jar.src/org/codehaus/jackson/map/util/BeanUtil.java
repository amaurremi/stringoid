package org.codehaus.jackson.map.util;

import org.codehaus.jackson.map.introspect.AnnotatedMethod;

public class BeanUtil
{
  protected static boolean isCglibGetCallbacks(AnnotatedMethod paramAnnotatedMethod)
  {
    paramAnnotatedMethod = paramAnnotatedMethod.getRawType();
    if ((paramAnnotatedMethod == null) || (!paramAnnotatedMethod.isArray())) {}
    do
    {
      do
      {
        return false;
        paramAnnotatedMethod = paramAnnotatedMethod.getComponentType().getPackage();
      } while (paramAnnotatedMethod == null);
      paramAnnotatedMethod = paramAnnotatedMethod.getName();
    } while ((!paramAnnotatedMethod.startsWith("net.sf.cglib")) && (!paramAnnotatedMethod.startsWith("org.hibernate.repackage.cglib")));
    return true;
  }
  
  protected static boolean isGroovyMetaClassGetter(AnnotatedMethod paramAnnotatedMethod)
  {
    paramAnnotatedMethod = paramAnnotatedMethod.getRawType();
    if ((paramAnnotatedMethod == null) || (paramAnnotatedMethod.isArray())) {}
    do
    {
      return false;
      paramAnnotatedMethod = paramAnnotatedMethod.getPackage();
    } while ((paramAnnotatedMethod == null) || (!paramAnnotatedMethod.getName().startsWith("groovy.lang")));
    return true;
  }
  
  protected static boolean isGroovyMetaClassSetter(AnnotatedMethod paramAnnotatedMethod)
  {
    boolean bool2 = false;
    paramAnnotatedMethod = paramAnnotatedMethod.getParameterClass(0).getPackage();
    boolean bool1 = bool2;
    if (paramAnnotatedMethod != null)
    {
      bool1 = bool2;
      if (paramAnnotatedMethod.getName().startsWith("groovy.lang")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected static String manglePropertyName(String paramString)
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
  
  public static String okNameForGetter(AnnotatedMethod paramAnnotatedMethod)
  {
    String str3 = paramAnnotatedMethod.getName();
    String str2 = okNameForIsGetter(paramAnnotatedMethod, str3);
    String str1 = str2;
    if (str2 == null) {
      str1 = okNameForRegularGetter(paramAnnotatedMethod, str3);
    }
    return str1;
  }
  
  public static String okNameForIsGetter(AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    if (paramString.startsWith("is"))
    {
      paramAnnotatedMethod = paramAnnotatedMethod.getRawType();
      if ((paramAnnotatedMethod == Boolean.class) || (paramAnnotatedMethod == Boolean.TYPE)) {}
    }
    else
    {
      return null;
    }
    return manglePropertyName(paramString.substring(2));
  }
  
  public static String okNameForRegularGetter(AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    if (paramString.startsWith("get"))
    {
      if (!"getCallbacks".equals(paramString)) {
        break label27;
      }
      if (!isCglibGetCallbacks(paramAnnotatedMethod)) {
        break label43;
      }
    }
    label27:
    while (("getMetaClass".equals(paramString)) && (isGroovyMetaClassGetter(paramAnnotatedMethod))) {
      return null;
    }
    label43:
    return manglePropertyName(paramString.substring(3));
  }
  
  public static String okNameForSetter(AnnotatedMethod paramAnnotatedMethod)
  {
    String str = paramAnnotatedMethod.getName();
    if (str.startsWith("set"))
    {
      str = manglePropertyName(str.substring(3));
      if (str != null) {
        break label29;
      }
    }
    label29:
    while (("metaClass".equals(str)) && (isGroovyMetaClassSetter(paramAnnotatedMethod))) {
      return null;
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/BeanUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */