package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.List;

public abstract interface d
  extends IInterface
{
  public abstract boolean b(d paramd);
  
  public abstract int getActiveLevelIndex();
  
  public abstract int getDefaultLevelIndex();
  
  public abstract List<IBinder> getLevels();
  
  public abstract int hashCodeRemote();
  
  public abstract boolean isUnderground();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */