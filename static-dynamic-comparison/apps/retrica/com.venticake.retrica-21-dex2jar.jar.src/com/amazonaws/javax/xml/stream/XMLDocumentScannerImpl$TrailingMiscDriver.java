package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import java.io.EOFException;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public final class XMLDocumentScannerImpl$TrailingMiscDriver
  implements XMLDocumentFragmentScannerImpl.Driver
{
  protected XMLDocumentScannerImpl$TrailingMiscDriver(XMLDocumentScannerImpl paramXMLDocumentScannerImpl) {}
  
  public int next()
  {
    do
    {
      try
      {
        if (this.this$0.fScannerState == 34) {
          return 8;
        }
        switch (this.this$0.fScannerState)
        {
        }
      }
      catch (EOFException localEOFException)
      {
        while (this.this$0.fMarkupDepth != 0)
        {
          this.this$0.reportFatalError("PrematureEOF", null);
          return -1;
          this.this$0.fEntityScanner.skipSpaces();
          if (this.this$0.fScannerState == 34) {
            break label613;
          }
          if (this.this$0.fEntityScanner.skipChar(60))
          {
            this.this$0.setScannerState(21);
          }
          else
          {
            this.this$0.setScannerState(22);
            continue;
            localXMLDocumentScannerImpl = this.this$0;
            localXMLDocumentScannerImpl.fMarkupDepth += 1;
            if (this.this$0.fEntityScanner.skipChar(63))
            {
              this.this$0.setScannerState(23);
            }
            else if (this.this$0.fEntityScanner.skipChar(33))
            {
              this.this$0.setScannerState(27);
            }
            else if (this.this$0.fEntityScanner.skipChar(47))
            {
              this.this$0.reportFatalError("MarkupNotRecognizedInMisc", null);
            }
            else if (XMLChar.isNameStart(this.this$0.fEntityScanner.peekChar()))
            {
              this.this$0.reportFatalError("MarkupNotRecognizedInMisc", null);
              this.this$0.scanStartElement();
              this.this$0.setScannerState(22);
            }
            else
            {
              this.this$0.reportFatalError("MarkupNotRecognizedInMisc", null);
              continue;
              this.this$0.fContentBuffer.clear();
              this.this$0.scanPI(this.this$0.fContentBuffer);
              this.this$0.setScannerState(44);
              return 3;
              if (!this.this$0.fEntityScanner.skipString(XMLDocumentScannerImpl.COMMENTSTRING)) {
                this.this$0.reportFatalError("InvalidCommentStart", null);
              }
              this.this$0.scanComment();
              this.this$0.setScannerState(44);
              return 5;
              if (this.this$0.fEntityScanner.peekChar() == -1)
              {
                this.this$0.setScannerState(34);
                return 8;
              }
              this.this$0.reportFatalError("ContentIllegalInTrailingMisc", null);
              this.this$0.fEntityScanner.scanChar();
              this.this$0.setScannerState(44);
              return 4;
              this.this$0.reportFatalError("ReferenceIllegalInTrailingMisc", null);
              this.this$0.setScannerState(44);
              return 9;
              this.this$0.setScannerState(48);
              return 8;
              throw new NoSuchElementException("No more events to be parsed");
            }
          }
        }
        System.out.println("EOFException thrown");
        this.this$0.setScannerState(34);
        return 8;
      }
    } while ((this.this$0.fScannerState == 21) || (this.this$0.fScannerState == 44));
    switch (this.this$0.fScannerState)
    {
    }
    for (;;)
    {
      throw new XNIException("Scanner State " + this.this$0.fScannerState + " not Recognized ");
      XMLDocumentScannerImpl localXMLDocumentScannerImpl;
      label613:
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentScannerImpl$TrailingMiscDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */