package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.drive.DriveResource.MetadataResult;

class bz
  extends c
{
  private final a.d<DriveResource.MetadataResult> a;
  
  public bz(a.d<DriveResource.MetadataResult> paramd)
  {
    this.a = paramd;
  }
  
  public void a(OnMetadataResponse paramOnMetadataResponse)
  {
    this.a.a(new ca(Status.En, new l(paramOnMetadataResponse.gB())));
  }
  
  public void o(Status paramStatus)
  {
    this.a.a(new ca(paramStatus, null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */