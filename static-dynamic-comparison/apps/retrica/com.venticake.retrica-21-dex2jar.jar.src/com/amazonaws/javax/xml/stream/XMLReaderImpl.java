package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.dtd.nonvalidating.DTDGrammar;
import com.amazonaws.javax.xml.stream.dtd.nonvalidating.XMLNotationDecl;
import com.amazonaws.javax.xml.stream.events.EntityDeclarationImpl;
import com.amazonaws.javax.xml.stream.events.NotationDeclarationImpl;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceContextWrapper;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesIteratorImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class XMLReaderImpl
  implements XMLStreamReader
{
  private boolean fBindNamespaces = true;
  private String fDTDDecl = null;
  protected XMLEntityManager fEntityManager = new XMLEntityManager();
  protected XMLEntityReaderImpl fEntityScanner = null;
  protected StaxErrorReporter fErrorReporter = new StaxErrorReporter();
  private int fEventType;
  protected XMLInputSource fInputSource = null;
  protected NamespaceContextWrapper fNamespaceContextWrapper = new NamespaceContextWrapper(this.fScanner.getNamespaceContext());
  protected PropertyManager fPropertyManager = null;
  private boolean fReuse = true;
  protected XMLNSDocumentScannerImpl fScanner = new XMLNSDocumentScannerImpl();
  private SymbolTable fSymbolTable = new SymbolTable();
  
  public XMLReaderImpl(XMLInputSource paramXMLInputSource, PropertyManager paramPropertyManager)
  {
    init(paramPropertyManager);
    setInputSource(paramXMLInputSource);
  }
  
  static final String getEventTypeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN_EVENT_TYPE , " + String.valueOf(paramInt);
    case 1: 
      return "START_ELEMENT";
    case 2: 
      return "END_ELEMENT";
    case 3: 
      return "PROCESSING_INSTRUCTION";
    case 4: 
      return "CHARACTERS";
    case 5: 
      return "COMMENT";
    case 7: 
      return "START_DOCUMENT";
    case 8: 
      return "END_DOCUMENT";
    case 9: 
      return "ENTITY_REFERENCE";
    case 10: 
      return "ATTRIBUTE";
    case 11: 
      return "DTD";
    case 12: 
      return "CDATA";
    }
    return "SPACE";
  }
  
  public boolean canReuse()
  {
    return this.fReuse;
  }
  
  public void close()
  {
    this.fReuse = true;
  }
  
  public com.amazonaws.javax.xml.namespace.QName convertXNIQNametoJavaxQName(com.amazonaws.javax.xml.stream.xerces.xni.QName paramQName)
  {
    if (paramQName == null) {
      return null;
    }
    if (paramQName.prefix == null) {
      return new com.amazonaws.javax.xml.namespace.QName(paramQName.uri, paramQName.localpart);
    }
    return new com.amazonaws.javax.xml.namespace.QName(paramQName.uri, paramQName.localpart, paramQName.prefix);
  }
  
  public int getAttributeCount()
  {
    if ((this.fEventType == 1) || (this.fEventType == 10)) {
      return this.fScanner.getAttributeIterator().getLength();
    }
    throw new IllegalStateException("Current state is not among the states " + getEventTypeString(1) + " , " + getEventTypeString(10) + "valid for getAttributeCount()");
  }
  
  public com.amazonaws.javax.xml.namespace.QName getAttributeName(int paramInt)
  {
    if ((this.fEventType == 1) || (this.fEventType == 10)) {
      return convertXNIQNametoJavaxQName(this.fScanner.getAttributeIterator().getQualifiedName(paramInt));
    }
    throw new IllegalStateException("Current state is not among the states " + getEventTypeString(1) + " , " + getEventTypeString(10) + "valid for getAttributeName()");
  }
  
  public String getAttributeType(int paramInt)
  {
    if ((this.fEventType == 1) || (this.fEventType == 10)) {
      return this.fScanner.getAttributeIterator().getType(paramInt);
    }
    throw new IllegalStateException("Current state is not among the states " + getEventTypeString(1) + " , " + getEventTypeString(10) + "valid for getAttributeType()");
  }
  
  public String getAttributeValue(int paramInt)
  {
    if ((this.fEventType == 1) || (this.fEventType == 10)) {
      return this.fScanner.getAttributeIterator().getValue(paramInt);
    }
    throw new IllegalStateException("Current state is not among the states " + getEventTypeString(1) + " , " + getEventTypeString(10) + "valid for getAttributeValue()");
  }
  
  public String getCharacterEncodingScheme()
  {
    return this.fScanner.getCharacterEncodingScheme();
  }
  
  public String getEncoding()
  {
    return this.fEntityScanner.getEncoding();
  }
  
  protected List getEntityDecls()
  {
    Enumeration localEnumeration = null;
    Object localObject = localEnumeration;
    if (this.fEventType == 11)
    {
      Hashtable localHashtable = this.fEntityManager.getEntityStore().getDeclaredEntities();
      localObject = localEnumeration;
      if (localHashtable != null)
      {
        localObject = new ArrayList(localHashtable.size());
        localEnumeration = localHashtable.keys();
        if (localEnumeration.hasMoreElements())
        {
          String str = (String)localEnumeration.nextElement();
          Entity localEntity = (Entity)localHashtable.get(str);
          EntityDeclarationImpl localEntityDeclarationImpl = new EntityDeclarationImpl();
          localEntityDeclarationImpl.setEntityName(str);
          if (localEntity.isExternal())
          {
            localEntityDeclarationImpl.setXMLResourceIdentifier(((Entity.ExternalEntity)localEntity).entityLocation);
            localEntityDeclarationImpl.setNotationName(((Entity.ExternalEntity)localEntity).notation);
          }
          for (;;)
          {
            ((ArrayList)localObject).add(localEntityDeclarationImpl);
            break;
            localEntityDeclarationImpl.setEntityReplacementText(((Entity.InternalEntity)localEntity).text);
          }
        }
      }
    }
    return (List)localObject;
  }
  
  public int getEventType()
  {
    return this.fEventType;
  }
  
  public String getLocalName()
  {
    if ((this.fEventType == 1) || (this.fEventType == 2)) {
      return this.fScanner.getElementQName().localpart;
    }
    if (this.fEventType == 9) {
      return this.fScanner.getEntityName();
    }
    throw new IllegalStateException("Method getLocalName() cannot be called for " + getEventTypeString(this.fEventType) + " event.");
  }
  
  public Location getLocation()
  {
    return new XMLReaderImpl.1(this);
  }
  
  public com.amazonaws.javax.xml.namespace.NamespaceContext getNamespaceContext()
  {
    return this.fNamespaceContextWrapper;
  }
  
  public int getNamespaceCount()
  {
    if ((this.fEventType == 1) || (this.fEventType == 2) || (this.fEventType == 13)) {
      return this.fScanner.getNamespaceContext().getDeclaredPrefixCount();
    }
    throw new IllegalStateException("Current state " + getEventTypeString(this.fEventType) + " is not among the states " + getEventTypeString(1) + ", " + getEventTypeString(2) + ", " + getEventTypeString(13) + " valid for getNamespaceCount().");
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    if ((this.fEventType == 1) || (this.fEventType == 2) || (this.fEventType == 13))
    {
      String str2 = this.fScanner.getNamespaceContext().getDeclaredPrefixAt(paramInt);
      String str1 = str2;
      if (str2.equals("")) {
        str1 = null;
      }
      return str1;
    }
    throw new IllegalStateException("Current state " + getEventTypeString(this.fEventType) + " is not among the states " + getEventTypeString(1) + ", " + getEventTypeString(2) + ", " + getEventTypeString(13) + " valid for getNamespacePrefix().");
  }
  
  public String getNamespaceURI()
  {
    if ((this.fEventType == 1) || (this.fEventType == 2)) {
      return this.fScanner.getElementQName().uri;
    }
    return null;
  }
  
  public String getNamespaceURI(int paramInt)
  {
    if ((this.fEventType == 1) || (this.fEventType == 2) || (this.fEventType == 13)) {
      return this.fScanner.getNamespaceContext().getURI(this.fScanner.getNamespaceContext().getDeclaredPrefixAt(paramInt));
    }
    throw new IllegalStateException("Current state " + getEventTypeString(this.fEventType) + " is not among the states " + getEventTypeString(1) + ", " + getEventTypeString(2) + ", " + getEventTypeString(13) + " valid for getNamespaceURI().");
  }
  
  protected List getNotationDecls()
  {
    if (this.fEventType == 11)
    {
      if (this.fScanner.fDTDScanner == null) {
        return null;
      }
      Object localObject = ((XMLDTDScannerImpl)this.fScanner.fDTDScanner).getGrammar();
      if (localObject == null) {
        return null;
      }
      localObject = ((DTDGrammar)localObject).getNotationDecls().iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject).hasNext())
      {
        XMLNotationDecl localXMLNotationDecl = (XMLNotationDecl)((Iterator)localObject).next();
        if (localXMLNotationDecl != null) {
          localArrayList.add(new NotationDeclarationImpl(localXMLNotationDecl));
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public String getPIData()
  {
    if (this.fEventType == 3) {
      return this.fScanner.getPIData().toString();
    }
    throw new IllegalStateException("Current state of the parser is " + getEventTypeString(this.fEventType) + " But expected state is " + getEventTypeString(3));
  }
  
  public String getPITarget()
  {
    if (this.fEventType == 3) {
      return this.fScanner.getPITarget();
    }
    throw new IllegalStateException("Current state of the parser is " + getEventTypeString(this.fEventType) + " But expected state is " + getEventTypeString(3));
  }
  
  public String getPrefix()
  {
    if ((this.fEventType == 1) || (this.fEventType == 2))
    {
      String str2 = this.fScanner.getElementQName().prefix;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      return str1;
    }
    return null;
  }
  
  public Object getProperty(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (this.fPropertyManager != null)
    {
      PropertyManager localPropertyManager = this.fPropertyManager;
      if (paramString.equals("com.amazonaws.javax.xml.stream.notations")) {
        return getNotationDecls();
      }
      localPropertyManager = this.fPropertyManager;
      if (paramString.equals("com.amazonaws.javax.xml.stream.entities")) {
        return getEntityDecls();
      }
      return this.fPropertyManager.getProperty(paramString);
    }
    return null;
  }
  
  public String getText()
  {
    if ((this.fEventType == 4) || (this.fEventType == 5) || (this.fEventType == 12) || (this.fEventType == 6)) {
      return this.fScanner.getCharacterData().toString();
    }
    if (this.fEventType == 9)
    {
      Object localObject = this.fScanner.getEntityName();
      if (localObject != null)
      {
        if (this.fScanner.foundBuiltInRefs) {
          return this.fScanner.getCharacterData().toString();
        }
        localObject = (Entity)this.fEntityManager.getEntityStore().getDeclaredEntities().get(localObject);
        if (localObject == null) {
          return null;
        }
        if (((Entity)localObject).isExternal()) {
          return ((Entity.ExternalEntity)localObject).entityLocation.getExpandedSystemId();
        }
        return ((Entity.InternalEntity)localObject).text;
      }
      return null;
    }
    if (this.fEventType == 11)
    {
      if (this.fDTDDecl != null) {
        return this.fDTDDecl;
      }
      this.fDTDDecl = this.fScanner.getDTDDecl().toString();
      return this.fDTDDecl;
    }
    throw new IllegalStateException("Current state " + getEventTypeString(this.fEventType) + " is not among the states" + getEventTypeString(4) + ", " + getEventTypeString(5) + ", " + getEventTypeString(12) + ", " + getEventTypeString(6) + ", " + getEventTypeString(9) + ", " + getEventTypeString(11) + " valid for getText() ");
  }
  
  public String getVersion()
  {
    return this.fEntityScanner.getVersion();
  }
  
  public boolean hasNext()
  {
    if (this.fEventType == -1) {}
    while (this.fEventType == 8) {
      return false;
    }
    return true;
  }
  
  void init(PropertyManager paramPropertyManager)
  {
    this.fPropertyManager = paramPropertyManager;
    paramPropertyManager.setProperty("http://apache.org/xml/properties/internal/symbol-table", this.fSymbolTable);
    paramPropertyManager.setProperty("http://apache.org/xml/properties/internal/error-reporter", this.fErrorReporter);
    paramPropertyManager.setProperty("http://apache.org/xml/properties/internal/entity-manager", this.fEntityManager);
    reset();
  }
  
  public boolean isAttributeSpecified(int paramInt)
  {
    if ((this.fEventType == 1) || (this.fEventType == 10)) {
      return this.fScanner.getAttributeIterator().isSpecified(paramInt);
    }
    throw new IllegalStateException("Current state is not among the states " + getEventTypeString(1) + " , " + getEventTypeString(10) + "valid for isAttributeSpecified()");
  }
  
  public boolean isStandalone()
  {
    return this.fScanner.isStandAlone();
  }
  
  public int next()
  {
    if (!hasNext())
    {
      if (this.fEventType != -1) {
        throw new NoSuchElementException("END_DOCUMENT reached: no more elements on the stream.");
      }
      throw new XMLStreamException("Error processing input source. The input stream is not complete.");
    }
    try
    {
      i = this.fScanner.next();
      this.fEventType = i;
      return i;
    }
    catch (IOException localIOException)
    {
      int i = this.fScanner.fScannerState;
      Object localObject = this.fScanner;
      XMLNSDocumentScannerImpl localXMLNSDocumentScannerImpl;
      if (i == 46)
      {
        localObject = (Boolean)this.fPropertyManager.getProperty("com.amazonaws.javax.xml.stream.isValidating");
        if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
        {
          this.fEventType = 11;
          localXMLNSDocumentScannerImpl = this.fScanner;
          localObject = this.fScanner;
          localXMLNSDocumentScannerImpl.setScannerState(43);
          this.fScanner.setDriver(this.fScanner.fPrologDriver);
          if ((this.fDTDDecl == null) || (this.fDTDDecl.length() == 0)) {
            this.fDTDDecl = "<!-- Exception scanning External DTD Subset.  True contents of DTD cannot be determined.  Processing will continue as XMLInputFactory.IS_VALIDATING == false. -->";
          }
          return 11;
        }
      }
      throw new XMLStreamException2(localXMLNSDocumentScannerImpl.getMessage(), getLocation(), localXMLNSDocumentScannerImpl);
    }
    catch (XNIException localXNIException)
    {
      throw new XMLStreamException2(localXNIException.getMessage(), getLocation(), localXNIException.getException());
    }
  }
  
  public void reset()
  {
    this.fReuse = true;
    this.fEventType = 0;
    this.fEntityManager.reset(this.fPropertyManager);
    this.fScanner.reset(this.fPropertyManager);
    this.fDTDDecl = null;
    this.fEntityScanner = ((XMLEntityReaderImpl)this.fEntityManager.getEntityReader());
    this.fBindNamespaces = ((Boolean)this.fPropertyManager.getProperty("com.amazonaws.javax.xml.stream.isNamespaceAware")).booleanValue();
  }
  
  public void setInputSource(XMLInputSource paramXMLInputSource)
  {
    this.fReuse = false;
    try
    {
      this.fScanner.setInputSource(paramXMLInputSource);
      this.fEventType = this.fScanner.next();
      return;
    }
    catch (IOException paramXMLInputSource)
    {
      throw new XMLStreamException2(paramXMLInputSource);
    }
    catch (XNIException paramXMLInputSource)
    {
      throw new XMLStreamException2(paramXMLInputSource.getMessage(), getLocation(), paramXMLInputSource.getException());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLReaderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */