package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;
import java.util.List;

public final class ObjectBuffer
{
  private ObjectBuffer.Node _bufferHead;
  private ObjectBuffer.Node _bufferTail;
  private int _bufferedEntryCount;
  private Object[] _freeBuffer;
  
  protected final void _copyTo(Object paramObject, int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    ObjectBuffer.Node localNode = this._bufferHead;
    int i = 0;
    while (localNode != null)
    {
      Object[] arrayOfObject = localNode.getData();
      int j = arrayOfObject.length;
      System.arraycopy(arrayOfObject, 0, paramObject, i, j);
      i += j;
      localNode = localNode.next();
    }
    System.arraycopy(paramArrayOfObject, 0, paramObject, i, paramInt2);
    paramInt2 = i + paramInt2;
    if (paramInt2 != paramInt1) {
      throw new IllegalStateException("Should have gotten " + paramInt1 + " entries, got " + paramInt2);
    }
  }
  
  protected void _reset()
  {
    if (this._bufferTail != null) {
      this._freeBuffer = this._bufferTail.getData();
    }
    this._bufferTail = null;
    this._bufferHead = null;
    this._bufferedEntryCount = 0;
  }
  
  public Object[] appendCompletedChunk(Object[] paramArrayOfObject)
  {
    ObjectBuffer.Node localNode = new ObjectBuffer.Node(paramArrayOfObject);
    int i;
    if (this._bufferHead == null)
    {
      this._bufferTail = localNode;
      this._bufferHead = localNode;
      i = paramArrayOfObject.length;
      this._bufferedEntryCount += i;
      if (i >= 16384) {
        break label71;
      }
      i += i;
    }
    for (;;)
    {
      return new Object[i];
      this._bufferTail.linkNext(localNode);
      this._bufferTail = localNode;
      break;
      label71:
      i += (i >> 2);
    }
  }
  
  public void completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt, List<Object> paramList)
  {
    int j = 0;
    int i;
    for (ObjectBuffer.Node localNode = this._bufferHead;; localNode = localNode.next())
    {
      i = j;
      if (localNode == null) {
        break;
      }
      Object[] arrayOfObject = localNode.getData();
      int k = arrayOfObject.length;
      i = 0;
      while (i < k)
      {
        paramList.add(arrayOfObject[i]);
        i += 1;
      }
    }
    while (i < paramInt)
    {
      paramList.add(paramArrayOfObject[i]);
      i += 1;
    }
  }
  
  public Object[] completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt)
  {
    int i = this._bufferedEntryCount + paramInt;
    Object[] arrayOfObject = new Object[i];
    _copyTo(arrayOfObject, i, paramArrayOfObject, paramInt);
    return arrayOfObject;
  }
  
  public <T> T[] completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt, Class<T> paramClass)
  {
    int i = paramInt + this._bufferedEntryCount;
    paramClass = (Object[])Array.newInstance(paramClass, i);
    _copyTo(paramClass, i, paramArrayOfObject, paramInt);
    _reset();
    return paramClass;
  }
  
  public int initialCapacity()
  {
    if (this._freeBuffer == null) {
      return 0;
    }
    return this._freeBuffer.length;
  }
  
  public Object[] resetAndStart()
  {
    _reset();
    if (this._freeBuffer == null) {
      return new Object[12];
    }
    return this._freeBuffer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ObjectBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */