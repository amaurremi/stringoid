package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;

class StaxErrorReporter$1
  implements Location
{
  StaxErrorReporter$1(StaxErrorReporter paramStaxErrorReporter, XMLLocator paramXMLLocator) {}
  
  public int getColumnNumber()
  {
    return this.val$location.getColumnNumber();
  }
  
  public int getLineNumber()
  {
    return this.val$location.getLineNumber();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/StaxErrorReporter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */