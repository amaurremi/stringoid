package com.amazonaws.javax.xml.stream;

import java.io.EOFException;

public class XMLDocumentScannerImpl$ContentDriver
  extends XMLDocumentFragmentScannerImpl.FragmentContentDriver
{
  protected XMLDocumentScannerImpl$ContentDriver(XMLDocumentScannerImpl paramXMLDocumentScannerImpl)
  {
    super(paramXMLDocumentScannerImpl);
  }
  
  protected boolean elementDepthIsZeroHook()
  {
    this.this$0.setScannerState(44);
    this.this$0.setDriver(this.this$0.fTrailingMiscDriver);
    return true;
  }
  
  protected void endOfFileHook(EOFException paramEOFException)
  {
    this.this$0.reportFatalError("PrematureEOF", null);
  }
  
  protected boolean scanForDoctypeHook()
  {
    if (this.this$0.fEntityScanner.skipString(XMLDocumentScannerImpl.DOCTYPE))
    {
      this.this$0.setScannerState(24);
      return true;
    }
    return false;
  }
  
  protected boolean scanRootElementHook()
  {
    if (this.this$0.scanStartElement())
    {
      this.this$0.setScannerState(44);
      this.this$0.setDriver(this.this$0.fTrailingMiscDriver);
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentScannerImpl$ContentDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */