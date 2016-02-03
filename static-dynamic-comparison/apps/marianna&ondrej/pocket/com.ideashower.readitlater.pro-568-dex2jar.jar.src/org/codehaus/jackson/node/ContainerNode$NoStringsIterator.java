package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContainerNode$NoStringsIterator
  implements Iterator
{
  static final NoStringsIterator instance = new NoStringsIterator();
  
  public static NoStringsIterator instance()
  {
    return instance;
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public String next()
  {
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new IllegalStateException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/ContainerNode$NoStringsIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */