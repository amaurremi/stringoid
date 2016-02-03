package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class BeanPropertyMap$IteratorImpl
  implements Iterator<SettableBeanProperty>
{
  private final BeanPropertyMap.Bucket[] _buckets;
  private BeanPropertyMap.Bucket _currentBucket;
  private int _nextBucketIndex;
  
  public BeanPropertyMap$IteratorImpl(BeanPropertyMap.Bucket[] paramArrayOfBucket)
  {
    this._buckets = paramArrayOfBucket;
    int i = 0;
    int k = this._buckets.length;
    int j;
    if (i < k)
    {
      paramArrayOfBucket = this._buckets;
      j = i + 1;
      paramArrayOfBucket = paramArrayOfBucket[i];
      if (paramArrayOfBucket != null) {
        this._currentBucket = paramArrayOfBucket;
      }
    }
    for (;;)
    {
      this._nextBucketIndex = j;
      return;
      i = j;
      break;
      j = i;
    }
  }
  
  public boolean hasNext()
  {
    return this._currentBucket != null;
  }
  
  public SettableBeanProperty next()
  {
    BeanPropertyMap.Bucket localBucket = this._currentBucket;
    if (localBucket == null) {
      throw new NoSuchElementException();
    }
    int i;
    for (Object localObject = localBucket.next; (localObject == null) && (this._nextBucketIndex < this._buckets.length); localObject = localObject[i])
    {
      localObject = this._buckets;
      i = this._nextBucketIndex;
      this._nextBucketIndex = (i + 1);
    }
    this._currentBucket = ((BeanPropertyMap.Bucket)localObject);
    return localBucket.value;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$IteratorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */