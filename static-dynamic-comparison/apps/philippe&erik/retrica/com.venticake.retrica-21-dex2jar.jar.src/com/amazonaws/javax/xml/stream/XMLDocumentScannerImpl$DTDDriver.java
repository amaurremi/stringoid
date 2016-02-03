package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.dtd.DTDGrammarUtil;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDScanner;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.EOFException;

public final class XMLDocumentScannerImpl$DTDDriver
  implements XMLDocumentFragmentScannerImpl.Driver
{
  protected XMLDocumentScannerImpl$DTDDriver(XMLDocumentScannerImpl paramXMLDocumentScannerImpl) {}
  
  public boolean dispatch(boolean paramBoolean)
  {
    this.this$0.fEntityManager.setEntityHandler(null);
    for (;;)
    {
      try
      {
        XMLResourceIdentifierImpl localXMLResourceIdentifierImpl = new XMLResourceIdentifierImpl();
        if (this.this$0.fDTDScanner == null)
        {
          this.this$0.fDTDScanner = new XMLDTDScannerImpl();
          if (this.this$0.fPropertyManager != null) {
            ((XMLDTDScannerImpl)this.this$0.fDTDScanner).reset(this.this$0.fPropertyManager);
          }
        }
        switch (this.this$0.fScannerState)
        {
        case 44: 
          throw new XNIException("DTDDriver#dispatch: scanner state=" + this.this$0.fScannerState + " (" + this.this$0.getScannerStateName(this.this$0.fScannerState) + ')');
        }
      }
      catch (EOFException localEOFException)
      {
        localEOFException.printStackTrace();
        this.this$0.reportFatalError("PrematureEOF", null);
        return false;
        Object localObject2 = this.this$0.fDTDScanner;
        boolean bool2 = this.this$0.fStandalone;
        boolean bool1;
        if ((this.this$0.fHasExternalDTD) && (this.this$0.fLoadExternalDTD))
        {
          bool1 = true;
          bool1 = ((XMLDTDScanner)localObject2).scanDTDInternalSubset(true, bool2, bool1);
          localObject2 = this.this$0.fEntityScanner.getCurrentEntity();
          if ((localObject2 instanceof Entity.ScannedEntity)) {
            this.this$0.fEndPos = ((Entity.ScannedEntity)localObject2).position;
          }
          this.this$0.fReadingDTD = false;
          if (bool1) {
            break label677;
          }
          if (!this.this$0.fEntityScanner.skipChar(93)) {
            this.this$0.reportFatalError("EXPECTED_SQUARE_BRACKET_TO_CLOSE_INTERNAL_SUBSET", null);
          }
          this.this$0.fEntityScanner.skipSpaces();
          if (!this.this$0.fEntityScanner.skipChar(62)) {
            this.this$0.reportFatalError("DoctypedeclUnterminated", new Object[] { this.this$0.fDoctypeName });
          }
          localObject2 = this.this$0;
          ((XMLDocumentScannerImpl)localObject2).fMarkupDepth -= 1;
          if (this.this$0.fDisallowDoctype)
          {
            this.this$0.fEntityStore = this.this$0.fEntityManager.getEntityStore();
            this.this$0.fEntityStore.reset();
            this.this$0.setEndDTDScanState();
            return true;
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        if ((this.this$0.fDoctypeSystemId == null) || ((!this.this$0.fValidation) && (!this.this$0.fLoadExternalDTD))) {
          continue;
        }
        this.this$0.setScannerState(46);
        i = 0;
        if ((paramBoolean) || (i != 0)) {
          continue;
        }
        return true;
        localEOFException.setValues(this.this$0.fDoctypePublicId, this.this$0.fDoctypeSystemId, null, null);
        localObject2 = this.this$0.fEntityManager.resolveEntityAsPerStax(localEOFException).getXMLInputSource();
        this.this$0.fDTDScanner.setInputSource((XMLInputSource)localObject2);
        this.this$0.setScannerState(47);
        i = 1;
        continue;
        if (!this.this$0.fDTDScanner.scanDTDExternalSubset(true))
        {
          this.this$0.setEndDTDScanState();
          return true;
          this.this$0.setEndDTDScanState();
          return true;
        }
      }
      finally
      {
        this.this$0.fEntityManager.setEntityHandler(this.this$0);
      }
      label677:
      int i = 0;
    }
  }
  
  public int next()
  {
    dispatch(true);
    this.this$0.dtdGrammarUtil = new DTDGrammarUtil(((XMLDTDScannerImpl)this.this$0.fDTDScanner).getGrammar(), this.this$0.fSymbolTable, this.this$0.fNamespaceContext);
    return 11;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentScannerImpl$DTDDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */