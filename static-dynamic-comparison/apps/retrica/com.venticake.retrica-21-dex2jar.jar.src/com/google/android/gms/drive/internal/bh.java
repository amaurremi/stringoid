package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.MetadataBuffer;

class bh
  extends c
{
  private final a.d<DriveApi.MetadataBufferResult> a;
  
  public bh(a.d<DriveApi.MetadataBufferResult> paramd)
  {
    this.a = paramd;
  }
  
  public void a(OnListEntriesResponse paramOnListEntriesResponse)
  {
    MetadataBuffer localMetadataBuffer = new MetadataBuffer(paramOnListEntriesResponse.gy(), null);
    this.a.a(new be(Status.En, localMetadataBuffer, paramOnListEntriesResponse.gz()));
  }
  
  public void o(Status paramStatus)
  {
    this.a.a(new be(paramStatus, null, false));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */