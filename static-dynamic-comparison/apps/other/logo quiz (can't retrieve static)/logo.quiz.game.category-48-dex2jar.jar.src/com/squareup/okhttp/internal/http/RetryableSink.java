package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import com.squareup.okio.Buffer;
import com.squareup.okio.BufferedSink;
import com.squareup.okio.Sink;
import com.squareup.okio.Timeout;
import java.io.IOException;
import java.net.ProtocolException;

public final class RetryableSink
  implements Sink
{
  private boolean closed;
  private final Buffer content = new Buffer();
  private final int limit;
  
  public RetryableSink()
  {
    this(-1);
  }
  
  public RetryableSink(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public void close()
    throws IOException
  {
    if (this.closed) {}
    do
    {
      return;
      this.closed = true;
    } while (this.content.size() >= this.limit);
    throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.size());
  }
  
  public long contentLength()
    throws IOException
  {
    return this.content.size();
  }
  
  public void flush()
    throws IOException
  {}
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    if ((this.limit != -1) && (this.content.size() > this.limit - paramLong)) {
      throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
    }
    this.content.write(paramBuffer, paramLong);
  }
  
  public void writeToSocket(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink.writeAll(this.content.clone());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/http/RetryableSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */