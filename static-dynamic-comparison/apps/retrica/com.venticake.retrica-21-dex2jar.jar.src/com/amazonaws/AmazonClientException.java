package com.amazonaws;

public class AmazonClientException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public AmazonClientException(String paramString)
  {
    super(paramString);
  }
  
  public AmazonClientException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public boolean isRetryable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/AmazonClientException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */