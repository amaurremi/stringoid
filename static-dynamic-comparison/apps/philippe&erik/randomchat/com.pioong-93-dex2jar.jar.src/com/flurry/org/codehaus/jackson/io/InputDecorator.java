package com.flurry.org.codehaus.jackson.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public abstract class InputDecorator
{
  public abstract InputStream decorate(IOContext paramIOContext, InputStream paramInputStream)
    throws IOException;
  
  public abstract InputStream decorate(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract Reader decorate(IOContext paramIOContext, Reader paramReader)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/io/InputDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */