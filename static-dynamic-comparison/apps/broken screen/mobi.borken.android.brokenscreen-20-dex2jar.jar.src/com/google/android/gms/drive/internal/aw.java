package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

public class aw
  extends c
{
  private final a.d<Status> yO;
  
  public aw(a.d<Status> paramd)
  {
    this.yO = paramd;
  }
  
  public void o(Status paramStatus)
    throws RemoteException
  {
    this.yO.a(paramStatus);
  }
  
  public void onSuccess()
    throws RemoteException
  {
    this.yO.a(Status.Ek);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */