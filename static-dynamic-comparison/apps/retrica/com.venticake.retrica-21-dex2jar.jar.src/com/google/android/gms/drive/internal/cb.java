package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource.MetadataResult;

abstract class cb
  extends bm<DriveResource.MetadataResult>
{
  private cb(v paramv) {}
  
  public DriveResource.MetadataResult a(Status paramStatus)
  {
    return new ca(paramStatus, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */