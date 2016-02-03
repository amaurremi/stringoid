package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.dtd.DTDGrammarUtil;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesIteratorImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLDocumentHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import java.util.ArrayList;

public class XMLNSDocumentScannerImpl
  extends XMLDocumentScannerImpl
{
  private boolean fEmptyElement = false;
  protected boolean fPerformValidation;
  private boolean fXmlnsDeclared = false;
  private XMLDocumentScannerImpl.XMLBufferListenerImpl listener = new XMLDocumentScannerImpl.XMLBufferListenerImpl(this);
  
  private boolean seekCloseOfStartTag()
  {
    boolean bool = this.fEntityScanner.skipSpaces();
    int i = this.fEntityScanner.peekChar();
    if (i == 62)
    {
      this.fEntityScanner.scanChar();
      return true;
    }
    if (i == 47)
    {
      this.fEntityScanner.scanChar();
      if (!this.fEntityScanner.skipChar(62)) {
        reportFatalError("ElementUnterminated", new Object[] { this.fElementQName.rawname });
      }
      this.fEmptyElement = true;
      return true;
    }
    if ((!isValidNameStartChar(i)) || (!bool)) {
      reportFatalError("ElementUnterminated", new Object[] { this.fElementQName.rawname });
    }
    return false;
  }
  
  protected XMLDocumentFragmentScannerImpl.Driver createContentDriver()
  {
    return new XMLNSDocumentScannerImpl.NSContentDriver(this);
  }
  
  public String getCharacterEncodingScheme()
  {
    return this.fDeclaredEncoding;
  }
  
  public XMLStringBuffer getDTDDecl()
  {
    Entity.ScannedEntity localScannedEntity = this.fEntityScanner.getCurrentEntity();
    this.fDTDDecl.append(((Entity.ScannedEntity)localScannedEntity).ch, this.fStartPos, this.fEndPos - this.fStartPos);
    if (this.fSeenInternalSubset) {
      this.fDTDDecl.append("]>");
    }
    return this.fDTDDecl;
  }
  
  public QName getElementQName()
  {
    if (this.fScannerLastState == 2) {
      this.fElementQName.setValues(this.fElementStack.getLastPoppedElement());
    }
    return this.fElementQName;
  }
  
  public NamespaceContext getNamespaceContext()
  {
    return this.fNamespaceContext;
  }
  
  XMLString getString()
  {
    if ((this.fAttributeCacheUsedCount < this.initialCacheCount) || (this.fAttributeCacheUsedCount < this.attributeValueCache.size()))
    {
      localObject = this.attributeValueCache;
      int i = this.fAttributeCacheUsedCount;
      this.fAttributeCacheUsedCount = (i + 1);
      return (XMLString)((ArrayList)localObject).get(i);
    }
    Object localObject = new XMLString();
    this.fAttributeCacheUsedCount += 1;
    this.attributeValueCache.add(localObject);
    return (XMLString)localObject;
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    int i = 0;
    setPropertyManager(paramPropertyManager);
    super.reset(paramPropertyManager);
    try
    {
      if (!this.fAttributeCacheInitDone)
      {
        while (i < this.initialCacheCount)
        {
          this.attributeValueCache.add(new XMLString());
          this.stringBufferCache.add(new XMLStringBuffer());
          i += 1;
        }
        this.fAttributeCacheInitDone = true;
      }
      this.fStringBufferIndex = 0;
      this.fAttributeCacheUsedCount = 0;
      this.fEntityScanner.registerListener(this.listener);
      this.dtdGrammarUtil = null;
      return;
    }
    catch (RuntimeException paramPropertyManager) {}
  }
  
  protected void scanAttribute(XMLAttributesImpl paramXMLAttributesImpl)
  {
    this.fEntityScanner.scanQName(this.fAttributeQName);
    this.fEntityScanner.skipSpaces();
    if (!this.fEntityScanner.skipChar(61)) {
      reportFatalError("EqRequiredInAttribute", new Object[] { this.fCurrentElement.rawname, this.fAttributeQName.rawname });
    }
    this.fEntityScanner.skipSpaces();
    boolean bool;
    Object localObject3;
    Object localObject2;
    if ((this.fHasExternalDTD) && (!this.fStandalone))
    {
      bool = true;
      localObject3 = getString();
      scanAttributeValue((XMLString)localObject3, this.fTempString2, this.fAttributeQName.rawname, paramXMLAttributesImpl, 0, bool);
      if (!this.fBindNamespaces) {
        break label547;
      }
      localObject2 = this.fAttributeQName.localpart;
      if (this.fAttributeQName.prefix == null) {
        break label490;
      }
      localObject1 = this.fAttributeQName.prefix;
      label149:
      if ((localObject1 != XMLSymbols.PREFIX_XMLNS) && ((localObject1 != XMLSymbols.EMPTY_STRING) || (localObject2 != XMLSymbols.PREFIX_XMLNS))) {
        break label547;
      }
      localObject3 = this.fSymbolTable.addSymbol(((XMLString)localObject3).ch, ((XMLString)localObject3).offset, ((XMLString)localObject3).length);
      if ((localObject1 == XMLSymbols.PREFIX_XMLNS) && (localObject2 == XMLSymbols.PREFIX_XMLNS)) {
        this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "CantBindXMLNS", new Object[] { this.fAttributeQName }, (short)2);
      }
      if (localObject3 == NamespaceContext.XMLNS_URI) {
        this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "CantBindXMLNS", new Object[] { this.fAttributeQName }, (short)2);
      }
      if (localObject2 != XMLSymbols.PREFIX_XML) {
        break label498;
      }
      if (localObject3 != NamespaceContext.XML_URI) {
        this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "CantBindXML", new Object[] { this.fAttributeQName }, (short)2);
      }
      label312:
      if (localObject2 == XMLSymbols.PREFIX_XMLNS) {
        break label534;
      }
      paramXMLAttributesImpl = (XMLAttributesImpl)localObject2;
      label323:
      if ((localObject3 == XMLSymbols.EMPTY_STRING) && (localObject2 != XMLSymbols.PREFIX_XMLNS)) {
        this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "EmptyPrefixedAttName", new Object[] { this.fAttributeQName }, (short)2);
      }
      if (((NamespaceSupport)this.fNamespaceContext).containsPrefixInCurrentContext(paramXMLAttributesImpl)) {
        reportFatalError("AttributeNotUnique", new Object[] { this.fCurrentElement.rawname, this.fAttributeQName.rawname });
      }
      localObject2 = this.fNamespaceContext;
      if (((String)localObject3).length() == 0) {
        break label541;
      }
    }
    label490:
    label498:
    label534:
    label541:
    for (Object localObject1 = localObject3;; localObject1 = null)
    {
      if (!((NamespaceContext)localObject2).declarePrefix(paramXMLAttributesImpl, (String)localObject1))
      {
        if (this.fXmlnsDeclared) {
          reportFatalError("AttributeNotUnique", new Object[] { this.fCurrentElement.rawname, this.fAttributeQName.rawname });
        }
        this.fXmlnsDeclared = true;
      }
      return;
      bool = false;
      break;
      localObject1 = XMLSymbols.EMPTY_STRING;
      break label149;
      if (localObject3 != NamespaceContext.XML_URI) {
        break label312;
      }
      this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "CantBindXML", new Object[] { this.fAttributeQName }, (short)2);
      break label312;
      paramXMLAttributesImpl = XMLSymbols.EMPTY_STRING;
      break label323;
    }
    label547:
    int i;
    if (this.fBindNamespaces)
    {
      i = paramXMLAttributesImpl.getLength();
      paramXMLAttributesImpl.addAttributeNS(this.fAttributeQName, XMLSymbols.fCDATASymbol, null);
    }
    for (;;)
    {
      paramXMLAttributesImpl.setValue(i, null, (XMLString)localObject3);
      paramXMLAttributesImpl.setSpecified(i, true);
      if (this.fAttributeQName.prefix == null) {
        break;
      }
      paramXMLAttributesImpl.setURI(i, this.fNamespaceContext.getURI(this.fAttributeQName.prefix));
      return;
      int k = paramXMLAttributesImpl.getLength();
      int j = paramXMLAttributesImpl.addAttribute(this.fAttributeQName, XMLSymbols.fCDATASymbol, null);
      i = j;
      if (k == paramXMLAttributesImpl.getLength())
      {
        reportFatalError("AttributeNotUnique", new Object[] { this.fCurrentElement.rawname, this.fAttributeQName.rawname });
        i = j;
      }
    }
  }
  
  protected int scanEndElement()
  {
    QName localQName = this.fElementStack.popElement();
    String str = localQName.rawname;
    if (!this.fEntityScanner.skipString(localQName.characters)) {
      reportFatalError("ETagRequired", new Object[] { str });
    }
    this.fEntityScanner.skipSpaces();
    if (!this.fEntityScanner.skipChar(62)) {
      reportFatalError("ETagUnterminated", new Object[] { str });
    }
    this.fMarkupDepth -= 1;
    this.fMarkupDepth -= 1;
    if (this.fMarkupDepth < this.fEntityStack[(this.fEntityDepth - 1)]) {
      reportFatalError("ElementEntityMismatch", new Object[] { str });
    }
    if ((this.fDocumentHandler == null) || (this.dtdGrammarUtil != null)) {
      this.dtdGrammarUtil.endElement(localQName);
    }
    this.fScanEndElement = true;
    return this.fMarkupDepth;
  }
  
  protected boolean scanStartElement()
  {
    Object localObject;
    label100:
    label366:
    int j;
    int i;
    label495:
    label530:
    String str;
    if ((this.fSkip) && (!this.fAdd))
    {
      localObject = this.fElementStack.getNext();
      this.fSkip = this.fEntityScanner.skipString(((QName)localObject).characters);
      if (this.fSkip)
      {
        this.fElementStack.push();
        this.fElementQName = ((QName)localObject);
      }
    }
    else
    {
      if ((!this.fSkip) || (this.fAdd))
      {
        this.fElementQName = this.fElementStack.nextElement();
        if (!this.fBindNamespaces) {
          break label581;
        }
        this.fEntityScanner.scanQName(this.fElementQName);
      }
      if (this.fAdd) {
        this.fElementStack.matchElement(this.fElementQName);
      }
      this.fCurrentElement = this.fElementQName;
      localObject = this.fElementQName.rawname;
      if (this.fBindNamespaces)
      {
        this.fNamespaceContext.pushContext();
        if ((this.fScannerState == 26) && (this.fPerformValidation))
        {
          this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "MSG_GRAMMAR_NOT_FOUND", new Object[] { localObject }, (short)1);
          if ((this.fDoctypeName == null) || (!this.fDoctypeName.equals(localObject))) {
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "RootElementTypeMustMatchDoctypedecl", new Object[] { this.fDoctypeName, localObject }, (short)1);
          }
        }
      }
      this.fEmptyElement = false;
      this.fAttributes.removeAllAttributes();
      if (!seekCloseOfStartTag())
      {
        this.fReadingAttributes = true;
        this.fAttributeCacheUsedCount = 0;
        this.fStringBufferIndex = 0;
        this.fAddDefaultAttr = true;
        this.fXmlnsDeclared = false;
        do
        {
          scanAttribute(this.fAttributes);
        } while (!seekCloseOfStartTag());
        this.fReadingAttributes = false;
      }
      if (!this.fBindNamespaces) {
        break label773;
      }
      if (this.fElementQName.prefix == XMLSymbols.PREFIX_XMLNS) {
        this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "ElementXMLNSPrefix", new Object[] { this.fElementQName.rawname }, (short)2);
      }
      if (this.fElementQName.prefix == null) {
        break label617;
      }
      localObject = this.fElementQName.prefix;
      this.fElementQName.uri = this.fNamespaceContext.getURI((String)localObject);
      this.fCurrentElement.uri = this.fElementQName.uri;
      if ((this.fElementQName.prefix == null) && (this.fElementQName.uri != null)) {
        this.fElementQName.prefix = XMLSymbols.EMPTY_STRING;
      }
      if ((this.fElementQName.prefix != null) && (this.fElementQName.uri == null)) {
        this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "ElementPrefixUnbound", new Object[] { this.fElementQName.prefix, this.fElementQName.rawname }, (short)2);
      }
      j = this.fAttributes.getLength();
      i = 0;
      if (i >= j) {
        break label707;
      }
      this.fAttributes.getName(i, this.fAttributeQName);
      if (this.fAttributeQName.prefix == null) {
        break label624;
      }
      localObject = this.fAttributeQName.prefix;
      str = this.fNamespaceContext.getURI((String)localObject);
      if ((this.fAttributeQName.uri == null) || (this.fAttributeQName.uri != str)) {
        break label631;
      }
    }
    for (;;)
    {
      i += 1;
      break label495;
      this.fElementStack.reposition();
      break;
      label581:
      localObject = this.fEntityScanner.scanName();
      this.fElementQName.setValues(null, (String)localObject, (String)localObject, null);
      this.fElementQName.characters = this.fEntityScanner.scannedName;
      break label100;
      label617:
      localObject = XMLSymbols.EMPTY_STRING;
      break label366;
      label624:
      localObject = XMLSymbols.EMPTY_STRING;
      break label530;
      label631:
      if (localObject != XMLSymbols.EMPTY_STRING)
      {
        this.fAttributeQName.uri = str;
        if (str == null) {
          this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "AttributePrefixUnbound", new Object[] { this.fElementQName.rawname, this.fAttributeQName.rawname, localObject }, (short)2);
        }
        this.fAttributes.setURI(i, str);
      }
    }
    label707:
    if (j > 1)
    {
      localObject = this.fAttributes.checkDuplicatesNS();
      if (localObject != null)
      {
        if (((QName)localObject).uri == null) {
          break label872;
        }
        this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "AttributeNSNotUnique", new Object[] { this.fElementQName.rawname, ((QName)localObject).localpart, ((QName)localObject).uri }, (short)2);
      }
    }
    label773:
    if (this.fEmptyElement)
    {
      this.fMarkupDepth -= 1;
      if (this.fMarkupDepth < this.fEntityStack[(this.fEntityDepth - 1)]) {
        reportFatalError("ElementEntityMismatch", new Object[] { this.fCurrentElement.rawname });
      }
      if (this.fDocumentHandler != null) {
        this.fDocumentHandler.emptyElement(this.fElementQName, this.fAttributes, null);
      }
      this.fScanEndElement = true;
      this.fElementStack.popElement();
    }
    for (;;)
    {
      return this.fEmptyElement;
      label872:
      this.fErrorReporter.reportError("http://www.w3.org/TR/1999/REC-xml-names-19990114", "AttributeNotUnique", new Object[] { this.fElementQName.rawname, ((QName)localObject).rawname }, (short)2);
      break;
      if (this.dtdGrammarUtil != null) {
        this.dtdGrammarUtil.startElement(this.fElementQName, this.fAttributes);
      }
      if (this.fDocumentHandler == null) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLNSDocumentScannerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */