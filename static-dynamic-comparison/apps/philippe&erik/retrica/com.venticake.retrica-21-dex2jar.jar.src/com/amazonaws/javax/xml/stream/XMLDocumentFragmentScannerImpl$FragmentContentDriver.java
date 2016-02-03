package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.dtd.DTDGrammarUtil;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import java.io.EOFException;

public class XMLDocumentFragmentScannerImpl$FragmentContentDriver
  implements XMLDocumentFragmentScannerImpl.Driver
{
  private boolean fContinueDispatching = true;
  private boolean fScanningForMarkup = true;
  
  protected XMLDocumentFragmentScannerImpl$FragmentContentDriver(XMLDocumentFragmentScannerImpl paramXMLDocumentFragmentScannerImpl) {}
  
  private void startOfMarkup()
  {
    XMLDocumentFragmentScannerImpl localXMLDocumentFragmentScannerImpl = this.this$0;
    localXMLDocumentFragmentScannerImpl.fMarkupDepth += 1;
    int i = this.this$0.fEntityScanner.peekChar();
    switch (i)
    {
    default: 
      if (XMLScanner.isValidNameStartChar(i)) {
        this.this$0.setScannerState(38);
      }
      break;
    case 63: 
    case 33: 
      do
      {
        return;
        this.this$0.setScannerState(23);
        this.this$0.fEntityScanner.skipChar(i);
        return;
        this.this$0.fEntityScanner.skipChar(i);
        if (this.this$0.fEntityScanner.skipChar(45))
        {
          if (!this.this$0.fEntityScanner.skipChar(45)) {
            this.this$0.reportFatalError("InvalidCommentStart", null);
          }
          this.this$0.setScannerState(27);
          return;
        }
        if (this.this$0.fEntityScanner.skipString(XMLDocumentFragmentScannerImpl.cdata))
        {
          this.this$0.setScannerState(35);
          return;
        }
      } while (scanForDoctypeHook());
      this.this$0.reportFatalError("MarkupNotRecognizedInContent", null);
      return;
    case 47: 
      this.this$0.setScannerState(39);
      this.this$0.fEntityScanner.skipChar(i);
      return;
    }
    this.this$0.reportFatalError("MarkupNotRecognizedInContent", null);
  }
  
  protected boolean elementDepthIsZeroHook()
  {
    return false;
  }
  
  protected void endOfFileHook(EOFException paramEOFException)
  {
    if (this.this$0.fMarkupDepth != 0) {
      this.this$0.reportFatalError("PrematureEOF", null);
    }
  }
  
  public int next()
  {
    boolean bool2 = true;
    int i;
    for (;;)
    {
      try
      {
        switch (this.this$0.fScannerState)
        {
        case 22: 
          if (!this.this$0.fIsCoalesce) {
            break label275;
          }
          this.this$0.fUsebuffer = true;
          if (!this.this$0.fLastSectionWasCharacterData) {
            break label201;
          }
          if ((this.this$0.fScannerState == 35) || (this.this$0.fScannerState == 28) || (this.this$0.fScannerState == 37)) {
            break label275;
          }
          this.this$0.fLastSectionWasCharacterData = false;
          return 4;
        }
      }
      catch (EOFException localEOFException)
      {
        endOfFileHook(localEOFException);
        return -1;
      }
      i = this.this$0.fEntityScanner.peekChar();
      if (i == 60)
      {
        this.this$0.fEntityScanner.scanChar();
        this.this$0.setScannerState(21);
        startOfMarkup();
      }
      else if (i == 38)
      {
        this.this$0.fEntityScanner.scanChar();
        this.this$0.setScannerState(28);
      }
      else
      {
        this.this$0.setScannerState(37);
      }
    }
    label201:
    if (((this.this$0.fLastSectionWasCData) || (this.this$0.fLastSectionWasEntityReference)) && (this.this$0.fScannerState != 35) && (this.this$0.fScannerState != 28) && (this.this$0.fScannerState != 37))
    {
      this.this$0.fLastSectionWasCData = false;
      this.this$0.fLastSectionWasEntityReference = false;
      return 4;
    }
    label275:
    label380:
    Object localObject;
    switch (this.this$0.fScannerState)
    {
    case 38: 
      throw new XNIException("Scanner State " + this.this$0.fScannerState + " not Recognized ");
      this.this$0.fEmptyElement = this.this$0.scanStartElement();
      if (this.this$0.fEmptyElement) {
        this.this$0.setScannerState(39);
      } else {
        this.this$0.setScannerState(22);
      }
      break;
    case 37: 
      localObject = this.this$0;
      bool1 = bool2;
      if (!this.this$0.fLastSectionWasEntityReference)
      {
        bool1 = bool2;
        if (!this.this$0.fLastSectionWasCData) {
          if (!this.this$0.fLastSectionWasCharacterData) {
            break label2322;
          }
        }
      }
      break;
    }
    label767:
    label821:
    label897:
    label1169:
    label1317:
    label1828:
    label2223:
    label2312:
    label2322:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((XMLDocumentFragmentScannerImpl)localObject).fUsebuffer = bool1;
      int j;
      if ((this.this$0.fIsCoalesce) && ((this.this$0.fLastSectionWasEntityReference) || (this.this$0.fLastSectionWasCData) || (this.this$0.fLastSectionWasCharacterData)))
      {
        this.this$0.fLastSectionWasEntityReference = false;
        this.this$0.fLastSectionWasCData = false;
        this.this$0.fLastSectionWasCharacterData = true;
        this.this$0.fUsebuffer = true;
        this.this$0.fTempString.length = 0;
        j = this.this$0.fEntityScanner.scanContent(this.this$0.fTempString);
        if (!this.this$0.fEntityScanner.skipChar(60)) {
          break label897;
        }
        if (!this.this$0.fEntityScanner.skipChar(47)) {
          break label767;
        }
        localObject = this.this$0;
        ((XMLDocumentFragmentScannerImpl)localObject).fMarkupDepth += 1;
        this.this$0.fLastSectionWasCharacterData = false;
        this.this$0.setScannerState(39);
      }
      do
      {
        for (;;)
        {
          if (this.this$0.fUsebuffer)
          {
            this.this$0.fContentBuffer.append(this.this$0.fTempString);
            this.this$0.fTempString.length = 0;
          }
          if ((this.this$0.dtdGrammarUtil == null) || (!this.this$0.dtdGrammarUtil.isIgnorableWhiteSpace(this.this$0.fContentBuffer))) {
            break label2312;
          }
          return 6;
          this.this$0.fContentBuffer.clear();
          break;
          if (!XMLChar.isNameStart(this.this$0.fEntityScanner.peekChar())) {
            break label821;
          }
          localObject = this.this$0;
          ((XMLDocumentFragmentScannerImpl)localObject).fMarkupDepth += 1;
          this.this$0.fLastSectionWasCharacterData = false;
          this.this$0.setScannerState(38);
        }
        this.this$0.setScannerState(21);
      } while (!this.this$0.fIsCoalesce);
      this.this$0.fUsebuffer = true;
      this.this$0.fLastSectionWasCharacterData = true;
      this.this$0.fContentBuffer.append(this.this$0.fTempString);
      this.this$0.fTempString.length = 0;
      return this.this$0.fDriver.next();
      this.this$0.fUsebuffer = true;
      this.this$0.fContentBuffer.append(this.this$0.fTempString);
      this.this$0.fTempString.length = 0;
      if (j == 13)
      {
        this.this$0.fEntityScanner.scanChar();
        this.this$0.fUsebuffer = true;
        this.this$0.fContentBuffer.append((char)j);
        i = -1;
        if (i != 60) {
          break label1169;
        }
        this.this$0.fEntityScanner.scanChar();
        this.this$0.setScannerState(21);
      }
      for (;;)
      {
        if (!this.this$0.fIsCoalesce) {
          break label1317;
        }
        this.this$0.fLastSectionWasCharacterData = true;
        return this.this$0.fDriver.next();
        i = j;
        if (j != 93) {
          break;
        }
        this.this$0.fUsebuffer = true;
        this.this$0.fContentBuffer.append((char)this.this$0.fEntityScanner.scanChar());
        this.this$0.fInScanContent = true;
        if (this.this$0.fEntityScanner.skipChar(93))
        {
          this.this$0.fContentBuffer.append(']');
          while (this.this$0.fEntityScanner.skipChar(93)) {
            this.this$0.fContentBuffer.append(']');
          }
          if (this.this$0.fEntityScanner.skipChar(62)) {
            this.this$0.reportFatalError("CDEndInContent", null);
          }
        }
        this.this$0.fInScanContent = false;
        i = -1;
        break;
        if (i == 38)
        {
          this.this$0.fEntityScanner.scanChar();
          this.this$0.setScannerState(28);
        }
        else if ((i != -1) && (XMLScanner.isInvalidLiteral(i)))
        {
          if (XMLChar.isHighSurrogate(i))
          {
            this.this$0.scanSurrogates(this.this$0.fContentBuffer);
            this.this$0.setScannerState(22);
          }
          else
          {
            this.this$0.reportFatalError("InvalidCharInContent", new Object[] { Integer.toString(i, 16) });
            this.this$0.fEntityScanner.scanChar();
          }
        }
        else
        {
          i = this.this$0.scanContent(this.this$0.fContentBuffer);
          if (this.this$0.fIsCoalesce) {
            break;
          }
          this.this$0.setScannerState(22);
        }
      }
      if ((this.this$0.dtdGrammarUtil != null) && (this.this$0.dtdGrammarUtil.isIgnorableWhiteSpace(this.this$0.fContentBuffer)))
      {
        return 6;
        if (this.this$0.fEmptyElement)
        {
          this.this$0.fEmptyElement = false;
          this.this$0.setScannerState(22);
          if ((this.this$0.fMarkupDepth != 0) || (!elementDepthIsZeroHook())) {
            break label2327;
          }
          return 2;
        }
        if ((this.this$0.scanEndElement() == 0) && (elementDepthIsZeroHook())) {
          return 2;
        }
        this.this$0.setScannerState(22);
        return 2;
        this.this$0.scanComment();
        this.this$0.setScannerState(22);
        return 5;
        this.this$0.fContentBuffer.clear();
        this.this$0.scanPI(this.this$0.fContentBuffer);
        this.this$0.setScannerState(22);
        return 3;
        if ((this.this$0.fIsCoalesce) && ((this.this$0.fLastSectionWasEntityReference) || (this.this$0.fLastSectionWasCData) || (this.this$0.fLastSectionWasCharacterData)))
        {
          this.this$0.fLastSectionWasCData = true;
          this.this$0.fLastSectionWasEntityReference = false;
          this.this$0.fLastSectionWasCharacterData = false;
        }
        for (;;)
        {
          this.this$0.fUsebuffer = true;
          this.this$0.scanCDATASection(this.this$0.fContentBuffer, true);
          this.this$0.setScannerState(22);
          if (!this.this$0.fIsCoalesce) {
            break;
          }
          this.this$0.fLastSectionWasCData = true;
          return this.this$0.fDriver.next();
          this.this$0.fContentBuffer.clear();
        }
        if (this.this$0.fReportCdataEvent)
        {
          return 12;
          localObject = this.this$0;
          ((XMLDocumentFragmentScannerImpl)localObject).fMarkupDepth += 1;
          this.this$0.foundBuiltInRefs = false;
          if ((this.this$0.fIsCoalesce) && ((this.this$0.fLastSectionWasEntityReference) || (this.this$0.fLastSectionWasCData) || (this.this$0.fLastSectionWasCharacterData)))
          {
            this.this$0.fLastSectionWasEntityReference = true;
            this.this$0.fLastSectionWasCData = false;
            this.this$0.fLastSectionWasCharacterData = false;
          }
          for (;;)
          {
            this.this$0.fUsebuffer = true;
            if (!this.this$0.fEntityScanner.skipChar(35)) {
              break;
            }
            this.this$0.scanCharReferenceValue(this.this$0.fContentBuffer, null);
            localObject = this.this$0;
            ((XMLDocumentFragmentScannerImpl)localObject).fMarkupDepth -= 1;
            if (this.this$0.fIsCoalesce) {
              break label1828;
            }
            this.this$0.setScannerState(22);
            return 4;
            this.this$0.fContentBuffer.clear();
          }
          this.this$0.scanEntityReference(this.this$0.fContentBuffer);
          if ((this.this$0.fScannerState == 41) && (!this.this$0.fIsCoalesce))
          {
            this.this$0.setScannerState(22);
            return 4;
          }
          if (this.this$0.fScannerState == 36)
          {
            this.this$0.fLastSectionWasEntityReference = true;
            return this.this$0.fDriver.next();
          }
          if (this.this$0.fScannerState == 28)
          {
            this.this$0.setScannerState(22);
            if (!this.this$0.fReplaceEntityReferences) {
              return 9;
            }
          }
          this.this$0.setScannerState(22);
          this.this$0.fLastSectionWasEntityReference = true;
          return this.this$0.fDriver.next();
          if (this.this$0.fEntityScanner.skipString("<?xml"))
          {
            localObject = this.this$0;
            ((XMLDocumentFragmentScannerImpl)localObject).fMarkupDepth += 1;
            if (!XMLScanner.isValidNameChar(this.this$0.fEntityScanner.peekChar())) {
              break label2223;
            }
            this.this$0.fStringBuffer.clear();
            this.this$0.fStringBuffer.append("xml");
            if (this.this$0.fNamespaces) {
              while (XMLScanner.isValidNCName(this.this$0.fEntityScanner.peekChar())) {
                this.this$0.fStringBuffer.append((char)this.this$0.fEntityScanner.scanChar());
              }
            }
            while (XMLScanner.isValidNameChar(this.this$0.fEntityScanner.peekChar())) {
              this.this$0.fStringBuffer.append((char)this.this$0.fEntityScanner.scanChar());
            }
            localObject = this.this$0.fSymbolTable.addSymbol(this.this$0.fStringBuffer.ch, this.this$0.fStringBuffer.offset, this.this$0.fStringBuffer.length);
            this.this$0.fStringBuffer.clear();
            this.this$0.scanPIData((String)localObject, this.this$0.fStringBuffer);
          }
          for (;;)
          {
            this.this$0.fEntityManager.fCurrentEntity.mayReadChunks = true;
            this.this$0.setScannerState(22);
            return this.this$0.fDriver.next();
            this.this$0.scanXMLDeclOrTextDecl(true);
          }
          if (scanRootElementHook()) {
            return -1;
          }
          this.this$0.setScannerState(22);
          return -1;
          this.this$0.fContentBuffer.clear();
          this.this$0.scanCharReferenceValue(this.this$0.fContentBuffer, null);
          localObject = this.this$0;
          ((XMLDocumentFragmentScannerImpl)localObject).fMarkupDepth -= 1;
          this.this$0.setScannerState(22);
          return 4;
          break;
        }
      }
      return 4;
      break label380;
      return 7;
      return 1;
    }
    label2327:
    return 2;
  }
  
  protected boolean scanForDoctypeHook()
  {
    return false;
  }
  
  protected boolean scanRootElementHook()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentFragmentScannerImpl$FragmentContentDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */