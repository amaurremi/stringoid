package com.amazonaws;

public class AmazonServiceException
  extends AmazonClientException
{
  private static final long serialVersionUID = 1L;
  private String errorCode;
  private String errorMessage;
  private AmazonServiceException.ErrorType errorType = AmazonServiceException.ErrorType.Unknown;
  private String requestId;
  private String serviceName;
  private int statusCode;
  
  public AmazonServiceException(String paramString)
  {
    super(null);
    this.errorMessage = paramString;
  }
  
  public AmazonServiceException(String paramString, Exception paramException)
  {
    super(null, paramException);
    this.errorMessage = paramString;
  }
  
  public String getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public AmazonServiceException.ErrorType getErrorType()
  {
    return this.errorType;
  }
  
  public String getMessage()
  {
    return getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + ")";
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public void setErrorCode(String paramString)
  {
    this.errorCode = paramString;
  }
  
  public void setErrorType(AmazonServiceException.ErrorType paramErrorType)
  {
    this.errorType = paramErrorType;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/AmazonServiceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */