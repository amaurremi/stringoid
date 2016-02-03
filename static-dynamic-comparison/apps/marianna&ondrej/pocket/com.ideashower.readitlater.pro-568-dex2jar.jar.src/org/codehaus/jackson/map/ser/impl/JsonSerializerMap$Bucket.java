package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class JsonSerializerMap$Bucket
{
  public final SerializerCache.TypeKey key;
  public final Bucket next;
  public final JsonSerializer value;
  
  public JsonSerializerMap$Bucket(Bucket paramBucket, SerializerCache.TypeKey paramTypeKey, JsonSerializer paramJsonSerializer)
  {
    this.next = paramBucket;
    this.key = paramTypeKey;
    this.value = paramJsonSerializer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/JsonSerializerMap$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */