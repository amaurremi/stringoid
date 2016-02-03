package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class g
  implements DataEvent
{
  private int AT;
  private DataItem alH;
  
  public g(DataEvent paramDataEvent)
  {
    this.AT = paramDataEvent.getType();
    this.alH = ((DataItem)paramDataEvent.getDataItem().freeze());
  }
  
  public DataItem getDataItem()
  {
    return this.alH;
  }
  
  public int getType()
  {
    return this.AT;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataEvent np()
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */