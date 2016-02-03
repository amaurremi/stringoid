package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.dtd.nonvalidating.DTDGrammar;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLDTDContentModelHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLDTDHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDScanner;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.util.ArrayList;

public class XMLDTDScannerImpl
  extends XMLScanner
  implements XMLEntityHandler, XMLDTDScanner
{
  private static final Boolean[] FEATURE_DEFAULTS;
  private static final Object[] PROPERTY_DEFAULTS = { null, null, null };
  private static final String[] RECOGNIZED_FEATURES = { "http://xml.org/sax/features/validation", "http://apache.org/xml/features/scanner/notify-char-refs" };
  private static final String[] RECOGNIZED_PROPERTIES;
  private XMLAttributesImpl fAttributes = new XMLAttributesImpl();
  private int fContentDepth;
  private int[] fContentStack = new int[5];
  protected XMLDTDContentModelHandler fDTDContentModelHandler;
  public XMLDTDHandler fDTDHandler = null;
  private String[] fEnumeration = new String[5];
  private int fEnumerationCount;
  private int fExtEntityDepth;
  private XMLStringBuffer fIgnoreConditionalBuffer = new XMLStringBuffer(128);
  private int fIncludeSectDepth;
  private XMLString fLiteral = new XMLString();
  private XMLString fLiteral2 = new XMLString();
  private int fMarkUpDepth;
  private int fPEDepth;
  private boolean[] fPEReport = new boolean[5];
  private int[] fPEStack = new int[5];
  protected int fScannerState;
  protected boolean fSeenExternalDTD;
  protected boolean fSeenExternalPE;
  protected boolean fStandalone;
  private boolean fStartDTDCalled;
  private XMLString fString = new XMLString();
  private XMLStringBuffer fStringBuffer = new XMLStringBuffer();
  private XMLStringBuffer fStringBuffer2 = new XMLStringBuffer();
  private String[] fStrings = new String[3];
  boolean nonValidatingMode = true;
  DTDGrammar nvGrammarInfo = null;
  
  static
  {
    FEATURE_DEFAULTS = new Boolean[] { null, Boolean.FALSE };
    RECOGNIZED_PROPERTIES = new String[] { "http://apache.org/xml/properties/internal/symbol-table", "http://apache.org/xml/properties/internal/error-reporter", "http://apache.org/xml/properties/internal/entity-manager" };
  }
  
  private final void ensureEnumerationSize(int paramInt)
  {
    if (this.fEnumeration.length == paramInt)
    {
      String[] arrayOfString = new String[paramInt * 2];
      System.arraycopy(this.fEnumeration, 0, arrayOfString, 0, paramInt);
      this.fEnumeration = arrayOfString;
    }
  }
  
  private void init()
  {
    this.fStartDTDCalled = false;
    this.fExtEntityDepth = 0;
    this.fIncludeSectDepth = 0;
    this.fMarkUpDepth = 0;
    this.fPEDepth = 0;
    this.fStandalone = false;
    this.fSeenExternalDTD = false;
    this.fSeenExternalPE = false;
    this.fSymbolTable = ((SymbolTable)this.fPropertyManager.getProperty("http://apache.org/xml/properties/internal/symbol-table"));
    setScannerState(1);
    this.nvGrammarInfo = new DTDGrammar(this.fSymbolTable);
  }
  
  private final boolean peekReportEntity()
  {
    return this.fPEReport[(this.fPEDepth - 1)];
  }
  
  private final int popContentStack()
  {
    int[] arrayOfInt = this.fContentStack;
    int i = this.fContentDepth - 1;
    this.fContentDepth = i;
    return arrayOfInt[i];
  }
  
  private final int popPEStack()
  {
    int[] arrayOfInt = this.fPEStack;
    int i = this.fPEDepth - 1;
    this.fPEDepth = i;
    return arrayOfInt[i];
  }
  
  private final void pushContentStack(int paramInt)
  {
    if (this.fContentStack.length == this.fContentDepth)
    {
      arrayOfInt = new int[this.fContentDepth * 2];
      System.arraycopy(this.fContentStack, 0, arrayOfInt, 0, this.fContentDepth);
      this.fContentStack = arrayOfInt;
    }
    int[] arrayOfInt = this.fContentStack;
    int i = this.fContentDepth;
    this.fContentDepth = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  private final void pushPEStack(int paramInt, boolean paramBoolean)
  {
    if (this.fPEStack.length == this.fPEDepth)
    {
      localObject = new int[this.fPEDepth * 2];
      System.arraycopy(this.fPEStack, 0, localObject, 0, this.fPEDepth);
      this.fPEStack = ((int[])localObject);
      localObject = new boolean[this.fPEDepth * 2];
      System.arraycopy(this.fPEReport, 0, localObject, 0, this.fPEDepth);
      this.fPEReport = ((boolean[])localObject);
    }
    this.fPEReport[this.fPEDepth] = paramBoolean;
    Object localObject = this.fPEStack;
    int i = this.fPEDepth;
    this.fPEDepth = (i + 1);
    localObject[i] = paramInt;
  }
  
  private final String scanAttType(String paramString1, String paramString2)
  {
    this.fEnumerationCount = 0;
    if (this.fEntityScanner.skipString("CDATA")) {
      return "CDATA";
    }
    if (this.fEntityScanner.skipString("IDREFS")) {
      return "IDREFS";
    }
    if (this.fEntityScanner.skipString("IDREF")) {
      return "IDREF";
    }
    if (this.fEntityScanner.skipString("ID")) {
      return "ID";
    }
    if (this.fEntityScanner.skipString("ENTITY")) {
      return "ENTITY";
    }
    if (this.fEntityScanner.skipString("ENTITIES")) {
      return "ENTITIES";
    }
    if (this.fEntityScanner.skipString("NMTOKENS")) {
      return "NMTOKENS";
    }
    if (this.fEntityScanner.skipString("NMTOKEN")) {
      return "NMTOKEN";
    }
    label215:
    label225:
    String str;
    String[] arrayOfString;
    int i;
    if (this.fEntityScanner.skipString("NOTATION"))
    {
      if (!scanningInternalSubset())
      {
        bool = true;
        if (!skipSeparator(true, bool)) {
          reportFatalError("MSG_SPACE_REQUIRED_AFTER_NOTATION_IN_NOTATIONTYPE", new Object[] { paramString1, paramString2 });
        }
        if (this.fEntityScanner.scanChar() != 40) {
          reportFatalError("MSG_OPEN_PAREN_REQUIRED_IN_NOTATIONTYPE", new Object[] { paramString1, paramString2 });
        }
        this.fMarkUpDepth += 1;
        if (scanningInternalSubset()) {
          break label374;
        }
        bool = true;
        skipSeparator(false, bool);
        str = this.fEntityScanner.scanName();
        if (str == null) {
          reportFatalError("MSG_NAME_REQUIRED_IN_NOTATIONTYPE", new Object[] { paramString1, paramString2 });
        }
        ensureEnumerationSize(this.fEnumerationCount + 1);
        arrayOfString = this.fEnumeration;
        i = this.fEnumerationCount;
        this.fEnumerationCount = (i + 1);
        arrayOfString[i] = str;
        if (scanningInternalSubset()) {
          break label380;
        }
      }
      label374:
      label380:
      for (bool = true;; bool = false)
      {
        skipSeparator(false, bool);
        i = this.fEntityScanner.scanChar();
        if (i == 124) {
          break label215;
        }
        if (i != 41) {
          reportFatalError("NotationTypeUnterminated", new Object[] { paramString1, paramString2 });
        }
        this.fMarkUpDepth -= 1;
        return "NOTATION";
        bool = false;
        break;
        bool = false;
        break label225;
      }
    }
    if (this.fEntityScanner.scanChar() != 40) {
      reportFatalError("AttTypeRequiredInAttDef", new Object[] { paramString1, paramString2 });
    }
    this.fMarkUpDepth += 1;
    if (!scanningInternalSubset())
    {
      bool = true;
      label436:
      skipSeparator(false, bool);
      str = this.fEntityScanner.scanNmtoken();
      if (str == null) {
        reportFatalError("MSG_NMTOKEN_REQUIRED_IN_ENUMERATION", new Object[] { paramString1, paramString2 });
      }
      ensureEnumerationSize(this.fEnumerationCount + 1);
      arrayOfString = this.fEnumeration;
      i = this.fEnumerationCount;
      this.fEnumerationCount = (i + 1);
      arrayOfString[i] = str;
      if (scanningInternalSubset()) {
        break label586;
      }
    }
    label586:
    for (boolean bool = true;; bool = false)
    {
      skipSeparator(false, bool);
      i = this.fEntityScanner.scanChar();
      if (i == 124) {
        break;
      }
      if (i != 41) {
        reportFatalError("EnumerationUnterminated", new Object[] { paramString1, paramString2 });
      }
      this.fMarkUpDepth -= 1;
      return "ENUMERATION";
      bool = false;
      break label436;
    }
  }
  
  private final void scanChildren(String paramString)
  {
    this.fContentDepth = 0;
    pushContentStack(0);
    int i = 0;
    if (this.fEntityScanner.skipChar(40))
    {
      this.fMarkUpDepth += 1;
      this.fStringBuffer.append('(');
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.startGroup(null);
      }
      pushContentStack(i);
      if (!scanningInternalSubset()) {}
      for (bool = true;; bool = false)
      {
        skipSeparator(false, bool);
        i = 0;
        break;
      }
    }
    if (!scanningInternalSubset()) {}
    String str;
    for (boolean bool = true;; bool = false)
    {
      skipSeparator(false, bool);
      str = this.fEntityScanner.scanName();
      if (str != null) {
        break;
      }
      reportFatalError("MSG_OPEN_PAREN_OR_ELEMENT_TYPE_REQUIRED_IN_CHILDREN", new Object[] { paramString });
      return;
    }
    if (this.fDTDContentModelHandler != null) {
      this.fDTDContentModelHandler.element(str, null);
    }
    this.fStringBuffer.append(str);
    int k = this.fEntityScanner.peekChar();
    int j;
    short s;
    if ((k != 63) && (k != 42))
    {
      j = i;
      if (k != 43) {}
    }
    else
    {
      if (this.fDTDContentModelHandler != null)
      {
        if (k != 63) {
          break label352;
        }
        s = 2;
        label225:
        this.fDTDContentModelHandler.occurrence(s, null);
      }
      this.fEntityScanner.scanChar();
      this.fStringBuffer.append((char)k);
      j = i;
    }
    if (!scanningInternalSubset())
    {
      bool = true;
      label267:
      skipSeparator(false, bool);
      i = this.fEntityScanner.peekChar();
      if ((i != 44) || (j == 124)) {
        break label375;
      }
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.separator((short)1, null);
      }
      this.fEntityScanner.scanChar();
      this.fStringBuffer.append(',');
      label331:
      if (scanningInternalSubset()) {
        break label637;
      }
    }
    label352:
    label375:
    label637:
    for (bool = true;; bool = false)
    {
      skipSeparator(false, bool);
      break;
      if (k == 42)
      {
        s = 3;
        break label225;
      }
      s = 4;
      break label225;
      bool = false;
      break label267;
      if ((i == 124) && (j != 44))
      {
        if (this.fDTDContentModelHandler != null) {
          this.fDTDContentModelHandler.separator((short)0, null);
        }
        this.fEntityScanner.scanChar();
        this.fStringBuffer.append('|');
        break label331;
      }
      if (i != 41) {
        reportFatalError("MSG_CLOSE_PAREN_REQUIRED_IN_CHILDREN", new Object[] { paramString });
      }
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.endGroup(null);
      }
      j = popContentStack();
      if (this.fEntityScanner.skipString(")?"))
      {
        this.fStringBuffer.append(")?");
        if (this.fDTDContentModelHandler != null) {
          this.fDTDContentModelHandler.occurrence((short)2, null);
        }
      }
      for (;;)
      {
        this.fMarkUpDepth -= 1;
        if (this.fContentDepth != 0) {
          break;
        }
        return;
        if (this.fEntityScanner.skipString(")+"))
        {
          this.fStringBuffer.append(")+");
          if (this.fDTDContentModelHandler != null) {
            this.fDTDContentModelHandler.occurrence((short)4, null);
          }
        }
        else if (this.fEntityScanner.skipString(")*"))
        {
          this.fStringBuffer.append(")*");
          if (this.fDTDContentModelHandler != null) {
            this.fDTDContentModelHandler.occurrence((short)3, null);
          }
        }
        else
        {
          this.fEntityScanner.scanChar();
          this.fStringBuffer.append(')');
        }
      }
    }
  }
  
  private final void scanConditionalSect(int paramInt)
  {
    this.fReportEntity = false;
    if (!scanningInternalSubset())
    {
      bool = true;
      skipSeparator(false, bool);
      if (!this.fEntityScanner.skipString("INCLUDE")) {
        break label160;
      }
      if (scanningInternalSubset()) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      skipSeparator(false, bool);
      if ((paramInt != this.fPEDepth) && (this.fValidation)) {
        this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "INVALID_PE_IN_CONDITIONAL", new Object[] { this.fEntityManager.fCurrentEntity.name }, (short)1);
      }
      if (!this.fEntityScanner.skipChar(91)) {
        reportFatalError("MSG_MARKUP_NOT_RECOGNIZED_IN_DTD", null);
      }
      if (this.fDTDHandler != null) {
        this.fDTDHandler.startConditional((short)0, null);
      }
      this.fIncludeSectDepth += 1;
      this.fReportEntity = true;
      return;
      bool = false;
      break;
    }
    label160:
    if (this.fEntityScanner.skipString("IGNORE"))
    {
      if (!scanningInternalSubset())
      {
        bool = true;
        label182:
        skipSeparator(false, bool);
        if ((paramInt != this.fPEDepth) && (this.fValidation)) {
          this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "INVALID_PE_IN_CONDITIONAL", new Object[] { this.fEntityManager.fCurrentEntity.name }, (short)1);
        }
        if (this.fDTDHandler != null) {
          this.fDTDHandler.startConditional((short)1, null);
        }
        if (!this.fEntityScanner.skipChar(91)) {
          reportFatalError("MSG_MARKUP_NOT_RECOGNIZED_IN_DTD", null);
        }
        this.fReportEntity = true;
        paramInt = this.fIncludeSectDepth + 1;
        this.fIncludeSectDepth = paramInt;
        if (this.fDTDHandler != null) {
          this.fIgnoreConditionalBuffer.clear();
        }
      }
      for (;;)
      {
        if (this.fEntityScanner.skipChar(60))
        {
          if (this.fDTDHandler != null) {
            this.fIgnoreConditionalBuffer.append('<');
          }
          if (!this.fEntityScanner.skipChar(33)) {
            continue;
          }
          if (this.fEntityScanner.skipChar(91))
          {
            if (this.fDTDHandler != null) {
              this.fIgnoreConditionalBuffer.append("![");
            }
            this.fIncludeSectDepth += 1;
            continue;
            bool = false;
            break label182;
          }
          if (this.fDTDHandler == null) {
            continue;
          }
          this.fIgnoreConditionalBuffer.append("!");
          continue;
        }
        if (this.fEntityScanner.skipChar(93))
        {
          if (this.fDTDHandler != null) {
            this.fIgnoreConditionalBuffer.append(']');
          }
          if (!this.fEntityScanner.skipChar(93)) {
            continue;
          }
          if (this.fDTDHandler != null) {
            this.fIgnoreConditionalBuffer.append(']');
          }
          while (this.fEntityScanner.skipChar(93)) {
            if (this.fDTDHandler != null) {
              this.fIgnoreConditionalBuffer.append(']');
            }
          }
          if (!this.fEntityScanner.skipChar(62)) {
            continue;
          }
          i = this.fIncludeSectDepth;
          this.fIncludeSectDepth = (i - 1);
          if (i == paramInt)
          {
            this.fMarkUpDepth -= 1;
            if (this.fDTDHandler == null) {
              break;
            }
            this.fLiteral.setValues(this.fIgnoreConditionalBuffer.ch, 0, this.fIgnoreConditionalBuffer.length - 2);
            this.fDTDHandler.ignoredCharacters(this.fLiteral, null);
            this.fDTDHandler.endConditional(null);
            return;
          }
          if (this.fDTDHandler == null) {
            continue;
          }
          this.fIgnoreConditionalBuffer.append('>');
          continue;
        }
        int i = this.fEntityScanner.scanChar();
        if (this.fScannerState == 0)
        {
          reportFatalError("IgnoreSectUnterminated", null);
          return;
        }
        if (this.fDTDHandler != null) {
          this.fIgnoreConditionalBuffer.append((char)i);
        }
      }
    }
    reportFatalError("MSG_MARKUP_NOT_RECOGNIZED_IN_DTD", null);
  }
  
  private final void scanEntityDecl()
  {
    this.fReportEntity = false;
    int i;
    boolean bool1;
    boolean bool2;
    label37:
    label59:
    String str1;
    label112:
    String str3;
    String str4;
    label185:
    label238:
    String str2;
    if (this.fEntityScanner.skipSpaces()) {
      if (!this.fEntityScanner.skipChar(37))
      {
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i != 0)
        {
          localObject = this.fEntityScanner.scanName();
          if (localObject != null) {
            break label726;
          }
          reportFatalError("NameRequiredInPEReference", null);
          this.fEntityScanner.skipSpaces();
          if (this.fEntityScanner.skipChar(37)) {
            break label767;
          }
          bool2 = bool1;
        }
        str1 = this.fEntityScanner.scanName();
        if (str1 == null) {
          reportFatalError("MSG_ENTITY_NAME_REQUIRED_IN_ENTITYDECL", null);
        }
        if (scanningInternalSubset()) {
          break label812;
        }
        bool1 = true;
        if (!skipSeparator(true, bool1)) {
          reportFatalError("MSG_SPACE_REQUIRED_AFTER_ENTITY_NAME_IN_ENTITYDECL", new Object[] { str1 });
        }
        scanExternalID(this.fStrings, false);
        str3 = this.fStrings[0];
        str4 = this.fStrings[1];
        if ((bool2) && (str3 != null)) {
          this.fSeenExternalPE = true;
        }
        if (scanningInternalSubset()) {
          break label817;
        }
        bool1 = true;
        bool1 = skipSeparator(true, bool1);
        if ((bool2) || (!this.fEntityScanner.skipString("NDATA"))) {
          break label918;
        }
        if (!bool1) {
          reportFatalError("MSG_SPACE_REQUIRED_BEFORE_NDATA_IN_UNPARSED_ENTITYDECL", new Object[] { str1 });
        }
        if (scanningInternalSubset()) {
          break label822;
        }
        bool1 = true;
        if (!skipSeparator(true, bool1)) {
          reportFatalError("MSG_SPACE_REQUIRED_BEFORE_NOTATION_NAME_IN_UNPARSED_ENTITYDECL", new Object[] { str1 });
        }
        str2 = this.fEntityScanner.scanName();
        localObject = str2;
        if (str2 == null) {
          reportFatalError("MSG_NOTATION_NAME_REQUIRED_FOR_UNPARSED_ENTITYDECL", new Object[] { str1 });
        }
      }
    }
    label397:
    label505:
    label591:
    label726:
    label767:
    label799:
    label812:
    label817:
    label822:
    label850:
    label915:
    label918:
    for (Object localObject = str2;; localObject = null)
    {
      if (str3 == null)
      {
        scanEntityValue(this.fLiteral, this.fLiteral2);
        this.fStringBuffer.clear();
        this.fStringBuffer2.clear();
        this.fStringBuffer.append(this.fLiteral.ch, this.fLiteral.offset, this.fLiteral.length);
        this.fStringBuffer2.append(this.fLiteral2.ch, this.fLiteral2.offset, this.fLiteral2.length);
      }
      if (!scanningInternalSubset())
      {
        bool1 = true;
        skipSeparator(false, bool1);
        if (!this.fEntityScanner.skipChar(62)) {
          reportFatalError("EntityDeclUnterminated", new Object[] { str1 });
        }
        this.fMarkUpDepth -= 1;
        if (!bool2) {
          break label915;
        }
        str1 = "%" + str1;
      }
      for (;;)
      {
        if (str3 != null)
        {
          str2 = this.fEntityScanner.getBaseSystemId();
          if (localObject != null)
          {
            this.fEntityStore.addUnparsedEntity(str1, str4, str3, str2, (String)localObject);
            if (this.fDTDHandler != null)
            {
              this.fResourceIdentifier.setValues(str4, str3, str2, XMLEntityManager.expandSystemId(str3, str2));
              if (localObject == null) {
                break label850;
              }
              this.fDTDHandler.unparsedEntityDecl(str1, this.fResourceIdentifier, (String)localObject, null);
            }
          }
        }
        for (;;)
        {
          this.fReportEntity = true;
          return;
          if (!scanningInternalSubset()) {}
          for (bool1 = true;; bool1 = false)
          {
            if (!skipSeparator(true, bool1)) {
              break label591;
            }
            i = 0;
            bool1 = true;
            break;
          }
          if (scanningInternalSubset())
          {
            reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ENTITY_NAME_IN_ENTITYDECL", null);
            i = 0;
            bool1 = true;
            break;
          }
          if (this.fEntityScanner.peekChar() == 37)
          {
            if (!scanningInternalSubset()) {}
            for (bool1 = true;; bool1 = false)
            {
              skipSeparator(false, bool1);
              i = 0;
              bool1 = true;
              break;
            }
          }
          i = 1;
          bool1 = false;
          break;
          if ((scanningInternalSubset()) || (!this.fEntityScanner.skipChar(37)))
          {
            reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ENTITY_NAME_IN_ENTITYDECL", null);
            i = 0;
            bool1 = false;
            break;
          }
          if (this.fEntityScanner.skipSpaces())
          {
            reportFatalError("MSG_SPACE_REQUIRED_BEFORE_PERCENT_IN_PEDECL", null);
            i = 0;
            bool1 = false;
            break;
          }
          i = 1;
          bool1 = false;
          break;
          if (!this.fEntityScanner.skipChar(59))
          {
            reportFatalError("SemicolonRequiredInPEReference", new Object[] { localObject });
            break label59;
          }
          startPE((String)localObject, false);
          break label59;
          if (bool1) {
            break label37;
          }
          if (!scanningInternalSubset()) {}
          for (bool1 = true;; bool1 = false)
          {
            if (!skipSeparator(true, bool1)) {
              break label799;
            }
            bool2 = true;
            break;
          }
          bool1 = this.fEntityScanner.skipChar(37);
          break label37;
          bool1 = false;
          break label112;
          bool1 = false;
          break label185;
          bool1 = false;
          break label238;
          bool1 = false;
          break label397;
          this.fEntityStore.addExternalEntity(str1, str4, str3, str2);
          break label505;
          this.fDTDHandler.externalEntityDecl(str1, this.fResourceIdentifier, null);
          continue;
          this.fEntityStore.addInternalEntity(str1, this.fStringBuffer.toString());
          if (this.fDTDHandler != null) {
            this.fDTDHandler.internalEntityDecl(str1, this.fStringBuffer, this.fStringBuffer2, null);
          }
        }
      }
    }
  }
  
  private final void scanMixed(String paramString)
  {
    this.fStringBuffer.append("#PCDATA");
    if (this.fDTDContentModelHandler != null) {
      this.fDTDContentModelHandler.pcdata(null);
    }
    String str;
    if (!scanningInternalSubset())
    {
      bool = true;
      skipSeparator(false, bool);
      str = null;
      label45:
      if (!this.fEntityScanner.skipChar(124)) {
        break label187;
      }
      this.fStringBuffer.append('|');
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.separator((short)0, null);
      }
      if (scanningInternalSubset()) {
        break label177;
      }
      bool = true;
      label93:
      skipSeparator(false, bool);
      str = this.fEntityScanner.scanName();
      if (str == null) {
        reportFatalError("MSG_ELEMENT_TYPE_REQUIRED_IN_MIXED_CONTENT", new Object[] { paramString });
      }
      this.fStringBuffer.append(str);
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.element(str, null);
      }
      if (scanningInternalSubset()) {
        break label182;
      }
    }
    label177:
    label182:
    for (boolean bool = true;; bool = false)
    {
      skipSeparator(false, bool);
      break label45;
      bool = false;
      break;
      bool = false;
      break label93;
    }
    label187:
    if (this.fEntityScanner.skipString(")*"))
    {
      this.fStringBuffer.append(")*");
      if (this.fDTDContentModelHandler != null)
      {
        this.fDTDContentModelHandler.endGroup(null);
        this.fDTDContentModelHandler.occurrence((short)3, null);
      }
    }
    for (;;)
    {
      this.fMarkUpDepth -= 1;
      return;
      if (str != null)
      {
        reportFatalError("MixedContentUnterminated", new Object[] { paramString });
      }
      else if (this.fEntityScanner.skipChar(41))
      {
        this.fStringBuffer.append(')');
        if (this.fDTDContentModelHandler != null) {
          this.fDTDContentModelHandler.endGroup(null);
        }
      }
      else
      {
        reportFatalError("MSG_CLOSE_PAREN_REQUIRED_IN_CHILDREN", new Object[] { paramString });
      }
    }
  }
  
  private final void scanNotationDecl()
  {
    this.fReportEntity = false;
    String str1;
    label60:
    String str2;
    String str3;
    String str4;
    if (!scanningInternalSubset())
    {
      bool = true;
      if (!skipSeparator(true, bool)) {
        reportFatalError("MSG_SPACE_REQUIRED_BEFORE_NOTATION_NAME_IN_NOTATIONDECL", null);
      }
      str1 = this.fEntityScanner.scanName();
      if (str1 == null) {
        reportFatalError("MSG_NOTATION_NAME_REQUIRED_IN_NOTATIONDECL", null);
      }
      if (scanningInternalSubset()) {
        break label265;
      }
      bool = true;
      if (!skipSeparator(true, bool)) {
        reportFatalError("MSG_SPACE_REQUIRED_AFTER_NOTATION_NAME_IN_NOTATIONDECL", new Object[] { str1 });
      }
      scanExternalID(this.fStrings, true);
      str2 = this.fStrings[0];
      str3 = this.fStrings[1];
      str4 = this.fEntityScanner.getBaseSystemId();
      if ((str2 == null) && (str3 == null)) {
        reportFatalError("ExternalIDorPublicIDRequired", new Object[] { str1 });
      }
      if (scanningInternalSubset()) {
        break label270;
      }
    }
    label265:
    label270:
    for (boolean bool = true;; bool = false)
    {
      skipSeparator(false, bool);
      if (!this.fEntityScanner.skipChar(62)) {
        reportFatalError("NotationDeclUnterminated", new Object[] { str1 });
      }
      this.fMarkUpDepth -= 1;
      this.fResourceIdentifier.setValues(str3, str2, str4, XMLEntityManager.expandSystemId(str2, str4));
      if (this.nonValidatingMode) {
        this.nvGrammarInfo.notationDecl(str1, this.fResourceIdentifier, null);
      }
      if (this.fDTDHandler != null) {
        this.fDTDHandler.notationDecl(str1, this.fResourceIdentifier, null);
      }
      this.fReportEntity = true;
      return;
      bool = false;
      break;
      bool = false;
      break label60;
    }
  }
  
  private boolean skipSeparator(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = false;
    int i = this.fPEDepth;
    boolean bool2 = this.fEntityScanner.skipSpaces();
    if ((!paramBoolean2) || (!this.fEntityScanner.skipChar(37)))
    {
      if ((paramBoolean1) && (!bool2))
      {
        paramBoolean1 = bool1;
        if (i == this.fPEDepth) {}
      }
      else
      {
        paramBoolean1 = true;
      }
      return paramBoolean1;
    }
    String str = this.fEntityScanner.scanName();
    if (str == null) {
      reportFatalError("NameRequiredInPEReference", null);
    }
    for (;;)
    {
      startPE(str, false);
      this.fEntityScanner.skipSpaces();
      if (this.fEntityScanner.skipChar(37)) {
        break;
      }
      return true;
      if (!this.fEntityScanner.skipChar(59)) {
        reportFatalError("SemicolonRequiredInPEReference", new Object[] { str });
      }
    }
  }
  
  public void endEntity(String paramString)
  {
    super.endEntity(paramString);
    if (this.fScannerState == 0) {}
    boolean bool1;
    do
    {
      return;
      boolean bool2 = this.fReportEntity;
      if (paramString.startsWith("%"))
      {
        bool1 = peekReportEntity();
        int i = popPEStack();
        if ((i == 0) && (i < this.fMarkUpDepth)) {
          this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "ILL_FORMED_PARAMETER_ENTITY_WHEN_USED_IN_DECL", new Object[] { this.fEntityManager.fCurrentEntity.name }, (short)2);
        }
        if (i != this.fMarkUpDepth)
        {
          if (this.fValidation) {
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "ImproperDeclarationNesting", new Object[] { paramString }, (short)1);
          }
          bool1 = false;
        }
        bool2 = bool1;
        if (this.fEntityScanner.isExternal())
        {
          this.fExtEntityDepth -= 1;
          bool2 = bool1;
        }
      }
      bool1 = paramString.equals("[dtd]");
      if ((this.fDTDHandler != null) && (!bool1) && (bool2)) {
        this.fDTDHandler.endParameterEntity(paramString, null);
      }
    } while (!bool1);
    if (this.fIncludeSectDepth != 0) {
      reportFatalError("IncludeSectUnterminated", null);
    }
    this.fScannerState = 0;
    this.fEntityManager.endExternalSubset();
    if (this.fDTDHandler != null)
    {
      this.fDTDHandler.endExternalSubset(null);
      this.fDTDHandler.endDTD(null);
    }
    this.fExtEntityDepth -= 1;
  }
  
  public DTDGrammar getGrammar()
  {
    return this.nvGrammarInfo;
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    setPropertyManager(paramPropertyManager);
    super.reset(paramPropertyManager);
    if (!this.fAttributeCacheInitDone)
    {
      int i = 0;
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
    init();
  }
  
  protected final String scanAttDefaultDecl(String paramString1, String paramString2, String paramString3, XMLString paramXMLString1, XMLString paramXMLString2)
  {
    this.fString.clear();
    paramXMLString1.clear();
    if (this.fEntityScanner.skipString("#REQUIRED")) {
      return "#REQUIRED";
    }
    if (this.fEntityScanner.skipString("#IMPLIED")) {
      return "#IMPLIED";
    }
    boolean bool;
    if (this.fEntityScanner.skipString("#FIXED")) {
      if (!scanningInternalSubset())
      {
        bool = true;
        if (!skipSeparator(true, bool)) {
          reportFatalError("MSG_SPACE_REQUIRED_AFTER_FIXED_IN_DEFAULTDECL", new Object[] { paramString1, paramString2 });
        }
      }
    }
    for (paramString1 = "#FIXED";; paramString1 = null)
    {
      if ((!this.fStandalone) && ((this.fSeenExternalDTD) || (this.fSeenExternalPE))) {}
      for (bool = true;; bool = false)
      {
        scanAttributeValue(paramXMLString1, paramXMLString2, paramString2, this.fAttributes, 0, bool);
        return paramString1;
        bool = false;
        break;
      }
    }
  }
  
  protected final void scanAttlistDecl()
  {
    this.fReportEntity = false;
    boolean bool;
    String str1;
    if (!scanningInternalSubset())
    {
      bool = true;
      if (!skipSeparator(true, bool)) {
        reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ELEMENT_TYPE_IN_ATTLISTDECL", null);
      }
      str1 = this.fEntityScanner.scanName();
      if (str1 == null) {
        reportFatalError("MSG_ELEMENT_TYPE_REQUIRED_IN_ATTLISTDECL", null);
      }
      if (this.fDTDHandler != null) {
        this.fDTDHandler.startAttlist(str1, null);
      }
      if (scanningInternalSubset()) {
        break label135;
      }
      bool = true;
    }
    for (;;)
    {
      if (!skipSeparator(true, bool))
      {
        if (this.fEntityScanner.skipChar(62))
        {
          if (this.fDTDHandler != null) {
            this.fDTDHandler.endAttlist(null);
          }
          this.fMarkUpDepth -= 1;
          return;
          bool = false;
          break;
          label135:
          bool = false;
          continue;
        }
        reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ATTRIBUTE_NAME_IN_ATTDEF", new Object[] { str1 });
      }
    }
    if (!this.fEntityScanner.skipChar(62))
    {
      String str2 = this.fEntityScanner.scanName();
      if (str2 == null) {
        reportFatalError("AttNameRequiredInAttDef", new Object[] { str1 });
      }
      label207:
      String str3;
      label256:
      String str4;
      Object localObject1;
      if (!scanningInternalSubset())
      {
        bool = true;
        if (!skipSeparator(true, bool)) {
          reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ATTTYPE_IN_ATTDEF", new Object[] { str1, str2 });
        }
        str3 = scanAttType(str1, str2);
        if (scanningInternalSubset()) {
          break label460;
        }
        bool = true;
        if (!skipSeparator(true, bool)) {
          reportFatalError("MSG_SPACE_REQUIRED_BEFORE_DEFAULTDECL_IN_ATTDEF", new Object[] { str1, str2 });
        }
        str4 = scanAttDefaultDecl(str1, str2, str3, this.fLiteral, this.fLiteral2);
        Object localObject2 = null;
        if (this.fDTDHandler == null)
        {
          localObject1 = localObject2;
          if (!this.nonValidatingMode) {}
        }
        else
        {
          localObject1 = localObject2;
          if (this.fEnumerationCount != 0)
          {
            localObject1 = new String[this.fEnumerationCount];
            System.arraycopy(this.fEnumeration, 0, localObject1, 0, this.fEnumerationCount);
          }
        }
        if ((str4 == null) || ((!str4.equals("#REQUIRED")) && (!str4.equals("#IMPLIED")))) {
          break label465;
        }
        if (this.fDTDHandler != null) {
          this.fDTDHandler.attributeDecl(str1, str2, str3, (String[])localObject1, str4, null, null, null);
        }
        if (this.nonValidatingMode) {
          this.nvGrammarInfo.attributeDecl(str1, str2, str3, (String[])localObject1, str4, null, null, null);
        }
        label436:
        if (scanningInternalSubset()) {
          break label534;
        }
      }
      label460:
      label465:
      label534:
      for (bool = true;; bool = false)
      {
        skipSeparator(false, bool);
        break;
        bool = false;
        break label207;
        bool = false;
        break label256;
        if (this.fDTDHandler != null) {
          this.fDTDHandler.attributeDecl(str1, str2, str3, (String[])localObject1, str4, this.fLiteral, this.fLiteral2, null);
        }
        if (!this.nonValidatingMode) {
          break label436;
        }
        this.nvGrammarInfo.attributeDecl(str1, str2, str3, (String[])localObject1, str4, this.fLiteral, this.fLiteral2, null);
        break label436;
      }
    }
    if (this.fDTDHandler != null) {
      this.fDTDHandler.endAttlist(null);
    }
    this.fMarkUpDepth -= 1;
    this.fReportEntity = true;
  }
  
  protected final void scanComment()
  {
    this.fReportEntity = false;
    scanComment(this.fStringBuffer);
    this.fMarkUpDepth -= 1;
    if (this.fDTDHandler != null) {
      this.fDTDHandler.comment(this.fStringBuffer, null);
    }
    this.fReportEntity = true;
  }
  
  public boolean scanDTDExternalSubset(boolean paramBoolean)
  {
    this.fEntityManager.setEntityHandler(this);
    boolean bool;
    if (this.fScannerState == 1)
    {
      this.fSeenExternalDTD = true;
      bool = scanTextDecl();
      if (this.fScannerState != 0) {}
    }
    do
    {
      while (!scanDecls(paramBoolean))
      {
        return false;
        setScannerState(2);
        if ((bool) && (!paramBoolean)) {
          return true;
        }
      }
    } while (paramBoolean);
    return true;
  }
  
  public boolean scanDTDInternalSubset(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.fEntityScanner = ((XMLEntityReaderImpl)this.fEntityManager.getEntityReader());
    this.fEntityManager.setEntityHandler(this);
    this.fStandalone = paramBoolean2;
    if (this.fScannerState == 1)
    {
      if (this.fDTDHandler != null)
      {
        this.fDTDHandler.startDTD(this.fEntityScanner, null);
        this.fStartDTDCalled = true;
      }
      if (this.nonValidatingMode)
      {
        this.fStartDTDCalled = true;
        this.nvGrammarInfo.startDTD(this.fEntityScanner, null);
      }
      setScannerState(2);
    }
    do
    {
      if (!scanDecls(paramBoolean1))
      {
        if ((this.fDTDHandler != null) && (!paramBoolean3)) {
          this.fDTDHandler.endDTD(null);
        }
        if ((this.nonValidatingMode) && (!paramBoolean3)) {
          this.nvGrammarInfo.endDTD(null);
        }
        setScannerState(1);
        return false;
      }
    } while (paramBoolean1);
    return true;
  }
  
  protected final boolean scanDecls(boolean paramBoolean)
  {
    boolean bool2 = true;
    skipSeparator(false, true);
    boolean bool1 = true;
    if ((bool1) && (this.fScannerState == 2))
    {
      if (this.fEntityScanner.skipChar(60))
      {
        this.fMarkUpDepth += 1;
        if (this.fEntityScanner.skipChar(63))
        {
          this.fStringBuffer.clear();
          scanPI(this.fStringBuffer);
        }
      }
      for (;;)
      {
        skipSeparator(false, true);
        bool1 = paramBoolean;
        break;
        if (this.fEntityScanner.skipChar(33))
        {
          if (this.fEntityScanner.skipChar(45))
          {
            if (!this.fEntityScanner.skipChar(45)) {
              reportFatalError("MSG_MARKUP_NOT_RECOGNIZED_IN_DTD", null);
            } else {
              scanComment();
            }
          }
          else if (this.fEntityScanner.skipString("ELEMENT"))
          {
            scanElementDecl();
          }
          else if (this.fEntityScanner.skipString("ATTLIST"))
          {
            scanAttlistDecl();
          }
          else if (this.fEntityScanner.skipString("ENTITY"))
          {
            scanEntityDecl();
          }
          else if (this.fEntityScanner.skipString("NOTATION"))
          {
            scanNotationDecl();
          }
          else if ((this.fEntityScanner.skipChar(91)) && (!scanningInternalSubset()))
          {
            scanConditionalSect(this.fPEDepth);
          }
          else
          {
            this.fMarkUpDepth -= 1;
            reportFatalError("MSG_MARKUP_NOT_RECOGNIZED_IN_DTD", null);
          }
        }
        else
        {
          this.fMarkUpDepth -= 1;
          reportFatalError("MSG_MARKUP_NOT_RECOGNIZED_IN_DTD", null);
          continue;
          if ((this.fIncludeSectDepth > 0) && (this.fEntityScanner.skipChar(93)))
          {
            if ((!this.fEntityScanner.skipChar(93)) || (!this.fEntityScanner.skipChar(62))) {
              reportFatalError("IncludeSectUnterminated", null);
            }
            if (this.fDTDHandler != null) {
              this.fDTDHandler.endConditional(null);
            }
            this.fIncludeSectDepth -= 1;
            this.fMarkUpDepth -= 1;
          }
          else
          {
            if ((scanningInternalSubset()) && (this.fEntityScanner.peekChar() == 93)) {
              return false;
            }
            if (!this.fEntityScanner.skipSpaces()) {
              reportFatalError("MSG_MARKUP_NOT_RECOGNIZED_IN_DTD", null);
            }
          }
        }
      }
    }
    if (this.fScannerState != 0) {}
    for (paramBoolean = bool2;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  protected final void scanElementDecl()
  {
    this.fReportEntity = false;
    String str3;
    label62:
    String str2;
    String str1;
    if (!scanningInternalSubset())
    {
      bool = true;
      if (!skipSeparator(true, bool)) {
        reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ELEMENT_TYPE_IN_ELEMENTDECL", null);
      }
      str3 = this.fEntityScanner.scanName();
      if (str3 == null) {
        reportFatalError("MSG_ELEMENT_TYPE_REQUIRED_IN_ELEMENTDECL", null);
      }
      if (scanningInternalSubset()) {
        break label274;
      }
      bool = true;
      if (!skipSeparator(true, bool)) {
        reportFatalError("MSG_SPACE_REQUIRED_BEFORE_CONTENTSPEC_IN_ELEMENTDECL", new Object[] { str3 });
      }
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.startContentModel(str3, null);
      }
      this.fReportEntity = true;
      if (!this.fEntityScanner.skipString("EMPTY")) {
        break label279;
      }
      str2 = "EMPTY";
      str1 = str2;
      if (this.fDTDContentModelHandler != null)
      {
        this.fDTDContentModelHandler.empty(null);
        str1 = str2;
      }
      label149:
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.endContentModel(null);
      }
      this.fReportEntity = false;
      if (scanningInternalSubset()) {
        break label451;
      }
    }
    label274:
    label279:
    label400:
    label442:
    label451:
    for (boolean bool = true;; bool = false)
    {
      skipSeparator(false, bool);
      if (!this.fEntityScanner.skipChar(62)) {
        reportFatalError("ElementDeclUnterminated", new Object[] { str3 });
      }
      this.fReportEntity = true;
      this.fMarkUpDepth -= 1;
      if (this.fDTDHandler != null) {
        this.fDTDHandler.elementDecl(str3, str1, null);
      }
      if (this.nonValidatingMode) {
        this.nvGrammarInfo.elementDecl(str3, str1, null);
      }
      return;
      bool = false;
      break;
      bool = false;
      break label62;
      if (this.fEntityScanner.skipString("ANY"))
      {
        str2 = "ANY";
        str1 = str2;
        if (this.fDTDContentModelHandler == null) {
          break label149;
        }
        this.fDTDContentModelHandler.any(null);
        str1 = str2;
        break label149;
      }
      if (!this.fEntityScanner.skipChar(40)) {
        reportFatalError("MSG_OPEN_PAREN_OR_ELEMENT_TYPE_REQUIRED_IN_CHILDREN", new Object[] { str3 });
      }
      if (this.fDTDContentModelHandler != null) {
        this.fDTDContentModelHandler.startGroup(null);
      }
      this.fStringBuffer.clear();
      this.fStringBuffer.append('(');
      this.fMarkUpDepth += 1;
      if (!scanningInternalSubset())
      {
        bool = true;
        skipSeparator(false, bool);
        if (!this.fEntityScanner.skipString("#PCDATA")) {
          break label442;
        }
        scanMixed(str3);
      }
      for (;;)
      {
        str1 = this.fStringBuffer.toString();
        break;
        bool = false;
        break label400;
        scanChildren(str3);
      }
    }
  }
  
  protected final void scanEntityValue(XMLString paramXMLString1, XMLString paramXMLString2)
  {
    int i = this.fEntityScanner.scanChar();
    if ((i != 39) && (i != 34)) {
      reportFatalError("OpenQuoteMissingInDecl", null);
    }
    int j = this.fEntityDepth;
    Object localObject2 = this.fString;
    Object localObject1 = this.fString;
    if (this.fEntityScanner.scanLiteral(i, this.fString) != i)
    {
      this.fStringBuffer.clear();
      this.fStringBuffer2.clear();
    }
    for (;;)
    {
      this.fStringBuffer.append(this.fString);
      this.fStringBuffer2.append(this.fString);
      if (this.fEntityScanner.skipChar(38)) {
        if (this.fEntityScanner.skipChar(35))
        {
          this.fStringBuffer2.append("&#");
          scanCharReferenceValue(this.fStringBuffer, this.fStringBuffer2);
        }
      }
      while (this.fEntityScanner.scanLiteral(i, this.fString) == i)
      {
        this.fStringBuffer.append(this.fString);
        this.fStringBuffer2.append(this.fString);
        localObject2 = this.fStringBuffer;
        localObject1 = this.fStringBuffer2;
        paramXMLString1.setValues((XMLString)localObject2);
        paramXMLString2.setValues((XMLString)localObject1);
        if (!this.fEntityScanner.skipChar(i)) {
          reportFatalError("CloseQuoteMissingInDecl", null);
        }
        return;
        this.fStringBuffer.append('&');
        this.fStringBuffer2.append('&');
        localObject1 = this.fEntityScanner.scanName();
        if (localObject1 == null) {
          reportFatalError("NameRequiredInReference", null);
        }
        for (;;)
        {
          if (this.fEntityScanner.skipChar(59)) {
            break label319;
          }
          reportFatalError("SemicolonRequiredInReference", new Object[] { localObject1 });
          break;
          this.fStringBuffer.append((String)localObject1);
          this.fStringBuffer2.append((String)localObject1);
        }
        label319:
        this.fStringBuffer.append(';');
        this.fStringBuffer2.append(';');
        continue;
        if (this.fEntityScanner.skipChar(37))
        {
          label352:
          this.fStringBuffer2.append('%');
          localObject1 = this.fEntityScanner.scanName();
          if (localObject1 == null) {
            reportFatalError("NameRequiredInPEReference", null);
          }
          for (;;)
          {
            startPE((String)localObject1, true);
            this.fEntityScanner.skipSpaces();
            if (this.fEntityScanner.skipChar(37)) {
              break label352;
            }
            break;
            if (!this.fEntityScanner.skipChar(59))
            {
              reportFatalError("SemicolonRequiredInPEReference", new Object[] { localObject1 });
            }
            else
            {
              if (scanningInternalSubset()) {
                reportFatalError("PEReferenceWithinMarkup", new Object[] { localObject1 });
              }
              this.fStringBuffer2.append((String)localObject1);
              this.fStringBuffer2.append(';');
            }
          }
        }
        int k = this.fEntityScanner.peekChar();
        if (XMLChar.isHighSurrogate(k))
        {
          scanSurrogates(this.fStringBuffer2);
        }
        else if (isInvalidLiteral(k))
        {
          reportFatalError("InvalidCharInLiteral", new Object[] { Integer.toHexString(k) });
          this.fEntityScanner.scanChar();
        }
        else if ((k != i) || (j != this.fEntityDepth))
        {
          this.fStringBuffer.append((char)k);
          this.fStringBuffer2.append((char)k);
          this.fEntityScanner.scanChar();
        }
      }
    }
  }
  
  protected final void scanPIData(String paramString, XMLString paramXMLString)
  {
    this.fMarkUpDepth -= 1;
    if (this.fDTDHandler != null) {
      this.fDTDHandler.processingInstruction(paramString, paramXMLString, null);
    }
  }
  
  protected final boolean scanTextDecl()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.fEntityScanner.skipString("<?xml"))
    {
      this.fMarkUpDepth += 1;
      if (!isValidNameChar(this.fEntityScanner.peekChar())) {
        break label139;
      }
      this.fStringBuffer.clear();
      this.fStringBuffer.append("xml");
      while (isValidNameChar(this.fEntityScanner.peekChar())) {
        this.fStringBuffer.append((char)this.fEntityScanner.scanChar());
      }
      scanPIData(this.fSymbolTable.addSymbol(this.fStringBuffer.ch, this.fStringBuffer.offset, this.fStringBuffer.length), this.fString);
    }
    for (bool1 = bool2;; bool1 = true)
    {
      this.fEntityManager.fCurrentEntity.mayReadChunks = true;
      return bool1;
      label139:
      scanXMLDeclOrTextDecl(true, this.fStrings);
      this.fMarkUpDepth -= 1;
      String str1 = this.fStrings[0];
      String str2 = this.fStrings[1];
      this.fEntityScanner.setEncoding(str2);
      if (this.fDTDHandler != null) {
        this.fDTDHandler.textDecl(str1, str2, null);
      }
    }
  }
  
  protected final boolean scanningInternalSubset()
  {
    return this.fExtEntityDepth == 0;
  }
  
  public void setInputSource(XMLInputSource paramXMLInputSource)
  {
    if (paramXMLInputSource == null)
    {
      if (this.fDTDHandler != null)
      {
        this.fDTDHandler.startDTD(null, null);
        this.fDTDHandler.endDTD(null);
      }
      if (this.nonValidatingMode)
      {
        this.nvGrammarInfo.startDTD(null, null);
        this.nvGrammarInfo.endDTD(null);
      }
      return;
    }
    this.fEntityManager.setEntityHandler(this);
    this.fEntityManager.startDTDEntity(paramXMLInputSource);
  }
  
  protected final void setScannerState(int paramInt)
  {
    this.fScannerState = paramInt;
  }
  
  public void startEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2)
  {
    super.startEntity(paramString1, paramXMLResourceIdentifier, paramString2);
    boolean bool = paramString1.equals("[dtd]");
    if (bool)
    {
      if ((this.fDTDHandler != null) && (!this.fStartDTDCalled)) {
        this.fDTDHandler.startDTD(this.fEntityScanner, null);
      }
      if (this.fDTDHandler != null) {
        this.fDTDHandler.startExternalSubset(paramXMLResourceIdentifier, null);
      }
      this.fEntityManager.startExternalSubset();
      this.fExtEntityDepth += 1;
    }
    for (;;)
    {
      if ((this.fDTDHandler != null) && (!bool) && (this.fReportEntity)) {
        this.fDTDHandler.startParameterEntity(paramString1, paramXMLResourceIdentifier, paramString2, null);
      }
      return;
      if (paramString1.charAt(0) == '%')
      {
        pushPEStack(this.fMarkUpDepth, this.fReportEntity);
        if (this.fEntityScanner.isExternal()) {
          this.fExtEntityDepth += 1;
        }
      }
    }
  }
  
  protected void startPE(String paramString, boolean paramBoolean)
  {
    int i = this.fPEDepth;
    String str = "%" + paramString;
    if ((this.fValidation) && (!this.fEntityStore.isDeclaredEntity(str))) {
      this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EntityNotDeclared", new Object[] { paramString }, (short)1);
    }
    this.fEntityManager.startEntity(this.fSymbolTable.addSymbol(str), paramBoolean);
    if ((i != this.fPEDepth) && (this.fEntityScanner.isExternal())) {
      scanTextDecl();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDTDScannerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */