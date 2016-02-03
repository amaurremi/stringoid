package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.ContentsResult;

abstract class bq
  extends bm<DriveApi.ContentsResult>
{
  private bq(s params) {}
  
  public DriveApi.ContentsResult a(Status paramStatus)
  {
    return new p.a(paramStatus, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */