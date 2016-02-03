package com.google.android.gms.maps;

public abstract interface LocationSource
{
  public abstract void activate(LocationSource.OnLocationChangedListener paramOnLocationChangedListener);
  
  public abstract void deactivate();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/LocationSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */