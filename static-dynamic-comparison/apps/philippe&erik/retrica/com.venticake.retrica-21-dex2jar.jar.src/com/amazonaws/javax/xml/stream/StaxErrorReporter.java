package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;

public class StaxErrorReporter
  extends XMLErrorReporter
{
  protected XMLReporter fXMLReporter = null;
  
  public StaxErrorReporter()
  {
    putMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210", new XMLMessageFormatter());
  }
  
  Location convertToStaxLocation(XMLLocator paramXMLLocator)
  {
    return new StaxErrorReporter.1(this, paramXMLLocator);
  }
  
  public void reportError(XMLLocator paramXMLLocator, String paramString1, String paramString2, Object[] paramArrayOfObject, short paramShort)
  {
    int j = 0;
    Object localObject = getMessageFormatter(paramString1);
    if (localObject != null)
    {
      paramString1 = ((MessageFormatter)localObject).formatMessage(this.fLocale, paramString2, paramArrayOfObject);
      switch (paramShort)
      {
      }
    }
    do
    {
      for (;;)
      {
        return;
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append(paramString1);
        ((StringBuffer)localObject).append('#');
        ((StringBuffer)localObject).append(paramString2);
        if (paramArrayOfObject != null) {}
        for (int i = paramArrayOfObject.length; i > 0; i = 0)
        {
          ((StringBuffer)localObject).append('?');
          while (j < i)
          {
            ((StringBuffer)localObject).append(paramArrayOfObject[j]);
            if (j < i - 1) {
              ((StringBuffer)localObject).append('&');
            }
            j += 1;
          }
        }
        paramString1 = ((StringBuffer)localObject).toString();
        break;
        try
        {
          if (this.fXMLReporter == null) {
            continue;
          }
          this.fXMLReporter.report(paramString1, "WARNING", null, convertToStaxLocation(paramXMLLocator));
          return;
        }
        catch (XMLStreamException paramXMLLocator)
        {
          throw new XNIException(paramXMLLocator);
        }
        try
        {
          if (this.fXMLReporter != null)
          {
            this.fXMLReporter.report(paramString1, "ERROR", null, convertToStaxLocation(paramXMLLocator));
            return;
          }
        }
        catch (XMLStreamException paramXMLLocator)
        {
          throw new XNIException(paramXMLLocator);
        }
      }
    } while (this.fContinueAfterFatalError);
    throw new XNIException(paramString1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/StaxErrorReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */