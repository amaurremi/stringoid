package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;

abstract class bt
  extends bm<DriveFolder.DriveFolderResult>
{
  private bt(u paramu) {}
  
  public DriveFolder.DriveFolderResult a(Status paramStatus)
  {
    return new bv(paramStatus, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */