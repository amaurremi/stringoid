package com.vungle.publisher;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;
import javax.inject.Provider;

public final class cw
{
  private static final String a = Provider.class.getCanonicalName() + "<";
  private static final String b = cp.class.getCanonicalName() + "<";
  private static final String c = co.class.getCanonicalName() + "<";
  private static final String d = Set.class.getCanonicalName() + "<";
  private static final da<Class<? extends Annotation>, Boolean> e = new da() {};
  
  public static String a(Class<?> paramClass)
  {
    return "members/".concat(paramClass.getName());
  }
  
  static String a(String paramString)
  {
    int i = f(paramString);
    if (a(paramString, i, a)) {
      return a(paramString, i, paramString.substring(0, i), a);
    }
    if (a(paramString, i, b)) {
      return a(paramString, i, "members/", b);
    }
    return null;
  }
  
  private static String a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return paramString2 + paramString1.substring(paramString3.length() + paramInt, paramString1.length() - 1);
  }
  
  public static String a(Type paramType)
  {
    return a(paramType, null);
  }
  
  private static String a(Type paramType, Annotation paramAnnotation)
  {
    if (paramType == Byte.TYPE) {
      paramType = Byte.class;
    }
    while ((paramAnnotation == null) && ((paramType instanceof Class)) && (!((Class)paramType).isArray()))
    {
      return ((Class)paramType).getName();
      if (paramType == Short.TYPE) {
        paramType = Short.class;
      } else if (paramType == Integer.TYPE) {
        paramType = Integer.class;
      } else if (paramType == Long.TYPE) {
        paramType = Long.class;
      } else if (paramType == Character.TYPE) {
        paramType = Character.class;
      } else if (paramType == Boolean.TYPE) {
        paramType = Boolean.class;
      } else if (paramType == Float.TYPE) {
        paramType = Float.class;
      } else if (paramType == Double.TYPE) {
        paramType = Double.class;
      } else if (paramType == Void.TYPE) {
        paramType = Void.class;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramAnnotation != null) {
      localStringBuilder.append(paramAnnotation).append("/");
    }
    a(paramType, localStringBuilder, true);
    return localStringBuilder.toString();
  }
  
  public static String a(Type paramType, Annotation[] paramArrayOfAnnotation, Object paramObject)
  {
    Object localObject = null;
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    if (i < j)
    {
      Annotation localAnnotation = paramArrayOfAnnotation[i];
      if (!((Boolean)e.b(localAnnotation.annotationType())).booleanValue()) {
        break label89;
      }
      if (localObject != null) {
        throw new IllegalArgumentException("Too many qualifier annotations on " + paramObject);
      }
      localObject = localAnnotation;
    }
    label89:
    for (;;)
    {
      i += 1;
      break;
      return a(paramType, (Annotation)localObject);
    }
  }
  
  private static void a(Type paramType, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    int i = 0;
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray())
      {
        a(paramType.getComponentType(), paramStringBuilder, false);
        paramStringBuilder.append("[]");
        return;
      }
      if (paramType.isPrimitive())
      {
        if (paramBoolean) {
          throw new UnsupportedOperationException("Uninjectable type " + paramType.getName());
        }
        paramStringBuilder.append(paramType.getName());
        return;
      }
      paramStringBuilder.append(paramType.getName());
      return;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      a(paramType.getRawType(), paramStringBuilder, true);
      paramType = paramType.getActualTypeArguments();
      paramStringBuilder.append("<");
      while (i < paramType.length)
      {
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        a(paramType[i], paramStringBuilder, true);
        i += 1;
      }
      paramStringBuilder.append(">");
      return;
    }
    if ((paramType instanceof GenericArrayType))
    {
      a(((GenericArrayType)paramType).getGenericComponentType(), paramStringBuilder, false);
      paramStringBuilder.append("[]");
      return;
    }
    throw new UnsupportedOperationException("Uninjectable type " + paramType);
  }
  
  private static boolean a(String paramString1, int paramInt, String paramString2)
  {
    return paramString1.regionMatches(paramInt, paramString2, 0, paramString2.length());
  }
  
  static String b(String paramString)
  {
    int i = f(paramString);
    if (a(paramString, i, c)) {
      return a(paramString, i, paramString.substring(0, i), c);
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    return paramString.startsWith("@");
  }
  
  public static String d(String paramString)
  {
    int i = 0;
    if ((paramString.startsWith("@")) || (paramString.startsWith("members/"))) {
      i = paramString.lastIndexOf('/') + 1;
    }
    if ((paramString.indexOf('<', i) == -1) && (paramString.indexOf('[', i) == -1)) {
      return paramString.substring(i);
    }
    return null;
  }
  
  public static boolean e(String paramString)
  {
    return (paramString.startsWith("java.")) || (paramString.startsWith("javax.")) || (paramString.startsWith("android."));
  }
  
  private static int f(String paramString)
  {
    if (paramString.startsWith("@")) {
      return paramString.lastIndexOf('/') + 1;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */