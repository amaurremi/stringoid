package com.squareup.okhttp.internal.spdy;

import com.squareup.okio.AsyncTimeout;
import com.squareup.okio.Buffer;
import com.squareup.okio.BufferedSource;
import com.squareup.okio.Sink;
import com.squareup.okio.Source;
import com.squareup.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public final class SpdyStream
{
  long bytesLeftInWriteWindow;
  private final SpdyConnection connection;
  private ErrorCode errorCode = null;
  private final int id;
  private final SpdyTimeout readTimeout = new SpdyTimeout();
  private long readTimeoutMillis = 0L;
  private final List<Header> requestHeaders;
  private List<Header> responseHeaders;
  final SpdyDataSink sink;
  private final SpdyDataSource source;
  long unacknowledgedBytesRead = 0L;
  private final SpdyTimeout writeTimeout = new SpdyTimeout();
  
  static
  {
    if (!SpdyStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  SpdyStream(int paramInt, SpdyConnection paramSpdyConnection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList)
  {
    if (paramSpdyConnection == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.id = paramInt;
    this.connection = paramSpdyConnection;
    this.bytesLeftInWriteWindow = paramSpdyConnection.peerSettings.getInitialWindowSize(65536);
    this.source = new SpdyDataSource(paramSpdyConnection.okHttpSettings.getInitialWindowSize(65536), null);
    this.sink = new SpdyDataSink();
    SpdyDataSource.access$102(this.source, paramBoolean2);
    SpdyDataSink.access$202(this.sink, paramBoolean1);
    this.requestHeaders = paramList;
  }
  
  private void cancelStreamIfNecessary()
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.source.finished) && (this.source.closed))
        {
          if (this.sink.finished) {
            break label112;
          }
          if (this.sink.closed)
          {
            break label112;
            bool = isOpen();
            if (i == 0) {
              break label95;
            }
            close(ErrorCode.CANCEL);
            return;
          }
        }
        i = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.connection.removeStream(this.id);
      return;
      label112:
      int i = 1;
    }
  }
  
  private void checkOutNotClosed()
    throws IOException
  {
    if (this.sink.closed) {
      throw new IOException("stream closed");
    }
    if (this.sink.finished) {
      throw new IOException("stream finished");
    }
    if (this.errorCode != null) {
      throw new IOException("stream was reset: " + this.errorCode);
    }
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      if (this.errorCode != null) {
        return false;
      }
      if ((this.source.finished) && (this.sink.finished)) {
        return false;
      }
    }
    finally {}
    this.errorCode = paramErrorCode;
    notifyAll();
    this.connection.removeStream(this.id);
    return true;
  }
  
  private void waitForIo()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void close(ErrorCode paramErrorCode)
    throws IOException
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynReset(this.id, paramErrorCode);
  }
  
  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }
  
  public SpdyConnection getConnection()
  {
    return this.connection;
  }
  
  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public List<Header> getRequestHeaders()
  {
    return this.requestHeaders;
  }
  
  /* Error */
  public List<Header> getResponseHeaders()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;
    //   6: invokevirtual 239	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout:enter	()V
    //   9: aload_0
    //   10: getfield 241	com/squareup/okhttp/internal/spdy/SpdyStream:responseHeaders	Ljava/util/List;
    //   13: ifnonnull +32 -> 45
    //   16: aload_0
    //   17: getfield 66	com/squareup/okhttp/internal/spdy/SpdyStream:errorCode	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
    //   20: ifnonnull +25 -> 45
    //   23: aload_0
    //   24: invokespecial 143	com/squareup/okhttp/internal/spdy/SpdyStream:waitForIo	()V
    //   27: goto -18 -> 9
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 62	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;
    //   35: invokevirtual 244	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout:exitAndThrowIfTimedOut	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: aload_0
    //   46: getfield 62	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;
    //   49: invokevirtual 244	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout:exitAndThrowIfTimedOut	()V
    //   52: aload_0
    //   53: getfield 241	com/squareup/okhttp/internal/spdy/SpdyStream:responseHeaders	Ljava/util/List;
    //   56: ifnull +12 -> 68
    //   59: aload_0
    //   60: getfield 241	com/squareup/okhttp/internal/spdy/SpdyStream:responseHeaders	Ljava/util/List;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new 120	java/io/IOException
    //   71: dup
    //   72: new 189	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   79: ldc -64
    //   81: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: getfield 66	com/squareup/okhttp/internal/spdy/SpdyStream:errorCode	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
    //   88: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 185	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	SpdyStream
    //   30	9	1	localObject1	Object
    //   40	4	1	localObject2	Object
    //   63	4	1	localList	List
    // Exception table:
    //   from	to	target	type
    //   9	27	30	finally
    //   2	9	40	finally
    //   31	40	40	finally
    //   45	64	40	finally
    //   68	98	40	finally
  }
  
  public Sink getSink()
  {
    try
    {
      if ((this.responseHeaders == null) && (!isLocallyInitiated())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.sink;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    if ((this.id & 0x1) == 1) {}
    for (int i = 1; this.connection.client == i; i = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public boolean isOpen()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 66	com/squareup/okhttp/internal/spdy/SpdyStream:errorCode	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 102	com/squareup/okhttp/internal/spdy/SpdyStream:source	Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource;
    //   21: invokestatic 156	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:access$100	(Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 102	com/squareup/okhttp/internal/spdy/SpdyStream:source	Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource;
    //   31: invokestatic 159	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:access$300	(Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource;)Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 105	com/squareup/okhttp/internal/spdy/SpdyStream:sink	Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSink;
    //   41: invokestatic 163	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSink:access$200	(Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSink;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 105	com/squareup/okhttp/internal/spdy/SpdyStream:sink	Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSink;
    //   51: invokestatic 166	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSink:access$400	(Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSink;)Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 241	com/squareup/okhttp/internal/spdy/SpdyStream:responseHeaders	Ljava/util/List;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	SpdyStream
    //   1	67	1	bool	boolean
    //   8	55	2	localObject1	Object
    //   71	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin()
  {
    assert (!Thread.holdsLock(this));
    try
    {
      SpdyDataSource.access$102(this.source, true);
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveHeaders(List<Header> paramList, HeadersMode paramHeadersMode)
  {
    assert (!Thread.holdsLock(this));
    Object localObject = null;
    boolean bool = true;
    label97:
    do
    {
      for (;;)
      {
        try
        {
          if (this.responseHeaders == null)
          {
            if (paramHeadersMode.failIfHeadersAbsent())
            {
              paramList = ErrorCode.PROTOCOL_ERROR;
              if (paramList == null) {
                break;
              }
              closeLater(paramList);
              return;
            }
            this.responseHeaders = paramList;
            bool = isOpen();
            notifyAll();
            paramList = (List<Header>)localObject;
            continue;
          }
          if (!paramHeadersMode.failIfHeadersPresent()) {
            break label97;
          }
        }
        finally {}
        paramList = ErrorCode.STREAM_IN_USE;
        continue;
        paramHeadersMode = new ArrayList();
        paramHeadersMode.addAll(this.responseHeaders);
        paramHeadersMode.addAll(paramList);
        this.responseHeaders = paramHeadersMode;
        paramList = (List<Header>)localObject;
      }
    } while (bool);
    this.connection.removeStream(this.id);
  }
  
  void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public void reply(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    boolean bool = false;
    if (paramList == null) {
      try
      {
        throw new NullPointerException("responseHeaders == null");
      }
      finally {}
    }
    if (this.responseHeaders != null) {
      throw new IllegalStateException("reply already sent");
    }
    this.responseHeaders = paramList;
    if (!paramBoolean)
    {
      SpdyDataSink.access$202(this.sink, true);
      bool = true;
    }
    this.connection.writeSynReply(this.id, bool, paramList);
    if (bool) {
      this.connection.flush();
    }
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
  
  final class SpdyDataSink
    implements Sink
  {
    private boolean closed;
    private boolean finished;
    
    static
    {
      if (!SpdyStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    SpdyDataSink() {}
    
    public void close()
      throws IOException
    {
      assert (!Thread.holdsLock(SpdyStream.this));
      synchronized (SpdyStream.this)
      {
        if (this.closed) {
          return;
        }
        if (!SpdyStream.this.sink.finished) {
          SpdyStream.this.connection.writeData(SpdyStream.this.id, true, null, 0L);
        }
      }
      synchronized (SpdyStream.this)
      {
        this.closed = true;
        SpdyStream.this.connection.flush();
        SpdyStream.this.cancelStreamIfNecessary();
        return;
        localObject1 = finally;
        throw ((Throwable)localObject1);
      }
    }
    
    public void flush()
      throws IOException
    {
      assert (!Thread.holdsLock(SpdyStream.this));
      synchronized (SpdyStream.this)
      {
        SpdyStream.this.checkOutNotClosed();
        SpdyStream.this.connection.flush();
        return;
      }
    }
    
    public Timeout timeout()
    {
      return SpdyStream.this.writeTimeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      long l = paramLong;
      if (!$assertionsDisabled)
      {
        l = paramLong;
        if (Thread.holdsLock(SpdyStream.this)) {
          throw new AssertionError();
        }
      }
      SpdyStream localSpdyStream1;
      try
      {
        SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
        SpdyStream.this.checkOutNotClosed();
        paramLong = Math.min(SpdyStream.this.bytesLeftInWriteWindow, l);
        SpdyStream localSpdyStream2 = SpdyStream.this;
        localSpdyStream2.bytesLeftInWriteWindow -= paramLong;
        l -= paramLong;
        SpdyStream.this.connection.writeData(SpdyStream.this.id, false, paramBuffer, paramLong);
        if (l > 0L)
        {
          localSpdyStream1 = SpdyStream.this;
          SpdyStream.this.writeTimeout.enter();
        }
      }
      finally
      {
        try
        {
          for (;;)
          {
            if ((SpdyStream.this.bytesLeftInWriteWindow <= 0L) && (!this.finished) && (!this.closed) && (SpdyStream.this.errorCode == null)) {
              SpdyStream.this.waitForIo();
            }
          }
        }
        finally
        {
          SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
        }
      }
    }
  }
  
  private final class SpdyDataSource
    implements Source
  {
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer = new Buffer();
    private final Buffer receiveBuffer = new Buffer();
    
    static
    {
      if (!SpdyStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    private SpdyDataSource(long paramLong)
    {
      this.maxByteCount = paramLong;
    }
    
    private void checkNotClosed()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("stream closed");
      }
      if (SpdyStream.this.errorCode != null) {
        throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
      }
    }
    
    /* Error */
    private void waitUntilReadable()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 35	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   4: invokestatic 92	com/squareup/okhttp/internal/spdy/SpdyStream:access$700	(Lcom/squareup/okhttp/internal/spdy/SpdyStream;)Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;
      //   7: invokevirtual 97	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout:enter	()V
      //   10: aload_0
      //   11: getfield 44	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:readBuffer	Lcom/squareup/okio/Buffer;
      //   14: invokevirtual 101	com/squareup/okio/Buffer:size	()J
      //   17: lconst_0
      //   18: lcmp
      //   19: ifne +50 -> 69
      //   22: aload_0
      //   23: getfield 53	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:finished	Z
      //   26: ifne +43 -> 69
      //   29: aload_0
      //   30: getfield 58	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:closed	Z
      //   33: ifne +36 -> 69
      //   36: aload_0
      //   37: getfield 35	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   40: invokestatic 70	com/squareup/okhttp/internal/spdy/SpdyStream:access$800	(Lcom/squareup/okhttp/internal/spdy/SpdyStream;)Lcom/squareup/okhttp/internal/spdy/ErrorCode;
      //   43: ifnonnull +26 -> 69
      //   46: aload_0
      //   47: getfield 35	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   50: invokestatic 105	com/squareup/okhttp/internal/spdy/SpdyStream:access$900	(Lcom/squareup/okhttp/internal/spdy/SpdyStream;)V
      //   53: goto -43 -> 10
      //   56: astore_1
      //   57: aload_0
      //   58: getfield 35	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   61: invokestatic 92	com/squareup/okhttp/internal/spdy/SpdyStream:access$700	(Lcom/squareup/okhttp/internal/spdy/SpdyStream;)Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;
      //   64: invokevirtual 108	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout:exitAndThrowIfTimedOut	()V
      //   67: aload_1
      //   68: athrow
      //   69: aload_0
      //   70: getfield 35	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyDataSource:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   73: invokestatic 92	com/squareup/okhttp/internal/spdy/SpdyStream:access$700	(Lcom/squareup/okhttp/internal/spdy/SpdyStream;)Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;
      //   76: invokevirtual 108	com/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout:exitAndThrowIfTimedOut	()V
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	SpdyDataSource
      //   56	12	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   10	53	56	finally
    }
    
    public void close()
      throws IOException
    {
      synchronized (SpdyStream.this)
      {
        this.closed = true;
        this.readBuffer.clear();
        SpdyStream.this.notifyAll();
        SpdyStream.this.cancelStreamIfNecessary();
        return;
      }
    }
    
    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      synchronized (SpdyStream.this)
      {
        waitUntilReadable();
        checkNotClosed();
        if (this.readBuffer.size() == 0L) {
          return -1L;
        }
        paramLong = this.readBuffer.read(???, Math.min(paramLong, this.readBuffer.size()));
        ??? = SpdyStream.this;
        ???.unacknowledgedBytesRead += paramLong;
        if (SpdyStream.this.unacknowledgedBytesRead >= SpdyStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)
        {
          SpdyStream.this.connection.writeWindowUpdateLater(SpdyStream.this.id, SpdyStream.this.unacknowledgedBytesRead);
          SpdyStream.this.unacknowledgedBytesRead = 0L;
        }
        synchronized (SpdyStream.this.connection)
        {
          ??? = SpdyStream.this.connection;
          ((SpdyConnection)???).unacknowledgedBytesRead += paramLong;
          if (SpdyStream.this.connection.unacknowledgedBytesRead >= SpdyStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)
          {
            SpdyStream.this.connection.writeWindowUpdateLater(0, SpdyStream.this.connection.unacknowledgedBytesRead);
            SpdyStream.this.connection.unacknowledgedBytesRead = 0L;
          }
          return paramLong;
        }
      }
    }
    
    void receive(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      long l = paramLong;
      if (!$assertionsDisabled)
      {
        l = paramLong;
        if (Thread.holdsLock(SpdyStream.this)) {
          throw new AssertionError();
        }
      }
      for (;;)
      {
        l -= paramLong;
        synchronized (SpdyStream.this)
        {
          if (this.readBuffer.size() == 0L)
          {
            i = 1;
            this.readBuffer.writeAll(this.receiveBuffer);
            if (i != 0) {
              SpdyStream.this.notifyAll();
            }
            if (l > 0L) {}
            boolean bool;
            synchronized (SpdyStream.this)
            {
              bool = this.finished;
              if (this.readBuffer.size() + l > this.maxByteCount)
              {
                i = 1;
                if (i != 0)
                {
                  paramBufferedSource.skip(l);
                  SpdyStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramBufferedSource.skip(l);
              return;
            }
            paramLong = paramBufferedSource.read(this.receiveBuffer, l);
            if (paramLong != -1L) {
              continue;
            }
            throw new EOFException();
          }
          int i = 0;
        }
      }
    }
    
    public Timeout timeout()
    {
      return SpdyStream.this.readTimeout;
    }
  }
  
  class SpdyTimeout
    extends AsyncTimeout
  {
    SpdyTimeout() {}
    
    public void exitAndThrowIfTimedOut()
      throws InterruptedIOException
    {
      if (exit()) {
        throw new InterruptedIOException("timeout");
      }
    }
    
    protected void timedOut()
    {
      SpdyStream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/spdy/SpdyStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */