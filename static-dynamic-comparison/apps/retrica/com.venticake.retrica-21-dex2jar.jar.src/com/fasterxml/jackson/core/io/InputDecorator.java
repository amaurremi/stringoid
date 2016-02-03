package com.fasterxml.jackson.core.io;

import java.io.InputStream;
import java.io.Serializable;

public abstract class InputDecorator
  implements Serializable
{
  public abstract InputStream decorate(IOContext paramIOContext, InputStream paramInputStream);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/InputDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */