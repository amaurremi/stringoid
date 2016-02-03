package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.Iterator;

final class StringMap$Values
  extends AbstractCollection<V>
{
  private StringMap$Values(StringMap paramStringMap) {}
  
  public void clear()
  {
    this.this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.this$0.containsValue(paramObject);
  }
  
  public Iterator<V> iterator()
  {
    return new StringMap.Values.1(this);
  }
  
  public int size()
  {
    return StringMap.access$500(this.this$0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */