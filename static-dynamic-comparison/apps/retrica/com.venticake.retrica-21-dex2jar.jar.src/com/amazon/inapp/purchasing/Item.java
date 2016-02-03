package com.amazon.inapp.purchasing;

public final class Item
{
  private static final String TO_STRING_FORMAT = "(%s, sku: \"%s\", price: \"%s\", itemType: \"%s\", title: \"%s\", description: \"%s\", smallIconUrl: \"%s\")";
  private final String _description;
  private final Item.ItemType _itemType;
  private final String _price;
  private final String _sku;
  private final String _smallIconUrl;
  private final String _title;
  
  Item(String paramString1, String paramString2, Item.ItemType paramItemType, String paramString3, String paramString4, String paramString5)
  {
    Validator.validateNotNull(paramString1, "sku");
    Validator.validateNotNull(paramItemType, "itemType");
    Validator.validateNotNull(paramString3, "title");
    Validator.validateNotNull(paramString4, "description");
    Validator.validateNotNull(paramString5, "smallIconUrl");
    if (Item.ItemType.SUBSCRIPTION != paramItemType) {
      Validator.validateNotNull(paramString2, "price");
    }
    this._sku = paramString1;
    this._itemType = paramItemType;
    this._price = paramString2;
    this._title = paramString3;
    this._description = paramString4;
    this._smallIconUrl = paramString5;
  }
  
  public String getDescription()
  {
    return this._description;
  }
  
  public Item.ItemType getItemType()
  {
    return this._itemType;
  }
  
  public String getPrice()
  {
    return this._price;
  }
  
  public String getSku()
  {
    return this._sku;
  }
  
  public String getSmallIconUrl()
  {
    return this._smallIconUrl;
  }
  
  public String getTitle()
  {
    return this._title;
  }
  
  public String toString()
  {
    return String.format("(%s, sku: \"%s\", price: \"%s\", itemType: \"%s\", title: \"%s\", description: \"%s\", smallIconUrl: \"%s\")", new Object[] { super.toString(), this._sku, this._price, this._itemType, this._title, this._description, this._smallIconUrl });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */