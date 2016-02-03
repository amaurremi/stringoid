package com.google.android.gms.drive.realtime.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract interface j
  extends IInterface
{
  public abstract void a(ParcelableEventList paramParcelableEventList);
  
  public abstract void o(Status paramStatus);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */