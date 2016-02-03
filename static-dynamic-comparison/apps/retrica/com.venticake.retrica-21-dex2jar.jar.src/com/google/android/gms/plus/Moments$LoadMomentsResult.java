package com.google.android.gms.plus;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public abstract interface Moments$LoadMomentsResult
  extends Releasable, Result
{
  public abstract MomentBuffer getMomentBuffer();
  
  public abstract String getNextPageToken();
  
  public abstract String getUpdated();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/Moments$LoadMomentsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */