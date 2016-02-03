package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;

class bs
  extends c
{
  private final a.d<DriveFolder.DriveFolderResult> a;
  
  public bs(a.d<DriveFolder.DriveFolderResult> paramd)
  {
    this.a = paramd;
  }
  
  public void a(OnDriveIdResponse paramOnDriveIdResponse)
  {
    this.a.a(new bv(Status.En, new u(paramOnDriveIdResponse.getDriveId())));
  }
  
  public void o(Status paramStatus)
  {
    this.a.a(new bv(paramStatus, null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */