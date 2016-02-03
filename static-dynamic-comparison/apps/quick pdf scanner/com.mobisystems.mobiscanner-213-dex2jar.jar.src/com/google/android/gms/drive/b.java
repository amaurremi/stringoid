package com.google.android.gms.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;

public abstract interface b
{
  public abstract com.google.android.gms.common.api.d<a> a(com.google.android.gms.common.api.c paramc);
  
  public abstract com.google.android.gms.common.api.d<Status> a(com.google.android.gms.common.api.c paramc, Contents paramContents);
  
  public abstract c a(com.google.android.gms.common.api.c paramc, DriveId paramDriveId);
  
  public abstract d b(com.google.android.gms.common.api.c paramc);
  
  public abstract d b(com.google.android.gms.common.api.c paramc, DriveId paramDriveId);
  
  public abstract com.google.android.gms.common.api.d<Status> c(com.google.android.gms.common.api.c paramc);
  
  public static abstract interface a
    extends f
  {
    public abstract Contents mQ();
  }
  
  public static abstract interface b
    extends f
  {
    public abstract g mR();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */