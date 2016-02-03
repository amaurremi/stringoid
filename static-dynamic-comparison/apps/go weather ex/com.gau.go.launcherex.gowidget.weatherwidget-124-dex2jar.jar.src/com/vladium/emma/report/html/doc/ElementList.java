package com.vladium.emma.report.html.doc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ElementList
  implements IElementList
{
  private final List m_contents = new ArrayList();
  
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
    Iterator localIterator = this.m_contents.iterator();
    while (localIterator.hasNext()) {
      ((IContent)localIterator.next()).emit(paramHTMLWriter);
    }
  }
  
  public int size()
  {
    return this.m_contents.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/ElementList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */