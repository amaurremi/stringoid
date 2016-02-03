package com.amazon.inapp.purchasing;

class PurchaseRequest
  extends Request
{
  private final String _sku;
  
  PurchaseRequest(String paramString)
  {
    Validator.validateNotNull(paramString, "sku");
    this._sku = paramString;
  }
  
  Runnable getRunnable()
  {
    new Runnable()
    {
      public void run()
      {
        ImplementationFactory.getRequestHandler().sendPurchaseRequest(PurchaseRequest.this._sku, PurchaseRequest.this.getRequestId());
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/PurchaseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */