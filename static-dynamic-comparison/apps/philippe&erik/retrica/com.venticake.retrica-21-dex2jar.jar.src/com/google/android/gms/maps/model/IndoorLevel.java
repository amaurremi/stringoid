package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.model.internal.e;

public final class IndoorLevel
{
  private final e aaJ;
  
  public IndoorLevel(e parame)
  {
    this.aaJ = ((e)hm.f(parame));
  }
  
  public void activate()
  {
    try
    {
      this.aaJ.activate();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IndoorLevel)) {
      return false;
    }
    try
    {
      boolean bool = this.aaJ.a(((IndoorLevel)paramObject).aaJ);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      throw new RuntimeRemoteException((RemoteException)paramObject);
    }
  }
  
  public String getName()
  {
    try
    {
      String str = this.aaJ.getName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public String getShortName()
  {
    try
    {
      String str = this.aaJ.getShortName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.aaJ.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/IndoorLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */