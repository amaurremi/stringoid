package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLDocumentHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDScanner;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.EOFException;

public class XMLDocumentScannerImpl
  extends XMLDocumentFragmentScannerImpl
{
  public static final char[] COMMENTSTRING = { 45, 45 };
  public static final char[] DOCTYPE;
  private static final Boolean[] FEATURE_DEFAULTS;
  private static final Object[] PROPERTY_DEFAULTS;
  private static final String[] RECOGNIZED_FEATURES = { "http://apache.org/xml/features/nonvalidating/load-external-dtd", "http://apache.org/xml/features/disallow-doctype-decl" };
  private static final String[] RECOGNIZED_PROPERTIES;
  protected boolean fBindNamespaces;
  protected XMLStringBuffer fDTDDecl = null;
  protected XMLDocumentFragmentScannerImpl.Driver fDTDDriver = null;
  protected XMLDTDScanner fDTDScanner = null;
  protected String fDoctypeName;
  protected String fDoctypePublicId;
  protected String fDoctypeSystemId;
  protected boolean fEndOfDocument;
  protected int fEndPos = 0;
  protected boolean fLoadExternalDTD = true;
  protected NamespaceContext fNamespaceContext = new NamespaceSupport();
  protected XMLDocumentFragmentScannerImpl.Driver fPrologDriver = new XMLDocumentScannerImpl.PrologDriver(this);
  protected boolean fReadingAttributes = false;
  protected boolean fReadingDTD = false;
  protected boolean fScanEndElement;
  protected XMLDocumentScannerImpl.XMLBufferListenerImpl fScannerBufferlistener = new XMLDocumentScannerImpl.XMLBufferListenerImpl(this);
  protected int fScannerLastState;
  protected boolean fSeenDoctypeDecl;
  protected boolean fSeenInternalSubset = false;
  protected int fStartPos = 0;
  private XMLString fString = new XMLString();
  private String[] fStrings = new String[3];
  protected XMLDocumentFragmentScannerImpl.Driver fTrailingMiscDriver = new XMLDocumentScannerImpl.TrailingMiscDriver(this);
  protected XMLDocumentFragmentScannerImpl.Driver fXMLDeclDriver = new XMLDocumentScannerImpl.XMLDeclDriver(this);
  
  static
  {
    FEATURE_DEFAULTS = new Boolean[] { Boolean.TRUE, Boolean.FALSE };
    RECOGNIZED_PROPERTIES = new String[] { "http://apache.org/xml/properties/internal/dtd-scanner", "http://apache.org/xml/properties/internal/validation-manager" };
    PROPERTY_DEFAULTS = new Object[] { null, null };
    DOCTYPE = new char[] { 68, 79, 67, 84, 89, 80, 69 };
  }
  
  protected XMLDocumentFragmentScannerImpl.Driver createContentDriver()
  {
    return new XMLDocumentScannerImpl.ContentDriver(this);
  }
  
  public void endEntity(String paramString)
  {
    super.endEntity(paramString);
    if (paramString.equals("[xml]"))
    {
      if ((this.fMarkupDepth != 0) || (this.fDriver != this.fTrailingMiscDriver)) {
        break label56;
      }
      setScannerState(34);
      if (this.fDocumentHandler != null) {
        this.fDocumentHandler.endDocument(null);
      }
    }
    return;
    label56:
    throw new EOFException();
  }
  
  protected String getScannerStateName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getScannerStateName(paramInt);
    case 42: 
      return "SCANNER_STATE_XML_DECL";
    case 43: 
      return "SCANNER_STATE_PROLOG";
    case 44: 
      return "SCANNER_STATE_TRAILING_MISC";
    case 45: 
      return "SCANNER_STATE_DTD_INTERNAL_DECLS";
    case 46: 
      return "SCANNER_STATE_DTD_EXTERNAL";
    }
    return "SCANNER_STATE_DTD_EXTERNAL_DECLS";
  }
  
  public int next()
  {
    if ((this.fScannerLastState == 2) && (this.fBindNamespaces))
    {
      this.fScannerLastState = -1;
      this.fNamespaceContext.popContext();
    }
    int i = this.fDriver.next();
    this.fScannerLastState = i;
    return i;
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    boolean bool2 = true;
    super.reset(paramPropertyManager);
    this.fDoctypeName = null;
    this.fDoctypePublicId = null;
    this.fDoctypeSystemId = null;
    this.fSeenDoctypeDecl = false;
    this.fNamespaceContext.reset();
    if (!((Boolean)paramPropertyManager.getProperty("com.amazonaws.javax.xml.stream.supportDTD")).booleanValue())
    {
      bool1 = true;
      this.fDisallowDoctype = bool1;
      this.fBindNamespaces = ((Boolean)paramPropertyManager.getProperty("com.amazonaws.javax.xml.stream.isNamespaceAware")).booleanValue();
      if (((Boolean)paramPropertyManager.getProperty("http://java.sun.com/xml/stream/properties/ignore-external-dtd")).booleanValue()) {
        break label168;
      }
    }
    label168:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fLoadExternalDTD = bool1;
      this.fEndOfDocument = false;
      setScannerState(7);
      setDriver(this.fXMLDeclDriver);
      this.fSeenInternalSubset = false;
      if (this.fDTDScanner != null) {
        ((XMLDTDScannerImpl)this.fDTDScanner).reset(paramPropertyManager);
      }
      this.fEndPos = 0;
      this.fStartPos = 0;
      if (this.fDTDDecl != null) {
        this.fDTDDecl.clear();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  protected boolean scanDoctypeDecl(boolean paramBoolean)
  {
    if (!this.fEntityScanner.skipSpaces()) {
      reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ROOT_ELEMENT_TYPE_IN_DOCTYPEDECL", null);
    }
    this.fDoctypeName = this.fEntityScanner.scanName();
    if (this.fDoctypeName == null) {
      reportFatalError("MSG_ROOT_ELEMENT_TYPE_REQUIRED", null);
    }
    if (this.fEntityScanner.skipSpaces())
    {
      scanExternalID(this.fStrings, false);
      this.fDoctypeSystemId = this.fStrings[0];
      this.fDoctypePublicId = this.fStrings[1];
      this.fEntityScanner.skipSpaces();
    }
    if (this.fDoctypeSystemId != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.fHasExternalDTD = bool;
      if ((this.fDocumentHandler != null) && (!paramBoolean)) {
        this.fDocumentHandler.doctypeDecl(this.fDoctypeName, this.fDoctypePublicId, this.fDoctypeSystemId, null);
      }
      if (this.fEntityScanner.skipChar(91)) {
        break;
      }
      this.fEntityScanner.skipSpaces();
      if (!this.fEntityScanner.skipChar(62)) {
        reportFatalError("DoctypedeclUnterminated", new Object[] { this.fDoctypeName });
      }
      this.fMarkupDepth -= 1;
      return false;
    }
    return true;
  }
  
  protected void setEndDTDScanState()
  {
    setScannerState(43);
    setDriver(this.fPrologDriver);
    this.fEntityManager.setEntityHandler(this);
  }
  
  public void setInputSource(XMLInputSource paramXMLInputSource)
  {
    this.fEntityManager.setEntityHandler(this);
    this.fEntityManager.startDocumentEntity(paramXMLInputSource);
    setScannerState(7);
  }
  
  public void startEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2)
  {
    super.startEntity(paramString1, paramXMLResourceIdentifier, paramString2);
    if ((!paramString1.equals("[xml]")) && (this.fEntityScanner.isExternal()) && (this.fReplaceEntityReferences)) {
      setScannerState(36);
    }
    if ((this.fDocumentHandler != null) && (paramString1.equals("[xml]"))) {
      this.fDocumentHandler.startDocument(this.fEntityScanner, paramString2, this.fNamespaceContext, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentScannerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */