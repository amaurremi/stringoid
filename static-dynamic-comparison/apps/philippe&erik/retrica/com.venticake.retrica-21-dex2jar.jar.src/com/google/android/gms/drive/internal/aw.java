package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

public class aw
  extends c
{
  private final a.d<Status> yR;
  
  public aw(a.d<Status> paramd)
  {
    this.yR = paramd;
  }
  
  public void o(Status paramStatus)
  {
    this.yR.a(paramStatus);
  }
  
  public void onSuccess()
  {
    this.yR.a(Status.En);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */