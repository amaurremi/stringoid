package com.flurry.org.codehaus.jackson.map.util;

import java.lang.reflect.Array;

public class Comparators
{
  public static Object getArrayComparator(Object paramObject)
  {
    new Object()
    {
      public boolean equals(Object paramAnonymousObject)
      {
        if (paramAnonymousObject == this) {
          return true;
        }
        if ((paramAnonymousObject == null) || (paramAnonymousObject.getClass() != this.val$defaultValue.getClass())) {
          return false;
        }
        if (Array.getLength(paramAnonymousObject) != this.val$length) {
          return false;
        }
        int i = 0;
        label42:
        Object localObject1;
        Object localObject2;
        if (i < this.val$length)
        {
          localObject1 = Array.get(this.val$defaultValue, i);
          localObject2 = Array.get(paramAnonymousObject, i);
          if (localObject1 != localObject2) {
            break label79;
          }
        }
        label79:
        while ((localObject1 == null) || (localObject1.equals(localObject2)))
        {
          i += 1;
          break label42;
          break;
        }
        return false;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/util/Comparators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */