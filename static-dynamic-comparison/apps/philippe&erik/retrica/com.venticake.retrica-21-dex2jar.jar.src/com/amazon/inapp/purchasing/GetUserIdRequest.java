package com.amazon.inapp.purchasing;

final class GetUserIdRequest
  extends Request
{
  Runnable getRunnable()
  {
    new Runnable()
    {
      public void run()
      {
        ImplementationFactory.getRequestHandler().sendGetUserIdRequest(GetUserIdRequest.this.getRequestId());
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/GetUserIdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */