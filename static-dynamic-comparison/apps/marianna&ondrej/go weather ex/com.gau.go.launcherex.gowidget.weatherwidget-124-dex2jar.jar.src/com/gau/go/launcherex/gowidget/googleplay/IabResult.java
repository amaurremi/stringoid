package com.gau.go.launcherex.gowidget.googleplay;

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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/IabResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */