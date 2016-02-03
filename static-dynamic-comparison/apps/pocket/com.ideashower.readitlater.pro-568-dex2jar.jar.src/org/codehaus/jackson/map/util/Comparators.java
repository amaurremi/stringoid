package org.codehaus.jackson.map.util;

import java.lang.reflect.Array;

public class Comparators
{
  public static Object getArrayComparator(Object paramObject)
  {
    new Object()
    {
      public boolean equals(Object paramAnonymousObject)
      {
        boolean bool2 = false;
        boolean bool1;
        if (paramAnonymousObject == this) {
          bool1 = true;
        }
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramAnonymousObject == null);
            bool1 = bool2;
          } while (paramAnonymousObject.getClass() != Comparators.this.getClass());
          bool1 = bool2;
        } while (Array.getLength(paramAnonymousObject) != this.val$length);
        int i = 0;
        if (i < this.val$length)
        {
          Object localObject1 = Array.get(Comparators.this, i);
          Object localObject2 = Array.get(paramAnonymousObject, i);
          if (localObject1 == localObject2) {}
          while ((localObject1 == null) || (localObject1.equals(localObject2)))
          {
            i += 1;
            break;
          }
          return false;
        }
        return true;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/Comparators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */