package com.flurry.org.apache.avro.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

class DeflateCodec
  extends Codec
{
  private int compressionLevel;
  private Deflater deflater;
  private Inflater inflater;
  private boolean nowrap = true;
  private ByteArrayOutputStream outputBuffer;
  
  public DeflateCodec(int paramInt)
  {
    this.compressionLevel = paramInt;
  }
  
  private Deflater getDeflater()
  {
    if (this.deflater == null) {
      this.deflater = new Deflater(this.compressionLevel, this.nowrap);
    }
    this.deflater.reset();
    return this.deflater;
  }
  
  private Inflater getInflater()
  {
    if (this.inflater == null) {
      this.inflater = new Inflater(this.nowrap);
    }
    this.inflater.reset();
    return this.inflater;
  }
  
  private ByteArrayOutputStream getOutputBuffer(int paramInt)
  {
    if (this.outputBuffer == null) {
      this.outputBuffer = new ByteArrayOutputStream(paramInt);
    }
    this.outputBuffer.reset();
    return this.outputBuffer;
  }
  
  private void writeAndClose(ByteBuffer paramByteBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.arrayOffset();
    int j = paramByteBuffer.position();
    int k = paramByteBuffer.remaining();
    try
    {
      paramOutputStream.write(arrayOfByte, i + j, k);
      return;
    }
    finally
    {
      paramOutputStream.close();
    }
  }
  
  ByteBuffer compress(ByteBuffer paramByteBuffer)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = getOutputBuffer(paramByteBuffer.remaining());
    writeAndClose(paramByteBuffer, new DeflaterOutputStream(localByteArrayOutputStream, getDeflater()));
    return ByteBuffer.wrap(localByteArrayOutputStream.toByteArray());
  }
  
  ByteBuffer decompress(ByteBuffer paramByteBuffer)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = getOutputBuffer(paramByteBuffer.remaining());
    writeAndClose(paramByteBuffer, new InflaterOutputStream(localByteArrayOutputStream, getInflater()));
    return ByteBuffer.wrap(localByteArrayOutputStream.toByteArray());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DeflateCodec)paramObject;
    } while (this.nowrap == ((DeflateCodec)paramObject).nowrap);
    return false;
  }
  
  String getName()
  {
    return "deflate";
  }
  
  public int hashCode()
  {
    if (this.nowrap) {
      return 0;
    }
    return 1;
  }
  
  public String toString()
  {
    return getName() + "-" + this.compressionLevel;
  }
  
  static class Option
    extends CodecFactory
  {
    private int compressionLevel;
    
    Option(int paramInt)
    {
      this.compressionLevel = paramInt;
    }
    
    protected Codec createInstance()
    {
      return new DeflateCodec(this.compressionLevel);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/DeflateCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */