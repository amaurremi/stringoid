package org.bson.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class StringRangeSet
  implements Set<String>
{
  private static final String[] NUMSTRS = new String[100];
  private static final int NUMSTR_LEN = 100;
  private final int size;
  
  static
  {
    int i = 0;
    while (i < 100)
    {
      NUMSTRS[i] = String.valueOf(i);
      i += 1;
    }
  }
  
  public StringRangeSet(int paramInt)
  {
    this.size = paramInt;
  }
  
  public boolean add(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(Object paramObject)
  {
    int i = Integer.parseInt(String.valueOf(paramObject));
    return (i >= 0) && (i < this.size);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<String> iterator()
  {
    new Iterator()
    {
      int index = 0;
      
      public boolean hasNext()
      {
        return this.index < StringRangeSet.this.size;
      }
      
      public String next()
      {
        if (this.index < 100)
        {
          String[] arrayOfString = StringRangeSet.NUMSTRS;
          i = this.index;
          this.index = (i + 1);
          return arrayOfString[i];
        }
        int i = this.index;
        this.index = (i + 1);
        return String.valueOf(i);
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Object[] toArray()
  {
    String[] arrayOfString = new String[size()];
    int i = 0;
    if (i < this.size)
    {
      if (i < 100) {
        arrayOfString[i] = NUMSTRS[i];
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString[i] = String.valueOf(i);
      }
    }
    return arrayOfString;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/util/StringRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */