package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;

@Immutable
public class NonRepeatableRequestException
  extends ProtocolException
{
  public NonRepeatableRequestException() {}
  
  public NonRepeatableRequestException(String paramString)
  {
    super(paramString);
  }
  
  public NonRepeatableRequestException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/NonRepeatableRequestException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */