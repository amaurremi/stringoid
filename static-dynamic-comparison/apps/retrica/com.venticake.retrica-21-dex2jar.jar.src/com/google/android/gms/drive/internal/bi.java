package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;

abstract class bi
  extends bm<DriveApi.MetadataBufferResult>
{
  bi(p paramp) {}
  
  public DriveApi.MetadataBufferResult a(Status paramStatus)
  {
    return new be(paramStatus, null, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */