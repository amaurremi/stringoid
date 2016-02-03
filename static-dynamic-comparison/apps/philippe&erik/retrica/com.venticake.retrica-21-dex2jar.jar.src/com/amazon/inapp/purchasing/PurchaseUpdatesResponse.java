package com.amazon.inapp.purchasing;

import java.util.HashSet;
import java.util.Set;

public final class PurchaseUpdatesResponse
{
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", purchaseUpdatesRequestStatus: \"%s\", userId: \"%s\", receipts: %s, revokedSkus: %s, offset: \"%s\", isMore: \"%b\")";
  private final boolean _isMore;
  private final Offset _offset;
  private final PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus _purchaseUpdatesRequestStatus;
  private final Set<Receipt> _receipts;
  private final String _requestId;
  private final Set<String> _revokedSkus;
  private final String _userId;
  
  PurchaseUpdatesResponse(String paramString1, String paramString2, PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus paramPurchaseUpdatesRequestStatus, Set<Receipt> paramSet, Set<String> paramSet1, Offset paramOffset, boolean paramBoolean)
  {
    Validator.validateNotNull(paramString1, "requestId");
    Validator.validateNotNull(paramPurchaseUpdatesRequestStatus, "purchaseUpdatesRequestStatus");
    Validator.validateNotNull(paramOffset, "offset");
    if (PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus.SUCCESSFUL == paramPurchaseUpdatesRequestStatus)
    {
      Validator.validateNotNull(paramString2, "userId");
      Validator.validateNotNull(paramSet, "receipts");
      Validator.validateNotNull(paramSet1, "revokedSkus");
    }
    this._requestId = paramString1;
    this._userId = paramString2;
    this._purchaseUpdatesRequestStatus = paramPurchaseUpdatesRequestStatus;
    if (paramSet != null)
    {
      this._receipts = paramSet;
      if (paramSet1 == null) {
        break label112;
      }
    }
    for (;;)
    {
      this._revokedSkus = paramSet1;
      this._offset = paramOffset;
      this._isMore = paramBoolean;
      return;
      paramSet = new HashSet();
      break;
      label112:
      paramSet1 = new HashSet();
    }
  }
  
  public Offset getOffset()
  {
    return this._offset;
  }
  
  public PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus getPurchaseUpdatesRequestStatus()
  {
    return this._purchaseUpdatesRequestStatus;
  }
  
  public Set<Receipt> getReceipts()
  {
    return this._receipts;
  }
  
  public String getRequestId()
  {
    return this._requestId;
  }
  
  public Set<String> getRevokedSkus()
  {
    return this._revokedSkus;
  }
  
  public String getUserId()
  {
    return this._userId;
  }
  
  public boolean isMore()
  {
    return this._isMore;
  }
  
  public String toString()
  {
    return String.format("(%s, requestId: \"%s\", purchaseUpdatesRequestStatus: \"%s\", userId: \"%s\", receipts: %s, revokedSkus: %s, offset: \"%s\", isMore: \"%b\")", new Object[] { super.toString(), this._requestId, this._purchaseUpdatesRequestStatus, this._userId, this._receipts, this._revokedSkus, this._offset, Boolean.valueOf(this._isMore) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/PurchaseUpdatesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */