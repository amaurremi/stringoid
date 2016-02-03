package org.codehaus.jackson.io;

import java.io.InputStream;
import java.io.Reader;

public abstract class InputDecorator
{
  public abstract InputStream decorate(IOContext paramIOContext, InputStream paramInputStream);
  
  public abstract InputStream decorate(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract Reader decorate(IOContext paramIOContext, Reader paramReader);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/io/InputDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */