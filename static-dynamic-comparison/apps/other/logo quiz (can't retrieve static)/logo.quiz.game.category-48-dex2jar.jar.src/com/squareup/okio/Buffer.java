package com.squareup.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Buffer
  implements BufferedSource, BufferedSink, Cloneable
{
  Segment head;
  long size;
  
  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
    throws IOException
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    int i;
    do
    {
      localSegment.limit += i;
      this.size += i;
      paramLong -= i;
      if ((paramLong <= 0L) && (!paramBoolean)) {
        break;
      }
      Segment localSegment = writableSegment(1);
      i = (int)Math.min(paramLong, 2048 - localSegment.limit);
      i = paramInputStream.read(localSegment.data, localSegment.limit, i);
    } while (i != -1);
    if (paramBoolean) {
      return;
    }
    throw new EOFException();
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  public void clear()
  {
    try
    {
      skip(this.size);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public Buffer clone()
  {
    Buffer localBuffer = new Buffer();
    if (this.size == 0L) {}
    for (;;)
    {
      return localBuffer;
      localBuffer.write(this.head.data, this.head.pos, this.head.limit - this.head.pos);
      for (Segment localSegment = this.head.next; localSegment != this.head; localSegment = localSegment.next) {
        localBuffer.write(localSegment.data, localSegment.pos, localSegment.limit - localSegment.pos);
      }
    }
  }
  
  public void close() {}
  
  public long completeSegmentByteCount()
  {
    long l2 = this.size;
    if (l2 == 0L) {
      return 0L;
    }
    Segment localSegment = this.head.prev;
    long l1 = l2;
    if (localSegment.limit < 2048) {
      l1 = l2 - (localSegment.limit - localSegment.pos);
    }
    return l1;
  }
  
  public Buffer copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    return copyTo(paramOutputStream, 0L, this.size);
  }
  
  public Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {}
    for (;;)
    {
      return this;
      Segment localSegment2;
      long l1;
      long l2;
      for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
      {
        localSegment2 = localSegment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localSegment1.limit - localSegment1.pos) {
          break;
        }
        paramLong1 -= localSegment1.limit - localSegment1.pos;
      }
      while (l2 > 0L)
      {
        int i = (int)(localSegment2.pos + l1);
        int j = (int)Math.min(localSegment2.limit - i, l2);
        paramOutputStream.write(localSegment2.data, i, j);
        l2 -= j;
        l1 = 0L;
        localSegment2 = localSegment2.next;
      }
    }
  }
  
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    if (this.size != ((Buffer)paramObject).size) {
      return false;
    }
    if (this.size == 0L) {
      return true;
    }
    Segment localSegment = this.head;
    paramObject = ((Buffer)paramObject).head;
    int i = localSegment.pos;
    int j = ((Segment)paramObject).pos;
    long l1 = 0L;
    long l2;
    int k;
    if (l1 < this.size)
    {
      l2 = Math.min(localSegment.limit - i, ((Segment)paramObject).limit - j);
      int m = 0;
      k = i;
      i = j;
      j = k;
      k = m;
      while (k < l2)
      {
        if (localSegment.data[j] != paramObject.data[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
      }
      if (j != localSegment.limit) {
        break label223;
      }
      localSegment = localSegment.next;
      j = localSegment.pos;
    }
    label223:
    for (;;)
    {
      if (i == ((Segment)paramObject).limit) {
        paramObject = ((Segment)paramObject).next;
      }
      for (k = ((Segment)paramObject).pos;; k = i)
      {
        l1 += l2;
        i = j;
        j = k;
        break;
        return true;
      }
    }
  }
  
  public boolean exhausted()
  {
    return this.size == 0L;
  }
  
  public void flush() {}
  
  public byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    for (Segment localSegment = this.head;; localSegment = localSegment.next)
    {
      int i = localSegment.limit - localSegment.pos;
      if (paramLong < i) {
        return localSegment.data[(localSegment.pos + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    Segment localSegment;
    do
    {
      int k = ((Segment)localObject).pos;
      int m = ((Segment)localObject).limit;
      i = j;
      j = k;
      while (j < m)
      {
        i = i * 31 + localObject.data[j];
        j += 1;
      }
      localSegment = ((Segment)localObject).next;
      j = i;
      localObject = localSegment;
    } while (localSegment != this.head);
    return i;
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.head;
    if (localObject1 == null) {
      return -1L;
    }
    long l1 = 0L;
    int i = ((Segment)localObject1).limit - ((Segment)localObject1).pos;
    if (paramLong >= i) {}
    for (paramLong -= i;; paramLong = 0L)
    {
      l1 += i;
      Object localObject2 = ((Segment)localObject1).next;
      localObject1 = localObject2;
      if (localObject2 != this.head) {
        break;
      }
      return -1L;
      localObject2 = ((Segment)localObject1).data;
      paramLong = ((Segment)localObject1).pos + paramLong;
      long l2 = ((Segment)localObject1).limit;
      while (paramLong < l2)
      {
        if (localObject2[((int)paramLong)] == paramByte) {
          return l1 + paramLong - ((Segment)localObject1).pos;
        }
        paramLong += 1L;
      }
    }
  }
  
  public InputStream inputStream()
  {
    new InputStream()
    {
      public int available()
      {
        return (int)Math.min(Buffer.this.size, 2147483647L);
      }
      
      public void close() {}
      
      public int read()
      {
        if (Buffer.this.size > 0L) {
          return Buffer.this.readByte() & 0xFF;
        }
        return -1;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return Buffer.this.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        return Buffer.this + ".inputStream()";
      }
    };
  }
  
  public OutputStream outputStream()
  {
    new OutputStream()
    {
      public void close() {}
      
      public void flush() {}
      
      public String toString()
      {
        return this + ".outputStream()";
      }
      
      public void write(int paramAnonymousInt)
      {
        Buffer.this.writeByte((byte)paramAnonymousInt);
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Buffer.this.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.head;
    if (localSegment == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      System.arraycopy(localSegment.data, localSegment.pos, paramArrayOfByte, paramInt1, paramInt2);
      localSegment.pos += paramInt2;
      this.size -= paramInt2;
      paramInt1 = paramInt2;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.INSTANCE.recycle(localSegment);
    return paramInt2;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.size == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.size) {
      l = this.size;
    }
    paramBuffer.write(this, l);
    return l;
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    long l = this.size;
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  public byte readByte()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    byte b = arrayOfByte[i];
    this.size -= 1L;
    if (k == j)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
      return b;
    }
    localSegment.pos = k;
    return b;
  }
  
  public byte[] readByteArray()
  {
    try
    {
      byte[] arrayOfByte = readByteArray(this.size);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public byte[] readByteArray(long paramLong)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  public ByteString readByteString()
  {
    return new ByteString(readByteArray());
  }
  
  public ByteString readByteString(long paramLong)
    throws EOFException
  {
    return new ByteString(readByteArray(paramLong));
  }
  
  public Buffer readFrom(InputStream paramInputStream)
    throws IOException
  {
    readFrom(paramInputStream, Long.MAX_VALUE, true);
    return this;
  }
  
  public Buffer readFrom(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    readFrom(paramInputStream, paramLong, false);
    return this;
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
    throws EOFException
  {
    if (this.size < paramLong)
    {
      paramBuffer.write(this, this.size);
      throw new EOFException();
    }
    paramBuffer.write(this, paramLong);
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws EOFException
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public int readInt()
  {
    if (this.size < 4L) {
      throw new IllegalStateException("size < 4: " + this.size);
    }
    Segment localSegment = this.head;
    int j = localSegment.pos;
    int i = localSegment.limit;
    if (i - j < 4) {
      return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.size -= 4L;
    if (n == i)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
      return j;
    }
    localSegment.pos = n;
    return j;
  }
  
  public int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }
  
  public long readLong()
  {
    if (this.size < 8L) {
      throw new IllegalStateException("size < 8: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 8) {
      return (readInt() & 0xFFFFFFFF) << 32 | readInt() & 0xFFFFFFFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    long l1 = arrayOfByte[k];
    k = j + 1;
    long l2 = arrayOfByte[j];
    j = k + 1;
    long l3 = arrayOfByte[k];
    k = j + 1;
    long l4 = arrayOfByte[j];
    j = k + 1;
    long l5 = arrayOfByte[k];
    k = j + 1;
    long l6 = arrayOfByte[j];
    j = k + 1;
    long l7 = arrayOfByte[k];
    k = j + 1;
    l1 = (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | arrayOfByte[j] & 0xFF;
    this.size -= 8L;
    if (k == i)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
      return l1;
    }
    localSegment.pos = k;
    return l1;
  }
  
  public long readLongLe()
  {
    return Util.reverseBytesLong(readLong());
  }
  
  public short readShort()
  {
    if (this.size < 2L) {
      throw new IllegalStateException("size < 2: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 2) {
      return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.size -= 2L;
    if (m == i)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localSegment.pos = m;
    }
  }
  
  public short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    Segment localSegment;
    String str;
    do
    {
      return paramCharset;
      localSegment = this.head;
      if (localSegment.pos + paramLong > localSegment.limit) {
        return new String(readByteArray(paramLong), paramCharset);
      }
      str = new String(localSegment.data, localSegment.pos, (int)paramLong, paramCharset);
      localSegment.pos = ((int)(localSegment.pos + paramLong));
      this.size -= paramLong;
      paramCharset = str;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.INSTANCE.recycle(localSegment);
    return str;
  }
  
  public String readString(Charset paramCharset)
  {
    try
    {
      paramCharset = readString(this.size, paramCharset);
      return paramCharset;
    }
    catch (EOFException paramCharset)
    {
      throw new AssertionError(paramCharset);
    }
  }
  
  public String readUtf8()
  {
    try
    {
      String str = readString(this.size, Util.UTF_8);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String readUtf8(long paramLong)
    throws EOFException
  {
    return readString(paramLong, Util.UTF_8);
  }
  
  public String readUtf8Line()
    throws EOFException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.size != 0L) {
        return readUtf8(this.size);
      }
      return null;
    }
    return readUtf8Line(l);
  }
  
  String readUtf8Line(long paramLong)
    throws EOFException
  {
    if ((paramLong > 0L) && (getByte(paramLong - 1L) == 13))
    {
      str = readUtf8(paramLong - 1L);
      skip(2L);
      return str;
    }
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public String readUtf8LineStrict()
    throws EOFException
  {
    long l = indexOf((byte)10);
    if (l == -1L) {
      throw new EOFException();
    }
    return readUtf8Line(l);
  }
  
  public void require(long paramLong)
    throws EOFException
  {
    if (this.size < paramLong) {
      throw new EOFException();
    }
  }
  
  List<Integer> segmentSizes()
  {
    Object localObject;
    if (this.head == null)
    {
      localObject = Collections.emptyList();
      return (List<Integer>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
    for (Segment localSegment = this.head.next;; localSegment = localSegment.next)
    {
      localObject = localArrayList;
      if (localSegment == this.head) {
        break;
      }
      localArrayList.add(Integer.valueOf(localSegment.limit - localSegment.pos));
    }
  }
  
  public long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L)
    {
      if (this.head == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.head.limit - this.head.pos);
      this.size -= i;
      long l = paramLong - i;
      Segment localSegment = this.head;
      localSegment.pos += i;
      paramLong = l;
      if (this.head.pos == this.head.limit)
      {
        localSegment = this.head;
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        paramLong = l;
      }
    }
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public String toString()
  {
    if (this.size == 0L) {
      return "Buffer[size=0]";
    }
    Object localObject;
    if (this.size <= 16L)
    {
      localObject = clone().readByteString();
      return String.format("Buffer[size=%s data=%s]", new Object[] { Long.valueOf(this.size), ((ByteString)localObject).hex() });
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
      for (localObject = this.head.next; localObject != this.head; localObject = ((Segment)localObject).next) {
        localMessageDigest.update(((Segment)localObject).data, ((Segment)localObject).pos, ((Segment)localObject).limit - ((Segment)localObject).pos);
      }
      localObject = String.format("Buffer[size=%s md5=%s]", new Object[] { Long.valueOf(this.size), ByteString.of(localMessageDigest.digest()).hex() });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
  }
  
  Segment writableSegment(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 2048)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment2;
    Segment localSegment1;
    if (this.head == null)
    {
      this.head = SegmentPool.INSTANCE.take();
      localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment1 = this.head;
      localSegment3.prev = localSegment1;
      localSegment2.next = localSegment1;
    }
    do
    {
      return localSegment1;
      localSegment2 = this.head.prev;
      localSegment1 = localSegment2;
    } while (localSegment2.limit + paramInt <= 2048);
    return localSegment2.push(SegmentPool.INSTANCE.take());
  }
  
  public Buffer write(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    return write(paramByteString.data, 0, paramByteString.data.length);
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      Segment localSegment = writableSegment(1);
      int j = Math.min(i - paramInt1, 2048 - localSegment.limit);
      System.arraycopy(paramArrayOfByte, paramInt1, localSegment.data, localSegment.limit, j);
      paramInt1 += j;
      localSegment.limit += j;
    }
    this.size += paramInt2;
    return this;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramBuffer == this) {
      throw new IllegalArgumentException("source == this");
    }
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    Segment localSegment1;
    label83:
    long l;
    if (paramLong > 0L) {
      if (paramLong < paramBuffer.head.limit - paramBuffer.head.pos)
      {
        if (this.head != null)
        {
          localSegment1 = this.head.prev;
          if ((localSegment1 != null) && (localSegment1.limit - localSegment1.pos + paramLong <= 2048L)) {
            break label232;
          }
          paramBuffer.head = paramBuffer.head.split((int)paramLong);
        }
      }
      else
      {
        localSegment1 = paramBuffer.head;
        l = localSegment1.limit - localSegment1.pos;
        paramBuffer.head = localSegment1.pop();
        if (this.head != null) {
          break label264;
        }
        this.head = localSegment1;
        localSegment1 = this.head;
        Segment localSegment2 = this.head;
        Segment localSegment3 = this.head;
        localSegment2.prev = localSegment3;
        localSegment1.next = localSegment3;
      }
    }
    for (;;)
    {
      paramBuffer.size -= l;
      this.size += l;
      paramLong -= l;
      break;
      localSegment1 = null;
      break label83;
      label232:
      paramBuffer.head.writeTo(localSegment1, (int)paramLong);
      paramBuffer.size -= paramLong;
      this.size += paramLong;
      return;
      label264:
      this.head.prev.push(localSegment1).compact();
    }
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(this, 2048L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.size += 1L;
    return this;
  }
  
  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment(4);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 4L;
    return this;
  }
  
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment(8);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 8L;
    return this;
  }
  
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(Util.reverseBytesLong(paramLong));
  }
  
  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    this.size += 2L;
    return this;
  }
  
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    paramString = paramString.getBytes(paramCharset);
    return write(paramString, 0, paramString.length);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    return writeTo(paramOutputStream, this.size);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    Object localObject1 = this.head;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (paramLong <= 0L) {
        break;
      }
      int i = (int)Math.min(paramLong, ((Segment)localObject2).limit - ((Segment)localObject2).pos);
      paramOutputStream.write(((Segment)localObject2).data, ((Segment)localObject2).pos, i);
      ((Segment)localObject2).pos += i;
      this.size -= i;
      long l = paramLong - i;
      localObject1 = localObject2;
      paramLong = l;
      if (((Segment)localObject2).pos == ((Segment)localObject2).limit)
      {
        localObject1 = ((Segment)localObject2).pop();
        this.head = ((Segment)localObject1);
        SegmentPool.INSTANCE.recycle((Segment)localObject2);
        paramLong = l;
      }
    }
    return this;
  }
  
  public Buffer writeUtf8(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    return writeString(paramString, Util.UTF_8);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okio/Buffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */