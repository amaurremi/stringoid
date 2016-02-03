package com.amazonaws.javax.xml.stream;

class FactoryFinder$ConfigurationError
  extends Error
{
  private Exception exception;
  
  FactoryFinder$ConfigurationError(String paramString, Exception paramException)
  {
    super(paramString);
    this.exception = paramException;
  }
  
  public Throwable getCause()
  {
    return this.exception;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/FactoryFinder$ConfigurationError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */