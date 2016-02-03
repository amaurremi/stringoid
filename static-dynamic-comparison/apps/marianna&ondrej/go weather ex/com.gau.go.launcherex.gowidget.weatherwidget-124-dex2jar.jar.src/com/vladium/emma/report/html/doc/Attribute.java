package com.vladium.emma.report.html.doc;

public abstract class Attribute
  implements IContent
{
  public static final Attribute ALIGN = new AttributeImpl("ALIGN");
  public static final Attribute BORDER;
  public static final Attribute CELLPADDING;
  public static final Attribute CELLSPACING;
  public static final Attribute CLASS;
  public static final Attribute COLSPAN = new AttributeImpl("COLSPAN");
  public static final Attribute CONTENT;
  public static final Attribute HREF;
  public static final Attribute HTTP_EQUIV;
  public static final Attribute ID = new AttributeImpl("ID");
  public static final Attribute NAME = new AttributeImpl("NAME");
  public static final Attribute REL;
  public static final Attribute SIZE;
  public static final Attribute SRC;
  public static final Attribute TITLE = new AttributeImpl("TITLE");
  public static final Attribute TYPE = new AttributeImpl("TYPE");
  public static final Attribute WIDTH;
  
  static
  {
    CLASS = new AttributeImpl("CLASS");
    HTTP_EQUIV = new AttributeImpl("HTTP-EQUIV");
    CONTENT = new AttributeImpl("CONTENT");
    HREF = new AttributeImpl("HREF");
    SRC = new AttributeImpl("SRC");
    REL = new AttributeImpl("REL");
    WIDTH = new AttributeImpl("WIDTH");
    SIZE = new AttributeImpl("SIZE");
    BORDER = new AttributeImpl("BORDER");
    CELLPADDING = new AttributeImpl("CELLPADDING");
    CELLSPACING = new AttributeImpl("CELLSPACING");
  }
  
  public abstract boolean equals(Object paramObject);
  
  public abstract String getName();
  
  public abstract int hashCode();
  
  private static final class AttributeImpl
    extends Attribute
  {
    private final String m_name;
    
    AttributeImpl(String paramString)
    {
      this.m_name = paramString;
    }
    
    public void emit(HTMLWriter paramHTMLWriter)
    {
      paramHTMLWriter.write(this.m_name);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof AttributeImpl)) {
        return false;
      }
      return this.m_name.equals(((AttributeImpl)paramObject).m_name);
    }
    
    public String getName()
    {
      return this.m_name;
    }
    
    public int hashCode()
    {
      return this.m_name.hashCode();
    }
    
    public String toString()
    {
      return this.m_name;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */