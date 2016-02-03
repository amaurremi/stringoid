package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;

class ca
  implements DriveResource.MetadataResult
{
  private final Status a;
  private final Metadata b;
  
  public ca(Status paramStatus, Metadata paramMetadata)
  {
    this.a = paramStatus;
    this.b = paramMetadata;
  }
  
  public Metadata getMetadata()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */