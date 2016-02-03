package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache.TypeKey;

final class JsonSerializerMap$Bucket
{
  public final SerializerCache.TypeKey key;
  public final Bucket next;
  public final JsonSerializer<Object> value;
  
  public JsonSerializerMap$Bucket(Bucket paramBucket, SerializerCache.TypeKey paramTypeKey, JsonSerializer<Object> paramJsonSerializer)
  {
    this.next = paramBucket;
    this.key = paramTypeKey;
    this.value = paramJsonSerializer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/JsonSerializerMap$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */