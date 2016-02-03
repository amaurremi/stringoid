package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;

public abstract interface DataEvent
  extends Freezable<DataEvent>
{
  public static final int TYPE_CHANGED = 1;
  public static final int TYPE_DELETED = 2;
  
  public abstract DataItem getDataItem();
  
  public abstract int getType();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/DataEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */