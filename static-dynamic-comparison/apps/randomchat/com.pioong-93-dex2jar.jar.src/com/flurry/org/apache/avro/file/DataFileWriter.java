package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericDatumReader;
import com.flurry.org.apache.avro.io.BinaryEncoder;
import com.flurry.org.apache.avro.io.DatumWriter;
import com.flurry.org.apache.avro.io.EncoderFactory;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.rmi.server.UID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DataFileWriter<D>
  implements Closeable, Flushable
{
  private long blockCount;
  private BinaryEncoder bufOut;
  private NonCopyingByteArrayOutputStream buffer;
  private Codec codec;
  private DatumWriter<D> dout;
  private boolean isOpen;
  private final Map<String, byte[]> meta = new HashMap();
  private DataFileWriter<D>.BufferedFileOutputStream out;
  private Schema schema;
  private byte[] sync;
  private int syncInterval = 16000;
  private BinaryEncoder vout;
  
  public DataFileWriter(DatumWriter<D> paramDatumWriter)
  {
    this.dout = paramDatumWriter;
  }
  
  private void assertNotOpen()
  {
    if (this.isOpen) {
      throw new AvroRuntimeException("already open");
    }
  }
  
  private void assertOpen()
  {
    if (!this.isOpen) {
      throw new AvroRuntimeException("not open");
    }
  }
  
  private int bufferInUse()
  {
    return this.buffer.size() + this.bufOut.bytesBuffered();
  }
  
  private static byte[] generateSync()
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      long l = System.currentTimeMillis();
      ((MessageDigest)localObject).update((new UID() + "@" + l).getBytes());
      localObject = ((MessageDigest)localObject).digest();
      return (byte[])localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  private void init(OutputStream paramOutputStream)
    throws IOException
  {
    this.out = new BufferedFileOutputStream(paramOutputStream);
    paramOutputStream = new EncoderFactory();
    this.vout = paramOutputStream.binaryEncoder(this.out, null);
    this.dout.setSchema(this.schema);
    this.buffer = new NonCopyingByteArrayOutputStream(Math.min((int)(this.syncInterval * 1.25D), 1073741822));
    this.bufOut = paramOutputStream.binaryEncoder(this.buffer, null);
    if (this.codec == null) {
      this.codec = CodecFactory.nullCodec().createInstance();
    }
    this.isOpen = true;
  }
  
  public static boolean isReservedMeta(String paramString)
  {
    return paramString.startsWith("avro.");
  }
  
  private void resetBufferTo(int paramInt)
    throws IOException
  {
    this.bufOut.flush();
    byte[] arrayOfByte = this.buffer.toByteArray();
    this.buffer.reset();
    this.buffer.write(arrayOfByte, 0, paramInt);
  }
  
  private DataFileWriter<D> setMetaInternal(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = setMetaInternal(paramString1, paramString2.getBytes("UTF-8"));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  private DataFileWriter<D> setMetaInternal(String paramString, byte[] paramArrayOfByte)
  {
    assertNotOpen();
    this.meta.put(paramString, paramArrayOfByte);
    return this;
  }
  
  private void writeBlock()
    throws IOException
  {
    if (this.blockCount > 0L)
    {
      this.bufOut.flush();
      DataFileStream.DataBlock localDataBlock = new DataFileStream.DataBlock(this.buffer.getByteArrayAsByteBuffer(), this.blockCount);
      localDataBlock.compressUsing(this.codec);
      localDataBlock.writeBlockTo(this.vout, this.sync);
      this.buffer.reset();
      this.blockCount = 0L;
    }
  }
  
  private void writeIfBlockFull()
    throws IOException
  {
    if (bufferInUse() >= this.syncInterval) {
      writeBlock();
    }
  }
  
  public void append(D paramD)
    throws IOException
  {
    assertOpen();
    int i = bufferInUse();
    try
    {
      this.dout.write(paramD, this.bufOut);
      this.blockCount += 1L;
      writeIfBlockFull();
      return;
    }
    catch (IOException paramD)
    {
      resetBufferTo(i);
      throw new AppendWriteException(paramD);
    }
    catch (RuntimeException paramD)
    {
      resetBufferTo(i);
      throw new AppendWriteException(paramD);
    }
  }
  
  public void appendAllFrom(DataFileStream<D> paramDataFileStream, boolean paramBoolean)
    throws IOException
  {
    assertOpen();
    Object localObject1 = paramDataFileStream.getSchema();
    if (!this.schema.equals(localObject1)) {
      throw new IOException("Schema from file " + paramDataFileStream + " does not match");
    }
    writeBlock();
    Codec localCodec = paramDataFileStream.resolveCodec();
    Object localObject3 = null;
    Object localObject2 = null;
    localObject1 = localObject3;
    if (this.codec.equals(localCodec))
    {
      localObject1 = localObject3;
      if (!paramBoolean)
      {
        localObject1 = localObject2;
        while (paramDataFileStream.hasNextBlock())
        {
          localObject1 = paramDataFileStream.nextRawBlock((DataFileStream.DataBlock)localObject1);
          ((DataFileStream.DataBlock)localObject1).writeBlockTo(this.vout, this.sync);
        }
      }
    }
    while (paramDataFileStream.hasNextBlock())
    {
      localObject1 = paramDataFileStream.nextRawBlock((DataFileStream.DataBlock)localObject1);
      ((DataFileStream.DataBlock)localObject1).decompressUsing(localCodec);
      ((DataFileStream.DataBlock)localObject1).compressUsing(this.codec);
      ((DataFileStream.DataBlock)localObject1).writeBlockTo(this.vout, this.sync);
    }
  }
  
  public void appendEncoded(ByteBuffer paramByteBuffer)
    throws IOException
  {
    assertOpen();
    int i = paramByteBuffer.position();
    this.bufOut.writeFixed(paramByteBuffer.array(), i, paramByteBuffer.limit() - i);
    this.blockCount += 1L;
    writeIfBlockFull();
  }
  
  public DataFileWriter<D> appendTo(File paramFile)
    throws IOException
  {
    assertNotOpen();
    if (!paramFile.exists()) {
      throw new FileNotFoundException("Not found: " + paramFile);
    }
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    Object localObject = new DataFileReader(new SeekableFileInput(localRandomAccessFile.getFD()), new GenericDatumReader());
    this.schema = ((DataFileReader)localObject).getSchema();
    this.sync = ((DataFileReader)localObject).getHeader().sync;
    this.meta.putAll(((DataFileReader)localObject).getHeader().meta);
    localObject = (byte[])this.meta.get("avro.codec");
    if (localObject != null) {}
    for (this.codec = CodecFactory.fromString(new String((byte[])localObject, "UTF-8")).createInstance();; this.codec = CodecFactory.nullCodec().createInstance())
    {
      localRandomAccessFile.close();
      init(new FileOutputStream(paramFile, true));
      return this;
    }
  }
  
  public void close()
    throws IOException
  {
    flush();
    this.out.close();
    this.isOpen = false;
  }
  
  public DataFileWriter<D> create(Schema paramSchema, File paramFile)
    throws IOException
  {
    return create(paramSchema, new FileOutputStream(paramFile));
  }
  
  public DataFileWriter<D> create(Schema paramSchema, OutputStream paramOutputStream)
    throws IOException
  {
    assertNotOpen();
    this.schema = paramSchema;
    setMetaInternal("avro.schema", paramSchema.toString());
    this.sync = generateSync();
    init(paramOutputStream);
    this.vout.writeFixed(DataFileConstants.MAGIC);
    this.vout.writeMapStart();
    this.vout.setItemCount(this.meta.size());
    paramSchema = this.meta.entrySet().iterator();
    while (paramSchema.hasNext())
    {
      paramOutputStream = (Map.Entry)paramSchema.next();
      this.vout.startItem();
      this.vout.writeString((String)paramOutputStream.getKey());
      this.vout.writeBytes((byte[])paramOutputStream.getValue());
    }
    this.vout.writeMapEnd();
    this.vout.writeFixed(this.sync);
    this.vout.flush();
    return this;
  }
  
  public void flush()
    throws IOException
  {
    sync();
    this.vout.flush();
  }
  
  public DataFileWriter<D> setCodec(CodecFactory paramCodecFactory)
  {
    assertNotOpen();
    this.codec = paramCodecFactory.createInstance();
    setMetaInternal("avro.codec", this.codec.getName());
    return this;
  }
  
  public DataFileWriter<D> setMeta(String paramString, long paramLong)
  {
    return setMeta(paramString, Long.toString(paramLong));
  }
  
  public DataFileWriter<D> setMeta(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = setMeta(paramString1, paramString2.getBytes("UTF-8"));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  public DataFileWriter<D> setMeta(String paramString, byte[] paramArrayOfByte)
  {
    if (isReservedMeta(paramString)) {
      throw new AvroRuntimeException("Cannot set reserved meta key: " + paramString);
    }
    return setMetaInternal(paramString, paramArrayOfByte);
  }
  
  public DataFileWriter<D> setSyncInterval(int paramInt)
  {
    if ((paramInt < 32) || (paramInt > 1073741824)) {
      throw new IllegalArgumentException("Invalid syncInterval value: " + paramInt);
    }
    this.syncInterval = paramInt;
    return this;
  }
  
  public long sync()
    throws IOException
  {
    assertOpen();
    writeBlock();
    return this.out.tell();
  }
  
  public static class AppendWriteException
    extends RuntimeException
  {
    public AppendWriteException(Exception paramException)
    {
      super();
    }
  }
  
  private class BufferedFileOutputStream
    extends BufferedOutputStream
  {
    private long position;
    
    public BufferedFileOutputStream(OutputStream paramOutputStream)
      throws IOException
    {
      super();
      this.out = new PositionFilter(paramOutputStream);
    }
    
    public long tell()
    {
      return this.position + this.count;
    }
    
    private class PositionFilter
      extends FilterOutputStream
    {
      public PositionFilter(OutputStream paramOutputStream)
        throws IOException
      {
        super();
      }
      
      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
        throws IOException
      {
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
        DataFileWriter.BufferedFileOutputStream.access$014(DataFileWriter.BufferedFileOutputStream.this, paramInt2);
      }
    }
  }
  
  private static class NonCopyingByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    NonCopyingByteArrayOutputStream(int paramInt)
    {
      super();
    }
    
    ByteBuffer getByteArrayAsByteBuffer()
    {
      return ByteBuffer.wrap(this.buf, 0, this.count);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/DataFileWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */