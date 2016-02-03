package com.google.gson.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class StringMap$LinkedHashIterator<T>
  implements Iterator<T>
{
  StringMap.LinkedEntry<V> lastReturned = null;
  StringMap.LinkedEntry<V> next = StringMap.access$300(this.this$0).nxt;
  
  private StringMap$LinkedHashIterator(StringMap paramStringMap) {}
  
  public final boolean hasNext()
  {
    return this.next != StringMap.access$300(this.this$0);
  }
  
  final StringMap.LinkedEntry<V> nextEntry()
  {
    StringMap.LinkedEntry localLinkedEntry = this.next;
    if (localLinkedEntry == StringMap.access$300(this.this$0)) {
      throw new NoSuchElementException();
    }
    this.next = localLinkedEntry.nxt;
    this.lastReturned = localLinkedEntry;
    return localLinkedEntry;
  }
  
  public final void remove()
  {
    if (this.lastReturned == null) {
      throw new IllegalStateException();
    }
    this.this$0.remove(this.lastReturned.key);
    this.lastReturned = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/StringMap$LinkedHashIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */