package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;

public abstract interface Person$Cover
  extends Freezable<Cover>
{
  public abstract Person.Cover.CoverInfo getCoverInfo();
  
  public abstract Person.Cover.CoverPhoto getCoverPhoto();
  
  public abstract int getLayout();
  
  public abstract boolean hasCoverInfo();
  
  public abstract boolean hasCoverPhoto();
  
  public abstract boolean hasLayout();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/people/Person$Cover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */