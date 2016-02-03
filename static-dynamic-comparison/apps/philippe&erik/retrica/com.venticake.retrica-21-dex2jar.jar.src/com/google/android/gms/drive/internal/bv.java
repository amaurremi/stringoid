package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;

class bv
  implements DriveFolder.DriveFolderResult
{
  private final Status a;
  private final DriveFolder b;
  
  public bv(Status paramStatus, DriveFolder paramDriveFolder)
  {
    this.a = paramStatus;
    this.b = paramDriveFolder;
  }
  
  public DriveFolder getDriveFolder()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */