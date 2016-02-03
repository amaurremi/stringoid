package org.codehaus.jackson.map.util;

final class PrimitiveArrayBuilder$Node
{
  final Object _data;
  final int _dataLength;
  Node _next;
  
  public PrimitiveArrayBuilder$Node(Object paramObject, int paramInt)
  {
    this._data = paramObject;
    this._dataLength = paramInt;
  }
  
  public int copyData(Object paramObject, int paramInt)
  {
    System.arraycopy(this._data, 0, paramObject, paramInt, this._dataLength);
    return this._dataLength + paramInt;
  }
  
  public Object getData()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/PrimitiveArrayBuilder$Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */