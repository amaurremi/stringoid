package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.DefaultErrorHandler;
import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLErrorHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLParseException;
import java.util.Hashtable;
import java.util.Locale;

public class XMLErrorReporter
{
  private static final Boolean[] FEATURE_DEFAULTS;
  private static final Object[] PROPERTY_DEFAULTS = { null };
  private static final String[] RECOGNIZED_FEATURES = { "http://apache.org/xml/features/continue-after-fatal-error" };
  private static final String[] RECOGNIZED_PROPERTIES;
  protected boolean fContinueAfterFatalError;
  protected XMLErrorHandler fDefaultErrorHandler;
  protected XMLErrorHandler fErrorHandler;
  protected Locale fLocale;
  protected XMLLocator fLocator;
  protected Hashtable fMessageFormatters = new Hashtable();
  
  static
  {
    FEATURE_DEFAULTS = new Boolean[] { null };
    RECOGNIZED_PROPERTIES = new String[] { "http://apache.org/xml/properties/internal/error-handler" };
  }
  
  public Locale getLocale()
  {
    return this.fLocale;
  }
  
  public MessageFormatter getMessageFormatter(String paramString)
  {
    return (MessageFormatter)this.fMessageFormatters.get(paramString);
  }
  
  public void putMessageFormatter(String paramString, MessageFormatter paramMessageFormatter)
  {
    this.fMessageFormatters.put(paramString, paramMessageFormatter);
  }
  
  public void reportError(XMLLocator paramXMLLocator, String paramString1, String paramString2, Object[] paramArrayOfObject, short paramShort)
  {
    int j = 0;
    Object localObject = getMessageFormatter(paramString1);
    if (localObject != null)
    {
      paramArrayOfObject = ((MessageFormatter)localObject).formatMessage(this.fLocale, paramString2, paramArrayOfObject);
      localObject = new XMLParseException(paramXMLLocator, paramArrayOfObject);
      paramArrayOfObject = this.fErrorHandler;
      paramXMLLocator = paramArrayOfObject;
      if (paramArrayOfObject == null)
      {
        if (this.fDefaultErrorHandler == null) {
          this.fDefaultErrorHandler = new DefaultErrorHandler();
        }
        paramXMLLocator = this.fDefaultErrorHandler;
      }
      switch (paramShort)
      {
      }
    }
    do
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
      paramArrayOfObject = ((StringBuffer)localObject).toString();
      break;
      paramXMLLocator.warning(paramString1, paramString2, (XMLParseException)localObject);
      return;
      paramXMLLocator.error(paramString1, paramString2, (XMLParseException)localObject);
      return;
      paramXMLLocator.fatalError(paramString1, paramString2, (XMLParseException)localObject);
    } while (this.fContinueAfterFatalError);
    throw ((Throwable)localObject);
  }
  
  public void reportError(String paramString1, String paramString2, Object[] paramArrayOfObject, short paramShort)
  {
    reportError(this.fLocator, paramString1, paramString2, paramArrayOfObject, paramShort);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLErrorReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */