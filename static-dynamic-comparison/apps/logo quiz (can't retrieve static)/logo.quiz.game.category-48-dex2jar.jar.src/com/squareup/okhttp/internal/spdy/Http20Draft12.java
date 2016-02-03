package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okio.Buffer;
import com.squareup.okio.BufferedSink;
import com.squareup.okio.BufferedSource;
import com.squareup.okio.ByteString;
import com.squareup.okio.Source;
import com.squareup.okio.Timeout;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Http20Draft12
  implements Variant
{
  private static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_SEGMENT = 2;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PAD_HIGH = 16;
  static final byte FLAG_PAD_LOW = 8;
  static final byte FLAG_PRIORITY = 32;
  static final int MAX_FRAME_SIZE = 16383;
  static final byte TYPE_ALTSVC = 10;
  static final byte TYPE_BLOCKED = 11;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;
  private static final Logger logger = Logger.getLogger(Http20Draft12.class.getName());
  
  private static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  private static IOException ioException(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  private static short lengthWithoutPadding(short paramShort1, byte paramByte, short paramShort2)
    throws IOException
  {
    short s;
    if ((paramByte & 0x10) != 0) {
      s = (short)(paramShort1 - 2);
    }
    while (paramShort2 > s)
    {
      throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort2), Short.valueOf(s) });
      s = paramShort1;
      if ((paramByte & 0x8) != 0) {
        s = (short)(paramShort1 - 1);
      }
    }
    return (short)(s - paramShort2);
  }
  
  private static short readPadding(BufferedSource paramBufferedSource, byte paramByte)
    throws IOException
  {
    if (((paramByte & 0x10) != 0) && ((paramByte & 0x8) == 0)) {
      throw ioException("PROTOCOL_ERROR FLAG_PAD_HIGH set without FLAG_PAD_LOW", new Object[0]);
    }
    int i = 0;
    if ((paramByte & 0x10) != 0) {
      i = paramBufferedSource.readShort() & 0xFFFF;
    }
    while (i > 16383)
    {
      throw ioException("PROTOCOL_ERROR padding > %d: %d", new Object[] { Integer.valueOf(16383), Integer.valueOf(i) });
      if ((paramByte & 0x8) != 0) {
        i = paramBufferedSource.readByte() & 0xFF;
      }
    }
    return (short)i;
  }
  
  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }
  
  public int maxFrameSize()
  {
    return 16383;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Reader(paramBufferedSource, 4096, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class ContinuationSource
    implements Source
  {
    byte flags;
    short left;
    short length;
    short padding;
    private final BufferedSource source;
    int streamId;
    
    public ContinuationSource(BufferedSource paramBufferedSource)
    {
      this.source = paramBufferedSource;
    }
    
    private void readContinuationHeader()
      throws IOException
    {
      int i = this.streamId;
      int j = this.source.readInt();
      int k = this.source.readInt();
      this.length = ((short)((0x3FFF0000 & j) >> 16));
      byte b = (byte)((0xFF00 & j) >> 8);
      this.flags = ((byte)(j & 0xFF));
      if (Http20Draft12.logger.isLoggable(Level.FINE)) {
        Http20Draft12.logger.fine(Http20Draft12.FrameLogger.formatHeader(true, this.streamId, this.length, b, this.flags));
      }
      this.padding = Http20Draft12.readPadding(this.source, this.flags);
      short s = Http20Draft12.lengthWithoutPadding(this.length, this.flags, this.padding);
      this.left = s;
      this.length = s;
      this.streamId = (0x7FFFFFFF & k);
      if (b != 9) {
        throw Http20Draft12.ioException("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
      }
      if (this.streamId != i) {
        throw Http20Draft12.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
      }
    }
    
    public void close()
      throws IOException
    {}
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      while (this.left == 0)
      {
        this.source.skip(this.padding);
        this.padding = 0;
        if ((this.flags & 0x4) != 0) {
          return -1L;
        }
        readContinuationHeader();
      }
      paramLong = this.source.read(paramBuffer, Math.min(paramLong, this.left));
      if (paramLong == -1L) {
        return -1L;
      }
      this.left = ((short)(int)(this.left - paramLong));
      return paramLong;
    }
    
    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }
  
  static final class FrameLogger
  {
    private static final String[] BINARY;
    private static final String[] FLAGS;
    private static final String[] TYPES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION", "ALTSVC", "BLOCKED" };
    
    static
    {
      FLAGS = new String[64];
      BINARY = new String['Ā'];
      int i = 0;
      while (i < BINARY.length)
      {
        BINARY[i] = String.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
        i += 1;
      }
      FLAGS[0] = "";
      FLAGS[1] = "END_STREAM";
      FLAGS[2] = "END_SEGMENT";
      FLAGS[3] = "END_STREAM|END_SEGMENT";
      int[] arrayOfInt1 = new int[3];
      int[] tmp171_169 = arrayOfInt1;
      tmp171_169[0] = 1;
      int[] tmp175_171 = tmp171_169;
      tmp175_171[1] = 2;
      int[] tmp179_175 = tmp175_171;
      tmp179_175[2] = 3;
      tmp179_175;
      FLAGS[8] = "PAD_LOW";
      FLAGS[24] = "PAD_LOW|PAD_HIGH";
      int[] arrayOfInt2 = new int[2];
      int[] tmp207_205 = arrayOfInt2;
      tmp207_205[0] = 8;
      int[] tmp212_207 = tmp207_205;
      tmp212_207[1] = 24;
      tmp212_207;
      int k = arrayOfInt1.length;
      i = 0;
      int n;
      int j;
      int i1;
      while (i < k)
      {
        m = arrayOfInt1[i];
        n = arrayOfInt2.length;
        j = 0;
        while (j < n)
        {
          i1 = arrayOfInt2[j];
          FLAGS[(m | i1)] = (FLAGS[m] + '|' + FLAGS[i1]);
          j += 1;
        }
        i += 1;
      }
      FLAGS[4] = "END_HEADERS";
      FLAGS[32] = "PRIORITY";
      FLAGS[36] = "END_HEADERS|PRIORITY";
      int[] arrayOfInt3 = new int[3];
      int[] tmp337_335 = arrayOfInt3;
      tmp337_335[0] = 4;
      int[] tmp341_337 = tmp337_335;
      tmp341_337[1] = 32;
      int[] tmp346_341 = tmp341_337;
      tmp346_341[2] = 36;
      tmp346_341;
      int m = arrayOfInt3.length;
      i = 0;
      while (i < m)
      {
        n = arrayOfInt3[i];
        i1 = arrayOfInt1.length;
        j = 0;
        while (j < i1)
        {
          int i2 = arrayOfInt1[j];
          FLAGS[(i2 | n)] = (FLAGS[i2] + '|' + FLAGS[n]);
          int i3 = arrayOfInt2.length;
          k = 0;
          while (k < i3)
          {
            int i4 = arrayOfInt2[k];
            FLAGS[(i2 | n | i4)] = (FLAGS[i2] + '|' + FLAGS[n] + '|' + FLAGS[i4]);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
      i = 0;
      while (i < FLAGS.length)
      {
        if (FLAGS[i] == null) {
          FLAGS[i] = BINARY[i];
        }
        i += 1;
      }
    }
    
    static String formatFlags(byte paramByte1, byte paramByte2)
    {
      if (paramByte2 == 0) {
        return "";
      }
      switch (paramByte1)
      {
      case 5: 
      case 9: 
      default: 
        if (paramByte2 >= FLAGS.length) {
          break;
        }
      }
      for (String str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
      {
        return str.replace("HEADERS", "PUSH_PROMISE");
        if (paramByte2 == 1) {
          return "ACK";
        }
        return BINARY[paramByte2];
        return BINARY[paramByte2];
      }
      if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
        return str.replace("PRIORITY", "COMPRESSED");
      }
      return str;
    }
    
    static String formatHeader(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      String str1;
      String str3;
      if (paramByte1 < TYPES.length)
      {
        str1 = TYPES[paramByte1];
        str3 = formatFlags(paramByte1, paramByte2);
        if (!paramBoolean) {
          break label91;
        }
      }
      label91:
      for (String str2 = "<<";; str2 = ">>")
      {
        return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
        str1 = String.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
        break;
      }
    }
  }
  
  static final class Reader
    implements FrameReader
  {
    private final boolean client;
    private final Http20Draft12.ContinuationSource continuation;
    final HpackDraft07.Reader hpackReader;
    private final BufferedSource source;
    
    Reader(BufferedSource paramBufferedSource, int paramInt, boolean paramBoolean)
    {
      this.source = paramBufferedSource;
      this.client = paramBoolean;
      this.continuation = new Http20Draft12.ContinuationSource(this.source);
      this.hpackReader = new HpackDraft07.Reader(paramInt, this.continuation);
    }
    
    private void readAlternateService(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      long l = this.source.readInt();
      paramByte = this.source.readShort();
      this.source.readByte();
      int i = this.source.readByte() & 0xFF;
      ByteString localByteString = this.source.readByteString(i);
      int j = this.source.readByte() & 0xFF;
      String str = this.source.readUtf8(j);
      paramHandler.alternateService(paramInt, this.source.readUtf8(paramShort - 9 - i - j), localByteString, str, paramByte & 0xFFFF, l & 0xFFFFFFFF);
    }
    
    private void readData(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      int i = 1;
      boolean bool;
      if ((paramByte & 0x1) != 0)
      {
        bool = true;
        if ((paramByte & 0x20) == 0) {
          break label40;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label46;
        }
        throw Http20Draft12.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        bool = false;
        break;
        label40:
        i = 0;
      }
      label46:
      short s = Http20Draft12.readPadding(this.source, paramByte);
      i = Http20Draft12.lengthWithoutPadding(paramShort, paramByte, s);
      paramHandler.data(bool, paramInt, this.source, i);
      this.source.skip(s);
    }
    
    private void readGoAway(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort < 8) {
        throw Http20Draft12.ioException("TYPE_GOAWAY length < 8: %s", new Object[] { Short.valueOf(paramShort) });
      }
      if (paramInt != 0) {
        throw Http20Draft12.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
      }
      paramByte = this.source.readInt();
      paramInt = this.source.readInt();
      int i = paramShort - 8;
      ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt);
      if (localErrorCode == null) {
        throw Http20Draft12.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      ByteString localByteString = ByteString.EMPTY;
      if (i > 0) {
        localByteString = this.source.readByteString(i);
      }
      paramHandler.goAway(paramByte, localErrorCode, localByteString);
    }
    
    private List<Header> readHeaderBlock(short paramShort1, short paramShort2, byte paramByte, int paramInt)
      throws IOException
    {
      Http20Draft12.ContinuationSource localContinuationSource = this.continuation;
      this.continuation.left = paramShort1;
      localContinuationSource.length = paramShort1;
      this.continuation.padding = paramShort2;
      this.continuation.flags = paramByte;
      this.continuation.streamId = paramInt;
      this.hpackReader.readHeaders();
      this.hpackReader.emitReferenceSet();
      return this.hpackReader.getAndReset();
    }
    
    private void readHeaders(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt == 0) {
        throw Http20Draft12.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
      }
      if ((paramByte & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        short s2 = Http20Draft12.readPadding(this.source, paramByte);
        short s1 = paramShort;
        if ((paramByte & 0x20) != 0)
        {
          readPriority(paramHandler, paramInt);
          s1 = (short)(paramShort - 5);
        }
        paramHandler.headers(false, bool, paramInt, -1, readHeaderBlock(Http20Draft12.lengthWithoutPadding(s1, paramByte, s2), s2, paramByte, paramInt), HeadersMode.HTTP_20_HEADERS);
        return;
      }
    }
    
    private void readPing(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      boolean bool = true;
      if (paramShort != 8) {
        throw Http20Draft12.ioException("TYPE_PING length != 8: %s", new Object[] { Short.valueOf(paramShort) });
      }
      if (paramInt != 0) {
        throw Http20Draft12.ioException("TYPE_PING streamId != 0", new Object[0]);
      }
      paramInt = this.source.readInt();
      int i = this.source.readInt();
      if ((paramByte & 0x1) != 0) {}
      for (;;)
      {
        paramHandler.ping(bool, paramInt, i);
        return;
        bool = false;
      }
    }
    
    private void readPriority(FrameReader.Handler paramHandler, int paramInt)
      throws IOException
    {
      int i = this.source.readInt();
      if ((0x80000000 & i) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramHandler.priority(paramInt, i & 0x7FFFFFFF, (this.source.readByte() & 0xFF) + 1, bool);
        return;
      }
    }
    
    private void readPriority(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 5) {
        throw Http20Draft12.ioException("TYPE_PRIORITY length: %d != 5", new Object[] { Short.valueOf(paramShort) });
      }
      if (paramInt == 0) {
        throw Http20Draft12.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
      }
      readPriority(paramHandler, paramInt);
    }
    
    private void readPushPromise(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt == 0) {
        throw Http20Draft12.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
      }
      short s = Http20Draft12.readPadding(this.source, paramByte);
      paramHandler.pushPromise(paramInt, this.source.readInt() & 0x7FFFFFFF, readHeaderBlock((short)(paramShort - 4), s, paramByte, paramInt));
    }
    
    private void readRstStream(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 4) {
        throw Http20Draft12.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] { Short.valueOf(paramShort) });
      }
      if (paramInt == 0) {
        throw Http20Draft12.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
      }
      paramByte = this.source.readInt();
      ErrorCode localErrorCode = ErrorCode.fromHttp2(paramByte);
      if (localErrorCode == null) {
        throw Http20Draft12.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramByte) });
      }
      paramHandler.rstStream(paramInt, localErrorCode);
    }
    
    private void readSettings(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt != 0) {
        throw Http20Draft12.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
      }
      if ((paramByte & 0x1) != 0)
      {
        if (paramShort != 0) {
          throw Http20Draft12.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        }
        paramHandler.ackSettings();
      }
      Settings localSettings;
      do
      {
        return;
        if (paramShort % 5 != 0) {
          throw Http20Draft12.ioException("TYPE_SETTINGS length %% 5 != 0: %s", new Object[] { Short.valueOf(paramShort) });
        }
        localSettings = new Settings();
        paramInt = 0;
        if (paramInt < paramShort)
        {
          byte b = this.source.readByte();
          int i = this.source.readInt();
          paramByte = b;
          switch (b)
          {
          default: 
            throw Http20Draft12.ioException("PROTOCOL_ERROR invalid settings id: %s", new Object[] { Integer.valueOf(b) });
          case 2: 
            paramByte = b;
            if (i != 0)
            {
              paramByte = b;
              if (i != 1) {
                throw Http20Draft12.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              }
            }
            break;
          case 3: 
            paramByte = 4;
          }
          do
          {
            localSettings.set(paramByte, 0, i);
            paramInt += 5;
            break;
            paramByte = 7;
          } while (i >= 0);
          throw Http20Draft12.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        }
        paramHandler.settings(false, localSettings);
      } while (localSettings.getHeaderTableSize() < 0);
      this.hpackReader.maxHeaderTableByteCountSetting(localSettings.getHeaderTableSize());
    }
    
    private void readWindowUpdate(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 4) {
        throw Http20Draft12.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Short.valueOf(paramShort) });
      }
      long l = this.source.readInt() & 0x7FFFFFFF;
      if (l == 0L) {
        throw Http20Draft12.ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      }
      paramHandler.windowUpdate(paramInt, l);
    }
    
    public void close()
      throws IOException
    {
      this.source.close();
    }
    
    public boolean nextFrame(FrameReader.Handler paramHandler)
      throws IOException
    {
      boolean bool = true;
      short s;
      do
      {
        int i;
        byte b2;
        try
        {
          i = this.source.readInt();
          int j = this.source.readInt();
          s = (short)((0x3FFF0000 & i) >> 16);
          byte b1 = (byte)((0xFF00 & i) >> 8);
          b2 = (byte)(i & 0xFF);
          i = j & 0x7FFFFFFF;
          if (Http20Draft12.logger.isLoggable(Level.FINE)) {
            Http20Draft12.logger.fine(Http20Draft12.FrameLogger.formatHeader(true, i, s, b1, b2));
          }
          switch (b1)
          {
          case 9: 
          default: 
            throw Http20Draft12.ioException("PROTOCOL_ERROR: unknown frame type %s", new Object[] { Byte.valueOf(b1) });
          }
        }
        catch (IOException paramHandler)
        {
          bool = false;
          return bool;
        }
        readData(paramHandler, s, b2, i);
        return true;
        readHeaders(paramHandler, s, b2, i);
        return true;
        readPriority(paramHandler, s, b2, i);
        return true;
        readRstStream(paramHandler, s, b2, i);
        return true;
        readSettings(paramHandler, s, b2, i);
        return true;
        readPushPromise(paramHandler, s, b2, i);
        return true;
        readPing(paramHandler, s, b2, i);
        return true;
        readGoAway(paramHandler, s, b2, i);
        return true;
        readWindowUpdate(paramHandler, s, b2, i);
        return true;
        readAlternateService(paramHandler, s, b2, i);
        return true;
      } while (s == 0);
      throw Http20Draft12.ioException("TYPE_BLOCKED length != 0: %s", new Object[] { Short.valueOf(s) });
    }
    
    public void readConnectionPreface()
      throws IOException
    {
      if (this.client) {}
      ByteString localByteString;
      do
      {
        return;
        localByteString = this.source.readByteString(Http20Draft12.CONNECTION_PREFACE.size());
        if (Http20Draft12.logger.isLoggable(Level.FINE)) {
          Http20Draft12.logger.fine(String.format("<< CONNECTION %s", new Object[] { localByteString.hex() }));
        }
      } while (Http20Draft12.CONNECTION_PREFACE.equals(localByteString));
      throw Http20Draft12.ioException("Expected a connection header but was %s", new Object[] { localByteString.utf8() });
    }
  }
  
  static final class Writer
    implements FrameWriter
  {
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final HpackDraft07.Writer hpackWriter;
    private final BufferedSink sink;
    
    Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
    {
      this.sink = paramBufferedSink;
      this.client = paramBoolean;
      this.hpackBuffer = new Buffer();
      this.hpackWriter = new HpackDraft07.Writer(this.hpackBuffer);
    }
    
    private void writeContinuationFrames(int paramInt, long paramLong)
      throws IOException
    {
      if (paramLong > 0L)
      {
        int i = (int)Math.min(16383L, paramLong);
        paramLong -= i;
        if (paramLong == 0L) {}
        for (byte b = 4;; b = 0)
        {
          frameHeader(paramInt, i, (byte)9, b);
          this.sink.write(this.hpackBuffer, i);
          break;
        }
      }
    }
    
    public void ackSettings()
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      frameHeader(0, 0, (byte)4, (byte)1);
      this.sink.flush();
    }
    
    public void close()
      throws IOException
    {
      try
      {
        this.closed = true;
        this.sink.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void connectionPreface()
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      boolean bool = this.client;
      if (!bool) {}
      for (;;)
      {
        return;
        if (Http20Draft12.logger.isLoggable(Level.FINE)) {
          Http20Draft12.logger.fine(String.format(">> CONNECTION %s", new Object[] { Http20Draft12.CONNECTION_PREFACE.hex() }));
        }
        this.sink.write(Http20Draft12.CONNECTION_PREFACE.toByteArray());
        this.sink.flush();
      }
    }
    
    public void data(boolean paramBoolean, int paramInt, Buffer paramBuffer)
      throws IOException
    {
      try
      {
        data(paramBoolean, paramInt, paramBuffer, (int)paramBuffer.size());
        return;
      }
      finally
      {
        paramBuffer = finally;
        throw paramBuffer;
      }
    }
    
    public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      byte b = 0;
      if (paramBoolean) {
        b = (byte)1;
      }
      dataFrame(paramInt1, b, paramBuffer, paramInt2);
    }
    
    void dataFrame(int paramInt1, byte paramByte, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      frameHeader(paramInt1, paramInt2, (byte)0, paramByte);
      if (paramInt2 > 0) {
        this.sink.write(paramBuffer, paramInt2);
      }
    }
    
    public void flush()
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.sink.flush();
    }
    
    void frameHeader(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
      throws IOException
    {
      if (Http20Draft12.logger.isLoggable(Level.FINE)) {
        Http20Draft12.logger.fine(Http20Draft12.FrameLogger.formatHeader(false, paramInt1, paramInt2, paramByte1, paramByte2));
      }
      if (paramInt2 > 16383) {
        throw Http20Draft12.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(16383), Integer.valueOf(paramInt2) });
      }
      if ((0x80000000 & paramInt1) != 0) {
        throw Http20Draft12.illegalArgument("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      this.sink.writeInt((paramInt2 & 0x3FFF) << 16 | (paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF);
      this.sink.writeInt(0x7FFFFFFF & paramInt1);
    }
    
    public void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramErrorCode.httpCode == -1) {
        throw Http20Draft12.illegalArgument("errorCode.httpCode == -1", new Object[0]);
      }
      frameHeader(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
      this.sink.writeInt(paramInt);
      this.sink.writeInt(paramErrorCode.httpCode);
      if (paramArrayOfByte.length > 0) {
        this.sink.write(paramArrayOfByte);
      }
      this.sink.flush();
    }
    
    public void headers(int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      headers(false, paramInt, paramList);
    }
    
    void headers(boolean paramBoolean, int paramInt, List<Header> paramList)
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      if (this.hpackBuffer.size() != 0L) {
        throw new IllegalStateException();
      }
      this.hpackWriter.writeHeaders(paramList);
      long l = this.hpackBuffer.size();
      int i = (int)Math.min(16383L, l);
      if (l == i) {}
      for (byte b1 = 4;; b1 = 0)
      {
        byte b2 = b1;
        if (paramBoolean) {
          b2 = (byte)(b1 | 0x1);
        }
        frameHeader(paramInt, i, (byte)1, b2);
        this.sink.write(this.hpackBuffer, i);
        if (l > i) {
          writeContinuationFrames(paramInt, l - i);
        }
        return;
      }
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramBoolean) {}
      for (byte b = 1;; b = 0)
      {
        frameHeader(0, 8, (byte)6, b);
        this.sink.writeInt(paramInt1);
        this.sink.writeInt(paramInt2);
        this.sink.flush();
        return;
      }
    }
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (this.hpackBuffer.size() != 0L) {
        throw new IllegalStateException();
      }
      this.hpackWriter.writeHeaders(paramList);
      long l = this.hpackBuffer.size();
      int i = (int)Math.min(16379L, l);
      if (l == i) {}
      for (byte b = 4;; b = 0)
      {
        frameHeader(paramInt1, i + 4, (byte)5, b);
        this.sink.writeInt(0x7FFFFFFF & paramInt2);
        this.sink.write(this.hpackBuffer, i);
        if (l > i) {
          writeContinuationFrames(paramInt1, l - i);
        }
        return;
      }
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramErrorCode.spdyRstCode == -1) {
        throw new IllegalArgumentException();
      }
      frameHeader(paramInt, 4, (byte)3, (byte)0);
      this.sink.writeInt(paramErrorCode.httpCode);
      this.sink.flush();
    }
    
    public void settings(Settings paramSettings)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      frameHeader(0, paramSettings.size() * 5, (byte)4, (byte)0);
      int i = 0;
      if (i < 10) {
        if (paramSettings.isSet(i)) {
          break label104;
        }
      }
      for (;;)
      {
        int j;
        this.sink.writeByte(j);
        this.sink.writeInt(paramSettings.get(i));
        break label97;
        this.sink.flush();
        return;
        label97:
        i += 1;
        break;
        label104:
        int k = i;
        if (k == 4)
        {
          j = 3;
        }
        else
        {
          j = k;
          if (k == 7) {
            j = 4;
          }
        }
      }
    }
    
    public void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      headers(paramBoolean, paramInt, paramList);
    }
    
    public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      if (paramBoolean2) {
        try
        {
          throw new UnsupportedOperationException();
        }
        finally {}
      }
      if (this.closed) {
        throw new IOException("closed");
      }
      headers(paramBoolean1, paramInt1, paramList);
    }
    
    public void windowUpdate(int paramInt, long paramLong)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if ((paramLong == 0L) || (paramLong > 2147483647L)) {
        throw Http20Draft12.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      }
      frameHeader(paramInt, 4, (byte)8, (byte)0);
      this.sink.writeInt((int)paramLong);
      this.sink.flush();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/spdy/Http20Draft12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */