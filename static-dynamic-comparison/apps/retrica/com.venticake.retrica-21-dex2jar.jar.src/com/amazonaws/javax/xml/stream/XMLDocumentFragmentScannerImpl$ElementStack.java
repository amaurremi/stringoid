package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.QName;

public class XMLDocumentFragmentScannerImpl$ElementStack
{
  protected int fCount;
  protected int fDepth;
  protected QName[] fElements = new QName[20];
  protected int[] fInt = new int[20];
  protected int fLastDepth;
  protected int fMark;
  protected int fPosition;
  
  public XMLDocumentFragmentScannerImpl$ElementStack(XMLDocumentFragmentScannerImpl paramXMLDocumentFragmentScannerImpl)
  {
    int i = 0;
    while (i < this.fElements.length)
    {
      this.fElements[i] = new QName();
      i += 1;
    }
  }
  
  public void clear()
  {
    this.fDepth = 0;
    this.fLastDepth = 0;
    this.fCount = 0;
    this.fMark = 1;
    this.fPosition = 1;
  }
  
  public QName getLastPoppedElement()
  {
    return this.fElements[this.fDepth];
  }
  
  public QName getNext()
  {
    if (this.fPosition == this.fCount) {
      this.fPosition = this.fMark;
    }
    return this.fElements[this.fPosition];
  }
  
  public boolean matchElement(QName paramQName)
  {
    boolean bool = true;
    if ((this.fLastDepth > this.fDepth) && (this.fDepth <= 3)) {
      if (paramQName.rawname == this.fElements[(this.fDepth - 1)].rawname)
      {
        this.this$0.fAdd = false;
        this.fMark = (this.fDepth - 1);
        this.fPosition = this.fMark;
        this.fCount -= 1;
        if (!bool) {
          break label158;
        }
        paramQName = this.fInt;
        int i = this.fDepth;
        int j = this.fPosition;
        this.fPosition = (j + 1);
        paramQName[i] = j;
      }
    }
    for (;;)
    {
      if (this.fCount != this.fElements.length) {
        break label176;
      }
      this.this$0.fSkip = false;
      this.this$0.fAdd = false;
      reposition();
      return false;
      this.this$0.fAdd = true;
      bool = false;
      break;
      label158:
      this.fInt[this.fDepth] = (this.fCount - 1);
    }
    label176:
    this.fLastDepth = this.fDepth;
    return bool;
  }
  
  public QName nextElement()
  {
    if (this.this$0.fSkip)
    {
      this.fDepth += 1;
      arrayOfQName = this.fElements;
      i = this.fCount;
      this.fCount = (i + 1);
      return arrayOfQName[i];
    }
    if (this.fDepth == this.fElements.length)
    {
      arrayOfQName = new QName[this.fElements.length * 2];
      System.arraycopy(this.fElements, 0, arrayOfQName, 0, this.fDepth);
      this.fElements = arrayOfQName;
      i = this.fDepth;
      while (i < this.fElements.length)
      {
        this.fElements[i] = new QName();
        i += 1;
      }
    }
    QName[] arrayOfQName = this.fElements;
    int i = this.fDepth;
    this.fDepth = (i + 1);
    return arrayOfQName[i];
  }
  
  public QName popElement()
  {
    if ((this.this$0.fSkip) || (this.this$0.fAdd))
    {
      arrayOfQName = this.fElements;
      int[] arrayOfInt = this.fInt;
      i = this.fDepth;
      this.fDepth = (i - 1);
      return arrayOfQName[arrayOfInt[i]];
    }
    QName[] arrayOfQName = this.fElements;
    int i = this.fDepth - 1;
    this.fDepth = i;
    return arrayOfQName[i];
  }
  
  public void push()
  {
    int[] arrayOfInt = this.fInt;
    int i = this.fDepth + 1;
    this.fDepth = i;
    int j = this.fPosition;
    this.fPosition = (j + 1);
    arrayOfInt[i] = j;
  }
  
  public void reposition()
  {
    int i = 2;
    while (i <= this.fDepth)
    {
      this.fElements[(i - 1)] = this.fElements[this.fInt[i]];
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLDocumentFragmentScannerImpl$ElementStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */