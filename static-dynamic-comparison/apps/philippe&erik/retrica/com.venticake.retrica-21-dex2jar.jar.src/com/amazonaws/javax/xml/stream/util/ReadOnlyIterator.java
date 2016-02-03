package com.amazonaws.javax.xml.stream.util;

import java.util.Iterator;

public class ReadOnlyIterator
  implements Iterator
{
  Iterator iterator = null;
  
  public ReadOnlyIterator() {}
  
  public ReadOnlyIterator(Iterator paramIterator)
  {
    this.iterator = paramIterator;
  }
  
  public boolean hasNext()
  {
    if (this.iterator != null) {
      return this.iterator.hasNext();
    }
    return false;
  }
  
  public Object next()
  {
    if (this.iterator != null) {
      return this.iterator.next();
    }
    return null;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Remove operation is not supported");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/util/ReadOnlyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */