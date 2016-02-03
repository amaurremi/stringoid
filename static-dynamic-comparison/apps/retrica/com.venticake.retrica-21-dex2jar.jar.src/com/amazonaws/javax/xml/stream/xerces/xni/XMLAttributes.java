package com.amazonaws.javax.xml.stream.xerces.xni;

public abstract interface XMLAttributes
{
  public abstract int addAttribute(QName paramQName, String paramString1, String paramString2);
  
  public abstract int getLength();
  
  public abstract String getQName(int paramInt);
  
  public abstract String getValue(int paramInt);
  
  public abstract boolean isSpecified(int paramInt);
  
  public abstract void setSpecified(int paramInt, boolean paramBoolean);
  
  public abstract void setType(int paramInt, String paramString);
  
  public abstract void setValue(int paramInt, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/XMLAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */