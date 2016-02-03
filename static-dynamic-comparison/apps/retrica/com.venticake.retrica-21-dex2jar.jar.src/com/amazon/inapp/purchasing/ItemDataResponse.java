package com.amazon.inapp.purchasing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ItemDataResponse
{
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", itemDataRequestStatus: \"%s\", unavailableSkus: %s, itemData: %s)";
  private final Map<String, Item> _itemData;
  private final ItemDataResponse.ItemDataRequestStatus _itemDataRequestStatus;
  private final String _requestId;
  private final Set<String> _unavailableSkus;
  
  ItemDataResponse(String paramString, Set<String> paramSet, ItemDataResponse.ItemDataRequestStatus paramItemDataRequestStatus, Map<String, Item> paramMap)
  {
    Validator.validateNotNull(paramString, "requestId");
    Validator.validateNotNull(paramItemDataRequestStatus, "itemDataRequestStatus");
    if (ItemDataResponse.ItemDataRequestStatus.SUCCESSFUL_WITH_UNAVAILABLE_SKUS == paramItemDataRequestStatus)
    {
      Validator.validateNotNull(paramSet, "unavailableSkus");
      Validator.validateNotEmpty(paramSet, "unavailableSkus");
    }
    if (ItemDataResponse.ItemDataRequestStatus.SUCCESSFUL == paramItemDataRequestStatus)
    {
      Validator.validateNotNull(paramMap, "itemData");
      Validator.validateNotEmpty(paramMap.entrySet(), "itemData");
    }
    this._requestId = paramString;
    this._itemDataRequestStatus = paramItemDataRequestStatus;
    if (paramSet != null)
    {
      this._unavailableSkus = paramSet;
      if (paramMap == null) {
        break label103;
      }
    }
    for (;;)
    {
      this._itemData = paramMap;
      return;
      paramSet = new HashSet();
      break;
      label103:
      paramMap = new HashMap();
    }
  }
  
  public Map<String, Item> getItemData()
  {
    return this._itemData;
  }
  
  public ItemDataResponse.ItemDataRequestStatus getItemDataRequestStatus()
  {
    return this._itemDataRequestStatus;
  }
  
  public String getRequestId()
  {
    return this._requestId;
  }
  
  public Set<String> getUnavailableSkus()
  {
    return this._unavailableSkus;
  }
  
  public String toString()
  {
    return String.format("(%s, requestId: \"%s\", itemDataRequestStatus: \"%s\", unavailableSkus: %s, itemData: %s)", new Object[] { super.toString(), this._requestId, this._itemDataRequestStatus, this._unavailableSkus, this._itemData });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/ItemDataResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */