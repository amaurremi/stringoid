package org.apache.commons.logging.impl;

import java.util.Map.Entry;

final class WeakHashtable$Entry
  implements Map.Entry
{
  private final Object key;
  private final Object value;
  
  private WeakHashtable$Entry(Object paramObject1, Object paramObject2)
  {
    this.key = paramObject1;
    this.value = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        if (getKey() != null) {
          break label62;
        }
        bool1 = bool2;
        if (((Map.Entry)paramObject).getKey() == null)
        {
          if (getValue() != null) {
            break label83;
          }
          bool1 = bool2;
          if (((Map.Entry)paramObject).getValue() != null) {}
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      label62:
      label83:
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!getKey().equals(((Map.Entry)paramObject).getKey()));
        break;
        bool1 = bool2;
      } while (!getValue().equals(((Map.Entry)paramObject).getValue()));
    }
  }
  
  public Object getKey()
  {
    return this.key;
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (getKey() == null)
    {
      i = 0;
      if (getValue() != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = getKey().hashCode();
      break;
      label33:
      j = getValue().hashCode();
    }
  }
  
  public Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException("Entry.setValue is not supported.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/WeakHashtable$Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */