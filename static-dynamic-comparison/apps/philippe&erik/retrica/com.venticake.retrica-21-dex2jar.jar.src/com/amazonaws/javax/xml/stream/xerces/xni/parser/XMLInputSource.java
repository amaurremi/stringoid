package com.amazonaws.javax.xml.stream.xerces.xni.parser;

import java.io.InputStream;
import java.io.Reader;

public class XMLInputSource
{
  protected String fBaseSystemId;
  protected InputStream fByteStream;
  protected Reader fCharStream;
  protected String fEncoding;
  protected String fPublicId;
  protected String fSystemId;
  
  public XMLInputSource(String paramString1, String paramString2, String paramString3)
  {
    this.fPublicId = paramString1;
    this.fSystemId = paramString2;
    this.fBaseSystemId = paramString3;
  }
  
  public XMLInputSource(String paramString1, String paramString2, String paramString3, InputStream paramInputStream, String paramString4)
  {
    this.fPublicId = paramString1;
    this.fSystemId = paramString2;
    this.fBaseSystemId = paramString3;
    this.fByteStream = paramInputStream;
    this.fEncoding = paramString4;
  }
  
  public XMLInputSource(String paramString1, String paramString2, String paramString3, Reader paramReader, String paramString4)
  {
    this.fPublicId = paramString1;
    this.fSystemId = paramString2;
    this.fBaseSystemId = paramString3;
    this.fCharStream = paramReader;
    this.fEncoding = paramString4;
  }
  
  public String getBaseSystemId()
  {
    return this.fBaseSystemId;
  }
  
  public InputStream getByteStream()
  {
    return this.fByteStream;
  }
  
  public Reader getCharacterStream()
  {
    return this.fCharStream;
  }
  
  public String getEncoding()
  {
    return this.fEncoding;
  }
  
  public String getPublicId()
  {
    return this.fPublicId;
  }
  
  public String getSystemId()
  {
    return this.fSystemId;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/parser/XMLInputSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */