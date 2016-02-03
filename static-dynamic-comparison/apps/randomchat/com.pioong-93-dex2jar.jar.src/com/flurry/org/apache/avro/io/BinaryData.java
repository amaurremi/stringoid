package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.Schema.Field.Order;
import com.flurry.org.apache.avro.generic.GenericDatumReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class BinaryData
{
  private static final ThreadLocal<Decoders> DECODERS = new ThreadLocal()
  {
    protected BinaryData.Decoders initialValue()
    {
      return new BinaryData.Decoders();
    }
  };
  private static final ThreadLocal<HashData> HASH_DATA = new ThreadLocal()
  {
    protected BinaryData.HashData initialValue()
    {
      return new BinaryData.HashData();
    }
  };
  
  private static int compare(Decoders paramDecoders, Schema paramSchema)
    throws IOException
  {
    BinaryDecoder localBinaryDecoder1 = paramDecoders.d1;
    BinaryDecoder localBinaryDecoder2 = paramDecoders.d2;
    int i;
    int j;
    long l1;
    long l2;
    switch (paramSchema.getType())
    {
    default: 
      throw new AvroRuntimeException("Unexpected schema to compare!");
    case ???: 
      paramSchema = paramSchema.getFields().iterator();
      while (paramSchema.hasNext())
      {
        Schema.Field localField = (Schema.Field)paramSchema.next();
        if (localField.order() == Schema.Field.Order.IGNORE)
        {
          GenericDatumReader.skip(localField.schema(), localBinaryDecoder1);
          GenericDatumReader.skip(localField.schema(), localBinaryDecoder2);
        }
        else
        {
          i = compare(paramDecoders, localField.schema());
          if (i != 0)
          {
            if (localField.order() != Schema.Field.Order.DESCENDING) {}
            for (;;)
            {
              return i;
              i = -i;
            }
          }
        }
      }
      return 0;
    case ???: 
    case ???: 
      i = localBinaryDecoder1.readInt();
      j = localBinaryDecoder2.readInt();
      if (i == j) {
        return 0;
      }
      if (i > j) {
        return 1;
      }
      return -1;
    case ???: 
      l1 = localBinaryDecoder1.readLong();
      l2 = localBinaryDecoder2.readLong();
      if (l1 == l2) {
        return 0;
      }
      if (l1 > l2) {
        return 1;
      }
      return -1;
    case ???: 
      long l6 = 0L;
      long l3 = 0L;
      l1 = 0L;
      long l8 = 0L;
      long l5 = 0L;
      long l7 = l8;
      l2 = l3;
      if (l3 == 0L)
      {
        l3 = localBinaryDecoder1.readLong();
        l2 = l3;
        if (l3 < 0L)
        {
          l2 = -l3;
          localBinaryDecoder1.readLong();
        }
        l7 = l8 + l2;
      }
      long l9 = l5;
      long l4 = l1;
      if (l1 == 0L)
      {
        l1 = localBinaryDecoder2.readLong();
        l4 = l1;
        if (l1 < 0L)
        {
          l4 = -l1;
          localBinaryDecoder2.readLong();
        }
        l9 = l5 + l4;
      }
      if ((l2 == 0L) || (l4 == 0L))
      {
        if (l7 == l9) {
          return 0;
        }
        if (l7 > l9) {
          return 1;
        }
        return -1;
      }
      long l11 = Math.min(l7, l9);
      long l10 = l6;
      for (;;)
      {
        l6 = l10;
        l8 = l7;
        l5 = l9;
        l3 = l2;
        l1 = l4;
        if (l10 >= l11) {
          break;
        }
        i = compare(paramDecoders, paramSchema.getElementType());
        if (i != 0) {
          return i;
        }
        l10 += 1L;
        l2 -= 1L;
        l4 -= 1L;
      }
    case ???: 
      throw new AvroRuntimeException("Can't compare maps!");
    case ???: 
      i = localBinaryDecoder1.readInt();
      j = localBinaryDecoder2.readInt();
      if (i == j) {
        return compare(paramDecoders, (Schema)paramSchema.getTypes().get(i));
      }
      return i - j;
    case ???: 
      i = paramSchema.getFixedSize();
      j = compareBytes(paramDecoders.b1.getBuf(), paramDecoders.b1.getPos(), i, paramDecoders.b2.getBuf(), paramDecoders.b2.getPos(), i);
      paramDecoders.d1.skipFixed(i);
      paramDecoders.d2.skipFixed(i);
      return j;
    case ???: 
    case ???: 
      i = localBinaryDecoder1.readInt();
      j = localBinaryDecoder2.readInt();
      int k = compareBytes(paramDecoders.b1.getBuf(), paramDecoders.b1.getPos(), i, paramDecoders.b2.getBuf(), paramDecoders.b2.getPos(), j);
      paramDecoders.d1.skipFixed(i);
      paramDecoders.d2.skipFixed(j);
      return k;
    case ???: 
      float f1 = localBinaryDecoder1.readFloat();
      float f2 = localBinaryDecoder2.readFloat();
      if (f1 == f2) {
        return 0;
      }
      if (f1 > f2) {
        return 1;
      }
      return -1;
    case ???: 
      double d1 = localBinaryDecoder1.readDouble();
      double d2 = localBinaryDecoder2.readDouble();
      if (d1 == d2) {
        return 0;
      }
      if (d1 > d2) {
        return 1;
      }
      return -1;
    case ???: 
      boolean bool = localBinaryDecoder1.readBoolean();
      if (bool == localBinaryDecoder2.readBoolean()) {
        return 0;
      }
      if (bool) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  public static int compare(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, Schema paramSchema)
  {
    Decoders localDecoders = (Decoders)DECODERS.get();
    localDecoders.set(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3, paramInt4);
    try
    {
      paramInt1 = compare(localDecoders, paramSchema);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte1)
    {
      throw new AvroRuntimeException(paramArrayOfByte1);
    }
  }
  
  public static int compare(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, Schema paramSchema)
  {
    return compare(paramArrayOfByte1, paramInt1, paramArrayOfByte1.length - paramInt1, paramArrayOfByte2, paramInt2, paramArrayOfByte2.length - paramInt2, paramSchema);
  }
  
  public static int compareBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    int i = paramInt3;
    while ((j < paramInt1 + paramInt2) && (i < paramInt3 + paramInt4))
    {
      int k = paramArrayOfByte1[j] & 0xFF;
      int m = paramArrayOfByte2[i] & 0xFF;
      if (k != m) {
        return k - m;
      }
      j += 1;
      i += 1;
    }
    return paramInt2 - paramInt4;
  }
  
  public static int encodeBoolean(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramArrayOfByte[paramInt] = i;
      return 1;
    }
  }
  
  public static int encodeDouble(double paramDouble, byte[] paramArrayOfByte, int paramInt)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    int i = (int)(l & 0xFFFFFFFFFFFFFFFF);
    int j = (int)(l >>> 32 & 0xFFFFFFFFFFFFFFFF);
    paramArrayOfByte[paramInt] = ((byte)(i & 0xFF));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(j & 0xFF));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(j >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(i >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(i >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(j >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(j >>> 24 & 0xFF));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(i >>> 24 & 0xFF));
    return 8;
  }
  
  public static int encodeFloat(float paramFloat, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Float.floatToRawIntBits(paramFloat);
    paramArrayOfByte[paramInt] = ((byte)(i & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(i >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(i >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(i >>> 24 & 0xFF));
    return 4;
  }
  
  public static int encodeInt(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int j = paramInt1 << 1 ^ paramInt1 >> 31;
    int i = j;
    paramInt1 = paramInt2;
    if ((j & 0xFFFFFF80) != 0)
    {
      int k = paramInt2 + 1;
      paramArrayOfByte[paramInt2] = ((byte)((j | 0x80) & 0xFF));
      int m = j >>> 7;
      paramInt1 = k;
      i = m;
      if (m <= 127) {
        break label181;
      }
      j = k + 1;
      paramArrayOfByte[k] = ((byte)((m | 0x80) & 0xFF));
      m >>>= 7;
      i = m;
      paramInt1 = j;
      if (m > 127)
      {
        k = j + 1;
        paramArrayOfByte[j] = ((byte)((m | 0x80) & 0xFF));
        j = m >>> 7;
        paramInt1 = k;
        i = j;
        if (j <= 127) {
          break label181;
        }
        paramInt1 = k + 1;
        paramArrayOfByte[k] = ((byte)((j | 0x80) & 0xFF));
        i = j >>> 7;
      }
    }
    label181:
    for (;;)
    {
      paramArrayOfByte[paramInt1] = ((byte)i);
      return paramInt1 + 1 - paramInt2;
    }
  }
  
  public static int encodeLong(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    long l = paramLong << 1 ^ paramLong >> 63;
    paramLong = l;
    int i = paramInt;
    if ((0xFFFFFFFFFFFFFF80 & l) != 0L)
    {
      int k = paramInt + 1;
      paramArrayOfByte[paramInt] = ((byte)(int)((0x80 | l) & 0xFF));
      l >>>= 7;
      i = k;
      paramLong = l;
      if (l <= 127L) {
        break label427;
      }
      int j = k + 1;
      paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
      l >>>= 7;
      paramLong = l;
      i = j;
      if (l > 127L)
      {
        k = j + 1;
        paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
        l >>>= 7;
        i = k;
        paramLong = l;
        if (l <= 127L) {
          break label427;
        }
        j = k + 1;
        paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
        l >>>= 7;
        paramLong = l;
        i = j;
        if (l > 127L)
        {
          k = j + 1;
          paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
          l >>>= 7;
          i = k;
          paramLong = l;
          if (l <= 127L) {
            break label427;
          }
          j = k + 1;
          paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
          l >>>= 7;
          paramLong = l;
          i = j;
          if (l > 127L)
          {
            k = j + 1;
            paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
            l >>>= 7;
            i = k;
            paramLong = l;
            if (l <= 127L) {
              break label427;
            }
            j = k + 1;
            paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
            l >>>= 7;
            paramLong = l;
            i = j;
            if (l > 127L)
            {
              paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
              paramLong = l >>> 7;
              i = j + 1;
            }
          }
        }
      }
    }
    label427:
    for (;;)
    {
      paramArrayOfByte[i] = ((byte)(int)paramLong);
      return i + 1 - paramInt;
    }
  }
  
  private static int hashBytes(int paramInt1, HashData paramHashData, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    byte[] arrayOfByte = paramHashData.bytes.getBuf();
    int k = paramHashData.bytes.getPos();
    int m = k + paramInt2;
    int i;
    if (paramBoolean)
    {
      j = m - 1;
      for (;;)
      {
        i = paramInt1;
        if (j < k) {
          break;
        }
        paramInt1 = paramInt1 * 31 + arrayOfByte[j];
        j -= 1;
      }
    }
    int j = k;
    for (;;)
    {
      i = paramInt1;
      if (j >= m) {
        break;
      }
      paramInt1 = paramInt1 * 31 + arrayOfByte[j];
      j += 1;
    }
    paramHashData.decoder.skipFixed(paramInt2);
    return i;
  }
  
  private static int hashCode(HashData paramHashData, Schema paramSchema)
    throws IOException
  {
    int i = 0;
    BinaryDecoder localBinaryDecoder = paramHashData.decoder;
    int j;
    long l1;
    switch (paramSchema.getType())
    {
    default: 
      throw new AvroRuntimeException("Unexpected schema to hashCode!");
    case ???: 
      j = 1;
      paramSchema = paramSchema.getFields().iterator();
      for (;;)
      {
        i = j;
        if (!paramSchema.hasNext()) {
          break;
        }
        Schema.Field localField = (Schema.Field)paramSchema.next();
        if (localField.order() == Schema.Field.Order.IGNORE) {
          GenericDatumReader.skip(localField.schema(), localBinaryDecoder);
        } else {
          j = j * 31 + hashCode(paramHashData, localField.schema());
        }
      }
    case ???: 
    case ???: 
      i = localBinaryDecoder.readInt();
    case ???: 
      return i;
    case ???: 
      return Float.floatToIntBits(localBinaryDecoder.readFloat());
    case ???: 
      l1 = localBinaryDecoder.readLong();
      return (int)(l1 >>> 32 ^ l1);
    case ???: 
      l1 = Double.doubleToLongBits(localBinaryDecoder.readDouble());
      return (int)(l1 >>> 32 ^ l1);
    case ???: 
      paramSchema = paramSchema.getElementType();
      j = 1;
      for (l1 = localBinaryDecoder.readArrayStart();; l1 = localBinaryDecoder.arrayNext())
      {
        i = j;
        if (l1 == 0L) {
          break;
        }
        for (long l2 = 0L; l2 < l1; l2 += 1L) {
          j = j * 31 + hashCode(paramHashData, paramSchema);
        }
      }
    case ???: 
      throw new AvroRuntimeException("Can't hashCode maps!");
    case ???: 
      return hashCode(paramHashData, (Schema)paramSchema.getTypes().get(localBinaryDecoder.readInt()));
    case ???: 
      return hashBytes(1, paramHashData, paramSchema.getFixedSize(), false);
    case ???: 
      return hashBytes(0, paramHashData, localBinaryDecoder.readInt(), false);
    case ???: 
      return hashBytes(1, paramHashData, localBinaryDecoder.readInt(), true);
    }
    if (localBinaryDecoder.readBoolean()) {}
    for (i = 1231;; i = 1237) {
      return i;
    }
  }
  
  public static int hashCode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Schema paramSchema)
  {
    HashData localHashData = (HashData)HASH_DATA.get();
    localHashData.set(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      paramInt1 = hashCode(localHashData, paramSchema);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new AvroRuntimeException(paramArrayOfByte);
    }
  }
  
  public static int skipLong(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    int j = paramArrayOfByte[paramInt];
    paramInt = i;
    i = j;
    while ((i & 0x80) != 0)
    {
      i = paramArrayOfByte[paramInt];
      paramInt += 1;
    }
    return paramInt;
  }
  
  private static class Decoders
  {
    private final BinaryDecoder.BufferAccessor b1 = this.d1.getBufferAccessor();
    private final BinaryDecoder.BufferAccessor b2 = this.d2.getBufferAccessor();
    private final BinaryDecoder d1 = new BinaryDecoder(new byte[0], 0, 0);
    private final BinaryDecoder d2 = new BinaryDecoder(new byte[0], 0, 0);
    
    public void set(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
    {
      this.d1.configure(paramArrayOfByte1, paramInt1, paramInt2);
      this.d2.configure(paramArrayOfByte2, paramInt3, paramInt4);
    }
  }
  
  private static class HashData
  {
    private final BinaryDecoder.BufferAccessor bytes = this.decoder.getBufferAccessor();
    private final BinaryDecoder decoder = new BinaryDecoder(new byte[0], 0, 0);
    
    public void set(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.decoder.configure(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/BinaryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */