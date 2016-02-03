package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonServiceException;

public class ExpiredTokenException
  extends AmazonServiceException
{
  private static final long serialVersionUID = 1L;
  
  public ExpiredTokenException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/securitytoken/model/ExpiredTokenException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */