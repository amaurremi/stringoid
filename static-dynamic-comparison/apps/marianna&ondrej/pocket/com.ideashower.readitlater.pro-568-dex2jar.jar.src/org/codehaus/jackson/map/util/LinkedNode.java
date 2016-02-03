package org.codehaus.jackson.map.util;

public final class LinkedNode
{
  final LinkedNode _next;
  final Object _value;
  
  public LinkedNode(Object paramObject, LinkedNode paramLinkedNode)
  {
    this._value = paramObject;
    this._next = paramLinkedNode;
  }
  
  public static boolean contains(LinkedNode paramLinkedNode, Object paramObject)
  {
    while (paramLinkedNode != null)
    {
      if (paramLinkedNode.value() == paramObject) {
        return true;
      }
      paramLinkedNode = paramLinkedNode.next();
    }
    return false;
  }
  
  public LinkedNode next()
  {
    return this._next;
  }
  
  public Object value()
  {
    return this._value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/LinkedNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */