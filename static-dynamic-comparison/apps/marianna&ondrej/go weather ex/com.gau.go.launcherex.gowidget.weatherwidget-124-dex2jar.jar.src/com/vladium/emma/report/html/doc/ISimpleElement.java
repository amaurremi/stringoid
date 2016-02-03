package com.vladium.emma.report.html.doc;

public abstract interface ISimpleElement
  extends IContent
{
  public abstract AttributeSet getAttributes();
  
  public abstract Tag getTag();
  
  public abstract ISimpleElement setClass(String paramString);
  
  public static abstract class Factory
  {
    public static ISimpleElement create(Tag paramTag)
    {
      return new SimpleElementImpl(paramTag, AttributeSet.create());
    }
    
    public static ISimpleElement create(Tag paramTag, AttributeSet paramAttributeSet)
    {
      return new SimpleElementImpl(paramTag, paramAttributeSet);
    }
    
    static class SimpleElementImpl
      implements ISimpleElement
    {
      protected final AttributeSet m_attrs;
      protected final Tag m_tag;
      
      SimpleElementImpl(Tag paramTag, AttributeSet paramAttributeSet)
      {
        this.m_tag = paramTag;
        this.m_attrs = paramAttributeSet;
      }
      
      public void emit(HTMLWriter paramHTMLWriter)
      {
        paramHTMLWriter.write('<');
        paramHTMLWriter.write(this.m_tag.getName());
        if (!this.m_attrs.isEmpty())
        {
          paramHTMLWriter.write(' ');
          this.m_attrs.emit(paramHTMLWriter);
        }
        paramHTMLWriter.write("/>");
      }
      
      public AttributeSet getAttributes()
      {
        return this.m_attrs;
      }
      
      public Tag getTag()
      {
        return this.m_tag;
      }
      
      public ISimpleElement setClass(String paramString)
      {
        if ((paramString != null) && (paramString.length() > 0)) {
          getAttributes().set(Attribute.CLASS, paramString);
        }
        return this;
      }
      
      public String toString()
      {
        return "<" + this.m_tag.getName() + "/>";
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/ISimpleElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */