package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.io.BinaryDecoder;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DecoderFactory;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class DataFileReader<D>
  extends DataFileStream<D>
  implements FileReader<D>
{
  private long blockStart;
  private SeekableInputStream sin;
  
  public DataFileReader(SeekableInput paramSeekableInput, DatumReader<D> paramDatumReader)
    throws IOException
  {
    super(paramDatumReader);
    this.sin = new SeekableInputStream(paramSeekableInput);
    initialize(this.sin);
    blockFinished();
  }
  
  protected DataFileReader(SeekableInput paramSeekableInput, DatumReader<D> paramDatumReader, DataFileStream.Header paramHeader)
    throws IOException
  {
    super(paramDatumReader);
    this.sin = new SeekableInputStream(paramSeekableInput);
    initialize(this.sin, paramHeader);
  }
  
  public DataFileReader(File paramFile, DatumReader<D> paramDatumReader)
    throws IOException
  {
    this(new SeekableFileInput(paramFile), paramDatumReader);
  }
  
  public static <D> DataFileReader<D> openReader(SeekableInput paramSeekableInput, DatumReader<D> paramDatumReader, DataFileStream.Header paramHeader, boolean paramBoolean)
    throws IOException
  {
    paramDatumReader = new DataFileReader(paramSeekableInput, paramDatumReader, paramHeader);
    if (paramBoolean)
    {
      paramDatumReader.sync(paramSeekableInput.tell());
      return paramDatumReader;
    }
    paramDatumReader.seek(paramSeekableInput.tell());
    return paramDatumReader;
  }
  
  public static <D> FileReader<D> openReader(SeekableInput paramSeekableInput, DatumReader<D> paramDatumReader)
    throws IOException
  {
    if (paramSeekableInput.length() < DataFileConstants.MAGIC.length) {
      throw new IOException("Not an Avro data file");
    }
    byte[] arrayOfByte = new byte[DataFileConstants.MAGIC.length];
    paramSeekableInput.seek(0L);
    for (int i = 0; i < arrayOfByte.length; i = paramSeekableInput.read(arrayOfByte, i, arrayOfByte.length - i)) {}
    paramSeekableInput.seek(0L);
    if (Arrays.equals(DataFileConstants.MAGIC, arrayOfByte)) {
      return new DataFileReader(paramSeekableInput, paramDatumReader);
    }
    if (Arrays.equals(DataFileReader12.MAGIC, arrayOfByte)) {
      return new DataFileReader12(paramSeekableInput, paramDatumReader);
    }
    throw new IOException("Not an Avro data file");
  }
  
  public static <D> FileReader<D> openReader(File paramFile, DatumReader<D> paramDatumReader)
    throws IOException
  {
    return openReader(new SeekableFileInput(paramFile), paramDatumReader);
  }
  
  protected void blockFinished()
    throws IOException
  {
    this.blockStart = (this.sin.tell() - this.vin.inputStream().available());
  }
  
  public boolean pastSync(long paramLong)
    throws IOException
  {
    return (this.blockStart >= 16L + paramLong) || (this.blockStart >= this.sin.length());
  }
  
  public long previousSync()
  {
    return this.blockStart;
  }
  
  public void seek(long paramLong)
    throws IOException
  {
    this.sin.seek(paramLong);
    this.vin = DecoderFactory.get().binaryDecoder(this.sin, this.vin);
    this.datumIn = null;
    this.blockRemaining = 0L;
    this.blockStart = paramLong;
  }
  
  public void sync(long paramLong)
    throws IOException
  {
    seek(paramLong);
    if ((paramLong == 0L) && (getMeta("avro.sync") != null))
    {
      initialize(this.sin);
      return;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        InputStream localInputStream = this.vin.inputStream();
        this.vin.readFixed(this.syncBuffer);
      }
      catch (EOFException localEOFException)
      {
        this.blockStart = this.sin.tell();
        return;
      }
      if ((j >= 16) || (getHeader().sync[j] != this.syncBuffer[((i + j) % 16)]))
      {
        if (j == 16) {
          this.blockStart = (i + paramLong + 16L);
        }
      }
      else
      {
        j += 1;
        continue;
      }
      int j = localEOFException.read();
      byte[] arrayOfByte = this.syncBuffer;
      arrayOfByte[(i % 16)] = ((byte)j);
      if (j != -1)
      {
        i += 1;
        j = 0;
      }
    }
  }
  
  public long tell()
    throws IOException
  {
    return this.sin.tell();
  }
  
  static class SeekableInputStream
    extends InputStream
    implements SeekableInput
  {
    private SeekableInput in;
    private final byte[] oneByte = new byte[1];
    
    SeekableInputStream(SeekableInput paramSeekableInput)
      throws IOException
    {
      this.in = paramSeekableInput;
    }
    
    public int available()
      throws IOException
    {
      long l = this.in.length() - this.in.tell();
      if (l > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      return (int)l;
    }
    
    public void close()
      throws IOException
    {
      this.in.close();
      super.close();
    }
    
    public long length()
      throws IOException
    {
      return this.in.length();
    }
    
    public int read()
      throws IOException
    {
      int j = read(this.oneByte, 0, 1);
      int i = j;
      if (j == 1) {
        i = this.oneByte[0] & 0xFF;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte)
      throws IOException
    {
      return this.in.read(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void seek(long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IOException("Illegal seek: " + paramLong);
      }
      this.in.seek(paramLong);
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      long l1 = this.in.tell();
      long l2 = this.in.length() - l1;
      if (l2 > paramLong)
      {
        this.in.seek(paramLong);
        return this.in.tell() - l1;
      }
      this.in.seek(l2);
      return this.in.tell() - l1;
    }
    
    public long tell()
      throws IOException
    {
      return this.in.tell();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/DataFileReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */