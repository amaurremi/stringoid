package com.pocket.list.adapter.data;

public class ItemQuery$ReadOnlyItemQuery
  extends ItemQuery
{
  private ItemQuery$ReadOnlyItemQuery(ItemQuery paramItemQuery)
  {
    super(paramItemQuery, null);
    N();
  }
  
  private void N()
  {
    if ((p()) && (!s())) {
      throw new RuntimeException("offset requires count");
    }
  }
  
  public l a()
  {
    throw new RuntimeException("query is read only");
  }
  
  public ReadOnlyItemQuery c()
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/ItemQuery$ReadOnlyItemQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */