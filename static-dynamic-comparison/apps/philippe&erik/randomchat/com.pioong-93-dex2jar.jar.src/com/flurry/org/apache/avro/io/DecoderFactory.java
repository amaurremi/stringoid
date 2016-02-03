package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.Schema;
import java.io.IOException;
import java.io.InputStream;

public class DecoderFactory
{
  static final int DEFAULT_BUFFER_SIZE = 8192;
  private static final DecoderFactory DEFAULT_FACTORY = new DefaultDecoderFactory(null);
  int binaryDecoderBufferSize = 8192;
  
  @Deprecated
  public static DecoderFactory defaultFactory()
  {
    return get();
  }
  
  public static DecoderFactory get()
  {
    return DEFAULT_FACTORY;
  }
  
  public BinaryDecoder binaryDecoder(InputStream paramInputStream, BinaryDecoder paramBinaryDecoder)
  {
    if ((paramBinaryDecoder == null) || (!paramBinaryDecoder.getClass().equals(BinaryDecoder.class))) {
      return new BinaryDecoder(paramInputStream, this.binaryDecoderBufferSize);
    }
    return paramBinaryDecoder.configure(paramInputStream, this.binaryDecoderBufferSize);
  }
  
  public BinaryDecoder binaryDecoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BinaryDecoder paramBinaryDecoder)
  {
    if ((paramBinaryDecoder == null) || (!paramBinaryDecoder.getClass().equals(BinaryDecoder.class))) {
      return new BinaryDecoder(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramBinaryDecoder.configure(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public BinaryDecoder binaryDecoder(byte[] paramArrayOfByte, BinaryDecoder paramBinaryDecoder)
  {
    return binaryDecoder(paramArrayOfByte, 0, paramArrayOfByte.length, paramBinaryDecoder);
  }
  
  public DecoderFactory configureDecoderBufferSize(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 32) {
      i = 32;
    }
    paramInt = i;
    if (i > 16777216) {
      paramInt = 16777216;
    }
    this.binaryDecoderBufferSize = paramInt;
    return this;
  }
  
  @Deprecated
  public BinaryDecoder createBinaryDecoder(InputStream paramInputStream, BinaryDecoder paramBinaryDecoder)
  {
    return binaryDecoder(paramInputStream, paramBinaryDecoder);
  }
  
  @Deprecated
  public BinaryDecoder createBinaryDecoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BinaryDecoder paramBinaryDecoder)
  {
    if ((paramBinaryDecoder == null) || (!paramBinaryDecoder.getClass().equals(BinaryDecoder.class))) {
      return new BinaryDecoder(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramBinaryDecoder.configure(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @Deprecated
  public BinaryDecoder createBinaryDecoder(byte[] paramArrayOfByte, BinaryDecoder paramBinaryDecoder)
  {
    return binaryDecoder(paramArrayOfByte, 0, paramArrayOfByte.length, paramBinaryDecoder);
  }
  
  public BinaryDecoder directBinaryDecoder(InputStream paramInputStream, BinaryDecoder paramBinaryDecoder)
  {
    if ((paramBinaryDecoder == null) || (!paramBinaryDecoder.getClass().equals(DirectBinaryDecoder.class))) {
      return new DirectBinaryDecoder(paramInputStream);
    }
    return ((DirectBinaryDecoder)paramBinaryDecoder).configure(paramInputStream);
  }
  
  public int getConfiguredBufferSize()
  {
    return this.binaryDecoderBufferSize;
  }
  
  public JsonDecoder jsonDecoder(Schema paramSchema, InputStream paramInputStream)
    throws IOException
  {
    return new JsonDecoder(paramSchema, paramInputStream);
  }
  
  public JsonDecoder jsonDecoder(Schema paramSchema, String paramString)
    throws IOException
  {
    return new JsonDecoder(paramSchema, paramString);
  }
  
  public ResolvingDecoder resolvingDecoder(Schema paramSchema1, Schema paramSchema2, Decoder paramDecoder)
    throws IOException
  {
    return new ResolvingDecoder(paramSchema1, paramSchema2, paramDecoder);
  }
  
  public ValidatingDecoder validatingDecoder(Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    return new ValidatingDecoder(paramSchema, paramDecoder);
  }
  
  private static class DefaultDecoderFactory
    extends DecoderFactory
  {
    public DecoderFactory configureDecoderBufferSize(int paramInt)
    {
      throw new IllegalArgumentException("This Factory instance is Immutable");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/DecoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */