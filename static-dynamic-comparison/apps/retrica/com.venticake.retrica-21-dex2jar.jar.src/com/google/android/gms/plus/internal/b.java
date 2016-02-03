package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.ks;

public abstract interface b
  extends IInterface
{
  public abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void a(int paramInt, Bundle paramBundle, ie paramie);
  
  public abstract void a(int paramInt, ks paramks);
  
  public abstract void a(DataHolder paramDataHolder, String paramString);
  
  public abstract void a(DataHolder paramDataHolder, String paramString1, String paramString2);
  
  public abstract void am(Status paramStatus);
  
  public abstract void bw(String paramString);
  
  public abstract void bx(String paramString);
  
  public abstract void h(int paramInt, Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */