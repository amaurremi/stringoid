package com.amazonaws.internal;

import java.util.ArrayList;
import java.util.Collection;

public class ListWithAutoConstructFlag<T>
  extends ArrayList<T>
{
  private static final long serialVersionUID = 1L;
  private boolean autoConstruct;
  
  public ListWithAutoConstructFlag() {}
  
  public ListWithAutoConstructFlag(int paramInt)
  {
    super(paramInt);
  }
  
  public ListWithAutoConstructFlag(Collection<? extends T> paramCollection)
  {
    super(paramCollection);
  }
  
  public boolean isAutoConstruct()
  {
    return this.autoConstruct;
  }
  
  public void setAutoConstruct(boolean paramBoolean)
  {
    this.autoConstruct = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/ListWithAutoConstructFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */