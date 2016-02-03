package com.google.tagmanager.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

public abstract class MessageNano
{
  protected int cachedSize = -1;
  
  public static final <T extends MessageNano> T mergeFrom(T paramT, byte[] paramArrayOfByte)
    throws InvalidProtocolBufferNanoException
  {
    return mergeFrom(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final <T extends MessageNano> T mergeFrom(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferNanoException
  {
    try
    {
      paramArrayOfByte = CodedInputByteBufferNano.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      paramT.mergeFrom(paramArrayOfByte);
      paramArrayOfByte.checkLastTagWas(0);
      return paramT;
    }
    catch (InvalidProtocolBufferNanoException paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final boolean messageNanoEquals(MessageNano paramMessageNano1, MessageNano paramMessageNano2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMessageNano1 == paramMessageNano2) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramMessageNano1 == null);
          bool1 = bool2;
        } while (paramMessageNano2 == null);
        bool1 = bool2;
      } while (paramMessageNano1.getClass() != paramMessageNano2.getClass());
      i = paramMessageNano1.getSerializedSize();
      bool1 = bool2;
    } while (paramMessageNano2.getSerializedSize() != i);
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[i];
    toByteArray(paramMessageNano1, arrayOfByte1, 0, i);
    toByteArray(paramMessageNano2, arrayOfByte2, 0, i);
    return Arrays.equals(arrayOfByte1, arrayOfByte2);
  }
  
  public static final void toByteArray(MessageNano paramMessageNano, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = CodedOutputByteBufferNano.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      paramMessageNano.writeTo(paramArrayOfByte);
      paramArrayOfByte.checkNoSpaceLeft();
      return;
    }
    catch (IOException paramMessageNano)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramMessageNano);
    }
  }
  
  public static final byte[] toByteArray(MessageNano paramMessageNano)
  {
    byte[] arrayOfByte = new byte[paramMessageNano.getSerializedSize()];
    toByteArray(paramMessageNano, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public int getCachedSize()
  {
    if (this.cachedSize < 0) {
      getSerializedSize();
    }
    return this.cachedSize;
  }
  
  public int getSerializedSize()
  {
    this.cachedSize = 0;
    return 0;
  }
  
  public abstract MessageNano mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException;
  
  public String toString()
  {
    return MessageNanoPrinter.print(this);
  }
  
  public abstract void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/protobuf/nano/MessageNano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */