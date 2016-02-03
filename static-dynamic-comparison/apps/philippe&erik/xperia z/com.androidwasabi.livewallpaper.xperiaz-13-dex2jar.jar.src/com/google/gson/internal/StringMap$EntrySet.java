package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class StringMap$EntrySet
  extends AbstractSet<Map.Entry<String, V>>
{
  private StringMap$EntrySet(StringMap paramStringMap) {}
  
  public void clear()
  {
    this.this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    Object localObject;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      localObject = this.this$0.get(((Map.Entry)paramObject).getKey());
    } while ((localObject == null) || (!localObject.equals(((Map.Entry)paramObject).getValue())));
    return true;
  }
  
  public Iterator<Map.Entry<String, V>> iterator()
  {
    return new StringMap.EntrySet.1(this);
  }
  
  public boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return StringMap.access$600(this.this$0, ((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
  }
  
  public int size()
  {
    return StringMap.access$500(this.this$0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */