package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.MetadataBuffer;

class be
  implements DriveApi.MetadataBufferResult
{
  private final Status a;
  private final MetadataBuffer b;
  private final boolean c;
  
  public be(Status paramStatus, MetadataBuffer paramMetadataBuffer, boolean paramBoolean)
  {
    this.a = paramStatus;
    this.b = paramMetadataBuffer;
    this.c = paramBoolean;
  }
  
  public MetadataBuffer getMetadataBuffer()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */