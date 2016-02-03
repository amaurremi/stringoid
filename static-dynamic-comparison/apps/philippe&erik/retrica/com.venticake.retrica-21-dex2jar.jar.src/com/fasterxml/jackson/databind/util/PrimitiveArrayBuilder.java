package com.fasterxml.jackson.databind.util;

public abstract class PrimitiveArrayBuilder<T>
{
  PrimitiveArrayBuilder.Node<T> _bufferHead;
  PrimitiveArrayBuilder.Node<T> _bufferTail;
  int _bufferedEntryCount;
  T _freeBuffer;
  
  protected abstract T _constructArray(int paramInt);
  
  protected void _reset()
  {
    if (this._bufferTail != null) {
      this._freeBuffer = this._bufferTail.getData();
    }
    this._bufferTail = null;
    this._bufferHead = null;
    this._bufferedEntryCount = 0;
  }
  
  public final T appendCompletedChunk(T paramT, int paramInt)
  {
    paramT = new PrimitiveArrayBuilder.Node(paramT, paramInt);
    if (this._bufferHead == null)
    {
      this._bufferTail = paramT;
      this._bufferHead = paramT;
      this._bufferedEntryCount += paramInt;
      if (paramInt >= 16384) {
        break label70;
      }
      paramInt += paramInt;
    }
    for (;;)
    {
      return (T)_constructArray(paramInt);
      this._bufferTail.linkNext(paramT);
      this._bufferTail = paramT;
      break;
      label70:
      paramInt = (paramInt >> 2) + paramInt;
    }
  }
  
  public T completeAndClearBuffer(T paramT, int paramInt)
  {
    int j = paramInt + this._bufferedEntryCount;
    Object localObject = _constructArray(j);
    PrimitiveArrayBuilder.Node localNode = this._bufferHead;
    int i = 0;
    while (localNode != null)
    {
      i = localNode.copyData(localObject, i);
      localNode = localNode.next();
    }
    System.arraycopy(paramT, 0, localObject, i, paramInt);
    paramInt = i + paramInt;
    if (paramInt != j) {
      throw new IllegalStateException("Should have gotten " + j + " entries, got " + paramInt);
    }
    return (T)localObject;
  }
  
  public T resetAndStart()
  {
    _reset();
    if (this._freeBuffer == null) {
      return (T)_constructArray(12);
    }
    return (T)this._freeBuffer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/PrimitiveArrayBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */