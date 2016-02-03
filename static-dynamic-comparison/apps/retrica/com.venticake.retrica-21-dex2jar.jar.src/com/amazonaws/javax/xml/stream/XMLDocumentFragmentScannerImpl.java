package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.dtd.DTDGrammarUtil;
import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesIteratorImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLDocumentHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.lang.reflect.Array;

public class XMLDocumentFragmentScannerImpl
  extends XMLScanner
  implements XMLEntityHandler
{
  private static final Boolean[] FEATURE_DEFAULTS;
  private static final Object[] PROPERTY_DEFAULTS;
  private static final String[] RECOGNIZED_FEATURES = { "http://xml.org/sax/features/namespaces", "http://xml.org/sax/features/validation", "http://apache.org/xml/features/scanner/notify-builtin-refs", "http://apache.org/xml/features/scanner/notify-char-refs" };
  private static final String[] RECOGNIZED_PROPERTIES;
  protected static final char[] cdata;
  protected static final char[] endTag = { 60, 47 };
  protected static final char[] xmlDecl;
  protected DTDGrammarUtil dtdGrammarUtil = null;
  protected boolean fAdd = false;
  protected boolean fAddDefaultAttr = false;
  protected QName fAttributeQName = new QName();
  protected XMLAttributesIteratorImpl fAttributes = new XMLAttributesIteratorImpl();
  protected XMLStringBuffer fContentBuffer = new XMLStringBuffer();
  protected XMLDocumentFragmentScannerImpl.Driver fContentDriver = createContentDriver();
  protected QName fCurrentElement;
  private String fCurrentEntityName = null;
  protected String fDeclaredEncoding = null;
  protected boolean fDisallowDoctype = false;
  protected XMLDocumentHandler fDocumentHandler;
  protected XMLDocumentFragmentScannerImpl.Driver fDriver;
  String[] fElementArray = new String['È'];
  short fElementPointer = 0;
  protected QName fElementQName = new QName();
  protected XMLDocumentFragmentScannerImpl.ElementStack fElementStack = new XMLDocumentFragmentScannerImpl.ElementStack(this);
  protected XMLDocumentFragmentScannerImpl.ElementStack2 fElementStack2 = new XMLDocumentFragmentScannerImpl.ElementStack2(this);
  protected boolean fEmptyElement;
  protected int[] fEntityStack = new int[4];
  protected XMLEntityStorage fEntityStore;
  protected boolean fHasExternalDTD;
  protected boolean fInScanContent = false;
  protected boolean fIsCoalesce = false;
  short fLastPointerLocation = 0;
  protected boolean fLastSectionWasCData = false;
  protected boolean fLastSectionWasCharacterData = false;
  protected boolean fLastSectionWasEntityReference = false;
  protected int fMarkupDepth;
  protected boolean fNamespaces;
  protected boolean fNotifyBuiltInRefs = false;
  protected XMLString fPIData = new XMLString();
  protected String fPITarget;
  short[][] fPointerInfo = (short[][])Array.newInstance(Short.TYPE, new int[] { 5, 4 });
  protected boolean fReplaceEntityReferences = true;
  protected boolean fReportCdataEvent = false;
  protected boolean fScanToEnd = false;
  protected int fScannerState;
  protected boolean fShouldSkip = false;
  private final char[] fSingleChar = new char[1];
  protected boolean fSkip = false;
  protected boolean fStandalone;
  protected boolean fStandaloneSet;
  protected XMLStringBuffer fStringBuffer = new XMLStringBuffer();
  protected XMLStringBuffer fStringBuffer2 = new XMLStringBuffer();
  private String[] fStrings = new String[3];
  protected boolean fSupportExternalEntities = false;
  protected XMLString fTempString = new XMLString();
  protected XMLString fTempString2 = new XMLString();
  boolean fUsebuffer;
  protected boolean foundBuiltInRefs = false;
  
  static
  {
    FEATURE_DEFAULTS = new Boolean[] { null, null, Boolean.FALSE, Boolean.FALSE };
    RECOGNIZED_PROPERTIES = new String[] { "http://apache.org/xml/properties/internal/symbol-table", "http://apache.org/xml/properties/internal/error-reporter", "http://apache.org/xml/properties/internal/entity-manager" };
    PROPERTY_DEFAULTS = new Object[] { null, null, null };
    cdata = new char[] { 91, 67, 68, 65, 84, 65, 91 };
    xmlDecl = new char[] { 60, 63, 120, 109, 108 };
  }
  
  private void handleCharacter(char paramChar, String paramString, XMLStringBuffer paramXMLStringBuffer)
  {
    this.foundBuiltInRefs = true;
    paramXMLStringBuffer.append(paramChar);
    if (this.fDocumentHandler != null)
    {
      this.fSingleChar[0] = paramChar;
      if (this.fNotifyBuiltInRefs) {
        this.fDocumentHandler.startGeneralEntity(paramString, null, null, null);
      }
      this.fTempString.setValues(this.fSingleChar, 0, 1);
      this.fDocumentHandler.characters(this.fTempString, null);
      if (this.fNotifyBuiltInRefs) {
        this.fDocumentHandler.endGeneralEntity(paramString, null);
      }
    }
  }
  
  protected XMLDocumentFragmentScannerImpl.Driver createContentDriver()
  {
    return new XMLDocumentFragmentScannerImpl.FragmentContentDriver(this);
  }
  
  public void endEntity(String paramString)
  {
    super.endEntity(paramString);
    if (this.fMarkupDepth != this.fEntityStack[this.fEntityDepth]) {
      reportFatalError("MarkupEntityMismatch", null);
    }
    if ((this.fDocumentHandler != null) && (!this.fScanningAttribute) && (!paramString.equals("[xml]"))) {
      this.fDocumentHandler.endGeneralEntity(paramString, null);
    }
  }
  
  public XMLAttributesIteratorImpl getAttributeIterator()
  {
    if ((this.dtdGrammarUtil != null) && (this.fAddDefaultAttr))
    {
      this.dtdGrammarUtil.addDTDDefaultAttrs(this.fElementQName, this.fAttributes);
      this.fAddDefaultAttr = false;
    }
    return this.fAttributes;
  }
  
  public XMLString getCharacterData()
  {
    if (this.fUsebuffer) {
      return this.fContentBuffer;
    }
    return this.fTempString;
  }
  
  public String getEntityName()
  {
    return this.fCurrentEntityName;
  }
  
  public XMLStringBuffer getPIData()
  {
    return this.fContentBuffer;
  }
  
  public String getPITarget()
  {
    return this.fPITarget;
  }
  
  protected String getScannerStateName(int paramInt)
  {
    switch (paramInt)
    {
    case 25: 
    case 31: 
    case 32: 
    default: 
      return "??? (" + paramInt + ')';
    case 24: 
      return "SCANNER_STATE_DOCTYPE";
    case 26: 
      return "SCANNER_STATE_ROOT_ELEMENT";
    case 21: 
      return "SCANNER_STATE_START_OF_MARKUP";
    case 27: 
      return "SCANNER_STATE_COMMENT";
    case 23: 
      return "SCANNER_STATE_PI";
    case 22: 
      return "SCANNER_STATE_CONTENT";
    case 28: 
      return "SCANNER_STATE_REFERENCE";
    case 33: 
      return "SCANNER_STATE_END_OF_INPUT";
    case 34: 
      return "SCANNER_STATE_TERMINATED";
    case 35: 
      return "SCANNER_STATE_CDATA";
    case 36: 
      return "SCANNER_STATE_TEXT_DECL";
    case 29: 
      return "SCANNER_STATE_ATTRIBUTE";
    case 30: 
      return "SCANNER_STATE_ATTRIBUTE_VALUE";
    case 38: 
      return "SCANNER_STATE_START_ELEMENT_TAG";
    case 39: 
      return "SCANNER_STATE_END_ELEMENT_TAG";
    }
    return "SCANNER_STATE_CHARACTER_DATA";
  }
  
  public boolean isStandAlone()
  {
    return this.fStandalone;
  }
  
  public int next()
  {
    return this.fDriver.next();
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    boolean bool2 = true;
    super.reset(paramPropertyManager);
    this.fNamespaces = false;
    this.fNotifyBuiltInRefs = false;
    this.fMarkupDepth = 0;
    this.fCurrentElement = null;
    this.fShouldSkip = false;
    this.fAdd = false;
    this.fSkip = false;
    this.fElementStack.clear();
    this.fHasExternalDTD = false;
    this.fStandaloneSet = false;
    this.fStandalone = false;
    this.fReplaceEntityReferences = ((Boolean)paramPropertyManager.getProperty("com.amazonaws.javax.xml.stream.isReplacingEntityReferences")).booleanValue();
    this.fSupportExternalEntities = ((Boolean)paramPropertyManager.getProperty("com.amazonaws.javax.xml.stream.isSupportingExternalEntities")).booleanValue();
    Boolean localBoolean = (Boolean)paramPropertyManager.getProperty("http://java.sun.com/xml/stream/properties/report-cdata-event");
    if (localBoolean != null) {
      this.fReportCdataEvent = localBoolean.booleanValue();
    }
    paramPropertyManager = (Boolean)paramPropertyManager.getProperty("com.amazonaws.javax.xml.stream.isCoalescing");
    if (paramPropertyManager != null) {
      this.fIsCoalesce = paramPropertyManager.booleanValue();
    }
    if (this.fIsCoalesce)
    {
      bool1 = false;
      this.fReportCdataEvent = bool1;
      if (!this.fIsCoalesce) {
        break label204;
      }
    }
    label204:
    for (boolean bool1 = bool2;; bool1 = this.fReplaceEntityReferences)
    {
      this.fReplaceEntityReferences = bool1;
      this.fEntityStore = this.fEntityManager.getEntityStore();
      return;
      if (this.fReportCdataEvent)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  protected void scanAttribute(XMLAttributes paramXMLAttributes)
  {
    boolean bool2 = false;
    if (this.fNamespaces) {
      this.fEntityScanner.scanQName(this.fAttributeQName);
    }
    for (;;)
    {
      this.fEntityScanner.skipSpaces();
      if (!this.fEntityScanner.skipChar(61)) {
        reportFatalError("EqRequiredInAttribute", new Object[] { this.fAttributeQName.rawname });
      }
      this.fEntityScanner.skipSpaces();
      int i = paramXMLAttributes.getLength();
      paramXMLAttributes.addAttribute(this.fAttributeQName, XMLSymbols.fCDATASymbol, null);
      if (i == paramXMLAttributes.getLength()) {
        reportFatalError("AttributeNotUnique", new Object[] { this.fCurrentElement.rawname, this.fAttributeQName.rawname });
      }
      boolean bool1 = bool2;
      if (this.fHasExternalDTD)
      {
        bool1 = bool2;
        if (!this.fStandalone) {
          bool1 = true;
        }
      }
      scanAttributeValue(this.fTempString, this.fTempString2, this.fAttributeQName.rawname, paramXMLAttributes, i, bool1);
      paramXMLAttributes.setValue(i, this.fTempString.toString());
      paramXMLAttributes.setSpecified(i, true);
      return;
      String str = this.fEntityScanner.scanName();
      this.fAttributeQName.setValues(null, str, str, null);
    }
  }
  
  protected boolean scanCDATASection(XMLStringBuffer paramXMLStringBuffer, boolean paramBoolean)
  {
    if (this.fDocumentHandler != null) {
      this.fDocumentHandler.startCDATA(null);
    }
    if (!this.fEntityScanner.scanData("]]>", paramXMLStringBuffer)) {}
    label139:
    label168:
    for (;;)
    {
      this.fMarkupDepth -= 1;
      if ((this.fDocumentHandler != null) && (paramXMLStringBuffer.length > 0)) {
        this.fDocumentHandler.characters(paramXMLStringBuffer, null);
      }
      if (this.fDocumentHandler != null) {
        this.fDocumentHandler.endCDATA(null);
      }
      return true;
      int i = this.fEntityScanner.peekChar();
      if ((i != -1) && (isInvalidLiteral(i)))
      {
        if (!XMLChar.isHighSurrogate(i)) {
          break label139;
        }
        scanSurrogates(paramXMLStringBuffer);
      }
      for (;;)
      {
        if (this.fDocumentHandler == null) {
          break label168;
        }
        this.fDocumentHandler.characters(paramXMLStringBuffer, null);
        break;
        reportFatalError("InvalidCharInCDSect", new Object[] { Integer.toString(i, 16) });
        this.fEntityScanner.scanChar();
      }
    }
  }
  
  protected void scanComment()
  {
    this.fContentBuffer.clear();
    scanComment(this.fContentBuffer);
    this.fUsebuffer = true;
    this.fMarkupDepth -= 1;
    if (this.fDocumentHandler != null) {
      this.fDocumentHandler.comment(this.fContentBuffer, null);
    }
  }
  
  protected int scanContent(XMLStringBuffer paramXMLStringBuffer)
  {
    int i = -1;
    this.fTempString.length = 0;
    int j = this.fEntityScanner.scanContent(this.fTempString);
    paramXMLStringBuffer.append(this.fTempString);
    this.fTempString.length = 0;
    if (j == 13)
    {
      this.fEntityScanner.scanChar();
      paramXMLStringBuffer.append((char)j);
    }
    for (;;)
    {
      if ((this.fDocumentHandler != null) && (paramXMLStringBuffer.length > 0)) {
        this.fDocumentHandler.characters(paramXMLStringBuffer, null);
      }
      return i;
      if (j == 93)
      {
        paramXMLStringBuffer.append((char)this.fEntityScanner.scanChar());
        this.fInScanContent = true;
        if (this.fEntityScanner.skipChar(93))
        {
          paramXMLStringBuffer.append(']');
          while (this.fEntityScanner.skipChar(93)) {
            paramXMLStringBuffer.append(']');
          }
          if (this.fEntityScanner.skipChar(62)) {
            reportFatalError("CDEndInContent", null);
          }
        }
        this.fInScanContent = false;
      }
      else
      {
        i = j;
      }
    }
  }
  
  protected int scanEndElement()
  {
    String str = this.fElementStack.popElement().rawname;
    if (!this.fEntityScanner.skipString(str)) {
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
    if (this.fDocumentHandler != null) {}
    return this.fMarkupDepth;
  }
  
  protected void scanEntityReference(XMLStringBuffer paramXMLStringBuffer)
  {
    String str = this.fEntityScanner.scanName();
    if (str == null) {
      reportFatalError("NameRequiredInReference", null);
    }
    if (!this.fEntityScanner.skipChar(59)) {
      reportFatalError("SemicolonRequiredInReference", new Object[] { str });
    }
    if (this.fEntityStore.isUnparsedEntity(str)) {
      reportFatalError("ReferenceToUnparsedEntity", new Object[] { str });
    }
    this.fMarkupDepth -= 1;
    this.fCurrentEntityName = str;
    if (str == fAmpSymbol)
    {
      handleCharacter('&', fAmpSymbol, paramXMLStringBuffer);
      this.fScannerState = 41;
      return;
    }
    if (str == fLtSymbol)
    {
      handleCharacter('<', fLtSymbol, paramXMLStringBuffer);
      this.fScannerState = 41;
      return;
    }
    if (str == fGtSymbol)
    {
      handleCharacter('>', fGtSymbol, paramXMLStringBuffer);
      this.fScannerState = 41;
      return;
    }
    if (str == fQuotSymbol)
    {
      handleCharacter('"', fQuotSymbol, paramXMLStringBuffer);
      this.fScannerState = 41;
      return;
    }
    if (str == fAposSymbol)
    {
      handleCharacter('\'', fAposSymbol, paramXMLStringBuffer);
      this.fScannerState = 41;
      return;
    }
    if (((this.fEntityStore.isExternalEntity(str)) && (!this.fSupportExternalEntities)) || ((!this.fEntityStore.isExternalEntity(str)) && (!this.fReplaceEntityReferences)))
    {
      this.fScannerState = 28;
      return;
    }
    if (!this.fEntityStore.isDeclaredEntity(str))
    {
      if ((this.fDisallowDoctype) && (this.fReplaceEntityReferences))
      {
        reportFatalError("EntityNotDeclared", new Object[] { str });
        return;
      }
      if ((!this.fHasExternalDTD) || (this.fStandalone)) {
        break label349;
      }
      if (this.fValidation) {
        this.fErrorReporter.reportError(this.fEntityScanner, "http://www.w3.org/TR/1998/REC-xml-19980210", "EntityNotDeclared", new Object[] { str }, (short)1);
      }
    }
    for (;;)
    {
      this.fEntityManager.startEntity(str, false);
      return;
      label349:
      reportFatalError("EntityNotDeclared", new Object[] { str });
    }
  }
  
  protected void scanPIData(String paramString, XMLStringBuffer paramXMLStringBuffer)
  {
    super.scanPIData(paramString, paramXMLStringBuffer);
    this.fPITarget = paramString;
    this.fMarkupDepth -= 1;
    if (this.fDocumentHandler != null) {
      this.fDocumentHandler.processingInstruction(paramString, paramXMLStringBuffer, null);
    }
  }
  
  protected boolean scanStartElement()
  {
    if ((this.fShouldSkip) && (!this.fAdd)) {
      this.fShouldSkip = skipQElement(this.fElementStack2.getNext());
    }
    label88:
    String str;
    label122:
    boolean bool;
    int i;
    if (this.fAdd)
    {
      this.fElementQName = this.fElementStack2.nextElement();
      this.fCurrentElement = this.fElementQName;
      if ((!this.fShouldSkip) || (this.fAdd))
      {
        if (!this.fNamespaces) {
          break label238;
        }
        this.fEntityScanner.scanQName(this.fElementQName);
      }
      if (this.fAdd) {
        this.fElementStack2.matchElement(this.fElementQName);
      }
      str = this.fElementQName.rawname;
      this.fAttributes.removeAllAttributes();
      bool = this.fEntityScanner.skipSpaces();
      i = this.fEntityScanner.peekChar();
      if (i != 62) {
        break label274;
      }
      this.fEntityScanner.scanChar();
      bool = false;
      label154:
      if (!bool) {
        break label357;
      }
      this.fMarkupDepth -= 1;
      if (this.fMarkupDepth < this.fEntityStack[(this.fEntityDepth - 1)]) {
        reportFatalError("ElementEntityMismatch", new Object[] { this.fCurrentElement.rawname });
      }
      if (this.fDocumentHandler != null) {}
      this.fElementStack.popElement();
    }
    label238:
    label274:
    label357:
    while (this.fDocumentHandler == null)
    {
      return bool;
      this.fElementQName = this.fElementStack.nextElement();
      break;
      str = this.fEntityScanner.scanName();
      this.fElementQName.setValues(null, str, str, null);
      this.fElementQName.characters = this.fEntityScanner.scannedName;
      break label88;
      if (i == 47)
      {
        this.fEntityScanner.scanChar();
        if (!this.fEntityScanner.skipChar(62)) {
          reportFatalError("ElementUnterminated", new Object[] { str });
        }
        bool = true;
        break label154;
      }
      if ((!isValidNameStartChar(i)) || (!bool)) {
        reportFatalError("ElementUnterminated", new Object[] { str });
      }
      scanAttribute(this.fAttributes);
      break label122;
    }
    return bool;
  }
  
  protected void scanXMLDeclOrTextDecl(boolean paramBoolean)
  {
    boolean bool2 = true;
    super.scanXMLDeclOrTextDecl(paramBoolean, this.fStrings);
    this.fMarkupDepth -= 1;
    String str1 = this.fStrings[0];
    String str2 = this.fStrings[1];
    String str3 = this.fStrings[2];
    this.fDeclaredEncoding = str2;
    boolean bool1;
    if (str3 != null)
    {
      bool1 = true;
      this.fStandaloneSet = bool1;
      if ((!this.fStandaloneSet) || (!str3.equals("yes"))) {
        break label158;
      }
      bool1 = bool2;
      label83:
      this.fStandalone = bool1;
      this.fEntityManager.setStandalone(this.fStandalone);
      if (this.fDocumentHandler != null)
      {
        if (!paramBoolean) {
          break label163;
        }
        this.fDocumentHandler.textDecl(str1, str2, null);
      }
    }
    for (;;)
    {
      if (str1 != null) {
        this.fEntityScanner.setVersion(str1);
      }
      if (str2 != null) {
        this.fEntityScanner.setEncoding(str2);
      }
      return;
      bool1 = false;
      break;
      label158:
      bool1 = false;
      break label83;
      label163:
      this.fDocumentHandler.xmlDecl(str1, str2, str3, null);
    }
  }
  
  protected final void setDriver(XMLDocumentFragmentScannerImpl.Driver paramDriver)
  {
    this.fDriver = paramDriver;
  }
  
  public void setInputSource(XMLInputSource paramXMLInputSource)
  {
    this.fEntityManager.setEntityHandler(this);
    this.fEntityManager.startEntity("$fragment$", paramXMLInputSource, false, true);
  }
  
  protected final void setScannerState(int paramInt)
  {
    this.fScannerState = paramInt;
  }
  
  boolean skipQElement(QName paramQName)
  {
    if (XMLChar.isName(this.fEntityScanner.getChar(paramQName.characters.length))) {
      return false;
    }
    return this.fEntityScanner.skipString(paramQName.characters);
  }
  
  public void startEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2)
  {
    if (this.fEntityDepth == this.fEntityStack.length)
    {
      int[] arrayOfInt = new int[this.fEntityStack.length * 2];
      System.arraycopy(this.fEntityStack, 0, arrayOfInt, 0, this.fEntityStack.length);
      this.fEntityStack = arrayOfInt;
    }
    this.fEntityStack[this.fEntityDepth] = this.fMarkupDepth;
    super.startEntity(paramString1, paramXMLResourceIdentifier, paramString2);
    if ((this.fStandalone) && (this.fEntityStore.isEntityDeclInExternalSubset(paramString1))) {
      reportFatalError("MSG_REFERENCE_TO_EXTERNALLY_DECLARED_ENTITY_WHEN_STANDALONE", new Object[] { paramString1 });
    }
    if ((this.fDocumentHandler != null) && (!this.fScanningAttribute) && (!paramString1.equals("[xml]"))) {
      this.fDocumentHandler.startGeneralEntity(paramString1, paramXMLResourceIdentifier, paramString2, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentFragmentScannerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */