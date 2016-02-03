package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.Serializable;

final class BeanPropertyMap$Bucket
  implements Serializable
{
  public final int index;
  public final String key;
  public final Bucket next;
  public final SettableBeanProperty value;
  
  public BeanPropertyMap$Bucket(Bucket paramBucket, String paramString, SettableBeanProperty paramSettableBeanProperty, int paramInt)
  {
    this.next = paramBucket;
    this.key = paramString;
    this.value = paramSettableBeanProperty;
    this.index = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */