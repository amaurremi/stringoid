package com.inmobi.androidsdk.impl;

public final class IMAdException
  extends Exception
{
  public static final int INVALID_APP_ID = 800;
  public static final int INVALID_REQUEST = 300;
  public static final int NO_FILL = 100;
  public static final int PARSE_ERROR = 200;
  public static final int SANDBOX_BADIP = 500;
  public static final int SANDBOX_OOF = 400;
  public static final int SANDBOX_UA = 700;
  public static final int SANDBOX_UAND = 600;
  private static final long serialVersionUID = -3924043691624251411L;
  private int a = 300;
  
  public IMAdException(String paramString, int paramInt)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public IMAdException(String paramString, Exception paramException, int paramInt)
  {
    super(paramString, paramException);
    this.a = paramInt;
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public void setCode(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/IMAdException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */