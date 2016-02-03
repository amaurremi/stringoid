package com.mobisystems.mobiscanner.common;

public enum OperationStatus
{
  private int mResId;
  private Type mType;
  
  private OperationStatus(Type paramType, int paramInt)
  {
    this.mType = paramType;
    this.mResId = paramInt;
  }
  
  public int Ds()
  {
    return this.mResId;
  }
  
  public static enum Type
  {
    private Type() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/OperationStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */