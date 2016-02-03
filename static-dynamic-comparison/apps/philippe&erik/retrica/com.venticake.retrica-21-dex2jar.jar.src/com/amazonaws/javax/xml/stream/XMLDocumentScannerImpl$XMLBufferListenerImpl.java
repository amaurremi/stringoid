package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesIteratorImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;

public class XMLDocumentScannerImpl$XMLBufferListenerImpl
  implements XMLBufferListener
{
  protected XMLDocumentScannerImpl$XMLBufferListenerImpl(XMLDocumentScannerImpl paramXMLDocumentScannerImpl) {}
  
  public void refresh(int paramInt)
  {
    if (this.this$0.fReadingAttributes) {
      this.this$0.fAttributes.refresh();
    }
    if (this.this$0.fReadingDTD)
    {
      Entity.ScannedEntity localScannedEntity = this.this$0.fEntityScanner.getCurrentEntity();
      if ((localScannedEntity instanceof Entity.ScannedEntity)) {
        this.this$0.fEndPos = ((Entity.ScannedEntity)localScannedEntity).position;
      }
      this.this$0.fDTDDecl.append(((Entity.ScannedEntity)localScannedEntity).ch, this.this$0.fStartPos, this.this$0.fEndPos - this.this$0.fStartPos);
      this.this$0.fStartPos = paramInt;
    }
    if (this.this$0.fScannerState == 37)
    {
      this.this$0.fContentBuffer.append(this.this$0.fTempString);
      this.this$0.fTempString.length = 0;
      this.this$0.fUsebuffer = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentScannerImpl$XMLBufferListenerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */