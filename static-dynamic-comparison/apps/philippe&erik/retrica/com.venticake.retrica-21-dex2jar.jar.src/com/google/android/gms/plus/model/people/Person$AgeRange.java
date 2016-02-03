package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;

public abstract interface Person$AgeRange
  extends Freezable<AgeRange>
{
  public abstract int getMax();
  
  public abstract int getMin();
  
  public abstract boolean hasMax();
  
  public abstract boolean hasMin();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/people/Person$AgeRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */