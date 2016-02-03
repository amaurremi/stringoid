package com.google.gson.internal;

import java.util.Map.Entry;

class StringMap$LinkedEntry<V>
  implements Map.Entry<String, V>
{
  final int hash;
  final String key;
  LinkedEntry<V> next;
  LinkedEntry<V> nxt;
  LinkedEntry<V> prv;
  V value;
  
  StringMap$LinkedEntry()
  {
    this(null, null, 0, null, null, null);
    this.prv = this;
    this.nxt = this;
  }
  
  StringMap$LinkedEntry(String paramString, V paramV, int paramInt, LinkedEntry<V> paramLinkedEntry1, LinkedEntry<V> paramLinkedEntry2, LinkedEntry<V> paramLinkedEntry3)
  {
    this.key = paramString;
    this.value = paramV;
    this.hash = paramInt;
    this.next = paramLinkedEntry1;
    this.nxt = paramLinkedEntry2;
    this.prv = paramLinkedEntry3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        localObject = ((Map.Entry)paramObject).getValue();
      } while (!this.key.equals(((Map.Entry)paramObject).getKey()));
      if (this.value != null) {
        break;
      }
    } while (localObject != null);
    for (;;)
    {
      return true;
      if (!this.value.equals(localObject)) {
        break;
      }
    }
  }
  
  public final String getKey()
  {
    return this.key;
  }
  
  public final V getValue()
  {
    return (V)this.value;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int i;
    if (this.key == null)
    {
      i = 0;
      if (this.value != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.key.hashCode();
      break;
      label33:
      j = this.value.hashCode();
    }
  }
  
  public final V setValue(V paramV)
  {
    Object localObject = this.value;
    this.value = paramV;
    return (V)localObject;
  }
  
  public final String toString()
  {
    return this.key + "=" + this.value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap$LinkedEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */