package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.drive.DriveApi.DriveIdResult;

class bb
  extends c
{
  private final a.d<DriveApi.DriveIdResult> a;
  
  public bb(a.d<DriveApi.DriveIdResult> paramd)
  {
    this.a = paramd;
  }
  
  public void a(OnDriveIdResponse paramOnDriveIdResponse)
  {
    this.a.a(new bc(Status.En, paramOnDriveIdResponse.getDriveId()));
  }
  
  public void a(OnMetadataResponse paramOnMetadataResponse)
  {
    this.a.a(new bc(Status.En, new l(paramOnMetadataResponse.gB()).getDriveId()));
  }
  
  public void o(Status paramStatus)
  {
    this.a.a(new bc(paramStatus, null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */