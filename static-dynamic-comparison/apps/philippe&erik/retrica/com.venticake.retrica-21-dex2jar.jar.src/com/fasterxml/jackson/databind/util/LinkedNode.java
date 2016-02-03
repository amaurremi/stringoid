package com.fasterxml.jackson.databind.util;

public final class LinkedNode<T>
{
  final LinkedNode<T> _next;
  final T _value;
  
  public LinkedNode<T> next()
  {
    return this._next;
  }
  
  public T value()
  {
    return (T)this._value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/LinkedNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */