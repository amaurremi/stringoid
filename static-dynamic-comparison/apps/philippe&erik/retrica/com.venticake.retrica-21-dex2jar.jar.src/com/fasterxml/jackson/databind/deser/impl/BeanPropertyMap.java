package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BeanPropertyMap
  implements Serializable, Iterable<SettableBeanProperty>
{
  private final BeanPropertyMap.Bucket[] _buckets;
  private final int _hashMask;
  private int _nextBucketIndex = 0;
  private final int _size;
  
  public BeanPropertyMap(Collection<SettableBeanProperty> paramCollection)
  {
    this._size = paramCollection.size();
    int i = findSize(this._size);
    this._hashMask = (i - 1);
    BeanPropertyMap.Bucket[] arrayOfBucket = new BeanPropertyMap.Bucket[i];
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)paramCollection.next();
      String str = localSettableBeanProperty.getName();
      i = str.hashCode() & this._hashMask;
      BeanPropertyMap.Bucket localBucket = arrayOfBucket[i];
      int j = this._nextBucketIndex;
      this._nextBucketIndex = (j + 1);
      arrayOfBucket[i] = new BeanPropertyMap.Bucket(localBucket, str, localSettableBeanProperty, j);
    }
    this._buckets = arrayOfBucket;
  }
  
  private BeanPropertyMap(BeanPropertyMap.Bucket[] paramArrayOfBucket, int paramInt1, int paramInt2)
  {
    this._buckets = paramArrayOfBucket;
    this._size = paramInt1;
    this._hashMask = (paramArrayOfBucket.length - 1);
    this._nextBucketIndex = paramInt2;
  }
  
  private SettableBeanProperty _findWithEquals(String paramString, int paramInt)
  {
    for (BeanPropertyMap.Bucket localBucket = this._buckets[paramInt]; localBucket != null; localBucket = localBucket.next) {
      if (paramString.equals(localBucket.key)) {
        return localBucket.value;
      }
    }
    return null;
  }
  
  private static final int findSize(int paramInt)
  {
    if (paramInt <= 32) {
      paramInt += paramInt;
    }
    int i;
    for (;;)
    {
      i = 2;
      while (i < paramInt) {
        i += i;
      }
      paramInt = (paramInt >> 2) + paramInt;
    }
    return i;
  }
  
  public BeanPropertyMap assignIndexes()
  {
    BeanPropertyMap.Bucket[] arrayOfBucket = this._buckets;
    int k = arrayOfBucket.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      BeanPropertyMap.Bucket localBucket = arrayOfBucket[i];
      while (localBucket != null)
      {
        localBucket.value.assignIndex(j);
        localBucket = localBucket.next;
        j += 1;
      }
      i += 1;
    }
    return this;
  }
  
  public SettableBeanProperty find(String paramString)
  {
    int i = paramString.hashCode();
    i = this._hashMask & i;
    BeanPropertyMap.Bucket localBucket2 = this._buckets[i];
    if (localBucket2 == null) {
      return null;
    }
    BeanPropertyMap.Bucket localBucket1 = localBucket2;
    if (localBucket2.key == paramString) {
      return localBucket2.value;
    }
    do
    {
      localBucket2 = localBucket1.next;
      if (localBucket2 == null) {
        break;
      }
      localBucket1 = localBucket2;
    } while (localBucket2.key != paramString);
    return localBucket2.value;
    return _findWithEquals(paramString, i);
  }
  
  public SettableBeanProperty[] getPropertiesInInsertionOrder()
  {
    SettableBeanProperty[] arrayOfSettableBeanProperty = new SettableBeanProperty[this._nextBucketIndex];
    BeanPropertyMap.Bucket[] arrayOfBucket = this._buckets;
    int j = arrayOfBucket.length;
    int i = 0;
    while (i < j)
    {
      for (BeanPropertyMap.Bucket localBucket = arrayOfBucket[i]; localBucket != null; localBucket = localBucket.next) {
        arrayOfSettableBeanProperty[localBucket.index] = localBucket.value;
      }
      i += 1;
    }
    return arrayOfSettableBeanProperty;
  }
  
  public Iterator<SettableBeanProperty> iterator()
  {
    return new BeanPropertyMap.IteratorImpl(this._buckets);
  }
  
  public void remove(SettableBeanProperty paramSettableBeanProperty)
  {
    String str = paramSettableBeanProperty.getName();
    int j = str.hashCode() & this._buckets.length - 1;
    BeanPropertyMap.Bucket localBucket1 = this._buckets[j];
    int i = 0;
    BeanPropertyMap.Bucket localBucket2 = null;
    if (localBucket1 != null)
    {
      if ((i == 0) && (localBucket1.key.equals(str))) {
        i = 1;
      }
      for (;;)
      {
        localBucket1 = localBucket1.next;
        break;
        localBucket2 = new BeanPropertyMap.Bucket(localBucket2, localBucket1.key, localBucket1.value, localBucket1.index);
      }
    }
    if (i == 0) {
      throw new NoSuchElementException("No entry '" + paramSettableBeanProperty + "' found, can't remove");
    }
    this._buckets[j] = localBucket2;
  }
  
  public BeanPropertyMap renameAll(NameTransformer paramNameTransformer)
  {
    if ((paramNameTransformer == null) || (paramNameTransformer == NameTransformer.NOP)) {
      return this;
    }
    Iterator localIterator = iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      Object localObject = (SettableBeanProperty)localIterator.next();
      SettableBeanProperty localSettableBeanProperty = ((SettableBeanProperty)localObject).withName(paramNameTransformer.transform(((SettableBeanProperty)localObject).getName()));
      JsonDeserializer localJsonDeserializer1 = localSettableBeanProperty.getValueDeserializer();
      localObject = localSettableBeanProperty;
      if (localJsonDeserializer1 != null)
      {
        JsonDeserializer localJsonDeserializer2 = localJsonDeserializer1.unwrappingDeserializer(paramNameTransformer);
        localObject = localSettableBeanProperty;
        if (localJsonDeserializer2 != localJsonDeserializer1) {
          localObject = localSettableBeanProperty.withValueDeserializer(localJsonDeserializer2);
        }
      }
      localArrayList.add(localObject);
    }
    return new BeanPropertyMap(localArrayList);
  }
  
  public void replace(SettableBeanProperty paramSettableBeanProperty)
  {
    String str = paramSettableBeanProperty.getName();
    int j = str.hashCode() & this._buckets.length - 1;
    BeanPropertyMap.Bucket localBucket1 = this._buckets[j];
    int i = -1;
    BeanPropertyMap.Bucket localBucket2 = null;
    if (localBucket1 != null)
    {
      if ((i < 0) && (localBucket1.key.equals(str))) {
        i = localBucket1.index;
      }
      for (;;)
      {
        localBucket1 = localBucket1.next;
        break;
        localBucket2 = new BeanPropertyMap.Bucket(localBucket2, localBucket1.key, localBucket1.value, localBucket1.index);
      }
    }
    if (i < 0) {
      throw new NoSuchElementException("No entry '" + paramSettableBeanProperty + "' found, can't replace");
    }
    this._buckets[j] = new BeanPropertyMap.Bucket(localBucket2, str, paramSettableBeanProperty, i);
  }
  
  public int size()
  {
    return this._size;
  }
  
  public BeanPropertyMap withProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    int i = this._buckets.length;
    Object localObject = new BeanPropertyMap.Bucket[i];
    System.arraycopy(this._buckets, 0, localObject, 0, i);
    String str = paramSettableBeanProperty.getName();
    if (find(paramSettableBeanProperty.getName()) == null)
    {
      i = str.hashCode() & this._hashMask;
      BeanPropertyMap.Bucket localBucket = localObject[i];
      int j = this._nextBucketIndex;
      this._nextBucketIndex = (j + 1);
      localObject[i] = new BeanPropertyMap.Bucket(localBucket, str, paramSettableBeanProperty, j);
      return new BeanPropertyMap((BeanPropertyMap.Bucket[])localObject, this._size + 1, this._nextBucketIndex);
    }
    localObject = new BeanPropertyMap((BeanPropertyMap.Bucket[])localObject, i, this._nextBucketIndex);
    ((BeanPropertyMap)localObject).replace(paramSettableBeanProperty);
    return (BeanPropertyMap)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/BeanPropertyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */