package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveIdResult;

abstract class bd
  extends bm<DriveApi.DriveIdResult>
{
  bd(p paramp) {}
  
  public DriveApi.DriveIdResult a(Status paramStatus)
  {
    return new bc(paramStatus, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */