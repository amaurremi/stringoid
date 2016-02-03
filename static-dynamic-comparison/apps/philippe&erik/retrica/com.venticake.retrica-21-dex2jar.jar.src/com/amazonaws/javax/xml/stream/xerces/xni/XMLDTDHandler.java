package com.amazonaws.javax.xml.stream.xerces.xni;

public abstract interface XMLDTDHandler
{
  public abstract void attributeDecl(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, String paramString4, XMLString paramXMLString1, XMLString paramXMLString2, Augmentations paramAugmentations);
  
  public abstract void comment(XMLString paramXMLString, Augmentations paramAugmentations);
  
  public abstract void elementDecl(String paramString1, String paramString2, Augmentations paramAugmentations);
  
  public abstract void endAttlist(Augmentations paramAugmentations);
  
  public abstract void endConditional(Augmentations paramAugmentations);
  
  public abstract void endDTD(Augmentations paramAugmentations);
  
  public abstract void endExternalSubset(Augmentations paramAugmentations);
  
  public abstract void endParameterEntity(String paramString, Augmentations paramAugmentations);
  
  public abstract void externalEntityDecl(String paramString, XMLResourceIdentifier paramXMLResourceIdentifier, Augmentations paramAugmentations);
  
  public abstract void ignoredCharacters(XMLString paramXMLString, Augmentations paramAugmentations);
  
  public abstract void internalEntityDecl(String paramString, XMLString paramXMLString1, XMLString paramXMLString2, Augmentations paramAugmentations);
  
  public abstract void notationDecl(String paramString, XMLResourceIdentifier paramXMLResourceIdentifier, Augmentations paramAugmentations);
  
  public abstract void processingInstruction(String paramString, XMLString paramXMLString, Augmentations paramAugmentations);
  
  public abstract void startAttlist(String paramString, Augmentations paramAugmentations);
  
  public abstract void startConditional(short paramShort, Augmentations paramAugmentations);
  
  public abstract void startDTD(XMLLocator paramXMLLocator, Augmentations paramAugmentations);
  
  public abstract void startExternalSubset(XMLResourceIdentifier paramXMLResourceIdentifier, Augmentations paramAugmentations);
  
  public abstract void startParameterEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2, Augmentations paramAugmentations);
  
  public abstract void textDecl(String paramString1, String paramString2, Augmentations paramAugmentations);
  
  public abstract void unparsedEntityDecl(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2, Augmentations paramAugmentations);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/XMLDTDHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */