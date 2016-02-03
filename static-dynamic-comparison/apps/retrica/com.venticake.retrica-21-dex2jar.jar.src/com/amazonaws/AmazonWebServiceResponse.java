package com.amazonaws;

public class AmazonWebServiceResponse<T>
{
  private ResponseMetadata responseMetadata;
  private T result;
  
  public String getRequestId()
  {
    if (this.responseMetadata == null) {
      return null;
    }
    return this.responseMetadata.getRequestId();
  }
  
  public ResponseMetadata getResponseMetadata()
  {
    return this.responseMetadata;
  }
  
  public T getResult()
  {
    return (T)this.result;
  }
  
  public void setResponseMetadata(ResponseMetadata paramResponseMetadata)
  {
    this.responseMetadata = paramResponseMetadata;
  }
  
  public void setResult(T paramT)
  {
    this.result = paramT;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/AmazonWebServiceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */