package com.vladium.emma.report;

public final class AllItem
  extends Item
{
  private static final Item.ItemMetadata METADATA = new Item.ItemMetadata(0, "all", 31L);
  
  public AllItem()
  {
    super(null);
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
    return "all classes";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/AllItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */