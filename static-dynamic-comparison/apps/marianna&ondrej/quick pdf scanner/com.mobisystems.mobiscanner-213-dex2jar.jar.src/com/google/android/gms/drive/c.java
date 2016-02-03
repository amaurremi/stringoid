package com.google.android.gms.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;

public abstract interface c
  extends e
{
  public abstract d<b.a> a(com.google.android.gms.common.api.c paramc, int paramInt, a parama);
  
  public abstract d<Status> a(com.google.android.gms.common.api.c paramc, Contents paramContents);
  
  public abstract d<Status> b(com.google.android.gms.common.api.c paramc, Contents paramContents);
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */