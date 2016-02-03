package com.vladium.emma.report.html.doc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract interface IElement
  extends ISimpleElement, IElementList
{
  public abstract IElement setText(String paramString, boolean paramBoolean);
  
  public static abstract class Factory
  {
    public static IElement create(Tag paramTag)
    {
      return new ElementImpl(paramTag, AttributeSet.create());
    }
    
    public static IElement create(Tag paramTag, AttributeSet paramAttributeSet)
    {
      return new ElementImpl(paramTag, paramAttributeSet);
    }
    
    static class ElementImpl
      extends ISimpleElement.Factory.SimpleElementImpl
      implements IElement
    {
      private static final boolean DEBUG_HTML = false;
      protected final List m_contents = new ArrayList();
      
      ElementImpl(Tag paramTag, AttributeSet paramAttributeSet)
      {
        super(paramAttributeSet);
      }
      
      public IElementList add(int paramInt, IContent paramIContent)
      {
        if (paramIContent != null) {
          this.m_contents.add(paramInt, paramIContent);
        }
        return this;
      }
      
      public IElementList add(IContent paramIContent)
      {
        if (paramIContent != null) {
          this.m_contents.add(paramIContent);
        }
        return this;
      }
      
      public void emit(HTMLWriter paramHTMLWriter)
      {
        String str = this.m_tag.getName();
        paramHTMLWriter.write('<');
        paramHTMLWriter.write(str);
        if (!this.m_attrs.isEmpty())
        {
          paramHTMLWriter.write(' ');
          this.m_attrs.emit(paramHTMLWriter);
        }
        paramHTMLWriter.write('>');
        Iterator localIterator = this.m_contents.iterator();
        while (localIterator.hasNext()) {
          ((IContent)localIterator.next()).emit(paramHTMLWriter);
        }
        paramHTMLWriter.write("</");
        paramHTMLWriter.write(str);
        paramHTMLWriter.write('>');
      }
      
      public IElement setText(String paramString, boolean paramBoolean)
      {
        if (paramString != null)
        {
          this.m_contents.clear();
          this.m_contents.add(new Text(paramString, paramBoolean));
        }
        return this;
      }
      
      public int size()
      {
        return this.m_contents.size();
      }
      
      public String toString()
      {
        return "<" + this.m_tag.getName() + ">";
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/IElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */