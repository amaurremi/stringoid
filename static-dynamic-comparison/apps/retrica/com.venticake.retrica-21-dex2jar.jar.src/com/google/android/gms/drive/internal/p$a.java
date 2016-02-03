package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.ContentsResult;

public class p$a
  implements DriveApi.ContentsResult
{
  private final Contents HG;
  private final Status yz;
  
  public p$a(Status paramStatus, Contents paramContents)
  {
    this.yz = paramStatus;
    this.HG = paramContents;
  }
  
  public Contents getContents()
  {
    return this.HG;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/p$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */