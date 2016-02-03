package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;

public class AttributeImpl
  extends DummyEvent
  implements Attribute
{
  private String fAttributeType = "CDATA";
  private boolean fIsSpecified;
  private String fNonNormalizedvalue;
  private QName fQName;
  private String fValue;
  
  public AttributeImpl()
  {
    init();
  }
  
  public AttributeImpl(QName paramQName, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    init();
    this.fQName = paramQName;
    this.fValue = paramString1;
    if ((paramString3 != null) && (!paramString3.equals(""))) {
      this.fAttributeType = paramString3;
    }
    this.fNonNormalizedvalue = paramString2;
    this.fIsSpecified = paramBoolean;
  }
  
  public AttributeImpl(String paramString1, String paramString2)
  {
    init();
    this.fQName = new QName(paramString1);
    this.fValue = paramString2;
  }
  
  public AttributeImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4, null, paramString5, false);
  }
  
  public AttributeImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(new QName(paramString2, paramString3, paramString1), paramString4, paramString5, paramString6, paramBoolean);
  }
  
  public QName getName()
  {
    return this.fQName;
  }
  
  public String getValue()
  {
    return this.fValue;
  }
  
  protected void init()
  {
    setEventType(10);
  }
  
  public void setAttributeType(String paramString)
  {
    this.fAttributeType = paramString;
  }
  
  public void setName(QName paramQName)
  {
    this.fQName = paramQName;
  }
  
  public void setSpecified(boolean paramBoolean)
  {
    this.fIsSpecified = paramBoolean;
  }
  
  public void setValue(String paramString)
  {
    this.fValue = paramString;
  }
  
  public String toString()
  {
    if ((this.fQName.getPrefix() != null) && (this.fQName.getPrefix().length() > 0)) {
      return this.fQName.getPrefix() + ":" + this.fQName.getLocalPart() + "='" + this.fValue + "'";
    }
    return this.fQName.getLocalPart() + "='" + this.fValue + "'";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/AttributeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */