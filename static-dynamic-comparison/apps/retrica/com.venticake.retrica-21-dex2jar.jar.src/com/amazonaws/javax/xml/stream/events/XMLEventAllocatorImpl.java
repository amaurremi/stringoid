package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.XMLStreamException2;
import com.amazonaws.javax.xml.stream.XMLStreamReader;
import com.amazonaws.javax.xml.stream.util.XMLEventAllocator;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceContextWrapper;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import java.util.List;

public class XMLEventAllocatorImpl
  implements XMLEventAllocator
{
  private QName getQName(XMLStreamReader paramXMLStreamReader)
  {
    return new QName(paramXMLStreamReader.getNamespaceURI(), paramXMLStreamReader.getLocalName(), paramXMLStreamReader.getPrefix());
  }
  
  private void setNamespaceContext(StartElementEvent paramStartElementEvent, XMLStreamReader paramXMLStreamReader)
  {
    paramStartElementEvent.setNamespaceContext(new NamespaceContextWrapper(new NamespaceSupport(((NamespaceContextWrapper)paramXMLStreamReader.getNamespaceContext()).getNamespaceContext())));
  }
  
  public XMLEvent allocate(XMLStreamReader paramXMLStreamReader)
  {
    if (paramXMLStreamReader == null) {
      throw new XMLStreamException2("Reader cannot be null");
    }
    return getXMLEvent(paramXMLStreamReader);
  }
  
  protected void fillAttributes(StartElementEvent paramStartElementEvent, XMLStreamReader paramXMLStreamReader)
  {
    int j = paramXMLStreamReader.getAttributeCount();
    int i = 0;
    while (i < j)
    {
      QName localQName = paramXMLStreamReader.getAttributeName(i);
      localQName.getPrefix();
      localQName.getLocalPart();
      AttributeImpl localAttributeImpl = new AttributeImpl();
      localAttributeImpl.setName(localQName);
      localAttributeImpl.setAttributeType(paramXMLStreamReader.getAttributeType(i));
      localAttributeImpl.setSpecified(paramXMLStreamReader.isAttributeSpecified(i));
      localAttributeImpl.setValue(paramXMLStreamReader.getAttributeValue(i));
      paramStartElementEvent.addAttribute(localAttributeImpl);
      i += 1;
    }
  }
  
  protected void fillNamespaceAttributes(EndElementEvent paramEndElementEvent, XMLStreamReader paramXMLStreamReader)
  {
    int j = paramXMLStreamReader.getNamespaceCount();
    int i = 0;
    while (i < j)
    {
      String str3 = paramXMLStreamReader.getNamespaceURI(i);
      String str2 = paramXMLStreamReader.getNamespacePrefix(i);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramEndElementEvent.addNamespace(new NamespaceImpl(str1, str3));
      i += 1;
    }
  }
  
  protected void fillNamespaceAttributes(StartElementEvent paramStartElementEvent, XMLStreamReader paramXMLStreamReader)
  {
    int j = paramXMLStreamReader.getNamespaceCount();
    int i = 0;
    while (i < j)
    {
      String str3 = paramXMLStreamReader.getNamespaceURI(i);
      String str2 = paramXMLStreamReader.getNamespacePrefix(i);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramStartElementEvent.addNamespaceAttribute(new NamespaceImpl(str1, str3));
      i += 1;
    }
  }
  
  XMLEvent getXMLEvent(XMLStreamReader paramXMLStreamReader)
  {
    switch (paramXMLStreamReader.getEventType())
    {
    case 10: 
    default: 
      return null;
    case 1: 
      localObject = new StartElementEvent(getQName(paramXMLStreamReader));
      fillAttributes((StartElementEvent)localObject, paramXMLStreamReader);
      if (((Boolean)paramXMLStreamReader.getProperty("com.amazonaws.javax.xml.stream.isNamespaceAware")).booleanValue())
      {
        fillNamespaceAttributes((StartElementEvent)localObject, paramXMLStreamReader);
        setNamespaceContext((StartElementEvent)localObject, paramXMLStreamReader);
      }
      ((StartElementEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      return (XMLEvent)localObject;
    case 2: 
      localObject = new EndElementEvent(getQName(paramXMLStreamReader));
      ((EndElementEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      if (((Boolean)paramXMLStreamReader.getProperty("com.amazonaws.javax.xml.stream.isNamespaceAware")).booleanValue()) {
        fillNamespaceAttributes((EndElementEvent)localObject, paramXMLStreamReader);
      }
      return (XMLEvent)localObject;
    case 3: 
      localObject = new ProcessingInstructionEvent(paramXMLStreamReader.getPITarget(), paramXMLStreamReader.getPIData());
      ((ProcessingInstructionEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      return (XMLEvent)localObject;
    case 4: 
      localObject = new CharacterEvent(paramXMLStreamReader.getText());
      ((CharacterEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      return (XMLEvent)localObject;
    case 5: 
      localObject = new CommentEvent(paramXMLStreamReader.getText());
      ((CommentEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      return (XMLEvent)localObject;
    case 7: 
      localObject = new StartDocumentEvent();
      ((StartDocumentEvent)localObject).setVersion(paramXMLStreamReader.getVersion());
      ((StartDocumentEvent)localObject).setEncoding(paramXMLStreamReader.getEncoding());
      if (paramXMLStreamReader.getCharacterEncodingScheme() != null) {
        ((StartDocumentEvent)localObject).setDeclaredEncoding(true);
      }
      for (;;)
      {
        ((StartDocumentEvent)localObject).setStandalone(paramXMLStreamReader.isStandalone());
        ((StartDocumentEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
        return (XMLEvent)localObject;
        ((StartDocumentEvent)localObject).setDeclaredEncoding(false);
      }
    case 8: 
      localObject = new EndDocumentEvent();
      ((EndDocumentEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      return (XMLEvent)localObject;
    case 9: 
      localObject = new EntityReferenceEvent(paramXMLStreamReader.getLocalName(), new EntityDeclarationImpl(paramXMLStreamReader.getLocalName(), paramXMLStreamReader.getText()));
      ((EntityReferenceEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      return (XMLEvent)localObject;
    case 11: 
      localObject = new DTDEvent(paramXMLStreamReader.getText());
      ((DTDEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      List localList = (List)paramXMLStreamReader.getProperty("com.amazonaws.javax.xml.stream.entities");
      if ((localList != null) && (localList.size() != 0)) {
        ((DTDEvent)localObject).setEntities(localList);
      }
      paramXMLStreamReader = (List)paramXMLStreamReader.getProperty("com.amazonaws.javax.xml.stream.notations");
      if ((paramXMLStreamReader != null) && (paramXMLStreamReader.size() != 0)) {
        ((DTDEvent)localObject).setNotations(paramXMLStreamReader);
      }
      return (XMLEvent)localObject;
    case 12: 
      localObject = new CharacterEvent(paramXMLStreamReader.getText(), true);
      ((CharacterEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
      return (XMLEvent)localObject;
    }
    Object localObject = new CharacterEvent(paramXMLStreamReader.getText(), false, true);
    ((CharacterEvent)localObject).setLocation(paramXMLStreamReader.getLocation());
    return (XMLEvent)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/XMLEventAllocatorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */