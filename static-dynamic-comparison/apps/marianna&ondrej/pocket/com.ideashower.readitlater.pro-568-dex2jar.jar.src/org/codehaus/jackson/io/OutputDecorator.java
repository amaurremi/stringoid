package org.codehaus.jackson.io;

import java.io.OutputStream;
import java.io.Writer;

public abstract class OutputDecorator
{
  public abstract OutputStream decorate(IOContext paramIOContext, OutputStream paramOutputStream);
  
  public abstract Writer decorate(IOContext paramIOContext, Writer paramWriter);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/io/OutputDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */