package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDScanner;
import java.io.EOFException;

public final class XMLDocumentScannerImpl$PrologDriver
  implements XMLDocumentFragmentScannerImpl.Driver
{
  protected XMLDocumentScannerImpl$PrologDriver(XMLDocumentScannerImpl paramXMLDocumentScannerImpl) {}
  
  public int next()
  {
    for (;;)
    {
      try
      {
        switch (this.this$0.fScannerState)
        {
        case 43: 
          if ((this.this$0.fScannerState == 43) || (this.this$0.fScannerState == 21)) {
            continue;
          }
          switch (this.this$0.fScannerState)
          {
          case 26: 
            this.this$0.fEntityScanner.skipSpaces();
            if (this.this$0.fEntityScanner.skipChar(60))
            {
              this.this$0.setScannerState(21);
              continue;
            }
            if (!this.this$0.fEntityScanner.skipChar(38)) {
              break label182;
            }
          }
          break;
        }
      }
      catch (EOFException localEOFException)
      {
        this.this$0.reportFatalError("PrematureEOF", null);
        return -1;
      }
      this.this$0.setScannerState(28);
      continue;
      label182:
      this.this$0.setScannerState(22);
      continue;
      Object localObject = this.this$0;
      ((XMLDocumentScannerImpl)localObject).fMarkupDepth += 1;
      if (this.this$0.fEntityScanner.skipChar(63))
      {
        this.this$0.setScannerState(23);
      }
      else if (this.this$0.fEntityScanner.skipChar(33))
      {
        if (this.this$0.fEntityScanner.skipChar(45))
        {
          if (!this.this$0.fEntityScanner.skipChar(45)) {
            this.this$0.reportFatalError("InvalidCommentStart", null);
          }
          this.this$0.setScannerState(27);
        }
        else if (this.this$0.fEntityScanner.skipString(XMLDocumentScannerImpl.DOCTYPE))
        {
          this.this$0.setScannerState(24);
          localObject = this.this$0.fEntityScanner.getCurrentEntity();
          if ((localObject instanceof Entity.ScannedEntity)) {
            this.this$0.fStartPos = ((Entity.ScannedEntity)localObject).position;
          }
          this.this$0.fReadingDTD = true;
          if (this.this$0.fDTDDecl == null) {
            this.this$0.fDTDDecl = new XMLStringBuffer();
          }
          this.this$0.fDTDDecl.append("<!DOCTYPE");
        }
        else
        {
          this.this$0.reportFatalError("MarkupNotRecognizedInProlog", null);
        }
      }
      else if (XMLChar.isNameStart(this.this$0.fEntityScanner.peekChar()))
      {
        this.this$0.setScannerState(26);
      }
      else
      {
        this.this$0.reportFatalError("MarkupNotRecognizedInProlog", null);
        continue;
        this.this$0.setScannerState(38);
        this.this$0.setDriver(this.this$0.fContentDriver);
        return this.this$0.fContentDriver.next();
        this.this$0.scanComment();
        this.this$0.setScannerState(43);
        return 5;
        this.this$0.fContentBuffer.clear();
        this.this$0.scanPI(this.this$0.fContentBuffer);
        this.this$0.setScannerState(43);
        return 3;
        if (this.this$0.fSeenDoctypeDecl) {
          this.this$0.reportFatalError("AlreadySeenDoctype", null);
        }
        this.this$0.fSeenDoctypeDecl = true;
        if (this.this$0.scanDoctypeDecl(this.this$0.fDisallowDoctype))
        {
          this.this$0.setScannerState(45);
          this.this$0.fSeenInternalSubset = true;
          if (this.this$0.fDTDDriver == null) {
            this.this$0.fDTDDriver = new XMLDocumentScannerImpl.DTDDriver(this.this$0);
          }
          this.this$0.setDriver(this.this$0.fContentDriver);
          return this.this$0.fDTDDriver.next();
        }
        if (this.this$0.fSeenDoctypeDecl)
        {
          localObject = this.this$0.fEntityScanner.getCurrentEntity();
          if ((localObject instanceof Entity.ScannedEntity)) {
            this.this$0.fEndPos = ((Entity.ScannedEntity)localObject).position;
          }
          this.this$0.fReadingDTD = false;
        }
        if ((this.this$0.fDoctypeSystemId != null) && ((this.this$0.fValidation) || (this.this$0.fLoadExternalDTD)))
        {
          if (!this.this$0.fDisallowDoctype) {
            this.this$0.setScannerState(46);
          }
          for (;;)
          {
            this.this$0.setDriver(this.this$0.fContentDriver);
            if (this.this$0.fDTDDriver == null) {
              this.this$0.fDTDDriver = new XMLDocumentScannerImpl.DTDDriver(this.this$0);
            }
            return this.this$0.fDTDDriver.next();
            this.this$0.setScannerState(43);
          }
        }
        if (this.this$0.fDTDScanner != null) {
          this.this$0.fDTDScanner.setInputSource(null);
        }
        this.this$0.setScannerState(43);
        return 11;
        this.this$0.reportFatalError("ContentIllegalInProlog", null);
        this.this$0.fEntityScanner.scanChar();
        this.this$0.reportFatalError("ReferenceIllegalInProlog", null);
        break;
      }
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentScannerImpl$PrologDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */