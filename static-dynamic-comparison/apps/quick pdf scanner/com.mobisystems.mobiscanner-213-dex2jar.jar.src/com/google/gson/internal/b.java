package com.google.gson.internal;

import com.google.gson.b.a;
import com.google.gson.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class b
{
  private final Map<Type, e<?>> aeV;
  
  public b()
  {
    this(Collections.emptyMap());
  }
  
  public b(Map<Type, e<?>> paramMap)
  {
    this.aeV = paramMap;
  }
  
  private <T> f<T> d(final Type paramType, final Class<? super T> paramClass)
  {
    new f()
    {
      private final i afa = i.zL();
      
      public T zI()
      {
        try
        {
          Object localObject = this.afa.l(paramClass);
          return (T)localObject;
        }
        catch (Exception localException)
        {
          throw new RuntimeException("Unable to invoke no-args constructor for " + paramType + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
        }
      }
    };
  }
  
  private <T> f<T> o(final Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        paramClass.setAccessible(true);
      }
      paramClass = new f()
      {
        public T zI()
        {
          try
          {
            Object localObject = paramClass.newInstance(null);
            return (T)localObject;
          }
          catch (InstantiationException localInstantiationException)
          {
            throw new RuntimeException("Failed to invoke " + paramClass + " with no args", localInstantiationException);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            throw new RuntimeException("Failed to invoke " + paramClass + " with no args", localInvocationTargetException.getTargetException());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new AssertionError(localIllegalAccessException);
          }
        }
      };
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  private <T> f<T> p(Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        new f()
        {
          public T zI()
          {
            return new TreeSet();
          }
        };
      }
      if (Set.class.isAssignableFrom(paramClass)) {
        new f()
        {
          public T zI()
          {
            return new LinkedHashSet();
          }
        };
      }
      if (Queue.class.isAssignableFrom(paramClass)) {
        new f()
        {
          public T zI()
          {
            return new LinkedList();
          }
        };
      }
      new f()
      {
        public T zI()
        {
          return new ArrayList();
        }
      };
    }
    if (Map.class.isAssignableFrom(paramClass)) {
      new f()
      {
        public T zI()
        {
          return new LinkedHashMap();
        }
      };
    }
    return null;
  }
  
  public <T> f<T> b(final a<T> parama)
  {
    final Type localType = parama.Aa();
    Class localClass = parama.zZ();
    parama = (e)this.aeV.get(localType);
    if (parama != null) {
      parama = new f()
      {
        public T zI()
        {
          return (T)parama.g(localType);
        }
      };
    }
    f localf;
    do
    {
      do
      {
        return parama;
        localf = o(localClass);
        parama = localf;
      } while (localf != null);
      localf = p(localClass);
      parama = localf;
    } while (localf != null);
    return d(localType, localClass);
  }
  
  public String toString()
  {
    return this.aeV.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */