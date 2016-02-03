package com.mobisystems.mobiscanner.common.util;

public class d
{
  int axm;
  String axn;
  
  public d(int paramInt, String paramString)
  {
    this.axm = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.axn = c.gb(paramInt);
      return;
    }
    this.axn = (paramString + " (response: " + c.gb(paramInt) + ")");
  }
  
  public String getMessage()
  {
    return this.axn;
  }
  
  public boolean isFailure()
  {
    return !mu();
  }
  
  public boolean mu()
  {
    return this.axm == 0;
  }
  
  public String toString()
  {
    return "IabResult: " + getMessage();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */