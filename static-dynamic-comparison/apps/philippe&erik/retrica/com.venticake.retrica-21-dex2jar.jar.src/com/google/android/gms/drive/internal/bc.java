package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveId;

class bc
  implements DriveApi.DriveIdResult
{
  private final Status a;
  private final DriveId b;
  
  public bc(Status paramStatus, DriveId paramDriveId)
  {
    this.a = paramStatus;
    this.b = paramDriveId;
  }
  
  public DriveId getDriveId()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */