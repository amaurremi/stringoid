package com.google.android.gms.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.a;

public abstract interface e
{
  public abstract d<Status> a(c paramc, DriveEvent.a<ChangeEvent> parama);
  
  public abstract d<a> d(c paramc);
  
  public abstract DriveId mV();
  
  public static abstract interface a
    extends com.google.android.gms.common.api.f
  {
    public abstract f mW();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */