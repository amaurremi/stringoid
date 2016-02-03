package com.amazon.inapp.purchasing;

final class ContentDownloadRequest
  extends Request
{
  private final String _location;
  private final String _sku;
  
  ContentDownloadRequest(String paramString1, String paramString2)
  {
    Validator.validateNotNull(paramString1, "sku");
    Validator.validateNotNull(paramString2, "location");
    this._sku = paramString1;
    this._location = paramString2;
  }
  
  Runnable getRunnable()
  {
    new Runnable()
    {
      public void run()
      {
        ImplementationFactory.getRequestHandler().sendContentDownloadRequest(ContentDownloadRequest.this._sku, ContentDownloadRequest.this._location, ContentDownloadRequest.this.getRequestId());
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/ContentDownloadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */