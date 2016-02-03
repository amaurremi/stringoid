package com.amazonaws.javax.xml.stream.xerces.xni;

public abstract interface XMLDocumentHandler
{
  public abstract void characters(XMLString paramXMLString, Augmentations paramAugmentations);
  
  public abstract void comment(XMLString paramXMLString, Augmentations paramAugmentations);
  
  public abstract void doctypeDecl(String paramString1, String paramString2, String paramString3, Augmentations paramAugmentations);
  
  public abstract void emptyElement(QName paramQName, XMLAttributes paramXMLAttributes, Augmentations paramAugmentations);
  
  public abstract void endCDATA(Augmentations paramAugmentations);
  
  public abstract void endDocument(Augmentations paramAugmentations);
  
  public abstract void endGeneralEntity(String paramString, Augmentations paramAugmentations);
  
  public abstract void processingInstruction(String paramString, XMLString paramXMLString, Augmentations paramAugmentations);
  
  public abstract void startCDATA(Augmentations paramAugmentations);
  
  public abstract void startDocument(XMLLocator paramXMLLocator, String paramString, NamespaceContext paramNamespaceContext, Augmentations paramAugmentations);
  
  public abstract void startGeneralEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2, Augmentations paramAugmentations);
  
  public abstract void textDecl(String paramString1, String paramString2, Augmentations paramAugmentations);
  
  public abstract void xmlDecl(String paramString1, String paramString2, String paramString3, Augmentations paramAugmentations);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/XMLDocumentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */