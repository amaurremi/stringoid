package com.google.android.gms.dynamic;

import java.lang.reflect.Field;

public final class d<T>
  extends c.a
{
  private final T uZ;
  
  private d(T paramT)
  {
    this.uZ = paramT;
  }
  
  public static <T> c J(T paramT)
  {
    return new d(paramT);
  }
  
  public static <T> T a(c paramc)
  {
    if ((paramc instanceof d)) {
      return (T)((d)paramc).uZ;
    }
    paramc = paramc.asBinder();
    Object localObject = paramc.getClass().getDeclaredFields();
    if (localObject.length == 1)
    {
      localObject = localObject[0];
      if (!((Field)localObject).isAccessible())
      {
        ((Field)localObject).setAccessible(true);
        try
        {
          paramc = ((Field)localObject).get(paramc);
          return paramc;
        }
        catch (NullPointerException paramc)
        {
          throw new IllegalArgumentException("Binder object is null.", paramc);
        }
        catch (IllegalArgumentException paramc)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", paramc);
        }
        catch (IllegalAccessException paramc)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramc);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/dynamic/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */