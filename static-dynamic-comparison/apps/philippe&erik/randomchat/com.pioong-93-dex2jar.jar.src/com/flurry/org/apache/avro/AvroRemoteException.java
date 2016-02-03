package com.flurry.org.apache.avro;

import java.io.IOException;

public class AvroRemoteException
  extends IOException
{
  private Object value;
  
  protected AvroRemoteException() {}
  
  public AvroRemoteException(Object paramObject) {}
  
  public AvroRemoteException(Object paramObject, Throwable paramThrowable) {}
  
  public AvroRemoteException(Throwable paramThrowable)
  {
    this(paramThrowable.toString());
    initCause(paramThrowable);
  }
  
  public Object getValue()
  {
    return this.value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/AvroRemoteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */