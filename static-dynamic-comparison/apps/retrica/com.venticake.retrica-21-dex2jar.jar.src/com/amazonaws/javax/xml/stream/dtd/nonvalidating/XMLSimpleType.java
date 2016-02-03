package com.amazonaws.javax.xml.stream.dtd.nonvalidating;

public class XMLSimpleType
{
  public short defaultType;
  public String defaultValue;
  public String[] enumeration;
  public boolean list;
  public String name;
  public String nonNormalizedDefaultValue;
  public short type;
  
  public void clear()
  {
    this.type = -1;
    this.name = null;
    this.enumeration = null;
    this.list = false;
    this.defaultType = -1;
    this.defaultValue = null;
    this.nonNormalizedDefaultValue = null;
  }
  
  public void setValues(XMLSimpleType paramXMLSimpleType)
  {
    this.type = paramXMLSimpleType.type;
    this.name = paramXMLSimpleType.name;
    if ((paramXMLSimpleType.enumeration != null) && (paramXMLSimpleType.enumeration.length > 0))
    {
      this.enumeration = new String[paramXMLSimpleType.enumeration.length];
      System.arraycopy(paramXMLSimpleType.enumeration, 0, this.enumeration, 0, this.enumeration.length);
    }
    for (;;)
    {
      this.list = paramXMLSimpleType.list;
      this.defaultType = paramXMLSimpleType.defaultType;
      this.defaultValue = paramXMLSimpleType.defaultValue;
      this.nonNormalizedDefaultValue = paramXMLSimpleType.nonNormalizedDefaultValue;
      return;
      this.enumeration = null;
    }
  }
  
  public void setValues(short paramShort1, String paramString1, String[] paramArrayOfString, boolean paramBoolean, short paramShort2, String paramString2, String paramString3)
  {
    this.type = paramShort1;
    this.name = paramString1;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      this.enumeration = new String[paramArrayOfString.length];
      System.arraycopy(paramArrayOfString, 0, this.enumeration, 0, this.enumeration.length);
    }
    for (;;)
    {
      this.list = paramBoolean;
      this.defaultType = paramShort2;
      this.defaultValue = paramString2;
      this.nonNormalizedDefaultValue = paramString3;
      return;
      this.enumeration = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/dtd/nonvalidating/XMLSimpleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */