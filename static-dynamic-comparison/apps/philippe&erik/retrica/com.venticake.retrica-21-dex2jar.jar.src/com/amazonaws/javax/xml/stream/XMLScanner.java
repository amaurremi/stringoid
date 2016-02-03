package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import java.util.ArrayList;

public abstract class XMLScanner
{
  protected static final String fAmpSymbol;
  protected static final String fAposSymbol = "apos".intern();
  protected static final String fEncodingSymbol;
  protected static final String fGtSymbol;
  protected static final String fLtSymbol;
  protected static final String fQuotSymbol;
  protected static final String fStandaloneSymbol;
  protected static final String fVersionSymbol = "version".intern();
  protected ArrayList attributeValueCache = new ArrayList();
  protected boolean fAttributeCacheInitDone = false;
  protected int fAttributeCacheUsedCount = 0;
  protected String fCharRefLiteral = null;
  protected int fEntityDepth;
  protected XMLEntityManager fEntityManager = null;
  protected XMLEntityReaderImpl fEntityScanner = null;
  protected XMLEntityStorage fEntityStore = null;
  protected XMLErrorReporter fErrorReporter;
  private boolean fNeedNonNormalizedValue = false;
  protected boolean fNotifyCharRefs = false;
  protected PropertyManager fPropertyManager = null;
  protected boolean fReportEntity;
  protected XMLResourceIdentifierImpl fResourceIdentifier = new XMLResourceIdentifierImpl();
  protected boolean fScanningAttribute;
  private XMLString fString = new XMLString();
  private XMLStringBuffer fStringBuffer = new XMLStringBuffer();
  private XMLStringBuffer fStringBuffer2 = new XMLStringBuffer();
  private XMLStringBuffer fStringBuffer3 = new XMLStringBuffer();
  protected int fStringBufferIndex = 0;
  protected SymbolTable fSymbolTable;
  protected boolean fValidation = false;
  int initialCacheCount = 6;
  protected ArrayList stringBufferCache = new ArrayList();
  
  static
  {
    fEncodingSymbol = "encoding".intern();
    fStandaloneSymbol = "standalone".intern();
    fAmpSymbol = "amp".intern();
    fLtSymbol = "lt".intern();
    fGtSymbol = "gt".intern();
    fQuotSymbol = "quot".intern();
  }
  
  private void init()
  {
    this.fEntityDepth = 0;
    this.fReportEntity = true;
    this.fResourceIdentifier.clear();
  }
  
  protected static boolean isInvalid(int paramInt)
  {
    return XMLChar.isInvalid(paramInt);
  }
  
  protected static boolean isInvalidLiteral(int paramInt)
  {
    return XMLChar.isInvalid(paramInt);
  }
  
  protected static boolean isValidNCName(int paramInt)
  {
    return XMLChar.isNCName(paramInt);
  }
  
  protected static boolean isValidNameChar(int paramInt)
  {
    return XMLChar.isName(paramInt);
  }
  
  protected static boolean isValidNameStartChar(int paramInt)
  {
    return XMLChar.isNameStart(paramInt);
  }
  
  public void endEntity(String paramString)
  {
    this.fEntityDepth -= 1;
  }
  
  XMLStringBuffer getStringBuffer()
  {
    if ((this.fStringBufferIndex < this.initialCacheCount) || (this.fStringBufferIndex < this.stringBufferCache.size()))
    {
      localObject = this.stringBufferCache;
      int i = this.fStringBufferIndex;
      this.fStringBufferIndex = (i + 1);
      return (XMLStringBuffer)((ArrayList)localObject).get(i);
    }
    Object localObject = new XMLStringBuffer();
    this.stringBufferCache.add(this.fStringBufferIndex, localObject);
    return (XMLStringBuffer)localObject;
  }
  
  protected void normalizeWhitespace(XMLString paramXMLString)
  {
    int i = 0;
    int[] arrayOfInt = this.fEntityScanner.whiteSpaceLookup;
    int j = this.fEntityScanner.whiteSpaceLen;
    int k = paramXMLString.offset;
    int m = paramXMLString.length;
    while (i < j)
    {
      int n = arrayOfInt[i];
      if (n < k + m) {
        paramXMLString.ch[n] = ' ';
      }
      i += 1;
    }
  }
  
  protected void reportFatalError(String paramString, Object[] paramArrayOfObject)
  {
    this.fErrorReporter.reportError(this.fEntityScanner, "http://www.w3.org/TR/1998/REC-xml-19980210", paramString, paramArrayOfObject, (short)2);
  }
  
  public void reset(PropertyManager paramPropertyManager)
  {
    init();
    this.fSymbolTable = ((SymbolTable)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/symbol-table"));
    this.fErrorReporter = ((XMLErrorReporter)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/error-reporter"));
    this.fEntityManager = ((XMLEntityManager)paramPropertyManager.getProperty("http://apache.org/xml/properties/internal/entity-manager"));
    this.fEntityStore = this.fEntityManager.getEntityStore();
    this.fEntityScanner = ((XMLEntityReaderImpl)this.fEntityManager.getEntityReader());
    this.fValidation = false;
    this.fNotifyCharRefs = false;
  }
  
  protected void scanAttributeValue(XMLString paramXMLString1, XMLString paramXMLString2, String paramString, XMLAttributes paramXMLAttributes, int paramInt, boolean paramBoolean)
  {
    int j = this.fEntityScanner.peekChar();
    if ((j != 39) && (j != 34)) {
      reportFatalError("OpenQuoteExpected", new Object[] { paramString });
    }
    this.fEntityScanner.scanChar();
    int k = this.fEntityDepth;
    paramInt = this.fEntityScanner.scanLiteral(j, paramXMLString1);
    if (this.fNeedNonNormalizedValue)
    {
      this.fStringBuffer2.clear();
      this.fStringBuffer2.append(paramXMLString1);
    }
    if (this.fEntityScanner.whiteSpaceLen > 0) {
      normalizeWhitespace(paramXMLString1);
    }
    if (paramInt != j)
    {
      this.fScanningAttribute = true;
      paramXMLAttributes = getStringBuffer();
      paramXMLAttributes.clear();
      paramXMLAttributes.append(paramXMLString1);
      if (paramInt != 38) {
        break label690;
      }
      this.fEntityScanner.skipChar(38);
      if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
        this.fStringBuffer2.append('&');
      }
      if (!this.fEntityScanner.skipChar(35)) {
        break label381;
      }
      if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
        this.fStringBuffer2.append('#');
      }
      if (!this.fNeedNonNormalizedValue) {
        break label369;
      }
      paramInt = scanCharReferenceValue(paramXMLAttributes, this.fStringBuffer2);
      label228:
      if (paramInt == -1) {}
    }
    for (;;)
    {
      int i = this.fEntityScanner.scanLiteral(j, paramXMLString1);
      if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
        this.fStringBuffer2.append(paramXMLString1);
      }
      if (this.fEntityScanner.whiteSpaceLen > 0) {
        normalizeWhitespace(paramXMLString1);
      }
      paramInt = i;
      if (i != j) {
        break;
      }
      paramInt = i;
      if (k != this.fEntityDepth) {
        break;
      }
      paramXMLAttributes.append(paramXMLString1);
      paramXMLString1.setValues(paramXMLAttributes);
      this.fScanningAttribute = false;
      if (this.fNeedNonNormalizedValue) {
        paramXMLString2.setValues(this.fStringBuffer2);
      }
      if (this.fEntityScanner.scanChar() != j) {
        reportFatalError("CloseQuoteExpected", new Object[] { paramString });
      }
      return;
      label369:
      paramInt = scanCharReferenceValue(paramXMLAttributes, null);
      break label228;
      label381:
      String str = this.fEntityScanner.scanName();
      if (str == null)
      {
        reportFatalError("NameRequiredInReference", null);
        label403:
        if (this.fEntityScanner.skipChar(59)) {
          break label477;
        }
        reportFatalError("SemicolonRequiredInReference", new Object[] { str });
      }
      for (;;)
      {
        if (str != fAmpSymbol) {
          break label505;
        }
        paramXMLAttributes.append('&');
        break;
        if ((k != this.fEntityDepth) || (!this.fNeedNonNormalizedValue)) {
          break label403;
        }
        this.fStringBuffer2.append(str);
        break label403;
        label477:
        if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
          this.fStringBuffer2.append(';');
        }
      }
      label505:
      if (str == fAposSymbol)
      {
        paramXMLAttributes.append('\'');
      }
      else if (str == fLtSymbol)
      {
        paramXMLAttributes.append('<');
      }
      else if (str == fGtSymbol)
      {
        paramXMLAttributes.append('>');
      }
      else if (str == fQuotSymbol)
      {
        paramXMLAttributes.append('"');
      }
      else if (this.fEntityStore.isExternalEntity(str))
      {
        reportFatalError("ReferenceToExternalEntity", new Object[] { str });
      }
      else
      {
        if (!this.fEntityStore.isDeclaredEntity(str))
        {
          if (!paramBoolean) {
            break label671;
          }
          if (this.fValidation) {
            this.fErrorReporter.reportError(this.fEntityScanner, "http://www.w3.org/TR/1998/REC-xml-19980210", "EntityNotDeclared", new Object[] { str }, (short)1);
          }
        }
        for (;;)
        {
          this.fEntityManager.startEntity(str, true);
          break;
          label671:
          reportFatalError("EntityNotDeclared", new Object[] { str });
        }
        label690:
        if (paramInt == 60)
        {
          reportFatalError("LessthanInAttValue", new Object[] { null, paramString });
          this.fEntityScanner.scanChar();
          if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
            this.fStringBuffer2.append((char)paramInt);
          }
        }
        else if ((paramInt == 37) || (paramInt == 93))
        {
          this.fEntityScanner.scanChar();
          paramXMLAttributes.append((char)paramInt);
          if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
            this.fStringBuffer2.append((char)paramInt);
          }
        }
        else if ((paramInt == 10) || (paramInt == 13))
        {
          this.fEntityScanner.scanChar();
          paramXMLAttributes.append(' ');
          if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
            this.fStringBuffer2.append('\n');
          }
        }
        else if ((paramInt != -1) && (XMLChar.isHighSurrogate(paramInt)))
        {
          if (scanSurrogates(this.fStringBuffer3))
          {
            paramXMLAttributes.append(this.fStringBuffer3);
            if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
              this.fStringBuffer2.append(this.fStringBuffer3);
            }
          }
        }
        else if ((paramInt != -1) && (isInvalidLiteral(paramInt)))
        {
          reportFatalError("InvalidCharInAttValue", new Object[] { Integer.toString(paramInt, 16) });
          this.fEntityScanner.scanChar();
          if ((k == this.fEntityDepth) && (this.fNeedNonNormalizedValue)) {
            this.fStringBuffer2.append((char)paramInt);
          }
        }
      }
    }
  }
  
  protected int scanCharReferenceValue(XMLStringBuffer paramXMLStringBuffer1, XMLStringBuffer paramXMLStringBuffer2)
  {
    label168:
    label205:
    label207:
    int m;
    if (this.fEntityScanner.skipChar(120))
    {
      if (paramXMLStringBuffer2 != null) {
        paramXMLStringBuffer2.append('x');
      }
      this.fStringBuffer3.clear();
      j = this.fEntityScanner.peekChar();
      if (((j >= 48) && (j <= 57)) || ((j >= 97) && (j <= 102)) || ((j >= 65) && (j <= 70)))
      {
        i = 1;
        if (i == 0) {
          break label466;
        }
        if (paramXMLStringBuffer2 != null) {
          paramXMLStringBuffer2.append((char)j);
        }
        this.fEntityScanner.scanChar();
        this.fStringBuffer3.append((char)j);
        do
        {
          j = this.fEntityScanner.peekChar();
          if (((j < 48) || (j > 57)) && ((j < 97) || (j > 102)) && ((j < 65) || (j > 70))) {
            break;
          }
          i = 1;
          if (i != 0)
          {
            if (paramXMLStringBuffer2 != null) {
              paramXMLStringBuffer2.append((char)j);
            }
            this.fEntityScanner.scanChar();
            this.fStringBuffer3.append((char)j);
          }
        } while (i != 0);
        i = 1;
        if (!this.fEntityScanner.skipChar(59)) {
          reportFatalError("SemicolonRequiredInCharRef", null);
        }
        if (paramXMLStringBuffer2 != null) {
          paramXMLStringBuffer2.append(';');
        }
        m = -1;
        j = m;
      }
    }
    for (;;)
    {
      try
      {
        paramXMLStringBuffer2 = this.fStringBuffer3.toString();
        if (i == 0) {
          continue;
        }
        k = 16;
        j = m;
        k = Integer.parseInt(paramXMLStringBuffer2, k);
        j = k;
        if (isInvalid(k))
        {
          j = k;
          paramXMLStringBuffer2 = new StringBuffer(this.fStringBuffer3.length + 1);
          if (i != 0)
          {
            j = k;
            paramXMLStringBuffer2.append('x');
          }
          j = k;
          paramXMLStringBuffer2.append(this.fStringBuffer3.ch, this.fStringBuffer3.offset, this.fStringBuffer3.length);
          j = k;
          reportFatalError("InvalidCharRef", new Object[] { paramXMLStringBuffer2.toString() });
        }
      }
      catch (NumberFormatException paramXMLStringBuffer2)
      {
        label466:
        paramXMLStringBuffer2 = new StringBuffer(this.fStringBuffer3.length + 1);
        if (i == 0) {
          continue;
        }
        paramXMLStringBuffer2.append('x');
        paramXMLStringBuffer2.append(this.fStringBuffer3.ch, this.fStringBuffer3.offset, this.fStringBuffer3.length);
        reportFatalError("InvalidCharRef", new Object[] { paramXMLStringBuffer2.toString() });
        int k = j;
        continue;
        paramXMLStringBuffer1.append(XMLChar.highSurrogate(k));
        paramXMLStringBuffer1.append(XMLChar.lowSurrogate(k));
        continue;
        paramXMLStringBuffer1 = "";
        continue;
      }
      if (XMLChar.isSupplemental(k)) {
        continue;
      }
      paramXMLStringBuffer1.append((char)k);
      if ((this.fNotifyCharRefs) && (k != -1))
      {
        paramXMLStringBuffer2 = new StringBuffer().append("#");
        if (i == 0) {
          continue;
        }
        paramXMLStringBuffer1 = "x";
        paramXMLStringBuffer1 = paramXMLStringBuffer1 + this.fStringBuffer3.toString();
        if (!this.fScanningAttribute) {
          this.fCharRefLiteral = paramXMLStringBuffer1;
        }
      }
      return k;
      i = 0;
      break;
      i = 0;
      break label168;
      reportFatalError("HexdigitRequiredInCharRef", null);
      break label205;
      this.fStringBuffer3.clear();
      j = this.fEntityScanner.peekChar();
      if ((j >= 48) && (j <= 57))
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        if (paramXMLStringBuffer2 != null) {
          paramXMLStringBuffer2.append((char)j);
        }
        this.fEntityScanner.scanChar();
        this.fStringBuffer3.append((char)j);
        j = this.fEntityScanner.peekChar();
        if ((j < 48) || (j > 57)) {
          continue;
        }
        i = 1;
        if (i != 0)
        {
          if (paramXMLStringBuffer2 != null) {
            paramXMLStringBuffer2.append((char)j);
          }
          this.fEntityScanner.scanChar();
          this.fStringBuffer3.append((char)j);
        }
        if (i != 0) {
          continue;
        }
        i = 0;
        break label207;
      }
      i = 0;
      continue;
      i = 0;
      continue;
      reportFatalError("DigitRequiredInCharRef", null);
      i = 0;
      break label207;
      k = 10;
    }
  }
  
  protected void scanComment(XMLStringBuffer paramXMLStringBuffer)
  {
    paramXMLStringBuffer.clear();
    while (this.fEntityScanner.scanData("--", paramXMLStringBuffer))
    {
      int i = this.fEntityScanner.peekChar();
      if (i != -1)
      {
        if (XMLChar.isHighSurrogate(i)) {
          scanSurrogates(paramXMLStringBuffer);
        }
        if (isInvalidLiteral(i))
        {
          reportFatalError("InvalidCharInComment", new Object[] { Integer.toHexString(i) });
          this.fEntityScanner.scanChar();
        }
      }
    }
    if (!this.fEntityScanner.skipChar(62)) {
      reportFatalError("DashDashInComment", null);
    }
  }
  
  protected void scanExternalID(String[] paramArrayOfString, boolean paramBoolean)
  {
    String str;
    if (this.fEntityScanner.skipString("PUBLIC"))
    {
      if (!this.fEntityScanner.skipSpaces()) {
        reportFatalError("SpaceRequiredAfterPUBLIC", null);
      }
      scanPubidLiteral(this.fString);
      str = this.fString.toString();
      if ((!this.fEntityScanner.skipSpaces()) && (!paramBoolean)) {
        reportFatalError("SpaceRequiredBetweenPublicAndSystem", null);
      }
    }
    for (;;)
    {
      Object localObject2;
      if ((str != null) || (this.fEntityScanner.skipString("SYSTEM")))
      {
        if ((str == null) && (!this.fEntityScanner.skipSpaces())) {
          reportFatalError("SpaceRequiredAfterSYSTEM", null);
        }
        int i = this.fEntityScanner.peekChar();
        if ((i != 39) && (i != 34))
        {
          if ((str != null) && (paramBoolean))
          {
            paramArrayOfString[0] = null;
            paramArrayOfString[1] = str;
            return;
          }
          reportFatalError("QuoteRequiredInSystemID", null);
        }
        this.fEntityScanner.scanChar();
        localObject2 = this.fString;
        localObject1 = localObject2;
        if (this.fEntityScanner.scanLiteral(i, (XMLString)localObject2) != i)
        {
          this.fStringBuffer.clear();
          do
          {
            this.fStringBuffer.append((XMLString)localObject2);
            int j = this.fEntityScanner.peekChar();
            if ((XMLChar.isMarkup(j)) || (j == 93)) {
              this.fStringBuffer.append((char)this.fEntityScanner.scanChar());
            }
          } while (this.fEntityScanner.scanLiteral(i, (XMLString)localObject2) != i);
          this.fStringBuffer.append((XMLString)localObject2);
          localObject1 = this.fStringBuffer;
        }
        localObject2 = ((XMLString)localObject1).toString();
        localObject1 = localObject2;
        if (!this.fEntityScanner.skipChar(i)) {
          reportFatalError("SystemIDUnterminated", null);
        }
      }
      for (Object localObject1 = localObject2;; localObject1 = null)
      {
        paramArrayOfString[0] = localObject1;
        paramArrayOfString[1] = str;
        return;
      }
      str = null;
    }
  }
  
  protected void scanPI(XMLStringBuffer paramXMLStringBuffer)
  {
    this.fReportEntity = false;
    String str = this.fEntityScanner.scanName();
    if (str == null) {
      reportFatalError("PITargetRequired", null);
    }
    scanPIData(str, paramXMLStringBuffer);
    this.fReportEntity = true;
  }
  
  protected void scanPIData(String paramString, XMLStringBuffer paramXMLStringBuffer)
  {
    int i;
    if (paramString.length() == 3)
    {
      i = Character.toLowerCase(paramString.charAt(0));
      int j = Character.toLowerCase(paramString.charAt(1));
      int k = Character.toLowerCase(paramString.charAt(2));
      if ((i == 120) && (j == 109) && (k == 108)) {
        reportFatalError("ReservedPITarget", null);
      }
    }
    if (!this.fEntityScanner.skipSpaces()) {
      if (!this.fEntityScanner.skipString("?>")) {}
    }
    while (!this.fEntityScanner.scanData("?>", paramXMLStringBuffer))
    {
      return;
      reportFatalError("SpaceRequiredInPI", null);
    }
    for (;;)
    {
      i = this.fEntityScanner.peekChar();
      if (i != -1)
      {
        if (!XMLChar.isHighSurrogate(i)) {
          break label152;
        }
        scanSurrogates(paramXMLStringBuffer);
      }
      while (!this.fEntityScanner.scanData("?>", paramXMLStringBuffer))
      {
        return;
        label152:
        if (isInvalidLiteral(i))
        {
          reportFatalError("InvalidCharInPI", new Object[] { Integer.toHexString(i) });
          this.fEntityScanner.scanChar();
        }
      }
    }
  }
  
  public String scanPseudoAttribute(boolean paramBoolean, XMLString paramXMLString)
  {
    String str2 = this.fEntityScanner.scanName();
    if (str2 == null) {
      reportFatalError("PseudoAttrNameExpected", null);
    }
    this.fEntityScanner.skipSpaces();
    String str1;
    label106:
    int i;
    if (!this.fEntityScanner.skipChar(61))
    {
      if (paramBoolean)
      {
        str1 = "EqRequiredInTextDecl";
        reportFatalError(str1, new Object[] { str2 });
      }
    }
    else
    {
      this.fEntityScanner.skipSpaces();
      int k = this.fEntityScanner.peekChar();
      if ((k != 39) && (k != 34))
      {
        if (!paramBoolean) {
          break label288;
        }
        str1 = "QuoteRequiredInTextDecl";
        reportFatalError(str1, new Object[] { str2 });
      }
      this.fEntityScanner.scanChar();
      i = this.fEntityScanner.scanLiteral(k, paramXMLString);
      if (i != k)
      {
        this.fStringBuffer2.clear();
        label205:
        int j;
        do
        {
          this.fStringBuffer2.append(paramXMLString);
          if (i != -1)
          {
            if ((i != 38) && (i != 37) && (i != 60) && (i != 93)) {
              break;
            }
            this.fStringBuffer2.append((char)this.fEntityScanner.scanChar());
          }
          j = this.fEntityScanner.scanLiteral(k, paramXMLString);
          i = j;
        } while (j != k);
        this.fStringBuffer2.append(paramXMLString);
        paramXMLString.setValues(this.fStringBuffer2);
      }
      if (!this.fEntityScanner.skipChar(k)) {
        if (!paramBoolean) {
          break label369;
        }
      }
    }
    label288:
    label369:
    for (paramXMLString = "CloseQuoteMissingInTextDecl";; paramXMLString = "CloseQuoteMissingInXMLDecl")
    {
      reportFatalError(paramXMLString, new Object[] { str2 });
      return str2;
      str1 = "EqRequiredInXMLDecl";
      break;
      str1 = "QuoteRequiredInXMLDecl";
      break label106;
      if (XMLChar.isHighSurrogate(i))
      {
        scanSurrogates(this.fStringBuffer2);
        break label205;
      }
      if (!isInvalidLiteral(i)) {
        break label205;
      }
      if (paramBoolean) {}
      for (str1 = "InvalidCharInTextDecl";; str1 = "InvalidCharInXMLDecl")
      {
        reportFatalError(str1, new Object[] { Integer.toString(i, 16) });
        this.fEntityScanner.scanChar();
        break;
      }
    }
  }
  
  protected boolean scanPubidLiteral(XMLString paramXMLString)
  {
    int j = this.fEntityScanner.scanChar();
    if ((j != 39) && (j != 34))
    {
      reportFatalError("QuoteRequiredInPublicID", null);
      return false;
    }
    this.fStringBuffer.clear();
    boolean bool = true;
    int i = 1;
    for (;;)
    {
      int k = this.fEntityScanner.scanChar();
      if ((k == 32) || (k == 10) || (k == 13))
      {
        if (i == 0)
        {
          this.fStringBuffer.append(' ');
          i = 1;
        }
      }
      else
      {
        if (k == j)
        {
          if (i != 0)
          {
            XMLStringBuffer localXMLStringBuffer = this.fStringBuffer;
            localXMLStringBuffer.length -= 1;
          }
          paramXMLString.setValues(this.fStringBuffer);
          return bool;
        }
        if (XMLChar.isPubid(k))
        {
          this.fStringBuffer.append((char)k);
          i = 0;
        }
        else
        {
          if (k == -1)
          {
            reportFatalError("PublicIDUnterminated", null);
            return false;
          }
          reportFatalError("InvalidCharInPublicID", new Object[] { Integer.toHexString(k) });
          bool = false;
        }
      }
    }
  }
  
  protected boolean scanSurrogates(XMLStringBuffer paramXMLStringBuffer)
  {
    int i = this.fEntityScanner.scanChar();
    int j = this.fEntityScanner.peekChar();
    if (!XMLChar.isLowSurrogate(j))
    {
      reportFatalError("InvalidCharInContent", new Object[] { Integer.toString(i, 16) });
      return false;
    }
    this.fEntityScanner.scanChar();
    int k = XMLChar.supplemental((char)i, (char)j);
    if (isInvalid(k))
    {
      reportFatalError("InvalidCharInContent", new Object[] { Integer.toString(k, 16) });
      return false;
    }
    paramXMLStringBuffer.append((char)i);
    paramXMLStringBuffer.append((char)j);
    return true;
  }
  
  protected void scanXMLDeclOrTextDecl(boolean paramBoolean, String[] paramArrayOfString)
  {
    boolean bool = this.fEntityScanner.skipSpaces();
    int j = 0;
    Object localObject = null;
    String str1 = null;
    String str2 = null;
    int i = 0;
    String str3;
    if (this.fEntityScanner.peekChar() != 63)
    {
      str3 = scanPseudoAttribute(paramBoolean, this.fString);
      switch (i)
      {
      default: 
        reportFatalError("NoMorePseudoAttributes", null);
      }
    }
    for (;;)
    {
      bool = this.fEntityScanner.skipSpaces();
      j = 1;
      break;
      if (str3.equals(fVersionSymbol))
      {
        if (!bool) {
          if (!paramBoolean) {
            break label166;
          }
        }
        label166:
        for (str2 = "SpaceRequiredBeforeVersionInTextDecl";; str2 = "SpaceRequiredBeforeVersionInXMLDecl")
        {
          reportFatalError(str2, null);
          str2 = this.fString.toString();
          if (versionSupported(str2)) {
            break label645;
          }
          reportFatalError("VersionNotSupported", new Object[] { str2 });
          i = 1;
          break;
        }
      }
      if (str3.equals(fEncodingSymbol))
      {
        if (!paramBoolean) {
          reportFatalError("VersionInfoRequired", null);
        }
        if (!bool) {
          if (!paramBoolean) {
            break label236;
          }
        }
        label236:
        for (str1 = "SpaceRequiredBeforeEncodingInTextDecl";; str1 = "SpaceRequiredBeforeEncodingInXMLDecl")
        {
          reportFatalError(str1, null);
          str1 = this.fString.toString();
          if (!paramBoolean) {
            break label244;
          }
          i = 3;
          break;
        }
        label244:
        i = 2;
      }
      else if (paramBoolean)
      {
        reportFatalError("EncodingDeclRequired", null);
      }
      else
      {
        reportFatalError("VersionInfoRequired", null);
        continue;
        if (str3.equals(fEncodingSymbol))
        {
          if (!bool) {
            if (!paramBoolean) {
              break label325;
            }
          }
          label325:
          for (str1 = "SpaceRequiredBeforeEncodingInTextDecl";; str1 = "SpaceRequiredBeforeEncodingInXMLDecl")
          {
            reportFatalError(str1, null);
            str1 = this.fString.toString();
            if (!paramBoolean) {
              break label333;
            }
            i = 3;
            break;
          }
          label333:
          i = 2;
        }
        else
        {
          if ((!paramBoolean) && (str3.equals(fStandaloneSymbol)))
          {
            if (!bool) {
              reportFatalError("SpaceRequiredBeforeStandalone", null);
            }
            str3 = this.fString.toString();
            localObject = str3;
            if (!str3.equals("yes"))
            {
              localObject = str3;
              if (!str3.equals("no"))
              {
                reportFatalError("SDDeclInvalid", null);
                localObject = str3;
                i = 3;
              }
            }
          }
          else
          {
            reportFatalError("EncodingDeclRequired", null);
            continue;
            if (str3.equals(fStandaloneSymbol))
            {
              if (!bool) {
                reportFatalError("SpaceRequiredBeforeStandalone", null);
              }
              str3 = this.fString.toString();
              localObject = str3;
              if (!str3.equals("yes"))
              {
                localObject = str3;
                if (!str3.equals("no"))
                {
                  reportFatalError("SDDeclInvalid", null);
                  localObject = str3;
                  i = 3;
                }
              }
            }
            else
            {
              reportFatalError("EncodingDeclRequired", null);
              continue;
              if ((paramBoolean) && (i != 3)) {
                reportFatalError("MorePseudoAttributes", null);
              }
              if (paramBoolean) {
                if ((j == 0) && (str1 == null)) {
                  reportFatalError("EncodingDeclRequired", null);
                }
              }
              for (;;)
              {
                if (!this.fEntityScanner.skipChar(63)) {
                  reportFatalError("XMLDeclUnterminated", null);
                }
                if (!this.fEntityScanner.skipChar(62)) {
                  reportFatalError("XMLDeclUnterminated", null);
                }
                paramArrayOfString[0] = str2;
                paramArrayOfString[1] = str1;
                paramArrayOfString[2] = localObject;
                return;
                if ((j == 0) && (str2 == null)) {
                  reportFatalError("VersionInfoRequired", null);
                }
              }
            }
          }
          i = 3;
          continue;
          label645:
          i = 1;
        }
      }
    }
  }
  
  protected void setPropertyManager(PropertyManager paramPropertyManager)
  {
    this.fPropertyManager = paramPropertyManager;
  }
  
  public void startEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2)
  {
    this.fEntityDepth += 1;
  }
  
  protected boolean versionSupported(String paramString)
  {
    return paramString.equals("1.0");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */