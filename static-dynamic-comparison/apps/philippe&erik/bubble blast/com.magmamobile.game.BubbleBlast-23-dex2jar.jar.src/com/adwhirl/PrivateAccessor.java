package com.adwhirl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateAccessor
{
  public static Object invokePrivateMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    Method[] arrayOfMethod = paramObject.getClass().getDeclaredMethods();
    int i = 0;
    int j = arrayOfMethod.length;
    for (;;)
    {
      if (i >= j) {
        return null;
      }
      if (paramString.equals(arrayOfMethod[i].getName())) {}
      try
      {
        arrayOfMethod[i].setAccessible(true);
        Object localObject = arrayOfMethod[i].invoke(paramObject, paramArrayOfObject);
        return localObject;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        i += 1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/PrivateAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */