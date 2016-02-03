package com.vladium.emma.report.html.doc;

public final class HTMLTable
  extends IElement.Factory.ElementImpl
{
  private IElement m_caption;
  
  public HTMLTable(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(Tag.TABLE, AttributeSet.create());
    AttributeSet localAttributeSet = getAttributes();
    if (paramString1 != null) {
      localAttributeSet.set(Attribute.WIDTH, paramString1);
    }
    if (paramString2 != null) {
      localAttributeSet.set(Attribute.BORDER, paramString2);
    }
    if (paramString3 != null) {
      localAttributeSet.set(Attribute.CELLPADDING, paramString3);
    }
    if (paramString4 != null) {
      localAttributeSet.set(Attribute.CELLSPACING, paramString4);
    }
  }
  
  public void emit(HTMLWriter paramHTMLWriter)
  {
    if (this.m_caption != null) {
      add(0, this.m_caption);
    }
    super.emit(paramHTMLWriter);
  }
  
  public IRow newRow()
  {
    Row localRow = new Row(false);
    add(localRow);
    return localRow;
  }
  
  public IRow newTitleRow()
  {
    Row localRow = new Row(true);
    add(localRow);
    return localRow;
  }
  
  public void setCaption(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.m_caption = IElement.Factory.create(Tag.CAPTION);
    this.m_caption.getAttributes().set(Attribute.ALIGN, paramString1);
    this.m_caption.setText(paramString2, paramBoolean);
  }
  
  private static class Cell
    extends IElement.Factory.ElementImpl
    implements HTMLTable.ICell
  {
    Cell(Tag paramTag)
    {
      super(AttributeSet.create());
    }
    
    public HTMLTable.ICell setColspan(int paramInt)
    {
      getAttributes().set(Attribute.COLSPAN, paramInt);
      return this;
    }
  }
  
  public static abstract interface ICell
    extends IElement
  {
    public abstract ICell setColspan(int paramInt);
  }
  
  public static abstract interface IRow
    extends IElement
  {
    public abstract HTMLTable.ICell newCell();
  }
  
  private static class Row
    extends IElement.Factory.ElementImpl
    implements HTMLTable.IRow
  {
    private final boolean m_th;
    
    Row(boolean paramBoolean)
    {
      super(AttributeSet.create());
      this.m_th = paramBoolean;
    }
    
    public HTMLTable.ICell newCell()
    {
      if (this.m_th) {}
      for (Object localObject = Tag.TH;; localObject = Tag.TD)
      {
        localObject = new HTMLTable.Cell((Tag)localObject);
        add((IContent)localObject);
        return (HTMLTable.ICell)localObject;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/HTMLTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */