package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.InputStream;

public class StaxEntityResolverWrapper
{
  XMLResolver fStaxResolver;
  
  public StaxEntityResolverWrapper(XMLResolver paramXMLResolver)
  {
    this.fStaxResolver = paramXMLResolver;
  }
  
  StaxXMLInputSource getStaxInputSource(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof InputStream)) {
        return new StaxXMLInputSource(new XMLInputSource(null, null, null, (InputStream)paramObject, null));
      }
      if ((paramObject instanceof XMLStreamReader)) {
        return new StaxXMLInputSource((XMLStreamReader)paramObject);
      }
    } while (!(paramObject instanceof XMLEventReader));
    return new StaxXMLInputSource((XMLEventReader)paramObject);
  }
  
  public StaxXMLInputSource resolveEntity(XMLResourceIdentifier paramXMLResourceIdentifier)
  {
    try
    {
      paramXMLResourceIdentifier = getStaxInputSource(this.fStaxResolver.resolveEntity(paramXMLResourceIdentifier.getPublicId(), paramXMLResourceIdentifier.getLiteralSystemId(), paramXMLResourceIdentifier.getBaseSystemId(), null));
      return paramXMLResourceIdentifier;
    }
    catch (XMLStreamException paramXMLResourceIdentifier)
    {
      throw new XNIException(paramXMLResourceIdentifier);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/StaxEntityResolverWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */