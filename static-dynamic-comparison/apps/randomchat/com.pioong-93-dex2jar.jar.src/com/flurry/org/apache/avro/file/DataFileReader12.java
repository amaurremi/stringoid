package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.BinaryDecoder;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.util.Utf8;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataFileReader12<D>
  implements FileReader<D>, Closeable
{
  private static final String CODEC = "codec";
  private static final String COUNT = "count";
  private static final long FOOTER_BLOCK = -1L;
  static final byte[] MAGIC = { 79, 98, 106, 0 };
  private static final String NULL_CODEC = "null";
  private static final String SCHEMA = "schema";
  private static final String SYNC = "sync";
  private static final int SYNC_INTERVAL = 16000;
  private static final int SYNC_SIZE = 16;
  private static final byte VERSION = 0;
  private long blockCount;
  private long blockStart;
  private long count;
  private DataFileReader.SeekableInputStream in;
  private Map<String, byte[]> meta = new HashMap();
  private D peek;
  private DatumReader<D> reader;
  private Schema schema;
  private byte[] sync = new byte[16];
  private byte[] syncBuffer = new byte[16];
  private BinaryDecoder vin;
  
  public DataFileReader12(SeekableInput paramSeekableInput, DatumReader<D> paramDatumReader)
    throws IOException
  {
    this.in = new DataFileReader.SeekableInputStream(paramSeekableInput);
    paramSeekableInput = new byte[4];
    this.in.read(paramSeekableInput);
    if (!Arrays.equals(MAGIC, paramSeekableInput)) {
      throw new IOException("Not a data file.");
    }
    long l1 = this.in.length();
    this.in.seek(l1 - 4L);
    seek(l1 - ((this.in.read() << 24) + (this.in.read() << 16) + (this.in.read() << 8) + this.in.read()));
    l1 = this.vin.readMapStart();
    if (l1 > 0L)
    {
      long l2;
      do
      {
        for (l2 = 0L; l2 < l1; l2 += 1L)
        {
          paramSeekableInput = this.vin.readString(null).toString();
          ByteBuffer localByteBuffer = this.vin.readBytes(null);
          byte[] arrayOfByte = new byte[localByteBuffer.remaining()];
          localByteBuffer.get(arrayOfByte);
          this.meta.put(paramSeekableInput, arrayOfByte);
        }
        l2 = this.vin.mapNext();
        l1 = l2;
      } while (l2 != 0L);
    }
    this.sync = getMeta("sync");
    this.count = getMetaLong("count");
    paramSeekableInput = getMetaString("codec");
    if ((paramSeekableInput != null) && (!paramSeekableInput.equals("null"))) {
      throw new IOException("Unknown codec: " + paramSeekableInput);
    }
    this.schema = Schema.parse(getMetaString("schema"));
    this.reader = paramDatumReader;
    paramDatumReader.setSchema(this.schema);
    seek(MAGIC.length);
  }
  
  private void skipSync()
    throws IOException
  {
    this.vin.readFixed(this.syncBuffer);
    if (!Arrays.equals(this.syncBuffer, this.sync)) {
      throw new IOException("Invalid sync!");
    }
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.in.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public byte[] getMeta(String paramString)
  {
    try
    {
      paramString = (byte[])this.meta.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public long getMetaLong(String paramString)
  {
    try
    {
      long l = Long.parseLong(getMetaString(paramString));
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public String getMetaString(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 158	com/flurry/org/apache/avro/file/DataFileReader12:getMeta	(Ljava/lang/String;)[B
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +9 -> 18
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: new 170	java/lang/String
    //   21: dup
    //   22: aload_1
    //   23: ldc -31
    //   25: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   28: astore_1
    //   29: goto -15 -> 14
    //   32: astore_1
    //   33: new 230	java/lang/RuntimeException
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	DataFileReader12
    //   0	47	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   18	29	32	java/io/UnsupportedEncodingException
    //   2	8	42	finally
    //   18	29	42	finally
    //   33	42	42	finally
  }
  
  public Schema getSchema()
  {
    return this.schema;
  }
  
  public boolean hasNext()
  {
    if ((this.peek != null) || (this.blockCount != 0L)) {}
    do
    {
      return true;
      this.peek = next();
    } while (this.peek != null);
    return false;
  }
  
  public Iterator<D> iterator()
  {
    return this;
  }
  
  public D next()
  {
    Object localObject;
    if (this.peek != null)
    {
      localObject = this.peek;
      this.peek = null;
      return (D)localObject;
    }
    try
    {
      localObject = next(null);
      return (D)localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public D next(D paramD)
    throws IOException
  {
    for (;;)
    {
      try
      {
        if (this.blockCount == 0L)
        {
          long l1 = this.in.tell();
          long l2 = this.in.length();
          if (l1 == l2)
          {
            paramD = null;
            return paramD;
          }
          skipSync();
          this.blockCount = this.vin.readLong();
          if (this.blockCount != -1L) {
            continue;
          }
          seek(this.vin.readLong() + this.in.tell());
          continue;
        }
        this.blockCount -= 1L;
      }
      finally {}
      paramD = this.reader.read(paramD, this.vin);
    }
  }
  
  public boolean pastSync(long paramLong)
    throws IOException
  {
    return (this.blockStart >= 16L + paramLong) || (this.blockStart >= this.in.length());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public void seek(long paramLong)
    throws IOException
  {
    try
    {
      this.in.seek(paramLong);
      this.blockCount = 0L;
      this.blockStart = paramLong;
      this.vin = DecoderFactory.get().binaryDecoder(this.in, this.vin);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void sync(long paramLong)
    throws IOException
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.in.tell() + 16L >= this.in.length())
        {
          seek(this.in.length());
          return;
        }
        this.in.seek(paramLong);
        this.vin.readFixed(this.syncBuffer);
        i = 0;
        if (this.in.tell() >= this.in.length()) {
          break label186;
        }
        int j = 0;
        if ((j >= this.sync.length) || (this.sync[j] != this.syncBuffer[((i + j) % this.sync.length)]))
        {
          if (j != this.sync.length) {
            break label159;
          }
          seek(this.in.tell() - 16L);
          continue;
        }
        j += 1;
      }
      finally {}
      continue;
      label159:
      this.syncBuffer[(i % this.sync.length)] = ((byte)this.in.read());
      i += 1;
      continue;
      label186:
      seek(this.in.length());
    }
  }
  
  public long tell()
    throws IOException
  {
    return this.in.tell();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/DataFileReader12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */