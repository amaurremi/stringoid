package org.codehaus.jackson.map.util;

public abstract class PrimitiveArrayBuilder
{
  static final int INITIAL_CHUNK_SIZE = 12;
  static final int MAX_CHUNK_SIZE = 262144;
  static final int SMALL_CHUNK_SIZE = 16384;
  PrimitiveArrayBuilder.Node _bufferHead;
  PrimitiveArrayBuilder.Node _bufferTail;
  int _bufferedEntryCount;
  Object _freeBuffer;
  
  protected abstract Object _constructArray(int paramInt);
  
  protected void _reset()
  {
    if (this._bufferTail != null) {
      this._freeBuffer = this._bufferTail.getData();
    }
    this._bufferTail = null;
    this._bufferHead = null;
    this._bufferedEntryCount = 0;
  }
  
  public final Object appendCompletedChunk(Object paramObject, int paramInt)
  {
    paramObject = new PrimitiveArrayBuilder.Node(paramObject, paramInt);
    if (this._bufferHead == null)
    {
      this._bufferTail = ((PrimitiveArrayBuilder.Node)paramObject);
      this._bufferHead = ((PrimitiveArrayBuilder.Node)paramObject);
      this._bufferedEntryCount += paramInt;
      if (paramInt >= 16384) {
        break label70;
      }
      paramInt += paramInt;
    }
    for (;;)
    {
      return _constructArray(paramInt);
      this._bufferTail.linkNext((PrimitiveArrayBuilder.Node)paramObject);
      this._bufferTail = ((PrimitiveArrayBuilder.Node)paramObject);
      break;
      label70:
      paramInt = (paramInt >> 2) + paramInt;
    }
  }
  
  public Object completeAndClearBuffer(Object paramObject, int paramInt)
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
    System.arraycopy(paramObject, 0, localObject, i, paramInt);
    paramInt = i + paramInt;
    if (paramInt != j) {
      throw new IllegalStateException("Should have gotten " + j + " entries, got " + paramInt);
    }
    return localObject;
  }
  
  public Object resetAndStart()
  {
    _reset();
    if (this._freeBuffer == null) {
      return _constructArray(12);
    }
    return this._freeBuffer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/PrimitiveArrayBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */