package com.fasterxml.jackson.databind.util;

final class ObjectBuffer$Node
{
  final Object[] _data;
  Node _next;
  
  public ObjectBuffer$Node(Object[] paramArrayOfObject)
  {
    this._data = paramArrayOfObject;
  }
  
  public Object[] getData()
  {
    return this._data;
  }
  
  public void linkNext(Node paramNode)
  {
    if (this._next != null) {
      throw new IllegalStateException();
    }
    this._next = paramNode;
  }
  
  public Node next()
  {
    return this._next;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ObjectBuffer$Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */