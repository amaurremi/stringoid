package com.google.android.gms.dynamic;

import java.lang.reflect.Field;

public final class e<T>
  extends d.a
{
  private final T Sc;
  
  private e(T paramT)
  {
    this.Sc = paramT;
  }
  
  public static <T> T f(d paramd)
  {
    if ((paramd instanceof e)) {
      return (T)((e)paramd).Sc;
    }
    paramd = paramd.asBinder();
    Object localObject = paramd.getClass().getDeclaredFields();
    if (localObject.length == 1)
    {
      localObject = localObject[0];
      if (!((Field)localObject).isAccessible())
      {
        ((Field)localObject).setAccessible(true);
        try
        {
          paramd = ((Field)localObject).get(paramd);
          return paramd;
        }
        catch (NullPointerException paramd)
        {
          throw new IllegalArgumentException("Binder object is null.", paramd);
        }
        catch (IllegalArgumentException paramd)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", paramd);
        }
        catch (IllegalAccessException paramd)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramd);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
  
  public static <T> d k(T paramT)
  {
    return new e(paramT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/dynamic/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */