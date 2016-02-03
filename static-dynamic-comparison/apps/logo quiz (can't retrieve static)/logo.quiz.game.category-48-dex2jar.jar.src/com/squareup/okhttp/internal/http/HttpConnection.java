package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okio.Buffer;
import com.squareup.okio.BufferedSink;
import com.squareup.okio.BufferedSource;
import com.squareup.okio.Okio;
import com.squareup.okio.Sink;
import com.squareup.okio.Source;
import com.squareup.okio.Timeout;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public final class HttpConnection
{
  private static final String CRLF = "\r\n";
  private static final byte[] FINAL_CHUNK = { 48, 13, 10, 13, 10 };
  private static final byte[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int ON_IDLE_CLOSE = 2;
  private static final int ON_IDLE_HOLD = 0;
  private static final int ON_IDLE_POOL = 1;
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  private final Connection connection;
  private int onIdle = 0;
  private final ConnectionPool pool;
  private final BufferedSink sink;
  private final Socket socket;
  private final BufferedSource source;
  private int state = 0;
  
  public HttpConnection(ConnectionPool paramConnectionPool, Connection paramConnection, Socket paramSocket)
    throws IOException
  {
    this.pool = paramConnectionPool;
    this.connection = paramConnection;
    this.socket = paramSocket;
    this.source = Okio.buffer(Okio.source(paramSocket));
    this.sink = Okio.buffer(Okio.sink(paramSocket));
  }
  
  public long bufferSize()
  {
    return this.source.buffer().size();
  }
  
  public void closeIfOwnedBy(Object paramObject)
    throws IOException
  {
    Internal.instance.closeIfOwnedBy(this.connection, paramObject);
  }
  
  public void closeOnIdle()
    throws IOException
  {
    this.onIdle = 2;
    if (this.state == 0)
    {
      this.state = 6;
      this.connection.getSocket().close();
    }
  }
  
  public boolean discard(Source paramSource, int paramInt)
  {
    try
    {
      int i = this.socket.getSoTimeout();
      this.socket.setSoTimeout(paramInt);
      try
      {
        boolean bool = Util.skipAll(paramSource, paramInt);
        return bool;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      return false;
    }
    catch (IOException paramSource) {}
  }
  
  public void emptyResponseBody()
    throws IOException
  {
    newFixedLengthSource(null, 0L);
  }
  
  public void flush()
    throws IOException
  {
    this.sink.flush();
  }
  
  public boolean isClosed()
  {
    return this.state == 6;
  }
  
  public boolean isReadable()
  {
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        boolean bool = this.source.exhausted();
        return !bool;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException) {}
  }
  
  public Sink newChunkedSink()
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new ChunkedSink(null);
  }
  
  public Source newChunkedSource(CacheRequest paramCacheRequest, HttpEngine paramHttpEngine)
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new ChunkedSource(paramCacheRequest, paramHttpEngine);
  }
  
  public Sink newFixedLengthSink(long paramLong)
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new FixedLengthSink(paramLong, null);
  }
  
  public Source newFixedLengthSource(CacheRequest paramCacheRequest, long paramLong)
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new FixedLengthSource(paramCacheRequest, paramLong);
  }
  
  public Source newUnknownLengthSource(CacheRequest paramCacheRequest)
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new UnknownLengthSource(paramCacheRequest);
  }
  
  public void poolOnIdle()
  {
    this.onIdle = 1;
    if (this.state == 0)
    {
      this.onIdle = 0;
      Internal.instance.recycle(this.pool, this.connection);
    }
  }
  
  public void readHeaders(Headers.Builder paramBuilder)
    throws IOException
  {
    for (;;)
    {
      String str = this.source.readUtf8LineStrict();
      if (str.length() == 0) {
        break;
      }
      Internal.instance.addLine(paramBuilder, str);
    }
  }
  
  public Response.Builder readResponse()
    throws IOException
  {
    if ((this.state != 1) && (this.state != 3)) {
      throw new IllegalStateException("state: " + this.state);
    }
    StatusLine localStatusLine;
    Response.Builder localBuilder;
    do
    {
      localStatusLine = StatusLine.parse(this.source.readUtf8LineStrict());
      localBuilder = new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message);
      Headers.Builder localBuilder1 = new Headers.Builder();
      readHeaders(localBuilder1);
      localBuilder1.add(OkHeaders.SELECTED_PROTOCOL, localStatusLine.protocol.toString());
      localBuilder.headers(localBuilder1.build());
    } while (localStatusLine.code == 100);
    this.state = 4;
    return localBuilder;
  }
  
  public void setTimeouts(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
    }
    if (paramInt2 != 0) {
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
    }
  }
  
  public void writeRequest(Headers paramHeaders, String paramString)
    throws IOException
  {
    if (this.state != 0) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.sink.writeUtf8(paramString).writeUtf8("\r\n");
    int i = 0;
    while (i < paramHeaders.size())
    {
      this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
      i += 1;
    }
    this.sink.writeUtf8("\r\n");
    this.state = 1;
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 3;
    paramRetryableSink.writeToSocket(this.sink);
  }
  
  private class AbstractSource
  {
    protected final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    protected boolean closed;
    
    AbstractSource(CacheRequest paramCacheRequest)
      throws IOException
    {
      if (paramCacheRequest != null) {}
      for (this$1 = paramCacheRequest.getBody();; this$1 = null)
      {
        if (HttpConnection.this == null) {
          paramCacheRequest = null;
        }
        this.cacheBody = HttpConnection.this;
        this.cacheRequest = paramCacheRequest;
        return;
      }
    }
    
    protected final void cacheWrite(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.cacheBody != null) {
        paramBuffer.copyTo(this.cacheBody, paramBuffer.size() - paramLong, paramLong);
      }
    }
    
    protected final void endOfInput(boolean paramBoolean)
      throws IOException
    {
      if (HttpConnection.this.state != 5) {
        throw new IllegalStateException("state: " + HttpConnection.this.state);
      }
      if (this.cacheRequest != null) {
        this.cacheBody.close();
      }
      HttpConnection.access$302(HttpConnection.this, 0);
      if ((paramBoolean) && (HttpConnection.this.onIdle == 1))
      {
        HttpConnection.access$602(HttpConnection.this, 0);
        Internal.instance.recycle(HttpConnection.this.pool, HttpConnection.this.connection);
      }
      while (HttpConnection.this.onIdle != 2) {
        return;
      }
      HttpConnection.access$302(HttpConnection.this, 6);
      HttpConnection.this.connection.getSocket().close();
    }
    
    protected final void unexpectedEndOfInput()
    {
      if (this.cacheRequest != null) {
        this.cacheRequest.abort();
      }
      Util.closeQuietly(HttpConnection.this.connection.getSocket());
      HttpConnection.access$302(HttpConnection.this, 6);
    }
  }
  
  private final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final byte[] hex = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 10 };
    
    private ChunkedSink() {}
    
    private void writeHex(long paramLong)
      throws IOException
    {
      int i = 16;
      int j;
      long l;
      do
      {
        byte[] arrayOfByte = this.hex;
        j = i - 1;
        arrayOfByte[j] = HttpConnection.HEX_DIGITS[((int)(0xF & paramLong))];
        l = paramLong >>> 4;
        i = j;
        paramLong = l;
      } while (l != 0L);
      HttpConnection.this.sink.write(this.hex, j, this.hex.length - j);
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 55	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 55	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:closed	Z
      //   19: aload_0
      //   20: getfield 19	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/HttpConnection;
      //   23: invokestatic 45	com/squareup/okhttp/internal/http/HttpConnection:access$200	(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lcom/squareup/okio/BufferedSink;
      //   26: invokestatic 58	com/squareup/okhttp/internal/http/HttpConnection:access$400	()[B
      //   29: invokeinterface 61 2 0
      //   34: pop
      //   35: aload_0
      //   36: getfield 19	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/HttpConnection;
      //   39: iconst_3
      //   40: invokestatic 65	com/squareup/okhttp/internal/http/HttpConnection:access$302	(Lcom/squareup/okhttp/internal/http/HttpConnection;I)I
      //   43: pop
      //   44: goto -33 -> 11
      //   47: astore_2
      //   48: aload_0
      //   49: monitorexit
      //   50: aload_2
      //   51: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	52	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   47	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	47	finally
      //   14	44	47	finally
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 55	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 19	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/HttpConnection;
      //   18: invokestatic 45	com/squareup/okhttp/internal/http/HttpConnection:access$200	(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lcom/squareup/okio/BufferedSink;
      //   21: invokeinterface 68 1 0
      //   26: goto -15 -> 11
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   29	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
    
    public Timeout timeout()
    {
      return HttpConnection.this.sink.timeout();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      writeHex(paramLong);
      HttpConnection.this.sink.write(paramBuffer, paramLong);
      HttpConnection.this.sink.writeUtf8("\r\n");
    }
  }
  
  private class ChunkedSource
    extends HttpConnection.AbstractSource
    implements Source
  {
    private static final int NO_CHUNK_YET = -1;
    private int bytesRemainingInChunk = -1;
    private boolean hasMoreChunks = true;
    private final HttpEngine httpEngine;
    
    ChunkedSource(CacheRequest paramCacheRequest, HttpEngine paramHttpEngine)
      throws IOException
    {
      super(paramCacheRequest);
      this.httpEngine = paramHttpEngine;
    }
    
    private void readChunkSize()
      throws IOException
    {
      if (this.bytesRemainingInChunk != -1) {
        HttpConnection.this.source.readUtf8LineStrict();
      }
      String str = HttpConnection.this.source.readUtf8LineStrict();
      int i = str.indexOf(";");
      Object localObject = str;
      if (i != -1) {
        localObject = str.substring(0, i);
      }
      try
      {
        this.bytesRemainingInChunk = Integer.parseInt(((String)localObject).trim(), 16);
        if (this.bytesRemainingInChunk == 0)
        {
          this.hasMoreChunks = false;
          localObject = new Headers.Builder();
          HttpConnection.this.readHeaders((Headers.Builder)localObject);
          this.httpEngine.receiveHeaders(((Headers.Builder)localObject).build());
          endOfInput(true);
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException("Expected a hex chunk size but was " + (String)localObject);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.hasMoreChunks) && (!HttpConnection.this.discard(this, 100))) {
        unexpectedEndOfInput();
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (!this.hasMoreChunks) {
        return -1L;
      }
      if ((this.bytesRemainingInChunk == 0) || (this.bytesRemainingInChunk == -1))
      {
        readChunkSize();
        if (!this.hasMoreChunks) {
          return -1L;
        }
      }
      paramLong = HttpConnection.this.source.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
      if (paramLong == -1L)
      {
        unexpectedEndOfInput();
        throw new IOException("unexpected end of stream");
      }
      this.bytesRemainingInChunk = ((int)(this.bytesRemainingInChunk - paramLong));
      cacheWrite(paramBuffer, paramLong);
      return paramLong;
    }
    
    public Timeout timeout()
    {
      return HttpConnection.this.source.timeout();
    }
  }
  
  private final class FixedLengthSink
    implements Sink
  {
    private long bytesRemaining;
    private boolean closed;
    
    private FixedLengthSink(long paramLong)
    {
      this.bytesRemaining = paramLong;
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      this.closed = true;
      if (this.bytesRemaining > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      HttpConnection.access$302(HttpConnection.this, 3);
    }
    
    public void flush()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      HttpConnection.this.sink.flush();
    }
    
    public Timeout timeout()
    {
      return HttpConnection.this.sink.timeout();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      if (paramLong > this.bytesRemaining) {
        throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + paramLong);
      }
      HttpConnection.this.sink.write(paramBuffer, paramLong);
      this.bytesRemaining -= paramLong;
    }
  }
  
  private class FixedLengthSource
    extends HttpConnection.AbstractSource
    implements Source
  {
    private long bytesRemaining;
    
    public FixedLengthSource(CacheRequest paramCacheRequest, long paramLong)
      throws IOException
    {
      super(paramCacheRequest);
      this.bytesRemaining = paramLong;
      if (this.bytesRemaining == 0L) {
        endOfInput(true);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.bytesRemaining != 0L) && (!HttpConnection.this.discard(this, 100))) {
        unexpectedEndOfInput();
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (this.bytesRemaining == 0L) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = HttpConnection.this.source.read(paramBuffer, Math.min(this.bytesRemaining, paramLong));
        if (l == -1L)
        {
          unexpectedEndOfInput();
          throw new ProtocolException("unexpected end of stream");
        }
        this.bytesRemaining -= l;
        cacheWrite(paramBuffer, l);
        paramLong = l;
      } while (this.bytesRemaining != 0L);
      endOfInput(true);
      return l;
    }
    
    public Timeout timeout()
    {
      return HttpConnection.this.source.timeout();
    }
  }
  
  class UnknownLengthSource
    extends HttpConnection.AbstractSource
    implements Source
  {
    private boolean inputExhausted;
    
    UnknownLengthSource(CacheRequest paramCacheRequest)
      throws IOException
    {
      super(paramCacheRequest);
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if (!this.inputExhausted) {
        unexpectedEndOfInput();
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (this.inputExhausted) {
        return -1L;
      }
      paramLong = HttpConnection.this.source.read(paramBuffer, paramLong);
      if (paramLong == -1L)
      {
        this.inputExhausted = true;
        endOfInput(false);
        return -1L;
      }
      cacheWrite(paramBuffer, paramLong);
      return paramLong;
    }
    
    public Timeout timeout()
    {
      return HttpConnection.this.source.timeout();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/http/HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */