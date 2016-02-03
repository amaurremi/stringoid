package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class ObjectNode$NoFieldsIterator
  implements Iterator
{
  static final NoFieldsIterator instance = new NoFieldsIterator();
  
  public boolean hasNext()
  {
    return false;
  }
  
  public Map.Entry next()
  {
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new IllegalStateException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/ObjectNode$NoFieldsIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */