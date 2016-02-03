package com.amazonaws.javax.xml.stream.xerces.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class XMLAttributesIteratorImpl
  extends XMLAttributesImpl
  implements Iterator
{
  protected int fCurrent = 0;
  protected XMLAttributesImpl.Attribute fLastReturnedItem;
  
  public boolean hasNext()
  {
    return this.fCurrent < getLength();
  }
  
  public Object next()
  {
    if (hasNext())
    {
      Object localObject = this.fAttributes;
      int i = this.fCurrent;
      this.fCurrent = (i + 1);
      localObject = localObject[i];
      this.fLastReturnedItem = ((XMLAttributesImpl.Attribute)localObject);
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    if (this.fLastReturnedItem == this.fAttributes[(this.fCurrent - 1)])
    {
      int i = this.fCurrent;
      this.fCurrent = (i - 1);
      removeAttributeAt(i);
      return;
    }
    throw new IllegalStateException();
  }
  
  public void removeAllAttributes()
  {
    super.removeAllAttributes();
    this.fCurrent = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/XMLAttributesIteratorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */