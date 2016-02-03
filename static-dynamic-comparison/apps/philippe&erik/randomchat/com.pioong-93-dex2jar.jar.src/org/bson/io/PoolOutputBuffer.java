package org.bson.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.bson.util.SimplePool;

public class PoolOutputBuffer
  extends OutputBuffer
{
  public static final int BUF_SIZE = 16384;
  private static final String DEFAULT_ENCODING_1 = "UTF-8";
  private static final String DEFAULT_ENCODING_2 = "UTF8";
  private static SimplePool<byte[]> _extra = new SimplePool(640)
  {
    protected byte[] createNew()
    {
      return new byte['䀀'];
    }
  };
  final char[] _chars = new char['䀀'];
  private final Position _cur = new Position();
  final UTF8Encoding _encoding = new UTF8Encoding();
  private final Position _end = new Position();
  final List<byte[]> _fromPool = new ArrayList();
  final byte[] _mine = new byte['䀀'];
  
  public PoolOutputBuffer()
  {
    reset();
  }
  
  void _afterWrite()
  {
    if (this._cur.pos() < this._end.pos()) {
      if (this._cur.y == 16384) {
        this._cur.nextBuffer();
      }
    }
    do
    {
      return;
      this._end.reset(this._cur);
    } while (this._end.y < 16384);
    this._fromPool.add(_extra.get());
    this._end.nextBuffer();
    this._cur.reset(this._end);
  }
  
  byte[] _cur()
  {
    return _get(this._cur.x);
  }
  
  byte[] _get(int paramInt)
  {
    if (paramInt < 0) {
      return this._mine;
    }
    return (byte[])this._fromPool.get(paramInt);
  }
  
  public String asAscii()
  {
    if (this._fromPool.size() > 0) {
      return super.asString();
    }
    int j = size();
    if (j < this._chars.length) {}
    for (char[] arrayOfChar = this._chars;; arrayOfChar = new char[j])
    {
      int i = 0;
      while (i < j)
      {
        arrayOfChar[i] = ((char)this._mine[i]);
        i += 1;
      }
    }
    return new String(arrayOfChar, 0, j);
  }
  
  public String asString(String paramString)
    throws UnsupportedEncodingException
  {
    if (this._fromPool.size() > 0) {
      return super.asString(paramString);
    }
    if ((paramString.equals("UTF-8")) || (paramString.equals("UTF8"))) {
      try
      {
        String str = this._encoding.decode(this._mine, 0, size());
        return str;
      }
      catch (IOException localIOException) {}
    }
    return new String(this._mine, 0, size(), paramString);
  }
  
  public int getPosition()
  {
    return this._cur.pos();
  }
  
  public int pipe(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new NullPointerException("out is null");
    }
    int j = 0;
    int i = -1;
    while (i < this._fromPool.size())
    {
      byte[] arrayOfByte = _get(i);
      int k = this._end.len(i);
      paramOutputStream.write(arrayOfByte, 0, k);
      j += k;
      i += 1;
    }
    return j;
  }
  
  public void reset()
  {
    this._cur.reset();
    this._end.reset();
    int i = 0;
    while (i < this._fromPool.size())
    {
      _extra.done(this._fromPool.get(i));
      i += 1;
    }
    this._fromPool.clear();
  }
  
  public void seekEnd()
  {
    this._cur.reset(this._end);
  }
  
  public void seekStart()
  {
    this._cur.reset();
  }
  
  public void setPosition(int paramInt)
  {
    this._cur.reset(paramInt);
  }
  
  public int size()
  {
    return this._end.pos();
  }
  
  public void write(int paramInt)
  {
    _cur()[this._cur.getAndInc()] = ((byte)(paramInt & 0xFF));
    _afterWrite();
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      byte[] arrayOfByte = _cur();
      int i = Math.min(arrayOfByte.length - this._cur.y, paramInt2);
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this._cur.y, i);
      this._cur.inc(i);
      paramInt2 -= i;
      paramInt1 += i;
      _afterWrite();
    }
  }
  
  static class Position
  {
    int x;
    int y;
    
    Position()
    {
      reset();
    }
    
    int getAndInc()
    {
      int i = this.y;
      this.y = (i + 1);
      return i;
    }
    
    void inc(int paramInt)
    {
      this.y += paramInt;
      if (this.y > 16384) {
        throw new IllegalArgumentException("something is wrong");
      }
    }
    
    int len(int paramInt)
    {
      if (paramInt < this.x) {
        return 16384;
      }
      return this.y;
    }
    
    void nextBuffer()
    {
      if (this.y != 16384) {
        throw new IllegalArgumentException("broken");
      }
      this.x += 1;
      this.y = 0;
    }
    
    int pos()
    {
      return (this.x + 1) * 16384 + this.y;
    }
    
    void reset()
    {
      this.x = -1;
      this.y = 0;
    }
    
    void reset(int paramInt)
    {
      this.x = (paramInt / 16384 - 1);
      this.y = (paramInt % 16384);
    }
    
    void reset(Position paramPosition)
    {
      this.x = paramPosition.x;
      this.y = paramPosition.y;
    }
    
    public String toString()
    {
      return this.x + "," + this.y;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/io/PoolOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */