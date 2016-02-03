package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.QName;

public class XMLDocumentFragmentScannerImpl$ElementStack2
{
  protected int fCount;
  protected int fDepth;
  protected int fLastDepth;
  protected int fMark;
  protected int fPosition;
  protected QName[] fQName = new QName[20];
  
  public XMLDocumentFragmentScannerImpl$ElementStack2(XMLDocumentFragmentScannerImpl paramXMLDocumentFragmentScannerImpl)
  {
    int i = 0;
    while (i < this.fQName.length)
    {
      this.fQName[i] = new QName();
      i += 1;
    }
    this.fPosition = 1;
    this.fMark = 1;
  }
  
  public QName getNext()
  {
    if (this.fPosition == this.fCount) {
      this.fPosition = this.fMark;
    }
    QName[] arrayOfQName = this.fQName;
    int i = this.fPosition;
    this.fPosition = (i + 1);
    return arrayOfQName[i];
  }
  
  public boolean matchElement(QName paramQName)
  {
    boolean bool = true;
    if ((this.fLastDepth > this.fDepth) && (this.fDepth <= 2)) {
      if (paramQName.rawname == this.fQName[this.fDepth].rawname)
      {
        this.this$0.fAdd = false;
        this.fMark = (this.fDepth - 1);
        this.fPosition = (this.fMark + 1);
        this.fCount -= 1;
      }
    }
    for (;;)
    {
      int i = this.fDepth;
      this.fDepth = (i + 1);
      this.fLastDepth = i;
      return bool;
      this.this$0.fAdd = true;
      bool = false;
    }
  }
  
  public QName nextElement()
  {
    if (this.fCount == this.fQName.length)
    {
      this.this$0.fShouldSkip = false;
      this.this$0.fAdd = false;
      arrayOfQName = this.fQName;
      i = this.fCount - 1;
      this.fCount = i;
      return arrayOfQName[i];
    }
    QName[] arrayOfQName = this.fQName;
    int i = this.fCount;
    this.fCount = (i + 1);
    return arrayOfQName[i];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentFragmentScannerImpl$ElementStack2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */