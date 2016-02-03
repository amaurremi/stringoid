package com.amazon.inapp.purchasing;

final class PurchaseUpdatesRequest
  extends Request
{
  private final Offset _offset;
  
  PurchaseUpdatesRequest(Offset paramOffset)
  {
    Validator.validateNotNull(paramOffset, "offset");
    this._offset = paramOffset;
  }
  
  Runnable getRunnable()
  {
    new Runnable()
    {
      public void run()
      {
        ImplementationFactory.getRequestHandler().sendPurchaseUpdatesRequest(PurchaseUpdatesRequest.this._offset, PurchaseUpdatesRequest.this.getRequestId());
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/PurchaseUpdatesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */