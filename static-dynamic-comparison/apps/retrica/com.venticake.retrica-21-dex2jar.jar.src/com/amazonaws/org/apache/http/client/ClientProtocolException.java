package com.amazonaws.org.apache.http.client;

import java.io.IOException;
import org.apache.http.annotation.Immutable;

@Immutable
public class ClientProtocolException
  extends IOException
{
  public ClientProtocolException() {}
  
  public ClientProtocolException(String paramString)
  {
    super(paramString);
  }
  
  public ClientProtocolException(Throwable paramThrowable)
  {
    initCause(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/ClientProtocolException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */