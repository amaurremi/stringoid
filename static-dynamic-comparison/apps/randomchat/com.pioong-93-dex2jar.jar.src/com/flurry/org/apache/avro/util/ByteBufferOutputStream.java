package com.flurry.org.apache.avro.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ByteBufferOutputStream
  extends OutputStream
{
  public static final int BUFFER_SIZE = 8192;
  private List<ByteBuffer> buffers;
  
  public ByteBufferOutputStream()
  {
    reset();
  }
  
  public void append(List<ByteBuffer> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ByteBuffer localByteBuffer = (ByteBuffer)localIterator.next();
      localByteBuffer.position(localByteBuffer.limit());
    }
    this.buffers.addAll(paramList);
  }
  
  public List<ByteBuffer> getBufferList()
  {
    List localList = this.buffers;
    reset();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      ((ByteBuffer)localIterator.next()).flip();
    }
    return localList;
  }
  
  public void prepend(List<ByteBuffer> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ByteBuffer localByteBuffer = (ByteBuffer)localIterator.next();
      localByteBuffer.position(localByteBuffer.limit());
    }
    this.buffers.addAll(0, paramList);
  }
  
  public void reset()
  {
    this.buffers = new LinkedList();
    this.buffers.add(ByteBuffer.allocate(8192));
  }
  
  public void write(int paramInt)
  {
    ByteBuffer localByteBuffer2 = (ByteBuffer)this.buffers.get(this.buffers.size() - 1);
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2.remaining() < 1)
    {
      localByteBuffer1 = ByteBuffer.allocate(8192);
      this.buffers.add(localByteBuffer1);
    }
    localByteBuffer1.put((byte)paramInt);
  }
  
  public void write(ByteBuffer paramByteBuffer)
  {
    this.buffers.add(paramByteBuffer);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = (ByteBuffer)this.buffers.get(this.buffers.size() - 1);
    int j = localByteBuffer.remaining();
    int i = paramInt2;
    paramInt2 = paramInt1;
    for (paramInt1 = j; i > paramInt1; paramInt1 = localByteBuffer.remaining())
    {
      localByteBuffer.put(paramArrayOfByte, paramInt2, paramInt1);
      i -= paramInt1;
      paramInt2 += paramInt1;
      localByteBuffer = ByteBuffer.allocate(8192);
      this.buffers.add(localByteBuffer);
    }
    localByteBuffer.put(paramArrayOfByte, paramInt2, i);
  }
  
  public void writeBuffer(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramByteBuffer.remaining() < 8192)
    {
      write(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      return;
    }
    ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
    localByteBuffer.position(paramByteBuffer.limit());
    this.buffers.add(localByteBuffer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/util/ByteBufferOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */