package com.amazonaws.javax.xml.stream;

public final class XMLNSDocumentScannerImpl$NSContentDriver
  extends XMLDocumentScannerImpl.ContentDriver
{
  protected XMLNSDocumentScannerImpl$NSContentDriver(XMLNSDocumentScannerImpl paramXMLNSDocumentScannerImpl)
  {
    super(paramXMLNSDocumentScannerImpl);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLNSDocumentScannerImpl$NSContentDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */