package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class h
  extends d
  implements DataEvent
{
  private final int RG;
  
  public h(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.RG = paramInt2;
  }
  
  public DataItem getDataItem()
  {
    return new o(this.DG, this.EC, this.RG);
  }
  
  public int getType()
  {
    return getInteger("event_type");
  }
  
  public DataEvent np()
  {
    return new g(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */