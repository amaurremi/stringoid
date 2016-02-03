package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUMap<K, V>
  extends LinkedHashMap<K, V>
  implements Serializable
{
  protected final int _maxEntries;
  
  public LRUMap(int paramInt1, int paramInt2)
  {
    super(paramInt1, 0.8F, true);
    this._maxEntries = paramInt2;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this._maxEntries;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/LRUMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */