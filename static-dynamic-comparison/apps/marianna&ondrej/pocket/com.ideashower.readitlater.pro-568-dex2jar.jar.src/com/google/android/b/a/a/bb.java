package com.google.android.b.a.a;

import java.lang.reflect.Field;

public final class bb
  extends az
{
  private final Object a;
  
  private bb(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public static ay a(Object paramObject)
  {
    return new bb(paramObject);
  }
  
  public static Object a(ay paramay)
  {
    if ((paramay instanceof bb)) {
      return ((bb)paramay).a;
    }
    paramay = paramay.asBinder();
    Object localObject = paramay.getClass().getDeclaredFields();
    if (localObject.length == 1)
    {
      localObject = localObject[0];
      if (!((Field)localObject).isAccessible())
      {
        ((Field)localObject).setAccessible(true);
        try
        {
          paramay = ((Field)localObject).get(paramay);
          return paramay;
        }
        catch (NullPointerException paramay)
        {
          throw new IllegalArgumentException("Binder object is null.", paramay);
        }
        catch (IllegalArgumentException paramay)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", paramay);
        }
        catch (IllegalAccessException paramay)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramay);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */