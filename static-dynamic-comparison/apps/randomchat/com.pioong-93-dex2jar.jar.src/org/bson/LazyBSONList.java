package org.bson;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.bson.io.BSONByteBuffer;

public class LazyBSONList
  extends LazyBSONObject
  implements List
{
  public LazyBSONList(BSONByteBuffer paramBSONByteBuffer, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramInt, paramLazyBSONCallback);
  }
  
  public LazyBSONList(BSONByteBuffer paramBSONByteBuffer, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramLazyBSONCallback);
  }
  
  public LazyBSONList(byte[] paramArrayOfByte, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramInt, paramLazyBSONCallback);
  }
  
  public LazyBSONList(byte[] paramArrayOfByte, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramLazyBSONCallback);
  }
  
  public void add(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public boolean add(Object paramObject)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) > -1;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public Object get(int paramInt)
  {
    return get("" + paramInt);
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      if (paramObject.equals(localIterator.next())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public Iterator iterator()
  {
    return new LazyBSONListIterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    int i = 0;
    int j = -1;
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      if (paramObject.equals(localIterator.next())) {
        j = i;
      }
      i += 1;
    }
    return j;
  }
  
  public ListIterator listIterator()
  {
    throw new UnsupportedOperationException("Not Supported");
  }
  
  public ListIterator listIterator(int paramInt)
  {
    throw new UnsupportedOperationException("Not Supported");
  }
  
  public Object remove(int paramInt)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Read Only");
  }
  
  public int size()
  {
    return getElements().size();
  }
  
  public List subList(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("Not Supported");
  }
  
  public Object[] toArray()
  {
    throw new UnsupportedOperationException("Not Supported");
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    throw new UnsupportedOperationException("Not Supported");
  }
  
  public class LazyBSONListIterator
    implements Iterator
  {
    List<LazyBSONObject.ElementRecord> elements = LazyBSONList.this.getElements();
    int pos = 0;
    
    public LazyBSONListIterator() {}
    
    public boolean hasNext()
    {
      return this.pos < this.elements.size();
    }
    
    public Object next()
    {
      LazyBSONList localLazyBSONList = LazyBSONList.this;
      List localList = this.elements;
      int i = this.pos;
      this.pos = (i + 1);
      return localLazyBSONList.getElementValue((LazyBSONObject.ElementRecord)localList.get(i));
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read Only");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/LazyBSONList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */