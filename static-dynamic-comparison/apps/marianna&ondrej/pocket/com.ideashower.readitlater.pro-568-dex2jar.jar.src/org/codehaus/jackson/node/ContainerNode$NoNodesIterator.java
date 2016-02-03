package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.JsonNode;

public class ContainerNode$NoNodesIterator
  implements Iterator
{
  static final NoNodesIterator instance = new NoNodesIterator();
  
  public static NoNodesIterator instance()
  {
    return instance;
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public JsonNode next()
  {
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new IllegalStateException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/ContainerNode$NoNodesIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */