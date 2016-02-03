package com.amazonaws.javax.xml.stream;

class XMLReaderImpl$1
  implements Location
{
  int _columnNumber = this.this$0.fEntityScanner.getColumnNumber();
  int _lineNumber = this.this$0.fEntityScanner.getLineNumber();
  int _offset = this.this$0.fEntityScanner.getCharacterOffset();
  String _publicId = this.this$0.fEntityScanner.getPublicId();
  String _systemId = this.this$0.fEntityScanner.getExpandedSystemId();
  
  XMLReaderImpl$1(XMLReaderImpl paramXMLReaderImpl) {}
  
  public int getCharacterOffset()
  {
    return this._offset;
  }
  
  public int getColumnNumber()
  {
    return this._columnNumber;
  }
  
  public int getLineNumber()
  {
    return this._lineNumber;
  }
  
  public String getLocationURI()
  {
    return this._systemId;
  }
  
  public String getPublicId()
  {
    return this._publicId;
  }
  
  public String getSystemId()
  {
    return this._systemId;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Line number = " + getLineNumber());
    localStringBuffer.append("\n");
    localStringBuffer.append("Column number = " + getColumnNumber());
    localStringBuffer.append("\n");
    localStringBuffer.append("System Id = " + getSystemId());
    localStringBuffer.append("\n");
    localStringBuffer.append("Public Id = " + getPublicId());
    localStringBuffer.append("\n");
    localStringBuffer.append("Location Uri= " + getLocationURI());
    localStringBuffer.append("\n");
    localStringBuffer.append("CharacterOffset = " + getCharacterOffset());
    localStringBuffer.append("\n");
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLReaderImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */