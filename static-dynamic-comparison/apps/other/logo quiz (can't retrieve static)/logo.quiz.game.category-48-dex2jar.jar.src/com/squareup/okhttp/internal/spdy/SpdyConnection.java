package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okio.Buffer;
import com.squareup.okio.BufferedSource;
import com.squareup.okio.ByteString;
import com.squareup.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class SpdyConnection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService executor;
  long bytesLeftInWriteWindow;
  final boolean client;
  private final Set<Integer> currentPushRequests = new LinkedHashSet();
  final FrameWriter frameWriter;
  private final IncomingStreamHandler handler;
  private final String hostName;
  private long idleStartTimeNs = System.nanoTime();
  private int lastGoodStreamId;
  final long maxFrameSize;
  private int nextPingId;
  private int nextStreamId;
  final Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private Map<Integer, Ping> pings;
  final Protocol protocol;
  private final ExecutorService pushExecutor;
  private final PushObserver pushObserver;
  final Reader readerRunnable;
  private boolean receivedInitialPeerSettings = false;
  private boolean shutdown;
  final Socket socket;
  private final Map<Integer, SpdyStream> streams = new HashMap();
  long unacknowledgedBytesRead = 0L;
  final Variant variant;
  
  static
  {
    if (!SpdyConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp SpdyConnection", true));
      return;
    }
  }
  
  private SpdyConnection(Builder paramBuilder)
    throws IOException
  {
    this.protocol = paramBuilder.protocol;
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.handler = paramBuilder.handler;
    int i;
    if (paramBuilder.client)
    {
      i = 1;
      this.nextStreamId = i;
      if ((paramBuilder.client) && (this.protocol == Protocol.HTTP_2)) {
        this.nextStreamId += 2;
      }
      i = j;
      if (paramBuilder.client) {
        i = 1;
      }
      this.nextPingId = i;
      if (paramBuilder.client) {
        this.okHttpSettings.set(7, 0, 16777216);
      }
      this.hostName = paramBuilder.hostName;
      if (this.protocol != Protocol.HTTP_2) {
        break label345;
      }
      this.variant = new Http20Draft12();
    }
    for (this.pushExecutor = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] { this.hostName }), true));; this.pushExecutor = null)
    {
      this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
      this.socket = paramBuilder.socket;
      this.frameWriter = this.variant.newWriter(Okio.buffer(Okio.sink(paramBuilder.socket)), this.client);
      this.maxFrameSize = this.variant.maxFrameSize();
      this.readerRunnable = new Reader(null);
      new Thread(this.readerRunnable).start();
      return;
      i = 2;
      break;
      label345:
      if (this.protocol != Protocol.SPDY_3) {
        break label374;
      }
      this.variant = new Spdy3();
    }
    label374:
    throw new AssertionError(this.protocol);
  }
  
  private void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    Object localObject = null;
    try
    {
      shutdown(paramErrorCode1);
      paramErrorCode1 = (ErrorCode)localObject;
    }
    catch (IOException paramErrorCode1)
    {
      SpdyStream[] arrayOfSpdyStream;
      for (;;) {}
    }
    arrayOfSpdyStream = null;
    Ping[] arrayOfPing = null;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (!this.streams.isEmpty())
        {
          arrayOfSpdyStream = (SpdyStream[])this.streams.values().toArray(new SpdyStream[this.streams.size()]);
          this.streams.clear();
          setIdle(false);
        }
        if (this.pings != null)
        {
          arrayOfPing = (Ping[])this.pings.values().toArray(new Ping[this.pings.size()]);
          this.pings = null;
        }
        localObject = paramErrorCode1;
        if (arrayOfSpdyStream == null) {
          break label216;
        }
        j = arrayOfSpdyStream.length;
        i = 0;
        localObject = paramErrorCode1;
        if (i >= j) {
          break label216;
        }
        localObject = arrayOfSpdyStream[i];
      }
      finally {}
      try
      {
        ((SpdyStream)localObject).close(paramErrorCode2);
        localObject = paramErrorCode1;
      }
      catch (IOException localIOException)
      {
        localObject = paramErrorCode1;
        if (paramErrorCode1 == null) {
          continue;
        }
        localObject = localIOException;
        continue;
      }
      i += 1;
      paramErrorCode1 = (ErrorCode)localObject;
    }
    label216:
    if (arrayOfPing != null)
    {
      j = arrayOfPing.length;
      i = 0;
      while (i < j)
      {
        arrayOfPing[i].cancel();
        i += 1;
      }
    }
    try
    {
      this.frameWriter.close();
      paramErrorCode1 = (ErrorCode)localObject;
      return;
    }
    catch (IOException paramErrorCode2)
    {
      try
      {
        for (;;)
        {
          this.socket.close();
          if (paramErrorCode1 == null) {
            break;
          }
          throw paramErrorCode1;
          paramErrorCode2 = paramErrorCode2;
          paramErrorCode1 = (ErrorCode)localObject;
          if (localObject == null) {
            paramErrorCode1 = paramErrorCode2;
          }
        }
      }
      catch (IOException paramErrorCode1)
      {
        for (;;) {}
      }
    }
  }
  
  private SpdyStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramBoolean1)
    {
      bool1 = true;
      if (paramBoolean2) {
        break label65;
      }
    }
    label65:
    for (paramBoolean2 = bool2;; paramBoolean2 = false)
    {
      synchronized (this.frameWriter)
      {
        try
        {
          if (!this.shutdown) {
            break label71;
          }
          throw new IOException("shutdown");
        }
        finally {}
      }
      bool1 = false;
      break;
    }
    label71:
    int i = this.nextStreamId;
    this.nextStreamId += 2;
    SpdyStream localSpdyStream = new SpdyStream(i, this, bool1, paramBoolean2, paramList);
    if (localSpdyStream.isOpen())
    {
      this.streams.put(Integer.valueOf(i), localSpdyStream);
      setIdle(false);
    }
    if (paramInt == 0) {
      this.frameWriter.synStream(bool1, paramBoolean2, i, paramInt, paramList);
    }
    for (;;)
    {
      if (!paramBoolean1) {
        this.frameWriter.flush();
      }
      return localSpdyStream;
      if (this.client) {
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
      }
      this.frameWriter.pushPromise(paramInt, i, paramList);
    }
  }
  
  private void pushDataLater(final int paramInt1, BufferedSource paramBufferedSource, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    final Buffer localBuffer = new Buffer();
    paramBufferedSource.require(paramInt2);
    paramBufferedSource.read(localBuffer, paramInt2);
    if (localBuffer.size() != paramInt2) {
      throw new IOException(localBuffer.size() + " != " + paramInt2);
    }
    this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt1) })
    {
      public void execute()
      {
        try
        {
          boolean bool = SpdyConnection.this.pushObserver.onData(paramInt1, localBuffer, paramInt2, paramBoolean);
          if (bool) {
            SpdyConnection.this.frameWriter.rstStream(paramInt1, ErrorCode.CANCEL);
          }
          if ((bool) || (paramBoolean)) {
            synchronized (SpdyConnection.this)
            {
              SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt1));
              return;
            }
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  private void pushHeadersLater(final int paramInt, final List<Header> paramList, final boolean paramBoolean)
  {
    this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        boolean bool = SpdyConnection.this.pushObserver.onHeaders(paramInt, paramList, paramBoolean);
        if (bool) {}
        try
        {
          SpdyConnection.this.frameWriter.rstStream(paramInt, ErrorCode.CANCEL);
          if ((bool) || (paramBoolean)) {
            synchronized (SpdyConnection.this)
            {
              SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
              return;
            }
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  private void pushRequestLater(final int paramInt, final List<Header> paramList)
  {
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) })
      {
        public void execute()
        {
          if (SpdyConnection.this.pushObserver.onRequest(paramInt, paramList)) {
            try
            {
              SpdyConnection.this.frameWriter.rstStream(paramInt, ErrorCode.CANCEL);
              synchronized (SpdyConnection.this)
              {
                SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
                return;
              }
              return;
            }
            catch (IOException localIOException) {}
          }
        }
      });
      return;
    }
    finally {}
  }
  
  private void pushResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        SpdyConnection.this.pushObserver.onReset(paramInt, paramErrorCode);
        synchronized (SpdyConnection.this)
        {
          SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }
  
  private boolean pushedStream(int paramInt)
  {
    return (this.protocol == Protocol.HTTP_2) && (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  /* Error */
  private Ping removePing(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 395	com/squareup/okhttp/internal/spdy/SpdyConnection:pings	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 395	com/squareup/okhttp/internal/spdy/SpdyConnection:pings	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 429	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 534 2 0
    //   22: checkcast 397	com/squareup/okhttp/internal/spdy/Ping
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	SpdyConnection
    //   0	40	1	paramInt	int
    //   25	7	2	localPing	Ping
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void setIdle(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l = System.nanoTime();
        this.idleStartTimeNs = l;
        return;
      }
      finally {}
      long l = Long.MAX_VALUE;
    }
  }
  
  private void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
    throws IOException
  {
    FrameWriter localFrameWriter = this.frameWriter;
    if (paramPing != null) {}
    try
    {
      paramPing.send();
      this.frameWriter.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  private void writePingLater(final boolean paramBoolean, final int paramInt1, final int paramInt2, final Ping paramPing)
  {
    executor.submit(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[] { this.hostName, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })
    {
      public void execute()
      {
        try
        {
          SpdyConnection.this.writePing(paramBoolean, paramInt1, paramInt2, paramPing);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush()
    throws IOException
  {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs()
  {
    try
    {
      long l = this.idleStartTimeNs;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  SpdyStream getStream(int paramInt)
  {
    try
    {
      SpdyStream localSpdyStream = (SpdyStream)this.streams.get(Integer.valueOf(paramInt));
      return localSpdyStream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean isIdle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 133	com/squareup/okhttp/internal/spdy/SpdyConnection:idleStartTimeNs	J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 535
    //   11: lcmp
    //   12: ifeq +9 -> 21
    //   15: iconst_1
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_3
    //   23: goto -6 -> 17
    //   26: astore 4
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 4
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	SpdyConnection
    //   6	2	1	l	long
    //   16	7	3	bool	boolean
    //   26	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public SpdyStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Ping ping()
    throws IOException
  {
    Ping localPing = new Ping();
    try
    {
      if (this.shutdown) {
        throw new IOException("shutdown");
      }
    }
    finally {}
    int i = this.nextPingId;
    this.nextPingId += 2;
    if (this.pings == null) {
      this.pings = new HashMap();
    }
    this.pings.put(Integer.valueOf(i), localObject);
    writePing(false, i, 1330343787, (Ping)localObject);
    return (Ping)localObject;
  }
  
  public SpdyStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.client) {
      throw new IllegalStateException("Client cannot push requests.");
    }
    if (this.protocol != Protocol.HTTP_2) {
      throw new IllegalStateException("protocol != HTTP_2");
    }
    return newStream(paramInt, paramList, paramBoolean, false);
  }
  
  SpdyStream removeStream(int paramInt)
  {
    try
    {
      SpdyStream localSpdyStream = (SpdyStream)this.streams.remove(Integer.valueOf(paramInt));
      if ((localSpdyStream != null) && (this.streams.isEmpty())) {
        setIdle(true);
      }
      return localSpdyStream;
    }
    finally {}
  }
  
  public void sendConnectionPreface()
    throws IOException
  {
    this.frameWriter.connectionPreface();
    this.frameWriter.settings(this.okHttpSettings);
    int i = this.okHttpSettings.getInitialWindowSize(65536);
    if (i != 65536) {
      this.frameWriter.windowUpdate(0, i - 65536);
    }
  }
  
  public void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    int i;
    synchronized (this.frameWriter) {}
  }
  
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
    throws IOException
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      this.frameWriter.data(paramBoolean, paramInt, paramBuffer, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i = (int)Math.min(Math.min(l, this.bytesLeftInWriteWindow), this.maxFrameSize);
        this.bytesLeftInWriteWindow -= i;
        l -= i;
        FrameWriter localFrameWriter = this.frameWriter;
        if ((paramBoolean) && (l == 0L))
        {
          bool = true;
          localFrameWriter.data(bool, paramInt, paramBuffer, i);
          if (l <= 0L) {
            break;
          }
          try
          {
            if (this.bytesLeftInWriteWindow > 0L) {
              continue;
            }
            wait();
            continue;
            paramBuffer = finally;
          }
          catch (InterruptedException paramBuffer)
          {
            throw new InterruptedIOException();
          }
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        try
        {
          SpdyConnection.this.writeSynReset(paramInt, paramErrorCode);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void writeWindowUpdateLater(final int paramInt, final long paramLong)
  {
    executor.submit(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        try
        {
          SpdyConnection.this.frameWriter.windowUpdate(paramInt, paramLong);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  public static class Builder
  {
    private boolean client;
    private IncomingStreamHandler handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
    private String hostName;
    private Protocol protocol = Protocol.SPDY_3;
    private PushObserver pushObserver = PushObserver.CANCEL;
    private Socket socket;
    
    public Builder(String paramString, boolean paramBoolean, Socket paramSocket)
      throws IOException
    {
      this.hostName = paramString;
      this.client = paramBoolean;
      this.socket = paramSocket;
    }
    
    public Builder(boolean paramBoolean, Socket paramSocket)
      throws IOException
    {
      this(((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), paramBoolean, paramSocket);
    }
    
    public SpdyConnection build()
      throws IOException
    {
      return new SpdyConnection(this, null);
    }
    
    public Builder handler(IncomingStreamHandler paramIncomingStreamHandler)
    {
      this.handler = paramIncomingStreamHandler;
      return this;
    }
    
    public Builder protocol(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
      return this;
    }
    
    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }
  }
  
  class Reader
    extends NamedRunnable
    implements FrameReader.Handler
  {
    FrameReader frameReader;
    
    private Reader()
    {
      super(new Object[] { SpdyConnection.this.hostName });
    }
    
    private void ackSettingsLater()
    {
      SpdyConnection.executor.submit(new NamedRunnable("OkHttp %s ACK Settings", new Object[] { SpdyConnection.this.hostName })
      {
        public void execute()
        {
          try
          {
            SpdyConnection.this.frameWriter.ackSettings();
            return;
          }
          catch (IOException localIOException) {}
        }
      });
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
    
    public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      if (SpdyConnection.this.pushedStream(paramInt1)) {
        SpdyConnection.this.pushDataLater(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
      }
      SpdyStream localSpdyStream;
      do
      {
        return;
        localSpdyStream = SpdyConnection.this.getStream(paramInt1);
        if (localSpdyStream == null)
        {
          SpdyConnection.this.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
          paramBufferedSource.skip(paramInt2);
          return;
        }
        localSpdyStream.receiveData(paramBufferedSource, paramInt2);
      } while (!paramBoolean);
      localSpdyStream.receiveFin();
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: getstatic 102	com/squareup/okhttp/internal/spdy/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
      //   3: astore_3
      //   4: getstatic 102	com/squareup/okhttp/internal/spdy/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 21	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
      //   18: getfield 106	com/squareup/okhttp/internal/spdy/SpdyConnection:variant	Lcom/squareup/okhttp/internal/spdy/Variant;
      //   21: aload_0
      //   22: getfield 21	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
      //   25: getfield 110	com/squareup/okhttp/internal/spdy/SpdyConnection:socket	Ljava/net/Socket;
      //   28: invokestatic 116	com/squareup/okio/Okio:source	(Ljava/net/Socket;)Lcom/squareup/okio/Source;
      //   31: invokestatic 120	com/squareup/okio/Okio:buffer	(Lcom/squareup/okio/Source;)Lcom/squareup/okio/BufferedSource;
      //   34: aload_0
      //   35: getfield 21	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
      //   38: getfield 124	com/squareup/okhttp/internal/spdy/SpdyConnection:client	Z
      //   41: invokeinterface 130 3 0
      //   46: putfield 132	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/spdy/FrameReader;
      //   49: aload_3
      //   50: astore_2
      //   51: aload_3
      //   52: astore_1
      //   53: aload_0
      //   54: getfield 21	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
      //   57: getfield 124	com/squareup/okhttp/internal/spdy/SpdyConnection:client	Z
      //   60: ifne +16 -> 76
      //   63: aload_3
      //   64: astore_2
      //   65: aload_3
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 132	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/spdy/FrameReader;
      //   71: invokeinterface 137 1 0
      //   76: aload_3
      //   77: astore_2
      //   78: aload_3
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 132	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/spdy/FrameReader;
      //   84: aload_0
      //   85: invokeinterface 141 2 0
      //   90: ifne -14 -> 76
      //   93: aload_3
      //   94: astore_2
      //   95: aload_3
      //   96: astore_1
      //   97: getstatic 144	com/squareup/okhttp/internal/spdy/ErrorCode:NO_ERROR	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
      //   100: astore_3
      //   101: aload_3
      //   102: astore_2
      //   103: aload_3
      //   104: astore_1
      //   105: getstatic 147	com/squareup/okhttp/internal/spdy/ErrorCode:CANCEL	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
      //   108: astore 5
      //   110: aload_0
      //   111: getfield 21	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
      //   114: aload_3
      //   115: aload 5
      //   117: invokestatic 151	com/squareup/okhttp/internal/spdy/SpdyConnection:access$1000	(Lcom/squareup/okhttp/internal/spdy/SpdyConnection;Lcom/squareup/okhttp/internal/spdy/ErrorCode;Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
      //   120: aload_0
      //   121: getfield 132	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/spdy/FrameReader;
      //   124: invokestatic 157	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   127: return
      //   128: astore_1
      //   129: aload_2
      //   130: astore_1
      //   131: getstatic 160	com/squareup/okhttp/internal/spdy/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
      //   134: astore_2
      //   135: aload_2
      //   136: astore_1
      //   137: getstatic 160	com/squareup/okhttp/internal/spdy/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/spdy/ErrorCode;
      //   140: astore_3
      //   141: aload_0
      //   142: getfield 21	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
      //   145: aload_2
      //   146: aload_3
      //   147: invokestatic 151	com/squareup/okhttp/internal/spdy/SpdyConnection:access$1000	(Lcom/squareup/okhttp/internal/spdy/SpdyConnection;Lcom/squareup/okhttp/internal/spdy/ErrorCode;Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
      //   150: aload_0
      //   151: getfield 132	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/spdy/FrameReader;
      //   154: invokestatic 157	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   157: return
      //   158: astore_2
      //   159: aload_0
      //   160: getfield 21	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:this$0	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
      //   163: aload_1
      //   164: aload 4
      //   166: invokestatic 151	com/squareup/okhttp/internal/spdy/SpdyConnection:access$1000	(Lcom/squareup/okhttp/internal/spdy/SpdyConnection;Lcom/squareup/okhttp/internal/spdy/ErrorCode;Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
      //   169: aload_0
      //   170: getfield 132	com/squareup/okhttp/internal/spdy/SpdyConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/spdy/FrameReader;
      //   173: invokestatic 157	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   176: aload_2
      //   177: athrow
      //   178: astore_1
      //   179: goto -10 -> 169
      //   182: astore_1
      //   183: goto -33 -> 150
      //   186: astore_1
      //   187: goto -67 -> 120
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	190	0	this	Reader
      //   12	93	1	localErrorCode1	ErrorCode
      //   128	1	1	localIOException1	IOException
      //   130	34	1	localErrorCode2	ErrorCode
      //   178	1	1	localIOException2	IOException
      //   182	1	1	localIOException3	IOException
      //   186	1	1	localIOException4	IOException
      //   10	136	2	localErrorCode3	ErrorCode
      //   158	19	2	localObject	Object
      //   3	144	3	localErrorCode4	ErrorCode
      //   7	158	4	localErrorCode5	ErrorCode
      //   108	8	5	localErrorCode6	ErrorCode
      // Exception table:
      //   from	to	target	type
      //   13	49	128	java/io/IOException
      //   53	63	128	java/io/IOException
      //   67	76	128	java/io/IOException
      //   80	93	128	java/io/IOException
      //   97	101	128	java/io/IOException
      //   105	110	128	java/io/IOException
      //   13	49	158	finally
      //   53	63	158	finally
      //   67	76	158	finally
      //   80	93	158	finally
      //   97	101	158	finally
      //   105	110	158	finally
      //   131	135	158	finally
      //   137	141	158	finally
      //   159	169	178	java/io/IOException
      //   141	150	182	java/io/IOException
      //   110	120	186	java/io/IOException
    }
    
    public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      if (paramByteString.size() > 0) {}
      synchronized (SpdyConnection.this)
      {
        SpdyConnection.access$1402(SpdyConnection.this, true);
        paramByteString = SpdyConnection.this.streams.entrySet().iterator();
        while (paramByteString.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramByteString.next();
          if ((((Integer)localEntry.getKey()).intValue() > paramInt) && (((SpdyStream)localEntry.getValue()).isLocallyInitiated()))
          {
            ((SpdyStream)localEntry.getValue()).receiveRstStream(ErrorCode.REFUSED_STREAM);
            paramByteString.remove();
          }
        }
      }
    }
    
    public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, final List<Header> paramList, HeadersMode paramHeadersMode)
    {
      if (SpdyConnection.this.pushedStream(paramInt1)) {
        SpdyConnection.this.pushHeadersLater(paramInt1, paramList, paramBoolean2);
      }
      SpdyStream localSpdyStream;
      do
      {
        return;
        synchronized (SpdyConnection.this)
        {
          if (SpdyConnection.this.shutdown) {
            return;
          }
        }
        localSpdyStream = SpdyConnection.this.getStream(paramInt1);
        if (localSpdyStream == null)
        {
          if (paramHeadersMode.failIfStreamAbsent())
          {
            SpdyConnection.this.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
            return;
          }
          if (paramInt1 <= SpdyConnection.this.lastGoodStreamId) {
            return;
          }
          if (paramInt1 % 2 == SpdyConnection.this.nextStreamId % 2) {
            return;
          }
          paramList = new SpdyStream(paramInt1, SpdyConnection.this, paramBoolean1, paramBoolean2, paramList);
          SpdyConnection.access$1502(SpdyConnection.this, paramInt1);
          SpdyConnection.this.streams.put(Integer.valueOf(paramInt1), paramList);
          SpdyConnection.executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[] { SpdyConnection.this.hostName, Integer.valueOf(paramInt1) })
          {
            public void execute()
            {
              try
              {
                SpdyConnection.this.handler.receive(paramList);
                return;
              }
              catch (IOException localIOException)
              {
                throw new RuntimeException(localIOException);
              }
            }
          });
          return;
        }
        if (paramHeadersMode.failIfStreamPresent())
        {
          localSpdyStream.closeLater(ErrorCode.PROTOCOL_ERROR);
          SpdyConnection.this.removeStream(paramInt1);
          return;
        }
        localSpdyStream.receiveHeaders(paramList, paramHeadersMode);
      } while (!paramBoolean2);
      localSpdyStream.receiveFin();
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        Ping localPing = SpdyConnection.this.removePing(paramInt1);
        if (localPing != null) {
          localPing.receive();
        }
        return;
      }
      SpdyConnection.this.writePingLater(true, paramInt1, paramInt2, null);
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      SpdyConnection.this.pushRequestLater(paramInt2, paramList);
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      if (SpdyConnection.this.pushedStream(paramInt)) {
        SpdyConnection.this.pushResetLater(paramInt, paramErrorCode);
      }
      SpdyStream localSpdyStream;
      do
      {
        return;
        localSpdyStream = SpdyConnection.this.removeStream(paramInt);
      } while (localSpdyStream == null);
      localSpdyStream.receiveRstStream(paramErrorCode);
    }
    
    public void settings(boolean paramBoolean, Settings arg2)
    {
      long l2 = 0L;
      Iterator localIterator = null;
      synchronized (SpdyConnection.this)
      {
        int i = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
        if (paramBoolean) {
          SpdyConnection.this.peerSettings.clear();
        }
        SpdyConnection.this.peerSettings.merge(???);
        if (SpdyConnection.this.getProtocol() == Protocol.HTTP_2) {
          ackSettingsLater();
        }
        int j = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
        long l1 = l2;
        ??? = localIterator;
        if (j != -1)
        {
          l1 = l2;
          ??? = localIterator;
          if (j != i)
          {
            l2 = j - i;
            if (!SpdyConnection.this.receivedInitialPeerSettings)
            {
              SpdyConnection.this.addBytesToWriteWindow(l2);
              SpdyConnection.access$2102(SpdyConnection.this, true);
            }
            l1 = l2;
            ??? = localIterator;
            if (!SpdyConnection.this.streams.isEmpty())
            {
              ??? = (SpdyStream[])SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
              l1 = l2;
            }
          }
        }
        if ((??? != null) && (l1 != 0L))
        {
          localIterator = SpdyConnection.this.streams.values().iterator();
          while (localIterator.hasNext()) {
            synchronized ((SpdyStream)localIterator.next())
            {
              ???.addBytesToWriteWindow(l1);
            }
          }
        }
      }
    }
    
    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (SpdyConnection.this)
        {
          SpdyConnection localSpdyConnection = SpdyConnection.this;
          localSpdyConnection.bytesLeftInWriteWindow += paramLong;
          SpdyConnection.this.notifyAll();
          return;
        }
      }
      ??? = SpdyConnection.this.getStream(paramInt);
      if (??? != null) {
        try
        {
          ((SpdyStream)???).addBytesToWriteWindow(paramLong);
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/spdy/SpdyConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */