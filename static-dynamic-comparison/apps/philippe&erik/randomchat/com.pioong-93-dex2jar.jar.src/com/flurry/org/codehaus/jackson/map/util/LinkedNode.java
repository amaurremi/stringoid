package com.flurry.org.codehaus.jackson.map.util;

public final class LinkedNode<T>
{
  final LinkedNode<T> _next;
  final T _value;
  
  public LinkedNode(T paramT, LinkedNode<T> paramLinkedNode)
  {
    this._value = paramT;
    this._next = paramLinkedNode;
  }
  
  public static <ST> boolean contains(LinkedNode<ST> paramLinkedNode, ST paramST)
  {
    while (paramLinkedNode != null)
    {
      if (paramLinkedNode.value() == paramST) {
        return true;
      }
      paramLinkedNode = paramLinkedNode.next();
    }
    return false;
  }
  
  public LinkedNode<T> next()
  {
    return this._next;
  }
  
  public T value()
  {
    return (T)this._value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/util/LinkedNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */