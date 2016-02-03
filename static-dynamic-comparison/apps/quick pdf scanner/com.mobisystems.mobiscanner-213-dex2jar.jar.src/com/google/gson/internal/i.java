package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class i
{
  public static i zL()
  {
    try
    {
      Object localObject1 = Class.forName("sun.misc.Unsafe");
      final Object localObject4 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject4).setAccessible(true);
      localObject4 = ((Field)localObject4).get(null);
      localObject1 = new i()
      {
        public <T> T l(Class<T> paramAnonymousClass)
        {
          return (T)this.afv.invoke(localObject4, new Object[] { paramAnonymousClass });
        }
      };
      return (i)localObject1;
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject2 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
        ((Method)localObject2).setAccessible(true);
        localObject2 = new i()
        {
          public <T> T l(Class<T> paramAnonymousClass)
          {
            return (T)this.afx.invoke(null, new Object[] { paramAnonymousClass, Object.class });
          }
        };
        return (i)localObject2;
      }
      catch (Exception localException2)
      {
        try
        {
          Object localObject3 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
          ((Method)localObject3).setAccessible(true);
          final int i = ((Integer)((Method)localObject3).invoke(null, new Object[] { Object.class })).intValue();
          localObject3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
          ((Method)localObject3).setAccessible(true);
          localObject3 = new i()
          {
            public <T> T l(Class<T> paramAnonymousClass)
            {
              return (T)this.afx.invoke(null, new Object[] { paramAnonymousClass, Integer.valueOf(i) });
            }
          };
          return (i)localObject3;
        }
        catch (Exception localException3) {}
      }
    }
    new i()
    {
      public <T> T l(Class<T> paramAnonymousClass)
      {
        throw new UnsupportedOperationException("Cannot allocate " + paramAnonymousClass);
      }
    };
  }
  
  public abstract <T> T l(Class<T> paramClass);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */