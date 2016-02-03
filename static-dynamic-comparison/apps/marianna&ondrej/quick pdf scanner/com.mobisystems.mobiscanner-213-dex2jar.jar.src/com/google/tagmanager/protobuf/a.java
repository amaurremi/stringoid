package com.google.tagmanager.protobuf;

import java.io.IOException;

public abstract class a
  implements n
{
  protected int memoizedHashCode = 0;
  
  UninitializedMessageException AE()
  {
    return new UninitializedMessageException(this);
  }
  
  public byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[fI()];
      CodedOutputStream localCodedOutputStream = CodedOutputStream.m(arrayOfByte);
      a(localCodedOutputStream);
      localCodedOutputStream.Bt();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public static abstract class a<BuilderType extends a>
    implements n.a
  {
    protected static UninitializedMessageException a(n paramn)
    {
      return new UninitializedMessageException(paramn);
    }
    
    public BuilderType a(f paramf)
    {
      return d(paramf, g.Bu());
    }
    
    public abstract BuilderType d(f paramf, g paramg);
    
    public BuilderType d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        paramArrayOfByte = f.f(paramArrayOfByte, paramInt1, paramInt2);
        a(paramArrayOfByte);
        paramArrayOfByte.eT(0);
        return this;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramArrayOfByte);
      }
    }
    
    public abstract BuilderType fW();
    
    public BuilderType i(byte[] paramArrayOfByte)
    {
      return d(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */