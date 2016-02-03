package com.amazon.inapp.purchasing;

final class ContentDownloadResponse
{
  private final ContentDownloadResponse.ContentDownloadRequestStatus _contentDownloadRequestStatus;
  private final int _percentComplete;
  private final String _requestId;
  
  ContentDownloadResponse(String paramString, int paramInt, ContentDownloadResponse.ContentDownloadRequestStatus paramContentDownloadRequestStatus)
  {
    Validator.validateNotNull(paramString, "requestId");
    Validator.validateNotNull(paramContentDownloadRequestStatus, "contentDownloadRequestStatus");
    this._requestId = paramString;
    this._percentComplete = paramInt;
    this._contentDownloadRequestStatus = paramContentDownloadRequestStatus;
  }
  
  public ContentDownloadResponse.ContentDownloadRequestStatus getContentDownloadRequestStatus()
  {
    return this._contentDownloadRequestStatus;
  }
  
  public int getPercentComplete()
  {
    return this._percentComplete;
  }
  
  public String getRequestId()
  {
    return this._requestId;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/ContentDownloadResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */