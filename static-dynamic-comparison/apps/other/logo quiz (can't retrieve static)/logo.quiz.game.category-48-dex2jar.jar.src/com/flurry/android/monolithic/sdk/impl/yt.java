package com.flurry.android.monolithic.sdk.impl;

import java.util.EnumMap;
import java.util.EnumSet;

public class yt
  extends yz
{
  public yt(afm paramafm, adk paramadk)
  {
    super(paramafm, paramadk);
  }
  
  public afm a(String paramString)
  {
    if (paramString.indexOf('<') > 0) {
      return adk.a(paramString);
    }
    try
    {
      Object localObject = Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
      localObject = this.c.a(this.d, (Class)localObject);
      return (afm)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): no such class found");
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): " + localException.getMessage(), localException);
    }
  }
  
  public String a(Object paramObject)
  {
    return b(paramObject, paramObject.getClass());
  }
  
  public String a(Object paramObject, Class<?> paramClass)
  {
    return b(paramObject, paramClass);
  }
  
  protected final String b(Object paramObject, Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (Enum.class.isAssignableFrom(paramClass))
    {
      localObject = paramClass;
      if (!paramClass.isEnum()) {
        localObject = paramClass.getSuperclass();
      }
    }
    paramClass = ((Class)localObject).getName();
    if (paramClass.startsWith("java.util")) {
      if ((paramObject instanceof EnumSet))
      {
        paramObject = adz.a((EnumSet)paramObject);
        paramObject = adk.a().b(EnumSet.class, (Class)paramObject).m();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (String)paramObject;
              if ((paramObject instanceof EnumMap))
              {
                paramObject = adz.a((EnumMap)paramObject);
                return adk.a().a(EnumMap.class, (Class)paramObject, Object.class).m();
              }
              localObject = paramClass.substring(9);
              if (((String)localObject).startsWith(".Arrays$")) {
                break;
              }
              paramObject = paramClass;
            } while (!((String)localObject).startsWith(".Collections$"));
            paramObject = paramClass;
          } while (paramClass.indexOf("List") < 0);
          return "java.util.ArrayList";
          paramObject = paramClass;
        } while (paramClass.indexOf('$') < 0);
        paramObject = paramClass;
      } while (adz.b((Class)localObject) == null);
      paramObject = paramClass;
    } while (adz.b(this.d.p()) != null);
    return this.d.p().getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */