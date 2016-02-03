package com.fasterxml.jackson.databind;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class JsonNode
  implements Iterable<JsonNode>
{
  protected static final List<JsonNode> NO_NODES = ;
  protected static final List<String> NO_STRINGS = Collections.emptyList();
  
  public abstract String asText();
  
  public Iterator<JsonNode> elements()
  {
    return NO_NODES.iterator();
  }
  
  public abstract boolean equals(Object paramObject);
  
  public JsonNode get(String paramString)
  {
    return null;
  }
  
  public final Iterator<JsonNode> iterator()
  {
    return elements();
  }
  
  public int size()
  {
    return 0;
  }
  
  public abstract String toString();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/JsonNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */