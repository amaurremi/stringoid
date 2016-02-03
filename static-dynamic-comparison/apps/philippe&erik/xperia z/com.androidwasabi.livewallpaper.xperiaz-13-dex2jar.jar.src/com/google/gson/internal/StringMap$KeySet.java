package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

final class StringMap$KeySet
  extends AbstractSet<String>
{
  private StringMap$KeySet(StringMap paramStringMap) {}
  
  public void clear()
  {
    this.this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.this$0.containsKey(paramObject);
  }
  
  public Iterator<String> iterator()
  {
    return new StringMap.KeySet.1(this);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = StringMap.access$500(this.this$0);
    this.this$0.remove(paramObject);
    return StringMap.access$500(this.this$0) != i;
  }
  
  public int size()
  {
    return StringMap.access$500(this.this$0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap$KeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */