package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContainerNode$NoNodesIterator
  implements Iterator<JsonNode>
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/ContainerNode$NoNodesIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */