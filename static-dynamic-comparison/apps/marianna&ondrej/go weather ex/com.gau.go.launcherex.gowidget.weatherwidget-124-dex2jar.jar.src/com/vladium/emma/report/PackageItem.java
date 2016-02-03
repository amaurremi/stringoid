package com.vladium.emma.report;

public final class PackageItem
  extends Item
{
  private static final Item.ItemMetadata METADATA = new Item.ItemMetadata(1, "package", 31L);
  private final String m_VMname;
  private final String m_name;
  
  public PackageItem(IItem paramIItem, String paramString1, String paramString2)
  {
    super(paramIItem);
    this.m_name = paramString1;
    this.m_VMname = paramString2;
  }
  
  public static IItemMetadata getTypeMetadata()
  {
    return METADATA;
  }
  
  public void accept(IItemVisitor paramIItemVisitor, Object paramObject)
  {
    paramIItemVisitor.visit(this, paramObject);
  }
  
  public final IItemMetadata getMetadata()
  {
    return METADATA;
  }
  
  public String getName()
  {
    return this.m_name;
  }
  
  public String getVMName()
  {
    return this.m_VMname;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/PackageItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */