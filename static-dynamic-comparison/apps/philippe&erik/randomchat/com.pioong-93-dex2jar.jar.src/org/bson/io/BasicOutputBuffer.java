package org.bson.io;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class BasicOutputBuffer
  extends OutputBuffer
{
  private byte[] _buffer = new byte['Ȁ'];
  private int _cur;
  private int _size;
  
  void _ensure(int paramInt)
  {
    int j = this._cur + paramInt;
    if (j < this._buffer.length) {
      return;
    }
    int i = this._buffer.length * 2;
    paramInt = i;
    if (i <= j) {
      paramInt = j + 128;
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this._buffer, 0, arrayOfByte, 0, this._size);
    this._buffer = arrayOfByte;
  }
  
  public String asString()
  {
    return new String(this._buffer, 0, this._size);
  }
  
  public String asString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(this._buffer, 0, this._size, paramString);
  }
  
  public int getPosition()
  {
    return this._cur;
  }
  
  public int pipe(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.write(this._buffer, 0, this._size);
    return this._size;
  }
  
  public int pipe(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this._buffer, 0, this._size);
    return this._size;
  }
  
  public void seekEnd()
  {
    this._cur = this._size;
  }
  
  public void seekStart()
  {
    this._cur = 0;
  }
  
  public void setPosition(int paramInt)
  {
    this._cur = paramInt;
  }
  
  public int size()
  {
    return this._size;
  }
  
  public void write(int paramInt)
  {
    _ensure(1);
    byte[] arrayOfByte = this._buffer;
    int i = this._cur;
    this._cur = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    this._size = Math.max(this._cur, this._size);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _ensure(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this._buffer, this._cur, paramInt2);
    this._cur += paramInt2;
    this._size = Math.max(this._cur, this._size);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/io/BasicOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */