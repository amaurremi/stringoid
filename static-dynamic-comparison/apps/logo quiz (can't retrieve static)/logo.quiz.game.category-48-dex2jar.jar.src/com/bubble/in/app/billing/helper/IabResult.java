package com.bubble.in.app.billing.helper;

public class IabResult
{
  String mMessage;
  int mResponse;
  
  public IabResult(int paramInt, String paramString)
  {
    this.mResponse = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.mMessage = IabHelper.getResponseDesc(paramInt);
      return;
    }
    this.mMessage = (paramString + " (response: " + IabHelper.getResponseDesc(paramInt) + ")");
  }
  
  public String getMessage()
  {
    return this.mMessage;
  }
  
  public int getResponse()
  {
    return this.mResponse;
  }
  
  public boolean isFailure()
  {
    return !isSuccess();
  }
  
  public boolean isSuccess()
  {
    return this.mResponse == 0;
  }
  
  public String toString()
  {
    return "IabResult: " + getMessage();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/in/app/billing/helper/IabResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */