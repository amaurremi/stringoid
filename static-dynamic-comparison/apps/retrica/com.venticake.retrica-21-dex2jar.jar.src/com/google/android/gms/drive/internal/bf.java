package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.drive.DriveApi.ContentsResult;

class bf
  extends c
{
  private final a.d<DriveApi.ContentsResult> a;
  
  public bf(a.d<DriveApi.ContentsResult> paramd)
  {
    this.a = paramd;
  }
  
  public void a(OnContentsResponse paramOnContentsResponse)
  {
    this.a.a(new p.a(Status.En, paramOnContentsResponse.gt()));
  }
  
  public void o(Status paramStatus)
  {
    this.a.a(new p.a(paramStatus, null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */