package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroRuntimeException;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedBinaryEncoder
  extends BinaryEncoder
{
  private byte[] buf;
  private int bulkLimit;
  private int pos;
  private ByteSink sink;
  
  BufferedBinaryEncoder(OutputStream paramOutputStream, int paramInt)
  {
    configure(paramOutputStream, paramInt);
  }
  
  private void ensureBounds(int paramInt)
    throws IOException
  {
    if (this.buf.length - this.pos < paramInt) {
      flushBuffer();
    }
  }
  
  private void flushBuffer()
    throws IOException
  {
    if (this.pos > 0)
    {
      this.sink.innerWrite(this.buf, 0, this.pos);
      this.pos = 0;
    }
  }
  
  private void writeByte(int paramInt)
    throws IOException
  {
    if (this.pos == this.buf.length) {
      flushBuffer();
    }
    byte[] arrayOfByte = this.buf;
    int i = this.pos;
    this.pos = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public int bytesBuffered()
  {
    return this.pos;
  }
  
  BufferedBinaryEncoder configure(OutputStream paramOutputStream, int paramInt)
  {
    if (paramOutputStream == null) {
      throw new NullPointerException("OutputStream cannot be null!");
    }
    if ((this.sink != null) && (this.pos > 0)) {}
    try
    {
      flushBuffer();
      this.sink = new OutputStreamSink(paramOutputStream, null);
      this.pos = 0;
      if ((this.buf == null) || (this.buf.length != paramInt)) {
        this.buf = new byte[paramInt];
      }
      this.bulkLimit = (this.buf.length >>> 1);
      if (this.bulkLimit > 512) {
        this.bulkLimit = 512;
      }
      return this;
    }
    catch (IOException paramOutputStream)
    {
      throw new AvroRuntimeException("Failure flushing old output", paramOutputStream);
    }
  }
  
  public void flush()
    throws IOException
  {
    flushBuffer();
    this.sink.innerFlush();
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    if (this.buf.length == this.pos) {
      flushBuffer();
    }
    this.pos += BinaryData.encodeBoolean(paramBoolean, this.buf, this.pos);
  }
  
  public void writeDouble(double paramDouble)
    throws IOException
  {
    ensureBounds(8);
    this.pos += BinaryData.encodeDouble(paramDouble, this.buf, this.pos);
  }
  
  public void writeFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 > this.bulkLimit)
    {
      flushBuffer();
      this.sink.innerWrite(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    ensureBounds(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.buf, this.pos, paramInt2);
    this.pos += paramInt2;
  }
  
  public void writeFloat(float paramFloat)
    throws IOException
  {
    ensureBounds(4);
    this.pos += BinaryData.encodeFloat(paramFloat, this.buf, this.pos);
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    ensureBounds(5);
    this.pos += BinaryData.encodeInt(paramInt, this.buf, this.pos);
  }
  
  public void writeLong(long paramLong)
    throws IOException
  {
    ensureBounds(10);
    this.pos += BinaryData.encodeLong(paramLong, this.buf, this.pos);
  }
  
  protected void writeZero()
    throws IOException
  {
    writeByte(0);
  }
  
  private static abstract class ByteSink
  {
    protected abstract void innerFlush()
      throws IOException;
    
    protected abstract void innerWrite(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException;
  }
  
  static class OutputStreamSink
    extends BufferedBinaryEncoder.ByteSink
  {
    private final OutputStream out;
    
    private OutputStreamSink(OutputStream paramOutputStream)
    {
      this.out = paramOutputStream;
    }
    
    protected void innerFlush()
      throws IOException
    {
      this.out.flush();
    }
    
    protected void innerWrite(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/BufferedBinaryEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */