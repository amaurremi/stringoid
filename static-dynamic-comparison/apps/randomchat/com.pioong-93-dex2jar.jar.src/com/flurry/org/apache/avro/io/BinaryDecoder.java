package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class BinaryDecoder
  extends Decoder
{
  private byte[] buf = null;
  private int limit = 0;
  private int minPos = 0;
  private int pos = 0;
  private final Utf8 scratchUtf8 = new Utf8();
  private ByteSource source = null;
  
  protected BinaryDecoder() {}
  
  BinaryDecoder(InputStream paramInputStream, int paramInt)
  {
    configure(paramInputStream, paramInt);
  }
  
  BinaryDecoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    configure(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void configureSource(int paramInt, ByteSource paramByteSource)
  {
    if (this.source != null) {
      this.source.detach();
    }
    paramByteSource.attach(paramInt, this);
    this.source = paramByteSource;
  }
  
  private long doSkipItems()
    throws IOException
  {
    for (long l = readInt(); l < 0L; l = readInt()) {
      doSkipBytes(readLong());
    }
    return l;
  }
  
  private void ensureBounds(int paramInt)
    throws IOException
  {
    int i = this.limit - this.pos;
    if (i < paramInt) {
      this.source.compactAndFill(this.buf, this.pos, this.minPos, i);
    }
  }
  
  private long innerLongDecode(long paramLong)
    throws IOException
  {
    int i = 1;
    int j = this.buf[this.pos] & 0xFF;
    long l = paramLong ^ (j & 0x7F) << 28;
    paramLong = l;
    if (j > 127)
    {
      byte[] arrayOfByte = this.buf;
      j = this.pos;
      i = 1 + 1;
      j = arrayOfByte[(j + 1)] & 0xFF;
      paramLong = l ^ (j & 0x7F) << 35;
      if (j > 127)
      {
        arrayOfByte = this.buf;
        int k = this.pos;
        j = i + 1;
        k = arrayOfByte[(k + 2)] & 0xFF;
        l = paramLong ^ (k & 0x7F) << 42;
        i = j;
        paramLong = l;
        if (k > 127)
        {
          arrayOfByte = this.buf;
          i = this.pos;
          j += 1;
          k = arrayOfByte[(i + 3)] & 0xFF;
          l ^= (k & 0x7F) << 49;
          i = j;
          paramLong = l;
          if (k > 127)
          {
            arrayOfByte = this.buf;
            i = this.pos;
            j += 1;
            k = arrayOfByte[(i + 4)] & 0xFF;
            l ^= (k & 0x7F) << 56;
            i = j;
            paramLong = l;
            if (k > 127)
            {
              arrayOfByte = this.buf;
              k = this.pos;
              i = j + 1;
              j = arrayOfByte[(k + 5)] & 0xFF;
              paramLong = l ^ (j & 0x7F) << 63;
              if (j > 127) {
                throw new IOException("Invalid long encoding");
              }
            }
          }
        }
      }
    }
    this.pos += i;
    return paramLong;
  }
  
  public long arrayNext()
    throws IOException
  {
    return doReadItemCount();
  }
  
  BinaryDecoder configure(InputStream paramInputStream, int paramInt)
  {
    configureSource(paramInt, new InputStreamByteSource(paramInputStream, null));
    return this;
  }
  
  BinaryDecoder configure(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    configureSource(8192, new ByteArrayByteSource(paramArrayOfByte, paramInt1, paramInt2, null));
    return this;
  }
  
  protected void doReadBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.limit - this.pos;
    if (paramInt2 <= i)
    {
      System.arraycopy(this.buf, this.pos, paramArrayOfByte, paramInt1, paramInt2);
      this.pos += paramInt2;
      return;
    }
    System.arraycopy(this.buf, this.pos, paramArrayOfByte, paramInt1, i);
    this.pos = this.limit;
    this.source.readRaw(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
  }
  
  protected long doReadItemCount()
    throws IOException
  {
    long l2 = readLong();
    long l1 = l2;
    if (l2 < 0L)
    {
      readLong();
      l1 = -l2;
    }
    return l1;
  }
  
  protected void doSkipBytes(long paramLong)
    throws IOException
  {
    int i = this.limit - this.pos;
    if (paramLong <= i)
    {
      this.pos = ((int)(this.pos + paramLong));
      return;
    }
    this.pos = 0;
    this.limit = 0;
    long l = i;
    this.source.skipSourceBytes(paramLong - l);
  }
  
  BufferAccessor getBufferAccessor()
  {
    return new BufferAccessor(this, null);
  }
  
  public InputStream inputStream()
  {
    return this.source;
  }
  
  public boolean isEnd()
    throws IOException
  {
    if (this.limit - this.pos > 0) {}
    int i;
    do
    {
      return false;
      if (this.source.isEof()) {
        return true;
      }
      i = this.source.tryReadRaw(this.buf, 0, this.buf.length);
      this.pos = 0;
      this.limit = i;
    } while (i != 0);
    return true;
  }
  
  public long mapNext()
    throws IOException
  {
    return doReadItemCount();
  }
  
  public long readArrayStart()
    throws IOException
  {
    return doReadItemCount();
  }
  
  public boolean readBoolean()
    throws IOException
  {
    if (this.limit == this.pos)
    {
      this.limit = this.source.tryReadRaw(this.buf, 0, this.buf.length);
      this.pos = 0;
      if (this.limit == 0) {
        throw new EOFException();
      }
    }
    byte[] arrayOfByte = this.buf;
    int i = this.pos;
    this.pos = (i + 1);
    return (arrayOfByte[i] & 0xFF) == 1;
  }
  
  public ByteBuffer readBytes(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int i = readInt();
    if ((paramByteBuffer != null) && (i <= paramByteBuffer.capacity())) {
      paramByteBuffer.clear();
    }
    for (;;)
    {
      doReadBytes(paramByteBuffer.array(), paramByteBuffer.position(), i);
      paramByteBuffer.limit(i);
      return paramByteBuffer;
      paramByteBuffer = ByteBuffer.allocate(i);
    }
  }
  
  public double readDouble()
    throws IOException
  {
    ensureBounds(8);
    int i = this.buf[this.pos];
    int j = this.buf[(this.pos + 1)];
    int k = this.buf[(this.pos + 2)];
    int m = this.buf[(this.pos + 3)];
    int n = this.buf[(this.pos + 4)];
    int i1 = this.buf[(this.pos + 5)];
    int i2 = this.buf[(this.pos + 6)];
    int i3 = this.buf[(this.pos + 7)];
    if (this.pos + 8 > this.limit) {
      throw new EOFException();
    }
    this.pos += 8;
    return Double.longBitsToDouble((i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24) & 0xFFFFFFFF | (n & 0xFF | (i1 & 0xFF) << 8 | (i2 & 0xFF) << 16 | (i3 & 0xFF) << 24) << 32);
  }
  
  public int readEnum()
    throws IOException
  {
    return readInt();
  }
  
  public void readFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    doReadBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public float readFloat()
    throws IOException
  {
    ensureBounds(4);
    int i = this.buf[this.pos];
    int j = this.buf[(this.pos + 1)];
    int k = this.buf[(this.pos + 2)];
    int m = this.buf[(this.pos + 3)];
    if (this.pos + 4 > this.limit) {
      throw new EOFException();
    }
    this.pos += 4;
    return Float.intBitsToFloat(i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24);
  }
  
  public int readIndex()
    throws IOException
  {
    return readInt();
  }
  
  public int readInt()
    throws IOException
  {
    ensureBounds(5);
    int i = 1;
    int m = this.buf[this.pos] & 0xFF;
    int k = m & 0x7F;
    int j = k;
    if (m > 127)
    {
      byte[] arrayOfByte = this.buf;
      j = this.pos;
      i = 1 + 1;
      m = arrayOfByte[(j + 1)] & 0xFF;
      j = k ^ (m & 0x7F) << 7;
      if (m > 127)
      {
        arrayOfByte = this.buf;
        m = this.pos;
        k = i + 1;
        int n = arrayOfByte[(m + 2)] & 0xFF;
        m = j ^ (n & 0x7F) << 14;
        i = k;
        j = m;
        if (n > 127)
        {
          arrayOfByte = this.buf;
          i = this.pos;
          k += 1;
          n = arrayOfByte[(i + 3)] & 0xFF;
          m ^= (n & 0x7F) << 21;
          i = k;
          j = m;
          if (n > 127)
          {
            arrayOfByte = this.buf;
            j = this.pos;
            i = k + 1;
            k = arrayOfByte[(j + 4)] & 0xFF;
            j = m ^ (k & 0x7F) << 28;
            if (k > 127) {
              throw new IOException("Invalid int encoding");
            }
          }
        }
      }
    }
    this.pos += i;
    if (this.pos > this.limit) {
      throw new EOFException();
    }
    return j >>> 1 ^ -(j & 0x1);
  }
  
  public long readLong()
    throws IOException
  {
    ensureBounds(10);
    byte[] arrayOfByte = this.buf;
    int i = this.pos;
    this.pos = (i + 1);
    int j = arrayOfByte[i] & 0xFF;
    i = j & 0x7F;
    long l;
    if (j > 127)
    {
      arrayOfByte = this.buf;
      j = this.pos;
      this.pos = (j + 1);
      j = arrayOfByte[j] & 0xFF;
      i ^= (j & 0x7F) << 7;
      if (j > 127)
      {
        arrayOfByte = this.buf;
        j = this.pos;
        this.pos = (j + 1);
        j = arrayOfByte[j] & 0xFF;
        i ^= (j & 0x7F) << 14;
        if (j > 127)
        {
          arrayOfByte = this.buf;
          j = this.pos;
          this.pos = (j + 1);
          j = arrayOfByte[j] & 0xFF;
          i ^= (j & 0x7F) << 21;
          if (j > 127) {
            l = innerLongDecode(i);
          }
        }
      }
    }
    while (this.pos > this.limit)
    {
      throw new EOFException();
      l = i;
      continue;
      l = i;
      continue;
      l = i;
      continue;
      l = i;
    }
    return l >>> 1 ^ -(1L & l);
  }
  
  public long readMapStart()
    throws IOException
  {
    return doReadItemCount();
  }
  
  public void readNull()
    throws IOException
  {}
  
  public Utf8 readString(Utf8 paramUtf8)
    throws IOException
  {
    int i = readInt();
    if (paramUtf8 != null) {}
    for (;;)
    {
      paramUtf8.setByteLength(i);
      if (i != 0) {
        doReadBytes(paramUtf8.getBytes(), 0, i);
      }
      return paramUtf8;
      paramUtf8 = new Utf8();
    }
  }
  
  public String readString()
    throws IOException
  {
    return readString(this.scratchUtf8).toString();
  }
  
  public long skipArray()
    throws IOException
  {
    return doSkipItems();
  }
  
  public void skipBytes()
    throws IOException
  {
    doSkipBytes(readInt());
  }
  
  public void skipFixed(int paramInt)
    throws IOException
  {
    doSkipBytes(paramInt);
  }
  
  public long skipMap()
    throws IOException
  {
    return doSkipItems();
  }
  
  public void skipString()
    throws IOException
  {
    doSkipBytes(readInt());
  }
  
  static class BufferAccessor
  {
    private byte[] buf;
    private final BinaryDecoder decoder;
    boolean detached = false;
    private int limit;
    private int pos;
    
    private BufferAccessor(BinaryDecoder paramBinaryDecoder)
    {
      this.decoder = paramBinaryDecoder;
    }
    
    void detach()
    {
      this.buf = this.decoder.buf;
      this.pos = this.decoder.pos;
      this.limit = this.decoder.limit;
      this.detached = true;
    }
    
    byte[] getBuf()
    {
      if (this.detached) {
        return this.buf;
      }
      return this.decoder.buf;
    }
    
    int getLim()
    {
      if (this.detached) {
        return this.limit;
      }
      return this.decoder.limit;
    }
    
    int getPos()
    {
      if (this.detached) {
        return this.pos;
      }
      return this.decoder.pos;
    }
    
    void setBuf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.detached)
      {
        this.buf = paramArrayOfByte;
        this.limit = (paramInt1 + paramInt2);
        this.pos = paramInt1;
        return;
      }
      BinaryDecoder.access$302(this.decoder, paramArrayOfByte);
      BinaryDecoder.access$502(this.decoder, paramInt1 + paramInt2);
      BinaryDecoder.access$402(this.decoder, paramInt1);
      BinaryDecoder.access$602(this.decoder, paramInt1);
    }
    
    void setLimit(int paramInt)
    {
      if (this.detached)
      {
        this.limit = paramInt;
        return;
      }
      BinaryDecoder.access$502(this.decoder, paramInt);
    }
    
    void setPos(int paramInt)
    {
      if (this.detached)
      {
        this.pos = paramInt;
        return;
      }
      BinaryDecoder.access$402(this.decoder, paramInt);
    }
  }
  
  private static class ByteArrayByteSource
    extends BinaryDecoder.ByteSource
  {
    private boolean compacted = false;
    private byte[] data;
    private int max;
    private int position;
    
    private ByteArrayByteSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if ((paramArrayOfByte.length < 16) || (paramInt2 < 16))
      {
        this.data = new byte[16];
        System.arraycopy(paramArrayOfByte, paramInt1, this.data, 0, paramInt2);
        this.position = 0;
        this.max = paramInt2;
        return;
      }
      this.data = paramArrayOfByte;
      this.position = paramInt1;
      this.max = (paramInt1 + paramInt2);
    }
    
    protected void attach(int paramInt, BinaryDecoder paramBinaryDecoder)
    {
      BinaryDecoder.access$302(paramBinaryDecoder, this.data);
      BinaryDecoder.access$402(paramBinaryDecoder, this.position);
      BinaryDecoder.access$602(paramBinaryDecoder, this.position);
      BinaryDecoder.access$502(paramBinaryDecoder, this.max);
      this.ba = new BinaryDecoder.BufferAccessor(paramBinaryDecoder, null);
    }
    
    public void close()
      throws IOException
    {
      this.ba.setPos(this.ba.getLim());
    }
    
    protected void compactAndFill(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
      throws IOException
    {
      if (!this.compacted)
      {
        byte[] arrayOfByte = new byte[paramInt3 + 16];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt3);
        this.ba.setBuf(arrayOfByte, 0, paramInt3);
        this.compacted = true;
      }
    }
    
    public boolean isEof()
    {
      return this.ba.getLim() - this.ba.getPos() == 0;
    }
    
    public int read()
      throws IOException
    {
      this.max = this.ba.getLim();
      this.position = this.ba.getPos();
      if (this.position >= this.max) {
        return -1;
      }
      byte[] arrayOfByte = this.ba.getBuf();
      int i = this.position;
      this.position = (i + 1);
      i = arrayOfByte[i];
      this.ba.setPos(this.position);
      return i & 0xFF;
    }
    
    protected void readRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (tryReadRaw(paramArrayOfByte, paramInt1, paramInt2) < paramInt2) {
        throw new EOFException();
      }
    }
    
    protected void skipSourceBytes(long paramLong)
      throws IOException
    {
      if (trySkipBytes(paramLong) < paramLong) {
        throw new EOFException();
      }
    }
    
    protected int tryReadRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      return 0;
    }
    
    protected long trySkipBytes(long paramLong)
      throws IOException
    {
      this.max = this.ba.getLim();
      this.position = this.ba.getPos();
      long l = this.max - this.position;
      if (l >= paramLong)
      {
        this.position = ((int)(this.position + paramLong));
        this.ba.setPos(this.position);
        return paramLong;
      }
      this.position = ((int)(this.position + l));
      this.ba.setPos(this.position);
      return l;
    }
  }
  
  static abstract class ByteSource
    extends InputStream
  {
    protected BinaryDecoder.BufferAccessor ba;
    
    protected void attach(int paramInt, BinaryDecoder paramBinaryDecoder)
    {
      BinaryDecoder.access$302(paramBinaryDecoder, new byte[paramInt]);
      BinaryDecoder.access$402(paramBinaryDecoder, 0);
      BinaryDecoder.access$602(paramBinaryDecoder, 0);
      BinaryDecoder.access$502(paramBinaryDecoder, 0);
      this.ba = new BinaryDecoder.BufferAccessor(paramBinaryDecoder, null);
    }
    
    public int available()
      throws IOException
    {
      return this.ba.getLim() - this.ba.getPos();
    }
    
    protected void compactAndFill(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
      throws IOException
    {
      System.arraycopy(paramArrayOfByte, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
      this.ba.setPos(paramInt2);
      paramInt1 = tryReadRaw(paramArrayOfByte, paramInt2 + paramInt3, paramArrayOfByte.length - paramInt3);
      this.ba.setLimit(paramInt3 + paramInt1);
    }
    
    protected void detach()
    {
      this.ba.detach();
    }
    
    abstract boolean isEof();
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int j = this.ba.getLim();
      int i = this.ba.getPos();
      byte[] arrayOfByte = this.ba.getBuf();
      j -= i;
      if (j >= paramInt2)
      {
        System.arraycopy(arrayOfByte, i, paramArrayOfByte, paramInt1, paramInt2);
        this.ba.setPos(i + paramInt2);
        return paramInt2;
      }
      System.arraycopy(arrayOfByte, i, paramArrayOfByte, paramInt1, j);
      this.ba.setPos(i + j);
      paramInt1 = j + tryReadRaw(paramArrayOfByte, paramInt1 + j, paramInt2 - j);
      if (paramInt1 == 0) {
        return -1;
      }
      return paramInt1;
    }
    
    protected abstract void readRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException;
    
    public long skip(long paramLong)
      throws IOException
    {
      int i = this.ba.getLim();
      int j = this.ba.getPos();
      int k = i - j;
      if (k > paramLong)
      {
        i = (int)(j + paramLong);
        this.ba.setPos(i);
        return paramLong;
      }
      this.ba.setPos(i);
      return trySkipBytes(paramLong - k) + k;
    }
    
    protected abstract void skipSourceBytes(long paramLong)
      throws IOException;
    
    protected abstract int tryReadRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException;
    
    protected abstract long trySkipBytes(long paramLong)
      throws IOException;
  }
  
  private static class InputStreamByteSource
    extends BinaryDecoder.ByteSource
  {
    private InputStream in;
    protected boolean isEof = false;
    
    private InputStreamByteSource(InputStream paramInputStream)
    {
      this.in = paramInputStream;
    }
    
    public void close()
      throws IOException
    {
      this.in.close();
    }
    
    public boolean isEof()
    {
      return this.isEof;
    }
    
    public int read()
      throws IOException
    {
      if (this.ba.getLim() - this.ba.getPos() == 0) {
        return this.in.read();
      }
      int i = this.ba.getPos();
      int j = this.ba.getBuf()[i];
      this.ba.setPos(i + 1);
      return j & 0xFF;
    }
    
    protected void readRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      while (paramInt2 > 0)
      {
        int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
        if (i < 0)
        {
          this.isEof = true;
          throw new EOFException();
        }
        paramInt2 -= i;
        paramInt1 += i;
      }
    }
    
    protected void skipSourceBytes(long paramLong)
      throws IOException
    {
      int i = 0;
      while (paramLong > 0L)
      {
        long l = this.in.skip(paramLong);
        if (l > 0L)
        {
          paramLong -= l;
        }
        else if (l == 0L)
        {
          if (i != 0)
          {
            this.isEof = true;
            throw new EOFException();
          }
          i = 1;
        }
        else
        {
          this.isEof = true;
          throw new EOFException();
        }
      }
    }
    
    protected int tryReadRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = paramInt2;
      for (;;)
      {
        if (i > 0) {}
        try
        {
          j = this.in.read(paramArrayOfByte, paramInt1, i);
          if (j >= 0) {
            break label36;
          }
          this.isEof = true;
        }
        catch (EOFException paramArrayOfByte)
        {
          for (;;)
          {
            int j;
            this.isEof = true;
          }
        }
        return paramInt2 - i;
        label36:
        i -= j;
        paramInt1 += j;
      }
    }
    
    protected long trySkipBytes(long paramLong)
      throws IOException
    {
      long l1 = paramLong;
      label78:
      for (int i = 0;; i = 1)
      {
        for (;;)
        {
          if (l1 > 0L) {
            try
            {
              long l2 = this.in.skip(paramLong);
              if (l2 > 0L)
              {
                l1 -= l2;
              }
              else if (l2 == 0L)
              {
                if (i == 0) {
                  break label78;
                }
                this.isEof = true;
              }
              else
              {
                this.isEof = true;
              }
            }
            catch (EOFException localEOFException)
            {
              this.isEof = true;
            }
          }
        }
        return paramLong - l1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/BinaryDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */