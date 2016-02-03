package com.amazon.inapp.purchasing;

public final class PurchaseResponse
{
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", purchaseRequestStatus: \"%s\", userId: \"%s\", receipt: %s)";
  private final PurchaseResponse.PurchaseRequestStatus _purchaseRequestStatus;
  private final Receipt _receipt;
  private final String _requestId;
  private final String _userId;
  
  PurchaseResponse(String paramString1, String paramString2, Receipt paramReceipt, PurchaseResponse.PurchaseRequestStatus paramPurchaseRequestStatus)
  {
    Validator.validateNotNull(paramString1, "requestId");
    Validator.validateNotNull(paramPurchaseRequestStatus, "purchaseRequestStatus");
    if (paramPurchaseRequestStatus == PurchaseResponse.PurchaseRequestStatus.SUCCESSFUL)
    {
      Validator.validateNotNull(paramReceipt, "receipt");
      Validator.validateNotNull(paramString2, "userId");
    }
    this._requestId = paramString1;
    this._userId = paramString2;
    this._receipt = paramReceipt;
    this._purchaseRequestStatus = paramPurchaseRequestStatus;
  }
  
  public PurchaseResponse.PurchaseRequestStatus getPurchaseRequestStatus()
  {
    return this._purchaseRequestStatus;
  }
  
  public Receipt getReceipt()
  {
    return this._receipt;
  }
  
  public String getRequestId()
  {
    return this._requestId;
  }
  
  public String getUserId()
  {
    return this._userId;
  }
  
  public String toString()
  {
    return String.format("(%s, requestId: \"%s\", purchaseRequestStatus: \"%s\", userId: \"%s\", receipt: %s)", new Object[] { super.toString(), this._requestId, this._purchaseRequestStatus, this._userId, this._receipt });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/PurchaseResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */