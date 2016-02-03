package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;

class bu
  implements DriveFolder.DriveFileResult
{
  private final Status a;
  private final DriveFile b;
  
  public bu(Status paramStatus, DriveFile paramDriveFile)
  {
    this.a = paramStatus;
    this.b = paramDriveFile;
  }
  
  public DriveFile getDriveFile()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */