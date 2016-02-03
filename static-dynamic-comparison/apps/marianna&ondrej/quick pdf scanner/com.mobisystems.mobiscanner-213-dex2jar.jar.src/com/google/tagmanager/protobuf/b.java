package com.google.tagmanager.protobuf;

import java.io.IOException;

public abstract class b
  implements p
{
  protected int cachedSize = -1;
  private boolean isMutable = true;
  
  UninitializedMessageException AE()
  {
    return new UninitializedMessageException(this);
  }
  
  public p AF()
  {
    throw new UnsupportedOperationException("clone() should be implemented by subclasses.");
  }
  
  protected boolean AG()
  {
    return false;
  }
  
  public void a(CodedOutputStream paramCodedOutputStream)
  {
    fI();
    c(paramCodedOutputStream);
  }
  
  public boolean b(f paramf)
  {
    return p(paramf, g.Bu());
  }
  
  public n.a fM()
  {
    throw new UnsupportedOperationException("toBuilder() is not supported in mutable messages.");
  }
  
  public n.a fN()
  {
    throw new UnsupportedOperationException("newBuilderForType() is not supported in mutable messages.");
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */