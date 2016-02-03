package com.amazonaws.org.apache.http;

public class HttpException
  extends Exception
{
  public HttpException() {}
  
  public HttpException(String paramString)
  {
    super(paramString);
  }
  
  public HttpException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/HttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */