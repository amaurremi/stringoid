package com.mobisystems.mobiscanner.common;

public abstract interface a<T>
{
  public abstract T getCurrentProgress();
  
  public abstract T getMaxProgress();
  
  public abstract boolean isWorkCancelled();
  
  public abstract void setProgress(T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */