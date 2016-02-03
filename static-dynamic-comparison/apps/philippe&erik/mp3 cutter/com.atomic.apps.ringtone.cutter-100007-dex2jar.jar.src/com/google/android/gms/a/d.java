package com.google.android.gms.a;

import java.lang.reflect.Field;

public final class d
  extends b
{
  private final Object a;
  
  private d(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public static a a(Object paramObject)
  {
    return new d(paramObject);
  }
  
  public static Object a(a parama)
  {
    if ((parama instanceof d)) {
      return ((d)parama).a;
    }
    parama = parama.asBinder();
    Object localObject = parama.getClass().getDeclaredFields();
    if (localObject.length == 1)
    {
      localObject = localObject[0];
      if (!((Field)localObject).isAccessible())
      {
        ((Field)localObject).setAccessible(true);
        try
        {
          parama = ((Field)localObject).get(parama);
          return parama;
        }
        catch (NullPointerException parama)
        {
          throw new IllegalArgumentException("Binder object is null.", parama);
        }
        catch (IllegalArgumentException parama)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", parama);
        }
        catch (IllegalAccessException parama)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", parama);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */