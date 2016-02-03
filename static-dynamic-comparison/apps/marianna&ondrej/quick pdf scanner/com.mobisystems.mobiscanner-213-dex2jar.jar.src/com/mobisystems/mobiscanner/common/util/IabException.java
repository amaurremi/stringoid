package com.mobisystems.mobiscanner.common.util;

public class IabException
  extends Exception
{
  d mResult;
  
  public IabException(int paramInt, String paramString)
  {
    this(new d(paramInt, paramString));
  }
  
  public IabException(int paramInt, String paramString, Exception paramException)
  {
    this(new d(paramInt, paramString), paramException);
  }
  
  public IabException(d paramd)
  {
    this(paramd, null);
  }
  
  public IabException(d paramd, Exception paramException)
  {
    super(paramd.getMessage(), paramException);
    this.mResult = paramd;
  }
  
  public d DS()
  {
    return this.mResult;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/IabException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */