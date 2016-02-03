package com.vladium.emma.report.html.doc;

import com.vladium.util.IConstants;

public final class HTMLDocument
  extends IElement.Factory.ElementImpl
{
  private final IElement m_body;
  private IContent m_footer;
  private final IElement m_head;
  private IContent m_header;
  private final String m_title;
  
  public HTMLDocument()
  {
    this(null, null);
  }
  
  public HTMLDocument(String paramString1, String paramString2)
  {
    super(Tag.HTML, AttributeSet.create());
    Object localObject = IElement.Factory.create(Tag.HEAD);
    this.m_head = ((IElement)localObject);
    super.add((IContent)localObject);
    localObject = IElement.Factory.create(Tag.BODY);
    this.m_body = ((IElement)localObject);
    super.add((IContent)localObject);
    if ((paramString2 != null) && (paramString2.length() != 0))
    {
      localObject = ISimpleElement.Factory.create(Tag.META);
      ((ISimpleElement)localObject).getAttributes().set(Attribute.HTTP_EQUIV, "Content-Type").set(Attribute.CONTENT, "text/html; charset=" + paramString2);
      this.m_head.add((IContent)localObject);
    }
    if (paramString1 != null)
    {
      paramString2 = IElement.Factory.create(Tag.TITLE).setText(paramString1, false);
      this.m_head.add(paramString2);
    }
    this.m_title = paramString1;
  }
  
  public IElementList add(IContent paramIContent)
  {
    this.m_body.add(paramIContent);
    return this;
  }
  
  public void addEmptyP()
  {
    add(IElement.Factory.create(Tag.P));
  }
  
  public void addH(int paramInt, IContent paramIContent, String paramString)
  {
    IElement localIElement = IElement.Factory.create(Tag.Hs[paramInt]);
    localIElement.add(paramIContent);
    localIElement.setClass(paramString);
    add(localIElement);
  }
  
  public void addH(int paramInt, String paramString1, String paramString2)
  {
    IElement localIElement = IElement.Factory.create(Tag.Hs[paramInt]);
    localIElement.setText(paramString1, true);
    localIElement.setClass(paramString2);
    add(localIElement);
  }
  
  public void addHR(int paramInt)
  {
    IElement localIElement = IElement.Factory.create(Tag.HR);
    localIElement.getAttributes().set(Attribute.SIZE, paramInt);
    add(localIElement);
  }
  
  public void addLINK(String paramString1, String paramString2)
  {
    ISimpleElement localISimpleElement = ISimpleElement.Factory.create(Tag.LINK);
    localISimpleElement.getAttributes().set(Attribute.TYPE, paramString1);
    localISimpleElement.getAttributes().set(Attribute.HREF, paramString2);
    localISimpleElement.getAttributes().set(Attribute.SRC, paramString2);
    this.m_head.add(localISimpleElement);
  }
  
  public void addStyle(String paramString)
  {
    if (paramString != null)
    {
      IElement localIElement = IElement.Factory.create(Tag.STYLE);
      localIElement.getAttributes().set(Attribute.TYPE, "text/css");
      StringBuffer localStringBuffer = new StringBuffer("<!--");
      localStringBuffer.append(IConstants.EOL);
      localIElement.setText(paramString, false);
      localStringBuffer.append(IConstants.EOL);
      localStringBuffer.append("-->");
      this.m_head.add(localIElement);
    }
  }
  
  public void emit(HTMLWriter paramHTMLWriter)
  {
    if (this.m_header != null) {
      this.m_body.add(0, this.m_header);
    }
    if (this.m_footer != null) {
      this.m_body.add(this.m_body.size(), this.m_footer);
    }
    super.emit(paramHTMLWriter);
  }
  
  public IElement getBody()
  {
    return this.m_body;
  }
  
  public IContent getFooter()
  {
    return this.m_footer;
  }
  
  public IElement getHead()
  {
    return this.m_head;
  }
  
  public IContent getHeader()
  {
    return this.m_header;
  }
  
  public String getTitle()
  {
    return this.m_title;
  }
  
  public void setFooter(IContent paramIContent)
  {
    if (paramIContent != null) {
      this.m_footer = paramIContent;
    }
  }
  
  public void setHeader(IContent paramIContent)
  {
    if (paramIContent != null) {
      this.m_header = paramIContent;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/HTMLDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */