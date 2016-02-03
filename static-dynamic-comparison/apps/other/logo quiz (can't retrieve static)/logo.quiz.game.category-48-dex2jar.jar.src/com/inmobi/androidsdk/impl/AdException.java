package com.inmobi.androidsdk.impl;

import com.inmobi.androidsdk.IMAdRequest.ErrorCode;

public final class AdException
  extends Exception
{
  public static final int INTERNAL_ERROR = 200;
  public static final int INVALID_APP_ID = 400;
  public static final int INVALID_REQUEST = 300;
  public static final int NO_FILL = 100;
  private static final long serialVersionUID = -3924043691624251411L;
  private int a = 300;
  private String b = null;
  private int c = 599;
  
  public AdException(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramString1);
    this.a = paramInt1;
    this.b = paramString2;
    this.c = paramInt2;
  }
  
  public AdException(String paramString1, Exception paramException, int paramInt, String paramString2)
  {
    super(paramString1, paramException);
    this.a = paramInt;
    this.b = paramString2;
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public IMAdRequest.ErrorCode getErrorCode()
  {
    switch (this.a)
    {
    default: 
      return IMAdRequest.ErrorCode.INTERNAL_ERROR;
    case 200: 
      return IMAdRequest.ErrorCode.INTERNAL_ERROR;
    case 400: 
      return IMAdRequest.ErrorCode.INVALID_APP_ID;
    case 300: 
      return IMAdRequest.ErrorCode.INVALID_REQUEST;
    }
    return IMAdRequest.ErrorCode.NO_FILL;
  }
  
  public int getHttpCode()
  {
    return this.c;
  }
  
  public String getImpressionId()
  {
    return this.b;
  }
  
  public void setCode(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/AdException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */