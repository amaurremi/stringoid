package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import java.io.EOFException;

public final class XMLDocumentScannerImpl$XMLDeclDriver
  implements XMLDocumentFragmentScannerImpl.Driver
{
  protected XMLDocumentScannerImpl$XMLDeclDriver(XMLDocumentScannerImpl paramXMLDocumentScannerImpl) {}
  
  public int next()
  {
    this.this$0.setScannerState(43);
    this.this$0.setDriver(this.this$0.fPrologDriver);
    try
    {
      if (!this.this$0.fEntityScanner.skipString(XMLDocumentFragmentScannerImpl.xmlDecl)) {
        break label252;
      }
      XMLDocumentScannerImpl localXMLDocumentScannerImpl = this.this$0;
      localXMLDocumentScannerImpl.fMarkupDepth += 1;
      if (!XMLChar.isName(this.this$0.fEntityScanner.peekChar())) {
        break label227;
      }
      this.this$0.fStringBuffer.clear();
      this.this$0.fStringBuffer.append("xml");
      while (XMLChar.isName(this.this$0.fEntityScanner.peekChar())) {
        this.this$0.fStringBuffer.append((char)this.this$0.fEntityScanner.scanChar());
      }
      str = this.this$0.fSymbolTable.addSymbol(this.this$0.fStringBuffer.ch, this.this$0.fStringBuffer.offset, this.this$0.fStringBuffer.length);
    }
    catch (EOFException localEOFException)
    {
      this.this$0.reportFatalError("PrematureEOF", null);
      return -1;
    }
    String str;
    this.this$0.fStringBuffer.clear();
    this.this$0.scanPIData(str, this.this$0.fStringBuffer);
    this.this$0.fEntityManager.fCurrentEntity.mayReadChunks = true;
    return 3;
    label227:
    this.this$0.scanXMLDeclOrTextDecl(false);
    this.this$0.fEntityManager.fCurrentEntity.mayReadChunks = true;
    return 7;
    label252:
    this.this$0.fEntityManager.fCurrentEntity.mayReadChunks = true;
    return 7;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentScannerImpl$XMLDeclDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */