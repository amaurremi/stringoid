package com.amazon.inapp.purchasing;

public final class Receipt
{
  private static final String TO_STRING_FORMAT = "(%s, sku: \"%s\", itemType: \"%s\", subscriptionPeriod: %s, purchaseToken: \"%s\")";
  private final boolean _isContentAvailable;
  private final Item.ItemType _itemType;
  private final String _purchaseToken;
  private final String _sku;
  private final SubscriptionPeriod _subscriptionPeriod;
  
  Receipt(String paramString1, Item.ItemType paramItemType, boolean paramBoolean, SubscriptionPeriod paramSubscriptionPeriod, String paramString2)
  {
    Validator.validateNotNull(paramString1, "sku");
    Validator.validateNotNull(paramItemType, "itemType");
    Validator.validateNotNull(paramString2, "purchaseToken");
    if (Item.ItemType.SUBSCRIPTION == paramItemType) {
      Validator.validateNotNull(paramSubscriptionPeriod, "subscriptionPeriod");
    }
    this._sku = paramString1;
    this._itemType = paramItemType;
    this._purchaseToken = paramString2;
    this._isContentAvailable = paramBoolean;
    this._subscriptionPeriod = paramSubscriptionPeriod;
  }
  
  public Item.ItemType getItemType()
  {
    return this._itemType;
  }
  
  public String getPurchaseToken()
  {
    return this._purchaseToken;
  }
  
  public String getSku()
  {
    return this._sku;
  }
  
  public SubscriptionPeriod getSubscriptionPeriod()
  {
    return this._subscriptionPeriod;
  }
  
  boolean isContentAvailable()
  {
    return this._isContentAvailable;
  }
  
  public String toString()
  {
    return String.format("(%s, sku: \"%s\", itemType: \"%s\", subscriptionPeriod: %s, purchaseToken: \"%s\")", new Object[] { super.toString(), this._sku, this._itemType, this._subscriptionPeriod, this._purchaseToken });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/Receipt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */