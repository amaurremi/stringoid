package com.amazon.inapp.purchasing;

import java.util.Iterator;
import java.util.Set;

final class ItemDataRequest
  extends Request
{
  private final Set<String> _skus;
  
  ItemDataRequest(Set<String> paramSet)
  {
    Validator.validateNotNull(paramSet, "skus");
    Validator.validateNotEmpty(paramSet, "skus");
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).trim().length() == 0) {
        throw new IllegalArgumentException("Empty SKU values are not allowed");
      }
    }
    if (paramSet.size() > 100) {
      throw new IllegalArgumentException(paramSet.size() + " SKUs were provided, but no more than " + 100 + " SKUs are allowed");
    }
    this._skus = paramSet;
  }
  
  Runnable getRunnable()
  {
    new Runnable()
    {
      public void run()
      {
        ImplementationFactory.getRequestHandler().sendItemDataRequest(ItemDataRequest.this._skus, ItemDataRequest.this.getRequestId());
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/ItemDataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */