package org.codehaus.jackson.map.deser.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.map.deser.SettableBeanProperty;

public final class BeanPropertyMap
{
  private final BeanPropertyMap.Bucket[] _buckets;
  private final int _hashMask;
  private final int _size;
  
  public BeanPropertyMap(Collection paramCollection)
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
      arrayOfBucket[i] = new BeanPropertyMap.Bucket(arrayOfBucket[i], str, localSettableBeanProperty);
    }
    this._buckets = arrayOfBucket;
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
  
  public Iterator allProperties()
  {
    return new BeanPropertyMap.IteratorImpl(this._buckets);
  }
  
  public void assignIndexes()
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
        localBucket2 = new BeanPropertyMap.Bucket(localBucket2, localBucket1.key, localBucket1.value);
      }
    }
    if (i == 0) {
      throw new NoSuchElementException("No entry '" + paramSettableBeanProperty + "' found, can't remove");
    }
    this._buckets[j] = localBucket2;
  }
  
  public void replace(SettableBeanProperty paramSettableBeanProperty)
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
        localBucket2 = new BeanPropertyMap.Bucket(localBucket2, localBucket1.key, localBucket1.value);
      }
    }
    if (i == 0) {
      throw new NoSuchElementException("No entry '" + paramSettableBeanProperty + "' found, can't replace");
    }
    this._buckets[j] = new BeanPropertyMap.Bucket(localBucket2, str, paramSettableBeanProperty);
  }
  
  public int size()
  {
    return this._size;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/BeanPropertyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */