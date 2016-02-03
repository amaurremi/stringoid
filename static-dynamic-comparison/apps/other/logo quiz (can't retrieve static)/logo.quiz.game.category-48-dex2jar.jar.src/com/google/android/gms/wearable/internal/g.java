package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class g
  implements DataEvent
{
  private int FD;
  private DataItem avh;
  
  public g(DataEvent paramDataEvent)
  {
    this.FD = paramDataEvent.getType();
    this.avh = ((DataItem)paramDataEvent.getDataItem().freeze());
  }
  
  public DataItem getDataItem()
  {
    return this.avh;
  }
  
  public int getType()
  {
    return this.FD;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataEvent pU()
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */