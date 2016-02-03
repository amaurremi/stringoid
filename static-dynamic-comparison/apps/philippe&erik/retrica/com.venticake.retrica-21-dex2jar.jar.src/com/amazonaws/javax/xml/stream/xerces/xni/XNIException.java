package com.amazonaws.javax.xml.stream.xerces.xni;

public class XNIException
  extends RuntimeException
{
  private Exception fException;
  
  public XNIException(Exception paramException)
  {
    super(paramException.getMessage());
    this.fException = paramException;
  }
  
  public XNIException(String paramString)
  {
    super(paramString);
  }
  
  public Exception getException()
  {
    return this.fException;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/XNIException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */