package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.BufferRecycler.ByteBufferType;
import com.fasterxml.jackson.core.util.BufferRecycler.CharBufferType;
import com.fasterxml.jackson.core.util.TextBuffer;

public final class IOContext
{
  protected byte[] _base64Buffer = null;
  protected final BufferRecycler _bufferRecycler;
  protected char[] _concatCBuffer = null;
  protected JsonEncoding _encoding;
  protected final boolean _managedResource;
  protected char[] _nameCopyBuffer = null;
  protected byte[] _readIOBuffer = null;
  protected final Object _sourceRef;
  protected char[] _tokenCBuffer = null;
  protected byte[] _writeEncodingBuffer = null;
  
  public IOContext(BufferRecycler paramBufferRecycler, Object paramObject, boolean paramBoolean)
  {
    this._bufferRecycler = paramBufferRecycler;
    this._sourceRef = paramObject;
    this._managedResource = paramBoolean;
  }
  
  public char[] allocNameCopyBuffer(int paramInt)
  {
    if (this._nameCopyBuffer != null) {
      throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
    }
    this._nameCopyBuffer = this._bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, paramInt);
    return this._nameCopyBuffer;
  }
  
  public byte[] allocReadIOBuffer()
  {
    if (this._readIOBuffer != null) {
      throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
    }
    this._readIOBuffer = this._bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER);
    return this._readIOBuffer;
  }
  
  public char[] allocTokenBuffer()
  {
    if (this._tokenCBuffer != null) {
      throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
    }
    this._tokenCBuffer = this._bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER);
    return this._tokenCBuffer;
  }
  
  public TextBuffer constructTextBuffer()
  {
    return new TextBuffer(this._bufferRecycler);
  }
  
  public JsonEncoding getEncoding()
  {
    return this._encoding;
  }
  
  public Object getSourceReference()
  {
    return this._sourceRef;
  }
  
  public boolean isResourceManaged()
  {
    return this._managedResource;
  }
  
  public void releaseNameCopyBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this._nameCopyBuffer) {
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      }
      this._nameCopyBuffer = null;
      this._bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, paramArrayOfChar);
    }
  }
  
  public void releaseReadIOBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte != this._readIOBuffer) {
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      }
      this._readIOBuffer = null;
      this._bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER, paramArrayOfByte);
    }
  }
  
  public void releaseTokenBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfChar != this._tokenCBuffer) {
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
      }
      this._tokenCBuffer = null;
      this._bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER, paramArrayOfChar);
    }
  }
  
  public void setEncoding(JsonEncoding paramJsonEncoding)
  {
    this._encoding = paramJsonEncoding;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/IOContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */