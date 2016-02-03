package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;

class br
  extends c
{
  private final a.d<DriveFolder.DriveFileResult> a;
  
  public br(a.d<DriveFolder.DriveFileResult> paramd)
  {
    this.a = paramd;
  }
  
  public void a(OnDriveIdResponse paramOnDriveIdResponse)
  {
    this.a.a(new bu(Status.En, new s(paramOnDriveIdResponse.getDriveId())));
  }
  
  public void o(Status paramStatus)
  {
    this.a.a(new bu(paramStatus, null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */