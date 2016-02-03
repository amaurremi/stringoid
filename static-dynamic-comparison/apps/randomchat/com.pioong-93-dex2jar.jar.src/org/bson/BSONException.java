package org.bson;

public class BSONException
  extends RuntimeException
{
  private static final long serialVersionUID = -4415279469780082174L;
  private Integer _errorCode = null;
  
  public BSONException(int paramInt, String paramString)
  {
    super(paramString);
    this._errorCode = Integer.valueOf(paramInt);
  }
  
  public BSONException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this._errorCode = Integer.valueOf(paramInt);
  }
  
  public BSONException(String paramString)
  {
    super(paramString);
  }
  
  public BSONException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public Integer getErrorCode()
  {
    return this._errorCode;
  }
  
  public boolean hasErrorCode()
  {
    return this._errorCode != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BSONException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */