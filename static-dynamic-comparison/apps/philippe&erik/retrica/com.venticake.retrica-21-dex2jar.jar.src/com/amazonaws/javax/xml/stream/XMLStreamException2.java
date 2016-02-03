package com.amazonaws.javax.xml.stream;

public class XMLStreamException2
  extends XMLStreamException
{
  public XMLStreamException2(String paramString)
  {
    super(paramString);
  }
  
  public XMLStreamException2(String paramString, Location paramLocation, Throwable paramThrowable)
  {
    super(paramString, paramLocation, paramThrowable);
  }
  
  public XMLStreamException2(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public XMLStreamException2(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public Throwable getCause()
  {
    return getNestedException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLStreamException2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */