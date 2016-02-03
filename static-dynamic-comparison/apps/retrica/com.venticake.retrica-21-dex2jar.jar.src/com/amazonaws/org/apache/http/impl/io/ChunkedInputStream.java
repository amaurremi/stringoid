package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpException;
import com.amazonaws.org.apache.http.MalformedChunkCodingException;
import com.amazonaws.org.apache.http.TruncatedChunkException;
import com.amazonaws.org.apache.http.io.BufferInfo;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ChunkedInputStream
  extends InputStream
{
  private final CharArrayBuffer buffer;
  private int chunkSize;
  private boolean closed = false;
  private boolean eof = false;
  private Header[] footers = new Header[0];
  private final SessionInputBuffer in;
  private int pos;
  private int state;
  
  public ChunkedInputStream(SessionInputBuffer paramSessionInputBuffer)
  {
    if (paramSessionInputBuffer == null) {
      throw new IllegalArgumentException("Session input buffer may not be null");
    }
    this.in = paramSessionInputBuffer;
    this.pos = 0;
    this.buffer = new CharArrayBuffer(16);
    this.state = 1;
  }
  
  private int getChunkSize()
  {
    switch (this.state)
    {
    case 2: 
    default: 
      throw new IllegalStateException("Inconsistent codec state");
    case 3: 
      this.buffer.clear();
      if (this.in.readLine(this.buffer) != -1) {
        break;
      }
    }
    do
    {
      return 0;
      if (!this.buffer.isEmpty()) {
        throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
      }
      this.state = 1;
      this.buffer.clear();
    } while (this.in.readLine(this.buffer) == -1);
    int j = this.buffer.indexOf(59);
    int i = j;
    if (j < 0) {
      i = this.buffer.length();
    }
    try
    {
      i = Integer.parseInt(this.buffer.substringTrimmed(0, i), 16);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new MalformedChunkCodingException("Bad chunk header");
    }
  }
  
  private void nextChunk()
  {
    this.chunkSize = getChunkSize();
    if (this.chunkSize < 0) {
      throw new MalformedChunkCodingException("Negative chunk size");
    }
    this.state = 2;
    this.pos = 0;
    if (this.chunkSize == 0)
    {
      this.eof = true;
      parseTrailerHeaders();
    }
  }
  
  private void parseTrailerHeaders()
  {
    try
    {
      this.footers = AbstractMessageParser.parseHeaders(this.in, -1, -1, null);
      return;
    }
    catch (HttpException localHttpException)
    {
      MalformedChunkCodingException localMalformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + localHttpException.getMessage());
      localMalformedChunkCodingException.initCause(localHttpException);
      throw localMalformedChunkCodingException;
    }
  }
  
  public int available()
  {
    if ((this.in instanceof BufferInfo)) {
      return Math.min(((BufferInfo)this.in).length(), this.chunkSize - this.pos);
    }
    return 0;
  }
  
  public void close()
  {
    if (!this.closed) {}
    try
    {
      if (!this.eof)
      {
        byte[] arrayOfByte = new byte['ࠀ'];
        int i;
        do
        {
          i = read(arrayOfByte);
        } while (i >= 0);
      }
      return;
    }
    finally
    {
      this.eof = true;
      this.closed = true;
    }
  }
  
  public int read()
  {
    if (this.closed) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.eof) {}
    do
    {
      return -1;
      if (this.state == 2) {
        break;
      }
      nextChunk();
    } while (this.eof);
    int i = this.in.read();
    if (i != -1)
    {
      this.pos += 1;
      if (this.pos >= this.chunkSize) {
        this.state = 3;
      }
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.closed) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.eof) {}
    do
    {
      return -1;
      if (this.state == 2) {
        break;
      }
      nextChunk();
    } while (this.eof);
    paramInt2 = Math.min(paramInt2, this.chunkSize - this.pos);
    paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1)
    {
      this.pos += paramInt1;
      if (this.pos >= this.chunkSize) {
        this.state = 3;
      }
      return paramInt1;
    }
    this.eof = true;
    throw new TruncatedChunkException("Truncated chunk ( expected size: " + this.chunkSize + "; actual size: " + this.pos + ")");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/ChunkedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */