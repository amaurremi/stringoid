package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface ContainerHolder
  extends Releasable, Result
{
  public abstract Container getContainer();
  
  public abstract void refresh();
  
  public abstract void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ContainerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */