package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j.c;

public class l
  extends p
{
  private final j.c<Status> tu;
  
  public l(j.c<Status> paramc)
  {
    this.tu = paramc;
  }
  
  public void c(Status paramStatus)
  {
    this.tu.H(paramStatus);
  }
  
  public void onSuccess()
  {
    this.tu.H(Status.rc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */