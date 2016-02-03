package com.amazon.inapp.purchasing;

public final class GetUserIdResponse
{
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", getUserIdRequestStatus: \"%s\", userId: \"%s\")";
  private final GetUserIdResponse.GetUserIdRequestStatus _getUserIdRequestStatus;
  private final String _requestId;
  private final String _userId;
  
  GetUserIdResponse(String paramString1, GetUserIdResponse.GetUserIdRequestStatus paramGetUserIdRequestStatus, String paramString2)
  {
    Validator.validateNotNull(paramString1, "requestId");
    Validator.validateNotNull(paramGetUserIdRequestStatus, "getUserIdRequestStatus");
    if (GetUserIdResponse.GetUserIdRequestStatus.SUCCESSFUL == paramGetUserIdRequestStatus) {
      Validator.validateNotNull(paramString2, "userId");
    }
    this._requestId = paramString1;
    this._userId = paramString2;
    this._getUserIdRequestStatus = paramGetUserIdRequestStatus;
  }
  
  public String getRequestId()
  {
    return this._requestId;
  }
  
  public String getUserId()
  {
    return this._userId;
  }
  
  public GetUserIdResponse.GetUserIdRequestStatus getUserIdRequestStatus()
  {
    return this._getUserIdRequestStatus;
  }
  
  public String toString()
  {
    return String.format("(%s, requestId: \"%s\", getUserIdRequestStatus: \"%s\", userId: \"%s\")", new Object[] { super.toString(), this._requestId, this._getUserIdRequestStatus, this._userId });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/GetUserIdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */