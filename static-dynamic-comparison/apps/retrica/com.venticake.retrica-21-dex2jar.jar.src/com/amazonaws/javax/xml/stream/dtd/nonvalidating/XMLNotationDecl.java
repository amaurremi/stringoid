package com.amazonaws.javax.xml.stream.dtd.nonvalidating;

public class XMLNotationDecl
{
  public String baseSystemId;
  public String name;
  public String publicId;
  public String systemId;
  
  public void setValues(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.name = paramString1;
    this.publicId = paramString2;
    this.systemId = paramString3;
    this.baseSystemId = paramString4;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/dtd/nonvalidating/XMLNotationDecl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */