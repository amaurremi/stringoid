package com.google.android.gms.wearable;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.io.InputStream;

public abstract interface DataApi$GetFdForAssetResult
  extends Releasable, Result
{
  public abstract ParcelFileDescriptor getFd();
  
  public abstract InputStream getInputStream();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/DataApi$GetFdForAssetResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */