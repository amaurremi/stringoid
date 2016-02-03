package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

class LazyField
{
  private ByteString bytes;
  private final MessageLite defaultInstance;
  private final ExtensionRegistryLite extensionRegistry;
  private volatile boolean isDirty = false;
  private volatile MessageLite value;
  
  public LazyField(MessageLite paramMessageLite, ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    this.defaultInstance = paramMessageLite;
    this.extensionRegistry = paramExtensionRegistryLite;
    this.bytes = paramByteString;
  }
  
  private void ensureInitialized()
  {
    if (this.value != null) {
      return;
    }
    try
    {
      if (this.value != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.bytes != null) {
        this.value = ((MessageLite)this.defaultInstance.getParserForType().parseFrom(this.bytes, this.extensionRegistry));
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public boolean equals(Object paramObject)
  {
    ensureInitialized();
    return this.value.equals(paramObject);
  }
  
  public int getSerializedSize()
  {
    if (this.isDirty) {
      return this.value.getSerializedSize();
    }
    return this.bytes.size();
  }
  
  public MessageLite getValue()
  {
    ensureInitialized();
    return this.value;
  }
  
  public int hashCode()
  {
    ensureInitialized();
    return this.value.hashCode();
  }
  
  public MessageLite setValue(MessageLite paramMessageLite)
  {
    MessageLite localMessageLite = this.value;
    this.value = paramMessageLite;
    this.bytes = null;
    this.isDirty = true;
    return localMessageLite;
  }
  
  public ByteString toByteString()
  {
    if (!this.isDirty) {
      return this.bytes;
    }
    try
    {
      if (!this.isDirty)
      {
        ByteString localByteString1 = this.bytes;
        return localByteString1;
      }
    }
    finally {}
    this.bytes = this.value.toByteString();
    this.isDirty = false;
    ByteString localByteString2 = this.bytes;
    return localByteString2;
  }
  
  public String toString()
  {
    ensureInitialized();
    return this.value.toString();
  }
  
  static class LazyEntry<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, LazyField> entry;
    
    private LazyEntry(Map.Entry<K, LazyField> paramEntry)
    {
      this.entry = paramEntry;
    }
    
    public LazyField getField()
    {
      return (LazyField)this.entry.getValue();
    }
    
    public K getKey()
    {
      return (K)this.entry.getKey();
    }
    
    public Object getValue()
    {
      LazyField localLazyField = (LazyField)this.entry.getValue();
      if (localLazyField == null) {
        return null;
      }
      return localLazyField.getValue();
    }
    
    public Object setValue(Object paramObject)
    {
      if (!(paramObject instanceof MessageLite)) {
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      }
      return ((LazyField)this.entry.getValue()).setValue((MessageLite)paramObject);
    }
  }
  
  static class LazyIterator<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> iterator;
    
    public LazyIterator(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.iterator = paramIterator;
    }
    
    public boolean hasNext()
    {
      return this.iterator.hasNext();
    }
    
    public Map.Entry<K, Object> next()
    {
      Map.Entry localEntry = (Map.Entry)this.iterator.next();
      Object localObject = localEntry;
      if ((localEntry.getValue() instanceof LazyField)) {
        localObject = new LazyField.LazyEntry(localEntry, null);
      }
      return (Map.Entry<K, Object>)localObject;
    }
    
    public void remove()
    {
      this.iterator.remove();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/LazyField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */