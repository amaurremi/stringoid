package com.amazonaws.javax.xml.stream;

public class XMLStreamException
  extends Exception
{
  protected Location location;
  protected Throwable nested;
  
  public XMLStreamException() {}
  
  public XMLStreamException(String paramString)
  {
    super(paramString);
  }
  
  public XMLStreamException(String paramString, Location paramLocation, Throwable paramThrowable)
  {
    super("ParseError at [row,col]:[" + paramLocation.getLineNumber() + "," + paramLocation.getColumnNumber() + "]\n" + "Message: " + paramString);
    this.nested = paramThrowable;
    this.location = paramLocation;
  }
  
  public XMLStreamException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.nested = paramThrowable;
  }
  
  public XMLStreamException(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.nested = paramThrowable;
  }
  
  public Throwable getNestedException()
  {
    return this.nested;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLStreamException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */