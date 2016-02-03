package com.google.android.gms.dynamic;

import java.lang.reflect.Field;

public final class c<T>
  extends b.a
{
  private final T sE;
  
  private c(T paramT)
  {
    this.sE = paramT;
  }
  
  public static <T> T b(b paramb)
  {
    if ((paramb instanceof c)) {
      return (T)((c)paramb).sE;
    }
    paramb = paramb.asBinder();
    Object localObject = paramb.getClass().getDeclaredFields();
    if (localObject.length == 1)
    {
      localObject = localObject[0];
      if (!((Field)localObject).isAccessible())
      {
        ((Field)localObject).setAccessible(true);
        try
        {
          paramb = ((Field)localObject).get(paramb);
          return paramb;
        }
        catch (NullPointerException paramb)
        {
          throw new IllegalArgumentException("Binder object is null.", paramb);
        }
        catch (IllegalArgumentException paramb)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", paramb);
        }
        catch (IllegalAccessException paramb)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramb);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
  
  public static <T> b h(T paramT)
  {
    return new c(paramT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/dynamic/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */