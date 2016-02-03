package com.amazonaws.org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.annotation.Immutable;

@Immutable
public class CloneUtils
{
  public static Object clone(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Cloneable))
    {
      Object localObject = paramObject.getClass();
      try
      {
        localObject = ((Class)localObject).getMethod("clone", (Class[])null);
        throw new CloneNotSupportedException();
      }
      catch (NoSuchMethodException paramObject)
      {
        try
        {
          paramObject = ((Method)localObject).invoke(paramObject, (Object[])null);
          return paramObject;
        }
        catch (InvocationTargetException paramObject)
        {
          paramObject = ((InvocationTargetException)paramObject).getCause();
          if (!(paramObject instanceof CloneNotSupportedException)) {
            break label72;
          }
          throw ((CloneNotSupportedException)paramObject);
          throw new Error("Unexpected exception", (Throwable)paramObject);
        }
        catch (IllegalAccessException paramObject)
        {
          throw new IllegalAccessError(((IllegalAccessException)paramObject).getMessage());
        }
        paramObject = paramObject;
        throw new NoSuchMethodError(((NoSuchMethodException)paramObject).getMessage());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/utils/CloneUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */