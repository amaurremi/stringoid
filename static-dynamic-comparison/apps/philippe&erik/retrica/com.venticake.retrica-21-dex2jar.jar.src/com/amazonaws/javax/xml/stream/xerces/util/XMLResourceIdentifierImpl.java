package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;

public class XMLResourceIdentifierImpl
  implements XMLResourceIdentifier
{
  protected String fBaseSystemId;
  protected String fExpandedSystemId;
  protected String fLiteralSystemId;
  protected String fPublicId;
  
  public XMLResourceIdentifierImpl() {}
  
  public XMLResourceIdentifierImpl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    setValues(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void clear()
  {
    this.fPublicId = null;
    this.fLiteralSystemId = null;
    this.fBaseSystemId = null;
    this.fExpandedSystemId = null;
  }
  
  public String getBaseSystemId()
  {
    return this.fBaseSystemId;
  }
  
  public String getExpandedSystemId()
  {
    return this.fExpandedSystemId;
  }
  
  public String getLiteralSystemId()
  {
    return this.fLiteralSystemId;
  }
  
  public String getPublicId()
  {
    return this.fPublicId;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.fPublicId != null) {
      j = 0 + this.fPublicId.hashCode();
    }
    int i = j;
    if (this.fLiteralSystemId != null) {
      i = j + this.fLiteralSystemId.hashCode();
    }
    j = i;
    if (this.fBaseSystemId != null) {
      j = i + this.fBaseSystemId.hashCode();
    }
    i = j;
    if (this.fExpandedSystemId != null) {
      i = j + this.fExpandedSystemId.hashCode();
    }
    return i;
  }
  
  public void setValues(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.fPublicId = paramString1;
    this.fLiteralSystemId = paramString2;
    this.fBaseSystemId = paramString3;
    this.fExpandedSystemId = paramString4;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.fPublicId != null) {
      localStringBuffer.append(this.fPublicId);
    }
    localStringBuffer.append(':');
    if (this.fLiteralSystemId != null) {
      localStringBuffer.append(this.fLiteralSystemId);
    }
    localStringBuffer.append(':');
    if (this.fBaseSystemId != null) {
      localStringBuffer.append(this.fBaseSystemId);
    }
    localStringBuffer.append(':');
    if (this.fExpandedSystemId != null) {
      localStringBuffer.append(this.fExpandedSystemId);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/XMLResourceIdentifierImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */